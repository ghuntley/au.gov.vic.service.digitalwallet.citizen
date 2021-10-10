package com.digitalwallet.app.model.db.unsecure;

import com.digitalwallet.app.model.Asset;
import com.digitalwallet.app.model.ShareHolding;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.Types;
import java.lang.reflect.Type;
import java.util.List;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0007J\u0018\u0010\b\u001a\u00020\u00072\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004H\u0007¨\u0006\n"}, d2 = {"Lcom/digitalwallet/app/model/db/unsecure/AssetListConverter;", "", "()V", "toAssetList", "", "Lcom/digitalwallet/app/model/Asset;", "json", "", "toJson", ShareHolding.assetDataKey, "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: UnsecuredHolding.kt */
public final class AssetListConverter {
    public final String toJson(List<Asset> list) {
        String json;
        return (list == null || (json = new Moshi.Builder().build().adapter(Types.newParameterizedType(List.class, new Type[]{Asset.class})).toJson(list)) == null) ? "" : json;
    }

    public final List<Asset> toAssetList(String str) {
        try {
            JsonAdapter adapter = new Moshi.Builder().build().adapter(Types.newParameterizedType(List.class, Asset.class));
            if (str == null) {
                str = "";
            }
            return (List) adapter.fromJson(str);
        } catch (Exception unused) {
            return null;
        }
    }
}
