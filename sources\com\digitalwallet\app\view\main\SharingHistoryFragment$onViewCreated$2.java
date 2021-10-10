package com.digitalwallet.app.view.main;

import com.digitalwallet.app.model.db.shares.ShareRecord;
import io.reactivex.functions.Function;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\u0010\u0000\u001a\u0016\u0012\u0004\u0012\u00020\u0002 \u0003*\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00010\u00012\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "Lcom/digitalwallet/app/model/db/shares/ShareRecord;", "kotlin.jvm.PlatformType", "it", "", "apply"}, k = 3, mv = {1, 4, 0})
/* compiled from: SharingHistoryFragment.kt */
final class SharingHistoryFragment$onViewCreated$2<T, R> implements Function<Throwable, List<? extends ShareRecord>> {
    public static final SharingHistoryFragment$onViewCreated$2 INSTANCE = new SharingHistoryFragment$onViewCreated$2();

    SharingHistoryFragment$onViewCreated$2() {
    }

    public final List<ShareRecord> apply(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        return CollectionsKt.emptyList();
    }
}
