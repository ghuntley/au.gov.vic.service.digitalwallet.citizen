package net.openid.appauth;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;
import com.google.firebase.messaging.Constants;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import net.openid.appauth.internal.UriUtil;
import org.json.JSONException;
import org.json.JSONObject;

public class AuthorizationRequest {
    private static final Set<String> BUILT_IN_PARAMS = AdditionalParamsProcessor.builtInParams("client_id", PARAM_CODE_CHALLENGE, PARAM_CODE_CHALLENGE_METHOD, Constants.ScionAnalytics.MessageType.DISPLAY_NOTIFICATION, "login_hint", "prompt", PARAM_REDIRECT_URI, PARAM_RESPONSE_MODE, PARAM_RESPONSE_TYPE, "scope", "state");
    public static final String CODE_CHALLENGE_METHOD_PLAIN = "plain";
    public static final String CODE_CHALLENGE_METHOD_S256 = "S256";
    private static final String KEY_ADDITIONAL_PARAMETERS = "additionalParameters";
    private static final String KEY_CLIENT_ID = "clientId";
    private static final String KEY_CODE_VERIFIER = "codeVerifier";
    private static final String KEY_CODE_VERIFIER_CHALLENGE = "codeVerifierChallenge";
    private static final String KEY_CODE_VERIFIER_CHALLENGE_METHOD = "codeVerifierChallengeMethod";
    private static final String KEY_CONFIGURATION = "configuration";
    private static final String KEY_DISPLAY = "display";
    private static final String KEY_LOGIN_HINT = "login_hint";
    private static final String KEY_PROMPT = "prompt";
    private static final String KEY_REDIRECT_URI = "redirectUri";
    private static final String KEY_RESPONSE_MODE = "responseMode";
    private static final String KEY_RESPONSE_TYPE = "responseType";
    private static final String KEY_SCOPE = "scope";
    private static final String KEY_STATE = "state";
    static final String PARAM_CLIENT_ID = "client_id";
    static final String PARAM_CODE_CHALLENGE = "code_challenge";
    static final String PARAM_CODE_CHALLENGE_METHOD = "code_challenge_method";
    static final String PARAM_DISPLAY = "display";
    static final String PARAM_LOGIN_HINT = "login_hint";
    static final String PARAM_PROMPT = "prompt";
    static final String PARAM_REDIRECT_URI = "redirect_uri";
    static final String PARAM_RESPONSE_MODE = "response_mode";
    static final String PARAM_RESPONSE_TYPE = "response_type";
    static final String PARAM_SCOPE = "scope";
    static final String PARAM_STATE = "state";
    private static final int STATE_LENGTH = 16;
    public final Map<String, String> additionalParameters;
    public final String clientId;
    public final String codeVerifier;
    public final String codeVerifierChallenge;
    public final String codeVerifierChallengeMethod;
    public final AuthorizationServiceConfiguration configuration;
    public final String display;
    public final String loginHint;
    public final String prompt;
    public final Uri redirectUri;
    public final String responseMode;
    public final String responseType;
    public final String scope;
    public final String state;

    public static final class Display {
        public static final String PAGE = "page";
        public static final String POPUP = "popup";
        public static final String TOUCH = "touch";
        public static final String WAP = "wap";
    }

    public static final class Prompt {
        public static final String CONSENT = "consent";
        public static final String LOGIN = "login";
        public static final String NONE = "none";
        public static final String SELECT_ACCOUNT = "select_account";
    }

    public static final class ResponseMode {
        public static final String FRAGMENT = "fragment";
        public static final String QUERY = "query";
    }

    public static final class Scope {
        public static final String ADDRESS = "address";
        public static final String EMAIL = "email";
        public static final String OFFLINE_ACCESS = "offline_access";
        public static final String OPENID = "openid";
        public static final String PHONE = "phone";
        public static final String PROFILE = "profile";
    }

    public static final class Builder {
        private Map<String, String> mAdditionalParameters = new HashMap();
        private String mClientId;
        private String mCodeVerifier;
        private String mCodeVerifierChallenge;
        private String mCodeVerifierChallengeMethod;
        private AuthorizationServiceConfiguration mConfiguration;
        private String mDisplay;
        private String mLoginHint;
        private String mPrompt;
        private Uri mRedirectUri;
        private String mResponseMode;
        private String mResponseType;
        private String mScope;
        private String mState;

        public Builder(AuthorizationServiceConfiguration authorizationServiceConfiguration, String str, String str2, Uri uri) {
            setAuthorizationServiceConfiguration(authorizationServiceConfiguration);
            setClientId(str);
            setResponseType(str2);
            setRedirectUri(uri);
            setState(AuthorizationRequest.generateRandomState());
            setCodeVerifier(CodeVerifierUtil.generateRandomCodeVerifier());
        }

        public Builder setAuthorizationServiceConfiguration(AuthorizationServiceConfiguration authorizationServiceConfiguration) {
            this.mConfiguration = (AuthorizationServiceConfiguration) Preconditions.checkNotNull(authorizationServiceConfiguration, "configuration cannot be null");
            return this;
        }

