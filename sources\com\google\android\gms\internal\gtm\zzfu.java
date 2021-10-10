package com.google.android.gms.internal.gtm;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import androidx.browser.trusted.sharing.ShareTarget;
import com.bumptech.glide.load.Key;
import com.google.firebase.crashlytics.internal.common.AbstractSpiCall;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/* access modifiers changed from: package-private */
public final class zzfu implements zzed {
    private final String zzabp;
    private final zzfx zzapo;
    private final zzfw zzapp;
    private final Context zzrm;

    private zzfu(zzfx zzfx, Context context, zzfw zzfw) {
        this.zzapo = zzfx;
        this.zzrm = context.getApplicationContext();
        this.zzapp = zzfw;
        String str = Build.VERSION.RELEASE;
        Locale locale = Locale.getDefault();
        String str2 = null;
        if (!(locale == null || locale.getLanguage() == null || locale.getLanguage().length() == 0)) {
            StringBuilder sb = new StringBuilder();
            sb.append(locale.getLanguage().toLowerCase());
            if (!(locale.getCountry() == null || locale.getCountry().length() == 0)) {
                sb.append("-");
                sb.append(locale.getCountry().toLowerCase());
            }
            str2 = sb.toString();
        }
        this.zzabp = String.format("%s/%s (Linux; U; Android %s; %s; %s Build/%s)", "GoogleTagManager", "5.06", str, str2, Build.MODEL, Build.ID);
    }

    zzfu(Context context, zzfw zzfw) {
        this(new zzfv(), context, zzfw);
    }

