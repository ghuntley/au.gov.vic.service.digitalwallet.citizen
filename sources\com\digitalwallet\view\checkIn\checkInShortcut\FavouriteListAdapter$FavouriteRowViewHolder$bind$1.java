package com.digitalwallet.view.checkIn.checkInShortcut;

import android.view.MotionEvent;
import android.view.View;
import com.digitalwallet.view.checkIn.checkInShortcut.FavouriteListAdapter;
import com.digitalwallet.viewmodel.checkIn.checkInShortcut.FavouriteRowViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00060\u0006H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "<anonymous parameter 0>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "event", "Landroid/view/MotionEvent;", "onTouch"}, k = 3, mv = {1, 4, 0})
/* compiled from: ShortcutItemViewAdapters.kt */
public final class FavouriteListAdapter$FavouriteRowViewHolder$bind$1 implements View.OnTouchListener {
    final /* synthetic */ FavouriteRowViewModel $item;
    final /* synthetic */ FavouriteListAdapter.FavouriteRowViewHolder this$0;

    FavouriteListAdapter$FavouriteRowViewHolder$bind$1(FavouriteListAdapter.FavouriteRowViewHolder favouriteRowViewHolder, FavouriteRowViewModel favouriteRowViewModel) {
        this.this$0 = favouriteRowViewHolder;
        this.$item = favouriteRowViewModel;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        Intrinsics.checkNotNullExpressionValue(motionEvent, "event");
        if (motionEvent.getActionMasked() != 0 || !this.$item.getEditing().get()) {
            return true;
        }
        this.this$0.itemTouchHelper.startDrag(this.this$0);
        return true;
    }
}
