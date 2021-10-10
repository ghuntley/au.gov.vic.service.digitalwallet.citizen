package kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Objects;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyAccessorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefinerKt;
import kotlin.reflect.jvm.internal.impl.utils.DFS;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;

/* compiled from: DescriptorUtils.kt */
public final class DescriptorUtilsKt {
    private static final Name RETENTION_PARAMETER_NAME;

    static {
        Name identifier = Name.identifier("value");
        Intrinsics.checkNotNullExpressionValue(identifier, "Name.identifier(\"value\")");
        RETENTION_PARAMETER_NAME = identifier;
    }

    public static final FqNameUnsafe getFqNameUnsafe(DeclarationDescriptor declarationDescriptor) {
        Intrinsics.checkNotNullParameter(declarationDescriptor, "$this$fqNameUnsafe");
        FqNameUnsafe fqName = DescriptorUtils.getFqName(declarationDescriptor);
        Intrinsics.checkNotNullExpressionValue(fqName, "DescriptorUtils.getFqName(this)");
        return fqName;
    }

    public static final FqName getFqNameSafe(DeclarationDescriptor declarationDescriptor) {
        Intrinsics.checkNotNullParameter(declarationDescriptor, "$this$fqNameSafe");
        FqName fqNameSafe = DescriptorUtils.getFqNameSafe(declarationDescriptor);
        Intrinsics.checkNotNullExpressionValue(fqNameSafe, "DescriptorUtils.getFqNameSafe(this)");
        return fqNameSafe;
    }

    public static final ModuleDescriptor getModule(DeclarationDescriptor declarationDescriptor) {
        Intrinsics.checkNotNullParameter(declarationDescriptor, "$this$module");
        ModuleDescriptor containingModule = DescriptorUtils.getContainingModule(declarationDescriptor);
        Intrinsics.checkNotNullExpressionValue(containingModule, "DescriptorUtils.getContainingModule(this)");
        return containingModule;
    }

    public static final ClassDescriptor resolveTopLevelClass(ModuleDescriptor moduleDescriptor, FqName fqName, LookupLocation lookupLocation) {
        Intrinsics.checkNotNullParameter(moduleDescriptor, "$this$resolveTopLevelClass");
        Intrinsics.checkNotNullParameter(fqName, "topLevelClassFqName");
        Intrinsics.checkNotNullParameter(lookupLocation, FirebaseAnalytics.Param.LOCATION);
        fqName.isRoot();
        FqName parent = fqName.parent();
        Intrinsics.checkNotNullExpressionValue(parent, "topLevelClassFqName.parent()");
        MemberScope memberScope = moduleDescriptor.getPackage(parent).getMemberScope();
        Name shortName = fqName.shortName();
        Intrinsics.checkNotNullExpressionValue(shortName, "topLevelClassFqName.shortName()");
        ClassifierDescriptor contributedClassifier = memberScope.getContributedClassifier(shortName, lookupLocation);
        if (!(contributedClassifier instanceof ClassDescriptor)) {
            contributedClassifier = null;
        }
        return (ClassDescriptor) contributedClassifier;
    }

    public static final ClassId getClassId(ClassifierDescriptor classifierDescriptor) {
        DeclarationDescriptor containingDeclaration;
        ClassId classId;
        if (classifierDescriptor == null || (containingDeclaration = classifierDescriptor.getContainingDeclaration()) == null) {
            return null;
        }
        if (containingDeclaration instanceof PackageFragmentDescriptor) {
            return new ClassId(((PackageFragmentDescriptor) containingDeclaration).getFqName(), classifierDescriptor.getName());
        }
        if (!(containingDeclaration instanceof ClassifierDescriptorWithTypeParameters) || (classId = getClassId((ClassifierDescriptor) containingDeclaration)) == null) {
            return null;
        }
        return classId.createNestedClassId(classifierDescriptor.getName());
    }

