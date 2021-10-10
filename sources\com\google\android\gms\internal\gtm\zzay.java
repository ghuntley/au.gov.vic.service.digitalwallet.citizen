package com.google.android.gms.internal.gtm;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import android.text.TextUtils;
import com.bumptech.glide.load.Key;
import com.digitalwallet.utilities.DateFormattingHelper;
import com.google.android.gms.analytics.zzk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.HttpUtils;
import java.io.Closeable;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* access modifiers changed from: package-private */
public final class zzay extends zzan implements Closeable {
    private static final String zzxj = String.format("CREATE TABLE IF NOT EXISTS %s ( '%s' INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, '%s' INTEGER NOT NULL, '%s' TEXT NOT NULL, '%s' TEXT NOT NULL, '%s' INTEGER);", "hits2", "hit_id", "hit_time", "hit_url", "hit_string", "hit_app_id");
    private static final String zzxk = String.format("SELECT MAX(%s) FROM %s WHERE 1;", "hit_time", "hits2");
    private final zzaz zzxl;
    private final zzcv zzxm = new zzcv(zzcn());
    private final zzcv zzxn = new zzcv(zzcn());

    zzay(zzap zzap) {
        super(zzap);
        this.zzxl = new zzaz(this, zzap.getContext(), "google_analytics_v4.db");
    }

    /* access modifiers changed from: private */
    public static String zzdt() {
        return "google_analytics_v4.db";
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.gtm.zzan
    public final void zzaw() {
    }

    public final void beginTransaction() {
        zzdb();
        getWritableDatabase().beginTransaction();
    }

    public final void setTransactionSuccessful() {
        zzdb();
        getWritableDatabase().setTransactionSuccessful();
    }

    public final void endTransaction() {
        zzdb();
        getWritableDatabase().endTransaction();
    }

    public final void zzc(zzcd zzcd) {
        String str;
        Preconditions.checkNotNull(zzcd);
        zzk.zzav();
        zzdb();
        Preconditions.checkNotNull(zzcd);
        Uri.Builder builder = new Uri.Builder();
        for (Map.Entry<String, String> entry : zzcd.zzdm().entrySet()) {
            String key = entry.getKey();
            if (!"ht".equals(key) && !"qt".equals(key) && !"AppUID".equals(key)) {
                builder.appendQueryParameter(key, entry.getValue());
            }
        }
        String encodedQuery = builder.build().getEncodedQuery();
        if (encodedQuery == null) {
            encodedQuery = "";
        }
        if (encodedQuery.length() > 8192) {
            zzco().zza(zzcd, "Hit length exceeds the maximum allowed size");
            return;
        }
        int intValue = zzby.zzze.get().intValue();
        long zzdl = zzdl();
        if (zzdl > ((long) (intValue - 1))) {
            List<Long> zzc = zzc((zzdl - ((long) intValue)) + 1);
            zzd("Store full, deleting hits to make room, count", Integer.valueOf(zzc.size()));
            zza(zzc);
        }
        SQLiteDatabase writableDatabase = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("hit_string", encodedQuery);
        contentValues.put("hit_time", Long.valueOf(zzcd.zzfh()));
        contentValues.put("hit_app_id", Integer.valueOf(zzcd.zzff()));
        if (zzcd.zzfj()) {
            str = zzbq.zzet();
        } else {
            str = zzbq.zzeu();
        }
        contentValues.put("hit_url", str);
        try {
            long insert = writableDatabase.insert("hits2", null, contentValues);
            if (insert == -1) {
                zzu("Failed to insert a hit (got -1)");
            } else {
                zzb("Hit saved to database. db-id, hit", Long.valueOf(insert), zzcd);
            }
        } catch (SQLiteException e) {
            zze("Error storing a hit", e);
        }
    }

    private final long zzdl() {
        zzk.zzav();
        zzdb();
        return zza("SELECT COUNT(*) FROM hits2", (String[]) null);
    }

    /* access modifiers changed from: package-private */
    public final boolean isEmpty() {
        return zzdl() == 0;
    }

    private final List<Long> zzc(long j) {
        zzk.zzav();
        zzdb();
        if (j <= 0) {
            return Collections.emptyList();
        }
        SQLiteDatabase writableDatabase = getWritableDatabase();
        ArrayList arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            Cursor query = writableDatabase.query("hits2", new String[]{"hit_id"}, null, null, null, null, String.format("%s ASC", "hit_id"), Long.toString(j));
            if (query.moveToFirst()) {
                do {
                    arrayList.add(Long.valueOf(query.getLong(0)));
                } while (query.moveToNext());
            }
            if (query != null) {
                query.close();
            }
        } catch (SQLiteException e) {
            zzd("Error selecting hit ids", e);
            if (0 != 0) {
                cursor.close();
            }
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            throw th;
        }
        return arrayList;
    }

