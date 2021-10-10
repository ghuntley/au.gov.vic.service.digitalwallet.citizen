package net.openid.appauth;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import net.openid.appauth.AuthorizationException;
import net.openid.appauth.AuthorizationService;
import net.openid.appauth.ClientAuthentication;
import net.openid.appauth.TokenRequest;
import net.openid.appauth.internal.Logger;
import org.json.JSONException;
import org.json.JSONObject;

public class AuthState {
    public static final int EXPIRY_TIME_TOLERANCE_MS = 60000;
    private static final String KEY_AUTHORIZATION_EXCEPTION = "mAuthorizationException";
    private static final String KEY_CONFIG = "config";
    private static final String KEY_LAST_AUTHORIZATION_RESPONSE = "lastAuthorizationResponse";
    private static final String KEY_LAST_REGISTRATION_RESPONSE = "lastRegistrationResponse";
    private static final String KEY_LAST_TOKEN_RESPONSE = "mLastTokenResponse";
    private static final String KEY_REFRESH_TOKEN = "refreshToken";
    private static final String KEY_SCOPE = "scope";
    private AuthorizationException mAuthorizationException;
    private AuthorizationServiceConfiguration mConfig;
    private AuthorizationResponse mLastAuthorizationResponse;
    private RegistrationResponse mLastRegistrationResponse;
    private TokenResponse mLastTokenResponse;
    private boolean mNeedsTokenRefreshOverride;
    private List<AuthStateAction> mPendingActions;
    private final Object mPendingActionsSyncObject;
    private String mRefreshToken;
    private String mScope;

    public interface AuthStateAction {
        void execute(String str, String str2, AuthorizationException authorizationException);
    }

    public AuthState() {
        this.mPendingActionsSyncObject = new Object();
    }

    public AuthState(AuthorizationServiceConfiguration authorizationServiceConfiguration) {
        this.mPendingActionsSyncObject = new Object();
        this.mConfig = authorizationServiceConfiguration;
    }

    public AuthState(AuthorizationResponse authorizationResponse, AuthorizationException authorizationException) {
        this.mPendingActionsSyncObject = new Object();
        boolean z = true;
        Preconditions.checkArgument((authorizationException == null ? false : z) ^ (authorizationResponse != null), "exactly one of authResponse or authError should be non-null");
        this.mPendingActions = null;
        update(authorizationResponse, authorizationException);
    }

    public AuthState(RegistrationResponse registrationResponse) {
        this.mPendingActionsSyncObject = new Object();
        update(registrationResponse);
    }

    public AuthState(AuthorizationResponse authorizationResponse, TokenResponse tokenResponse, AuthorizationException authorizationException) {
        this(authorizationResponse, null);
        update(tokenResponse, authorizationException);
    }

    public String getRefreshToken() {
        return this.mRefreshToken;
    }

    public String getScope() {
        return this.mScope;
    }

    public Set<String> getScopeSet() {
        return AsciiStringListUtil.stringToSet(this.mScope);
    }

    public AuthorizationResponse getLastAuthorizationResponse() {
        return this.mLastAuthorizationResponse;
    }

    public TokenResponse getLastTokenResponse() {
        return this.mLastTokenResponse;
    }

    public RegistrationResponse getLastRegistrationResponse() {
        return this.mLastRegistrationResponse;
    }

    public AuthorizationServiceConfiguration getAuthorizationServiceConfiguration() {
        AuthorizationResponse authorizationResponse = this.mLastAuthorizationResponse;
        if (authorizationResponse != null) {
            return authorizationResponse.request.configuration;
        }
        return this.mConfig;
    }

    public String getAccessToken() {
        if (this.mAuthorizationException != null) {
            return null;
        }
        TokenResponse tokenResponse = this.mLastTokenResponse;
        if (tokenResponse != null && tokenResponse.accessToken != null) {
            return this.mLastTokenResponse.accessToken;
        }
        AuthorizationResponse authorizationResponse = this.mLastAuthorizationResponse;
        if (authorizationResponse != null) {
            return authorizationResponse.accessToken;
        }
        return null;
    }

    public Long getAccessTokenExpirationTime() {
        if (this.mAuthorizationException != null) {
            return null;
        }
        TokenResponse tokenResponse = this.mLastTokenResponse;
        if (tokenResponse != null && tokenResponse.accessToken != null) {
            return this.mLastTokenResponse.accessTokenExpirationTime;
        }
        AuthorizationResponse authorizationResponse = this.mLastAuthorizationResponse;
        if (authorizationResponse == null || authorizationResponse.accessToken == null) {
            return null;
        }
        return this.mLastAuthorizationResponse.accessTokenExpirationTime;
    }

