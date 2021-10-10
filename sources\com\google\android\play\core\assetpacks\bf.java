package com.google.android.play.core.assetpacks;

import java.util.Objects;

final class bf extends AssetLocation {
    private final String a;
    private final long b;
    private final long c;

    bf(String str, long j, long j2) {
        Objects.requireNonNull(str, "Null path");
        this.a = str;
        this.b = j;
        this.c = j2;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof AssetLocation) {
            AssetLocation assetLocation = (AssetLocation) obj;
            return this.a.equals(assetLocation.path()) && this.b == assetLocation.offset() && this.c == assetLocation.size();
        }
    }

    public final int hashCode() {
        int hashCode = this.a.hashCode();
        long j = this.b;
        long j2 = this.c;
        return ((((hashCode ^ 1000003) * 1000003) ^ ((int) (j ^ (j >>> 32)))) * 1000003) ^ ((int) ((j2 >>> 32) ^ j2));
    }

    @Override // com.google.android.play.core.assetpacks.AssetLocation
    public final long offset() {
        return this.b;
    }

    @Override // com.google.android.play.core.assetpacks.AssetLocation
    public final String path() {
        return this.a;
    }

    @Override // com.google.android.play.core.assetpacks.AssetLocation
    public final long size() {
        return this.c;
    }

    public final String toString() {
        String str = this.a;
        long j = this.b;
        long j2 = this.c;
        StringBuilder sb = new StringBuilder(str.length() + 76);
        sb.append("AssetLocation{path=");
        sb.append(str);
        sb.append(", offset=");
        sb.append(j);
        sb.append(", size=");
        sb.append(j2);
        sb.append("}");
        return sb.toString();
    }
}
