package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.FunctionTypesKt;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibility;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.FieldDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertyGetterDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertySetterDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ValueParameterDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.ProtoTypeTableUtilKt;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.VersionRequirement;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.VersionRequirementTable;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorFactory;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ProtoContainer;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedAnnotations;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedCallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedPropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedSimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedTypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.NonEmptyDeserializedAnnotations;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;

/* compiled from: MemberDeserializer.kt */
public final class MemberDeserializer {
    private final AnnotationDeserializer annotationDeserializer;
    private final DeserializationContext c;

    private final int loadOldFlags(int i) {
        return (i & 63) + ((i >> 8) << 6);
    }

    public MemberDeserializer(DeserializationContext deserializationContext) {
        Intrinsics.checkNotNullParameter(deserializationContext, "c");
        this.c = deserializationContext;
        this.annotationDeserializer = new AnnotationDeserializer(deserializationContext.getComponents().getModuleDescriptor(), deserializationContext.getComponents().getNotFoundClasses());
    }

    public final PropertyDescriptor loadProperty(ProtoBuf.Property property) {
        ProtoBuf.Property property2;
        Annotations annotations;
        PropertyGetterDescriptorImpl propertyGetterDescriptorImpl;
        PropertyGetterDescriptorImpl propertyGetterDescriptorImpl2;
        boolean z;
        PropertyGetterDescriptorImpl propertyGetterDescriptorImpl3;
        KotlinType type;
        Intrinsics.checkNotNullParameter(property, "proto");
        int flags = property.hasFlags() ? property.getFlags() : loadOldFlags(property.getOldFlags());
        DeclarationDescriptor containingDeclaration = this.c.getContainingDeclaration();
        ProtoBuf.Property property3 = property;
        Annotations annotations2 = getAnnotations(property3, flags, AnnotatedCallableKind.PROPERTY);
        Modality modality = ProtoEnumFlags.INSTANCE.modality(Flags.MODALITY.get(flags));
        Visibility visibility = ProtoEnumFlags.INSTANCE.visibility(Flags.VISIBILITY.get(flags));
        Boolean bool = Flags.IS_VAR.get(flags);
        Intrinsics.checkNotNullExpressionValue(bool, "Flags.IS_VAR.get(flags)");
        boolean booleanValue = bool.booleanValue();
        Name name = NameResolverUtilKt.getName(this.c.getNameResolver(), property.getName());
        CallableMemberDescriptor.Kind memberKind = ProtoEnumFlags.INSTANCE.memberKind(Flags.MEMBER_KIND.get(flags));
        Boolean bool2 = Flags.IS_LATEINIT.get(flags);
        Intrinsics.checkNotNullExpressionValue(bool2, "Flags.IS_LATEINIT.get(flags)");
        boolean booleanValue2 = bool2.booleanValue();
        Boolean bool3 = Flags.IS_CONST.get(flags);
        Intrinsics.checkNotNullExpressionValue(bool3, "Flags.IS_CONST.get(flags)");
        boolean booleanValue3 = bool3.booleanValue();
        Boolean bool4 = Flags.IS_EXTERNAL_PROPERTY.get(flags);
        Intrinsics.checkNotNullExpressionValue(bool4, "Flags.IS_EXTERNAL_PROPERTY.get(flags)");
        boolean booleanValue4 = bool4.booleanValue();
        Boolean bool5 = Flags.IS_DELEGATED.get(flags);
        Intrinsics.checkNotNullExpressionValue(bool5, "Flags.IS_DELEGATED.get(flags)");
        boolean booleanValue5 = bool5.booleanValue();
        Boolean bool6 = Flags.IS_EXPECT_PROPERTY.get(flags);
        Intrinsics.checkNotNullExpressionValue(bool6, "Flags.IS_EXPECT_PROPERTY.get(flags)");
        DeserializedPropertyDescriptor deserializedPropertyDescriptor = new DeserializedPropertyDescriptor(containingDeclaration, null, annotations2, modality, visibility, booleanValue, name, memberKind, booleanValue2, booleanValue3, booleanValue4, booleanValue5, bool6.booleanValue(), property, this.c.getNameResolver(), this.c.getTypeTable(), this.c.getVersionRequirementTable(), this.c.getContainerSource());
        List<ProtoBuf.TypeParameter> typeParameterList = property.getTypeParameterList();
        Intrinsics.checkNotNullExpressionValue(typeParameterList, "proto.typeParameterList");
        DeserializationContext childContext$default = DeserializationContext.childContext$default(this.c, deserializedPropertyDescriptor, typeParameterList, null, null, null, null, 60, null);
        Boolean bool7 = Flags.HAS_GETTER.get(flags);
        Intrinsics.checkNotNullExpressionValue(bool7, "Flags.HAS_GETTER.get(flags)");
        boolean booleanValue6 = bool7.booleanValue();
        if (!booleanValue6 || !ProtoTypeTableUtilKt.hasReceiver(property)) {
            property2 = property3;
            annotations = Annotations.Companion.getEMPTY();
        } else {
            property2 = property3;
            annotations = getReceiverParameterAnnotations(property2, AnnotatedCallableKind.PROPERTY_GETTER);
        }
        KotlinType type2 = childContext$default.getTypeDeserializer().type(ProtoTypeTableUtilKt.returnType(property, this.c.getTypeTable()));
        List<TypeParameterDescriptor> ownTypeParameters = childContext$default.getTypeDeserializer().getOwnTypeParameters();
        ReceiverParameterDescriptor dispatchReceiverParameter = getDispatchReceiverParameter();
        ProtoBuf.Type receiverType = ProtoTypeTableUtilKt.receiverType(property, this.c.getTypeTable());
        PropertySetterDescriptorImpl propertySetterDescriptorImpl = null;
        deserializedPropertyDescriptor.setType(type2, ownTypeParameters, dispatchReceiverParameter, (receiverType == null || (type = childContext$default.getTypeDeserializer().type(receiverType)) == null) ? null : DescriptorFactory.createExtensionReceiverParameterForCallable(deserializedPropertyDescriptor, type, annotations));
        Boolean bool8 = Flags.HAS_ANNOTATIONS.get(flags);
        Intrinsics.checkNotNullExpressionValue(bool8, "Flags.HAS_ANNOTATIONS.get(flags)");
        int accessorFlags = Flags.getAccessorFlags(bool8.booleanValue(), Flags.VISIBILITY.get(flags), Flags.MODALITY.get(flags), false, false, false);
        if (booleanValue6) {
            int getterFlags = property.hasGetterFlags() ? property.getGetterFlags() : accessorFlags;
            Boolean bool9 = Flags.IS_NOT_DEFAULT.get(getterFlags);
            Intrinsics.checkNotNullExpressionValue(bool9, "Flags.IS_NOT_DEFAULT.get(getterFlags)");
            boolean booleanValue7 = bool9.booleanValue();
            Boolean bool10 = Flags.IS_EXTERNAL_ACCESSOR.get(getterFlags);
            Intrinsics.checkNotNullExpressionValue(bool10, "Flags.IS_EXTERNAL_ACCESSOR.get(getterFlags)");
            boolean booleanValue8 = bool10.booleanValue();
            Boolean bool11 = Flags.IS_INLINE_ACCESSOR.get(getterFlags);
            Intrinsics.checkNotNullExpressionValue(bool11, "Flags.IS_INLINE_ACCESSOR.get(getterFlags)");
            boolean booleanValue9 = bool11.booleanValue();
            Annotations annotations3 = getAnnotations(property2, getterFlags, AnnotatedCallableKind.PROPERTY_GETTER);
            if (booleanValue7) {
                propertyGetterDescriptorImpl3 = new PropertyGetterDescriptorImpl(deserializedPropertyDescriptor, annotations3, ProtoEnumFlags.INSTANCE.modality(Flags.MODALITY.get(getterFlags)), ProtoEnumFlags.INSTANCE.visibility(Flags.VISIBILITY.get(getterFlags)), !booleanValue7, booleanValue8, booleanValue9, deserializedPropertyDescriptor.getKind(), null, SourceElement.NO_SOURCE);
            } else {
                propertyGetterDescriptorImpl3 = DescriptorFactory.createDefaultGetter(deserializedPropertyDescriptor, annotations3);
                Intrinsics.checkNotNullExpressionValue(propertyGetterDescriptorImpl3, "DescriptorFactory.create…er(property, annotations)");
            }
            propertyGetterDescriptorImpl3.initialize(deserializedPropertyDescriptor.getReturnType());
            propertyGetterDescriptorImpl = propertyGetterDescriptorImpl3;
        } else {
            propertyGetterDescriptorImpl = null;
        }
        Boolean bool12 = Flags.HAS_SETTER.get(flags);
        Intrinsics.checkNotNullExpressionValue(bool12, "Flags.HAS_SETTER.get(flags)");
        if (bool12.booleanValue()) {
            if (property.hasSetterFlags()) {
                accessorFlags = property.getSetterFlags();
            }
            Boolean bool13 = Flags.IS_NOT_DEFAULT.get(accessorFlags);
            Intrinsics.checkNotNullExpressionValue(bool13, "Flags.IS_NOT_DEFAULT.get(setterFlags)");
            boolean booleanValue10 = bool13.booleanValue();
            Boolean bool14 = Flags.IS_EXTERNAL_ACCESSOR.get(accessorFlags);
            Intrinsics.checkNotNullExpressionValue(bool14, "Flags.IS_EXTERNAL_ACCESSOR.get(setterFlags)");
            boolean booleanValue11 = bool14.booleanValue();
            Boolean bool15 = Flags.IS_INLINE_ACCESSOR.get(accessorFlags);
            Intrinsics.checkNotNullExpressionValue(bool15, "Flags.IS_INLINE_ACCESSOR.get(setterFlags)");
            boolean booleanValue12 = bool15.booleanValue();
            Annotations annotations4 = getAnnotations(property2, accessorFlags, AnnotatedCallableKind.PROPERTY_SETTER);
            if (booleanValue10) {
                PropertySetterDescriptorImpl propertySetterDescriptorImpl2 = new PropertySetterDescriptorImpl(deserializedPropertyDescriptor, annotations4, ProtoEnumFlags.INSTANCE.modality(Flags.MODALITY.get(accessorFlags)), ProtoEnumFlags.INSTANCE.visibility(Flags.VISIBILITY.get(accessorFlags)), !booleanValue10, booleanValue11, booleanValue12, deserializedPropertyDescriptor.getKind(), null, SourceElement.NO_SOURCE);
                propertyGetterDescriptorImpl2 = propertyGetterDescriptorImpl;
                z = true;
                propertySetterDescriptorImpl2.initialize((ValueParameterDescriptor) CollectionsKt.single((List) DeserializationContext.childContext$default(childContext$default, propertySetterDescriptorImpl2, CollectionsKt.emptyList(), null, null, null, null, 60, null).getMemberDeserializer().valueParameters(CollectionsKt.listOf(property.getSetterValueParameter()), property2, AnnotatedCallableKind.PROPERTY_SETTER)));
                propertySetterDescriptorImpl = propertySetterDescriptorImpl2;
            } else {
                propertyGetterDescriptorImpl2 = propertyGetterDescriptorImpl;
                z = true;
                propertySetterDescriptorImpl = DescriptorFactory.createDefaultSetter(deserializedPropertyDescriptor, annotations4, Annotations.Companion.getEMPTY());
                Intrinsics.checkNotNullExpressionValue(propertySetterDescriptorImpl, "DescriptorFactory.create…ptor */\n                )");
            }
        } else {
            propertyGetterDescriptorImpl2 = propertyGetterDescriptorImpl;
            z = true;
        }
        Boolean bool16 = Flags.HAS_CONSTANT.get(flags);
        Intrinsics.checkNotNullExpressionValue(bool16, "Flags.HAS_CONSTANT.get(flags)");
        if (bool16.booleanValue()) {
            deserializedPropertyDescriptor.setCompileTimeInitializer(this.c.getStorageManager().createNullableLazyValue(new MemberDeserializer$loadProperty$3(this, property, deserializedPropertyDescriptor)));
        }
        DeserializedPropertyDescriptor deserializedPropertyDescriptor2 = deserializedPropertyDescriptor;
        deserializedPropertyDescriptor.initialize(propertyGetterDescriptorImpl2, propertySetterDescriptorImpl, new FieldDescriptorImpl(getPropertyFieldAnnotations(property, false), deserializedPropertyDescriptor2), new FieldDescriptorImpl(getPropertyFieldAnnotations(property, z), deserializedPropertyDescriptor2), checkExperimentalCoroutine(deserializedPropertyDescriptor, childContext$default.getTypeDeserializer()));
        return deserializedPropertyDescriptor2;
    }

