package kotlin.reflect.jvm.internal.impl.resolve;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.utils.SmartSet;

/* access modifiers changed from: package-private */
/* compiled from: overridingUtils.kt */
public final class OverridingUtilsKt$selectMostSpecificInEachOverridableGroup$overridableGroup$1 extends Lambda implements Function1<H, Unit> {
    final /* synthetic */ SmartSet $conflictedHandles;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    OverridingUtilsKt$selectMostSpecificInEachOverridableGroup$overridableGroup$1(SmartSet smartSet) {
        super(1);
        this.$conflictedHandles = smartSet;
    }

    @Override // kotlin.jvm.functions.Function1
    public final void invoke(H h) {
        SmartSet smartSet = this.$conflictedHandles;
        Intrinsics.checkNotNullExpressionValue(h, "it");
        smartSet.add(h);
    }
}
