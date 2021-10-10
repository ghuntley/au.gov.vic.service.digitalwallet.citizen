package com.nimbusds.jose.util;

import java.security.cert.X509Certificate;
import java.text.ParseException;
import java.util.LinkedList;
import java.util.List;
import net.minidev.json.JSONArray;

public class X509CertChainUtils {
    public static List<Base64> toBase64List(JSONArray jSONArray) throws ParseException {
        if (jSONArray == null) {
            return null;
        }
        LinkedList linkedList = new LinkedList();
        for (int i = 0; i < jSONArray.size(); i++) {
            Object obj = jSONArray.get(i);
            if (obj == null) {
                throw new ParseException("The X.509 certificate at position " + i + " must not be null", 0);
            } else if (obj instanceof String) {
                linkedList.add(new Base64((String) obj));
            } else {
                throw new ParseException("The X.509 certificate at position " + i + " must be encoded as a Base64 string", 0);
            }
        }
        return linkedList;
    }

    public static List<X509Certificate> parse(List<Base64> list) throws ParseException {
        if (list == null) {
            return null;
        }
        LinkedList linkedList = new LinkedList();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) != null) {
                X509Certificate parse = X509CertUtils.parse(list.get(i).decode());
                if (parse != null) {
                    linkedList.add(parse);
                } else {
                    throw new ParseException("Invalid X.509 certificate at position " + i, 0);
                }
            }
        }
        return linkedList;
    }

    private X509CertChainUtils() {
    }
}
