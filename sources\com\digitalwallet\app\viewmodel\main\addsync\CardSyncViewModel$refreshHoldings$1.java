package com.digitalwallet.app.viewmodel.main.addsync;

import com.digitalwallet.app.model.SecureHolding;
import com.digitalwallet.app.model.db.unsecure.UnsecuredHolding;
import io.reactivex.functions.BiFunction;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00020\u00012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u0002H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "Lkotlin/Pair;", "", "Lcom/digitalwallet/app/model/db/unsecure/UnsecuredHolding;", "Lcom/digitalwallet/app/model/SecureHolding;", "a", "b", "apply"}, k = 3, mv = {1, 4, 0})
/* compiled from: CardSyncViewModel.kt */
public final class CardSyncViewModel$refreshHoldings$1<T1, T2, R> implements BiFunction<List<? extends UnsecuredHolding>, List<? extends SecureHolding>, Pair<? extends List<? extends UnsecuredHolding>, ? extends List<? extends SecureHolding>>> {
    public static final CardSyncViewModel$refreshHoldings$1 INSTANCE = new CardSyncViewModel$refreshHoldings$1();

    CardSyncViewModel$refreshHoldings$1() {
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // io.reactivex.functions.BiFunction
    public /* bridge */ /* synthetic */ Pair<? extends List<? extends UnsecuredHolding>, ? extends List<? extends SecureHolding>> apply(List<? extends UnsecuredHolding> list, List<? extends SecureHolding> list2) {
        return apply(list, (List<SecureHolding>) list2);
    }

    public final Pair<List<UnsecuredHolding>, List<SecureHolding>> apply(List<? extends UnsecuredHolding> list, List<SecureHolding> list2) {
        Intrinsics.checkNotNullParameter(list, "a");
        Intrinsics.checkNotNullParameter(list2, "b");
        return new Pair<>(list, list2);
    }
}
