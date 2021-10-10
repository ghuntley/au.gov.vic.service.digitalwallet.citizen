package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;

/* access modifiers changed from: package-private */
/* compiled from: TypeAliasConstructorDescriptor.kt */
public final class TypeAliasConstructorDescriptorImpl$withDispatchReceiver$2 extends Lambda implements Function0<TypeAliasConstructorDescriptorImpl> {
    final /* synthetic */ ClassConstructorDescriptor $underlyingConstructorDescriptor;
    final /* synthetic */ TypeAliasConstructorDescriptorImpl this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TypeAliasConstructorDescriptorImpl$withDispatchReceiver$2(TypeAliasConstructorDescriptorImpl typeAliasConstructorDescriptorImpl, ClassConstructorDescriptor classConstructorDescriptor) {
        super(0);
        this.this$0 = typeAliasConstructorDescriptorImpl;
        this.$underlyingConstructorDescriptor = classConstructorDescriptor;
    }

    @Override // kotlin.jvm.functions.Function0
    public final TypeAliasConstructorDescriptorImpl invoke() {
        StorageManager storageManager = this.this$0.getStorageManager();
        TypeAliasDescriptor typeAliasDescriptor = this.this$0.getTypeAliasDescriptor();
        ClassConstructorDescriptor classConstructorDescriptor = this.$underlyingConstructorDescriptor;
        TypeAliasConstructorDescriptorImpl typeAliasConstructorDescriptorImpl = this.this$0;
        Annotations annotations = classConstructorDescriptor.getAnnotations();
        CallableMemberDescriptor.Kind kind = this.$underlyingConstructorDescriptor.getKind();
        Intrinsics.checkNotNullExpressionValue(kind, "underlyingConstructorDescriptor.kind");
        SourceElement source = this.this$0.getTypeAliasDescriptor().getSource();
        Intrinsics.checkNotNullExpressionValue(source, "typeAliasDescriptor.source");
        TypeAliasConstructorDescriptorImpl typeAliasConstructorDescriptorImpl2 = new TypeAliasConstructorDescriptorImpl(storageManager, typeAliasDescriptor, classConstructorDescriptor, typeAliasConstructorDescriptorImpl, annotations, kind, source, null);
        TypeSubstitutor typeSubstitutor = TypeAliasConstructorDescriptorImpl.Companion.getTypeSubstitutorForUnderlyingClass(this.this$0.getTypeAliasDescriptor());
        if (typeSubstitutor == null) {
            return null;
        }
        ReceiverParameterDescriptor dispatchReceiverParameter = this.$underlyingConstructorDescriptor.getDispatchReceiverParameter();
        typeAliasConstructorDescriptorImpl2.initialize(null, dispatchReceiverParameter != null ? dispatchReceiverParameter.substitute(typeSubstitutor) : null, this.this$0.getTypeAliasDescriptor().getDeclaredTypeParameters(), this.this$0.getValueParameters(), this.this$0.getReturnType(), Modality.FINAL, this.this$0.getTypeAliasDescriptor().getVisibility());
        return typeAliasConstructorDescriptorImpl2;
    }
}
