package com.digitalwallet.viewmodel.checkIn;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Base64;
import au.gov.vic.service.digitalwallet.citizen.R;
import com.digitalwallet.BuildConfig;
import com.digitalwallet.model.CheckInLocation;
import com.digitalwallet.model.CheckInQRPayload;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.internal.ImagesContract;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.nimbusds.jose.Payload;
import com.nimbusds.jose.crypto.ECDSAVerifier;
import com.nimbusds.jwt.SignedJWT;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.interfaces.ECPublicKey;
import java.security.spec.X509EncodedKeySpec;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import timber.log.Timber;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u0000 \u00042\u00020\u0001:\u0002\u0003\u0004B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0005"}, d2 = {"Lcom/digitalwallet/viewmodel/checkIn/CheckInUtils;", "", "()V", "CheckInCode", "Companion", "base_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: CheckInUtils.kt */
public final class CheckInUtils {
    public static final Companion Companion = new Companion(null);
    private static final int PLAY_SERVICES_RESOLUTION_REQUEST = 1;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0012J8\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u0019J\t\u0010\u001a\u001a\u00020\u0007HÖ\u0001J\u0013\u0010\u001b\u001a\u00020\n2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dHÖ\u0003J\t\u0010\u001e\u001a\u00020\u0007HÖ\u0001J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001J\u0019\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u0007HÖ\u0001R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0011\u0010\u0012¨\u0006%"}, d2 = {"Lcom/digitalwallet/viewmodel/checkIn/CheckInUtils$CheckInCode;", "Landroid/os/Parcelable;", "payload", "", "locationId", FirebaseAnalytics.Param.LOCATION, "type", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V", "canBeFavoured", "", "getCanBeFavoured", "()Z", "getLocation", "()Ljava/lang/String;", "getLocationId", "getPayload", "getType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)Lcom/digitalwallet/viewmodel/checkIn/CheckInUtils$CheckInCode;", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "base_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
    /* compiled from: CheckInUtils.kt */
    public static final class CheckInCode implements Parcelable {
        public static final Parcelable.Creator CREATOR = new Creator();
        private final boolean canBeFavoured;
        private final String location;
        private final String locationId;
        private final String payload;
        private final Integer type;

