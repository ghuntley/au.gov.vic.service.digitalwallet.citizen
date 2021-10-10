package com.nimbusds.jose.jwk;

import com.nimbusds.jose.Algorithm;
import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.jwk.ECKey;
import com.nimbusds.jose.jwk.RSAKey;
import com.nimbusds.jose.util.Base64;
import com.nimbusds.jose.util.Base64URL;
import com.nimbusds.jose.util.JSONObjectUtils;
import com.nimbusds.jose.util.X509CertChainUtils;
import com.nimbusds.jose.util.X509CertUtils;
import java.io.Serializable;
import java.net.URI;
import java.security.KeyPair;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.security.interfaces.ECPrivateKey;
import java.security.interfaces.ECPublicKey;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.ECParameterSpec;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import net.minidev.json.JSONArray;
import net.minidev.json.JSONAware;
import net.minidev.json.JSONObject;

public abstract class JWK implements JSONAware, Serializable {
    public static final String MIME_TYPE = "application/jwk+json; charset=UTF-8";
    private static final long serialVersionUID = 1;
    private final Algorithm alg;
    private final KeyStore keyStore;
    private final String kid;
    private final KeyType kty;
    private final Set<KeyOperation> ops;
    private final List<X509Certificate> parsedX5c;
    private final KeyUse use;
    private final List<Base64> x5c;
    @Deprecated
    private final Base64URL x5t;
    private Base64URL x5t256;
    private final URI x5u;

    public abstract LinkedHashMap<String, ?> getRequiredParams();

    public abstract boolean isPrivate();

    public abstract int size();

    public abstract JWK toPublicJWK();

    protected JWK(KeyType keyType, KeyUse keyUse, Set<KeyOperation> set, Algorithm algorithm, String str, URI uri, Base64URL base64URL, Base64URL base64URL2, List<Base64> list, KeyStore keyStore2) {
        if (keyType != null) {
            this.kty = keyType;
            if (KeyUseAndOpsConsistency.areConsistent(keyUse, set)) {
                this.use = keyUse;
                this.ops = set;
                this.alg = algorithm;
                this.kid = str;
                this.x5u = uri;
                this.x5t = base64URL;
                this.x5t256 = base64URL2;
                if (list == null || !list.isEmpty()) {
                    this.x5c = list;
                    try {
                        this.parsedX5c = X509CertChainUtils.parse(list);
                        this.keyStore = keyStore2;
                    } catch (ParseException e) {
                        throw new IllegalArgumentException("Invalid X.509 certificate chain \"x5c\": " + e.getMessage(), e);
                    }
                } else {
                    throw new IllegalArgumentException("The X.509 certificate chain \"x5c\" must not be empty");
                }
            } else {
                throw new IllegalArgumentException("The key use \"use\" and key options \"key_opts\" parameters are not consistent, see RFC 7517, section 4.3");
            }
        } else {
            throw new IllegalArgumentException("The key type \"kty\" parameter must not be null");
        }
    }

    public KeyType getKeyType() {
        return this.kty;
    }

    public KeyUse getKeyUse() {
        return this.use;
    }

    public Set<KeyOperation> getKeyOperations() {
        return this.ops;
    }

    public Algorithm getAlgorithm() {
        return this.alg;
    }

    public String getKeyID() {
        return this.kid;
    }

    public URI getX509CertURL() {
        return this.x5u;
    }

    @Deprecated
    public Base64URL getX509CertThumbprint() {
        return this.x5t;
    }

    public Base64URL getX509CertSHA256Thumbprint() {
        return this.x5t256;
    }

    public List<Base64> getX509CertChain() {
        List<Base64> list = this.x5c;
        if (list == null) {
            return null;
        }
        return Collections.unmodifiableList(list);
    }

    public List<X509Certificate> getParsedX509CertChain() {
        List<X509Certificate> list = this.parsedX5c;
        if (list == null) {
            return null;
        }
        return Collections.unmodifiableList(list);
    }

    public KeyStore getKeyStore() {
        return this.keyStore;
    }

    public Base64URL computeThumbprint() throws JOSEException {
        return computeThumbprint("SHA-256");
    }

    public Base64URL computeThumbprint(String str) throws JOSEException {
        return ThumbprintUtils.compute(str, this);
    }

