package net.openid.appauth;

import android.net.Uri;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* access modifiers changed from: package-private */
public final class JsonUtil {
    private JsonUtil() {
        throw new IllegalStateException("This type is not intended to be instantiated");
    }

    public static void put(JSONObject jSONObject, String str, int i) {
        Preconditions.checkNotNull(jSONObject, "json must not be null");
        Preconditions.checkNotNull(str, "field must not be null");
        Preconditions.checkNotNull(Integer.valueOf(i), "value must not be null");
        try {
            jSONObject.put(str, i);
        } catch (JSONException unused) {
            throw new IllegalStateException("JSONException thrown in violation of contract, ex");
        }
    }

    public static void put(JSONObject jSONObject, String str, String str2) {
        Preconditions.checkNotNull(jSONObject, "json must not be null");
        Preconditions.checkNotNull(str, "field must not be null");
        Preconditions.checkNotNull(str2, "value must not be null");
        try {
            jSONObject.put(str, str2);
        } catch (JSONException e) {
            throw new IllegalStateException("JSONException thrown in violation of contract", e);
        }
    }

    public static void put(JSONObject jSONObject, String str, JSONArray jSONArray) {
        Preconditions.checkNotNull(jSONObject, "json must not be null");
        Preconditions.checkNotNull(str, "field must not be null");
        Preconditions.checkNotNull(jSONArray, "value must not be null");
        try {
            jSONObject.put(str, jSONArray);
        } catch (JSONException e) {
            throw new IllegalStateException("JSONException thrown in violation of contract", e);
        }
    }

    public static void put(JSONObject jSONObject, String str, JSONObject jSONObject2) {
        Preconditions.checkNotNull(jSONObject, "json must not be null");
        Preconditions.checkNotNull(str, "field must not be null");
        Preconditions.checkNotNull(jSONObject2, "value must not be null");
        try {
            jSONObject.put(str, jSONObject2);
        } catch (JSONException e) {
            throw new IllegalStateException("JSONException thrown in violation of contract", e);
        }
    }

    public static void putIfNotNull(JSONObject jSONObject, String str, String str2) {
        Preconditions.checkNotNull(jSONObject, "json must not be null");
        Preconditions.checkNotNull(str, "field must not be null");
        if (str2 != null) {
            try {
                jSONObject.put(str, str2);
            } catch (JSONException e) {
                throw new IllegalStateException("JSONException thrown in violation of contract", e);
            }
        }
    }

    public static void putIfNotNull(JSONObject jSONObject, String str, Uri uri) {
        Preconditions.checkNotNull(jSONObject, "json must not be null");
        Preconditions.checkNotNull(str, "field must not be null");
        if (uri != null) {
            try {
                jSONObject.put(str, uri.toString());
            } catch (JSONException e) {
                throw new IllegalStateException("JSONException thrown in violation of contract", e);
            }
        }
    }

    public static void putIfNotNull(JSONObject jSONObject, String str, Long l) {
        Preconditions.checkNotNull(jSONObject, "json must not be null");
        Preconditions.checkNotNull(str, "field must not be null");
        if (l != null) {
            try {
                jSONObject.put(str, l);
            } catch (JSONException e) {
                throw new IllegalStateException("JSONException thrown in violation of contract", e);
            }
        }
    }

    public static void putIfNotNull(JSONObject jSONObject, String str, JSONObject jSONObject2) {
        Preconditions.checkNotNull(jSONObject, "json must not be null");
        Preconditions.checkNotNull(str, "field must not be null");
        if (jSONObject2 != null) {
            try {
                jSONObject.put(str, jSONObject2);
            } catch (JSONException e) {
                throw new IllegalStateException("JSONException thrown in violation of contract", e);
            }
        }
    }

    public static String getString(JSONObject jSONObject, String str) throws JSONException {
        Preconditions.checkNotNull(jSONObject, "json must not be null");
        Preconditions.checkNotNull(str, "field must not be null");
        if (jSONObject.has(str)) {
            String string = jSONObject.getString(str);
            if (string != null) {
                return string;
            }
            throw new JSONException("field \"" + str + "\" is mapped to a null value");
        }
        throw new JSONException("field \"" + str + "\" not found in json object");
    }

