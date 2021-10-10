package net.openid.appauth;

public final class GrantTypeValues {
    public static final String AUTHORIZATION_CODE = "authorization_code";
    public static final String IMPLICIT = "implicit";
    public static final String REFRESH_TOKEN = "refresh_token";

    private GrantTypeValues() {
        throw new IllegalStateException("This type is not intended to be instantiated");
    }
}
