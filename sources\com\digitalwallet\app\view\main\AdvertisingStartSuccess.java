package com.digitalwallet.app.view.main;

import android.bluetooth.le.AdvertiseSettings;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/digitalwallet/app/view/main/AdvertisingStartSuccess;", "Lcom/digitalwallet/app/view/main/RxAdvertisingEvent;", "settings", "Landroid/bluetooth/le/AdvertiseSettings;", "(Landroid/bluetooth/le/AdvertiseSettings;)V", "getSettings", "()Landroid/bluetooth/le/AdvertiseSettings;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: RxBLEScanner.kt */
public final class AdvertisingStartSuccess extends RxAdvertisingEvent {
    private final AdvertiseSettings settings;

    public static /* synthetic */ AdvertisingStartSuccess copy$default(AdvertisingStartSuccess advertisingStartSuccess, AdvertiseSettings advertiseSettings, int i, Object obj) {
        if ((i & 1) != 0) {
            advertiseSettings = advertisingStartSuccess.settings;
        }
        return advertisingStartSuccess.copy(advertiseSettings);
    }

    public final AdvertiseSettings component1() {
        return this.settings;
    }

    public final AdvertisingStartSuccess copy(AdvertiseSettings advertiseSettings) {
        Intrinsics.checkNotNullParameter(advertiseSettings, "settings");
        return new AdvertisingStartSuccess(advertiseSettings);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof AdvertisingStartSuccess) && Intrinsics.areEqual(this.settings, ((AdvertisingStartSuccess) obj).settings);
        }
        return true;
    }

    public int hashCode() {
        AdvertiseSettings advertiseSettings = this.settings;
        if (advertiseSettings != null) {
            return advertiseSettings.hashCode();
        }
        return 0;
    }

    public String toString() {
        return "AdvertisingStartSuccess(settings=" + this.settings + ")";
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AdvertisingStartSuccess(AdvertiseSettings advertiseSettings) {
        super(null);
        Intrinsics.checkNotNullParameter(advertiseSettings, "settings");
        this.settings = advertiseSettings;
    }

    public final AdvertiseSettings getSettings() {
        return this.settings;
    }
}
