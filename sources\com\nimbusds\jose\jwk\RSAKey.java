package com.nimbusds.jose.jwk;

import com.nimbusds.jose.Algorithm;
import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.util.Base64;
import com.nimbusds.jose.util.Base64URL;
import com.nimbusds.jose.util.ByteUtils;
import com.nimbusds.jose.util.IntegerOverflowException;
import com.nimbusds.jose.util.JSONObjectUtils;
import java.io.Serializable;
import java.math.BigInteger;
import java.net.URI;
import java.security.Key;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.UnrecoverableKeyException;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.security.cert.X509Certificate;
import java.security.interfaces.RSAMultiPrimePrivateCrtKey;
import java.security.interfaces.RSAPrivateCrtKey;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.security.spec.RSAMultiPrimePrivateCrtKeySpec;
import java.security.spec.RSAOtherPrimeInfo;
import java.security.spec.RSAPrivateCrtKeySpec;
import java.security.spec.RSAPrivateKeySpec;
import java.security.spec.RSAPublicKeySpec;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import net.jcip.annotations.Immutable;
import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;

@Immutable
public final class RSAKey extends JWK implements AsymmetricJWK {
    private static final long serialVersionUID = 1;
    private final Base64URL d;
    private final Base64URL dp;
    private final Base64URL dq;
    private final Base64URL e;
    private final Base64URL n;
    private final List<OtherPrimesInfo> oth;
    private final Base64URL p;
    private final PrivateKey privateKey;
    private final Base64URL q;
    private final Base64URL qi;

    @Immutable
    public static class OtherPrimesInfo implements Serializable {
        private static final long serialVersionUID = 1;
        private final Base64URL d;
        private final Base64URL r;
        private final Base64URL t;

        public OtherPrimesInfo(Base64URL base64URL, Base64URL base64URL2, Base64URL base64URL3) {
            if (base64URL != null) {
                this.r = base64URL;
                if (base64URL2 != null) {
                    this.d = base64URL2;
                    if (base64URL3 != null) {
                        this.t = base64URL3;
                        return;
                    }
                    throw new IllegalArgumentException("The factor CRT coefficient must not be null");
                }
                throw new IllegalArgumentException("The factor CRT exponent must not be null");
            }
            throw new IllegalArgumentException("The prime factor must not be null");
        }

        public OtherPrimesInfo(RSAOtherPrimeInfo rSAOtherPrimeInfo) {
            this.r = Base64URL.encode(rSAOtherPrimeInfo.getPrime());
            this.d = Base64URL.encode(rSAOtherPrimeInfo.getExponent());
            this.t = Base64URL.encode(rSAOtherPrimeInfo.getCrtCoefficient());
        }

        public Base64URL getPrimeFactor() {
            return this.r;
        }

        public Base64URL getFactorCRTExponent() {
            return this.d;
        }

        public Base64URL getFactorCRTCoefficient() {
            return this.t;
        }

        public static List<OtherPrimesInfo> toList(RSAOtherPrimeInfo[] rSAOtherPrimeInfoArr) {
            ArrayList arrayList = new ArrayList();
            if (rSAOtherPrimeInfoArr == null) {
                return arrayList;
            }
            for (RSAOtherPrimeInfo rSAOtherPrimeInfo : rSAOtherPrimeInfoArr) {
                arrayList.add(new OtherPrimesInfo(rSAOtherPrimeInfo));
            }
            return arrayList;
        }
    }

    public static class Builder {
        private Algorithm alg;
        private Base64URL d;
        private Base64URL dp;
        private Base64URL dq;
        private final Base64URL e;
        private String kid;
        private KeyStore ks;
        private final Base64URL n;
        private Set<KeyOperation> ops;
        private List<OtherPrimesInfo> oth;
        private Base64URL p;
        private PrivateKey priv;
        private Base64URL q;
        private Base64URL qi;
        private KeyUse use;
        private List<Base64> x5c;
        @Deprecated
        private Base64URL x5t;
        private Base64URL x5t256;
        private URI x5u;

        public Builder(Base64URL base64URL, Base64URL base64URL2) {
            if (base64URL != null) {
                this.n = base64URL;
                if (base64URL2 != null) {
                    this.e = base64URL2;
                    return;
                }
                throw new IllegalArgumentException("The public exponent value must not be null");
            }
            throw new IllegalArgumentException("The modulus value must not be null");
        }

