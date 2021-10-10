package com.google.android.gms.measurement.internal;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.collection.ArrayMap;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.CollectionUtils;
import com.google.android.gms.common.util.Strings;
import com.google.android.gms.internal.measurement.zzlo;
import com.google.android.gms.internal.measurement.zzml;
import com.google.android.gms.internal.measurement.zzms;
import com.google.android.gms.internal.measurement.zzmy;
import com.google.android.gms.internal.measurement.zznj;
import com.google.android.gms.internal.measurement.zznw;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.messaging.Constants;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import kotlinx.coroutines.DebugKt;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class zzhb extends zzg {
    protected zzhy zza;
    final zzo zzb;
    private zzgw zzc;
    private final Set<zzgz> zzd = new CopyOnWriteArraySet();
    private boolean zze;
    private final AtomicReference<String> zzf = new AtomicReference<>();
    private final Object zzg = new Object();
    private zzac zzh = new zzac(null, null);
    private int zzi = 100;
    private final AtomicLong zzj = new AtomicLong(0);
    private long zzk = -1;
    private int zzl = 100;
    private boolean zzm = true;
    private final zzky zzn = new zzhq(this);

    protected zzhb(zzfu zzfu) {
        super(zzfu);
        this.zzb = new zzo(zzfu);
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.measurement.internal.zzg
    public final boolean zzy() {
        return false;
    }

    public final void zzaa() {
        if (zzm().getApplicationContext() instanceof Application) {
            ((Application) zzm().getApplicationContext()).unregisterActivityLifecycleCallbacks(this.zza);
        }
    }

    public final Boolean zzab() {
        AtomicReference atomicReference = new AtomicReference();
        return (Boolean) zzp().zza(atomicReference, 15000, "boolean test flag value", new zzhc(this, atomicReference));
    }

    public final String zzac() {
        AtomicReference atomicReference = new AtomicReference();
        return (String) zzp().zza(atomicReference, 15000, "String test flag value", new zzhm(this, atomicReference));
    }

    public final Long zzad() {
        AtomicReference atomicReference = new AtomicReference();
        return (Long) zzp().zza(atomicReference, 15000, "long test flag value", new zzht(this, atomicReference));
    }

    public final Integer zzae() {
        AtomicReference atomicReference = new AtomicReference();
        return (Integer) zzp().zza(atomicReference, 15000, "int test flag value", new zzhs(this, atomicReference));
    }

    public final Double zzaf() {
        AtomicReference atomicReference = new AtomicReference();
        return (Double) zzp().zza(atomicReference, 15000, "double test flag value", new zzhv(this, atomicReference));
    }

    public final void zza(Boolean bool) {
        zzv();
        zzp().zza(new zzhu(this, bool));
    }

    public final void zza(Bundle bundle, int i, long j) {
        if (zzml.zzb() && zzs().zza(zzas.zzcg)) {
            zzv();
            String zza2 = zzac.zza(bundle);
            if (zza2 != null) {
                zzq().zzj().zza("Ignoring invalid consent setting", zza2);
                zzq().zzj().zza("Valid consent values are 'granted', 'denied'");
            }
            zza(zzac.zzb(bundle), i, j);
        }
    }

    public final void zza(zzac zzac, int i, long j) {
        boolean z;
        boolean z2;
        zzac zzac2;
        boolean z3;
        if (zzml.zzb() && zzs().zza(zzas.zzcg)) {
            zzv();
            if ((!zzs().zza(zzas.zzch) || i != 20) && zzac.zzb() == null && zzac.zzd() == null) {
                zzq().zzj().zza("Discarding empty consent settings");
                return;
            }
            synchronized (this.zzg) {
                z = true;
                z2 = false;
                if (zzac.zza(i, this.zzi)) {
                    boolean zza2 = zzac.zza(this.zzh);
                    if (zzac.zze() && !this.zzh.zze()) {
                        z2 = true;
                    }
                    zzac zzc2 = zzac.zzc(this.zzh);
                    this.zzh = zzc2;
                    this.zzi = i;
                    zzac2 = zzc2;
                    z3 = z2;
                    z2 = zza2;
                } else {
                    zzac2 = zzac;
                    z3 = false;
                    z = false;
                }
            }
            if (!z) {
                zzq().zzu().zza("Ignoring lower-priority consent settings, proposed settings", zzac2);
                return;
            }
            long andIncrement = this.zzj.getAndIncrement();
            if (z2) {
                zza((String) null);
                zzp().zzb(new zzhx(this, zzac2, j, i, andIncrement, z3));
            } else if (!zzs().zza(zzas.zzch) || !(i == 40 || i == 20)) {
                zzp().zza(new zzhz(this, zzac2, i, andIncrement, z3));
            } else {
                zzp().zzb(new zzhw(this, zzac2, i, andIncrement, z3));
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void zza(zzac zzac) {
        zzc();
        boolean z = (zzac.zze() && zzac.zzc()) || zzg().zzai();
        if (z != this.zzy.zzac()) {
            this.zzy.zzb(z);
            Boolean zzv = zzr().zzv();
            if (!z || zzv == null || zzv.booleanValue()) {
                zza(Boolean.valueOf(z), false);
            }
        }
    }

    /* access modifiers changed from: private */
    public final void zza(Boolean bool, boolean z) {
        zzc();
        zzv();
        zzq().zzv().zza("Setting app measurement enabled (FE)", bool);
        zzr().zza(bool);
        if (zzml.zzb() && zzs().zza(zzas.zzcg) && z) {
            zzr().zzb(bool);
        }
        if (!zzml.zzb() || !zzs().zza(zzas.zzcg) || this.zzy.zzac() || !bool.booleanValue()) {
            zzal();
        }
    }

    /* access modifiers changed from: private */
    public final void zza(zzac zzac, int i, long j, boolean z, boolean z2) {
        zzc();
        zzv();
        if (j <= this.zzk && zzac.zza(this.zzl, i)) {
            zzq().zzu().zza("Dropped out-of-date consent setting, proposed settings", zzac);
        } else if (zzr().zza(zzac, i)) {
            this.zzk = j;
            this.zzl = i;
            zzg().zza(z);
            if (z2) {
                zzg().zza(new AtomicReference<>());
            }
        } else {
            zzq().zzu().zza("Lower precedence consent source ignored, proposed source", Integer.valueOf(i));
        }
    }

    /* access modifiers changed from: private */
    public final void zzal() {
        zzc();
        String zza2 = zzr().zzn.zza();
        if (zza2 != null) {
            if ("unset".equals(zza2)) {
                zza("app", "_npa", (Object) null, zzl().currentTimeMillis());
            } else {
                zza("app", "_npa", Long.valueOf("true".equals(zza2) ? 1 : 0), zzl().currentTimeMillis());
            }
        }
        if (!this.zzy.zzaa() || !this.zzm) {
            zzq().zzv().zza("Updating Scion state (FE)");
            zzg().zzab();
            return;
        }
        zzq().zzv().zza("Recording app launch after enabling measurement for the first time (FE)");
        zzah();
        if (zznj.zzb() && zzs().zza(zzas.zzbp)) {
            zzj().zza.zza();
        }
        if (zzmy.zzb() && zzs().zza(zzas.zzbs)) {
            if (!(this.zzy.zze().zza.zzb().zzi.zza() > 0)) {
                zzfl zze2 = this.zzy.zze();
                zze2.zza(zze2.zza.zzm().getPackageName());
            }
        }
        if (zzs().zza(zzas.zzcc)) {
            zzp().zza(new zzhe(this));
        }
    }

    public final void zza(String str, String str2, Bundle bundle) {
        zza(str, str2, bundle, true, true, zzl().currentTimeMillis());
    }

    /* access modifiers changed from: package-private */
    public final void zzb(String str, String str2, Bundle bundle) {
        zzc();
        zza(str, str2, zzl().currentTimeMillis(), bundle);
    }

    /* access modifiers changed from: package-private */
    public final void zza(String str, String str2, long j, Bundle bundle) {
        zzc();
        zza(str, str2, j, bundle, true, this.zzc == null || zzkv.zzd(str2), false, null);
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x014f  */
    public final void zza(String str, String str2, long j, Bundle bundle, boolean z, boolean z2, boolean z3, String str3) {
        long j2;
        boolean z4;
        boolean z5;
        Class<?> cls;
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(bundle);
        zzc();
        zzv();
        if (!this.zzy.zzaa()) {
            zzq().zzv().zza("Event not sent since app measurement is disabled");
            return;
        }
        List<String> zzag = zzf().zzag();
        if (zzag == null || zzag.contains(str2)) {
            int i = 0;
            if (!this.zze) {
                this.zze = true;
                try {
                    if (!this.zzy.zzs()) {
                        cls = Class.forName("com.google.android.gms.tagmanager.TagManagerService", true, zzm().getClassLoader());
                    } else {
                        cls = Class.forName("com.google.android.gms.tagmanager.TagManagerService");
                    }
                    try {
                        cls.getDeclaredMethod("initialize", Context.class).invoke(null, zzm());
                    } catch (Exception e) {
                        zzq().zzh().zza("Failed to invoke Tag Manager's initialize() method", e);
                    }
                } catch (ClassNotFoundException unused) {
                    zzq().zzu().zza("Tag Manager is not found and thus will not be used");
                }
            }
            if (zzs().zza(zzas.zzbd) && Constants.ScionAnalytics.EVENT_FIREBASE_CAMPAIGN.equals(str2) && bundle.containsKey("gclid")) {
                zza(DebugKt.DEBUG_PROPERTY_VALUE_AUTO, "_lgclid", bundle.getString("gclid"), zzl().currentTimeMillis());
            }
            if (zznw.zzb() && zzs().zza(zzas.zzby) && z && zzkv.zzf(str2)) {
                zzo().zza(bundle, zzr().zzx.zza());
            }
            if (z3 && !"_iap".equals(str2)) {
                zzkv zzh2 = this.zzy.zzh();
                boolean z6 = zzlo.zzb() && zzs().zza(zzas.zzck);
                int i2 = 2;
                if (zzh2.zza("event", str2)) {
                    if (z6) {
                        if (zzh2.zza("event", 40, str2)) {
                            i2 = 0;
                        }
                    } else if (zzh2.zza("event", 40, str2)) {
                    }
                    i2 = 13;
                }
                if (i2 != 0) {
                    zzq().zzg().zza("Invalid public event name. Event will not be logged (FE)", zzn().zza(str2));
                    this.zzy.zzh();
                    String zza2 = zzkv.zza(str2, 40, true);
                    if (str2 != null) {
                        i = str2.length();
                    }
                    this.zzy.zzh().zza(this.zzn, i2, "_ev", zza2, i);
                    return;
                }
            }
            zzij zza3 = zzh().zza(false);
            if (zza3 != null && !bundle.containsKey("_sc")) {
                zza3.zzd = true;
            }
            zzii.zza(zza3, bundle, z && z3);
            boolean equals = "am".equals(str);
            boolean zzd2 = zzkv.zzd(str2);
            if (z && this.zzc != null && !zzd2 && !equals) {
                zzq().zzv().zza("Passing event to registered event handler (FE)", zzn().zza(str2), zzn().zza(bundle));
                this.zzc.interceptEvent(str, str2, bundle, j);
            } else if (this.zzy.zzaf()) {
                int zza4 = zzo().zza(str2, zzlo.zzb() && zzs().zza(zzas.zzck));
                if (zza4 != 0) {
                    zzq().zzg().zza("Invalid event name. Event will not be logged (FE)", zzn().zza(str2));
                    zzo();
                    String zza5 = zzkv.zza(str2, 40, true);
                    if (str2 != null) {
                        i = str2.length();
                    }
                    this.zzy.zzh().zza(this.zzn, str3, zza4, "_ev", zza5, i);
                    return;
                }
                Bundle zza6 = zzo().zza(str3, str2, bundle, CollectionUtils.listOf((Object[]) new String[]{"_o", "_sn", "_sc", "_si"}), z3, true);
                if (zza6 != null && zza6.containsKey("_sc") && zza6.containsKey("_si")) {
                    new zzij(zza6.getString("_sn"), zza6.getString("_sc"), Long.valueOf(zza6.getLong("_si")).longValue());
                }
                if (zzs().zza(zzas.zzas) && zzh().zza(false) != null && "_ae".equals(str2)) {
                    long zzb2 = zzj().zzb.zzb();
                    if (zzb2 > 0) {
                        zzo().zza(zza6, zzb2);
                    }
                }
                if (zzms.zzb() && zzs().zza(zzas.zzbo)) {
                    if (!DebugKt.DEBUG_PROPERTY_VALUE_AUTO.equals(str) && "_ssr".equals(str2)) {
                        zzkv zzo = zzo();
                        String string = zza6.getString("_ffr");
                        String trim = Strings.isEmptyOrWhitespace(string) ? null : string.trim();
                        if (zzkv.zzc(trim, zzo.zzr().zzu.zza())) {
                            zzo.zzq().zzv().zza("Not logging duplicate session_start_with_rollout event");
                            z5 = false;
                        } else {
                            zzo.zzr().zzu.zza(trim);
                            z5 = true;
                        }
                        if (!z5) {
                            return;
                        }
                    } else if ("_ae".equals(str2)) {
                        String zza7 = zzo().zzr().zzu.zza();
                        if (!TextUtils.isEmpty(zza7)) {
                            zza6.putString("_ffr", zza7);
                        }
                    }
                }
                ArrayList arrayList = new ArrayList();
                arrayList.add(zza6);
                zzo().zzg().nextLong();
                if (zzr().zzp.zza() > 0) {
                    j2 = j;
                    if (zzr().zza(j2) && zzr().zzr.zza()) {
                        zzq().zzw().zza("Current session is expired, remove the session number, ID, and engagement time");
                        zza(DebugKt.DEBUG_PROPERTY_VALUE_AUTO, "_sid", (Object) null, zzl().currentTimeMillis());
                        zza(DebugKt.DEBUG_PROPERTY_VALUE_AUTO, "_sno", (Object) null, zzl().currentTimeMillis());
                        zza(DebugKt.DEBUG_PROPERTY_VALUE_AUTO, "_se", (Object) null, zzl().currentTimeMillis());
                    }
                } else {
                    j2 = j;
                }
                if (zza6.getLong(FirebaseAnalytics.Param.EXTEND_SESSION, 0) == 1) {
                    zzq().zzw().zza("EXTEND_SESSION param attached: initiate a new session or extend the current active session");
                    z4 = true;
                    this.zzy.zzd().zza.zza(j2, true);
                } else {
                    z4 = true;
                }
                String[] strArr = (String[]) zza6.keySet().toArray(new String[zza6.size()]);
                Arrays.sort(strArr);
                for (String str4 : strArr) {
                    zzo();
                    Bundle[] zzb3 = zzkv.zzb(zza6.get(str4));
                    if (zzb3 != null) {
                        zza6.putParcelableArray(str4, zzb3);
                    }
                }
                int i3 = 0;
                while (i3 < arrayList.size()) {
                    Bundle bundle2 = (Bundle) arrayList.get(i3);
                    String str5 = i3 != 0 ? z4 : false ? "_ep" : str2;
                    bundle2.putString("_o", str);
                    if (z2) {
                        bundle2 = zzo().zza(bundle2);
                    }
                    zzg().zza(new zzaq(str5, new zzap(bundle2), str, j), str3);
                    if (!equals) {
                        for (zzgz zzgz : this.zzd) {
                            zzgz.onEvent(str, str2, new Bundle(bundle2), j);
                        }
                    }
                    i3++;
                    z4 = true;
                }
                if (zzh().zza(false) != null && "_ae".equals(str2)) {
                    zzj().zza(true, true, zzl().elapsedRealtime());
                }
            }
        } else {
            zzq().zzv().zza("Dropping non-safelisted event. event name, origin", str2, str);
        }
    }

    public final void zza(String str, String str2, Bundle bundle, String str3) {
        zza();
        zzb(str, str2, zzl().currentTimeMillis(), bundle, false, true, false, str3);
    }

    public final void zza(String str, String str2, Bundle bundle, boolean z, boolean z2, long j) {
        String str3 = str == null ? "app" : str;
        Bundle bundle2 = bundle == null ? new Bundle() : bundle;
        if (zzs().zza(zzas.zzbu)) {
            if (zzkv.zzc(str2, FirebaseAnalytics.Event.SCREEN_VIEW)) {
                zzh().zza(bundle2, j);
                return;
            }
        }
        zzb(str3, str2, j, bundle2, z2, !z2 || this.zzc == null || zzkv.zzd(str2), !z, null);
    }

    private final void zzb(String str, String str2, long j, Bundle bundle, boolean z, boolean z2, boolean z3, String str3) {
        zzp().zza(new zzhj(this, str, str2, j, zzkv.zzb(bundle), z, z2, z3, str3));
    }

    public final void zza(String str, String str2, Object obj, boolean z) {
        zza(str, str2, obj, true, zzl().currentTimeMillis());
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0038  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0054  */
    public final void zza(String str, String str2, Object obj, boolean z, long j) {
        int i;
        if (str == null) {
            str = "app";
        }
        int i2 = 6;
        int i3 = 0;
        if (z) {
            i2 = zzo().zzb(str2);
        } else {
            zzkv zzo = zzo();
            if (zzo.zza("user property", str2)) {
                if (!zzo.zza("user property", zzgx.zza, str2)) {
                    i2 = 15;
                } else if (zzo.zza("user property", 24, str2)) {
                    i = 0;
                    if (i == 0) {
                        zzo();
                        String zza2 = zzkv.zza(str2, 24, true);
                        if (str2 != null) {
                            i3 = str2.length();
                        }
                        this.zzy.zzh().zza(this.zzn, i, "_ev", zza2, i3);
                        return;
                    } else if (obj != null) {
                        int zzb2 = zzo().zzb(str2, obj);
                        if (zzb2 != 0) {
                            zzo();
                            String zza3 = zzkv.zza(str2, 24, true);
                            if ((obj instanceof String) || (obj instanceof CharSequence)) {
                                i3 = String.valueOf(obj).length();
                            }
                            this.zzy.zzh().zza(this.zzn, zzb2, "_ev", zza3, i3);
                            return;
                        }
                        Object zzc2 = zzo().zzc(str2, obj);
                        if (zzc2 != null) {
                            zza(str, str2, j, zzc2);
                            return;
                        }
                        return;
                    } else {
                        zza(str, str2, j, (Object) null);
                        return;
                    }
                }
            }
        }
        i = i2;
        if (i == 0) {
        }
    }

    private final void zza(String str, String str2, long j, Object obj) {
        zzp().zza(new zzhi(this, str, str2, obj, j));
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x006d  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x007b  */
    public final void zza(String str, String str2, Object obj, long j) {
        Long l;
        String str3;
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        zzc();
        zzv();
        if (FirebaseAnalytics.UserProperty.ALLOW_AD_PERSONALIZATION_SIGNALS.equals(str2)) {
            if (obj instanceof String) {
                String str4 = (String) obj;
                if (!TextUtils.isEmpty(str4)) {
                    String str5 = "false";
                    Long valueOf = Long.valueOf(str5.equals(str4.toLowerCase(Locale.ENGLISH)) ? 1 : 0);
                    zzfi zzfi = zzr().zzn;
                    if (valueOf.longValue() == 1) {
                        str5 = "true";
                    }
                    zzfi.zza(str5);
                    l = valueOf;
                    str3 = "_npa";
                    if (!this.zzy.zzaa()) {
                        zzq().zzw().zza("User property not set since app measurement is disabled");
                        return;
                    } else if (this.zzy.zzaf()) {
                        zzg().zza(new zzku(str3, j, l, str));
                        return;
                    } else {
                        return;
                    }
                }
            }
            if (obj == null) {
                zzr().zzn.zza("unset");
                l = obj;
                str3 = "_npa";
                if (!this.zzy.zzaa()) {
                }
            }
        }
        str3 = str2;
        l = obj;
        if (!this.zzy.zzaa()) {
        }
    }

    public final List<zzku> zza(boolean z) {
        zzv();
        zzq().zzw().zza("Getting user properties (FE)");
        if (zzp().zzf()) {
            zzq().zze().zza("Cannot get all user properties from analytics worker thread");
            return Collections.emptyList();
        } else if (zzw.zza()) {
            zzq().zze().zza("Cannot get all user properties from main thread");
            return Collections.emptyList();
        } else {
            AtomicReference atomicReference = new AtomicReference();
            this.zzy.zzp().zza(atomicReference, 5000, "get user properties", new zzhl(this, atomicReference, z));
            List<zzku> list = (List) atomicReference.get();
            if (list != null) {
                return list;
            }
            zzq().zze().zza("Timed out waiting for get user properties, includeInternal", Boolean.valueOf(z));
            return Collections.emptyList();
        }
    }

    public final String zzag() {
        return this.zzf.get();
    }

    /* access modifiers changed from: package-private */
    public final void zza(String str) {
        this.zzf.set(str);
    }

    /* access modifiers changed from: package-private */
    public final void zza(long j, boolean z) {
        zzc();
        zzv();
        zzq().zzv().zza("Resetting analytics data (FE)");
        zzjx zzj2 = zzj();
        zzj2.zzc();
        zzj2.zzb.zza();
        boolean zzaa = this.zzy.zzaa();
        zzfc zzr = zzr();
        zzr.zzh.zza(j);
        if (!TextUtils.isEmpty(zzr.zzr().zzu.zza())) {
            zzr.zzu.zza(null);
        }
        if (zznj.zzb() && zzr.zzs().zza(zzas.zzbp)) {
            zzr.zzp.zza(0);
        }
        if (!zzr.zzs().zzf()) {
            zzr.zzb(!zzaa);
        }
        zzr.zzv.zza(null);
        zzr.zzw.zza(0);
        zzr.zzx.zza(null);
        if (z) {
            zzg().zzac();
        }
        if (zznj.zzb() && zzs().zza(zzas.zzbp)) {
            zzj().zza.zza();
        }
        this.zzm = !zzaa;
    }

    public final void zzah() {
        zzc();
        zzv();
        if (this.zzy.zzaf()) {
            if (zzs().zza(zzas.zzbc)) {
                Boolean zzf2 = zzs().zzf("google_analytics_deferred_deep_link_enabled");
                if (zzf2 != null && zzf2.booleanValue()) {
                    zzq().zzv().zza("Deferred Deep Link feature enabled.");
                    zzp().zza(new zzhd(this));
                }
            }
            zzg().zzad();
            this.zzm = false;
            String zzy = zzr().zzy();
            if (!TextUtils.isEmpty(zzy)) {
                zzk().zzab();
                if (!zzy.equals(Build.VERSION.RELEASE)) {
                    Bundle bundle = new Bundle();
                    bundle.putString("_po", zzy);
                    zza(DebugKt.DEBUG_PROPERTY_VALUE_AUTO, "_ou", bundle);
                }
            }
        }
    }

    public final void zza(zzgw zzgw) {
        zzgw zzgw2;
        zzc();
        zzv();
        if (!(zzgw == null || zzgw == (zzgw2 = this.zzc))) {
            Preconditions.checkState(zzgw2 == null, "EventInterceptor already set.");
        }
        this.zzc = zzgw;
    }

    public final void zza(zzgz zzgz) {
        zzv();
        Preconditions.checkNotNull(zzgz);
        if (!this.zzd.add(zzgz)) {
            zzq().zzh().zza("OnEventListener already registered");
        }
    }

    public final void zzb(zzgz zzgz) {
        zzv();
        Preconditions.checkNotNull(zzgz);
        if (!this.zzd.remove(zzgz)) {
            zzq().zzh().zza("OnEventListener had not been registered");
        }
    }

    public final void zza(Bundle bundle) {
        zza(bundle, zzl().currentTimeMillis());
    }

    public final void zza(Bundle bundle, long j) {
        Preconditions.checkNotNull(bundle);
        Bundle bundle2 = new Bundle(bundle);
        if (!TextUtils.isEmpty(bundle2.getString("app_id"))) {
            zzq().zzh().zza("Package name should be null when calling setConditionalUserProperty");
        }
        bundle2.remove("app_id");
        Preconditions.checkNotNull(bundle2);
        zzgs.zza(bundle2, "app_id", String.class, null);
        zzgs.zza(bundle2, "origin", String.class, null);
        zzgs.zza(bundle2, "name", String.class, null);
        zzgs.zza(bundle2, "value", Object.class, null);
        zzgs.zza(bundle2, AppMeasurementSdk.ConditionalUserProperty.TRIGGER_EVENT_NAME, String.class, null);
        zzgs.zza(bundle2, AppMeasurementSdk.ConditionalUserProperty.TRIGGER_TIMEOUT, Long.class, 0L);
        zzgs.zza(bundle2, AppMeasurementSdk.ConditionalUserProperty.TIMED_OUT_EVENT_NAME, String.class, null);
        zzgs.zza(bundle2, AppMeasurementSdk.ConditionalUserProperty.TIMED_OUT_EVENT_PARAMS, Bundle.class, null);
        zzgs.zza(bundle2, AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_EVENT_NAME, String.class, null);
        zzgs.zza(bundle2, AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_EVENT_PARAMS, Bundle.class, null);
        zzgs.zza(bundle2, AppMeasurementSdk.ConditionalUserProperty.TIME_TO_LIVE, Long.class, 0L);
        zzgs.zza(bundle2, AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_NAME, String.class, null);
        zzgs.zza(bundle2, AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_PARAMS, Bundle.class, null);
        Preconditions.checkNotEmpty(bundle2.getString("name"));
        Preconditions.checkNotEmpty(bundle2.getString("origin"));
        Preconditions.checkNotNull(bundle2.get("value"));
        bundle2.putLong(AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP, j);
        String string = bundle2.getString("name");
        Object obj = bundle2.get("value");
        if (zzo().zzb(string) != 0) {
            zzq().zze().zza("Invalid conditional user property name", zzn().zzc(string));
        } else if (zzo().zzb(string, obj) != 0) {
            zzq().zze().zza("Invalid conditional user property value", zzn().zzc(string), obj);
        } else {
            Object zzc2 = zzo().zzc(string, obj);
            if (zzc2 == null) {
                zzq().zze().zza("Unable to normalize conditional user property value", zzn().zzc(string), obj);
                return;
            }
            zzgs.zza(bundle2, zzc2);
            long j2 = bundle2.getLong(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_TIMEOUT);
            if (TextUtils.isEmpty(bundle2.getString(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_EVENT_NAME)) || (j2 <= 15552000000L && j2 >= 1)) {
                long j3 = bundle2.getLong(AppMeasurementSdk.ConditionalUserProperty.TIME_TO_LIVE);
                if (j3 > 15552000000L || j3 < 1) {
                    zzq().zze().zza("Invalid conditional user property time to live", zzn().zzc(string), Long.valueOf(j3));
                } else {
                    zzp().zza(new zzhn(this, bundle2));
                }
            } else {
                zzq().zze().zza("Invalid conditional user property timeout", zzn().zzc(string), Long.valueOf(j2));
            }
        }
    }

    public final void zzc(String str, String str2, Bundle bundle) {
        long currentTimeMillis = zzl().currentTimeMillis();
        Preconditions.checkNotEmpty(str);
        Bundle bundle2 = new Bundle();
        bundle2.putString("name", str);
        bundle2.putLong(AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP, currentTimeMillis);
        if (str2 != null) {
            bundle2.putString(AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_NAME, str2);
            bundle2.putBundle(AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_PARAMS, bundle);
        }
        zzp().zza(new zzhp(this, bundle2));
    }

    /* access modifiers changed from: private */
    public final void zzc(Bundle bundle) {
        zzc();
        zzv();
        Preconditions.checkNotNull(bundle);
        Preconditions.checkNotEmpty(bundle.getString("name"));
        Preconditions.checkNotEmpty(bundle.getString("origin"));
        Preconditions.checkNotNull(bundle.get("value"));
        if (!this.zzy.zzaa()) {
            zzq().zzw().zza("Conditional property not set since app measurement is disabled");
            return;
        }
        try {
            zzg().zza(new zzz(bundle.getString("app_id"), bundle.getString("origin"), new zzku(bundle.getString("name"), bundle.getLong(AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_TIMESTAMP), bundle.get("value"), bundle.getString("origin")), bundle.getLong(AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP), false, bundle.getString(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_EVENT_NAME), zzo().zza(bundle.getString("app_id"), bundle.getString(AppMeasurementSdk.ConditionalUserProperty.TIMED_OUT_EVENT_NAME), bundle.getBundle(AppMeasurementSdk.ConditionalUserProperty.TIMED_OUT_EVENT_PARAMS), bundle.getString("origin"), 0L, true, false, zzlo.zzb() && zzs().zza(zzas.zzck)), bundle.getLong(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_TIMEOUT), zzo().zza(bundle.getString("app_id"), bundle.getString(AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_EVENT_NAME), bundle.getBundle(AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_EVENT_PARAMS), bundle.getString("origin"), 0L, true, false, zzlo.zzb() && zzs().zza(zzas.zzck)), bundle.getLong(AppMeasurementSdk.ConditionalUserProperty.TIME_TO_LIVE), zzo().zza(bundle.getString("app_id"), bundle.getString(AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_NAME), bundle.getBundle(AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_PARAMS), bundle.getString("origin"), 0L, true, false, zzlo.zzb() && zzs().zza(zzas.zzck))));
        } catch (IllegalArgumentException unused) {
        }
    }

    /* access modifiers changed from: private */
    public final void zzd(Bundle bundle) {
        zzc();
        zzv();
        Preconditions.checkNotNull(bundle);
        Preconditions.checkNotEmpty(bundle.getString("name"));
        if (!this.zzy.zzaa()) {
            zzq().zzw().zza("Conditional property not cleared since app measurement is disabled");
            return;
        }
        try {
            zzg().zza(new zzz(bundle.getString("app_id"), bundle.getString("origin"), new zzku(bundle.getString("name"), 0, null, null), bundle.getLong(AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP), bundle.getBoolean(AppMeasurementSdk.ConditionalUserProperty.ACTIVE), bundle.getString(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_EVENT_NAME), null, bundle.getLong(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_TIMEOUT), null, bundle.getLong(AppMeasurementSdk.ConditionalUserProperty.TIME_TO_LIVE), zzo().zza(bundle.getString("app_id"), bundle.getString(AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_NAME), bundle.getBundle(AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_PARAMS), bundle.getString("origin"), bundle.getLong(AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP), true, false, zzlo.zzb() && zzs().zza(zzas.zzck))));
        } catch (IllegalArgumentException unused) {
        }
    }

    public final ArrayList<Bundle> zza(String str, String str2) {
        if (zzp().zzf()) {
            zzq().zze().zza("Cannot get conditional user properties from analytics worker thread");
            return new ArrayList<>(0);
        } else if (zzw.zza()) {
            zzq().zze().zza("Cannot get conditional user properties from main thread");
            return new ArrayList<>(0);
        } else {
            AtomicReference atomicReference = new AtomicReference();
            this.zzy.zzp().zza(atomicReference, 5000, "get conditional user properties", new zzho(this, atomicReference, null, str, str2));
            List list = (List) atomicReference.get();
            if (list != null) {
                return zzkv.zzb((List<zzz>) list);
            }
            zzq().zze().zza("Timed out waiting for get conditional user properties", null);
            return new ArrayList<>();
        }
    }

    public final Map<String, Object> zza(String str, String str2, boolean z) {
        if (zzp().zzf()) {
            zzq().zze().zza("Cannot get user properties from analytics worker thread");
            return Collections.emptyMap();
        } else if (zzw.zza()) {
            zzq().zze().zza("Cannot get user properties from main thread");
            return Collections.emptyMap();
        } else {
            AtomicReference atomicReference = new AtomicReference();
            this.zzy.zzp().zza(atomicReference, 5000, "get user properties", new zzhr(this, atomicReference, null, str, str2, z));
            List<zzku> list = (List) atomicReference.get();
            if (list == null) {
                zzq().zze().zza("Timed out waiting for handle get user properties, includeInternal", Boolean.valueOf(z));
                return Collections.emptyMap();
            }
            ArrayMap arrayMap = new ArrayMap(list.size());
            for (zzku zzku : list) {
                arrayMap.put(zzku.zza, zzku.zza());
            }
            return arrayMap;
        }
    }

    public final String zzai() {
        zzij zzaa = this.zzy.zzu().zzaa();
        if (zzaa != null) {
            return zzaa.zza;
        }
        return null;
    }

    public final String zzaj() {
        zzij zzaa = this.zzy.zzu().zzaa();
        if (zzaa != null) {
            return zzaa.zzb;
        }
        return null;
    }

    public final String zzak() {
        if (this.zzy.zzn() != null) {
            return this.zzy.zzn();
        }
        try {
            return zzig.zza(zzm(), "google_app_id");
        } catch (IllegalStateException e) {
            this.zzy.zzq().zze().zza("getGoogleAppId failed with exception", e);
            return null;
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzd, com.google.android.gms.measurement.internal.zzgr
    public final /* bridge */ /* synthetic */ void zza() {
        super.zza();
    }

    @Override // com.google.android.gms.measurement.internal.zzd, com.google.android.gms.measurement.internal.zzgr
    public final /* bridge */ /* synthetic */ void zzb() {
        super.zzb();
    }

    @Override // com.google.android.gms.measurement.internal.zzd, com.google.android.gms.measurement.internal.zzgr
    public final /* bridge */ /* synthetic */ void zzc() {
        super.zzc();
    }

    @Override // com.google.android.gms.measurement.internal.zzd
    public final /* bridge */ /* synthetic */ zza zzd() {
        return super.zzd();
    }

    @Override // com.google.android.gms.measurement.internal.zzd
    public final /* bridge */ /* synthetic */ zzhb zze() {
        return super.zze();
    }

    @Override // com.google.android.gms.measurement.internal.zzd
    public final /* bridge */ /* synthetic */ zzen zzf() {
        return super.zzf();
    }

    @Override // com.google.android.gms.measurement.internal.zzd
    public final /* bridge */ /* synthetic */ zzir zzg() {
        return super.zzg();
    }

    @Override // com.google.android.gms.measurement.internal.zzd
    public final /* bridge */ /* synthetic */ zzii zzh() {
        return super.zzh();
    }

    @Override // com.google.android.gms.measurement.internal.zzd
    public final /* bridge */ /* synthetic */ zzem zzi() {
        return super.zzi();
    }

    @Override // com.google.android.gms.measurement.internal.zzd
    public final /* bridge */ /* synthetic */ zzjx zzj() {
        return super.zzj();
    }

    @Override // com.google.android.gms.measurement.internal.zzgr
    public final /* bridge */ /* synthetic */ zzak zzk() {
        return super.zzk();
    }

    @Override // com.google.android.gms.measurement.internal.zzgt, com.google.android.gms.measurement.internal.zzgr
    public final /* bridge */ /* synthetic */ Clock zzl() {
        return super.zzl();
    }

    @Override // com.google.android.gms.measurement.internal.zzgt, com.google.android.gms.measurement.internal.zzgr
    public final /* bridge */ /* synthetic */ Context zzm() {
        return super.zzm();
    }

    @Override // com.google.android.gms.measurement.internal.zzgr
    public final /* bridge */ /* synthetic */ zzeo zzn() {
        return super.zzn();
    }

    @Override // com.google.android.gms.measurement.internal.zzgr
    public final /* bridge */ /* synthetic */ zzkv zzo() {
        return super.zzo();
    }

    @Override // com.google.android.gms.measurement.internal.zzgt, com.google.android.gms.measurement.internal.zzgr
    public final /* bridge */ /* synthetic */ zzfr zzp() {
        return super.zzp();
    }

    @Override // com.google.android.gms.measurement.internal.zzgt, com.google.android.gms.measurement.internal.zzgr
    public final /* bridge */ /* synthetic */ zzeq zzq() {
        return super.zzq();
    }

    @Override // com.google.android.gms.measurement.internal.zzgr
    public final /* bridge */ /* synthetic */ zzfc zzr() {
        return super.zzr();
    }

    @Override // com.google.android.gms.measurement.internal.zzgr
    public final /* bridge */ /* synthetic */ zzab zzs() {
        return super.zzs();
    }

    @Override // com.google.android.gms.measurement.internal.zzgt, com.google.android.gms.measurement.internal.zzgr
    public final /* bridge */ /* synthetic */ zzw zzt() {
        return super.zzt();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzb(Bundle bundle) {
        if (zznw.zzb() && zzs().zza(zzas.zzby)) {
            if (bundle == null) {
                zzr().zzx.zza(new Bundle());
                return;
            }
            Bundle zza2 = zzr().zzx.zza();
            for (String str : bundle.keySet()) {
                Object obj = bundle.get(str);
                if (obj != null && !(obj instanceof String) && !(obj instanceof Long) && !(obj instanceof Double)) {
                    zzo();
                    if (zzkv.zza(obj)) {
                        zzo().zza(this.zzn, 27, (String) null, (String) null, 0);
                    }
                    zzq().zzj().zza("Invalid default event parameter type. Name, value", str, obj);
                } else if (zzkv.zzd(str)) {
                    zzq().zzj().zza("Invalid default event parameter name. Name", str);
                } else if (obj == null) {
                    zza2.remove(str);
                } else if (zzo().zza("param", str, 100, obj)) {
                    zzo().zza(zza2, str, obj);
                }
            }
            zzo();
            if (zzkv.zza(zza2, zzs().zzd())) {
                zzo().zza(this.zzn, 26, (String) null, (String) null, 0);
                zzq().zzj().zza("Too many default event parameters set. Discarding beyond event parameter limit");
            }
            zzr().zzx.zza(zza2);
            zzg().zza(zza2);
        }
    }
}
