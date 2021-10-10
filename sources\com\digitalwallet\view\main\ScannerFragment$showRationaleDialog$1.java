package com.digitalwallet.view.main;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import au.gov.vic.service.digitalwallet.citizen.R;
import kotlin.Metadata;
import kotlin.Unit;
import timber.log.Timber;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\u000e\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u00052\u0006\u0010\u0007\u001a\u00020\bH\n¢\u0006\u0002\b\t"}, d2 = {"<anonymous>", "", "T", "Landroidx/databinding/ViewDataBinding;", "<anonymous parameter 0>", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "onClick"}, k = 3, mv = {1, 4, 0})
/* compiled from: ScannerFragment.kt */
public final class ScannerFragment$showRationaleDialog$1 implements DialogInterface.OnClickListener {
    final /* synthetic */ Context $context;
    final /* synthetic */ ScannerFragment this$0;

    ScannerFragment$showRationaleDialog$1(ScannerFragment scannerFragment, Context context) {
        this.this$0 = scannerFragment;
        this.$context = context;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        try {
            ScannerFragment scannerFragment = this.this$0;
            Intent intent = new Intent();
            intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent.setData(Uri.fromParts("package", this.$context.getPackageName(), null));
            Unit unit = Unit.INSTANCE;
            scannerFragment.startActivity(intent);
            this.this$0.popFragment();
        } catch (Exception e) {
            Timber.e(e);
            new AlertDialog.Builder(this.$context).setMessage(R.string.scanner_settings_direction_failed).setPositiveButton(R.string.ok_RES_2131689719, (DialogInterface.OnClickListener) null).show();
        }
    }
}
