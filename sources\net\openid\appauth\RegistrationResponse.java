package net.openid.appauth;

import android.net.Uri;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

public class RegistrationResponse {
    private static final Set<String> BUILT_IN_PARAMS = new HashSet(Arrays.asList("client_id", PARAM_CLIENT_SECRET, PARAM_CLIENT_SECRET_EXPIRES_AT, PARAM_REGISTRATION_ACCESS_TOKEN, PARAM_REGISTRATION_CLIENT_URI, PARAM_CLIENT_ID_ISSUED_AT, PARAM_TOKEN_ENDPOINT_AUTH_METHOD));
    static final String KEY_ADDITIONAL_PARAMETERS = "additionalParameters";
    static final String KEY_REQUEST = "request";
    static final String PARAM_CLIENT_ID = "client_id";
    static final String PARAM_CLIENT_ID_ISSUED_AT = "client_id_issued_at";
    static final String PARAM_CLIENT_SECRET = "client_secret";
    static final String PARAM_CLIENT_SECRET_EXPIRES_AT = "client_secret_expires_at";
    static final String PARAM_REGISTRATION_ACCESS_TOKEN = "registration_access_token";
    static final String PARAM_REGISTRATION_CLIENT_URI = "registration_client_uri";
    static final String PARAM_TOKEN_ENDPOINT_AUTH_METHOD = "token_endpoint_auth_method";
    public final Map<String, String> additionalParameters;
    public final String clientId;
    public final Long clientIdIssuedAt;
    public final String clientSecret;
    public final Long clientSecretExpiresAt;
    public final String registrationAccessToken;
    public final Uri registrationClientUri;
    public final RegistrationRequest request;
    public final String tokenEndpointAuthMethod;

    public static class MissingArgumentException extends Exception {
        private String mMissingField;

        public MissingArgumentException(String str) {
            super("Missing mandatory registration field: " + str);
            this.mMissingField = str;
        }

        public String getMissingField() {
            return this.mMissingField;
        }
    }

    public static final class Builder {
        private Map<String, String> mAdditionalParameters = Collections.emptyMap();
        private String mClientId;
        private Long mClientIdIssuedAt;
        private String mClientSecret;
        private Long mClientSecretExpiresAt;
        private String mRegistrationAccessToken;
        private Uri mRegistrationClientUri;
        private RegistrationRequest mRequest;
        private String mTokenEndpointAuthMethod;

        public Builder(RegistrationRequest registrationRequest) {
            setRequest(registrationRequest);
        }

        public Builder setRequest(RegistrationRequest registrationRequest) {
            this.mRequest = (RegistrationRequest) Preconditions.checkNotNull(registrationRequest, "request cannot be null");
            return this;
        }

        public Builder setClientId(String str) {
            Preconditions.checkNotEmpty(str, "client ID cannot be null or empty");
            this.mClientId = str;
            return this;
        }

        public Builder setClientIdIssuedAt(Long l) {
            this.mClientIdIssuedAt = l;
            return this;
        }

        public Builder setClientSecret(String str) {
            this.mClientSecret = str;
            return this;
        }

        public Builder setClientSecretExpiresAt(Long l) {
            this.mClientSecretExpiresAt = l;
            return this;
        }

        public Builder setRegistrationAccessToken(String str) {
            this.mRegistrationAccessToken = str;
            return this;
        }

        public Builder setTokenEndpointAuthMethod(String str) {
            this.mTokenEndpointAuthMethod = str;
            return this;
        }

        public Builder setRegistrationClientUri(Uri uri) {
            this.mRegistrationClientUri = uri;
            return this;
        }

        public Builder setAdditionalParameters(Map<String, String> map) {
            this.mAdditionalParameters = AdditionalParamsProcessor.checkAdditionalParams(map, RegistrationResponse.BUILT_IN_PARAMS);
            return this;
        }

        public RegistrationResponse build() {
            return new RegistrationResponse(this.mRequest, this.mClientId, this.mClientIdIssuedAt, this.mClientSecret, this.mClientSecretExpiresAt, this.mRegistrationAccessToken, this.mRegistrationClientUri, this.mTokenEndpointAuthMethod, this.mAdditionalParameters);
        }

        public Builder fromResponseJsonString(String str) throws JSONException, MissingArgumentException {
            Preconditions.checkNotEmpty(str, "json cannot be null or empty");
            return fromResponseJson(new JSONObject(str));
        }

        public Builder fromResponseJson(JSONObject jSONObject) throws JSONException, MissingArgumentException {
            setClientId(JsonUtil.getString(jSONObject, "client_id"));
            setClientIdIssuedAt(JsonUtil.getLongIfDefined(jSONObject, RegistrationResponse.PARAM_CLIENT_ID_ISSUED_AT));
            if (jSONObject.has(RegistrationResponse.PARAM_CLIENT_SECRET)) {
                if (jSONObject.has(RegistrationResponse.PARAM_CLIENT_SECRET_EXPIRES_AT)) {
                    setClientSecret(jSONObject.getString(RegistrationResponse.PARAM_CLIENT_SECRET));
                    setClientSecretExpiresAt(Long.valueOf(jSONObject.getLong(RegistrationResponse.PARAM_CLIENT_SECRET_EXPIRES_AT)));
                } else {
                    throw new MissingArgumentException(RegistrationResponse.PARAM_CLIENT_SECRET_EXPIRES_AT);
                }
            }
            String str = RegistrationResponse.PARAM_REGISTRATION_ACCESS_TOKEN;
            if (jSONObject.has(str) != jSONObject.has(RegistrationResponse.PARAM_REGISTRATION_CLIENT_URI)) {
                if (jSONObject.has(str)) {
                    str = RegistrationResponse.PARAM_REGISTRATION_CLIENT_URI;
                }
                throw new MissingArgumentException(str);
            }
            setRegistrationAccessToken(JsonUtil.getStringIfDefined(jSONObject, str));
            setRegistrationClientUri(JsonUtil.getUriIfDefined(jSONObject, RegistrationResponse.PARAM_REGISTRATION_CLIENT_URI));
            setTokenEndpointAuthMethod(JsonUtil.getStringIfDefined(jSONObject, RegistrationResponse.PARAM_TOKEN_ENDPOINT_AUTH_METHOD));
            setAdditionalParameters(AdditionalParamsProcessor.extractAdditionalParams(jSONObject, RegistrationResponse.BUILT_IN_PARAMS));
            return this;
        }
    }

