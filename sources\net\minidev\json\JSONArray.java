package net.minidev.json;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import net.minidev.json.reader.JsonWriter;

public class JSONArray extends ArrayList<Object> implements List<Object>, JSONAwareEx, JSONStreamAwareEx {
    private static final long serialVersionUID = 9106884089231309568L;

    public static String toJSONString(List<? extends Object> list) {
        return toJSONString(list, JSONValue.COMPRESSION);
    }

    public static String toJSONString(List<? extends Object> list, JSONStyle jSONStyle) {
        StringBuilder sb = new StringBuilder();
        try {
            writeJSONString(list, sb, jSONStyle);
        } catch (IOException unused) {
        }
        return sb.toString();
    }

    public static void writeJSONString(Iterable<? extends Object> iterable, Appendable appendable, JSONStyle jSONStyle) throws IOException {
        if (iterable == null) {
            appendable.append("null");
        } else {
            JsonWriter.JSONIterableWriter.writeJSONString(iterable, appendable, jSONStyle);
        }
    }

    public static void writeJSONString(List<? extends Object> list, Appendable appendable) throws IOException {
        writeJSONString(list, appendable, JSONValue.COMPRESSION);
    }

    public JSONArray appendElement(Object obj) {
        add(obj);
        return this;
    }

    public void merge(Object obj) {
        JSONObject.merge(this, obj);
    }

    @Override // net.minidev.json.JSONAware
    public String toJSONString() {
        return toJSONString(this, JSONValue.COMPRESSION);
    }

    @Override // net.minidev.json.JSONAwareEx
    public String toJSONString(JSONStyle jSONStyle) {
        return toJSONString(this, jSONStyle);
    }

    public String toString() {
        return toJSONString();
    }

    public String toString(JSONStyle jSONStyle) {
        return toJSONString(jSONStyle);
    }

    @Override // net.minidev.json.JSONStreamAware
    public void writeJSONString(Appendable appendable) throws IOException {
        writeJSONString(this, appendable, JSONValue.COMPRESSION);
    }

    @Override // net.minidev.json.JSONStreamAwareEx
    public void writeJSONString(Appendable appendable, JSONStyle jSONStyle) throws IOException {
        writeJSONString(this, appendable, jSONStyle);
    }
}
