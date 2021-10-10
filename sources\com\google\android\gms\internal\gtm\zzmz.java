package com.google.android.gms.internal.gtm;

import android.content.Context;
import com.google.android.gms.common.util.IOUtils;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.ExecutorService;

public final class zzmz {
    private final ExecutorService zzajm;
    private final zzne zzate;
    private final Context zzrm;

    public zzmz(Context context) {
        this(context, zzdf.zzgp().zzr(zzdi.zzadg), new zzna(context));
    }

    private zzmz(Context context, ExecutorService executorService, zzne zzne) {
        this.zzrm = context;
        this.zzajm = executorService;
        this.zzate = zzne;
    }

    public final void zza(String str, zzmn zzmn) {
        this.zzajm.execute(new zznb(this, str, zzmn));
    }

    /* access modifiers changed from: package-private */
    public final void zzb(String str, zzmn zzmn) {
        zzev.zzab("Starting to load a saved resource file from Disk.");
        try {
            zzmn.zzc(zza(new FileInputStream(zzch(str))));
        } catch (FileNotFoundException unused) {
            String valueOf = String.valueOf(zzci(str));
            zzev.zzav(valueOf.length() != 0 ? "Saved resource not found: ".concat(valueOf) : new String("Saved resource not found: "));
            zzmn.zzb(0, 1);
        }
    }

    public final void zza(String str, String str2, zzmn zzmn) {
        this.zzajm.execute(new zznc(this, str, str2, zzmn));
    }

    /* access modifiers changed from: package-private */
    public final void zzb(String str, String str2, zzmn zzmn) {
        zzev.zzab("Starting to load a default asset file from Disk.");
        if (str2 == null) {
            zzev.zzab("Default asset file is not specified. Not proceeding with the loading");
            zzmn.zzb(0, 2);
            return;
        }
        try {
            InputStream open = this.zzate.open(str2);
            if (open != null) {
                zzmn.zzc(zza(open));
            } else {
                zzmn.zzb(0, 2);
            }
        } catch (IOException unused) {
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 42 + String.valueOf(str2).length());
            sb.append("Default asset file not found. ");
            sb.append(str);
            sb.append(". Filename: ");
            sb.append(str2);
            zzev.zzav(sb.toString());
            zzmn.zzb(0, 2);
        }
    }

    public final void zza(String str, byte[] bArr) {
        this.zzajm.execute(new zznd(this, str, bArr));
    }

    /* access modifiers changed from: package-private */
    public final void zzb(String str, byte[] bArr) {
        File zzch = zzch(str);
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(zzch);
            try {
                fileOutputStream.write(bArr);
                try {
                    fileOutputStream.close();
                    StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 24);
                    sb.append("Resource ");
                    sb.append(str);
                    sb.append(" saved on Disk.");
                    zzev.zzab(sb.toString());
                } catch (IOException unused) {
                    zzev.zzav("Error closing stream for writing resource to disk");
                }
            } catch (IOException unused2) {
                zzev.zzav("Error writing resource to disk. Removing resource from disk");
                zzch.delete();
                try {
                    fileOutputStream.close();
                    StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 24);
                    sb2.append("Resource ");
                    sb2.append(str);
                    sb2.append(" saved on Disk.");
                    zzev.zzab(sb2.toString());
                } catch (IOException unused3) {
                    zzev.zzav("Error closing stream for writing resource to disk");
                }
            } catch (Throwable th) {
                try {
                    fileOutputStream.close();
                    StringBuilder sb3 = new StringBuilder(String.valueOf(str).length() + 24);
                    sb3.append("Resource ");
                    sb3.append(str);
                    sb3.append(" saved on Disk.");
                    zzev.zzab(sb3.toString());
                } catch (IOException unused4) {
                    zzev.zzav("Error closing stream for writing resource to disk");
                }
                throw th;
            }
        } catch (FileNotFoundException unused5) {
            zzev.zzav("Error opening resource file for writing");
        }
    }

    public final long zzcg(String str) {
        File zzch = zzch(str);
        if (zzch.exists()) {
            return zzch.lastModified();
        }
        return 0;
    }

    private final File zzch(String str) {
        return new File(this.zzrm.getDir("google_tagmanager", 0), zzci(str));
    }

    private static String zzci(String str) {
        String valueOf = String.valueOf(str);
        return valueOf.length() != 0 ? "resource_".concat(valueOf) : new String("resource_");
    }

    private static byte[] zza(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            IOUtils.copyStream(inputStream, byteArrayOutputStream);
            try {
                inputStream.close();
            } catch (IOException unused) {
                zzev.zzac("Error closing stream for reading resource from disk");
                return null;
            }
        } catch (IOException unused2) {
            zzev.zzac("Failed to read the resource from disk");
            try {
                inputStream.close();
            } catch (IOException unused3) {
                zzev.zzac("Error closing stream for reading resource from disk");
                return null;
            }
        } catch (Throwable th) {
            try {
                inputStream.close();
                throw th;
            } catch (IOException unused4) {
                zzev.zzac("Error closing stream for reading resource from disk");
                return null;
            }
        }
        return byteArrayOutputStream.toByteArray();
    }
}
