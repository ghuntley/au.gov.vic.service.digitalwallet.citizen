package com.nimbusds.jose.jwk;

import com.nimbusds.jose.Algorithm;
import com.nimbusds.jose.JWEHeader;
import com.nimbusds.jose.JWSAlgorithm;
import com.nimbusds.jose.JWSHeader;
import com.nimbusds.jose.util.Base64URL;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import net.jcip.annotations.Immutable;
import org.objectweb.asm.signature.SignatureVisitor;

@Immutable
public class JWKMatcher {
    private final Set<Algorithm> algs;
    private final Set<Curve> curves;
    private final boolean hasID;
    private final boolean hasUse;
    private final Set<String> ids;
    private final int maxSizeBits;
    private final int minSizeBits;
    private final Set<KeyOperation> ops;
    private final boolean privateOnly;
    private final boolean publicOnly;
    private final Set<Integer> sizesBits;
    private final Set<KeyType> types;
    private final Set<KeyUse> uses;
    private final Set<Base64URL> x5tS256s;

    public static class Builder {
        private Set<Algorithm> algs;
        private Set<Curve> curves;
        private boolean hasID = false;
        private boolean hasUse = false;
        private Set<String> ids;
        private int maxSizeBits = 0;
        private int minSizeBits = 0;
        private Set<KeyOperation> ops;
        private boolean privateOnly = false;
        private boolean publicOnly = false;
        private Set<Integer> sizesBits;
        private Set<KeyType> types;
        private Set<KeyUse> uses;
        private Set<Base64URL> x5tS256s;

        public Builder keyType(KeyType keyType) {
            if (keyType == null) {
                this.types = null;
            } else {
                this.types = new HashSet(Collections.singletonList(keyType));
            }
            return this;
        }

        public Builder keyTypes(KeyType... keyTypeArr) {
            keyTypes(new LinkedHashSet(Arrays.asList(keyTypeArr)));
            return this;
        }

        public Builder keyTypes(Set<KeyType> set) {
            this.types = set;
            return this;
        }

        public Builder keyUse(KeyUse keyUse) {
            if (keyUse == null) {
                this.uses = null;
            } else {
                this.uses = new HashSet(Collections.singletonList(keyUse));
            }
            return this;
        }

        public Builder keyUses(KeyUse... keyUseArr) {
            keyUses(new LinkedHashSet(Arrays.asList(keyUseArr)));
            return this;
        }

        public Builder keyUses(Set<KeyUse> set) {
            this.uses = set;
            return this;
        }

        public Builder keyOperation(KeyOperation keyOperation) {
            if (keyOperation == null) {
                this.ops = null;
            } else {
                this.ops = new HashSet(Collections.singletonList(keyOperation));
            }
            return this;
        }

        public Builder keyOperations(KeyOperation... keyOperationArr) {
            keyOperations(new LinkedHashSet(Arrays.asList(keyOperationArr)));
            return this;
        }

        public Builder keyOperations(Set<KeyOperation> set) {
            this.ops = set;
            return this;
        }

        public Builder algorithm(Algorithm algorithm) {
            if (algorithm == null) {
                this.algs = null;
            } else {
                this.algs = new HashSet(Collections.singletonList(algorithm));
            }
            return this;
        }

        public Builder algorithms(Algorithm... algorithmArr) {
            algorithms(new LinkedHashSet(Arrays.asList(algorithmArr)));
            return this;
        }

        public Builder algorithms(Set<Algorithm> set) {
            this.algs = set;
            return this;
        }

        public Builder keyID(String str) {
            if (str == null) {
                this.ids = null;
            } else {
                this.ids = new HashSet(Collections.singletonList(str));
            }
            return this;
        }

        public Builder keyIDs(String... strArr) {
            keyIDs(new LinkedHashSet(Arrays.asList(strArr)));
            return this;
        }

        public Builder keyIDs(Set<String> set) {
            this.ids = set;
            return this;
        }

        public Builder hasKeyUse(boolean z) {
            this.hasUse = z;
            return this;
        }

        public Builder hasKeyID(boolean z) {
            this.hasID = z;
            return this;
        }

        public Builder privateOnly(boolean z) {
            this.privateOnly = z;
            return this;
        }

        public Builder publicOnly(boolean z) {
            this.publicOnly = z;
            return this;
        }

        public Builder minKeySize(int i) {
            this.minSizeBits = i;
            return this;
        }

        public Builder maxKeySize(int i) {
            this.maxSizeBits = i;
            return this;
        }

        public Builder keySize(int i) {
            if (i <= 0) {
                this.sizesBits = null;
            } else {
                this.sizesBits = Collections.singleton(Integer.valueOf(i));
            }
            return this;
        }

        public Builder keySizes(int... iArr) {
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            for (int i : iArr) {
                linkedHashSet.add(Integer.valueOf(i));
            }
            keySizes(linkedHashSet);
            return this;
        }

