package com.digitalwallet.app.view.main;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;
import com.digitalwallet.app.R;
import com.digitalwallet.app.model.db.shares.ShareRecord;
import com.digitalwallet.app.view.main.HoldingDetailFragment;
import com.digitalwallet.app.view.main.SharingDetailsFragment;
import com.digitalwallet.app.view.main.SharingHistoryFragment;
import com.digitalwallet.app.view.main.adapter.SharesAdapter;
import com.digitalwallet.utilities.ServerTypeKt;
import com.digitalwallet.view.base.BasicFragment;
import com.google.firebase.analytics.FirebaseAnalytics;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u001a\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004 \u0005*\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "shares", "", "Lcom/digitalwallet/app/model/db/shares/ShareRecord;", "kotlin.jvm.PlatformType", "accept"}, k = 3, mv = {1, 4, 0})
/* compiled from: SharingHistoryFragment.kt */
public final class SharingHistoryFragment$onViewCreated$3<T> implements Consumer<List<? extends ShareRecord>> {
    final /* synthetic */ SharingHistoryFragment this$0;

    SharingHistoryFragment$onViewCreated$3(SharingHistoryFragment sharingHistoryFragment) {
        this.this$0 = sharingHistoryFragment;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public /* bridge */ /* synthetic */ void accept(List<? extends ShareRecord> list) {
        accept((List<ShareRecord>) list);
    }

    public final void accept(List<ShareRecord> list) {
        Intrinsics.checkNotNullExpressionValue(list, "shares");
        if (!list.isEmpty()) {
            SharesAdapter sharesAdapter = new SharesAdapter(list);
            RecyclerView recyclerView = (RecyclerView) this.this$0._$_findCachedViewById(R.id.shares_recycler_view);
            Intrinsics.checkNotNullExpressionValue(recyclerView, "shares_recycler_view");
            recyclerView.setAdapter(sharesAdapter);
            this.this$0.disposables.add(sharesAdapter.getSelectedSharePublisher().subscribeOn(Schedulers.io()).subscribe(new Consumer<ShareRecord>(this) {
                /* class com.digitalwallet.app.view.main.SharingHistoryFragment$onViewCreated$3.AnonymousClass1 */
                final /* synthetic */ SharingHistoryFragment$onViewCreated$3 this$0;

                {
                    this.this$0 = r1;
                }

                public final void accept(ShareRecord shareRecord) {
                    SharingDetailsFragment sharingDetailsFragment;
                    int i = SharingHistoryFragment.WhenMappings.$EnumSwitchMapping$0[ServerTypeKt.getAppType().ordinal()];
                    if (i == 1) {
                        SharingDetailsFragment.Companion companion = SharingDetailsFragment.Companion;
                        Intrinsics.checkNotNullExpressionValue(shareRecord, FirebaseAnalytics.Event.SHARE);
                        sharingDetailsFragment = SharingDetailsFragment.Companion.newInstance$default(companion, shareRecord, false, 2, null);
                    } else if (i == 2) {
                        HoldingDetailFragment.Companion companion2 = HoldingDetailFragment.Companion;
                        Intrinsics.checkNotNullExpressionValue(shareRecord, FirebaseAnalytics.Event.SHARE);
                        sharingDetailsFragment = companion2.newInstance(shareRecord);
                    } else {
                        throw new NoWhenBranchMatchedException();
                    }
                    FragmentManager parentFragmentManager = this.this$0.this$0.getParentFragmentManager();
                    Intrinsics.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
                    List<Fragment> fragments = parentFragmentManager.getFragments();
                    Intrinsics.checkNotNullExpressionValue(fragments, "fragments");
                    for (T t : fragments) {
                        Intrinsics.checkNotNullExpressionValue(t, "it");
                        t.setUserVisibleHint(false);
                    }
                    FragmentTransaction beginTransaction = parentFragmentManager.beginTransaction();
                    Intrinsics.checkNotNullExpressionValue(beginTransaction, "this.beginTransaction()");
                    beginTransaction.setCustomAnimations(au.gov.vic.service.digitalwallet.citizen.R.anim.slide_in_up, au.gov.vic.service.digitalwallet.citizen.R.anim.slide_out_down, au.gov.vic.service.digitalwallet.citizen.R.anim.slide_in_up, au.gov.vic.service.digitalwallet.citizen.R.anim.slide_out_down);
                    String simpleName = Reflection.getOrCreateKotlinClass(BasicFragment.class).getSimpleName();
                    beginTransaction.add(au.gov.vic.service.digitalwallet.citizen.R.id.fragment_container_RES_2114322527, sharingDetailsFragment, simpleName).addToBackStack(simpleName).commit();
                }
            }));
        }
    }
}
