package com.digitalwallet.app.view.main;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import androidx.fragment.app.FragmentActivity;
import au.gov.vic.service.digitalwallet.citizen.R;
import com.digitalwallet.app.utilities.DebugHelperKt;
import com.digitalwallet.app.view.main.AccountSettingsFragment;
import com.digitalwallet.app.view.main.adapter.AccountSettingsAdapter;
import com.digitalwallet.app.viewmodel.main.AccountSettingsFragmentViewModel;
import com.digitalwallet.app.viewmodel.main.SettingOption;
import com.digitalwallet.utilities.ServerTypeKt;
import io.reactivex.functions.Consumer;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Lcom/digitalwallet/app/viewmodel/main/SettingOption;", "kotlin.jvm.PlatformType", "accept"}, k = 3, mv = {1, 4, 0})
/* compiled from: AccountSettingsFragment.kt */
final class AccountSettingsFragment$onViewCreated$1<T> implements Consumer<SettingOption> {
    final /* synthetic */ AccountSettingsAdapter $accountSettingsAdapter;
    final /* synthetic */ AccountSettingsFragment this$0;

    AccountSettingsFragment$onViewCreated$1(AccountSettingsFragment accountSettingsFragment, AccountSettingsAdapter accountSettingsAdapter) {
        this.this$0 = accountSettingsFragment;
        this.$accountSettingsAdapter = accountSettingsAdapter;
    }

    public final void accept(SettingOption settingOption) {
        int i;
        this.this$0.getAnalytics().selectContent("Settings selection", settingOption.name());
        boolean z = settingOption == null || !((i = AccountSettingsFragment.WhenMappings.$EnumSwitchMapping$0[settingOption.ordinal()]) == 1 || i == 2);
        if (settingOption != null) {
            int i2 = AccountSettingsFragment.WhenMappings.$EnumSwitchMapping$2[settingOption.ordinal()];
            if (i2 == 1) {
                this.this$0.getAuthenticationUtility().setAutoUpdateState(!this.this$0.getAuthenticationUtility().shouldAutoUpdate());
                boolean shouldAutoUpdate = this.this$0.getAuthenticationUtility().shouldAutoUpdate();
                this.$accountSettingsAdapter.updateAutoSyncStatus(shouldAutoUpdate);
                this.this$0.getAnalytics().selectContent("New items sync", shouldAutoUpdate ? "Automatic" : "Manual");
                return;
            } else if (i2 == 2) {
                int i3 = AccountSettingsFragment.WhenMappings.$EnumSwitchMapping$1[ServerTypeKt.getAppType().ordinal()];
                if (i3 == 1) {
                    this.this$0.startActivity(new Intent("android.intent.action.DIAL", Uri.fromParts(this.this$0.getResources().getString(R.string.phone_prefix), this.this$0.getResources().getString(R.string.service_vic_phone_number), null)));
                    return;
                } else if (i3 == 2) {
                    int pathForOption = this.this$0.getViewModel().getPathForOption(settingOption);
                    FragmentActivity activity = this.this$0.getActivity();
                    Objects.requireNonNull(activity, "null cannot be cast to non-null type com.digitalwallet.app.view.main.MainActivity");
                    String string = this.this$0.getResources().getString(pathForOption);
                    Intrinsics.checkNotNullExpressionValue(string, "resources.getString(path)");
                    ((MainActivity) activity).startChromeCustomTabs(string, z);
                    return;
                } else {
                    return;
                }
            }
        }
        if (settingOption.getDebug()) {
            Context context = this.this$0.getContext();
            if (context != null) {
                DebugHelperKt.toggleDebugOption(context, settingOption.name());
                this.$accountSettingsAdapter.notifyDataSetChanged();
                return;
            }
            return;
        }
        AccountSettingsFragmentViewModel viewModel = this.this$0.getViewModel();
        Intrinsics.checkNotNullExpressionValue(settingOption, "it");
        int pathForOption2 = viewModel.getPathForOption(settingOption);
        FragmentActivity activity2 = this.this$0.getActivity();
        Objects.requireNonNull(activity2, "null cannot be cast to non-null type com.digitalwallet.app.view.main.MainActivity");
        String string2 = this.this$0.getResources().getString(pathForOption2);
        Intrinsics.checkNotNullExpressionValue(string2, "resources.getString(path)");
        ((MainActivity) activity2).startChromeCustomTabs(string2, z);
    }
}
