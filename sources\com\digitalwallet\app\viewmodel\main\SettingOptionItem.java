package com.digitalwallet.app.viewmodel.main;

import android.content.Context;
import au.gov.vic.service.digitalwallet.citizen.R;
import com.digitalwallet.app.utilities.DebugHelperKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.bouncycastle.i18n.MessageBundle;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0002\u0010\u000bJ\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0007HÂ\u0003J\u000f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\n0\tHÂ\u0003J7\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tHÆ\u0001J\u0013\u0010 \u001a\u00020\u00052\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\"\u001a\u00020\u0018HÖ\u0001J\u0006\u0010#\u001a\u00020\nJ\t\u0010$\u001a\u00020%HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u000e\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\rR\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0010\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00030\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0017\u001a\u00020\u0018¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001a¨\u0006&"}, d2 = {"Lcom/digitalwallet/app/viewmodel/main/SettingOptionItem;", "", "settingOption", "Lcom/digitalwallet/app/viewmodel/main/SettingOption;", "autoUpdate", "", "context", "Landroid/content/Context;", "doOnClick", "Lkotlin/Function0;", "", "(Lcom/digitalwallet/app/viewmodel/main/SettingOption;ZLandroid/content/Context;Lkotlin/jvm/functions/Function0;)V", "getAutoUpdate", "()Z", "debugOptionActivated", "getDebugOptionActivated", "isDebug", "getSettingOption", "()Lcom/digitalwallet/app/viewmodel/main/SettingOption;", "switchOptions", "", "getSwitchOptions", "()Ljava/util/List;", MessageBundle.TITLE_ENTRY, "", "getTitle", "()I", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "onClick", "toString", "", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: SettingOptionItem.kt */
public final class SettingOptionItem {
    private final boolean autoUpdate;
    private final Context context;
    private final Function0<Unit> doOnClick;
    private final SettingOption settingOption;
    private final List<SettingOption> switchOptions;
    private final int title;

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 0})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[SettingOption.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[SettingOption.PaymentMethod.ordinal()] = 1;
            iArr[SettingOption.AutoSync.ordinal()] = 2;
            iArr[SettingOption.Privacy.ordinal()] = 3;
            iArr[SettingOption.Terms.ordinal()] = 4;
            iArr[SettingOption.Contact.ordinal()] = 5;
            iArr[SettingOption.HarvestMockFail.ordinal()] = 6;
            iArr[SettingOption.HarvestMockSucceed.ordinal()] = 7;
        }
    }

    private final Context component3() {
        return this.context;
    }

    private final Function0<Unit> component4() {
        return this.doOnClick;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.digitalwallet.app.viewmodel.main.SettingOptionItem */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SettingOptionItem copy$default(SettingOptionItem settingOptionItem, SettingOption settingOption2, boolean z, Context context2, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            settingOption2 = settingOptionItem.settingOption;
        }
        if ((i & 2) != 0) {
            z = settingOptionItem.autoUpdate;
        }
        if ((i & 4) != 0) {
            context2 = settingOptionItem.context;
        }
        if ((i & 8) != 0) {
            function0 = settingOptionItem.doOnClick;
        }
        return settingOptionItem.copy(settingOption2, z, context2, function0);
    }

    public final SettingOption component1() {
        return this.settingOption;
    }

    public final boolean component2() {
        return this.autoUpdate;
    }

    public final SettingOptionItem copy(SettingOption settingOption2, boolean z, Context context2, Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(settingOption2, "settingOption");
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(function0, "doOnClick");
        return new SettingOptionItem(settingOption2, z, context2, function0);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SettingOptionItem)) {
            return false;
        }
        SettingOptionItem settingOptionItem = (SettingOptionItem) obj;
        return Intrinsics.areEqual(this.settingOption, settingOptionItem.settingOption) && this.autoUpdate == settingOptionItem.autoUpdate && Intrinsics.areEqual(this.context, settingOptionItem.context) && Intrinsics.areEqual(this.doOnClick, settingOptionItem.doOnClick);
    }

    public int hashCode() {
        SettingOption settingOption2 = this.settingOption;
        int i = 0;
        int hashCode = (settingOption2 != null ? settingOption2.hashCode() : 0) * 31;
        boolean z = this.autoUpdate;
        if (z) {
            z = true;
        }
        int i2 = z ? 1 : 0;
        int i3 = z ? 1 : 0;
        int i4 = z ? 1 : 0;
        int i5 = (hashCode + i2) * 31;
        Context context2 = this.context;
        int hashCode2 = (i5 + (context2 != null ? context2.hashCode() : 0)) * 31;
        Function0<Unit> function0 = this.doOnClick;
        if (function0 != null) {
            i = function0.hashCode();
        }
        return hashCode2 + i;
    }

    public String toString() {
        return "SettingOptionItem(settingOption=" + this.settingOption + ", autoUpdate=" + this.autoUpdate + ", context=" + this.context + ", doOnClick=" + this.doOnClick + ")";
    }

    public SettingOptionItem(SettingOption settingOption2, boolean z, Context context2, Function0<Unit> function0) {
        int i;
        Intrinsics.checkNotNullParameter(settingOption2, "settingOption");
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(function0, "doOnClick");
        this.settingOption = settingOption2;
        this.autoUpdate = z;
        this.context = context2;
        this.doOnClick = function0;
        this.switchOptions = CollectionsKt.listOf(SettingOption.AutoSync);
        switch (WhenMappings.$EnumSwitchMapping$0[settingOption2.ordinal()]) {
            case 1:
                i = R.string.setting_payment_method;
                break;
            case 2:
                i = R.string.setting_auto_sync;
                break;
            case 3:
                i = R.string.setting_privacy;
                break;
            case 4:
                i = R.string.setting_terms;
                break;
            case 5:
                i = R.string.setting_contact;
                break;
            case 6:
                i = R.string.harvest_mock_fail;
                break;
            case 7:
                i = R.string.harvest_mock_success;
                break;
            default:
                throw new NoWhenBranchMatchedException();
        }
        this.title = i;
    }

    public final SettingOption getSettingOption() {
        return this.settingOption;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SettingOptionItem(SettingOption settingOption2, boolean z, Context context2, Function0 function0, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(settingOption2, (i & 2) != 0 ? false : z, context2, function0);
    }

    public final boolean getAutoUpdate() {
        return this.autoUpdate;
    }

    public final List<SettingOption> getSwitchOptions() {
        return this.switchOptions;
    }

    public final int getTitle() {
        return this.title;
    }

    public final boolean isDebug() {
        return this.settingOption.getDebug();
    }

    public final boolean getDebugOptionActivated() {
        return DebugHelperKt.debugOptionActivated(this.context, this.settingOption.name());
    }

    public final void onClick() {
        this.doOnClick.invoke();
    }
}
