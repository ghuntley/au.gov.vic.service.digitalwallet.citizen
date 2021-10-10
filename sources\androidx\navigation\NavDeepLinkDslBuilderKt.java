package androidx.navigation;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u001f\u0010\u0000\u001a\u00020\u00012\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006¨\u0006\u0007"}, d2 = {"navDeepLink", "Landroidx/navigation/NavDeepLink;", "deepLinkBuilder", "Lkotlin/Function1;", "Landroidx/navigation/NavDeepLinkDslBuilder;", "", "Lkotlin/ExtensionFunctionType;", "navigation-common-ktx_release"}, k = 2, mv = {1, 1, 16})
/* compiled from: NavDeepLinkDslBuilder.kt */
public final class NavDeepLinkDslBuilderKt {
    public static final NavDeepLink navDeepLink(Function1<? super NavDeepLinkDslBuilder, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(function1, "deepLinkBuilder");
        NavDeepLinkDslBuilder navDeepLinkDslBuilder = new NavDeepLinkDslBuilder();
        function1.invoke(navDeepLinkDslBuilder);
        return navDeepLinkDslBuilder.build$navigation_common_ktx_release();
    }
}