    private final DeserializedMemberDescriptor.CoroutinesCompatibilityMode checkExperimentalCoroutine(DeserializedMemberDescriptor deserializedMemberDescriptor, TypeDeserializer typeDeserializer) {
        if (!versionAndReleaseCoroutinesMismatch(deserializedMemberDescriptor)) {
            return DeserializedMemberDescriptor.CoroutinesCompatibilityMode.COMPATIBLE;
        }
        forceUpperBoundsComputation(typeDeserializer);
        if (typeDeserializer.getExperimentalSuspendFunctionTypeEncountered()) {
            return DeserializedMemberDescriptor.CoroutinesCompatibilityMode.INCOMPATIBLE;
        }
        return DeserializedMemberDescriptor.CoroutinesCompatibilityMode.COMPATIBLE;
    }

    private final void forceUpperBoundsComputation(TypeDeserializer typeDeserializer) {
        Iterator<T> it = typeDeserializer.getOwnTypeParameters().iterator();
        while (it.hasNext()) {
            it.next().getUpperBounds();
        }
    }

    private final void initializeWithCoroutinesExperimentalityStatus(DeserializedSimpleFunctionDescriptor deserializedSimpleFunctionDescriptor, ReceiverParameterDescriptor receiverParameterDescriptor, ReceiverParameterDescriptor receiverParameterDescriptor2, List<? extends TypeParameterDescriptor> list, List<? extends ValueParameterDescriptor> list2, KotlinType kotlinType, Modality modality, Visibility visibility, Map<? extends CallableDescriptor.UserDataKey<?>, ?> map, boolean z) {
        deserializedSimpleFunctionDescriptor.initialize(receiverParameterDescriptor, receiverParameterDescriptor2, list, list2, kotlinType, modality, visibility, map, computeExperimentalityModeForFunctions(deserializedSimpleFunctionDescriptor, receiverParameterDescriptor, list2, list, kotlinType, z));
    }

