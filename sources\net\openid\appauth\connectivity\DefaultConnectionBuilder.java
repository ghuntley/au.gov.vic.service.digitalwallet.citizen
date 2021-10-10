package net.openid.appauth.connectivity;

import android.net.Uri;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import net.openid.appauth.Preconditions;

public final class DefaultConnectionBuilder implements ConnectionBuilder {
    private static final int CONNECTION_TIMEOUT_MS = ((int) TimeUnit.SECONDS.toMillis(15));
    private static final String HTTPS_SCHEME = "https";
    public static final DefaultConnectionBuilder INSTANCE = new DefaultConnectionBuilder();
    private static final int READ_TIMEOUT_MS = ((int) TimeUnit.SECONDS.toMillis(10));

    private DefaultConnectionBuilder() {
    }

    @Override // net.openid.appauth.connectivity.ConnectionBuilder
    public HttpURLConnection openConnection(Uri uri) throws IOException {
        Preconditions.checkNotNull(uri, "url must not be null");
        Preconditions.checkArgument(HTTPS_SCHEME.equals(uri.getScheme()), "only https connections are permitted");
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(uri.toString()).openConnection();
        httpURLConnection.setConnectTimeout(CONNECTION_TIMEOUT_MS);
        httpURLConnection.setReadTimeout(READ_TIMEOUT_MS);
        httpURLConnection.setInstanceFollowRedirects(false);
        return httpURLConnection;
    }
}
