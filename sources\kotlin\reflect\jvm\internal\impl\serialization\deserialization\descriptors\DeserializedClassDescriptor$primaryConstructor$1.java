package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;

/* access modifiers changed from: package-private */
/* compiled from: DeserializedClassDescriptor.kt */
public final class DeserializedClassDescriptor$primaryConstructor$1 extends Lambda implements Function0<ClassConstructorDescriptor> {
    final /* synthetic */ DeserializedClassDescriptor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DeserializedClassDescriptor$primaryConstructor$1(DeserializedClassDescriptor deserializedClassDescriptor) {
        super(0);
        this.this$0 = deserializedClassDescriptor;
    }

    @Override // kotlin.jvm.functions.Function0
    public final ClassConstructorDescriptor invoke() {
        return this.this$0.computePrimaryConstructor();
    }
}