    public static final ClassDescriptor getSuperClassNotAny(ClassDescriptor classDescriptor) {
        Intrinsics.checkNotNullParameter(classDescriptor, "$this$getSuperClassNotAny");
        for (KotlinType kotlinType : classDescriptor.getDefaultType().getConstructor().getSupertypes()) {
            if (!KotlinBuiltIns.isAnyOrNullableAny(kotlinType)) {
                ClassifierDescriptor declarationDescriptor = kotlinType.getConstructor().getDeclarationDescriptor();
                if (DescriptorUtils.isClassOrEnumClass(declarationDescriptor)) {
                    Objects.requireNonNull(declarationDescriptor, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
                    return (ClassDescriptor) declarationDescriptor;
                }
            }
        }
        return null;
    }

    public static final KotlinBuiltIns getBuiltIns(DeclarationDescriptor declarationDescriptor) {
        Intrinsics.checkNotNullParameter(declarationDescriptor, "$this$builtIns");
        return getModule(declarationDescriptor).getBuiltIns();
    }

    public static final boolean declaresOrInheritsDefaultValue(ValueParameterDescriptor valueParameterDescriptor) {
        Intrinsics.checkNotNullParameter(valueParameterDescriptor, "$this$declaresOrInheritsDefaultValue");
        Boolean ifAny = DFS.ifAny(CollectionsKt.listOf(valueParameterDescriptor), DescriptorUtilsKt$declaresOrInheritsDefaultValue$1.INSTANCE, DescriptorUtilsKt$declaresOrInheritsDefaultValue$2.INSTANCE);
        Intrinsics.checkNotNullExpressionValue(ifAny, "DFS.ifAny(\n        listO…eclaresDefaultValue\n    )");
        return ifAny.booleanValue();
    }

    public static final Sequence<DeclarationDescriptor> getParentsWithSelf(DeclarationDescriptor declarationDescriptor) {
        Intrinsics.checkNotNullParameter(declarationDescriptor, "$this$parentsWithSelf");
        return SequencesKt.generateSequence(declarationDescriptor, DescriptorUtilsKt$parentsWithSelf$1.INSTANCE);
    }

    public static final Sequence<DeclarationDescriptor> getParents(DeclarationDescriptor declarationDescriptor) {
        Intrinsics.checkNotNullParameter(declarationDescriptor, "$this$parents");
        return SequencesKt.drop(getParentsWithSelf(declarationDescriptor), 1);
    }

    public static final CallableMemberDescriptor getPropertyIfAccessor(CallableMemberDescriptor callableMemberDescriptor) {
        Intrinsics.checkNotNullParameter(callableMemberDescriptor, "$this$propertyIfAccessor");
        if (!(callableMemberDescriptor instanceof PropertyAccessorDescriptor)) {
            return callableMemberDescriptor;
        }
        PropertyDescriptor correspondingProperty = ((PropertyAccessorDescriptor) callableMemberDescriptor).getCorrespondingProperty();
        Intrinsics.checkNotNullExpressionValue(correspondingProperty, "correspondingProperty");
        return correspondingProperty;
    }

    public static final FqName fqNameOrNull(DeclarationDescriptor declarationDescriptor) {
        Intrinsics.checkNotNullParameter(declarationDescriptor, "$this$fqNameOrNull");
        FqNameUnsafe fqNameUnsafe = getFqNameUnsafe(declarationDescriptor);
        if (!fqNameUnsafe.isSafe()) {
            fqNameUnsafe = null;
        }
        if (fqNameUnsafe != null) {
            return fqNameUnsafe.toSafe();
        }
        return null;
    }

    public static /* synthetic */ CallableMemberDescriptor firstOverridden$default(CallableMemberDescriptor callableMemberDescriptor, boolean z, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        return firstOverridden(callableMemberDescriptor, z, function1);
    }

    public static final CallableMemberDescriptor firstOverridden(CallableMemberDescriptor callableMemberDescriptor, boolean z, Function1<? super CallableMemberDescriptor, Boolean> function1) {
        Intrinsics.checkNotNullParameter(callableMemberDescriptor, "$this$firstOverridden");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = (T) null;
        return (CallableMemberDescriptor) DFS.dfs(CollectionsKt.listOf(callableMemberDescriptor), new DescriptorUtilsKt$firstOverridden$1(z), new DescriptorUtilsKt$firstOverridden$2(objectRef, function1));
    }

    public static final Collection<ClassDescriptor> computeSealedSubclasses(ClassDescriptor classDescriptor) {
        Intrinsics.checkNotNullParameter(classDescriptor, "sealedClass");
        if (classDescriptor.getModality() != Modality.SEALED) {
            return CollectionsKt.emptyList();
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        DescriptorUtilsKt$computeSealedSubclasses$1 descriptorUtilsKt$computeSealedSubclasses$1 = new DescriptorUtilsKt$computeSealedSubclasses$1(classDescriptor, linkedHashSet);
        DeclarationDescriptor containingDeclaration = classDescriptor.getContainingDeclaration();
        Intrinsics.checkNotNullExpressionValue(containingDeclaration, "sealedClass.containingDeclaration");
        if (containingDeclaration instanceof PackageFragmentDescriptor) {
            descriptorUtilsKt$computeSealedSubclasses$1.invoke(((PackageFragmentDescriptor) containingDeclaration).getMemberScope(), false);
        }
        MemberScope unsubstitutedInnerClassesScope = classDescriptor.getUnsubstitutedInnerClassesScope();
        Intrinsics.checkNotNullExpressionValue(unsubstitutedInnerClassesScope, "sealedClass.unsubstitutedInnerClassesScope");
        descriptorUtilsKt$computeSealedSubclasses$1.invoke(unsubstitutedInnerClassesScope, true);
        return linkedHashSet;
    }

    public static final ClassDescriptor getAnnotationClass(AnnotationDescriptor annotationDescriptor) {
        Intrinsics.checkNotNullParameter(annotationDescriptor, "$this$annotationClass");
        ClassifierDescriptor declarationDescriptor = annotationDescriptor.getType().getConstructor().getDeclarationDescriptor();
        if (!(declarationDescriptor instanceof ClassDescriptor)) {
            declarationDescriptor = null;
        }
        return (ClassDescriptor) declarationDescriptor;
    }

    public static final ConstantValue<?> firstArgument(AnnotationDescriptor annotationDescriptor) {
        Intrinsics.checkNotNullParameter(annotationDescriptor, "$this$firstArgument");
        return (ConstantValue) CollectionsKt.firstOrNull(annotationDescriptor.getAllValueArguments().values());
    }

    public static final KotlinTypeRefiner getKotlinTypeRefiner(ModuleDescriptor moduleDescriptor) {
        KotlinTypeRefiner kotlinTypeRefiner;
        Intrinsics.checkNotNullParameter(moduleDescriptor, "$this$getKotlinTypeRefiner");
        kotlin.reflect.jvm.internal.impl.types.checker.Ref ref = (kotlin.reflect.jvm.internal.impl.types.checker.Ref) moduleDescriptor.getCapability(KotlinTypeRefinerKt.getREFINER_CAPABILITY());
        return (ref == null || (kotlinTypeRefiner = (KotlinTypeRefiner) ref.getValue()) == null) ? KotlinTypeRefiner.Default.INSTANCE : kotlinTypeRefiner;
    }

    public static final boolean isTypeRefinementEnabled(ModuleDescriptor moduleDescriptor) {
        Intrinsics.checkNotNullParameter(moduleDescriptor, "$this$isTypeRefinementEnabled");
        kotlin.reflect.jvm.internal.impl.types.checker.Ref ref = (kotlin.reflect.jvm.internal.impl.types.checker.Ref) moduleDescriptor.getCapability(KotlinTypeRefinerKt.getREFINER_CAPABILITY());
        return (ref != null ? (KotlinTypeRefiner) ref.getValue() : null) != null;
    }
}
