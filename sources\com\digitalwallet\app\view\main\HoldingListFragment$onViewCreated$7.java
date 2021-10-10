package com.digitalwallet.app.view.main;

import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import androidx.appcompat.app.AlertDialog;
import androidx.core.content.ContextCompat;
import au.gov.vic.service.digitalwallet.citizen.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k = 3, mv = {1, 4, 0})
/* compiled from: HoldingListFragment.kt */
final class HoldingListFragment$onViewCreated$7 implements View.OnClickListener {
    final /* synthetic */ HoldingListFragment this$0;

    HoldingListFragment$onViewCreated$7(HoldingListFragment holdingListFragment) {
        this.this$0 = holdingListFragment;
    }

    public final void onClick(View view) {
        if (!this.this$0.getViewModel().getBluetoothServiceRunning().get()) {
            Context context = this.this$0.getContext();
            Intrinsics.checkNotNull(context);
            if (ContextCompat.checkSelfPermission(context, "android.permission.ACCESS_COARSE_LOCATION") != 0) {
                Context context2 = this.this$0.getContext();
                Intrinsics.checkNotNull(context2);
                new AlertDialog.Builder(context2).setTitle(R.string.bluetooth_disconnected_title).setMessage(R.string.bluetooth_disconnected_permission_message).setPositiveButton(R.string.settings, new DialogInterface.OnClickListener(this) {
                    /* class com.digitalwallet.app.view.main.HoldingListFragment$onViewCreated$7.AnonymousClass1 */
                    final /* synthetic */ HoldingListFragment$onViewCreated$7 this$0;

                    {
                        this.this$0 = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        HoldingListFragment holdingListFragment = this.this$0.this$0;
                        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
                        Context context = this.this$0.this$0.getContext();
                        Intrinsics.checkNotNull(context);
                        intent.setData(Uri.fromParts("package", context.getPackageName(), null));
                        Unit unit = Unit.INSTANCE;
                        holdingListFragment.startActivity(intent);
                    }
                }).setNegativeButton(R.string.request_dismiss, (DialogInterface.OnClickListener) null).show();
                return;
            }
            BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
            if (defaultAdapter == null || defaultAdapter.isEnabled()) {
                Context context3 = this.this$0.getContext();
                Intrinsics.checkNotNull(context3);
                new AlertDialog.Builder(context3).setTitle(R.string.bluetooth_disconnected_title).setMessage(R.string.bluetooth_disconnected_unknown_message).setNegativeButton(R.string.request_dismiss, (DialogInterface.OnClickListener) null).show();
                return;
            }
            Context context4 = this.this$0.getContext();
            Intrinsics.checkNotNull(context4);
            new AlertDialog.Builder(context4).setTitle(R.string.bluetooth_disconnected_title).setMessage(R.string.bluetooth_disconnected_disabled_message).setPositiveButton(R.string.settings, new DialogInterface.OnClickListener(this) {
                /* class com.digitalwallet.app.view.main.HoldingListFragment$onViewCreated$7.AnonymousClass2 */
                final /* synthetic */ HoldingListFragment$onViewCreated$7 this$0;

                {
                    this.this$0 = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    this.this$0.this$0.startActivity(new Intent("android.settings.BLUETOOTH_SETTINGS"));
                }
            }).setNegativeButton(R.string.request_dismiss, (DialogInterface.OnClickListener) null).show();
        }
    }
}
