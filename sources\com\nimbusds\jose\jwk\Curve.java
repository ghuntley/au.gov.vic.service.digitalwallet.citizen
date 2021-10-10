package com.nimbusds.jose.jwk;

import com.nimbusds.jose.JWSAlgorithm;
import java.io.Serializable;
import java.security.spec.ECParameterSpec;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import net.jcip.annotations.Immutable;

@Immutable
public final class Curve implements Serializable {
    public static final Curve Ed25519 = new Curve("Ed25519", "Ed25519", null);
    public static final Curve Ed448 = new Curve("Ed448", "Ed448", null);
    public static final Curve P_256 = new Curve("P-256", "secp256r1", "1.2.840.10045.3.1.7");
    @Deprecated
    public static final Curve P_256K = new Curve("P-256K", "secp256k1", "1.3.132.0.10");
    public static final Curve P_384 = new Curve("P-384", "secp384r1", "1.3.132.0.34");
    public static final Curve P_521 = new Curve("P-521", "secp521r1", "1.3.132.0.35");
    public static final Curve SECP256K1 = new Curve("secp256k1", "secp256k1", "1.3.132.0.10");
    public static final Curve X25519 = new Curve("X25519", "X25519", null);
    public static final Curve X448 = new Curve("X448", "X448", null);
    private static final long serialVersionUID = 1;
    private final String name;
    private final String oid;
    private final String stdName;

    public Curve(String str) {
        this(str, null, null);
    }

    public Curve(String str, String str2, String str3) {
        if (str != null) {
            this.name = str;
            this.stdName = str2;
            this.oid = str3;
            return;
        }
        throw new IllegalArgumentException("The JOSE cryptographic curve name must not be null");
    }

    public String getName() {
        return this.name;
    }

    public String getStdName() {
        return this.stdName;
    }

    public String getOID() {
        return this.oid;
    }

    public ECParameterSpec toECParameterSpec() {
        return ECParameterTable.get(this);
    }

    public String toString() {
        return getName();
    }

    public boolean equals(Object obj) {
        return (obj instanceof Curve) && toString().equals(obj.toString());
    }

    public static Curve parse(String str) {
        if (str == null || str.trim().isEmpty()) {
            throw new IllegalArgumentException("The cryptographic curve string must not be null or empty");
        }
        Curve curve = P_256;
        if (str.equals(curve.getName())) {
            return curve;
        }
        Curve curve2 = P_256K;
        if (str.equals(curve2.getName())) {
            return curve2;
        }
        Curve curve3 = SECP256K1;
        if (str.equals(curve3.getName())) {
            return curve3;
        }
        Curve curve4 = P_384;
        if (str.equals(curve4.getName())) {
            return curve4;
        }
        Curve curve5 = P_521;
        if (str.equals(curve5.getName())) {
            return curve5;
        }
        Curve curve6 = Ed25519;
        if (str.equals(curve6.getName())) {
            return curve6;
        }
        Curve curve7 = Ed448;
        if (str.equals(curve7.getName())) {
            return curve7;
        }
        Curve curve8 = X25519;
        if (str.equals(curve8.getName())) {
            return curve8;
        }
        Curve curve9 = X448;
        if (str.equals(curve9.getName())) {
            return curve9;
        }
        return new Curve(str);
    }

    public static Curve forStdName(String str) {
        if ("secp256r1".equals(str) || "prime256v1".equals(str)) {
            return P_256;
        }
        if ("secp256k1".equals(str)) {
            return SECP256K1;
        }
        if ("secp384r1".equals(str)) {
            return P_384;
        }
        if ("secp521r1".equals(str)) {
            return P_521;
        }
        Curve curve = Ed25519;
        if (curve.getStdName().equals(str)) {
            return curve;
        }
        Curve curve2 = Ed448;
        if (curve2.getStdName().equals(str)) {
            return curve2;
        }
        Curve curve3 = X25519;
        if (curve3.getStdName().equals(str)) {
            return curve3;
        }
        Curve curve4 = X448;
        if (curve4.getStdName().equals(str)) {
            return curve4;
        }
        return null;
    }

    public static Curve forOID(String str) {
        Curve curve = P_256;
        if (curve.getOID().equals(str)) {
            return curve;
        }
        Curve curve2 = SECP256K1;
        if (curve2.getOID().equals(str)) {
            return curve2;
        }
        Curve curve3 = P_384;
        if (curve3.getOID().equals(str)) {
            return curve3;
        }
        Curve curve4 = P_521;
        if (curve4.getOID().equals(str)) {
            return curve4;
        }
        return null;
    }

    public static Set<Curve> forJWSAlgorithm(JWSAlgorithm jWSAlgorithm) {
        if (JWSAlgorithm.ES256.equals(jWSAlgorithm)) {
            return Collections.singleton(P_256);
        }
        if (JWSAlgorithm.ES256K.equals(jWSAlgorithm)) {
            return Collections.singleton(SECP256K1);
        }
        if (JWSAlgorithm.ES384.equals(jWSAlgorithm)) {
            return Collections.singleton(P_384);
        }
        if (JWSAlgorithm.ES512.equals(jWSAlgorithm)) {
            return Collections.singleton(P_521);
        }
        if (!JWSAlgorithm.EdDSA.equals(jWSAlgorithm)) {
            return null;
        }
        return Collections.unmodifiableSet(new HashSet(Arrays.asList(Ed25519, Ed448)));
    }

    public static Curve forECParameterSpec(ECParameterSpec eCParameterSpec) {
        return ECParameterTable.get(eCParameterSpec);
    }
}
