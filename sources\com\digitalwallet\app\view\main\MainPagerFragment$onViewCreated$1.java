package com.digitalwallet.app.view.main;

import android.content.Context;
import android.view.View;
import androidx.appcompat.app.AlertDialog;
import com.digitalwallet.utilities.AnalyticsHelper;
import java.util.Objects;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k = 3, mv = {1, 4, 0})
/* compiled from: MainPagerFragment.kt */
final class MainPagerFragment$onViewCreated$1 implements View.OnClickListener {
    final /* synthetic */ MainPagerFragment this$0;

    MainPagerFragment$onViewCreated$1(MainPagerFragment mainPagerFragment) {
        this.this$0 = mainPagerFragment;
    }

    public final void onClick(View view) {
        Context context = this.this$0.getContext();
        Objects.requireNonNull(context, "null cannot be cast to non-null type android.content.Context");
        AnalyticsHelper.selectContent$default(new AnalyticsHelper(context), "Unlink account", null, 2, null);
        AlertDialog unused = this.this$0.showLogoutDialog();
    }
}
