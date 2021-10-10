package com.digitalwallet.app.view.main;

import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u0003HÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/digitalwallet/app/view/main/AdvertisingStartFailure;", "Lcom/digitalwallet/app/view/main/RxAdvertisingEvent;", "errorCode", "", "(I)V", "getErrorCode", "()I", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: RxBLEScanner.kt */
public final class AdvertisingStartFailure extends RxAdvertisingEvent {
    private final int errorCode;

    public static /* synthetic */ AdvertisingStartFailure copy$default(AdvertisingStartFailure advertisingStartFailure, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = advertisingStartFailure.errorCode;
        }
        return advertisingStartFailure.copy(i);
    }

    public final int component1() {
        return this.errorCode;
    }

    public final AdvertisingStartFailure copy(int i) {
        return new AdvertisingStartFailure(i);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof AdvertisingStartFailure) && this.errorCode == ((AdvertisingStartFailure) obj).errorCode;
        }
        return true;
    }

    public int hashCode() {
        return this.errorCode;
    }

    public String toString() {
        return "AdvertisingStartFailure(errorCode=" + this.errorCode + ")";
    }

    public AdvertisingStartFailure(int i) {
        super(null);
        this.errorCode = i;
    }

    public final int getErrorCode() {
        return this.errorCode;
    }
}
