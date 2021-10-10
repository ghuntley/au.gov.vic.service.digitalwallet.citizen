package com.google.android.gms.internal.gtm;

import android.content.Context;
import com.google.android.gms.common.internal.Preconditions;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Locale;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public final class zzbh extends zzan {
    private volatile String zzut;
    private Future<String> zzyh;

    protected zzbh(zzap zzap) {
        super(zzap);
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.gtm.zzan
    public final void zzaw() {
    }

    public final String zzeh() {
        String str;
        zzdb();
        synchronized (this) {
            if (this.zzut == null) {
                this.zzyh = zzcq().zza(new zzbi(this));
            }
            Future<String> future = this.zzyh;
            if (future != null) {
                try {
                    this.zzut = future.get();
                } catch (InterruptedException e) {
                    zzd("ClientId loading or generation was interrupted", e);
                    this.zzut = "0";
                } catch (ExecutionException e2) {
                    zze("Failed to load or generate client id", e2);
                    this.zzut = "0";
                }
                if (this.zzut == null) {
                    this.zzut = "0";
                }
                zza("Loaded clientId", this.zzut);
                this.zzyh = null;
            }
            str = this.zzut;
        }
        return str;
    }

    /* access modifiers changed from: package-private */
    public final String zzei() {
        synchronized (this) {
            this.zzut = null;
            this.zzyh = zzcq().zza(new zzbj(this));
        }
        return zzeh();
    }

    /* access modifiers changed from: package-private */
    public final String zzej() {
        String zzd = zzd(zzcq().getContext());
        return zzd == null ? zzek() : zzd;
    }

    /* access modifiers changed from: private */
    public final String zzek() {
        String lowerCase = UUID.randomUUID().toString().toLowerCase(Locale.US);
        try {
            if (!zzb(zzcq().getContext(), lowerCase)) {
                return "0";
            }
            return lowerCase;
        } catch (Exception e) {
            zze("Error saving clientId file", e);
            return "0";
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:38:0x0075 A[SYNTHETIC, Splitter:B:38:0x0075] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0082 A[SYNTHETIC, Splitter:B:46:0x0082] */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x008e A[SYNTHETIC, Splitter:B:55:0x008e] */
    private final String zzd(Context context) {
        FileInputStream fileInputStream;
        Throwable th;
        Object e;
        Preconditions.checkNotMainThread("ClientId should be loaded from worker thread");
        FileInputStream fileInputStream2 = null;
        try {
            fileInputStream = context.openFileInput("gaClientId");
            try {
                byte[] bArr = new byte[36];
                int read = fileInputStream.read(bArr, 0, 36);
                if (fileInputStream.available() > 0) {
                    zzt("clientId file seems corrupted, deleting it.");
                    fileInputStream.close();
                    context.deleteFile("gaClientId");
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e2) {
                            zze("Failed to close client id reading stream", e2);
                        }
                    }
                    return null;
                } else if (read < 14) {
                    zzt("clientId file is empty, deleting it.");
                    fileInputStream.close();
                    context.deleteFile("gaClientId");
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e3) {
                            zze("Failed to close client id reading stream", e3);
                        }
                    }
                    return null;
                } else {
                    fileInputStream.close();
                    String str = new String(bArr, 0, read);
                    zza("Read client id from disk", str);
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e4) {
                            zze("Failed to close client id reading stream", e4);
                        }
                    }
                    return str;
                }
            } catch (FileNotFoundException unused) {
                if (fileInputStream != null) {
                }
                return null;
            } catch (IOException e5) {
                e = e5;
                try {
                    zze("Error reading client id file, deleting it", e);
                    context.deleteFile("gaClientId");
                    if (fileInputStream != null) {
                    }
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    fileInputStream2 = fileInputStream;
                    if (fileInputStream2 != null) {
                    }
                    throw th;
                }
            }
        } catch (FileNotFoundException unused2) {
            fileInputStream = null;
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e6) {
                    zze("Failed to close client id reading stream", e6);
                }
            }
            return null;
        } catch (IOException e7) {
            e = e7;
            fileInputStream = null;
            zze("Error reading client id file, deleting it", e);
            context.deleteFile("gaClientId");
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e8) {
                    zze("Failed to close client id reading stream", e8);
                }
            }
            return null;
        } catch (Throwable th3) {
            th = th3;
            if (fileInputStream2 != null) {
                try {
                    fileInputStream2.close();
                } catch (IOException e9) {
                    zze("Failed to close client id reading stream", e9);
                }
            }
            throw th;
        }
    }

    private final boolean zzb(Context context, String str) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotMainThread("ClientId should be saved from worker thread");
        FileOutputStream fileOutputStream = null;
        try {
            zza("Storing clientId", str);
            fileOutputStream = context.openFileOutput("gaClientId", 0);
            fileOutputStream.write(str.getBytes());
            if (fileOutputStream == null) {
                return true;
            }
            try {
                fileOutputStream.close();
                return true;
            } catch (IOException e) {
                zze("Failed to close clientId writing stream", e);
                return true;
            }
        } catch (FileNotFoundException e2) {
            zze("Error creating clientId file", e2);
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e3) {
                    zze("Failed to close clientId writing stream", e3);
                }
            }
            return false;
        } catch (IOException e4) {
            zze("Error writing to clientId file", e4);
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e5) {
                    zze("Failed to close clientId writing stream", e5);
                }
            }
            return false;
        } catch (Throwable th) {
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e6) {
                    zze("Failed to close clientId writing stream", e6);
                }
            }
            throw th;
        }
    }
}
