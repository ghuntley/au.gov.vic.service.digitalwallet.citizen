package net.openid.appauth.connectivity;

import android.net.Uri;
import java.io.IOException;
import java.net.HttpURLConnection;

public interface ConnectionBuilder {
    HttpURLConnection openConnection(Uri uri) throws IOException;
}
