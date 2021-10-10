package com.google.android.play.core.assetpacks;

import java.util.Objects;

/* access modifiers changed from: package-private */
public final class bh extends AssetPackState {
    private final String a;
    private final int b;
    private final int c;
    private final long d;
    private final long e;
    private final int f;
    private final int g;

    bh(String str, int i, int i2, long j, long j2, int i3, int i4) {
        Objects.requireNonNull(str, "Null name");
        this.a = str;
        this.b = i;
        this.c = i2;
        this.d = j;
        this.e = j2;
        this.f = i3;
        this.g = i4;
    }

    @Override // com.google.android.play.core.assetpacks.AssetPackState
    public final int a() {
        return this.g;
    }

    @Override // com.google.android.play.core.assetpacks.AssetPackState
    public final long bytesDownloaded() {
        return this.d;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof AssetPackState) {
            AssetPackState assetPackState = (AssetPackState) obj;
            return this.a.equals(assetPackState.name()) && this.b == assetPackState.status() && this.c == assetPackState.errorCode() && this.d == assetPackState.bytesDownloaded() && this.e == assetPackState.totalBytesToDownload() && this.f == assetPackState.transferProgressPercentage() && this.g == assetPackState.a();
        }
    }

    @Override // com.google.android.play.core.assetpacks.AssetPackState
    public final int errorCode() {
        return this.c;
    }

    public final int hashCode() {
        int hashCode = this.a.hashCode();
        int i = this.b;
        int i2 = this.c;
        long j = this.d;
        long j2 = this.e;
        return ((((((((((((hashCode ^ 1000003) * 1000003) ^ i) * 1000003) ^ i2) * 1000003) ^ ((int) ((j >>> 32) ^ j))) * 1000003) ^ ((int) ((j2 >>> 32) ^ j2))) * 1000003) ^ this.f) * 1000003) ^ this.g;
    }

    @Override // com.google.android.play.core.assetpacks.AssetPackState
    public final String name() {
        return this.a;
    }

    @Override // com.google.android.play.core.assetpacks.AssetPackState
    public final int status() {
        return this.b;
    }

    public final String toString() {
        String str = this.a;
        int i = this.b;
        int i2 = this.c;
        long j = this.d;
        long j2 = this.e;
        int i3 = this.f;
        int i4 = this.g;
        StringBuilder sb = new StringBuilder(str.length() + 217);
        sb.append("AssetPackState{name=");
        sb.append(str);
        sb.append(", status=");
        sb.append(i);
        sb.append(", errorCode=");
        sb.append(i2);
        sb.append(", bytesDownloaded=");
        sb.append(j);
        sb.append(", totalBytesToDownload=");
        sb.append(j2);
        sb.append(", transferProgressPercentage=");
        sb.append(i3);
        sb.append(", updateAvailability=");
        sb.append(i4);
        sb.append("}");
        return sb.toString();
    }

    @Override // com.google.android.play.core.assetpacks.AssetPackState
    public final long totalBytesToDownload() {
        return this.e;
    }

    @Override // com.google.android.play.core.assetpacks.AssetPackState
    public final int transferProgressPercentage() {
        return this.f;
    }
}
