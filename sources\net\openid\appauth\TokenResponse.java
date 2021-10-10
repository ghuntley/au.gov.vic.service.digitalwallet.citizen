package net.openid.appauth;

import android.text.TextUtils;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

public class TokenResponse {
    private static final Set<String> BUILT_IN_PARAMS = new HashSet(Arrays.asList(KEY_TOKEN_TYPE, KEY_ACCESS_TOKEN, KEY_EXPIRES_IN, "refresh_token", "id_token", KEY_SCOPE));
    static final String KEY_ACCESS_TOKEN = "access_token";
    static final String KEY_ADDITIONAL_PARAMETERS = "additionalParameters";
    static final String KEY_EXPIRES_AT = "expires_at";
    static final String KEY_EXPIRES_IN = "expires_in";
    static final String KEY_ID_TOKEN = "id_token";
    static final String KEY_REFRESH_TOKEN = "refresh_token";
    static final String KEY_REQUEST = "request";
    static final String KEY_SCOPE = "scope";
    static final String KEY_TOKEN_TYPE = "token_type";
    public static final String TOKEN_TYPE_BEARER = "bearer";
    public final String accessToken;
    public final Long accessTokenExpirationTime;
    public final Map<String, String> additionalParameters;
    public final String idToken;
    public final String refreshToken;
    public final TokenRequest request;
    public final String scope;
    public final String tokenType;

    public static final class Builder {
        private String mAccessToken;
        private Long mAccessTokenExpirationTime;
        private Map<String, String> mAdditionalParameters = Collections.emptyMap();
        private String mIdToken;
        private String mRefreshToken;
        private TokenRequest mRequest;
        private String mScope;
        private String mTokenType;

        public Builder(TokenRequest tokenRequest) {
            setRequest(tokenRequest);
        }

        public Builder fromResponseJsonString(String str) throws JSONException {
            Preconditions.checkNotEmpty(str, "json cannot be null or empty");
            return fromResponseJson(new JSONObject(str));
        }

        public Builder fromResponseJson(JSONObject jSONObject) throws JSONException {
            setTokenType(JsonUtil.getString(jSONObject, TokenResponse.KEY_TOKEN_TYPE));
            setAccessToken(JsonUtil.getStringIfDefined(jSONObject, TokenResponse.KEY_ACCESS_TOKEN));
            setAccessTokenExpirationTime(JsonUtil.getLongIfDefined(jSONObject, TokenResponse.KEY_EXPIRES_AT));
            if (jSONObject.has(TokenResponse.KEY_EXPIRES_IN)) {
                setAccessTokenExpiresIn(Long.valueOf(jSONObject.getLong(TokenResponse.KEY_EXPIRES_IN)));
            }
            setRefreshToken(JsonUtil.getStringIfDefined(jSONObject, "refresh_token"));
            setIdToken(JsonUtil.getStringIfDefined(jSONObject, "id_token"));
            setScope(JsonUtil.getStringIfDefined(jSONObject, TokenResponse.KEY_SCOPE));
            setAdditionalParameters(AdditionalParamsProcessor.extractAdditionalParams(jSONObject, TokenResponse.BUILT_IN_PARAMS));
            return this;
        }

        public Builder setRequest(TokenRequest tokenRequest) {
            this.mRequest = (TokenRequest) Preconditions.checkNotNull(tokenRequest, "request cannot be null");
            return this;
        }

        public Builder setTokenType(String str) {
            this.mTokenType = Preconditions.checkNullOrNotEmpty(str, "token type must not be empty if defined");
            return this;
        }

        public Builder setAccessToken(String str) {
            this.mAccessToken = Preconditions.checkNullOrNotEmpty(str, "access token cannot be empty if specified");
            return this;
        }

        public Builder setAccessTokenExpiresIn(Long l) {
            return setAccessTokenExpiresIn(l, SystemClock.INSTANCE);
        }

