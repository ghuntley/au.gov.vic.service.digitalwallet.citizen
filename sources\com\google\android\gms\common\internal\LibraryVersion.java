package com.google.android.gms.common.internal;

import com.digitalwallet.app.model.P2PHeader;
import com.google.android.gms.common.util.IOUtils;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: com.google.android.gms:play-services-basement@@17.4.0 */
public class LibraryVersion {
    private static final GmsLogger zza = new GmsLogger("LibraryVersion", "");
    private static LibraryVersion zzb = new LibraryVersion();
    private ConcurrentHashMap<String, String> zzc = new ConcurrentHashMap<>();

    public static LibraryVersion getInstance() {
        return zzb;
    }

    protected LibraryVersion() {
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x00a1 A[Catch:{ all -> 0x0091 }] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00a6 A[Catch:{ all -> 0x0091 }] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00b1  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00b7  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00c8  */
    public String getVersion(String str) {
        Throwable th;
        String str2;
        IOException e;
        Preconditions.checkNotEmpty(str, "Please provide a valid libraryName");
        if (this.zzc.containsKey(str)) {
            return this.zzc.get(str);
        }
        Properties properties = new Properties();
        InputStream inputStream = null;
        String str3 = null;
        try {
            InputStream resourceAsStream = LibraryVersion.class.getResourceAsStream(String.format("/%s.properties", str));
            if (resourceAsStream != null) {
                try {
                    properties.load(resourceAsStream);
                    str3 = properties.getProperty(P2PHeader.versionKey, null);
                    GmsLogger gmsLogger = zza;
                    StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 12 + String.valueOf(str3).length());
                    sb.append(str);
                    sb.append(" version is ");
                    sb.append(str3);
                    gmsLogger.v("LibraryVersion", sb.toString());
                } catch (IOException e2) {
                    e = e2;
                    str2 = null;
                    inputStream = resourceAsStream;
                    try {
                        GmsLogger gmsLogger2 = zza;
                        String valueOf = String.valueOf(str);
                        gmsLogger2.e("LibraryVersion", valueOf.length() == 0 ? "Failed to get app version for libraryName: ".concat(valueOf) : new String("Failed to get app version for libraryName: "), e);
                        if (inputStream != null) {
                        }
                        str3 = str2;
                        if (str3 == null) {
                        }
                        this.zzc.put(str, str3);
                        return str3;
                    } catch (Throwable th2) {
                        th = th2;
                        if (inputStream != null) {
                            IOUtils.closeQuietly(inputStream);
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    inputStream = resourceAsStream;
                    if (inputStream != null) {
                    }
                    throw th;
                }
            } else {
                GmsLogger gmsLogger3 = zza;
                String valueOf2 = String.valueOf(str);
                gmsLogger3.w("LibraryVersion", valueOf2.length() != 0 ? "Failed to get app version for libraryName: ".concat(valueOf2) : new String("Failed to get app version for libraryName: "));
            }
            if (resourceAsStream != null) {
                IOUtils.closeQuietly(resourceAsStream);
            }
        } catch (IOException e3) {
            e = e3;
            str2 = null;
            GmsLogger gmsLogger22 = zza;
            String valueOf3 = String.valueOf(str);
            gmsLogger22.e("LibraryVersion", valueOf3.length() == 0 ? "Failed to get app version for libraryName: ".concat(valueOf3) : new String("Failed to get app version for libraryName: "), e);
            if (inputStream != null) {
                IOUtils.closeQuietly(inputStream);
            }
            str3 = str2;
            if (str3 == null) {
            }
            this.zzc.put(str, str3);
            return str3;
        }
        if (str3 == null) {
            zza.d("LibraryVersion", ".properties file is dropped during release process. Failure to read app version is expected during Google internal testing where locally-built libraries are used");
            str3 = "UNKNOWN";
        }
        this.zzc.put(str, str3);
        return str3;
    }
}
