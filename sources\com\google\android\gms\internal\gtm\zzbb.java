package com.google.android.gms.internal.gtm;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Pair;
import com.digitalwallet.utilities.DateFormattingHelper;
import com.google.android.gms.analytics.CampaignTrackingReceiver;
import com.google.android.gms.analytics.zza;
import com.google.android.gms.analytics.zzg;
import com.google.android.gms.analytics.zzk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.firebase.messaging.Constants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* access modifiers changed from: package-private */
public final class zzbb extends zzan {
    private boolean started;
    private final zzay zzxp;
    private final zzck zzxq;
    private final zzcj zzxr;
    private final zzat zzxs;
    private long zzxt = Long.MIN_VALUE;
    private final zzbs zzxu;
    private final zzbs zzxv;
    private final zzcv zzxw;
    private long zzxx;
    private boolean zzxy;

    protected zzbb(zzap zzap, zzar zzar) {
        super(zzap);
        Preconditions.checkNotNull(zzar);
        this.zzxr = new zzcj(zzap);
        this.zzxp = new zzay(zzap);
        this.zzxq = new zzck(zzap);
        this.zzxs = new zzat(zzap);
        this.zzxw = new zzcv(zzcn());
        this.zzxu = new zzbc(this, zzap);
        this.zzxv = new zzbd(this, zzap);
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.gtm.zzan
    public final void zzaw() {
        this.zzxp.zzag();
        this.zzxq.zzag();
        this.zzxs.zzag();
    }

    /* access modifiers changed from: package-private */
    public final void start() {
        zzdb();
        Preconditions.checkState(!this.started, "Analytics backend already started");
        this.started = true;
        zzcq().zza(new zzbe(this));
    }

    private final boolean zzx(String str) {
        return Wrappers.packageManager(getContext()).checkCallingOrSelfPermission(str) == 0;
    }

    /* access modifiers changed from: protected */
    public final void zzdw() {
        zzdb();
        zzk.zzav();
        Context context = zzcm().getContext();
        if (!zzcp.zza(context)) {
            zzt("AnalyticsReceiver is not registered or is disabled. Register the receiver for reliable dispatching on non-Google Play devices. See http://goo.gl/8Rd3yj for instructions.");
        } else if (!zzcq.zze(context)) {
            zzu("AnalyticsService is not registered or is disabled. Analytics service at risk of not starting. See http://goo.gl/8Rd3yj for instructions.");
        }
        if (!CampaignTrackingReceiver.zza(context)) {
            zzt("CampaignTrackingReceiver is not registered, not exported or is disabled. Installation campaign tracking is not possible. See http://goo.gl/8Rd3yj for instructions.");
        }
        zzcv().zzfv();
        if (!zzx("android.permission.ACCESS_NETWORK_STATE")) {
            zzu("Missing required android.permission.ACCESS_NETWORK_STATE. Google Analytics disabled. See http://goo.gl/8Rd3yj for instructions");
            zzeg();
        }
        if (!zzx("android.permission.INTERNET")) {
            zzu("Missing required android.permission.INTERNET. Google Analytics disabled. See http://goo.gl/8Rd3yj for instructions");
            zzeg();
        }
        if (zzcq.zze(getContext())) {
            zzq("AnalyticsService registered in the app manifest and enabled");
        } else {
            zzt("AnalyticsService not registered in the app manifest. Hits might not be delivered reliably. See http://goo.gl/8Rd3yj for instructions.");
        }
        if (!this.zzxy && !this.zzxp.isEmpty()) {
            zzdz();
        }
        zzec();
    }

    /* access modifiers changed from: private */
    public final void zzdx() {
        zzb((zzbw) new zzbf(this));
    }

    /* access modifiers changed from: package-private */
    public final void zzcl() {
        zzk.zzav();
        this.zzxx = zzcn().currentTimeMillis();
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0044 A[LOOP:1: B:15:0x0044->B:23:?, LOOP_START] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0040 A[SYNTHETIC] */
    public final void onServiceConnected() {
        zzk.zzav();
        zzk.zzav();
        zzdb();
        if (!zzbq.zzen()) {
            zzt("Service client disabled. Can't dispatch local hits to device AnalyticsService");
        }
        if (!this.zzxs.isConnected()) {
            zzq("Service not connected");
        } else if (!this.zzxp.isEmpty()) {
            zzq("Dispatching local hits to device AnalyticsService");
            while (true) {
                try {
                    List<zzcd> zzd = this.zzxp.zzd((long) zzbq.zzer());
                    if (!zzd.isEmpty()) {
                        zzec();
                        return;
                    }
                    while (true) {
                        if (!zzd.isEmpty()) {
                            zzcd zzcd = zzd.get(0);
                            if (!this.zzxs.zzb(zzcd)) {
                                zzec();
                                return;
                            }
                            zzd.remove(zzcd);
                            try {
                                this.zzxp.zze(zzcd.zzfg());
                            } catch (SQLiteException e) {
                                zze("Failed to remove hit that was send for delivery", e);
                                zzee();
                                return;
                            }
                        }
                    }
                    List<zzcd> zzd2 = this.zzxp.zzd((long) zzbq.zzer());
                    if (!zzd2.isEmpty()) {
                    }
                } catch (SQLiteException e2) {
                    zze("Failed to read hits from store", e2);
                    zzee();
                    return;
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public final void zzdy() {
        try {
            this.zzxp.zzdr();
            zzec();
        } catch (SQLiteException e) {
            zzd("Failed to delete stale hits", e);
        }
        this.zzxv.zzh(DateFormattingHelper.DAY_IN_MS);
    }

    /* access modifiers changed from: protected */
    public final void zzb(zzas zzas) {
        zzk.zzav();
        zzb("Sending first hit to property", zzas.zzdj());
        if (!zzcv().zzfw().zzj(zzbq.zzex())) {
            String zzfz = zzcv().zzfz();
            if (!TextUtils.isEmpty(zzfz)) {
                zzr zza = zzcz.zza(zzco(), zzfz);
                zzb("Found relevant installation campaign", zza);
                zza(zzas, zza);
            }
        }
    }

    public final void zzg(long j) {
        zzk.zzav();
        zzdb();
        if (j < 0) {
            j = 0;
        }
        this.zzxt = j;
        zzec();
    }

    private final void zzdz() {
        if (!this.zzxy && zzbq.zzen() && !this.zzxs.isConnected()) {
            if (this.zzxw.zzj(zzby.zzaan.get().longValue())) {
                this.zzxw.start();
                zzq("Connecting to service");
                if (this.zzxs.connect()) {
                    zzq("Connected to service");
                    this.zzxw.clear();
                    onServiceConnected();
                }
            }
        }
    }

    public final long zza(zzas zzas, boolean z) {
        Preconditions.checkNotNull(zzas);
        zzdb();
        zzk.zzav();
        try {
            this.zzxp.beginTransaction();
            zzay zzay = this.zzxp;
            long zzdi = zzas.zzdi();
            String zzbt = zzas.zzbt();
            Preconditions.checkNotEmpty(zzbt);
            zzay.zzdb();
            zzk.zzav();
            int i = 0;
            int delete = zzay.getWritableDatabase().delete("properties", "app_uid=? AND cid<>?", new String[]{String.valueOf(zzdi), zzbt});
            if (delete > 0) {
                zzay.zza("Deleted property records", Integer.valueOf(delete));
            }
            long zza = this.zzxp.zza(zzas.zzdi(), zzas.zzbt(), zzas.zzdj());
            zzas.zzb(1 + zza);
            zzay zzay2 = this.zzxp;
            Preconditions.checkNotNull(zzas);
            zzay2.zzdb();
            zzk.zzav();
            SQLiteDatabase writableDatabase = zzay2.getWritableDatabase();
            Map<String, String> zzdm = zzas.zzdm();
            Preconditions.checkNotNull(zzdm);
            Uri.Builder builder = new Uri.Builder();
            for (Map.Entry<String, String> entry : zzdm.entrySet()) {
                builder.appendQueryParameter(entry.getKey(), entry.getValue());
            }
            String encodedQuery = builder.build().getEncodedQuery();
            if (encodedQuery == null) {
                encodedQuery = "";
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("app_uid", Long.valueOf(zzas.zzdi()));
            contentValues.put("cid", zzas.zzbt());
            contentValues.put("tid", zzas.zzdj());
            if (zzas.zzdk()) {
                i = 1;
            }
            contentValues.put("adid", Integer.valueOf(i));
            contentValues.put("hits_count", Long.valueOf(zzas.zzdl()));
            contentValues.put("params", encodedQuery);
            try {
                if (writableDatabase.insertWithOnConflict("properties", null, contentValues, 5) == -1) {
                    zzay2.zzu("Failed to insert/update a property (got -1)");
                }
            } catch (SQLiteException e) {
                zzay2.zze("Error storing a property", e);
            }
            this.zzxp.setTransactionSuccessful();
            try {
                this.zzxp.endTransaction();
            } catch (SQLiteException e2) {
                zze("Failed to end transaction", e2);
            }
            return zza;
        } catch (SQLiteException e3) {
            zze("Failed to update Analytics property", e3);
            try {
                this.zzxp.endTransaction();
            } catch (SQLiteException e4) {
                zze("Failed to end transaction", e4);
            }
            return -1;
        } catch (Throwable th) {
            try {
                this.zzxp.endTransaction();
            } catch (SQLiteException e5) {
                zze("Failed to end transaction", e5);
            }
            throw th;
        }
    }

    public final void zza(zzcd zzcd) {
        Pair<String, Long> zzgc;
        Preconditions.checkNotNull(zzcd);
        zzk.zzav();
        zzdb();
        if (this.zzxy) {
            zzr("Hit delivery not possible. Missing network permissions. See http://goo.gl/8Rd3yj for instructions");
        } else {
            zza("Delivering hit", zzcd);
        }
        if (TextUtils.isEmpty(zzcd.zzfl()) && (zzgc = zzcv().zzga().zzgc()) != null) {
            String str = (String) zzgc.first;
            String valueOf = String.valueOf((Long) zzgc.second);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 1 + String.valueOf(str).length());
            sb.append(valueOf);
            sb.append(":");
            sb.append(str);
            String sb2 = sb.toString();
            HashMap hashMap = new HashMap(zzcd.zzdm());
            hashMap.put("_m", sb2);
            zzcd = new zzcd(this, hashMap, zzcd.zzfh(), zzcd.zzfj(), zzcd.zzfg(), zzcd.zzff(), zzcd.zzfi());
        }
        zzdz();
        if (this.zzxs.zzb(zzcd)) {
            zzr("Hit sent to the device AnalyticsService for delivery");
            return;
        }
        try {
            this.zzxp.zzc(zzcd);
            zzec();
        } catch (SQLiteException e) {
            zze("Delivery failed to save hit to a database", e);
            zzco().zza(zzcd, "deliver: failed to insert hit to database");
        }
    }

    public final void zzch() {
        zzk.zzav();
        zzdb();
        zzq("Delete all hits from local store");
        try {
            zzay zzay = this.zzxp;
            zzk.zzav();
            zzay.zzdb();
            zzay.getWritableDatabase().delete("hits2", null, null);
            zzay zzay2 = this.zzxp;
            zzk.zzav();
            zzay2.zzdb();
            zzay2.getWritableDatabase().delete("properties", null, null);
            zzec();
        } catch (SQLiteException e) {
            zzd("Failed to delete hits from store", e);
        }
        zzdz();
        if (this.zzxs.zzdn()) {
            zzq("Device service unavailable. Can't clear hits stored on the device service.");
        }
    }

    private final boolean zzea() {
        zzk.zzav();
        zzdb();
        zzq("Dispatching a batch of local hits");
        boolean z = !this.zzxs.isConnected();
        boolean z2 = !this.zzxq.zzfr();
        if (!z || !z2) {
            long max = (long) Math.max(zzbq.zzer(), zzbq.zzes());
            ArrayList arrayList = new ArrayList();
            long j = 0;
            while (true) {
                try {
                    this.zzxp.beginTransaction();
                    arrayList.clear();
                    try {
                        List<zzcd> zzd = this.zzxp.zzd(max);
                        if (zzd.isEmpty()) {
                            zzq("Store is empty, nothing to dispatch");
                            zzee();
                            try {
                                this.zzxp.setTransactionSuccessful();
                                this.zzxp.endTransaction();
                                return false;
                            } catch (SQLiteException e) {
                                zze("Failed to commit local dispatch transaction", e);
                                zzee();
                                return false;
                            }
                        } else {
                            zza("Hits loaded from store. count", Integer.valueOf(zzd.size()));
                            for (zzcd zzcd : zzd) {
                                if (zzcd.zzfg() == j) {
                                    zzd("Database contains successfully uploaded hit", Long.valueOf(j), Integer.valueOf(zzd.size()));
                                    zzee();
                                    try {
                                        return false;
                                    } catch (SQLiteException e2) {
                                        zze("Failed to commit local dispatch transaction", e2);
                                        zzee();
                                        return false;
                                    }
                                }
                            }
                            if (this.zzxs.isConnected()) {
                                zzq("Service connected, sending hits to the service");
                                while (!zzd.isEmpty()) {
                                    zzcd zzcd2 = zzd.get(0);
                                    if (!this.zzxs.zzb(zzcd2)) {
                                        break;
                                    }
                                    j = Math.max(j, zzcd2.zzfg());
                                    zzd.remove(zzcd2);
                                    zzb("Hit sent do device AnalyticsService for delivery", zzcd2);
                                    try {
                                        this.zzxp.zze(zzcd2.zzfg());
                                        arrayList.add(Long.valueOf(zzcd2.zzfg()));
                                    } catch (SQLiteException e3) {
                                        zze("Failed to remove hit that was send for delivery", e3);
                                        zzee();
                                        try {
                                            this.zzxp.setTransactionSuccessful();
                                            this.zzxp.endTransaction();
                                            return false;
                                        } catch (SQLiteException e4) {
                                            zze("Failed to commit local dispatch transaction", e4);
                                            zzee();
                                            return false;
                                        }
                                    }
                                }
                            }
                            if (this.zzxq.zzfr()) {
                                List<Long> zzb = this.zzxq.zzb(zzd);
                                for (Long l : zzb) {
                                    j = Math.max(j, l.longValue());
                                }
                                try {
                                    this.zzxp.zza(zzb);
                                    arrayList.addAll(zzb);
                                } catch (SQLiteException e5) {
                                    zze("Failed to remove successfully uploaded hits", e5);
                                    zzee();
                                    try {
                                        this.zzxp.setTransactionSuccessful();
                                        this.zzxp.endTransaction();
                                        return false;
                                    } catch (SQLiteException e6) {
                                        zze("Failed to commit local dispatch transaction", e6);
                                        zzee();
                                        return false;
                                    }
                                }
                            }
                            if (arrayList.isEmpty()) {
                                try {
                                    this.zzxp.setTransactionSuccessful();
                                    this.zzxp.endTransaction();
                                    return false;
                                } catch (SQLiteException e7) {
                                    zze("Failed to commit local dispatch transaction", e7);
                                    zzee();
                                    return false;
                                }
                            } else {
                                try {
                                    this.zzxp.setTransactionSuccessful();
                                    this.zzxp.endTransaction();
                                } catch (SQLiteException e8) {
                                    zze("Failed to commit local dispatch transaction", e8);
                                    zzee();
                                    return false;
                                }
                            }
                        }
                    } catch (SQLiteException e9) {
                        zzd("Failed to read hits from persisted store", e9);
                        zzee();
                        try {
                            this.zzxp.setTransactionSuccessful();
                            this.zzxp.endTransaction();
                            return false;
                        } catch (SQLiteException e10) {
                            zze("Failed to commit local dispatch transaction", e10);
                            zzee();
                            return false;
                        }
                    }
                } finally {
                    try {
                        this.zzxp.setTransactionSuccessful();
                        this.zzxp.endTransaction();
                    } catch (SQLiteException e11) {
                        zze("Failed to commit local dispatch transaction", e11);
                        zzee();
                        return false;
                    }
                }
            }
        } else {
            zzq("No network or service available. Will retry later");
            return false;
        }
    }

    public final void zzb(zzbw zzbw) {
        long j = this.zzxx;
        zzk.zzav();
        zzdb();
        long zzfx = zzcv().zzfx();
        zzb("Dispatching local hits. Elapsed time since last dispatch (ms)", Long.valueOf(zzfx != 0 ? Math.abs(zzcn().currentTimeMillis() - zzfx) : -1));
        zzdz();
        try {
            zzea();
            zzcv().zzfy();
            zzec();
            if (zzbw != null) {
                zzbw.zza(null);
            }
            if (this.zzxx != j) {
                this.zzxr.zzfq();
            }
        } catch (Exception e) {
            zze("Local dispatch failed", e);
            zzcv().zzfy();
            zzec();
            if (zzbw != null) {
                zzbw.zza(e);
            }
        }
    }

    public final void zzeb() {
        zzk.zzav();
        zzdb();
        zzr("Sync dispatching local hits");
        long j = this.zzxx;
        zzdz();
        try {
            zzea();
            zzcv().zzfy();
            zzec();
            if (this.zzxx != j) {
                this.zzxr.zzfq();
            }
        } catch (Exception e) {
            zze("Sync local dispatch failed", e);
            zzec();
        }
    }

    private final long zzds() {
        zzk.zzav();
        zzdb();
        try {
            return this.zzxp.zzds();
        } catch (SQLiteException e) {
            zze("Failed to get min/max hit times from local store", e);
            return 0;
        }
    }

    public final void zzec() {
        long j;
        zzk.zzav();
        zzdb();
        boolean z = true;
        if (!(!this.zzxy && zzef() > 0)) {
            this.zzxr.unregister();
            zzee();
        } else if (this.zzxp.isEmpty()) {
            this.zzxr.unregister();
            zzee();
        } else {
            if (!zzby.zzaai.get().booleanValue()) {
                this.zzxr.zzfo();
                z = this.zzxr.isConnected();
            }
            if (z) {
                zzed();
                long zzef = zzef();
                long zzfx = zzcv().zzfx();
                if (zzfx != 0) {
                    j = zzef - Math.abs(zzcn().currentTimeMillis() - zzfx);
                    if (j <= 0) {
                        j = Math.min(zzbq.zzep(), zzef);
                    }
                } else {
                    j = Math.min(zzbq.zzep(), zzef);
                }
                zza("Dispatch scheduled (ms)", Long.valueOf(j));
                if (this.zzxu.zzez()) {
                    this.zzxu.zzi(Math.max(1L, j + this.zzxu.zzey()));
                } else {
                    this.zzxu.zzh(j);
                }
            } else {
                zzee();
                zzed();
            }
        }
    }

    private final void zzed() {
        zzbv zzct = zzct();
        if (zzct.zzfc() && !zzct.zzez()) {
            long zzds = zzds();
            if (zzds != 0 && Math.abs(zzcn().currentTimeMillis() - zzds) <= zzby.zzzm.get().longValue()) {
                zza("Dispatch alarm scheduled (ms)", Long.valueOf(zzbq.zzeq()));
                zzct.zzfd();
            }
        }
    }

    private final void zzee() {
        if (this.zzxu.zzez()) {
            zzq("All hits dispatched or no network/service. Going to power save mode");
        }
        this.zzxu.cancel();
        zzbv zzct = zzct();
        if (zzct.zzez()) {
            zzct.cancel();
        }
    }

    private final long zzef() {
        long j = this.zzxt;
        if (j != Long.MIN_VALUE) {
            return j;
        }
        long longValue = zzby.zzzh.get().longValue();
        zzda zzcu = zzcu();
        zzcu.zzdb();
        if (!zzcu.zzacv) {
            return longValue;
        }
        zzda zzcu2 = zzcu();
        zzcu2.zzdb();
        return ((long) zzcu2.zzaax) * 1000;
    }

    public final void zzy(String str) {
        Preconditions.checkNotEmpty(str);
        zzk.zzav();
        zzr zza = zzcz.zza(zzco(), str);
        if (zza == null) {
            zzd("Parsing failed. Ignoring invalid campaign data", str);
            return;
        }
        String zzfz = zzcv().zzfz();
        if (str.equals(zzfz)) {
            zzt("Ignoring duplicate install campaign");
        } else if (!TextUtils.isEmpty(zzfz)) {
            zzd("Ignoring multiple install campaigns. original, new", zzfz, str);
        } else {
            zzcv().zzad(str);
            if (zzcv().zzfw().zzj(zzbq.zzex())) {
                zzd("Campaign received too late, ignoring", zza);
                return;
            }
            zzb("Received installation campaign", zza);
            for (zzas zzas : this.zzxp.zzf(0)) {
                zza(zzas, zza);
            }
        }
    }

    private final void zza(zzas zzas, zzr zzr) {
        Preconditions.checkNotNull(zzas);
        Preconditions.checkNotNull(zzr);
        zza zza = new zza(zzcm());
        zza.zza(zzas.zzdj());
        zza.enableAdvertisingIdCollection(zzas.zzdk());
        zzg zzac = zza.zzac();
        zzz zzz = (zzz) zzac.zzb(zzz.class);
        zzz.zzl(Constants.ScionAnalytics.MessageType.DATA_MESSAGE);
        zzz.zzb(true);
        zzac.zza(zzr);
        zzu zzu = (zzu) zzac.zzb(zzu.class);
        zzq zzq = (zzq) zzac.zzb(zzq.class);
        for (Map.Entry<String, String> entry : zzas.zzdm().entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            if ("an".equals(key)) {
                zzq.setAppName(value);
            } else if ("av".equals(key)) {
                zzq.setAppVersion(value);
            } else if ("aid".equals(key)) {
                zzq.setAppId(value);
            } else if ("aiid".equals(key)) {
                zzq.setAppInstallerId(value);
            } else if ("uid".equals(key)) {
                zzz.setUserId(value);
            } else {
                zzu.set(key, value);
            }
        }
        zzb("Sending installation campaign to", zzas.zzdj(), zzr);
        zzac.zza(zzcv().zzfv());
        zzac.zzam();
    }

    private final void zzeg() {
        zzdb();
        zzk.zzav();
        this.zzxy = true;
        this.zzxs.disconnect();
        zzec();
    }
}
