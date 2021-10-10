package org.msgpack.value.impl;

import java.io.IOException;
import java.math.BigInteger;
import kotlin.jvm.internal.LongCompanionObject;
import org.msgpack.core.MessageFormat;
import org.msgpack.core.MessageIntegerOverflowException;
import org.msgpack.core.MessagePacker;
import org.msgpack.value.ImmutableArrayValue;
import org.msgpack.value.ImmutableBinaryValue;
import org.msgpack.value.ImmutableBooleanValue;
import org.msgpack.value.ImmutableExtensionValue;
import org.msgpack.value.ImmutableFloatValue;
import org.msgpack.value.ImmutableIntegerValue;
import org.msgpack.value.ImmutableMapValue;
import org.msgpack.value.ImmutableNilValue;
import org.msgpack.value.ImmutableNumberValue;
import org.msgpack.value.ImmutableRawValue;
import org.msgpack.value.ImmutableStringValue;
import org.msgpack.value.IntegerValue;
import org.msgpack.value.Value;
import org.msgpack.value.ValueType;

public class ImmutableBigIntegerValueImpl extends AbstractImmutableValue implements ImmutableIntegerValue {
    private static final BigInteger BYTE_MAX = BigInteger.valueOf(127);
    private static final BigInteger BYTE_MIN = BigInteger.valueOf(-128);
    private static final BigInteger INT_MAX = BigInteger.valueOf(2147483647L);
    private static final BigInteger INT_MIN = BigInteger.valueOf(-2147483648L);
    private static final BigInteger LONG_MAX = BigInteger.valueOf(LongCompanionObject.MAX_VALUE);
    private static final BigInteger LONG_MIN = BigInteger.valueOf(Long.MIN_VALUE);
    private static final BigInteger SHORT_MAX = BigInteger.valueOf(32767);
    private static final BigInteger SHORT_MIN = BigInteger.valueOf(-32768);
    private final BigInteger value;

    @Override // org.msgpack.value.Value, org.msgpack.value.ImmutableValue, org.msgpack.value.impl.AbstractImmutableValue, org.msgpack.value.impl.AbstractImmutableValue
    public ImmutableIntegerValue asIntegerValue() {
        return this;
    }

    @Override // org.msgpack.value.Value, org.msgpack.value.impl.AbstractImmutableValue, org.msgpack.value.impl.AbstractImmutableValue
    public ImmutableNumberValue asNumberValue() {
        return this;
    }

    @Override // org.msgpack.value.Value
    public ImmutableIntegerValue immutableValue() {
        return this;
    }

    @Override // org.msgpack.value.Value, org.msgpack.value.ImmutableValue, org.msgpack.value.impl.AbstractImmutableValue, org.msgpack.value.impl.AbstractImmutableValue
    public /* bridge */ /* synthetic */ ImmutableArrayValue asArrayValue() {
        return super.asArrayValue();
    }

    @Override // org.msgpack.value.Value, org.msgpack.value.ImmutableValue, org.msgpack.value.impl.AbstractImmutableValue, org.msgpack.value.impl.AbstractImmutableValue
    public /* bridge */ /* synthetic */ ImmutableBinaryValue asBinaryValue() {
        return super.asBinaryValue();
    }

    @Override // org.msgpack.value.Value, org.msgpack.value.ImmutableValue, org.msgpack.value.impl.AbstractImmutableValue, org.msgpack.value.impl.AbstractImmutableValue
    public /* bridge */ /* synthetic */ ImmutableBooleanValue asBooleanValue() {
        return super.asBooleanValue();
    }

    @Override // org.msgpack.value.Value, org.msgpack.value.impl.AbstractImmutableValue, org.msgpack.value.impl.AbstractImmutableValue
    public /* bridge */ /* synthetic */ ImmutableExtensionValue asExtensionValue() {
        return super.asExtensionValue();
    }

    @Override // org.msgpack.value.Value, org.msgpack.value.ImmutableValue, org.msgpack.value.impl.AbstractImmutableValue, org.msgpack.value.impl.AbstractImmutableValue
    public /* bridge */ /* synthetic */ ImmutableFloatValue asFloatValue() {
        return super.asFloatValue();
    }

