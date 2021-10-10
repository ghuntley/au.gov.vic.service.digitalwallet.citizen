package net.openid.appauth;

import android.net.Uri;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class RegistrationRequest {
    public static final String APPLICATION_TYPE_NATIVE = "native";
    private static final Set<String> BUILT_IN_PARAMS = AdditionalParamsProcessor.builtInParams(PARAM_REDIRECT_URIS, PARAM_RESPONSE_TYPES, PARAM_GRANT_TYPES, PARAM_APPLICATION_TYPE, PARAM_SUBJECT_TYPE, PARAM_TOKEN_ENDPOINT_AUTHENTICATION_METHOD);
    static final String KEY_ADDITIONAL_PARAMETERS = "additionalParameters";
    static final String KEY_CONFIGURATION = "configuration";
    static final String PARAM_APPLICATION_TYPE = "application_type";
    static final String PARAM_GRANT_TYPES = "grant_types";
    static final String PARAM_REDIRECT_URIS = "redirect_uris";
    static final String PARAM_RESPONSE_TYPES = "response_types";
    static final String PARAM_SUBJECT_TYPE = "subject_type";
    static final String PARAM_TOKEN_ENDPOINT_AUTHENTICATION_METHOD = "token_endpoint_auth_method";
    public static final String SUBJECT_TYPE_PAIRWISE = "pairwise";
    public static final String SUBJECT_TYPE_PUBLIC = "public";
    public final Map<String, String> additionalParameters;
    public final String applicationType;
    public final AuthorizationServiceConfiguration configuration;
    public final List<String> grantTypes;
    public final List<Uri> redirectUris;
    public final List<String> responseTypes;
    public final String subjectType;
    public final String tokenEndpointAuthenticationMethod;

    public static final class Builder {
        private Map<String, String> mAdditionalParameters = Collections.emptyMap();
        private AuthorizationServiceConfiguration mConfiguration;
        private List<String> mGrantTypes;
        private List<Uri> mRedirectUris = new ArrayList();
        private List<String> mResponseTypes;
        private String mSubjectType;
        private String mTokenEndpointAuthenticationMethod;

        public Builder(AuthorizationServiceConfiguration authorizationServiceConfiguration, List<Uri> list) {
            setConfiguration(authorizationServiceConfiguration);
            setRedirectUriValues(list);
        }

        public Builder setConfiguration(AuthorizationServiceConfiguration authorizationServiceConfiguration) {
            this.mConfiguration = (AuthorizationServiceConfiguration) Preconditions.checkNotNull(authorizationServiceConfiguration);
            return this;
        }

        public Builder setRedirectUriValues(Uri... uriArr) {
            return setRedirectUriValues(Arrays.asList(uriArr));
        }

        public Builder setRedirectUriValues(List<Uri> list) {
            Preconditions.checkCollectionNotEmpty(list, "redirectUriValues cannot be null");
            this.mRedirectUris = list;
            return this;
        }

        public Builder setResponseTypeValues(String... strArr) {
            return setResponseTypeValues(Arrays.asList(strArr));
        }

        public Builder setResponseTypeValues(List<String> list) {
            this.mResponseTypes = list;
            return this;
        }

        public Builder setGrantTypeValues(String... strArr) {
            return setGrantTypeValues(Arrays.asList(strArr));
        }

        public Builder setGrantTypeValues(List<String> list) {
            this.mGrantTypes = list;
            return this;
        }

        public Builder setSubjectType(String str) {
            this.mSubjectType = str;
            return this;
        }

        public Builder setTokenEndpointAuthenticationMethod(String str) {
            this.mTokenEndpointAuthenticationMethod = str;
            return this;
        }

        public Builder setAdditionalParameters(Map<String, String> map) {
            this.mAdditionalParameters = AdditionalParamsProcessor.checkAdditionalParams(map, RegistrationRequest.BUILT_IN_PARAMS);
            return this;
        }

        public RegistrationRequest build() {
            AuthorizationServiceConfiguration authorizationServiceConfiguration = this.mConfiguration;
            List unmodifiableList = Collections.unmodifiableList(this.mRedirectUris);
            List<String> list = this.mResponseTypes;
            if (list != null) {
                list = Collections.unmodifiableList(list);
            }
            List<String> list2 = this.mGrantTypes;
            if (list2 != null) {
                list2 = Collections.unmodifiableList(list2);
            }
            return new RegistrationRequest(authorizationServiceConfiguration, unmodifiableList, list, list2, this.mSubjectType, this.mTokenEndpointAuthenticationMethod, Collections.unmodifiableMap(this.mAdditionalParameters));
        }
    }

    private RegistrationRequest(AuthorizationServiceConfiguration authorizationServiceConfiguration, List<Uri> list, List<String> list2, List<String> list3, String str, String str2, Map<String, String> map) {
        this.configuration = authorizationServiceConfiguration;
        this.redirectUris = list;
        this.responseTypes = list2;
        this.grantTypes = list3;
        this.subjectType = str;
        this.tokenEndpointAuthenticationMethod = str2;
        this.additionalParameters = map;
        this.applicationType = APPLICATION_TYPE_NATIVE;
    }

    public String toJsonString() {
        JSONObject jsonSerializeParams = jsonSerializeParams();
        for (Map.Entry<String, String> entry : this.additionalParameters.entrySet()) {
            JsonUtil.put(jsonSerializeParams, entry.getKey(), entry.getValue());
        }
        return jsonSerializeParams.toString();
    }

    public JSONObject jsonSerialize() {
        JSONObject jsonSerializeParams = jsonSerializeParams();
        JsonUtil.put(jsonSerializeParams, KEY_CONFIGURATION, this.configuration.toJson());
        JsonUtil.put(jsonSerializeParams, KEY_ADDITIONAL_PARAMETERS, JsonUtil.mapToJsonObject(this.additionalParameters));
        return jsonSerializeParams;
    }

    public String jsonSerializeString() {
        return jsonSerialize().toString();
    }

    private JSONObject jsonSerializeParams() {
        JSONObject jSONObject = new JSONObject();
        JsonUtil.put(jSONObject, PARAM_REDIRECT_URIS, JsonUtil.toJsonArray(this.redirectUris));
        JsonUtil.put(jSONObject, PARAM_APPLICATION_TYPE, this.applicationType);
        List<String> list = this.responseTypes;
        if (list != null) {
            JsonUtil.put(jSONObject, PARAM_RESPONSE_TYPES, JsonUtil.toJsonArray(list));
        }
        List<String> list2 = this.grantTypes;
        if (list2 != null) {
            JsonUtil.put(jSONObject, PARAM_GRANT_TYPES, JsonUtil.toJsonArray(list2));
        }
        JsonUtil.putIfNotNull(jSONObject, PARAM_SUBJECT_TYPE, this.subjectType);
        JsonUtil.putIfNotNull(jSONObject, PARAM_TOKEN_ENDPOINT_AUTHENTICATION_METHOD, this.tokenEndpointAuthenticationMethod);
        return jSONObject;
    }

    public static RegistrationRequest jsonDeserialize(JSONObject jSONObject) throws JSONException {
        Preconditions.checkNotNull(jSONObject, "json must not be null");
        return new Builder(AuthorizationServiceConfiguration.fromJson(jSONObject.getJSONObject(KEY_CONFIGURATION)), JsonUtil.getUriList(jSONObject, PARAM_REDIRECT_URIS)).setSubjectType(JsonUtil.getStringIfDefined(jSONObject, PARAM_SUBJECT_TYPE)).setResponseTypeValues(JsonUtil.getStringListIfDefined(jSONObject, PARAM_RESPONSE_TYPES)).setGrantTypeValues(JsonUtil.getStringListIfDefined(jSONObject, PARAM_GRANT_TYPES)).setAdditionalParameters(JsonUtil.getStringMap(jSONObject, KEY_ADDITIONAL_PARAMETERS)).build();
    }

    public static RegistrationRequest jsonDeserialize(String str) throws JSONException {
        Preconditions.checkNotEmpty(str, "jsonStr must not be empty or null");
        return jsonDeserialize(new JSONObject(str));
    }
}
