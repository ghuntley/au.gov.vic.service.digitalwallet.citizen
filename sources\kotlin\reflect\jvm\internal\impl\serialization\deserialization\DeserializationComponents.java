package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.NotFoundClasses;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProvider;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.AdditionalClassPartsProvider;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.ClassDescriptorFactory;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.PlatformDependentDeclarationFilter;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.PlatformDependentTypeTransformer;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupTracker;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.BinaryVersion;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.TypeTable;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.VersionRequirementTable;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;
import kotlin.reflect.jvm.internal.impl.resolve.sam.SamConversionResolver;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedContainerSource;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.checker.NewKotlinTypeChecker;

/* compiled from: context.kt */
public final class DeserializationComponents {
    private final AdditionalClassPartsProvider additionalClassPartsProvider;
    private final AnnotationAndConstantLoader<AnnotationDescriptor, ConstantValue<?>> annotationAndConstantLoader;
    private final ClassDataFinder classDataFinder;
    private final ClassDeserializer classDeserializer;
    private final DeserializationConfiguration configuration;
    private final ContractDeserializer contractDeserializer;
    private final ErrorReporter errorReporter;
    private final ExtensionRegistryLite extensionRegistryLite;
    private final Iterable<ClassDescriptorFactory> fictitiousClassDescriptorFactories;
    private final FlexibleTypeDeserializer flexibleTypeDeserializer;
    private final NewKotlinTypeChecker kotlinTypeChecker;
    private final LocalClassifierTypeSettings localClassifierTypeSettings;
    private final LookupTracker lookupTracker;
    private final ModuleDescriptor moduleDescriptor;
    private final NotFoundClasses notFoundClasses;
    private final PackageFragmentProvider packageFragmentProvider;
    private final PlatformDependentDeclarationFilter platformDependentDeclarationFilter;
    private final PlatformDependentTypeTransformer platformDependentTypeTransformer;
    private final SamConversionResolver samConversionResolver;
    private final StorageManager storageManager;

