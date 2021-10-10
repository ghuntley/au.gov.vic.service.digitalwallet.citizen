package com.google.android.play.core.assetpacks;

public abstract class AssetPackLocation {
    private static final AssetPackLocation a = new bg(1, null, null);

    static AssetPackLocation a() {
        return a;
    }

    static AssetPackLocation b(String str, String str2) {
        return new bg(0, str, str2);
    }

    public abstract String assetsPath();

    public abstract int packStorageMethod();

    public abstract String path();
}
