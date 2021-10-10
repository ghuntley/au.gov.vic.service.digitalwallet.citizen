package kotlin.reflect.jvm.internal;

import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.KTypeProjection;
import kotlin.reflect.jvm.internal.KTypeImpl;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0016\u0012\u0004\u0012\u00020\u0002 \u0003*\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "Lkotlin/reflect/KTypeProjection;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 4, 0})
/* compiled from: KTypeImpl.kt */
public final class KTypeImpl$arguments$2 extends Lambda implements Function0<List<? extends KTypeProjection>> {
    final /* synthetic */ Function0 $computeJavaType;
    final /* synthetic */ KTypeImpl this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    KTypeImpl$arguments$2(KTypeImpl kTypeImpl, Function0 function0) {
        super(0);
        this.this$0 = kTypeImpl;
        this.$computeJavaType = function0;
    }

    /* Return type fixed from 'java.util.List<kotlin.reflect.KTypeProjection>' to match base method */
    @Override // kotlin.jvm.functions.Function0
    public final List<? extends KTypeProjection> invoke() {
        KTypeProjection kTypeProjection;
        List<TypeProjection> arguments = this.this$0.getType().getArguments();
        if (arguments.isEmpty()) {
            return CollectionsKt.emptyList();
        }
        Lazy lazy = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, (Function0) new KTypeImpl$arguments$2$parameterizedTypeArguments$2(this));
        List<TypeProjection> list = arguments;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        int i = 0;
        for (T t : list) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            T t2 = t;
            if (t2.isStarProjection()) {
                kTypeProjection = KTypeProjection.Companion.getSTAR();
            } else {
                KotlinType type = t2.getType();
                Intrinsics.checkNotNullExpressionValue(type, "typeProjection.type");
                KTypeImpl$arguments$2$$special$$inlined$mapIndexed$lambda$1 kTypeImpl$arguments$2$$special$$inlined$mapIndexed$lambda$1 = null;
                if (this.$computeJavaType != null) {
                    kTypeImpl$arguments$2$$special$$inlined$mapIndexed$lambda$1 = new KTypeImpl$arguments$2$$special$$inlined$mapIndexed$lambda$1(i, this, lazy, null);
                }
                KTypeImpl kTypeImpl = new KTypeImpl(type, kTypeImpl$arguments$2$$special$$inlined$mapIndexed$lambda$1);
                int i3 = KTypeImpl.WhenMappings.$EnumSwitchMapping$0[t2.getProjectionKind().ordinal()];
                if (i3 == 1) {
                    kTypeProjection = KTypeProjection.Companion.invariant(kTypeImpl);
                } else if (i3 == 2) {
                    kTypeProjection = KTypeProjection.Companion.contravariant(kTypeImpl);
                } else if (i3 == 3) {
                    kTypeProjection = KTypeProjection.Companion.covariant(kTypeImpl);
                } else {
                    throw new NoWhenBranchMatchedException();
                }
            }
            arrayList.add(kTypeProjection);
            i = i2;
        }
        return arrayList;
    }
}
