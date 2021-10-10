package com.digitalwallet.app.view.main;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import androidx.fragment.app.FragmentActivity;
import com.digitalwallet.app.view.login.LoginActivity;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "<anonymous parameter 0>", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "onClick"}, k = 3, mv = {1, 4, 0})
/* compiled from: MainPagerFragment.kt */
public final class MainPagerFragment$showLogoutDialog$1 implements DialogInterface.OnClickListener {
    final /* synthetic */ MainPagerFragment this$0;

    MainPagerFragment$showLogoutDialog$1(MainPagerFragment mainPagerFragment) {
        this.this$0 = mainPagerFragment;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.this$0.getViewModel().logout();
        MainPagerFragment mainPagerFragment = this.this$0;
        Context context = this.this$0.getContext();
        Objects.requireNonNull(context, "null cannot be cast to non-null type android.content.Context");
        Intent intent = new Intent(context, LoginActivity.class);
        intent.setFlags(67108864);
        Unit unit = Unit.INSTANCE;
        mainPagerFragment.startActivity(intent);
        FragmentActivity activity = this.this$0.getActivity();
        if (activity != null) {
            activity.finish();
        }
    }
}
