package com.google.android.play.core.splitinstall;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public final class h {
    private final Map<String, Map<String, String>> a;

    /* synthetic */ h(Map map) {
        this.a = map;
    }

    public final Map<String, Set<String>> a(Collection<String> collection) {
        Set set;
        HashMap hashMap = new HashMap();
        for (String str : this.a.keySet()) {
            if (!this.a.containsKey(str)) {
                set = Collections.emptySet();
            } else {
                HashSet hashSet = new HashSet();
                for (Map.Entry<String, String> entry : this.a.get(str).entrySet()) {
                    if (collection.contains(entry.getKey())) {
                        hashSet.add(entry.getValue());
                    }
                }
                set = Collections.unmodifiableSet(hashSet);
            }
            hashMap.put(str, set);
        }
        return hashMap;
    }
}
