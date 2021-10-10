package com.digitalwallet.app.oidc;

import android.net.Uri;
import android.util.Base64;
import com.digitalwallet.app.oidc.model.AuthenticationConfig;
import com.squareup.moshi.Moshi;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.Map;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import net.openid.appauth.AuthorizationRequest;
import net.openid.appauth.AuthorizationServiceConfiguration;
import net.openid.appauth.AuthorizationServiceDiscovery;
import net.openid.appauth.ResponseTypeValues;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0010\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\bH\u0012J\u0010\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u0018H\u0012J\b\u0010\u0019\u001a\u00020\bH\u0016J\b\u0010\u001a\u001a\u00020\bH\u0016J\u0010\u0010\u001b\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0012R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u00020\bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0014\u0010\u000e\u001a\u00020\bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000b¨\u0006\u001e"}, d2 = {"Lcom/digitalwallet/app/oidc/AuthSession;", "", "authentication", "Lcom/digitalwallet/app/oidc/model/AuthenticationConfig;", "authorization", "Lnet/openid/appauth/AuthorizationServiceConfiguration;", "(Lcom/digitalwallet/app/oidc/model/AuthenticationConfig;Lnet/openid/appauth/AuthorizationServiceConfiguration;)V", "challenge", "", "clientId", "getClientId", "()Ljava/lang/String;", "codeVerifier", "getCodeVerifier", "nonce", "getNonce", "generateAuthorizationRequest", "Lnet/openid/appauth/AuthorizationRequest;", "moshi", "Lcom/squareup/moshi/Moshi;", "generateCodeChallenge", "verifier", "generateRandomString", "keyByteSize", "", "getTokenEndpoint", "getUserEndpoint", "urlEncode", "buffer", "", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: AuthSession.kt */
public class AuthSession {
    private final AuthenticationConfig authentication;
    private final AuthorizationServiceConfiguration authorization;
    private final String challenge;
    private final String clientId;
    private final String codeVerifier = generateRandomString(32);
    private final String nonce = generateRandomString(32);

    public AuthSession(AuthenticationConfig authenticationConfig, AuthorizationServiceConfiguration authorizationServiceConfiguration) {
        Intrinsics.checkNotNullParameter(authenticationConfig, "authentication");
        Intrinsics.checkNotNullParameter(authorizationServiceConfiguration, "authorization");
        this.authentication = authenticationConfig;
        this.authorization = authorizationServiceConfiguration;
        this.clientId = authenticationConfig.getAuthClientId();
        this.challenge = generateCodeChallenge(getCodeVerifier());
    }

    public AuthorizationRequest generateAuthorizationRequest(Moshi moshi) {
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        AuthorizationRequest.Builder builder = new AuthorizationRequest.Builder(this.authorization, getClientId(), ResponseTypeValues.CODE, Uri.parse(AuthenticationService.AuthCallbackUrl));
        Map<String, String> mapOf = MapsKt.mapOf(TuplesKt.to("nonce", getNonce()), TuplesKt.to("claims", new String(UtilKt.toByteArray(MapsKt.mapOf(TuplesKt.to("userinfo", MapsKt.mapOf(TuplesKt.to("given_name", MapsKt.mapOf(TuplesKt.to("essential", true))), TuplesKt.to("family_name", MapsKt.mapOf(TuplesKt.to("essential", true))), TuplesKt.to("email", MapsKt.mapOf(TuplesKt.to("essential", true))))), TuplesKt.to(ResponseTypeValues.ID_TOKEN, MapsKt.emptyMap())), moshi), Charsets.UTF_8)));
        builder.setScope(this.authentication.getScopes());
        builder.setPrompt("login");
        builder.setCodeVerifier(getCodeVerifier(), this.challenge, AuthorizationRequest.CODE_CHALLENGE_METHOD_S256);
        builder.setAdditionalParameters(mapOf);
        AuthorizationRequest build = builder.build();
        Intrinsics.checkNotNullExpressionValue(build, "builder.apply {\n        …Params)\n        }.build()");
        return build;
    }

    public String getTokenEndpoint() {
        String uri = this.authorization.tokenEndpoint.toString();
        Intrinsics.checkNotNullExpressionValue(uri, "authorization.tokenEndpoint.toString()");
        return uri;
    }

    public String getUserEndpoint() {
        Uri userinfoEndpoint;
        String uri;
        AuthorizationServiceDiscovery authorizationServiceDiscovery = this.authorization.discoveryDoc;
        if (authorizationServiceDiscovery != null && (userinfoEndpoint = authorizationServiceDiscovery.getUserinfoEndpoint()) != null && (uri = userinfoEndpoint.toString()) != null) {
            return uri;
        }
        throw new Exception("User info endpoint invalid");
    }

    private String generateRandomString(int i) {
        byte[] bArr = new byte[i];
        new SecureRandom().nextBytes(bArr);
        return urlEncode(bArr);
    }

    private String generateCodeChallenge(String str) {
        Charset charset = Charsets.UTF_8;
        Objects.requireNonNull(str, "null cannot be cast to non-null type java.lang.String");
        byte[] bytes = str.getBytes(charset);
        Intrinsics.checkNotNullExpressionValue(bytes, "(this as java.lang.String).getBytes(charset)");
        byte[] digest = MessageDigest.getInstance("SHA-256").digest(bytes);
        Intrinsics.checkNotNullExpressionValue(digest, "buffer");
        return urlEncode(digest);
    }

    private String urlEncode(byte[] bArr) {
        String encodeToString = Base64.encodeToString(bArr, 11);
        Intrinsics.checkNotNullExpressionValue(encodeToString, "Base64.encodeToString(buffer, flags)");
        return encodeToString;
    }

    public String getCodeVerifier() {
        return this.codeVerifier;
    }

    public String getNonce() {
        return this.nonce;
    }

    public String getClientId() {
        return this.clientId;
    }
}
