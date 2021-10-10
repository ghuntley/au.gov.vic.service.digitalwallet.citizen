package com.digitalwallet.app.viewmodel.main;

import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/digitalwallet/app/viewmodel/main/SettingOption;", "", "debug", "", "(Ljava/lang/String;IZ)V", "getDebug", "()Z", "PaymentMethod", "AutoSync", "Privacy", "Terms", "Contact", "HarvestMockFail", "HarvestMockSucceed", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: AccountSettingsFragmentViewModel.kt */
public enum SettingOption {
    PaymentMethod(false),
    AutoSync(false),
    Privacy(false),
    Terms(false),
    Contact(false),
    HarvestMockFail(true),
    HarvestMockSucceed(true);
    
    private final boolean debug;

    private SettingOption(boolean z) {
        this.debug = z;
    }

    public final boolean getDebug() {
        return this.debug;
    }
}