        public Builder(RSAPublicKey rSAPublicKey) {
            this.n = Base64URL.encode(rSAPublicKey.getModulus());
            this.e = Base64URL.encode(rSAPublicKey.getPublicExponent());
        }

        public Builder(RSAKey rSAKey) {
            this.n = rSAKey.n;
            this.e = rSAKey.e;
            this.d = rSAKey.d;
            this.p = rSAKey.p;
            this.q = rSAKey.q;
            this.dp = rSAKey.dp;
            this.dq = rSAKey.dq;
            this.qi = rSAKey.qi;
            this.oth = rSAKey.oth;
            this.priv = rSAKey.privateKey;
            this.use = rSAKey.getKeyUse();
            this.ops = rSAKey.getKeyOperations();
            this.alg = rSAKey.getAlgorithm();
            this.kid = rSAKey.getKeyID();
            this.x5u = rSAKey.getX509CertURL();
            this.x5t = rSAKey.getX509CertThumbprint();
            this.x5t256 = rSAKey.getX509CertSHA256Thumbprint();
            this.x5c = rSAKey.getX509CertChain();
            this.ks = rSAKey.getKeyStore();
        }

        public Builder privateExponent(Base64URL base64URL) {
            this.d = base64URL;
            return this;
        }

        public Builder privateKey(RSAPrivateKey rSAPrivateKey) {
            if (rSAPrivateKey instanceof RSAPrivateCrtKey) {
                return privateKey((RSAPrivateCrtKey) rSAPrivateKey);
            }
            if (rSAPrivateKey instanceof RSAMultiPrimePrivateCrtKey) {
                return privateKey((RSAMultiPrimePrivateCrtKey) rSAPrivateKey);
            }
            this.d = Base64URL.encode(rSAPrivateKey.getPrivateExponent());
            return this;
        }

        public Builder privateKey(PrivateKey privateKey) {
            if (privateKey instanceof RSAPrivateKey) {
                return privateKey((RSAPrivateKey) privateKey);
            }
            if ("RSA".equalsIgnoreCase(privateKey.getAlgorithm())) {
                this.priv = privateKey;
                return this;
            }
            throw new IllegalArgumentException("The private key algorithm must be RSA");
        }

        public Builder firstPrimeFactor(Base64URL base64URL) {
            this.p = base64URL;
            return this;
        }

        public Builder secondPrimeFactor(Base64URL base64URL) {
            this.q = base64URL;
            return this;
        }

        public Builder firstFactorCRTExponent(Base64URL base64URL) {
            this.dp = base64URL;
            return this;
        }

        public Builder secondFactorCRTExponent(Base64URL base64URL) {
            this.dq = base64URL;
            return this;
        }

        public Builder firstCRTCoefficient(Base64URL base64URL) {
            this.qi = base64URL;
            return this;
        }

        public Builder otherPrimes(List<OtherPrimesInfo> list) {
            this.oth = list;
            return this;
        }

        public Builder privateKey(RSAPrivateCrtKey rSAPrivateCrtKey) {
            this.d = Base64URL.encode(rSAPrivateCrtKey.getPrivateExponent());
            this.p = Base64URL.encode(rSAPrivateCrtKey.getPrimeP());
            this.q = Base64URL.encode(rSAPrivateCrtKey.getPrimeQ());
            this.dp = Base64URL.encode(rSAPrivateCrtKey.getPrimeExponentP());
            this.dq = Base64URL.encode(rSAPrivateCrtKey.getPrimeExponentQ());
            this.qi = Base64URL.encode(rSAPrivateCrtKey.getCrtCoefficient());
            return this;
        }

        public Builder privateKey(RSAMultiPrimePrivateCrtKey rSAMultiPrimePrivateCrtKey) {
            this.d = Base64URL.encode(rSAMultiPrimePrivateCrtKey.getPrivateExponent());
            this.p = Base64URL.encode(rSAMultiPrimePrivateCrtKey.getPrimeP());
            this.q = Base64URL.encode(rSAMultiPrimePrivateCrtKey.getPrimeQ());
            this.dp = Base64URL.encode(rSAMultiPrimePrivateCrtKey.getPrimeExponentP());
            this.dq = Base64URL.encode(rSAMultiPrimePrivateCrtKey.getPrimeExponentQ());
            this.qi = Base64URL.encode(rSAMultiPrimePrivateCrtKey.getCrtCoefficient());
            this.oth = OtherPrimesInfo.toList(rSAMultiPrimePrivateCrtKey.getOtherPrimeInfo());
            return this;
        }

