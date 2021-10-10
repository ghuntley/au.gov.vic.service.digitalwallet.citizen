package org.msgpack.value.impl;

import org.msgpack.core.MessageTypeCastException;
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
import org.msgpack.value.ImmutableValue;

/* access modifiers changed from: package-private */
public abstract class AbstractImmutableValue implements ImmutableValue {
    AbstractImmutableValue() {
    }

    @Override // org.msgpack.value.Value
    public boolean isNilValue() {
        return getValueType().isNilType();
    }

    @Override // org.msgpack.value.Value
    public boolean isBooleanValue() {
        return getValueType().isBooleanType();
    }

    @Override // org.msgpack.value.Value
    public boolean isNumberValue() {
        return getValueType().isNumberType();
    }

    @Override // org.msgpack.value.Value
    public boolean isIntegerValue() {
        return getValueType().isIntegerType();
    }

    @Override // org.msgpack.value.Value
    public boolean isFloatValue() {
        return getValueType().isFloatType();
    }

    @Override // org.msgpack.value.Value
    public boolean isRawValue() {
        return getValueType().isRawType();
    }

    @Override // org.msgpack.value.Value
    public boolean isBinaryValue() {
        return getValueType().isBinaryType();
    }

    @Override // org.msgpack.value.Value
    public boolean isStringValue() {
        return getValueType().isStringType();
    }

    @Override // org.msgpack.value.Value
    public boolean isArrayValue() {
        return getValueType().isArrayType();
    }

    @Override // org.msgpack.value.Value
    public boolean isMapValue() {
        return getValueType().isMapType();
    }

    @Override // org.msgpack.value.Value
    public boolean isExtensionValue() {
        return getValueType().isExtensionType();
    }

    @Override // org.msgpack.value.Value, org.msgpack.value.ImmutableValue
    public ImmutableNilValue asNilValue() {
        throw new MessageTypeCastException();
    }

    @Override // org.msgpack.value.Value, org.msgpack.value.ImmutableValue
    public ImmutableBooleanValue asBooleanValue() {
        throw new MessageTypeCastException();
    }

    @Override // org.msgpack.value.Value
    public ImmutableNumberValue asNumberValue() {
        throw new MessageTypeCastException();
    }

    @Override // org.msgpack.value.Value, org.msgpack.value.ImmutableValue
    public ImmutableIntegerValue asIntegerValue() {
        throw new MessageTypeCastException();
    }

    @Override // org.msgpack.value.Value, org.msgpack.value.ImmutableValue
    public ImmutableFloatValue asFloatValue() {
        throw new MessageTypeCastException();
    }

    @Override // org.msgpack.value.Value, org.msgpack.value.ImmutableValue
    public ImmutableRawValue asRawValue() {
        throw new MessageTypeCastException();
    }

    @Override // org.msgpack.value.Value, org.msgpack.value.ImmutableValue
    public ImmutableBinaryValue asBinaryValue() {
        throw new MessageTypeCastException();
    }

    @Override // org.msgpack.value.Value, org.msgpack.value.ImmutableValue
    public ImmutableStringValue asStringValue() {
        throw new MessageTypeCastException();
    }

    @Override // org.msgpack.value.Value, org.msgpack.value.ImmutableValue
    public ImmutableArrayValue asArrayValue() {
        throw new MessageTypeCastException();
    }

    @Override // org.msgpack.value.Value, org.msgpack.value.ImmutableValue
    public ImmutableMapValue asMapValue() {
        throw new MessageTypeCastException();
    }

    @Override // org.msgpack.value.Value
    public ImmutableExtensionValue asExtensionValue() {
        throw new MessageTypeCastException();
    }
}
