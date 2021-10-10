package com.digitalwallet.view.main;

import android.content.DialogInterface;
import com.digitalwallet.utilities.AnalyticsHelper;
import kotlin.Metadata;
import timber.log.Timber;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\u000e\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u00052\u0006\u0010\u0007\u001a\u00020\bH\n¢\u0006\u0002\b\t"}, d2 = {"<anonymous>", "", "T", "Landroidx/databinding/ViewDataBinding;", "<anonymous parameter 0>", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "onClick"}, k = 3, mv = {1, 4, 0})
/* compiled from: ScannerFragment.kt */
public final class ScannerFragment$showRationaleDialog$2 implements DialogInterface.OnClickListener {
    final /* synthetic */ ScannerFragment this$0;

    ScannerFragment$showRationaleDialog$2(ScannerFragment scannerFragment) {
        this.this$0 = scannerFragment;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        AnalyticsHelper.selectContent$default(this.this$0.getAnalytics(), "Permission - Camera denied", null, 2, null);
        try {
            this.this$0.popFragment();
        } catch (Exception e) {
            Timber.e(e);
        }
    }
}
