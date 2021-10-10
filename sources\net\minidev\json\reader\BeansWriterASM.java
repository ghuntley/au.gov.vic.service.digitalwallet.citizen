package net.minidev.json.reader;

import java.io.IOException;
import net.minidev.asm.Accessor;
import net.minidev.asm.BeansAccess;
import net.minidev.json.JSONObject;
import net.minidev.json.JSONStyle;
import net.minidev.json.JSONUtil;

public class BeansWriterASM implements JsonWriterI<Object> {
    @Override // net.minidev.json.reader.JsonWriterI
    public <E> void writeJSONString(E e, Appendable appendable, JSONStyle jSONStyle) throws IOException {
        try {
            BeansAccess beansAccess = BeansAccess.get(e.getClass(), JSONUtil.JSON_SMART_FIELD_FILTER);
            appendable.append('{');
            Accessor[] accessors = beansAccess.getAccessors();
            boolean z = false;
            for (Accessor accessor : accessors) {
                Object obj = beansAccess.get(e, accessor.getIndex());
                if (obj != null || !jSONStyle.ignoreNull()) {
                    if (z) {
                        appendable.append(',');
                    } else {
                        z = true;
                    }
                    JSONObject.writeJSONKV(accessor.getName(), obj, appendable, jSONStyle);
                }
            }
            appendable.append('}');
        } catch (IOException e2) {
            throw e2;
        }
    }
}
