package kotlin.reflect.jvm.internal.impl.types.checker;

import java.util.Objects;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.types.AbstractTypeCheckerContext;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker;

/* compiled from: ClassicTypeCheckerContext.kt */
public final class ClassicTypeCheckerContext$Companion$classicSubstitutionSupertypePolicy$2 extends AbstractTypeCheckerContext.SupertypesPolicy.DoCustomTransform {
    final /* synthetic */ TypeSubstitutor $substitutor;
    final /* synthetic */ ClassicTypeSystemContext $this_classicSubstitutionSupertypePolicy;

    ClassicTypeCheckerContext$Companion$classicSubstitutionSupertypePolicy$2(ClassicTypeSystemContext classicTypeSystemContext, TypeSubstitutor typeSubstitutor) {
        this.$this_classicSubstitutionSupertypePolicy = classicTypeSystemContext;
        this.$substitutor = typeSubstitutor;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.AbstractTypeCheckerContext.SupertypesPolicy
    public SimpleTypeMarker transformType(AbstractTypeCheckerContext abstractTypeCheckerContext, KotlinTypeMarker kotlinTypeMarker) {
        Intrinsics.checkNotNullParameter(abstractTypeCheckerContext, "context");
        Intrinsics.checkNotNullParameter(kotlinTypeMarker, "type");
        ClassicTypeSystemContext classicTypeSystemContext = this.$this_classicSubstitutionSupertypePolicy;
        TypeSubstitutor typeSubstitutor = this.$substitutor;
        SimpleTypeMarker lowerBoundIfFlexible = classicTypeSystemContext.lowerBoundIfFlexible(kotlinTypeMarker);
        Objects.requireNonNull(lowerBoundIfFlexible, "null cannot be cast to non-null type org.jetbrains.kotlin.types.KotlinType");
        KotlinType safeSubstitute = typeSubstitutor.safeSubstitute((KotlinType) lowerBoundIfFlexible, Variance.INVARIANT);
        Intrinsics.checkNotNullExpressionValue(safeSubstitute, "substitutor.safeSubstitu…ANT\n                    )");
        SimpleTypeMarker asSimpleType = classicTypeSystemContext.asSimpleType(safeSubstitute);
        Intrinsics.checkNotNull(asSimpleType);
        return asSimpleType;
    }
}
