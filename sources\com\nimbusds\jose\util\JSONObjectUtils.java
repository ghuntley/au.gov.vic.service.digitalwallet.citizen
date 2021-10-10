package com.nimbusds.jose.util;

import java.net.URI;
import java.net.URISyntaxException;
import java.text.ParseException;
import java.util.Arrays;
import java.util.List;
import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;
import net.minidev.json.parser.JSONParser;

public class JSONObjectUtils {
    public static JSONObject parse(String str) throws ParseException {
        try {
            Object parse = new JSONParser(640).parse(str);
            if (parse instanceof JSONObject) {
                return (JSONObject) parse;
            }
            throw new ParseException("JSON entity is not an object", 0);
        } catch (net.minidev.json.parser.ParseException e) {
            throw new ParseException("Invalid JSON: " + e.getMessage(), 0);
        } catch (Exception e2) {
            throw new ParseException("Unexpected exception: " + e2.getMessage(), 0);
        }
    }

    @Deprecated
    public static JSONObject parseJSONObject(String str) throws ParseException {
        return parse(str);
    }

    private static <T> T getGeneric(JSONObject jSONObject, String str, Class<T> cls) throws ParseException {
        if (jSONObject.get(str) == null) {
            return null;
        }
        T t = (T) jSONObject.get(str);
        if (cls.isAssignableFrom(t.getClass())) {
            return t;
        }
        throw new ParseException("Unexpected type of JSON object member with key \"" + str + "\"", 0);
    }

    public static boolean getBoolean(JSONObject jSONObject, String str) throws ParseException {
        Boolean bool = (Boolean) getGeneric(jSONObject, str, Boolean.class);
        if (bool != null) {
            return bool.booleanValue();
        }
        throw new ParseException("JSON object member with key \"" + str + "\" is missing or null", 0);
    }

    public static int getInt(JSONObject jSONObject, String str) throws ParseException {
        Number number = (Number) getGeneric(jSONObject, str, Number.class);
        if (number != null) {
            return number.intValue();
        }
        throw new ParseException("JSON object member with key \"" + str + "\" is missing or null", 0);
    }

    public static long getLong(JSONObject jSONObject, String str) throws ParseException {
        Number number = (Number) getGeneric(jSONObject, str, Number.class);
        if (number != null) {
            return number.longValue();
        }
        throw new ParseException("JSON object member with key \"" + str + "\" is missing or null", 0);
    }

    public static float getFloat(JSONObject jSONObject, String str) throws ParseException {
        Number number = (Number) getGeneric(jSONObject, str, Number.class);
        if (number != null) {
            return number.floatValue();
        }
        throw new ParseException("JSON object member with key \"" + str + "\" is missing or null", 0);
    }

    public static double getDouble(JSONObject jSONObject, String str) throws ParseException {
        Number number = (Number) getGeneric(jSONObject, str, Number.class);
        if (number != null) {
            return number.doubleValue();
        }
        throw new ParseException("JSON object member with key \"" + str + "\" is missing or null", 0);
    }

    public static String getString(JSONObject jSONObject, String str) throws ParseException {
        return (String) getGeneric(jSONObject, str, String.class);
    }

    public static URI getURI(JSONObject jSONObject, String str) throws ParseException {
        String string = getString(jSONObject, str);
        if (string == null) {
            return null;
        }
        try {
            return new URI(string);
        } catch (URISyntaxException e) {
            throw new ParseException(e.getMessage(), 0);
        }
    }

    public static JSONArray getJSONArray(JSONObject jSONObject, String str) throws ParseException {
        return (JSONArray) getGeneric(jSONObject, str, JSONArray.class);
    }

    public static String[] getStringArray(JSONObject jSONObject, String str) throws ParseException {
        JSONArray jSONArray = getJSONArray(jSONObject, str);
        if (jSONArray == null) {
            return null;
        }
        try {
            return (String[]) jSONArray.toArray(new String[0]);
        } catch (ArrayStoreException unused) {
            throw new ParseException("JSON object member with key \"" + str + "\" is not an array of strings", 0);
        }
    }

    public static List<String> getStringList(JSONObject jSONObject, String str) throws ParseException {
        String[] stringArray = getStringArray(jSONObject, str);
        if (stringArray == null) {
            return null;
        }
        return Arrays.asList(stringArray);
    }

    public static JSONObject getJSONObject(JSONObject jSONObject, String str) throws ParseException {
        return (JSONObject) getGeneric(jSONObject, str, JSONObject.class);
    }

    private JSONObjectUtils() {
    }
}
