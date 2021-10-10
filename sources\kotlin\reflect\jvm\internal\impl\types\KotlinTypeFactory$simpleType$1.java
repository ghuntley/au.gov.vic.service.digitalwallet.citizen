package kotlin.reflect.jvm.internal.impl.types;

import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;

/* access modifiers changed from: package-private */
/* compiled from: KotlinTypeFactory.kt */
public final class KotlinTypeFactory$simpleType$1 extends Lambda implements Function1<KotlinTypeRefiner, SimpleType> {
    final /* synthetic */ Annotations $annotations;
    final /* synthetic */ List $arguments;
    final /* synthetic */ TypeConstructor $constructor;
    final /* synthetic */ boolean $nullable;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    KotlinTypeFactory$simpleType$1(TypeConstructor typeConstructor, List list, Annotations annotations, boolean z) {
        super(1);
        this.$constructor = typeConstructor;
        this.$arguments = list;
        this.$annotations = annotations;
        this.$nullable = z;
    }

    public final SimpleType invoke(KotlinTypeRefiner kotlinTypeRefiner) {
        Intrinsics.checkNotNullParameter(kotlinTypeRefiner, "refiner");
        KotlinTypeFactory.ExpandedTypeOrRefinedConstructor expandedTypeOrRefinedConstructor = KotlinTypeFactory.INSTANCE.refineConstructor(this.$constructor, kotlinTypeRefiner, this.$arguments);
        if (expandedTypeOrRefinedConstructor == null) {
            return null;
        }
        SimpleType expandedType = expandedTypeOrRefinedConstructor.getExpandedType();
        if (expandedType != null) {
            return expandedType;
        }
        Annotations annotations = this.$annotations;
        TypeConstructor refinedConstructor = expandedTypeOrRefinedConstructor.getRefinedConstructor();
        Intrinsics.checkNotNull(refinedConstructor);
        return KotlinTypeFactory.simpleType(annotations, refinedConstructor, this.$arguments, this.$nullable, kotlinTypeRefiner);
    }
}
