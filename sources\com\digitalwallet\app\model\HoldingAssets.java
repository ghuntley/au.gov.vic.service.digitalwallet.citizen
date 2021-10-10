package com.digitalwallet.app.model;

import android.content.Context;
import androidx.databinding.ObservableArrayMap;
import com.digitalwallet.app.services.AssetService;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\fR\u001d\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/digitalwallet/app/model/HoldingAssets;", "", "context", "Landroid/content/Context;", "assetService", "Lcom/digitalwallet/app/services/AssetService;", ShareHolding.assetDataKey, "", "Lcom/digitalwallet/app/model/Asset;", "overrideWidth", "", "overrideHeight", "(Landroid/content/Context;Lcom/digitalwallet/app/services/AssetService;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/Integer;)V", "map", "Landroidx/databinding/ObservableArrayMap;", "", "Lcom/digitalwallet/app/model/DrawableAsset;", "getMap", "()Landroidx/databinding/ObservableArrayMap;", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: Holding.kt */
public final class HoldingAssets {
    private final ObservableArrayMap<String, DrawableAsset> map;

    public HoldingAssets(Context context, AssetService assetService, List<Asset> list, Integer num, Integer num2) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(assetService, "assetService");
        this.map = (ObservableArrayMap) new HoldingAssets$map$1(list, assetService, context, num, num2).invoke();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ HoldingAssets(Context context, AssetService assetService, List list, Integer num, Integer num2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, assetService, list, (i & 8) != 0 ? null : num, (i & 16) != 0 ? null : num2);
    }

    public final ObservableArrayMap<String, DrawableAsset> getMap() {
        return this.map;
    }
}
