package net.openid.appauth;

import android.net.Uri;
import android.text.TextUtils;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class TokenRequest {
    private static final Set<String> BUILT_IN_PARAMS = Collections.unmodifiableSet(new HashSet(Arrays.asList(PARAM_CLIENT_ID, "code", PARAM_CODE_VERIFIER, PARAM_GRANT_TYPE, PARAM_REDIRECT_URI, "refresh_token", "scope")));
    public static final String GRANT_TYPE_CLIENT_CREDENTIALS = "client_credentials";
    public static final String GRANT_TYPE_PASSWORD = "password";
    static final String KEY_ADDITIONAL_PARAMETERS = "additionalParameters";
    static final String KEY_AUTHORIZATION_CODE = "authorizationCode";
    static final String KEY_CLIENT_ID = "clientId";
    static final String KEY_CONFIGURATION = "configuration";
    static final String KEY_GRANT_TYPE = "grantType";
    static final String KEY_REDIRECT_URI = "redirectUri";
    static final String KEY_REFRESH_TOKEN = "refreshToken";
    static final String KEY_SCOPE = "scope";
    public static final String PARAM_CLIENT_ID = "client_id";
    static final String PARAM_CODE = "code";
    static final String PARAM_CODE_VERIFIER = "code_verifier";
    static final String PARAM_GRANT_TYPE = "grant_type";
    static final String PARAM_REDIRECT_URI = "redirect_uri";
    static final String PARAM_REFRESH_TOKEN = "refresh_token";
    static final String PARAM_SCOPE = "scope";
    public final Map<String, String> additionalParameters;
    public final String authorizationCode;
    public final String clientId;
    public final String codeVerifier;
    public final AuthorizationServiceConfiguration configuration;
    public final String grantType;
    public final Uri redirectUri;
    public final String refreshToken;
    public final String scope;

    public static final class Builder {
        private Map<String, String> mAdditionalParameters = new LinkedHashMap();
        private String mAuthorizationCode;
        private String mClientId;
        private String mCodeVerifier;
        private AuthorizationServiceConfiguration mConfiguration;
        private String mGrantType;
        private Uri mRedirectUri;
        private String mRefreshToken;
        private String mScope;

        public Builder(AuthorizationServiceConfiguration authorizationServiceConfiguration, String str) {
            setConfiguration(authorizationServiceConfiguration);
            setClientId(str);
        }

        public Builder setConfiguration(AuthorizationServiceConfiguration authorizationServiceConfiguration) {
            this.mConfiguration = (AuthorizationServiceConfiguration) Preconditions.checkNotNull(authorizationServiceConfiguration);
            return this;
        }

        public Builder setClientId(String str) {
            this.mClientId = Preconditions.checkNotEmpty(str, "clientId cannot be null or empty");
            return this;
        }

        public Builder setGrantType(String str) {
            this.mGrantType = Preconditions.checkNotEmpty(str, "grantType cannot be null or empty");
            return this;
        }

        public Builder setRedirectUri(Uri uri) {
            if (uri != null) {
                Preconditions.checkNotNull(uri.getScheme(), "redirectUri must have a scheme");
            }
            this.mRedirectUri = uri;
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

        public Builder setAuthorizationCode(String str) {
            Preconditions.checkNullOrNotEmpty(str, "authorization code must not be empty");
            this.mAuthorizationCode = str;
            return this;
        }

        public Builder setRefreshToken(String str) {
            if (str != null) {
                Preconditions.checkNotEmpty(str, "refresh token cannot be empty if defined");
            }
            this.mRefreshToken = str;
            return this;
        }

        public Builder setCodeVerifier(String str) {
            if (str != null) {
                CodeVerifierUtil.checkCodeVerifier(str);
            }
            this.mCodeVerifier = str;
            return this;
        }

        public Builder setAdditionalParameters(Map<String, String> map) {
            this.mAdditionalParameters = AdditionalParamsProcessor.checkAdditionalParams(map, TokenRequest.BUILT_IN_PARAMS);
            return this;
        }

        public TokenRequest build() {
            String inferGrantType = inferGrantType();
            if (GrantTypeValues.AUTHORIZATION_CODE.equals(inferGrantType)) {
                Preconditions.checkNotNull(this.mAuthorizationCode, "authorization code must be specified for grant_type = authorization_code");
            }
            if ("refresh_token".equals(inferGrantType)) {
                Preconditions.checkNotNull(this.mRefreshToken, "refresh token must be specified for grant_type = refresh_token");
            }
            if (!inferGrantType.equals(GrantTypeValues.AUTHORIZATION_CODE) || this.mRedirectUri != null) {
                return new TokenRequest(this.mConfiguration, this.mClientId, inferGrantType, this.mRedirectUri, this.mScope, this.mAuthorizationCode, this.mRefreshToken, this.mCodeVerifier, Collections.unmodifiableMap(this.mAdditionalParameters));
            }
            throw new IllegalStateException("no redirect URI specified on token request for code exchange");
        }

        private String inferGrantType() {
            String str = this.mGrantType;
            if (str != null) {
                return str;
            }
            if (this.mAuthorizationCode != null) {
                return GrantTypeValues.AUTHORIZATION_CODE;
            }
            if (this.mRefreshToken != null) {
                return "refresh_token";
            }
            throw new IllegalStateException("grant type not specified and cannot be inferred");
        }
    }

    private TokenRequest(AuthorizationServiceConfiguration authorizationServiceConfiguration, String str, String str2, Uri uri, String str3, String str4, String str5, String str6, Map<String, String> map) {
        this.configuration = authorizationServiceConfiguration;
        this.clientId = str;
        this.grantType = str2;
        this.redirectUri = uri;
        this.scope = str3;
        this.authorizationCode = str4;
        this.refreshToken = str5;
        this.codeVerifier = str6;
        this.additionalParameters = map;
    }

    public Set<String> getScopeSet() {
        return AsciiStringListUtil.stringToSet(this.scope);
    }

    public Map<String, String> getRequestParameters() {
        Map<String, String> hashMap = new HashMap<>();
        hashMap.put(PARAM_GRANT_TYPE, this.grantType);
        putIfNotNull(hashMap, PARAM_REDIRECT_URI, this.redirectUri);
        putIfNotNull(hashMap, "code", this.authorizationCode);
        putIfNotNull(hashMap, "refresh_token", this.refreshToken);
        putIfNotNull(hashMap, PARAM_CODE_VERIFIER, this.codeVerifier);
        putIfNotNull(hashMap, "scope", this.scope);
        for (Map.Entry<String, String> entry : this.additionalParameters.entrySet()) {
            hashMap.put(entry.getKey(), entry.getValue());
        }
        return hashMap;
    }

    private void putIfNotNull(Map<String, String> map, String str, Object obj) {
        if (obj != null) {
            map.put(str, obj.toString());
        }
    }

    public JSONObject jsonSerialize() {
        JSONObject jSONObject = new JSONObject();
        JsonUtil.put(jSONObject, KEY_CONFIGURATION, this.configuration.toJson());
        JsonUtil.put(jSONObject, KEY_CLIENT_ID, this.clientId);
        JsonUtil.put(jSONObject, KEY_GRANT_TYPE, this.grantType);
        JsonUtil.putIfNotNull(jSONObject, KEY_REDIRECT_URI, this.redirectUri);
        JsonUtil.putIfNotNull(jSONObject, "scope", this.scope);
        JsonUtil.putIfNotNull(jSONObject, KEY_AUTHORIZATION_CODE, this.authorizationCode);
        JsonUtil.putIfNotNull(jSONObject, KEY_REFRESH_TOKEN, this.refreshToken);
        JsonUtil.put(jSONObject, KEY_ADDITIONAL_PARAMETERS, JsonUtil.mapToJsonObject(this.additionalParameters));
        return jSONObject;
    }

    public String jsonSerializeString() {
        return jsonSerialize().toString();
    }

    public static TokenRequest jsonDeserialize(JSONObject jSONObject) throws JSONException {
        Preconditions.checkNotNull(jSONObject, "json object cannot be null");
        Builder additionalParameters2 = new Builder(AuthorizationServiceConfiguration.fromJson(jSONObject.getJSONObject(KEY_CONFIGURATION)), JsonUtil.getString(jSONObject, KEY_CLIENT_ID)).setRedirectUri(JsonUtil.getUriIfDefined(jSONObject, KEY_REDIRECT_URI)).setGrantType(JsonUtil.getString(jSONObject, KEY_GRANT_TYPE)).setRefreshToken(JsonUtil.getStringIfDefined(jSONObject, KEY_REFRESH_TOKEN)).setAuthorizationCode(JsonUtil.getStringIfDefined(jSONObject, KEY_AUTHORIZATION_CODE)).setAdditionalParameters(JsonUtil.getStringMap(jSONObject, KEY_ADDITIONAL_PARAMETERS));
        if (jSONObject.has("scope")) {
            additionalParameters2.setScopes(AsciiStringListUtil.stringToSet(JsonUtil.getString(jSONObject, "scope")));
        }
        return additionalParameters2.build();
    }

    public static TokenRequest jsonDeserialize(String str) throws JSONException {
        Preconditions.checkNotNull(str, "json string cannot be null");
        return jsonDeserialize(new JSONObject(str));
    }
}