    public JSONObject toJSONObject() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("kty", this.kty.getValue());
        KeyUse keyUse = this.use;
        if (keyUse != null) {
            jSONObject.put("use", keyUse.identifier());
        }
        if (this.ops != null) {
            ArrayList arrayList = new ArrayList(this.ops.size());
            for (KeyOperation keyOperation : this.ops) {
                arrayList.add(keyOperation.identifier());
            }
            jSONObject.put("key_ops", arrayList);
        }
        Algorithm algorithm = this.alg;
        if (algorithm != null) {
            jSONObject.put("alg", algorithm.getName());
        }
        String str = this.kid;
        if (str != null) {
            jSONObject.put("kid", str);
        }
        URI uri = this.x5u;
        if (uri != null) {
            jSONObject.put("x5u", uri.toString());
        }
        Base64URL base64URL = this.x5t;
        if (base64URL != null) {
            jSONObject.put("x5t", base64URL.toString());
        }
        Base64URL base64URL2 = this.x5t256;
        if (base64URL2 != null) {
            jSONObject.put("x5t#S256", base64URL2.toString());
        }
        if (this.x5c != null) {
            JSONArray jSONArray = new JSONArray();
            for (Base64 base64 : this.x5c) {
                jSONArray.add(base64.toString());
            }
            jSONObject.put("x5c", jSONArray);
        }
        return jSONObject;
    }

    @Override // net.minidev.json.JSONAware
    public String toJSONString() {
        return toJSONObject().toString();
    }

    public String toString() {
        return toJSONObject().toString();
    }

    public static JWK parse(String str) throws ParseException {
        return parse(JSONObjectUtils.parse(str));
    }

    public static JWK parse(JSONObject jSONObject) throws ParseException {
        KeyType parse = KeyType.parse(JSONObjectUtils.getString(jSONObject, "kty"));
        if (parse == KeyType.EC) {
            return ECKey.parse(jSONObject);
        }
        if (parse == KeyType.RSA) {
            return RSAKey.parse(jSONObject);
        }
        if (parse == KeyType.OCT) {
            return OctetSequenceKey.parse(jSONObject);
        }
        if (parse == KeyType.OKP) {
            return OctetKeyPair.parse(jSONObject);
        }
        throw new ParseException("Unsupported key type \"kty\" parameter: " + parse, 0);
    }

    public static JWK parse(X509Certificate x509Certificate) throws JOSEException {
        if (x509Certificate.getPublicKey() instanceof RSAPublicKey) {
            return RSAKey.parse(x509Certificate);
        }
        if (x509Certificate.getPublicKey() instanceof ECPublicKey) {
            return ECKey.parse(x509Certificate);
        }
        throw new JOSEException("Unsupported public key algorithm: " + x509Certificate.getPublicKey().getAlgorithm());
    }

    public static JWK parseFromPEMEncodedX509Cert(String str) throws JOSEException {
        X509Certificate parse = X509CertUtils.parse(str);
        if (parse != null) {
            return parse(parse);
        }
        throw new JOSEException("Couldn't parse PEM-encoded X.509 certificate");
    }

    public static JWK load(KeyStore keyStore2, String str, char[] cArr) throws KeyStoreException, JOSEException {
        Certificate certificate = keyStore2.getCertificate(str);
        if (certificate == null) {
            return OctetSequenceKey.load(keyStore2, str, cArr);
        }
        if (certificate.getPublicKey() instanceof RSAPublicKey) {
            return RSAKey.load(keyStore2, str, cArr);
        }
        if (certificate.getPublicKey() instanceof ECPublicKey) {
            return ECKey.load(keyStore2, str, cArr);
        }
        throw new JOSEException("Unsupported public key algorithm: " + certificate.getPublicKey().getAlgorithm());
    }

    public static JWK parseFromPEMEncodedObjects(String str) throws JOSEException {
        if (!PEMEncodedKeyParser.parseKeys(str).isEmpty()) {
            KeyPair mergeKeyPairs = mergeKeyPairs(toKeyPairList(str));
            PublicKey publicKey = mergeKeyPairs.getPublic();
            PrivateKey privateKey = mergeKeyPairs.getPrivate();
            if (publicKey == null) {
                throw new JOSEException("Missing PEM-encoded public key to construct JWK");
            } else if (publicKey instanceof ECPublicKey) {
                ECPublicKey eCPublicKey = (ECPublicKey) publicKey;
                ECParameterSpec params = eCPublicKey.getParams();
                boolean z = privateKey instanceof ECPrivateKey;
                if (z) {
                    validateEcCurves(eCPublicKey, (ECPrivateKey) privateKey);
                }
                if (privateKey == null || z) {
                    ECKey.Builder builder = new ECKey.Builder(Curve.forECParameterSpec(params), eCPublicKey);
                    if (privateKey != null) {
                        builder.privateKey((ECPrivateKey) privateKey);
                    }
                    return builder.build();
                }
                throw new JOSEException("Unsupported EC private key type: " + privateKey);
            } else if (publicKey instanceof RSAPublicKey) {
                RSAKey.Builder builder2 = new RSAKey.Builder((RSAPublicKey) publicKey);
                if (privateKey instanceof RSAPrivateKey) {
                    builder2.privateKey((RSAPrivateKey) privateKey);
                } else if (privateKey != null) {
                    throw new JOSEException("Unsupported RSA private key type: " + privateKey);
                }
                return builder2.build();
            } else {
                throw new JOSEException("Unsupported algorithm of PEM-encoded key: " + publicKey.getAlgorithm());
            }
        } else {
            throw new JOSEException("No PEM-encoded keys found");
        }
    }

    private static void validateEcCurves(ECPublicKey eCPublicKey, ECPrivateKey eCPrivateKey) throws JOSEException {
        ECParameterSpec params = eCPublicKey.getParams();
        ECParameterSpec params2 = eCPrivateKey.getParams();
        if (!params.getCurve().equals(params2.getCurve())) {
            throw new JOSEException("Public/private EC key curve mismatch: " + eCPublicKey);
        } else if (params.getCofactor() != params2.getCofactor()) {
            throw new JOSEException("Public/private EC key cofactor mismatch: " + eCPublicKey);
        } else if (!params.getGenerator().equals(params2.getGenerator())) {
            throw new JOSEException("Public/private EC key generator mismatch: " + eCPublicKey);
        } else if (!params.getOrder().equals(params2.getOrder())) {
            throw new JOSEException("Public/private EC key order mismatch: " + eCPublicKey);
        }
    }

    private static KeyPair mergeKeyPairs(List<KeyPair> list) throws JOSEException {
        if (list.size() == 1) {
            return list.get(0);
        }
        if (list.size() == 2) {
            return twoKeysToKeyPair(list);
        }
        throw new JOSEException("Expected key or pair of PEM-encoded keys");
    }

    private static List<KeyPair> toKeyPairList(String str) throws JOSEException {
        List<KeyPair> parseKeys = PEMEncodedKeyParser.parseKeys(str);
        if (!parseKeys.isEmpty()) {
            return parseKeys;
        }
        throw new JOSEException("No PEM-encoded keys found");
    }

    private static KeyPair twoKeysToKeyPair(List<? extends KeyPair> list) throws JOSEException {
        KeyPair keyPair = (KeyPair) list.get(0);
        KeyPair keyPair2 = (KeyPair) list.get(1);
        if (keyPair.getPublic() != null && keyPair2.getPrivate() != null) {
            return new KeyPair(keyPair.getPublic(), keyPair2.getPrivate());
        }
        if (keyPair.getPrivate() != null && keyPair2.getPublic() != null) {
            return new KeyPair(keyPair2.getPublic(), keyPair.getPrivate());
        }
        throw new JOSEException("Not a public/private key pair");
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof JWK)) {
            return false;
        }
        JWK jwk = (JWK) obj;
        return Objects.equals(this.kty, jwk.kty) && Objects.equals(this.use, jwk.use) && Objects.equals(this.ops, jwk.ops) && Objects.equals(this.alg, jwk.alg) && Objects.equals(this.kid, jwk.kid) && Objects.equals(this.x5u, jwk.x5u) && Objects.equals(this.x5t, jwk.x5t) && Objects.equals(this.x5t256, jwk.x5t256) && Objects.equals(this.x5c, jwk.x5c) && Objects.equals(this.parsedX5c, jwk.parsedX5c) && Objects.equals(this.keyStore, jwk.keyStore);
    }

    public int hashCode() {
        return Objects.hash(this.kty, this.use, this.ops, this.alg, this.kid, this.x5u, this.x5t, this.x5t256, this.x5c, this.parsedX5c, this.keyStore);
    }
}