        public Builder setClientId(String str) {
            this.mClientId = Preconditions.checkNotEmpty(str, "client ID cannot be null or empty");
            return this;
        }

        public Builder setDisplay(String str) {
            this.mDisplay = Preconditions.checkNullOrNotEmpty(str, "display must be null or not empty");
            return this;
        }

        public Builder setLoginHint(String str) {
            this.mLoginHint = Preconditions.checkNullOrNotEmpty(str, "login hint must be null or not empty");
            return this;
        }

        public Builder setPrompt(String str) {
            this.mPrompt = Preconditions.checkNullOrNotEmpty(str, "prompt must be null or non-empty");
            return this;
        }

        public Builder setPromptValues(String... strArr) {
            if (strArr != null) {
                return setPromptValues(Arrays.asList(strArr));
            }
            this.mPrompt = null;
            return this;
        }

        public Builder setPromptValues(Iterable<String> iterable) {
            this.mPrompt = AsciiStringListUtil.iterableToString(iterable);
            return this;
        }

        public Builder setResponseType(String str) {
            this.mResponseType = Preconditions.checkNotEmpty(str, "expected response type cannot be null or empty");
            return this;
        }

        public Builder setRedirectUri(Uri uri) {
            this.mRedirectUri = (Uri) Preconditions.checkNotNull(uri, "redirect URI cannot be null or empty");
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

        public Builder setState(String str) {
            this.mState = Preconditions.checkNullOrNotEmpty(str, "state cannot be empty if defined");
            return this;
        }

        public Builder setCodeVerifier(String str) {
            if (str != null) {
                CodeVerifierUtil.checkCodeVerifier(str);
                this.mCodeVerifier = str;
                this.mCodeVerifierChallenge = CodeVerifierUtil.deriveCodeVerifierChallenge(str);
                this.mCodeVerifierChallengeMethod = CodeVerifierUtil.getCodeVerifierChallengeMethod();
            } else {
                this.mCodeVerifier = null;
                this.mCodeVerifierChallenge = null;
                this.mCodeVerifierChallengeMethod = null;
            }
            return this;
        }

        public Builder setCodeVerifier(String str, String str2, String str3) {
            if (str != null) {
                CodeVerifierUtil.checkCodeVerifier(str);
                Preconditions.checkNotEmpty(str2, "code verifier challenge cannot be null or empty if verifier is set");
                Preconditions.checkNotEmpty(str3, "code verifier challenge method cannot be null or empty if verifier is set");
            } else {
                boolean z = true;
                Preconditions.checkArgument(str2 == null, "code verifier challenge must be null if verifier is null");
                if (str3 != null) {
                    z = false;
                }
                Preconditions.checkArgument(z, "code verifier challenge method must be null if verifier is null");
            }
            this.mCodeVerifier = str;
            this.mCodeVerifierChallenge = str2;
            this.mCodeVerifierChallengeMethod = str3;
            return this;
        }

        public Builder setResponseMode(String str) {
            Preconditions.checkNullOrNotEmpty(str, "responseMode must not be empty");
            this.mResponseMode = str;
            return this;
        }

        public Builder setAdditionalParameters(Map<String, String> map) {
            this.mAdditionalParameters = AdditionalParamsProcessor.checkAdditionalParams(map, AuthorizationRequest.BUILT_IN_PARAMS);
            return this;
        }

        public AuthorizationRequest build() {
            return new AuthorizationRequest(this.mConfiguration, this.mClientId, this.mResponseType, this.mRedirectUri, this.mDisplay, this.mLoginHint, this.mPrompt, this.mScope, this.mState, this.mCodeVerifier, this.mCodeVerifierChallenge, this.mCodeVerifierChallengeMethod, this.mResponseMode, Collections.unmodifiableMap(new HashMap(this.mAdditionalParameters)));
        }
    }

    private AuthorizationRequest(AuthorizationServiceConfiguration authorizationServiceConfiguration, String str, String str2, Uri uri, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, Map<String, String> map) {
        this.configuration = authorizationServiceConfiguration;
        this.clientId = str;
        this.responseType = str2;
        this.redirectUri = uri;
        this.additionalParameters = map;
        this.display = str3;
        this.loginHint = str4;
        this.prompt = str5;
        this.scope = str6;
        this.state = str7;
        this.codeVerifier = str8;
        this.codeVerifierChallenge = str9;
        this.codeVerifierChallengeMethod = str10;
        this.responseMode = str11;
    }

    public Set<String> getScopeSet() {
        return AsciiStringListUtil.stringToSet(this.scope);
    }

    public Set<String> getPromptValues() {
        return AsciiStringListUtil.stringToSet(this.prompt);
    }

