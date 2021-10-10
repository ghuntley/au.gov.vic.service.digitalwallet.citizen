package com.digitalwallet.app.viewmodel.main.sharing;

import com.digitalwallet.app.model.SecureHolding;
import io.reactivex.Maybe;
import io.reactivex.MaybeSource;
import io.reactivex.functions.Function;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\u0010\u0000\u001a*\u0012\u000e\b\u0001\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002 \u0003*\u0014\u0012\u000e\b\u0001\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002\u0018\u00010\u00010\u00012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "Lio/reactivex/MaybeSource;", "Lcom/digitalwallet/app/model/SecureHolding;", "kotlin.jvm.PlatformType", "allHoldings", "", "apply"}, k = 3, mv = {1, 4, 0})
/* compiled from: IncomingRequestFragmentViewModel.kt */
public final class IncomingRequestFragmentViewModel$fetchRequestedHolding$1<T, R> implements Function<List<? extends SecureHolding>, MaybeSource<? extends SecureHolding>> {
    final /* synthetic */ String $sharingCode;

    IncomingRequestFragmentViewModel$fetchRequestedHolding$1(String str) {
        this.$sharingCode = str;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Function
    public /* bridge */ /* synthetic */ MaybeSource<? extends SecureHolding> apply(List<? extends SecureHolding> list) {
        return apply((List<SecureHolding>) list);
    }

    public final MaybeSource<? extends SecureHolding> apply(List<SecureHolding> list) {
        T t;
        Maybe just;
        Intrinsics.checkNotNullParameter(list, "allHoldings");
        Iterator<T> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                t = null;
                break;
            }
            t = it.next();
            if (Intrinsics.areEqual(t.getAttributes().getSharingCode(), this.$sharingCode)) {
                break;
            }
        }
        T t2 = t;
        if (t2 == null || (just = Maybe.just(t2)) == null) {
            return Maybe.empty();
        }
        return just;
    }
}
