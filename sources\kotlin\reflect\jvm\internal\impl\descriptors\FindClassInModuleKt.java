package kotlin.reflect.jvm.internal.impl.descriptors;

import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.ResolutionAnchorProvider;
import kotlin.reflect.jvm.internal.impl.resolve.ResolutionAnchorProviderKt;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.sequences.SequencesKt;

/* compiled from: findClassInModule.kt */
public final class FindClassInModuleKt {
    public static final ClassDescriptor findClassAcrossModuleDependencies(ModuleDescriptor moduleDescriptor, ClassId classId) {
        Intrinsics.checkNotNullParameter(moduleDescriptor, "$this$findClassAcrossModuleDependencies");
        Intrinsics.checkNotNullParameter(classId, "classId");
        ClassifierDescriptor findClassifierAcrossModuleDependencies = findClassifierAcrossModuleDependencies(moduleDescriptor, classId);
        if (!(findClassifierAcrossModuleDependencies instanceof ClassDescriptor)) {
            findClassifierAcrossModuleDependencies = null;
        }
        return (ClassDescriptor) findClassifierAcrossModuleDependencies;
    }

    public static final ClassDescriptor findNonGenericClassAcrossDependencies(ModuleDescriptor moduleDescriptor, ClassId classId, NotFoundClasses notFoundClasses) {
        Intrinsics.checkNotNullParameter(moduleDescriptor, "$this$findNonGenericClassAcrossDependencies");
        Intrinsics.checkNotNullParameter(classId, "classId");
        Intrinsics.checkNotNullParameter(notFoundClasses, "notFoundClasses");
        ClassDescriptor findClassAcrossModuleDependencies = findClassAcrossModuleDependencies(moduleDescriptor, classId);
        if (findClassAcrossModuleDependencies != null) {
            return findClassAcrossModuleDependencies;
        }
        return notFoundClasses.getClass(classId, SequencesKt.toList(SequencesKt.map(SequencesKt.generateSequence(classId, FindClassInModuleKt$findNonGenericClassAcrossDependencies$typeParametersCount$1.INSTANCE), FindClassInModuleKt$findNonGenericClassAcrossDependencies$typeParametersCount$2.INSTANCE)));
    }

    public static final TypeAliasDescriptor findTypeAliasAcrossModuleDependencies(ModuleDescriptor moduleDescriptor, ClassId classId) {
        Intrinsics.checkNotNullParameter(moduleDescriptor, "$this$findTypeAliasAcrossModuleDependencies");
        Intrinsics.checkNotNullParameter(classId, "classId");
        ClassifierDescriptor findClassifierAcrossModuleDependencies = findClassifierAcrossModuleDependencies(moduleDescriptor, classId);
        if (!(findClassifierAcrossModuleDependencies instanceof TypeAliasDescriptor)) {
            findClassifierAcrossModuleDependencies = null;
        }
        return (TypeAliasDescriptor) findClassifierAcrossModuleDependencies;
    }

