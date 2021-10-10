package net.openid.appauth;

public final class ResponseTypeValues {
    public static final String CODE = "code";
    public static final String ID_TOKEN = "id_token";
    public static final String TOKEN = "token";

    private ResponseTypeValues() {
        throw new IllegalStateException("This type is not intended to be instantiated");
    }
}
