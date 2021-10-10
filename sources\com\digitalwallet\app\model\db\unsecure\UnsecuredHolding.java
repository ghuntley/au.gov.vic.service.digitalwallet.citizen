package com.digitalwallet.app.model.db.unsecure;

import android.content.Context;
import com.digitalwallet.app.model.Asset;
import com.digitalwallet.app.model.DynamicHoldingDisplay;
import com.digitalwallet.app.model.DynamicHoldingRenewal;
import com.digitalwallet.app.model.HoldingKt;
import com.digitalwallet.app.model.HoldingRecordAttributes;
import com.digitalwallet.app.model.HoldingType;
import com.digitalwallet.app.model.ShareHolding;
import com.digitalwallet.app.view.main.HoldingElements;
import com.digitalwallet.app.view.main.HoldingElementsKt;
import com.google.firebase.messaging.Constants;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@JsonClass(generateAdapter = true)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b#\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0017\u0018\u00002\u00020\u0001BK\b\u0012\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\u0002\u0010\u0011B\u0005¢\u0006\u0002\u0010\u0012J\u0010\u0010I\u001a\u0004\u0018\u00010\u00052\u0006\u0010J\u001a\u00020KJ\b\u0010L\u001a\u00020'H\u0002J\u000e\u0010M\u001a\u00020\u00002\u0006\u0010N\u001a\u00020\u0000R,\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r8\u0006@\u0006X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0013\u0010\u0012\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R$\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0018\u0010\u0012\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR&\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u001d\u0010\u0012\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u0011\u0010\"\u001a\u00020#8F¢\u0006\u0006\u001a\u0004\b$\u0010%R\u0011\u0010&\u001a\u00020'8F¢\u0006\u0006\u001a\u0004\b(\u0010)R\u001a\u0010*\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\"\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u00103\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u0011\u00104\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b5\u0010,R\u0011\u00106\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b6\u00107R$\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b8\u0010\u0012\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R\u0011\u0010=\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b>\u00107R&\u0010\u000f\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b?\u0010\u0012\u001a\u0004\b@\u0010A\"\u0004\bB\u0010CR\u0011\u0010D\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\bE\u00107R\u001a\u0010\b\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bF\u00107\"\u0004\bG\u0010H¨\u0006O"}, d2 = {"Lcom/digitalwallet/app/model/db/unsecure/UnsecuredHolding;", "", "id", "", "link", "", "attributes", "Lcom/digitalwallet/app/model/HoldingRecordAttributes;", "shouldUpdate", "", Constants.ScionAnalytics.MessageType.DISPLAY_NOTIFICATION, "Lcom/digitalwallet/app/model/DynamicHoldingDisplay;", ShareHolding.assetDataKey, "", "Lcom/digitalwallet/app/model/Asset;", "renewal", "Lcom/digitalwallet/app/model/DynamicHoldingRenewal;", "(ILjava/lang/String;Lcom/digitalwallet/app/model/HoldingRecordAttributes;ZLcom/digitalwallet/app/model/DynamicHoldingDisplay;Ljava/util/List;Lcom/digitalwallet/app/model/DynamicHoldingRenewal;)V", "()V", "getAssets$annotations", "getAssets", "()Ljava/util/List;", "setAssets", "(Ljava/util/List;)V", "getAttributes$annotations", "getAttributes", "()Lcom/digitalwallet/app/model/HoldingRecordAttributes;", "setAttributes", "(Lcom/digitalwallet/app/model/HoldingRecordAttributes;)V", "getDisplay$annotations", "getDisplay", "()Lcom/digitalwallet/app/model/DynamicHoldingDisplay;", "setDisplay", "(Lcom/digitalwallet/app/model/DynamicHoldingDisplay;)V", "holdingElements", "Lcom/digitalwallet/app/view/main/HoldingElements;", "getHoldingElements", "()Lcom/digitalwallet/app/view/main/HoldingElements;", "holdingType", "Lcom/digitalwallet/app/model/HoldingType;", "getHoldingType", "()Lcom/digitalwallet/app/model/HoldingType;", "holdingTypeInt", "getHoldingTypeInt", "()I", "setHoldingTypeInt", "(I)V", "getId", "()Ljava/lang/Integer;", "setId", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "idForNotification", "getIdForNotification", "isValid", "()Z", "getLink$annotations", "getLink", "()Ljava/lang/String;", "setLink", "(Ljava/lang/String;)V", "noId", "getNoId", "getRenewal$annotations", "getRenewal", "()Lcom/digitalwallet/app/model/DynamicHoldingRenewal;", "setRenewal", "(Lcom/digitalwallet/app/model/DynamicHoldingRenewal;)V", "shouldNotify", "getShouldNotify", "getShouldUpdate", "setShouldUpdate", "(Z)V", "getDetailTitle", "context", "Landroid/content/Context;", "holdingTypeFromInt", "mergeWithLocalHolding", "other", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: UnsecuredHolding.kt */
public class UnsecuredHolding {
    private List<Asset> assets;
    private HoldingRecordAttributes attributes;
    private DynamicHoldingDisplay display;
    private int holdingTypeInt;
    private Integer id;
    private String link;
    private DynamicHoldingRenewal renewal;
    private boolean shouldUpdate;

