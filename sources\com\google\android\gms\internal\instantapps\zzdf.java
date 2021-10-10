package com.google.android.gms.internal.instantapps;

import java.io.IOException;

public class zzdf extends IOException {
    private zzef zzapz = null;

    public zzdf(String str) {
        super(str);
    }

    static zzdf zzcf() {
        return new zzdf("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }

    static zzdf zzcg() {
        return new zzdf("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }

    static zzdf zzch() {
        return new zzdf("CodedInputStream encountered a malformed varint.");
    }

    static zzdf zzci() {
        return new zzdf("Protocol message contained an invalid tag (zero).");
    }

    static zzdf zzcj() {
        return new zzdf("Protocol message end-group tag did not match expected tag.");
    }

    static zzde zzck() {
        return new zzde("Protocol message tag had invalid wire type.");
    }

    static zzdf zzcl() {
        return new zzdf("Failed to parse the message.");
    }

    static zzdf zzcm() {
        return new zzdf("Protocol message had invalid UTF-8.");
    }
}
