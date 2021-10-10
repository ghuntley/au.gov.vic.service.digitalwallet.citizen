package net.minidev.json.writer;

public class FakeMapper extends JsonReaderI<Object> {
    public static JsonReaderI<Object> DEFAULT = new FakeMapper();

    @Override // net.minidev.json.writer.JsonReaderI
    public void addValue(Object obj, Object obj2) {
    }

    @Override // net.minidev.json.writer.JsonReaderI
    public Object createArray() {
        return null;
    }

    @Override // net.minidev.json.writer.JsonReaderI
    public Object createObject() {
        return null;
    }

    @Override // net.minidev.json.writer.JsonReaderI
    public void setValue(Object obj, String str, Object obj2) {
    }

    @Override // net.minidev.json.writer.JsonReaderI
    public JsonReaderI<?> startArray(String str) {
        return this;
    }

    @Override // net.minidev.json.writer.JsonReaderI
    public JsonReaderI<?> startObject(String str) {
        return this;
    }

    private FakeMapper() {
        super(null);
    }
}
