package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.jvm.JavaToKotlinClassMap;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotated;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationsKt;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertyGetterDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.load.java.AnnotationTypeQualifierResolver;
import kotlin.reflect.jvm.internal.impl.load.java.DeprecationCausedByFunctionN;
import kotlin.reflect.jvm.internal.impl.load.java.JvmAnnotationNamesKt;
import kotlin.reflect.jvm.internal.impl.load.java.UtilsKt;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.AnnotationDefaultValue;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaCallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaMethodDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaPropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.NullDefaultValue;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.PossiblyExternalAnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.StringDefaultValue;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.UtilKt;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.ValueParameterData;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.ContextKt;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.JavaTypeQualifiersByElementType;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.JavaDescriptorUtilKt;
import kotlin.reflect.jvm.internal.impl.load.kotlin.MethodSignatureMappingKt;
import kotlin.reflect.jvm.internal.impl.load.kotlin.SignatureBuildingComponents;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.EnumValue;
import kotlin.reflect.jvm.internal.impl.resolve.deprecation.DeprecationKt;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.FlexibleType;
import kotlin.reflect.jvm.internal.impl.types.FlexibleTypesKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;
import kotlin.reflect.jvm.internal.impl.types.TypeWithEnhancementKt;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeChecker;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import kotlin.reflect.jvm.internal.impl.utils.Jsr305State;
import kotlin.reflect.jvm.internal.impl.utils.ReportLevel;

/* compiled from: signatureEnhancement.kt */
public final class SignatureEnhancement {
    private final AnnotationTypeQualifierResolver annotationTypeQualifierResolver;
    private final Jsr305State jsr305State;

    public SignatureEnhancement(AnnotationTypeQualifierResolver annotationTypeQualifierResolver2, Jsr305State jsr305State2) {
        Intrinsics.checkNotNullParameter(annotationTypeQualifierResolver2, "annotationTypeQualifierResolver");
        Intrinsics.checkNotNullParameter(jsr305State2, "jsr305State");
        this.annotationTypeQualifierResolver = annotationTypeQualifierResolver2;
        this.jsr305State = jsr305State2;
    }

    private final NullabilityQualifierWithMigrationStatus extractNullabilityTypeFromArgument(AnnotationDescriptor annotationDescriptor) {
        NullabilityQualifierWithMigrationStatus nullabilityQualifierWithMigrationStatus;
        ConstantValue<?> firstArgument = DescriptorUtilsKt.firstArgument(annotationDescriptor);
        if (!(firstArgument instanceof EnumValue)) {
            firstArgument = null;
        }
        EnumValue enumValue = (EnumValue) firstArgument;
        if (enumValue == null) {
            return new NullabilityQualifierWithMigrationStatus(NullabilityQualifier.NOT_NULL, false, 2, null);
        }
        String asString = enumValue.getEnumEntryName().asString();
        switch (asString.hashCode()) {
            case 73135176:
                if (!asString.equals("MAYBE")) {
                    return null;
                }
                nullabilityQualifierWithMigrationStatus = new NullabilityQualifierWithMigrationStatus(NullabilityQualifier.NULLABLE, false, 2, null);
                break;
            case 74175084:
                if (!asString.equals("NEVER")) {
                    return null;
                }
                nullabilityQualifierWithMigrationStatus = new NullabilityQualifierWithMigrationStatus(NullabilityQualifier.NULLABLE, false, 2, null);
                break;
            case 433141802:
                if (asString.equals("UNKNOWN")) {
                    nullabilityQualifierWithMigrationStatus = new NullabilityQualifierWithMigrationStatus(NullabilityQualifier.FORCE_FLEXIBILITY, false, 2, null);
                    break;
                } else {
                    return null;
                }
            case 1933739535:
                if (asString.equals("ALWAYS")) {
                    nullabilityQualifierWithMigrationStatus = new NullabilityQualifierWithMigrationStatus(NullabilityQualifier.NOT_NULL, false, 2, null);
                    break;
                } else {
                    return null;
                }
            default:
                return null;
        }
        return nullabilityQualifierWithMigrationStatus;
    }

