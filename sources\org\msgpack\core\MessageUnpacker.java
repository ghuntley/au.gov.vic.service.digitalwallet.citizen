package org.msgpack.core;

import java.io.Closeable;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CoderResult;
import java.nio.charset.CodingErrorAction;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.UByte;
import kotlin.UShort;
import kotlin.jvm.internal.LongCompanionObject;
import org.msgpack.core.MessagePack;
import org.msgpack.core.buffer.MessageBuffer;
import org.msgpack.core.buffer.MessageBufferInput;
import org.msgpack.value.ImmutableValue;
import org.msgpack.value.Value;
import org.msgpack.value.ValueFactory;
import org.msgpack.value.ValueType;
import org.msgpack.value.Variable;

public class MessageUnpacker implements Closeable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final MessageBuffer EMPTY_BUFFER = MessageBuffer.wrap(new byte[0]);
    private static final String EMPTY_STRING = "";
    private final CodingErrorAction actionOnMalformedString;
    private final CodingErrorAction actionOnUnmappableString;
    private final boolean allowReadingBinaryAsString;
    private final boolean allowReadingStringAsBinary;
    private MessageBuffer buffer = EMPTY_BUFFER;
    private CharBuffer decodeBuffer;
    private StringBuilder decodeStringBuffer;
    private CharsetDecoder decoder;
    private MessageBufferInput in;
    private int nextReadPosition;
    private final MessageBuffer numberBuffer = MessageBuffer.allocate(8);
    private int position;
    private final int stringDecoderBufferSize;
    private final int stringSizeLimit;
    private long totalReadBytes;

    protected MessageUnpacker(MessageBufferInput messageBufferInput, MessagePack.UnpackerConfig unpackerConfig) {
        this.in = (MessageBufferInput) Preconditions.checkNotNull(messageBufferInput, "MessageBufferInput is null");
        this.allowReadingStringAsBinary = unpackerConfig.getAllowReadingStringAsBinary();
        this.allowReadingBinaryAsString = unpackerConfig.getAllowReadingBinaryAsString();
        this.actionOnMalformedString = unpackerConfig.getActionOnMalformedString();
        this.actionOnUnmappableString = unpackerConfig.getActionOnUnmappableString();
        this.stringSizeLimit = unpackerConfig.getStringSizeLimit();
        this.stringDecoderBufferSize = unpackerConfig.getStringDecoderBufferSize();
    }

    public MessageBufferInput reset(MessageBufferInput messageBufferInput) throws IOException {
        MessageBufferInput messageBufferInput2 = this.in;
        this.in = (MessageBufferInput) Preconditions.checkNotNull(messageBufferInput, "MessageBufferInput is null");
        this.buffer = EMPTY_BUFFER;
        this.position = 0;
        this.totalReadBytes = 0;
        return messageBufferInput2;
    }

    public long getTotalReadBytes() {
        return this.totalReadBytes + ((long) this.position);
    }

    private MessageBuffer getNextBuffer() throws IOException {
        MessageBuffer next = this.in.next();
        if (next != null) {
            this.totalReadBytes += (long) this.buffer.size();
            return next;
        }
        throw new MessageInsufficientBufferException();
    }

    private void nextBuffer() throws IOException {
        this.buffer = getNextBuffer();
        this.position = 0;
    }

    private MessageBuffer prepareNumberBuffer(int i) throws IOException {
        int i2;
        int size = this.buffer.size();
        int i3 = this.position;
        int i4 = size - i3;
        if (i4 >= i) {
            this.nextReadPosition = i3;
            this.position = i3 + i;
            return this.buffer;
        }
        if (i4 > 0) {
            this.numberBuffer.putMessageBuffer(0, this.buffer, i3, i4);
            i -= i4;
            i2 = i4 + 0;
        } else {
            i2 = 0;
        }
        while (true) {
            nextBuffer();
            int size2 = this.buffer.size();
            if (size2 >= i) {
                this.numberBuffer.putMessageBuffer(i2, this.buffer, 0, i);
                this.position = i;
                this.nextReadPosition = 0;
                return this.numberBuffer;
            }
            this.numberBuffer.putMessageBuffer(i2, this.buffer, 0, size2);
            i -= size2;
            i2 += size2;
        }
    }

    private static int utf8MultibyteCharacterSize(byte b) {
        return Integer.numberOfLeadingZeros((~(b & UByte.MAX_VALUE)) << 24);
    }

    public boolean hasNext() throws IOException {
        return ensureBuffer();
    }

    private boolean ensureBuffer() throws IOException {
        while (this.buffer.size() <= this.position) {
            MessageBuffer next = this.in.next();
            if (next == null) {
                return false;
            }
            this.totalReadBytes += (long) this.buffer.size();
            this.buffer = next;
            this.position = 0;
        }
        return true;
    }

    public MessageFormat getNextFormat() throws IOException {
        if (ensureBuffer()) {
            return MessageFormat.valueOf(this.buffer.getByte(this.position));
        }
        throw new MessageInsufficientBufferException();
    }

    private byte readByte() throws IOException {
        int size = this.buffer.size();
        int i = this.position;
        if (size > i) {
            byte b = this.buffer.getByte(i);
            this.position++;
            return b;
        }
        nextBuffer();
        if (this.buffer.size() <= 0) {
            return readByte();
        }
        byte b2 = this.buffer.getByte(0);
        this.position = 1;
        return b2;
    }

    private short readShort() throws IOException {
        return prepareNumberBuffer(2).getShort(this.nextReadPosition);
    }

    private int readInt() throws IOException {
        return prepareNumberBuffer(4).getInt(this.nextReadPosition);
    }

    private long readLong() throws IOException {
        return prepareNumberBuffer(8).getLong(this.nextReadPosition);
    }

    private float readFloat() throws IOException {
        return prepareNumberBuffer(4).getFloat(this.nextReadPosition);
    }

    private double readDouble() throws IOException {
        return prepareNumberBuffer(8).getDouble(this.nextReadPosition);
    }

    public void skipValue() throws IOException {
        skipValue(1);
    }

    public void skipValue(int i) throws IOException {
        int i2;
        int i3;
        while (i > 0) {
            byte readByte = readByte();
            switch (MessageFormat.valueOf(readByte)) {
                case FIXMAP:
                    i3 = readByte & 15;
                    i2 = i3 * 2;
                    break;
                case FIXARRAY:
                    i2 = readByte & 15;
                    break;
                case FIXSTR:
                    skipPayload(readByte & 31);
                    continue;
                    i--;
                case INT8:
                case UINT8:
                    skipPayload(1);
                    continue;
                    i--;
                case INT16:
                case UINT16:
                    skipPayload(2);
                    continue;
                    i--;
                case INT32:
                case UINT32:
                case FLOAT32:
                    skipPayload(4);
                    continue;
                    i--;
                case INT64:
                case UINT64:
                case FLOAT64:
                    skipPayload(8);
                    continue;
                    i--;
                case BIN8:
                case STR8:
                    skipPayload(readNextLength8());
                    continue;
                    i--;
                case BIN16:
                case STR16:
                    skipPayload(readNextLength16());
                    continue;
                    i--;
                case BIN32:
                case STR32:
                    skipPayload(readNextLength32());
                    continue;
                    i--;
                case FIXEXT1:
                    skipPayload(2);
                    continue;
                    i--;
                case FIXEXT2:
                    skipPayload(3);
                    continue;
                    i--;
                case FIXEXT4:
                    skipPayload(5);
                    continue;
                    i--;
                case FIXEXT8:
                    skipPayload(9);
                    continue;
                    i--;
                case FIXEXT16:
                    skipPayload(17);
                    continue;
                    i--;
                case EXT8:
                    skipPayload(readNextLength8() + 1);
                    continue;
                    i--;
                case EXT16:
                    skipPayload(readNextLength16() + 1);
                    continue;
                    i--;
                case EXT32:
                    skipPayload(readNextLength32() + 1);
                    continue;
                    i--;
                case ARRAY16:
                    i2 = readNextLength16();
                    break;
                case ARRAY32:
                    i2 = readNextLength32();
                    break;
                case MAP16:
                    i3 = readNextLength16();
                    i2 = i3 * 2;
                    break;
                case MAP32:
                    i3 = readNextLength32();
                    i2 = i3 * 2;
                    break;
                case NEVER_USED:
                    throw new MessageNeverUsedFormatException("Encountered 0xC1 \"NEVER_USED\" byte");
                default:
                    i--;
            }
            i += i2;
            i--;
        }
    }

    private static MessagePackException unexpected(String str, byte b) {
        MessageFormat valueOf = MessageFormat.valueOf(b);
        if (valueOf == MessageFormat.NEVER_USED) {
            return new MessageNeverUsedFormatException(String.format("Expected %s, but encountered 0xC1 \"NEVER_USED\" byte", str));
        }
        String name = valueOf.getValueType().name();
        return new MessageTypeException(String.format("Expected %s, but got %s (%02x)", str, name.substring(0, 1) + name.substring(1).toLowerCase(), Byte.valueOf(b)));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: org.msgpack.core.MessageUnpacker$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$msgpack$value$ValueType;

        /* JADX WARNING: Can't wrap try/catch for region: R(101:0|1|2|3|5|6|7|9|10|11|13|14|15|17|18|19|21|22|23|25|26|27|29|30|31|33|34|35|37|38|39|40|41|42|43|44|45|46|47|48|49|50|51|52|53|54|55|56|57|58|59|60|61|62|63|64|65|66|67|68|69|70|71|72|73|74|75|76|77|78|79|80|81|82|83|84|85|86|87|88|89|90|91|92|93|94|95|96|97|98|99|100|101|102|103|104|105|106|107|108|110) */
        /* JADX WARNING: Can't wrap try/catch for region: R(91:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|(2:13|14)|15|(2:17|18)|19|21|22|23|(2:25|26)|27|(2:29|30)|31|(2:33|34)|35|37|38|39|40|41|42|43|44|45|46|47|48|49|50|51|52|53|54|55|56|57|58|59|60|61|62|63|64|65|66|67|68|69|70|71|72|73|74|75|76|77|78|79|80|81|82|83|84|85|86|87|88|89|90|91|92|93|94|95|96|97|98|99|100|101|102|103|104|105|106|(3:107|108|110)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(92:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|(2:13|14)|15|17|18|19|21|22|23|(2:25|26)|27|(2:29|30)|31|(2:33|34)|35|37|38|39|40|41|42|43|44|45|46|47|48|49|50|51|52|53|54|55|56|57|58|59|60|61|62|63|64|65|66|67|68|69|70|71|72|73|74|75|76|77|78|79|80|81|82|83|84|85|86|87|88|89|90|91|92|93|94|95|96|97|98|99|100|101|102|103|104|105|106|(3:107|108|110)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(93:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|13|14|15|17|18|19|21|22|23|(2:25|26)|27|(2:29|30)|31|(2:33|34)|35|37|38|39|40|41|42|43|44|45|46|47|48|49|50|51|52|53|54|55|56|57|58|59|60|61|62|63|64|65|66|67|68|69|70|71|72|73|74|75|76|77|78|79|80|81|82|83|84|85|86|87|88|89|90|91|92|93|94|95|96|97|98|99|100|101|102|103|104|105|106|(3:107|108|110)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(94:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|13|14|15|17|18|19|21|22|23|(2:25|26)|27|(2:29|30)|31|33|34|35|37|38|39|40|41|42|43|44|45|46|47|48|49|50|51|52|53|54|55|56|57|58|59|60|61|62|63|64|65|66|67|68|69|70|71|72|73|74|75|76|77|78|79|80|81|82|83|84|85|86|87|88|89|90|91|92|93|94|95|96|97|98|99|100|101|102|103|104|105|106|(3:107|108|110)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(95:0|(2:1|2)|3|(2:5|6)|7|9|10|11|13|14|15|17|18|19|21|22|23|(2:25|26)|27|(2:29|30)|31|33|34|35|37|38|39|40|41|42|43|44|45|46|47|48|49|50|51|52|53|54|55|56|57|58|59|60|61|62|63|64|65|66|67|68|69|70|71|72|73|74|75|76|77|78|79|80|81|82|83|84|85|86|87|88|89|90|91|92|93|94|95|96|97|98|99|100|101|102|103|104|105|106|(3:107|108|110)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(96:0|(2:1|2)|3|(2:5|6)|7|9|10|11|13|14|15|17|18|19|21|22|23|(2:25|26)|27|29|30|31|33|34|35|37|38|39|40|41|42|43|44|45|46|47|48|49|50|51|52|53|54|55|56|57|58|59|60|61|62|63|64|65|66|67|68|69|70|71|72|73|74|75|76|77|78|79|80|81|82|83|84|85|86|87|88|89|90|91|92|93|94|95|96|97|98|99|100|101|102|103|104|105|106|(3:107|108|110)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(97:0|(2:1|2)|3|5|6|7|9|10|11|13|14|15|17|18|19|21|22|23|(2:25|26)|27|29|30|31|33|34|35|37|38|39|40|41|42|43|44|45|46|47|48|49|50|51|52|53|54|55|56|57|58|59|60|61|62|63|64|65|66|67|68|69|70|71|72|73|74|75|76|77|78|79|80|81|82|83|84|85|86|87|88|89|90|91|92|93|94|95|96|97|98|99|100|101|102|103|104|105|106|(3:107|108|110)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(99:0|1|2|3|5|6|7|9|10|11|13|14|15|17|18|19|21|22|23|25|26|27|29|30|31|33|34|35|37|38|39|40|41|42|43|44|45|46|47|48|49|50|51|52|53|54|55|56|57|58|59|60|61|62|63|64|65|66|67|68|69|70|71|72|73|74|75|76|77|78|79|80|81|82|83|84|85|86|87|88|89|90|91|92|93|94|95|96|97|98|99|100|101|102|103|104|105|106|(3:107|108|110)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:101:0x01e1 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:103:0x01ed */
        /* JADX WARNING: Missing exception handler attribute for start block: B:105:0x01f9 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:107:0x0205 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:39:0x007d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:41:0x0087 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:43:0x0091 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:45:0x009b */
        /* JADX WARNING: Missing exception handler attribute for start block: B:47:0x00a5 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:49:0x00af */
        /* JADX WARNING: Missing exception handler attribute for start block: B:51:0x00b9 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:53:0x00c3 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:55:0x00cd */
        /* JADX WARNING: Missing exception handler attribute for start block: B:57:0x00d9 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:59:0x00e5 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:61:0x00f1 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:63:0x00fd */
        /* JADX WARNING: Missing exception handler attribute for start block: B:65:0x0109 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:67:0x0115 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:69:0x0121 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:71:0x012d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:73:0x0139 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:75:0x0145 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:77:0x0151 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:79:0x015d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:81:0x0169 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:83:0x0175 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:85:0x0181 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:87:0x018d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:89:0x0199 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:91:0x01a5 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:93:0x01b1 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:95:0x01bd */
        /* JADX WARNING: Missing exception handler attribute for start block: B:97:0x01c9 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:99:0x01d5 */
        static {
            int[] iArr = new int[ValueType.values().length];
            $SwitchMap$org$msgpack$value$ValueType = iArr;
            try {
                iArr[ValueType.NIL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$msgpack$value$ValueType[ValueType.BOOLEAN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$msgpack$value$ValueType[ValueType.INTEGER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$org$msgpack$value$ValueType[ValueType.FLOAT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$org$msgpack$value$ValueType[ValueType.STRING.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$org$msgpack$value$ValueType[ValueType.BINARY.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$org$msgpack$value$ValueType[ValueType.ARRAY.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$org$msgpack$value$ValueType[ValueType.MAP.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$org$msgpack$value$ValueType[ValueType.EXTENSION.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            int[] iArr2 = new int[MessageFormat.values().length];
            $SwitchMap$org$msgpack$core$MessageFormat = iArr2;
            iArr2[MessageFormat.POSFIXINT.ordinal()] = 1;
            $SwitchMap$org$msgpack$core$MessageFormat[MessageFormat.NEGFIXINT.ordinal()] = 2;
            $SwitchMap$org$msgpack$core$MessageFormat[MessageFormat.BOOLEAN.ordinal()] = 3;
            $SwitchMap$org$msgpack$core$MessageFormat[MessageFormat.NIL.ordinal()] = 4;
            $SwitchMap$org$msgpack$core$MessageFormat[MessageFormat.FIXMAP.ordinal()] = 5;
            $SwitchMap$org$msgpack$core$MessageFormat[MessageFormat.FIXARRAY.ordinal()] = 6;
            $SwitchMap$org$msgpack$core$MessageFormat[MessageFormat.FIXSTR.ordinal()] = 7;
            $SwitchMap$org$msgpack$core$MessageFormat[MessageFormat.INT8.ordinal()] = 8;
            $SwitchMap$org$msgpack$core$MessageFormat[MessageFormat.UINT8.ordinal()] = 9;
            $SwitchMap$org$msgpack$core$MessageFormat[MessageFormat.INT16.ordinal()] = 10;
            $SwitchMap$org$msgpack$core$MessageFormat[MessageFormat.UINT16.ordinal()] = 11;
            $SwitchMap$org$msgpack$core$MessageFormat[MessageFormat.INT32.ordinal()] = 12;
            $SwitchMap$org$msgpack$core$MessageFormat[MessageFormat.UINT32.ordinal()] = 13;
            $SwitchMap$org$msgpack$core$MessageFormat[MessageFormat.FLOAT32.ordinal()] = 14;
            $SwitchMap$org$msgpack$core$MessageFormat[MessageFormat.INT64.ordinal()] = 15;
            $SwitchMap$org$msgpack$core$MessageFormat[MessageFormat.UINT64.ordinal()] = 16;
            $SwitchMap$org$msgpack$core$MessageFormat[MessageFormat.FLOAT64.ordinal()] = 17;
            $SwitchMap$org$msgpack$core$MessageFormat[MessageFormat.BIN8.ordinal()] = 18;
            $SwitchMap$org$msgpack$core$MessageFormat[MessageFormat.STR8.ordinal()] = 19;
            $SwitchMap$org$msgpack$core$MessageFormat[MessageFormat.BIN16.ordinal()] = 20;
            $SwitchMap$org$msgpack$core$MessageFormat[MessageFormat.STR16.ordinal()] = 21;
            $SwitchMap$org$msgpack$core$MessageFormat[MessageFormat.BIN32.ordinal()] = 22;
            $SwitchMap$org$msgpack$core$MessageFormat[MessageFormat.STR32.ordinal()] = 23;
            $SwitchMap$org$msgpack$core$MessageFormat[MessageFormat.FIXEXT1.ordinal()] = 24;
            $SwitchMap$org$msgpack$core$MessageFormat[MessageFormat.FIXEXT2.ordinal()] = 25;
            $SwitchMap$org$msgpack$core$MessageFormat[MessageFormat.FIXEXT4.ordinal()] = 26;
            $SwitchMap$org$msgpack$core$MessageFormat[MessageFormat.FIXEXT8.ordinal()] = 27;
            $SwitchMap$org$msgpack$core$MessageFormat[MessageFormat.FIXEXT16.ordinal()] = 28;
            $SwitchMap$org$msgpack$core$MessageFormat[MessageFormat.EXT8.ordinal()] = 29;
            $SwitchMap$org$msgpack$core$MessageFormat[MessageFormat.EXT16.ordinal()] = 30;
            $SwitchMap$org$msgpack$core$MessageFormat[MessageFormat.EXT32.ordinal()] = 31;
            $SwitchMap$org$msgpack$core$MessageFormat[MessageFormat.ARRAY16.ordinal()] = 32;
            $SwitchMap$org$msgpack$core$MessageFormat[MessageFormat.ARRAY32.ordinal()] = 33;
            $SwitchMap$org$msgpack$core$MessageFormat[MessageFormat.MAP16.ordinal()] = 34;
            $SwitchMap$org$msgpack$core$MessageFormat[MessageFormat.MAP32.ordinal()] = 35;
            try {
                $SwitchMap$org$msgpack$core$MessageFormat[MessageFormat.NEVER_USED.ordinal()] = 36;
            } catch (NoSuchFieldError unused10) {
            }
        }
    }

    public ImmutableValue unpackValue() throws IOException {
        MessageFormat nextFormat = getNextFormat();
        int i = 0;
        switch (AnonymousClass1.$SwitchMap$org$msgpack$value$ValueType[nextFormat.getValueType().ordinal()]) {
            case 1:
                readByte();
                return ValueFactory.newNil();
            case 2:
                return ValueFactory.newBoolean(unpackBoolean());
            case 3:
                if (AnonymousClass1.$SwitchMap$org$msgpack$core$MessageFormat[nextFormat.ordinal()] != 16) {
                    return ValueFactory.newInteger(unpackLong());
                }
                return ValueFactory.newInteger(unpackBigInteger());
            case 4:
                return ValueFactory.newFloat(unpackDouble());
            case 5:
                return ValueFactory.newString(readPayload(unpackRawStringHeader()), true);
            case 6:
                return ValueFactory.newBinary(readPayload(unpackBinaryHeader()), true);
            case 7:
                int unpackArrayHeader = unpackArrayHeader();
                Value[] valueArr = new Value[unpackArrayHeader];
                while (i < unpackArrayHeader) {
                    valueArr[i] = unpackValue();
                    i++;
                }
                return ValueFactory.newArray(valueArr, true);
            case 8:
                int unpackMapHeader = unpackMapHeader() * 2;
                Value[] valueArr2 = new Value[unpackMapHeader];
                while (i < unpackMapHeader) {
                    valueArr2[i] = unpackValue();
                    int i2 = i + 1;
                    valueArr2[i2] = unpackValue();
                    i = i2 + 1;
                }
                return ValueFactory.newMap(valueArr2, true);
            case 9:
                ExtensionTypeHeader unpackExtensionTypeHeader = unpackExtensionTypeHeader();
                return ValueFactory.newExtension(unpackExtensionTypeHeader.getType(), readPayload(unpackExtensionTypeHeader.getLength()));
            default:
                throw new MessageNeverUsedFormatException("Unknown value type");
        }
    }

    public Variable unpackValue(Variable variable) throws IOException {
        MessageFormat nextFormat = getNextFormat();
        int i = 0;
        switch (AnonymousClass1.$SwitchMap$org$msgpack$value$ValueType[nextFormat.getValueType().ordinal()]) {
            case 1:
                readByte();
                variable.setNilValue();
                return variable;
            case 2:
                variable.setBooleanValue(unpackBoolean());
                return variable;
            case 3:
                if (AnonymousClass1.$SwitchMap$org$msgpack$core$MessageFormat[nextFormat.ordinal()] != 16) {
                    variable.setIntegerValue(unpackLong());
                    return variable;
                }
                variable.setIntegerValue(unpackBigInteger());
                return variable;
            case 4:
                variable.setFloatValue(unpackDouble());
                return variable;
            case 5:
                variable.setStringValue(readPayload(unpackRawStringHeader()));
                return variable;
            case 6:
                variable.setBinaryValue(readPayload(unpackBinaryHeader()));
                return variable;
            case 7:
                int unpackArrayHeader = unpackArrayHeader();
                ArrayList arrayList = new ArrayList(unpackArrayHeader);
                while (i < unpackArrayHeader) {
                    arrayList.add(unpackValue());
                    i++;
                }
                variable.setArrayValue(arrayList);
                return variable;
            case 8:
                int unpackMapHeader = unpackMapHeader();
                HashMap hashMap = new HashMap();
                while (i < unpackMapHeader) {
                    hashMap.put(unpackValue(), unpackValue());
                    i++;
                }
                variable.setMapValue(hashMap);
                return variable;
            case 9:
                ExtensionTypeHeader unpackExtensionTypeHeader = unpackExtensionTypeHeader();
                variable.setExtensionValue(unpackExtensionTypeHeader.getType(), readPayload(unpackExtensionTypeHeader.getLength()));
                return variable;
            default:
                throw new MessageFormatException("Unknown value type");
        }
    }

    public void unpackNil() throws IOException {
        byte readByte = readByte();
        if (readByte != -64) {
            throw unexpected("Nil", readByte);
        }
    }

    public boolean tryUnpackNil() throws IOException {
        if (!ensureBuffer()) {
            throw new MessageInsufficientBufferException();
        } else if (this.buffer.getByte(this.position) != -64) {
            return false;
        } else {
            readByte();
            return true;
        }
    }

    public boolean unpackBoolean() throws IOException {
        byte readByte = readByte();
        if (readByte == -62) {
            return false;
        }
        if (readByte == -61) {
            return true;
        }
        throw unexpected("boolean", readByte);
    }

    public byte unpackByte() throws IOException {
        long readLong;
        byte readByte = readByte();
        if (MessagePack.Code.isFixInt(readByte)) {
            return readByte;
        }
        switch (readByte) {
            case -52:
                byte readByte2 = readByte();
                if (readByte2 >= 0) {
                    return readByte2;
                }
                throw overflowU8(readByte2);
            case -51:
                short readShort = readShort();
                if (readShort >= 0 && readShort <= 127) {
                    return (byte) readShort;
                }
                throw overflowU16(readShort);
            case -50:
                int readInt = readInt();
                if (readInt >= 0 && readInt <= 127) {
                    return (byte) readInt;
                }
                throw overflowU32(readInt);
            case -49:
                readLong = readLong();
                if (readLong < 0 || readLong > 127) {
                    throw overflowU64(readLong);
                }
            case -48:
                return readByte();
            case -47:
                short readShort2 = readShort();
                if (readShort2 >= -128 && readShort2 <= 127) {
                    return (byte) readShort2;
                }
                throw overflowI16(readShort2);
            case -46:
                int readInt2 = readInt();
                if (readInt2 >= -128 && readInt2 <= 127) {
                    return (byte) readInt2;
                }
                throw overflowI32(readInt2);
            case -45:
                readLong = readLong();
                if (readLong < -128 || readLong > 127) {
                    throw overflowI64(readLong);
                }
            default:
                throw unexpected("Integer", readByte);
        }
        return (byte) ((int) readLong);
    }

    public short unpackShort() throws IOException {
        int readByte;
        long readLong;
        byte readByte2 = readByte();
        if (MessagePack.Code.isFixInt(readByte2)) {
            return (short) readByte2;
        }
        switch (readByte2) {
            case -52:
                readByte = readByte() & UByte.MAX_VALUE;
                break;
            case -51:
                short readShort = readShort();
                if (readShort >= 0) {
                    return readShort;
                }
                throw overflowU16(readShort);
            case -50:
                int readInt = readInt();
                if (readInt >= 0 && readInt <= 32767) {
                    return (short) readInt;
                }
                throw overflowU32(readInt);
            case -49:
                readLong = readLong();
                if (readLong < 0 || readLong > 32767) {
                    throw overflowU64(readLong);
                }
                readByte = (int) readLong;
                break;
            case -48:
                readByte = readByte();
                break;
            case -47:
                return readShort();
            case -46:
                int readInt2 = readInt();
                if (readInt2 >= -32768 && readInt2 <= 32767) {
                    return (short) readInt2;
                }
                throw overflowI32(readInt2);
            case -45:
                readLong = readLong();
                if (readLong < -32768 || readLong > 32767) {
                    throw overflowI64(readLong);
                }
                readByte = (int) readLong;
                break;
            default:
                throw unexpected("Integer", readByte2);
        }
        return (short) readByte;
    }

    public int unpackInt() throws IOException {
        byte readByte = readByte();
        if (MessagePack.Code.isFixInt(readByte)) {
            return readByte;
        }
        switch (readByte) {
            case -52:
                return readByte() & UByte.MAX_VALUE;
            case -51:
                return readShort() & UShort.MAX_VALUE;
            case -50:
                int readInt = readInt();
                if (readInt >= 0) {
                    return readInt;
                }
                throw overflowU32(readInt);
            case -49:
                long readLong = readLong();
                if (readLong >= 0 && readLong <= 2147483647L) {
                    return (int) readLong;
                }
                throw overflowU64(readLong);
            case -48:
                return readByte();
            case -47:
                return readShort();
            case -46:
                return readInt();
            case -45:
                long readLong2 = readLong();
                if (readLong2 >= -2147483648L && readLong2 <= 2147483647L) {
                    return (int) readLong2;
                }
                throw overflowI64(readLong2);
            default:
                throw unexpected("Integer", readByte);
        }
    }

    public long unpackLong() throws IOException {
        byte readByte = readByte();
        if (MessagePack.Code.isFixInt(readByte)) {
            return (long) readByte;
        }
        switch (readByte) {
            case -52:
                return (long) (readByte() & UByte.MAX_VALUE);
            case -51:
                return (long) (readShort() & UShort.MAX_VALUE);
            case -50:
                int readInt = readInt();
                return readInt < 0 ? ((long) (readInt & Integer.MAX_VALUE)) + 2147483648L : (long) readInt;
            case -49:
                long readLong = readLong();
                if (readLong >= 0) {
                    return readLong;
                }
                throw overflowU64(readLong);
            case -48:
                return (long) readByte();
            case -47:
                return (long) readShort();
            case -46:
                return (long) readInt();
            case -45:
                return readLong();
            default:
                throw unexpected("Integer", readByte);
        }
    }

    public BigInteger unpackBigInteger() throws IOException {
        byte readByte = readByte();
        if (MessagePack.Code.isFixInt(readByte)) {
            return BigInteger.valueOf((long) readByte);
        }
        switch (readByte) {
            case -52:
                return BigInteger.valueOf((long) (readByte() & UByte.MAX_VALUE));
            case -51:
                return BigInteger.valueOf((long) (readShort() & UShort.MAX_VALUE));
            case -50:
                int readInt = readInt();
                if (readInt < 0) {
                    return BigInteger.valueOf(((long) (readInt & Integer.MAX_VALUE)) + 2147483648L);
                }
                return BigInteger.valueOf((long) readInt);
            case -49:
                long readLong = readLong();
                if (readLong < 0) {
                    return BigInteger.valueOf(readLong + LongCompanionObject.MAX_VALUE + 1).setBit(63);
                }
                return BigInteger.valueOf(readLong);
            case -48:
                return BigInteger.valueOf((long) readByte());
            case -47:
                return BigInteger.valueOf((long) readShort());
            case -46:
                return BigInteger.valueOf((long) readInt());
            case -45:
                return BigInteger.valueOf(readLong());
            default:
                throw unexpected("Integer", readByte);
        }
    }

    public float unpackFloat() throws IOException {
        byte readByte = readByte();
        if (readByte == -54) {
            return readFloat();
        }
        if (readByte == -53) {
            return (float) readDouble();
        }
        throw unexpected("Float", readByte);
    }

    public double unpackDouble() throws IOException {
        byte readByte = readByte();
        if (readByte == -54) {
            return (double) readFloat();
        }
        if (readByte == -53) {
            return readDouble();
        }
        throw unexpected("Float", readByte);
    }

    private void resetDecoder() {
        CharsetDecoder charsetDecoder = this.decoder;
        if (charsetDecoder == null) {
            this.decodeBuffer = CharBuffer.allocate(this.stringDecoderBufferSize);
            this.decoder = MessagePack.UTF8.newDecoder().onMalformedInput(this.actionOnMalformedString).onUnmappableCharacter(this.actionOnUnmappableString);
        } else {
            charsetDecoder.reset();
        }
        StringBuilder sb = this.decodeStringBuffer;
        if (sb == null) {
            this.decodeStringBuffer = new StringBuilder();
        } else {
            sb.setLength(0);
        }
    }

    public String unpackString() throws IOException {
        int remaining;
        int unpackRawStringHeader = unpackRawStringHeader();
        if (unpackRawStringHeader == 0) {
            return "";
        }
        if (unpackRawStringHeader <= this.stringSizeLimit) {
            resetDecoder();
            if (this.buffer.size() - this.position >= unpackRawStringHeader) {
                return decodeStringFastPath(unpackRawStringHeader);
            }
            while (true) {
                if (unpackRawStringHeader <= 0) {
                    break;
                }
                try {
                    int size = this.buffer.size();
                    int i = this.position;
                    int i2 = size - i;
                    if (i2 >= unpackRawStringHeader) {
                        this.decodeStringBuffer.append(decodeStringFastPath(unpackRawStringHeader));
                        break;
                    } else if (i2 == 0) {
                        nextBuffer();
                    } else {
                        ByteBuffer sliceAsByteBuffer = this.buffer.sliceAsByteBuffer(i, i2);
                        int position2 = sliceAsByteBuffer.position();
                        this.decodeBuffer.clear();
                        CoderResult decode = this.decoder.decode(sliceAsByteBuffer, this.decodeBuffer, false);
                        int position3 = sliceAsByteBuffer.position() - position2;
                        this.position += position3;
                        unpackRawStringHeader -= position3;
                        this.decodeStringBuffer.append(this.decodeBuffer.flip());
                        if (decode.isError()) {
                            handleCoderError(decode);
                        }
                        if (decode.isUnderflow() && position3 < i2) {
                            ByteBuffer allocate = ByteBuffer.allocate(utf8MultibyteCharacterSize(this.buffer.getByte(this.position)));
                            MessageBuffer messageBuffer = this.buffer;
                            messageBuffer.getBytes(this.position, messageBuffer.size() - this.position, allocate);
                            while (true) {
                                nextBuffer();
                                remaining = allocate.remaining();
                                if (this.buffer.size() >= remaining) {
                                    break;
                                }
                                MessageBuffer messageBuffer2 = this.buffer;
                                messageBuffer2.getBytes(0, messageBuffer2.size(), allocate);
                                this.position = this.buffer.size();
                            }
                            this.buffer.getBytes(0, remaining, allocate);
                            this.position = remaining;
                            allocate.position(0);
                            this.decodeBuffer.clear();
                            CoderResult decode2 = this.decoder.decode(allocate, this.decodeBuffer, false);
                            if (decode2.isError()) {
                                handleCoderError(decode2);
                            }
                            if (decode2.isOverflow() || (decode2.isUnderflow() && allocate.position() < allocate.limit())) {
                                try {
                                    decode2.throwException();
                                    throw new MessageFormatException("Unexpected UTF-8 multibyte sequence");
                                } catch (Exception e) {
                                    throw new MessageFormatException("Unexpected UTF-8 multibyte sequence", e);
                                }
                            } else {
                                unpackRawStringHeader -= allocate.limit();
                                this.decodeStringBuffer.append(this.decodeBuffer.flip());
                            }
                        }
                    }
                } catch (CharacterCodingException e2) {
                    throw new MessageStringCodingException(e2);
                }
            }
            return this.decodeStringBuffer.toString();
        }
        throw new MessageSizeException(String.format("cannot unpack a String of size larger than %,d: %,d", Integer.valueOf(this.stringSizeLimit), Integer.valueOf(unpackRawStringHeader)), (long) unpackRawStringHeader);
    }

    private void handleCoderError(CoderResult coderResult) throws CharacterCodingException {
        if ((coderResult.isMalformed() && this.actionOnMalformedString == CodingErrorAction.REPORT) || (coderResult.isUnmappable() && this.actionOnUnmappableString == CodingErrorAction.REPORT)) {
            coderResult.throwException();
        }
    }

    private String decodeStringFastPath(int i) {
        if (this.actionOnMalformedString == CodingErrorAction.REPLACE && this.actionOnUnmappableString == CodingErrorAction.REPLACE && this.buffer.hasArray()) {
            String str = new String(this.buffer.array(), this.buffer.arrayOffset() + this.position, i, MessagePack.UTF8);
            this.position += i;
            return str;
        }
        try {
            CharBuffer decode = this.decoder.decode(this.buffer.sliceAsByteBuffer(this.position, i));
            this.position += i;
            return decode.toString();
        } catch (CharacterCodingException e) {
            throw new MessageStringCodingException(e);
        }
    }

    public int unpackArrayHeader() throws IOException {
        byte readByte = readByte();
        if (MessagePack.Code.isFixedArray(readByte)) {
            return readByte & 15;
        }
        if (readByte == -36) {
            return readNextLength16();
        }
        if (readByte == -35) {
            return readNextLength32();
        }
        throw unexpected("Array", readByte);
    }

    public int unpackMapHeader() throws IOException {
        byte readByte = readByte();
        if (MessagePack.Code.isFixedMap(readByte)) {
            return readByte & 15;
        }
        if (readByte == -34) {
            return readNextLength16();
        }
        if (readByte == -33) {
            return readNextLength32();
        }
        throw unexpected("Map", readByte);
    }

    public ExtensionTypeHeader unpackExtensionTypeHeader() throws IOException {
        byte readByte = readByte();
        switch (readByte) {
            case -57:
                MessageBuffer prepareNumberBuffer = prepareNumberBuffer(2);
                return new ExtensionTypeHeader(prepareNumberBuffer.getByte(this.nextReadPosition + 1), prepareNumberBuffer.getByte(this.nextReadPosition) & UByte.MAX_VALUE);
            case -56:
                MessageBuffer prepareNumberBuffer2 = prepareNumberBuffer(3);
                return new ExtensionTypeHeader(prepareNumberBuffer2.getByte(this.nextReadPosition + 2), prepareNumberBuffer2.getShort(this.nextReadPosition) & UShort.MAX_VALUE);
            case -55:
                MessageBuffer prepareNumberBuffer3 = prepareNumberBuffer(5);
                int i = prepareNumberBuffer3.getInt(this.nextReadPosition);
                if (i >= 0) {
                    return new ExtensionTypeHeader(prepareNumberBuffer3.getByte(this.nextReadPosition + 4), i);
                }
                throw overflowU32Size(i);
            default:
                switch (readByte) {
                    case -44:
                        return new ExtensionTypeHeader(readByte(), 1);
                    case -43:
                        return new ExtensionTypeHeader(readByte(), 2);
                    case -42:
                        return new ExtensionTypeHeader(readByte(), 4);
                    case -41:
                        return new ExtensionTypeHeader(readByte(), 8);
                    case -40:
                        return new ExtensionTypeHeader(readByte(), 16);
                    default:
                        throw unexpected("Ext", readByte);
                }
        }
    }

    private int tryReadStringHeader(byte b) throws IOException {
        switch (b) {
            case -39:
                return readNextLength8();
            case -38:
                return readNextLength16();
            case -37:
                return readNextLength32();
            default:
                return -1;
        }
    }

    private int tryReadBinaryHeader(byte b) throws IOException {
        switch (b) {
            case -60:
                return readNextLength8();
            case -59:
                return readNextLength16();
            case -58:
                return readNextLength32();
            default:
                return -1;
        }
    }

    public int unpackRawStringHeader() throws IOException {
        int tryReadBinaryHeader;
        byte readByte = readByte();
        if (MessagePack.Code.isFixedRaw(readByte)) {
            return readByte & 31;
        }
        int tryReadStringHeader = tryReadStringHeader(readByte);
        if (tryReadStringHeader >= 0) {
            return tryReadStringHeader;
        }
        if (this.allowReadingBinaryAsString && (tryReadBinaryHeader = tryReadBinaryHeader(readByte)) >= 0) {
            return tryReadBinaryHeader;
        }
        throw unexpected("String", readByte);
    }

    public int unpackBinaryHeader() throws IOException {
        int tryReadStringHeader;
        byte readByte = readByte();
        if (MessagePack.Code.isFixedRaw(readByte)) {
            return readByte & 31;
        }
        int tryReadBinaryHeader = tryReadBinaryHeader(readByte);
        if (tryReadBinaryHeader >= 0) {
            return tryReadBinaryHeader;
        }
        if (this.allowReadingStringAsBinary && (tryReadStringHeader = tryReadStringHeader(readByte)) >= 0) {
            return tryReadStringHeader;
        }
        throw unexpected("Binary", readByte);
    }

    private void skipPayload(int i) throws IOException {
        while (true) {
            int size = this.buffer.size();
            int i2 = this.position;
            int i3 = size - i2;
            if (i3 >= i) {
                this.position = i2 + i;
                return;
            }
            this.position = i2 + i3;
            i -= i3;
            nextBuffer();
        }
    }

    public void readPayload(ByteBuffer byteBuffer) throws IOException {
        while (true) {
            int remaining = byteBuffer.remaining();
            int size = this.buffer.size();
            int i = this.position;
            int i2 = size - i;
            if (i2 >= remaining) {
                this.buffer.getBytes(i, remaining, byteBuffer);
                this.position += remaining;
                return;
            }
            this.buffer.getBytes(i, i2, byteBuffer);
            this.position += i2;
            nextBuffer();
        }
    }

    public void readPayload(MessageBuffer messageBuffer, int i, int i2) throws IOException {
        while (true) {
            int size = this.buffer.size();
            int i3 = this.position;
            int i4 = size - i3;
            if (i4 >= i2) {
                messageBuffer.putMessageBuffer(i, this.buffer, i3, i2);
                this.position += i2;
                return;
            }
            messageBuffer.putMessageBuffer(i, this.buffer, i3, i4);
            i += i4;
            i2 -= i4;
            this.position += i4;
            nextBuffer();
        }
    }

    public void readPayload(byte[] bArr) throws IOException {
        readPayload(bArr, 0, bArr.length);
    }

    public byte[] readPayload(int i) throws IOException {
        byte[] bArr = new byte[i];
        readPayload(bArr);
        return bArr;
    }

    public void readPayload(byte[] bArr, int i, int i2) throws IOException {
        readPayload(MessageBuffer.wrap(bArr), i, i2);
    }

    public MessageBuffer readPayloadAsReference(int i) throws IOException {
        int size = this.buffer.size();
        int i2 = this.position;
        if (size - i2 >= i) {
            MessageBuffer slice = this.buffer.slice(i2, i);
            this.position += i;
            return slice;
        }
        MessageBuffer allocate = MessageBuffer.allocate(i);
        readPayload(allocate, 0, i);
        return allocate;
    }

    private int readNextLength8() throws IOException {
        return readByte() & UByte.MAX_VALUE;
    }

    private int readNextLength16() throws IOException {
        return readShort() & UShort.MAX_VALUE;
    }

    private int readNextLength32() throws IOException {
        int readInt = readInt();
        if (readInt >= 0) {
            return readInt;
        }
        throw overflowU32Size(readInt);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.buffer = EMPTY_BUFFER;
        this.position = 0;
        this.in.close();
    }

    private static MessageIntegerOverflowException overflowU8(byte b) {
        return new MessageIntegerOverflowException(BigInteger.valueOf((long) (b & UByte.MAX_VALUE)));
    }

    private static MessageIntegerOverflowException overflowU16(short s) {
        return new MessageIntegerOverflowException(BigInteger.valueOf((long) (s & UShort.MAX_VALUE)));
    }

    private static MessageIntegerOverflowException overflowU32(int i) {
        return new MessageIntegerOverflowException(BigInteger.valueOf(((long) (i & Integer.MAX_VALUE)) + 2147483648L));
    }

    private static MessageIntegerOverflowException overflowU64(long j) {
        return new MessageIntegerOverflowException(BigInteger.valueOf(j + LongCompanionObject.MAX_VALUE + 1).setBit(63));
    }

    private static MessageIntegerOverflowException overflowI16(short s) {
        return new MessageIntegerOverflowException(BigInteger.valueOf((long) s));
    }

    private static MessageIntegerOverflowException overflowI32(int i) {
        return new MessageIntegerOverflowException(BigInteger.valueOf((long) i));
    }

    private static MessageIntegerOverflowException overflowI64(long j) {
        return new MessageIntegerOverflowException(BigInteger.valueOf(j));
    }

    private static MessageSizeException overflowU32Size(int i) {
        return new MessageSizeException(((long) (i & Integer.MAX_VALUE)) + 2147483648L);
    }
}