        @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 0})
        public static class Creator implements Parcelable.Creator {
            @Override // android.os.Parcelable.Creator
            public final Object createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "in");
                return new CheckInCode(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt() != 0 ? Integer.valueOf(parcel.readInt()) : null);
            }

            @Override // android.os.Parcelable.Creator
            public final Object[] newArray(int i) {
                return new CheckInCode[i];
            }
        }

        public static /* synthetic */ CheckInCode copy$default(CheckInCode checkInCode, String str, String str2, String str3, Integer num, int i, Object obj) {
            if ((i & 1) != 0) {
                str = checkInCode.payload;
            }
            if ((i & 2) != 0) {
                str2 = checkInCode.locationId;
            }
            if ((i & 4) != 0) {
                str3 = checkInCode.location;
            }
            if ((i & 8) != 0) {
                num = checkInCode.type;
            }
            return checkInCode.copy(str, str2, str3, num);
        }

        public final String component1() {
            return this.payload;
        }

        public final String component2() {
            return this.locationId;
        }

        public final String component3() {
            return this.location;
        }

        public final Integer component4() {
            return this.type;
        }

        public final CheckInCode copy(String str, String str2, String str3, Integer num) {
            Intrinsics.checkNotNullParameter(str, "payload");
            Intrinsics.checkNotNullParameter(str2, "locationId");
            Intrinsics.checkNotNullParameter(str3, FirebaseAnalytics.Param.LOCATION);
            return new CheckInCode(str, str2, str3, num);
        }

        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof CheckInCode)) {
                return false;
            }
            CheckInCode checkInCode = (CheckInCode) obj;
            return Intrinsics.areEqual(this.payload, checkInCode.payload) && Intrinsics.areEqual(this.locationId, checkInCode.locationId) && Intrinsics.areEqual(this.location, checkInCode.location) && Intrinsics.areEqual(this.type, checkInCode.type);
        }

        public int hashCode() {
            String str = this.payload;
            int i = 0;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            String str2 = this.locationId;
            int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
            String str3 = this.location;
            int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
            Integer num = this.type;
            if (num != null) {
                i = num.hashCode();
            }
            return hashCode3 + i;
        }

        public String toString() {
            return "CheckInCode(payload=" + this.payload + ", locationId=" + this.locationId + ", location=" + this.location + ", type=" + this.type + ")";
        }

        public void writeToParcel(Parcel parcel, int i) {
            int i2;
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeString(this.payload);
            parcel.writeString(this.locationId);
            parcel.writeString(this.location);
            Integer num = this.type;
            if (num != null) {
                parcel.writeInt(1);
                i2 = num.intValue();
            } else {
                i2 = 0;
            }
            parcel.writeInt(i2);
        }

        public CheckInCode(String str, String str2, String str3, Integer num) {
            Intrinsics.checkNotNullParameter(str, "payload");
            Intrinsics.checkNotNullParameter(str2, "locationId");
            Intrinsics.checkNotNullParameter(str3, FirebaseAnalytics.Param.LOCATION);
            this.payload = str;
            this.locationId = str2;
            this.location = str3;
            this.type = num;
            boolean z = true;
            if (num != null && (num == null || num.intValue() != 1)) {
                z = false;
            }
            this.canBeFavoured = z;
        }

        public final String getPayload() {
            return this.payload;
        }

        public final String getLocationId() {
            return this.locationId;
        }

        public final String getLocation() {
            return this.location;
        }

        public final Integer getType() {
            return this.type;
        }

        public final boolean getCanBeFavoured() {
            return this.canBeFavoured;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0018\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012J\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012J \u0010\u0014\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u0012R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/digitalwallet/viewmodel/checkIn/CheckInUtils$Companion;", "", "()V", "PLAY_SERVICES_RESOLUTION_REQUEST", "", "checkGoogleApiAvailability", "", "activity", "Landroid/app/Activity;", "isVerified", "", "signedJWT", "Lcom/nimbusds/jwt/SignedJWT;", "parseJSON", "Lcom/digitalwallet/viewmodel/checkIn/CheckInUtils$CheckInCode;", "moshi", "Lcom/squareup/moshi/Moshi;", "payload", "", "parseJWT", "parseUrl", "context", "Landroid/content/Context;", ImagesContract.URL, "base_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
    /* compiled from: CheckInUtils.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void checkGoogleApiAvailability(Activity activity) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            int isGooglePlayServicesAvailable = GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(activity);
            if (isGooglePlayServicesAvailable != 0) {
                Timber.e("isGooglePlayServicesAvailable returned " + isGooglePlayServicesAvailable, new Object[0]);
                Dialog errorDialog = GoogleApiAvailability.getInstance().getErrorDialog(activity, isGooglePlayServicesAvailable, 1);
                if (errorDialog != null) {
                    errorDialog.show();
                }
            }
        }

        public final CheckInCode parseUrl(Context context, Moshi moshi, String str) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(moshi, "moshi");
            Intrinsics.checkNotNullParameter(str, ImagesContract.URL);
            Uri parse = Uri.parse(str);
            String queryParameter = parse.getQueryParameter("metadata");
            if (queryParameter == null) {
                return null;
            }
            Intrinsics.checkNotNullExpressionValue(queryParameter, "uri.getQueryParameter(\"metadata\") ?: return null");
            String string = context.getString(R.string.instant_checkin_path);
            Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.string.instant_checkin_path)");
            Intrinsics.checkNotNullExpressionValue(parse, "uri");
            if (!(Intrinsics.areEqual(parse.getHost(), "service.vic.gov.au") && Intrinsics.areEqual(parse.getPath(), string))) {
                return null;
            }
            try {
                CheckInCode parseJWT = parseJWT(moshi, queryParameter);
                if (parseJWT == null) {
                    parseJWT = parseJSON(moshi, queryParameter);
                }
                return parseJWT;
            } catch (Exception e) {
                Timber.e(e);
                return null;
            }
        }

        public final CheckInCode parseJWT(Moshi moshi, String str) {
            Intrinsics.checkNotNullParameter(moshi, "moshi");
            Intrinsics.checkNotNullParameter(str, "payload");
            try {
                SignedJWT parse = SignedJWT.parse(str);
                Intrinsics.checkNotNullExpressionValue(parse, "signedJWT");
                if (!isVerified(parse)) {
                    return null;
                }
                Payload payload = parse.getPayload();
                JsonAdapter adapter = moshi.adapter(CheckInLocation.class);
                Intrinsics.checkNotNullExpressionValue(adapter, "this.adapter(T::class.java)");
                CheckInLocation checkInLocation = (CheckInLocation) adapter.fromJson(payload.toString());
                if (checkInLocation == null) {
                    return null;
                }
                Intrinsics.checkNotNullExpressionValue(checkInLocation, "moshi.adapter<CheckInLoc…oString()) ?: return null");
                return new CheckInCode(str, checkInLocation.getId(), checkInLocation.getName(), null);
            } catch (Throwable unused) {
                return null;
            }
        }

        public final CheckInCode parseJSON(Moshi moshi, String str) {
            Intrinsics.checkNotNullParameter(moshi, "moshi");
            Intrinsics.checkNotNullParameter(str, "payload");
            try {
                byte[] decode = Base64.decode(str, 8);
                Intrinsics.checkNotNullExpressionValue(decode, "payloadBytes");
                CheckInQRPayload checkInQRPayload = (CheckInQRPayload) moshi.adapter(CheckInQRPayload.class).fromJson(new String(decode, Charsets.UTF_8));
                if (checkInQRPayload == null) {
                    return null;
                }
                Intrinsics.checkNotNullExpressionValue(checkInQRPayload, "moshi.adapter(CheckInQRP…           ?: return null");
                return new CheckInCode(str, checkInQRPayload.getEncryptedId(), checkInQRPayload.getLocation(), Integer.valueOf(checkInQRPayload.getType()));
            } catch (Throwable unused) {
                return null;
            }
        }

        private final boolean isVerified(SignedJWT signedJWT) {
            PublicKey generatePublic = KeyFactory.getInstance("ECDSA", new BouncyCastleProvider()).generatePublic(new X509EncodedKeySpec(Base64.decode(BuildConfig.CHECK_IN_QR_VALIDATION_PUBLIC_KEY, 0)));
            if (!(generatePublic instanceof ECPublicKey)) {
                generatePublic = null;
            }
            return signedJWT.verify(new ECDSAVerifier((ECPublicKey) generatePublic));
        }
    }
}
