package com.google.android.gms.measurement.internal;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.firebase.messaging.Constants;
import kotlinx.coroutines.DebugKt;

/* access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class zzhy implements Application.ActivityLifecycleCallbacks {
    private final /* synthetic */ zzhb zza;

    private zzhy(zzhb zzhb) {
        this.zza = zzhb;
    }

    public final void onActivityStarted(Activity activity) {
    }

    public final void onActivityStopped(Activity activity) {
    }

    public final void onActivityCreated(Activity activity, Bundle bundle) {
        try {
            this.zza.zzq().zzw().zza("onActivityCreated");
            Intent intent = activity.getIntent();
            if (intent != null) {
                Uri data = intent.getData();
                if (data == null || !data.isHierarchical()) {
                    this.zza.zzh().zza(activity, bundle);
                    return;
                }
                this.zza.zzo();
                this.zza.zzp().zza(new zzib(this, bundle == null, data, zzkv.zza(intent) ? "gs" : DebugKt.DEBUG_PROPERTY_VALUE_AUTO, data.getQueryParameter("referrer")));
                this.zza.zzh().zza(activity, bundle);
            }
        } catch (Exception e) {
            this.zza.zzq().zze().zza("Throwable caught in onActivityCreated", e);
        } finally {
            this.zza.zzh().zza(activity, bundle);
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00a1  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00fe  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x013e A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x013f  */
    public final void zza(boolean z, Uri uri, String str, String str2) {
        Bundle bundle;
        Bundle bundle2;
        this.zza.zzc();
        try {
            if (this.zza.zzs().zza(zzas.zzbd) || this.zza.zzs().zza(zzas.zzbf) || this.zza.zzs().zza(zzas.zzbe)) {
                zzkv zzo = this.zza.zzo();
                if (!TextUtils.isEmpty(str2)) {
                    if (str2.contains("gclid") || str2.contains("utm_campaign") || str2.contains("utm_source") || str2.contains("utm_medium")) {
                        String valueOf = String.valueOf(str2);
                        bundle = zzo.zza(Uri.parse(valueOf.length() != 0 ? "https://google.com/search?".concat(valueOf) : new String("https://google.com/search?")));
                        if (bundle != null) {
                            bundle.putString("_cis", "referrer");
                        }
                        boolean z2 = false;
                        if (!z) {
                            bundle2 = this.zza.zzo().zza(uri);
                            if (bundle2 != null) {
                                bundle2.putString("_cis", "intent");
                                if (this.zza.zzs().zza(zzas.zzbd) && !bundle2.containsKey("gclid") && bundle != null && bundle.containsKey("gclid")) {
                                    bundle2.putString("_cer", String.format("gclid=%s", bundle.getString("gclid")));
                                }
                                this.zza.zza(str, Constants.ScionAnalytics.EVENT_FIREBASE_CAMPAIGN, bundle2);
                                if (this.zza.zzs().zza(zzas.zzcc)) {
                                    this.zza.zzb.zza(str, bundle2);
                                }
                            }
                        } else {
                            bundle2 = null;
                        }
                        if (this.zza.zzs().zza(zzas.zzbf) && !this.zza.zzs().zza(zzas.zzbe) && bundle != null && bundle.containsKey("gclid") && (bundle2 == null || !bundle2.containsKey("gclid"))) {
                            this.zza.zza(DebugKt.DEBUG_PROPERTY_VALUE_AUTO, "_lgclid", (Object) bundle.getString("gclid"), true);
                        }
                        if (TextUtils.isEmpty(str2)) {
                            this.zza.zzq().zzv().zza("Activity created with referrer", str2);
                            if (this.zza.zzs().zza(zzas.zzbe)) {
                                if (bundle != null) {
                                    this.zza.zza(str, Constants.ScionAnalytics.EVENT_FIREBASE_CAMPAIGN, bundle);
                                    if (this.zza.zzs().zza(zzas.zzcc)) {
                                        this.zza.zzb.zza(str, bundle);
                                    }
                                } else {
                                    this.zza.zzq().zzv().zza("Referrer does not contain valid parameters", str2);
                                }
                                this.zza.zza(DebugKt.DEBUG_PROPERTY_VALUE_AUTO, "_ldl", (Object) null, true);
                                return;
                            }
                            if (str2.contains("gclid") && (str2.contains("utm_campaign") || str2.contains("utm_source") || str2.contains("utm_medium") || str2.contains("utm_term") || str2.contains("utm_content"))) {
                                z2 = true;
                            }
                            if (!z2) {
                                this.zza.zzq().zzv().zza("Activity created with data 'referrer' without required params");
                                return;
                            } else if (!TextUtils.isEmpty(str2)) {
                                this.zza.zza(DebugKt.DEBUG_PROPERTY_VALUE_AUTO, "_ldl", (Object) str2, true);
                                return;
                            } else {
                                return;
                            }
                        } else {
                            return;
                        }
                    } else {
                        zzo.zzq().zzv().zza("Activity created with data 'referrer' without required params");
                    }
                }
            }
            bundle = null;
            boolean z22 = false;
            if (!z) {
            }
            this.zza.zza(DebugKt.DEBUG_PROPERTY_VALUE_AUTO, "_lgclid", (Object) bundle.getString("gclid"), true);
            if (TextUtils.isEmpty(str2)) {
            }
        } catch (Exception e) {
            this.zza.zzq().zze().zza("Throwable caught in handleReferrerForOnActivityCreated", e);
        }
    }

    public final void onActivityDestroyed(Activity activity) {
        this.zza.zzh().zzc(activity);
    }

    public final void onActivityPaused(Activity activity) {
        this.zza.zzh().zzb(activity);
        zzjx zzj = this.zza.zzj();
        zzj.zzp().zza(new zzjz(zzj, zzj.zzl().elapsedRealtime()));
    }

    public final void onActivityResumed(Activity activity) {
        zzjx zzj = this.zza.zzj();
        zzj.zzp().zza(new zzjw(zzj, zzj.zzl().elapsedRealtime()));
        this.zza.zzh().zza(activity);
    }

    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        this.zza.zzh().zzb(activity, bundle);
    }

    /* synthetic */ zzhy(zzhb zzhb, zzhc zzhc) {
        this(zzhb);
    }
}
