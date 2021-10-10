package com.google.android.datatransport.runtime;

import com.google.android.datatransport.Encoding;
import java.util.Arrays;
import java.util.Objects;

public final class EncodedPayload {
    private final byte[] bytes;
    private final Encoding encoding;

    public EncodedPayload(Encoding encoding2, byte[] bArr) {
        Objects.requireNonNull(encoding2, "encoding is null");
        Objects.requireNonNull(bArr, "bytes is null");
        this.encoding = encoding2;
        this.bytes = bArr;
    }

    public Encoding getEncoding() {
        return this.encoding;
    }

    public byte[] getBytes() {
        return this.bytes;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof EncodedPayload)) {
            return false;
        }
        EncodedPayload encodedPayload = (EncodedPayload) obj;
        if (!this.encoding.equals(encodedPayload.encoding)) {
            return false;
        }
        return Arrays.equals(this.bytes, encodedPayload.bytes);
    }

    public int hashCode() {
        return ((this.encoding.hashCode() ^ 1000003) * 1000003) ^ Arrays.hashCode(this.bytes);
    }

    public String toString() {
        return "EncodedPayload{encoding=" + this.encoding + ", bytes=[...]}";
    }
}
