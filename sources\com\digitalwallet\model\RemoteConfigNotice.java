package com.digitalwallet.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.bouncycastle.i18n.MessageBundle;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/digitalwallet/model/RemoteConfigNotice;", "", MessageBundle.TITLE_ENTRY, "", "message", "(Ljava/lang/String;Ljava/lang/String;)V", "getMessage", "()Ljava/lang/String;", "getTitle", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "base_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: RemoteConfig.kt */
public final class RemoteConfigNotice {
    private final String message;
    private final String title;

    public static /* synthetic */ RemoteConfigNotice copy$default(RemoteConfigNotice remoteConfigNotice, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = remoteConfigNotice.title;
        }
        if ((i & 2) != 0) {
            str2 = remoteConfigNotice.message;
        }
        return remoteConfigNotice.copy(str, str2);
    }

    public final String component1() {
        return this.title;
    }

    public final String component2() {
        return this.message;
    }

    public final RemoteConfigNotice copy(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, MessageBundle.TITLE_ENTRY);
        Intrinsics.checkNotNullParameter(str2, "message");
        return new RemoteConfigNotice(str, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RemoteConfigNotice)) {
            return false;
        }
        RemoteConfigNotice remoteConfigNotice = (RemoteConfigNotice) obj;
        return Intrinsics.areEqual(this.title, remoteConfigNotice.title) && Intrinsics.areEqual(this.message, remoteConfigNotice.message);
    }

    public int hashCode() {
        String str = this.title;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.message;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return "RemoteConfigNotice(title=" + this.title + ", message=" + this.message + ")";
    }

    public RemoteConfigNotice(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, MessageBundle.TITLE_ENTRY);
        Intrinsics.checkNotNullParameter(str2, "message");
        this.title = str;
        this.message = str2;
    }

    public final String getMessage() {
        return this.message;
    }

    public final String getTitle() {
        return this.title;
    }
}
