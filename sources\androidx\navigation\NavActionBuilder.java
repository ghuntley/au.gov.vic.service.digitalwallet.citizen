package androidx.navigation;

import android.os.Bundle;
import androidx.core.os.BundleKt;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@NavDestinationDsl
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\r\u0010\u0010\u001a\u00020\u0011H\u0000¢\u0006\u0002\b\u0012J\u001f\u0010\u000e\u001a\u00020\u00132\u0017\u0010\u0014\u001a\u0013\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00130\u0015¢\u0006\u0002\b\u0017R\u001f\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Landroidx/navigation/NavActionBuilder;", "", "()V", "defaultArguments", "", "", "getDefaultArguments", "()Ljava/util/Map;", "destinationId", "", "getDestinationId", "()I", "setDestinationId", "(I)V", "navOptions", "Landroidx/navigation/NavOptions;", "build", "Landroidx/navigation/NavAction;", "build$navigation_common_ktx_release", "", "optionsBuilder", "Lkotlin/Function1;", "Landroidx/navigation/NavOptionsBuilder;", "Lkotlin/ExtensionFunctionType;", "navigation-common-ktx_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: NavDestinationBuilder.kt */
public final class NavActionBuilder {
    private final Map<String, Object> defaultArguments = new LinkedHashMap();
    private int destinationId;
    private NavOptions navOptions;

    public final int getDestinationId() {
        return this.destinationId;
    }

    public final void setDestinationId(int i) {
        this.destinationId = i;
    }

    public final Map<String, Object> getDefaultArguments() {
        return this.defaultArguments;
    }

    public final void navOptions(Function1<? super NavOptionsBuilder, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(function1, "optionsBuilder");
        NavOptionsBuilder navOptionsBuilder = new NavOptionsBuilder();
        function1.invoke(navOptionsBuilder);
        this.navOptions = navOptionsBuilder.build$navigation_common_ktx_release();
    }

    public final NavAction build$navigation_common_ktx_release() {
        Bundle bundle;
        int i = this.destinationId;
        NavOptions navOptions2 = this.navOptions;
        if (this.defaultArguments.isEmpty()) {
            bundle = null;
        } else {
            Object[] array = MapsKt.toList(this.defaultArguments).toArray(new Pair[0]);
            if (array != null) {
                Pair[] pairArr = (Pair[]) array;
                bundle = BundleKt.bundleOf((Pair[]) Arrays.copyOf(pairArr, pairArr.length));
            } else {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
            }
        }
        return new NavAction(i, navOptions2, bundle);
    }
}
