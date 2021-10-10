package kotlin.reflect.jvm.internal.impl.descriptors;

import java.util.Collection;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;

/* compiled from: ValueParameterDescriptor.kt */
public interface ValueParameterDescriptor extends ParameterDescriptor, VariableDescriptor {

    /* compiled from: ValueParameterDescriptor.kt */
    public static final class DefaultImpls {
        public static boolean isLateInit(ValueParameterDescriptor valueParameterDescriptor) {
            return false;
        }
    }

    ValueParameterDescriptor copy(CallableDescriptor callableDescriptor, Name name, int i);

    boolean declaresDefaultValue();

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorNonRoot, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.ValueDescriptor
    CallableDescriptor getContainingDeclaration();

    int getIndex();

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    ValueParameterDescriptor getOriginal();

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor
    Collection<ValueParameterDescriptor> getOverriddenDescriptors();

    KotlinType getVarargElementType();

    boolean isCrossinline();

    boolean isNoinline();
}
