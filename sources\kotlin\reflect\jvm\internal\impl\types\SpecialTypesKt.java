package kotlin.reflect.jvm.internal.impl.types;

import java.util.ArrayList;
import java.util.Collection;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.types.checker.NewCapturedType;

/* compiled from: SpecialTypes.kt */
public final class SpecialTypesKt {
    public static final AbbreviatedType getAbbreviatedType(KotlinType kotlinType) {
        Intrinsics.checkNotNullParameter(kotlinType, "$this$getAbbreviatedType");
        UnwrappedType unwrap = kotlinType.unwrap();
        if (!(unwrap instanceof AbbreviatedType)) {
            unwrap = null;
        }
        return (AbbreviatedType) unwrap;
    }

    public static final SimpleType getAbbreviation(KotlinType kotlinType) {
        Intrinsics.checkNotNullParameter(kotlinType, "$this$getAbbreviation");
        AbbreviatedType abbreviatedType = getAbbreviatedType(kotlinType);
        if (abbreviatedType != null) {
            return abbreviatedType.getAbbreviation();
        }
        return null;
    }

    public static final SimpleType withAbbreviation(SimpleType simpleType, SimpleType simpleType2) {
        Intrinsics.checkNotNullParameter(simpleType, "$this$withAbbreviation");
        Intrinsics.checkNotNullParameter(simpleType2, "abbreviatedType");
        if (KotlinTypeKt.isError(simpleType)) {
            return simpleType;
        }
        return new AbbreviatedType(simpleType, simpleType2);
    }

    public static final boolean isDefinitelyNotNullType(KotlinType kotlinType) {
        Intrinsics.checkNotNullParameter(kotlinType, "$this$isDefinitelyNotNullType");
        return kotlinType.unwrap() instanceof DefinitelyNotNullType;
    }

    public static final SimpleType makeSimpleTypeDefinitelyNotNullOrNotNull(SimpleType simpleType) {
        DefinitelyNotNullType definitelyNotNullType;
        Intrinsics.checkNotNullParameter(simpleType, "$this$makeSimpleTypeDefinitelyNotNullOrNotNull");
        DefinitelyNotNullType makeDefinitelyNotNull$descriptors = DefinitelyNotNullType.Companion.makeDefinitelyNotNull$descriptors(simpleType);
        if (makeDefinitelyNotNull$descriptors != null) {
            definitelyNotNullType = makeDefinitelyNotNull$descriptors;
        } else {
            definitelyNotNullType = makeIntersectionTypeDefinitelyNotNullOrNotNull(simpleType);
        }
        return definitelyNotNullType != null ? definitelyNotNullType : simpleType.makeNullableAsSpecified(false);
    }

    public static final NewCapturedType withNotNullProjection(NewCapturedType newCapturedType) {
        Intrinsics.checkNotNullParameter(newCapturedType, "$this$withNotNullProjection");
        return new NewCapturedType(newCapturedType.getCaptureStatus(), newCapturedType.getConstructor(), newCapturedType.getLowerType(), newCapturedType.getAnnotations(), newCapturedType.isMarkedNullable(), true);
    }

    public static final UnwrappedType makeDefinitelyNotNullOrNotNull(UnwrappedType unwrappedType) {
        DefinitelyNotNullType definitelyNotNullType;
        Intrinsics.checkNotNullParameter(unwrappedType, "$this$makeDefinitelyNotNullOrNotNull");
        DefinitelyNotNullType makeDefinitelyNotNull$descriptors = DefinitelyNotNullType.Companion.makeDefinitelyNotNull$descriptors(unwrappedType);
        if (makeDefinitelyNotNull$descriptors != null) {
            definitelyNotNullType = makeDefinitelyNotNull$descriptors;
        } else {
            definitelyNotNullType = makeIntersectionTypeDefinitelyNotNullOrNotNull(unwrappedType);
        }
        if (definitelyNotNullType != null) {
            return definitelyNotNullType;
        }
        return unwrappedType.makeNullableAsSpecified(false);
    }

    private static final SimpleType makeIntersectionTypeDefinitelyNotNullOrNotNull(KotlinType kotlinType) {
        IntersectionTypeConstructor makeDefinitelyNotNullOrNotNull;
        TypeConstructor constructor = kotlinType.getConstructor();
        if (!(constructor instanceof IntersectionTypeConstructor)) {
            constructor = null;
        }
        IntersectionTypeConstructor intersectionTypeConstructor = (IntersectionTypeConstructor) constructor;
        if (intersectionTypeConstructor == null || (makeDefinitelyNotNullOrNotNull = makeDefinitelyNotNullOrNotNull(intersectionTypeConstructor)) == null) {
            return null;
        }
        return makeDefinitelyNotNullOrNotNull.createType();
    }

    private static final IntersectionTypeConstructor makeDefinitelyNotNullOrNotNull(IntersectionTypeConstructor intersectionTypeConstructor) {
        Collection<KotlinType> supertypes = intersectionTypeConstructor.getSupertypes();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(supertypes, 10));
        boolean z = false;
        for (T t : supertypes) {
            if (TypeUtils.isNullableType(t)) {
                z = true;
                t = (T) makeDefinitelyNotNullOrNotNull(t.unwrap());
            }
            arrayList.add(t);
        }
        ArrayList arrayList2 = arrayList;
        KotlinType kotlinType = null;
        if (!z) {
            return null;
        }
        UnwrappedType alternativeType = intersectionTypeConstructor.getAlternativeType();
        if (alternativeType != null) {
            if (TypeUtils.isNullableType(alternativeType)) {
                alternativeType = makeDefinitelyNotNullOrNotNull(alternativeType.unwrap());
            }
            kotlinType = alternativeType;
        }
        return new IntersectionTypeConstructor(arrayList2).setAlternative(kotlinType);
    }
}
