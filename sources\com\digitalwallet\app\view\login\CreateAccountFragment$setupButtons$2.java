package com.digitalwallet.app.view.login;

import android.view.View;
import com.digitalwallet.utilities.AnalyticsHelper;
import kotlin.Metadata;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k = 3, mv = {1, 4, 0})
/* compiled from: CreateAccountFragment.kt */
public final class CreateAccountFragment$setupButtons$2 implements View.OnClickListener {
    final /* synthetic */ CreateAccountFragment this$0;

    CreateAccountFragment$setupButtons$2(CreateAccountFragment createAccountFragment) {
        this.this$0 = createAccountFragment;
    }

    public final void onClick(View view) {
        AnalyticsHelper.selectContent$default(this.this$0.getAnalytics(), "Button click - Create account screen - Login", null, 2, null);
        this.this$0.login();
    }
}
