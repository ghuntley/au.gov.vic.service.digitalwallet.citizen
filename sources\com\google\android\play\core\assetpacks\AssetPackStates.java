package com.google.android.play.core.assetpacks;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class AssetPackStates {
    public static AssetPackStates a(long j, Map<String, AssetPackState> map) {
        return new bi(j, map);
    }

    public static AssetPackStates b(Bundle bundle, bz bzVar) {
        return c(bundle, bzVar, new ArrayList());
    }

    public static AssetPackStates c(Bundle bundle, bz bzVar, List<String> list) {
        return e(bundle, bzVar, list, ba.a);
    }

    public static AssetPackStates d(Bundle bundle, bz bzVar, az azVar) {
        return e(bundle, bzVar, new ArrayList(), azVar);
    }

    private static AssetPackStates e(Bundle bundle, bz bzVar, List<String> list, az azVar) {
        ArrayList<String> stringArrayList = bundle.getStringArrayList("pack_names");
        HashMap hashMap = new HashMap();
        int size = stringArrayList.size();
        for (int i = 0; i < size; i++) {
            String str = stringArrayList.get(i);
            hashMap.put(str, AssetPackState.c(bundle, str, bzVar, azVar));
        }
        for (String str2 : list) {
            hashMap.put(str2, AssetPackState.b(str2, 4, 0, 0, 0, 0.0d, 1));
        }
        return a(bundle.getLong("total_bytes_to_download"), hashMap);
    }

    public abstract Map<String, AssetPackState> packStates();

    public abstract long totalBytes();
}