        public Builder keyUse(KeyUse keyUse) {
            this.use = keyUse;
            return this;
        }

        public Builder keyOperations(Set<KeyOperation> set) {
            this.ops = set;
            return this;
        }

        public Builder algorithm(Algorithm algorithm) {
            this.alg = algorithm;
            return this;
        }

        public Builder keyID(String str) {
            this.kid = str;
            return this;
        }

        public Builder keyIDFromThumbprint() throws JOSEException {
            return keyIDFromThumbprint("SHA-256");
        }

        public Builder keyIDFromThumbprint(String str) throws JOSEException {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("e", this.e.toString());
            linkedHashMap.put("kty", KeyType.RSA.getValue());
            linkedHashMap.put("n", this.n.toString());
            this.kid = ThumbprintUtils.compute(str, linkedHashMap).toString();
            return this;
        }

        public Builder x509CertURL(URI uri) {
            this.x5u = uri;
            return this;
        }

        @Deprecated
        public Builder x509CertThumbprint(Base64URL base64URL) {
            this.x5t = base64URL;
            return this;
        }

        public Builder x509CertSHA256Thumbprint(Base64URL base64URL) {
            this.x5t256 = base64URL;
            return this;
        }

        public Builder x509CertChain(List<Base64> list) {
            this.x5c = list;
            return this;
        }

        public Builder keyStore(KeyStore keyStore) {
            this.ks = keyStore;
            return this;
        }

        public RSAKey build() {
            try {
                return new RSAKey(this.n, this.e, this.d, this.p, this.q, this.dp, this.dq, this.qi, this.oth, this.priv, this.use, this.ops, this.alg, this.kid, this.x5u, this.x5t, this.x5t256, this.x5c, this.ks);
            } catch (IllegalArgumentException e2) {
                throw new IllegalStateException(e2.getMessage(), e2);
            }
        }
    }

    public RSAKey(Base64URL base64URL, Base64URL base64URL2, KeyUse keyUse, Set<KeyOperation> set, Algorithm algorithm, String str, URI uri, Base64URL base64URL3, Base64URL base64URL4, List<Base64> list, KeyStore keyStore) {
        this(base64URL, base64URL2, null, null, null, null, null, null, null, null, keyUse, set, algorithm, str, uri, base64URL3, base64URL4, list, keyStore);
    }

    public RSAKey(Base64URL base64URL, Base64URL base64URL2, Base64URL base64URL3, KeyUse keyUse, Set<KeyOperation> set, Algorithm algorithm, String str, URI uri, Base64URL base64URL4, Base64URL base64URL5, List<Base64> list, KeyStore keyStore) {
        this(base64URL, base64URL2, base64URL3, null, null, null, null, null, null, null, keyUse, set, algorithm, str, uri, base64URL4, base64URL5, list, keyStore);
        if (base64URL3 == null) {
            throw new IllegalArgumentException("The private exponent must not be null");
        }
    }

    public RSAKey(Base64URL base64URL, Base64URL base64URL2, Base64URL base64URL3, Base64URL base64URL4, Base64URL base64URL5, Base64URL base64URL6, Base64URL base64URL7, List<OtherPrimesInfo> list, KeyUse keyUse, Set<KeyOperation> set, Algorithm algorithm, String str, URI uri, Base64URL base64URL8, Base64URL base64URL9, List<Base64> list2, KeyStore keyStore) {
        this(base64URL, base64URL2, null, base64URL3, base64URL4, base64URL5, base64URL6, base64URL7, list, null, keyUse, set, algorithm, str, uri, base64URL8, base64URL9, list2, keyStore);
        if (base64URL3 == null) {
            throw new IllegalArgumentException("The first prime factor must not be null");
        } else if (base64URL4 == null) {
            throw new IllegalArgumentException("The second prime factor must not be null");
        } else if (base64URL5 == null) {
            throw new IllegalArgumentException("The first factor CRT exponent must not be null");
        } else if (base64URL6 == null) {
            throw new IllegalArgumentException("The second factor CRT exponent must not be null");
        } else if (base64URL7 == null) {
            throw new IllegalArgumentException("The first CRT coefficient must not be null");
        }
    }