    /* JADX DEBUG: Multi-variable search result rejected for r21v0, resolved type: kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationAndConstantLoader<? extends kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor, ? extends kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue<?>> */
    /* JADX DEBUG: Multi-variable search result rejected for r27v0, resolved type: java.lang.Iterable<? extends kotlin.reflect.jvm.internal.impl.descriptors.deserialization.ClassDescriptorFactory> */
    /* JADX WARN: Multi-variable type inference failed */
    public DeserializationComponents(StorageManager storageManager2, ModuleDescriptor moduleDescriptor2, DeserializationConfiguration deserializationConfiguration, ClassDataFinder classDataFinder2, AnnotationAndConstantLoader<? extends AnnotationDescriptor, ? extends ConstantValue<?>> annotationAndConstantLoader2, PackageFragmentProvider packageFragmentProvider2, LocalClassifierTypeSettings localClassifierTypeSettings2, ErrorReporter errorReporter2, LookupTracker lookupTracker2, FlexibleTypeDeserializer flexibleTypeDeserializer2, Iterable<? extends ClassDescriptorFactory> iterable, NotFoundClasses notFoundClasses2, ContractDeserializer contractDeserializer2, AdditionalClassPartsProvider additionalClassPartsProvider2, PlatformDependentDeclarationFilter platformDependentDeclarationFilter2, ExtensionRegistryLite extensionRegistryLite2, NewKotlinTypeChecker newKotlinTypeChecker, SamConversionResolver samConversionResolver2, PlatformDependentTypeTransformer platformDependentTypeTransformer2) {
        Intrinsics.checkNotNullParameter(storageManager2, "storageManager");
        Intrinsics.checkNotNullParameter(moduleDescriptor2, "moduleDescriptor");
        Intrinsics.checkNotNullParameter(deserializationConfiguration, "configuration");
        Intrinsics.checkNotNullParameter(classDataFinder2, "classDataFinder");
        Intrinsics.checkNotNullParameter(annotationAndConstantLoader2, "annotationAndConstantLoader");
        Intrinsics.checkNotNullParameter(packageFragmentProvider2, "packageFragmentProvider");
        Intrinsics.checkNotNullParameter(localClassifierTypeSettings2, "localClassifierTypeSettings");
        Intrinsics.checkNotNullParameter(errorReporter2, "errorReporter");
        Intrinsics.checkNotNullParameter(lookupTracker2, "lookupTracker");
        Intrinsics.checkNotNullParameter(flexibleTypeDeserializer2, "flexibleTypeDeserializer");
        Intrinsics.checkNotNullParameter(iterable, "fictitiousClassDescriptorFactories");
        Intrinsics.checkNotNullParameter(notFoundClasses2, "notFoundClasses");
        Intrinsics.checkNotNullParameter(contractDeserializer2, "contractDeserializer");
        Intrinsics.checkNotNullParameter(additionalClassPartsProvider2, "additionalClassPartsProvider");
        Intrinsics.checkNotNullParameter(platformDependentDeclarationFilter2, "platformDependentDeclarationFilter");
        Intrinsics.checkNotNullParameter(extensionRegistryLite2, "extensionRegistryLite");
        Intrinsics.checkNotNullParameter(newKotlinTypeChecker, "kotlinTypeChecker");
        Intrinsics.checkNotNullParameter(samConversionResolver2, "samConversionResolver");
        Intrinsics.checkNotNullParameter(platformDependentTypeTransformer2, "platformDependentTypeTransformer");
        this.storageManager = storageManager2;
        this.moduleDescriptor = moduleDescriptor2;
        this.configuration = deserializationConfiguration;
        this.classDataFinder = classDataFinder2;
        this.annotationAndConstantLoader = annotationAndConstantLoader2;
        this.packageFragmentProvider = packageFragmentProvider2;
        this.localClassifierTypeSettings = localClassifierTypeSettings2;
        this.errorReporter = errorReporter2;
        this.lookupTracker = lookupTracker2;
        this.flexibleTypeDeserializer = flexibleTypeDeserializer2;
        this.fictitiousClassDescriptorFactories = iterable;
        this.notFoundClasses = notFoundClasses2;
        this.contractDeserializer = contractDeserializer2;
        this.additionalClassPartsProvider = additionalClassPartsProvider2;
        this.platformDependentDeclarationFilter = platformDependentDeclarationFilter2;
        this.extensionRegistryLite = extensionRegistryLite2;
        this.kotlinTypeChecker = newKotlinTypeChecker;
        this.samConversionResolver = samConversionResolver2;
        this.platformDependentTypeTransformer = platformDependentTypeTransformer2;
        this.classDeserializer = new ClassDeserializer(this);
    }

    public final StorageManager getStorageManager() {
        return this.storageManager;
    }

    public final ModuleDescriptor getModuleDescriptor() {
        return this.moduleDescriptor;
    }

    public final DeserializationConfiguration getConfiguration() {
        return this.configuration;
    }

    public final ClassDataFinder getClassDataFinder() {
        return this.classDataFinder;
    }

    public final AnnotationAndConstantLoader<AnnotationDescriptor, ConstantValue<?>> getAnnotationAndConstantLoader() {
        return this.annotationAndConstantLoader;
    }

    public final PackageFragmentProvider getPackageFragmentProvider() {
        return this.packageFragmentProvider;
    }

    public final LocalClassifierTypeSettings getLocalClassifierTypeSettings() {
        return this.localClassifierTypeSettings;
    }

    public final ErrorReporter getErrorReporter() {
        return this.errorReporter;
    }

    public final LookupTracker getLookupTracker() {
        return this.lookupTracker;
    }

    public final FlexibleTypeDeserializer getFlexibleTypeDeserializer() {
        return this.flexibleTypeDeserializer;
    }

    public final Iterable<ClassDescriptorFactory> getFictitiousClassDescriptorFactories() {
        return this.fictitiousClassDescriptorFactories;
    }

