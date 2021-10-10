package org.bouncycastle.bcpg;

public interface PacketTags {
    public static final int COMPRESSED_DATA = 8;
    public static final int EXPERIMENTAL_1 = 60;
    public static final int EXPERIMENTAL_2 = 61;
    public static final int EXPERIMENTAL_3 = 62;
    public static final int EXPERIMENTAL_4 = 63;
    public static final int LITERAL_DATA = 11;
    public static final int MARKER = 10;
    public static final int MOD_DETECTION_CODE = 19;
    public static final int ONE_PASS_SIGNATURE = 4;
    public static final int PUBLIC_KEY = 6;
    public static final int PUBLIC_KEY_ENC_SESSION = 1;
    public static final int PUBLIC_SUBKEY = 14;
    public static final int RESERVED = 0;
    public static final int SECRET_KEY = 5;
    public static final int SECRET_SUBKEY = 7;
    public static final int SIGNATURE = 2;
    public static final int SYMMETRIC_KEY_ENC = 9;
    public static final int SYMMETRIC_KEY_ENC_SESSION = 3;
    public static final int SYM_ENC_INTEGRITY_PRO = 18;
    public static final int TRUST = 12;
    public static final int USER_ATTRIBUTE = 17;
    public static final int USER_ID = 13;
}
