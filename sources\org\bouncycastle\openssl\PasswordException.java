package org.bouncycastle.openssl;

import java.io.IOException;

public class PasswordException extends IOException {
    public PasswordException(String str) {
        super(str);
    }
}