    @Override // com.google.android.gms.internal.gtm.zzed
    public final boolean zzhy() {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.zzrm.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
            return true;
        }
        zzev.zzab("...no network connectivity");
        return false;
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARNING: Removed duplicated region for block: B:102:0x0222 A[SYNTHETIC, Splitter:B:102:0x0222] */
    /* JADX WARNING: Removed duplicated region for block: B:108:0x022d  */
    /* JADX WARNING: Removed duplicated region for block: B:117:0x023c  */
    @Override // com.google.android.gms.internal.gtm.zzed
    public final void zzd(List<zzeh> list) {
        int i;
        IOException e;
        InputStream inputStream;
        Throwable th;
        char c;
        InputStream inputStream2;
        BufferedReader bufferedReader;
        Throwable th2;
        int min = Math.min(list.size(), 40);
        int i2 = 1;
        boolean z = true;
        int i3 = 0;
        while (i3 < min) {
            zzeh zzeh = list.get(i3);
            URL zzd = zzd(zzeh);
            String zzkj = zzeh.zzkj();
            Map<String, String> zzkk = zzeh.zzkk();
            String zzkl = zzeh.zzkl();
            if (zzd == null) {
                zzev.zzac("No destination: discarding hit.");
                this.zzapp.zzb(zzeh);
            } else {
                try {
                    HttpURLConnection zzc = this.zzapo.zzc(zzd);
                    if (z) {
                        try {
                            zzex.zzn(this.zzrm);
                            z = false;
                        } catch (Throwable th3) {
                            th = th3;
                            inputStream = null;
                            if (inputStream != null) {
                            }
                            zzc.disconnect();
                            throw th;
                        }
                    }
                    zzc.setRequestProperty(AbstractSpiCall.HEADER_USER_AGENT, this.zzabp);
                    if (zzkk != null) {
                        for (Map.Entry<String, String> entry : zzkk.entrySet()) {
                            zzc.setRequestProperty(entry.getKey(), entry.getValue());
                        }
                    }
                    if (zzkj == null) {
                        Object[] objArr = new Object[i2];
                        objArr[0] = Long.valueOf(zzeh.zzih());
                        zzev.zzac(String.format("Hit %d retrieved from the store has null HTTP method.", objArr));
                        this.zzapp.zzb(zzeh);
                        zzc.disconnect();
                    } else {
                        if (!zzkj.equals(ShareTarget.METHOD_GET)) {
                            try {
                                if (!zzkj.equals("HEAD") && !zzkj.equals(ShareTarget.METHOD_POST) && !zzkj.equals("PUT")) {
                                    zzev.zzac(String.format("Unrecongnized HTTP method %s. Supported methods are GET, HEAD, PUT and/or POST", zzkj));
                                    this.zzapp.zzb(zzeh);
                                    try {
                                        zzc.disconnect();
                                        i = 1;
                                    } catch (IOException e2) {
                                        e = e2;
                                        i = 1;
                                        String valueOf = String.valueOf(zzd);
                                        String simpleName = e.getClass().getSimpleName();
                                        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 27 + String.valueOf(simpleName).length());
                                        sb.append("Exception sending hit to ");
                                        sb.append(valueOf);
                                        sb.append(": ");
                                        sb.append(simpleName);
                                        zzev.zzac(sb.toString());
                                        zzev.zzac(e.getMessage());
                                        this.zzapp.zzc(zzeh);
                                        i3++;
                                        i2 = i;
                                    }
                                    i3++;
                                    i2 = i;
                                }
                            } catch (Throwable th4) {
                                th = th4;
                                inputStream = null;
                                if (inputStream != null) {
                                }
                                zzc.disconnect();
                                throw th;
                            }
                        }
                        switch (zzkj.hashCode()) {
                            case 70454:
                                if (zzkj.equals(ShareTarget.METHOD_GET)) {
                                    c = 0;
                                    break;
                                }
                                c = 65535;
                                break;
                            case 79599:
                                if (zzkj.equals("PUT")) {
                                    c = 3;
                                    break;
                                }
                                c = 65535;
                                break;
                            case 2213344:
                                if (zzkj.equals("HEAD")) {
                                    c = 1;
                                    break;
                                }
                                c = 65535;
                                break;
                            case 2461856:
                                if (zzkj.equals(ShareTarget.METHOD_POST)) {
                                    c = 2;
                                    break;
                                }
                                c = 65535;
                                break;
                            default:
                                c = 65535;
                                break;
                        }
                        if (c == 0 || c == 1) {
                            if (zzkl != null) {
                                Object[] objArr2 = new Object[2];
                                objArr2[0] = zzkj;
                                i = 1;
                                try {
                                    objArr2[1] = zzkl;
                                    zzev.zzac(String.format("Body of %s hit is ignored: %s.", objArr2));
                                } catch (Throwable th5) {
                                    th = th5;
                                    inputStream = null;
                                    if (inputStream != null) {
                                        inputStream.close();
                                    }
                                    zzc.disconnect();
                                    throw th;
                                }
                            } else {
                                i = 1;
                            }
                            zzc.setRequestMethod(zzkj);
                        } else {
                            if (c == 2 || c == 3) {
                                try {
                                    zzc.setRequestMethod(zzkj);
                                    if (zzkl != null) {
                                        zzc.setDoOutput(true);
                                        byte[] bytes = zzkl.getBytes(Charset.forName(Key.STRING_CHARSET_NAME));
                                        zzc.setFixedLengthStreamingMode(bytes.length);
                                        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(zzc.getOutputStream());
                                        bufferedOutputStream.write(bytes);
                                        bufferedOutputStream.flush();
                                        bufferedOutputStream.close();
                                        i = 1;
                                    }
                                } catch (Throwable th6) {
                                    th = th6;
                                    inputStream = null;
                                    if (inputStream != null) {
                                    }
                                    zzc.disconnect();
                                    throw th;
                                }
                            }
                            i = 1;
                        }
                        int responseCode = zzc.getResponseCode();
                        if (responseCode >= 200) {
                            if (responseCode < 300) {
                                InputStream inputStream3 = zzc.getInputStream();
                                try {
                                    String valueOf2 = String.valueOf(zzd);
                                    StringBuilder sb2 = new StringBuilder(String.valueOf(valueOf2).length() + 23 + String.valueOf(zzkj).length());
                                    sb2.append("Hit sent to ");
                                    sb2.append(valueOf2);
                                    sb2.append("(method = ");
                                    sb2.append(zzkj);
                                    sb2.append(")");
                                    zzev.zzab(sb2.toString());
                                    this.zzapp.zza(zzeh);
                                    inputStream2 = inputStream3;
                                    if (inputStream2 != null) {
                                        try {
                                            inputStream2.close();
                                        } catch (IOException e3) {
                                            e = e3;
                                            String valueOf3 = String.valueOf(zzd);
                                            String simpleName2 = e.getClass().getSimpleName();
                                            StringBuilder sb3 = new StringBuilder(String.valueOf(valueOf3).length() + 27 + String.valueOf(simpleName2).length());
                                            sb3.append("Exception sending hit to ");
                                            sb3.append(valueOf3);
                                            sb3.append(": ");
                                            sb3.append(simpleName2);
                                            zzev.zzac(sb3.toString());
                                            zzev.zzac(e.getMessage());
                                            this.zzapp.zzc(zzeh);
                                            i3++;
                                            i2 = i;
                                        }
                                    }
                                    zzc.disconnect();
                                    i3++;
                                    i2 = i;
                                } catch (Throwable th7) {
                                    th = th7;
                                    inputStream = inputStream3;
                                    if (inputStream != null) {
                                    }
                                    zzc.disconnect();
                                    throw th;
                                }
                            }
                        }
                        String valueOf4 = String.valueOf(zzd);
                        StringBuilder sb4 = new StringBuilder(String.valueOf(valueOf4).length() + 39);
                        sb4.append("Bad response received for ");
                        sb4.append(valueOf4);
                        sb4.append(": ");
                        sb4.append(responseCode);
                        zzev.zzac(sb4.toString());
                        StringBuilder sb5 = new StringBuilder();
                        try {
                            InputStream errorStream = zzc.getErrorStream();
                            if (errorStream != null) {
                                bufferedReader = new BufferedReader(new InputStreamReader(errorStream));
                                while (true) {
                                    try {
                                        String readLine = bufferedReader.readLine();
                                        if (readLine != null) {
                                            sb5.append(readLine);
                                        } else {
                                            String valueOf5 = String.valueOf(sb5.toString());
                                            zzev.zzac(valueOf5.length() != 0 ? "Error Message: ".concat(valueOf5) : new String("Error Message: "));
                                        }
                                    } catch (Throwable th8) {
                                        th2 = th8;
                                        if (bufferedReader != null) {
                                            bufferedReader.close();
                                        }
                                        throw th2;
                                    }
                                }
                            } else {
                                bufferedReader = null;
                            }
                            if (bufferedReader != null) {
                                bufferedReader.close();
                            }
                            this.zzapp.zzc(zzeh);
                            inputStream2 = null;
                            if (inputStream2 != null) {
                            }
                            zzc.disconnect();
                            i3++;
                            i2 = i;
                        } catch (Throwable th9) {
                            th2 = th9;
                            bufferedReader = null;
                            if (bufferedReader != null) {
                            }
                            throw th2;
                        }
                    }
                } catch (IOException e4) {
                    e = e4;
                    i = i2;
                    String valueOf32 = String.valueOf(zzd);
                    String simpleName22 = e.getClass().getSimpleName();
                    StringBuilder sb32 = new StringBuilder(String.valueOf(valueOf32).length() + 27 + String.valueOf(simpleName22).length());
                    sb32.append("Exception sending hit to ");
                    sb32.append(valueOf32);
                    sb32.append(": ");
                    sb32.append(simpleName22);
                    zzev.zzac(sb32.toString());
                    zzev.zzac(e.getMessage());
                    this.zzapp.zzc(zzeh);
                    i3++;
                    i2 = i;
                }
            }
            i = i2;
            i3++;
            i2 = i;
        }
    }

    private static URL zzd(zzeh zzeh) {
        try {
            return new URL(zzeh.zzij());
        } catch (MalformedURLException unused) {
            zzev.zzav("Error trying to parse the GTM url.");
            return null;
        }
    }
}
