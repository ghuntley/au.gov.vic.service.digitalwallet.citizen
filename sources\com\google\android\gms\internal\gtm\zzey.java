package com.google.android.gms.internal.gtm;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteConstraintException;
import android.database.sqlite.SQLiteCursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import androidx.browser.trusted.sharing.ShareTarget;
import com.digitalwallet.utilities.DateFormattingHelper;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.CrashUtils;
import com.google.android.gms.common.util.DefaultClock;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class zzey implements zzem {
    private static final String zzaog = String.format("CREATE TABLE IF NOT EXISTS %s ('%s' TEXT UNIQUE);", "gtm_hit_unique_ids", "hit_unique_id");
    private static final String zzaoh = String.format("CREATE TRIGGER IF NOT EXISTS %s DELETE ON %s FOR EACH ROW WHEN OLD.%s NOTNULL BEGIN     INSERT OR IGNORE INTO %s (%s) VALUES (OLD.%s); END;", "save_unique_on_delete", "gtm_hits", "hit_unique_id", "gtm_hit_unique_ids", "hit_unique_id", "hit_unique_id");
    private static final String zzaoi = String.format("CREATE TRIGGER IF NOT EXISTS %s BEFORE INSERT ON %s FOR EACH ROW WHEN NEW.%s NOT NULL BEGIN     SELECT RAISE(ABORT, 'Duplicate unique ID.')     WHERE EXISTS (SELECT 1 FROM %s WHERE %s = NEW.%s); END;", "check_unique_on_insert", "gtm_hits", "hit_unique_id", "gtm_hit_unique_ids", "hit_unique_id", "hit_unique_id");
    private static final String zzxj = String.format("CREATE TABLE IF NOT EXISTS %s ( '%s' INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, '%s' INTEGER NOT NULL, '%s' TEXT NOT NULL, '%s' INTEGER NOT NULL, '%s' TEXT NOT NULL, '%s' TEXT UNIQUE, '%s' TEXT, '%s' TEXT);", "gtm_hits", "hit_id", "hit_time", "hit_url", "hit_first_send_time", "hit_method", "hit_unique_id", "hit_headers", "hit_body");
    private final String zzaih;
    private long zzaii;
    private final int zzaij;
    private final zzfa zzaoj;
    private volatile zzed zzaok;
    private final zzen zzaol;
    private final Context zzrm;
    private Clock zzsd;

    zzey(zzen zzen, Context context) {
        this(zzen, context, "gtm_urls.db", 2000);
    }

    private zzey(zzen zzen, Context context, String str, int i) {
        Context applicationContext = context.getApplicationContext();
        this.zzrm = applicationContext;
        this.zzaih = str;
        this.zzaol = zzen;
        this.zzsd = DefaultClock.getInstance();
        this.zzaoj = new zzfa(this, applicationContext, str);
        this.zzaok = new zzfu(applicationContext, new zzez(this));
        this.zzaii = 0;
        this.zzaij = 2000;
    }

    @Override // com.google.android.gms.internal.gtm.zzem
    public final void zza(long j, String str, String str2, String str3, Map<String, String> map, String str4) {
        String str5;
        long currentTimeMillis = this.zzsd.currentTimeMillis();
        if (currentTimeMillis > this.zzaii + DateFormattingHelper.DAY_IN_MS) {
            this.zzaii = currentTimeMillis;
            SQLiteDatabase zzau = zzau("Error opening database for deleteStaleHits.");
            if (zzau != null) {
                int delete = zzau.delete("gtm_hits", "HIT_TIME < ?", new String[]{Long.toString(this.zzsd.currentTimeMillis() - 2592000000L)});
                StringBuilder sb = new StringBuilder(31);
                sb.append("Removed ");
                sb.append(delete);
                sb.append(" stale hits.");
                zzev.zzab(sb.toString());
                this.zzaol.zze(zzbv("gtm_hits") == 0);
            }
        }
        int zzbv = (zzbv("gtm_hits") - this.zzaij) + 1;
        if (zzbv > 0) {
            List<String> zzz = zzz(zzbv);
            int size = zzz.size();
            StringBuilder sb2 = new StringBuilder(51);
            sb2.append("Store full, deleting ");
            sb2.append(size);
            sb2.append(" hits to make room.");
            zzev.zzab(sb2.toString());
            zza((String[]) zzz.toArray(new String[0]));
        }
        SQLiteDatabase zzau2 = zzau("Error opening database for putHit");
        if (zzau2 != null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("hit_time", Long.valueOf(j));
            contentValues.put("hit_url", str);
            contentValues.put("hit_first_send_time", (Integer) 0);
            if (str2 == null) {
                str2 = ShareTarget.METHOD_GET;
            }
            contentValues.put("hit_method", str2);
            contentValues.put("hit_unique_id", str3);
            if (map == null) {
                str5 = null;
            } else {
                str5 = new JSONObject(map).toString();
            }
            contentValues.put("hit_headers", str5);
            contentValues.put("hit_body", str4);
            try {
                zzau2.insertOrThrow("gtm_hits", null, contentValues);
                StringBuilder sb3 = new StringBuilder(String.valueOf(str).length() + 19);
                sb3.append("Hit stored (url = ");
                sb3.append(str);
                sb3.append(")");
                zzev.zzab(sb3.toString());
                this.zzaol.zze(false);
            } catch (SQLiteConstraintException unused) {
                String valueOf = String.valueOf(str);
                zzev.zzab(valueOf.length() != 0 ? "Hit has already been sent: ".concat(valueOf) : new String("Hit has already been sent: "));
            } catch (SQLiteException e) {
                String valueOf2 = String.valueOf(e.getMessage());
                zzev.zzac(valueOf2.length() != 0 ? "Error storing hit: ".concat(valueOf2) : new String("Error storing hit: "));
            }
        }
        if (zzfd.zzkr().isPreview()) {
            zzev.zzab("Sending hits immediately under preview.");
            dispatch();
        }
    }

    private final List<String> zzz(int i) {
        ArrayList arrayList = new ArrayList();
        if (i <= 0) {
            zzev.zzac("Invalid maxHits specified. Skipping");
            return arrayList;
        }
        SQLiteDatabase zzau = zzau("Error opening database for peekHitIds.");
        if (zzau == null) {
            return arrayList;
        }
        Cursor cursor = null;
        try {
            Cursor query = zzau.query("gtm_hits", new String[]{"hit_id"}, null, null, null, null, String.format("%s ASC", "hit_id"), Integer.toString(i));
            if (query.moveToFirst()) {
                do {
                    arrayList.add(String.valueOf(query.getLong(0)));
                } while (query.moveToNext());
            }
            if (query != null) {
                query.close();
            }
        } catch (SQLiteException e) {
            String valueOf = String.valueOf(e.getMessage());
            zzev.zzac(valueOf.length() != 0 ? "Error in peekHits fetching hitIds: ".concat(valueOf) : new String("Error in peekHits fetching hitIds: "));
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

    /* JADX WARNING: Code restructure failed: missing block: B:101:0x01f1, code lost:
        r14.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:105:0x01f8, code lost:
        r14.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x01c1, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x01c2, code lost:
        r14 = r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x01c7, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:97:0x01e2, code lost:
        r0 = "Error in peekHits fetching hitIds: ".concat(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:0x01e7, code lost:
        r0 = new java.lang.String("Error in peekHits fetching hitIds: ");
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:101:0x01f1  */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x01f8  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x017c A[Catch:{ all -> 0x01b7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x0181 A[Catch:{ all -> 0x01b7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x0198 A[Catch:{ all -> 0x01b7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x01b3  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x01ba  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x01c1 A[ExcHandler: all (th java.lang.Throwable), Splitter:B:6:0x003a] */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x01e2 A[Catch:{ all -> 0x01f5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x01e7 A[Catch:{ all -> 0x01f5 }] */
    private final List<zzeh> zzaa(int i) {
        Cursor cursor;
        Throwable th;
        SQLiteException e;
        String valueOf;
        String str;
        ArrayList arrayList;
        Throwable th2;
        ArrayList arrayList2;
        SQLiteException e2;
        int size;
        HashMap hashMap;
        ArrayList arrayList3 = new ArrayList();
        SQLiteDatabase zzau = zzau("Error opening database for peekHits");
        if (zzau == null) {
            return arrayList3;
        }
        try {
            int i2 = 0;
            Cursor query = zzau.query("gtm_hits", new String[]{"hit_id", "hit_time", "hit_first_send_time"}, null, null, null, null, String.format("%s ASC", "hit_id"), Integer.toString(40));
            try {
                arrayList = new ArrayList();
                if (query.moveToFirst()) {
                    do {
                        try {
                            arrayList.add(new zzeh(query.getLong(0), query.getLong(1), query.getLong(2)));
                        } catch (SQLiteException e3) {
                            e = e3;
                            arrayList3 = arrayList;
                            cursor = query;
                            try {
                                valueOf = String.valueOf(e.getMessage());
                                if (valueOf.length() == 0) {
                                }
                                zzev.zzac(str);
                                if (cursor != null) {
                                }
                                return arrayList3;
                            } catch (Throwable th3) {
                                th = th3;
                                if (cursor != null) {
                                }
                                throw th;
                            }
                        } catch (Throwable th4) {
                            th = th4;
                            cursor = query;
                            if (cursor != null) {
                            }
                            throw th;
                        }
                    } while (query.moveToNext());
                }
                if (query != null) {
                    query.close();
                }
                try {
                    arrayList2 = arrayList;
                    try {
                        query = zzau.query("gtm_hits", new String[]{"hit_id", "hit_url", "hit_method", "hit_headers", "hit_body"}, null, null, null, null, String.format("%s ASC", "hit_id"), Integer.toString(40));
                        try {
                            if (query.moveToFirst()) {
                                int i3 = 0;
                                do {
                                    if (((SQLiteCursor) query).getWindow().getNumRows() > 0) {
                                        ((zzeh) arrayList2.get(i3)).zzbc(query.getString(1));
                                        ((zzeh) arrayList2.get(i3)).zzbt(query.getString(2));
                                        ((zzeh) arrayList2.get(i3)).zzbu(query.getString(4));
                                        try {
                                            String string = query.getString(3);
                                            if (string != null) {
                                                JSONObject jSONObject = new JSONObject(string);
                                                JSONArray names = jSONObject.names();
                                                hashMap = new HashMap();
                                                for (int i4 = 0; i4 < names.length(); i4++) {
                                                    String string2 = names.getString(i4);
                                                    hashMap.put(string2, (String) jSONObject.opt(string2));
                                                }
                                            } else {
                                                hashMap = null;
                                            }
                                            ((zzeh) arrayList2.get(i3)).zzg(hashMap);
                                        } catch (JSONException e4) {
                                            zzev.zzac(String.format("Failed to read headers for hitId %d: %s", Long.valueOf(((zzeh) arrayList2.get(i3)).zzih()), e4.getMessage()));
                                        }
                                    } else {
                                        zzev.zzac(String.format("HitString for hitId %d too large. Hit will be deleted.", Long.valueOf(((zzeh) arrayList2.get(i3)).zzih())));
                                    }
                                    i3++;
                                } while (query.moveToNext());
                            }
                            if (query != null) {
                                query.close();
                            }
                            return arrayList2;
                        } catch (SQLiteException e5) {
                            e2 = e5;
                            try {
                                String valueOf2 = String.valueOf(e2.getMessage());
                                zzev.zzac(valueOf2.length() != 0 ? "Error in peekHits fetching hit url: ".concat(valueOf2) : new String("Error in peekHits fetching hit url: "));
                                ArrayList arrayList4 = new ArrayList();
                                ArrayList arrayList5 = arrayList2;
                                size = arrayList5.size();
                                boolean z = false;
                                while (i2 < size) {
                                    Object obj = arrayList5.get(i2);
                                    i2++;
                                    zzeh zzeh = (zzeh) obj;
                                    if (TextUtils.isEmpty(zzeh.zzij())) {
                                        if (z) {
                                            break;
                                        }
                                        z = true;
                                    }
                                    arrayList4.add(zzeh);
                                }
                                if (query != null) {
                                    query.close();
                                }
                                return arrayList4;
                            } catch (Throwable th5) {
                                th2 = th5;
                                if (query != null) {
                                }
                                throw th2;
                            }
                        }
                    } catch (SQLiteException e6) {
                        e2 = e6;
                        query = query;
                        String valueOf22 = String.valueOf(e2.getMessage());
                        zzev.zzac(valueOf22.length() != 0 ? "Error in peekHits fetching hit url: ".concat(valueOf22) : new String("Error in peekHits fetching hit url: "));
                        ArrayList arrayList42 = new ArrayList();
                        ArrayList arrayList52 = arrayList2;
                        size = arrayList52.size();
                        boolean z2 = false;
                        while (i2 < size) {
                        }
                        if (query != null) {
                        }
                        return arrayList42;
                    } catch (Throwable th6) {
                        th2 = th6;
                        query = query;
                        if (query != null) {
                        }
                        throw th2;
                    }
                } catch (SQLiteException e7) {
                    e2 = e7;
                    arrayList2 = arrayList;
                    String valueOf222 = String.valueOf(e2.getMessage());
                    zzev.zzac(valueOf222.length() != 0 ? "Error in peekHits fetching hit url: ".concat(valueOf222) : new String("Error in peekHits fetching hit url: "));
                    ArrayList arrayList422 = new ArrayList();
                    ArrayList arrayList522 = arrayList2;
                    size = arrayList522.size();
                    boolean z22 = false;
                    while (i2 < size) {
                    }
                    if (query != null) {
                    }
                    return arrayList422;
                } catch (Throwable th7) {
                    th2 = th7;
                    if (query != null) {
                        query.close();
                    }
                    throw th2;
                }
            } catch (SQLiteException e8) {
                e = e8;
                arrayList3 = arrayList;
                cursor = query;
                valueOf = String.valueOf(e.getMessage());
                if (valueOf.length() == 0) {
                }
                zzev.zzac(str);
                if (cursor != null) {
                }
                return arrayList3;
            } catch (Throwable th8) {
            }
        } catch (SQLiteException e9) {
            e = e9;
            cursor = null;
            valueOf = String.valueOf(e.getMessage());
            if (valueOf.length() == 0) {
            }
            zzev.zzac(str);
            if (cursor != null) {
            }
            return arrayList3;
        } catch (Throwable th9) {
            th = th9;
            cursor = null;
            if (cursor != null) {
            }
            throw th;
        }
    }

    private final void zza(String[] strArr) {
        SQLiteDatabase zzau;
        if (strArr != null && strArr.length != 0 && (zzau = zzau("Error opening database for deleteHits.")) != null) {
            boolean z = true;
            try {
                zzau.delete("gtm_hits", String.format("HIT_ID in (%s)", TextUtils.join(",", Collections.nCopies(strArr.length, "?"))), strArr);
                zzen zzen = this.zzaol;
                if (zzbv("gtm_hits") != 0) {
                    z = false;
                }
                zzen.zze(z);
            } catch (SQLiteException e) {
                String valueOf = String.valueOf(e.getMessage());
                zzev.zzac(valueOf.length() != 0 ? "Error deleting hits: ".concat(valueOf) : new String("Error deleting hits: "));
            }
        }
    }

    /* access modifiers changed from: public */
    private final void zze(long j) {
        zza(new String[]{String.valueOf(j)});
    }

    /* access modifiers changed from: public */
    private final void zzb(long j, long j2) {
        SQLiteDatabase zzau = zzau("Error opening database for getNumStoredHits.");
        if (zzau != null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("hit_first_send_time", Long.valueOf(j2));
            try {
                zzau.update("gtm_hits", contentValues, "hit_id=?", new String[]{String.valueOf(j)});
            } catch (SQLiteException e) {
                String message = e.getMessage();
                StringBuilder sb = new StringBuilder(String.valueOf(message).length() + 70);
                sb.append("Error setting HIT_FIRST_DISPATCH_TIME for hitId ");
                sb.append(j);
                sb.append(": ");
                sb.append(message);
                zzev.zzac(sb.toString());
                zze(j);
            }
        }
    }

    private final int zzbv(String str) {
        SQLiteDatabase zzau = zzau("Error opening database for getNumRecords.");
        int i = 0;
        if (zzau == null) {
            return 0;
        }
        Cursor cursor = null;
        try {
            String valueOf = String.valueOf(str);
            Cursor rawQuery = zzau.rawQuery(valueOf.length() != 0 ? "SELECT COUNT(*) from ".concat(valueOf) : new String("SELECT COUNT(*) from "), null);
            if (rawQuery.moveToFirst()) {
                i = (int) rawQuery.getLong(0);
            }
            if (rawQuery != null) {
                rawQuery.close();
            }
        } catch (SQLiteException e) {
            String valueOf2 = String.valueOf(e.getMessage());
            zzev.zzac(valueOf2.length() != 0 ? "Error getting numStoredRecords: ".concat(valueOf2) : new String("Error getting numStoredRecords: "));
            if (0 != 0) {
                cursor.close();
            }
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            throw th;
        }
        return i;
    }

    private final int zziw() {
        SQLiteDatabase zzau = zzau("Error opening database for getNumStoredHits.");
        int i = 0;
        if (zzau == null) {
            return 0;
        }
        Cursor cursor = null;
        try {
            cursor = zzau.query("gtm_hits", new String[]{"hit_id", "hit_first_send_time"}, "hit_first_send_time=0", null, null, null, null);
            i = cursor.getCount();
            if (cursor != null) {
                cursor.close();
            }
        } catch (SQLiteException e) {
            String valueOf = String.valueOf(e.getMessage());
            zzev.zzac(valueOf.length() != 0 ? "Error getting num untried hits: ".concat(valueOf) : new String("Error getting num untried hits: "));
            if (cursor != null) {
                cursor.close();
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
        return i;
    }

    @Override // com.google.android.gms.internal.gtm.zzem
    public final void dispatch() {
        zzev.zzab("GTM Dispatch running...");
        if (this.zzaok.zzhy()) {
            List<zzeh> zzaa = zzaa(40);
            if (zzaa.isEmpty()) {
                zzev.zzab("...nothing to dispatch");
                this.zzaol.zze(true);
                return;
            }
            this.zzaok.zzd(zzaa);
            if (zziw() > 0) {
                zzfo.zzkv().dispatch();
            }
        }
    }

    private final SQLiteDatabase zzau(String str) {
        try {
            return this.zzaoj.getWritableDatabase();
        } catch (SQLiteException e) {
            Context context = this.zzrm;
            zzev.zzb(str, e);
            if (CrashUtils.addDynamiteErrorToDropBox(context, e)) {
                zzev.zzab("Crash reported successfully.");
                return null;
            }
            zzev.zzab("Failed to report crash");
            return null;
        }
    }
}
