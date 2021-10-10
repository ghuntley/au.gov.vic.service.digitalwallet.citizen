package net.openid.appauth;

import android.net.Uri;
import android.os.AsyncTask;
import androidx.browser.trusted.sharing.ShareTarget;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import net.openid.appauth.AuthorizationException;
import net.openid.appauth.AuthorizationServiceDiscovery;
import net.openid.appauth.connectivity.ConnectionBuilder;
import net.openid.appauth.connectivity.DefaultConnectionBuilder;
import net.openid.appauth.internal.Logger;
import org.json.JSONException;
import org.json.JSONObject;

public class AuthorizationServiceConfiguration {
    private static final String KEY_AUTHORIZATION_ENDPOINT = "authorizationEndpoint";
    private static final String KEY_DISCOVERY_DOC = "discoveryDoc";
    private static final String KEY_REGISTRATION_ENDPOINT = "registrationEndpoint";
    private static final String KEY_TOKEN_ENDPOINT = "tokenEndpoint";
    public static final String OPENID_CONFIGURATION_RESOURCE = "openid-configuration";
    public static final String WELL_KNOWN_PATH = ".well-known";
    public final Uri authorizationEndpoint;
    public final AuthorizationServiceDiscovery discoveryDoc;
    public final Uri registrationEndpoint;
    public final Uri tokenEndpoint;

    public interface RetrieveConfigurationCallback {
        void onFetchConfigurationCompleted(AuthorizationServiceConfiguration authorizationServiceConfiguration, AuthorizationException authorizationException);
    }

    public AuthorizationServiceConfiguration(Uri uri, Uri uri2) {
        this(uri, uri2, null);
    }

    public AuthorizationServiceConfiguration(Uri uri, Uri uri2, Uri uri3) {
        this.authorizationEndpoint = (Uri) Preconditions.checkNotNull(uri);
        this.tokenEndpoint = (Uri) Preconditions.checkNotNull(uri2);
        this.registrationEndpoint = uri3;
        this.discoveryDoc = null;
    }

