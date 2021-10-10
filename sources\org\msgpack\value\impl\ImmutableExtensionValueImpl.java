package org.msgpack.value.impl;

import java.io.IOException;
import java.util.Arrays;
import org.msgpack.core.MessagePacker;
import org.msgpack.value.ExtensionValue;
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
import org.msgpack.value.Value;
import org.msgpack.value.ValueType;

public class ImmutableExtensionValueImpl extends AbstractImmutableValue implements ImmutableExtensionValue {
    private final byte[] data;
    private final byte type;

    @Override // org.msgpack.value.Value, org.msgpack.value.impl.AbstractImmutableValue, org.msgpack.value.impl.AbstractImmutableValue
    public ImmutableExtensionValue asExtensionValue() {
        return this;
    }

    @Override // org.msgpack.value.Value
    public ImmutableExtensionValue immutableValue() {
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

    @Override // org.msgpack.value.Value, org.msgpack.value.ImmutableValue, org.msgpack.value.impl.AbstractImmutableValue, org.msgpack.value.impl.AbstractImmutableValue
    public /* bridge */ /* synthetic */ ImmutableFloatValue asFloatValue() {
        return super.asFloatValue();
    }

    @Override // org.msgpack.value.Value, org.msgpack.value.ImmutableValue, org.msgpack.value.impl.AbstractImmutableValue, org.msgpack.value.impl.AbstractImmutableValue
    public /* bridge */ /* synthetic */ ImmutableIntegerValue asIntegerValue() {
        return super.asIntegerValue();
    }

    @Override // org.msgpack.value.Value, org.msgpack.value.ImmutableValue, org.msgpack.value.impl.AbstractImmutableValue, org.msgpack.value.impl.AbstractImmutableValue
    public /* bridge */ /* synthetic */ ImmutableMapValue asMapValue() {
        return super.asMapValue();
    }

    @Override // org.msgpack.value.Value, org.msgpack.value.ImmutableValue, org.msgpack.value.impl.AbstractImmutableValue, org.msgpack.value.impl.AbstractImmutableValue
    public /* bridge */ /* synthetic */ ImmutableNilValue asNilValue() {
        return super.asNilValue();
    }

    @Override // org.msgpack.value.Value, org.msgpack.value.impl.AbstractImmutableValue, org.msgpack.value.impl.AbstractImmutableValue
    public /* bridge */ /* synthetic */ ImmutableNumberValue asNumberValue() {
        return super.asNumberValue();
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

    public ImmutableExtensionValueImpl(byte b, byte[] bArr) {
        this.type = b;
        this.data = bArr;
    }

    @Override // org.msgpack.value.Value
    public ValueType getValueType() {
        return ValueType.EXTENSION;
    }

    @Override // org.msgpack.value.ExtensionValue
    public byte getType() {
        return this.type;
    }

    @Override // org.msgpack.value.ExtensionValue
    public byte[] getData() {
        return this.data;
    }

    @Override // org.msgpack.value.Value
    public void writeTo(MessagePacker messagePacker) throws IOException {
        messagePacker.packExtensionTypeHeader(this.type, this.data.length);
        messagePacker.writePayload(this.data);
    }

    @Override // org.msgpack.value.Value
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Value)) {
            return false;
        }
        Value value = (Value) obj;
        if (!value.isExtensionValue()) {
            return false;
        }
        ExtensionValue asExtensionValue = value.asExtensionValue();
        return this.type == asExtensionValue.getType() && Arrays.equals(this.data, asExtensionValue.getData());
    }

    public int hashCode() {
        int i = this.type + 31;
        for (byte b : this.data) {
            i = (i * 31) + b;
        }
        return i;
    }

    @Override // org.msgpack.value.Value
    public String toJson() {
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        sb.append(Byte.toString(this.type));
        sb.append(",\"");
        for (byte b : this.data) {
            sb.append(Integer.toString(b, 16));
        }
        sb.append("\"]");
        return sb.toString();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append('(');
        sb.append(Byte.toString(this.type));
        sb.append(",0x");
        for (byte b : this.data) {
            sb.append(Integer.toString(b, 16));
        }
        sb.append(")");
        return sb.toString();
    }
}
