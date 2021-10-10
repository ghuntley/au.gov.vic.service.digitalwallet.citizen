package com.digitalwallet.app.viewmodel.main;

import com.digitalwallet.app.model.db.unsecure.UnsecuredHolding;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u0016\u0012\u0004\u0012\u00020\u0002 \u0003*\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00010\u00012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "Lcom/digitalwallet/app/model/db/unsecure/UnsecuredHolding;", "kotlin.jvm.PlatformType", "holdings", "apply"}, k = 3, mv = {1, 4, 0})
/* compiled from: MainActivityViewModel.kt */
public final class MainActivityViewModel$refreshNotifications$1<T, R> implements Function<List<? extends UnsecuredHolding>, List<? extends UnsecuredHolding>> {
    final /* synthetic */ String $activeNotifiedLink;

    MainActivityViewModel$refreshNotifications$1(String str) {
        this.$activeNotifiedLink = str;
    }

    public final List<UnsecuredHolding> apply(List<? extends UnsecuredHolding> list) {
        Intrinsics.checkNotNullParameter(list, "holdings");
        ArrayList arrayList = new ArrayList();
        for (T t : list) {
            if (!Intrinsics.areEqual(t.getLink(), this.$activeNotifiedLink)) {
                arrayList.add(t);
            }
        }
        return arrayList;
    }
}