        /* access modifiers changed from: package-private */
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
            this.mIdToken = Preconditions.checkNullOrNotEmpty(str, "id token must not be empty if defined");
            return this;
        }

        public Builder setRefreshToken(String str) {
            this.mRefreshToken = Preconditions.checkNullOrNotEmpty(str, "refresh token must not be empty if defined");
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
                strArr = new String[0];
            }
            setScopes(Arrays.asList(strArr));
            return this;
        }

        public Builder setScopes(Iterable<String> iterable) {
            this.mScope = AsciiStringListUtil.iterableToString(iterable);
            return this;
        }

        public Builder setAdditionalParameters(Map<String, String> map) {
            this.mAdditionalParameters = AdditionalParamsProcessor.checkAdditionalParams(map, TokenResponse.BUILT_IN_PARAMS);
            return this;
        }

        public TokenResponse build() {
            return new TokenResponse(this.mRequest, this.mTokenType, this.mAccessToken, this.mAccessTokenExpirationTime, this.mIdToken, this.mRefreshToken, this.mScope, this.mAdditionalParameters);
        }
    }

    TokenResponse(TokenRequest tokenRequest, String str, String str2, Long l, String str3, String str4, String str5, Map<String, String> map) {
        this.request = tokenRequest;
        this.tokenType = str;
        this.accessToken = str2;
        this.accessTokenExpirationTime = l;
        this.idToken = str3;
        this.refreshToken = str4;
        this.scope = str5;
        this.additionalParameters = map;
    }

    public Set<String> getScopeSet() {
        return AsciiStringListUtil.stringToSet(this.scope);
    }

    public JSONObject jsonSerialize() {
        JSONObject jSONObject = new JSONObject();
        JsonUtil.put(jSONObject, KEY_REQUEST, this.request.jsonSerialize());
        JsonUtil.putIfNotNull(jSONObject, KEY_TOKEN_TYPE, this.tokenType);
        JsonUtil.putIfNotNull(jSONObject, KEY_ACCESS_TOKEN, this.accessToken);
        JsonUtil.putIfNotNull(jSONObject, KEY_EXPIRES_AT, this.accessTokenExpirationTime);
        JsonUtil.putIfNotNull(jSONObject, "id_token", this.idToken);
        JsonUtil.putIfNotNull(jSONObject, "refresh_token", this.refreshToken);
        JsonUtil.putIfNotNull(jSONObject, KEY_SCOPE, this.scope);
        JsonUtil.put(jSONObject, KEY_ADDITIONAL_PARAMETERS, JsonUtil.mapToJsonObject(this.additionalParameters));
        return jSONObject;
    }

    public String jsonSerializeString() {
        return jsonSerialize().toString();
    }

    public static TokenResponse jsonDeserialize(JSONObject jSONObject) throws JSONException {
        if (jSONObject.has(KEY_REQUEST)) {
            return new Builder(TokenRequest.jsonDeserialize(jSONObject.getJSONObject(KEY_REQUEST))).setTokenType(JsonUtil.getStringIfDefined(jSONObject, KEY_TOKEN_TYPE)).setAccessToken(JsonUtil.getStringIfDefined(jSONObject, KEY_ACCESS_TOKEN)).setAccessTokenExpirationTime(JsonUtil.getLongIfDefined(jSONObject, KEY_EXPIRES_AT)).setIdToken(JsonUtil.getStringIfDefined(jSONObject, "id_token")).setRefreshToken(JsonUtil.getStringIfDefined(jSONObject, "refresh_token")).setScope(JsonUtil.getStringIfDefined(jSONObject, KEY_SCOPE)).setAdditionalParameters(JsonUtil.getStringMap(jSONObject, KEY_ADDITIONAL_PARAMETERS)).build();
        }
        throw new IllegalArgumentException("token request not provided and not found in JSON");
    }

    public static TokenResponse jsonDeserialize(String str) throws JSONException {
        Preconditions.checkNotEmpty(str, "jsonStr cannot be null or empty");
        return jsonDeserialize(new JSONObject(str));
    }
}
