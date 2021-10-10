package com.digitalwallet.view.checkIn.checkInInput;

import android.view.View;
import au.gov.vic.service.digitalwallet.citizen.R;
import com.digitalwallet.utilities.FragmentHelperKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k = 3, mv = {1, 4, 0})
/* compiled from: CheckInPrimaryInputFragment.kt */
public final class CheckInPrimaryInputFragment$setupViews$4 implements View.OnClickListener {
    final /* synthetic */ CheckInPrimaryInputFragment this$0;

    CheckInPrimaryInputFragment$setupViews$4(CheckInPrimaryInputFragment checkInPrimaryInputFragment) {
        this.this$0 = checkInPrimaryInputFragment;
    }

    public final void onClick(View view) {
        this.this$0.setNavigatingAway(true);
        CheckInPrimaryInputFragment checkInPrimaryInputFragment = this.this$0;
        String string = checkInPrimaryInputFragment.getResources().getString(R.string.check_in_collection_notice_url);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.st…in_collection_notice_url)");
        FragmentHelperKt.openURL(checkInPrimaryInputFragment, string);
    }
}
