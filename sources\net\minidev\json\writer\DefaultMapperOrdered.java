package net.minidev.json.writer;

import java.util.LinkedHashMap;
import java.util.Map;
import net.minidev.json.JSONArray;
import net.minidev.json.JSONAwareEx;

public class DefaultMapperOrdered extends JsonReaderI<JSONAwareEx> {
    protected DefaultMapperOrdered(JsonReader jsonReader) {
        super(jsonReader);
    }

    @Override // net.minidev.json.writer.JsonReaderI
    public JsonReaderI<JSONAwareEx> startObject(String str) {
        return this.base.DEFAULT_ORDERED;
    }

    @Override // net.minidev.json.writer.JsonReaderI
    public JsonReaderI<JSONAwareEx> startArray(String str) {
        return this.base.DEFAULT_ORDERED;
    }

    @Override // net.minidev.json.writer.JsonReaderI
    public void setValue(Object obj, String str, Object obj2) {
        ((Map) obj).put(str, obj2);
    }

    @Override // net.minidev.json.writer.JsonReaderI
    public Object createObject() {
        return new LinkedHashMap();
    }

    @Override // net.minidev.json.writer.JsonReaderI
    public void addValue(Object obj, Object obj2) {
        ((JSONArray) obj).add(obj2);
    }

    @Override // net.minidev.json.writer.JsonReaderI
    public Object createArray() {
        return new JSONArray();
    }
}