    public String getIdToken() {
        if (this.mAuthorizationException != null) {
            return null;
        }
        TokenResponse tokenResponse = this.mLastTokenResponse;
        if (tokenResponse != null && tokenResponse.idToken != null) {
            return this.mLastTokenResponse.idToken;
        }
        AuthorizationResponse authorizationResponse = this.mLastAuthorizationResponse;
        if (authorizationResponse != null) {
            return authorizationResponse.idToken;
        }
        return null;
    }

    public String getClientSecret() {
        RegistrationResponse registrationResponse = this.mLastRegistrationResponse;
        if (registrationResponse != null) {
            return registrationResponse.clientSecret;
        }
        return null;
    }

    public Long getClientSecretExpirationTime() {
        RegistrationResponse registrationResponse = this.mLastRegistrationResponse;
        if (registrationResponse != null) {
            return registrationResponse.clientSecretExpiresAt;
        }
        return null;
    }

    public boolean isAuthorized() {
        return this.mAuthorizationException == null && !(getAccessToken() == null && getIdToken() == null);
    }

    public AuthorizationException getAuthorizationException() {
        return this.mAuthorizationException;
    }

    public boolean getNeedsTokenRefresh() {
        return getNeedsTokenRefresh(SystemClock.INSTANCE);
    }

    /* access modifiers changed from: package-private */
    public boolean getNeedsTokenRefresh(Clock clock) {
        if (this.mNeedsTokenRefreshOverride) {
            return true;
        }
        if (getAccessTokenExpirationTime() == null) {
            if (getAccessToken() == null) {
                return true;
            }
            return false;
        } else if (getAccessTokenExpirationTime().longValue() <= clock.getCurrentTimeMillis() + 60000) {
            return true;
        } else {
            return false;
        }
    }

    public void setNeedsTokenRefresh(boolean z) {
        this.mNeedsTokenRefreshOverride = z;
    }

    public boolean hasClientSecretExpired() {
        return hasClientSecretExpired(SystemClock.INSTANCE);
    }

    /* access modifiers changed from: package-private */
    public boolean hasClientSecretExpired(Clock clock) {
        if (getClientSecretExpirationTime() == null || getClientSecretExpirationTime().longValue() == 0 || getClientSecretExpirationTime().longValue() > clock.getCurrentTimeMillis()) {
            return false;
        }
        return true;
    }

    public void update(AuthorizationResponse authorizationResponse, AuthorizationException authorizationException) {
        boolean z = false;
        boolean z2 = authorizationResponse != null;
        if (authorizationException != null) {
            z = true;
        }
        Preconditions.checkArgument(z ^ z2, "exactly one of authResponse or authException should be non-null");
        if (authorizationException == null) {
            this.mLastAuthorizationResponse = authorizationResponse;
            this.mConfig = null;
            this.mLastTokenResponse = null;
            this.mRefreshToken = null;
            this.mAuthorizationException = null;
            this.mScope = authorizationResponse.scope != null ? authorizationResponse.scope : authorizationResponse.request.scope;
        } else if (authorizationException.type == 1) {
            this.mAuthorizationException = authorizationException;
        }
    }

    public void update(TokenResponse tokenResponse, AuthorizationException authorizationException) {
        Preconditions.checkArgument((tokenResponse != null) ^ (authorizationException != null), "exactly one of tokenResponse or authException should be non-null");
        AuthorizationException authorizationException2 = this.mAuthorizationException;
        if (authorizationException2 != null) {
            Logger.warn("AuthState.update should not be called in an error state (%s), call updatewith the result of the fresh authorization response first", authorizationException2);
            this.mAuthorizationException = null;
        }
        if (authorizationException == null) {
            this.mLastTokenResponse = tokenResponse;
            if (tokenResponse.scope != null) {
                this.mScope = tokenResponse.scope;
            }
            if (tokenResponse.refreshToken != null) {
                this.mRefreshToken = tokenResponse.refreshToken;
            }
        } else if (authorizationException.type == 2) {
            this.mAuthorizationException = authorizationException;
        }
    }

    public void update(RegistrationResponse registrationResponse) {
        this.mLastRegistrationResponse = registrationResponse;
        this.mConfig = getAuthorizationServiceConfiguration();
        this.mRefreshToken = null;
        this.mScope = null;
        this.mLastAuthorizationResponse = null;
        this.mLastTokenResponse = null;
        this.mAuthorizationException = null;
    }

    public void performActionWithFreshTokens(AuthorizationService authorizationService, AuthStateAction authStateAction) {
        performActionWithFreshTokens(authorizationService, NoClientAuthentication.INSTANCE, Collections.emptyMap(), SystemClock.INSTANCE, authStateAction);
    }

