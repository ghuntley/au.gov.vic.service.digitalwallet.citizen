package com.digitalwallet.app.view.main;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import au.gov.vic.service.digitalwallet.citizen.R;
import com.digitalwallet.app.viewmodel.main.addsync.CardAddEvent;
import io.reactivex.functions.Consumer;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "event", "Lcom/digitalwallet/app/viewmodel/main/addsync/CardAddEvent;", "kotlin.jvm.PlatformType", "accept"}, k = 3, mv = {1, 4, 0})
/* compiled from: CardAddFragment.kt */
final class CardAddFragment$onStart$1<T> implements Consumer<CardAddEvent> {
    final /* synthetic */ CardAddFragment this$0;

    CardAddFragment$onStart$1(CardAddFragment cardAddFragment) {
        this.this$0 = cardAddFragment;
    }

    public final void accept(CardAddEvent cardAddEvent) {
        if (Intrinsics.areEqual(cardAddEvent, CardAddEvent.CardSync.INSTANCE)) {
            FragmentManager parentFragmentManager = this.this$0.getParentFragmentManager();
            Intrinsics.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
            CardSyncFragment cardSyncFragment = new CardSyncFragment(false, null, 2, null);
            List<Fragment> fragments = parentFragmentManager.getFragments();
            Intrinsics.checkNotNullExpressionValue(fragments, "fragments");
            for (T t : fragments) {
                Intrinsics.checkNotNullExpressionValue(t, "it");
                t.setUserVisibleHint(false);
            }
            FragmentTransaction beginTransaction = parentFragmentManager.beginTransaction();
            Intrinsics.checkNotNullExpressionValue(beginTransaction, "this.beginTransaction()");
            String simpleName = Reflection.getOrCreateKotlinClass(CardSyncFragment.class).getSimpleName();
            beginTransaction.add(R.id.fragment_container_RES_2114322527, cardSyncFragment, simpleName).addToBackStack(simpleName).commit();
        } else if (cardAddEvent instanceof CardAddEvent.WebRequest) {
            FragmentActivity activity = this.this$0.getActivity();
            Objects.requireNonNull(activity, "null cannot be cast to non-null type com.digitalwallet.app.view.main.MainActivity");
            String string = this.this$0.getResources().getString(((CardAddEvent.WebRequest) cardAddEvent).getLinkRes());
            Intrinsics.checkNotNullExpressionValue(string, "resources.getString(event.linkRes)");
            ((MainActivity) activity).startChromeCustomTabs(string, true);
        }
    }
}
