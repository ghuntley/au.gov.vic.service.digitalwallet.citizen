package org.msgpack.value;

public interface ImmutableValue extends Value {
    @Override // org.msgpack.value.Value
    ImmutableArrayValue asArrayValue();

    @Override // org.msgpack.value.Value
    ImmutableBinaryValue asBinaryValue();

    @Override // org.msgpack.value.Value
    ImmutableBooleanValue asBooleanValue();

    @Override // org.msgpack.value.Value
    ImmutableFloatValue asFloatValue();

    @Override // org.msgpack.value.Value
    ImmutableIntegerValue asIntegerValue();

    @Override // org.msgpack.value.Value
    ImmutableMapValue asMapValue();

    @Override // org.msgpack.value.Value
    ImmutableNilValue asNilValue();

    @Override // org.msgpack.value.Value
    ImmutableRawValue asRawValue();

    @Override // org.msgpack.value.Value
    ImmutableStringValue asStringValue();
}