    /* JADX WARNING: Removed duplicated region for block: B:35:0x00fc  */
    public static final ClassifierDescriptor findClassifierAcrossModuleDependencies(ModuleDescriptor moduleDescriptor, ClassId classId) {
        ClassDescriptor classDescriptor;
        Intrinsics.checkNotNullParameter(moduleDescriptor, "$this$findClassifierAcrossModuleDependencies");
        Intrinsics.checkNotNullParameter(classId, "classId");
        ResolutionAnchorProvider resolutionAnchorProvider = (ResolutionAnchorProvider) moduleDescriptor.getCapability(ResolutionAnchorProviderKt.getRESOLUTION_ANCHOR_PROVIDER_CAPABILITY());
        ModuleDescriptor resolutionAnchor = resolutionAnchorProvider != null ? resolutionAnchorProvider.getResolutionAnchor(moduleDescriptor) : null;
        if (resolutionAnchor == null) {
            FqName packageFqName = classId.getPackageFqName();
            Intrinsics.checkNotNullExpressionValue(packageFqName, "classId.packageFqName");
            PackageViewDescriptor packageViewDescriptor = moduleDescriptor.getPackage(packageFqName);
            List<Name> pathSegments = classId.getRelativeClassName().pathSegments();
            Intrinsics.checkNotNullExpressionValue(pathSegments, "classId.relativeClassName.pathSegments()");
            MemberScope memberScope = packageViewDescriptor.getMemberScope();
            Object first = CollectionsKt.first((List) pathSegments);
            Intrinsics.checkNotNullExpressionValue(first, "segments.first()");
            classDescriptor = memberScope.getContributedClassifier((Name) first, NoLookupLocation.FROM_DESERIALIZATION);
            if (classDescriptor == null) {
                return null;
            }
            for (Name name : pathSegments.subList(1, pathSegments.size())) {
                if (!(classDescriptor instanceof ClassDescriptor)) {
                    return null;
                }
                MemberScope unsubstitutedInnerClassesScope = ((ClassDescriptor) classDescriptor).getUnsubstitutedInnerClassesScope();
                Intrinsics.checkNotNullExpressionValue(name, "name");
                ClassifierDescriptor contributedClassifier = unsubstitutedInnerClassesScope.getContributedClassifier(name, NoLookupLocation.FROM_DESERIALIZATION);
                if (!(contributedClassifier instanceof ClassDescriptor)) {
                    contributedClassifier = null;
                }
                ClassDescriptor classDescriptor2 = (ClassDescriptor) contributedClassifier;
                if (classDescriptor2 == null) {
                    return null;
                }
                classDescriptor = classDescriptor2;
            }
        } else {
            FqName packageFqName2 = classId.getPackageFqName();
            Intrinsics.checkNotNullExpressionValue(packageFqName2, "classId.packageFqName");
            PackageViewDescriptor packageViewDescriptor2 = moduleDescriptor.getPackage(packageFqName2);
            List<Name> pathSegments2 = classId.getRelativeClassName().pathSegments();
            Intrinsics.checkNotNullExpressionValue(pathSegments2, "classId.relativeClassName.pathSegments()");
            MemberScope memberScope2 = packageViewDescriptor2.getMemberScope();
            Object first2 = CollectionsKt.first((List) pathSegments2);
            Intrinsics.checkNotNullExpressionValue(first2, "segments.first()");
            classDescriptor = memberScope2.getContributedClassifier((Name) first2, NoLookupLocation.FROM_DESERIALIZATION);
            if (classDescriptor != null) {
                Iterator<Name> it = pathSegments2.subList(1, pathSegments2.size()).iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    Name next = it.next();
                    if (!(classDescriptor instanceof ClassDescriptor)) {
                        break;
                    }
                    MemberScope unsubstitutedInnerClassesScope2 = ((ClassDescriptor) classDescriptor).getUnsubstitutedInnerClassesScope();
                    Intrinsics.checkNotNullExpressionValue(next, "name");
                    ClassifierDescriptor contributedClassifier2 = unsubstitutedInnerClassesScope2.getContributedClassifier(next, NoLookupLocation.FROM_DESERIALIZATION);
                    if (!(contributedClassifier2 instanceof ClassDescriptor)) {
                        contributedClassifier2 = null;
                    }
                    ClassDescriptor classDescriptor3 = (ClassDescriptor) contributedClassifier2;
                    if (classDescriptor3 == null) {
                        break;
                    }
                    classDescriptor = classDescriptor3;
                }
                if (classDescriptor == null) {
                    FqName packageFqName3 = classId.getPackageFqName();
                    Intrinsics.checkNotNullExpressionValue(packageFqName3, "classId.packageFqName");
                    PackageViewDescriptor packageViewDescriptor3 = resolutionAnchor.getPackage(packageFqName3);
                    List<Name> pathSegments3 = classId.getRelativeClassName().pathSegments();
                    Intrinsics.checkNotNullExpressionValue(pathSegments3, "classId.relativeClassName.pathSegments()");
                    MemberScope memberScope3 = packageViewDescriptor3.getMemberScope();
                    Object first3 = CollectionsKt.first((List) pathSegments3);
                    Intrinsics.checkNotNullExpressionValue(first3, "segments.first()");
                    classDescriptor = memberScope3.getContributedClassifier((Name) first3, NoLookupLocation.FROM_DESERIALIZATION);
                    if (classDescriptor == null) {
                        return null;
                    }
                    for (Name name2 : pathSegments3.subList(1, pathSegments3.size())) {
                        if (!(classDescriptor instanceof ClassDescriptor)) {
                            return null;
                        }
                        MemberScope unsubstitutedInnerClassesScope3 = ((ClassDescriptor) classDescriptor).getUnsubstitutedInnerClassesScope();
                        Intrinsics.checkNotNullExpressionValue(name2, "name");
                        ClassifierDescriptor contributedClassifier3 = unsubstitutedInnerClassesScope3.getContributedClassifier(name2, NoLookupLocation.FROM_DESERIALIZATION);
                        if (!(contributedClassifier3 instanceof ClassDescriptor)) {
                            contributedClassifier3 = null;
                        }
                        ClassDescriptor classDescriptor4 = (ClassDescriptor) contributedClassifier3;
                        if (classDescriptor4 == null) {
                            return null;
                        }
                        classDescriptor = classDescriptor4;
                    }
                }
            }
            classDescriptor = null;
            if (classDescriptor == null) {
            }
        }
        return classDescriptor;
    }
}
