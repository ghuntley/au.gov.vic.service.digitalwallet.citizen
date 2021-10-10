package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;

/* access modifiers changed from: package-private */
/* compiled from: TypeDeserializer.kt */
public final class TypeDeserializer$typeAliasDescriptors$1 extends Lambda implements Function1<Integer, ClassifierDescriptor> {
    final /* synthetic */ TypeDeserializer this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TypeDeserializer$typeAliasDescriptors$1(TypeDeserializer typeDeserializer) {
        super(1);
        this.this$0 = typeDeserializer;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ ClassifierDescriptor invoke(Integer num) {
        return invoke(num.intValue());
    }

    public final ClassifierDescriptor invoke(int i) {
        return this.this$0.computeTypeAliasDescriptor(i);
    }
}
