package org.bouncycastle.asn1;

import java.io.ByteArrayInputStream;
import java.io.EOFException;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.bouncycastle.util.io.Streams;

public class ASN1InputStream extends FilterInputStream implements DERTags {
    private final boolean lazyEvaluate;
    private final int limit;

    public ASN1InputStream(InputStream inputStream) {
        this(inputStream, findLimit(inputStream));
    }

    public ASN1InputStream(InputStream inputStream, int i) {
        this(inputStream, i, false);
    }

    public ASN1InputStream(InputStream inputStream, int i, boolean z) {
        super(inputStream);
        this.limit = i;
        this.lazyEvaluate = z;
    }

    public ASN1InputStream(byte[] bArr) {
        this(new ByteArrayInputStream(bArr), bArr.length);
    }

    public ASN1InputStream(byte[] bArr, boolean z) {
        this(new ByteArrayInputStream(bArr), bArr.length, z);
    }

    static DERObject createPrimitiveDERObject(int i, byte[] bArr) {
        switch (i) {
            case 1:
                return new ASN1Boolean(bArr);
            case 2:
                return new ASN1Integer(bArr);
            case 3:
                return DERBitString.fromOctetString(bArr);
            case 4:
                return new DEROctetString(bArr);
            case 5:
                return DERNull.INSTANCE;
            case 6:
                return new ASN1ObjectIdentifier(bArr);
            case 7:
            case 8:
            case 9:
            case 11:
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
            case 21:
            case 25:
            case 29:
            default:
                return new DERUnknownTag(false, i, bArr);
            case 10:
                return new ASN1Enumerated(bArr);
            case 12:
                return new DERUTF8String(bArr);
            case 18:
                return new DERNumericString(bArr);
            case 19:
                return new DERPrintableString(bArr);
            case 20:
                return new DERT61String(bArr);
            case 22:
                return new DERIA5String(bArr);
            case 23:
                return new ASN1UTCTime(bArr);
            case 24:
                return new ASN1GeneralizedTime(bArr);
            case 26:
                return new DERVisibleString(bArr);
            case 27:
                return new DERGeneralString(bArr);
            case 28:
                return new DERUniversalString(bArr);
            case 30:
                return new DERBMPString(bArr);
        }
    }

    static int findLimit(InputStream inputStream) {
        if (inputStream instanceof LimitedInputStream) {
            return ((LimitedInputStream) inputStream).getRemaining();
        }
        if (inputStream instanceof ByteArrayInputStream) {
            return ((ByteArrayInputStream) inputStream).available();
        }
        return Integer.MAX_VALUE;
    }

    static int readLength(InputStream inputStream, int i) throws IOException {
        int read = inputStream.read();
        if (read < 0) {
            throw new EOFException("EOF found when length expected");
        } else if (read == 128) {
            return -1;
        } else {
            if (read <= 127) {
                return read;
            }
            int i2 = read & 127;
            if (i2 <= 4) {
                int i3 = 0;
                for (int i4 = 0; i4 < i2; i4++) {
                    int read2 = inputStream.read();
                    if (read2 >= 0) {
                        i3 = (i3 << 8) + read2;
                    } else {
                        throw new EOFException("EOF found reading length");
                    }
                }
                if (i3 < 0) {
                    throw new IOException("corrupted stream - negative length found");
                } else if (i3 < i) {
                    return i3;
                } else {
                    throw new IOException("corrupted stream - out of bounds length found");
                }
            } else {
                throw new IOException("DER length more than 4 bytes: " + i2);
            }
        }
    }

    static int readTagNumber(InputStream inputStream, int i) throws IOException {
        int i2 = i & 31;
        if (i2 != 31) {
            return i2;
        }
        int i3 = 0;
        int read = inputStream.read();
        if ((read & 127) != 0) {
            while (read >= 0 && (read & 128) != 0) {
                i3 = (i3 | (read & 127)) << 7;
                read = inputStream.read();
            }
            if (read >= 0) {
                return i3 | (read & 127);
            }
            throw new EOFException("EOF found inside tag value.");
        }
        throw new IOException("corrupted stream - invalid high tag number found");
    }

