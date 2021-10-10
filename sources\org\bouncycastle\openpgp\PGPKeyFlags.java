package org.bouncycastle.openpgp;

public interface PGPKeyFlags {
    public static final int CAN_CERTIFY = 1;
    public static final int CAN_ENCRYPT_COMMS = 4;
    public static final int CAN_ENCRYPT_STORAGE = 8;
    public static final int CAN_SIGN = 2;
    public static final int MAYBE_SHARED = 128;
    public static final int MAYBE_SPLIT = 16;
}
