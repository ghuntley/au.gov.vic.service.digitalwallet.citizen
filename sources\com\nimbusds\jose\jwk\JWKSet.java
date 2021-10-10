package com.nimbusds.jose.jwk;

import com.bumptech.glide.load.Key;
import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.util.DefaultResourceRetriever;
import com.nimbusds.jose.util.IOUtils;
import com.nimbusds.jose.util.JSONObjectUtils;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.net.Proxy;
import java.net.URL;
import java.nio.charset.Charset;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.cert.Certificate;
import java.security.interfaces.ECPublicKey;
import java.security.interfaces.RSAPublicKey;
import java.text.ParseException;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import net.jcip.annotations.Immutable;
import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;

@Immutable
public class JWKSet implements Serializable {
    public static final String MIME_TYPE = "application/jwk-set+json; charset=UTF-8";
    private static final long serialVersionUID = 1;
    private final Map<String, Object> customMembers;
    private final List<JWK> keys;

    public JWKSet() {
        this(Collections.emptyList());
    }

    public JWKSet(JWK jwk) {
        this(Collections.singletonList(jwk));
        if (jwk == null) {
            throw new IllegalArgumentException("The JWK must not be null");
        }
    }

    public JWKSet(List<JWK> list) {
        this(list, Collections.emptyMap());
    }

    public JWKSet(List<JWK> list, Map<String, Object> map) {
        if (list != null) {
            this.keys = Collections.unmodifiableList(list);
            this.customMembers = Collections.unmodifiableMap(map);
            return;
        }
        throw new IllegalArgumentException("The JWK list must not be null");
    }

    public List<JWK> getKeys() {
        return this.keys;
    }

    public JWK getKeyByKeyId(String str) {
        for (JWK jwk : getKeys()) {
            if (jwk.getKeyID() != null && jwk.getKeyID().equals(str)) {
                return jwk;
            }
        }
        return null;
    }

    public Map<String, Object> getAdditionalMembers() {
        return this.customMembers;
    }

    public JWKSet toPublicJWKSet() {
        LinkedList linkedList = new LinkedList();
        for (JWK jwk : this.keys) {
            JWK publicJWK = jwk.toPublicJWK();
            if (publicJWK != null) {
                linkedList.add(publicJWK);
            }
        }
        return new JWKSet(linkedList, this.customMembers);
    }

    public JSONObject toJSONObject() {
        return toJSONObject(true);
    }

    public JSONObject toJSONObject(boolean z) {
        JSONObject jSONObject = new JSONObject(this.customMembers);
        JSONArray jSONArray = new JSONArray();
        for (JWK jwk : this.keys) {
            if (z) {
                JWK publicJWK = jwk.toPublicJWK();
                if (publicJWK != null) {
                    jSONArray.add(publicJWK.toJSONObject());
                }
            } else {
                jSONArray.add(jwk.toJSONObject());
            }
        }
        jSONObject.put("keys", jSONArray);
        return jSONObject;
    }

    public String toString() {
        return toJSONObject().toString();
    }

    public static JWKSet parse(String str) throws ParseException {
        return parse(JSONObjectUtils.parse(str));
    }

    public static JWKSet parse(JSONObject jSONObject) throws ParseException {
        JSONArray jSONArray = JSONObjectUtils.getJSONArray(jSONObject, "keys");
        if (jSONArray != null) {
            LinkedList linkedList = new LinkedList();
            for (int i = 0; i < jSONArray.size(); i++) {
                if (jSONArray.get(i) instanceof JSONObject) {
                    try {
                        linkedList.add(JWK.parse((JSONObject) jSONArray.get(i)));
                    } catch (ParseException e) {
                        throw new ParseException("Invalid JWK at position " + i + ": " + e.getMessage(), 0);
                    }
                } else {
                    throw new ParseException("The \"keys\" JSON array must contain JSON objects only", 0);
                }
            }
            HashMap hashMap = new HashMap();
            for (Map.Entry entry : jSONObject.entrySet()) {
                if (entry.getKey() != null && !((String) entry.getKey()).equals("keys")) {
                    hashMap.put(entry.getKey(), entry.getValue());
                }
            }
            return new JWKSet(linkedList, hashMap);
        }
        throw new ParseException("Missing required \"keys\" member", 0);
    }

    public static JWKSet load(InputStream inputStream) throws IOException, ParseException {
        return parse(IOUtils.readInputStreamToString(inputStream, Charset.forName(Key.STRING_CHARSET_NAME)));
    }

    public static JWKSet load(File file) throws IOException, ParseException {
        return parse(IOUtils.readFileToString(file, Charset.forName(Key.STRING_CHARSET_NAME)));
    }

    public static JWKSet load(URL url, int i, int i2, int i3) throws IOException, ParseException {
        return load(url, i, i2, i3, null);
    }

    public static JWKSet load(URL url, int i, int i2, int i3, Proxy proxy) throws IOException, ParseException {
        DefaultResourceRetriever defaultResourceRetriever = new DefaultResourceRetriever(i, i2, i3);
        defaultResourceRetriever.setProxy(proxy);
        return parse(defaultResourceRetriever.retrieveResource(url).getContent());
    }

    public static JWKSet load(URL url) throws IOException, ParseException {
        return load(url, 0, 0, 0);
    }

    public static JWKSet load(KeyStore keyStore, PasswordLookup passwordLookup) throws KeyStoreException {
        ECKey load;
        LinkedList linkedList = new LinkedList();
        Enumeration<String> aliases = keyStore.aliases();
        while (aliases.hasMoreElements()) {
            String nextElement = aliases.nextElement();
            char[] charArray = passwordLookup == null ? "".toCharArray() : passwordLookup.lookupPassword(nextElement);
            Certificate certificate = keyStore.getCertificate(nextElement);
            if (certificate != null) {
                if (certificate.getPublicKey() instanceof RSAPublicKey) {
                    try {
                        RSAKey load2 = RSAKey.load(keyStore, nextElement, charArray);
                        if (load2 != null) {
                            linkedList.add(load2);
                        }
                    } catch (JOSEException unused) {
                    }
                } else if ((certificate.getPublicKey() instanceof ECPublicKey) && (load = ECKey.load(keyStore, nextElement, charArray)) != null) {
                    linkedList.add(load);
                }
            }
        }
        Enumeration<String> aliases2 = keyStore.aliases();
        while (aliases2.hasMoreElements()) {
            String nextElement2 = aliases2.nextElement();
            try {
                OctetSequenceKey load3 = OctetSequenceKey.load(keyStore, nextElement2, passwordLookup == null ? "".toCharArray() : passwordLookup.lookupPassword(nextElement2));
                if (load3 != null) {
                    linkedList.add(load3);
                }
            } catch (JOSEException unused2) {
            }
        }
        return new JWKSet(linkedList);
    }
}