    @Override // org.msgpack.value.Value, org.msgpack.value.ImmutableValue, org.msgpack.value.impl.AbstractImmutableValue, org.msgpack.value.impl.AbstractImmutableValue
    public /* bridge */ /* synthetic */ ImmutableMapValue asMapValue() {
        return super.asMapValue();
    }

    @Override // org.msgpack.value.Value, org.msgpack.value.ImmutableValue, org.msgpack.value.impl.AbstractImmutableValue, org.msgpack.value.impl.AbstractImmutableValue
    public /* bridge */ /* synthetic */ ImmutableNilValue asNilValue() {
        return super.asNilValue();
    }

    @Override // org.msgpack.value.Value, org.msgpack.value.ImmutableValue, org.msgpack.value.impl.AbstractImmutableValue, org.msgpack.value.impl.AbstractImmutableValue
    public /* bridge */ /* synthetic */ ImmutableRawValue asRawValue() {
        return super.asRawValue();
    }

    @Override // org.msgpack.value.Value, org.msgpack.value.ImmutableValue, org.msgpack.value.impl.AbstractImmutableValue, org.msgpack.value.impl.AbstractImmutableValue
    public /* bridge */ /* synthetic */ ImmutableStringValue asStringValue() {
        return super.asStringValue();
    }

    @Override // org.msgpack.value.Value, org.msgpack.value.impl.AbstractImmutableValue
    public /* bridge */ /* synthetic */ boolean isArrayValue() {
        return super.isArrayValue();
    }

    @Override // org.msgpack.value.Value, org.msgpack.value.impl.AbstractImmutableValue
    public /* bridge */ /* synthetic */ boolean isBinaryValue() {
        return super.isBinaryValue();
    }

    @Override // org.msgpack.value.Value, org.msgpack.value.impl.AbstractImmutableValue
    public /* bridge */ /* synthetic */ boolean isBooleanValue() {
        return super.isBooleanValue();
    }

    @Override // org.msgpack.value.Value, org.msgpack.value.impl.AbstractImmutableValue
    public /* bridge */ /* synthetic */ boolean isExtensionValue() {
        return super.isExtensionValue();
    }

    @Override // org.msgpack.value.Value, org.msgpack.value.impl.AbstractImmutableValue
    public /* bridge */ /* synthetic */ boolean isFloatValue() {
        return super.isFloatValue();
    }

    @Override // org.msgpack.value.Value, org.msgpack.value.impl.AbstractImmutableValue
    public /* bridge */ /* synthetic */ boolean isIntegerValue() {
        return super.isIntegerValue();
    }

    @Override // org.msgpack.value.Value, org.msgpack.value.impl.AbstractImmutableValue
    public /* bridge */ /* synthetic */ boolean isMapValue() {
        return super.isMapValue();
    }

    @Override // org.msgpack.value.Value, org.msgpack.value.impl.AbstractImmutableValue
    public /* bridge */ /* synthetic */ boolean isNilValue() {
        return super.isNilValue();
    }

    @Override // org.msgpack.value.Value, org.msgpack.value.impl.AbstractImmutableValue
    public /* bridge */ /* synthetic */ boolean isNumberValue() {
        return super.isNumberValue();
    }

    @Override // org.msgpack.value.Value, org.msgpack.value.impl.AbstractImmutableValue
    public /* bridge */ /* synthetic */ boolean isRawValue() {
        return super.isRawValue();
    }

    @Override // org.msgpack.value.Value, org.msgpack.value.impl.AbstractImmutableValue
    public /* bridge */ /* synthetic */ boolean isStringValue() {
        return super.isStringValue();
    }

    public static MessageFormat mostSuccinctMessageFormat(IntegerValue integerValue) {
        if (integerValue.isInByteRange()) {
            return MessageFormat.INT8;
        }
        if (integerValue.isInShortRange()) {
            return MessageFormat.INT16;
        }
        if (integerValue.isInIntRange()) {
            return MessageFormat.INT32;
        }
        if (integerValue.isInLongRange()) {
            return MessageFormat.INT64;
        }
        return MessageFormat.UINT64;
    }

