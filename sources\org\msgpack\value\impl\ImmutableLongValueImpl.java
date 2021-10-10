package org.msgpack.value.impl;

import java.io.IOException;
import java.math.BigInteger;
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

public class ImmutableLongValueImpl extends AbstractImmutableValue implements ImmutableIntegerValue {
    private static final long BYTE_MAX = 127;
    private static final long BYTE_MIN = -128;
    private static final long INT_MAX = 2147483647L;
    private static final long INT_MIN = -2147483648L;
    private static final long SHORT_MAX = 32767;
    private static final long SHORT_MIN = -32768;
    private final long value;

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

    @Override // org.msgpack.value.IntegerValue
    public boolean isInLongRange() {
        return true;
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

    public ImmutableLongValueImpl(long j) {
        this.value = j;
    }

    @Override // org.msgpack.value.Value
    public ValueType getValueType() {
        return ValueType.INTEGER;
    }

    @Override // org.msgpack.value.NumberValue
    public byte toByte() {
        return (byte) ((int) this.value);
    }

    @Override // org.msgpack.value.NumberValue
    public short toShort() {
        return (short) ((int) this.value);
    }

    @Override // org.msgpack.value.NumberValue
    public int toInt() {
        return (int) this.value;
    }

    @Override // org.msgpack.value.NumberValue
    public long toLong() {
        return this.value;
    }

    @Override // org.msgpack.value.NumberValue
    public BigInteger toBigInteger() {
        return BigInteger.valueOf(this.value);
    }

    @Override // org.msgpack.value.NumberValue
    public float toFloat() {
        return (float) this.value;
    }

    @Override // org.msgpack.value.NumberValue
    public double toDouble() {
        return (double) this.value;
    }

    @Override // org.msgpack.value.IntegerValue
    public boolean isInByteRange() {
        long j = this.value;
        return BYTE_MIN <= j && j <= BYTE_MAX;
    }

    @Override // org.msgpack.value.IntegerValue
    public boolean isInShortRange() {
        long j = this.value;
        return SHORT_MIN <= j && j <= SHORT_MAX;
    }

    @Override // org.msgpack.value.IntegerValue
    public boolean isInIntRange() {
        long j = this.value;
        return INT_MIN <= j && j <= INT_MAX;
    }

    @Override // org.msgpack.value.IntegerValue
    public MessageFormat mostSuccinctMessageFormat() {
        return ImmutableBigIntegerValueImpl.mostSuccinctMessageFormat(this);
    }

    @Override // org.msgpack.value.IntegerValue
    public byte asByte() {
        if (isInByteRange()) {
            return (byte) ((int) this.value);
        }
        throw new MessageIntegerOverflowException(this.value);
    }

    @Override // org.msgpack.value.IntegerValue
    public short asShort() {
        if (isInShortRange()) {
            return (short) ((int) this.value);
        }
        throw new MessageIntegerOverflowException(this.value);
    }

    @Override // org.msgpack.value.IntegerValue
    public int asInt() {
        if (isInIntRange()) {
            return (int) this.value;
        }
        throw new MessageIntegerOverflowException(this.value);
    }

    @Override // org.msgpack.value.IntegerValue
    public long asLong() {
        return this.value;
    }

    @Override // org.msgpack.value.IntegerValue
    public BigInteger asBigInteger() {
        return BigInteger.valueOf(this.value);
    }

    @Override // org.msgpack.value.Value
    public void writeTo(MessagePacker messagePacker) throws IOException {
        messagePacker.packLong(this.value);
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
        IntegerValue asIntegerValue = value2.asIntegerValue();
        if (!asIntegerValue.isInLongRange()) {
            return false;
        }
        return this.value == asIntegerValue.toLong();
    }

    public int hashCode() {
        long j = this.value;
        return (INT_MIN > j || j > INT_MAX) ? (int) (j ^ (j >>> 32)) : (int) j;
    }

    @Override // org.msgpack.value.Value
    public String toJson() {
        return Long.toString(this.value);
    }

    public String toString() {
        return toJson();
    }
}
