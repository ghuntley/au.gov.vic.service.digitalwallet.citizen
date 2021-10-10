package com.nimbusds.jose;

import java.io.Serializable;
import kotlin.text.Typography;
import net.jcip.annotations.Immutable;
import net.minidev.json.JSONAware;
import net.minidev.json.JSONObject;

@Immutable
public final class JOSEObjectType implements JSONAware, Serializable {
    public static final JOSEObjectType JOSE = new JOSEObjectType("JOSE");
    public static final JOSEObjectType JOSE_JSON = new JOSEObjectType("JOSE+JSON");
    public static final JOSEObjectType JWT = new JOSEObjectType("JWT");
    private static final long serialVersionUID = 1;
    private final String type;

    public JOSEObjectType(String str) {
        if (str != null) {
            this.type = str;
            return;
        }
        throw new IllegalArgumentException("The object type must not be null");
    }

    public String getType() {
        return this.type;
    }

    public int hashCode() {
        return this.type.toLowerCase().hashCode();
    }

    public boolean equals(Object obj) {
        return (obj instanceof JOSEObjectType) && this.type.toLowerCase().equals(((JOSEObjectType) obj).type.toLowerCase());
    }

    public String toString() {
        return this.type;
    }

    @Override // net.minidev.json.JSONAware
    public String toJSONString() {
        return "\"" + JSONObject.escape(this.type) + Typography.quote;
    }
}
