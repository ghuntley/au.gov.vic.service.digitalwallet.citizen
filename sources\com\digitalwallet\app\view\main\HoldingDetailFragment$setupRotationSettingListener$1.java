package com.digitalwallet.app.view.main;

import android.database.ContentObserver;
import android.os.Handler;
import androidx.fragment.app.FragmentActivity;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/digitalwallet/app/view/main/HoldingDetailFragment$setupRotationSettingListener$1", "Landroid/database/ContentObserver;", "onChange", "", "selfChange", "", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: HoldingDetailFragment.kt */
public final class HoldingDetailFragment$setupRotationSettingListener$1 extends ContentObserver {
    final /* synthetic */ Handler $handler;
    final /* synthetic */ HoldingDetailFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    HoldingDetailFragment$setupRotationSettingListener$1(HoldingDetailFragment holdingDetailFragment, Handler handler, Handler handler2) {
        super(handler2);
        this.this$0 = holdingDetailFragment;
        this.$handler = handler;
    }

    public void onChange(boolean z) {
        if (this.this$0.getSystemAutoRotate()) {
            FragmentActivity activity = this.this$0.getActivity();
            if (activity != null) {
                activity.setRequestedOrientation(10);
            }
            this.this$0.getViewModel().getKeepLandscapeOrientation().set(false);
            return;
        }
        FragmentActivity activity2 = this.this$0.getActivity();
        if (activity2 != null) {
            activity2.setRequestedOrientation(!this.this$0.isLandscape() ? 1 : 0);
        }
        this.this$0.getViewModel().getKeepLandscapeOrientation().set(Boolean.valueOf(this.this$0.isLandscape()));
    }
}