    public final NullabilityQualifierWithMigrationStatus extractNullability(AnnotationDescriptor annotationDescriptor) {
        NullabilityQualifierWithMigrationStatus extractNullabilityFromKnownAnnotations;
        Intrinsics.checkNotNullParameter(annotationDescriptor, "annotationDescriptor");
        NullabilityQualifierWithMigrationStatus extractNullabilityFromKnownAnnotations2 = extractNullabilityFromKnownAnnotations(annotationDescriptor);
        if (extractNullabilityFromKnownAnnotations2 != null) {
            return extractNullabilityFromKnownAnnotations2;
        }
        AnnotationDescriptor resolveTypeQualifierAnnotation = this.annotationTypeQualifierResolver.resolveTypeQualifierAnnotation(annotationDescriptor);
        if (resolveTypeQualifierAnnotation == null) {
            return null;
        }
        ReportLevel resolveJsr305AnnotationState = this.annotationTypeQualifierResolver.resolveJsr305AnnotationState(annotationDescriptor);
        if (!resolveJsr305AnnotationState.isIgnore() && (extractNullabilityFromKnownAnnotations = extractNullabilityFromKnownAnnotations(resolveTypeQualifierAnnotation)) != null) {
            return NullabilityQualifierWithMigrationStatus.copy$default(extractNullabilityFromKnownAnnotations, null, resolveJsr305AnnotationState.isWarning(), 1, null);
        }
        return null;
    }

    private final NullabilityQualifierWithMigrationStatus extractNullabilityFromKnownAnnotations(AnnotationDescriptor annotationDescriptor) {
        NullabilityQualifierWithMigrationStatus nullabilityQualifierWithMigrationStatus;
        FqName fqName = annotationDescriptor.getFqName();
        if (fqName == null) {
            return null;
        }
        if (JvmAnnotationNamesKt.getNULLABLE_ANNOTATIONS().contains(fqName)) {
            nullabilityQualifierWithMigrationStatus = new NullabilityQualifierWithMigrationStatus(NullabilityQualifier.NULLABLE, false, 2, null);
        } else if (JvmAnnotationNamesKt.getNOT_NULL_ANNOTATIONS().contains(fqName)) {
            nullabilityQualifierWithMigrationStatus = new NullabilityQualifierWithMigrationStatus(NullabilityQualifier.NOT_NULL, false, 2, null);
        } else if (Intrinsics.areEqual(fqName, JvmAnnotationNamesKt.getJAVAX_NONNULL_ANNOTATION())) {
            nullabilityQualifierWithMigrationStatus = extractNullabilityTypeFromArgument(annotationDescriptor);
        } else if (Intrinsics.areEqual(fqName, JvmAnnotationNamesKt.getCOMPATQUAL_NULLABLE_ANNOTATION()) && this.jsr305State.getEnableCompatqualCheckerFrameworkAnnotations()) {
            nullabilityQualifierWithMigrationStatus = new NullabilityQualifierWithMigrationStatus(NullabilityQualifier.NULLABLE, false, 2, null);
        } else if (Intrinsics.areEqual(fqName, JvmAnnotationNamesKt.getCOMPATQUAL_NONNULL_ANNOTATION()) && this.jsr305State.getEnableCompatqualCheckerFrameworkAnnotations()) {
            nullabilityQualifierWithMigrationStatus = new NullabilityQualifierWithMigrationStatus(NullabilityQualifier.NOT_NULL, false, 2, null);
        } else if (Intrinsics.areEqual(fqName, JvmAnnotationNamesKt.getANDROIDX_RECENTLY_NON_NULL_ANNOTATION())) {
            nullabilityQualifierWithMigrationStatus = new NullabilityQualifierWithMigrationStatus(NullabilityQualifier.NOT_NULL, true);
        } else {
            nullabilityQualifierWithMigrationStatus = Intrinsics.areEqual(fqName, JvmAnnotationNamesKt.getANDROIDX_RECENTLY_NULLABLE_ANNOTATION()) ? new NullabilityQualifierWithMigrationStatus(NullabilityQualifier.NULLABLE, true) : null;
        }
        if (nullabilityQualifierWithMigrationStatus != null) {
            return (nullabilityQualifierWithMigrationStatus.isForWarningOnly() || !(annotationDescriptor instanceof PossiblyExternalAnnotationDescriptor) || !((PossiblyExternalAnnotationDescriptor) annotationDescriptor).isIdeExternalAnnotation()) ? nullabilityQualifierWithMigrationStatus : NullabilityQualifierWithMigrationStatus.copy$default(nullabilityQualifierWithMigrationStatus, null, true, 1, null);
        }
        return null;
    }

