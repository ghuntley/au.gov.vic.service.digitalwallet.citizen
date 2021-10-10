package net.openid.appauth;

import java.util.HashMap;
import java.util.Map;

public class ClientSecretPost implements ClientAuthentication {
    public static final String NAME = "client_secret_post";
    static final String PARAM_CLIENT_ID = "client_id";
    static final String PARAM_CLIENT_SECRET = "client_secret";
    private String mClientSecret;

    @Override // net.openid.appauth.ClientAuthentication
    public final Map<String, String> getRequestHeaders(String str) {
        return null;
    }

    public ClientSecretPost(String str) {
        this.mClientSecret = (String) Preconditions.checkNotNull(str, "clientSecret cannot be null");
    }

    @Override // net.openid.appauth.ClientAuthentication
    public final Map<String, String> getRequestParameters(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("client_id", str);
        hashMap.put(PARAM_CLIENT_SECRET, this.mClientSecret);
        return hashMap;
    }
}
