package org.bouncycastle.bcpg;

public interface BCPGKey {
    byte[] getEncoded();

    String getFormat();
}