    private RegistrationResponse(RegistrationRequest registrationRequest, String str, Long l, String str2, Long l2, String str3, Uri uri, String str4, Map<String, String> map) {
        this.request = registrationRequest;
        this.clientId = str;
        this.clientIdIssuedAt = l;
        this.clientSecret = str2;
        this.clientSecretExpiresAt = l2;
        this.registrationAccessToken = str3;
        this.registrationClientUri = uri;
        this.tokenEndpointAuthMethod = str4;
        this.additionalParameters = map;
    }

    public static RegistrationResponse fromJson(RegistrationRequest registrationRequest, String str) throws JSONException, MissingArgumentException {
        Preconditions.checkNotEmpty(str, "jsonStr cannot be null or empty");
        return fromJson(registrationRequest, new JSONObject(str));
    }

    public static RegistrationResponse fromJson(RegistrationRequest registrationRequest, JSONObject jSONObject) throws JSONException, MissingArgumentException {
        Preconditions.checkNotNull(registrationRequest, "registration request cannot be null");
        return new Builder(registrationRequest).fromResponseJson(jSONObject).build();
    }

    public JSONObject jsonSerialize() {
        JSONObject jSONObject = new JSONObject();
        JsonUtil.put(jSONObject, KEY_REQUEST, this.request.jsonSerialize());
        JsonUtil.put(jSONObject, "client_id", this.clientId);
        JsonUtil.putIfNotNull(jSONObject, PARAM_CLIENT_ID_ISSUED_AT, this.clientIdIssuedAt);
        JsonUtil.putIfNotNull(jSONObject, PARAM_CLIENT_SECRET, this.clientSecret);
        JsonUtil.putIfNotNull(jSONObject, PARAM_CLIENT_SECRET_EXPIRES_AT, this.clientSecretExpiresAt);
        JsonUtil.putIfNotNull(jSONObject, PARAM_REGISTRATION_ACCESS_TOKEN, this.registrationAccessToken);
        JsonUtil.putIfNotNull(jSONObject, PARAM_REGISTRATION_CLIENT_URI, this.registrationClientUri);
        JsonUtil.putIfNotNull(jSONObject, PARAM_TOKEN_ENDPOINT_AUTH_METHOD, this.tokenEndpointAuthMethod);
        JsonUtil.put(jSONObject, KEY_ADDITIONAL_PARAMETERS, JsonUtil.mapToJsonObject(this.additionalParameters));
        return jSONObject;
    }

    public String jsonSerializeString() {
        return jsonSerialize().toString();
    }

    public static RegistrationResponse jsonDeserialize(JSONObject jSONObject) throws JSONException {
        Preconditions.checkNotNull(jSONObject, "json cannot be null");
        if (jSONObject.has(KEY_REQUEST)) {
            return new Builder(RegistrationRequest.jsonDeserialize(jSONObject.getJSONObject(KEY_REQUEST))).setClientId(JsonUtil.getString(jSONObject, "client_id")).setClientIdIssuedAt(JsonUtil.getLongIfDefined(jSONObject, PARAM_CLIENT_ID_ISSUED_AT)).setClientSecret(JsonUtil.getStringIfDefined(jSONObject, PARAM_CLIENT_SECRET)).setClientSecretExpiresAt(JsonUtil.getLongIfDefined(jSONObject, PARAM_CLIENT_SECRET_EXPIRES_AT)).setRegistrationAccessToken(JsonUtil.getStringIfDefined(jSONObject, PARAM_REGISTRATION_ACCESS_TOKEN)).setRegistrationClientUri(JsonUtil.getUriIfDefined(jSONObject, PARAM_REGISTRATION_CLIENT_URI)).setTokenEndpointAuthMethod(JsonUtil.getStringIfDefined(jSONObject, PARAM_TOKEN_ENDPOINT_AUTH_METHOD)).setAdditionalParameters(JsonUtil.getStringMap(jSONObject, KEY_ADDITIONAL_PARAMETERS)).build();
        }
        throw new IllegalArgumentException("registration request not found in JSON");
    }

    public static RegistrationResponse jsonDeserialize(String str) throws JSONException {
        Preconditions.checkNotEmpty(str, "jsonStr cannot be null or empty");
        return jsonDeserialize(new JSONObject(str));
    }

    public boolean hasClientSecretExpired() {
        return hasClientSecretExpired(SystemClock.INSTANCE);
    }

    /* access modifiers changed from: package-private */
    public boolean hasClientSecretExpired(Clock clock) {
        return this.clientSecretExpiresAt != null && Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(((Clock) Preconditions.checkNotNull(clock)).getCurrentTimeMillis())).longValue() > this.clientSecretExpiresAt.longValue();
    }
}
