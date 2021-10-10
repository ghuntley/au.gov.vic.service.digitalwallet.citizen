package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;

/* compiled from: FlexibleTypeDeserializer.kt */
public interface FlexibleTypeDeserializer {
    KotlinType create(ProtoBuf.Type type, String str, SimpleType simpleType, SimpleType simpleType2);

    /* compiled from: FlexibleTypeDeserializer.kt */
    public static final class ThrowException implements FlexibleTypeDeserializer {
        public static final ThrowException INSTANCE = new ThrowException();

        private ThrowException() {
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.FlexibleTypeDeserializer
        public KotlinType create(ProtoBuf.Type type, String str, SimpleType simpleType, SimpleType simpleType2) {
            Intrinsics.checkNotNullParameter(type, "proto");
            Intrinsics.checkNotNullParameter(str, "flexibleId");
            Intrinsics.checkNotNullParameter(simpleType, "lowerBound");
            Intrinsics.checkNotNullParameter(simpleType2, "upperBound");
            throw new IllegalArgumentException("This method should not be used.");
        }
    }
}
