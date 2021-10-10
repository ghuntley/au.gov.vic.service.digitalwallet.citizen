package org.bouncycastle.crypto.tls;

import java.io.IOException;
import java.util.Hashtable;

public interface TlsClient {
    TlsAuthentication getAuthentication() throws IOException;

    TlsCipher getCipher() throws IOException;

    int[] getCipherSuites();

    Hashtable getClientExtensions() throws IOException;

    TlsCompression getCompression() throws IOException;

    short[] getCompressionMethods();

    TlsKeyExchange getKeyExchange() throws IOException;

    void init(TlsClientContext tlsClientContext);

    void notifySecureRenegotiation(boolean z) throws IOException;

    void notifySelectedCipherSuite(int i);

    void notifySelectedCompressionMethod(short s);

    void notifySessionID(byte[] bArr);

    void processServerExtensions(Hashtable hashtable);
}
