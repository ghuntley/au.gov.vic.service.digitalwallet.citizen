package com.digitalwallet.app.oidc;

import android.content.Context;
import android.content.Intent;
import android.util.Base64;
import com.digitalwallet.app.api.AuthApi;
import com.digitalwallet.app.oidc.config.ConfigurationDocument;
import com.digitalwallet.app.oidc.model.AuthenticationConfig;
import com.digitalwallet.app.oidc.model.BootstrapConfig;
import com.digitalwallet.app.oidc.model.Profile;
import com.digitalwallet.app.oidc.model.Tokens;
import com.digitalwallet.app.viewmodel.main.NicknameViewModel;
import com.digitalwallet.utilities.AppType;
import com.digitalwallet.utilities.RetrofitHelper;
import com.digitalwallet.utilities.ServerTypeKt;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.squareup.moshi.Moshi;
import io.reactivex.Completable;
import io.reactivex.Single;
import io.reactivex.functions.Function;
import java.security.interfaces.ECPublicKey;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty1;
import net.openid.appauth.AuthorizationServiceConfiguration;
import net.openid.appauth.GrantTypeValues;
import net.openid.appauth.ResponseTypeValues;
import net.openid.appauth.TokenRequest;
import okhttp3.FormBody;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0002\b\u0016\u0018\u0000 82\u00020\u0001:\u00018B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0013J\u000e\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018H\u0016J\u0012\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u001dH\u0012J\u0018\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u001b2\u0006\u0010!\u001a\u00020\u0019H\u0012J\u0018\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\"\u001a\u00020\u001b2\u0006\u0010#\u001a\u00020$H\u0012J(\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*2\u0006\u0010!\u001a\u00020\u00192\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0018\u0010+\u001a\u00020&2\u0006\u0010 \u001a\u00020\u001b2\u0006\u0010!\u001a\u00020\u0019H\u0012J\u0018\u0010,\u001a\u00020&2\u0006\u0010#\u001a\u00020$2\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u001e\u0010-\u001a\b\u0012\u0004\u0012\u00020$0\u00182\u0006\u0010!\u001a\u00020\u00192\u0006\u0010#\u001a\u00020$H\u0016J\u001e\u0010.\u001a\b\u0012\u0004\u0012\u00020/0\u00182\u0006\u0010!\u001a\u00020\u00192\u0006\u0010#\u001a\u00020$H\u0016J\u0016\u00100\u001a\b\u0012\u0004\u0012\u0002010\u00182\u0006\u00102\u001a\u000203H\u0012J\b\u00104\u001a\u00020\u0014H\u0016J\u001e\u00105\u001a\b\u0012\u0004\u0012\u00020\u001b0\u00182\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*H\u0012J\u0018\u00106\u001a\u00020\u001f*\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u001b07H\u0012R\u0014\u0010\b\u001a\u00020\tX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u00069"}, d2 = {"Lcom/digitalwallet/app/oidc/AuthenticationService;", "", "configDocument", "Lcom/digitalwallet/app/oidc/config/ConfigurationDocument;", "authenticationUtility", "Lcom/digitalwallet/app/oidc/AuthenticationUtility;", "moshi", "Lcom/squareup/moshi/Moshi;", "authApi", "Lcom/digitalwallet/app/api/AuthApi;", "(Lcom/digitalwallet/app/oidc/config/ConfigurationDocument;Lcom/digitalwallet/app/oidc/AuthenticationUtility;Lcom/squareup/moshi/Moshi;Lcom/digitalwallet/app/api/AuthApi;)V", "getAuthApi", "()Lcom/digitalwallet/app/api/AuthApi;", "getAuthenticationUtility", "()Lcom/digitalwallet/app/oidc/AuthenticationUtility;", "getConfigDocument", "()Lcom/digitalwallet/app/oidc/config/ConfigurationDocument;", "getMoshi", "()Lcom/squareup/moshi/Moshi;", "doOnLoginComplete", "", "context", "Landroid/content/Context;", "generateAuthSession", "Lio/reactivex/Single;", "Lcom/digitalwallet/app/oidc/AuthSession;", "generateJWK", "", "publicKey", "Ljava/security/interfaces/ECPublicKey;", "generateRefreshForm", "Lokhttp3/FormBody;", "responseCode", "authSession", "clientId", "tokens", "Lcom/digitalwallet/app/oidc/model/Tokens;", "handleAuthenticationResponse", "Lio/reactivex/Completable;", "requestCode", "", "intent", "Landroid/content/Intent;", "handleAuthenticationResponseInternal", "handleRegistrationLoginSuccess", "refreshAuthorization", "requestProfile", "Lcom/digitalwallet/app/oidc/model/Profile;", "retrieveAuthorizationServiceConfiguration", "Lnet/openid/appauth/AuthorizationServiceConfiguration;", "authenticationData", "Lcom/digitalwallet/app/oidc/model/AuthenticationConfig;", "setAutoSyncAndNickname", "validateAuthenticationResponse", "toFormBody", "", "Companion", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: AuthenticationService.kt */
public class AuthenticationService {
    public static final int AuthCallbackIntentCode = 47270;
    public static final String AuthCallbackUrl = "au.gov.vic.digitalwallet://oauth2callback";
    private static final String AuthCallbackUrlScheme = "au.gov.vic.digitalwallet";
    public static final Companion Companion = new Companion(null);
    private static final int MAX_RETRIES = 3;
    private final AuthApi authApi;
    private final AuthenticationUtility authenticationUtility;
    private final ConfigurationDocument configDocument;
    private final Moshi moshi;

    public AuthenticationService(ConfigurationDocument configurationDocument, AuthenticationUtility authenticationUtility2, Moshi moshi2, AuthApi authApi2) {
        Intrinsics.checkNotNullParameter(configurationDocument, "configDocument");
        Intrinsics.checkNotNullParameter(authenticationUtility2, "authenticationUtility");
        Intrinsics.checkNotNullParameter(moshi2, "moshi");
        Intrinsics.checkNotNullParameter(authApi2, "authApi");
        this.configDocument = configurationDocument;
        this.authenticationUtility = authenticationUtility2;
        this.moshi = moshi2;
        this.authApi = authApi2;
    }

    public ConfigurationDocument getConfigDocument() {
        return this.configDocument;
    }

    public AuthenticationUtility getAuthenticationUtility() {
        return this.authenticationUtility;
    }

    public Moshi getMoshi() {
        return this.moshi;
    }

    public AuthApi getAuthApi() {
        return this.authApi;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/digitalwallet/app/oidc/AuthenticationService$Companion;", "", "()V", "AuthCallbackIntentCode", "", "AuthCallbackUrl", "", "AuthCallbackUrlScheme", "MAX_RETRIES", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
    /* compiled from: AuthenticationService.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public Single<Tokens> refreshAuthorization(AuthSession authSession, Tokens tokens) {
        Intrinsics.checkNotNullParameter(authSession, "authSession");
        Intrinsics.checkNotNullParameter(tokens, "tokens");
        Single<Tokens> doOnSuccess = getAuthApi().getTokens(authSession.getTokenEndpoint(), generateRefreshForm(authSession.getClientId(), tokens)).doOnSuccess(new AuthenticationService$sam$io_reactivex_functions_Consumer$0(new AuthenticationService$refreshAuthorization$1(getAuthenticationUtility())));
        Intrinsics.checkNotNullExpressionValue(doOnSuccess, "authApi.getTokens(authSe…cationUtility::setTokens)");
        return doOnSuccess;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [com.digitalwallet.app.oidc.AuthenticationService$sam$io_reactivex_functions_Function$0] */
    /* JADX WARNING: Unknown variable types count: 1 */
    public Single<AuthSession> generateAuthSession() {
        Single<BootstrapConfig> bootstrapDocument = getConfigDocument().getBootstrapDocument();
        KProperty1 kProperty1 = AuthenticationService$generateAuthSession$1.INSTANCE;
        if (kProperty1 != null) {
            kProperty1 = new AuthenticationService$sam$io_reactivex_functions_Function$0(kProperty1);
        }
        Single<R> flatMap = bootstrapDocument.map((Function) kProperty1).flatMap(new AuthenticationService$generateAuthSession$2(this));
        Intrinsics.checkNotNullExpressionValue(flatMap, "configDocument.getBootst…) }\n                    }");
        return flatMap;
    }

    public Single<Profile> requestProfile(AuthSession authSession, Tokens tokens) {
        Intrinsics.checkNotNullParameter(authSession, "authSession");
        Intrinsics.checkNotNullParameter(tokens, "tokens");
        AuthApi authApi2 = getAuthApi();
        String userEndpoint = authSession.getUserEndpoint();
        Single<Profile> doOnSuccess = authApi2.getProfile(userEndpoint, "Bearer " + tokens.getAccess()).doOnSuccess(new AuthenticationService$sam$io_reactivex_functions_Consumer$0(new AuthenticationService$requestProfile$1(getAuthenticationUtility()))).doOnSuccess(new AuthenticationService$requestProfile$2(this));
        Intrinsics.checkNotNullExpressionValue(doOnSuccess, "authApi.getProfile(authS…ility.newLoginSession() }");
        return doOnSuccess;
    }

    public Completable handleAuthenticationResponse(int i, Intent intent, AuthSession authSession, Context context) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        Intrinsics.checkNotNullParameter(authSession, "authSession");
        Intrinsics.checkNotNullParameter(context, "context");
        Completable doOnComplete = validateAuthenticationResponse(i, intent).flatMapCompletable(new AuthenticationService$handleAuthenticationResponse$1(this, authSession)).doOnComplete(new AuthenticationService$handleAuthenticationResponse$2(this, context));
        Intrinsics.checkNotNullExpressionValue(doOnComplete, "validateAuthenticationRe…nLoginComplete(context) }");
        return doOnComplete;
    }

    public Completable handleRegistrationLoginSuccess(Tokens tokens, Context context) {
        Intrinsics.checkNotNullParameter(tokens, "tokens");
        Intrinsics.checkNotNullParameter(context, "context");
        Completable doOnComplete = generateAuthSession().doOnSuccess(new AuthenticationService$handleRegistrationLoginSuccess$1(this, tokens)).flatMap(new AuthenticationService$handleRegistrationLoginSuccess$2(this, tokens)).ignoreElement().doOnComplete(new AuthenticationService$handleRegistrationLoginSuccess$3(this, context));
        Intrinsics.checkNotNullExpressionValue(doOnComplete, "generateAuthSession()\n  …nLoginComplete(context) }");
        return doOnComplete;
    }

    /* access modifiers changed from: private */
    public void doOnLoginComplete(Context context) {
        if (ServerTypeKt.getAppType() == AppType.CITIZEN) {
            setAutoSyncAndNickname();
        } else {
            getAuthenticationUtility().setAutoUpdateState(true);
        }
        FirebaseAnalytics instance = FirebaseAnalytics.getInstance(context);
        Intrinsics.checkNotNullExpressionValue(instance, "FirebaseAnalytics.getInstance(context)");
        instance.setUserId(getAuthenticationUtility().getLoginSession());
    }

    public void setAutoSyncAndNickname() {
        getAuthenticationUtility().setAutoUpdateState(true);
        getAuthenticationUtility().setNickname(NicknameViewModel.Companion.defaultNickname(getAuthenticationUtility()));
    }

    /* access modifiers changed from: private */
    public Single<AuthorizationServiceConfiguration> retrieveAuthorizationServiceConfiguration(AuthenticationConfig authenticationConfig) {
        Single<AuthorizationServiceConfiguration> retry = Single.create(new AuthenticationService$retrieveAuthorizationServiceConfiguration$1(authenticationConfig)).retry(AuthenticationService$retrieveAuthorizationServiceConfiguration$2.INSTANCE);
        Intrinsics.checkNotNullExpressionValue(retry, "Single.create<Authorizat…& attempt < MAX_RETRIES }");
        return retry;
    }

    private Single<String> validateAuthenticationResponse(int i, Intent intent) {
        Single<String> create = Single.create(new AuthenticationService$validateAuthenticationResponse$1(intent, i));
        Intrinsics.checkNotNullExpressionValue(create, "Single.create {\n        …onseCode)\n        }\n    }");
        return create;
    }

    /* access modifiers changed from: private */
    public Completable handleAuthenticationResponseInternal(String str, AuthSession authSession) {
        Completable ignoreElement = getAuthApi().getTokens(authSession.getTokenEndpoint(), generateRefreshForm(str, authSession)).doOnSuccess(new AuthenticationService$sam$io_reactivex_functions_Consumer$0(new AuthenticationService$handleAuthenticationResponseInternal$1(getAuthenticationUtility()))).flatMap(new AuthenticationService$handleAuthenticationResponseInternal$2(this, authSession)).doOnError(new AuthenticationService$sam$io_reactivex_functions_Consumer$0(new AuthenticationService$handleAuthenticationResponseInternal$3(RetrofitHelper.Companion))).ignoreElement();
        Intrinsics.checkNotNullExpressionValue(ignoreElement, "authApi.getTokens(authSe…         .ignoreElement()");
        return ignoreElement;
    }

    static /* synthetic */ String generateJWK$default(AuthenticationService authenticationService, ECPublicKey eCPublicKey, int i, Object obj) {
        if (obj == null) {
            if ((i & 1) != 0) {
                eCPublicKey = authenticationService.getAuthenticationUtility().generateSecureKey$app_citizenProdRelease();
            }
            return authenticationService.generateJWK(eCPublicKey);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: generateJWK");
    }

    private String generateJWK(ECPublicKey eCPublicKey) {
        String encodeToString = Base64.encodeToString(UtilKt.toByteArray(getAuthenticationUtility().generateJWK(eCPublicKey), getMoshi()), 2);
        Intrinsics.checkNotNullExpressionValue(encodeToString, "Base64.encodeToString(au…y(moshi), Base64.NO_WRAP)");
        return encodeToString;
    }

    private FormBody generateRefreshForm(String str, Tokens tokens) {
        ECPublicKey key = getAuthenticationUtility().getKey();
        if (key != null) {
            return toFormBody(MapsKt.mapOf(TuplesKt.to(TokenRequest.PARAM_CLIENT_ID, str), TuplesKt.to("grant_type", GrantTypeValues.REFRESH_TOKEN), TuplesKt.to(GrantTypeValues.REFRESH_TOKEN, tokens.getRefresh()), TuplesKt.to("cnf_key", generateJWK(key))));
        }
        throw new Exception("Public Key Not Found!");
    }

    private FormBody generateRefreshForm(String str, AuthSession authSession) {
        return toFormBody(MapsKt.mapOf(TuplesKt.to(TokenRequest.PARAM_CLIENT_ID, authSession.getClientId()), TuplesKt.to("grant_type", GrantTypeValues.AUTHORIZATION_CODE), TuplesKt.to("redirect_uri", AuthCallbackUrl), TuplesKt.to(ResponseTypeValues.CODE, str), TuplesKt.to("code_verifier", authSession.getCodeVerifier()), TuplesKt.to("nonce", authSession.getNonce()), TuplesKt.to("cnf_key", generateJWK$default(this, null, 1, null))));
    }

    private FormBody toFormBody(Map<String, String> map) {
        FormBody.Builder builder = new FormBody.Builder();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            builder.add(entry.getKey(), entry.getValue());
        }
        FormBody build = builder.build();
        Intrinsics.checkNotNullExpressionValue(build, "builder.build()");
        return build;
    }
}
