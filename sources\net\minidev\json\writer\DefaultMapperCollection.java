package net.minidev.json.writer;

import java.util.List;
import java.util.Map;

public class DefaultMapperCollection<T> extends JsonReaderI<T> {
    Class<T> clz;

    @Override // net.minidev.json.writer.JsonReaderI
    public JsonReaderI<T> startArray(String str) {
        return this;
    }

    @Override // net.minidev.json.writer.JsonReaderI
    public JsonReaderI<T> startObject(String str) {
        return this;
    }

    public DefaultMapperCollection(JsonReader jsonReader, Class<T> cls) {
        super(jsonReader);
        this.clz = cls;
    }

    @Override // net.minidev.json.writer.JsonReaderI
    public Object createObject() {
        try {
            return this.clz.getConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // net.minidev.json.writer.JsonReaderI
    public Object createArray() {
        try {
            return this.clz.getConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // net.minidev.json.writer.JsonReaderI
    public void setValue(Object obj, String str, Object obj2) {
        ((Map) obj).put(str, obj2);
    }

    @Override // net.minidev.json.writer.JsonReaderI
    public void addValue(Object obj, Object obj2) {
        ((List) obj).add(obj2);
    }
}
