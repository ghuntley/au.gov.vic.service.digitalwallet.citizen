package com.google.android.gms.internal.safetynet;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.safetynet.HarmfulAppsData;
import com.google.android.gms.safetynet.SafeBrowsingData;
import com.google.android.gms.safetynet.SafeBrowsingThreat;
import com.google.android.gms.safetynet.SafetyNet;
import com.google.android.gms.safetynet.SafetyNetApi;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class zzk implements SafetyNetApi {
    private static final String TAG = "zzk";

    static class zza implements SafetyNetApi.zza {
        private final Status zzad;
        private final com.google.android.gms.safetynet.zza zzae;

        public zza(Status status, com.google.android.gms.safetynet.zza zza) {
            this.zzad = status;
            this.zzae = zza;
        }

        @Override // com.google.android.gms.safetynet.SafetyNetApi.zza
        public final String getJwsResult() {
            com.google.android.gms.safetynet.zza zza = this.zzae;
            if (zza == null) {
                return null;
            }
            return zza.getJwsResult();
        }

        @Override // com.google.android.gms.common.api.Result
        public final Status getStatus() {
            return this.zzad;
        }
    }

    /* access modifiers changed from: package-private */
    public static abstract class zzb extends zzf<SafetyNetApi.zza> {
        protected zzg zzaf = new zzs(this);

        public zzb(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        /* access modifiers changed from: protected */
        @Override // com.google.android.gms.common.api.internal.BasePendingResult
        public /* synthetic */ Result createFailedResult(Status status) {
            return new zza(status, null);
        }
    }

    /* access modifiers changed from: package-private */
    public static abstract class zzc extends zzf<SafetyNetApi.zzc> {
        protected zzg zzaf = new zzt(this);

        public zzc(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        /* access modifiers changed from: protected */
        @Override // com.google.android.gms.common.api.internal.BasePendingResult
        public /* synthetic */ Result createFailedResult(Status status) {
            return new zzj(status, false);
        }
    }

    /* access modifiers changed from: package-private */
    public static abstract class zzd extends zzf<SafetyNetApi.zzb> {
        protected final zzg zzaf = new zzu(this);

        public zzd(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        /* access modifiers changed from: protected */
        @Override // com.google.android.gms.common.api.internal.BasePendingResult
        public /* synthetic */ Result createFailedResult(Status status) {
            return new zzg(status, null);
        }
    }

    /* access modifiers changed from: package-private */
    public static abstract class zze extends zzf<SafetyNetApi.RecaptchaTokenResult> {
        protected zzg zzaf = new zzv(this);

        public zze(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        /* access modifiers changed from: protected */
        @Override // com.google.android.gms.common.api.internal.BasePendingResult
        public /* synthetic */ Result createFailedResult(Status status) {
            return new zzh(status, null);
        }
    }

    /* access modifiers changed from: package-private */
    public static abstract class zzf extends zzf<SafetyNetApi.SafeBrowsingResult> {
        protected zzg zzaf = new zzw(this);

        public zzf(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        /* access modifiers changed from: protected */
        @Override // com.google.android.gms.common.api.internal.BasePendingResult
        public /* synthetic */ Result createFailedResult(Status status) {
            return new zzi(status, null);
        }
    }

    static class zzg implements SafetyNetApi.zzb {
        private final Status zzad;
        private final com.google.android.gms.safetynet.zzd zzal;

        public zzg(Status status, com.google.android.gms.safetynet.zzd zzd) {
            this.zzad = status;
            this.zzal = zzd;
        }

        @Override // com.google.android.gms.safetynet.SafetyNetApi.zzb
        public final List<HarmfulAppsData> getHarmfulAppsList() {
            com.google.android.gms.safetynet.zzd zzd = this.zzal;
            return zzd == null ? Collections.emptyList() : Arrays.asList(zzd.zzg);
        }

        @Override // com.google.android.gms.safetynet.SafetyNetApi.zzb
        public final int getHoursSinceLastScanWithHarmfulApp() {
            com.google.android.gms.safetynet.zzd zzd = this.zzal;
            if (zzd == null) {
                return -1;
            }
            return zzd.zzh;
        }

        @Override // com.google.android.gms.safetynet.SafetyNetApi.zzb
        public final long getLastScanTimeMs() {
            com.google.android.gms.safetynet.zzd zzd = this.zzal;
            if (zzd == null) {
                return 0;
            }
            return zzd.zzf;
        }

        @Override // com.google.android.gms.common.api.Result
        public final Status getStatus() {
            return this.zzad;
        }
    }

    static class zzh implements SafetyNetApi.RecaptchaTokenResult {
        private final Status zzad;
        private final com.google.android.gms.safetynet.zzf zzam;

        public zzh(Status status, com.google.android.gms.safetynet.zzf zzf) {
            this.zzad = status;
            this.zzam = zzf;
        }

        @Override // com.google.android.gms.common.api.Result
        public final Status getStatus() {
            return this.zzad;
        }

        @Override // com.google.android.gms.safetynet.SafetyNetApi.RecaptchaTokenResult
        public final String getTokenResult() {
            com.google.android.gms.safetynet.zzf zzf = this.zzam;
            if (zzf == null) {
                return null;
            }
            return zzf.getTokenResult();
        }
    }

    public static class zzi implements SafetyNetApi.SafeBrowsingResult {
        private Status zzad;
        private final SafeBrowsingData zzan;
        private String zzm = null;
        private long zzp;
        private byte[] zzq;

        public zzi(Status status, SafeBrowsingData safeBrowsingData) {
            this.zzad = status;
            this.zzan = safeBrowsingData;
            if (safeBrowsingData != null) {
                this.zzm = safeBrowsingData.getMetadata();
                this.zzp = safeBrowsingData.getLastUpdateTimeMs();
                this.zzq = safeBrowsingData.getState();
            } else if (status.isSuccess()) {
                this.zzad = new Status(8);
            }
        }

        @Override // com.google.android.gms.safetynet.SafetyNetApi.SafeBrowsingResult
        public final List<SafeBrowsingThreat> getDetectedThreats() {
            ArrayList arrayList = new ArrayList();
            if (this.zzm == null) {
                return arrayList;
            }
            try {
                JSONArray jSONArray = new JSONObject(this.zzm).getJSONArray("matches");
                for (int i = 0; i < jSONArray.length(); i++) {
                    try {
                        arrayList.add(new SafeBrowsingThreat(Integer.parseInt(jSONArray.getJSONObject(i).getString("threat_type"))));
                    } catch (NumberFormatException | JSONException unused) {
                    }
                }
            } catch (JSONException unused2) {
            }
            return arrayList;
        }

        @Override // com.google.android.gms.safetynet.SafetyNetApi.SafeBrowsingResult
        public final long getLastUpdateTimeMs() {
            return this.zzp;
        }

        @Override // com.google.android.gms.safetynet.SafetyNetApi.SafeBrowsingResult
        public final String getMetadata() {
            return this.zzm;
        }

        @Override // com.google.android.gms.safetynet.SafetyNetApi.SafeBrowsingResult
        public final byte[] getState() {
            return this.zzq;
        }

        @Override // com.google.android.gms.common.api.Result
        public final Status getStatus() {
            return this.zzad;
        }
    }

    static class zzj implements SafetyNetApi.zzc {
        private Status zzad;
        private boolean zzao;

        public zzj() {
        }

        public zzj(Status status, boolean z) {
            this.zzad = status;
            this.zzao = z;
        }

        @Override // com.google.android.gms.common.api.Result
        public final Status getStatus() {
            return this.zzad;
        }

        @Override // com.google.android.gms.safetynet.SafetyNetApi.zzc
        public final boolean isVerifyAppsEnabled() {
            Status status = this.zzad;
            if (status == null || !status.isSuccess()) {
                return false;
            }
            return this.zzao;
        }
    }

    public static PendingResult<SafetyNetApi.SafeBrowsingResult> zza(GoogleApiClient googleApiClient, String str, int i, String str2, int... iArr) {
        if (iArr.length == 0) {
            throw new IllegalArgumentException("Null threatTypes in lookupUri");
        } else if (!TextUtils.isEmpty(str)) {
            return googleApiClient.enqueue(new zzn(googleApiClient, iArr, i, str, str2));
        } else {
            throw new IllegalArgumentException("Null or empty uri in lookupUri");
        }
    }

    public static PendingResult<SafetyNetApi.zza> zza(GoogleApiClient googleApiClient, byte[] bArr, String str) {
        return googleApiClient.enqueue(new zzl(googleApiClient, bArr, str));
    }

    @Override // com.google.android.gms.safetynet.SafetyNetApi
    public PendingResult<SafetyNetApi.zza> attest(GoogleApiClient googleApiClient, byte[] bArr) {
        return zza(googleApiClient, bArr, null);
    }

    @Override // com.google.android.gms.safetynet.SafetyNetApi
    public PendingResult<SafetyNetApi.zzc> enableVerifyApps(GoogleApiClient googleApiClient) {
        return googleApiClient.enqueue(new zzp(this, googleApiClient));
    }

    @Override // com.google.android.gms.safetynet.SafetyNetApi
    public PendingResult<SafetyNetApi.zzc> isVerifyAppsEnabled(GoogleApiClient googleApiClient) {
        return googleApiClient.enqueue(new zzo(this, googleApiClient));
    }

    @Override // com.google.android.gms.safetynet.SafetyNetApi
    public boolean isVerifyAppsEnabled(Context context) {
        GoogleApiClient build = new GoogleApiClient.Builder(context).addApi(SafetyNet.API).build();
        try {
            boolean z = false;
            if (build.blockingConnect(3, TimeUnit.SECONDS).isSuccess()) {
                SafetyNetApi.zzc await = isVerifyAppsEnabled(build).await(3, TimeUnit.SECONDS);
                if (await != null && await.isVerifyAppsEnabled()) {
                    z = true;
                }
                return z;
            }
            if (build != null) {
                build.disconnect();
            }
            return false;
        } finally {
            if (build != null) {
                build.disconnect();
            }
        }
    }

    @Override // com.google.android.gms.safetynet.SafetyNetApi
    public PendingResult<SafetyNetApi.zzb> listHarmfulApps(GoogleApiClient googleApiClient) {
        return googleApiClient.enqueue(new zzq(this, googleApiClient));
    }

    @Override // com.google.android.gms.safetynet.SafetyNetApi
    public PendingResult<SafetyNetApi.SafeBrowsingResult> lookupUri(GoogleApiClient googleApiClient, String str, String str2, int... iArr) {
        return zza(googleApiClient, str, 1, str2, iArr);
    }

    @Override // com.google.android.gms.safetynet.SafetyNetApi
    public PendingResult<SafetyNetApi.SafeBrowsingResult> lookupUri(GoogleApiClient googleApiClient, List<Integer> list, String str) {
        if (list == null) {
            throw new IllegalArgumentException("Null threatTypes in lookupUri");
        } else if (!TextUtils.isEmpty(str)) {
            return googleApiClient.enqueue(new zzm(this, googleApiClient, list, str, null));
        } else {
            throw new IllegalArgumentException("Null or empty uri in lookupUri");
        }
    }

    @Override // com.google.android.gms.safetynet.SafetyNetApi
    public PendingResult<SafetyNetApi.RecaptchaTokenResult> verifyWithRecaptcha(GoogleApiClient googleApiClient, String str) {
        if (!TextUtils.isEmpty(str)) {
            return googleApiClient.enqueue(new zzr(this, googleApiClient, str));
        }
        throw new IllegalArgumentException("Null or empty site key in verifyWithRecaptcha");
    }
}
