package com.digitalwallet.app.model.db.unsecure;

import com.digitalwallet.app.model.Asset;
import com.digitalwallet.app.model.DynamicHoldingDisplay;
import com.digitalwallet.app.model.ShareHolding;
import com.google.firebase.messaging.Constants;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001BA\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f¢\u0006\u0002\u0010\u000eB\u000f\b\u0016\u0012\u0006\u0010\u000f\u001a\u00020\u0001¢\u0006\u0002\u0010\u0010B\u0005¢\u0006\u0002\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/digitalwallet/app/model/db/unsecure/UnsecuredHoldingRoom;", "Lcom/digitalwallet/app/model/db/unsecure/UnsecuredHolding;", "id", "", "link", "", "holdingTypeInt", "shouldUpdate", "", Constants.ScionAnalytics.MessageType.DISPLAY_NOTIFICATION, "Lcom/digitalwallet/app/model/DynamicHoldingDisplay;", ShareHolding.assetDataKey, "", "Lcom/digitalwallet/app/model/Asset;", "(ILjava/lang/String;IZLcom/digitalwallet/app/model/DynamicHoldingDisplay;Ljava/util/List;)V", "other", "(Lcom/digitalwallet/app/model/db/unsecure/UnsecuredHolding;)V", "()V", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: UnsecuredHolding.kt */
public final class UnsecuredHoldingRoom extends UnsecuredHolding {
    public UnsecuredHoldingRoom() {
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public UnsecuredHoldingRoom(int i, String str, int i2, boolean z, DynamicHoldingDisplay dynamicHoldingDisplay, List<Asset> list) {
        this();
        Intrinsics.checkNotNullParameter(str, "link");
        setId(Integer.valueOf(i));
        setLink(str);
        setHoldingTypeInt(i2);
        setShouldUpdate(z);
        setDisplay(dynamicHoldingDisplay);
        setAssets(list);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public UnsecuredHoldingRoom(UnsecuredHolding unsecuredHolding) {
        this();
        Intrinsics.checkNotNullParameter(unsecuredHolding, "other");
        setId(unsecuredHolding.getId());
        setLink(unsecuredHolding.getLink());
        setHoldingTypeInt(unsecuredHolding.getHoldingTypeInt());
        setAttributes(unsecuredHolding.getAttributes());
        setShouldUpdate(unsecuredHolding.getShouldUpdate());
        setDisplay(unsecuredHolding.getDisplay());
        setAssets(unsecuredHolding.getAssets());
        setRenewal(unsecuredHolding.getRenewal());
    }
}
