package com.digitalwallet.app.viewmodel.main;

import au.gov.vic.service.digitalwallet.citizen.R;
import com.digitalwallet.utilities.AppType;
import com.digitalwallet.utilities.ServerTypeKt;
import com.digitalwallet.viewmodel.base.BaseViewModel;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0007¢\u0006\u0002\u0010\u0002J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0005R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000b"}, d2 = {"Lcom/digitalwallet/app/viewmodel/main/AccountSettingsFragmentViewModel;", "Lcom/digitalwallet/viewmodel/base/BaseViewModel;", "()V", "settingsToDisplay", "", "Lcom/digitalwallet/app/viewmodel/main/SettingOption;", "getSettingsToDisplay", "()Ljava/util/List;", "getPathForOption", "", "option", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: AccountSettingsFragmentViewModel.kt */
public final class AccountSettingsFragmentViewModel extends BaseViewModel {
    private final List<SettingOption> settingsToDisplay;

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 0})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[AppType.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[AppType.CITIZEN.ordinal()] = 1;
            int[] iArr2 = new int[SettingOption.values().length];
            $EnumSwitchMapping$1 = iArr2;
            iArr2[SettingOption.PaymentMethod.ordinal()] = 1;
            iArr2[SettingOption.Privacy.ordinal()] = 2;
            iArr2[SettingOption.Terms.ordinal()] = 3;
            iArr2[SettingOption.Contact.ordinal()] = 4;
        }
    }

    @Inject
    public AccountSettingsFragmentViewModel() {
        List<SettingOption> list;
        if (WhenMappings.$EnumSwitchMapping$0[ServerTypeKt.getAppType().ordinal()] != 1) {
            list = CollectionsKt.mutableListOf(SettingOption.Privacy, SettingOption.Terms, SettingOption.Contact);
        } else {
            SettingOption[] values = SettingOption.values();
            ArrayList arrayList = new ArrayList();
            for (SettingOption settingOption : values) {
                if (!settingOption.getDebug()) {
                    arrayList.add(settingOption);
                }
            }
            list = CollectionsKt.toMutableList((Collection) arrayList);
        }
        SettingOption[] values2 = SettingOption.values();
        ArrayList arrayList2 = new ArrayList();
        for (SettingOption settingOption2 : values2) {
            if (settingOption2.getDebug()) {
                arrayList2.add(settingOption2);
            }
        }
        ArrayList arrayList3 = arrayList2;
        if (ServerTypeKt.isInternal(ServerTypeKt.getServerType())) {
            list.addAll(arrayList3);
        }
        Unit unit = Unit.INSTANCE;
        this.settingsToDisplay = list;
    }

    public final List<SettingOption> getSettingsToDisplay() {
        return this.settingsToDisplay;
    }

    public final int getPathForOption(SettingOption settingOption) {
        Intrinsics.checkNotNullParameter(settingOption, "option");
        int i = WhenMappings.$EnumSwitchMapping$1[settingOption.ordinal()];
        if (i == 1) {
            return R.string.setting_payment_url;
        }
        if (i == 2) {
            return R.string.setting_privacy_url;
        }
        if (i == 3) {
            return R.string.setting_terms_url;
        }
        if (i == 4) {
            return R.string.setting_contact_url;
        }
        if (settingOption.getDebug()) {
            return 0;
        }
        throw new IllegalStateException("Unexpected option " + settingOption);
    }
}
