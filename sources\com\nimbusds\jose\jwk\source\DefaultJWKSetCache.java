package com.nimbusds.jose.jwk.source;

import com.nimbusds.jose.jwk.JWKSet;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class DefaultJWKSetCache implements JWKSetCache {
    public static final long DEFAULT_LIFESPAN_MINUTES = 5;
    private JWKSet jwkSet;
    private final long lifespan;
    private long putTimestamp;
    private final TimeUnit timeUnit;

    public DefaultJWKSetCache() {
        this(5, TimeUnit.MINUTES);
    }

    public DefaultJWKSetCache(long j, TimeUnit timeUnit2) {
        this.putTimestamp = -1;
        this.lifespan = j;
        if (j <= -1 || timeUnit2 != null) {
            this.timeUnit = timeUnit2;
            return;
        }
        throw new IllegalArgumentException("A time unit must be specified for non-negative lifespans");
    }

    @Override // com.nimbusds.jose.jwk.source.JWKSetCache
    public void put(JWKSet jWKSet) {
        this.jwkSet = jWKSet;
        if (jWKSet != null) {
            this.putTimestamp = new Date().getTime();
        } else {
            this.putTimestamp = -1;
        }
    }

    @Override // com.nimbusds.jose.jwk.source.JWKSetCache
    public JWKSet get() {
        if (isExpired()) {
            this.jwkSet = null;
        }
        return this.jwkSet;
    }

    public long getPutTimestamp() {
        return this.putTimestamp;
    }

    public boolean isExpired() {
        return this.putTimestamp > -1 && this.lifespan > -1 && new Date().getTime() > this.putTimestamp + TimeUnit.MILLISECONDS.convert(this.lifespan, this.timeUnit);
    }

    public long getLifespan(TimeUnit timeUnit2) {
        long j = this.lifespan;
        if (j < 0) {
            return j;
        }
        return timeUnit2.convert(j, timeUnit2);
    }
}
