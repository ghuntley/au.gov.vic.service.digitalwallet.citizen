package net.minidev.json.writer;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Objects;
import net.minidev.json.parser.ParseException;

public class UpdaterMapper<T> extends JsonReaderI<T> {
    final JsonReaderI<?> mapper;
    final T obj;

    public UpdaterMapper(JsonReader jsonReader, T t) {
        super(jsonReader);
        Objects.requireNonNull(t, "can not update null Object");
        this.obj = t;
        this.mapper = jsonReader.getMapper((Class) t.getClass());
    }

    public UpdaterMapper(JsonReader jsonReader, T t, Type type) {
        super(jsonReader);
        Objects.requireNonNull(t, "can not update null Object");
        this.obj = t;
        this.mapper = jsonReader.getMapper(type);
    }

    @Override // net.minidev.json.writer.JsonReaderI
    public JsonReaderI<?> startObject(String str) throws ParseException, IOException {
        Object value = this.mapper.getValue(this.obj, str);
        if (value == null) {
            return this.mapper.startObject(str);
        }
        return new UpdaterMapper(this.base, value, this.mapper.getType(str));
    }

    @Override // net.minidev.json.writer.JsonReaderI
    public JsonReaderI<?> startArray(String str) throws ParseException, IOException {
        return this.mapper.startArray(str);
    }

    @Override // net.minidev.json.writer.JsonReaderI
    public void setValue(Object obj2, String str, Object obj3) throws ParseException, IOException {
        this.mapper.setValue(obj2, str, obj3);
    }

    @Override // net.minidev.json.writer.JsonReaderI
    public void addValue(Object obj2, Object obj3) throws ParseException, IOException {
        this.mapper.addValue(obj2, obj3);
    }

    @Override // net.minidev.json.writer.JsonReaderI
    public Object createObject() {
        T t = this.obj;
        if (t != null) {
            return t;
        }
        return this.mapper.createObject();
    }

    @Override // net.minidev.json.writer.JsonReaderI
    public Object createArray() {
        T t = this.obj;
        if (t != null) {
            return t;
        }
        return this.mapper.createArray();
    }

    @Override // net.minidev.json.writer.JsonReaderI
    public T convert(Object obj2) {
        T t = this.obj;
        return t != null ? t : (T) this.mapper.convert(obj2);
    }
}
