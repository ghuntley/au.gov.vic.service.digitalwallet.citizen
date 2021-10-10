package kotlin.reflect.jvm.internal.impl.descriptors;

import kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ReceiverValue;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;

public interface ReceiverParameterDescriptor extends ParameterDescriptor {
    ReceiverValue getValue();

    /* Return type fixed from 'kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor' to match base method */
    @Override // kotlin.reflect.jvm.internal.impl.descriptors.Substitutable
    CallableDescriptor substitute(TypeSubstitutor typeSubstitutor);
}
