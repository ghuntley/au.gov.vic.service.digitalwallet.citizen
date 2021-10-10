package net.minidev.json.reader;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import net.minidev.asm.Accessor;
import net.minidev.asm.BeansAccess;
import net.minidev.json.JSONObject;
import net.minidev.json.JSONStyle;
import net.minidev.json.JSONUtil;

public class BeansWriterASMRemap implements JsonWriterI<Object> {
    private Map<String, String> rename = new HashMap();

    public void renameField(String str, String str2) {
        this.rename.put(str, str2);
    }

    private String rename(String str) {
        String str2 = this.rename.get(str);
        return str2 != null ? str2 : str;
    }

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
                    JSONObject.writeJSONKV(rename(accessor.getName()), obj, appendable, jSONStyle);
                }
            }
            appendable.append('}');
        } catch (IOException e2) {
            throw e2;
        }
    }
}
