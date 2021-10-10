package com.nimbusds.jose;

import com.nimbusds.jose.util.ArrayUtils;
import java.util.Collection;
import net.jcip.annotations.Immutable;

@Immutable
public final class JWSAlgorithm extends Algorithm {
    public static final JWSAlgorithm ES256 = new JWSAlgorithm("ES256", Requirement.RECOMMENDED);
    public static final JWSAlgorithm ES256K = new JWSAlgorithm("ES256K", Requirement.OPTIONAL);
    public static final JWSAlgorithm ES384 = new JWSAlgorithm("ES384", Requirement.OPTIONAL);
    public static final JWSAlgorithm ES512 = new JWSAlgorithm("ES512", Requirement.OPTIONAL);
    public static final JWSAlgorithm EdDSA = new JWSAlgorithm("EdDSA", Requirement.OPTIONAL);
    public static final JWSAlgorithm HS256 = new JWSAlgorithm("HS256", Requirement.REQUIRED);
    public static final JWSAlgorithm HS384 = new JWSAlgorithm("HS384", Requirement.OPTIONAL);
    public static final JWSAlgorithm HS512 = new JWSAlgorithm("HS512", Requirement.OPTIONAL);
    public static final JWSAlgorithm PS256 = new JWSAlgorithm("PS256", Requirement.OPTIONAL);
    public static final JWSAlgorithm PS384 = new JWSAlgorithm("PS384", Requirement.OPTIONAL);
    public static final JWSAlgorithm PS512 = new JWSAlgorithm("PS512", Requirement.OPTIONAL);
    public static final JWSAlgorithm RS256 = new JWSAlgorithm("RS256", Requirement.RECOMMENDED);
    public static final JWSAlgorithm RS384 = new JWSAlgorithm("RS384", Requirement.OPTIONAL);
    public static final JWSAlgorithm RS512 = new JWSAlgorithm("RS512", Requirement.OPTIONAL);
    private static final long serialVersionUID = 1;

    public static final class Family extends AlgorithmFamily<JWSAlgorithm> {
        public static final Family EC;
        public static final Family ED;
        public static final Family HMAC_SHA = new Family(JWSAlgorithm.HS256, JWSAlgorithm.HS384, JWSAlgorithm.HS512);
        public static final Family RSA;
        public static final Family SIGNATURE;
        private static final long serialVersionUID = 1;

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.util.Collection] */
        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set, com.nimbusds.jose.AlgorithmFamily
        public /* bridge */ /* synthetic */ boolean addAll(Collection<? extends JWSAlgorithm> collection) {
            return super.addAll(collection);
        }

        @Override // com.nimbusds.jose.AlgorithmFamily
        public /* bridge */ /* synthetic */ boolean remove(Object obj) {
            return super.remove(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.AbstractSet, java.util.Set, com.nimbusds.jose.AlgorithmFamily
        public /* bridge */ /* synthetic */ boolean removeAll(Collection collection) {
            return super.removeAll(collection);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set, com.nimbusds.jose.AlgorithmFamily
        public /* bridge */ /* synthetic */ boolean retainAll(Collection collection) {
            return super.retainAll(collection);
        }

        static {
            Family family = new Family(JWSAlgorithm.RS256, JWSAlgorithm.RS384, JWSAlgorithm.RS512, JWSAlgorithm.PS256, JWSAlgorithm.PS384, JWSAlgorithm.PS512);
            RSA = family;
            Family family2 = new Family(JWSAlgorithm.ES256, JWSAlgorithm.ES256K, JWSAlgorithm.ES384, JWSAlgorithm.ES512);
            EC = family2;
            Family family3 = new Family(JWSAlgorithm.EdDSA);
            ED = family3;
            SIGNATURE = new Family((JWSAlgorithm[]) ArrayUtils.concat(family.toArray(new JWSAlgorithm[0]), (JWSAlgorithm[]) family2.toArray(new JWSAlgorithm[0]), (JWSAlgorithm[]) family3.toArray(new JWSAlgorithm[0])));
        }

        public Family(JWSAlgorithm... jWSAlgorithmArr) {
            super(jWSAlgorithmArr);
        }
    }

    public JWSAlgorithm(String str, Requirement requirement) {
        super(str, requirement);
    }

    public JWSAlgorithm(String str) {
        super(str, null);
    }

    public static JWSAlgorithm parse(String str) {
        JWSAlgorithm jWSAlgorithm = HS256;
        if (str.equals(jWSAlgorithm.getName())) {
            return jWSAlgorithm;
        }
        JWSAlgorithm jWSAlgorithm2 = HS384;
        if (str.equals(jWSAlgorithm2.getName())) {
            return jWSAlgorithm2;
        }
        JWSAlgorithm jWSAlgorithm3 = HS512;
        if (str.equals(jWSAlgorithm3.getName())) {
            return jWSAlgorithm3;
        }
        JWSAlgorithm jWSAlgorithm4 = RS256;
        if (str.equals(jWSAlgorithm4.getName())) {
            return jWSAlgorithm4;
        }
        JWSAlgorithm jWSAlgorithm5 = RS384;
        if (str.equals(jWSAlgorithm5.getName())) {
            return jWSAlgorithm5;
        }
        JWSAlgorithm jWSAlgorithm6 = RS512;
        if (str.equals(jWSAlgorithm6.getName())) {
            return jWSAlgorithm6;
        }
        JWSAlgorithm jWSAlgorithm7 = ES256;
        if (str.equals(jWSAlgorithm7.getName())) {
            return jWSAlgorithm7;
        }
        JWSAlgorithm jWSAlgorithm8 = ES256K;
        if (str.equals(jWSAlgorithm8.getName())) {
            return jWSAlgorithm8;
        }
        JWSAlgorithm jWSAlgorithm9 = ES384;
        if (str.equals(jWSAlgorithm9.getName())) {
            return jWSAlgorithm9;
        }
        JWSAlgorithm jWSAlgorithm10 = ES512;
        if (str.equals(jWSAlgorithm10.getName())) {
            return jWSAlgorithm10;
        }
        JWSAlgorithm jWSAlgorithm11 = PS256;
        if (str.equals(jWSAlgorithm11.getName())) {
            return jWSAlgorithm11;
        }
        JWSAlgorithm jWSAlgorithm12 = PS384;
        if (str.equals(jWSAlgorithm12.getName())) {
            return jWSAlgorithm12;
        }
        JWSAlgorithm jWSAlgorithm13 = PS512;
        if (str.equals(jWSAlgorithm13.getName())) {
            return jWSAlgorithm13;
        }
        JWSAlgorithm jWSAlgorithm14 = EdDSA;
        if (str.equals(jWSAlgorithm14.getName())) {
            return jWSAlgorithm14;
        }
        return new JWSAlgorithm(str);
    }
}