    public ImmutableBigIntegerValueImpl(BigInteger bigInteger) {
        this.value = bigInteger;
    }

    @Override // org.msgpack.value.Value
    public ValueType getValueType() {
        return ValueType.INTEGER;
    }

    @Override // org.msgpack.value.NumberValue
    public byte toByte() {
        return this.value.byteValue();
    }

    @Override // org.msgpack.value.NumberValue
    public short toShort() {
        return this.value.shortValue();
    }

    @Override // org.msgpack.value.NumberValue
    public int toInt() {
        return this.value.intValue();
    }

    @Override // org.msgpack.value.NumberValue
    public long toLong() {
        return this.value.longValue();
    }

    @Override // org.msgpack.value.NumberValue
    public BigInteger toBigInteger() {
        return this.value;
    }

    @Override // org.msgpack.value.NumberValue
    public float toFloat() {
        return this.value.floatValue();
    }

    @Override // org.msgpack.value.NumberValue
    public double toDouble() {
        return this.value.doubleValue();
    }

    @Override // org.msgpack.value.IntegerValue
    public boolean isInByteRange() {
        return this.value.compareTo(BYTE_MIN) >= 0 && this.value.compareTo(BYTE_MAX) <= 0;
    }

    @Override // org.msgpack.value.IntegerValue
    public boolean isInShortRange() {
        return this.value.compareTo(SHORT_MIN) >= 0 && this.value.compareTo(SHORT_MAX) <= 0;
    }

    @Override // org.msgpack.value.IntegerValue
    public boolean isInIntRange() {
        return this.value.compareTo(INT_MIN) >= 0 && this.value.compareTo(INT_MAX) <= 0;
    }

    @Override // org.msgpack.value.IntegerValue
    public boolean isInLongRange() {
        return this.value.compareTo(LONG_MIN) >= 0 && this.value.compareTo(LONG_MAX) <= 0;
    }

    @Override // org.msgpack.value.IntegerValue
    public MessageFormat mostSuccinctMessageFormat() {
        return mostSuccinctMessageFormat(this);
    }

    @Override // org.msgpack.value.IntegerValue
    public byte asByte() {
        if (isInByteRange()) {
            return this.value.byteValue();
        }
        throw new MessageIntegerOverflowException(this.value);
    }

    @Override // org.msgpack.value.IntegerValue
    public short asShort() {
        if (isInShortRange()) {
            return this.value.shortValue();
        }
        throw new MessageIntegerOverflowException(this.value);
    }

    @Override // org.msgpack.value.IntegerValue
    public int asInt() {
        if (isInIntRange()) {
            return this.value.intValue();
        }
        throw new MessageIntegerOverflowException(this.value);
    }

    @Override // org.msgpack.value.IntegerValue
    public long asLong() {
        if (isInLongRange()) {
            return this.value.longValue();
        }
        throw new MessageIntegerOverflowException(this.value);
    }

    @Override // org.msgpack.value.IntegerValue
    public BigInteger asBigInteger() {
        return this.value;
    }

    @Override // org.msgpack.value.Value
    public void writeTo(MessagePacker messagePacker) throws IOException {
        messagePacker.packBigInteger(this.value);
    }

    @Override // org.msgpack.value.Value
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Value)) {
            return false;
        }
        Value value2 = (Value) obj;
        if (!value2.isIntegerValue()) {
            return false;
        }
        return this.value.equals(value2.asIntegerValue().toBigInteger());
    }

    public int hashCode() {
        if (INT_MIN.compareTo(this.value) <= 0 && this.value.compareTo(INT_MAX) <= 0) {
            return (int) this.value.longValue();
        }
        if (LONG_MIN.compareTo(this.value) > 0 || this.value.compareTo(LONG_MAX) > 0) {
            return this.value.hashCode();
        }
        long longValue = this.value.longValue();
        return (int) (longValue ^ (longValue >>> 32));
    }

    @Override // org.msgpack.value.Value
    public String toJson() {
        return this.value.toString();
    }

    public String toString() {
        return toJson();
    }
}