    /* JADX WARNING: Removed duplicated region for block: B:44:0x00c3  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00c6  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x0130  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x0133  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x00c0 A[SYNTHETIC] */
    private final DeserializedMemberDescriptor.CoroutinesCompatibilityMode computeExperimentalityModeForFunctions(DeserializedCallableMemberDescriptor deserializedCallableMemberDescriptor, ReceiverParameterDescriptor receiverParameterDescriptor, Collection<? extends ValueParameterDescriptor> collection, Collection<? extends TypeParameterDescriptor> collection2, KotlinType kotlinType, boolean z) {
        boolean z2;
        DeserializedMemberDescriptor.CoroutinesCompatibilityMode coroutinesCompatibilityMode;
        DeserializedMemberDescriptor.CoroutinesCompatibilityMode coroutinesCompatibilityMode2;
        boolean z3;
        boolean z4;
        if (!versionAndReleaseCoroutinesMismatch(deserializedCallableMemberDescriptor)) {
            return DeserializedMemberDescriptor.CoroutinesCompatibilityMode.COMPATIBLE;
        }
        if (Intrinsics.areEqual(DescriptorUtilsKt.fqNameOrNull(deserializedCallableMemberDescriptor), SuspendFunctionTypeUtilKt.KOTLIN_SUSPEND_BUILT_IN_FUNCTION_FQ_NAME)) {
            return DeserializedMemberDescriptor.CoroutinesCompatibilityMode.COMPATIBLE;
        }
        Collection<? extends ValueParameterDescriptor> collection3 = collection;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(collection3, 10));
        Iterator<T> it = collection3.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().getType());
        }
        List plus = CollectionsKt.plus((Collection) arrayList, (Iterable) CollectionsKt.listOfNotNull(receiverParameterDescriptor != null ? receiverParameterDescriptor.getType() : null));
        if (kotlinType != null && containsSuspendFunctionType(kotlinType)) {
            return DeserializedMemberDescriptor.CoroutinesCompatibilityMode.INCOMPATIBLE;
        }
        Collection<? extends TypeParameterDescriptor> collection4 = collection2;
        if (!(collection4 instanceof Collection) || !collection4.isEmpty()) {
            Iterator<T> it2 = collection4.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                List<KotlinType> upperBounds = it2.next().getUpperBounds();
                Intrinsics.checkNotNullExpressionValue(upperBounds, "typeParameter.upperBounds");
                List<KotlinType> list = upperBounds;
                if (!(list instanceof Collection) || !list.isEmpty()) {
                    Iterator<T> it3 = list.iterator();
                    while (true) {
                        if (!it3.hasNext()) {
                            break;
                        }
                        T next = it3.next();
                        Intrinsics.checkNotNullExpressionValue(next, "it");
                        if (containsSuspendFunctionType(next)) {
                            z4 = true;
                            continue;
                            break;
                        }
                    }
                    if (z4) {
                        z2 = true;
                        break;
                    }
                }
                z4 = false;
                continue;
                if (z4) {
                }
            }
            if (!z2) {
                return DeserializedMemberDescriptor.CoroutinesCompatibilityMode.INCOMPATIBLE;
            }
            List<KotlinType> list2 = plus;
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
            for (KotlinType kotlinType2 : list2) {
                Intrinsics.checkNotNullExpressionValue(kotlinType2, "type");
                if (FunctionTypesKt.isSuspendFunctionType(kotlinType2) && kotlinType2.getArguments().size() <= 3) {
                    List<TypeProjection> arguments = kotlinType2.getArguments();
                    if (!(arguments instanceof Collection) || !arguments.isEmpty()) {
                        Iterator<T> it4 = arguments.iterator();
                        while (true) {
                            if (!it4.hasNext()) {
                                break;
                            }
                            KotlinType type = it4.next().getType();
                            Intrinsics.checkNotNullExpressionValue(type, "it.type");
                            if (containsSuspendFunctionType(type)) {
                                z3 = true;
                                break;
                            }
                        }
                        if (!z3) {
                            coroutinesCompatibilityMode2 = DeserializedMemberDescriptor.CoroutinesCompatibilityMode.INCOMPATIBLE;
                        } else {
                            coroutinesCompatibilityMode2 = DeserializedMemberDescriptor.CoroutinesCompatibilityMode.NEEDS_WRAPPER;
                        }
                    }
                    z3 = false;
                    if (!z3) {
                    }
                } else if (containsSuspendFunctionType(kotlinType2)) {
                    coroutinesCompatibilityMode2 = DeserializedMemberDescriptor.CoroutinesCompatibilityMode.INCOMPATIBLE;
                } else {
                    coroutinesCompatibilityMode2 = DeserializedMemberDescriptor.CoroutinesCompatibilityMode.COMPATIBLE;
                }
                arrayList2.add(coroutinesCompatibilityMode2);
            }
            DeserializedMemberDescriptor.CoroutinesCompatibilityMode coroutinesCompatibilityMode3 = (DeserializedMemberDescriptor.CoroutinesCompatibilityMode) CollectionsKt.max((Iterable) arrayList2);
            if (coroutinesCompatibilityMode3 == null) {
                coroutinesCompatibilityMode3 = DeserializedMemberDescriptor.CoroutinesCompatibilityMode.COMPATIBLE;
            }
            if (z) {
                coroutinesCompatibilityMode = DeserializedMemberDescriptor.CoroutinesCompatibilityMode.NEEDS_WRAPPER;
            } else {
                coroutinesCompatibilityMode = DeserializedMemberDescriptor.CoroutinesCompatibilityMode.COMPATIBLE;
            }
            return (DeserializedMemberDescriptor.CoroutinesCompatibilityMode) ComparisonsKt.maxOf(coroutinesCompatibilityMode, coroutinesCompatibilityMode3);
        }
        z2 = false;
        if (!z2) {
        }
    }

    private final boolean containsSuspendFunctionType(KotlinType kotlinType) {
        return TypeUtilsKt.contains(kotlinType, MemberDeserializer$containsSuspendFunctionType$1.INSTANCE);
    }

    private final boolean versionAndReleaseCoroutinesMismatch(DeserializedMemberDescriptor deserializedMemberDescriptor) {
        boolean z;
        boolean z2;
        if (!this.c.getComponents().getConfiguration().getReleaseCoroutines()) {
            return false;
        }
        List<VersionRequirement> versionRequirements = deserializedMemberDescriptor.getVersionRequirements();
        if (!(versionRequirements instanceof Collection) || !versionRequirements.isEmpty()) {
            Iterator<T> it = versionRequirements.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                T next = it.next();
                if (!Intrinsics.areEqual(next.getVersion(), new VersionRequirement.Version(1, 3, 0, 4, null)) || next.getKind() != ProtoBuf.VersionRequirement.VersionKind.LANGUAGE_VERSION) {
                    z2 = false;
                    continue;
                } else {
                    z2 = true;
                    continue;
                }
                if (z2) {
                    z = false;
                    break;
                }
            }
        }
        z = true;
        return z;
    }

    public final SimpleFunctionDescriptor loadFunction(ProtoBuf.Function function) {
        Annotations annotations;
        VersionRequirementTable versionRequirementTable;
        KotlinType type;
        Intrinsics.checkNotNullParameter(function, "proto");
        int flags = function.hasFlags() ? function.getFlags() : loadOldFlags(function.getOldFlags());
        ProtoBuf.Function function2 = function;
        Annotations annotations2 = getAnnotations(function2, flags, AnnotatedCallableKind.FUNCTION);
        if (ProtoTypeTableUtilKt.hasReceiver(function)) {
            annotations = getReceiverParameterAnnotations(function2, AnnotatedCallableKind.FUNCTION);
        } else {
            annotations = Annotations.Companion.getEMPTY();
        }
        if (Intrinsics.areEqual(DescriptorUtilsKt.getFqNameSafe(this.c.getContainingDeclaration()).child(NameResolverUtilKt.getName(this.c.getNameResolver(), function.getName())), SuspendFunctionTypeUtilKt.KOTLIN_SUSPEND_BUILT_IN_FUNCTION_FQ_NAME)) {
            versionRequirementTable = VersionRequirementTable.Companion.getEMPTY();
        } else {
            versionRequirementTable = this.c.getVersionRequirementTable();
        }
        DeserializedSimpleFunctionDescriptor deserializedSimpleFunctionDescriptor = new DeserializedSimpleFunctionDescriptor(this.c.getContainingDeclaration(), null, annotations2, NameResolverUtilKt.getName(this.c.getNameResolver(), function.getName()), ProtoEnumFlags.INSTANCE.memberKind(Flags.MEMBER_KIND.get(flags)), function, this.c.getNameResolver(), this.c.getTypeTable(), versionRequirementTable, this.c.getContainerSource(), null, 1024, null);
        List<ProtoBuf.TypeParameter> typeParameterList = function.getTypeParameterList();
        Intrinsics.checkNotNullExpressionValue(typeParameterList, "proto.typeParameterList");
        DeserializationContext childContext$default = DeserializationContext.childContext$default(this.c, deserializedSimpleFunctionDescriptor, typeParameterList, null, null, null, null, 60, null);
        ProtoBuf.Type receiverType = ProtoTypeTableUtilKt.receiverType(function, this.c.getTypeTable());
        ReceiverParameterDescriptor createExtensionReceiverParameterForCallable = (receiverType == null || (type = childContext$default.getTypeDeserializer().type(receiverType)) == null) ? null : DescriptorFactory.createExtensionReceiverParameterForCallable(deserializedSimpleFunctionDescriptor, type, annotations);
        ReceiverParameterDescriptor dispatchReceiverParameter = getDispatchReceiverParameter();
        List<TypeParameterDescriptor> ownTypeParameters = childContext$default.getTypeDeserializer().getOwnTypeParameters();
        MemberDeserializer memberDeserializer = childContext$default.getMemberDeserializer();
        List<ProtoBuf.ValueParameter> valueParameterList = function.getValueParameterList();
        Intrinsics.checkNotNullExpressionValue(valueParameterList, "proto.valueParameterList");
        List<ValueParameterDescriptor> valueParameters = memberDeserializer.valueParameters(valueParameterList, function2, AnnotatedCallableKind.FUNCTION);
        KotlinType type2 = childContext$default.getTypeDeserializer().type(ProtoTypeTableUtilKt.returnType(function, this.c.getTypeTable()));
        Modality modality = ProtoEnumFlags.INSTANCE.modality(Flags.MODALITY.get(flags));
        Visibility visibility = ProtoEnumFlags.INSTANCE.visibility(Flags.VISIBILITY.get(flags));
        Map<? extends CallableDescriptor.UserDataKey<?>, ?> emptyMap = MapsKt.emptyMap();
        Boolean bool = Flags.IS_SUSPEND.get(flags);
        Intrinsics.checkNotNullExpressionValue(bool, "Flags.IS_SUSPEND.get(flags)");
        initializeWithCoroutinesExperimentalityStatus(deserializedSimpleFunctionDescriptor, createExtensionReceiverParameterForCallable, dispatchReceiverParameter, ownTypeParameters, valueParameters, type2, modality, visibility, emptyMap, bool.booleanValue());
        Boolean bool2 = Flags.IS_OPERATOR.get(flags);
        Intrinsics.checkNotNullExpressionValue(bool2, "Flags.IS_OPERATOR.get(flags)");
        deserializedSimpleFunctionDescriptor.setOperator(bool2.booleanValue());
        Boolean bool3 = Flags.IS_INFIX.get(flags);
        Intrinsics.checkNotNullExpressionValue(bool3, "Flags.IS_INFIX.get(flags)");
        deserializedSimpleFunctionDescriptor.setInfix(bool3.booleanValue());
        Boolean bool4 = Flags.IS_EXTERNAL_FUNCTION.get(flags);
        Intrinsics.checkNotNullExpressionValue(bool4, "Flags.IS_EXTERNAL_FUNCTION.get(flags)");
        deserializedSimpleFunctionDescriptor.setExternal(bool4.booleanValue());
        Boolean bool5 = Flags.IS_INLINE.get(flags);
        Intrinsics.checkNotNullExpressionValue(bool5, "Flags.IS_INLINE.get(flags)");
        deserializedSimpleFunctionDescriptor.setInline(bool5.booleanValue());
        Boolean bool6 = Flags.IS_TAILREC.get(flags);
        Intrinsics.checkNotNullExpressionValue(bool6, "Flags.IS_TAILREC.get(flags)");
        deserializedSimpleFunctionDescriptor.setTailrec(bool6.booleanValue());
        Boolean bool7 = Flags.IS_SUSPEND.get(flags);
        Intrinsics.checkNotNullExpressionValue(bool7, "Flags.IS_SUSPEND.get(flags)");
        deserializedSimpleFunctionDescriptor.setSuspend(bool7.booleanValue());
        Boolean bool8 = Flags.IS_EXPECT_FUNCTION.get(flags);
        Intrinsics.checkNotNullExpressionValue(bool8, "Flags.IS_EXPECT_FUNCTION.get(flags)");
        deserializedSimpleFunctionDescriptor.setExpect(bool8.booleanValue());
        Pair<CallableDescriptor.UserDataKey<?>, Object> deserializeContractFromFunction = this.c.getComponents().getContractDeserializer().deserializeContractFromFunction(function, deserializedSimpleFunctionDescriptor, this.c.getTypeTable(), childContext$default.getTypeDeserializer());
        if (deserializeContractFromFunction != null) {
            deserializedSimpleFunctionDescriptor.putInUserDataMap(deserializeContractFromFunction.getFirst(), deserializeContractFromFunction.getSecond());
        }
        return deserializedSimpleFunctionDescriptor;
    }

    public final TypeAliasDescriptor loadTypeAlias(ProtoBuf.TypeAlias typeAlias) {
        Intrinsics.checkNotNullParameter(typeAlias, "proto");
        Annotations.Companion companion = Annotations.Companion;
        List<ProtoBuf.Annotation> annotationList = typeAlias.getAnnotationList();
        Intrinsics.checkNotNullExpressionValue(annotationList, "proto.annotationList");
        List<ProtoBuf.Annotation> list = annotationList;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        for (T t : list) {
            AnnotationDeserializer annotationDeserializer2 = this.annotationDeserializer;
            Intrinsics.checkNotNullExpressionValue(t, "it");
            arrayList.add(annotationDeserializer2.deserializeAnnotation(t, this.c.getNameResolver()));
        }
        DeserializedTypeAliasDescriptor deserializedTypeAliasDescriptor = new DeserializedTypeAliasDescriptor(this.c.getStorageManager(), this.c.getContainingDeclaration(), companion.create(arrayList), NameResolverUtilKt.getName(this.c.getNameResolver(), typeAlias.getName()), ProtoEnumFlags.INSTANCE.visibility(Flags.VISIBILITY.get(typeAlias.getFlags())), typeAlias, this.c.getNameResolver(), this.c.getTypeTable(), this.c.getVersionRequirementTable(), this.c.getContainerSource());
        List<ProtoBuf.TypeParameter> typeParameterList = typeAlias.getTypeParameterList();
        Intrinsics.checkNotNullExpressionValue(typeParameterList, "proto.typeParameterList");
        DeserializationContext childContext$default = DeserializationContext.childContext$default(this.c, deserializedTypeAliasDescriptor, typeParameterList, null, null, null, null, 60, null);
        deserializedTypeAliasDescriptor.initialize(childContext$default.getTypeDeserializer().getOwnTypeParameters(), childContext$default.getTypeDeserializer().simpleType(ProtoTypeTableUtilKt.underlyingType(typeAlias, this.c.getTypeTable()), false), childContext$default.getTypeDeserializer().simpleType(ProtoTypeTableUtilKt.expandedType(typeAlias, this.c.getTypeTable()), false), checkExperimentalCoroutine(deserializedTypeAliasDescriptor, childContext$default.getTypeDeserializer()));
        return deserializedTypeAliasDescriptor;
    }

    private final ReceiverParameterDescriptor getDispatchReceiverParameter() {
        DeclarationDescriptor containingDeclaration = this.c.getContainingDeclaration();
        if (!(containingDeclaration instanceof ClassDescriptor)) {
            containingDeclaration = null;
        }
        ClassDescriptor classDescriptor = (ClassDescriptor) containingDeclaration;
        if (classDescriptor != null) {
            return classDescriptor.getThisAsReceiverParameter();
        }
        return null;
    }

    public final ClassConstructorDescriptor loadConstructor(ProtoBuf.Constructor constructor, boolean z) {
        DeserializedClassConstructorDescriptor deserializedClassConstructorDescriptor;
        DeserializedMemberDescriptor.CoroutinesCompatibilityMode coroutinesCompatibilityMode;
        DeserializationContext c2;
        TypeDeserializer typeDeserializer;
        Intrinsics.checkNotNullParameter(constructor, "proto");
        DeclarationDescriptor containingDeclaration = this.c.getContainingDeclaration();
        Objects.requireNonNull(containingDeclaration, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
        ClassDescriptor classDescriptor = (ClassDescriptor) containingDeclaration;
        ProtoBuf.Constructor constructor2 = constructor;
        DeserializedClassConstructorDescriptor deserializedClassConstructorDescriptor2 = new DeserializedClassConstructorDescriptor(classDescriptor, null, getAnnotations(constructor2, constructor.getFlags(), AnnotatedCallableKind.FUNCTION), z, CallableMemberDescriptor.Kind.DECLARATION, constructor, this.c.getNameResolver(), this.c.getTypeTable(), this.c.getVersionRequirementTable(), this.c.getContainerSource(), null, 1024, null);
        MemberDeserializer memberDeserializer = DeserializationContext.childContext$default(this.c, deserializedClassConstructorDescriptor2, CollectionsKt.emptyList(), null, null, null, null, 60, null).getMemberDeserializer();
        List<ProtoBuf.ValueParameter> valueParameterList = constructor.getValueParameterList();
        Intrinsics.checkNotNullExpressionValue(valueParameterList, "proto.valueParameterList");
        deserializedClassConstructorDescriptor2.initialize(memberDeserializer.valueParameters(valueParameterList, constructor2, AnnotatedCallableKind.FUNCTION), ProtoEnumFlags.INSTANCE.visibility(Flags.VISIBILITY.get(constructor.getFlags())));
        deserializedClassConstructorDescriptor2.setReturnType(classDescriptor.getDefaultType());
        DeclarationDescriptor containingDeclaration2 = this.c.getContainingDeclaration();
        if (!(containingDeclaration2 instanceof DeserializedClassDescriptor)) {
            containingDeclaration2 = null;
        }
        DeserializedClassDescriptor deserializedClassDescriptor = (DeserializedClassDescriptor) containingDeclaration2;
        boolean z2 = true;
        if (deserializedClassDescriptor == null || (c2 = deserializedClassDescriptor.getC()) == null || (typeDeserializer = c2.getTypeDeserializer()) == null || !typeDeserializer.getExperimentalSuspendFunctionTypeEncountered() || !versionAndReleaseCoroutinesMismatch(deserializedClassConstructorDescriptor2)) {
            z2 = false;
        }
        if (z2) {
            coroutinesCompatibilityMode = DeserializedMemberDescriptor.CoroutinesCompatibilityMode.INCOMPATIBLE;
            deserializedClassConstructorDescriptor = deserializedClassConstructorDescriptor2;
        } else {
            List<ValueParameterDescriptor> valueParameters = deserializedClassConstructorDescriptor2.getValueParameters();
            Intrinsics.checkNotNullExpressionValue(valueParameters, "descriptor.valueParameters");
            List<ValueParameterDescriptor> list = valueParameters;
            List<TypeParameterDescriptor> typeParameters = deserializedClassConstructorDescriptor2.getTypeParameters();
            Intrinsics.checkNotNullExpressionValue(typeParameters, "descriptor.typeParameters");
            deserializedClassConstructorDescriptor = deserializedClassConstructorDescriptor2;
            coroutinesCompatibilityMode = computeExperimentalityModeForFunctions(deserializedClassConstructorDescriptor2, null, list, typeParameters, deserializedClassConstructorDescriptor2.getReturnType(), false);
        }
        deserializedClassConstructorDescriptor.setCoroutinesExperimentalCompatibilityMode$deserialization(coroutinesCompatibilityMode);
        return deserializedClassConstructorDescriptor;
    }

    private final Annotations getAnnotations(MessageLite messageLite, int i, AnnotatedCallableKind annotatedCallableKind) {
        if (!Flags.HAS_ANNOTATIONS.get(i).booleanValue()) {
            return Annotations.Companion.getEMPTY();
        }
        return new NonEmptyDeserializedAnnotations(this.c.getStorageManager(), new MemberDeserializer$getAnnotations$1(this, messageLite, annotatedCallableKind));
    }

    private final Annotations getPropertyFieldAnnotations(ProtoBuf.Property property, boolean z) {
        if (!Flags.HAS_ANNOTATIONS.get(property.getFlags()).booleanValue()) {
            return Annotations.Companion.getEMPTY();
        }
        return new NonEmptyDeserializedAnnotations(this.c.getStorageManager(), new MemberDeserializer$getPropertyFieldAnnotations$1(this, z, property));
    }

    private final Annotations getReceiverParameterAnnotations(MessageLite messageLite, AnnotatedCallableKind annotatedCallableKind) {
        return new DeserializedAnnotations(this.c.getStorageManager(), new MemberDeserializer$getReceiverParameterAnnotations$1(this, messageLite, annotatedCallableKind));
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x00f3  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x00fe  */
    private final List<ValueParameterDescriptor> valueParameters(List<ProtoBuf.ValueParameter> list, MessageLite messageLite, AnnotatedCallableKind annotatedCallableKind) {
        NonEmptyDeserializedAnnotations nonEmptyDeserializedAnnotations;
        DeclarationDescriptor containingDeclaration = this.c.getContainingDeclaration();
        Objects.requireNonNull(containingDeclaration, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.CallableDescriptor");
        CallableDescriptor callableDescriptor = (CallableDescriptor) containingDeclaration;
        DeclarationDescriptor containingDeclaration2 = callableDescriptor.getContainingDeclaration();
        Intrinsics.checkNotNullExpressionValue(containingDeclaration2, "callableDescriptor.containingDeclaration");
        ProtoContainer asProtoContainer = asProtoContainer(containingDeclaration2);
        List<ProtoBuf.ValueParameter> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        int i = 0;
        for (T t : list2) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            T t2 = t;
            int flags = t2.hasFlags() ? t2.getFlags() : 0;
            if (asProtoContainer != null) {
                Boolean bool = Flags.HAS_ANNOTATIONS.get(flags);
                Intrinsics.checkNotNullExpressionValue(bool, "Flags.HAS_ANNOTATIONS.get(flags)");
                if (bool.booleanValue()) {
                    nonEmptyDeserializedAnnotations = new NonEmptyDeserializedAnnotations(this.c.getStorageManager(), new MemberDeserializer$valueParameters$$inlined$mapIndexed$lambda$1(i, t2, this, asProtoContainer, messageLite, annotatedCallableKind, callableDescriptor));
                    Name name = NameResolverUtilKt.getName(this.c.getNameResolver(), t2.getName());
                    KotlinType type = this.c.getTypeDeserializer().type(ProtoTypeTableUtilKt.type((ProtoBuf.ValueParameter) t2, this.c.getTypeTable()));
                    Boolean bool2 = Flags.DECLARES_DEFAULT_VALUE.get(flags);
                    Intrinsics.checkNotNullExpressionValue(bool2, "Flags.DECLARES_DEFAULT_VALUE.get(flags)");
                    boolean booleanValue = bool2.booleanValue();
                    Boolean bool3 = Flags.IS_CROSSINLINE.get(flags);
                    Intrinsics.checkNotNullExpressionValue(bool3, "Flags.IS_CROSSINLINE.get(flags)");
                    boolean booleanValue2 = bool3.booleanValue();
                    Boolean bool4 = Flags.IS_NOINLINE.get(flags);
                    Intrinsics.checkNotNullExpressionValue(bool4, "Flags.IS_NOINLINE.get(flags)");
                    boolean booleanValue3 = bool4.booleanValue();
                    ProtoBuf.Type varargElementType = ProtoTypeTableUtilKt.varargElementType(t2, this.c.getTypeTable());
                    KotlinType type2 = varargElementType == null ? this.c.getTypeDeserializer().type(varargElementType) : null;
                    SourceElement sourceElement = SourceElement.NO_SOURCE;
                    Intrinsics.checkNotNullExpressionValue(sourceElement, "SourceElement.NO_SOURCE");
                    arrayList.add(new ValueParameterDescriptorImpl(callableDescriptor, null, i, nonEmptyDeserializedAnnotations, name, type, booleanValue, booleanValue2, booleanValue3, type2, sourceElement));
                    arrayList = arrayList;
                    i = i2;
                }
            }
            nonEmptyDeserializedAnnotations = Annotations.Companion.getEMPTY();
            Name name2 = NameResolverUtilKt.getName(this.c.getNameResolver(), t2.getName());
            KotlinType type3 = this.c.getTypeDeserializer().type(ProtoTypeTableUtilKt.type((ProtoBuf.ValueParameter) t2, this.c.getTypeTable()));
            Boolean bool22 = Flags.DECLARES_DEFAULT_VALUE.get(flags);
            Intrinsics.checkNotNullExpressionValue(bool22, "Flags.DECLARES_DEFAULT_VALUE.get(flags)");
            boolean booleanValue4 = bool22.booleanValue();
            Boolean bool32 = Flags.IS_CROSSINLINE.get(flags);
            Intrinsics.checkNotNullExpressionValue(bool32, "Flags.IS_CROSSINLINE.get(flags)");
            boolean booleanValue22 = bool32.booleanValue();
            Boolean bool42 = Flags.IS_NOINLINE.get(flags);
            Intrinsics.checkNotNullExpressionValue(bool42, "Flags.IS_NOINLINE.get(flags)");
            boolean booleanValue32 = bool42.booleanValue();
            ProtoBuf.Type varargElementType2 = ProtoTypeTableUtilKt.varargElementType(t2, this.c.getTypeTable());
            if (varargElementType2 == null) {
            }
            SourceElement sourceElement2 = SourceElement.NO_SOURCE;
            Intrinsics.checkNotNullExpressionValue(sourceElement2, "SourceElement.NO_SOURCE");
            arrayList.add(new ValueParameterDescriptorImpl(callableDescriptor, null, i, nonEmptyDeserializedAnnotations, name2, type3, booleanValue4, booleanValue22, booleanValue32, type2, sourceElement2));
            arrayList = arrayList;
            i = i2;
        }
        return CollectionsKt.toList(arrayList);
    }

    /* access modifiers changed from: private */
    public final ProtoContainer asProtoContainer(DeclarationDescriptor declarationDescriptor) {
        if (declarationDescriptor instanceof PackageFragmentDescriptor) {
            return new ProtoContainer.Package(((PackageFragmentDescriptor) declarationDescriptor).getFqName(), this.c.getNameResolver(), this.c.getTypeTable(), this.c.getContainerSource());
        }
        if (declarationDescriptor instanceof DeserializedClassDescriptor) {
            return ((DeserializedClassDescriptor) declarationDescriptor).getThisAsProtoContainer$deserialization();
        }
        return null;
    }
}