    public final List<zzcd> zzd(long j) {
        Preconditions.checkArgument(j >= 0);
        zzk.zzav();
        zzdb();
        Cursor cursor = null;
        try {
            Cursor query = getWritableDatabase().query("hits2", new String[]{"hit_id", "hit_time", "hit_string", "hit_url", "hit_app_id"}, null, null, null, null, String.format("%s ASC", "hit_id"), Long.toString(j));
            ArrayList arrayList = new ArrayList();
            if (query.moveToFirst()) {
                do {
                    long j2 = query.getLong(0);
                    arrayList.add(new zzcd(this, zzv(query.getString(2)), query.getLong(1), zzcz.zzaj(query.getString(3)), j2, query.getInt(4)));
                } while (query.moveToNext());
            }
            if (query != null) {
                query.close();
            }
            return arrayList;
        } catch (SQLiteException e) {
            zze("Error loading hits from the database", e);
            throw e;
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            throw th;
        }
    }

    public final void zza(List<Long> list) {
        Preconditions.checkNotNull(list);
        zzk.zzav();
        zzdb();
        if (!list.isEmpty()) {
            StringBuilder sb = new StringBuilder("hit_id");
            sb.append(" in (");
            for (int i = 0; i < list.size(); i++) {
                Long l = list.get(i);
                if (l == null || l.longValue() == 0) {
                    throw new SQLiteException("Invalid hit id");
                }
                if (i > 0) {
                    sb.append(",");
                }
                sb.append(l);
            }
            sb.append(")");
            String sb2 = sb.toString();
            try {
                SQLiteDatabase writableDatabase = getWritableDatabase();
                zza("Deleting dispatched hits. count", Integer.valueOf(list.size()));
                int delete = writableDatabase.delete("hits2", sb2, null);
                if (delete != list.size()) {
                    zzb("Deleted fewer hits then expected", Integer.valueOf(list.size()), Integer.valueOf(delete), sb2);
                }
            } catch (SQLiteException e) {
                zze("Error deleting hits", e);
                throw e;
            }
        }
    }

    public final void zze(long j) {
        zzk.zzav();
        zzdb();
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(Long.valueOf(j));
        zza("Deleting hit, id", Long.valueOf(j));
        zza(arrayList);
    }

    public final int zzdr() {
        zzk.zzav();
        zzdb();
        if (!this.zzxm.zzj(DateFormattingHelper.DAY_IN_MS)) {
            return 0;
        }
        this.zzxm.start();
        zzq("Deleting stale hits (if any)");
        int delete = getWritableDatabase().delete("hits2", "hit_time < ?", new String[]{Long.toString(zzcn().currentTimeMillis() - 2592000000L)});
        zza("Deleted stale hits, count", Integer.valueOf(delete));
        return delete;
    }

    public final long zzds() {
        zzk.zzav();
        zzdb();
        return zza(zzxk, (String[]) null, 0);
    }