    /* access modifiers changed from: package-private */
    public ASN1EncodableVector buildDEREncodableVector(DefiniteLengthInputStream definiteLengthInputStream) throws IOException {
        return new ASN1InputStream(definiteLengthInputStream).buildEncodableVector();
    }

    /* access modifiers changed from: package-private */
    public ASN1EncodableVector buildEncodableVector() throws IOException {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        while (true) {
            DERObject readObject = readObject();
            if (readObject == null) {
                return aSN1EncodableVector;
            }
            aSN1EncodableVector.add(readObject);
        }
    }

    /* access modifiers changed from: protected */
    public DERObject buildObject(int i, int i2, int i3) throws IOException {
        boolean z = (i & 32) != 0;
        DefiniteLengthInputStream definiteLengthInputStream = new DefiniteLengthInputStream(this, i3);
        return (i & 64) != 0 ? new DERApplicationSpecific(z, i2, definiteLengthInputStream.toByteArray()) : (i & 128) != 0 ? new ASN1StreamParser(definiteLengthInputStream).readTaggedObject(z, i2) : z ? i2 != 4 ? i2 != 8 ? i2 != 16 ? i2 != 17 ? new DERUnknownTag(true, i2, definiteLengthInputStream.toByteArray()) : DERFactory.createSet(buildDEREncodableVector(definiteLengthInputStream), false) : this.lazyEvaluate ? new LazyDERSequence(definiteLengthInputStream.toByteArray()) : DERFactory.createSequence(buildDEREncodableVector(definiteLengthInputStream)) : new DERExternal(buildDEREncodableVector(definiteLengthInputStream)) : new BERConstructedOctetString(buildDEREncodableVector(definiteLengthInputStream).v) : createPrimitiveDERObject(i2, definiteLengthInputStream.toByteArray());
    }

    /* access modifiers changed from: protected */
    public void readFully(byte[] bArr) throws IOException {
        if (Streams.readFully(this, bArr) != bArr.length) {
            throw new EOFException("EOF encountered in middle of object");
        }
    }

    /* access modifiers changed from: protected */
    public int readLength() throws IOException {
        return readLength(this, this.limit);
    }

    public DERObject readObject() throws IOException {
        int read = read();
        if (read > 0) {
            int readTagNumber = readTagNumber(this, read);
            boolean z = (read & 32) != 0;
            int readLength = readLength();
            if (readLength >= 0) {
                try {
                    return buildObject(read, readTagNumber, readLength);
                } catch (IllegalArgumentException e) {
                    throw new ASN1Exception("corrupted stream detected", e);
                }
            } else if (z) {
                ASN1StreamParser aSN1StreamParser = new ASN1StreamParser(new IndefiniteLengthInputStream(this, this.limit), this.limit);
                if ((read & 64) != 0) {
                    return new BERApplicationSpecificParser(readTagNumber, aSN1StreamParser).getLoadedObject();
                }
                if ((read & 128) != 0) {
                    return new BERTaggedObjectParser(true, readTagNumber, aSN1StreamParser).getLoadedObject();
                }
                if (readTagNumber == 4) {
                    return new BEROctetStringParser(aSN1StreamParser).getLoadedObject();
                }
                if (readTagNumber == 8) {
                    return new DERExternalParser(aSN1StreamParser).getLoadedObject();
                }
                if (readTagNumber == 16) {
                    return new BERSequenceParser(aSN1StreamParser).getLoadedObject();
                }
                if (readTagNumber == 17) {
                    return new BERSetParser(aSN1StreamParser).getLoadedObject();
                }
                throw new IOException("unknown BER object encountered");
            } else {
                throw new IOException("indefinite length primitive encoding encountered");
            }
        } else if (read != 0) {
            return null;
        } else {
            throw new IOException("unexpected end-of-contents marker");
        }
    }
}
