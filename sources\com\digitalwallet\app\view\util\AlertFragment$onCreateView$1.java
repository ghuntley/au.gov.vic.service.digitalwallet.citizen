package com.digitalwallet.app.view.util;

import androidx.activity.OnBackPressedCallback;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/digitalwallet/app/view/util/AlertFragment$onCreateView$1", "Landroidx/activity/OnBackPressedCallback;", "handleOnBackPressed", "", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: AlertFragment.kt */
public final class AlertFragment$onCreateView$1 extends OnBackPressedCallback {
    final /* synthetic */ AlertFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AlertFragment$onCreateView$1(AlertFragment alertFragment, boolean z) {
        super(z);
        this.this$0 = alertFragment;
    }

    @Override // androidx.activity.OnBackPressedCallback
    public void handleOnBackPressed() {
        this.this$0.handleBack();
    }
}
