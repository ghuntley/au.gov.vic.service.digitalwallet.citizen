package com.google.android.gms.internal.gtm;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

final class zzng implements zznh {
    private HttpURLConnection zzatk;
    private InputStream zzatl = null;

    zzng() {
    }

    @Override // com.google.android.gms.internal.gtm.zznh
    public final InputStream zzcj(String str) throws IOException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        httpURLConnection.setReadTimeout(20000);
        httpURLConnection.setConnectTimeout(20000);
        this.zzatk = httpURLConnection;
        int responseCode = httpURLConnection.getResponseCode();
        if (responseCode == 200) {
            InputStream inputStream = httpURLConnection.getInputStream();
            this.zzatl = inputStream;
            return inputStream;
        }
        StringBuilder sb = new StringBuilder(25);
        sb.append("Bad response: ");
        sb.append(responseCode);
        String sb2 = sb.toString();
        if (responseCode == 404) {
            throw new FileNotFoundException(sb2);
        } else if (responseCode == 503) {
            throw new zznl(sb2);
        } else {
            throw new IOException(sb2);
        }
    }

    @Override // com.google.android.gms.internal.gtm.zznh
    public final void close() {
        HttpURLConnection httpURLConnection = this.zzatk;
        try {
            InputStream inputStream = this.zzatl;
            if (inputStream != null) {
                inputStream.close();
            }
        } catch (IOException e) {
            String valueOf = String.valueOf(e.getMessage());
            zzev.zza(valueOf.length() != 0 ? "HttpUrlConnectionNetworkClient: Error when closing http input stream: ".concat(valueOf) : new String("HttpUrlConnectionNetworkClient: Error when closing http input stream: "), e);
        }
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
        }
    }
}