    public static String getStringIfDefined(JSONObject jSONObject, String str) throws JSONException {
        Preconditions.checkNotNull(jSONObject, "json must not be null");
        Preconditions.checkNotNull(str, "field must not be null");
        if (!jSONObject.has(str)) {
            return null;
        }
        String string = jSONObject.getString(str);
        if (string != null) {
            return string;
        }
        throw new JSONException("field \"" + str + "\" is mapped to a null value");
    }

    public static List<String> getStringListIfDefined(JSONObject jSONObject, String str) throws JSONException {
        Preconditions.checkNotNull(jSONObject, "json must not be null");
        Preconditions.checkNotNull(str, "field must not be null");
        if (!jSONObject.has(str)) {
            return null;
        }
        JSONArray jSONArray = jSONObject.getJSONArray(str);
        if (jSONArray != null) {
            return toStringList(jSONArray);
        }
        throw new JSONException("field \"" + str + "\" is mapped to a null value");
    }

    public static Uri getUri(JSONObject jSONObject, String str) throws JSONException {
        Preconditions.checkNotNull(jSONObject, "json must not be null");
        Preconditions.checkNotNull(str, "field must not be null");
        String string = jSONObject.getString(str);
        if (string != null) {
            return Uri.parse(string);
        }
        throw new JSONException("field \"" + str + "\" is mapped to a null value");
    }

    public static Uri getUriIfDefined(JSONObject jSONObject, String str) throws JSONException {
        Preconditions.checkNotNull(jSONObject, "json must not be null");
        Preconditions.checkNotNull(str, "field must not be null");
        if (!jSONObject.has(str)) {
            return null;
        }
        String string = jSONObject.getString(str);
        if (string != null) {
            return Uri.parse(string);
        }
        throw new JSONException("field \"" + str + "\" is mapped to a null value");
    }

    public static Long getLongIfDefined(JSONObject jSONObject, String str) throws JSONException {
        Preconditions.checkNotNull(jSONObject, "json must not be null");
        Preconditions.checkNotNull(str, "field must not be null");
        if (jSONObject.has(str) && !jSONObject.isNull(str)) {
            try {
                return Long.valueOf(jSONObject.getLong(str));
            } catch (JSONException unused) {
            }
        }
        return null;
    }

    public static List<String> getStringList(JSONObject jSONObject, String str) throws JSONException {
        Preconditions.checkNotNull(jSONObject, "json must not be null");
        Preconditions.checkNotNull(str, "field must not be null");
        if (jSONObject.has(str)) {
            return toStringList(jSONObject.getJSONArray(str));
        }
        throw new JSONException("field \"" + str + "\" not found in json object");
    }

    public static List<Uri> getUriList(JSONObject jSONObject, String str) throws JSONException {
        Preconditions.checkNotNull(jSONObject, "json must not be null");
        Preconditions.checkNotNull(str, "field must not be null");
        if (jSONObject.has(str)) {
            return toUriList(jSONObject.getJSONArray(str));
        }
        throw new JSONException("field \"" + str + "\" not found in json object");
    }

