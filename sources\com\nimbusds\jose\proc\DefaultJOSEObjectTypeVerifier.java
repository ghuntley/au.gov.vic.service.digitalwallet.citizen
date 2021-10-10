package com.nimbusds.jose.proc;

import com.nimbusds.jose.JOSEObjectType;
import com.nimbusds.jose.proc.SecurityContext;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import net.jcip.annotations.Immutable;

@Immutable
public class DefaultJOSEObjectTypeVerifier<C extends SecurityContext> implements JOSEObjectTypeVerifier<C> {
    public static final DefaultJOSEObjectTypeVerifier JOSE = new DefaultJOSEObjectTypeVerifier(JOSEObjectType.JOSE, null);
    public static final DefaultJOSEObjectTypeVerifier JWT = new DefaultJOSEObjectTypeVerifier(JOSEObjectType.JWT, null);
    private final Set<JOSEObjectType> allowedTypes;

    public DefaultJOSEObjectTypeVerifier() {
        this.allowedTypes = Collections.singleton(null);
    }

    public DefaultJOSEObjectTypeVerifier(Set<JOSEObjectType> set) {
        if (set == null || set.isEmpty()) {
            throw new IllegalArgumentException("The allowed types must not be null or empty");
        }
        this.allowedTypes = set;
    }

    public DefaultJOSEObjectTypeVerifier(JOSEObjectType... jOSEObjectTypeArr) {
        if (jOSEObjectTypeArr == null || jOSEObjectTypeArr.length == 0) {
            throw new IllegalArgumentException("The allowed types must not be null or empty");
        }
        this.allowedTypes = new HashSet(Arrays.asList(jOSEObjectTypeArr));
    }

    public Set<JOSEObjectType> getAllowedTypes() {
        return this.allowedTypes;
    }

    @Override // com.nimbusds.jose.proc.JOSEObjectTypeVerifier
    public void verify(JOSEObjectType jOSEObjectType, C c) throws BadJOSEException {
        if (jOSEObjectType == null && !this.allowedTypes.contains(null)) {
            throw new BadJOSEException("Required JOSE header \"typ\" (type) parameter is missing");
        } else if (!this.allowedTypes.contains(jOSEObjectType)) {
            throw new BadJOSEException("JOSE header \"typ\" (type) \"" + jOSEObjectType + "\" not allowed");
        }
    }
}
