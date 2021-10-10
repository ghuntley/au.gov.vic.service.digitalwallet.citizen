package net.minidev.json.writer;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;
import net.minidev.json.parser.ParseException;

public class MapperRemapped<T> extends JsonReaderI<T> {
    private JsonReaderI<T> parent;
    private Map<String, String> rename = new HashMap();

    public MapperRemapped(JsonReaderI<T> jsonReaderI) {
        super(jsonReaderI.base);
        this.parent = jsonReaderI;
    }

    public void renameField(String str, String str2) {
        this.rename.put(str, str2);
    }

    private String rename(String str) {
        String str2 = this.rename.get(str);
        return str2 != null ? str2 : str;
    }

    @Override // net.minidev.json.writer.JsonReaderI
    public void setValue(Object obj, String str, Object obj2) throws ParseException, IOException {
        this.parent.setValue(obj, rename(str), obj2);
    }

    @Override // net.minidev.json.writer.JsonReaderI
    public Object getValue(Object obj, String str) {
        return this.parent.getValue(obj, rename(str));
    }

    @Override // net.minidev.json.writer.JsonReaderI
    public Type getType(String str) {
        return this.parent.getType(rename(str));
    }

    @Override // net.minidev.json.writer.JsonReaderI
    public JsonReaderI<?> startArray(String str) throws ParseException, IOException {
        return this.parent.startArray(rename(str));
    }

    @Override // net.minidev.json.writer.JsonReaderI
    public JsonReaderI<?> startObject(String str) throws ParseException, IOException {
        return this.parent.startObject(rename(str));
    }

    @Override // net.minidev.json.writer.JsonReaderI
    public Object createObject() {
        return this.parent.createObject();
    }
}
