package com.nimbusds.jose.util;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.Proxy;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import net.jcip.annotations.ThreadSafe;

@ThreadSafe
public class DefaultResourceRetriever extends AbstractRestrictedResourceRetriever implements RestrictedResourceRetriever {
    private boolean disconnectAfterUse;
    private Proxy proxy;

    public DefaultResourceRetriever() {
        this(0, 0);
    }

    public DefaultResourceRetriever(int i, int i2) {
        this(i, i2, 0);
    }

    public DefaultResourceRetriever(int i, int i2, int i3) {
        this(i, i2, i3, true);
    }

    public DefaultResourceRetriever(int i, int i2, int i3, boolean z) {
        super(i, i2, i3);
        this.disconnectAfterUse = z;
    }

    public boolean disconnectsAfterUse() {
        return this.disconnectAfterUse;
    }

    public void setDisconnectsAfterUse(boolean z) {
        this.disconnectAfterUse = z;
    }

    public Proxy getProxy() {
        return this.proxy;
    }

    public void setProxy(Proxy proxy2) {
        this.proxy = proxy2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x006a, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x006b, code lost:
        if (r6 != null) goto L_0x006d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x006d, code lost:
        if (r1 != null) goto L_0x006f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:?, code lost:
        r6.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0073, code lost:
        r6 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0074, code lost:
        r1.addSuppressed(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0078, code lost:
        r6.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x007b, code lost:
        throw r2;
     */
    @Override // com.nimbusds.jose.util.ResourceRetriever
    public Resource retrieveResource(URL url) throws IOException {
        HttpURLConnection httpURLConnection = null;
        try {
            httpURLConnection = openConnection(url);
            httpURLConnection.setConnectTimeout(getConnectTimeout());
            httpURLConnection.setReadTimeout(getReadTimeout());
            InputStream inputStream = getInputStream(httpURLConnection, getSizeLimit());
            String readInputStreamToString = IOUtils.readInputStreamToString(inputStream, StandardCharsets.UTF_8);
            if (inputStream != null) {
                inputStream.close();
            }
            int responseCode = httpURLConnection.getResponseCode();
            String responseMessage = httpURLConnection.getResponseMessage();
            if (responseCode > 299 || responseCode < 200) {
                throw new IOException("HTTP " + responseCode + ": " + responseMessage);
            }
            Resource resource = new Resource(readInputStreamToString, httpURLConnection.getContentType());
            if (this.disconnectAfterUse && httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            return resource;
        } catch (ClassCastException e) {
            throw new IOException("Couldn't open HTTP(S) connection: " + e.getMessage(), e);
        } catch (Throwable th) {
            if (this.disconnectAfterUse && httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            throw th;
        }
    }

    /* access modifiers changed from: protected */
    public HttpURLConnection openConnection(URL url) throws IOException {
        Proxy proxy2 = this.proxy;
        if (proxy2 != null) {
            return (HttpURLConnection) url.openConnection(proxy2);
        }
        return (HttpURLConnection) url.openConnection();
    }

    private InputStream getInputStream(HttpURLConnection httpURLConnection, int i) throws IOException {
        InputStream inputStream = httpURLConnection.getInputStream();
        return i > 0 ? new BoundedInputStream(inputStream, (long) getSizeLimit()) : inputStream;
    }
}
