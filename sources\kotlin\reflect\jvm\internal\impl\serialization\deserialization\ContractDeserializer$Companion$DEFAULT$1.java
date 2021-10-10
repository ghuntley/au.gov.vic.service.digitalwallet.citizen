package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.TypeTable;

/* compiled from: ContractDeserializer.kt */
public final class ContractDeserializer$Companion$DEFAULT$1 implements ContractDeserializer {
    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.ContractDeserializer
    public Pair deserializeContractFromFunction(ProtoBuf.Function function, FunctionDescriptor functionDescriptor, TypeTable typeTable, TypeDeserializer typeDeserializer) {
        Intrinsics.checkNotNullParameter(function, "proto");
        Intrinsics.checkNotNullParameter(functionDescriptor, "ownerFunction");
        Intrinsics.checkNotNullParameter(typeTable, "typeTable");
        Intrinsics.checkNotNullParameter(typeDeserializer, "typeDeserializer");
        return null;
    }

    ContractDeserializer$Companion$DEFAULT$1() {
    }
}
