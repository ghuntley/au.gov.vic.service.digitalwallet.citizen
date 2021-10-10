package com.google.android.gms.internal.gtm;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import com.bumptech.glide.load.Key;
import com.google.android.gms.analytics.zzk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.firebase.crashlytics.internal.common.AbstractSpiCall;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.zip.GZIPOutputStream;
import kotlin.text.Typography;
import org.objectweb.asm.signature.SignatureVisitor;

/* access modifiers changed from: package-private */
public final class zzck extends zzan {
    private static final byte[] zzabr = "\n".getBytes();
    private final String zzabp = String.format("%s/%s (Linux; U; Android %s; %s; %s Build/%s)", "GoogleAnalytics", zzao.VERSION, Build.VERSION.RELEASE, zzcz.zza(Locale.getDefault()), Build.MODEL, Build.ID);
    private final zzcv zzabq;

    zzck(zzap zzap) {
        super(zzap);
        this.zzabq = new zzcv(zzap.zzcn());
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.gtm.zzan
    public final void zzaw() {
        zza("Network initialized. User agent", this.zzabp);
    }

    public final boolean zzfr() {
        NetworkInfo networkInfo;
        zzk.zzav();
        zzdb();
        try {
            networkInfo = ((ConnectivityManager) getContext().getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (SecurityException unused) {
            networkInfo = null;
        }
        if (networkInfo != null && networkInfo.isConnected()) {
            return true;
        }
        zzq("No network connectivity");
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:51:0x0157, code lost:
        if (zza(r5) == 200) goto L_0x0132;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x0199, code lost:
        if (zza(r6, r5) == 200) goto L_0x0132;
     */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x005d  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0102  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x019e  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x01b3 A[EDGE_INSN: B:71:0x01b3->B:67:0x01b3 ?: BREAK  , SYNTHETIC] */
    public final List<Long> zzb(List<zzcd> list) {
        boolean z;
        boolean z2;
        boolean z3;
        int i;
        zzk.zzav();
        zzdb();
        Preconditions.checkNotNull(list);
        if (zzcp().zzew().isEmpty() || !this.zzabq.zzj(((long) zzby.zzaab.get().intValue()) * 1000)) {
            z2 = false;
        } else {
            z2 = zzbg.zzz(zzby.zzzu.get()) != zzbg.NONE;
            if (zzbm.zzaa(zzby.zzzv.get()) == zzbm.GZIP) {
                z = true;
                if (!z2) {
                    Preconditions.checkArgument(!list.isEmpty());
                    zza("Uploading batched hits. compression, count", Boolean.valueOf(z), Integer.valueOf(list.size()));
                    zzcl zzcl = new zzcl(this);
                    ArrayList arrayList = new ArrayList();
                    for (zzcd zzcd : list) {
                        if (!zzcl.zze(zzcd)) {
                            break;
                        }
                        arrayList.add(Long.valueOf(zzcd.zzfg()));
                    }
                    if (zzcl.zzfu() == 0) {
                        return arrayList;
                    }
                    URL zzfs = zzfs();
                    if (zzfs == null) {
                        zzu("Failed to build batching endpoint url");
                    } else {
                        if (z) {
                            i = zzb(zzfs, zzcl.getPayload());
                        } else {
                            i = zza(zzfs, zzcl.getPayload());
                        }
                        if (200 == i) {
                            zza("Batched upload completed. Hits batched", Integer.valueOf(zzcl.zzfu()));
                            return arrayList;
                        }
                        zza("Network error uploading hits. status code", Integer.valueOf(i));
                        if (zzcp().zzew().contains(Integer.valueOf(i))) {
                            zzt("Server instructed the client to stop batching");
                            this.zzabq.start();
                        }
                    }
                    return Collections.emptyList();
                }
                ArrayList arrayList2 = new ArrayList(list.size());
                for (zzcd zzcd2 : list) {
                    Preconditions.checkNotNull(zzcd2);
                    String zza = zza(zzcd2, !zzcd2.zzfj());
                    if (zza != null) {
                        if (zza.length() <= zzby.zzzt.get().intValue()) {
                            URL zzb = zzb(zzcd2, zza);
                            if (zzb == null) {
                                zzu("Failed to build collect GET endpoint url");
                            }
                        } else {
                            String zza2 = zza(zzcd2, false);
                            if (zza2 == null) {
                                zzco().zza(zzcd2, "Error formatting hit for POST upload");
                            } else {
                                byte[] bytes = zza2.getBytes();
                                if (bytes.length > zzby.zzzy.get().intValue()) {
                                    zzco().zza(zzcd2, "Hit payload exceeds size limit");
                                } else {
                                    URL zzd = zzd(zzcd2);
                                    if (zzd == null) {
                                        zzu("Failed to build collect POST endpoint url");
                                    }
                                }
                            }
                        }
                        z3 = false;
                        if (z3) {
                            break;
                        }
                        arrayList2.add(Long.valueOf(zzcd2.zzfg()));
                        if (arrayList2.size() >= zzbq.zzer()) {
                            break;
                        }
                    } else {
                        zzco().zza(zzcd2, "Error formatting hit for upload");
                    }
                    z3 = true;
                    if (z3) {
                    }
                }
                return arrayList2;
            }
        }
        z = false;
        if (!z2) {
        }
    }

    private final int zza(URL url) {
        Preconditions.checkNotNull(url);
        zzb("GET request", url);
        HttpURLConnection httpURLConnection = null;
        try {
            HttpURLConnection zzb = zzb(url);
            zzb.connect();
            zza(zzb);
            int responseCode = zzb.getResponseCode();
            if (responseCode == 200) {
                zzcs().zzcl();
            }
            zzb("GET status", Integer.valueOf(responseCode));
            if (zzb != null) {
                zzb.disconnect();
            }
            return responseCode;
        } catch (IOException e) {
            zzd("Network GET connection error", e);
            if (0 == 0) {
                return 0;
            }
            httpURLConnection.disconnect();
            return 0;
        } catch (Throwable th) {
            if (0 != 0) {
                httpURLConnection.disconnect();
            }
            throw th;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x0079 A[SYNTHETIC, Splitter:B:29:0x0079] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0083  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x008b A[SYNTHETIC, Splitter:B:37:0x008b] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0095  */
    /* JADX WARNING: Removed duplicated region for block: B:45:? A[RETURN, SYNTHETIC] */
    private final int zza(URL url, byte[] bArr) {
        Throwable th;
        HttpURLConnection httpURLConnection;
        IOException e;
        Preconditions.checkNotNull(url);
        Preconditions.checkNotNull(bArr);
        zzb("POST bytes, url", Integer.valueOf(bArr.length), url);
        if (zzda()) {
            zza("Post payload\n", new String(bArr));
        }
        OutputStream outputStream = null;
        try {
            getContext().getPackageName();
            httpURLConnection = zzb(url);
            try {
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setFixedLengthStreamingMode(bArr.length);
                httpURLConnection.connect();
                OutputStream outputStream2 = httpURLConnection.getOutputStream();
                outputStream2.write(bArr);
                zza(httpURLConnection);
                int responseCode = httpURLConnection.getResponseCode();
                if (responseCode == 200) {
                    zzcs().zzcl();
                }
                zzb("POST status", Integer.valueOf(responseCode));
                if (outputStream2 != null) {
                    try {
                        outputStream2.close();
                    } catch (IOException e2) {
                        zze("Error closing http post connection output stream", e2);
                    }
                }
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                return responseCode;
            } catch (IOException e3) {
                e = e3;
                try {
                    zzd("Network POST connection error", e);
                    if (0 != 0) {
                        try {
                            outputStream.close();
                        } catch (IOException e4) {
                            zze("Error closing http post connection output stream", e4);
                        }
                    }
                    if (httpURLConnection != null) {
                        return 0;
                    }
                    httpURLConnection.disconnect();
                    return 0;
                } catch (Throwable th2) {
                    th = th2;
                    if (0 != 0) {
                        try {
                            outputStream.close();
                        } catch (IOException e5) {
                            zze("Error closing http post connection output stream", e5);
                        }
                    }
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    throw th;
                }
            }
        } catch (IOException e6) {
            e = e6;
            httpURLConnection = null;
            zzd("Network POST connection error", e);
            if (0 != 0) {
            }
            if (httpURLConnection != null) {
            }
        } catch (Throwable th3) {
            th = th3;
            httpURLConnection = null;
            if (0 != 0) {
            }
            if (httpURLConnection != null) {
            }
            throw th;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:41:0x00d5 A[SYNTHETIC, Splitter:B:41:0x00d5] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00df  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00e7 A[SYNTHETIC, Splitter:B:49:0x00e7] */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00f1  */
    /* JADX WARNING: Removed duplicated region for block: B:57:? A[RETURN, SYNTHETIC] */
    private final int zzb(URL url, byte[] bArr) {
        HttpURLConnection httpURLConnection;
        Throwable th;
        IOException e;
        OutputStream outputStream;
        Preconditions.checkNotNull(url);
        Preconditions.checkNotNull(bArr);
        OutputStream outputStream2 = null;
        try {
            getContext().getPackageName();
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            gZIPOutputStream.write(bArr);
            gZIPOutputStream.close();
            byteArrayOutputStream.close();
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            zza("POST compressed size, ratio %, url", Integer.valueOf(byteArray.length), Long.valueOf((((long) byteArray.length) * 100) / ((long) bArr.length)), url);
            if (byteArray.length > bArr.length) {
                zzc("Compressed payload is larger then uncompressed. compressed, uncompressed", Integer.valueOf(byteArray.length), Integer.valueOf(bArr.length));
            }
            if (zzda()) {
                String str = new String(bArr);
                zza("Post payload", str.length() != 0 ? "\n".concat(str) : new String("\n"));
            }
            HttpURLConnection zzb = zzb(url);
            try {
                zzb.setDoOutput(true);
                zzb.addRequestProperty("Content-Encoding", "gzip");
                zzb.setFixedLengthStreamingMode(byteArray.length);
                zzb.connect();
                outputStream = zzb.getOutputStream();
            } catch (IOException e2) {
                httpURLConnection = zzb;
                e = e2;
                try {
                    zzd("Network compressed POST connection error", e);
                    if (outputStream2 != null) {
                    }
                    if (httpURLConnection == null) {
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (outputStream2 != null) {
                        try {
                            outputStream2.close();
                        } catch (IOException e3) {
                            zze("Error closing http compressed post connection output stream", e3);
                        }
                    }
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                httpURLConnection = zzb;
                th = th3;
                if (outputStream2 != null) {
                }
                if (httpURLConnection != null) {
                }
                throw th;
            }
            try {
                outputStream.write(byteArray);
                outputStream.close();
                zza(zzb);
                int responseCode = zzb.getResponseCode();
                if (responseCode == 200) {
                    zzcs().zzcl();
                }
                zzb("POST status", Integer.valueOf(responseCode));
                if (zzb != null) {
                    zzb.disconnect();
                }
                return responseCode;
            } catch (IOException e4) {
                httpURLConnection = zzb;
                e = e4;
                outputStream2 = outputStream;
                zzd("Network compressed POST connection error", e);
                if (outputStream2 != null) {
                    try {
                        outputStream2.close();
                    } catch (IOException e5) {
                        zze("Error closing http compressed post connection output stream", e5);
                    }
                }
                if (httpURLConnection == null) {
                    return 0;
                }
                httpURLConnection.disconnect();
                return 0;
            } catch (Throwable th4) {
                httpURLConnection = zzb;
                th = th4;
                outputStream2 = outputStream;
                if (outputStream2 != null) {
                }
                if (httpURLConnection != null) {
                }
                throw th;
            }
        } catch (IOException e6) {
            e = e6;
            httpURLConnection = null;
            zzd("Network compressed POST connection error", e);
            if (outputStream2 != null) {
            }
            if (httpURLConnection == null) {
            }
        } catch (Throwable th5) {
            th = th5;
            httpURLConnection = null;
            if (outputStream2 != null) {
            }
            if (httpURLConnection != null) {
            }
            throw th;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0021 A[SYNTHETIC, Splitter:B:18:0x0021] */
    private final void zza(HttpURLConnection httpURLConnection) throws IOException {
        InputStream inputStream;
        Throwable th;
        try {
            inputStream = httpURLConnection.getInputStream();
            try {
                do {
                } while (inputStream.read(new byte[1024]) > 0);
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e) {
                        zze("Error closing http connection input stream", e);
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e2) {
                        zze("Error closing http connection input stream", e2);
                    }
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            inputStream = null;
            if (inputStream != null) {
            }
            throw th;
        }
    }

    private final HttpURLConnection zzb(URL url) throws IOException {
        URLConnection openConnection = url.openConnection();
        if (openConnection instanceof HttpURLConnection) {
            HttpURLConnection httpURLConnection = (HttpURLConnection) openConnection;
            httpURLConnection.setDefaultUseCaches(false);
            httpURLConnection.setConnectTimeout(zzby.zzaad.get().intValue());
            httpURLConnection.setReadTimeout(zzby.zzaae.get().intValue());
            httpURLConnection.setInstanceFollowRedirects(false);
            httpURLConnection.setRequestProperty(AbstractSpiCall.HEADER_USER_AGENT, this.zzabp);
            httpURLConnection.setDoInput(true);
            return httpURLConnection;
        }
        throw new IOException("Failed to obtain http connection");
    }

    private final URL zzd(zzcd zzcd) {
        String str;
        String str2;
        if (zzcd.zzfj()) {
            String valueOf = String.valueOf(zzbq.zzet());
            String valueOf2 = String.valueOf(zzbq.zzev());
            if (valueOf2.length() != 0) {
                str = valueOf.concat(valueOf2);
                return new URL(str);
            }
            str2 = new String(valueOf);
        } else {
            String valueOf3 = String.valueOf(zzbq.zzeu());
            String valueOf4 = String.valueOf(zzbq.zzev());
            if (valueOf4.length() != 0) {
                str = valueOf3.concat(valueOf4);
                return new URL(str);
            }
            str2 = new String(valueOf3);
        }
        str = str2;
        try {
            return new URL(str);
        } catch (MalformedURLException e) {
            zze("Error trying to parse the hardcoded host url", e);
            return null;
        }
    }

    private final URL zzb(zzcd zzcd, String str) {
        String str2;
        if (zzcd.zzfj()) {
            String zzet = zzbq.zzet();
            String zzev = zzbq.zzev();
            StringBuilder sb = new StringBuilder(String.valueOf(zzet).length() + 1 + String.valueOf(zzev).length() + String.valueOf(str).length());
            sb.append(zzet);
            sb.append(zzev);
            sb.append("?");
            sb.append(str);
            str2 = sb.toString();
        } else {
            String zzeu = zzbq.zzeu();
            String zzev2 = zzbq.zzev();
            StringBuilder sb2 = new StringBuilder(String.valueOf(zzeu).length() + 1 + String.valueOf(zzev2).length() + String.valueOf(str).length());
            sb2.append(zzeu);
            sb2.append(zzev2);
            sb2.append("?");
            sb2.append(str);
            str2 = sb2.toString();
        }
        try {
            return new URL(str2);
        } catch (MalformedURLException e) {
            zze("Error trying to parse the hardcoded host url", e);
            return null;
        }
    }

    private final URL zzfs() {
        String valueOf = String.valueOf(zzbq.zzet());
        String valueOf2 = String.valueOf(zzby.zzzs.get());
        try {
            return new URL(valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf));
        } catch (MalformedURLException e) {
            zze("Error trying to parse the hardcoded host url", e);
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public final String zza(zzcd zzcd, boolean z) {
        String str;
        Preconditions.checkNotNull(zzcd);
        StringBuilder sb = new StringBuilder();
        try {
            for (Map.Entry<String, String> entry : zzcd.zzdm().entrySet()) {
                String key = entry.getKey();
                if (!"ht".equals(key) && !"qt".equals(key) && !"AppUID".equals(key) && !"z".equals(key) && !"_gmsv".equals(key)) {
                    zza(sb, key, entry.getValue());
                }
            }
            zza(sb, "ht", String.valueOf(zzcd.zzfh()));
            zza(sb, "qt", String.valueOf(zzcn().currentTimeMillis() - zzcd.zzfh()));
            if (z) {
                long zzfk = zzcd.zzfk();
                if (zzfk != 0) {
                    str = String.valueOf(zzfk);
                } else {
                    str = String.valueOf(zzcd.zzfg());
                }
                zza(sb, "z", str);
            }
            return sb.toString();
        } catch (UnsupportedEncodingException e) {
            zze("Failed to encode name or value", e);
            return null;
        }
    }

    private static void zza(StringBuilder sb, String str, String str2) throws UnsupportedEncodingException {
        if (sb.length() != 0) {
            sb.append(Typography.amp);
        }
        sb.append(URLEncoder.encode(str, Key.STRING_CHARSET_NAME));
        sb.append(SignatureVisitor.INSTANCEOF);
        sb.append(URLEncoder.encode(str2, Key.STRING_CHARSET_NAME));
    }
}
