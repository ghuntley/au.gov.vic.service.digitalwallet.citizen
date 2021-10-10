package com.nimbusds.jwt.proc;

import com.nimbusds.jose.proc.SecurityContext;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.util.DateUtils;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import net.jcip.annotations.ThreadSafe;

@ThreadSafe
public class DefaultJWTClaimsVerifier<C extends SecurityContext> implements JWTClaimsSetVerifier<C>, JWTClaimsVerifier, ClockSkewAware {
    public static final int DEFAULT_MAX_CLOCK_SKEW_SECONDS = 60;
    private final Set<String> acceptedAudienceValues;
    private final JWTClaimsSet exactMatchClaims;
    private int maxClockSkew;
    private final Set<String> prohibitedClaims;
    private final Set<String> requiredClaims;

    public DefaultJWTClaimsVerifier() {
        this(null, null, null, null);
    }

    public DefaultJWTClaimsVerifier(JWTClaimsSet jWTClaimsSet, Set<String> set) {
        this(null, jWTClaimsSet, set, null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public DefaultJWTClaimsVerifier(String str, JWTClaimsSet jWTClaimsSet, Set<String> set) {
        this(str != null ? Collections.singleton(str) : null, jWTClaimsSet, set, null);
    }

    public DefaultJWTClaimsVerifier(Set<String> set, JWTClaimsSet jWTClaimsSet, Set<String> set2, Set<String> set3) {
        this.maxClockSkew = 60;
        Set<String> unmodifiableSet = set != null ? Collections.unmodifiableSet(set) : null;
        this.acceptedAudienceValues = unmodifiableSet;
        jWTClaimsSet = jWTClaimsSet == null ? new JWTClaimsSet.Builder().build() : jWTClaimsSet;
        this.exactMatchClaims = jWTClaimsSet;
        HashSet hashSet = new HashSet(jWTClaimsSet.getClaims().keySet());
        if (unmodifiableSet != null && !unmodifiableSet.contains(null)) {
            hashSet.add("aud");
        }
        if (set2 != null) {
            hashSet.addAll(set2);
        }
        this.requiredClaims = Collections.unmodifiableSet(hashSet);
        this.prohibitedClaims = set3 != null ? Collections.unmodifiableSet(set3) : Collections.emptySet();
    }

    public Set<String> getAcceptedAudienceValues() {
        return this.acceptedAudienceValues;
    }

    public JWTClaimsSet getExactMatchClaims() {
        return this.exactMatchClaims;
    }

    public Set<String> getRequiredClaims() {
        return this.requiredClaims;
    }

    public Set<String> getProhibitedClaims() {
        return this.prohibitedClaims;
    }

    @Override // com.nimbusds.jwt.proc.ClockSkewAware
    public int getMaxClockSkew() {
        return this.maxClockSkew;
    }

    @Override // com.nimbusds.jwt.proc.ClockSkewAware
    public void setMaxClockSkew(int i) {
        this.maxClockSkew = i;
    }

    @Override // com.nimbusds.jwt.proc.JWTClaimsVerifier
    public void verify(JWTClaimsSet jWTClaimsSet) throws BadJWTException {
        verify(jWTClaimsSet, null);
    }

    @Override // com.nimbusds.jwt.proc.JWTClaimsSetVerifier
    public void verify(JWTClaimsSet jWTClaimsSet, C c) throws BadJWTException {
        if (this.acceptedAudienceValues != null) {
            List<String> audience = jWTClaimsSet.getAudience();
            if (audience != null && !audience.isEmpty()) {
                boolean z = false;
                Iterator<String> it = audience.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    if (this.acceptedAudienceValues.contains(it.next())) {
                        z = true;
                        break;
                    }
                }
                if (!z) {
                    throw new BadJWTException("JWT audience rejected: " + audience);
                }
            } else if (!this.acceptedAudienceValues.contains(null)) {
                throw new BadJWTException("JWT missing required audience");
            }
        }
        if (jWTClaimsSet.getClaims().keySet().containsAll(this.requiredClaims)) {
            HashSet hashSet = new HashSet();
            for (String str : this.prohibitedClaims) {
                if (jWTClaimsSet.getClaims().containsKey(str)) {
                    hashSet.add(str);
                }
                if (!hashSet.isEmpty()) {
                    throw new BadJWTException("JWT has prohibited claims: " + hashSet);
                }
            }
            for (String str2 : this.exactMatchClaims.getClaims().keySet()) {
                Object claim = jWTClaimsSet.getClaim(str2);
                if (!claim.equals(this.exactMatchClaims.getClaim(str2))) {
                    throw new BadJWTException("JWT \"" + str2 + "\" claim doesn't match expected value: " + claim);
                }
            }
            Date date = new Date();
            Date expirationTime = jWTClaimsSet.getExpirationTime();
            if (expirationTime == null || DateUtils.isAfter(expirationTime, date, (long) this.maxClockSkew)) {
                Date notBeforeTime = jWTClaimsSet.getNotBeforeTime();
                if (!(notBeforeTime == null || DateUtils.isBefore(notBeforeTime, date, (long) this.maxClockSkew))) {
                    throw new BadJWTException("JWT before use time");
                }
                return;
            }
            throw new BadJWTException("Expired JWT");
        }
        HashSet hashSet2 = new HashSet(this.requiredClaims);
        hashSet2.removeAll(jWTClaimsSet.getClaims().keySet());
        throw new BadJWTException("JWT missing required claims: " + hashSet2);
    }
}
