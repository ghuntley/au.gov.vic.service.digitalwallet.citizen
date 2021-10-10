package com.google.android.gms.instantapps;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class InstantAppIntentData extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<InstantAppIntentData> CREATOR = new zzb();
    public static final int RESULT_LAUNCH_OK = 0;
    public static final int RESULT_NO_LAUNCH = 1;
    public static final int RESULT_NO_LAUNCH_HOLDBACK = 2;
    public static final int RESULT_USER_PREFERS_BROWSER = 3;
    public static final InstantAppIntentData zzj = new InstantAppIntentData(null, 1, null);
    private final Intent intent;
    private final String packageName;
    private final int zzk;

    @Retention(RetentionPolicy.SOURCE)
    public @interface MatchResult {
    }

    public InstantAppIntentData(Intent intent2, int i, String str) {
        this.intent = intent2;
        this.zzk = i;
        this.packageName = str;
    }

    public Intent getIntent() {
        return this.intent;
    }

    public int getMatchResult() {
        return this.zzk;
    }

    public String getPackageName() {
        return this.packageName;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 1, getIntent(), i, false);
        SafeParcelWriter.writeInt(parcel, 2, getMatchResult());
        SafeParcelWriter.writeString(parcel, 3, getPackageName(), false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
