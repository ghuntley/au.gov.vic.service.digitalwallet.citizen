package kotlin.reflect.jvm.internal.impl.types;

import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;

/* access modifiers changed from: package-private */
/* compiled from: KotlinTypeFactory.kt */
public final class KotlinTypeFactory$simpleTypeWithNonTrivialMemberScope$1 extends Lambda implements Function1<KotlinTypeRefiner, SimpleType> {
    final /* synthetic */ Annotations $annotations;
    final /* synthetic */ List $arguments;
    final /* synthetic */ TypeConstructor $constructor;
    final /* synthetic */ MemberScope $memberScope;
    final /* synthetic */ boolean $nullable;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    KotlinTypeFactory$simpleTypeWithNonTrivialMemberScope$1(TypeConstructor typeConstructor, List list, Annotations annotations, boolean z, MemberScope memberScope) {
        super(1);
        this.$constructor = typeConstructor;
        this.$arguments = list;
        this.$annotations = annotations;
        this.$nullable = z;
        this.$memberScope = memberScope;
    }

    public final SimpleType invoke(KotlinTypeRefiner kotlinTypeRefiner) {
        Intrinsics.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefiner");
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
        return KotlinTypeFactory.simpleTypeWithNonTrivialMemberScope(annotations, refinedConstructor, this.$arguments, this.$nullable, this.$memberScope);
    }
}
