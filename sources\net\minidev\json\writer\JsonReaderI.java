package net.minidev.json.writer;

import java.io.IOException;
import java.lang.reflect.Type;
import net.minidev.json.parser.ParseException;

public abstract class JsonReaderI<T> {
    private static String ERR_MSG = "Invalid or non Implemented status";
    public final JsonReader base;

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    public T convert(Object obj) {
        return obj;
    }

    public JsonReaderI(JsonReader jsonReader) {
        this.base = jsonReader;
    }

    public JsonReaderI<?> startObject(String str) throws ParseException, IOException {
        throw new RuntimeException(String.valueOf(ERR_MSG) + " startObject(String key) in " + getClass() + " key=" + str);
    }

    public JsonReaderI<?> startArray(String str) throws ParseException, IOException {
        throw new RuntimeException(String.valueOf(ERR_MSG) + " startArray in " + getClass() + " key=" + str);
    }

    public void setValue(Object obj, String str, Object obj2) throws ParseException, IOException {
        throw new RuntimeException(String.valueOf(ERR_MSG) + " setValue in " + getClass() + " key=" + str);
    }

    public Object getValue(Object obj, String str) {
        throw new RuntimeException(String.valueOf(ERR_MSG) + " getValue(Object current, String key) in " + getClass() + " key=" + str);
    }

    public Type getType(String str) {
        throw new RuntimeException(String.valueOf(ERR_MSG) + " getType(String key) in " + getClass() + " key=" + str);
    }

    public void addValue(Object obj, Object obj2) throws ParseException, IOException {
        throw new RuntimeException(String.valueOf(ERR_MSG) + " addValue(Object current, Object value) in " + getClass());
    }

    public Object createObject() {
        throw new RuntimeException(String.valueOf(ERR_MSG) + " createObject() in " + getClass());
    }

    public Object createArray() {
        throw new RuntimeException(String.valueOf(ERR_MSG) + " createArray() in " + getClass());
    }
}
