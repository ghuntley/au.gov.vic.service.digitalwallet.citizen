package net.openid.appauth;

/* access modifiers changed from: package-private */
public class SystemClock implements Clock {
    public static final SystemClock INSTANCE = new SystemClock();

    private SystemClock() {
    }

    @Override // net.openid.appauth.Clock
    public long getCurrentTimeMillis() {
        return System.currentTimeMillis();
    }
}
