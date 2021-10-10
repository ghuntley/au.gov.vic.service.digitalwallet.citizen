package com.google.android.gms.measurement.internal;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteFullException;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.util.Clock;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class zzem extends zzg {
    private final zzep zza = new zzep(this, zzm(), "google_app_measurement_local.db");
    private boolean zzb;

    zzem(zzfu zzfu) {
        super(zzfu);
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.measurement.internal.zzg
    public final boolean zzy() {
        return false;
    }

    public final void zzaa() {
        zzc();
        try {
            int delete = zzad().delete("messages", null, null) + 0;
            if (delete > 0) {
                zzq().zzw().zza("Reset local analytics data. records", Integer.valueOf(delete));
            }
        } catch (SQLiteException e) {
            zzq().zze().zza("Error resetting local analytics data. error", e);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:45:0x00c1 A[SYNTHETIC, Splitter:B:45:0x00c1] */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00dc  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00e1  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00f2  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00f7  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x010f  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x0114  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x0120  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x0125  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x0117 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x0117 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x0117 A[SYNTHETIC] */
    private final boolean zza(int i, byte[] bArr) {
        SQLiteDatabase sQLiteDatabase;
        Throwable th;
        SQLiteFullException e;
        Cursor cursor;
        SQLiteException e2;
        zzc();
        boolean z = false;
        if (this.zzb) {
            return false;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("type", Integer.valueOf(i));
        contentValues.put("entry", bArr);
        int i2 = 0;
        int i3 = 5;
        for (int i4 = 5; i2 < i4; i4 = 5) {
            Cursor cursor2 = null;
            cursor2 = null;
            r7 = null;
            r7 = null;
            SQLiteDatabase sQLiteDatabase2 = null;
            Cursor cursor3 = null;
            try {
                sQLiteDatabase = zzad();
                if (sQLiteDatabase == null) {
                    try {
                        this.zzb = true;
                        if (sQLiteDatabase != null) {
                            sQLiteDatabase.close();
                        }
                        return z;
                    } catch (SQLiteFullException e3) {
                        e = e3;
                    } catch (SQLiteDatabaseLockedException unused) {
                        try {
                            SystemClock.sleep((long) i3);
                            i3 += 20;
                            if (cursor3 != null) {
                                cursor3.close();
                            }
                            if (sQLiteDatabase != null) {
                                sQLiteDatabase.close();
                            }
                            i2++;
                            z = false;
                        } catch (Throwable th2) {
                            th = th2;
                            if (cursor3 != null) {
                            }
                            if (sQLiteDatabase != null) {
                            }
                            throw th;
                        }
                    } catch (SQLiteException e4) {
                        e2 = e4;
                        cursor = null;
                        sQLiteDatabase2 = sQLiteDatabase;
                        if (sQLiteDatabase2 != null) {
                            try {
                                if (sQLiteDatabase2.inTransaction()) {
                                    sQLiteDatabase2.endTransaction();
                                }
                            } catch (Throwable th3) {
                                th = th3;
                                sQLiteDatabase = sQLiteDatabase2;
                                cursor3 = cursor;
                                if (cursor3 != null) {
                                    cursor3.close();
                                }
                                if (sQLiteDatabase != null) {
                                    sQLiteDatabase.close();
                                }
                                throw th;
                            }
                        }
                        zzq().zze().zza("Error writing entry to local database", e2);
                        this.zzb = true;
                        if (cursor != null) {
                            cursor.close();
                        }
                        if (sQLiteDatabase2 != null) {
                            sQLiteDatabase2.close();
                        }
                        i2++;
                        z = false;
                    }
                } else {
                    sQLiteDatabase.beginTransaction();
                    long j = 0;
                    cursor = sQLiteDatabase.rawQuery("select count(1) from messages", null);
                    if (cursor != null) {
                        try {
                            if (cursor.moveToFirst()) {
                                int i5 = z ? 1 : 0;
                                int i6 = z ? 1 : 0;
                                int i7 = z ? 1 : 0;
                                j = cursor.getLong(i5);
                            }
                        } catch (SQLiteFullException e5) {
                            e = e5;
                            cursor2 = cursor;
                            zzq().zze().zza("Error writing entry; local database full", e);
                            this.zzb = true;
                            if (cursor2 != null) {
                            }
                            if (sQLiteDatabase == null) {
                            }
                            i2++;
                            z = false;
                        } catch (SQLiteDatabaseLockedException unused2) {
                            cursor3 = cursor;
                            SystemClock.sleep((long) i3);
                            i3 += 20;
                            if (cursor3 != null) {
                            }
                            if (sQLiteDatabase != null) {
                            }
                            i2++;
                            z = false;
                        } catch (SQLiteException e6) {
                            e2 = e6;
                            sQLiteDatabase2 = sQLiteDatabase;
                            if (sQLiteDatabase2 != null) {
                            }
                            zzq().zze().zza("Error writing entry to local database", e2);
                            this.zzb = true;
                            if (cursor != null) {
                            }
                            if (sQLiteDatabase2 != null) {
                            }
                            i2++;
                            z = false;
                        } catch (Throwable th4) {
                            th = th4;
                            cursor3 = cursor;
                            if (cursor3 != null) {
                            }
                            if (sQLiteDatabase != null) {
                            }
                            throw th;
                        }
                    }
                    if (j >= 100000) {
                        zzq().zze().zza("Data loss, local db full");
                        long j2 = (100000 - j) + 1;
                        String[] strArr = new String[1];
                        String l = Long.toString(j2);
                        char c = z ? 1 : 0;
                        char c2 = z ? 1 : 0;
                        char c3 = z ? 1 : 0;
                        strArr[c] = l;
                        long delete = (long) sQLiteDatabase.delete("messages", "rowid in (select rowid from messages order by rowid asc limit ?)", strArr);
                        if (delete != j2) {
                            zzq().zze().zza("Different delete count than expected in local db. expected, received, difference", Long.valueOf(j2), Long.valueOf(delete), Long.valueOf(j2 - delete));
                        }
                    }
                    sQLiteDatabase.insertOrThrow("messages", null, contentValues);
                    sQLiteDatabase.setTransactionSuccessful();
                    sQLiteDatabase.endTransaction();
                    if (cursor != null) {
                        cursor.close();
                    }
                    if (sQLiteDatabase == null) {
                        return true;
                    }
                    sQLiteDatabase.close();
                    return true;
                }
            } catch (SQLiteFullException e7) {
                e = e7;
                sQLiteDatabase = null;
                zzq().zze().zza("Error writing entry; local database full", e);
                this.zzb = true;
                if (cursor2 != null) {
                    cursor2.close();
                }
                if (sQLiteDatabase == null) {
                    sQLiteDatabase.close();
                }
                i2++;
                z = false;
            } catch (SQLiteDatabaseLockedException unused3) {
                sQLiteDatabase = null;
                SystemClock.sleep((long) i3);
                i3 += 20;
                if (cursor3 != null) {
                }
                if (sQLiteDatabase != null) {
                }
                i2++;
                z = false;
            } catch (SQLiteException e8) {
                e2 = e8;
                cursor = null;
                if (sQLiteDatabase2 != null) {
                }
                zzq().zze().zza("Error writing entry to local database", e2);
                this.zzb = true;
                if (cursor != null) {
                }
                if (sQLiteDatabase2 != null) {
                }
                i2++;
                z = false;
            } catch (Throwable th5) {
                th = th5;
                sQLiteDatabase = null;
                if (cursor3 != null) {
                }
                if (sQLiteDatabase != null) {
                }
                throw th;
            }
        }
        zzq().zzw().zza("Failed to write entry to local database");
        return false;
    }

    public final boolean zza(zzaq zzaq) {
        Parcel obtain = Parcel.obtain();
        zzaq.writeToParcel(obtain, 0);
        byte[] marshall = obtain.marshall();
        obtain.recycle();
        if (marshall.length <= 131072) {
            return zza(0, marshall);
        }
        zzq().zzf().zza("Event is too long for local database. Sending event directly to service");
        return false;
    }

    public final boolean zza(zzku zzku) {
        Parcel obtain = Parcel.obtain();
        zzku.writeToParcel(obtain, 0);
        byte[] marshall = obtain.marshall();
        obtain.recycle();
        if (marshall.length <= 131072) {
            return zza(1, marshall);
        }
        zzq().zzf().zza("User property too long for local database. Sending directly to service");
        return false;
    }

    public final boolean zza(zzz zzz) {
        zzo();
        byte[] zza2 = zzkv.zza((Parcelable) zzz);
        if (zza2.length <= 131072) {
            return zza(2, zza2);
        }
        zzq().zzf().zza("Conditional user property too long for local database. Sending directly to service");
        return false;
    }

    /* JADX INFO: finally extract failed */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x002e, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0031, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x009f, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:?, code lost:
        zzq().zze().zza("Failed to load event from local database");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00b2, code lost:
        r11.recycle();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00b5, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x00cf, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:?, code lost:
        zzq().zze().zza("Failed to load user property from local database");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x00de, code lost:
        r11.recycle();
        r0 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x00e8, code lost:
        r11.recycle();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x00eb, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x0105, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:?, code lost:
        zzq().zze().zza("Failed to load conditional user property from local database");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x0114, code lost:
        r11.recycle();
        r0 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x011f, code lost:
        r11.recycle();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x0122, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:95:0x018c, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:99:0x0193, code lost:
        r5 = r15;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:40:0x00a1 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:51:0x00d1 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:64:0x0107 */
    /* JADX WARNING: Removed duplicated region for block: B:100:? A[ExcHandler: SQLiteDatabaseLockedException (unused android.database.sqlite.SQLiteDatabaseLockedException), SYNTHETIC, Splitter:B:12:0x0026] */
    /* JADX WARNING: Removed duplicated region for block: B:113:0x01a3 A[SYNTHETIC, Splitter:B:113:0x01a3] */
    /* JADX WARNING: Removed duplicated region for block: B:119:0x01bb  */
    /* JADX WARNING: Removed duplicated region for block: B:121:0x01c0  */
    /* JADX WARNING: Removed duplicated region for block: B:126:0x01ce  */
    /* JADX WARNING: Removed duplicated region for block: B:128:0x01d3  */
    /* JADX WARNING: Removed duplicated region for block: B:133:0x01e9  */
    /* JADX WARNING: Removed duplicated region for block: B:135:0x01ee  */
    /* JADX WARNING: Removed duplicated region for block: B:141:0x01fb  */
    /* JADX WARNING: Removed duplicated region for block: B:143:0x0200  */
    /* JADX WARNING: Removed duplicated region for block: B:151:0x01f1 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:153:0x01f1 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:155:0x01f1 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x018c A[ExcHandler: all (th java.lang.Throwable), Splitter:B:12:0x0026] */
    public final List<AbstractSafeParcelable> zza(int i) {
        int i2;
        int i3;
        SQLiteDatabase sQLiteDatabase;
        Throwable th;
        SQLiteDatabase sQLiteDatabase2;
        Cursor cursor;
        SQLiteFullException e;
        SQLiteDatabase sQLiteDatabase3;
        SQLiteException e2;
        String[] strArr;
        String str;
        zzc();
        Cursor cursor2 = null;
        if (this.zzb) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        if (!zzae()) {
            return arrayList;
        }
        int i4 = 5;
        i3 = 0;
        for (i2 = 5; i3 < i2; i2 = 5) {
            try {
                sQLiteDatabase2 = zzad();
                if (sQLiteDatabase2 == null) {
                    try {
                        this.zzb = true;
                        if (sQLiteDatabase2 != null) {
                            sQLiteDatabase2.close();
                        }
                        return null;
                    } catch (SQLiteFullException e3) {
                        e = e3;
                    } catch (SQLiteDatabaseLockedException unused) {
                    } catch (SQLiteException e4) {
                        e2 = e4;
                        cursor = null;
                        if (sQLiteDatabase2 != null) {
                        }
                        zzq().zze().zza("Error reading entries from local database", e2);
                        this.zzb = true;
                        if (cursor != null) {
                        }
                        if (sQLiteDatabase2 != null) {
                        }
                        i3++;
                    } catch (Throwable th2) {
                    }
                } else {
                    sQLiteDatabase2.beginTransaction();
                    long zza2 = zza(sQLiteDatabase2);
                    long j = -1;
                    if (zza2 != -1) {
                        str = "rowid<?";
                        strArr = new String[]{String.valueOf(zza2)};
                    } else {
                        str = null;
                        strArr = null;
                    }
                    sQLiteDatabase = sQLiteDatabase2;
                    try {
                        cursor = sQLiteDatabase2.query("messages", new String[]{"rowid", "type", "entry"}, str, strArr, null, null, "rowid asc", Integer.toString(100));
                        while (cursor.moveToNext()) {
                            try {
                                j = cursor.getLong(0);
                                int i5 = cursor.getInt(1);
                                byte[] blob = cursor.getBlob(2);
                                if (i5 == 0) {
                                    Parcel obtain = Parcel.obtain();
                                    obtain.unmarshall(blob, 0, blob.length);
                                    obtain.setDataPosition(0);
                                    zzaq createFromParcel = zzaq.CREATOR.createFromParcel(obtain);
                                    obtain.recycle();
                                    if (createFromParcel != null) {
                                        arrayList.add(createFromParcel);
                                    }
                                } else if (i5 == 1) {
                                    Parcel obtain2 = Parcel.obtain();
                                    obtain2.unmarshall(blob, 0, blob.length);
                                    obtain2.setDataPosition(0);
                                    zzku zzku = zzku.CREATOR.createFromParcel(obtain2);
                                    obtain2.recycle();
                                    if (zzku != null) {
                                        arrayList.add(zzku);
                                    }
                                } else if (i5 == 2) {
                                    Parcel obtain3 = Parcel.obtain();
                                    obtain3.unmarshall(blob, 0, blob.length);
                                    obtain3.setDataPosition(0);
                                    zzz zzz = zzz.CREATOR.createFromParcel(obtain3);
                                    obtain3.recycle();
                                    if (zzz != null) {
                                        arrayList.add(zzz);
                                    }
                                } else if (i5 == 3) {
                                    zzq().zzh().zza("Skipping app launch break");
                                } else {
                                    zzq().zze().zza("Unknown record type in local database");
                                }
                            } catch (SQLiteFullException e5) {
                                e = e5;
                                sQLiteDatabase2 = sQLiteDatabase;
                                zzq().zze().zza("Error reading entries from local database", e);
                                this.zzb = true;
                                if (cursor != null) {
                                }
                                if (sQLiteDatabase2 == null) {
                                }
                                i3++;
                            } catch (SQLiteDatabaseLockedException unused2) {
                                sQLiteDatabase3 = sQLiteDatabase;
                                SystemClock.sleep((long) i4);
                                i4 += 20;
                                if (cursor != null) {
                                }
                                if (sQLiteDatabase3 == null) {
                                }
                                i3++;
                            } catch (SQLiteException e6) {
                                e2 = e6;
                                sQLiteDatabase2 = sQLiteDatabase;
                                if (sQLiteDatabase2 != null) {
                                }
                                zzq().zze().zza("Error reading entries from local database", e2);
                                this.zzb = true;
                                if (cursor != null) {
                                }
                                if (sQLiteDatabase2 != null) {
                                }
                                i3++;
                            } catch (Throwable th3) {
                                th = th3;
                                cursor2 = cursor;
                                if (cursor2 != null) {
                                }
                                if (sQLiteDatabase != null) {
                                }
                                throw th;
                            }
                        }
                        if (sQLiteDatabase.delete("messages", "rowid <= ?", new String[]{Long.toString(j)}) < arrayList.size()) {
                            zzq().zze().zza("Fewer entries removed from local database than expected");
                        }
                        sQLiteDatabase.setTransactionSuccessful();
                        sQLiteDatabase.endTransaction();
                        if (cursor != null) {
                            cursor.close();
                        }
                        if (sQLiteDatabase != null) {
                            sQLiteDatabase.close();
                        }
                        return arrayList;
                    } catch (SQLiteFullException e7) {
                        e = e7;
                        cursor = null;
                        sQLiteDatabase2 = sQLiteDatabase;
                        zzq().zze().zza("Error reading entries from local database", e);
                        this.zzb = true;
                        if (cursor != null) {
                        }
                        if (sQLiteDatabase2 == null) {
                        }
                        i3++;
                    } catch (SQLiteDatabaseLockedException unused3) {
                        cursor = null;
                        sQLiteDatabase3 = sQLiteDatabase;
                        SystemClock.sleep((long) i4);
                        i4 += 20;
                        if (cursor != null) {
                        }
                        if (sQLiteDatabase3 == null) {
                        }
                        i3++;
                    } catch (SQLiteException e8) {
                        e2 = e8;
                        cursor = null;
                        sQLiteDatabase2 = sQLiteDatabase;
                        if (sQLiteDatabase2 != null) {
                        }
                        zzq().zze().zza("Error reading entries from local database", e2);
                        this.zzb = true;
                        if (cursor != null) {
                        }
                        if (sQLiteDatabase2 != null) {
                        }
                        i3++;
                    } catch (Throwable th4) {
                        th = th4;
                        if (cursor2 != null) {
                        }
                        if (sQLiteDatabase != null) {
                        }
                        throw th;
                    }
                }
            } catch (SQLiteFullException e9) {
                e = e9;
                cursor = null;
                sQLiteDatabase2 = null;
                zzq().zze().zza("Error reading entries from local database", e);
                this.zzb = true;
                if (cursor != null) {
                    cursor.close();
                }
                if (sQLiteDatabase2 == null) {
                    sQLiteDatabase2.close();
                }
                i3++;
            } catch (SQLiteDatabaseLockedException unused4) {
                cursor = null;
                sQLiteDatabase3 = null;
                SystemClock.sleep((long) i4);
                i4 += 20;
                if (cursor != null) {
                    cursor.close();
                }
                if (sQLiteDatabase3 == null) {
                    sQLiteDatabase3.close();
                }
                i3++;
            } catch (SQLiteException e10) {
                e2 = e10;
                cursor = null;
                sQLiteDatabase2 = null;
                if (sQLiteDatabase2 != null) {
                    try {
                        if (sQLiteDatabase2.inTransaction()) {
                            sQLiteDatabase2.endTransaction();
                        }
                    } catch (Throwable th5) {
                        th = th5;
                        cursor2 = cursor;
                        sQLiteDatabase = sQLiteDatabase2;
                        if (cursor2 != null) {
                        }
                        if (sQLiteDatabase != null) {
                        }
                        throw th;
                    }
                }
                zzq().zze().zza("Error reading entries from local database", e2);
                this.zzb = true;
                if (cursor != null) {
                    cursor.close();
                }
                if (sQLiteDatabase2 != null) {
                    sQLiteDatabase2.close();
                }
                i3++;
            } catch (Throwable th6) {
                th = th6;
                sQLiteDatabase = null;
                if (cursor2 != null) {
                    cursor2.close();
                }
                if (sQLiteDatabase != null) {
                    sQLiteDatabase.close();
                }
                throw th;
            }
        }
        zzq().zzh().zza("Failed to read events from database in reasonable time");
        return null;
        cursor = null;
        zzq().zze().zza("Error reading entries from local database", e);
        this.zzb = true;
        if (cursor != null) {
        }
        if (sQLiteDatabase2 == null) {
        }
        i3++;
    }

    public final boolean zzab() {
        return zza(3, new byte[0]);
    }

    public final boolean zzac() {
        zzc();
        if (this.zzb || !zzae()) {
            return false;
        }
        int i = 5;
        for (int i2 = 0; i2 < 5; i2++) {
            SQLiteDatabase sQLiteDatabase = null;
            try {
                SQLiteDatabase zzad = zzad();
                if (zzad == null) {
                    this.zzb = true;
                    if (zzad != null) {
                        zzad.close();
                    }
                    return false;
                }
                zzad.beginTransaction();
                zzad.delete("messages", "type == ?", new String[]{Integer.toString(3)});
                zzad.setTransactionSuccessful();
                zzad.endTransaction();
                if (zzad != null) {
                    zzad.close();
                }
                return true;
            } catch (SQLiteFullException e) {
                zzq().zze().zza("Error deleting app launch break from local database", e);
                this.zzb = true;
                if (0 != 0) {
                    sQLiteDatabase.close();
                }
            } catch (SQLiteDatabaseLockedException unused) {
                SystemClock.sleep((long) i);
                i += 20;
                if (0 != 0) {
                    sQLiteDatabase.close();
                }
            } catch (SQLiteException e2) {
                if (0 != 0) {
                    if (sQLiteDatabase.inTransaction()) {
                        sQLiteDatabase.endTransaction();
                    }
                }
                zzq().zze().zza("Error deleting app launch break from local database", e2);
                this.zzb = true;
                if (0 != 0) {
                    sQLiteDatabase.close();
                }
            } catch (Throwable th) {
                if (0 != 0) {
                    sQLiteDatabase.close();
                }
                throw th;
            }
        }
        zzq().zzh().zza("Error deleting app launch break from local database in reasonable time");
        return false;
    }

    private static long zza(SQLiteDatabase sQLiteDatabase) {
        Cursor cursor = null;
        try {
            cursor = sQLiteDatabase.query("messages", new String[]{"rowid"}, "type=?", new String[]{"3"}, null, null, "rowid desc", "1");
            if (cursor.moveToFirst()) {
                return cursor.getLong(0);
            }
            if (cursor == null) {
                return -1;
            }
            cursor.close();
            return -1;
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    private final SQLiteDatabase zzad() throws SQLiteException {
        if (this.zzb) {
            return null;
        }
        SQLiteDatabase writableDatabase = this.zza.getWritableDatabase();
        if (writableDatabase != null) {
            return writableDatabase;
        }
        this.zzb = true;
        return null;
    }

    private final boolean zzae() {
        return zzm().getDatabasePath("google_app_measurement_local.db").exists();
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
}