    @Deprecated
    public RSAKey(Base64URL base64URL, Base64URL base64URL2, Base64URL base64URL3, Base64URL base64URL4, Base64URL base64URL5, Base64URL base64URL6, Base64URL base64URL7, Base64URL base64URL8, List<OtherPrimesInfo> list, KeyUse keyUse, Set<KeyOperation> set, Algorithm algorithm, String str, URI uri, Base64URL base64URL9, Base64URL base64URL10, List<Base64> list2) {
        this(base64URL, base64URL2, base64URL3, base64URL4, base64URL5, base64URL6, base64URL7, base64URL8, list, null, keyUse, set, algorithm, str, uri, base64URL9, base64URL10, list2, null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x008a A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00a7 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00c6  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00ec  */
    public RSAKey(Base64URL base64URL, Base64URL base64URL2, Base64URL base64URL3, Base64URL base64URL4, Base64URL base64URL5, Base64URL base64URL6, Base64URL base64URL7, Base64URL base64URL8, List<OtherPrimesInfo> list, PrivateKey privateKey2, KeyUse keyUse, Set<KeyOperation> set, Algorithm algorithm, String str, URI uri, Base64URL base64URL9, Base64URL base64URL10, List<Base64> list2, KeyStore keyStore) {
        super(KeyType.RSA, keyUse, set, algorithm, str, uri, base64URL9, base64URL10, list2, keyStore);
        Base64URL base64URL11;
        Base64URL base64URL12;
        Base64URL base64URL13;
        if (base64URL != null) {
            this.n = base64URL;
            if (base64URL2 != null) {
                this.e = base64URL2;
                if (getParsedX509CertChain() == null || matches(getParsedX509CertChain().get(0))) {
                    this.d = base64URL3;
                    if (base64URL4 == null || base64URL5 == null) {
                        base64URL13 = base64URL6;
                        base64URL12 = base64URL7;
                        base64URL11 = base64URL8;
                        if (base64URL4 != null && base64URL5 == null && base64URL13 == null && base64URL12 == null && base64URL11 == null && list == null) {
                            this.p = null;
                            this.q = null;
                            this.dp = null;
                            this.dq = null;
                            this.qi = null;
                            this.oth = Collections.emptyList();
                        } else if (base64URL4 != null && base64URL5 == null && base64URL13 == null && base64URL12 == null && base64URL11 == null) {
                            this.p = null;
                            this.q = null;
                            this.dp = null;
                            this.dq = null;
                            this.qi = null;
                            this.oth = Collections.emptyList();
                        } else if (base64URL4 == null) {
                            throw new IllegalArgumentException("Incomplete second private (CRT) representation: The first prime factor must not be null");
                        } else if (base64URL5 == null) {
                            throw new IllegalArgumentException("Incomplete second private (CRT) representation: The second prime factor must not be null");
                        } else if (base64URL13 == null) {
                            throw new IllegalArgumentException("Incomplete second private (CRT) representation: The first factor CRT exponent must not be null");
                        } else if (base64URL12 == null) {
                            throw new IllegalArgumentException("Incomplete second private (CRT) representation: The second factor CRT exponent must not be null");
                        } else {
                            throw new IllegalArgumentException("Incomplete second private (CRT) representation: The first CRT coefficient must not be null");
                        }
                    } else {
                        base64URL13 = base64URL6;
                        base64URL12 = base64URL7;
                        if (base64URL13 != null) {
                            base64URL11 = base64URL8;
                            if (!(base64URL12 == null || base64URL11 == null)) {
                                this.p = base64URL4;
                                this.q = base64URL5;
                                this.dp = base64URL13;
                                this.dq = base64URL12;
                                this.qi = base64URL11;
                                if (list != null) {
                                    this.oth = Collections.unmodifiableList(list);
                                } else {
                                    this.oth = Collections.emptyList();
                                }
                            }
                            if (base64URL4 != null) {
                            }
                            if (base64URL4 != null) {
                            }
                            if (base64URL4 == null) {
                            }
                        }
                        base64URL11 = base64URL8;
                        if (base64URL4 != null) {
                        }
                        if (base64URL4 != null) {
                        }
                        if (base64URL4 == null) {
                        }
                    }
                    this.privateKey = privateKey2;
                    return;
                }
                throw new IllegalArgumentException("The public subject key info of the first X.509 certificate in the chain must match the JWK type and public parameters");
            }
            throw new IllegalArgumentException("The public exponent value must not be null");
        }
        throw new IllegalArgumentException("The modulus value must not be null");
    }

    public RSAKey(RSAPublicKey rSAPublicKey, KeyUse keyUse, Set<KeyOperation> set, Algorithm algorithm, String str, URI uri, Base64URL base64URL, Base64URL base64URL2, List<Base64> list, KeyStore keyStore) {
        this(Base64URL.encode(rSAPublicKey.getModulus()), Base64URL.encode(rSAPublicKey.getPublicExponent()), keyUse, set, algorithm, str, uri, base64URL, base64URL2, list, keyStore);
    }

    public RSAKey(RSAPublicKey rSAPublicKey, RSAPrivateKey rSAPrivateKey, KeyUse keyUse, Set<KeyOperation> set, Algorithm algorithm, String str, URI uri, Base64URL base64URL, Base64URL base64URL2, List<Base64> list, KeyStore keyStore) {
        this(Base64URL.encode(rSAPublicKey.getModulus()), Base64URL.encode(rSAPublicKey.getPublicExponent()), Base64URL.encode(rSAPrivateKey.getPrivateExponent()), keyUse, set, algorithm, str, uri, base64URL, base64URL2, list, keyStore);
    }

    public RSAKey(RSAPublicKey rSAPublicKey, RSAPrivateCrtKey rSAPrivateCrtKey, KeyUse keyUse, Set<KeyOperation> set, Algorithm algorithm, String str, URI uri, Base64URL base64URL, Base64URL base64URL2, List<Base64> list, KeyStore keyStore) {
        this(Base64URL.encode(rSAPublicKey.getModulus()), Base64URL.encode(rSAPublicKey.getPublicExponent()), Base64URL.encode(rSAPrivateCrtKey.getPrivateExponent()), Base64URL.encode(rSAPrivateCrtKey.getPrimeP()), Base64URL.encode(rSAPrivateCrtKey.getPrimeQ()), Base64URL.encode(rSAPrivateCrtKey.getPrimeExponentP()), Base64URL.encode(rSAPrivateCrtKey.getPrimeExponentQ()), Base64URL.encode(rSAPrivateCrtKey.getCrtCoefficient()), null, null, keyUse, set, algorithm, str, uri, base64URL, base64URL2, list, keyStore);
    }

    public RSAKey(RSAPublicKey rSAPublicKey, RSAMultiPrimePrivateCrtKey rSAMultiPrimePrivateCrtKey, KeyUse keyUse, Set<KeyOperation> set, Algorithm algorithm, String str, URI uri, Base64URL base64URL, Base64URL base64URL2, List<Base64> list, KeyStore keyStore) {
        this(Base64URL.encode(rSAPublicKey.getModulus()), Base64URL.encode(rSAPublicKey.getPublicExponent()), Base64URL.encode(rSAMultiPrimePrivateCrtKey.getPrivateExponent()), Base64URL.encode(rSAMultiPrimePrivateCrtKey.getPrimeP()), Base64URL.encode(rSAMultiPrimePrivateCrtKey.getPrimeQ()), Base64URL.encode(rSAMultiPrimePrivateCrtKey.getPrimeExponentP()), Base64URL.encode(rSAMultiPrimePrivateCrtKey.getPrimeExponentQ()), Base64URL.encode(rSAMultiPrimePrivateCrtKey.getCrtCoefficient()), OtherPrimesInfo.toList(rSAMultiPrimePrivateCrtKey.getOtherPrimeInfo()), null, keyUse, set, algorithm, str, uri, base64URL, base64URL2, list, keyStore);
    }

    public RSAKey(RSAPublicKey rSAPublicKey, PrivateKey privateKey2, KeyUse keyUse, Set<KeyOperation> set, Algorithm algorithm, String str, URI uri, Base64URL base64URL, Base64URL base64URL2, List<Base64> list, KeyStore keyStore) {
        this(Base64URL.encode(rSAPublicKey.getModulus()), Base64URL.encode(rSAPublicKey.getPublicExponent()), null, null, null, null, null, null, null, privateKey2, keyUse, set, algorithm, str, uri, base64URL, base64URL2, list, keyStore);
    }

    public Base64URL getModulus() {
        return this.n;
    }

    public Base64URL getPublicExponent() {
        return this.e;
    }

    public Base64URL getPrivateExponent() {
        return this.d;
    }

    public Base64URL getFirstPrimeFactor() {
        return this.p;
    }

    public Base64URL getSecondPrimeFactor() {
        return this.q;
    }

    public Base64URL getFirstFactorCRTExponent() {
        return this.dp;
    }

    public Base64URL getSecondFactorCRTExponent() {
        return this.dq;
    }

    public Base64URL getFirstCRTCoefficient() {
        return this.qi;
    }

    public List<OtherPrimesInfo> getOtherPrimes() {
        return this.oth;
    }

    public RSAPublicKey toRSAPublicKey() throws JOSEException {
        try {
            return (RSAPublicKey) KeyFactory.getInstance("RSA").generatePublic(new RSAPublicKeySpec(this.n.decodeToBigInteger(), this.e.decodeToBigInteger()));
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e2) {
            throw new JOSEException(e2.getMessage(), e2);
        }
    }

    public RSAPrivateKey toRSAPrivateKey() throws JOSEException {
        KeySpec keySpec;
        if (this.d == null) {
            return null;
        }
        BigInteger decodeToBigInteger = this.n.decodeToBigInteger();
        BigInteger decodeToBigInteger2 = this.d.decodeToBigInteger();
        if (this.p == null) {
            keySpec = new RSAPrivateKeySpec(decodeToBigInteger, decodeToBigInteger2);
        } else {
            BigInteger decodeToBigInteger3 = this.e.decodeToBigInteger();
            BigInteger decodeToBigInteger4 = this.p.decodeToBigInteger();
            BigInteger decodeToBigInteger5 = this.q.decodeToBigInteger();
            BigInteger decodeToBigInteger6 = this.dp.decodeToBigInteger();
            BigInteger decodeToBigInteger7 = this.dq.decodeToBigInteger();
            BigInteger decodeToBigInteger8 = this.qi.decodeToBigInteger();
            List<OtherPrimesInfo> list = this.oth;
            if (list == null || list.isEmpty()) {
                keySpec = new RSAPrivateCrtKeySpec(decodeToBigInteger, decodeToBigInteger3, decodeToBigInteger2, decodeToBigInteger4, decodeToBigInteger5, decodeToBigInteger6, decodeToBigInteger7, decodeToBigInteger8);
            } else {
                RSAOtherPrimeInfo[] rSAOtherPrimeInfoArr = new RSAOtherPrimeInfo[this.oth.size()];
                for (int i = 0; i < this.oth.size(); i++) {
                    OtherPrimesInfo otherPrimesInfo = this.oth.get(i);
                    rSAOtherPrimeInfoArr[i] = new RSAOtherPrimeInfo(otherPrimesInfo.getPrimeFactor().decodeToBigInteger(), otherPrimesInfo.getFactorCRTExponent().decodeToBigInteger(), otherPrimesInfo.getFactorCRTCoefficient().decodeToBigInteger());
                }
                keySpec = new RSAMultiPrimePrivateCrtKeySpec(decodeToBigInteger, decodeToBigInteger3, decodeToBigInteger2, decodeToBigInteger4, decodeToBigInteger5, decodeToBigInteger6, decodeToBigInteger7, decodeToBigInteger8, rSAOtherPrimeInfoArr);
            }
        }
        try {
            return (RSAPrivateKey) KeyFactory.getInstance("RSA").generatePrivate(keySpec);
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e2) {
            throw new JOSEException(e2.getMessage(), e2);
        }
    }

    @Override // com.nimbusds.jose.jwk.AsymmetricJWK
    public PublicKey toPublicKey() throws JOSEException {
        return toRSAPublicKey();
    }

    @Override // com.nimbusds.jose.jwk.AsymmetricJWK
    public PrivateKey toPrivateKey() throws JOSEException {
        RSAPrivateKey rSAPrivateKey = toRSAPrivateKey();
        if (rSAPrivateKey != null) {
            return rSAPrivateKey;
        }
        return this.privateKey;
    }

    @Override // com.nimbusds.jose.jwk.AsymmetricJWK
    public KeyPair toKeyPair() throws JOSEException {
        return new KeyPair(toRSAPublicKey(), toPrivateKey());
    }

    @Override // com.nimbusds.jose.jwk.AsymmetricJWK
    public boolean matches(X509Certificate x509Certificate) {
        try {
            RSAPublicKey rSAPublicKey = (RSAPublicKey) getParsedX509CertChain().get(0).getPublicKey();
            if (this.e.decodeToBigInteger().equals(rSAPublicKey.getPublicExponent()) && this.n.decodeToBigInteger().equals(rSAPublicKey.getModulus())) {
                return true;
            }
            return false;
        } catch (ClassCastException unused) {
            return false;
        }
    }

    @Override // com.nimbusds.jose.jwk.JWK
    public LinkedHashMap<String, ?> getRequiredParams() {
        LinkedHashMap<String, ?> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("e", this.e.toString());
        linkedHashMap.put("kty", getKeyType().getValue());
        linkedHashMap.put("n", this.n.toString());
        return linkedHashMap;
    }

    @Override // com.nimbusds.jose.jwk.JWK
    public boolean isPrivate() {
        return (this.d == null && this.p == null && this.privateKey == null) ? false : true;
    }

    @Override // com.nimbusds.jose.jwk.JWK
    public int size() {
        try {
            return ByteUtils.safeBitLength(this.n.decode());
        } catch (IntegerOverflowException e2) {
            throw new ArithmeticException(e2.getMessage());
        }
    }

    @Override // com.nimbusds.jose.jwk.JWK
    public RSAKey toPublicJWK() {
        return new RSAKey(getModulus(), getPublicExponent(), getKeyUse(), getKeyOperations(), getAlgorithm(), getKeyID(), getX509CertURL(), getX509CertThumbprint(), getX509CertSHA256Thumbprint(), getX509CertChain(), getKeyStore());
    }

    @Override // com.nimbusds.jose.jwk.JWK
    public JSONObject toJSONObject() {
        JSONObject jSONObject = super.toJSONObject();
        jSONObject.put("n", this.n.toString());
        jSONObject.put("e", this.e.toString());
        Base64URL base64URL = this.d;
        if (base64URL != null) {
            jSONObject.put("d", base64URL.toString());
        }
        Base64URL base64URL2 = this.p;
        if (base64URL2 != null) {
            jSONObject.put("p", base64URL2.toString());
        }
        Base64URL base64URL3 = this.q;
        if (base64URL3 != null) {
            jSONObject.put("q", base64URL3.toString());
        }
        Base64URL base64URL4 = this.dp;
        if (base64URL4 != null) {
            jSONObject.put("dp", base64URL4.toString());
        }
        Base64URL base64URL5 = this.dq;
        if (base64URL5 != null) {
            jSONObject.put("dq", base64URL5.toString());
        }
        Base64URL base64URL6 = this.qi;
        if (base64URL6 != null) {
            jSONObject.put("qi", base64URL6.toString());
        }
        List<OtherPrimesInfo> list = this.oth;
        if (list != null && !list.isEmpty()) {
            JSONArray jSONArray = new JSONArray();
            for (OtherPrimesInfo otherPrimesInfo : this.oth) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("r", otherPrimesInfo.r.toString());
                jSONObject2.put("d", otherPrimesInfo.d.toString());
                jSONObject2.put("t", otherPrimesInfo.t.toString());
                jSONArray.add(jSONObject2);
            }
            jSONObject.put("oth", jSONArray);
        }
        return jSONObject;
    }

    public static RSAKey parse(String str) throws ParseException {
        return parse(JSONObjectUtils.parse(str));
    }

    public static RSAKey parse(JSONObject jSONObject) throws ParseException {
        ArrayList arrayList;
        Base64URL base64URL = new Base64URL(JSONObjectUtils.getString(jSONObject, "n"));
        Base64URL base64URL2 = new Base64URL(JSONObjectUtils.getString(jSONObject, "e"));
        if (KeyType.parse(JSONObjectUtils.getString(jSONObject, "kty")) == KeyType.RSA) {
            Base64URL base64URL3 = jSONObject.containsKey("d") ? new Base64URL(JSONObjectUtils.getString(jSONObject, "d")) : null;
            Base64URL base64URL4 = jSONObject.containsKey("p") ? new Base64URL(JSONObjectUtils.getString(jSONObject, "p")) : null;
            Base64URL base64URL5 = jSONObject.containsKey("q") ? new Base64URL(JSONObjectUtils.getString(jSONObject, "q")) : null;
            Base64URL base64URL6 = jSONObject.containsKey("dp") ? new Base64URL(JSONObjectUtils.getString(jSONObject, "dp")) : null;
            Base64URL base64URL7 = jSONObject.containsKey("dq") ? new Base64URL(JSONObjectUtils.getString(jSONObject, "dq")) : null;
            Base64URL base64URL8 = jSONObject.containsKey("qi") ? new Base64URL(JSONObjectUtils.getString(jSONObject, "qi")) : null;
            if (jSONObject.containsKey("oth")) {
                JSONArray jSONArray = JSONObjectUtils.getJSONArray(jSONObject, "oth");
                arrayList = new ArrayList(jSONArray.size());
                Iterator it = jSONArray.iterator();
                while (it.hasNext()) {
                    Object next = it.next();
                    if (next instanceof JSONObject) {
                        JSONObject jSONObject2 = (JSONObject) next;
                        arrayList.add(new OtherPrimesInfo(new Base64URL(JSONObjectUtils.getString(jSONObject2, "r")), new Base64URL(JSONObjectUtils.getString(jSONObject2, "dq")), new Base64URL(JSONObjectUtils.getString(jSONObject2, "t"))));
                    }
                }
            } else {
                arrayList = null;
            }
            try {
                return new RSAKey(base64URL, base64URL2, base64URL3, base64URL4, base64URL5, base64URL6, base64URL7, base64URL8, arrayList, null, JWKMetadata.parseKeyUse(jSONObject), JWKMetadata.parseKeyOperations(jSONObject), JWKMetadata.parseAlgorithm(jSONObject), JWKMetadata.parseKeyID(jSONObject), JWKMetadata.parseX509CertURL(jSONObject), JWKMetadata.parseX509CertThumbprint(jSONObject), JWKMetadata.parseX509CertSHA256Thumbprint(jSONObject), JWKMetadata.parseX509CertChain(jSONObject), null);
            } catch (IllegalArgumentException e2) {
                throw new ParseException(e2.getMessage(), 0);
            }
        } else {
            throw new ParseException("The key type \"kty\" must be RSA", 0);
        }
    }

    public static RSAKey parse(X509Certificate x509Certificate) throws JOSEException {
        if (x509Certificate.getPublicKey() instanceof RSAPublicKey) {
            try {
                return new Builder((RSAPublicKey) x509Certificate.getPublicKey()).keyUse(KeyUse.from(x509Certificate)).keyID(x509Certificate.getSerialNumber().toString(10)).x509CertChain(Collections.singletonList(Base64.encode(x509Certificate.getEncoded()))).x509CertSHA256Thumbprint(Base64URL.encode(MessageDigest.getInstance("SHA-256").digest(x509Certificate.getEncoded()))).build();
            } catch (NoSuchAlgorithmException e2) {
                throw new JOSEException("Couldn't encode x5t parameter: " + e2.getMessage(), e2);
            } catch (CertificateEncodingException e3) {
                throw new JOSEException("Couldn't encode x5c parameter: " + e3.getMessage(), e3);
            }
        } else {
            throw new JOSEException("The public key of the X.509 certificate is not RSA");
        }
    }

    public static RSAKey load(KeyStore keyStore, String str, char[] cArr) throws KeyStoreException, JOSEException {
        Certificate certificate = keyStore.getCertificate(str);
        if (certificate == null || !(certificate instanceof X509Certificate)) {
            return null;
        }
        X509Certificate x509Certificate = (X509Certificate) certificate;
        if (x509Certificate.getPublicKey() instanceof RSAPublicKey) {
            RSAKey build = new Builder(parse(x509Certificate)).keyID(str).keyStore(keyStore).build();
            try {
                Key key = keyStore.getKey(str, cArr);
                if (key instanceof RSAPrivateKey) {
                    return new Builder(build).privateKey((RSAPrivateKey) key).build();
                }
                if (!(key instanceof PrivateKey) || !"RSA".equalsIgnoreCase(key.getAlgorithm())) {
                    return build;
                }
                return new Builder(build).privateKey((PrivateKey) key).build();
            } catch (NoSuchAlgorithmException | UnrecoverableKeyException e2) {
                throw new JOSEException("Couldn't retrieve private RSA key (bad pin?): " + e2.getMessage(), e2);
            }
        } else {
            throw new JOSEException("Couldn't load RSA JWK: The key algorithm is not RSA");
        }
    }

    @Override // com.nimbusds.jose.jwk.JWK
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RSAKey) || !super.equals(obj)) {
            return false;
        }
        RSAKey rSAKey = (RSAKey) obj;
        return Objects.equals(this.n, rSAKey.n) && Objects.equals(this.e, rSAKey.e) && Objects.equals(this.d, rSAKey.d) && Objects.equals(this.p, rSAKey.p) && Objects.equals(this.q, rSAKey.q) && Objects.equals(this.dp, rSAKey.dp) && Objects.equals(this.dq, rSAKey.dq) && Objects.equals(this.qi, rSAKey.qi) && Objects.equals(this.oth, rSAKey.oth) && Objects.equals(this.privateKey, rSAKey.privateKey);
    }

    @Override // com.nimbusds.jose.jwk.JWK
    public int hashCode() {
        return Objects.hash(Integer.valueOf(super.hashCode()), this.n, this.e, this.d, this.p, this.q, this.dp, this.dq, this.qi, this.oth, this.privateKey);
    }
}
