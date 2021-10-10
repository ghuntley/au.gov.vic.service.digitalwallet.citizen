package com.digitalwallet.app.model;

import android.content.Context;
import android.content.res.Resources;
import android.os.Parcel;
import android.os.Parcelable;
import com.digitalwallet.app.model.db.secure.EncryptedSecureHoldings;
import com.digitalwallet.app.model.db.secure.Securable;
import com.digitalwallet.app.model.db.secure.SecuredData;
import com.digitalwallet.app.model.db.secure.SecuredStoreKt;
import com.digitalwallet.app.view.main.HoldingElements;
import com.digitalwallet.app.view.main.HoldingElementsKt;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonClass;
import com.squareup.moshi.Moshi;
import io.reactivex.subjects.PublishSubject;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

@JsonClass(generateAdapter = true)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u0002BM\u0012\b\b\u0003\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0003\u0010\u0007\u001a\u00020\u0004\u0012\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u0010\b\u0003\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b\u0012\n\b\u0003\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0002\u0010\u000fJ\t\u00109\u001a\u00020\u0004HÆ\u0003J\t\u0010:\u001a\u00020\u0006HÆ\u0003J\t\u0010;\u001a\u00020\u0004HÆ\u0003J\u000b\u0010<\u001a\u0004\u0018\u00010\tHÆ\u0003J\u0011\u0010=\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bHÆ\u0003J\u000b\u0010>\u001a\u0004\u0018\u00010\u000eHÆ\u0003JQ\u0010?\u001a\u00020\u00002\b\b\u0003\u0010\u0003\u001a\u00020\u00042\b\b\u0003\u0010\u0005\u001a\u00020\u00062\b\b\u0003\u0010\u0007\u001a\u00020\u00042\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\t2\u0010\b\u0003\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b2\n\b\u0003\u0010\r\u001a\u0004\u0018\u00010\u000eHÆ\u0001J\t\u0010@\u001a\u000202HÖ\u0001J\u0013\u0010A\u001a\u00020-2\b\u0010B\u001a\u0004\u0018\u00010CHÖ\u0003J\t\u0010D\u001a\u000202HÖ\u0001J\u0010\u0010E\u001a\u00020\u00042\b\u0010F\u001a\u0004\u0018\u00010GJ\u0006\u0010H\u001a\u00020\u0012J\b\u0010I\u001a\u00020JH\u0016J\t\u0010K\u001a\u00020\u0004HÖ\u0001J\u0019\u0010L\u001a\u00020\u00122\u0006\u0010M\u001a\u00020N2\u0006\u0010O\u001a\u000202HÖ\u0001R\u001d\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011¢\u0006\u000e\n\u0000\u0012\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0019\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0017\u0010\u001d\u001a\u00020\u001e8F¢\u0006\f\u0012\u0004\b\u001f\u0010\u0014\u001a\u0004\b \u0010!R\u0017\u0010\"\u001a\u00020#8F¢\u0006\f\u0012\u0004\b$\u0010\u0014\u001a\u0004\b%\u0010&R\u0011\u0010\u0007\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010(R\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u0017\u0010,\u001a\u00020-8F¢\u0006\f\u0012\u0004\b.\u0010\u0014\u001a\u0004\b/\u00100R$\u00101\u001a\u0004\u0018\u000102X\u000e¢\u0006\u0016\n\u0002\u00108\u0012\u0004\b3\u0010\u0014\u001a\u0004\b4\u00105\"\u0004\b6\u00107¨\u0006P"}, d2 = {"Lcom/digitalwallet/app/model/SecureHolding;", "Lcom/digitalwallet/app/model/db/secure/Securable;", "Landroid/os/Parcelable;", "link", "", "attributes", "Lcom/digitalwallet/app/model/HoldingRecordAttributes;", "jws", "dynamicDisplay", "Lcom/digitalwallet/app/model/DynamicHoldingDisplay;", ShareHolding.assetDataKey, "", "Lcom/digitalwallet/app/model/Asset;", "renewal", "Lcom/digitalwallet/app/model/DynamicHoldingRenewal;", "(Ljava/lang/String;Lcom/digitalwallet/app/model/HoldingRecordAttributes;Ljava/lang/String;Lcom/digitalwallet/app/model/DynamicHoldingDisplay;Ljava/util/List;Lcom/digitalwallet/app/model/DynamicHoldingRenewal;)V", "actionEmitter", "Lio/reactivex/subjects/PublishSubject;", "", "getActionEmitter$annotations", "()V", "getActionEmitter", "()Lio/reactivex/subjects/PublishSubject;", "getAssets", "()Ljava/util/List;", "getAttributes", "()Lcom/digitalwallet/app/model/HoldingRecordAttributes;", "getDynamicDisplay", "()Lcom/digitalwallet/app/model/DynamicHoldingDisplay;", "holdingElements", "Lcom/digitalwallet/app/view/main/HoldingElements;", "getHoldingElements$annotations", "getHoldingElements", "()Lcom/digitalwallet/app/view/main/HoldingElements;", "holdingType", "Lcom/digitalwallet/app/model/HoldingType;", "getHoldingType$annotations", "getHoldingType", "()Lcom/digitalwallet/app/model/HoldingType;", "getJws", "()Ljava/lang/String;", "getLink", "getRenewal", "()Lcom/digitalwallet/app/model/DynamicHoldingRenewal;", "showExpiryWarning", "", "getShowExpiryWarning$annotations", "getShowExpiryWarning", "()Z", "unsecuredId", "", "getUnsecuredId$annotations", "getUnsecuredId", "()Ljava/lang/Integer;", "setUnsecuredId", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "describeContents", "equals", "other", "", "hashCode", "holdingTypeName", "context", "Landroid/content/Context;", "performAction", "toSecureData", "Lcom/digitalwallet/app/model/db/secure/SecuredData;", "toString", "writeToParcel", "parcel", "Landroid/os/Parcel;", "flags", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: Holding.kt */
public final class SecureHolding implements Securable, Parcelable {
    public static final Parcelable.Creator CREATOR = new Creator();
    private final PublishSubject<Unit> actionEmitter;
    private final List<Asset> assets;
    private final HoldingRecordAttributes attributes;
    private final DynamicHoldingDisplay dynamicDisplay;
    private final String jws;
    private final String link;
    private final DynamicHoldingRenewal renewal;
    private Integer unsecuredId;

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 0})
    public static class Creator implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        public final Object createFromParcel(Parcel parcel) {
            ArrayList arrayList;
            Intrinsics.checkNotNullParameter(parcel, "in");
            String readString = parcel.readString();
            HoldingRecordAttributes holdingRecordAttributes = (HoldingRecordAttributes) HoldingRecordAttributes.CREATOR.createFromParcel(parcel);
            String readString2 = parcel.readString();
            DynamicHoldingDisplay dynamicHoldingDisplay = parcel.readInt() != 0 ? (DynamicHoldingDisplay) DynamicHoldingDisplay.CREATOR.createFromParcel(parcel) : null;
            if (parcel.readInt() != 0) {
                int readInt = parcel.readInt();
                arrayList = new ArrayList(readInt);
                while (readInt != 0) {
                    arrayList.add((Asset) Asset.CREATOR.createFromParcel(parcel));
                    readInt--;
                }
            } else {
                arrayList = null;
            }
            return new SecureHolding(readString, holdingRecordAttributes, readString2, dynamicHoldingDisplay, arrayList, parcel.readInt() != 0 ? (DynamicHoldingRenewal) DynamicHoldingRenewal.CREATOR.createFromParcel(parcel) : null);
        }

        @Override // android.os.Parcelable.Creator
        public final Object[] newArray(int i) {
            return new SecureHolding[i];
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: com.digitalwallet.app.model.SecureHolding */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SecureHolding copy$default(SecureHolding secureHolding, String str, HoldingRecordAttributes holdingRecordAttributes, String str2, DynamicHoldingDisplay dynamicHoldingDisplay, List list, DynamicHoldingRenewal dynamicHoldingRenewal, int i, Object obj) {
        if ((i & 1) != 0) {
            str = secureHolding.link;
        }
        if ((i & 2) != 0) {
            holdingRecordAttributes = secureHolding.attributes;
        }
        if ((i & 4) != 0) {
            str2 = secureHolding.jws;
        }
        if ((i & 8) != 0) {
            dynamicHoldingDisplay = secureHolding.dynamicDisplay;
        }
        if ((i & 16) != 0) {
            list = secureHolding.assets;
        }
        if ((i & 32) != 0) {
            dynamicHoldingRenewal = secureHolding.renewal;
        }
        return secureHolding.copy(str, holdingRecordAttributes, str2, dynamicHoldingDisplay, list, dynamicHoldingRenewal);
    }

    public static /* synthetic */ void getActionEmitter$annotations() {
    }

    public static /* synthetic */ void getHoldingElements$annotations() {
    }

    public static /* synthetic */ void getHoldingType$annotations() {
    }

    public static /* synthetic */ void getShowExpiryWarning$annotations() {
    }

    public static /* synthetic */ void getUnsecuredId$annotations() {
    }

    public final String component1() {
        return this.link;
    }

    public final HoldingRecordAttributes component2() {
        return this.attributes;
    }

    public final String component3() {
        return this.jws;
    }

    public final DynamicHoldingDisplay component4() {
        return this.dynamicDisplay;
    }

    public final List<Asset> component5() {
        return this.assets;
    }

    public final DynamicHoldingRenewal component6() {
        return this.renewal;
    }

    public final SecureHolding copy(@Json(name = "link") String str, @Json(name = "attributes") HoldingRecordAttributes holdingRecordAttributes, @Json(name = "jws") String str2, @Json(name = "display") DynamicHoldingDisplay dynamicHoldingDisplay, @Json(name = "assets") List<Asset> list, @Json(name = "renewal") DynamicHoldingRenewal dynamicHoldingRenewal) {
        Intrinsics.checkNotNullParameter(str, "link");
        Intrinsics.checkNotNullParameter(holdingRecordAttributes, "attributes");
        Intrinsics.checkNotNullParameter(str2, "jws");
        return new SecureHolding(str, holdingRecordAttributes, str2, dynamicHoldingDisplay, list, dynamicHoldingRenewal);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SecureHolding)) {
            return false;
        }
        SecureHolding secureHolding = (SecureHolding) obj;
        return Intrinsics.areEqual(this.link, secureHolding.link) && Intrinsics.areEqual(this.attributes, secureHolding.attributes) && Intrinsics.areEqual(this.jws, secureHolding.jws) && Intrinsics.areEqual(this.dynamicDisplay, secureHolding.dynamicDisplay) && Intrinsics.areEqual(this.assets, secureHolding.assets) && Intrinsics.areEqual(this.renewal, secureHolding.renewal);
    }

    public int hashCode() {
        String str = this.link;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        HoldingRecordAttributes holdingRecordAttributes = this.attributes;
        int hashCode2 = (hashCode + (holdingRecordAttributes != null ? holdingRecordAttributes.hashCode() : 0)) * 31;
        String str2 = this.jws;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        DynamicHoldingDisplay dynamicHoldingDisplay = this.dynamicDisplay;
        int hashCode4 = (hashCode3 + (dynamicHoldingDisplay != null ? dynamicHoldingDisplay.hashCode() : 0)) * 31;
        List<Asset> list = this.assets;
        int hashCode5 = (hashCode4 + (list != null ? list.hashCode() : 0)) * 31;
        DynamicHoldingRenewal dynamicHoldingRenewal = this.renewal;
        if (dynamicHoldingRenewal != null) {
            i = dynamicHoldingRenewal.hashCode();
        }
        return hashCode5 + i;
    }

    public String toString() {
        return "SecureHolding(link=" + this.link + ", attributes=" + this.attributes + ", jws=" + this.jws + ", dynamicDisplay=" + this.dynamicDisplay + ", assets=" + this.assets + ", renewal=" + this.renewal + ")";
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.link);
        this.attributes.writeToParcel(parcel, 0);
        parcel.writeString(this.jws);
        DynamicHoldingDisplay dynamicHoldingDisplay = this.dynamicDisplay;
        if (dynamicHoldingDisplay != null) {
            parcel.writeInt(1);
            dynamicHoldingDisplay.writeToParcel(parcel, 0);
        } else {
            parcel.writeInt(0);
        }
        List<Asset> list = this.assets;
        if (list != null) {
            parcel.writeInt(1);
            parcel.writeInt(list.size());
            for (Asset asset : list) {
                asset.writeToParcel(parcel, 0);
            }
        } else {
            parcel.writeInt(0);
        }
        DynamicHoldingRenewal dynamicHoldingRenewal = this.renewal;
        if (dynamicHoldingRenewal != null) {
            parcel.writeInt(1);
            dynamicHoldingRenewal.writeToParcel(parcel, 0);
            return;
        }
        parcel.writeInt(0);
    }

    public SecureHolding(@Json(name = "link") String str, @Json(name = "attributes") HoldingRecordAttributes holdingRecordAttributes, @Json(name = "jws") String str2, @Json(name = "display") DynamicHoldingDisplay dynamicHoldingDisplay, @Json(name = "assets") List<Asset> list, @Json(name = "renewal") DynamicHoldingRenewal dynamicHoldingRenewal) {
        Intrinsics.checkNotNullParameter(str, "link");
        Intrinsics.checkNotNullParameter(holdingRecordAttributes, "attributes");
        Intrinsics.checkNotNullParameter(str2, "jws");
        this.link = str;
        this.attributes = holdingRecordAttributes;
        this.jws = str2;
        this.dynamicDisplay = dynamicHoldingDisplay;
        this.assets = list;
        this.renewal = dynamicHoldingRenewal;
        PublishSubject<Unit> create = PublishSubject.create();
        Intrinsics.checkNotNullExpressionValue(create, "PublishSubject.create()");
        this.actionEmitter = create;
    }

    public final String getLink() {
        return this.link;
    }

    public final HoldingRecordAttributes getAttributes() {
        return this.attributes;
    }

    public final String getJws() {
        return this.jws;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SecureHolding(String str, HoldingRecordAttributes holdingRecordAttributes, String str2, DynamicHoldingDisplay dynamicHoldingDisplay, List list, DynamicHoldingRenewal dynamicHoldingRenewal, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, holdingRecordAttributes, (i & 4) != 0 ? "" : str2, (i & 8) != 0 ? null : dynamicHoldingDisplay, (i & 16) != 0 ? null : list, (i & 32) != 0 ? null : dynamicHoldingRenewal);
    }

    public final DynamicHoldingDisplay getDynamicDisplay() {
        return this.dynamicDisplay;
    }

    public final List<Asset> getAssets() {
        return this.assets;
    }

    public final DynamicHoldingRenewal getRenewal() {
        return this.renewal;
    }

    public final Integer getUnsecuredId() {
        return this.unsecuredId;
    }

    public final void setUnsecuredId(Integer num) {
        this.unsecuredId = num;
    }

    @Override // com.digitalwallet.app.model.db.secure.Securable
    public SecuredData toSecureData() {
        Moshi build = new Moshi.Builder().build();
        Intrinsics.checkNotNullExpressionValue(build, "Moshi.Builder().build()");
        JsonAdapter adapter = build.adapter(SecureHolding.class);
        Intrinsics.checkNotNullExpressionValue(adapter, "this.adapter(T::class.java)");
        String json = adapter.toJson(this);
        Intrinsics.checkNotNullExpressionValue(json, "Moshi.Builder().build()\n…            .toJson(this)");
        Charset charset = Charsets.UTF_8;
        Objects.requireNonNull(json, "null cannot be cast to non-null type java.lang.String");
        byte[] bytes = json.getBytes(charset);
        Intrinsics.checkNotNullExpressionValue(bytes, "(this as java.lang.String).getBytes(charset)");
        Pair<byte[], byte[]> encrypt = SecuredStoreKt.encrypt(bytes);
        return new EncryptedSecureHoldings(0, encrypt.getSecond(), encrypt.getFirst(), 1, null);
    }

    public final HoldingType getHoldingType() {
        DynamicHoldingDisplay dynamicHoldingDisplay = this.dynamicDisplay;
        return HoldingKt.holdingType(dynamicHoldingDisplay != null ? dynamicHoldingDisplay.getCardTemplate() : null, this.attributes);
    }

    public final HoldingElements getHoldingElements() {
        DynamicHoldingDisplay dynamicHoldingDisplay = this.dynamicDisplay;
        return HoldingElementsKt.holdingElements(dynamicHoldingDisplay != null ? dynamicHoldingDisplay.getCardTemplate() : null, this.attributes);
    }

    public final String holdingTypeName(Context context) {
        String str;
        Resources resources;
        DynamicHoldingDisplay dynamicHoldingDisplay = this.dynamicDisplay;
        if (dynamicHoldingDisplay == null || (str = dynamicHoldingDisplay.getHoldingName()) == null) {
            if (context == null || (resources = context.getResources()) == null) {
                str = null;
            } else {
                Integer detailTitle = getHoldingElements().getDetailTitle();
                str = resources.getString(detailTitle != null ? detailTitle.intValue() : getHoldingElements().getTitle());
            }
        }
        return str != null ? str : getHoldingType().name();
    }

    public final boolean getShowExpiryWarning() {
        DynamicHoldingRenewal dynamicHoldingRenewal = this.renewal;
        if (dynamicHoldingRenewal == null) {
            return this.attributes.showExpiryWarning(getHoldingType());
        }
        Long dayToExpire = this.attributes.getDayToExpire();
        return dayToExpire != null && dayToExpire.longValue() <= ((long) dynamicHoldingRenewal.getPeriod());
    }

    public final PublishSubject<Unit> getActionEmitter() {
        return this.actionEmitter;
    }

    public final void performAction() {
        this.actionEmitter.onNext(Unit.INSTANCE);
    }
}