    public Uri toUri() {
        Uri.Builder appendQueryParameter = this.configuration.authorizationEndpoint.buildUpon().appendQueryParameter(PARAM_REDIRECT_URI, this.redirectUri.toString()).appendQueryParameter("client_id", this.clientId).appendQueryParameter(PARAM_RESPONSE_TYPE, this.responseType);
        UriUtil.appendQueryParameterIfNotNull(appendQueryParameter, Constants.ScionAnalytics.MessageType.DISPLAY_NOTIFICATION, this.display);
        UriUtil.appendQueryParameterIfNotNull(appendQueryParameter, "login_hint", this.loginHint);
        UriUtil.appendQueryParameterIfNotNull(appendQueryParameter, "prompt", this.prompt);
        UriUtil.appendQueryParameterIfNotNull(appendQueryParameter, "state", this.state);
        UriUtil.appendQueryParameterIfNotNull(appendQueryParameter, "scope", this.scope);
        UriUtil.appendQueryParameterIfNotNull(appendQueryParameter, PARAM_RESPONSE_MODE, this.responseMode);
        if (this.codeVerifier != null) {
            appendQueryParameter.appendQueryParameter(PARAM_CODE_CHALLENGE, this.codeVerifierChallenge).appendQueryParameter(PARAM_CODE_CHALLENGE_METHOD, this.codeVerifierChallengeMethod);
        }
        for (Map.Entry<String, String> entry : this.additionalParameters.entrySet()) {
            appendQueryParameter.appendQueryParameter(entry.getKey(), entry.getValue());
        }
        return appendQueryParameter.build();
    }

    public JSONObject jsonSerialize() {
        JSONObject jSONObject = new JSONObject();
        JsonUtil.put(jSONObject, KEY_CONFIGURATION, this.configuration.toJson());
        JsonUtil.put(jSONObject, KEY_CLIENT_ID, this.clientId);
        JsonUtil.put(jSONObject, KEY_RESPONSE_TYPE, this.responseType);
        JsonUtil.put(jSONObject, KEY_REDIRECT_URI, this.redirectUri.toString());
        JsonUtil.putIfNotNull(jSONObject, Constants.ScionAnalytics.MessageType.DISPLAY_NOTIFICATION, this.display);
        JsonUtil.putIfNotNull(jSONObject, "login_hint", this.loginHint);
        JsonUtil.putIfNotNull(jSONObject, "scope", this.scope);
        JsonUtil.putIfNotNull(jSONObject, "prompt", this.prompt);
        JsonUtil.putIfNotNull(jSONObject, "state", this.state);
        JsonUtil.putIfNotNull(jSONObject, KEY_CODE_VERIFIER, this.codeVerifier);
        JsonUtil.putIfNotNull(jSONObject, KEY_CODE_VERIFIER_CHALLENGE, this.codeVerifierChallenge);
        JsonUtil.putIfNotNull(jSONObject, KEY_CODE_VERIFIER_CHALLENGE_METHOD, this.codeVerifierChallengeMethod);
        JsonUtil.putIfNotNull(jSONObject, KEY_RESPONSE_MODE, this.responseMode);
        JsonUtil.put(jSONObject, KEY_ADDITIONAL_PARAMETERS, JsonUtil.mapToJsonObject(this.additionalParameters));
        return jSONObject;
    }

    public String jsonSerializeString() {
        return jsonSerialize().toString();
    }

    public static AuthorizationRequest jsonDeserialize(JSONObject jSONObject) throws JSONException {
        Preconditions.checkNotNull(jSONObject, "json cannot be null");
        Builder additionalParameters2 = new Builder(AuthorizationServiceConfiguration.fromJson(jSONObject.getJSONObject(KEY_CONFIGURATION)), JsonUtil.getString(jSONObject, KEY_CLIENT_ID), JsonUtil.getString(jSONObject, KEY_RESPONSE_TYPE), JsonUtil.getUri(jSONObject, KEY_REDIRECT_URI)).setDisplay(JsonUtil.getStringIfDefined(jSONObject, Constants.ScionAnalytics.MessageType.DISPLAY_NOTIFICATION)).setLoginHint(JsonUtil.getStringIfDefined(jSONObject, "login_hint")).setPrompt(JsonUtil.getStringIfDefined(jSONObject, "prompt")).setState(JsonUtil.getStringIfDefined(jSONObject, "state")).setCodeVerifier(JsonUtil.getStringIfDefined(jSONObject, KEY_CODE_VERIFIER), JsonUtil.getStringIfDefined(jSONObject, KEY_CODE_VERIFIER_CHALLENGE), JsonUtil.getStringIfDefined(jSONObject, KEY_CODE_VERIFIER_CHALLENGE_METHOD)).setResponseMode(JsonUtil.getStringIfDefined(jSONObject, KEY_RESPONSE_MODE)).setAdditionalParameters(JsonUtil.getStringMap(jSONObject, KEY_ADDITIONAL_PARAMETERS));
        if (jSONObject.has("scope")) {
            additionalParameters2.setScopes(AsciiStringListUtil.stringToSet(JsonUtil.getString(jSONObject, "scope")));
        }
        return additionalParameters2.build();
    }

    public static AuthorizationRequest jsonDeserialize(String str) throws JSONException {
        Preconditions.checkNotNull(str, "json string cannot be null");
        return jsonDeserialize(new JSONObject(str));
    }

    /* access modifiers changed from: private */
    public static String generateRandomState() {
        byte[] bArr = new byte[16];
        new SecureRandom().nextBytes(bArr);
        return Base64.encodeToString(bArr, 11);
    }
}