    public final <D extends CallableMemberDescriptor> Collection<D> enhanceSignatures(LazyJavaResolverContext lazyJavaResolverContext, Collection<? extends D> collection) {
        Intrinsics.checkNotNullParameter(lazyJavaResolverContext, "c");
        Intrinsics.checkNotNullParameter(collection, "platformSignatures");
        Collection<? extends D> collection2 = collection;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(collection2, 10));
        Iterator<T> it = collection2.iterator();
        while (it.hasNext()) {
            arrayList.add(enhanceSignature(it.next(), lazyJavaResolverContext));
        }
        return arrayList;
    }

    /*  JADX ERROR: IF instruction can be used only in fallback mode
        jadx.core.utils.exceptions.CodegenException: IF instruction can be used only in fallback mode
        	at jadx.core.codegen.InsnGen.fallbackOnlyInsn(InsnGen.java:604)
        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:486)
        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:217)
        	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:110)
        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:56)
        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
        	at jadx.core.codegen.RegionGen.makeLoop(RegionGen.java:194)
        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:67)
        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
        	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:143)
        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
        	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:143)
        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
        	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:244)
        	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:237)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:342)
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:295)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:264)
        	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
        	at java.util.ArrayList.forEach(Unknown Source)
        	at java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
        	at java.util.stream.Sink$ChainedReference.end(Unknown Source)
        */
    /* JADX WARNING: Removed duplicated region for block: B:107:0x01f2  */
    /* JADX WARNING: Removed duplicated region for block: B:127:0x01a9 A[EDGE_INSN: B:127:0x01a9->B:84:0x01a9 ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:129:0x01e6 A[EDGE_INSN: B:129:0x01e6->B:103:0x01e6 ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00b6  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00e8  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x015f  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x0161  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x0181  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x0186  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x01b5  */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x01c5  */
    private final <D extends kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor> D enhanceSignature(D r17, kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext r18) {
        /*
        // Method dump skipped, instructions count: 608
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancement.enhanceSignature(kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor, kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext):kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor");
    }

    private final boolean hasDefaultValueInAnnotation(ValueParameterDescriptor valueParameterDescriptor, KotlinType kotlinType) {
        boolean z;
        AnnotationDefaultValue defaultValueFromAnnotation = UtilKt.getDefaultValueFromAnnotation(valueParameterDescriptor);
        if (defaultValueFromAnnotation instanceof StringDefaultValue) {
            z = UtilsKt.lexicalCastFrom(kotlinType, ((StringDefaultValue) defaultValueFromAnnotation).getValue()) != null;
        } else if (Intrinsics.areEqual(defaultValueFromAnnotation, NullDefaultValue.INSTANCE)) {
            z = TypeUtils.acceptsNullable(kotlinType);
        } else if (defaultValueFromAnnotation == null) {
            z = valueParameterDescriptor.declaresDefaultValue();
        } else {
            throw new NoWhenBranchMatchedException();
        }
        return z && valueParameterDescriptor.getOverriddenDescriptors().isEmpty();
    }

    /* access modifiers changed from: private */
    /* compiled from: signatureEnhancement.kt */
    public final class SignatureParts {
        private final AnnotationTypeQualifierResolver.QualifierApplicabilityType containerApplicabilityType;
        private final LazyJavaResolverContext containerContext;
        private final Collection<KotlinType> fromOverridden;
        private final KotlinType fromOverride;
        private final boolean isCovariant;
        final /* synthetic */ SignatureEnhancement this$0;
        private final Annotated typeContainer;

        /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: java.util.Collection<? extends kotlin.reflect.jvm.internal.impl.types.KotlinType> */
        /* JADX WARN: Multi-variable type inference failed */
        public SignatureParts(SignatureEnhancement signatureEnhancement, Annotated annotated, KotlinType kotlinType, Collection<? extends KotlinType> collection, boolean z, LazyJavaResolverContext lazyJavaResolverContext, AnnotationTypeQualifierResolver.QualifierApplicabilityType qualifierApplicabilityType) {
            Intrinsics.checkNotNullParameter(kotlinType, "fromOverride");
            Intrinsics.checkNotNullParameter(collection, "fromOverridden");
            Intrinsics.checkNotNullParameter(lazyJavaResolverContext, "containerContext");
            Intrinsics.checkNotNullParameter(qualifierApplicabilityType, "containerApplicabilityType");
            this.this$0 = signatureEnhancement;
            this.typeContainer = annotated;
            this.fromOverride = kotlinType;
            this.fromOverridden = collection;
            this.isCovariant = z;
            this.containerContext = lazyJavaResolverContext;
            this.containerApplicabilityType = qualifierApplicabilityType;
        }

        private final boolean isForVarargParameter() {
            Annotated annotated = this.typeContainer;
            KotlinType kotlinType = null;
            if (!(annotated instanceof ValueParameterDescriptor)) {
                annotated = null;
            }
            ValueParameterDescriptor valueParameterDescriptor = (ValueParameterDescriptor) annotated;
            if (valueParameterDescriptor != null) {
                kotlinType = valueParameterDescriptor.getVarargElementType();
            }
            return kotlinType != null;
        }

        public static /* synthetic */ PartEnhancementResult enhance$default(SignatureParts signatureParts, TypeEnhancementInfo typeEnhancementInfo, int i, Object obj) {
            if ((i & 1) != 0) {
                typeEnhancementInfo = null;
            }
            return signatureParts.enhance(typeEnhancementInfo);
        }

        public final PartEnhancementResult enhance(TypeEnhancementInfo typeEnhancementInfo) {
            Function1<Integer, JavaTypeQualifiers> computeIndexedQualifiersForOverride = computeIndexedQualifiersForOverride();
            SignatureEnhancement$SignatureParts$enhance$$inlined$let$lambda$1 signatureEnhancement$SignatureParts$enhance$$inlined$let$lambda$1 = typeEnhancementInfo != null ? new SignatureEnhancement$SignatureParts$enhance$$inlined$let$lambda$1(typeEnhancementInfo, computeIndexedQualifiersForOverride) : null;
            boolean contains = TypeUtils.contains(this.fromOverride, SignatureEnhancement$SignatureParts$enhance$containsFunctionN$1.INSTANCE);
            KotlinType kotlinType = this.fromOverride;
            if (signatureEnhancement$SignatureParts$enhance$$inlined$let$lambda$1 != null) {
                computeIndexedQualifiersForOverride = signatureEnhancement$SignatureParts$enhance$$inlined$let$lambda$1;
            }
            KotlinType enhance = TypeEnhancementKt.enhance(kotlinType, computeIndexedQualifiersForOverride);
            if (enhance != null) {
                return new PartEnhancementResult(enhance, true, contains);
            }
            return new PartEnhancementResult(this.fromOverride, false, contains);
        }

        /* JADX WARNING: Removed duplicated region for block: B:14:0x0048  */
        /* JADX WARNING: Removed duplicated region for block: B:15:0x004b  */
        private final JavaTypeQualifiers extractQualifiers(KotlinType kotlinType) {
            Pair pair;
            NullabilityQualifier nullabilityQualifier;
            MutabilityQualifier mutabilityQualifier;
            NullabilityQualifier nullabilityQualifier2;
            if (FlexibleTypesKt.isFlexible(kotlinType)) {
                FlexibleType asFlexibleType = FlexibleTypesKt.asFlexibleType(kotlinType);
                pair = new Pair(asFlexibleType.getLowerBound(), asFlexibleType.getUpperBound());
            } else {
                pair = new Pair(kotlinType, kotlinType);
            }
            KotlinType kotlinType2 = (KotlinType) pair.component1();
            KotlinType kotlinType3 = (KotlinType) pair.component2();
            JavaToKotlinClassMap javaToKotlinClassMap = JavaToKotlinClassMap.INSTANCE;
            if (kotlinType2.isMarkedNullable()) {
                nullabilityQualifier2 = NullabilityQualifier.NULLABLE;
            } else if (!kotlinType3.isMarkedNullable()) {
                nullabilityQualifier2 = NullabilityQualifier.NOT_NULL;
            } else {
                nullabilityQualifier = null;
                if (!javaToKotlinClassMap.isReadOnly(kotlinType2)) {
                    mutabilityQualifier = MutabilityQualifier.READ_ONLY;
                } else {
                    mutabilityQualifier = javaToKotlinClassMap.isMutable(kotlinType3) ? MutabilityQualifier.MUTABLE : null;
                }
                return new JavaTypeQualifiers(nullabilityQualifier, mutabilityQualifier, kotlinType.unwrap() instanceof NotNullTypeParameter, false, 8, null);
            }
            nullabilityQualifier = nullabilityQualifier2;
            if (!javaToKotlinClassMap.isReadOnly(kotlinType2)) {
            }
            return new JavaTypeQualifiers(nullabilityQualifier, mutabilityQualifier, kotlinType.unwrap() instanceof NotNullTypeParameter, false, 8, null);
        }

        private final JavaTypeQualifiers extractQualifiersFromAnnotations(KotlinType kotlinType, boolean z, JavaTypeQualifiers javaTypeQualifiers) {
            Annotations annotations;
            Annotated annotated;
            if (!z || (annotated = this.typeContainer) == null) {
                annotations = kotlinType.getAnnotations();
            } else {
                annotations = AnnotationsKt.composeAnnotations(annotated.getAnnotations(), kotlinType.getAnnotations());
            }
            SignatureEnhancement$SignatureParts$extractQualifiersFromAnnotations$1 signatureEnhancement$SignatureParts$extractQualifiersFromAnnotations$1 = new SignatureEnhancement$SignatureParts$extractQualifiersFromAnnotations$1(annotations);
            SignatureEnhancement$SignatureParts$extractQualifiersFromAnnotations$2 signatureEnhancement$SignatureParts$extractQualifiersFromAnnotations$2 = SignatureEnhancement$SignatureParts$extractQualifiersFromAnnotations$2.INSTANCE;
            NullabilityQualifier nullabilityQualifier = null;
            if (z) {
                JavaTypeQualifiersByElementType defaultTypeQualifiers = this.containerContext.getDefaultTypeQualifiers();
                javaTypeQualifiers = defaultTypeQualifiers != null ? defaultTypeQualifiers.get(this.containerApplicabilityType) : null;
            }
            NullabilityQualifierWithMigrationStatus extractNullability = extractNullability(annotations);
            if (extractNullability == null) {
                extractNullability = (javaTypeQualifiers == null || javaTypeQualifiers.getNullability() == null) ? null : new NullabilityQualifierWithMigrationStatus(javaTypeQualifiers.getNullability(), javaTypeQualifiers.isNullabilityQualifierForWarning());
            }
            NullabilityQualifier qualifier = extractNullability != null ? extractNullability.getQualifier() : null;
            MutabilityQualifier mutabilityQualifier = (MutabilityQualifier) signatureEnhancement$SignatureParts$extractQualifiersFromAnnotations$2.invoke(signatureEnhancement$SignatureParts$extractQualifiersFromAnnotations$1.invoke(JvmAnnotationNamesKt.getREAD_ONLY_ANNOTATIONS(), (Object) MutabilityQualifier.READ_ONLY), signatureEnhancement$SignatureParts$extractQualifiersFromAnnotations$1.invoke(JvmAnnotationNamesKt.getMUTABLE_ANNOTATIONS(), (Object) MutabilityQualifier.MUTABLE));
            if (extractNullability != null) {
                nullabilityQualifier = extractNullability.getQualifier();
            }
            boolean z2 = false;
            boolean z3 = nullabilityQualifier == NullabilityQualifier.NOT_NULL && TypeUtilsKt.isTypeParameter(kotlinType);
            if (extractNullability != null && extractNullability.isForWarningOnly()) {
                z2 = true;
            }
            return new JavaTypeQualifiers(qualifier, mutabilityQualifier, z3, z2);
        }

        private final NullabilityQualifierWithMigrationStatus extractNullability(Annotations annotations) {
            SignatureEnhancement signatureEnhancement = this.this$0;
            Iterator it = annotations.iterator();
            while (it.hasNext()) {
                NullabilityQualifierWithMigrationStatus extractNullability = signatureEnhancement.extractNullability((AnnotationDescriptor) it.next());
                if (extractNullability != null) {
                    return extractNullability;
                }
            }
            return null;
        }

        /* JADX WARNING: Removed duplicated region for block: B:18:0x0068  */
        /* JADX WARNING: Removed duplicated region for block: B:21:0x006d  */
        /* JADX WARNING: Removed duplicated region for block: B:22:0x006f  */
        /* JADX WARNING: Removed duplicated region for block: B:25:0x0078  */
        private final Function1<Integer, JavaTypeQualifiers> computeIndexedQualifiersForOverride() {
            boolean z;
            int size;
            int i;
            boolean z2;
            Collection<KotlinType> collection = this.fromOverridden;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(collection, 10));
            Iterator<T> it = collection.iterator();
            while (it.hasNext()) {
                arrayList.add(toIndexed(it.next()));
            }
            ArrayList<List> arrayList2 = arrayList;
            List<TypeAndDefaultQualifiers> indexed = toIndexed(this.fromOverride);
            if (this.isCovariant) {
                Collection<KotlinType> collection2 = this.fromOverridden;
                if (!(collection2 instanceof Collection) || !collection2.isEmpty()) {
                    Iterator<T> it2 = collection2.iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            break;
                        }
                        if (!KotlinTypeChecker.DEFAULT.equalTypes(it2.next(), this.fromOverride)) {
                            z2 = true;
                            break;
                        }
                    }
                    if (z2) {
                        z = true;
                        size = !z ? 1 : indexed.size();
                        JavaTypeQualifiers[] javaTypeQualifiersArr = new JavaTypeQualifiers[size];
                        i = 0;
                        while (i < size) {
                            boolean z3 = i == 0;
                            TypeAndDefaultQualifiers typeAndDefaultQualifiers = indexed.get(i);
                            KotlinType component1 = typeAndDefaultQualifiers.component1();
                            JavaTypeQualifiers component2 = typeAndDefaultQualifiers.component2();
                            ArrayList arrayList3 = new ArrayList();
                            for (List list : arrayList2) {
                                TypeAndDefaultQualifiers typeAndDefaultQualifiers2 = (TypeAndDefaultQualifiers) CollectionsKt.getOrNull(list, i);
                                KotlinType type = typeAndDefaultQualifiers2 != null ? typeAndDefaultQualifiers2.getType() : null;
                                if (type != null) {
                                    arrayList3.add(type);
                                }
                            }
                            javaTypeQualifiersArr[i] = computeQualifiersForOverride(component1, arrayList3, component2, z3);
                            i++;
                        }
                        return new SignatureEnhancement$SignatureParts$computeIndexedQualifiersForOverride$1(javaTypeQualifiersArr);
                    }
                }
                z2 = false;
                if (z2) {
                }
            }
            z = false;
            if (!z) {
            }
            JavaTypeQualifiers[] javaTypeQualifiersArr2 = new JavaTypeQualifiers[size];
            i = 0;
            while (i < size) {
            }
            return new SignatureEnhancement$SignatureParts$computeIndexedQualifiersForOverride$1(javaTypeQualifiersArr2);
        }

        private final List<TypeAndDefaultQualifiers> toIndexed(KotlinType kotlinType) {
            ArrayList arrayList = new ArrayList(1);
            new SignatureEnhancement$SignatureParts$toIndexed$1(arrayList).invoke(kotlinType, this.containerContext);
            return arrayList;
        }

        /* JADX WARNING: Removed duplicated region for block: B:72:0x0149  */
        private final JavaTypeQualifiers computeQualifiersForOverride(KotlinType kotlinType, Collection<? extends KotlinType> collection, JavaTypeQualifiers javaTypeQualifiers, boolean z) {
            boolean z2;
            boolean z3;
            Collection<? extends KotlinType> collection2 = collection;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(collection2, 10));
            Iterator<T> it = collection2.iterator();
            while (it.hasNext()) {
                arrayList.add(extractQualifiers(it.next()));
            }
            ArrayList<JavaTypeQualifiers> arrayList2 = arrayList;
            ArrayList arrayList3 = new ArrayList();
            for (JavaTypeQualifiers javaTypeQualifiers2 : arrayList2) {
                MutabilityQualifier mutability = javaTypeQualifiers2.getMutability();
                if (mutability != null) {
                    arrayList3.add(mutability);
                }
            }
            Set set = CollectionsKt.toSet(arrayList3);
            ArrayList arrayList4 = new ArrayList();
            for (JavaTypeQualifiers javaTypeQualifiers3 : arrayList2) {
                NullabilityQualifier nullability = javaTypeQualifiers3.getNullability();
                if (nullability != null) {
                    arrayList4.add(nullability);
                }
            }
            Set set2 = CollectionsKt.toSet(arrayList4);
            ArrayList arrayList5 = new ArrayList();
            Iterator<T> it2 = collection2.iterator();
            while (it2.hasNext()) {
                NullabilityQualifier nullability2 = extractQualifiers(TypeWithEnhancementKt.unwrapEnhancement(it2.next())).getNullability();
                if (nullability2 != null) {
                    arrayList5.add(nullability2);
                }
            }
            Set set3 = CollectionsKt.toSet(arrayList5);
            JavaTypeQualifiers extractQualifiersFromAnnotations = extractQualifiersFromAnnotations(kotlinType, z, javaTypeQualifiers);
            boolean z4 = true;
            NullabilityQualifier nullabilityQualifier = null;
            JavaTypeQualifiers javaTypeQualifiers4 = extractQualifiersFromAnnotations.isNullabilityQualifierForWarning() ^ true ? extractQualifiersFromAnnotations : null;
            NullabilityQualifier nullability3 = javaTypeQualifiers4 != null ? javaTypeQualifiers4.getNullability() : null;
            NullabilityQualifier nullability4 = extractQualifiersFromAnnotations.getNullability();
            boolean z5 = this.isCovariant && z;
            NullabilityQualifier select = SignatureEnhancementKt.select(set2, nullability3, z5);
            if (select != null) {
                if (!(isForVarargParameter() && z && select == NullabilityQualifier.NULLABLE)) {
                    nullabilityQualifier = select;
                }
            }
            MutabilityQualifier mutabilityQualifier = (MutabilityQualifier) SignatureEnhancementKt.select(set, MutabilityQualifier.MUTABLE, MutabilityQualifier.READ_ONLY, extractQualifiersFromAnnotations.getMutability(), z5);
            boolean z6 = nullability4 != nullability3 || (Intrinsics.areEqual(set3, set2) ^ true);
            if (!extractQualifiersFromAnnotations.isNotNullTypeParameter()) {
                if (!(arrayList2 instanceof Collection) || !arrayList2.isEmpty()) {
                    Iterator it3 = arrayList2.iterator();
                    while (true) {
                        if (it3.hasNext()) {
                            if (((JavaTypeQualifiers) it3.next()).isNotNullTypeParameter()) {
                                z3 = true;
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                }
                z3 = false;
                if (!z3) {
                    z2 = false;
                    if (nullabilityQualifier != null && z6) {
                        return SignatureEnhancementKt.createJavaTypeQualifiers(SignatureEnhancementKt.select(set3, nullability4, z5), mutabilityQualifier, true, z2);
                    }
                    if (nullabilityQualifier != null) {
                        z4 = false;
                    }
                    return SignatureEnhancementKt.createJavaTypeQualifiers(nullabilityQualifier, mutabilityQualifier, z4, z2);
                }
            }
            z2 = true;
            if (nullabilityQualifier != null) {
            }
            if (nullabilityQualifier != null) {
            }
            return SignatureEnhancementKt.createJavaTypeQualifiers(nullabilityQualifier, mutabilityQualifier, z4, z2);
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: signatureEnhancement.kt */
    public static class PartEnhancementResult {
        private final boolean containsFunctionN;
        private final KotlinType type;
        private final boolean wereChanges;

        public PartEnhancementResult(KotlinType kotlinType, boolean z, boolean z2) {
            Intrinsics.checkNotNullParameter(kotlinType, "type");
            this.type = kotlinType;
            this.wereChanges = z;
            this.containsFunctionN = z2;
        }

        public final KotlinType getType() {
            return this.type;
        }

        public final boolean getWereChanges() {
            return this.wereChanges;
        }

        public final boolean getContainsFunctionN() {
            return this.containsFunctionN;
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: signatureEnhancement.kt */
    public static final class ValueParameterEnhancementResult extends PartEnhancementResult {
        private final boolean hasDefaultValue;

        public final boolean getHasDefaultValue() {
            return this.hasDefaultValue;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ValueParameterEnhancementResult(KotlinType kotlinType, boolean z, boolean z2, boolean z3) {
            super(kotlinType, z2, z3);
            Intrinsics.checkNotNullParameter(kotlinType, "type");
            this.hasDefaultValue = z;
        }
    }

    private final SignatureParts partsForValueParameter(CallableMemberDescriptor callableMemberDescriptor, ValueParameterDescriptor valueParameterDescriptor, LazyJavaResolverContext lazyJavaResolverContext, Function1<? super CallableMemberDescriptor, ? extends KotlinType> function1) {
        LazyJavaResolverContext copyWithNewDefaultTypeQualifiers;
        return parts(callableMemberDescriptor, valueParameterDescriptor, false, (valueParameterDescriptor == null || (copyWithNewDefaultTypeQualifiers = ContextKt.copyWithNewDefaultTypeQualifiers(lazyJavaResolverContext, valueParameterDescriptor.getAnnotations())) == null) ? lazyJavaResolverContext : copyWithNewDefaultTypeQualifiers, AnnotationTypeQualifierResolver.QualifierApplicabilityType.VALUE_PARAMETER, function1);
    }

    private final SignatureParts parts(CallableMemberDescriptor callableMemberDescriptor, Annotated annotated, boolean z, LazyJavaResolverContext lazyJavaResolverContext, AnnotationTypeQualifierResolver.QualifierApplicabilityType qualifierApplicabilityType, Function1<? super CallableMemberDescriptor, ? extends KotlinType> function1) {
        KotlinType kotlinType = (KotlinType) function1.invoke(callableMemberDescriptor);
        Collection<? extends CallableMemberDescriptor> overriddenDescriptors = callableMemberDescriptor.getOverriddenDescriptors();
        Intrinsics.checkNotNullExpressionValue(overriddenDescriptors, "this.overriddenDescriptors");
        Collection<? extends CallableMemberDescriptor> collection = overriddenDescriptors;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(collection, 10));
        for (T t : collection) {
            Intrinsics.checkNotNullExpressionValue(t, "it");
            arrayList.add((KotlinType) function1.invoke(t));
        }
        return new SignatureParts(this, annotated, kotlinType, arrayList, z, ContextKt.copyWithNewDefaultTypeQualifiers(lazyJavaResolverContext, ((KotlinType) function1.invoke(callableMemberDescriptor)).getAnnotations()), qualifierApplicabilityType);
    }
}
