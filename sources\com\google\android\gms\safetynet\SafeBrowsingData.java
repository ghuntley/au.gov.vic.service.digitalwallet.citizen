package com.google.android.gms.safetynet;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class SafeBrowsingData extends AbstractSafeParcelable {
    public static final Parcelable.Creator<SafeBrowsingData> CREATOR = new zzj();
    private static final String TAG = "SafeBrowsingData";
    private String zzm;
    private DataHolder zzn;
    private ParcelFileDescriptor zzo;
    private long zzp;
    private byte[] zzq;
    private byte[] zzr;
    private File zzs;

    public SafeBrowsingData() {
        this(null, null, null, 0, null);
    }

    public SafeBrowsingData(long j, byte[] bArr) {
        this(null, null, null, j, bArr);
    }

    public SafeBrowsingData(String str) {
        this(str, null, null, 0, null);
    }

    public SafeBrowsingData(String str, DataHolder dataHolder) {
        this(str, dataHolder, null, 0, null);
    }

    public SafeBrowsingData(String str, DataHolder dataHolder, ParcelFileDescriptor parcelFileDescriptor, long j, byte[] bArr) {
        this.zzm = str;
        this.zzn = dataHolder;
        this.zzo = parcelFileDescriptor;
        this.zzp = j;
        this.zzq = bArr;
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0029  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0030  */
    private final FileOutputStream zza() {
        File file;
        Throwable th;
        File file2 = this.zzs;
        if (file2 == null) {
            return null;
        }
        try {
            file = File.createTempFile("xlb", ".tmp", file2);
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                this.zzo = ParcelFileDescriptor.open(file, 268435456);
                if (file != null) {
                    file.delete();
                }
                return fileOutputStream;
            } catch (IOException unused) {
                if (file != null) {
                }
                return null;
            } catch (Throwable th2) {
                th = th2;
                if (file != null) {
                }
                throw th;
            }
        } catch (IOException unused2) {
            file = null;
            if (file != null) {
                file.delete();
            }
            return null;
        } catch (Throwable th3) {
            th = th3;
            file = null;
            if (file != null) {
                file.delete();
            }
            throw th;
        }
    }

    private static void zza(Closeable closeable) {
        try {
            closeable.close();
        } catch (IOException unused) {
        }
    }

    public byte[] getBlacklists() {
        if (this.zzo == null) {
            return null;
        }
        DataInputStream dataInputStream = new DataInputStream(new ParcelFileDescriptor.AutoCloseInputStream(this.zzo));
        try {
            byte[] bArr = new byte[dataInputStream.readInt()];
            dataInputStream.read(bArr);
            return bArr;
        } catch (IOException unused) {
            return null;
        } finally {
            zza(dataInputStream);
            this.zzo = null;
        }
    }

    public DataHolder getBlacklistsDataHolder() {
        return this.zzn;
    }

    public ParcelFileDescriptor getFileDescriptor() {
        return this.zzo;
    }

    public long getLastUpdateTimeMs() {
        return this.zzp;
    }

    public String getMetadata() {
        return this.zzm;
    }

    public byte[] getState() {
        return this.zzq;
    }

    public void setBlacklists(byte[] bArr) {
        this.zzr = bArr;
    }

    public void setTempDir(File file) {
        if (file != null) {
            this.zzs = file;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0035  */
    public void writeToParcel(Parcel parcel, int i) {
        boolean z;
        FileOutputStream zza;
        if (!(this.zzo != null || this.zzr == null || (zza = zza()) == null)) {
            DataOutputStream dataOutputStream = new DataOutputStream(new BufferedOutputStream(zza));
            try {
                dataOutputStream.writeInt(this.zzr.length);
                dataOutputStream.write(this.zzr);
                zza(dataOutputStream);
                z = true;
            } catch (IOException unused) {
                zza(dataOutputStream);
            } catch (Throwable th) {
                zza(dataOutputStream);
                throw th;
            }
            if (z) {
                i |= 1;
            }
            zzj.zza(this, parcel, i);
            this.zzo = null;
        }
        z = false;
        if (z) {
        }
        zzj.zza(this, parcel, i);
        this.zzo = null;
    }
}
