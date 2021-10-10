package com.digitalwallet.view.checkIn.checkInShortcut;

import android.view.View;
import com.google.android.gms.analytics.ecommerce.Promotion;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a5\u0010\u0000\u001a\u00020\u0001*\u00020\u00022#\b\u0004\u0010\u0003\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\u00010\u0004H\bø\u0001\u0000\u0002\u0007\n\u0005\b20\u0001¨\u0006\b"}, d2 = {"doOnEachNextLayout", "", "Landroid/view/View;", "action", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", Promotion.ACTION_VIEW, "base_citizenProdRelease"}, k = 2, mv = {1, 4, 0})
/* compiled from: HeaderItemDecoration.kt */
public final class HeaderItemDecorationKt {
    public static final void doOnEachNextLayout(View view, Function1<? super View, Unit> function1) {
        Intrinsics.checkNotNullParameter(view, "$this$doOnEachNextLayout");
        Intrinsics.checkNotNullParameter(function1, "action");
        view.addOnLayoutChangeListener(new HeaderItemDecorationKt$doOnEachNextLayout$1(function1));
    }
}
