package com.google.android.gms.internal.gtm;

import com.bumptech.glide.load.Key;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public final class zznf {
    private String zzafk = "https://www.google-analytics.com";

    public final String zzb(zzmk zzmk) {
        String str = this.zzafk;
        String str2 = "";
        if (zzmk.zzlg()) {
            str2 = zzmk.zzlh();
        } else if (zzmk != null) {
            String trim = !zzmk.zzli().trim().equals(str2) ? zzmk.zzli().trim() : "-1";
            StringBuilder sb = new StringBuilder();
            if (zzmk.zzle() != null) {
                sb.append(zzmk.zzle());
            } else {
                sb.append("id");
            }
            sb.append("=");
            sb.append(zzbs(zzmk.getContainerId()));
            sb.append("&pv=");
            sb.append(zzbs(trim));
            sb.append("&rv=5.0");
            if (zzmk.zzlg()) {
                sb.append("&gtm_debug=x");
            }
            str2 = sb.toString();
        }
        StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 13 + String.valueOf(str2).length());
        sb2.append(str);
        sb2.append("/gtm/android?");
        sb2.append(str2);
        return sb2.toString();
    }

    private static String zzbs(String str) {
        try {
            return URLEncoder.encode(str, Key.STRING_CHARSET_NAME).replaceAll("\\+", "%20");
        } catch (UnsupportedEncodingException unused) {
            String valueOf = String.valueOf(str);
            zzev.zzav(valueOf.length() != 0 ? "Cannot encode the string: ".concat(valueOf) : new String("Cannot encode the string: "));
            return "";
        }
    }
}