    public final long zza(long j, String str, String str2) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        zzdb();
        zzk.zzav();
        return zza("SELECT hits_count FROM properties WHERE app_uid=? AND cid=? AND tid=?", new String[]{String.valueOf(j), str, str2}, 0);
    }

    public final List<zzas> zzf(long j) {
        zzdb();
        zzk.zzav();
        SQLiteDatabase writableDatabase = getWritableDatabase();
        Cursor cursor = null;
        try {
            int intValue = zzby.zzzg.get().intValue();
            Cursor query = writableDatabase.query("properties", new String[]{"cid", "tid", "adid", "hits_count", "params"}, "app_uid=?", new String[]{"0"}, null, null, null, String.valueOf(intValue));
            ArrayList arrayList = new ArrayList();
            if (query.moveToFirst()) {
                do {
                    String string = query.getString(0);
                    String string2 = query.getString(1);
                    boolean z = query.getInt(2) != 0;
                    long j2 = (long) query.getInt(3);
                    Map<String, String> zzw = zzw(query.getString(4));
                    if (!TextUtils.isEmpty(string)) {
                        if (!TextUtils.isEmpty(string2)) {
                            arrayList.add(new zzas(0, string, string2, z, j2, zzw));
                        }
                    }
                    zzc("Read property with empty client id or tracker id", string, string2);
                } while (query.moveToNext());
            }
            if (arrayList.size() >= intValue) {
                zzt("Sending hits to too many properties. Campaign report might be incorrect");
            }
            if (query != null) {
                query.close();
            }
            return arrayList;
        } catch (SQLiteException e) {
            zze("Error loading hits from the database", e);
            throw e;
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            throw th;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        try {
            this.zzxl.close();
        } catch (SQLiteException e) {
            zze("Sql error closing database", e);
        } catch (IllegalStateException e2) {
            zze("Error closing database", e2);
        }
    }

    private final long zza(String str, String[] strArr) {
        Cursor cursor = null;
        try {
            Cursor rawQuery = getWritableDatabase().rawQuery(str, null);
            if (rawQuery.moveToFirst()) {
                long j = rawQuery.getLong(0);
                if (rawQuery != null) {
                    rawQuery.close();
                }
                return j;
            }
            throw new SQLiteException("Database returned empty set");
        } catch (SQLiteException e) {
            zzd("Database error", str, e);
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
            Cursor rawQuery = getWritableDatabase().rawQuery(str, strArr);
            if (rawQuery.moveToFirst()) {
                long j2 = rawQuery.getLong(0);
                if (rawQuery != null) {
                    rawQuery.close();
                }
                return j2;
            } else if (rawQuery == null) {
                return 0;
            } else {
                rawQuery.close();
                return 0;
            }
        } catch (SQLiteException e) {
            zzd("Database error", str, e);
            throw e;
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            throw th;
        }
    }

    private final Map<String, String> zzv(String str) {
        if (TextUtils.isEmpty(str)) {
            return new HashMap(0);
        }
        try {
            if (!str.startsWith("?")) {
                String valueOf = String.valueOf(str);
                str = valueOf.length() != 0 ? "?".concat(valueOf) : new String("?");
            }
            return HttpUtils.parse(new URI(str), Key.STRING_CHARSET_NAME);
        } catch (URISyntaxException e) {
            zze("Error parsing hit parameters", e);
            return new HashMap(0);
        }
    }

    private final Map<String, String> zzw(String str) {
        if (TextUtils.isEmpty(str)) {
            return new HashMap(0);
        }
        try {
            String valueOf = String.valueOf(str);
            return HttpUtils.parse(new URI(valueOf.length() != 0 ? "?".concat(valueOf) : new String("?")), Key.STRING_CHARSET_NAME);
        } catch (URISyntaxException e) {
            zze("Error parsing property parameters", e);
            return new HashMap(0);
        }
    }

    /* access modifiers changed from: package-private */
    public final SQLiteDatabase getWritableDatabase() {
        try {
            return this.zzxl.getWritableDatabase();
        } catch (SQLiteException e) {
            zzd("Error opening database", e);
            throw e;
        }
    }
}
