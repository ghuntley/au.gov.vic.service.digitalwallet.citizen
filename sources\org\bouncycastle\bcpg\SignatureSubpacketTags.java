package org.bouncycastle.bcpg;

public interface SignatureSubpacketTags {
    public static final int CREATION_TIME = 2;
    public static final int EMBEDDED_SIGNATURE = 32;
    public static final int EXPIRE_TIME = 3;
    public static final int EXPORTABLE = 4;
    public static final int FEATURES = 30;
    public static final int ISSUER_KEY_ID = 16;
    public static final int KEY_EXPIRE_TIME = 9;
    public static final int KEY_FLAGS = 27;
    public static final int KEY_SERVER_PREFS = 23;
    public static final int NOTATION_DATA = 20;
    public static final int PLACEHOLDER = 10;
    public static final int POLICY_URL = 26;
    public static final int PREFERRED_COMP_ALGS = 22;
    public static final int PREFERRED_HASH_ALGS = 21;
    public static final int PREFERRED_KEY_SERV = 24;
    public static final int PREFERRED_SYM_ALGS = 11;
    public static final int PRIMARY_USER_ID = 25;
    public static final int REG_EXP = 6;
    public static final int REVOCABLE = 7;
    public static final int REVOCATION_KEY = 12;
    public static final int REVOCATION_REASON = 29;
    public static final int SIGNATURE_TARGET = 31;
    public static final int SIGNER_USER_ID = 28;
    public static final int TRUST_SIG = 5;
}
