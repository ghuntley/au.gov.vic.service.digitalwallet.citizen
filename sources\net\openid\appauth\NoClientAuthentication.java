package net.openid.appauth;

import java.util.Collections;
import java.util.Map;

public class NoClientAuthentication implements ClientAuthentication {
    public static final NoClientAuthentication INSTANCE = new NoClientAuthentication();
    public static final String NAME = "none";

    @Override // net.openid.appauth.ClientAuthentication
    public Map<String, String> getRequestHeaders(String str) {
        return null;
    }

    private NoClientAuthentication() {
    }

    @Override // net.openid.appauth.ClientAuthentication
    public Map<String, String> getRequestParameters(String str) {
        return Collections.singletonMap(TokenRequest.PARAM_CLIENT_ID, str);
    }
}