    @Json(name = ShareHolding.assetDataKey)
    public static /* synthetic */ void getAssets$annotations() {
    }

    @Json(name = "attributes")
    public static /* synthetic */ void getAttributes$annotations() {
    }

    @Json(name = Constants.ScionAnalytics.MessageType.DISPLAY_NOTIFICATION)
    public static /* synthetic */ void getDisplay$annotations() {
    }

    @Json(name = "link")
    public static /* synthetic */ void getLink$annotations() {
    }

    @Json(name = "renewal")
    public static /* synthetic */ void getRenewal$annotations() {
    }

    public UnsecuredHolding() {
        this.attributes = new HoldingRecordAttributes(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 134217727, null);
        this.link = "";
        this.holdingTypeInt = -1;
    }

    private UnsecuredHolding(int i, String str, HoldingRecordAttributes holdingRecordAttributes, boolean z, DynamicHoldingDisplay dynamicHoldingDisplay, List<Asset> list, DynamicHoldingRenewal dynamicHoldingRenewal) {
        this();
        this.id = Integer.valueOf(i);
        this.link = str;
        this.holdingTypeInt = HoldingKt.holdingType(dynamicHoldingDisplay != null ? dynamicHoldingDisplay.getCardTemplate() : null, holdingRecordAttributes).ordinal();
        this.shouldUpdate = z;
        this.attributes = holdingRecordAttributes;
        this.display = dynamicHoldingDisplay;
        this.assets = list;
        this.renewal = dynamicHoldingRenewal;
    }

    public final UnsecuredHolding mergeWithLocalHolding(UnsecuredHolding unsecuredHolding) {
        Intrinsics.checkNotNullParameter(unsecuredHolding, "other");
        Integer num = unsecuredHolding.id;
        Intrinsics.checkNotNull(num);
        return new UnsecuredHolding(num.intValue(), this.link, this.attributes, this.shouldUpdate, this.display, this.assets, this.renewal);
    }

    private final HoldingType holdingTypeFromInt() {
        HoldingType holdingType;
        HoldingType[] values = HoldingType.values();
        int length = values.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                holdingType = null;
                break;
            }
            holdingType = values[i];
            if (holdingType.ordinal() == this.holdingTypeInt) {
                break;
            }
            i++;
        }
        return holdingType != null ? holdingType : HoldingType.UNKNOWN;
    }

    public final Integer getId() {
        return this.id;
    }

    public final void setId(Integer num) {
        this.id = num;
    }

    public final HoldingRecordAttributes getAttributes() {
        return this.attributes;
    }

    public final void setAttributes(HoldingRecordAttributes holdingRecordAttributes) {
        Intrinsics.checkNotNullParameter(holdingRecordAttributes, "<set-?>");
        this.attributes = holdingRecordAttributes;
    }

    public final String getLink() {
        return this.link;
    }

    public final void setLink(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.link = str;
    }

    public final int getHoldingTypeInt() {
        return this.holdingTypeInt;
    }

    public final void setHoldingTypeInt(int i) {
        this.holdingTypeInt = i;
    }

    public final boolean getShouldUpdate() {
        return this.shouldUpdate;
    }

    public final void setShouldUpdate(boolean z) {
        this.shouldUpdate = z;
    }

    public final DynamicHoldingDisplay getDisplay() {
        return this.display;
    }

    public final void setDisplay(DynamicHoldingDisplay dynamicHoldingDisplay) {
        this.display = dynamicHoldingDisplay;
    }

    public final List<Asset> getAssets() {
        return this.assets;
    }

    public final void setAssets(List<Asset> list) {
        this.assets = list;
    }

    public final DynamicHoldingRenewal getRenewal() {
        return this.renewal;
    }

    public final void setRenewal(DynamicHoldingRenewal dynamicHoldingRenewal) {
        this.renewal = dynamicHoldingRenewal;
    }

    public final HoldingType getHoldingType() {
        DynamicHoldingDisplay dynamicHoldingDisplay = this.display;
        return HoldingKt.holdingType(dynamicHoldingDisplay != null ? dynamicHoldingDisplay.getCardTemplate() : null, this.attributes);
    }

    public final HoldingElements getHoldingElements() {
        DynamicHoldingDisplay dynamicHoldingDisplay = this.display;
        return HoldingElementsKt.holdingElements(dynamicHoldingDisplay != null ? dynamicHoldingDisplay.getCardTemplate() : null, this.attributes);
    }

    public final boolean isValid() {
        return getHoldingType() == HoldingType.TEMPLATE || (getHoldingType() != HoldingType.UNKNOWN && this.attributes.checkTypeValidity());
    }

    public final String getDetailTitle(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return HoldingKt.getHoldingDetailTitle(context, this.display, this.attributes);
    }

    public final boolean getShouldNotify() {
        return this.renewal != null || this.attributes.getDurationType().getShouldNotifyExpiry();
    }

    public final boolean getNoId() {
        Integer num = this.id;
        return (num != null && num.intValue() == 0) || this.id == null;
    }

    public final int getIdForNotification() {
        if (getNoId()) {
            return this.link.hashCode();
        }
        Integer num = this.id;
        Intrinsics.checkNotNull(num);
        return num.intValue();
    }
}
