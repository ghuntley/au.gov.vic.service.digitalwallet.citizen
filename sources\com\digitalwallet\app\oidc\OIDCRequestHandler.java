package com.digitalwallet.app.oidc;

import com.digitalwallet.app.oidc.config.ConfigurationDocument;
import com.digitalwallet.app.oidc.model.AuthenticationConfig;
import com.digitalwallet.app.oidc.model.BootstrapConfig;
import com.digitalwallet.app.oidc.model.Tokens;
import io.reactivex.schedulers.Schedulers;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import timber.log.Timber;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u0000 &2\u00020\u0001:\u0001&B\u001f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ(\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0012J\n\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0012J\u0010\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!H\u0016J8\u0010\"\u001a\u00020\u001f2\u0006\u0010#\u001a\u00020\u001f2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010 \u001a\u00020!2\u0006\u0010$\u001a\u00020\u00142\u0006\u0010%\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0012R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006'"}, d2 = {"Lcom/digitalwallet/app/oidc/OIDCRequestHandler;", "Lokhttp3/Interceptor;", "authenticationService", "Lcom/digitalwallet/app/oidc/AuthenticationService;", "authenticationUtility", "Lcom/digitalwallet/app/oidc/AuthenticationUtility;", "configurationDocument", "Lcom/digitalwallet/app/oidc/config/ConfigurationDocument;", "(Lcom/digitalwallet/app/oidc/AuthenticationService;Lcom/digitalwallet/app/oidc/AuthenticationUtility;Lcom/digitalwallet/app/oidc/config/ConfigurationDocument;)V", "getAuthenticationService", "()Lcom/digitalwallet/app/oidc/AuthenticationService;", "getAuthenticationUtility", "()Lcom/digitalwallet/app/oidc/AuthenticationUtility;", "getConfigurationDocument", "()Lcom/digitalwallet/app/oidc/config/ConfigurationDocument;", "refreshLock", "Ljava/lang/Object;", "getRefreshLock", "()Ljava/lang/Object;", "formatApiRequest", "Lokhttp3/Request;", "request", "tokens", "Lcom/digitalwallet/app/oidc/model/Tokens;", "authenticationData", "Lcom/digitalwallet/app/oidc/model/AuthenticationConfig;", "apiUrl", "", "getBootstrapData", "Lcom/digitalwallet/app/oidc/model/BootstrapConfig;", "intercept", "Lokhttp3/Response;", "chain", "Lokhttp3/Interceptor$Chain;", "refreshAndRetry", "response", "originalRequest", "authenticationConfig", "Companion", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: OIDCRequestHandler.kt */
public class OIDCRequestHandler implements Interceptor {
    public static final String API_CLIENT_VERSION = "Android/0.1.0.0";
    public static final Companion Companion = new Companion(null);
    public static final String apiPrefix = "https://dwapi/";
    private final AuthenticationService authenticationService;
    private final AuthenticationUtility authenticationUtility;
    private final ConfigurationDocument configurationDocument;
    private final Object refreshLock = new Object();

    @Inject
    public OIDCRequestHandler(AuthenticationService authenticationService2, AuthenticationUtility authenticationUtility2, ConfigurationDocument configurationDocument2) {
        Intrinsics.checkNotNullParameter(authenticationService2, "authenticationService");
        Intrinsics.checkNotNullParameter(authenticationUtility2, "authenticationUtility");
        Intrinsics.checkNotNullParameter(configurationDocument2, "configurationDocument");
        this.authenticationService = authenticationService2;
        this.authenticationUtility = authenticationUtility2;
        this.configurationDocument = configurationDocument2;
    }

    public AuthenticationService getAuthenticationService() {
        return this.authenticationService;
    }

    public AuthenticationUtility getAuthenticationUtility() {
        return this.authenticationUtility;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/digitalwallet/app/oidc/OIDCRequestHandler$Companion;", "", "()V", "API_CLIENT_VERSION", "", "apiPrefix", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
    /* compiled from: OIDCRequestHandler.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public ConfigurationDocument getConfigurationDocument() {
        return this.configurationDocument;
    }

    public Object getRefreshLock() {
        return this.refreshLock;
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) {
        Tokens tokens;
        Intrinsics.checkNotNullParameter(chain, "chain");
        Request request = chain.request();
        String httpUrl = request.url().toString();
        Intrinsics.checkNotNullExpressionValue(httpUrl, "request.url().toString()");
        BootstrapConfig bootstrapData = !StringsKt.startsWith$default(httpUrl, "https://service.vic.gov.au/mobile-application/application-config.json", false, 2, null) ? getBootstrapData() : null;
        if (bootstrapData == null) {
            Response proceed = chain.proceed(request);
            Intrinsics.checkNotNullExpressionValue(proceed, "chain.proceed(request)");
            return proceed;
        }
        AuthenticationConfig authentication = bootstrapData.getAuthentication();
        String apiUrl = bootstrapData.getApiConfig().getApiUrl();
        if (!StringsKt.startsWith$default(httpUrl, apiPrefix, false, 2, (Object) null)) {
            Response proceed2 = chain.proceed(request);
            Intrinsics.checkNotNullExpressionValue(proceed2, "chain.proceed(request)");
            return proceed2;
        }
        synchronized (getRefreshLock()) {
            tokens = getAuthenticationUtility().getTokens();
            Unit unit = Unit.INSTANCE;
        }
        if (tokens != null) {
            Intrinsics.checkNotNullExpressionValue(request, "request");
            Response proceed3 = chain.proceed(formatApiRequest(request, tokens, authentication, apiUrl));
            if (proceed3.code() == 401) {
                Intrinsics.checkNotNullExpressionValue(proceed3, "response");
                return refreshAndRetry(proceed3, tokens, chain, request, authentication, apiUrl);
            }
            Intrinsics.checkNotNullExpressionValue(proceed3, "response");
            return proceed3;
        }
        Response build = new Response.Builder().code(400).build();
        Intrinsics.checkNotNullExpressionValue(build, "Response.Builder().code(400).build()");
        return build;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r17v0, resolved type: okhttp3.Request */
    /* JADX WARN: Multi-variable type inference failed */
    private Response refreshAndRetry(Response response, Tokens tokens, Interceptor.Chain chain, Request request, AuthenticationConfig authenticationConfig, String str) {
        Throwable th;
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = request;
        synchronized (getRefreshLock()) {
            try {
                Tokens tokens2 = getAuthenticationUtility().getTokens();
                if (tokens2 == null) {
                    return response;
                }
                if (Intrinsics.areEqual(tokens2, tokens)) {
                    try {
                        R blockingGet = getAuthenticationService().generateAuthSession().flatMap(new OIDCRequestHandler$refreshAndRetry$$inlined$synchronized$lambda$1(this, response, tokens, objectRef, request, authenticationConfig, str)).subscribeOn(Schedulers.io()).blockingGet();
                        Intrinsics.checkNotNullExpressionValue(blockingGet, "newTokens");
                        try {
                            objectRef.element = (T) formatApiRequest(request, blockingGet, authenticationConfig, str);
                        } catch (Exception unused) {
                        }
                    } catch (Exception unused2) {
                        return response;
                    }
                }
                try {
                    Unit unit = Unit.INSTANCE;
                    Response proceed = chain.proceed(objectRef.element);
                    Intrinsics.checkNotNullExpressionValue(proceed, "chain.proceed(request)");
                    return proceed;
                } catch (Throwable th2) {
                    th = th2;
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                throw th;
            }
        }
    }

    private BootstrapConfig getBootstrapData() {
        BootstrapConfig bootstrapConfig = null;
        try {
            return getConfigurationDocument().getBootstrapDocument().blockingGet();
        } catch (Exception e) {
            Timber.e(e);
            return bootstrapConfig;
        }
    }

    private Request formatApiRequest(Request request, Tokens tokens, AuthenticationConfig authenticationConfig, String str) {
        String httpUrl = request.url().toString();
        Intrinsics.checkNotNullExpressionValue(httpUrl, "request.url().toString()");
        Request.Builder url = request.newBuilder().url(StringsKt.replace$default(httpUrl, apiPrefix, str + '/', false, 4, (Object) null));
        Request.Builder addHeader = url.addHeader("Authorization", "Bearer " + tokens.getAccess());
        Request build = addHeader.addHeader("X-Authentication", "Bearer " + tokens.getId()).addHeader("X-ClientId", authenticationConfig.getApiClientId()).addHeader("X-DigitalWalletClientVersion", API_CLIENT_VERSION).build();
        Intrinsics.checkNotNullExpressionValue(build, "request.newBuilder()\n   …\n                .build()");
        return build;
    }
}