    public AuthorizationServiceConfiguration(AuthorizationServiceDiscovery authorizationServiceDiscovery) {
        Preconditions.checkNotNull(authorizationServiceDiscovery, "docJson cannot be null");
        this.discoveryDoc = authorizationServiceDiscovery;
        this.authorizationEndpoint = authorizationServiceDiscovery.getAuthorizationEndpoint();
        this.tokenEndpoint = authorizationServiceDiscovery.getTokenEndpoint();
        this.registrationEndpoint = authorizationServiceDiscovery.getRegistrationEndpoint();
    }

    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        JsonUtil.put(jSONObject, KEY_AUTHORIZATION_ENDPOINT, this.authorizationEndpoint.toString());
        JsonUtil.put(jSONObject, KEY_TOKEN_ENDPOINT, this.tokenEndpoint.toString());
        Uri uri = this.registrationEndpoint;
        if (uri != null) {
            JsonUtil.put(jSONObject, KEY_REGISTRATION_ENDPOINT, uri.toString());
        }
        AuthorizationServiceDiscovery authorizationServiceDiscovery = this.discoveryDoc;
        if (authorizationServiceDiscovery != null) {
            JsonUtil.put(jSONObject, KEY_DISCOVERY_DOC, authorizationServiceDiscovery.docJson);
        }
        return jSONObject;
    }

    public String toJsonString() {
        return toJson().toString();
    }

    public static AuthorizationServiceConfiguration fromJson(JSONObject jSONObject) throws JSONException {
        Preconditions.checkNotNull(jSONObject, "json object cannot be null");
        if (jSONObject.has(KEY_DISCOVERY_DOC)) {
            try {
                return new AuthorizationServiceConfiguration(new AuthorizationServiceDiscovery(jSONObject.optJSONObject(KEY_DISCOVERY_DOC)));
            } catch (AuthorizationServiceDiscovery.MissingArgumentException e) {
                throw new JSONException("Missing required field in discovery doc: " + e.getMissingField());
            }
        } else {
            Preconditions.checkArgument(jSONObject.has(KEY_AUTHORIZATION_ENDPOINT), "missing authorizationEndpoint");
            Preconditions.checkArgument(jSONObject.has(KEY_TOKEN_ENDPOINT), "missing tokenEndpoint");
            return new AuthorizationServiceConfiguration(JsonUtil.getUri(jSONObject, KEY_AUTHORIZATION_ENDPOINT), JsonUtil.getUri(jSONObject, KEY_TOKEN_ENDPOINT), JsonUtil.getUriIfDefined(jSONObject, KEY_REGISTRATION_ENDPOINT));
        }
    }

    public static AuthorizationServiceConfiguration fromJson(String str) throws JSONException {
        Preconditions.checkNotNull(str, "json cannot be null");
        return fromJson(new JSONObject(str));
    }

    public static void fetchFromIssuer(Uri uri, RetrieveConfigurationCallback retrieveConfigurationCallback) {
        fetchFromUrl(buildConfigurationUriFromIssuer(uri), retrieveConfigurationCallback);
    }

    static Uri buildConfigurationUriFromIssuer(Uri uri) {
        return uri.buildUpon().appendPath(WELL_KNOWN_PATH).appendPath(OPENID_CONFIGURATION_RESOURCE).build();
    }

    public static void fetchFromUrl(Uri uri, RetrieveConfigurationCallback retrieveConfigurationCallback) {
        fetchFromUrl(uri, retrieveConfigurationCallback, DefaultConnectionBuilder.INSTANCE);
    }

    public static void fetchFromUrl(Uri uri, RetrieveConfigurationCallback retrieveConfigurationCallback, ConnectionBuilder connectionBuilder) {
        Preconditions.checkNotNull(uri, "openIDConnectDiscoveryUri cannot be null");
        Preconditions.checkNotNull(retrieveConfigurationCallback, "callback cannot be null");
        Preconditions.checkNotNull(connectionBuilder, "connectionBuilder must not be null");
        new ConfigurationRetrievalAsyncTask(uri, connectionBuilder, retrieveConfigurationCallback).execute(new Void[0]);
    }

    /* access modifiers changed from: private */
    public static class ConfigurationRetrievalAsyncTask extends AsyncTask<Void, Void, AuthorizationServiceConfiguration> {
        private RetrieveConfigurationCallback mCallback;
        private ConnectionBuilder mConnectionBuilder;
        private AuthorizationException mException = null;
        private Uri mUri;

        ConfigurationRetrievalAsyncTask(Uri uri, ConnectionBuilder connectionBuilder, RetrieveConfigurationCallback retrieveConfigurationCallback) {
            this.mUri = uri;
            this.mConnectionBuilder = connectionBuilder;
            this.mCallback = retrieveConfigurationCallback;
        }

        /* access modifiers changed from: protected */
        public AuthorizationServiceConfiguration doInBackground(Void... voidArr) {
            Throwable th;
            InputStream inputStream;
            IOException e;
            JSONException e2;
            AuthorizationServiceDiscovery.MissingArgumentException e3;
            try {
                HttpURLConnection openConnection = this.mConnectionBuilder.openConnection(this.mUri);
                openConnection.setRequestMethod(ShareTarget.METHOD_GET);
                openConnection.setDoInput(true);
                openConnection.connect();
                inputStream = openConnection.getInputStream();
                try {
                    AuthorizationServiceConfiguration authorizationServiceConfiguration = new AuthorizationServiceConfiguration(new AuthorizationServiceDiscovery(new JSONObject(Utils.readInputStream(inputStream))));
                    Utils.closeQuietly(inputStream);
                    return authorizationServiceConfiguration;
                } catch (IOException e4) {
                    e = e4;
                    Logger.errorWithStack(e, "Network error when retrieving discovery document", new Object[0]);
                    this.mException = AuthorizationException.fromTemplate(AuthorizationException.GeneralErrors.NETWORK_ERROR, e);
                    Utils.closeQuietly(inputStream);
                    return null;
                } catch (JSONException e5) {
                    e2 = e5;
                    Logger.errorWithStack(e2, "Error parsing discovery document", new Object[0]);
                    this.mException = AuthorizationException.fromTemplate(AuthorizationException.GeneralErrors.JSON_DESERIALIZATION_ERROR, e2);
                    Utils.closeQuietly(inputStream);
                    return null;
                } catch (AuthorizationServiceDiscovery.MissingArgumentException e6) {
                    e3 = e6;
                    Logger.errorWithStack(e3, "Malformed discovery document", new Object[0]);
                    this.mException = AuthorizationException.fromTemplate(AuthorizationException.GeneralErrors.INVALID_DISCOVERY_DOCUMENT, e3);
                    Utils.closeQuietly(inputStream);
                    return null;
                }
            } catch (IOException e7) {
                e = e7;
                inputStream = null;
                Logger.errorWithStack(e, "Network error when retrieving discovery document", new Object[0]);
                this.mException = AuthorizationException.fromTemplate(AuthorizationException.GeneralErrors.NETWORK_ERROR, e);
                Utils.closeQuietly(inputStream);
                return null;
            } catch (JSONException e8) {
                e2 = e8;
                inputStream = null;
                Logger.errorWithStack(e2, "Error parsing discovery document", new Object[0]);
                this.mException = AuthorizationException.fromTemplate(AuthorizationException.GeneralErrors.JSON_DESERIALIZATION_ERROR, e2);
                Utils.closeQuietly(inputStream);
                return null;
            } catch (AuthorizationServiceDiscovery.MissingArgumentException e9) {
                e3 = e9;
                inputStream = null;
                Logger.errorWithStack(e3, "Malformed discovery document", new Object[0]);
                this.mException = AuthorizationException.fromTemplate(AuthorizationException.GeneralErrors.INVALID_DISCOVERY_DOCUMENT, e3);
                Utils.closeQuietly(inputStream);
                return null;
            } catch (Throwable th2) {
                th = th2;
                Utils.closeQuietly(inputStream);
                throw th;
            }
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(AuthorizationServiceConfiguration authorizationServiceConfiguration) {
            AuthorizationException authorizationException = this.mException;
            if (authorizationException != null) {
                this.mCallback.onFetchConfigurationCompleted(null, authorizationException);
            } else {
                this.mCallback.onFetchConfigurationCompleted(authorizationServiceConfiguration, null);
            }
        }
    }
}