        public Builder keySizes(Set<Integer> set) {
            this.sizesBits = set;
            return this;
        }

        public Builder curve(Curve curve) {
            if (curve == null) {
                this.curves = null;
            } else {
                this.curves = new HashSet(Collections.singletonList(curve));
            }
            return this;
        }

        public Builder curves(Curve... curveArr) {
            curves(new LinkedHashSet(Arrays.asList(curveArr)));
            return this;
        }

        public Builder curves(Set<Curve> set) {
            this.curves = set;
            return this;
        }

        public Builder x509CertSHA256Thumbprint(Base64URL base64URL) {
            if (base64URL == null) {
                this.x5tS256s = null;
            } else {
                this.x5tS256s = Collections.singleton(base64URL);
            }
            return this;
        }

        public Builder x509CertSHA256Thumbprints(Base64URL... base64URLArr) {
            return x509CertSHA256Thumbprints(new LinkedHashSet(Arrays.asList(base64URLArr)));
        }

        public Builder x509CertSHA256Thumbprints(Set<Base64URL> set) {
            this.x5tS256s = set;
            return this;
        }

        public JWKMatcher build() {
            return new JWKMatcher(this.types, this.uses, this.ops, this.algs, this.ids, this.hasUse, this.hasID, this.privateOnly, this.publicOnly, this.minSizeBits, this.maxSizeBits, this.sizesBits, this.curves, this.x5tS256s);
        }
    }

    @Deprecated
    public JWKMatcher(Set<KeyType> set, Set<KeyUse> set2, Set<KeyOperation> set3, Set<Algorithm> set4, Set<String> set5, boolean z, boolean z2) {
        this(set, set2, set3, set4, set5, z, z2, 0, 0);
    }

    @Deprecated
    public JWKMatcher(Set<KeyType> set, Set<KeyUse> set2, Set<KeyOperation> set3, Set<Algorithm> set4, Set<String> set5, boolean z, boolean z2, int i, int i2) {
        this(set, set2, set3, set4, set5, z, z2, i, i2, null);
    }

    @Deprecated
    public JWKMatcher(Set<KeyType> set, Set<KeyUse> set2, Set<KeyOperation> set3, Set<Algorithm> set4, Set<String> set5, boolean z, boolean z2, int i, int i2, Set<Curve> set6) {
        this(set, set2, set3, set4, set5, z, z2, i, i2, null, set6);
    }

    @Deprecated
    public JWKMatcher(Set<KeyType> set, Set<KeyUse> set2, Set<KeyOperation> set3, Set<Algorithm> set4, Set<String> set5, boolean z, boolean z2, int i, int i2, Set<Integer> set6, Set<Curve> set7) {
        this(set, set2, set3, set4, set5, false, false, z, z2, i, i2, set6, set7);
    }

    @Deprecated
    public JWKMatcher(Set<KeyType> set, Set<KeyUse> set2, Set<KeyOperation> set3, Set<Algorithm> set4, Set<String> set5, boolean z, boolean z2, boolean z3, boolean z4, int i, int i2, Set<Integer> set6, Set<Curve> set7) {
        this(set, set2, set3, set4, set5, z, z2, z3, z4, i, i2, set6, set7, null);
    }

    public JWKMatcher(Set<KeyType> set, Set<KeyUse> set2, Set<KeyOperation> set3, Set<Algorithm> set4, Set<String> set5, boolean z, boolean z2, boolean z3, boolean z4, int i, int i2, Set<Integer> set6, Set<Curve> set7, Set<Base64URL> set8) {
        this.types = set;
        this.uses = set2;
        this.ops = set3;
        this.algs = set4;
        this.ids = set5;
        this.hasUse = z;
        this.hasID = z2;
        this.privateOnly = z3;
        this.publicOnly = z4;
        this.minSizeBits = i;
        this.maxSizeBits = i2;
        this.sizesBits = set6;
        this.curves = set7;
        this.x5tS256s = set8;
    }

    public static JWKMatcher forJWEHeader(JWEHeader jWEHeader) {
        return new Builder().keyType(KeyType.forAlgorithm(jWEHeader.getAlgorithm())).keyID(jWEHeader.getKeyID()).keyUses(KeyUse.ENCRYPTION, null).algorithms(jWEHeader.getAlgorithm(), null).build();
    }

    public static JWKMatcher forJWSHeader(JWSHeader jWSHeader) {
        JWSAlgorithm algorithm = jWSHeader.getAlgorithm();
        if (JWSAlgorithm.Family.RSA.contains(algorithm) || JWSAlgorithm.Family.EC.contains(algorithm)) {
            return new Builder().keyType(KeyType.forAlgorithm(algorithm)).keyID(jWSHeader.getKeyID()).keyUses(KeyUse.SIGNATURE, null).algorithms(algorithm, null).x509CertSHA256Thumbprint(jWSHeader.getX509CertSHA256Thumbprint()).build();
        } else if (!JWSAlgorithm.Family.HMAC_SHA.contains(algorithm)) {
            return null;
        } else {
            return new Builder().keyType(KeyType.forAlgorithm(algorithm)).keyID(jWSHeader.getKeyID()).privateOnly(true).algorithms(algorithm, null).build();
        }
    }

