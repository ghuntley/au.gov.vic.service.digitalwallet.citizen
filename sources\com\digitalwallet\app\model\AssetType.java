package com.digitalwallet.app.model;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0005\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\t\u001a\u00020\nJ\u0006\u0010\u000b\u001a\u00020\nR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lcom/digitalwallet/app/model/AssetType;", "", "jsonName", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getJsonName", "()Ljava/lang/String;", "setJsonName", "(Ljava/lang/String;)V", "standardHeight", "", "standardWidth", "Photo", "CardFront", "CardBack", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: Asset.kt */
public enum AssetType {
    Photo("photo"),
    CardFront("cardfront"),
    CardBack("cardback");
    
    private String jsonName;

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 0})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[AssetType.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[AssetType.Photo.ordinal()] = 1;
            iArr[AssetType.CardFront.ordinal()] = 2;
            iArr[AssetType.CardBack.ordinal()] = 3;
            int[] iArr2 = new int[AssetType.values().length];
            $EnumSwitchMapping$1 = iArr2;
            iArr2[AssetType.Photo.ordinal()] = 1;
            iArr2[AssetType.CardFront.ordinal()] = 2;
            iArr2[AssetType.CardBack.ordinal()] = 3;
        }
    }

    private AssetType(String str) {
        this.jsonName = str;
    }

    public final String getJsonName() {
        return this.jsonName;
    }

    public final void setJsonName(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.jsonName = str;
    }

    public final int standardWidth() {
        int i = WhenMappings.$EnumSwitchMapping$0[ordinal()];
        if (i == 1) {
            return 300;
        }
        if (i == 2 || i == 3) {
            return 1080;
        }
        throw new NoWhenBranchMatchedException();
    }

    public final int standardHeight() {
        int i = WhenMappings.$EnumSwitchMapping$1[ordinal()];
        if (i == 1) {
            return 200;
        }
        if (i == 2 || i == 3) {
            return 720;
        }
        throw new NoWhenBranchMatchedException();
    }
}
