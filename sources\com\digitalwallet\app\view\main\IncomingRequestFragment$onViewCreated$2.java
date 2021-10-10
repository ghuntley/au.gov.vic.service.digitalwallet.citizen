package com.digitalwallet.app.view.main;

import android.os.Build;
import androidx.fragment.app.FragmentActivity;
import io.reactivex.functions.Action;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 4, 0})
/* compiled from: IncomingRequestFragment.kt */
final class IncomingRequestFragment$onViewCreated$2 implements Action {
    final /* synthetic */ IncomingRequestFragment this$0;

    IncomingRequestFragment$onViewCreated$2(IncomingRequestFragment incomingRequestFragment) {
        this.this$0 = incomingRequestFragment;
    }

    @Override // io.reactivex.functions.Action
    public final void run() {
        if (Build.VERSION.SDK_INT >= 26) {
            FragmentActivity activity = this.this$0.getActivity();
            if (!(activity instanceof MainActivity)) {
                activity = null;
            }
            MainActivity mainActivity = (MainActivity) activity;
            if (mainActivity != null) {
                mainActivity.vibrateForShare();
            }
        }
    }
}
