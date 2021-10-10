package net.openid.appauth;

import java.util.Map;

public interface ClientAuthentication {
    Map<String, String> getRequestHeaders(String str);

    Map<String, String> getRequestParameters(String str);

    public static class UnsupportedAuthenticationMethod extends Exception {
        private String mAuthMethod;

        public UnsupportedAuthenticationMethod(String str) {
            super("Unsupported client authentication method: " + str);
            this.mAuthMethod = str;
        }

        public String getUnsupportedAuthenticationMethod() {
            return this.mAuthMethod;
        }
    }
}
