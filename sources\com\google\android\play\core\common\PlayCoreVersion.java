package com.google.android.play.core.common;

import android.os.Bundle;
import com.google.android.play.core.internal.ag;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import net.openid.appauth.RegistrationRequest;

public class PlayCoreVersion {
    private static final Set<String> a = new HashSet(Arrays.asList("review"));
    private static final Set<String> b = new HashSet(Arrays.asList(RegistrationRequest.APPLICATION_TYPE_NATIVE, "unity"));
    private static final Map<String, Map<String, Integer>> c = new HashMap();
    private static final ag d = new ag("PlayCoreVersion");

    private PlayCoreVersion() {
    }

    public static synchronized Map<String, Integer> a(String str) {
        Map<String, Integer> map;
        synchronized (PlayCoreVersion.class) {
            Map<String, Map<String, Integer>> map2 = c;
            if (!map2.containsKey(str)) {
                HashMap hashMap = new HashMap();
                hashMap.put("java", 10803);
                map2.put(str, hashMap);
            }
            map = map2.get(str);
        }
        return map;
    }

    public static synchronized void addVersion(String str, String str2, int i) {
        synchronized (PlayCoreVersion.class) {
            if (!a.contains(str)) {
                d.e("Illegal module name: %s", str);
            } else if (!b.contains(str2)) {
                d.e("Illegal platform name: %s", str2);
            } else {
                a(str).put(str2, Integer.valueOf(i));
            }
        }
    }

    public static Bundle b() {
        Bundle bundle = new Bundle();
        Map<String, Integer> a2 = a("review");
        bundle.putInt("playcore_version_code", a2.get("java").intValue());
        if (a2.containsKey(RegistrationRequest.APPLICATION_TYPE_NATIVE)) {
            bundle.putInt("playcore_native_version", a2.get(RegistrationRequest.APPLICATION_TYPE_NATIVE).intValue());
        }
        if (a2.containsKey("unity")) {
            bundle.putInt("playcore_unity_version", a2.get("unity").intValue());
        }
        return bundle;
    }
}