    public void performActionWithFreshTokens(AuthorizationService authorizationService, ClientAuthentication clientAuthentication, AuthStateAction authStateAction) {
        performActionWithFreshTokens(authorizationService, clientAuthentication, Collections.emptyMap(), SystemClock.INSTANCE, authStateAction);
    }

    public void performActionWithFreshTokens(AuthorizationService authorizationService, Map<String, String> map, AuthStateAction authStateAction) {
        try {
            performActionWithFreshTokens(authorizationService, getClientAuthentication(), map, SystemClock.INSTANCE, authStateAction);
        } catch (ClientAuthentication.UnsupportedAuthenticationMethod e) {
            authStateAction.execute(null, null, AuthorizationException.fromTemplate(AuthorizationException.TokenRequestErrors.CLIENT_ERROR, e));
        }
    }

    public void performActionWithFreshTokens(AuthorizationService authorizationService, ClientAuthentication clientAuthentication, Map<String, String> map, AuthStateAction authStateAction) {
        performActionWithFreshTokens(authorizationService, clientAuthentication, map, SystemClock.INSTANCE, authStateAction);
    }

    /* access modifiers changed from: package-private */
    public void performActionWithFreshTokens(AuthorizationService authorizationService, ClientAuthentication clientAuthentication, Map<String, String> map, Clock clock, AuthStateAction authStateAction) {
        Preconditions.checkNotNull(authorizationService, "service cannot be null");
        Preconditions.checkNotNull(clientAuthentication, "client authentication cannot be null");
        Preconditions.checkNotNull(map, "additional params cannot be null");
        Preconditions.checkNotNull(clock, "clock cannot be null");
        Preconditions.checkNotNull(authStateAction, "action cannot be null");
        if (!getNeedsTokenRefresh(clock)) {
            authStateAction.execute(getAccessToken(), getIdToken(), null);
        } else if (this.mRefreshToken == null) {
            authStateAction.execute(null, null, AuthorizationException.fromTemplate(AuthorizationException.AuthorizationRequestErrors.CLIENT_ERROR, new IllegalStateException("No refresh token available and token have expired")));
        } else {
            Preconditions.checkNotNull(this.mPendingActionsSyncObject, "pending actions sync object cannot be null");
            synchronized (this.mPendingActionsSyncObject) {
                List<AuthStateAction> list = this.mPendingActions;
                if (list != null) {
                    list.add(authStateAction);
                    return;
                }
                ArrayList arrayList = new ArrayList();
                this.mPendingActions = arrayList;
                arrayList.add(authStateAction);
                authorizationService.performTokenRequest(createTokenRefreshRequest(map), clientAuthentication, new AuthorizationService.TokenResponseCallback() {
                    /* class net.openid.appauth.AuthState.AnonymousClass1 */

                    @Override // net.openid.appauth.AuthorizationService.TokenResponseCallback
                    public void onTokenRequestCompleted(TokenResponse tokenResponse, AuthorizationException authorizationException) {
                        String str;
                        String str2;
                        AuthorizationException authorizationException2;
                        List<AuthStateAction> list;
                        AuthState.this.update(tokenResponse, authorizationException);
                        if (authorizationException == null) {
                            AuthState.this.mNeedsTokenRefreshOverride = false;
                            str = AuthState.this.getAccessToken();
                            str2 = AuthState.this.getIdToken();
                            authorizationException2 = null;
                        } else {
                            str2 = null;
                            authorizationException2 = authorizationException;
                            str = null;
                        }
                        synchronized (AuthState.this.mPendingActionsSyncObject) {
                            list = AuthState.this.mPendingActions;
                            AuthState.this.mPendingActions = null;
                        }
                        for (AuthStateAction authStateAction : list) {
                            authStateAction.execute(str, str2, authorizationException2);
                        }
                    }
                });
            }
        }
    }

    public TokenRequest createTokenRefreshRequest() {
        return createTokenRefreshRequest(Collections.emptyMap());
    }

    public TokenRequest createTokenRefreshRequest(Map<String, String> map) {
        if (this.mRefreshToken != null) {
            AuthorizationResponse authorizationResponse = this.mLastAuthorizationResponse;
            if (authorizationResponse != null) {
                return new TokenRequest.Builder(authorizationResponse.request.configuration, this.mLastAuthorizationResponse.request.clientId).setGrantType(GrantTypeValues.REFRESH_TOKEN).setScope(this.mLastAuthorizationResponse.request.scope).setRefreshToken(this.mRefreshToken).setAdditionalParameters(map).build();
            }
            throw new IllegalStateException("No authorization configuration available for refresh request");
        }
        throw new IllegalStateException("No refresh token available for refresh request");
    }