    public Set<KeyType> getKeyTypes() {
        return this.types;
    }

    public Set<KeyUse> getKeyUses() {
        return this.uses;
    }

    public Set<KeyOperation> getKeyOperations() {
        return this.ops;
    }

    public Set<Algorithm> getAlgorithms() {
        return this.algs;
    }

    public Set<String> getKeyIDs() {
        return this.ids;
    }

    public boolean hasKeyUse() {
        return this.hasUse;
    }

    public boolean hasKeyID() {
        return this.hasID;
    }

    public boolean isPrivateOnly() {
        return this.privateOnly;
    }

    public boolean isPublicOnly() {
        return this.publicOnly;
    }

    @Deprecated
    public int getMinSize() {
        return getMinKeySize();
    }

    public int getMinKeySize() {
        return this.minSizeBits;
    }

    @Deprecated
    public int getMaxSize() {
        return getMaxKeySize();
    }

    public int getMaxKeySize() {
        return this.maxSizeBits;
    }

    public Set<Integer> getKeySizes() {
        return this.sizesBits;
    }

    public Set<Curve> getCurves() {
        return this.curves;
    }

    public Set<Base64URL> getX509CertSHA256Thumbprints() {
        return this.x5tS256s;
    }

    public boolean matches(JWK jwk) {
        if (this.hasUse && jwk.getKeyUse() == null) {
            return false;
        }
        if (this.hasID && (jwk.getKeyID() == null || jwk.getKeyID().trim().isEmpty())) {
            return false;
        }
        if (this.privateOnly && !jwk.isPrivate()) {
            return false;
        }
        if (this.publicOnly && jwk.isPrivate()) {
            return false;
        }
        Set<KeyType> set = this.types;
        if (set != null && !set.contains(jwk.getKeyType())) {
            return false;
        }
        Set<KeyUse> set2 = this.uses;
        if (set2 != null && !set2.contains(jwk.getKeyUse())) {
            return false;
        }
        Set<KeyOperation> set3 = this.ops;
        if (set3 != null && ((!set3.contains(null) || jwk.getKeyOperations() != null) && (jwk.getKeyOperations() == null || !this.ops.containsAll(jwk.getKeyOperations())))) {
            return false;
        }
        Set<Algorithm> set4 = this.algs;
        if (set4 != null && !set4.contains(jwk.getAlgorithm())) {
            return false;
        }
        Set<String> set5 = this.ids;
        if (set5 != null && !set5.contains(jwk.getKeyID())) {
            return false;
        }
        if (this.minSizeBits > 0 && jwk.size() < this.minSizeBits) {
            return false;
        }
        if (this.maxSizeBits > 0 && jwk.size() > this.maxSizeBits) {
            return false;
        }
        Set<Integer> set6 = this.sizesBits;
        if (set6 != null && !set6.contains(Integer.valueOf(jwk.size()))) {
            return false;
        }
        Set<Curve> set7 = this.curves;
        if (set7 != null && (!(jwk instanceof CurveBasedJWK) || !set7.contains(((CurveBasedJWK) jwk).getCurve()))) {
            return false;
        }
        Set<Base64URL> set8 = this.x5tS256s;
        if (set8 == null || set8.contains(jwk.getX509CertSHA256Thumbprint())) {
            return true;
        }
        return false;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        append(sb, "kty", this.types);
        append(sb, "use", this.uses);
        append(sb, "key_ops", this.ops);
        append(sb, "alg", this.algs);
        append(sb, "kid", this.ids);
        if (this.hasUse) {
            sb.append("has_use=true ");
        }
        if (this.hasID) {
            sb.append("has_id=true ");
        }
        if (this.privateOnly) {
            sb.append("private_only=true ");
        }
        if (this.publicOnly) {
            sb.append("public_only=true ");
        }
        if (this.minSizeBits > 0) {
            sb.append("min_size=" + this.minSizeBits + " ");
        }
        if (this.maxSizeBits > 0) {
            sb.append("max_size=" + this.maxSizeBits + " ");
        }
        append(sb, "size", this.sizesBits);
        append(sb, "crv", this.curves);
        append(sb, "x5t#S256", this.x5tS256s);
        return sb.toString().trim();
    }

    private static void append(StringBuilder sb, String str, Set<?> set) {
        if (set != null) {
            sb.append(str);
            sb.append(SignatureVisitor.INSTANCEOF);
            if (set.size() == 1) {
                Object next = set.iterator().next();
                if (next == null) {
                    sb.append("ANY");
                } else {
                    sb.append(next.toString().trim());
                }
            } else {
                sb.append(set.toString().trim());
            }
            sb.append(' ');
        }
    }
}
