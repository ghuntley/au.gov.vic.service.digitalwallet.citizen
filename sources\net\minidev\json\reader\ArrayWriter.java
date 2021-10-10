package net.minidev.json.reader;

import java.io.IOException;
import net.minidev.json.JSONStyle;
import net.minidev.json.JSONValue;

public class ArrayWriter implements JsonWriterI<Object> {
    @Override // net.minidev.json.reader.JsonWriterI
    public <E> void writeJSONString(E e, Appendable appendable, JSONStyle jSONStyle) throws IOException {
        jSONStyle.arrayStart(appendable);
        Object[] objArr = (Object[]) e;
        boolean z = false;
        for (Object obj : objArr) {
            if (z) {
                jSONStyle.objectNext(appendable);
            } else {
                z = true;
            }
            JSONValue.writeJSONString(obj, appendable, jSONStyle);
        }
        jSONStyle.arrayStop(appendable);
    }
}
