package net.openid.appauth;

import android.net.Uri;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

/* access modifiers changed from: package-private */
public class AdditionalParamsProcessor {
    static Set<String> builtInParams(String... strArr) {
        if (strArr == null || strArr.length == 0) {
            return Collections.emptySet();
        }
        return Collections.unmodifiableSet(new HashSet(Arrays.asList(strArr)));
    }

    static Map<String, String> checkAdditionalParams(Map<String, String> map, Set<String> set) {
        if (map == null) {
            return Collections.emptyMap();
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            Preconditions.checkNotNull(key, "additional parameter keys cannot be null");
            Preconditions.checkNotNull(value, "additional parameter values cannot be null");
            Preconditions.checkArgument(!set.contains(key), "Parameter %s is directly supported via the authorization request builder, use the builder method instead", key);
            linkedHashMap.put(key, value);
        }
        return Collections.unmodifiableMap(linkedHashMap);
    }

    static Map<String, String> extractAdditionalParams(JSONObject jSONObject, Set<String> set) throws JSONException {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            if (!set.contains(next)) {
                linkedHashMap.put(next, jSONObject.get(next).toString());
            }
        }
        return linkedHashMap;
    }

    static Map<String, String> extractAdditionalParams(Uri uri, Set<String> set) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (String str : uri.getQueryParameterNames()) {
            if (!set.contains(str)) {
                linkedHashMap.put(str, uri.getQueryParameter(str));
            }
        }
        return linkedHashMap;
    }

    private AdditionalParamsProcessor() {
    }
}
