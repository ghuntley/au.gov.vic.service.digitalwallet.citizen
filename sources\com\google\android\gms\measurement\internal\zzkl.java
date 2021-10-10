package com.google.android.gms.measurement.internal;

import android.content.ContentValues;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Pair;
import androidx.collection.ArrayMap;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.internal.measurement.zzca;
import com.google.android.gms.internal.measurement.zzcd;
import com.google.android.gms.internal.measurement.zzhy;
import com.google.android.gms.internal.measurement.zzlo;
import com.google.android.gms.internal.measurement.zzmg;
import com.google.android.gms.internal.measurement.zzml;
import com.google.android.gms.internal.measurement.zzne;
import com.google.android.gms.internal.measurement.zznv;
import com.google.android.gms.internal.measurement.zznw;
import com.google.android.gms.internal.measurement.zzoz;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.crashlytics.internal.common.AbstractSpiCall;
import com.google.firebase.messaging.Constants;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.channels.OverlappingFileLockException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import kotlin.jvm.internal.LongCompanionObject;
import kotlinx.coroutines.DebugKt;

/* compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
public class zzkl implements zzgt {
    private static volatile zzkl zza;
    private final zzky zzaa;
    private zzfo zzb;
    private zzex zzc;
    private zzaf zzd;
    private zzfa zze;
    private zzkh zzf;
    private zzr zzg;
    private final zzkr zzh;
    private zzih zzi;
    private zzjr zzj;
    private final zzfu zzk;
    private boolean zzl;
    private boolean zzm;
    private long zzn;
    private List<Runnable> zzo;
    private int zzp;
    private int zzq;
    private boolean zzr;
    private boolean zzs;
    private boolean zzt;
    private FileLock zzu;
    private FileChannel zzv;
    private List<Long> zzw;
    private List<Long> zzx;
    private long zzy;
    private final Map<String, zzac> zzz;

    /* access modifiers changed from: private */
    /* compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
    public class zza implements zzah {
        zzcd.zzg zza;
        List<Long> zzb;
        List<zzcd.zzc> zzc;
        private long zzd;

        private zza() {
        }

        @Override // com.google.android.gms.measurement.internal.zzah
        public final void zza(zzcd.zzg zzg) {
            Preconditions.checkNotNull(zzg);
            this.zza = zzg;
        }

        @Override // com.google.android.gms.measurement.internal.zzah
        public final boolean zza(long j, zzcd.zzc zzc2) {
            Preconditions.checkNotNull(zzc2);
            if (this.zzc == null) {
                this.zzc = new ArrayList();
            }
            if (this.zzb == null) {
                this.zzb = new ArrayList();
            }
            if (this.zzc.size() > 0 && zza(this.zzc.get(0)) != zza(zzc2)) {
                return false;
            }
            long zzbp = this.zzd + ((long) zzc2.zzbp());
            if (zzbp >= ((long) Math.max(0, zzas.zzh.zza(null).intValue()))) {
                return false;
            }
            this.zzd = zzbp;
            this.zzc.add(zzc2);
            this.zzb.add(Long.valueOf(j));
            if (this.zzc.size() >= Math.max(1, zzas.zzi.zza(null).intValue())) {
                return false;
            }
            return true;
        }

        private static long zza(zzcd.zzc zzc2) {
            return ((zzc2.zze() / 1000) / 60) / 60;
        }

        /* synthetic */ zza(zzkl zzkl, zzkk zzkk) {
            this();
        }
    }

    public static zzkl zza(Context context) {
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(context.getApplicationContext());
        if (zza == null) {
            synchronized (zzkl.class) {
                if (zza == null) {
                    zza = new zzkl(new zzks(context));
                }
            }
        }
        return zza;
    }

    private zzkl(zzks zzks) {
        this(zzks, null);
    }

    private zzkl(zzks zzks, zzfu zzfu) {
        this.zzl = false;
        this.zzaa = new zzko(this);
        Preconditions.checkNotNull(zzks);
        zzfu zza2 = zzfu.zza(zzks.zza, null, null);
        this.zzk = zza2;
        this.zzy = -1;
        zzkr zzkr = new zzkr(this);
        zzkr.zzak();
        this.zzh = zzkr;
        zzex zzex = new zzex(this);
        zzex.zzak();
        this.zzc = zzex;
        zzfo zzfo = new zzfo(this);
        zzfo.zzak();
        this.zzb = zzfo;
        this.zzz = new HashMap();
        zza2.zzp().zza(new zzkk(this, zzks));
    }

    /* access modifiers changed from: private */
    public final void zza(zzks zzks) {
        this.zzk.zzp().zzc();
        zzaf zzaf = new zzaf(this);
        zzaf.zzak();
        this.zzd = zzaf;
        this.zzk.zza().zza(this.zzb);
        zzjr zzjr = new zzjr(this);
        zzjr.zzak();
        this.zzj = zzjr;
        zzr zzr2 = new zzr(this);
        zzr2.zzak();
        this.zzg = zzr2;
        zzih zzih = new zzih(this);
        zzih.zzak();
        this.zzi = zzih;
        zzkh zzkh = new zzkh(this);
        zzkh.zzak();
        this.zzf = zzkh;
        this.zze = new zzfa(this);
        if (this.zzp != this.zzq) {
            this.zzk.zzq().zze().zza("Not all upload components initialized", Integer.valueOf(this.zzp), Integer.valueOf(this.zzq));
        }
        this.zzl = true;
    }

    /* access modifiers changed from: protected */
    public final void zza() {
        this.zzk.zzp().zzc();
        zze().zzu();
        if (this.zzk.zzb().zzc.zza() == 0) {
            this.zzk.zzb().zzc.zza(this.zzk.zzl().currentTimeMillis());
        }
        zzab();
    }

    @Override // com.google.android.gms.measurement.internal.zzgt
    public final zzw zzt() {
        return this.zzk.zzt();
    }

    public final zzab zzb() {
        return this.zzk.zza();
    }

    @Override // com.google.android.gms.measurement.internal.zzgt
    public final zzeq zzq() {
        return this.zzk.zzq();
    }

    @Override // com.google.android.gms.measurement.internal.zzgt
    public final zzfr zzp() {
        return this.zzk.zzp();
    }

    public final zzfo zzc() {
        zzb(this.zzb);
        return this.zzb;
    }

    public final zzex zzd() {
        zzb(this.zzc);
        return this.zzc;
    }

    public final zzaf zze() {
        zzb(this.zzd);
        return this.zzd;
    }

    private final zzfa zzv() {
        zzfa zzfa = this.zze;
        if (zzfa != null) {
            return zzfa;
        }
        throw new IllegalStateException("Network broadcast receiver not created");
    }

    private final zzkh zzw() {
        zzb(this.zzf);
        return this.zzf;
    }

    public final zzr zzf() {
        zzb(this.zzg);
        return this.zzg;
    }

    public final zzih zzg() {
        zzb(this.zzi);
        return this.zzi;
    }

    public final zzkr zzh() {
        zzb(this.zzh);
        return this.zzh;
    }

    public final zzjr zzi() {
        return this.zzj;
    }

    public final zzeo zzj() {
        return this.zzk.zzi();
    }

    @Override // com.google.android.gms.measurement.internal.zzgt
    public final Context zzm() {
        return this.zzk.zzm();
    }

    @Override // com.google.android.gms.measurement.internal.zzgt
    public final Clock zzl() {
        return this.zzk.zzl();
    }

    public final zzkv zzk() {
        return this.zzk.zzh();
    }

    private final void zzx() {
        this.zzk.zzp().zzc();
    }

    /* access modifiers changed from: package-private */
    public final void zzn() {
        if (!this.zzl) {
            throw new IllegalStateException("UploadController is not initialized");
        }
    }

    private static void zzb(zzki zzki) {
        if (zzki == null) {
            throw new IllegalStateException("Upload Component not created");
        } else if (!zzki.zzai()) {
            String valueOf = String.valueOf(zzki.getClass());
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 27);
            sb.append("Component not initialized: ");
            sb.append(valueOf);
            throw new IllegalStateException(sb.toString());
        }
    }

    /* access modifiers changed from: package-private */
    public final void zza(String str, zzac zzac) {
        if (zzml.zzb() && this.zzk.zza().zza(zzas.zzci)) {
            zzx();
            zzn();
            this.zzz.put(str, zzac);
            zzaf zze2 = zze();
            if (zzml.zzb() && zze2.zzs().zza(zzas.zzci)) {
                Preconditions.checkNotNull(str);
                Preconditions.checkNotNull(zzac);
                zze2.zzc();
                zze2.zzaj();
                ContentValues contentValues = new ContentValues();
                contentValues.put("app_id", str);
                contentValues.put("consent_state", zzac.zza());
                try {
                    if (zze2.c_().insertWithOnConflict("consent_settings", null, contentValues, 5) == -1) {
                        zze2.zzq().zze().zza("Failed to insert/update consent setting (got -1). appId", zzeq.zza(str));
                    }
                } catch (SQLiteException e) {
                    zze2.zzq().zze().zza("Error storing consent setting. appId, error", zzeq.zza(str), e);
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final zzac zza(String str) {
        zzac zzac = zzac.zza;
        if (zzml.zzb() && this.zzk.zza().zza(zzas.zzci)) {
            zzx();
            zzn();
            zzac = this.zzz.get(str);
            if (zzac == null) {
                zzac = zze().zzj(str);
                if (zzac == null) {
                    zzac = zzac.zza;
                }
                zza(str, zzac);
            }
        }
        return zzac;
    }

    private final long zzy() {
        long currentTimeMillis = this.zzk.zzl().currentTimeMillis();
        zzfc zzb2 = this.zzk.zzb();
        zzb2.zzab();
        zzb2.zzc();
        long zza2 = zzb2.zzg.zza();
        if (zza2 == 0) {
            zza2 = 1 + ((long) zzb2.zzo().zzg().nextInt(86400000));
            zzb2.zzg.zza(zza2);
        }
        return ((((currentTimeMillis + zza2) / 1000) / 60) / 60) / 24;
    }

    /* access modifiers changed from: package-private */
    public final void zza(zzaq zzaq, String str) {
        boolean z;
        String str2;
        zzf zzb2 = zze().zzb(str);
        if (zzb2 == null || TextUtils.isEmpty(zzb2.zzl())) {
            this.zzk.zzq().zzv().zza("No app data available; dropping event", str);
            return;
        }
        Boolean zzb3 = zzb(zzb2);
        if (zzb3 == null) {
            if (!"_ui".equals(zzaq.zza)) {
                this.zzk.zzq().zzh().zza("Could not find package. appId", zzeq.zza(str));
            }
        } else if (!zzb3.booleanValue()) {
            this.zzk.zzq().zze().zza("App version does not match; dropping event. appId", zzeq.zza(str));
            return;
        }
        String zze2 = zzb2.zze();
        String zzl2 = zzb2.zzl();
        long zzm2 = zzb2.zzm();
        String zzn2 = zzb2.zzn();
        long zzo2 = zzb2.zzo();
        long zzp2 = zzb2.zzp();
        boolean zzr2 = zzb2.zzr();
        String zzi2 = zzb2.zzi();
        long zzae = zzb2.zzae();
        boolean zzaf = zzb2.zzaf();
        boolean zzag = zzb2.zzag();
        String zzf2 = zzb2.zzf();
        Boolean zzah = zzb2.zzah();
        long zzq2 = zzb2.zzq();
        List<String> zzai = zzb2.zzai();
        if (zznv.zzb()) {
            z = zzr2;
            if (this.zzk.zza().zze(zzb2.zzc(), zzas.zzbi)) {
                str2 = zzb2.zzg();
                zzb(zzaq, new zzn(str, zze2, zzl2, zzm2, zzn2, zzo2, zzp2, (String) null, z, false, zzi2, zzae, 0L, 0, zzaf, zzag, false, zzf2, zzah, zzq2, zzai, str2, (zzml.zzb() || !this.zzk.zza().zza(zzas.zzci)) ? "" : zza(str).zza()));
            }
        } else {
            z = zzr2;
        }
        str2 = null;
        zzb(zzaq, new zzn(str, zze2, zzl2, zzm2, zzn2, zzo2, zzp2, (String) null, z, false, zzi2, zzae, 0L, 0, zzaf, zzag, false, zzf2, zzah, zzq2, zzai, str2, (zzml.zzb() || !this.zzk.zza().zza(zzas.zzci)) ? "" : zza(str).zza()));
    }

    private final void zzb(zzaq zzaq, zzn zzn2) {
        if (zznw.zzb() && this.zzk.zza().zza(zzas.zzbz)) {
            zzeu zza2 = zzeu.zza(zzaq);
            this.zzk.zzh().zza(zza2.zzb, zze().zzi(zzn2.zza));
            this.zzk.zzh().zza(zza2, this.zzk.zza().zza(zzn2.zza));
            zzaq = zza2.zza();
        }
        if (this.zzk.zza().zza(zzas.zzbd) && Constants.ScionAnalytics.EVENT_FIREBASE_CAMPAIGN.equals(zzaq.zza) && "referrer API v2".equals(zzaq.zzb.zzd("_cis"))) {
            String zzd2 = zzaq.zzb.zzd("gclid");
            if (!TextUtils.isEmpty(zzd2)) {
                zza(new zzku("_lgclid", zzaq.zzd, zzd2, DebugKt.DEBUG_PROPERTY_VALUE_AUTO), zzn2);
            }
        }
        zza(zzaq, zzn2);
    }

    /* access modifiers changed from: package-private */
    public final void zza(zzaq zzaq, zzn zzn2) {
        List<zzz> list;
        List<zzz> list2;
        List<zzz> list3;
        zzaq zzaq2 = zzaq;
        Preconditions.checkNotNull(zzn2);
        Preconditions.checkNotEmpty(zzn2.zza);
        zzx();
        zzn();
        String str = zzn2.zza;
        long j = zzaq2.zzd;
        zzh();
        if (zzkr.zza(zzaq, zzn2)) {
            if (!zzn2.zzh) {
                zzc(zzn2);
                return;
            }
            if (zzn2.zzu != null) {
                if (zzn2.zzu.contains(zzaq2.zza)) {
                    Bundle zzb2 = zzaq2.zzb.zzb();
                    zzb2.putLong("ga_safelisted", 1);
                    zzaq2 = new zzaq(zzaq2.zza, new zzap(zzb2), zzaq2.zzc, zzaq2.zzd);
                } else {
                    this.zzk.zzq().zzv().zza("Dropping non-safelisted event. appId, event name, origin", str, zzaq2.zza, zzaq2.zzc);
                    return;
                }
            }
            zze().zze();
            try {
                zzaf zze2 = zze();
                Preconditions.checkNotEmpty(str);
                zze2.zzc();
                zze2.zzaj();
                int i = (j > 0 ? 1 : (j == 0 ? 0 : -1));
                if (i < 0) {
                    zze2.zzq().zzh().zza("Invalid time querying timed out conditional properties", zzeq.zza(str), Long.valueOf(j));
                    list = Collections.emptyList();
                } else {
                    list = zze2.zza("active=0 and app_id=? and abs(? - creation_timestamp) > trigger_timeout", new String[]{str, String.valueOf(j)});
                }
                for (zzz zzz2 : list) {
                    if (zzz2 != null) {
                        this.zzk.zzq().zzw().zza("User property timed out", zzz2.zza, this.zzk.zzi().zzc(zzz2.zzc.zza), zzz2.zzc.zza());
                        if (zzz2.zzg != null) {
                            zzc(new zzaq(zzz2.zzg, j), zzn2);
                        }
                        zze().zze(str, zzz2.zzc.zza);
                    }
                }
                zzaf zze3 = zze();
                Preconditions.checkNotEmpty(str);
                zze3.zzc();
                zze3.zzaj();
                if (i < 0) {
                    zze3.zzq().zzh().zza("Invalid time querying expired conditional properties", zzeq.zza(str), Long.valueOf(j));
                    list2 = Collections.emptyList();
                } else {
                    list2 = zze3.zza("active<>0 and app_id=? and abs(? - triggered_timestamp) > time_to_live", new String[]{str, String.valueOf(j)});
                }
                ArrayList arrayList = new ArrayList(list2.size());
                for (zzz zzz3 : list2) {
                    if (zzz3 != null) {
                        this.zzk.zzq().zzw().zza("User property expired", zzz3.zza, this.zzk.zzi().zzc(zzz3.zzc.zza), zzz3.zzc.zza());
                        zze().zzb(str, zzz3.zzc.zza);
                        if (zzz3.zzk != null) {
                            arrayList.add(zzz3.zzk);
                        }
                        zze().zze(str, zzz3.zzc.zza);
                    }
                }
                ArrayList arrayList2 = arrayList;
                int size = arrayList2.size();
                int i2 = 0;
                while (i2 < size) {
                    Object obj = arrayList2.get(i2);
                    i2++;
                    zzc(new zzaq((zzaq) obj, j), zzn2);
                }
                zzaf zze4 = zze();
                String str2 = zzaq2.zza;
                Preconditions.checkNotEmpty(str);
                Preconditions.checkNotEmpty(str2);
                zze4.zzc();
                zze4.zzaj();
                if (i < 0) {
                    zze4.zzq().zzh().zza("Invalid time querying triggered conditional properties", zzeq.zza(str), zze4.zzn().zza(str2), Long.valueOf(j));
                    list3 = Collections.emptyList();
                } else {
                    list3 = zze4.zza("active=0 and app_id=? and trigger_event_name=? and abs(? - creation_timestamp) <= trigger_timeout", new String[]{str, str2, String.valueOf(j)});
                }
                ArrayList arrayList3 = new ArrayList(list3.size());
                for (zzz zzz4 : list3) {
                    if (zzz4 != null) {
                        zzku zzku = zzz4.zzc;
                        zzkw zzkw = new zzkw(zzz4.zza, zzz4.zzb, zzku.zza, j, zzku.zza());
                        if (zze().zza(zzkw)) {
                            this.zzk.zzq().zzw().zza("User property triggered", zzz4.zza, this.zzk.zzi().zzc(zzkw.zzc), zzkw.zze);
                        } else {
                            this.zzk.zzq().zze().zza("Too many active user properties, ignoring", zzeq.zza(zzz4.zza), this.zzk.zzi().zzc(zzkw.zzc), zzkw.zze);
                        }
                        if (zzz4.zzi != null) {
                            arrayList3.add(zzz4.zzi);
                        }
                        zzz4.zzc = new zzku(zzkw);
                        zzz4.zze = true;
                        zze().zza(zzz4);
                    }
                }
                zzc(zzaq2, zzn2);
                ArrayList arrayList4 = arrayList3;
                int size2 = arrayList4.size();
                int i3 = 0;
                while (i3 < size2) {
                    Object obj2 = arrayList4.get(i3);
                    i3++;
                    zzc(new zzaq((zzaq) obj2, j), zzn2);
                }
                zze().b_();
            } finally {
                zze().zzg();
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:282:0x0973  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x02f3  */
    private final void zzc(zzaq zzaq, zzn zzn2) {
        long j;
        int i;
        zzam zzam;
        boolean z;
        zzkw zzc2;
        boolean z2;
        long j2;
        zzkw zzkw;
        Long l;
        zzf zzb2;
        zzaq zzaq2 = zzaq;
        Preconditions.checkNotNull(zzn2);
        Preconditions.checkNotEmpty(zzn2.zza);
        long nanoTime = System.nanoTime();
        zzx();
        zzn();
        String str = zzn2.zza;
        zzh();
        if (zzkr.zza(zzaq, zzn2)) {
            if (!zzn2.zzh) {
                zzc(zzn2);
            } else if (zzc().zzb(str, zzaq2.zza)) {
                this.zzk.zzq().zzh().zza("Dropping blacklisted event. appId", zzeq.zza(str), this.zzk.zzi().zza(zzaq2.zza));
                boolean z3 = zzc().zzg(str) || zzc().zzh(str);
                if (z3 || "_err".equals(zzaq2.zza)) {
                    l = null;
                } else {
                    l = null;
                    this.zzk.zzh().zza(this.zzaa, str, 11, "_ev", zzaq2.zza, 0);
                }
                if (z3 && (zzb2 = zze().zzb(str)) != null) {
                    if (Math.abs(this.zzk.zzl().currentTimeMillis() - Math.max(zzb2.zzu(), zzb2.zzt())) > zzas.zzy.zza(l).longValue()) {
                        this.zzk.zzq().zzv().zza("Fetching config for blacklisted app");
                        zza(zzb2);
                    }
                }
            } else {
                if (zzmg.zzb() && this.zzk.zza().zza(zzas.zzbv)) {
                    zzeu zza2 = zzeu.zza(zzaq);
                    this.zzk.zzh().zza(zza2, this.zzk.zza().zza(str));
                    zzaq2 = zza2.zza();
                }
                if (this.zzk.zzq().zza(2)) {
                    this.zzk.zzq().zzw().zza("Logging event", this.zzk.zzi().zza(zzaq2));
                }
                zze().zze();
                try {
                    zzc(zzn2);
                    boolean z4 = FirebaseAnalytics.Event.ECOMMERCE_PURCHASE.equals(zzaq2.zza) || "purchase".equals(zzaq2.zza) || "refund".equals(zzaq2.zza);
                    if ("_iap".equals(zzaq2.zza) || z4) {
                        String zzd2 = zzaq2.zzb.zzd(FirebaseAnalytics.Param.CURRENCY);
                        if (z4) {
                            double doubleValue = zzaq2.zzb.zzc("value").doubleValue() * 1000000.0d;
                            if (doubleValue == 0.0d) {
                                doubleValue = ((double) zzaq2.zzb.zzb("value").longValue()) * 1000000.0d;
                            }
                            if (doubleValue > 9.223372036854776E18d || doubleValue < -9.223372036854776E18d) {
                                this.zzk.zzq().zzh().zza("Data lost. Currency value is too big. appId", zzeq.zza(str), Double.valueOf(doubleValue));
                                j = nanoTime;
                                i = 0;
                                z2 = false;
                                if (!z2) {
                                    zze().b_();
                                    return;
                                }
                            } else {
                                j2 = Math.round(doubleValue);
                                if ("refund".equals(zzaq2.zza)) {
                                    j2 = -j2;
                                }
                            }
                        } else {
                            j2 = zzaq2.zzb.zzb("value").longValue();
                        }
                        if (!TextUtils.isEmpty(zzd2)) {
                            String upperCase = zzd2.toUpperCase(Locale.US);
                            if (upperCase.matches("[A-Z]{3}")) {
                                String valueOf = String.valueOf(upperCase);
                                String concat = valueOf.length() != 0 ? "_ltv_".concat(valueOf) : new String("_ltv_");
                                zzkw zzc3 = zze().zzc(str, concat);
                                if (zzc3 == null || !(zzc3.zze instanceof Long)) {
                                    j = nanoTime;
                                    i = 0;
                                    zzaf zze2 = zze();
                                    int zzb3 = this.zzk.zza().zzb(str, zzas.zzad) - 1;
                                    Preconditions.checkNotEmpty(str);
                                    zze2.zzc();
                                    zze2.zzaj();
                                    try {
                                        zze2.c_().execSQL("delete from user_attributes where app_id=? and name in (select name from user_attributes where app_id=? and name like '_ltv_%' order by set_timestamp desc limit ?,10);", new String[]{str, str, String.valueOf(zzb3)});
                                    } catch (SQLiteException e) {
                                        zze2.zzq().zze().zza("Error pruning currencies. appId", zzeq.zza(str), e);
                                    }
                                    zzkw = new zzkw(str, zzaq2.zzc, concat, this.zzk.zzl().currentTimeMillis(), Long.valueOf(j2));
                                } else {
                                    j = nanoTime;
                                    i = 0;
                                    zzkw = new zzkw(str, zzaq2.zzc, concat, this.zzk.zzl().currentTimeMillis(), Long.valueOf(((Long) zzc3.zze).longValue() + j2));
                                }
                                if (!zze().zza(zzkw)) {
                                    this.zzk.zzq().zze().zza("Too many unique user properties are set. Ignoring user property. appId", zzeq.zza(str), this.zzk.zzi().zzc(zzkw.zzc), zzkw.zze);
                                    this.zzk.zzh().zza(this.zzaa, str, 9, (String) null, (String) null, 0);
                                }
                                z2 = true;
                                if (!z2) {
                                }
                            }
                        }
                        j = nanoTime;
                        i = 0;
                        z2 = true;
                        if (!z2) {
                        }
                    } else {
                        j = nanoTime;
                        i = 0;
                    }
                    boolean zza3 = zzkv.zza(zzaq2.zza);
                    boolean equals = "_err".equals(zzaq2.zza);
                    this.zzk.zzh();
                    zzae zza4 = zze().zza(zzy(), str, zzkv.zza(zzaq2.zzb) + 1, true, zza3, false, equals, false);
                    long intValue = zza4.zzb - ((long) zzas.zzj.zza(null).intValue());
                    if (intValue > 0) {
                        if (intValue % 1000 == 1) {
                            this.zzk.zzq().zze().zza("Data loss. Too many events logged. appId, count", zzeq.zza(str), Long.valueOf(zza4.zzb));
                        }
                        zze().b_();
                        zze().zzg();
                        return;
                    }
                    if (zza3) {
                        long intValue2 = zza4.zza - ((long) zzas.zzl.zza(null).intValue());
                        if (intValue2 > 0) {
                            if (intValue2 % 1000 == 1) {
                                this.zzk.zzq().zze().zza("Data loss. Too many public events logged. appId, count", zzeq.zza(str), Long.valueOf(zza4.zza));
                            }
                            this.zzk.zzh().zza(this.zzaa, str, 16, "_ev", zzaq2.zza, 0);
                            zze().b_();
                            zze().zzg();
                            return;
                        }
                    }
                    if (equals) {
                        long max = zza4.zzd - ((long) Math.max(i, Math.min(1000000, this.zzk.zza().zzb(zzn2.zza, zzas.zzk))));
                        if (max > 0) {
                            if (max == 1) {
                                this.zzk.zzq().zze().zza("Too many error events logged. appId, count", zzeq.zza(str), Long.valueOf(zza4.zzd));
                            }
                            zze().b_();
                            zze().zzg();
                            return;
                        }
                    }
                    Bundle zzb4 = zzaq2.zzb.zzb();
                    this.zzk.zzh().zza(zzb4, "_o", zzaq2.zzc);
                    if (this.zzk.zzh().zze(str)) {
                        this.zzk.zzh().zza(zzb4, "_dbg", (Object) 1L);
                        this.zzk.zzh().zza(zzb4, "_r", (Object) 1L);
                    }
                    if ("_s".equals(zzaq2.zza) && (zzc2 = zze().zzc(zzn2.zza, "_sno")) != null && (zzc2.zze instanceof Long)) {
                        this.zzk.zzh().zza(zzb4, "_sno", zzc2.zze);
                    }
                    long zzc4 = zze().zzc(str);
                    if (zzc4 > 0) {
                        this.zzk.zzq().zzh().zza("Data lost. Too many events stored on disk, deleted. appId", zzeq.zza(str), Long.valueOf(zzc4));
                    }
                    zzan zzan = new zzan(this.zzk, zzaq2.zzc, str, zzaq2.zza, zzaq2.zzd, 0, zzb4);
                    zzam zza5 = zze().zza(str, zzan.zzb);
                    if (zza5 != null) {
                        zzan = zzan.zza(this.zzk, zza5.zzf);
                        zzam = zza5.zza(zzan.zzc);
                    } else if (zze().zzh(str) < ((long) this.zzk.zza().zzb(str)) || !zza3) {
                        zzam = new zzam(str, zzan.zzb, 0, 0, zzan.zzc, 0, null, null, null, null);
                    } else {
                        this.zzk.zzq().zze().zza("Too many event names used, ignoring event. appId, name, supported count", zzeq.zza(str), this.zzk.zzi().zza(zzan.zzb), Integer.valueOf(this.zzk.zza().zzb(str)));
                        this.zzk.zzh().zza(this.zzaa, str, 8, (String) null, (String) null, 0);
                        zze().zzg();
                        return;
                    }
                    zze().zza(zzam);
                    zzx();
                    zzn();
                    Preconditions.checkNotNull(zzan);
                    Preconditions.checkNotNull(zzn2);
                    Preconditions.checkNotEmpty(zzan.zza);
                    Preconditions.checkArgument(zzan.zza.equals(zzn2.zza));
                    zzcd.zzg.zza zza6 = zzcd.zzg.zzbh().zza(1).zza(AbstractSpiCall.ANDROID_CLIENT_TYPE);
                    if (!TextUtils.isEmpty(zzn2.zza)) {
                        zza6.zzf(zzn2.zza);
                    }
                    if (!TextUtils.isEmpty(zzn2.zzd)) {
                        zza6.zze(zzn2.zzd);
                    }
                    if (!TextUtils.isEmpty(zzn2.zzc)) {
                        zza6.zzg(zzn2.zzc);
                    }
                    if (zzn2.zzj != -2147483648L) {
                        zza6.zzh((int) zzn2.zzj);
                    }
                    zza6.zzf(zzn2.zze);
                    if (!TextUtils.isEmpty(zzn2.zzb)) {
                        zza6.zzk(zzn2.zzb);
                    }
                    if (zzml.zzb() && this.zzk.zza().zza(zzas.zzci)) {
                        zza6.zzq(zza(zzn2.zza).zzb(zzac.zza(zzn2.zzw)).zza());
                    }
                    if (zznv.zzb() && this.zzk.zza().zze(zzn2.zza, zzas.zzbi)) {
                        if (TextUtils.isEmpty(zza6.zzo()) && !TextUtils.isEmpty(zzn2.zzv)) {
                            zza6.zzp(zzn2.zzv);
                        }
                        if (TextUtils.isEmpty(zza6.zzo()) && TextUtils.isEmpty(zza6.zzs()) && !TextUtils.isEmpty(zzn2.zzr)) {
                            zza6.zzo(zzn2.zzr);
                        }
                    } else if (TextUtils.isEmpty(zza6.zzo()) && !TextUtils.isEmpty(zzn2.zzr)) {
                        zza6.zzo(zzn2.zzr);
                    }
                    if (zzn2.zzf != 0) {
                        zza6.zzh(zzn2.zzf);
                    }
                    zza6.zzk(zzn2.zzt);
                    List<Integer> zze3 = zzh().zze();
                    if (zze3 != null) {
                        zza6.zzd(zze3);
                    }
                    zzac zzb5 = zza(zzn2.zza).zzb(zzac.zza(zzn2.zzw));
                    if (!zzml.zzb() || !this.zzk.zza().zza(zzas.zzci) || zzb5.zzc()) {
                        Pair<String, Boolean> zza7 = this.zzj.zza(zzn2.zza, zzb5);
                        if (zza7 == null || TextUtils.isEmpty((CharSequence) zza7.first)) {
                            if (!this.zzk.zzw().zza(this.zzk.zzm()) && zzn2.zzp && (!zzoz.zzb() || !this.zzk.zza().zze(zzn2.zza, zzas.zzcf))) {
                                String string = Settings.Secure.getString(this.zzk.zzm().getContentResolver(), "android_id");
                                if (string == null) {
                                    this.zzk.zzq().zzh().zza("null secure ID. appId", zzeq.zza(zza6.zzj()));
                                    string = "null";
                                } else if (string.isEmpty()) {
                                    this.zzk.zzq().zzh().zza("empty secure ID. appId", zzeq.zza(zza6.zzj()));
                                }
                                zza6.zzm(string);
                            }
                        } else if (zzn2.zzo) {
                            zza6.zzh((String) zza7.first);
                            if (zza7.second != null) {
                                zza6.zza(((Boolean) zza7.second).booleanValue());
                            }
                        }
                    }
                    this.zzk.zzw().zzab();
                    zzcd.zzg.zza zzc5 = zza6.zzc(Build.MODEL);
                    this.zzk.zzw().zzab();
                    zzc5.zzb(Build.VERSION.RELEASE).zzf((int) this.zzk.zzw().zze()).zzd(this.zzk.zzw().zzf());
                    if (!this.zzk.zza().zza(zzas.zzbx)) {
                        zza6.zzj(zzn2.zzl);
                    }
                    if (this.zzk.zzaa()) {
                        if (!zzml.zzb() || !this.zzk.zza().zza(zzas.zzci)) {
                            zza6.zzj();
                        } else {
                            zza6.zzj();
                        }
                        if (!TextUtils.isEmpty(null)) {
                            zza6.zzn(null);
                        }
                    }
                    zzf zzb6 = zze().zzb(zzn2.zza);
                    if (zzb6 == null) {
                        zzb6 = new zzf(this.zzk, zzn2.zza);
                        if (!zzml.zzb() || !this.zzk.zza().zza(zzas.zzci)) {
                            zzb6.zza(zzz());
                        } else {
                            zzb6.zza(zza(zzb5));
                        }
                        zzb6.zzf(zzn2.zzk);
                        zzb6.zzb(zzn2.zzb);
                        if (!zzml.zzb() || !this.zzk.zza().zza(zzas.zzci) || zzb5.zzc()) {
                            zzb6.zze(this.zzj.zza(zzn2.zza));
                        }
                        zzb6.zzg(0);
                        zzb6.zza(0);
                        zzb6.zzb(0);
                        zzb6.zzg(zzn2.zzc);
                        zzb6.zzc(zzn2.zzj);
                        zzb6.zzh(zzn2.zzd);
                        zzb6.zzd(zzn2.zze);
                        zzb6.zze(zzn2.zzf);
                        zzb6.zza(zzn2.zzh);
                        if (!this.zzk.zza().zza(zzas.zzbx)) {
                            zzb6.zzp(zzn2.zzl);
                        }
                        zzb6.zzf(zzn2.zzt);
                        zze().zza(zzb6);
                    }
                    if ((!zzml.zzb() || !this.zzk.zza().zza(zzas.zzci) || zzb5.zze()) && !TextUtils.isEmpty(zzb6.zzd())) {
                        zza6.zzi(zzb6.zzd());
                    }
                    if (!TextUtils.isEmpty(zzb6.zzi())) {
                        zza6.zzl(zzb6.zzi());
                    }
                    List<zzkw> zza8 = zze().zza(zzn2.zza);
                    for (int i2 = 0; i2 < zza8.size(); i2++) {
                        zzcd.zzk.zza zza9 = zzcd.zzk.zzj().zza(zza8.get(i2).zzc).zza(zza8.get(i2).zzd);
                        zzh().zza(zza9, zza8.get(i2).zze);
                        zza6.zza(zza9);
                    }
                    try {
                        long zza10 = zze().zza((zzcd.zzg) ((zzhy) zza6.zzy()));
                        zzaf zze4 = zze();
                        if (zzan.zze != null) {
                            Iterator<String> it = zzan.zze.iterator();
                            while (true) {
                                if (it.hasNext()) {
                                    if ("_r".equals(it.next())) {
                                        break;
                                    }
                                } else {
                                    boolean zzc6 = zzc().zzc(zzan.zza, zzan.zzb);
                                    zzae zza11 = zze().zza(zzy(), zzan.zza, false, false, false, false, false);
                                    if (zzc6 && zza11.zze < ((long) this.zzk.zza().zzc(zzan.zza))) {
                                        z = true;
                                    }
                                }
                            }
                            z = true;
                            if (zze4.zza(zzan, zza10, z)) {
                                this.zzn = 0;
                            }
                            zze().b_();
                            zze().zzg();
                            zzab();
                            this.zzk.zzq().zzw().zza("Background event processing time, ms", Long.valueOf(((System.nanoTime() - j) + 500000) / 1000000));
                        }
                        z = false;
                        if (zze4.zza(zzan, zza10, z)) {
                        }
                    } catch (IOException e2) {
                        this.zzk.zzq().zze().zza("Data loss. Failed to insert raw event metadata. appId", zzeq.zza(zza6.zzj()), e2);
                    }
                    zze().b_();
                    zze().zzg();
                    zzab();
                    this.zzk.zzq().zzw().zza("Background event processing time, ms", Long.valueOf(((System.nanoTime() - j) + 500000) / 1000000));
                } finally {
                    zze().zzg();
                }
            }
        }
    }

    private final String zza(zzac zzac) {
        if (!zzml.zzb() || !this.zzk.zza().zza(zzas.zzci) || zzac.zze()) {
            return zzz();
        }
        return null;
    }

    @Deprecated
    private final String zzz() {
        byte[] bArr = new byte[16];
        this.zzk.zzh().zzg().nextBytes(bArr);
        return String.format(Locale.US, "%032x", new BigInteger(1, bArr));
    }

    /* access modifiers changed from: package-private */
    public final void zzo() {
        zzf zzb2;
        String str;
        zzx();
        zzn();
        this.zzt = true;
        try {
            Boolean zzaf = this.zzk.zzv().zzaf();
            if (zzaf == null) {
                this.zzk.zzq().zzh().zza("Upload data called on the client side before use of service was decided");
            } else if (zzaf.booleanValue()) {
                this.zzk.zzq().zze().zza("Upload called in the client side when service should be used");
                this.zzt = false;
                zzac();
            } else if (this.zzn > 0) {
                zzab();
                this.zzt = false;
                zzac();
            } else {
                zzx();
                if (this.zzw != null) {
                    this.zzk.zzq().zzw().zza("Uploading requested multiple times");
                    this.zzt = false;
                    zzac();
                } else if (!zzd().zze()) {
                    this.zzk.zzq().zzw().zza("Network not connected, ignoring upload request");
                    zzab();
                    this.zzt = false;
                    zzac();
                } else {
                    long currentTimeMillis = this.zzk.zzl().currentTimeMillis();
                    int zzb3 = this.zzk.zza().zzb(null, zzas.zzap);
                    long zzv2 = currentTimeMillis - zzab.zzv();
                    for (int i = 0; i < zzb3 && zza((String) null, zzv2); i++) {
                    }
                    long zza2 = this.zzk.zzb().zzc.zza();
                    if (zza2 != 0) {
                        this.zzk.zzq().zzv().zza("Uploading events. Elapsed time since last upload attempt (ms)", Long.valueOf(Math.abs(currentTimeMillis - zza2)));
                    }
                    String d_ = zze().d_();
                    if (!TextUtils.isEmpty(d_)) {
                        if (this.zzy == -1) {
                            this.zzy = zze().zzz();
                        }
                        List<Pair<zzcd.zzg, Long>> zza3 = zze().zza(d_, this.zzk.zza().zzb(d_, zzas.zzf), Math.max(0, this.zzk.zza().zzb(d_, zzas.zzg)));
                        if (!zza3.isEmpty()) {
                            if (!zzml.zzb() || !this.zzk.zza().zza(zzas.zzci) || zza(d_).zzc()) {
                                Iterator<Pair<zzcd.zzg, Long>> it = zza3.iterator();
                                while (true) {
                                    if (!it.hasNext()) {
                                        str = null;
                                        break;
                                    }
                                    zzcd.zzg zzg2 = (zzcd.zzg) it.next().first;
                                    if (!TextUtils.isEmpty(zzg2.zzad())) {
                                        str = zzg2.zzad();
                                        break;
                                    }
                                }
                                if (str != null) {
                                    int i2 = 0;
                                    while (true) {
                                        if (i2 >= zza3.size()) {
                                            break;
                                        }
                                        zzcd.zzg zzg3 = (zzcd.zzg) zza3.get(i2).first;
                                        if (!(TextUtils.isEmpty(zzg3.zzad()) || zzg3.zzad().equals(str))) {
                                            zza3 = zza3.subList(0, i2);
                                            break;
                                        }
                                        i2++;
                                    }
                                }
                            }
                            zzcd.zzf.zza zzb4 = zzcd.zzf.zzb();
                            int size = zza3.size();
                            ArrayList arrayList = new ArrayList(zza3.size());
                            boolean z = this.zzk.zza().zzh(d_) && (!zzml.zzb() || !this.zzk.zza().zza(zzas.zzci) || zza(d_).zzc());
                            boolean z2 = !zzml.zzb() || !this.zzk.zza().zza(zzas.zzci) || zza(d_).zzc();
                            boolean z3 = !zzml.zzb() || !this.zzk.zza().zza(zzas.zzci) || zza(d_).zze();
                            int i3 = 0;
                            while (i3 < size) {
                                zzcd.zzg.zza zza4 = (zzcd.zzg.zza) ((zzcd.zzg) zza3.get(i3).first).zzbo();
                                arrayList.add((Long) zza3.get(i3).second);
                                zza4.zzg(33025L).zza(currentTimeMillis).zzb(false);
                                if (!z) {
                                    zza4.zzr();
                                }
                                if (zzml.zzb() && this.zzk.zza().zza(zzas.zzci)) {
                                    if (!z2) {
                                        zza4.zzk();
                                        zza4.zzl();
                                    }
                                    if (!z3) {
                                        zza4.zzm();
                                    }
                                }
                                if (this.zzk.zza().zze(d_, zzas.zzaw)) {
                                    zza4.zzl(zzh().zza(((zzcd.zzg) ((zzhy) zza4.zzy())).zzbk()));
                                }
                                zzb4.zza(zza4);
                                i3++;
                                arrayList = arrayList;
                            }
                            String zza5 = this.zzk.zzq().zza(2) ? zzh().zza((zzcd.zzf) ((zzhy) zzb4.zzy())) : null;
                            zzh();
                            byte[] zzbk = ((zzcd.zzf) ((zzhy) zzb4.zzy())).zzbk();
                            String zza6 = zzas.zzp.zza(null);
                            try {
                                URL url = new URL(zza6);
                                Preconditions.checkArgument(!arrayList.isEmpty());
                                if (this.zzw != null) {
                                    this.zzk.zzq().zze().zza("Set uploading progress before finishing the previous upload");
                                } else {
                                    this.zzw = new ArrayList(arrayList);
                                }
                                this.zzk.zzb().zzd.zza(currentTimeMillis);
                                String str2 = "?";
                                if (size > 0) {
                                    str2 = zzb4.zza(0).zzx();
                                }
                                this.zzk.zzq().zzw().zza("Uploading data. app, uncompressed size, data", str2, Integer.valueOf(zzbk.length), zza5);
                                this.zzs = true;
                                zzex zzd2 = zzd();
                                zzkn zzkn = new zzkn(this, d_);
                                zzd2.zzc();
                                zzd2.zzaj();
                                Preconditions.checkNotNull(url);
                                Preconditions.checkNotNull(zzbk);
                                Preconditions.checkNotNull(zzkn);
                                zzd2.zzp().zzc(new zzfb(zzd2, d_, url, zzbk, null, zzkn));
                            } catch (MalformedURLException unused) {
                                this.zzk.zzq().zze().zza("Failed to parse upload URL. Not uploading. appId", zzeq.zza(d_), zza6);
                            }
                        }
                    } else {
                        this.zzy = -1;
                        String zza7 = zze().zza(currentTimeMillis - zzab.zzv());
                        if (!TextUtils.isEmpty(zza7) && (zzb2 = zze().zzb(zza7)) != null) {
                            zza(zzb2);
                        }
                    }
                    this.zzt = false;
                    zzac();
                }
            }
        } finally {
            this.zzt = false;
            zzac();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:100:0x0265, code lost:
        r25 = "";
        r4 = r0;
        r6 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:561:0x1032, code lost:
        r6.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:96:0x025e, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:97:0x025f, code lost:
        r6 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:99:0x0264, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x027d  */
    /* JADX WARNING: Removed duplicated region for block: B:108:0x0284  */
    /* JADX WARNING: Removed duplicated region for block: B:113:0x0292  */
    /* JADX WARNING: Removed duplicated region for block: B:168:0x0467  */
    /* JADX WARNING: Removed duplicated region for block: B:175:0x0473  */
    /* JADX WARNING: Removed duplicated region for block: B:181:0x0492  */
    /* JADX WARNING: Removed duplicated region for block: B:191:0x04fd A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:195:0x0534  */
    /* JADX WARNING: Removed duplicated region for block: B:198:0x0596  */
    /* JADX WARNING: Removed duplicated region for block: B:199:0x059a  */
    /* JADX WARNING: Removed duplicated region for block: B:208:0x0600  */
    /* JADX WARNING: Removed duplicated region for block: B:216:0x0629 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:219:0x0632  */
    /* JADX WARNING: Removed duplicated region for block: B:220:0x0651  */
    /* JADX WARNING: Removed duplicated region for block: B:258:0x0745  */
    /* JADX WARNING: Removed duplicated region for block: B:309:0x08d3  */
    /* JADX WARNING: Removed duplicated region for block: B:315:0x08eb  */
    /* JADX WARNING: Removed duplicated region for block: B:316:0x0905  */
    /* JADX WARNING: Removed duplicated region for block: B:445:0x0c8e  */
    /* JADX WARNING: Removed duplicated region for block: B:446:0x0ca1  */
    /* JADX WARNING: Removed duplicated region for block: B:448:0x0ca4  */
    /* JADX WARNING: Removed duplicated region for block: B:449:0x0ccb  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0120  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0137  */
    /* JADX WARNING: Removed duplicated region for block: B:556:0x101b  */
    /* JADX WARNING: Removed duplicated region for block: B:561:0x1032  */
    /* JADX WARNING: Removed duplicated region for block: B:578:0x04f9 A[EDGE_INSN: B:578:0x04f9->B:189:0x04f9 ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x025e A[ExcHandler: all (th java.lang.Throwable), Splitter:B:4:0x0029] */
    private final boolean zza(String str, long j) {
        Throwable th;
        String str2;
        boolean z;
        long j2;
        boolean z2;
        zza zza2;
        zzkl zzkl;
        zza zza3;
        SecureRandom secureRandom;
        HashMap hashMap;
        boolean z3;
        int zzd2;
        Long l;
        HashMap hashMap2;
        long j3;
        zzf zzb2;
        boolean z4;
        long j4;
        String str3;
        int i;
        zzcd.zzc.zza zza4;
        String str4;
        boolean z5;
        boolean z6;
        int i2;
        zzcd.zzg.zza zza5;
        zzcd.zzc.zza zza6;
        String str5;
        String str6;
        String str7;
        zzcd.zze.zza zza7;
        boolean z7;
        int i3;
        zzcd.zzc.zza zza8;
        int i4;
        String str8;
        boolean z8;
        char c;
        String str9;
        Cursor cursor;
        SQLiteException sQLiteException;
        String str10;
        String[] strArr;
        String str11;
        Cursor query;
        String str12;
        String str13;
        zzkl zzkl2 = this;
        String str14 = "_npa";
        String str15 = "_ai";
        zze().zze();
        try {
            zza zza9 = new zza(zzkl2, null);
            zzaf zze2 = zze();
            long j5 = zzkl2.zzy;
            Preconditions.checkNotNull(zza9);
            zze2.zzc();
            zze2.zzaj();
            try {
                SQLiteDatabase c_ = zze2.c_();
                if (TextUtils.isEmpty(null)) {
                    int i5 = (j5 > -1 ? 1 : (j5 == -1 ? 0 : -1));
                    String[] strArr2 = i5 != 0 ? new String[]{String.valueOf(j5), String.valueOf(j)} : new String[]{String.valueOf(j)};
                    if (i5 != 0) {
                        str13 = "rowid <= ? and ";
                    } else {
                        str13 = "";
                    }
                    StringBuilder sb = new StringBuilder(String.valueOf(str13).length() + 148);
                    sb.append("select app_id, metadata_fingerprint from raw_events where ");
                    sb.append(str13);
                    sb.append("app_id in (select app_id from apps where config_fetched_time >= ?) order by rowid limit 1;");
                    cursor = c_.rawQuery(sb.toString(), strArr2);
                    try {
                        if (cursor.moveToFirst()) {
                            str9 = cursor.getString(0);
                            try {
                                str10 = cursor.getString(1);
                                cursor.close();
                                cursor = c_.query("raw_events_metadata", new String[]{"metadata"}, "app_id = ? and metadata_fingerprint = ?", new String[]{str9, str10}, null, null, "rowid", "2");
                                if (cursor.moveToFirst()) {
                                    zze2.zzq().zze().zza("Raw event metadata record is missing. appId", zzeq.zza(str9));
                                    if (cursor != null) {
                                        cursor.close();
                                    }
                                } else {
                                    try {
                                        zzcd.zzg zzg2 = (zzcd.zzg) ((zzhy) ((zzcd.zzg.zza) zzkr.zza(zzcd.zzg.zzbh(), cursor.getBlob(0))).zzy());
                                        if (cursor.moveToNext()) {
                                            str2 = "";
                                            try {
                                                zze2.zzq().zzh().zza("Get multiple raw event metadata records, expected one. appId", zzeq.zza(str9));
                                            } catch (SQLiteException e) {
                                                e = e;
                                                sQLiteException = e;
                                                try {
                                                    zze2.zzq().zze().zza("Data loss. Error selecting raw event. appId", zzeq.zza(str9), sQLiteException);
                                                    if (cursor != null) {
                                                    }
                                                    if (zza9.zzc != null || zza9.zzc.isEmpty()) {
                                                    }
                                                } catch (Throwable th2) {
                                                    th = th2;
                                                    if (cursor != null) {
                                                    }
                                                    throw th;
                                                }
                                            }
                                        } else {
                                            str2 = "";
                                        }
                                        cursor.close();
                                        zza9.zza(zzg2);
                                        if (j5 != -1) {
                                            str11 = "app_id = ? and metadata_fingerprint = ? and rowid <= ?";
                                            strArr = new String[]{str9, str10, String.valueOf(j5)};
                                        } else {
                                            str11 = "app_id = ? and metadata_fingerprint = ?";
                                            strArr = new String[]{str9, str10};
                                        }
                                        query = c_.query("raw_events", new String[]{"rowid", "name", "timestamp", Constants.ScionAnalytics.MessageType.DATA_MESSAGE}, str11, strArr, null, null, "rowid", null);
                                    } catch (IOException e2) {
                                        str2 = "";
                                        zze2.zzq().zze().zza("Data loss. Failed to merge raw event metadata. appId", zzeq.zza(str9), e2);
                                        if (cursor != null) {
                                            cursor.close();
                                        }
                                    }
                                    try {
                                        if (!query.moveToFirst()) {
                                            zze2.zzq().zzh().zza("Raw event data disappeared while in transaction. appId", zzeq.zza(str9));
                                            if (query != null) {
                                                query.close();
                                            }
                                        } else {
                                            while (true) {
                                                long j6 = query.getLong(0);
                                                try {
                                                    zzcd.zzc.zza zza10 = (zzcd.zzc.zza) zzkr.zza(zzcd.zzc.zzj(), query.getBlob(3));
                                                    zza10.zza(query.getString(1)).zza(query.getLong(2));
                                                    if (!zza9.zza(j6, (zzcd.zzc) ((zzhy) zza10.zzy()))) {
                                                        if (query != null) {
                                                            query.close();
                                                        }
                                                    }
                                                } catch (IOException e3) {
                                                    zze2.zzq().zze().zza("Data loss. Failed to merge raw event. appId", zzeq.zza(str9), e3);
                                                }
                                                if (!query.moveToNext()) {
                                                    if (query != null) {
                                                        query.close();
                                                    }
                                                }
                                            }
                                        }
                                    } catch (SQLiteException e4) {
                                        e = e4;
                                        cursor = query;
                                        sQLiteException = e;
                                        zze2.zzq().zze().zza("Data loss. Error selecting raw event. appId", zzeq.zza(str9), sQLiteException);
                                        if (cursor != null) {
                                        }
                                        if (zza9.zzc != null || zza9.zzc.isEmpty()) {
                                        }
                                    } catch (Throwable th3) {
                                        th = th3;
                                        cursor = query;
                                        if (cursor != null) {
                                        }
                                        throw th;
                                    }
                                    if (zza9.zzc != null || zza9.zzc.isEmpty()) {
                                        zzcd.zzg.zza zzc2 = ((zzcd.zzg.zza) zza9.zza.zzbo()).zzc();
                                        boolean zze3 = zzkl2.zzk.zza().zze(zza9.zza.zzx(), zzas.zzat);
                                        int i6 = -1;
                                        int i7 = -1;
                                        zzcd.zzc.zza zza11 = null;
                                        zzcd.zzc.zza zza12 = null;
                                        int i8 = 0;
                                        boolean z9 = false;
                                        int i9 = 0;
                                        long j7 = 0;
                                        while (true) {
                                            z = z9;
                                            int i10 = i6;
                                            if (i8 >= zza9.zzc.size()) {
                                                break;
                                            }
                                            zzcd.zzc.zza zza13 = (zzcd.zzc.zza) zza9.zzc.get(i8).zzbo();
                                            if (zzc().zzb(zza9.zza.zzx(), zza13.zzd())) {
                                                zzkl2.zzk.zzq().zzh().zza("Dropping blacklisted raw event. appId", zzeq.zza(zza9.zza.zzx()), zzkl2.zzk.zzi().zza(zza13.zzd()));
                                                if (!(zzc().zzg(zza9.zza.zzx()) || zzc().zzh(zza9.zza.zzx())) && !"_err".equals(zza13.zzd())) {
                                                    zzkl2.zzk.zzh().zza(zzkl2.zzaa, zza9.zza.zzx(), 11, "_ev", zza13.zzd(), 0);
                                                }
                                                j4 = j7;
                                                z9 = z;
                                                i9 = i9;
                                                i = i8;
                                                str3 = str15;
                                            } else {
                                                if (zzlo.zzb()) {
                                                    j4 = j7;
                                                    if (zzkl2.zzk.zza().zze(zza9.zza.zzx(), zzas.zzcl) && zza13.zzd().equals(zzgv.zza(str15))) {
                                                        zza13.zza(str15);
                                                        zzkl2.zzk.zzq().zzw().zza("Renaming ad_impression to _ai");
                                                        if (zzkl2.zzk.zzq().zza(5)) {
                                                            for (int i11 = 0; i11 < zza13.zzb(); i11++) {
                                                                if (FirebaseAnalytics.Param.AD_PLATFORM.equals(zza13.zza(i11).zzb()) && !TextUtils.isEmpty(zza13.zza(i11).zzd()) && "admob".equalsIgnoreCase(zza13.zza(i11).zzd())) {
                                                                    zzkl2.zzk.zzq().zzj().zza("AdMob ad impression logged from app. Potentially duplicative.");
                                                                }
                                                            }
                                                        }
                                                    }
                                                } else {
                                                    j4 = j7;
                                                }
                                                boolean zzc3 = zzc().zzc(zza9.zza.zzx(), zza13.zzd());
                                                if (!zzc3) {
                                                    zzh();
                                                    String zzd3 = zza13.zzd();
                                                    Preconditions.checkNotEmpty(zzd3);
                                                    str3 = str15;
                                                    int hashCode = zzd3.hashCode();
                                                    zza4 = zza11;
                                                    if (hashCode != 94660) {
                                                        if (hashCode != 95025) {
                                                            if (hashCode == 95027 && zzd3.equals("_ui")) {
                                                                c = 1;
                                                                if (!(c != 0 || c == 1 || c == 2)) {
                                                                    str4 = "_et";
                                                                    zza5 = zzc2;
                                                                    zza6 = zza12;
                                                                    str7 = "_fr";
                                                                    str5 = "_e";
                                                                }
                                                                str4 = "_et";
                                                                z5 = false;
                                                                z6 = false;
                                                                i2 = 0;
                                                                while (true) {
                                                                    zza5 = zzc2;
                                                                    if (i2 >= zza13.zzb()) {
                                                                        break;
                                                                    }
                                                                    if ("_c".equals(zza13.zza(i2).zzb())) {
                                                                        zza13.zza(i2, (zzcd.zze) ((zzhy) ((zzcd.zze.zza) zza13.zza(i2).zzbo()).zza(1L).zzy()));
                                                                        zza8 = zza12;
                                                                        z5 = true;
                                                                    } else if ("_r".equals(zza13.zza(i2).zzb())) {
                                                                        zza8 = zza12;
                                                                        zza13.zza(i2, (zzcd.zze) ((zzhy) ((zzcd.zze.zza) zza13.zza(i2).zzbo()).zza(1L).zzy()));
                                                                        z6 = true;
                                                                    } else {
                                                                        zza8 = zza12;
                                                                    }
                                                                    i2++;
                                                                    zzc2 = zza5;
                                                                    zza12 = zza8;
                                                                }
                                                                zza6 = zza12;
                                                                if (!z5 || !zzc3) {
                                                                    str6 = "_fr";
                                                                    str5 = "_e";
                                                                } else {
                                                                    zzkl2.zzk.zzq().zzw().zza("Marking event as conversion", zzkl2.zzk.zzi().zza(zza13.zzd()));
                                                                    str6 = "_fr";
                                                                    str5 = "_e";
                                                                    zza13.zza(zzcd.zze.zzm().zza("_c").zza(1L));
                                                                }
                                                                if (!z6) {
                                                                    zzkl2.zzk.zzq().zzw().zza("Marking event as real-time", zzkl2.zzk.zzi().zza(zza13.zzd()));
                                                                    zza13.zza(zzcd.zze.zzm().zza("_r").zza(1L));
                                                                }
                                                                str7 = str6;
                                                                if (zze().zza(zzy(), zza9.zza.zzx(), false, false, false, false, true).zze > ((long) zzkl2.zzk.zza().zzc(zza9.zza.zzx()))) {
                                                                    zza(zza13, "_r");
                                                                } else {
                                                                    z = true;
                                                                }
                                                                if (zzkv.zza(zza13.zzd()) && zzc3 && zze().zza(zzy(), zza9.zza.zzx(), false, false, true, false, false).zzc > ((long) zzkl2.zzk.zza().zzb(zza9.zza.zzx(), zzas.zzm))) {
                                                                    zzkl2.zzk.zzq().zzh().zza("Too many conversions. Not logging as conversion. appId", zzeq.zza(zza9.zza.zzx()));
                                                                    int i12 = -1;
                                                                    zza7 = null;
                                                                    z7 = false;
                                                                    for (i3 = 0; i3 < zza13.zzb(); i3++) {
                                                                        zzcd.zze zza14 = zza13.zza(i3);
                                                                        if ("_c".equals(zza14.zzb())) {
                                                                            zza7 = (zzcd.zze.zza) zza14.zzbo();
                                                                            i12 = i3;
                                                                        } else if ("_err".equals(zza14.zzb())) {
                                                                            z7 = true;
                                                                        }
                                                                    }
                                                                    if (!z7 && zza7 != null) {
                                                                        zza13.zzb(i12);
                                                                    } else if (zza7 != null) {
                                                                        zza13.zza(i12, (zzcd.zze) ((zzhy) ((zzcd.zze.zza) ((zzhy.zzb) zza7.clone())).zza("_err").zza(10L).zzy()));
                                                                    } else {
                                                                        zzkl2.zzk.zzq().zze().zza("Did not find conversion parameter. appId", zzeq.zza(zza9.zza.zzx()));
                                                                    }
                                                                }
                                                            }
                                                        } else if (zzd3.equals("_ug")) {
                                                            c = 2;
                                                            if (!(c != 0 || c == 1 || c == 2)) {
                                                            }
                                                            str4 = "_et";
                                                            z5 = false;
                                                            z6 = false;
                                                            i2 = 0;
                                                            while (true) {
                                                                zza5 = zzc2;
                                                                if (i2 >= zza13.zzb()) {
                                                                }
                                                                i2++;
                                                                zzc2 = zza5;
                                                                zza12 = zza8;
                                                            }
                                                            zza6 = zza12;
                                                            if (!z5) {
                                                            }
                                                            str6 = "_fr";
                                                            str5 = "_e";
                                                            if (!z6) {
                                                            }
                                                            str7 = str6;
                                                            if (zze().zza(zzy(), zza9.zza.zzx(), false, false, false, false, true).zze > ((long) zzkl2.zzk.zza().zzc(zza9.zza.zzx()))) {
                                                            }
                                                            zzkl2.zzk.zzq().zzh().zza("Too many conversions. Not logging as conversion. appId", zzeq.zza(zza9.zza.zzx()));
                                                            int i122 = -1;
                                                            zza7 = null;
                                                            z7 = false;
                                                            while (i3 < zza13.zzb()) {
                                                            }
                                                            if (!z7) {
                                                            }
                                                            if (zza7 != null) {
                                                            }
                                                        }
                                                    } else if (zzd3.equals("_in")) {
                                                        c = 0;
                                                        if (!(c != 0 || c == 1 || c == 2)) {
                                                        }
                                                        str4 = "_et";
                                                        z5 = false;
                                                        z6 = false;
                                                        i2 = 0;
                                                        while (true) {
                                                            zza5 = zzc2;
                                                            if (i2 >= zza13.zzb()) {
                                                            }
                                                            i2++;
                                                            zzc2 = zza5;
                                                            zza12 = zza8;
                                                        }
                                                        zza6 = zza12;
                                                        if (!z5) {
                                                        }
                                                        str6 = "_fr";
                                                        str5 = "_e";
                                                        if (!z6) {
                                                        }
                                                        str7 = str6;
                                                        if (zze().zza(zzy(), zza9.zza.zzx(), false, false, false, false, true).zze > ((long) zzkl2.zzk.zza().zzc(zza9.zza.zzx()))) {
                                                        }
                                                        zzkl2.zzk.zzq().zzh().zza("Too many conversions. Not logging as conversion. appId", zzeq.zza(zza9.zza.zzx()));
                                                        int i1222 = -1;
                                                        zza7 = null;
                                                        z7 = false;
                                                        while (i3 < zza13.zzb()) {
                                                        }
                                                        if (!z7) {
                                                        }
                                                        if (zza7 != null) {
                                                        }
                                                    }
                                                    c = 65535;
                                                    if (!(c != 0 || c == 1 || c == 2)) {
                                                    }
                                                    str4 = "_et";
                                                    z5 = false;
                                                    z6 = false;
                                                    i2 = 0;
                                                    while (true) {
                                                        zza5 = zzc2;
                                                        if (i2 >= zza13.zzb()) {
                                                        }
                                                        i2++;
                                                        zzc2 = zza5;
                                                        zza12 = zza8;
                                                    }
                                                    zza6 = zza12;
                                                    if (!z5) {
                                                    }
                                                    str6 = "_fr";
                                                    str5 = "_e";
                                                    if (!z6) {
                                                    }
                                                    str7 = str6;
                                                    if (zze().zza(zzy(), zza9.zza.zzx(), false, false, false, false, true).zze > ((long) zzkl2.zzk.zza().zzc(zza9.zza.zzx()))) {
                                                    }
                                                    zzkl2.zzk.zzq().zzh().zza("Too many conversions. Not logging as conversion. appId", zzeq.zza(zza9.zza.zzx()));
                                                    int i12222 = -1;
                                                    zza7 = null;
                                                    z7 = false;
                                                    while (i3 < zza13.zzb()) {
                                                    }
                                                    if (!z7) {
                                                    }
                                                    if (zza7 != null) {
                                                    }
                                                } else {
                                                    str3 = str15;
                                                    zza4 = zza11;
                                                    str4 = "_et";
                                                    z5 = false;
                                                    z6 = false;
                                                    i2 = 0;
                                                    while (true) {
                                                        zza5 = zzc2;
                                                        if (i2 >= zza13.zzb()) {
                                                        }
                                                        i2++;
                                                        zzc2 = zza5;
                                                        zza12 = zza8;
                                                    }
                                                    zza6 = zza12;
                                                    if (!z5) {
                                                    }
                                                    str6 = "_fr";
                                                    str5 = "_e";
                                                    if (!z6) {
                                                    }
                                                    str7 = str6;
                                                    if (zze().zza(zzy(), zza9.zza.zzx(), false, false, false, false, true).zze > ((long) zzkl2.zzk.zza().zzc(zza9.zza.zzx()))) {
                                                    }
                                                    zzkl2.zzk.zzq().zzh().zza("Too many conversions. Not logging as conversion. appId", zzeq.zza(zza9.zza.zzx()));
                                                    int i122222 = -1;
                                                    zza7 = null;
                                                    z7 = false;
                                                    while (i3 < zza13.zzb()) {
                                                    }
                                                    if (!z7) {
                                                    }
                                                    if (zza7 != null) {
                                                    }
                                                }
                                                z9 = z;
                                                if (zzc3) {
                                                    ArrayList arrayList = new ArrayList(zza13.zza());
                                                    int i13 = -1;
                                                    int i14 = -1;
                                                    for (int i15 = 0; i15 < arrayList.size(); i15++) {
                                                        if ("value".equals(((zzcd.zze) arrayList.get(i15)).zzb())) {
                                                            i13 = i15;
                                                        } else if (FirebaseAnalytics.Param.CURRENCY.equals(((zzcd.zze) arrayList.get(i15)).zzb())) {
                                                            i14 = i15;
                                                        }
                                                    }
                                                    if (i13 != -1) {
                                                        if (((zzcd.zze) arrayList.get(i13)).zze() || ((zzcd.zze) arrayList.get(i13)).zzi()) {
                                                            if (i14 == -1) {
                                                                z8 = true;
                                                            } else {
                                                                String zzd4 = ((zzcd.zze) arrayList.get(i14)).zzd();
                                                                if (zzd4.length() == 3) {
                                                                    int i16 = 0;
                                                                    while (true) {
                                                                        if (i16 >= zzd4.length()) {
                                                                            z8 = false;
                                                                            break;
                                                                        }
                                                                        int codePointAt = zzd4.codePointAt(i16);
                                                                        if (!Character.isLetter(codePointAt)) {
                                                                            break;
                                                                        }
                                                                        i16 += Character.charCount(codePointAt);
                                                                    }
                                                                }
                                                                z8 = true;
                                                            }
                                                            if (z8) {
                                                                zzkl2.zzk.zzq().zzj().zza("Value parameter discarded. You must also supply a 3-letter ISO_4217 currency code in the currency parameter.");
                                                                zza13.zzb(i13);
                                                                zza(zza13, "_c");
                                                                zza(zza13, 19, FirebaseAnalytics.Param.CURRENCY);
                                                            }
                                                            if (zzkl2.zzk.zza().zze(zza9.zza.zzx(), zzas.zzas)) {
                                                                if (str5.equals(zza13.zzd())) {
                                                                    zzh();
                                                                    if (zzkr.zza((zzcd.zzc) ((zzhy) zza13.zzy()), str7) == null) {
                                                                        if (zza6 != null && Math.abs(zza6.zzf() - zza13.zzf()) <= 1000) {
                                                                            zzcd.zzc.zza zza15 = (zzcd.zzc.zza) ((zzhy.zzb) zza6.clone());
                                                                            if (zzkl2.zza(zza13, zza15)) {
                                                                                zzc2 = zza5;
                                                                                zzc2.zza(i7, zza15);
                                                                                i4 = i10;
                                                                                str8 = str4;
                                                                            }
                                                                        }
                                                                        zzc2 = zza5;
                                                                        zza4 = zza13;
                                                                        i4 = i9;
                                                                    } else {
                                                                        zzc2 = zza5;
                                                                        i4 = i10;
                                                                    }
                                                                    str8 = str4;
                                                                } else {
                                                                    zzc2 = zza5;
                                                                    if ("_vs".equals(zza13.zzd())) {
                                                                        zzh();
                                                                        str8 = str4;
                                                                        if (zzkr.zza((zzcd.zzc) ((zzhy) zza13.zzy()), str8) == null) {
                                                                            if (zza4 != null && Math.abs(zza4.zzf() - zza13.zzf()) <= 1000) {
                                                                                zzcd.zzc.zza zza16 = (zzcd.zzc.zza) ((zzhy.zzb) zza4.clone());
                                                                                if (zzkl2.zza(zza16, zza13)) {
                                                                                    i4 = i10;
                                                                                    zzc2.zza(i4, zza16);
                                                                                }
                                                                            }
                                                                            i4 = i10;
                                                                            zza6 = zza13;
                                                                            i7 = i9;
                                                                        } else {
                                                                            i4 = i10;
                                                                        }
                                                                    } else {
                                                                        i4 = i10;
                                                                        str8 = str4;
                                                                        if (zzkl2.zzk.zza().zze(zza9.zza.zzx(), zzas.zzbl) && "_ab".equals(zza13.zzd())) {
                                                                            zzh();
                                                                            if (zzkr.zza((zzcd.zzc) ((zzhy) zza13.zzy()), str8) == null && zza4 != null && Math.abs(zza4.zzf() - zza13.zzf()) <= 4000) {
                                                                                zzcd.zzc.zza zza17 = (zzcd.zzc.zza) ((zzhy.zzb) zza4.clone());
                                                                                zzkl2.zzb(zza17, zza13);
                                                                                Preconditions.checkArgument(str5.equals(zza17.zzd()));
                                                                                zzh();
                                                                                zzcd.zze zza18 = zzkr.zza((zzcd.zzc) ((zzhy) zza17.zzy()), "_sn");
                                                                                zzh();
                                                                                zzcd.zze zza19 = zzkr.zza((zzcd.zzc) ((zzhy) zza17.zzy()), "_sc");
                                                                                zzh();
                                                                                zzcd.zze zza20 = zzkr.zza((zzcd.zzc) ((zzhy) zza17.zzy()), "_si");
                                                                                String zzd5 = zza18 != null ? zza18.zzd() : str2;
                                                                                if (!TextUtils.isEmpty(zzd5)) {
                                                                                    zzh();
                                                                                    zzkr.zza(zza13, "_sn", zzd5);
                                                                                }
                                                                                String zzd6 = zza19 != null ? zza19.zzd() : str2;
                                                                                if (!TextUtils.isEmpty(zzd6)) {
                                                                                    zzh();
                                                                                    zzkr.zza(zza13, "_sc", zzd6);
                                                                                }
                                                                                if (zza20 != null) {
                                                                                    zzh();
                                                                                    zzkr.zza(zza13, "_si", Long.valueOf(zza20.zzf()));
                                                                                }
                                                                                zzc2.zza(i4, zza17);
                                                                                zza4 = null;
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                                zza4 = null;
                                                                zza6 = null;
                                                            } else {
                                                                i4 = i10;
                                                                str8 = str4;
                                                                zzc2 = zza5;
                                                            }
                                                            if (!zze3 && str5.equals(zza13.zzd())) {
                                                                if (zza13.zzb() == 0) {
                                                                    zzkl2.zzk.zzq().zzh().zza("Engagement event does not contain any parameters. appId", zzeq.zza(zza9.zza.zzx()));
                                                                } else {
                                                                    zzh();
                                                                    Long l2 = (Long) zzkr.zzb((zzcd.zzc) ((zzhy) zza13.zzy()), str8);
                                                                    if (l2 == null) {
                                                                        zzkl2.zzk.zzq().zzh().zza("Engagement event does not include duration. appId", zzeq.zza(zza9.zza.zzx()));
                                                                    } else {
                                                                        j4 += l2.longValue();
                                                                    }
                                                                }
                                                            }
                                                            i = i8;
                                                            zza9.zzc.set(i, (zzcd.zzc) ((zzhy) zza13.zzy()));
                                                            i9++;
                                                            zzc2.zza(zza13);
                                                            i10 = i4;
                                                            zza11 = zza4;
                                                            zza12 = zza6;
                                                        } else {
                                                            zzkl2.zzk.zzq().zzj().zza("Value must be specified with a numeric type.");
                                                            zza13.zzb(i13);
                                                            zza(zza13, "_c");
                                                            zza(zza13, 18, "value");
                                                        }
                                                    }
                                                    if (zzkl2.zzk.zza().zze(zza9.zza.zzx(), zzas.zzas)) {
                                                    }
                                                    if (zza13.zzb() == 0) {
                                                    }
                                                    i = i8;
                                                    zza9.zzc.set(i, (zzcd.zzc) ((zzhy) zza13.zzy()));
                                                    i9++;
                                                    zzc2.zza(zza13);
                                                    i10 = i4;
                                                    zza11 = zza4;
                                                    zza12 = zza6;
                                                }
                                                if (zzkl2.zzk.zza().zze(zza9.zza.zzx(), zzas.zzas)) {
                                                }
                                                if (zza13.zzb() == 0) {
                                                }
                                                i = i8;
                                                zza9.zzc.set(i, (zzcd.zzc) ((zzhy) zza13.zzy()));
                                                i9++;
                                                zzc2.zza(zza13);
                                                i10 = i4;
                                                zza11 = zza4;
                                                zza12 = zza6;
                                            }
                                            i8 = i + 1;
                                            str15 = str3;
                                            str14 = str14;
                                            zze3 = zze3;
                                            i6 = i10;
                                            j7 = j4;
                                        }
                                        if (zze3) {
                                            int i17 = i9;
                                            long j8 = j7;
                                            int i18 = 0;
                                            while (i18 < i17) {
                                                zzcd.zzc zzb3 = zzc2.zzb(i18);
                                                if ("_e".equals(zzb3.zzc())) {
                                                    zzh();
                                                    if (zzkr.zza(zzb3, "_fr") != null) {
                                                        zzc2.zzc(i18);
                                                        i17--;
                                                        i18--;
                                                        i18++;
                                                    }
                                                }
                                                zzh();
                                                zzcd.zze zza21 = zzkr.zza(zzb3, "_et");
                                                if (zza21 != null) {
                                                    Long valueOf = zza21.zze() ? Long.valueOf(zza21.zzf()) : null;
                                                    if (valueOf != null && valueOf.longValue() > 0) {
                                                        j8 += valueOf.longValue();
                                                    }
                                                }
                                                i18++;
                                            }
                                            j2 = j8;
                                        } else {
                                            j2 = j7;
                                        }
                                        zzkl2.zza(zzc2, j2, false);
                                        Iterator<zzcd.zzc> it = zzc2.zza().iterator();
                                        while (true) {
                                            if (it.hasNext()) {
                                                if ("_s".equals(it.next().zzc())) {
                                                    z2 = true;
                                                    break;
                                                }
                                            } else {
                                                z2 = false;
                                                break;
                                            }
                                        }
                                        if (z2) {
                                            zze().zzb(zzc2.zzj(), "_se");
                                        }
                                        if (zzkr.zza(zzc2, "_sid") >= 0) {
                                            zzkl2.zza(zzc2, j2, true);
                                        } else {
                                            int zza22 = zzkr.zza(zzc2, "_se");
                                            if (zza22 >= 0) {
                                                zzc2.zze(zza22);
                                                zzkl2.zzk.zzq().zze().zza("Session engagement user property is in the bundle without session ID. appId", zzeq.zza(zza9.zza.zzx()));
                                            }
                                        }
                                        zzkr zzh2 = zzh();
                                        zzh2.zzq().zzw().zza("Checking account type status for ad personalization signals");
                                        if (zzh2.zzj().zze(zzc2.zzj()) && (zzb2 = zzh2.zzi().zzb(zzc2.zzj())) != null && zzb2.zzaf() && zzh2.zzk().zzi()) {
                                            zzh2.zzq().zzv().zza("Turning off ad personalization due to account type");
                                            zzcd.zzk zzk2 = (zzcd.zzk) ((zzhy) zzcd.zzk.zzj().zza(str14).zza(zzh2.zzk().zzg()).zzb(1).zzy());
                                            int i19 = 0;
                                            while (true) {
                                                if (i19 >= zzc2.zze()) {
                                                    z4 = false;
                                                    break;
                                                } else if (str14.equals(zzc2.zzd(i19).zzc())) {
                                                    zzc2.zza(i19, zzk2);
                                                    z4 = true;
                                                    break;
                                                } else {
                                                    i19++;
                                                }
                                            }
                                            if (!z4) {
                                                zzc2.zza(zzk2);
                                            }
                                        }
                                        zzc2.zzb(LongCompanionObject.MAX_VALUE).zzc(Long.MIN_VALUE);
                                        for (int i20 = 0; i20 < zzc2.zzb(); i20++) {
                                            zzcd.zzc zzb4 = zzc2.zzb(i20);
                                            if (zzb4.zze() < zzc2.zzf()) {
                                                zzc2.zzb(zzb4.zze());
                                            }
                                            if (zzb4.zze() > zzc2.zzg()) {
                                                zzc2.zzc(zzb4.zze());
                                            }
                                        }
                                        if (zzoz.zzb() && zzkl2.zzk.zza().zze(zzc2.zzj(), zzas.zzcf)) {
                                            zzc2.zzq();
                                        }
                                        zzc2.zzp().zzc(zzf().zza(zzc2.zzj(), zzc2.zza(), zzc2.zzd(), Long.valueOf(zzc2.zzf()), Long.valueOf(zzc2.zzg())));
                                        if (zzkl2.zzk.zza().zzi(zza9.zza.zzx())) {
                                            try {
                                                HashMap hashMap3 = new HashMap();
                                                ArrayList arrayList2 = new ArrayList();
                                                SecureRandom zzg3 = zzkl2.zzk.zzh().zzg();
                                                int i21 = 0;
                                                while (i21 < zzc2.zzb()) {
                                                    zzcd.zzc.zza zza23 = (zzcd.zzc.zza) zzc2.zzb(i21).zzbo();
                                                    if (zza23.zzd().equals("_ep")) {
                                                        zzh();
                                                        String str16 = (String) zzkr.zzb((zzcd.zzc) ((zzhy) zza23.zzy()), "_en");
                                                        zzam zzam = (zzam) hashMap3.get(str16);
                                                        if (zzam == null) {
                                                            zzam = zze().zza(zza9.zza.zzx(), str16);
                                                            hashMap3.put(str16, zzam);
                                                        }
                                                        if (zzam.zzi == null) {
                                                            if (zzam.zzj.longValue() > 1) {
                                                                zzh();
                                                                zzkr.zza(zza23, "_sr", zzam.zzj);
                                                            }
                                                            if (zzam.zzk != null && zzam.zzk.booleanValue()) {
                                                                zzh();
                                                                zzkr.zza(zza23, "_efs", (Object) 1L);
                                                            }
                                                            arrayList2.add((zzcd.zzc) ((zzhy) zza23.zzy()));
                                                        }
                                                        zzc2.zza(i21, zza23);
                                                    } else {
                                                        long zzf2 = zzc().zzf(zza9.zza.zzx());
                                                        zzkl2.zzk.zzh();
                                                        long zza24 = zzkv.zza(zza23.zzf(), zzf2);
                                                        zzcd.zzc zzc4 = (zzcd.zzc) ((zzhy) zza23.zzy());
                                                        Long l3 = 1L;
                                                        if (!TextUtils.isEmpty("_dbg") && l3 != null) {
                                                            Iterator<zzcd.zze> it2 = zzc4.zza().iterator();
                                                            while (true) {
                                                                if (!it2.hasNext()) {
                                                                    break;
                                                                }
                                                                zzcd.zze next = it2.next();
                                                                if (!"_dbg".equals(next.zzb())) {
                                                                    it2 = it2;
                                                                } else if (((l3 instanceof Long) && l3.equals(Long.valueOf(next.zzf()))) || (((l3 instanceof String) && l3.equals(next.zzd())) || ((l3 instanceof Double) && l3.equals(Double.valueOf(next.zzj()))))) {
                                                                    z3 = true;
                                                                }
                                                            }
                                                            zzd2 = z3 ? zzc().zzd(zza9.zza.zzx(), zza23.zzd()) : 1;
                                                            if (zzd2 > 0) {
                                                                zzkl2.zzk.zzq().zzh().zza("Sample rate must be positive. event, rate", zza23.zzd(), Integer.valueOf(zzd2));
                                                                arrayList2.add((zzcd.zzc) ((zzhy) zza23.zzy()));
                                                                zzc2.zza(i21, zza23);
                                                            } else {
                                                                zzam zzam2 = (zzam) hashMap3.get(zza23.zzd());
                                                                if (zzam2 == null && (zzam2 = zze().zza(zza9.zza.zzx(), zza23.zzd())) == null) {
                                                                    zzkl2.zzk.zzq().zzh().zza("Event being bundled has no eventAggregate. appId, eventName", zza9.zza.zzx(), zza23.zzd());
                                                                    zzam2 = new zzam(zza9.zza.zzx(), zza23.zzd(), 1, 1, 1, zza23.zzf(), 0, null, null, null, null);
                                                                }
                                                                zzh();
                                                                Long l4 = (Long) zzkr.zzb((zzcd.zzc) ((zzhy) zza23.zzy()), "_eid");
                                                                Boolean valueOf2 = Boolean.valueOf(l4 != null);
                                                                if (zzd2 == 1) {
                                                                    arrayList2.add((zzcd.zzc) ((zzhy) zza23.zzy()));
                                                                    if (valueOf2.booleanValue() && !(zzam2.zzi == null && zzam2.zzj == null && zzam2.zzk == null)) {
                                                                        hashMap3.put(zza23.zzd(), zzam2.zza(null, null, null));
                                                                    }
                                                                    zzc2.zza(i21, zza23);
                                                                } else {
                                                                    if (zzg3.nextInt(zzd2) == 0) {
                                                                        zzh();
                                                                        zza3 = zza9;
                                                                        secureRandom = zzg3;
                                                                        long j9 = (long) zzd2;
                                                                        zzkr.zza(zza23, "_sr", Long.valueOf(j9));
                                                                        arrayList2.add((zzcd.zzc) ((zzhy) zza23.zzy()));
                                                                        if (valueOf2.booleanValue()) {
                                                                            zzam2 = zzam2.zza(null, Long.valueOf(j9), null);
                                                                        }
                                                                        hashMap3.put(zza23.zzd(), zzam2.zza(zza23.zzf(), zza24));
                                                                        hashMap = hashMap3;
                                                                    } else {
                                                                        zza3 = zza9;
                                                                        secureRandom = zzg3;
                                                                        if (zzam2.zzh != null) {
                                                                            j3 = zzam2.zzh.longValue();
                                                                            l = l4;
                                                                            hashMap2 = hashMap3;
                                                                        } else {
                                                                            this.zzk.zzh();
                                                                            l = l4;
                                                                            hashMap2 = hashMap3;
                                                                            j3 = zzkv.zza(zza23.zzg(), zzf2);
                                                                        }
                                                                        if (j3 != zza24) {
                                                                            zzh();
                                                                            zzkr.zza(zza23, "_efs", (Object) 1L);
                                                                            zzh();
                                                                            long j10 = (long) zzd2;
                                                                            zzkr.zza(zza23, "_sr", Long.valueOf(j10));
                                                                            arrayList2.add((zzcd.zzc) ((zzhy) zza23.zzy()));
                                                                            if (valueOf2.booleanValue()) {
                                                                                zzam2 = zzam2.zza(null, Long.valueOf(j10), true);
                                                                            }
                                                                            hashMap = hashMap2;
                                                                            hashMap.put(zza23.zzd(), zzam2.zza(zza23.zzf(), zza24));
                                                                        } else {
                                                                            hashMap = hashMap2;
                                                                            if (valueOf2.booleanValue()) {
                                                                                hashMap.put(zza23.zzd(), zzam2.zza(l, null, null));
                                                                            }
                                                                        }
                                                                    }
                                                                    zzc2.zza(i21, zza23);
                                                                    i21++;
                                                                    zzkl2 = this;
                                                                    zza9 = zza3;
                                                                    hashMap3 = hashMap;
                                                                    zzg3 = secureRandom;
                                                                }
                                                            }
                                                        }
                                                        z3 = false;
                                                        if (z3) {
                                                        }
                                                        if (zzd2 > 0) {
                                                        }
                                                    }
                                                    hashMap = hashMap3;
                                                    zza3 = zza9;
                                                    secureRandom = zzg3;
                                                    i21++;
                                                    zzkl2 = this;
                                                    zza9 = zza3;
                                                    hashMap3 = hashMap;
                                                    zzg3 = secureRandom;
                                                }
                                                if (arrayList2.size() < zzc2.zzb()) {
                                                    zzc2.zzc().zza(arrayList2);
                                                }
                                                for (Map.Entry entry : hashMap3.entrySet()) {
                                                    zze().zza((zzam) entry.getValue());
                                                }
                                                zza2 = zza9;
                                            } catch (Throwable th4) {
                                                th = th4;
                                                zze().zzg();
                                                throw th;
                                            }
                                        } else {
                                            zza2 = zza9;
                                        }
                                        String zzx2 = zza2.zza.zzx();
                                        zzf zzb5 = zze().zzb(zzx2);
                                        if (zzb5 == null) {
                                            zzkl = this;
                                            try {
                                                zzkl.zzk.zzq().zze().zza("Bundling raw events w/o app info. appId", zzeq.zza(zza2.zza.zzx()));
                                            } catch (Throwable th5) {
                                                th = th5;
                                                zze().zzg();
                                                throw th;
                                            }
                                        } else {
                                            zzkl = this;
                                            if (zzc2.zzb() > 0) {
                                                long zzk3 = zzb5.zzk();
                                                if (zzk3 != 0) {
                                                    zzc2.zze(zzk3);
                                                } else {
                                                    zzc2.zzi();
                                                }
                                                long zzj2 = zzb5.zzj();
                                                if (zzj2 != 0) {
                                                    zzk3 = zzj2;
                                                }
                                                if (zzk3 != 0) {
                                                    zzc2.zzd(zzk3);
                                                } else {
                                                    zzc2.zzh();
                                                }
                                                zzb5.zzv();
                                                zzc2.zzg((int) zzb5.zzs());
                                                zzb5.zza(zzc2.zzf());
                                                zzb5.zzb(zzc2.zzg());
                                                String zzad = zzb5.zzad();
                                                if (zzad != null) {
                                                    zzc2.zzj(zzad);
                                                } else {
                                                    zzc2.zzn();
                                                }
                                                zze().zza(zzb5);
                                            }
                                        }
                                        if (zzc2.zzb() > 0) {
                                            zzca.zzb zza25 = zzc().zza(zza2.zza.zzx());
                                            if (zza25 != null) {
                                                if (zza25.zza()) {
                                                    zzc2.zzi(zza25.zzb());
                                                    zze().zza((zzcd.zzg) ((zzhy) zzc2.zzy()), z);
                                                }
                                            }
                                            if (TextUtils.isEmpty(zza2.zza.zzam())) {
                                                zzc2.zzi(-1L);
                                            } else {
                                                zzkl.zzk.zzq().zzh().zza("Did not find measurement config or missing version info. appId", zzeq.zza(zza2.zza.zzx()));
                                            }
                                            zze().zza((zzcd.zzg) ((zzhy) zzc2.zzy()), z);
                                        }
                                        zzaf zze4 = zze();
                                        List<Long> list = zza2.zzb;
                                        Preconditions.checkNotNull(list);
                                        zze4.zzc();
                                        zze4.zzaj();
                                        StringBuilder sb2 = new StringBuilder("rowid in (");
                                        for (int i22 = 0; i22 < list.size(); i22++) {
                                            if (i22 != 0) {
                                                sb2.append(",");
                                            }
                                            sb2.append(list.get(i22).longValue());
                                        }
                                        sb2.append(")");
                                        int delete = zze4.c_().delete("raw_events", sb2.toString(), null);
                                        if (delete != list.size()) {
                                            zze4.zzq().zze().zza("Deleted fewer rows from raw events table than expected", Integer.valueOf(delete), Integer.valueOf(list.size()));
                                        }
                                        zzaf zze5 = zze();
                                        try {
                                            zze5.c_().execSQL("delete from raw_events_metadata where app_id=? and metadata_fingerprint not in (select distinct metadata_fingerprint from raw_events where app_id=?)", new String[]{zzx2, zzx2});
                                        } catch (SQLiteException e5) {
                                            zze5.zzq().zze().zza("Failed to remove unused event metadata. appId", zzeq.zza(zzx2), e5);
                                        }
                                        zze().b_();
                                        zze().zzg();
                                        return true;
                                    }
                                    zze().b_();
                                    zze().zzg();
                                    return false;
                                }
                            } catch (SQLiteException e6) {
                                e = e6;
                                str2 = "";
                            }
                        } else if (cursor != null) {
                            cursor.close();
                        }
                    } catch (SQLiteException e7) {
                        e = e7;
                        str2 = "";
                        str9 = null;
                        sQLiteException = e;
                        zze2.zzq().zze().zza("Data loss. Error selecting raw event. appId", zzeq.zza(str9), sQLiteException);
                        if (cursor != null) {
                        }
                        if (zza9.zzc != null || zza9.zzc.isEmpty()) {
                        }
                    }
                } else {
                    int i23 = (j5 > -1 ? 1 : (j5 == -1 ? 0 : -1));
                    String[] strArr3 = i23 != 0 ? new String[]{null, String.valueOf(j5)} : new String[]{null};
                    if (i23 != 0) {
                        str12 = " and rowid <= ?";
                    } else {
                        str12 = "";
                    }
                    StringBuilder sb3 = new StringBuilder(String.valueOf(str12).length() + 84);
                    sb3.append("select metadata_fingerprint from raw_events where app_id = ?");
                    sb3.append(str12);
                    sb3.append(" order by rowid limit 1;");
                    cursor = c_.rawQuery(sb3.toString(), strArr3);
                    try {
                        if (cursor.moveToFirst()) {
                            str10 = cursor.getString(0);
                            cursor.close();
                            str9 = null;
                            cursor = c_.query("raw_events_metadata", new String[]{"metadata"}, "app_id = ? and metadata_fingerprint = ?", new String[]{str9, str10}, null, null, "rowid", "2");
                            if (cursor.moveToFirst()) {
                            }
                        } else if (cursor != null) {
                            cursor.close();
                        }
                    } catch (SQLiteException e8) {
                        str2 = "";
                        sQLiteException = e8;
                        str9 = null;
                        zze2.zzq().zze().zza("Data loss. Error selecting raw event. appId", zzeq.zza(str9), sQLiteException);
                        if (cursor != null) {
                            cursor.close();
                        }
                        if (zza9.zzc != null || zza9.zzc.isEmpty()) {
                        }
                    }
                }
                str2 = "";
            } catch (SQLiteException e9) {
                e = e9;
                str2 = "";
                cursor = null;
                str9 = null;
                sQLiteException = e;
                zze2.zzq().zze().zza("Data loss. Error selecting raw event. appId", zzeq.zza(str9), sQLiteException);
                if (cursor != null) {
                }
                if (zza9.zzc != null || zza9.zzc.isEmpty()) {
                }
            } catch (Throwable th6) {
            }
            if (zza9.zzc != null || zza9.zzc.isEmpty()) {
            }
        } catch (Throwable th7) {
            th = th7;
            zze().zzg();
            throw th;
        }
    }

    private final void zza(zzcd.zzg.zza zza2, long j, boolean z) {
        zzkw zzkw;
        String str = z ? "_se" : "_lte";
        zzkw zzc2 = zze().zzc(zza2.zzj(), str);
        if (zzc2 == null || zzc2.zze == null) {
            zzkw = new zzkw(zza2.zzj(), DebugKt.DEBUG_PROPERTY_VALUE_AUTO, str, this.zzk.zzl().currentTimeMillis(), Long.valueOf(j));
        } else {
            zzkw = new zzkw(zza2.zzj(), DebugKt.DEBUG_PROPERTY_VALUE_AUTO, str, this.zzk.zzl().currentTimeMillis(), Long.valueOf(((Long) zzc2.zze).longValue() + j));
        }
        zzcd.zzk zzk2 = (zzcd.zzk) ((zzhy) zzcd.zzk.zzj().zza(str).zza(this.zzk.zzl().currentTimeMillis()).zzb(((Long) zzkw.zze).longValue()).zzy());
        boolean z2 = false;
        int zza3 = zzkr.zza(zza2, str);
        if (zza3 >= 0) {
            zza2.zza(zza3, zzk2);
            z2 = true;
        }
        if (!z2) {
            zza2.zza(zzk2);
        }
        if (j > 0) {
            zze().zza(zzkw);
            this.zzk.zzq().zzw().zza("Updated engagement user property. scope, value", z ? "session-scoped" : "lifetime", zzkw.zze);
        }
    }

    private final boolean zza(zzcd.zzc.zza zza2, zzcd.zzc.zza zza3) {
        String str;
        Preconditions.checkArgument("_e".equals(zza2.zzd()));
        zzh();
        zzcd.zze zza4 = zzkr.zza((zzcd.zzc) ((zzhy) zza2.zzy()), "_sc");
        String str2 = null;
        if (zza4 == null) {
            str = null;
        } else {
            str = zza4.zzd();
        }
        zzh();
        zzcd.zze zza5 = zzkr.zza((zzcd.zzc) ((zzhy) zza3.zzy()), "_pc");
        if (zza5 != null) {
            str2 = zza5.zzd();
        }
        if (str2 == null || !str2.equals(str)) {
            return false;
        }
        zzb(zza2, zza3);
        return true;
    }

    private final void zzb(zzcd.zzc.zza zza2, zzcd.zzc.zza zza3) {
        Preconditions.checkArgument("_e".equals(zza2.zzd()));
        zzh();
        zzcd.zze zza4 = zzkr.zza((zzcd.zzc) ((zzhy) zza2.zzy()), "_et");
        if (zza4.zze() && zza4.zzf() > 0) {
            long zzf2 = zza4.zzf();
            zzh();
            zzcd.zze zza5 = zzkr.zza((zzcd.zzc) ((zzhy) zza3.zzy()), "_et");
            if (zza5 != null && zza5.zzf() > 0) {
                zzf2 += zza5.zzf();
            }
            zzh();
            zzkr.zza(zza3, "_et", Long.valueOf(zzf2));
            zzh();
            zzkr.zza(zza2, "_fr", (Object) 1L);
        }
    }

    private static void zza(zzcd.zzc.zza zza2, String str) {
        List<zzcd.zze> zza3 = zza2.zza();
        for (int i = 0; i < zza3.size(); i++) {
            if (str.equals(zza3.get(i).zzb())) {
                zza2.zzb(i);
                return;
            }
        }
    }

    private static void zza(zzcd.zzc.zza zza2, int i, String str) {
        List<zzcd.zze> zza3 = zza2.zza();
        for (int i2 = 0; i2 < zza3.size(); i2++) {
            if ("_err".equals(zza3.get(i2).zzb())) {
                return;
            }
        }
        zza2.zza((zzcd.zze) ((zzhy) zzcd.zze.zzm().zza("_err").zza(Long.valueOf((long) i).longValue()).zzy())).zza((zzcd.zze) ((zzhy) zzcd.zze.zzm().zza("_ev").zzb(str).zzy()));
    }

    /* JADX INFO: finally extract failed */
    /* access modifiers changed from: package-private */
    public final void zza(int i, Throwable th, byte[] bArr, String str) {
        zzx();
        zzn();
        if (bArr == null) {
            try {
                bArr = new byte[0];
            } catch (Throwable th2) {
                this.zzs = false;
                zzac();
                throw th2;
            }
        }
        List<Long> list = this.zzw;
        this.zzw = null;
        boolean z = true;
        if ((i == 200 || i == 204) && th == null) {
            try {
                this.zzk.zzb().zzc.zza(this.zzk.zzl().currentTimeMillis());
                this.zzk.zzb().zzd.zza(0);
                zzab();
                this.zzk.zzq().zzw().zza("Successful upload. Got network response. code, size", Integer.valueOf(i), Integer.valueOf(bArr.length));
                zze().zze();
                try {
                    for (Long l : list) {
                        try {
                            zzaf zze2 = zze();
                            long longValue = l.longValue();
                            zze2.zzc();
                            zze2.zzaj();
                            try {
                                if (zze2.c_().delete("queue", "rowid=?", new String[]{String.valueOf(longValue)}) != 1) {
                                    throw new SQLiteException("Deleted fewer rows from queue than expected");
                                }
                            } catch (SQLiteException e) {
                                zze2.zzq().zze().zza("Failed to delete a bundle in a queue table", e);
                                throw e;
                            }
                        } catch (SQLiteException e2) {
                            List<Long> list2 = this.zzx;
                            if (list2 == null || !list2.contains(l)) {
                                throw e2;
                            }
                        }
                    }
                    zze().b_();
                    zze().zzg();
                    this.zzx = null;
                    if (!zzd().zze() || !zzaa()) {
                        this.zzy = -1;
                        zzab();
                    } else {
                        zzo();
                    }
                    this.zzn = 0;
                } catch (Throwable th3) {
                    zze().zzg();
                    throw th3;
                }
            } catch (SQLiteException e3) {
                this.zzk.zzq().zze().zza("Database error while trying to delete uploaded bundles", e3);
                this.zzn = this.zzk.zzl().elapsedRealtime();
                this.zzk.zzq().zzw().zza("Disable upload, time", Long.valueOf(this.zzn));
            }
        } else {
            this.zzk.zzq().zzw().zza("Network upload failed. Will retry later. code, error", Integer.valueOf(i), th);
            this.zzk.zzb().zzd.zza(this.zzk.zzl().currentTimeMillis());
            if (!(i == 503 || i == 429)) {
                z = false;
            }
            if (z) {
                this.zzk.zzb().zze.zza(this.zzk.zzl().currentTimeMillis());
            }
            zze().zza(list);
            zzab();
        }
        this.zzs = false;
        zzac();
    }

    private final boolean zzaa() {
        zzx();
        zzn();
        return zze().zzx() || !TextUtils.isEmpty(zze().d_());
    }

    private final void zza(zzf zzf2) {
        ArrayMap arrayMap;
        zzx();
        if (!zznv.zzb() || !this.zzk.zza().zze(zzf2.zzc(), zzas.zzbi)) {
            if (TextUtils.isEmpty(zzf2.zze()) && TextUtils.isEmpty(zzf2.zzf())) {
                zza(zzf2.zzc(), 204, null, null, null);
                return;
            }
        } else if (TextUtils.isEmpty(zzf2.zze()) && TextUtils.isEmpty(zzf2.zzg()) && TextUtils.isEmpty(zzf2.zzf())) {
            zza(zzf2.zzc(), 204, null, null, null);
            return;
        }
        String zza2 = this.zzk.zza().zza(zzf2);
        try {
            URL url = new URL(zza2);
            this.zzk.zzq().zzw().zza("Fetching remote configuration", zzf2.zzc());
            zzca.zzb zza3 = zzc().zza(zzf2.zzc());
            String zzb2 = zzc().zzb(zzf2.zzc());
            if (zza3 == null || TextUtils.isEmpty(zzb2)) {
                arrayMap = null;
            } else {
                ArrayMap arrayMap2 = new ArrayMap();
                arrayMap2.put("If-Modified-Since", zzb2);
                arrayMap = arrayMap2;
            }
            this.zzr = true;
            zzex zzd2 = zzd();
            String zzc2 = zzf2.zzc();
            zzkm zzkm = new zzkm(this);
            zzd2.zzc();
            zzd2.zzaj();
            Preconditions.checkNotNull(url);
            Preconditions.checkNotNull(zzkm);
            zzd2.zzp().zzc(new zzfb(zzd2, zzc2, url, null, arrayMap, zzkm));
        } catch (MalformedURLException unused) {
            this.zzk.zzq().zze().zza("Failed to parse config URL. Not fetching. appId", zzeq.zza(zzf2.zzc()), zza2);
        }
    }

    /* JADX INFO: finally extract failed */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x013a  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x014a  */
    public final void zza(String str, int i, Throwable th, byte[] bArr, Map<String, List<String>> map) {
        zzx();
        zzn();
        Preconditions.checkNotEmpty(str);
        if (bArr == null) {
            try {
                bArr = new byte[0];
            } catch (Throwable th2) {
                this.zzr = false;
                zzac();
                throw th2;
            }
        }
        this.zzk.zzq().zzw().zza("onConfigFetched. Response size", Integer.valueOf(bArr.length));
        zze().zze();
        try {
            zzf zzb2 = zze().zzb(str);
            boolean z = true;
            boolean z2 = (i == 200 || i == 204 || i == 304) && th == null;
            if (zzb2 == null) {
                this.zzk.zzq().zzh().zza("App does not exist in onConfigFetched. appId", zzeq.zza(str));
            } else {
                if (!z2) {
                    if (i != 404) {
                        zzb2.zzi(this.zzk.zzl().currentTimeMillis());
                        zze().zza(zzb2);
                        this.zzk.zzq().zzw().zza("Fetching config failed. code, error", Integer.valueOf(i), th);
                        zzc().zzc(str);
                        this.zzk.zzb().zzd.zza(this.zzk.zzl().currentTimeMillis());
                        if (i != 503) {
                            if (i != 429) {
                                z = false;
                            }
                        }
                        if (z) {
                            this.zzk.zzb().zze.zza(this.zzk.zzl().currentTimeMillis());
                        }
                        zzab();
                    }
                }
                List<String> list = map != null ? map.get("Last-Modified") : null;
                String str2 = (list == null || list.size() <= 0) ? null : list.get(0);
                if (i != 404) {
                    if (i != 304) {
                        if (!zzc().zza(str, bArr, str2)) {
                            zze().zzg();
                            this.zzr = false;
                            zzac();
                            return;
                        }
                        zzb2.zzh(this.zzk.zzl().currentTimeMillis());
                        zze().zza(zzb2);
                        if (i != 404) {
                            this.zzk.zzq().zzj().zza("Config not found. Using empty config. appId", str);
                        } else {
                            this.zzk.zzq().zzw().zza("Successfully fetched config. Got network response. code, size", Integer.valueOf(i), Integer.valueOf(bArr.length));
                        }
                        if (zzd().zze() || !zzaa()) {
                            zzab();
                        } else {
                            zzo();
                        }
                    }
                }
                if (zzc().zza(str) == null && !zzc().zza(str, null, null)) {
                    zze().zzg();
                    this.zzr = false;
                    zzac();
                    return;
                }
                zzb2.zzh(this.zzk.zzl().currentTimeMillis());
                zze().zza(zzb2);
                if (i != 404) {
                }
                if (zzd().zze()) {
                }
                zzab();
            }
            zze().b_();
            zze().zzg();
            this.zzr = false;
            zzac();
        } catch (Throwable th3) {
            zze().zzg();
            throw th3;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:48:0x018b  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x01a9  */
    private final void zzab() {
        long j;
        long j2;
        zzx();
        zzn();
        if (this.zzn > 0) {
            long abs = 3600000 - Math.abs(this.zzk.zzl().elapsedRealtime() - this.zzn);
            if (abs > 0) {
                this.zzk.zzq().zzw().zza("Upload has been suspended. Will update scheduling later in approximately ms", Long.valueOf(abs));
                zzv().zzb();
                zzw().zze();
                return;
            }
            this.zzn = 0;
        }
        if (!this.zzk.zzaf() || !zzaa()) {
            this.zzk.zzq().zzw().zza("Nothing to upload or uploading impossible");
            zzv().zzb();
            zzw().zze();
            return;
        }
        long currentTimeMillis = this.zzk.zzl().currentTimeMillis();
        long max = Math.max(0L, zzas.zzz.zza(null).longValue());
        boolean z = zze().zzy() || zze().e_();
        if (z) {
            String zzw2 = this.zzk.zza().zzw();
            if (TextUtils.isEmpty(zzw2) || ".none.".equals(zzw2)) {
                j = Math.max(0L, zzas.zzt.zza(null).longValue());
            } else {
                j = Math.max(0L, zzas.zzu.zza(null).longValue());
            }
        } else {
            j = Math.max(0L, zzas.zzs.zza(null).longValue());
        }
        long zza2 = this.zzk.zzb().zzc.zza();
        long zza3 = this.zzk.zzb().zzd.zza();
        long max2 = Math.max(zze().zzv(), zze().zzw());
        if (max2 != 0) {
            long abs2 = currentTimeMillis - Math.abs(max2 - currentTimeMillis);
            long abs3 = currentTimeMillis - Math.abs(zza2 - currentTimeMillis);
            long abs4 = currentTimeMillis - Math.abs(zza3 - currentTimeMillis);
            long max3 = Math.max(abs3, abs4);
            j2 = abs2 + max;
            if (z && max3 > 0) {
                j2 = Math.min(abs2, max3) + j;
            }
            if (!zzh().zza(max3, j)) {
                j2 = max3 + j;
            }
            if (abs4 != 0 && abs4 >= abs2) {
                int i = 0;
                while (true) {
                    if (i >= Math.min(20, Math.max(0, zzas.zzab.zza(null).intValue()))) {
                        break;
                    }
                    j2 += Math.max(0L, zzas.zzaa.zza(null).longValue()) * (1 << i);
                    if (j2 > abs4) {
                        break;
                    }
                    i++;
                }
            }
            if (j2 != 0) {
                this.zzk.zzq().zzw().zza("Next upload time is 0");
                zzv().zzb();
                zzw().zze();
                return;
            } else if (!zzd().zze()) {
                this.zzk.zzq().zzw().zza("No network");
                zzv().zza();
                zzw().zze();
                return;
            } else {
                long zza4 = this.zzk.zzb().zze.zza();
                long max4 = Math.max(0L, zzas.zzq.zza(null).longValue());
                if (!zzh().zza(zza4, max4)) {
                    j2 = Math.max(j2, zza4 + max4);
                }
                zzv().zzb();
                long currentTimeMillis2 = j2 - this.zzk.zzl().currentTimeMillis();
                if (currentTimeMillis2 <= 0) {
                    currentTimeMillis2 = Math.max(0L, zzas.zzv.zza(null).longValue());
                    this.zzk.zzb().zzc.zza(this.zzk.zzl().currentTimeMillis());
                }
                this.zzk.zzq().zzw().zza("Upload scheduled in approximately ms", Long.valueOf(currentTimeMillis2));
                zzw().zza(currentTimeMillis2);
                return;
            }
        }
        j2 = 0;
        if (j2 != 0) {
        }
    }

    /* access modifiers changed from: package-private */
    public final void zza(Runnable runnable) {
        zzx();
        if (this.zzo == null) {
            this.zzo = new ArrayList();
        }
        this.zzo.add(runnable);
    }

    private final void zzac() {
        zzx();
        if (this.zzr || this.zzs || this.zzt) {
            this.zzk.zzq().zzw().zza("Not stopping services. fetch, network, upload", Boolean.valueOf(this.zzr), Boolean.valueOf(this.zzs), Boolean.valueOf(this.zzt));
            return;
        }
        this.zzk.zzq().zzw().zza("Stopping uploading service(s)");
        List<Runnable> list = this.zzo;
        if (list != null) {
            for (Runnable runnable : list) {
                runnable.run();
            }
            this.zzo.clear();
        }
    }

    private final Boolean zzb(zzf zzf2) {
        try {
            if (zzf2.zzm() != -2147483648L) {
                if (zzf2.zzm() == ((long) Wrappers.packageManager(this.zzk.zzm()).getPackageInfo(zzf2.zzc(), 0).versionCode)) {
                    return true;
                }
            } else {
                String str = Wrappers.packageManager(this.zzk.zzm()).getPackageInfo(zzf2.zzc(), 0).versionName;
                if (zzf2.zzl() != null && zzf2.zzl().equals(str)) {
                    return true;
                }
            }
            return false;
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzr() {
        zzx();
        zzn();
        if (!this.zzm) {
            this.zzm = true;
            if (zzad()) {
                int zza2 = zza(this.zzv);
                int zzae = this.zzk.zzx().zzae();
                zzx();
                if (zza2 > zzae) {
                    this.zzk.zzq().zze().zza("Panic: can't downgrade version. Previous, current version", Integer.valueOf(zza2), Integer.valueOf(zzae));
                } else if (zza2 >= zzae) {
                } else {
                    if (zza(zzae, this.zzv)) {
                        this.zzk.zzq().zzw().zza("Storage version upgraded. Previous, current version", Integer.valueOf(zza2), Integer.valueOf(zzae));
                    } else {
                        this.zzk.zzq().zze().zza("Storage version upgrade failed. Previous, current version", Integer.valueOf(zza2), Integer.valueOf(zzae));
                    }
                }
            }
        }
    }

    private final boolean zzad() {
        FileLock fileLock;
        zzx();
        if (!this.zzk.zza().zza(zzas.zzbh) || (fileLock = this.zzu) == null || !fileLock.isValid()) {
            try {
                FileChannel channel = new RandomAccessFile(new File(this.zzk.zzm().getFilesDir(), "google_app_measurement.db"), "rw").getChannel();
                this.zzv = channel;
                FileLock tryLock = channel.tryLock();
                this.zzu = tryLock;
                if (tryLock != null) {
                    this.zzk.zzq().zzw().zza("Storage concurrent access okay");
                    return true;
                }
                this.zzk.zzq().zze().zza("Storage concurrent data access panic");
                return false;
            } catch (FileNotFoundException e) {
                this.zzk.zzq().zze().zza("Failed to acquire storage lock", e);
                return false;
            } catch (IOException e2) {
                this.zzk.zzq().zze().zza("Failed to access storage lock file", e2);
                return false;
            } catch (OverlappingFileLockException e3) {
                this.zzk.zzq().zzh().zza("Storage lock already acquired", e3);
                return false;
            }
        } else {
            this.zzk.zzq().zzw().zza("Storage concurrent access okay");
            return true;
        }
    }

    private final int zza(FileChannel fileChannel) {
        zzx();
        if (fileChannel == null || !fileChannel.isOpen()) {
            this.zzk.zzq().zze().zza("Bad channel to read from");
            return 0;
        }
        ByteBuffer allocate = ByteBuffer.allocate(4);
        try {
            fileChannel.position(0L);
            int read = fileChannel.read(allocate);
            if (read != 4) {
                if (read != -1) {
                    this.zzk.zzq().zzh().zza("Unexpected data length. Bytes read", Integer.valueOf(read));
                }
                return 0;
            }
            allocate.flip();
            return allocate.getInt();
        } catch (IOException e) {
            this.zzk.zzq().zze().zza("Failed to read from channel", e);
            return 0;
        }
    }

    private final boolean zza(int i, FileChannel fileChannel) {
        zzx();
        if (fileChannel == null || !fileChannel.isOpen()) {
            this.zzk.zzq().zze().zza("Bad channel to read from");
            return false;
        }
        ByteBuffer allocate = ByteBuffer.allocate(4);
        allocate.putInt(i);
        allocate.flip();
        try {
            fileChannel.truncate(0L);
            if (this.zzk.zza().zza(zzas.zzbr) && Build.VERSION.SDK_INT <= 19) {
                fileChannel.position(0L);
            }
            fileChannel.write(allocate);
            fileChannel.force(true);
            if (fileChannel.size() != 4) {
                this.zzk.zzq().zze().zza("Error writing to channel. Bytes written", Long.valueOf(fileChannel.size()));
            }
            return true;
        } catch (IOException e) {
            this.zzk.zzq().zze().zza("Failed to write to channel", e);
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    public final void zza(zzn zzn2) {
        if (this.zzw != null) {
            ArrayList arrayList = new ArrayList();
            this.zzx = arrayList;
            arrayList.addAll(this.zzw);
        }
        zzaf zze2 = zze();
        String str = zzn2.zza;
        Preconditions.checkNotEmpty(str);
        zze2.zzc();
        zze2.zzaj();
        try {
            SQLiteDatabase c_ = zze2.c_();
            String[] strArr = {str};
            int delete = c_.delete("apps", "app_id=?", strArr) + 0 + c_.delete("events", "app_id=?", strArr) + c_.delete("user_attributes", "app_id=?", strArr) + c_.delete("conditional_properties", "app_id=?", strArr) + c_.delete("raw_events", "app_id=?", strArr) + c_.delete("raw_events_metadata", "app_id=?", strArr) + c_.delete("queue", "app_id=?", strArr) + c_.delete("audience_filter_values", "app_id=?", strArr) + c_.delete("main_event_params", "app_id=?", strArr) + c_.delete("default_event_params", "app_id=?", strArr);
            if (delete > 0) {
                zze2.zzq().zzw().zza("Reset analytics data. app, records", str, Integer.valueOf(delete));
            }
        } catch (SQLiteException e) {
            zze2.zzq().zze().zza("Error resetting analytics data. appId, error", zzeq.zza(str), e);
        }
        if (zzn2.zzh) {
            zzb(zzn2);
        }
    }

    /* access modifiers changed from: package-private */
    public final void zza(zzku zzku, zzn zzn2) {
        zzx();
        zzn();
        if (zze(zzn2)) {
            if (!zzn2.zzh) {
                zzc(zzn2);
                return;
            }
            int zzb2 = this.zzk.zzh().zzb(zzku.zza);
            int i = 0;
            if (zzb2 != 0) {
                this.zzk.zzh();
                this.zzk.zzh().zza(this.zzaa, zzn2.zza, zzb2, "_ev", zzkv.zza(zzku.zza, 24, true), zzku.zza != null ? zzku.zza.length() : 0);
                return;
            }
            int zzb3 = this.zzk.zzh().zzb(zzku.zza, zzku.zza());
            if (zzb3 != 0) {
                this.zzk.zzh();
                String zza2 = zzkv.zza(zzku.zza, 24, true);
                Object zza3 = zzku.zza();
                if (zza3 != null && ((zza3 instanceof String) || (zza3 instanceof CharSequence))) {
                    i = String.valueOf(zza3).length();
                }
                this.zzk.zzh().zza(this.zzaa, zzn2.zza, zzb3, "_ev", zza2, i);
                return;
            }
            Object zzc2 = this.zzk.zzh().zzc(zzku.zza, zzku.zza());
            if (zzc2 != null) {
                if ("_sid".equals(zzku.zza)) {
                    long j = zzku.zzb;
                    String str = zzku.zze;
                    long j2 = 0;
                    zzkw zzc3 = zze().zzc(zzn2.zza, "_sno");
                    if (zzc3 == null || !(zzc3.zze instanceof Long)) {
                        if (zzc3 != null) {
                            this.zzk.zzq().zzh().zza("Retrieved last session number from database does not contain a valid (long) value", zzc3.zze);
                        }
                        zzam zza4 = zze().zza(zzn2.zza, "_s");
                        if (zza4 != null) {
                            j2 = zza4.zzc;
                            this.zzk.zzq().zzw().zza("Backfill the session number. Last used session number", Long.valueOf(j2));
                        }
                    } else {
                        j2 = ((Long) zzc3.zze).longValue();
                    }
                    zza(new zzku("_sno", j, Long.valueOf(j2 + 1), str), zzn2);
                }
                zzkw zzkw = new zzkw(zzn2.zza, zzku.zze, zzku.zza, zzku.zzb, zzc2);
                this.zzk.zzq().zzw().zza("Setting user property", this.zzk.zzi().zzc(zzkw.zzc), zzc2);
                zze().zze();
                try {
                    zzc(zzn2);
                    boolean zza5 = zze().zza(zzkw);
                    zze().b_();
                    if (!zza5) {
                        this.zzk.zzq().zze().zza("Too many unique user properties are set. Ignoring user property", this.zzk.zzi().zzc(zzkw.zzc), zzkw.zze);
                        this.zzk.zzh().zza(this.zzaa, zzn2.zza, 9, (String) null, (String) null, 0);
                    }
                } finally {
                    zze().zzg();
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzb(zzku zzku, zzn zzn2) {
        zzx();
        zzn();
        if (zze(zzn2)) {
            if (!zzn2.zzh) {
                zzc(zzn2);
            } else if (!"_npa".equals(zzku.zza) || zzn2.zzs == null) {
                this.zzk.zzq().zzv().zza("Removing user property", this.zzk.zzi().zzc(zzku.zza));
                zze().zze();
                try {
                    zzc(zzn2);
                    zze().zzb(zzn2.zza, zzku.zza);
                    zze().b_();
                    this.zzk.zzq().zzv().zza("User property removed", this.zzk.zzi().zzc(zzku.zza));
                } finally {
                    zze().zzg();
                }
            } else {
                this.zzk.zzq().zzv().zza("Falling back to manifest metadata value for ad personalization");
                zza(new zzku("_npa", this.zzk.zzl().currentTimeMillis(), Long.valueOf(zzn2.zzs.booleanValue() ? 1 : 0), DebugKt.DEBUG_PROPERTY_VALUE_AUTO), zzn2);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void zza(zzki zzki) {
        this.zzp++;
    }

    /* access modifiers changed from: package-private */
    public final void zzs() {
        this.zzq++;
    }

    /* access modifiers changed from: package-private */
    public final zzfu zzu() {
        return this.zzk;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:150:0x0482  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x011b A[Catch:{ all -> 0x04ae }] */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x01d2  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x020c  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x022f  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x0235  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x0242  */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x0255  */
    public final void zzb(zzn zzn2) {
        String str;
        int i;
        zzf zzb2;
        String str2;
        zzam zzam;
        long j;
        long j2;
        PackageInfo packageInfo;
        String str3;
        ApplicationInfo applicationInfo;
        boolean z;
        boolean z2;
        zzx();
        zzn();
        Preconditions.checkNotNull(zzn2);
        Preconditions.checkNotEmpty(zzn2.zza);
        if (zze(zzn2)) {
            zzf zzb3 = zze().zzb(zzn2.zza);
            if (zzb3 != null && TextUtils.isEmpty(zzb3.zze()) && !TextUtils.isEmpty(zzn2.zzb)) {
                zzb3.zzh(0);
                zze().zza(zzb3);
                zzc().zzd(zzn2.zza);
            }
            if (!zzn2.zzh) {
                zzc(zzn2);
                return;
            }
            long j3 = zzn2.zzm;
            if (j3 == 0) {
                j3 = this.zzk.zzl().currentTimeMillis();
            }
            this.zzk.zzw().zzh();
            int i2 = zzn2.zzn;
            if (!(i2 == 0 || i2 == 1)) {
                this.zzk.zzq().zzh().zza("Incorrect app type, assuming installed app. appId, appType", zzeq.zza(zzn2.zza), Integer.valueOf(i2));
                i2 = 0;
            }
            zze().zze();
            try {
                zzkw zzc2 = zze().zzc(zzn2.zza, "_npa");
                if (zzc2 != null) {
                    if (!DebugKt.DEBUG_PROPERTY_VALUE_AUTO.equals(zzc2.zzb)) {
                        str = "_sysu";
                        i = 1;
                        zzb2 = zze().zzb(zzn2.zza);
                        if (zzb2 != null) {
                            this.zzk.zzh();
                            if (zzkv.zza(zzn2.zzb, zzb2.zze(), zzn2.zzr, zzb2.zzf())) {
                                this.zzk.zzq().zzh().zza("New GMP App Id passed in. Removing cached database data. appId", zzeq.zza(zzb2.zzc()));
                                zzaf zze2 = zze();
                                String zzc3 = zzb2.zzc();
                                zze2.zzaj();
                                zze2.zzc();
                                Preconditions.checkNotEmpty(zzc3);
                                try {
                                    SQLiteDatabase c_ = zze2.c_();
                                    String[] strArr = new String[i];
                                    strArr[0] = zzc3;
                                    int delete = c_.delete("events", "app_id=?", strArr) + 0 + c_.delete("user_attributes", "app_id=?", strArr) + c_.delete("conditional_properties", "app_id=?", strArr) + c_.delete("apps", "app_id=?", strArr) + c_.delete("raw_events", "app_id=?", strArr) + c_.delete("raw_events_metadata", "app_id=?", strArr) + c_.delete("event_filters", "app_id=?", strArr) + c_.delete("property_filters", "app_id=?", strArr) + c_.delete("audience_filter_values", "app_id=?", strArr) + c_.delete("consent_settings", "app_id=?", strArr);
                                    if (delete > 0) {
                                        zze2.zzq().zzw().zza("Deleted application data. app, records", zzc3, Integer.valueOf(delete));
                                    }
                                } catch (SQLiteException e) {
                                    zze2.zzq().zze().zza("Error deleting application data. appId, error", zzeq.zza(zzc3), e);
                                }
                                zzb2 = null;
                            }
                        }
                        if (zzb2 == null) {
                            if (zzb2.zzm() != -2147483648L) {
                                str2 = "_sys";
                                if (zzb2.zzm() != zzn2.zzj) {
                                    z2 = true;
                                    if (z2 || ((zzb2.zzm() == -2147483648L || zzb2.zzl() == null || zzb2.zzl().equals(zzn2.zzc)) ? false : true)) {
                                        Bundle bundle = new Bundle();
                                        bundle.putString("_pv", zzb2.zzl());
                                        zza(new zzaq("_au", new zzap(bundle), DebugKt.DEBUG_PROPERTY_VALUE_AUTO, j3), zzn2);
                                    }
                                }
                            } else {
                                str2 = "_sys";
                            }
                            z2 = false;
                            if (z2 || ((zzb2.zzm() == -2147483648L || zzb2.zzl() == null || zzb2.zzl().equals(zzn2.zzc)) ? false : true)) {
                            }
                        } else {
                            str2 = "_sys";
                        }
                        zzc(zzn2);
                        if (i2 != 0) {
                            zzam = zze().zza(zzn2.zza, "_f");
                        } else {
                            zzam = i2 == 1 ? zze().zza(zzn2.zza, "_v") : null;
                        }
                        if (zzam != null) {
                            long j4 = ((j3 / 3600000) + 1) * 3600000;
                            if (i2 == 0) {
                                zza(new zzku("_fot", j3, Long.valueOf(j4), DebugKt.DEBUG_PROPERTY_VALUE_AUTO), zzn2);
                                zzx();
                                this.zzk.zze().zza(zzn2.zza);
                                zzx();
                                zzn();
                                Bundle bundle2 = new Bundle();
                                bundle2.putLong("_c", 1);
                                bundle2.putLong("_r", 1);
                                bundle2.putLong("_uwa", 0);
                                bundle2.putLong("_pfo", 0);
                                bundle2.putLong(str2, 0);
                                bundle2.putLong(str, 0);
                                if (this.zzk.zza().zze(zzn2.zza, zzas.zzas)) {
                                    j2 = 1;
                                    bundle2.putLong("_et", 1);
                                } else {
                                    j2 = 1;
                                }
                                if (zzn2.zzq) {
                                    bundle2.putLong("_dac", j2);
                                }
                                zzaf zze3 = zze();
                                String str4 = zzn2.zza;
                                Preconditions.checkNotEmpty(str4);
                                zze3.zzc();
                                zze3.zzaj();
                                long zzh2 = zze3.zzh(str4, "first_open_count");
                                if (this.zzk.zzm().getPackageManager() == null) {
                                    this.zzk.zzq().zze().zza("PackageManager is null, first open report might be inaccurate. appId", zzeq.zza(zzn2.zza));
                                } else {
                                    try {
                                        packageInfo = Wrappers.packageManager(this.zzk.zzm()).getPackageInfo(zzn2.zza, 0);
                                    } catch (PackageManager.NameNotFoundException e2) {
                                        this.zzk.zzq().zze().zza("Package info is null, first open report might be inaccurate. appId", zzeq.zza(zzn2.zza), e2);
                                        packageInfo = null;
                                    }
                                    if (packageInfo == null || packageInfo.firstInstallTime == 0) {
                                        str3 = str;
                                    } else {
                                        if (packageInfo.firstInstallTime != packageInfo.lastUpdateTime) {
                                            if (!this.zzk.zza().zza(zzas.zzbm)) {
                                                bundle2.putLong("_uwa", 1);
                                            } else if (zzh2 == 0) {
                                                bundle2.putLong("_uwa", 1);
                                            }
                                            z = false;
                                        } else {
                                            z = true;
                                        }
                                        str3 = str;
                                        zza(new zzku("_fi", j3, Long.valueOf(z ? 1 : 0), DebugKt.DEBUG_PROPERTY_VALUE_AUTO), zzn2);
                                    }
                                    try {
                                        applicationInfo = Wrappers.packageManager(this.zzk.zzm()).getApplicationInfo(zzn2.zza, 0);
                                    } catch (PackageManager.NameNotFoundException e3) {
                                        this.zzk.zzq().zze().zza("Application info is null, first open report might be inaccurate. appId", zzeq.zza(zzn2.zza), e3);
                                        applicationInfo = null;
                                    }
                                    if (applicationInfo != null) {
                                        if ((applicationInfo.flags & 1) != 0) {
                                            bundle2.putLong(str2, 1);
                                        }
                                        if ((applicationInfo.flags & 128) != 0) {
                                            bundle2.putLong(str3, 1);
                                        }
                                    }
                                }
                                if (zzh2 >= 0) {
                                    bundle2.putLong("_pfo", zzh2);
                                }
                                zzb(new zzaq("_f", new zzap(bundle2), DebugKt.DEBUG_PROPERTY_VALUE_AUTO, j3), zzn2);
                            } else if (i2 == 1) {
                                zza(new zzku("_fvt", j3, Long.valueOf(j4), DebugKt.DEBUG_PROPERTY_VALUE_AUTO), zzn2);
                                zzx();
                                zzn();
                                Bundle bundle3 = new Bundle();
                                bundle3.putLong("_c", 1);
                                bundle3.putLong("_r", 1);
                                if (this.zzk.zza().zze(zzn2.zza, zzas.zzas)) {
                                    j = 1;
                                    bundle3.putLong("_et", 1);
                                } else {
                                    j = 1;
                                }
                                if (zzn2.zzq) {
                                    bundle3.putLong("_dac", j);
                                }
                                zzb(new zzaq("_v", new zzap(bundle3), DebugKt.DEBUG_PROPERTY_VALUE_AUTO, j3), zzn2);
                            }
                            if (!this.zzk.zza().zze(zzn2.zza, zzas.zzat)) {
                                Bundle bundle4 = new Bundle();
                                bundle4.putLong("_et", 1);
                                if (this.zzk.zza().zze(zzn2.zza, zzas.zzas)) {
                                    bundle4.putLong("_fr", 1);
                                }
                                zzb(new zzaq("_e", new zzap(bundle4), DebugKt.DEBUG_PROPERTY_VALUE_AUTO, j3), zzn2);
                            }
                        } else if (zzn2.zzi) {
                            zzb(new zzaq("_cd", new zzap(new Bundle()), DebugKt.DEBUG_PROPERTY_VALUE_AUTO, j3), zzn2);
                        }
                        zze().b_();
                    }
                }
                if (zzn2.zzs != null) {
                    str = "_sysu";
                    i = 1;
                    zzku zzku = new zzku("_npa", j3, Long.valueOf(zzn2.zzs.booleanValue() ? 1 : 0), DebugKt.DEBUG_PROPERTY_VALUE_AUTO);
                    if (zzc2 == null || !zzc2.zze.equals(zzku.zzc)) {
                        zza(zzku, zzn2);
                    }
                } else {
                    str = "_sysu";
                    i = 1;
                    if (zzc2 != null) {
                        zzb(new zzku("_npa", j3, null, DebugKt.DEBUG_PROPERTY_VALUE_AUTO), zzn2);
                    }
                }
                zzb2 = zze().zzb(zzn2.zza);
                if (zzb2 != null) {
                }
                if (zzb2 == null) {
                }
                zzc(zzn2);
                if (i2 != 0) {
                }
                if (zzam != null) {
                }
                zze().b_();
            } finally {
                zze().zzg();
            }
        }
    }

    private final zzn zzb(String str) {
        zzf zzb2 = zze().zzb(str);
        if (zzb2 == null || TextUtils.isEmpty(zzb2.zzl())) {
            this.zzk.zzq().zzv().zza("No app data available; dropping", str);
            return null;
        }
        Boolean zzb3 = zzb(zzb2);
        if (zzb3 == null || zzb3.booleanValue()) {
            return new zzn(str, zzb2.zze(), zzb2.zzl(), zzb2.zzm(), zzb2.zzn(), zzb2.zzo(), zzb2.zzp(), (String) null, zzb2.zzr(), false, zzb2.zzi(), zzb2.zzae(), 0L, 0, zzb2.zzaf(), zzb2.zzag(), false, zzb2.zzf(), zzb2.zzah(), zzb2.zzq(), zzb2.zzai(), (!zznv.zzb() || !this.zzk.zza().zze(str, zzas.zzbi)) ? null : zzb2.zzg(), (!zzml.zzb() || !this.zzk.zza().zza(zzas.zzci)) ? "" : zza(str).zza());
        }
        this.zzk.zzq().zze().zza("App version does not match; dropping. appId", zzeq.zza(str));
        return null;
    }

    /* access modifiers changed from: package-private */
    public final void zza(zzz zzz2) {
        zzn zzb2 = zzb(zzz2.zza);
        if (zzb2 != null) {
            zza(zzz2, zzb2);
        }
    }

    /* access modifiers changed from: package-private */
    public final void zza(zzz zzz2, zzn zzn2) {
        Preconditions.checkNotNull(zzz2);
        Preconditions.checkNotEmpty(zzz2.zza);
        Preconditions.checkNotNull(zzz2.zzb);
        Preconditions.checkNotNull(zzz2.zzc);
        Preconditions.checkNotEmpty(zzz2.zzc.zza);
        zzx();
        zzn();
        if (zze(zzn2)) {
            if (!zzn2.zzh) {
                zzc(zzn2);
                return;
            }
            zzz zzz3 = new zzz(zzz2);
            boolean z = false;
            zzz3.zze = false;
            zze().zze();
            try {
                zzz zzd2 = zze().zzd(zzz3.zza, zzz3.zzc.zza);
                if (zzd2 != null && !zzd2.zzb.equals(zzz3.zzb)) {
                    this.zzk.zzq().zzh().zza("Updating a conditional user property with different origin. name, origin, origin (from DB)", this.zzk.zzi().zzc(zzz3.zzc.zza), zzz3.zzb, zzd2.zzb);
                }
                if (zzd2 != null && zzd2.zze) {
                    zzz3.zzb = zzd2.zzb;
                    zzz3.zzd = zzd2.zzd;
                    zzz3.zzh = zzd2.zzh;
                    zzz3.zzf = zzd2.zzf;
                    zzz3.zzi = zzd2.zzi;
                    zzz3.zze = zzd2.zze;
                    zzz3.zzc = new zzku(zzz3.zzc.zza, zzd2.zzc.zzb, zzz3.zzc.zza(), zzd2.zzc.zze);
                } else if (TextUtils.isEmpty(zzz3.zzf)) {
                    zzz3.zzc = new zzku(zzz3.zzc.zza, zzz3.zzd, zzz3.zzc.zza(), zzz3.zzc.zze);
                    zzz3.zze = true;
                    z = true;
                }
                if (zzz3.zze) {
                    zzku zzku = zzz3.zzc;
                    zzkw zzkw = new zzkw(zzz3.zza, zzz3.zzb, zzku.zza, zzku.zzb, zzku.zza());
                    if (zze().zza(zzkw)) {
                        this.zzk.zzq().zzv().zza("User property updated immediately", zzz3.zza, this.zzk.zzi().zzc(zzkw.zzc), zzkw.zze);
                    } else {
                        this.zzk.zzq().zze().zza("(2)Too many active user properties, ignoring", zzeq.zza(zzz3.zza), this.zzk.zzi().zzc(zzkw.zzc), zzkw.zze);
                    }
                    if (z && zzz3.zzi != null) {
                        zzc(new zzaq(zzz3.zzi, zzz3.zzd), zzn2);
                    }
                }
                if (zze().zza(zzz3)) {
                    this.zzk.zzq().zzv().zza("Conditional property added", zzz3.zza, this.zzk.zzi().zzc(zzz3.zzc.zza), zzz3.zzc.zza());
                } else {
                    this.zzk.zzq().zze().zza("Too many conditional properties, ignoring", zzeq.zza(zzz3.zza), this.zzk.zzi().zzc(zzz3.zzc.zza), zzz3.zzc.zza());
                }
                zze().b_();
            } finally {
                zze().zzg();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzb(zzz zzz2) {
        zzn zzb2 = zzb(zzz2.zza);
        if (zzb2 != null) {
            zzb(zzz2, zzb2);
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzb(zzz zzz2, zzn zzn2) {
        Preconditions.checkNotNull(zzz2);
        Preconditions.checkNotEmpty(zzz2.zza);
        Preconditions.checkNotNull(zzz2.zzc);
        Preconditions.checkNotEmpty(zzz2.zzc.zza);
        zzx();
        zzn();
        if (zze(zzn2)) {
            if (!zzn2.zzh) {
                zzc(zzn2);
                return;
            }
            zze().zze();
            try {
                zzc(zzn2);
                zzz zzd2 = zze().zzd(zzz2.zza, zzz2.zzc.zza);
                if (zzd2 != null) {
                    this.zzk.zzq().zzv().zza("Removing conditional user property", zzz2.zza, this.zzk.zzi().zzc(zzz2.zzc.zza));
                    zze().zze(zzz2.zza, zzz2.zzc.zza);
                    if (zzd2.zze) {
                        zze().zzb(zzz2.zza, zzz2.zzc.zza);
                    }
                    if (zzz2.zzk != null) {
                        Bundle bundle = null;
                        if (zzz2.zzk.zzb != null) {
                            bundle = zzz2.zzk.zzb.zzb();
                        }
                        zzc(this.zzk.zzh().zza(zzz2.zza, zzz2.zzk.zza, bundle, zzd2.zzb, zzz2.zzk.zzd, true, false, zzlo.zzb() && this.zzk.zza().zza(zzas.zzcl)), zzn2);
                    }
                } else {
                    this.zzk.zzq().zzh().zza("Conditional user property doesn't exist", zzeq.zza(zzz2.zza), this.zzk.zzi().zzc(zzz2.zzc.zza));
                }
                zze().b_();
            } finally {
                zze().zzg();
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:102:0x0214  */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x0222  */
    /* JADX WARNING: Removed duplicated region for block: B:113:0x0241  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00f4  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0106  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x018c  */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x01b2  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x01c0  */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x0206  */
    private final zzf zza(zzn zzn2, zzf zzf2, String str) {
        boolean z;
        zzac zzac = zzac.zza;
        if (zzml.zzb() && this.zzk.zza().zza(zzas.zzci)) {
            zzac = zza(zzn2.zza).zzb(zzac.zza(zzn2.zzw));
        }
        boolean z2 = true;
        if (zzf2 == null) {
            zzf2 = new zzf(this.zzk, zzn2.zza);
            if (!zzml.zzb() || !this.zzk.zza().zza(zzas.zzci)) {
                zzf2.zza(zzz());
                zzf2.zze(str);
            } else {
                if (zzac.zze()) {
                    zzf2.zza(zza(zzac));
                }
                if (zzac.zzc()) {
                    zzf2.zze(str);
                }
            }
        } else if ((!zzml.zzb() || !this.zzk.zza().zza(zzas.zzci) || zzac.zzc()) && !str.equals(zzf2.zzh())) {
            zzf2.zze(str);
            if (!zzml.zzb() || !this.zzk.zza().zza(zzas.zzci)) {
                zzf2.zza(zzz());
            } else if (zzac.zze()) {
                zzf2.zza(zza(zzac));
            }
        } else if (!zzml.zzb() || !this.zzk.zza().zza(zzas.zzci) || !TextUtils.isEmpty(zzf2.zzd()) || !zzac.zze()) {
            z = false;
            if (!TextUtils.equals(zzn2.zzb, zzf2.zze())) {
                zzf2.zzb(zzn2.zzb);
                z = true;
            }
            if (!TextUtils.equals(zzn2.zzr, zzf2.zzf())) {
                zzf2.zzc(zzn2.zzr);
                z = true;
            }
            if (zznv.zzb() && this.zzk.zza().zze(zzf2.zzc(), zzas.zzbi) && !TextUtils.equals(zzn2.zzv, zzf2.zzg())) {
                zzf2.zzd(zzn2.zzv);
                z = true;
            }
            if (!TextUtils.isEmpty(zzn2.zzk) && !zzn2.zzk.equals(zzf2.zzi())) {
                zzf2.zzf(zzn2.zzk);
                z = true;
            }
            if (!(zzn2.zze == 0 || zzn2.zze == zzf2.zzo())) {
                zzf2.zzd(zzn2.zze);
                z = true;
            }
            if (!TextUtils.isEmpty(zzn2.zzc) && !zzn2.zzc.equals(zzf2.zzl())) {
                zzf2.zzg(zzn2.zzc);
                z = true;
            }
            if (zzn2.zzj != zzf2.zzm()) {
                zzf2.zzc(zzn2.zzj);
                z = true;
            }
            if (zzn2.zzd != null && !zzn2.zzd.equals(zzf2.zzn())) {
                zzf2.zzh(zzn2.zzd);
                z = true;
            }
            if (zzn2.zzf != zzf2.zzp()) {
                zzf2.zze(zzn2.zzf);
                z = true;
            }
            if (zzn2.zzh != zzf2.zzr()) {
                zzf2.zza(zzn2.zzh);
                z = true;
            }
            if (!TextUtils.isEmpty(zzn2.zzg) && !zzn2.zzg.equals(zzf2.zzac())) {
                zzf2.zzi(zzn2.zzg);
                z = true;
            }
            if (!this.zzk.zza().zza(zzas.zzbx) && zzn2.zzl != zzf2.zzae()) {
                zzf2.zzp(zzn2.zzl);
                z = true;
            }
            if (zzn2.zzo != zzf2.zzaf()) {
                zzf2.zzb(zzn2.zzo);
                z = true;
            }
            if (zzn2.zzp != zzf2.zzag()) {
                zzf2.zzc(zzn2.zzp);
                z = true;
            }
            if (zzn2.zzs != zzf2.zzah()) {
                zzf2.zza(zzn2.zzs);
                z = true;
            }
            if (zzn2.zzt != 0 || zzn2.zzt == zzf2.zzq()) {
                z2 = z;
            } else {
                zzf2.zzf(zzn2.zzt);
            }
            if (z2) {
                zze().zza(zzf2);
            }
            return zzf2;
        } else {
            zzf2.zza(zza(zzac));
        }
        z = true;
        if (!TextUtils.equals(zzn2.zzb, zzf2.zze())) {
        }
        if (!TextUtils.equals(zzn2.zzr, zzf2.zzf())) {
        }
        zzf2.zzd(zzn2.zzv);
        z = true;
        zzf2.zzf(zzn2.zzk);
        z = true;
        zzf2.zzd(zzn2.zze);
        z = true;
        zzf2.zzg(zzn2.zzc);
        z = true;
        if (zzn2.zzj != zzf2.zzm()) {
        }
        zzf2.zzh(zzn2.zzd);
        z = true;
        if (zzn2.zzf != zzf2.zzp()) {
        }
        if (zzn2.zzh != zzf2.zzr()) {
        }
        zzf2.zzi(zzn2.zzg);
        z = true;
        zzf2.zzp(zzn2.zzl);
        z = true;
        if (zzn2.zzo != zzf2.zzaf()) {
        }
        if (zzn2.zzp != zzf2.zzag()) {
        }
        if (zzn2.zzs != zzf2.zzah()) {
        }
        if (zzn2.zzt != 0) {
        }
        z2 = z;
        if (z2) {
        }
        return zzf2;
    }

    /* access modifiers changed from: package-private */
    public final zzf zzc(zzn zzn2) {
        String str;
        zzx();
        zzn();
        Preconditions.checkNotNull(zzn2);
        Preconditions.checkNotEmpty(zzn2.zza);
        zzf zzb2 = zze().zzb(zzn2.zza);
        zzac zzac = zzac.zza;
        if (zzml.zzb() && this.zzk.zza().zza(zzas.zzci)) {
            zzac = zza(zzn2.zza).zzb(zzac.zza(zzn2.zzw));
        }
        if (!zzml.zzb() || !this.zzk.zza().zza(zzas.zzci) || zzac.zzc()) {
            str = this.zzj.zza(zzn2.zza);
        } else {
            str = "";
        }
        if (!zzne.zzb() || !this.zzk.zza().zza(zzas.zzbn)) {
            return zza(zzn2, zzb2, str);
        }
        if (zzb2 == null) {
            zzb2 = new zzf(this.zzk, zzn2.zza);
            if (!zzml.zzb() || !this.zzk.zza().zza(zzas.zzci)) {
                zzb2.zza(zzz());
                zzb2.zze(str);
            } else {
                if (zzac.zze()) {
                    zzb2.zza(zza(zzac));
                }
                if (zzac.zzc()) {
                    zzb2.zze(str);
                }
            }
        } else if ((!zzml.zzb() || !this.zzk.zza().zza(zzas.zzci) || zzac.zzc()) && !str.equals(zzb2.zzh())) {
            zzb2.zze(str);
            if (!zzml.zzb() || !this.zzk.zza().zza(zzas.zzci)) {
                zzb2.zza(zzz());
            } else {
                zzb2.zza(zza(zzac));
            }
        } else if (zzml.zzb() && this.zzk.zza().zza(zzas.zzci) && TextUtils.isEmpty(zzb2.zzd()) && zzac.zze()) {
            zzb2.zza(zza(zzac));
        }
        zzb2.zzb(zzn2.zzb);
        zzb2.zzc(zzn2.zzr);
        if (zznv.zzb() && this.zzk.zza().zze(zzb2.zzc(), zzas.zzbi)) {
            zzb2.zzd(zzn2.zzv);
        }
        if (!TextUtils.isEmpty(zzn2.zzk)) {
            zzb2.zzf(zzn2.zzk);
        }
        if (zzn2.zze != 0) {
            zzb2.zzd(zzn2.zze);
        }
        if (!TextUtils.isEmpty(zzn2.zzc)) {
            zzb2.zzg(zzn2.zzc);
        }
        zzb2.zzc(zzn2.zzj);
        if (zzn2.zzd != null) {
            zzb2.zzh(zzn2.zzd);
        }
        zzb2.zze(zzn2.zzf);
        zzb2.zza(zzn2.zzh);
        if (!TextUtils.isEmpty(zzn2.zzg)) {
            zzb2.zzi(zzn2.zzg);
        }
        if (!this.zzk.zza().zza(zzas.zzbx)) {
            zzb2.zzp(zzn2.zzl);
        }
        zzb2.zzb(zzn2.zzo);
        zzb2.zzc(zzn2.zzp);
        zzb2.zza(zzn2.zzs);
        zzb2.zzf(zzn2.zzt);
        if (zzb2.zza()) {
            zze().zza(zzb2);
        }
        return zzb2;
    }

    /* access modifiers changed from: package-private */
    public final String zzd(zzn zzn2) {
        try {
            return (String) this.zzk.zzp().zza(new zzkp(this, zzn2)).get(30000, TimeUnit.MILLISECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            this.zzk.zzq().zze().zza("Failed to get app instance id. appId", zzeq.zza(zzn2.zza), e);
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public final void zza(boolean z) {
        zzab();
    }

    private final boolean zze(zzn zzn2) {
        return (!zznv.zzb() || !this.zzk.zza().zze(zzn2.zza, zzas.zzbi)) ? !TextUtils.isEmpty(zzn2.zzb) || !TextUtils.isEmpty(zzn2.zzr) : !TextUtils.isEmpty(zzn2.zzb) || !TextUtils.isEmpty(zzn2.zzv) || !TextUtils.isEmpty(zzn2.zzr);
    }
}
