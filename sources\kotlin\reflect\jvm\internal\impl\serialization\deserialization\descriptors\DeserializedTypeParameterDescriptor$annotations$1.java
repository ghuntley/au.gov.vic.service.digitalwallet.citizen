package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;

/* access modifiers changed from: package-private */
/* compiled from: DeserializedTypeParameterDescriptor.kt */
public final class DeserializedTypeParameterDescriptor$annotations$1 extends Lambda implements Function0<List<? extends AnnotationDescriptor>> {
    final /* synthetic */ DeserializedTypeParameterDescriptor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DeserializedTypeParameterDescriptor$annotations$1(DeserializedTypeParameterDescriptor deserializedTypeParameterDescriptor) {
        super(0);
        this.this$0 = deserializedTypeParameterDescriptor;
    }

    /* Return type fixed from 'java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor>' to match base method */
    @Override // kotlin.jvm.functions.Function0
    public final List<? extends AnnotationDescriptor> invoke() {
        return CollectionsKt.toList(this.this$0.c.getComponents().getAnnotationAndConstantLoader().loadTypeParameterAnnotations(this.this$0.getProto(), this.this$0.c.getNameResolver()));
    }
}
