package com.digitalwallet.app.view.main;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.bouncycastle.i18n.MessageBundle;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b&\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B]\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\f\u001a\u00020\u0006\u0012\u0006\u0010\r\u001a\u00020\u0006¢\u0006\u0002\u0010\u000eJ\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0006HÆ\u0003J\u0010\u0010!\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0012J\t\u0010\"\u001a\u00020\u0006HÆ\u0003J\u0010\u0010#\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0012J\u0010\u0010$\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0012J\u0010\u0010%\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0012J\t\u0010&\u001a\u00020\u0006HÆ\u0003Jz\u0010'\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\f\u001a\u00020\u00062\b\b\u0002\u0010\r\u001a\u00020\u0006HÆ\u0001¢\u0006\u0002\u0010(J\u0013\u0010)\u001a\u00020\u00032\b\u0010*\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010+\u001a\u00020\u0006HÖ\u0001J\t\u0010,\u001a\u00020-HÖ\u0001R\u0011\u0010\b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0015\u0010\u000b\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0011\u0010\u0012R\u0015\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0014\u0010\u0012R\u0015\u0010\n\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0015\u0010\u0012R\u0015\u0010\t\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0016\u0010\u0012R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0010R\u0011\u0010\r\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001aR\u0011\u0010\f\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0010¨\u0006."}, d2 = {"Lcom/digitalwallet/app/view/main/HoldingElements;", "", "supported", "", "realCard", "front", "", "back", "affordances", "detailTitle", "detailIcon", "applyUrl", MessageBundle.TITLE_ENTRY, "lowercaseTitle", "(ZZILjava/lang/Integer;ILjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;II)V", "getAffordances", "()I", "getApplyUrl", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getBack", "getDetailIcon", "getDetailTitle", "getFront", "getLowercaseTitle", "getRealCard", "()Z", "getSupported", "getTitle", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(ZZILjava/lang/Integer;ILjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;II)Lcom/digitalwallet/app/view/main/HoldingElements;", "equals", "other", "hashCode", "toString", "", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: HoldingElements.kt */
public final class HoldingElements {
    private final int affordances;
    private final Integer applyUrl;
    private final Integer back;
    private final Integer detailIcon;
    private final Integer detailTitle;
    private final int front;
    private final int lowercaseTitle;
    private final boolean realCard;
    private final boolean supported;
    private final int title;

    public static /* synthetic */ HoldingElements copy$default(HoldingElements holdingElements, boolean z, boolean z2, int i, Integer num, int i2, Integer num2, Integer num3, Integer num4, int i3, int i4, int i5, Object obj) {
        return holdingElements.copy((i5 & 1) != 0 ? holdingElements.supported : z, (i5 & 2) != 0 ? holdingElements.realCard : z2, (i5 & 4) != 0 ? holdingElements.front : i, (i5 & 8) != 0 ? holdingElements.back : num, (i5 & 16) != 0 ? holdingElements.affordances : i2, (i5 & 32) != 0 ? holdingElements.detailTitle : num2, (i5 & 64) != 0 ? holdingElements.detailIcon : num3, (i5 & 128) != 0 ? holdingElements.applyUrl : num4, (i5 & 256) != 0 ? holdingElements.title : i3, (i5 & 512) != 0 ? holdingElements.lowercaseTitle : i4);
    }

    public final boolean component1() {
        return this.supported;
    }

    public final int component10() {
        return this.lowercaseTitle;
    }

    public final boolean component2() {
        return this.realCard;
    }

    public final int component3() {
        return this.front;
    }

    public final Integer component4() {
        return this.back;
    }

    public final int component5() {
        return this.affordances;
    }

    public final Integer component6() {
        return this.detailTitle;
    }

    public final Integer component7() {
        return this.detailIcon;
    }

    public final Integer component8() {
        return this.applyUrl;
    }

    public final int component9() {
        return this.title;
    }

    public final HoldingElements copy(boolean z, boolean z2, int i, Integer num, int i2, Integer num2, Integer num3, Integer num4, int i3, int i4) {
        return new HoldingElements(z, z2, i, num, i2, num2, num3, num4, i3, i4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof HoldingElements)) {
            return false;
        }
        HoldingElements holdingElements = (HoldingElements) obj;
        return this.supported == holdingElements.supported && this.realCard == holdingElements.realCard && this.front == holdingElements.front && Intrinsics.areEqual(this.back, holdingElements.back) && this.affordances == holdingElements.affordances && Intrinsics.areEqual(this.detailTitle, holdingElements.detailTitle) && Intrinsics.areEqual(this.detailIcon, holdingElements.detailIcon) && Intrinsics.areEqual(this.applyUrl, holdingElements.applyUrl) && this.title == holdingElements.title && this.lowercaseTitle == holdingElements.lowercaseTitle;
    }

    public int hashCode() {
        boolean z = this.supported;
        int i = 1;
        if (z) {
            z = true;
        }
        int i2 = z ? 1 : 0;
        int i3 = z ? 1 : 0;
        int i4 = z ? 1 : 0;
        int i5 = i2 * 31;
        boolean z2 = this.realCard;
        if (!z2) {
            i = z2 ? 1 : 0;
        }
        int i6 = (((i5 + i) * 31) + this.front) * 31;
        Integer num = this.back;
        int i7 = 0;
        int hashCode = (((i6 + (num != null ? num.hashCode() : 0)) * 31) + this.affordances) * 31;
        Integer num2 = this.detailTitle;
        int hashCode2 = (hashCode + (num2 != null ? num2.hashCode() : 0)) * 31;
        Integer num3 = this.detailIcon;
        int hashCode3 = (hashCode2 + (num3 != null ? num3.hashCode() : 0)) * 31;
        Integer num4 = this.applyUrl;
        if (num4 != null) {
            i7 = num4.hashCode();
        }
        return ((((hashCode3 + i7) * 31) + this.title) * 31) + this.lowercaseTitle;
    }

    public String toString() {
        return "HoldingElements(supported=" + this.supported + ", realCard=" + this.realCard + ", front=" + this.front + ", back=" + this.back + ", affordances=" + this.affordances + ", detailTitle=" + this.detailTitle + ", detailIcon=" + this.detailIcon + ", applyUrl=" + this.applyUrl + ", title=" + this.title + ", lowercaseTitle=" + this.lowercaseTitle + ")";
    }

    public HoldingElements(boolean z, boolean z2, int i, Integer num, int i2, Integer num2, Integer num3, Integer num4, int i3, int i4) {
        this.supported = z;
        this.realCard = z2;
        this.front = i;
        this.back = num;
        this.affordances = i2;
        this.detailTitle = num2;
        this.detailIcon = num3;
        this.applyUrl = num4;
        this.title = i3;
        this.lowercaseTitle = i4;
    }

    public final boolean getSupported() {
        return this.supported;
    }

    public final boolean getRealCard() {
        return this.realCard;
    }

    public final int getFront() {
        return this.front;
    }

    public final Integer getBack() {
        return this.back;
    }

    public final int getAffordances() {
        return this.affordances;
    }

    public final Integer getDetailTitle() {
        return this.detailTitle;
    }

    public final Integer getDetailIcon() {
        return this.detailIcon;
    }

    public final Integer getApplyUrl() {
        return this.applyUrl;
    }

    public final int getTitle() {
        return this.title;
    }

    public final int getLowercaseTitle() {
        return this.lowercaseTitle;
    }
}