    public final NotFoundClasses getNotFoundClasses() {
        return this.notFoundClasses;
    }

    public final ContractDeserializer getContractDeserializer() {
        return this.contractDeserializer;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ DeserializationComponents(StorageManager storageManager2, ModuleDescriptor moduleDescriptor2, DeserializationConfiguration deserializationConfiguration, ClassDataFinder classDataFinder2, AnnotationAndConstantLoader annotationAndConstantLoader2, PackageFragmentProvider packageFragmentProvider2, LocalClassifierTypeSettings localClassifierTypeSettings2, ErrorReporter errorReporter2, LookupTracker lookupTracker2, FlexibleTypeDeserializer flexibleTypeDeserializer2, Iterable iterable, NotFoundClasses notFoundClasses2, ContractDeserializer contractDeserializer2, AdditionalClassPartsProvider additionalClassPartsProvider2, PlatformDependentDeclarationFilter platformDependentDeclarationFilter2, ExtensionRegistryLite extensionRegistryLite2, NewKotlinTypeChecker newKotlinTypeChecker, SamConversionResolver samConversionResolver2, PlatformDependentTypeTransformer platformDependentTypeTransformer2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(storageManager2, moduleDescriptor2, deserializationConfiguration, classDataFinder2, annotationAndConstantLoader2, packageFragmentProvider2, localClassifierTypeSettings2, errorReporter2, lookupTracker2, flexibleTypeDeserializer2, iterable, notFoundClasses2, contractDeserializer2, (i & 8192) != 0 ? AdditionalClassPartsProvider.None.INSTANCE : additionalClassPartsProvider2, (i & 16384) != 0 ? PlatformDependentDeclarationFilter.All.INSTANCE : platformDependentDeclarationFilter2, extensionRegistryLite2, (65536 & i) != 0 ? NewKotlinTypeChecker.Companion.getDefault() : newKotlinTypeChecker, samConversionResolver2, (i & 262144) != 0 ? PlatformDependentTypeTransformer.None.INSTANCE : platformDependentTypeTransformer2);
    }

    public final AdditionalClassPartsProvider getAdditionalClassPartsProvider() {
        return this.additionalClassPartsProvider;
    }

    public final PlatformDependentDeclarationFilter getPlatformDependentDeclarationFilter() {
        return this.platformDependentDeclarationFilter;
    }

    public final ExtensionRegistryLite getExtensionRegistryLite() {
        return this.extensionRegistryLite;
    }

    public final NewKotlinTypeChecker getKotlinTypeChecker() {
        return this.kotlinTypeChecker;
    }

    public final PlatformDependentTypeTransformer getPlatformDependentTypeTransformer() {
        return this.platformDependentTypeTransformer;
    }

    public final ClassDeserializer getClassDeserializer() {
        return this.classDeserializer;
    }

    public final ClassDescriptor deserializeClass(ClassId classId) {
        Intrinsics.checkNotNullParameter(classId, "classId");
        return ClassDeserializer.deserializeClass$default(this.classDeserializer, classId, null, 2, null);
    }

    public final DeserializationContext createContext(PackageFragmentDescriptor packageFragmentDescriptor, NameResolver nameResolver, TypeTable typeTable, VersionRequirementTable versionRequirementTable, BinaryVersion binaryVersion, DeserializedContainerSource deserializedContainerSource) {
        Intrinsics.checkNotNullParameter(packageFragmentDescriptor, "descriptor");
        Intrinsics.checkNotNullParameter(nameResolver, "nameResolver");
        Intrinsics.checkNotNullParameter(typeTable, "typeTable");
        Intrinsics.checkNotNullParameter(versionRequirementTable, "versionRequirementTable");
        Intrinsics.checkNotNullParameter(binaryVersion, "metadataVersion");
        return new DeserializationContext(this, nameResolver, packageFragmentDescriptor, typeTable, versionRequirementTable, binaryVersion, deserializedContainerSource, null, CollectionsKt.emptyList());
    }
}
