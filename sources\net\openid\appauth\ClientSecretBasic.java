package net.openid.appauth;

import android.util.Base64;
import java.util.Collections;
import java.util.Map;
import net.openid.appauth.internal.UriUtil;

public class ClientSecretBasic implements ClientAuthentication {
    public static final String NAME = "client_secret_basic";
    private String mClientSecret;

    @Override // net.openid.appauth.ClientAuthentication
    public final Map<String, String> getRequestParameters(String str) {
        return null;
    }

    public ClientSecretBasic(String str) {
        this.mClientSecret = (String) Preconditions.checkNotNull(str, "mClientSecret cannot be null");
    }

    @Override // net.openid.appauth.ClientAuthentication
    public final Map<String, String> getRequestHeaders(String str) {
        String formUrlEncodeValue = UriUtil.formUrlEncodeValue(str);
        String formUrlEncodeValue2 = UriUtil.formUrlEncodeValue(this.mClientSecret);
        String encodeToString = Base64.encodeToString((formUrlEncodeValue + ":" + formUrlEncodeValue2).getBytes(), 2);
        return Collections.singletonMap("Authorization", "Basic " + encodeToString);
    }
}
