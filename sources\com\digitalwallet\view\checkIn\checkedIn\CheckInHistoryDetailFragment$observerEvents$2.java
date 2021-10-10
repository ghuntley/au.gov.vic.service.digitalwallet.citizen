package com.digitalwallet.view.checkIn.checkedIn;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import androidx.databinding.Observable;
import au.gov.vic.service.digitalwallet.citizen.R;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"com/digitalwallet/view/checkIn/checkedIn/CheckInHistoryDetailFragment$observerEvents$2", "Landroidx/databinding/Observable$OnPropertyChangedCallback;", "onPropertyChanged", "", "sender", "Landroidx/databinding/Observable;", "propertyId", "", "base_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: CheckInHistoryDetailFragment.kt */
public final class CheckInHistoryDetailFragment$observerEvents$2 extends Observable.OnPropertyChangedCallback {
    final /* synthetic */ CheckInHistoryDetailFragment this$0;

    /* JADX WARN: Incorrect args count in method signature: ()V */
    CheckInHistoryDetailFragment$observerEvents$2(CheckInHistoryDetailFragment checkInHistoryDetailFragment) {
        this.this$0 = checkInHistoryDetailFragment;
    }

    @Override // androidx.databinding.Observable.OnPropertyChangedCallback
    public void onPropertyChanged(Observable observable, int i) {
        String str;
        String str2;
        this.this$0.getViewModel().addOrRemoveAFavourite();
        AlertDialog.Builder builder = new AlertDialog.Builder(this.this$0.getContext());
        if (this.this$0.getViewModel().getShouldFavour().get()) {
            AlertDialog.Builder title = builder.setTitle(R.string.checked_in_favourite_added_title);
            Context context = builder.getContext();
            if (context != null) {
                str2 = context.getString(R.string.checked_in_favourite_added_message, this.this$0.getViewModel().getLocationName().get());
            } else {
                str2 = null;
            }
            title.setMessage(str2);
        } else {
            AlertDialog.Builder title2 = builder.setTitle(R.string.checked_in_favourite_removed_title);
            Context context2 = builder.getContext();
            if (context2 != null) {
                str = context2.getString(R.string.checked_in_favourite_removed_message, this.this$0.getViewModel().getLocationName().get());
            } else {
                str = null;
            }
            title2.setMessage(str);
        }
        builder.setPositiveButton(R.string.ok_RES_2131689719, (DialogInterface.OnClickListener) null).setCancelable(false).create().show();
    }
}
