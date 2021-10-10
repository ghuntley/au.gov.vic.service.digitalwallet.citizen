package com.google.android.gms.internal.gtm;

import java.io.IOException;

public class zzrk extends IOException {
    private zzsk zzbbk = null;

    public zzrk(String str) {
        super(str);
    }

    public final zzrk zzg(zzsk zzsk) {
        this.zzbbk = zzsk;
        return this;
    }

    static zzrk zzpp() {
        return new zzrk("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }

    static zzrk zzpq() {
        return new zzrk("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }

    static zzrk zzpr() {
        return new zzrk("CodedInputStream encountered a malformed varint.");
    }

    static zzrk zzps() {
        return new zzrk("Protocol message end-group tag did not match expected tag.");
    }

    static zzrl zzpt() {
        return new zzrl("Protocol message tag had invalid wire type.");
    }

    static zzrk zzpu() {
        return new zzrk("Protocol message had too many levels of nesting.  May be malicious.  Use CodedInputStream.setRecursionLimit() to increase the depth limit.");
    }

    static zzrk zzpv() {
        return new zzrk("Failed to parse the message.");
    }

    static zzrk zzpw() {
        return new zzrk("Protocol message had invalid UTF-8.");
    }
}