    public JSONObject jsonSerialize() {
        JSONObject jSONObject = new JSONObject();
        JsonUtil.putIfNotNull(jSONObject, KEY_REFRESH_TOKEN, this.mRefreshToken);
        JsonUtil.putIfNotNull(jSONObject, KEY_SCOPE, this.mScope);
        AuthorizationServiceConfiguration authorizationServiceConfiguration = this.mConfig;
        if (authorizationServiceConfiguration != null) {
            JsonUtil.put(jSONObject, KEY_CONFIG, authorizationServiceConfiguration.toJson());
        }
        AuthorizationException authorizationException = this.mAuthorizationException;
        if (authorizationException != null) {
            JsonUtil.put(jSONObject, KEY_AUTHORIZATION_EXCEPTION, authorizationException.toJson());
        }
        AuthorizationResponse authorizationResponse = this.mLastAuthorizationResponse;
        if (authorizationResponse != null) {
            JsonUtil.put(jSONObject, KEY_LAST_AUTHORIZATION_RESPONSE, authorizationResponse.jsonSerialize());
        }
        TokenResponse tokenResponse = this.mLastTokenResponse;
        if (tokenResponse != null) {
            JsonUtil.put(jSONObject, KEY_LAST_TOKEN_RESPONSE, tokenResponse.jsonSerialize());
        }
        RegistrationResponse registrationResponse = this.mLastRegistrationResponse;
        if (registrationResponse != null) {
            JsonUtil.put(jSONObject, KEY_LAST_REGISTRATION_RESPONSE, registrationResponse.jsonSerialize());
        }
        return jSONObject;
    }

    public String jsonSerializeString() {
        return jsonSerialize().toString();
    }

    public static AuthState jsonDeserialize(JSONObject jSONObject) throws JSONException {
        Preconditions.checkNotNull(jSONObject, "json cannot be null");
        AuthState authState = new AuthState();
        authState.mRefreshToken = JsonUtil.getStringIfDefined(jSONObject, KEY_REFRESH_TOKEN);
        authState.mScope = JsonUtil.getStringIfDefined(jSONObject, KEY_SCOPE);
        if (jSONObject.has(KEY_CONFIG)) {
            authState.mConfig = AuthorizationServiceConfiguration.fromJson(jSONObject.getJSONObject(KEY_CONFIG));
        }
        if (jSONObject.has(KEY_AUTHORIZATION_EXCEPTION)) {
            authState.mAuthorizationException = AuthorizationException.fromJson(jSONObject.getJSONObject(KEY_AUTHORIZATION_EXCEPTION));
        }
        if (jSONObject.has(KEY_LAST_AUTHORIZATION_RESPONSE)) {
            authState.mLastAuthorizationResponse = AuthorizationResponse.jsonDeserialize(jSONObject.getJSONObject(KEY_LAST_AUTHORIZATION_RESPONSE));
        }
        if (jSONObject.has(KEY_LAST_TOKEN_RESPONSE)) {
            authState.mLastTokenResponse = TokenResponse.jsonDeserialize(jSONObject.getJSONObject(KEY_LAST_TOKEN_RESPONSE));
        }
        if (jSONObject.has(KEY_LAST_REGISTRATION_RESPONSE)) {
            authState.mLastRegistrationResponse = RegistrationResponse.jsonDeserialize(jSONObject.getJSONObject(KEY_LAST_REGISTRATION_RESPONSE));
        }
        return authState;
    }

    public static AuthState jsonDeserialize(String str) throws JSONException {
        Preconditions.checkNotEmpty(str, "jsonStr cannot be null or empty");
        return jsonDeserialize(new JSONObject(str));
    }

    public ClientAuthentication getClientAuthentication() throws ClientAuthentication.UnsupportedAuthenticationMethod {
        if (getClientSecret() == null) {
            return NoClientAuthentication.INSTANCE;
        }
        if (this.mLastRegistrationResponse.tokenEndpointAuthMethod == null) {
            return new ClientSecretBasic(getClientSecret());
        }
        String str = this.mLastRegistrationResponse.tokenEndpointAuthMethod;
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case -2034587045:
                if (str.equals(ClientSecretPost.NAME)) {
                    c = 0;
                    break;
                }
                break;
            case 3387192:
                if (str.equals("none")) {
                    c = 1;
                    break;
                }
                break;
            case 1338964435:
                if (str.equals(ClientSecretBasic.NAME)) {
                    c = 2;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                return new ClientSecretPost(getClientSecret());
            case 1:
                return NoClientAuthentication.INSTANCE;
            case 2:
                return new ClientSecretBasic(getClientSecret());
            default:
                throw new ClientAuthentication.UnsupportedAuthenticationMethod(this.mLastRegistrationResponse.tokenEndpointAuthMethod);
        }
    }
}
