package com.google.android.gms.measurement.internal;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Pair;
import androidx.collection.ArrayMap;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzbv;
import com.google.android.gms.internal.measurement.zzcd;
import com.google.android.gms.internal.measurement.zzhy;
import com.google.android.gms.internal.measurement.zznd;
import com.google.android.gms.internal.measurement.zznv;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.firebase.messaging.Constants;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class zzaf extends zzki {
    private static final String[] zzb = {"last_bundled_timestamp", "ALTER TABLE events ADD COLUMN last_bundled_timestamp INTEGER;", "last_bundled_day", "ALTER TABLE events ADD COLUMN last_bundled_day INTEGER;", "last_sampled_complex_event_id", "ALTER TABLE events ADD COLUMN last_sampled_complex_event_id INTEGER;", "last_sampling_rate", "ALTER TABLE events ADD COLUMN last_sampling_rate INTEGER;", "last_exempt_from_sampling", "ALTER TABLE events ADD COLUMN last_exempt_from_sampling INTEGER;", "current_session_count", "ALTER TABLE events ADD COLUMN current_session_count INTEGER;"};
    private static final String[] zzc = {"origin", "ALTER TABLE user_attributes ADD COLUMN origin TEXT;"};
    private static final String[] zzd = {"app_version", "ALTER TABLE apps ADD COLUMN app_version TEXT;", "app_store", "ALTER TABLE apps ADD COLUMN app_store TEXT;", "gmp_version", "ALTER TABLE apps ADD COLUMN gmp_version INTEGER;", "dev_cert_hash", "ALTER TABLE apps ADD COLUMN dev_cert_hash INTEGER;", "measurement_enabled", "ALTER TABLE apps ADD COLUMN measurement_enabled INTEGER;", "last_bundle_start_timestamp", "ALTER TABLE apps ADD COLUMN last_bundle_start_timestamp INTEGER;", "day", "ALTER TABLE apps ADD COLUMN day INTEGER;", "daily_public_events_count", "ALTER TABLE apps ADD COLUMN daily_public_events_count INTEGER;", "daily_events_count", "ALTER TABLE apps ADD COLUMN daily_events_count INTEGER;", "daily_conversions_count", "ALTER TABLE apps ADD COLUMN daily_conversions_count INTEGER;", "remote_config", "ALTER TABLE apps ADD COLUMN remote_config BLOB;", "config_fetched_time", "ALTER TABLE apps ADD COLUMN config_fetched_time INTEGER;", "failed_config_fetch_time", "ALTER TABLE apps ADD COLUMN failed_config_fetch_time INTEGER;", "app_version_int", "ALTER TABLE apps ADD COLUMN app_version_int INTEGER;", "firebase_instance_id", "ALTER TABLE apps ADD COLUMN firebase_instance_id TEXT;", "daily_error_events_count", "ALTER TABLE apps ADD COLUMN daily_error_events_count INTEGER;", "daily_realtime_events_count", "ALTER TABLE apps ADD COLUMN daily_realtime_events_count INTEGER;", "health_monitor_sample", "ALTER TABLE apps ADD COLUMN health_monitor_sample TEXT;", "android_id", "ALTER TABLE apps ADD COLUMN android_id INTEGER;", "adid_reporting_enabled", "ALTER TABLE apps ADD COLUMN adid_reporting_enabled INTEGER;", "ssaid_reporting_enabled", "ALTER TABLE apps ADD COLUMN ssaid_reporting_enabled INTEGER;", "admob_app_id", "ALTER TABLE apps ADD COLUMN admob_app_id TEXT;", "linked_admob_app_id", "ALTER TABLE apps ADD COLUMN linked_admob_app_id TEXT;", "dynamite_version", "ALTER TABLE apps ADD COLUMN dynamite_version INTEGER;", "safelisted_events", "ALTER TABLE apps ADD COLUMN safelisted_events TEXT;", "ga_app_id", "ALTER TABLE apps ADD COLUMN ga_app_id TEXT;"};
    private static final String[] zze = {"realtime", "ALTER TABLE raw_events ADD COLUMN realtime INTEGER;"};
    private static final String[] zzf = {"has_realtime", "ALTER TABLE queue ADD COLUMN has_realtime INTEGER;", "retry_count", "ALTER TABLE queue ADD COLUMN retry_count INTEGER;"};
    private static final String[] zzg = {"session_scoped", "ALTER TABLE event_filters ADD COLUMN session_scoped BOOLEAN;"};
    private static final String[] zzh = {"session_scoped", "ALTER TABLE property_filters ADD COLUMN session_scoped BOOLEAN;"};
    private static final String[] zzi = {"previous_install_count", "ALTER TABLE app2 ADD COLUMN previous_install_count INTEGER;"};
    private final zzag zzj = new zzag(this, zzm(), "google_app_measurement.db");
    private final zzke zzk = new zzke(zzl());

    zzaf(zzkl zzkl) {
        super(zzkl);
    }

    @Override // com.google.android.gms.measurement.internal.zzki
    public final boolean zzd() {
        return false;
    }

    public final void zze() {
        zzaj();
        c_().beginTransaction();
    }

    public final void b_() {
        zzaj();
        c_().setTransactionSuccessful();
    }

    public final void zzg() {
        zzaj();
        c_().endTransaction();
    }

    private final long zzb(String str, String[] strArr) {
        Cursor cursor = null;
        try {
            Cursor rawQuery = c_().rawQuery(str, strArr);
            if (rawQuery.moveToFirst()) {
                long j = rawQuery.getLong(0);
                if (rawQuery != null) {
                    rawQuery.close();
                }
                return j;
            }
            throw new SQLiteException("Database returned empty set");
        } catch (SQLiteException e) {
            zzq().zze().zza("Database error", str, e);
            throw e;
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            throw th;
        }
    }

    private final long zza(String str, String[] strArr, long j) {
        Cursor cursor = null;
        try {
            Cursor rawQuery = c_().rawQuery(str, strArr);
            if (rawQuery.moveToFirst()) {
                long j2 = rawQuery.getLong(0);
                if (rawQuery != null) {
                    rawQuery.close();
                }
                return j2;
            }
            if (rawQuery != null) {
                rawQuery.close();
            }
            return j;
        } catch (SQLiteException e) {
            zzq().zze().zza("Database error", str, e);
            throw e;
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            throw th;
        }
    }

    private final String zza(String str, String[] strArr, String str2) {
        Cursor cursor = null;
        try {
            Cursor rawQuery = c_().rawQuery(str, strArr);
            if (rawQuery.moveToFirst()) {
                String string = rawQuery.getString(0);
                if (rawQuery != null) {
                    rawQuery.close();
                }
                return string;
            }
            if (rawQuery != null) {
                rawQuery.close();
            }
            return str2;
        } catch (SQLiteException e) {
            zzq().zze().zza("Database error", str, e);
            throw e;
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            throw th;
        }
    }

    public final SQLiteDatabase c_() {
        zzc();
        try {
            return this.zzj.getWritableDatabase();
        } catch (SQLiteException e) {
            zzq().zzh().zza("Error opening database", e);
            throw e;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:61:0x0147  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x0150  */
    public final zzam zza(String str, String str2) {
        Throwable th;
        Cursor cursor;
        SQLiteException e;
        Cursor cursor2;
        Boolean bool;
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        zzc();
        zzaj();
        Cursor cursor3 = null;
        try {
            boolean z = false;
            cursor = c_().query("events", (String[]) new ArrayList(Arrays.asList("lifetime_count", "current_bundle_count", "last_fire_timestamp", "last_bundled_timestamp", "last_bundled_day", "last_sampled_complex_event_id", "last_sampling_rate", "last_exempt_from_sampling", "current_session_count")).toArray(new String[0]), "app_id=? and name=?", new String[]{str, str2}, null, null, null);
            try {
                if (!cursor.moveToFirst()) {
                    if (cursor != null) {
                        cursor.close();
                    }
                    return null;
                }
                long j = cursor.getLong(0);
                long j2 = cursor.getLong(1);
                long j3 = cursor.getLong(2);
                long j4 = cursor.isNull(3) ? 0 : cursor.getLong(3);
                Long valueOf = cursor.isNull(4) ? null : Long.valueOf(cursor.getLong(4));
                Long valueOf2 = cursor.isNull(5) ? null : Long.valueOf(cursor.getLong(5));
                Long valueOf3 = cursor.isNull(6) ? null : Long.valueOf(cursor.getLong(6));
                if (!cursor.isNull(7)) {
                    try {
                        if (cursor.getLong(7) == 1) {
                            z = true;
                        }
                        bool = Boolean.valueOf(z);
                    } catch (SQLiteException e2) {
                        e = e2;
                        try {
                            zzq().zze().zza("Error querying events. appId", zzeq.zza(str), zzn().zza(str2), e);
                            if (cursor != null) {
                            }
                            return null;
                        } catch (Throwable th2) {
                            th = th2;
                            cursor3 = cursor;
                            if (cursor3 != null) {
                            }
                            throw th;
                        }
                    }
                } else {
                    bool = null;
                }
                cursor2 = cursor;
                try {
                    zzam zzam = new zzam(str, str2, j, j2, cursor.isNull(8) ? 0 : cursor.getLong(8), j3, j4, valueOf, valueOf2, valueOf3, bool);
                    if (cursor2.moveToNext()) {
                        zzq().zze().zza("Got multiple records for event aggregates, expected one. appId", zzeq.zza(str));
                    }
                    if (cursor2 != null) {
                        cursor2.close();
                    }
                    return zzam;
                } catch (SQLiteException e3) {
                    e = e3;
                    cursor = cursor2;
                    zzq().zze().zza("Error querying events. appId", zzeq.zza(str), zzn().zza(str2), e);
                    if (cursor != null) {
                    }
                    return null;
                } catch (Throwable th3) {
                    th = th3;
                    cursor3 = cursor2;
                    if (cursor3 != null) {
                    }
                    throw th;
                }
            } catch (SQLiteException e4) {
                e = e4;
                zzq().zze().zza("Error querying events. appId", zzeq.zza(str), zzn().zza(str2), e);
                if (cursor != null) {
                }
                return null;
            } catch (Throwable th4) {
                th = th4;
                cursor2 = cursor;
                cursor3 = cursor2;
                if (cursor3 != null) {
                }
                throw th;
            }
        } catch (SQLiteException e5) {
            e = e5;
            cursor = null;
            zzq().zze().zza("Error querying events. appId", zzeq.zza(str), zzn().zza(str2), e);
            if (cursor != null) {
                cursor.close();
            }
            return null;
        } catch (Throwable th5) {
            th = th5;
            if (cursor3 != null) {
                cursor3.close();
            }
            throw th;
        }
    }

    public final void zza(zzam zzam) {
        Preconditions.checkNotNull(zzam);
        zzc();
        zzaj();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", zzam.zza);
        contentValues.put("name", zzam.zzb);
        contentValues.put("lifetime_count", Long.valueOf(zzam.zzc));
        contentValues.put("current_bundle_count", Long.valueOf(zzam.zzd));
        contentValues.put("last_fire_timestamp", Long.valueOf(zzam.zzf));
        contentValues.put("last_bundled_timestamp", Long.valueOf(zzam.zzg));
        contentValues.put("last_bundled_day", zzam.zzh);
        contentValues.put("last_sampled_complex_event_id", zzam.zzi);
        contentValues.put("last_sampling_rate", zzam.zzj);
        contentValues.put("current_session_count", Long.valueOf(zzam.zze));
        contentValues.put("last_exempt_from_sampling", (zzam.zzk == null || !zzam.zzk.booleanValue()) ? null : 1L);
        try {
            if (c_().insertWithOnConflict("events", null, contentValues, 5) == -1) {
                zzq().zze().zza("Failed to insert/update event aggregates (got -1). appId", zzeq.zza(zzam.zza));
            }
        } catch (SQLiteException e) {
            zzq().zze().zza("Error storing event aggregates. appId", zzeq.zza(zzam.zza), e);
        }
    }

    public final void zzb(String str, String str2) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        zzc();
        zzaj();
        try {
            c_().delete("user_attributes", "app_id=? and name=?", new String[]{str, str2});
        } catch (SQLiteException e) {
            zzq().zze().zza("Error deleting user property. appId", zzeq.zza(str), zzn().zzc(str2), e);
        }
    }

    public final boolean zza(zzkw zzkw) {
        Preconditions.checkNotNull(zzkw);
        zzc();
        zzaj();
        if (zzc(zzkw.zza, zzkw.zzc) == null) {
            if (zzkv.zza(zzkw.zzc)) {
                if (zzb("select count(1) from user_attributes where app_id=? and name not like '!_%' escape '!'", new String[]{zzkw.zza}) >= ((long) zzs().zzd(zzkw.zza))) {
                    return false;
                }
            } else if (!"_npa".equals(zzkw.zzc)) {
                if (zzb("select count(1) from user_attributes where app_id=? and origin=? AND name like '!_%' escape '!'", new String[]{zzkw.zza, zzkw.zzb}) >= 25) {
                    return false;
                }
            }
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", zzkw.zza);
        contentValues.put("origin", zzkw.zzb);
        contentValues.put("name", zzkw.zzc);
        contentValues.put("set_timestamp", Long.valueOf(zzkw.zzd));
        zza(contentValues, "value", zzkw.zze);
        try {
            if (c_().insertWithOnConflict("user_attributes", null, contentValues, 5) == -1) {
                zzq().zze().zza("Failed to insert/update user property (got -1). appId", zzeq.zza(zzkw.zza));
            }
        } catch (SQLiteException e) {
            zzq().zze().zza("Error storing user property. appId", zzeq.zza(zzkw.zza), e);
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x00a1  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00a9  */
    public final zzkw zzc(String str, String str2) {
        Throwable th;
        Cursor cursor;
        SQLiteException e;
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        zzc();
        zzaj();
        Cursor cursor2 = null;
        try {
            cursor = c_().query("user_attributes", new String[]{"set_timestamp", "value", "origin"}, "app_id=? and name=?", new String[]{str, str2}, null, null, null);
            try {
                if (!cursor.moveToFirst()) {
                    if (cursor != null) {
                        cursor.close();
                    }
                    return null;
                }
                try {
                    zzkw zzkw = new zzkw(str, cursor.getString(2), str2, cursor.getLong(0), zza(cursor, 1));
                    if (cursor.moveToNext()) {
                        zzq().zze().zza("Got multiple records for user property, expected one. appId", zzeq.zza(str));
                    }
                    if (cursor != null) {
                        cursor.close();
                    }
                    return zzkw;
                } catch (SQLiteException e2) {
                    e = e2;
                    try {
                        zzq().zze().zza("Error querying user property. appId", zzeq.zza(str), zzn().zzc(str2), e);
                        if (cursor != null) {
                        }
                        return null;
                    } catch (Throwable th2) {
                        th = th2;
                        cursor2 = cursor;
                        if (cursor2 != null) {
                            cursor2.close();
                        }
                        throw th;
                    }
                }
            } catch (SQLiteException e3) {
                e = e3;
                zzq().zze().zza("Error querying user property. appId", zzeq.zza(str), zzn().zzc(str2), e);
                if (cursor != null) {
                }
                return null;
            } catch (Throwable th3) {
                th = th3;
                cursor2 = cursor;
                if (cursor2 != null) {
                }
                throw th;
            }
        } catch (SQLiteException e4) {
            e = e4;
            cursor = null;
            zzq().zze().zza("Error querying user property. appId", zzeq.zza(str), zzn().zzc(str2), e);
            if (cursor != null) {
                cursor.close();
            }
            return null;
        } catch (Throwable th4) {
            th = th4;
            if (cursor2 != null) {
            }
            throw th;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:35:0x00b5  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00bd  */
    public final List<zzkw> zza(String str) {
        Throwable th;
        Cursor cursor;
        SQLiteException e;
        Preconditions.checkNotEmpty(str);
        zzc();
        zzaj();
        ArrayList arrayList = new ArrayList();
        Cursor cursor2 = null;
        try {
            cursor = c_().query("user_attributes", new String[]{"name", "origin", "set_timestamp", "value"}, "app_id=?", new String[]{str}, null, null, "rowid", "1000");
            try {
                if (!cursor.moveToFirst()) {
                    if (cursor != null) {
                        cursor.close();
                    }
                    return arrayList;
                }
                do {
                    String string = cursor.getString(0);
                    String string2 = cursor.getString(1);
                    if (string2 == null) {
                        string2 = "";
                    }
                    long j = cursor.getLong(2);
                    Object zza = zza(cursor, 3);
                    if (zza == null) {
                        zzq().zze().zza("Read invalid user property value, ignoring it. appId", zzeq.zza(str));
                    } else {
                        arrayList.add(new zzkw(str, string2, string, j, zza));
                    }
                } while (cursor.moveToNext());
                if (cursor != null) {
                    cursor.close();
                }
                return arrayList;
            } catch (SQLiteException e2) {
                e = e2;
                try {
                    zzq().zze().zza("Error querying user properties. appId", zzeq.zza(str), e);
                    if (zznd.zzb()) {
                    }
                    if (cursor != null) {
                    }
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    cursor2 = cursor;
                    if (cursor2 != null) {
                    }
                    throw th;
                }
            }
        } catch (SQLiteException e3) {
            e = e3;
            cursor = null;
            zzq().zze().zza("Error querying user properties. appId", zzeq.zza(str), e);
            if (zznd.zzb() || !zzs().zze(str, zzas.zzce)) {
                if (cursor != null) {
                    cursor.close();
                }
                return null;
            }
            List<zzkw> emptyList = Collections.emptyList();
            if (cursor != null) {
                cursor.close();
            }
            return emptyList;
        } catch (Throwable th3) {
            th = th3;
            if (cursor2 != null) {
                cursor2.close();
            }
            throw th;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00fb, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00ff, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x0100, code lost:
        r3 = r22;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x013c, code lost:
        r9.close();
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00fb A[ExcHandler: all (th java.lang.Throwable), Splitter:B:1:0x0011] */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x011c A[Catch:{ all -> 0x0138 }] */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x0134  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x013c  */
    public final List<zzkw> zza(String str, String str2, String str3) {
        Throwable th;
        Cursor cursor;
        String str4;
        SQLiteException e;
        Preconditions.checkNotEmpty(str);
        zzc();
        zzaj();
        ArrayList arrayList = new ArrayList();
        Cursor cursor2 = null;
        try {
            ArrayList arrayList2 = new ArrayList(3);
            arrayList2.add(str);
            StringBuilder sb = new StringBuilder("app_id=?");
            if (!TextUtils.isEmpty(str2)) {
                str4 = str2;
                arrayList2.add(str4);
                sb.append(" and origin=?");
            } else {
                str4 = str2;
            }
            if (!TextUtils.isEmpty(str3)) {
                arrayList2.add(String.valueOf(str3).concat("*"));
                sb.append(" and name glob ?");
            }
            cursor = c_().query("user_attributes", new String[]{"name", "set_timestamp", "value", "origin"}, sb.toString(), (String[]) arrayList2.toArray(new String[arrayList2.size()]), null, null, "rowid", "1001");
            try {
                if (!cursor.moveToFirst()) {
                    if (cursor != null) {
                        cursor.close();
                    }
                    return arrayList;
                }
                while (true) {
                    if (arrayList.size() >= 1000) {
                        zzq().zze().zza("Read more than the max allowed user properties, ignoring excess", 1000);
                        break;
                    }
                    String string = cursor.getString(0);
                    long j = cursor.getLong(1);
                    try {
                        Object zza = zza(cursor, 2);
                        String string2 = cursor.getString(3);
                        if (zza == null) {
                            try {
                                zzq().zze().zza("(2)Read invalid user property value, ignoring it", zzeq.zza(str), string2, str3);
                            } catch (SQLiteException e2) {
                                e = e2;
                                str4 = string2;
                                try {
                                    zzq().zze().zza("(2)Error querying user properties", zzeq.zza(str), str4, e);
                                    if (zznd.zzb() || !zzs().zze(str, zzas.zzce)) {
                                        if (cursor != null) {
                                            cursor.close();
                                        }
                                        return null;
                                    }
                                    List<zzkw> emptyList = Collections.emptyList();
                                    if (cursor != null) {
                                        cursor.close();
                                    }
                                    return emptyList;
                                } catch (Throwable th2) {
                                    th = th2;
                                    cursor2 = cursor;
                                    if (cursor2 != null) {
                                    }
                                    throw th;
                                }
                            }
                        } else {
                            arrayList.add(new zzkw(str, string2, string, j, zza));
                        }
                        if (!cursor.moveToNext()) {
                            break;
                        }
                        str4 = string2;
                    } catch (SQLiteException e3) {
                        e = e3;
                        zzq().zze().zza("(2)Error querying user properties", zzeq.zza(str), str4, e);
                        if (zznd.zzb()) {
                        }
                        if (cursor != null) {
                        }
                        return null;
                    }
                }
                if (cursor != null) {
                    cursor.close();
                }
                return arrayList;
            } catch (SQLiteException e4) {
                e = e4;
                zzq().zze().zza("(2)Error querying user properties", zzeq.zza(str), str4, e);
                if (zznd.zzb()) {
                }
                if (cursor != null) {
                }
                return null;
            } catch (Throwable th3) {
                th = th3;
                cursor2 = cursor;
                if (cursor2 != null) {
                }
                throw th;
            }
        } catch (SQLiteException e5) {
            e = e5;
            cursor = null;
            zzq().zze().zza("(2)Error querying user properties", zzeq.zza(str), str4, e);
            if (zznd.zzb()) {
            }
            if (cursor != null) {
            }
            return null;
        } catch (Throwable th4) {
        }
    }

    public final boolean zza(zzz zzz) {
        Preconditions.checkNotNull(zzz);
        zzc();
        zzaj();
        if (zzc(zzz.zza, zzz.zzc.zza) == null) {
            if (zzb("SELECT COUNT(1) FROM conditional_properties WHERE app_id=?", new String[]{zzz.zza}) >= 1000) {
                return false;
            }
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", zzz.zza);
        contentValues.put("origin", zzz.zzb);
        contentValues.put("name", zzz.zzc.zza);
        zza(contentValues, "value", zzz.zzc.zza());
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.ACTIVE, Boolean.valueOf(zzz.zze));
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_EVENT_NAME, zzz.zzf);
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_TIMEOUT, Long.valueOf(zzz.zzh));
        zzo();
        contentValues.put("timed_out_event", zzkv.zza((Parcelable) zzz.zzg));
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP, Long.valueOf(zzz.zzd));
        zzo();
        contentValues.put("triggered_event", zzkv.zza((Parcelable) zzz.zzi));
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_TIMESTAMP, Long.valueOf(zzz.zzc.zzb));
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.TIME_TO_LIVE, Long.valueOf(zzz.zzj));
        zzo();
        contentValues.put("expired_event", zzkv.zza((Parcelable) zzz.zzk));
        try {
            if (c_().insertWithOnConflict("conditional_properties", null, contentValues, 5) == -1) {
                zzq().zze().zza("Failed to insert/update conditional user property (got -1)", zzeq.zza(zzz.zza));
            }
        } catch (SQLiteException e) {
            zzq().zze().zza("Error storing conditional user property", zzeq.zza(zzz.zza), e);
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:33:0x011d  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0125  */
    public final zzz zzd(String str, String str2) {
        Throwable th;
        Cursor cursor;
        SQLiteException e;
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        zzc();
        zzaj();
        Cursor cursor2 = null;
        try {
            cursor = c_().query("conditional_properties", new String[]{"origin", "value", AppMeasurementSdk.ConditionalUserProperty.ACTIVE, AppMeasurementSdk.ConditionalUserProperty.TRIGGER_EVENT_NAME, AppMeasurementSdk.ConditionalUserProperty.TRIGGER_TIMEOUT, "timed_out_event", AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP, "triggered_event", AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_TIMESTAMP, AppMeasurementSdk.ConditionalUserProperty.TIME_TO_LIVE, "expired_event"}, "app_id=? and name=?", new String[]{str, str2}, null, null, null);
            try {
                if (!cursor.moveToFirst()) {
                    if (cursor != null) {
                        cursor.close();
                    }
                    return null;
                }
                String string = cursor.getString(0);
                try {
                    Object zza = zza(cursor, 1);
                    boolean z = cursor.getInt(2) != 0;
                    zzz zzz = new zzz(str, string, new zzku(str2, cursor.getLong(8), zza, string), cursor.getLong(6), z, cursor.getString(3), (zzaq) f_().zza(cursor.getBlob(5), zzaq.CREATOR), cursor.getLong(4), (zzaq) f_().zza(cursor.getBlob(7), zzaq.CREATOR), cursor.getLong(9), (zzaq) f_().zza(cursor.getBlob(10), zzaq.CREATOR));
                    if (cursor.moveToNext()) {
                        zzq().zze().zza("Got multiple records for conditional property, expected one", zzeq.zza(str), zzn().zzc(str2));
                    }
                    if (cursor != null) {
                        cursor.close();
                    }
                    return zzz;
                } catch (SQLiteException e2) {
                    e = e2;
                    try {
                        zzq().zze().zza("Error querying conditional property", zzeq.zza(str), zzn().zzc(str2), e);
                        if (cursor != null) {
                        }
                        return null;
                    } catch (Throwable th2) {
                        th = th2;
                        cursor2 = cursor;
                        if (cursor2 != null) {
                            cursor2.close();
                        }
                        throw th;
                    }
                }
            } catch (SQLiteException e3) {
                e = e3;
                zzq().zze().zza("Error querying conditional property", zzeq.zza(str), zzn().zzc(str2), e);
                if (cursor != null) {
                }
                return null;
            } catch (Throwable th3) {
                th = th3;
                cursor2 = cursor;
                if (cursor2 != null) {
                }
                throw th;
            }
        } catch (SQLiteException e4) {
            e = e4;
            cursor = null;
            zzq().zze().zza("Error querying conditional property", zzeq.zza(str), zzn().zzc(str2), e);
            if (cursor != null) {
                cursor.close();
            }
            return null;
        } catch (Throwable th4) {
            th = th4;
            if (cursor2 != null) {
            }
            throw th;
        }
    }

    public final int zze(String str, String str2) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        zzc();
        zzaj();
        try {
            return c_().delete("conditional_properties", "app_id=? and name=?", new String[]{str, str2});
        } catch (SQLiteException e) {
            zzq().zze().zza("Error deleting conditional property", zzeq.zza(str), zzn().zzc(str2), e);
            return 0;
        }
    }

    public final List<zzz> zzb(String str, String str2, String str3) {
        Preconditions.checkNotEmpty(str);
        zzc();
        zzaj();
        ArrayList arrayList = new ArrayList(3);
        arrayList.add(str);
        StringBuilder sb = new StringBuilder("app_id=?");
        if (!TextUtils.isEmpty(str2)) {
            arrayList.add(str2);
            sb.append(" and origin=?");
        }
        if (!TextUtils.isEmpty(str3)) {
            arrayList.add(String.valueOf(str3).concat("*"));
            sb.append(" and name glob ?");
        }
        return zza(sb.toString(), (String[]) arrayList.toArray(new String[arrayList.size()]));
    }

    public final List<zzz> zza(String str, String[] strArr) {
        zzc();
        zzaj();
        ArrayList arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            cursor = c_().query("conditional_properties", new String[]{"app_id", "origin", "name", "value", AppMeasurementSdk.ConditionalUserProperty.ACTIVE, AppMeasurementSdk.ConditionalUserProperty.TRIGGER_EVENT_NAME, AppMeasurementSdk.ConditionalUserProperty.TRIGGER_TIMEOUT, "timed_out_event", AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP, "triggered_event", AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_TIMESTAMP, AppMeasurementSdk.ConditionalUserProperty.TIME_TO_LIVE, "expired_event"}, str, strArr, null, null, "rowid", "1001");
            if (!cursor.moveToFirst()) {
                if (cursor != null) {
                    cursor.close();
                }
                return arrayList;
            }
            while (true) {
                if (arrayList.size() < 1000) {
                    boolean z = false;
                    String string = cursor.getString(0);
                    String string2 = cursor.getString(1);
                    String string3 = cursor.getString(2);
                    Object zza = zza(cursor, 3);
                    if (cursor.getInt(4) != 0) {
                        z = true;
                    }
                    String string4 = cursor.getString(5);
                    long j = cursor.getLong(6);
                    arrayList.add(new zzz(string, string2, new zzku(string3, cursor.getLong(10), zza, string2), cursor.getLong(8), z, string4, (zzaq) f_().zza(cursor.getBlob(7), zzaq.CREATOR), j, (zzaq) f_().zza(cursor.getBlob(9), zzaq.CREATOR), cursor.getLong(11), (zzaq) f_().zza(cursor.getBlob(12), zzaq.CREATOR)));
                    if (!cursor.moveToNext()) {
                        break;
                    }
                } else {
                    zzq().zze().zza("Read more than the max allowed conditional properties, ignoring extra", 1000);
                    break;
                }
            }
            if (cursor != null) {
                cursor.close();
            }
            return arrayList;
        } catch (SQLiteException e) {
            zzq().zze().zza("Error querying conditional user property value", e);
            List<zzz> emptyList = Collections.emptyList();
            if (cursor != null) {
                cursor.close();
            }
            return emptyList;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x011b A[Catch:{ SQLiteException -> 0x0200 }] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x011f A[Catch:{ SQLiteException -> 0x0200 }] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0159 A[Catch:{ SQLiteException -> 0x0200 }] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0172 A[Catch:{ SQLiteException -> 0x0200 }] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0187 A[Catch:{ SQLiteException -> 0x0200 }] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x01a3 A[Catch:{ SQLiteException -> 0x0200 }] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x01a4 A[Catch:{ SQLiteException -> 0x0200 }] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x01b3 A[Catch:{ SQLiteException -> 0x0200 }] */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x01e9 A[Catch:{ SQLiteException -> 0x0200 }] */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x01fc  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x0225  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x022d  */
    public final zzf zzb(String str) {
        Throwable th;
        Cursor cursor;
        SQLiteException e;
        boolean z;
        boolean z2;
        Preconditions.checkNotEmpty(str);
        zzc();
        zzaj();
        Cursor cursor2 = null;
        try {
            boolean z3 = true;
            cursor = c_().query("apps", new String[]{"app_instance_id", "gmp_app_id", "resettable_device_id_hash", "last_bundle_index", "last_bundle_start_timestamp", "last_bundle_end_timestamp", "app_version", "app_store", "gmp_version", "dev_cert_hash", "measurement_enabled", "day", "daily_public_events_count", "daily_events_count", "daily_conversions_count", "config_fetched_time", "failed_config_fetch_time", "app_version_int", "firebase_instance_id", "daily_error_events_count", "daily_realtime_events_count", "health_monitor_sample", "android_id", "adid_reporting_enabled", "ssaid_reporting_enabled", "admob_app_id", "dynamite_version", "safelisted_events", "ga_app_id"}, "app_id=?", new String[]{str}, null, null, null);
            try {
                if (!cursor.moveToFirst()) {
                    if (cursor != null) {
                        cursor.close();
                    }
                    return null;
                }
                try {
                    zzf zzf2 = new zzf(this.zza.zzu(), str);
                    zzf2.zza(cursor.getString(0));
                    zzf2.zzb(cursor.getString(1));
                    zzf2.zze(cursor.getString(2));
                    zzf2.zzg(cursor.getLong(3));
                    zzf2.zza(cursor.getLong(4));
                    zzf2.zzb(cursor.getLong(5));
                    zzf2.zzg(cursor.getString(6));
                    zzf2.zzh(cursor.getString(7));
                    zzf2.zzd(cursor.getLong(8));
                    zzf2.zze(cursor.getLong(9));
                    if (!cursor.isNull(10)) {
                        if (cursor.getInt(10) == 0) {
                            z = false;
                            zzf2.zza(z);
                            zzf2.zzj(cursor.getLong(11));
                            zzf2.zzk(cursor.getLong(12));
                            zzf2.zzl(cursor.getLong(13));
                            zzf2.zzm(cursor.getLong(14));
                            zzf2.zzh(cursor.getLong(15));
                            zzf2.zzi(cursor.getLong(16));
                            zzf2.zzc(!cursor.isNull(17) ? -2147483648L : (long) cursor.getInt(17));
                            zzf2.zzf(cursor.getString(18));
                            zzf2.zzo(cursor.getLong(19));
                            zzf2.zzn(cursor.getLong(20));
                            zzf2.zzi(cursor.getString(21));
                            long j = 0;
                            if (!zzs().zza(zzas.zzbx)) {
                                zzf2.zzp(cursor.isNull(22) ? 0 : cursor.getLong(22));
                            }
                            if (!cursor.isNull(23)) {
                                if (cursor.getInt(23) == 0) {
                                    z2 = false;
                                    zzf2.zzb(z2);
                                    if (!cursor.isNull(24)) {
                                        if (cursor.getInt(24) == 0) {
                                            z3 = false;
                                        }
                                    }
                                    zzf2.zzc(z3);
                                    zzf2.zzc(cursor.getString(25));
                                    if (!cursor.isNull(26)) {
                                        j = cursor.getLong(26);
                                    }
                                    zzf2.zzf(j);
                                    if (!cursor.isNull(27)) {
                                        zzf2.zza(Arrays.asList(cursor.getString(27).split(",", -1)));
                                    }
                                    if (zznv.zzb() && zzs().zze(str, zzas.zzbi)) {
                                        zzf2.zzd(cursor.getString(28));
                                    }
                                    zzf2.zzb();
                                    if (cursor.moveToNext()) {
                                        zzq().zze().zza("Got multiple records for app, expected one. appId", zzeq.zza(str));
                                    }
                                    if (cursor != null) {
                                        cursor.close();
                                    }
                                    return zzf2;
                                }
                            }
                            z2 = true;
                            zzf2.zzb(z2);
                            if (!cursor.isNull(24)) {
                            }
                            zzf2.zzc(z3);
                            zzf2.zzc(cursor.getString(25));
                            if (!cursor.isNull(26)) {
                            }
                            zzf2.zzf(j);
                            if (!cursor.isNull(27)) {
                            }
                            zzf2.zzd(cursor.getString(28));
                            zzf2.zzb();
                            if (cursor.moveToNext()) {
                            }
                            if (cursor != null) {
                            }
                            return zzf2;
                        }
                    }
                    z = true;
                    zzf2.zza(z);
                    zzf2.zzj(cursor.getLong(11));
                    zzf2.zzk(cursor.getLong(12));
                    zzf2.zzl(cursor.getLong(13));
                    zzf2.zzm(cursor.getLong(14));
                    zzf2.zzh(cursor.getLong(15));
                    zzf2.zzi(cursor.getLong(16));
                    zzf2.zzc(!cursor.isNull(17) ? -2147483648L : (long) cursor.getInt(17));
                    zzf2.zzf(cursor.getString(18));
                    zzf2.zzo(cursor.getLong(19));
                    zzf2.zzn(cursor.getLong(20));
                    zzf2.zzi(cursor.getString(21));
                    long j2 = 0;
                    if (!zzs().zza(zzas.zzbx)) {
                    }
                    if (!cursor.isNull(23)) {
                    }
                    z2 = true;
                    zzf2.zzb(z2);
                    if (!cursor.isNull(24)) {
                    }
                    zzf2.zzc(z3);
                    zzf2.zzc(cursor.getString(25));
                    if (!cursor.isNull(26)) {
                    }
                    zzf2.zzf(j2);
                    if (!cursor.isNull(27)) {
                    }
                    zzf2.zzd(cursor.getString(28));
                    zzf2.zzb();
                    if (cursor.moveToNext()) {
                    }
                    if (cursor != null) {
                    }
                    return zzf2;
                } catch (SQLiteException e2) {
                    e = e2;
                    try {
                        zzq().zze().zza("Error querying app. appId", zzeq.zza(str), e);
                        if (cursor != null) {
                        }
                        return null;
                    } catch (Throwable th2) {
                        th = th2;
                        cursor2 = cursor;
                        if (cursor2 != null) {
                        }
                        throw th;
                    }
                }
            } catch (SQLiteException e3) {
                e = e3;
                zzq().zze().zza("Error querying app. appId", zzeq.zza(str), e);
                if (cursor != null) {
                }
                return null;
            } catch (Throwable th3) {
                th = th3;
                cursor2 = cursor;
                if (cursor2 != null) {
                }
                throw th;
            }
        } catch (SQLiteException e4) {
            e = e4;
            cursor = null;
            zzq().zze().zza("Error querying app. appId", zzeq.zza(str), e);
            if (cursor != null) {
                cursor.close();
            }
            return null;
        } catch (Throwable th4) {
            th = th4;
            if (cursor2 != null) {
                cursor2.close();
            }
            throw th;
        }
    }

    public final void zza(zzf zzf2) {
        Preconditions.checkNotNull(zzf2);
        zzc();
        zzaj();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", zzf2.zzc());
        contentValues.put("app_instance_id", zzf2.zzd());
        contentValues.put("gmp_app_id", zzf2.zze());
        contentValues.put("resettable_device_id_hash", zzf2.zzh());
        contentValues.put("last_bundle_index", Long.valueOf(zzf2.zzs()));
        contentValues.put("last_bundle_start_timestamp", Long.valueOf(zzf2.zzj()));
        contentValues.put("last_bundle_end_timestamp", Long.valueOf(zzf2.zzk()));
        contentValues.put("app_version", zzf2.zzl());
        contentValues.put("app_store", zzf2.zzn());
        contentValues.put("gmp_version", Long.valueOf(zzf2.zzo()));
        contentValues.put("dev_cert_hash", Long.valueOf(zzf2.zzp()));
        contentValues.put("measurement_enabled", Boolean.valueOf(zzf2.zzr()));
        contentValues.put("day", Long.valueOf(zzf2.zzw()));
        contentValues.put("daily_public_events_count", Long.valueOf(zzf2.zzx()));
        contentValues.put("daily_events_count", Long.valueOf(zzf2.zzy()));
        contentValues.put("daily_conversions_count", Long.valueOf(zzf2.zzz()));
        contentValues.put("config_fetched_time", Long.valueOf(zzf2.zzt()));
        contentValues.put("failed_config_fetch_time", Long.valueOf(zzf2.zzu()));
        contentValues.put("app_version_int", Long.valueOf(zzf2.zzm()));
        contentValues.put("firebase_instance_id", zzf2.zzi());
        contentValues.put("daily_error_events_count", Long.valueOf(zzf2.zzab()));
        contentValues.put("daily_realtime_events_count", Long.valueOf(zzf2.zzaa()));
        contentValues.put("health_monitor_sample", zzf2.zzac());
        contentValues.put("android_id", Long.valueOf(zzf2.zzae()));
        contentValues.put("adid_reporting_enabled", Boolean.valueOf(zzf2.zzaf()));
        contentValues.put("ssaid_reporting_enabled", Boolean.valueOf(zzf2.zzag()));
        contentValues.put("admob_app_id", zzf2.zzf());
        contentValues.put("dynamite_version", Long.valueOf(zzf2.zzq()));
        if (zzf2.zzai() != null) {
            if (zzf2.zzai().size() == 0) {
                zzq().zzh().zza("Safelisted events should not be an empty list. appId", zzf2.zzc());
            } else {
                contentValues.put("safelisted_events", TextUtils.join(",", zzf2.zzai()));
            }
        }
        if (zznv.zzb() && zzs().zze(zzf2.zzc(), zzas.zzbi)) {
            contentValues.put("ga_app_id", zzf2.zzg());
        }
        try {
            SQLiteDatabase c_ = c_();
            if (((long) c_.update("apps", contentValues, "app_id = ?", new String[]{zzf2.zzc()})) == 0 && c_.insertWithOnConflict("apps", null, contentValues, 5) == -1) {
                zzq().zze().zza("Failed to insert/update app (got -1). appId", zzeq.zza(zzf2.zzc()));
            }
        } catch (SQLiteException e) {
            zzq().zze().zza("Error storing app. appId", zzeq.zza(zzf2.zzc()), e);
        }
    }

    public final long zzc(String str) {
        Preconditions.checkNotEmpty(str);
        zzc();
        zzaj();
        try {
            return (long) c_().delete("raw_events", "rowid in (select rowid from raw_events where app_id=? order by rowid desc limit -1 offset ?)", new String[]{str, String.valueOf(Math.max(0, Math.min(1000000, zzs().zzb(str, zzas.zzo))))});
        } catch (SQLiteException e) {
            zzq().zze().zza("Error deleting over the limit events. appId", zzeq.zza(str), e);
            return 0;
        }
    }

    public final zzae zza(long j, String str, boolean z, boolean z2, boolean z3, boolean z4, boolean z5) {
        return zza(j, str, 1, false, false, z3, false, z5);
    }

    public final zzae zza(long j, String str, long j2, boolean z, boolean z2, boolean z3, boolean z4, boolean z5) {
        Preconditions.checkNotEmpty(str);
        zzc();
        zzaj();
        String[] strArr = {str};
        zzae zzae = new zzae();
        Cursor cursor = null;
        try {
            SQLiteDatabase c_ = c_();
            Cursor query = c_.query("apps", new String[]{"day", "daily_events_count", "daily_public_events_count", "daily_conversions_count", "daily_error_events_count", "daily_realtime_events_count"}, "app_id=?", new String[]{str}, null, null, null);
            if (!query.moveToFirst()) {
                zzq().zzh().zza("Not updating daily counts, app is not known. appId", zzeq.zza(str));
                if (query != null) {
                    query.close();
                }
                return zzae;
            }
            if (query.getLong(0) == j) {
                zzae.zzb = query.getLong(1);
                zzae.zza = query.getLong(2);
                zzae.zzc = query.getLong(3);
                zzae.zzd = query.getLong(4);
                zzae.zze = query.getLong(5);
            }
            if (z) {
                zzae.zzb += j2;
            }
            if (z2) {
                zzae.zza += j2;
            }
            if (z3) {
                zzae.zzc += j2;
            }
            if (z4) {
                zzae.zzd += j2;
            }
            if (z5) {
                zzae.zze += j2;
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("day", Long.valueOf(j));
            contentValues.put("daily_public_events_count", Long.valueOf(zzae.zza));
            contentValues.put("daily_events_count", Long.valueOf(zzae.zzb));
            contentValues.put("daily_conversions_count", Long.valueOf(zzae.zzc));
            contentValues.put("daily_error_events_count", Long.valueOf(zzae.zzd));
            contentValues.put("daily_realtime_events_count", Long.valueOf(zzae.zze));
            c_.update("apps", contentValues, "app_id=?", strArr);
            if (query != null) {
                query.close();
            }
            return zzae;
        } catch (SQLiteException e) {
            zzq().zze().zza("Error updating daily counts. appId", zzeq.zza(str), e);
            if (0 != 0) {
                cursor.close();
            }
            return zzae;
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            throw th;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x006b  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0073  */
    public final byte[] zzd(String str) {
        Throwable th;
        SQLiteException e;
        Cursor cursor;
        Preconditions.checkNotEmpty(str);
        zzc();
        zzaj();
        Cursor cursor2 = null;
        try {
            cursor = c_().query("apps", new String[]{"remote_config"}, "app_id=?", new String[]{str}, null, null, null);
            try {
                if (!cursor.moveToFirst()) {
                    if (cursor != null) {
                        cursor.close();
                    }
                    return null;
                }
                byte[] blob = cursor.getBlob(0);
                if (cursor.moveToNext()) {
                    zzq().zze().zza("Got multiple records for app config, expected one. appId", zzeq.zza(str));
                }
                if (cursor != null) {
                    cursor.close();
                }
                return blob;
            } catch (SQLiteException e2) {
                e = e2;
                try {
                    zzq().zze().zza("Error querying remote config. appId", zzeq.zza(str), e);
                    if (cursor != null) {
                    }
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    cursor2 = cursor;
                    if (cursor2 != null) {
                    }
                    throw th;
                }
            }
        } catch (SQLiteException e3) {
            e = e3;
            cursor = null;
            zzq().zze().zza("Error querying remote config. appId", zzeq.zza(str), e);
            if (cursor != null) {
                cursor.close();
            }
            return null;
        } catch (Throwable th3) {
            th = th3;
            if (cursor2 != null) {
                cursor2.close();
            }
            throw th;
        }
    }

    public final boolean zza(zzcd.zzg zzg2, boolean z) {
        zzc();
        zzaj();
        Preconditions.checkNotNull(zzg2);
        Preconditions.checkNotEmpty(zzg2.zzx());
        Preconditions.checkState(zzg2.zzk());
        zzu();
        long currentTimeMillis = zzl().currentTimeMillis();
        if (zzg2.zzl() < currentTimeMillis - zzab.zzu() || zzg2.zzl() > zzab.zzu() + currentTimeMillis) {
            zzq().zzh().zza("Storing bundle outside of the max uploading time span. appId, now, timestamp", zzeq.zza(zzg2.zzx()), Long.valueOf(currentTimeMillis), Long.valueOf(zzg2.zzl()));
        }
        try {
            byte[] zzc2 = f_().zzc(zzg2.zzbk());
            zzq().zzw().zza("Saving bundle, size", Integer.valueOf(zzc2.length));
            ContentValues contentValues = new ContentValues();
            contentValues.put("app_id", zzg2.zzx());
            contentValues.put("bundle_end_timestamp", Long.valueOf(zzg2.zzl()));
            contentValues.put(Constants.ScionAnalytics.MessageType.DATA_MESSAGE, zzc2);
            contentValues.put("has_realtime", Integer.valueOf(z ? 1 : 0));
            if (zzg2.zzaz()) {
                contentValues.put("retry_count", Integer.valueOf(zzg2.zzba()));
            }
            try {
                if (c_().insert("queue", null, contentValues) != -1) {
                    return true;
                }
                zzq().zze().zza("Failed to insert bundle (got -1). appId", zzeq.zza(zzg2.zzx()));
                return false;
            } catch (SQLiteException e) {
                zzq().zze().zza("Error storing bundle. appId", zzeq.zza(zzg2.zzx()), e);
                return false;
            }
        } catch (IOException e2) {
            zzq().zze().zza("Data loss. Failed to serialize bundle. appId", zzeq.zza(zzg2.zzx()), e2);
            return false;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x003a  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0041  */
    public final String d_() {
        Throwable th;
        Cursor cursor;
        SQLiteException e;
        try {
            cursor = c_().rawQuery("select app_id from queue order by has_realtime desc, rowid asc limit 1;", null);
            try {
                if (cursor.moveToFirst()) {
                    String string = cursor.getString(0);
                    if (cursor != null) {
                        cursor.close();
                    }
                    return string;
                }
                if (cursor != null) {
                    cursor.close();
                }
                return null;
            } catch (SQLiteException e2) {
                e = e2;
                try {
                    zzq().zze().zza("Database error getting next bundle app id", e);
                    if (cursor != null) {
                    }
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    if (cursor != null) {
                    }
                    throw th;
                }
            }
        } catch (SQLiteException e3) {
            e = e3;
            cursor = null;
            zzq().zze().zza("Database error getting next bundle app id", e);
            if (cursor != null) {
                cursor.close();
            }
            return null;
        } catch (Throwable th3) {
            th = th3;
            cursor = null;
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    public final boolean e_() {
        return zzb("select count(1) > 0 from queue where has_realtime = 1", null) != 0;
    }

    public final List<Pair<zzcd.zzg, Long>> zza(String str, int i, int i2) {
        zzc();
        zzaj();
        Preconditions.checkArgument(i > 0);
        Preconditions.checkArgument(i2 > 0);
        Preconditions.checkNotEmpty(str);
        Cursor cursor = null;
        try {
            Cursor query = c_().query("queue", new String[]{"rowid", Constants.ScionAnalytics.MessageType.DATA_MESSAGE, "retry_count"}, "app_id=?", new String[]{str}, null, null, "rowid", String.valueOf(i));
            if (!query.moveToFirst()) {
                List<Pair<zzcd.zzg, Long>> emptyList = Collections.emptyList();
                if (query != null) {
                    query.close();
                }
                return emptyList;
            }
            ArrayList arrayList = new ArrayList();
            int i3 = 0;
            do {
                long j = query.getLong(0);
                try {
                    byte[] zzb2 = f_().zzb(query.getBlob(1));
                    if (!arrayList.isEmpty() && zzb2.length + i3 > i2) {
                        break;
                    }
                    try {
                        zzcd.zzg.zza zza = (zzcd.zzg.zza) zzkr.zza(zzcd.zzg.zzbh(), zzb2);
                        if (!query.isNull(2)) {
                            zza.zzi(query.getInt(2));
                        }
                        i3 += zzb2.length;
                        arrayList.add(Pair.create((zzcd.zzg) ((zzhy) zza.zzy()), Long.valueOf(j)));
                    } catch (IOException e) {
                        zzq().zze().zza("Failed to merge queued bundle. appId", zzeq.zza(str), e);
                    }
                    if (!query.moveToNext()) {
                        break;
                    }
                } catch (IOException e2) {
                    zzq().zze().zza("Failed to unzip queued bundle. appId", zzeq.zza(str), e2);
                }
            } while (i3 <= i2);
            if (query != null) {
                query.close();
            }
            return arrayList;
        } catch (SQLiteException e3) {
            zzq().zze().zza("Error querying bundles. appId", zzeq.zza(str), e3);
            List<Pair<zzcd.zzg, Long>> emptyList2 = Collections.emptyList();
            if (0 != 0) {
                cursor.close();
            }
            return emptyList2;
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            throw th;
        }
    }

    public final void zzu() {
        int delete;
        zzc();
        zzaj();
        if (zzal()) {
            long zza = zzr().zzf.zza();
            long elapsedRealtime = zzl().elapsedRealtime();
            if (Math.abs(elapsedRealtime - zza) > zzas.zzx.zza(null).longValue()) {
                zzr().zzf.zza(elapsedRealtime);
                zzc();
                zzaj();
                if (zzal() && (delete = c_().delete("queue", "abs(bundle_end_timestamp - ?) > cast(? as integer)", new String[]{String.valueOf(zzl().currentTimeMillis()), String.valueOf(zzab.zzu())})) > 0) {
                    zzq().zzw().zza("Deleted stale rows. rowsDeleted", Integer.valueOf(delete));
                }
            }
        }
    }

    public final void zza(List<Long> list) {
        zzc();
        zzaj();
        Preconditions.checkNotNull(list);
        Preconditions.checkNotZero(list.size());
        if (zzal()) {
            String join = TextUtils.join(",", list);
            StringBuilder sb = new StringBuilder(String.valueOf(join).length() + 2);
            sb.append("(");
            sb.append(join);
            sb.append(")");
            String sb2 = sb.toString();
            StringBuilder sb3 = new StringBuilder(String.valueOf(sb2).length() + 80);
            sb3.append("SELECT COUNT(1) FROM queue WHERE rowid IN ");
            sb3.append(sb2);
            sb3.append(" AND retry_count =  2147483647 LIMIT 1");
            if (zzb(sb3.toString(), (String[]) null) > 0) {
                zzq().zzh().zza("The number of upload retries exceeds the limit. Will remain unchanged.");
            }
            try {
                SQLiteDatabase c_ = c_();
                StringBuilder sb4 = new StringBuilder(String.valueOf(sb2).length() + 127);
                sb4.append("UPDATE queue SET retry_count = IFNULL(retry_count, 0) + 1 WHERE rowid IN ");
                sb4.append(sb2);
                sb4.append(" AND (retry_count IS NULL OR retry_count < 2147483647)");
                c_.execSQL(sb4.toString());
            } catch (SQLiteException e) {
                zzq().zze().zza("Error incrementing retry count. error", e);
            }
        }
    }

    private final boolean zza(String str, int i, zzbv.zzb zzb2) {
        zzaj();
        zzc();
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzb2);
        Integer num = null;
        if (TextUtils.isEmpty(zzb2.zzc())) {
            zzes zzh2 = zzq().zzh();
            Object zza = zzeq.zza(str);
            Integer valueOf = Integer.valueOf(i);
            if (zzb2.zza()) {
                num = Integer.valueOf(zzb2.zzb());
            }
            zzh2.zza("Event filter had no event name. Audience definition ignored. appId, audienceId, filterId", zza, valueOf, String.valueOf(num));
            return false;
        }
        byte[] zzbk = zzb2.zzbk();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("audience_id", Integer.valueOf(i));
        contentValues.put("filter_id", zzb2.zza() ? Integer.valueOf(zzb2.zzb()) : null);
        contentValues.put("event_name", zzb2.zzc());
        contentValues.put("session_scoped", zzb2.zzj() ? Boolean.valueOf(zzb2.zzk()) : null);
        contentValues.put(Constants.ScionAnalytics.MessageType.DATA_MESSAGE, zzbk);
        try {
            if (c_().insertWithOnConflict("event_filters", null, contentValues, 5) != -1) {
                return true;
            }
            zzq().zze().zza("Failed to insert event filter (got -1). appId", zzeq.zza(str));
            return true;
        } catch (SQLiteException e) {
            zzq().zze().zza("Error storing event filter. appId", zzeq.zza(str), e);
            return false;
        }
    }

    private final boolean zza(String str, int i, zzbv.zze zze2) {
        zzaj();
        zzc();
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zze2);
        Integer num = null;
        if (TextUtils.isEmpty(zze2.zzc())) {
            zzes zzh2 = zzq().zzh();
            Object zza = zzeq.zza(str);
            Integer valueOf = Integer.valueOf(i);
            if (zze2.zza()) {
                num = Integer.valueOf(zze2.zzb());
            }
            zzh2.zza("Property filter had no property name. Audience definition ignored. appId, audienceId, filterId", zza, valueOf, String.valueOf(num));
            return false;
        }
        byte[] zzbk = zze2.zzbk();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("audience_id", Integer.valueOf(i));
        contentValues.put("filter_id", zze2.zza() ? Integer.valueOf(zze2.zzb()) : null);
        contentValues.put("property_name", zze2.zzc());
        contentValues.put("session_scoped", zze2.zzg() ? Boolean.valueOf(zze2.zzh()) : null);
        contentValues.put(Constants.ScionAnalytics.MessageType.DATA_MESSAGE, zzbk);
        try {
            if (c_().insertWithOnConflict("property_filters", null, contentValues, 5) != -1) {
                return true;
            }
            zzq().zze().zza("Failed to insert property filter (got -1). appId", zzeq.zza(str));
            return false;
        } catch (SQLiteException e) {
            zzq().zze().zza("Error storing property filter. appId", zzeq.zza(str), e);
            return false;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:38:0x00cb  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00d3  */
    public final Map<Integer, List<zzbv.zzb>> zzf(String str, String str2) {
        Throwable th;
        Cursor cursor;
        SQLiteException e;
        zzaj();
        zzc();
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        ArrayMap arrayMap = new ArrayMap();
        Cursor cursor2 = null;
        try {
            cursor = c_().query("event_filters", new String[]{"audience_id", Constants.ScionAnalytics.MessageType.DATA_MESSAGE}, "app_id=? AND event_name=?", new String[]{str, str2}, null, null, null);
            try {
                if (!cursor.moveToFirst()) {
                    Map<Integer, List<zzbv.zzb>> emptyMap = Collections.emptyMap();
                    if (cursor != null) {
                        cursor.close();
                    }
                    return emptyMap;
                }
                do {
                    try {
                        zzbv.zzb zzb2 = (zzbv.zzb) ((zzhy) ((zzbv.zzb.zza) zzkr.zza(zzbv.zzb.zzl(), cursor.getBlob(1))).zzy());
                        int i = cursor.getInt(0);
                        List list = (List) arrayMap.get(Integer.valueOf(i));
                        if (list == null) {
                            list = new ArrayList();
                            arrayMap.put(Integer.valueOf(i), list);
                        }
                        list.add(zzb2);
                    } catch (IOException e2) {
                        zzq().zze().zza("Failed to merge filter. appId", zzeq.zza(str), e2);
                    }
                } while (cursor.moveToNext());
                if (cursor != null) {
                    cursor.close();
                }
                return arrayMap;
            } catch (SQLiteException e3) {
                e = e3;
                try {
                    zzq().zze().zza("Database error querying filters. appId", zzeq.zza(str), e);
                    if (zznd.zzb()) {
                    }
                    if (cursor != null) {
                    }
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    cursor2 = cursor;
                    if (cursor2 != null) {
                    }
                    throw th;
                }
            }
        } catch (SQLiteException e4) {
            e = e4;
            cursor = null;
            zzq().zze().zza("Database error querying filters. appId", zzeq.zza(str), e);
            if (zznd.zzb() || !zzs().zze(str, zzas.zzce)) {
                if (cursor != null) {
                    cursor.close();
                }
                return null;
            }
            Map<Integer, List<zzbv.zzb>> emptyMap2 = Collections.emptyMap();
            if (cursor != null) {
                cursor.close();
            }
            return emptyMap2;
        } catch (Throwable th3) {
            th = th3;
            if (cursor2 != null) {
                cursor2.close();
            }
            throw th;
        }
    }

    public final Map<Integer, List<zzbv.zzb>> zze(String str) {
        Preconditions.checkNotEmpty(str);
        ArrayMap arrayMap = new ArrayMap();
        SQLiteDatabase c_ = c_();
        Cursor cursor = null;
        try {
            Cursor query = c_.query("event_filters", new String[]{"audience_id", Constants.ScionAnalytics.MessageType.DATA_MESSAGE}, "app_id=?", new String[]{str}, null, null, null);
            if (!query.moveToFirst()) {
                Map<Integer, List<zzbv.zzb>> emptyMap = Collections.emptyMap();
                if (query != null) {
                    query.close();
                }
                return emptyMap;
            }
            do {
                try {
                    zzbv.zzb zzb2 = (zzbv.zzb) ((zzhy) ((zzbv.zzb.zza) zzkr.zza(zzbv.zzb.zzl(), query.getBlob(1))).zzy());
                    if (zzb2.zzf()) {
                        int i = query.getInt(0);
                        List list = (List) arrayMap.get(Integer.valueOf(i));
                        if (list == null) {
                            list = new ArrayList();
                            arrayMap.put(Integer.valueOf(i), list);
                        }
                        list.add(zzb2);
                    }
                } catch (IOException e) {
                    zzq().zze().zza("Failed to merge filter. appId", zzeq.zza(str), e);
                }
            } while (query.moveToNext());
            if (query != null) {
                query.close();
            }
            return arrayMap;
        } catch (SQLiteException e2) {
            zzq().zze().zza("Database error querying filters. appId", zzeq.zza(str), e2);
            Map<Integer, List<zzbv.zzb>> emptyMap2 = Collections.emptyMap();
            if (0 != 0) {
                cursor.close();
            }
            return emptyMap2;
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            throw th;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:38:0x00cb  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00d3  */
    public final Map<Integer, List<zzbv.zze>> zzg(String str, String str2) {
        Throwable th;
        Cursor cursor;
        SQLiteException e;
        zzaj();
        zzc();
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        ArrayMap arrayMap = new ArrayMap();
        Cursor cursor2 = null;
        try {
            cursor = c_().query("property_filters", new String[]{"audience_id", Constants.ScionAnalytics.MessageType.DATA_MESSAGE}, "app_id=? AND property_name=?", new String[]{str, str2}, null, null, null);
            try {
                if (!cursor.moveToFirst()) {
                    Map<Integer, List<zzbv.zze>> emptyMap = Collections.emptyMap();
                    if (cursor != null) {
                        cursor.close();
                    }
                    return emptyMap;
                }
                do {
                    try {
                        zzbv.zze zze2 = (zzbv.zze) ((zzhy) ((zzbv.zze.zza) zzkr.zza(zzbv.zze.zzi(), cursor.getBlob(1))).zzy());
                        int i = cursor.getInt(0);
                        List list = (List) arrayMap.get(Integer.valueOf(i));
                        if (list == null) {
                            list = new ArrayList();
                            arrayMap.put(Integer.valueOf(i), list);
                        }
                        list.add(zze2);
                    } catch (IOException e2) {
                        zzq().zze().zza("Failed to merge filter", zzeq.zza(str), e2);
                    }
                } while (cursor.moveToNext());
                if (cursor != null) {
                    cursor.close();
                }
                return arrayMap;
            } catch (SQLiteException e3) {
                e = e3;
                try {
                    zzq().zze().zza("Database error querying filters. appId", zzeq.zza(str), e);
                    if (zznd.zzb()) {
                    }
                    if (cursor != null) {
                    }
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    cursor2 = cursor;
                    if (cursor2 != null) {
                    }
                    throw th;
                }
            }
        } catch (SQLiteException e4) {
            e = e4;
            cursor = null;
            zzq().zze().zza("Database error querying filters. appId", zzeq.zza(str), e);
            if (zznd.zzb() || !zzs().zze(str, zzas.zzce)) {
                if (cursor != null) {
                    cursor.close();
                }
                return null;
            }
            Map<Integer, List<zzbv.zze>> emptyMap2 = Collections.emptyMap();
            if (cursor != null) {
                cursor.close();
            }
            return emptyMap2;
        } catch (Throwable th3) {
            th = th3;
            if (cursor2 != null) {
                cursor2.close();
            }
            throw th;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:32:0x009a  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00a2  */
    public final Map<Integer, List<Integer>> zzf(String str) {
        Throwable th;
        Cursor cursor;
        SQLiteException e;
        zzaj();
        zzc();
        Preconditions.checkNotEmpty(str);
        ArrayMap arrayMap = new ArrayMap();
        Cursor cursor2 = null;
        try {
            cursor = c_().rawQuery("select audience_id, filter_id from event_filters where app_id = ? and session_scoped = 1 UNION select audience_id, filter_id from property_filters where app_id = ? and session_scoped = 1;", new String[]{str, str});
            try {
                if (!cursor.moveToFirst()) {
                    Map<Integer, List<Integer>> emptyMap = Collections.emptyMap();
                    if (cursor != null) {
                        cursor.close();
                    }
                    return emptyMap;
                }
                do {
                    int i = cursor.getInt(0);
                    List list = (List) arrayMap.get(Integer.valueOf(i));
                    if (list == null) {
                        list = new ArrayList();
                        arrayMap.put(Integer.valueOf(i), list);
                    }
                    list.add(Integer.valueOf(cursor.getInt(1)));
                } while (cursor.moveToNext());
                if (cursor != null) {
                    cursor.close();
                }
                return arrayMap;
            } catch (SQLiteException e2) {
                e = e2;
                try {
                    zzq().zze().zza("Database error querying scoped filters. appId", zzeq.zza(str), e);
                    if (zznd.zzb()) {
                    }
                    if (cursor != null) {
                    }
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    cursor2 = cursor;
                    if (cursor2 != null) {
                    }
                    throw th;
                }
            }
        } catch (SQLiteException e3) {
            e = e3;
            cursor = null;
            zzq().zze().zza("Database error querying scoped filters. appId", zzeq.zza(str), e);
            if (zznd.zzb() || !zzs().zze(str, zzas.zzce)) {
                if (cursor != null) {
                    cursor.close();
                }
                return null;
            }
            Map<Integer, List<Integer>> emptyMap2 = Collections.emptyMap();
            if (cursor != null) {
                cursor.close();
            }
            return emptyMap2;
        } catch (Throwable th3) {
            th = th3;
            if (cursor2 != null) {
                cursor2.close();
            }
            throw th;
        }
    }

    private final boolean zzb(String str, List<Integer> list) {
        Preconditions.checkNotEmpty(str);
        zzaj();
        zzc();
        SQLiteDatabase c_ = c_();
        try {
            long zzb2 = zzb("select count(1) from audience_filter_values where app_id=?", new String[]{str});
            int max = Math.max(0, Math.min(2000, zzs().zzb(str, zzas.zzae)));
            if (zzb2 <= ((long) max)) {
                return false;
            }
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < list.size(); i++) {
                Integer num = list.get(i);
                if (num == null || !(num instanceof Integer)) {
                    return false;
                }
                arrayList.add(Integer.toString(num.intValue()));
            }
            String join = TextUtils.join(",", arrayList);
            StringBuilder sb = new StringBuilder(String.valueOf(join).length() + 2);
            sb.append("(");
            sb.append(join);
            sb.append(")");
            String sb2 = sb.toString();
            StringBuilder sb3 = new StringBuilder(String.valueOf(sb2).length() + 140);
            sb3.append("audience_id in (select audience_id from audience_filter_values where app_id=? and audience_id not in ");
            sb3.append(sb2);
            sb3.append(" order by rowid desc limit -1 offset ?)");
            return c_.delete("audience_filter_values", sb3.toString(), new String[]{str, Integer.toString(max)}) > 0;
        } catch (SQLiteException e) {
            zzq().zze().zza("Database error querying filters. appId", zzeq.zza(str), e);
            return false;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:43:0x00cd  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00d5  */
    public final Map<Integer, zzcd.zzi> zzg(String str) {
        Throwable th;
        SQLiteException e;
        Cursor cursor;
        zzaj();
        zzc();
        Preconditions.checkNotEmpty(str);
        Cursor cursor2 = null;
        try {
            cursor = c_().query("audience_filter_values", new String[]{"audience_id", "current_results"}, "app_id=?", new String[]{str}, null, null, null);
            try {
                if (cursor.moveToFirst()) {
                    ArrayMap arrayMap = new ArrayMap();
                    do {
                        int i = cursor.getInt(0);
                        try {
                            arrayMap.put(Integer.valueOf(i), (zzcd.zzi) ((zzhy) ((zzcd.zzi.zza) zzkr.zza(zzcd.zzi.zzi(), cursor.getBlob(1))).zzy()));
                        } catch (IOException e2) {
                            zzq().zze().zza("Failed to merge filter results. appId, audienceId, error", zzeq.zza(str), Integer.valueOf(i), e2);
                        }
                    } while (cursor.moveToNext());
                    if (cursor != null) {
                        cursor.close();
                    }
                    return arrayMap;
                } else if (!zznd.zzb() || !zzs().zze(str, zzas.zzce)) {
                    if (cursor != null) {
                        cursor.close();
                    }
                    return null;
                } else {
                    Map<Integer, zzcd.zzi> emptyMap = Collections.emptyMap();
                    if (cursor != null) {
                        cursor.close();
                    }
                    return emptyMap;
                }
            } catch (SQLiteException e3) {
                e = e3;
                try {
                    zzq().zze().zza("Database error querying filter results. appId", zzeq.zza(str), e);
                    if (zznd.zzb()) {
                    }
                    if (cursor != null) {
                    }
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    cursor2 = cursor;
                    if (cursor2 != null) {
                    }
                    throw th;
                }
            }
        } catch (SQLiteException e4) {
            e = e4;
            cursor = null;
            zzq().zze().zza("Database error querying filter results. appId", zzeq.zza(str), e);
            if (zznd.zzb() || !zzs().zze(str, zzas.zzce)) {
                if (cursor != null) {
                    cursor.close();
                }
                return null;
            }
            Map<Integer, zzcd.zzi> emptyMap2 = Collections.emptyMap();
            if (cursor != null) {
                cursor.close();
            }
            return emptyMap2;
        } catch (Throwable th3) {
            th = th3;
            if (cursor2 != null) {
                cursor2.close();
            }
            throw th;
        }
    }

    private static void zza(ContentValues contentValues, String str, Object obj) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(obj);
        if (obj instanceof String) {
            contentValues.put(str, (String) obj);
        } else if (obj instanceof Long) {
            contentValues.put(str, (Long) obj);
        } else if (obj instanceof Double) {
            contentValues.put(str, (Double) obj);
        } else {
            throw new IllegalArgumentException("Invalid value type");
        }
    }

    private final Object zza(Cursor cursor, int i) {
        int type = cursor.getType(i);
        if (type == 0) {
            zzq().zze().zza("Loaded invalid null value from database");
            return null;
        } else if (type == 1) {
            return Long.valueOf(cursor.getLong(i));
        } else {
            if (type == 2) {
                return Double.valueOf(cursor.getDouble(i));
            }
            if (type == 3) {
                return cursor.getString(i);
            }
            if (type != 4) {
                zzq().zze().zza("Loaded invalid unknown value type, ignoring it", Integer.valueOf(type));
                return null;
            }
            zzq().zze().zza("Loaded invalid blob type value, ignoring it");
            return null;
        }
    }

    public final long zzv() {
        return zza("select max(bundle_end_timestamp) from queue", (String[]) null, 0);
    }

    public final long zzh(String str, String str2) {
        SQLiteException e;
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        zzc();
        zzaj();
        SQLiteDatabase c_ = c_();
        c_.beginTransaction();
        long j = 0;
        try {
            StringBuilder sb = new StringBuilder(String.valueOf(str2).length() + 32);
            sb.append("select ");
            sb.append(str2);
            sb.append(" from app2 where app_id=?");
            long zza = zza(sb.toString(), new String[]{str}, -1);
            if (zza == -1) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("app_id", str);
                contentValues.put("first_open_count", (Integer) 0);
                contentValues.put("previous_install_count", (Integer) 0);
                if (c_.insertWithOnConflict("app2", null, contentValues, 5) == -1) {
                    zzq().zze().zza("Failed to insert column (got -1). appId", zzeq.zza(str), str2);
                    c_.endTransaction();
                    return -1;
                }
                zza = 0;
            }
            try {
                ContentValues contentValues2 = new ContentValues();
                contentValues2.put("app_id", str);
                contentValues2.put(str2, Long.valueOf(1 + zza));
                if (((long) c_.update("app2", contentValues2, "app_id = ?", new String[]{str})) == 0) {
                    zzq().zze().zza("Failed to update column (got 0). appId", zzeq.zza(str), str2);
                    c_.endTransaction();
                    return -1;
                }
                c_.setTransactionSuccessful();
                c_.endTransaction();
                return zza;
            } catch (SQLiteException e2) {
                e = e2;
                j = zza;
                try {
                    zzq().zze().zza("Error inserting column. appId", zzeq.zza(str), str2, e);
                    return j;
                } finally {
                    c_.endTransaction();
                }
            }
        } catch (SQLiteException e3) {
            e = e3;
            zzq().zze().zza("Error inserting column. appId", zzeq.zza(str), str2, e);
            return j;
        }
    }

    public final long zzw() {
        return zza("select max(timestamp) from raw_events", (String[]) null, 0);
    }

    public final long zza(zzcd.zzg zzg2) {
        zzc();
        zzaj();
        Preconditions.checkNotNull(zzg2);
        Preconditions.checkNotEmpty(zzg2.zzx());
        byte[] zzbk = zzg2.zzbk();
        long zza = f_().zza(zzbk);
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", zzg2.zzx());
        contentValues.put("metadata_fingerprint", Long.valueOf(zza));
        contentValues.put("metadata", zzbk);
        try {
            c_().insertWithOnConflict("raw_events_metadata", null, contentValues, 4);
            return zza;
        } catch (SQLiteException e) {
            zzq().zze().zza("Error storing raw event metadata. appId", zzeq.zza(zzg2.zzx()), e);
            throw e;
        }
    }

    public final boolean zzx() {
        return zzb("select count(1) > 0 from raw_events", null) != 0;
    }

    public final boolean zzy() {
        return zzb("select count(1) > 0 from raw_events where realtime = 1", null) != 0;
    }

    public final long zzh(String str) {
        Preconditions.checkNotEmpty(str);
        return zza("select count(1) from events where app_id=? and name not like '!_%' escape '!'", new String[]{str}, 0);
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0053  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x005b  */
    public final String zza(long j) {
        Throwable th;
        SQLiteException e;
        Cursor cursor;
        zzc();
        zzaj();
        Cursor cursor2 = null;
        try {
            cursor = c_().rawQuery("select app_id from apps where app_id in (select distinct app_id from raw_events) and config_fetched_time < ? order by failed_config_fetch_time limit 1;", new String[]{String.valueOf(j)});
            try {
                if (!cursor.moveToFirst()) {
                    zzq().zzw().zza("No expired configs for apps with pending events");
                    if (cursor != null) {
                        cursor.close();
                    }
                    return null;
                }
                String string = cursor.getString(0);
                if (cursor != null) {
                    cursor.close();
                }
                return string;
            } catch (SQLiteException e2) {
                e = e2;
                try {
                    zzq().zze().zza("Error selecting expired configs", e);
                    if (cursor != null) {
                    }
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    cursor2 = cursor;
                    if (cursor2 != null) {
                    }
                    throw th;
                }
            }
        } catch (SQLiteException e3) {
            e = e3;
            cursor = null;
            zzq().zze().zza("Error selecting expired configs", e);
            if (cursor != null) {
                cursor.close();
            }
            return null;
        } catch (Throwable th3) {
            th = th3;
            if (cursor2 != null) {
                cursor2.close();
            }
            throw th;
        }
    }

    public final long zzz() {
        Cursor cursor = null;
        try {
            cursor = c_().rawQuery("select rowid from raw_events order by rowid desc limit 1;", null);
            if (!cursor.moveToFirst()) {
                if (cursor != null) {
                    cursor.close();
                }
                return -1;
            }
            long j = cursor.getLong(0);
            if (cursor != null) {
                cursor.close();
            }
            return j;
        } catch (SQLiteException e) {
            zzq().zze().zza("Error querying raw events", e);
            if (cursor != null) {
                cursor.close();
            }
            return -1;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x008c  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0094  */
    public final Pair<zzcd.zzc, Long> zza(String str, Long l) {
        Throwable th;
        SQLiteException e;
        Cursor cursor;
        zzc();
        zzaj();
        Cursor cursor2 = null;
        try {
            cursor = c_().rawQuery("select main_event, children_to_process from main_event_params where app_id=? and event_id=?", new String[]{str, String.valueOf(l)});
            try {
                if (!cursor.moveToFirst()) {
                    zzq().zzw().zza("Main event not found");
                    if (cursor != null) {
                        cursor.close();
                    }
                    return null;
                }
                try {
                    Pair<zzcd.zzc, Long> create = Pair.create((zzcd.zzc) ((zzhy) ((zzcd.zzc.zza) zzkr.zza(zzcd.zzc.zzj(), cursor.getBlob(0))).zzy()), Long.valueOf(cursor.getLong(1)));
                    if (cursor != null) {
                        cursor.close();
                    }
                    return create;
                } catch (IOException e2) {
                    zzq().zze().zza("Failed to merge main event. appId, eventId", zzeq.zza(str), l, e2);
                    if (cursor != null) {
                        cursor.close();
                    }
                    return null;
                }
            } catch (SQLiteException e3) {
                e = e3;
                try {
                    zzq().zze().zza("Error selecting main event", e);
                    if (cursor != null) {
                    }
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    cursor2 = cursor;
                    if (cursor2 != null) {
                        cursor2.close();
                    }
                    throw th;
                }
            }
        } catch (SQLiteException e4) {
            e = e4;
            cursor = null;
            zzq().zze().zza("Error selecting main event", e);
            if (cursor != null) {
                cursor.close();
            }
            return null;
        } catch (Throwable th3) {
            th = th3;
            if (cursor2 != null) {
            }
            throw th;
        }
    }

    public final boolean zza(String str, Long l, long j, zzcd.zzc zzc2) {
        zzc();
        zzaj();
        Preconditions.checkNotNull(zzc2);
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(l);
        byte[] zzbk = zzc2.zzbk();
        zzq().zzw().zza("Saving complex main event, appId, data size", zzn().zza(str), Integer.valueOf(zzbk.length));
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("event_id", l);
        contentValues.put("children_to_process", Long.valueOf(j));
        contentValues.put("main_event", zzbk);
        try {
            if (c_().insertWithOnConflict("main_event_params", null, contentValues, 5) != -1) {
                return true;
            }
            zzq().zze().zza("Failed to insert complex main event (got -1). appId", zzeq.zza(str));
            return false;
        } catch (SQLiteException e) {
            zzq().zze().zza("Error storing complex main event. appId", zzeq.zza(str), e);
            return false;
        }
    }

    public final boolean zza(String str, Bundle bundle) {
        zzc();
        zzaj();
        byte[] zzbk = f_().zza(new zzan(this.zzy, "", str, "dep", 0, 0, bundle)).zzbk();
        zzq().zzw().zza("Saving default event parameters, appId, data size", zzn().zza(str), Integer.valueOf(zzbk.length));
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("parameters", zzbk);
        try {
            if (c_().insertWithOnConflict("default_event_params", null, contentValues, 5) != -1) {
                return true;
            }
            zzq().zze().zza("Failed to insert default event parameters (got -1). appId", zzeq.zza(str));
            return false;
        } catch (SQLiteException e) {
            zzq().zze().zza("Error storing default event parameters. appId", zzeq.zza(str), e);
            return false;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:43:0x00d1  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00d9  */
    public final Bundle zzi(String str) {
        Throwable th;
        SQLiteException e;
        Cursor cursor;
        zzc();
        zzaj();
        Cursor cursor2 = null;
        try {
            cursor = c_().rawQuery("select parameters from default_event_params where app_id=?", new String[]{str});
            try {
                if (!cursor.moveToFirst()) {
                    zzq().zzw().zza("Default event parameters not found");
                    if (cursor != null) {
                        cursor.close();
                    }
                    return null;
                }
                try {
                    zzcd.zzc zzc2 = (zzcd.zzc) ((zzhy) ((zzcd.zzc.zza) zzkr.zza(zzcd.zzc.zzj(), cursor.getBlob(0))).zzy());
                    f_();
                    List<zzcd.zze> zza = zzc2.zza();
                    Bundle bundle = new Bundle();
                    for (zzcd.zze zze2 : zza) {
                        String zzb2 = zze2.zzb();
                        if (zze2.zzi()) {
                            bundle.putDouble(zzb2, zze2.zzj());
                        } else if (zze2.zzg()) {
                            bundle.putFloat(zzb2, zze2.zzh());
                        } else if (zze2.zzc()) {
                            bundle.putString(zzb2, zze2.zzd());
                        } else if (zze2.zze()) {
                            bundle.putLong(zzb2, zze2.zzf());
                        }
                    }
                    if (cursor != null) {
                        cursor.close();
                    }
                    return bundle;
                } catch (IOException e2) {
                    zzq().zze().zza("Failed to retrieve default event parameters. appId", zzeq.zza(str), e2);
                    if (cursor != null) {
                        cursor.close();
                    }
                    return null;
                }
            } catch (SQLiteException e3) {
                e = e3;
                try {
                    zzq().zze().zza("Error selecting default event parameters", e);
                    if (cursor != null) {
                    }
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    cursor2 = cursor;
                    if (cursor2 != null) {
                    }
                    throw th;
                }
            }
        } catch (SQLiteException e4) {
            e = e4;
            cursor = null;
            zzq().zze().zza("Error selecting default event parameters", e);
            if (cursor != null) {
                cursor.close();
            }
            return null;
        } catch (Throwable th3) {
            th = th3;
            if (cursor2 != null) {
                cursor2.close();
            }
            throw th;
        }
    }

    public final zzac zzj(String str) {
        Preconditions.checkNotNull(str);
        zzc();
        zzaj();
        return zzac.zza(zza("select consent_state from consent_settings where app_id=? limit 1;", new String[]{str}, "G1"));
    }

    public final boolean zza(zzan zzan, long j, boolean z) {
        zzc();
        zzaj();
        Preconditions.checkNotNull(zzan);
        Preconditions.checkNotEmpty(zzan.zza);
        byte[] zzbk = f_().zza(zzan).zzbk();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", zzan.zza);
        contentValues.put("name", zzan.zzb);
        contentValues.put("timestamp", Long.valueOf(zzan.zzc));
        contentValues.put("metadata_fingerprint", Long.valueOf(j));
        contentValues.put(Constants.ScionAnalytics.MessageType.DATA_MESSAGE, zzbk);
        contentValues.put("realtime", Integer.valueOf(z ? 1 : 0));
        try {
            if (c_().insert("raw_events", null, contentValues) != -1) {
                return true;
            }
            zzq().zze().zza("Failed to insert raw event (got -1). appId", zzeq.zza(zzan.zza));
            return false;
        } catch (SQLiteException e) {
            zzq().zze().zza("Error storing raw event. appId", zzeq.zza(zzan.zza), e);
            return false;
        }
    }

    public final void zza(String str, List<zzbv.zza> list) {
        boolean z;
        boolean z2;
        Preconditions.checkNotNull(list);
        for (int i = 0; i < list.size(); i++) {
            zzbv.zza.C0010zza zza = (zzbv.zza.C0010zza) list.get(i).zzbo();
            if (zza.zzb() != 0) {
                for (int i2 = 0; i2 < zza.zzb(); i2++) {
                    zzbv.zzb.zza zza2 = (zzbv.zzb.zza) zza.zzb(i2).zzbo();
                    zzbv.zzb.zza zza3 = (zzbv.zzb.zza) ((zzhy.zzb) zza2.clone());
                    String zzb2 = zzgv.zzb(zza2.zza());
                    if (zzb2 != null) {
                        zza3.zza(zzb2);
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    for (int i3 = 0; i3 < zza2.zzb(); i3++) {
                        zzbv.zzc zza4 = zza2.zza(i3);
                        String zza5 = zzgu.zza(zza4.zzh());
                        if (zza5 != null) {
                            zza3.zza(i3, (zzbv.zzc) ((zzhy) ((zzbv.zzc.zza) zza4.zzbo()).zza(zza5).zzy()));
                            z2 = true;
                        }
                    }
                    if (z2) {
                        zza = zza.zza(i2, zza3);
                        list.set(i, (zzbv.zza) ((zzhy) zza.zzy()));
                    }
                }
            }
            if (zza.zza() != 0) {
                for (int i4 = 0; i4 < zza.zza(); i4++) {
                    zzbv.zze zza6 = zza.zza(i4);
                    String zza7 = zzgx.zza(zza6.zzc());
                    if (zza7 != null) {
                        zza = zza.zza(i4, ((zzbv.zze.zza) zza6.zzbo()).zza(zza7));
                        list.set(i, (zzbv.zza) ((zzhy) zza.zzy()));
                    }
                }
            }
        }
        zzaj();
        zzc();
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(list);
        SQLiteDatabase c_ = c_();
        c_.beginTransaction();
        try {
            zzaj();
            zzc();
            Preconditions.checkNotEmpty(str);
            SQLiteDatabase c_2 = c_();
            c_2.delete("property_filters", "app_id=?", new String[]{str});
            c_2.delete("event_filters", "app_id=?", new String[]{str});
            for (zzbv.zza zza8 : list) {
                zzaj();
                zzc();
                Preconditions.checkNotEmpty(str);
                Preconditions.checkNotNull(zza8);
                if (!zza8.zza()) {
                    zzq().zzh().zza("Audience with no ID. appId", zzeq.zza(str));
                } else {
                    int zzb3 = zza8.zzb();
                    Iterator<zzbv.zzb> it = zza8.zze().iterator();
                    while (true) {
                        if (it.hasNext()) {
                            if (!it.next().zza()) {
                                zzq().zzh().zza("Event filter with no ID. Audience definition ignored. appId, audienceId", zzeq.zza(str), Integer.valueOf(zzb3));
                                break;
                            }
                        } else {
                            Iterator<zzbv.zze> it2 = zza8.zzc().iterator();
                            while (true) {
                                if (it2.hasNext()) {
                                    if (!it2.next().zza()) {
                                        zzq().zzh().zza("Property filter with no ID. Audience definition ignored. appId, audienceId", zzeq.zza(str), Integer.valueOf(zzb3));
                                        break;
                                    }
                                } else {
                                    Iterator<zzbv.zzb> it3 = zza8.zze().iterator();
                                    while (true) {
                                        if (it3.hasNext()) {
                                            if (!zza(str, zzb3, it3.next())) {
                                                z = false;
                                                break;
                                            }
                                        } else {
                                            z = true;
                                            break;
                                        }
                                    }
                                    if (z) {
                                        Iterator<zzbv.zze> it4 = zza8.zzc().iterator();
                                        while (true) {
                                            if (it4.hasNext()) {
                                                if (!zza(str, zzb3, it4.next())) {
                                                    z = false;
                                                    break;
                                                }
                                            } else {
                                                break;
                                            }
                                        }
                                    }
                                    if (!z) {
                                        zzaj();
                                        zzc();
                                        Preconditions.checkNotEmpty(str);
                                        SQLiteDatabase c_3 = c_();
                                        c_3.delete("property_filters", "app_id=? and audience_id=?", new String[]{str, String.valueOf(zzb3)});
                                        c_3.delete("event_filters", "app_id=? and audience_id=?", new String[]{str, String.valueOf(zzb3)});
                                    }
                                }
                            }
                        }
                    }
                }
            }
            ArrayList arrayList = new ArrayList();
            for (zzbv.zza zza9 : list) {
                arrayList.add(zza9.zza() ? Integer.valueOf(zza9.zzb()) : null);
            }
            zzb(str, arrayList);
            c_.setTransactionSuccessful();
        } finally {
            c_.endTransaction();
        }
    }

    private final boolean zzal() {
        return zzm().getDatabasePath("google_app_measurement.db").exists();
    }
}
