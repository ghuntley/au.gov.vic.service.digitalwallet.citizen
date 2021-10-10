package com.google.android.datatransport.cct.internal;

/* access modifiers changed from: package-private */
public final class AutoValue_LogResponse extends LogResponse {
    private final long nextRequestWaitMillis;

    AutoValue_LogResponse(long j) {
        this.nextRequestWaitMillis = j;
    }

    @Override // com.google.android.datatransport.cct.internal.LogResponse
    public long getNextRequestWaitMillis() {
        return this.nextRequestWaitMillis;
    }

    public String toString() {
        return "LogResponse{nextRequestWaitMillis=" + this.nextRequestWaitMillis + "}";
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof LogResponse) {
            return this.nextRequestWaitMillis == ((LogResponse) obj).getNextRequestWaitMillis();
        }
        return false;
    }

    public int hashCode() {
        long j = this.nextRequestWaitMillis;
        return ((int) (j ^ (j >>> 32))) ^ 1000003;
    }
}
