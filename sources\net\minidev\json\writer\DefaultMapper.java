package net.minidev.json.writer;

import net.minidev.json.JSONArray;
import net.minidev.json.JSONAwareEx;
import net.minidev.json.JSONObject;

public class DefaultMapper<T> extends JsonReaderI<T> {
    protected DefaultMapper(JsonReader jsonReader) {
        super(jsonReader);
    }

    @Override // net.minidev.json.writer.JsonReaderI
    public JsonReaderI<JSONAwareEx> startObject(String str) {
        return this.base.DEFAULT;
    }

    @Override // net.minidev.json.writer.JsonReaderI
    public JsonReaderI<JSONAwareEx> startArray(String str) {
        return this.base.DEFAULT;
    }

    @Override // net.minidev.json.writer.JsonReaderI
    public Object createObject() {
        return new JSONObject();
    }

    @Override // net.minidev.json.writer.JsonReaderI
    public Object createArray() {
        return new JSONArray();
    }

    @Override // net.minidev.json.writer.JsonReaderI
    public void setValue(Object obj, String str, Object obj2) {
        ((JSONObject) obj).put(str, obj2);
    }

    @Override // net.minidev.json.writer.JsonReaderI
    public void addValue(Object obj, Object obj2) {
        ((JSONArray) obj).add(obj2);
    }
}
