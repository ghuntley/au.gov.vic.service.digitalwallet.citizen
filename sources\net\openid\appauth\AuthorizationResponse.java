package net.openid.appauth;

import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import net.openid.appauth.TokenRequest;
import net.openid.appauth.internal.UriUtil;
import org.json.JSONException;
import org.json.JSONObject;

public class AuthorizationResponse {
    private static final Set<String> BUILT_IN_PARAMS = Collections.unmodifiableSet(new HashSet(Arrays.asList(KEY_TOKEN_TYPE, KEY_STATE, "code", KEY_ACCESS_TOKEN, KEY_EXPIRES_IN, "id_token", KEY_SCOPE)));
    public static final String EXTRA_RESPONSE = "net.openid.appauth.AuthorizationResponse";
    static final String KEY_ACCESS_TOKEN = "access_token";
    static final String KEY_ADDITIONAL_PARAMETERS = "additional_parameters";
    static final String KEY_AUTHORIZATION_CODE = "code";
    static final String KEY_EXPIRES_AT = "expires_at";
    static final String KEY_EXPIRES_IN = "expires_in";
    static final String KEY_ID_TOKEN = "id_token";
    static final String KEY_REQUEST = "request";
    static final String KEY_SCOPE = "scope";
    static final String KEY_STATE = "state";
    static final String KEY_TOKEN_TYPE = "token_type";
    public static final String TOKEN_TYPE_BEARER = "bearer";
    public final String accessToken;
    public final Long accessTokenExpirationTime;
    public final Map<String, String> additionalParameters;
    public final String authorizationCode;
    public final String idToken;
    public final AuthorizationRequest request;
    public final String scope;
    public final String state;
    public final String tokenType;

    public static final class Builder {
        private String mAccessToken;
        private Long mAccessTokenExpirationTime;
        private Map<String, String> mAdditionalParameters = new LinkedHashMap();
        private String mAuthorizationCode;
        private String mIdToken;
        private AuthorizationRequest mRequest;
        private String mScope;
        private String mState;
        private String mTokenType;

        public Builder(AuthorizationRequest authorizationRequest) {
            this.mRequest = (AuthorizationRequest) Preconditions.checkNotNull(authorizationRequest, "authorization request cannot be null");
        }

        public Builder fromUri(Uri uri) {
            return fromUri(uri, SystemClock.INSTANCE);
        }

        /* access modifiers changed from: package-private */
        public Builder fromUri(Uri uri, Clock clock) {
            setState(uri.getQueryParameter(AuthorizationResponse.KEY_STATE));
            setTokenType(uri.getQueryParameter(AuthorizationResponse.KEY_TOKEN_TYPE));
            setAuthorizationCode(uri.getQueryParameter("code"));
            setAccessToken(uri.getQueryParameter(AuthorizationResponse.KEY_ACCESS_TOKEN));
            setAccessTokenExpiresIn(UriUtil.getLongQueryParameter(uri, AuthorizationResponse.KEY_EXPIRES_IN), clock);
            setIdToken(uri.getQueryParameter("id_token"));
            setScope(uri.getQueryParameter(AuthorizationResponse.KEY_SCOPE));
            setAdditionalParameters(AdditionalParamsProcessor.extractAdditionalParams(uri, AuthorizationResponse.BUILT_IN_PARAMS));
            return this;
        }

        public Builder setState(String str) {
            Preconditions.checkNullOrNotEmpty(str, "state must not be empty");
            this.mState = str;
            return this;
        }

        public Builder setTokenType(String str) {
            Preconditions.checkNullOrNotEmpty(str, "tokenType must not be empty");
            this.mTokenType = str;
            return this;
        }

        public Builder setAuthorizationCode(String str) {
            Preconditions.checkNullOrNotEmpty(str, "authorizationCode must not be empty");
            this.mAuthorizationCode = str;
            return this;
        }

        public Builder setAccessToken(String str) {
            Preconditions.checkNullOrNotEmpty(str, "accessToken must not be empty");
            this.mAccessToken = str;
            return this;
        }

        public Builder setAccessTokenExpiresIn(Long l) {
            return setAccessTokenExpiresIn(l, SystemClock.INSTANCE);
        }

        public Builder setAccessTokenExpiresIn(Long l, Clock clock) {
            if (l == null) {
                this.mAccessTokenExpirationTime = null;
            } else {
                this.mAccessTokenExpirationTime = Long.valueOf(clock.getCurrentTimeMillis() + TimeUnit.SECONDS.toMillis(l.longValue()));
            }
            return this;
        }

        public Builder setAccessTokenExpirationTime(Long l) {
            this.mAccessTokenExpirationTime = l;
            return this;
        }

        public Builder setIdToken(String str) {
            Preconditions.checkNullOrNotEmpty(str, "idToken cannot be empty");
            this.mIdToken = str;
            return this;
        }

        public Builder setScope(String str) {
            if (TextUtils.isEmpty(str)) {
                this.mScope = null;
            } else {
                setScopes(str.split(" +"));
            }
            return this;
        }

        public Builder setScopes(String... strArr) {
            if (strArr == null) {
                this.mScope = null;
            } else {
                setScopes(Arrays.asList(strArr));
            }
            return this;
        }

        public Builder setScopes(Iterable<String> iterable) {
            this.mScope = AsciiStringListUtil.iterableToString(iterable);
            return this;
        }

