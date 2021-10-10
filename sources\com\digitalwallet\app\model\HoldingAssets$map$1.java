package com.digitalwallet.app.model;

import android.content.Context;
import android.graphics.drawable.Drawable;
import androidx.databinding.ObservableArrayMap;
import com.bumptech.glide.RequestBuilder;
import com.digitalwallet.app.services.AssetService;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Landroidx/databinding/ObservableArrayMap;", "", "Lcom/digitalwallet/app/model/DrawableAsset;", "invoke"}, k = 3, mv = {1, 4, 0})
/* compiled from: Holding.kt */
public final class HoldingAssets$map$1 extends Lambda implements Function0<ObservableArrayMap<String, DrawableAsset>> {
    final /* synthetic */ AssetService $assetService;
    final /* synthetic */ List $assets;
    final /* synthetic */ Context $context;
    final /* synthetic */ Integer $overrideHeight;
    final /* synthetic */ Integer $overrideWidth;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    HoldingAssets$map$1(List list, AssetService assetService, Context context, Integer num, Integer num2) {
        super(0);
        this.$assets = list;
        this.$assetService = assetService;
        this.$context = context;
        this.$overrideWidth = num;
        this.$overrideHeight = num2;
    }

    @Override // kotlin.jvm.functions.Function0
    public final ObservableArrayMap<String, DrawableAsset> invoke() {
        ObservableArrayMap<String, DrawableAsset> observableArrayMap = new ObservableArrayMap<>();
        List<Asset> list = this.$assets;
        if (list != null) {
            for (Asset asset : list) {
                AssetType interpretedType = asset.getInterpretedType();
                if (interpretedType != null) {
                    RequestBuilder<Drawable> asset2 = this.$assetService.getAsset(this.$context, asset);
                    Context context = this.$context;
                    Integer num = this.$overrideWidth;
                    int intValue = num != null ? num.intValue() : interpretedType.standardWidth();
                    Integer num2 = this.$overrideHeight;
                    observableArrayMap.put(interpretedType.getJsonName(), new DrawableAsset(context, asset2, intValue, num2 != null ? num2.intValue() : interpretedType.standardHeight()));
                }
            }
        }
        return observableArrayMap;
    }
}
