package com.google.android.gms.internal.gtm;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import java.util.HashMap;
import java.util.Map;

public class zzeu {
    private static String zzahj;
    private static Map<String, String> zzahk = new HashMap();

    public static String zze(Context context, String str) {
        if (zzahj == null) {
            synchronized (zzeu.class) {
                if (zzahj == null) {
                    SharedPreferences sharedPreferences = context.getSharedPreferences("gtm_install_referrer", 0);
                    if (sharedPreferences != null) {
                        zzahj = sharedPreferences.getString("referrer", "");
                    } else {
                        zzahj = "";
                    }
                }
            }
        }
        return zze(zzahj, str);
    }

    public static String zze(String str, String str2) {
        if (str2 != null) {
            String valueOf = String.valueOf(str);
            return Uri.parse(valueOf.length() != 0 ? "http://hostname/?".concat(valueOf) : new String("http://hostname/?")).getQueryParameter(str2);
        } else if (str.length() > 0) {
            return str;
        } else {
            return null;
        }
    }
}
