package com.digitalwallet.model;

import com.digitalwallet.viewmodel.checkIn.CheckInUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J)\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00072\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u001a"}, d2 = {"Lcom/digitalwallet/model/CheckInHistoryCombo;", "", "checkInItem", "Lcom/digitalwallet/model/CheckIn;", "checkInCode", "Lcom/digitalwallet/viewmodel/checkIn/CheckInUtils$CheckInCode;", "isHidden", "", "(Lcom/digitalwallet/model/CheckIn;Lcom/digitalwallet/viewmodel/checkIn/CheckInUtils$CheckInCode;Z)V", "getCheckInCode", "()Lcom/digitalwallet/viewmodel/checkIn/CheckInUtils$CheckInCode;", "getCheckInItem", "()Lcom/digitalwallet/model/CheckIn;", "()Z", "setHidden", "(Z)V", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "", "base_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: CheckIn.kt */
public final class CheckInHistoryCombo {
    private final CheckInUtils.CheckInCode checkInCode;
    private final CheckIn checkInItem;
    private boolean isHidden;

    public static /* synthetic */ CheckInHistoryCombo copy$default(CheckInHistoryCombo checkInHistoryCombo, CheckIn checkIn, CheckInUtils.CheckInCode checkInCode2, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            checkIn = checkInHistoryCombo.checkInItem;
        }
        if ((i & 2) != 0) {
            checkInCode2 = checkInHistoryCombo.checkInCode;
        }
        if ((i & 4) != 0) {
            z = checkInHistoryCombo.isHidden;
        }
        return checkInHistoryCombo.copy(checkIn, checkInCode2, z);
    }

    public final CheckIn component1() {
        return this.checkInItem;
    }

    public final CheckInUtils.CheckInCode component2() {
        return this.checkInCode;
    }

    public final boolean component3() {
        return this.isHidden;
    }

    public final CheckInHistoryCombo copy(CheckIn checkIn, CheckInUtils.CheckInCode checkInCode2, boolean z) {
        Intrinsics.checkNotNullParameter(checkIn, "checkInItem");
        return new CheckInHistoryCombo(checkIn, checkInCode2, z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CheckInHistoryCombo)) {
            return false;
        }
        CheckInHistoryCombo checkInHistoryCombo = (CheckInHistoryCombo) obj;
        return Intrinsics.areEqual(this.checkInItem, checkInHistoryCombo.checkInItem) && Intrinsics.areEqual(this.checkInCode, checkInHistoryCombo.checkInCode) && this.isHidden == checkInHistoryCombo.isHidden;
    }

    public int hashCode() {
        CheckIn checkIn = this.checkInItem;
        int i = 0;
        int hashCode = (checkIn != null ? checkIn.hashCode() : 0) * 31;
        CheckInUtils.CheckInCode checkInCode2 = this.checkInCode;
        if (checkInCode2 != null) {
            i = checkInCode2.hashCode();
        }
        int i2 = (hashCode + i) * 31;
        boolean z = this.isHidden;
        if (z) {
            z = true;
        }
        int i3 = z ? 1 : 0;
        int i4 = z ? 1 : 0;
        int i5 = z ? 1 : 0;
        return i2 + i3;
    }

    public String toString() {
        return "CheckInHistoryCombo(checkInItem=" + this.checkInItem + ", checkInCode=" + this.checkInCode + ", isHidden=" + this.isHidden + ")";
    }

    public CheckInHistoryCombo(CheckIn checkIn, CheckInUtils.CheckInCode checkInCode2, boolean z) {
        Intrinsics.checkNotNullParameter(checkIn, "checkInItem");
        this.checkInItem = checkIn;
        this.checkInCode = checkInCode2;
        this.isHidden = z;
    }

    public final CheckIn getCheckInItem() {
        return this.checkInItem;
    }

    public final CheckInUtils.CheckInCode getCheckInCode() {
        return this.checkInCode;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CheckInHistoryCombo(CheckIn checkIn, CheckInUtils.CheckInCode checkInCode2, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(checkIn, checkInCode2, (i & 4) != 0 ? false : z);
    }

    public final boolean isHidden() {
        return this.isHidden;
    }

    public final void setHidden(boolean z) {
        this.isHidden = z;
    }
}
