package com.digitalwallet.app.holdings;

import com.digitalwallet.app.model.SecureHolding;
import com.digitalwallet.utilities.AppType;
import com.digitalwallet.utilities.ServerTypeKt;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u0016\u0012\u0004\u0012\u00020\u0002 \u0003*\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00010\u00012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "Lcom/digitalwallet/app/model/SecureHolding;", "kotlin.jvm.PlatformType", "holdings", "apply"}, k = 3, mv = {1, 4, 0})
/* compiled from: HoldingsService.kt */
public final class HoldingsService$refreshSecureHoldings$1<T, R> implements Function<List<? extends SecureHolding>, List<? extends SecureHolding>> {
    public static final HoldingsService$refreshSecureHoldings$1 INSTANCE = new HoldingsService$refreshSecureHoldings$1();

    HoldingsService$refreshSecureHoldings$1() {
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Function
    public /* bridge */ /* synthetic */ List<? extends SecureHolding> apply(List<? extends SecureHolding> list) {
        return apply((List<SecureHolding>) list);
    }

    public final List<SecureHolding> apply(List<SecureHolding> list) {
        Intrinsics.checkNotNullParameter(list, "holdings");
        ArrayList arrayList = new ArrayList();
        for (T t : list) {
            if (ServerTypeKt.getAppType() == AppType.CITIZEN || t.getAttributes().getSharingCode() != null) {
                arrayList.add(t);
            }
        }
        return arrayList;
    }
}
