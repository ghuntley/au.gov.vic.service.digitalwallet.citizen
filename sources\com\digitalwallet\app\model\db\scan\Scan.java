package com.digitalwallet.app.model.db.scan;

import com.digitalwallet.utilities.DateFormattingHelper;
import com.google.android.gms.vision.barcode.Barcode;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.messaging.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0014\n\u0002\u0010\b\n\u0002\b\u0003\b\b\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0006HÆ\u0003J)\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00062\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\b\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\n\"\u0004\b\f\u0010\rR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\n\"\u0004\b\u000f\u0010\rR\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u001e"}, d2 = {"Lcom/digitalwallet/app/model/db/scan/Scan;", "", FirebaseAnalytics.Param.CONTENT, "", "date", "posted", "", "(Ljava/lang/String;Ljava/lang/String;Z)V", "composite", "getComposite", "()Ljava/lang/String;", "getContent", "setContent", "(Ljava/lang/String;)V", "getDate", "setDate", "getPosted", "()Z", "setPosted", "(Z)V", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "Companion", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: Scan.kt */
public final class Scan {
    public static final Companion Companion = new Companion(null);
    private String content;
    private String date;
    private boolean posted;

    public static /* synthetic */ Scan copy$default(Scan scan, String str, String str2, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            str = scan.content;
        }
        if ((i & 2) != 0) {
            str2 = scan.date;
        }
        if ((i & 4) != 0) {
            z = scan.posted;
        }
        return scan.copy(str, str2, z);
    }

    public final String component1() {
        return this.content;
    }

    public final String component2() {
        return this.date;
    }

    public final boolean component3() {
        return this.posted;
    }

    public final Scan copy(String str, String str2, boolean z) {
        Intrinsics.checkNotNullParameter(str, FirebaseAnalytics.Param.CONTENT);
        return new Scan(str, str2, z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Scan)) {
            return false;
        }
        Scan scan = (Scan) obj;
        return Intrinsics.areEqual(this.content, scan.content) && Intrinsics.areEqual(this.date, scan.date) && this.posted == scan.posted;
    }

    public int hashCode() {
        String str = this.content;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.date;
        if (str2 != null) {
            i = str2.hashCode();
        }
        int i2 = (hashCode + i) * 31;
        boolean z = this.posted;
        if (z) {
            z = true;
        }
        int i3 = z ? 1 : 0;
        int i4 = z ? 1 : 0;
        int i5 = z ? 1 : 0;
        return i2 + i3;
    }

    public String toString() {
        return "Scan(content=" + this.content + ", date=" + this.date + ", posted=" + this.posted + ")";
    }

    public Scan(String str, String str2, boolean z) {
        Intrinsics.checkNotNullParameter(str, FirebaseAnalytics.Param.CONTENT);
        this.content = str;
        this.date = str2;
        this.posted = z;
    }

    public final String getContent() {
        return this.content;
    }

    public final void setContent(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.content = str;
    }

    public final String getDate() {
        return this.date;
    }

    public final void setDate(String str) {
        this.date = str;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ Scan(String str, String str2, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, (i & 4) != 0 ? false : z);
    }

    public final boolean getPosted() {
        return this.posted;
    }

    public final void setPosted(boolean z) {
        this.posted = z;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/digitalwallet/app/model/db/scan/Scan$Companion;", "", "()V", Constants.MessagePayloadKeys.FROM, "Lcom/digitalwallet/app/model/db/scan/Scan;", "barcode", "Lcom/google/android/gms/vision/barcode/Barcode;", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
    /* compiled from: Scan.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Scan from(Barcode barcode) {
            Intrinsics.checkNotNullParameter(barcode, "barcode");
            String str = barcode.rawValue;
            Intrinsics.checkNotNullExpressionValue(str, "barcode.rawValue");
            return new Scan(str, DateFormattingHelper.INSTANCE.getCurrentDate(), false, 4, null);
        }
    }

    public final String getComposite() {
        if (this.date != null) {
            String str = this.content + '|' + this.date;
            if (str != null) {
                return str;
            }
        }
        return this.content;
    }
}
