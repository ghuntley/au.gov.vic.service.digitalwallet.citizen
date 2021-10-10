package kotlin.reflect.jvm.internal.impl.descriptors;

import java.util.Collection;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;

public interface PropertyDescriptor extends CallableMemberDescriptor, VariableDescriptorWithAccessors {
    List<PropertyAccessorDescriptor> getAccessors();

    FieldDescriptor getBackingField();

    FieldDescriptor getDelegateField();

    PropertyGetterDescriptor getGetter();

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    PropertyDescriptor getOriginal();

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor
    Collection<? extends PropertyDescriptor> getOverriddenDescriptors();

    PropertySetterDescriptor getSetter();

    /* Return type fixed from 'kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor' to match base method */
    @Override // kotlin.reflect.jvm.internal.impl.descriptors.Substitutable
    CallableDescriptor substitute(TypeSubstitutor typeSubstitutor);
}