    public static Map<String, String> getStringMap(JSONObject jSONObject, String str) throws JSONException {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Preconditions.checkNotNull(jSONObject, "json must not be null");
        Preconditions.checkNotNull(str, "field must not be null");
        if (!jSONObject.has(str)) {
            return linkedHashMap;
        }
        JSONObject jSONObject2 = jSONObject.getJSONObject(str);
        Iterator<String> keys = jSONObject2.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            linkedHashMap.put(next, (String) Preconditions.checkNotNull(jSONObject2.getString(next), "additional parameter values must not be null"));
        }
        return linkedHashMap;
    }

    public static List<String> toStringList(JSONArray jSONArray) throws JSONException {
        ArrayList arrayList = new ArrayList();
        if (jSONArray != null) {
            for (int i = 0; i < jSONArray.length(); i++) {
                arrayList.add(Preconditions.checkNotNull(jSONArray.get(i)).toString());
            }
        }
        return arrayList;
    }

    public static List<Uri> toUriList(JSONArray jSONArray) throws JSONException {
        ArrayList arrayList = new ArrayList();
        if (jSONArray != null) {
            for (int i = 0; i < jSONArray.length(); i++) {
                arrayList.add(Uri.parse(Preconditions.checkNotNull(jSONArray.get(i)).toString()));
            }
        }
        return arrayList;
    }

    public static JSONArray toJsonArray(Iterable<?> iterable) {
        Preconditions.checkNotNull(iterable, "objects cannot be null");
        JSONArray jSONArray = new JSONArray();
        Iterator<?> it = iterable.iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next().toString());
        }
        return jSONArray;
    }

    public static JSONObject mapToJsonObject(Map<String, String> map) {
        Preconditions.checkNotNull(map);
        JSONObject jSONObject = new JSONObject();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            Preconditions.checkNotNull(entry.getKey(), "map entries must not have null keys");
            Preconditions.checkNotNull(entry.getValue(), "map entries must not have null values");
            put(jSONObject, entry.getKey(), entry.getValue());
        }
        return jSONObject;
    }

    public static <T> T get(JSONObject jSONObject, Field<T> field) {
        try {
            if (!jSONObject.has(field.key)) {
                return field.defaultValue;
            }
            return field.convert(jSONObject.getString(field.key));
        } catch (JSONException e) {
            throw new IllegalStateException("unexpected JSONException", e);
        }
    }

    public static <T> List<T> get(JSONObject jSONObject, ListField<T> listField) {
        try {
            if (!jSONObject.has(listField.key)) {
                return listField.defaultValue;
            }
            Object obj = jSONObject.get(listField.key);
            if (obj instanceof JSONArray) {
                JSONArray jSONArray = (JSONArray) obj;
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < jSONArray.length(); i++) {
                    arrayList.add(listField.convert(jSONArray.getString(i)));
                }
                return arrayList;
            }
            throw new IllegalStateException(listField.key + " does not contain the expected JSON array");
        } catch (JSONException e) {
            throw new IllegalStateException("unexpected JSONException", e);
        }
    }

    /* access modifiers changed from: package-private */
    public static abstract class Field<T> {
        public final T defaultValue;
        public final String key;

        /* access modifiers changed from: package-private */
        public abstract T convert(String str);

        Field(String str, T t) {
            this.key = str;
            this.defaultValue = t;
        }
    }

    /* access modifiers changed from: package-private */
    public static final class UriField extends Field<Uri> {
        UriField(String str, Uri uri) {
            super(str, uri);
        }

        UriField(String str) {
            this(str, null);
        }

        /* access modifiers changed from: package-private */
        @Override // net.openid.appauth.JsonUtil.Field
        public Uri convert(String str) {
            return Uri.parse(str);
        }
    }

    /* access modifiers changed from: package-private */
    public static final class StringField extends Field<String> {
        /* access modifiers changed from: package-private */
        @Override // net.openid.appauth.JsonUtil.Field
        public String convert(String str) {
            return str;
        }

        StringField(String str, String str2) {
            super(str, str2);
        }

        StringField(String str) {
            this(str, null);
        }
    }

    /* access modifiers changed from: package-private */
    public static final class BooleanField extends Field<Boolean> {
        BooleanField(String str, boolean z) {
            super(str, Boolean.valueOf(z));
        }

        /* access modifiers changed from: package-private */
        @Override // net.openid.appauth.JsonUtil.Field
        public Boolean convert(String str) {
            return Boolean.valueOf(Boolean.parseBoolean(str));
        }
    }

    /* access modifiers changed from: package-private */
    public static abstract class ListField<T> {
        public final List<T> defaultValue;
        public final String key;

        /* access modifiers changed from: package-private */
        public abstract T convert(String str);

        ListField(String str, List<T> list) {
            this.key = str;
            this.defaultValue = list;
        }
    }

    /* access modifiers changed from: package-private */
    public static final class StringListField extends ListField<String> {
        /* access modifiers changed from: package-private */
        @Override // net.openid.appauth.JsonUtil.ListField
        public String convert(String str) {
            return str;
        }

        StringListField(String str) {
            super(str, null);
        }

        StringListField(String str, List<String> list) {
            super(str, list);
        }
    }
}