        public Builder setAdditionalParameters(Map<String, String> map) {
            this.mAdditionalParameters = AdditionalParamsProcessor.checkAdditionalParams(map, AuthorizationResponse.BUILT_IN_PARAMS);
            return this;
        }

        public AuthorizationResponse build() {
            return new AuthorizationResponse(this.mRequest, this.mState, this.mTokenType, this.mAuthorizationCode, this.mAccessToken, this.mAccessTokenExpirationTime, this.mIdToken, this.mScope, Collections.unmodifiableMap(this.mAdditionalParameters));
        }
    }

    private AuthorizationResponse(AuthorizationRequest authorizationRequest, String str, String str2, String str3, String str4, Long l, String str5, String str6, Map<String, String> map) {
        this.request = authorizationRequest;
        this.state = str;
        this.tokenType = str2;
        this.authorizationCode = str3;
        this.accessToken = str4;
        this.accessTokenExpirationTime = l;
        this.idToken = str5;
        this.scope = str6;
        this.additionalParameters = map;
    }

    public boolean hasAccessTokenExpired() {
        return hasAccessTokenExpired(SystemClock.INSTANCE);
    }

    /* access modifiers changed from: package-private */
    public boolean hasAccessTokenExpired(Clock clock) {
        return this.accessTokenExpirationTime != null && ((Clock) Preconditions.checkNotNull(clock)).getCurrentTimeMillis() > this.accessTokenExpirationTime.longValue();
    }

    public Set<String> getScopeSet() {
        return AsciiStringListUtil.stringToSet(this.scope);
    }

    public TokenRequest createTokenExchangeRequest() {
        return createTokenExchangeRequest(Collections.emptyMap());
    }

    public TokenRequest createTokenExchangeRequest(Map<String, String> map) {
        Preconditions.checkNotNull(map, "additionalExchangeParameters cannot be null");
        if (this.authorizationCode != null) {
            return new TokenRequest.Builder(this.request.configuration, this.request.clientId).setGrantType(GrantTypeValues.AUTHORIZATION_CODE).setRedirectUri(this.request.redirectUri).setCodeVerifier(this.request.codeVerifier).setAuthorizationCode(this.authorizationCode).setAdditionalParameters(map).build();
        }
        throw new IllegalStateException("authorizationCode not available for exchange request");
    }

    public JSONObject jsonSerialize() {
        JSONObject jSONObject = new JSONObject();
        JsonUtil.put(jSONObject, KEY_REQUEST, this.request.jsonSerialize());
        JsonUtil.putIfNotNull(jSONObject, KEY_STATE, this.state);
        JsonUtil.putIfNotNull(jSONObject, KEY_TOKEN_TYPE, this.tokenType);
        JsonUtil.putIfNotNull(jSONObject, "code", this.authorizationCode);
        JsonUtil.putIfNotNull(jSONObject, KEY_ACCESS_TOKEN, this.accessToken);
        JsonUtil.putIfNotNull(jSONObject, KEY_EXPIRES_AT, this.accessTokenExpirationTime);
        JsonUtil.putIfNotNull(jSONObject, "id_token", this.idToken);
        JsonUtil.putIfNotNull(jSONObject, KEY_SCOPE, this.scope);
        JsonUtil.put(jSONObject, KEY_ADDITIONAL_PARAMETERS, JsonUtil.mapToJsonObject(this.additionalParameters));
        return jSONObject;
    }

    public String jsonSerializeString() {
        return jsonSerialize().toString();
    }

    public static AuthorizationResponse jsonDeserialize(JSONObject jSONObject) throws JSONException {
        if (jSONObject.has(KEY_REQUEST)) {
            return new Builder(AuthorizationRequest.jsonDeserialize(jSONObject.getJSONObject(KEY_REQUEST))).setTokenType(JsonUtil.getStringIfDefined(jSONObject, KEY_TOKEN_TYPE)).setAccessToken(JsonUtil.getStringIfDefined(jSONObject, KEY_ACCESS_TOKEN)).setAuthorizationCode(JsonUtil.getStringIfDefined(jSONObject, "code")).setIdToken(JsonUtil.getStringIfDefined(jSONObject, "id_token")).setScope(JsonUtil.getStringIfDefined(jSONObject, KEY_SCOPE)).setState(JsonUtil.getStringIfDefined(jSONObject, KEY_STATE)).setAccessTokenExpirationTime(JsonUtil.getLongIfDefined(jSONObject, KEY_EXPIRES_AT)).setAdditionalParameters(JsonUtil.getStringMap(jSONObject, KEY_ADDITIONAL_PARAMETERS)).build();
        }
        throw new IllegalArgumentException("authorization request not provided and not found in JSON");
    }

    public static AuthorizationResponse jsonDeserialize(String str) throws JSONException {
        return jsonDeserialize(new JSONObject(str));
    }

    public Intent toIntent() {
        Intent intent = new Intent();
        intent.putExtra(EXTRA_RESPONSE, jsonSerializeString());
        return intent;
    }

    public static AuthorizationResponse fromIntent(Intent intent) {
        Preconditions.checkNotNull(intent, "dataIntent must not be null");
        if (!intent.hasExtra(EXTRA_RESPONSE)) {
            return null;
        }
        try {
            return jsonDeserialize(intent.getStringExtra(EXTRA_RESPONSE));
        } catch (JSONException e) {
            throw new IllegalArgumentException("Intent contains malformed auth response", e);
        }
    }
}
