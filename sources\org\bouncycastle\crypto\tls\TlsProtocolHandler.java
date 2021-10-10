package org.bouncycastle.crypto.tls;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.SecureRandom;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.x500.X500Name;
import org.bouncycastle.crypto.prng.ThreadedSeedGenerator;
import org.bouncycastle.util.Arrays;

public class TlsProtocolHandler {
    private static final short CS_CERTIFICATE_REQUEST_RECEIVED = 5;
    private static final short CS_CERTIFICATE_VERIFY_SEND = 8;
    private static final short CS_CLIENT_CHANGE_CIPHER_SPEC_SEND = 9;
    private static final short CS_CLIENT_FINISHED_SEND = 10;
    private static final short CS_CLIENT_HELLO_SEND = 1;
    private static final short CS_CLIENT_KEY_EXCHANGE_SEND = 7;
    private static final short CS_DONE = 12;
    private static final short CS_SERVER_CERTIFICATE_RECEIVED = 3;
    private static final short CS_SERVER_CHANGE_CIPHER_SPEC_RECEIVED = 11;
    private static final short CS_SERVER_HELLO_DONE_RECEIVED = 6;
    private static final short CS_SERVER_HELLO_RECEIVED = 2;
    private static final short CS_SERVER_KEY_EXCHANGE_RECEIVED = 4;
    private static final Integer EXT_RenegotiationInfo = new Integer(65281);
    private static final String TLS_ERROR_MESSAGE = "Internal TLS error, this could be an attack";
    private static final byte[] emptybuf = new byte[0];
    private ByteQueue alertQueue;
    private boolean appDataReady;
    private ByteQueue applicationDataQueue;
    private TlsAuthentication authentication;
    private CertificateRequest certificateRequest;
    private ByteQueue changeCipherSpecQueue;
    private Hashtable clientExtensions;
    private boolean closed;
    private short connection_state;
    private boolean failedWithError;
    private ByteQueue handshakeQueue;
    private TlsKeyExchange keyExchange;
    private int[] offeredCipherSuites;
    private short[] offeredCompressionMethods;
    private SecureRandom random;
    private RecordStream rs;
    private SecurityParameters securityParameters;
    private TlsClient tlsClient;
    private TlsClientContextImpl tlsClientContext;
    private TlsInputStream tlsInputStream;
    private TlsOutputStream tlsOutputStream;

    public TlsProtocolHandler(InputStream inputStream, OutputStream outputStream) {
        this(inputStream, outputStream, createSecureRandom());
    }

    public TlsProtocolHandler(InputStream inputStream, OutputStream outputStream, SecureRandom secureRandom) {
        this.applicationDataQueue = new ByteQueue();
        this.changeCipherSpecQueue = new ByteQueue();
        this.alertQueue = new ByteQueue();
        this.handshakeQueue = new ByteQueue();
        this.tlsInputStream = null;
        this.tlsOutputStream = null;
        this.closed = false;
        this.failedWithError = false;
        this.appDataReady = false;
        this.securityParameters = null;
        this.tlsClientContext = null;
        this.tlsClient = null;
        this.offeredCipherSuites = null;
        this.offeredCompressionMethods = null;
        this.keyExchange = null;
        this.authentication = null;
        this.certificateRequest = null;
        this.connection_state = 0;
        this.rs = new RecordStream(this, inputStream, outputStream);
        this.random = secureRandom;
    }

    private static boolean arrayContains(int[] iArr, int i) {
        for (int i2 : iArr) {
            if (i2 == i) {
                return true;
            }
        }
        return false;
    }

    private static boolean arrayContains(short[] sArr, short s) {
        for (short s2 : sArr) {
            if (s2 == s) {
                return true;
            }
        }
        return false;
    }

    private static byte[] createRenegotiationInfo(byte[] bArr) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        TlsUtils.writeOpaque8(bArr, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    private static SecureRandom createSecureRandom() {
        ThreadedSeedGenerator threadedSeedGenerator = new ThreadedSeedGenerator();
        SecureRandom secureRandom = new SecureRandom();
        secureRandom.setSeed(threadedSeedGenerator.generateSeed(20, true));
        return secureRandom;
    }

    private void failWithError(short s, short s2) throws IOException {
        if (!this.closed) {
            this.closed = true;
            if (s == 2) {
                this.failedWithError = true;
            }
            sendAlert(s, s2);
            this.rs.close();
            if (s == 2) {
                throw new IOException(TLS_ERROR_MESSAGE);
            }
            return;
        }
        throw new IOException(TLS_ERROR_MESSAGE);
    }

    private void processAlert() throws IOException {
        while (this.alertQueue.size() >= 2) {
            byte[] bArr = new byte[2];
            this.alertQueue.read(bArr, 0, 2, 0);
            this.alertQueue.removeData(2);
            short s = (short) bArr[0];
            short s2 = (short) bArr[1];
            if (s == 2) {
                this.failedWithError = true;
                this.closed = true;
                try {
                    this.rs.close();
                } catch (Exception unused) {
                }
                throw new IOException(TLS_ERROR_MESSAGE);
            } else if (s2 == 0) {
                failWithError(1, 0);
            }
        }
    }

    private void processApplicationData() {
    }

    private void processChangeCipherSpec() throws IOException {
        while (this.changeCipherSpecQueue.size() > 0) {
            byte[] bArr = new byte[1];
            this.changeCipherSpecQueue.read(bArr, 0, 1, 0);
            this.changeCipherSpecQueue.removeData(1);
            if (bArr[0] != 1) {
                failWithError(2, 10);
            }
            if (this.connection_state != 10) {
                failWithError(2, 40);
            }
            this.rs.serverClientSpecReceived();
            this.connection_state = 11;
        }
    }

    private void processHandshake() throws IOException {
        boolean z;
        do {
            z = false;
            if (this.handshakeQueue.size() >= 4) {
                byte[] bArr = new byte[4];
                this.handshakeQueue.read(bArr, 0, 4, 0);
                ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
                short readUint8 = TlsUtils.readUint8(byteArrayInputStream);
                int readUint24 = TlsUtils.readUint24(byteArrayInputStream);
                int i = readUint24 + 4;
                if (this.handshakeQueue.size() >= i) {
                    byte[] bArr2 = new byte[readUint24];
                    this.handshakeQueue.read(bArr2, 0, readUint24, 4);
                    this.handshakeQueue.removeData(i);
                    if (!(readUint8 == 0 || readUint8 == 20)) {
                        this.rs.updateHandshakeData(bArr, 0, 4);
                        this.rs.updateHandshakeData(bArr2, 0, readUint24);
                    }
                    processHandshakeMessage(readUint8, bArr2);
                    z = true;
                    continue;
                } else {
                    continue;
                }
            }
        } while (z);
    }

    private void processHandshakeMessage(short s, byte[] bArr) throws IOException {
        Certificate certificate;
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        if (s != 0) {
            if (s != 2) {
                if (s != 20) {
                    TlsCredentials tlsCredentials = null;
                    switch (s) {
                        case 11:
                            if (this.connection_state != 2) {
                                failWithError(2, 10);
                            } else {
                                Certificate parse = Certificate.parse(byteArrayInputStream);
                                assertEmpty(byteArrayInputStream);
                                this.keyExchange.processServerCertificate(parse);
                                TlsAuthentication authentication2 = this.tlsClient.getAuthentication();
                                this.authentication = authentication2;
                                authentication2.notifyServerCertificate(parse);
                            }
                            this.connection_state = 3;
                            return;
                        case 12:
                            short s2 = this.connection_state;
                            if (s2 == 2) {
                                this.keyExchange.skipServerCertificate();
                                this.authentication = null;
                            } else if (s2 != 3) {
                                failWithError(2, 10);
                                this.connection_state = 4;
                                return;
                            }
                            this.keyExchange.processServerKeyExchange(byteArrayInputStream);
                            assertEmpty(byteArrayInputStream);
                            this.connection_state = 4;
                            return;
                        case 13:
                            short s3 = this.connection_state;
                            if (s3 == 3) {
                                this.keyExchange.skipServerKeyExchange();
                            } else if (s3 != 4) {
                                failWithError(2, 10);
                                this.connection_state = CS_CERTIFICATE_REQUEST_RECEIVED;
                                return;
                            }
                            if (this.authentication == null) {
                                failWithError(2, 40);
                            }
                            int readUint8 = TlsUtils.readUint8(byteArrayInputStream);
                            short[] sArr = new short[readUint8];
                            for (int i = 0; i < readUint8; i++) {
                                sArr[i] = TlsUtils.readUint8(byteArrayInputStream);
                            }
                            byte[] readOpaque16 = TlsUtils.readOpaque16(byteArrayInputStream);
                            assertEmpty(byteArrayInputStream);
                            Vector vector = new Vector();
                            ByteArrayInputStream byteArrayInputStream2 = new ByteArrayInputStream(readOpaque16);
                            while (byteArrayInputStream2.available() > 0) {
                                vector.addElement(X500Name.getInstance(ASN1Object.fromByteArray(TlsUtils.readOpaque16(byteArrayInputStream2))));
                            }
                            CertificateRequest certificateRequest2 = new CertificateRequest(sArr, vector);
                            this.certificateRequest = certificateRequest2;
                            this.keyExchange.validateCertificateRequest(certificateRequest2);
                            this.connection_state = CS_CERTIFICATE_REQUEST_RECEIVED;
                            return;
                        case 14:
                            short s4 = this.connection_state;
                            if (s4 == 3) {
                                this.keyExchange.skipServerKeyExchange();
                            } else if (!(s4 == 4 || s4 == 5)) {
                                failWithError(2, 40);
                                return;
                            }
                            assertEmpty(byteArrayInputStream);
                            this.connection_state = CS_SERVER_HELLO_DONE_RECEIVED;
                            CertificateRequest certificateRequest3 = this.certificateRequest;
                            if (certificateRequest3 == null) {
                                this.keyExchange.skipClientCredentials();
                            } else {
                                tlsCredentials = this.authentication.getClientCredentials(certificateRequest3);
                                TlsKeyExchange tlsKeyExchange = this.keyExchange;
                                if (tlsCredentials == null) {
                                    tlsKeyExchange.skipClientCredentials();
                                    certificate = Certificate.EMPTY_CHAIN;
                                } else {
                                    tlsKeyExchange.processClientCredentials(tlsCredentials);
                                    certificate = tlsCredentials.getCertificate();
                                }
                                sendClientCertificate(certificate);
                            }
                            sendClientKeyExchange();
                            this.connection_state = CS_CLIENT_KEY_EXCHANGE_SEND;
                            if (tlsCredentials != null && (tlsCredentials instanceof TlsSignerCredentials)) {
                                sendCertificateVerify(((TlsSignerCredentials) tlsCredentials).generateCertificateSignature(this.rs.getCurrentHash()));
                                this.connection_state = CS_CERTIFICATE_VERIFY_SEND;
                            }
                            this.rs.writeMessage(20, new byte[]{1}, 0, 1);
                            this.connection_state = CS_CLIENT_CHANGE_CIPHER_SPEC_SEND;
                            byte[] generatePremasterSecret = this.keyExchange.generatePremasterSecret();
                            SecurityParameters securityParameters2 = this.securityParameters;
                            securityParameters2.masterSecret = TlsUtils.PRF(generatePremasterSecret, "master secret", TlsUtils.concat(securityParameters2.clientRandom, this.securityParameters.serverRandom), 48);
                            Arrays.fill(generatePremasterSecret, (byte) 0);
                            this.rs.clientCipherSpecDecided(this.tlsClient.getCompression(), this.tlsClient.getCipher());
                            byte[] PRF = TlsUtils.PRF(this.securityParameters.masterSecret, "client finished", this.rs.getCurrentHash(), 12);
                            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                            TlsUtils.writeUint8(20, byteArrayOutputStream);
                            TlsUtils.writeOpaque24(PRF, byteArrayOutputStream);
                            byte[] byteArray = byteArrayOutputStream.toByteArray();
                            this.rs.writeMessage(22, byteArray, 0, byteArray.length);
                            this.connection_state = 10;
                            return;
                    }
                } else if (this.connection_state == 11) {
                    byte[] bArr2 = new byte[12];
                    TlsUtils.readFully(bArr2, byteArrayInputStream);
                    assertEmpty(byteArrayInputStream);
                    if (!Arrays.constantTimeAreEqual(TlsUtils.PRF(this.securityParameters.masterSecret, "server finished", this.rs.getCurrentHash(), 12), bArr2)) {
                        failWithError(2, 40);
                    }
                    this.connection_state = 12;
                    this.appDataReady = true;
                    return;
                }
            } else if (this.connection_state == 1) {
                TlsUtils.checkVersion(byteArrayInputStream, this);
                this.securityParameters.serverRandom = new byte[32];
                TlsUtils.readFully(this.securityParameters.serverRandom, byteArrayInputStream);
                byte[] readOpaque8 = TlsUtils.readOpaque8(byteArrayInputStream);
                if (readOpaque8.length > 32) {
                    failWithError(2, 47);
                }
                this.tlsClient.notifySessionID(readOpaque8);
                int readUint16 = TlsUtils.readUint16(byteArrayInputStream);
                if (!arrayContains(this.offeredCipherSuites, readUint16) || readUint16 == 255) {
                    failWithError(2, 47);
                }
                this.tlsClient.notifySelectedCipherSuite(readUint16);
                short readUint82 = TlsUtils.readUint8(byteArrayInputStream);
                if (!arrayContains(this.offeredCompressionMethods, readUint82)) {
                    failWithError(2, 47);
                }
                this.tlsClient.notifySelectedCompressionMethod(readUint82);
                Hashtable hashtable = new Hashtable();
                if (byteArrayInputStream.available() > 0) {
                    ByteArrayInputStream byteArrayInputStream3 = new ByteArrayInputStream(TlsUtils.readOpaque16(byteArrayInputStream));
                    while (byteArrayInputStream3.available() > 0) {
                        Integer num = new Integer(TlsUtils.readUint16(byteArrayInputStream3));
                        byte[] readOpaque162 = TlsUtils.readOpaque16(byteArrayInputStream3);
                        if (!num.equals(EXT_RenegotiationInfo) && this.clientExtensions.get(num) == null) {
                            failWithError(2, AlertDescription.unsupported_extension);
                        }
                        if (hashtable.containsKey(num)) {
                            failWithError(2, 47);
                        }
                        hashtable.put(num, readOpaque162);
                    }
                }
                assertEmpty(byteArrayInputStream);
                Integer num2 = EXT_RenegotiationInfo;
                boolean containsKey = hashtable.containsKey(num2);
                if (containsKey && !Arrays.constantTimeAreEqual((byte[]) hashtable.get(num2), createRenegotiationInfo(emptybuf))) {
                    failWithError(2, 40);
                }
                this.tlsClient.notifySecureRenegotiation(containsKey);
                if (this.clientExtensions != null) {
                    this.tlsClient.processServerExtensions(hashtable);
                }
                this.keyExchange = this.tlsClient.getKeyExchange();
                this.connection_state = 2;
                return;
            }
            failWithError(2, 10);
        } else if (this.connection_state == 12) {
            sendAlert(1, 100);
        }
    }

    private void safeReadData() throws IOException {
        try {
            this.rs.readData();
        } catch (TlsFatalAlert e) {
            if (!this.closed) {
                failWithError(2, e.getAlertDescription());
            }
            throw e;
        } catch (IOException e2) {
            if (!this.closed) {
                failWithError(2, 80);
            }
            throw e2;
        } catch (RuntimeException e3) {
            if (!this.closed) {
                failWithError(2, 80);
            }
            throw e3;
        }
    }

    private void safeWriteMessage(short s, byte[] bArr, int i, int i2) throws IOException {
        try {
            this.rs.writeMessage(s, bArr, i, i2);
        } catch (TlsFatalAlert e) {
            if (!this.closed) {
                failWithError(2, e.getAlertDescription());
            }
            throw e;
        } catch (IOException e2) {
            if (!this.closed) {
                failWithError(2, 80);
            }
            throw e2;
        } catch (RuntimeException e3) {
            if (!this.closed) {
                failWithError(2, 80);
            }
            throw e3;
        }
    }

    private void sendAlert(short s, short s2) throws IOException {
        this.rs.writeMessage(21, new byte[]{(byte) s, (byte) s2}, 0, 2);
    }

    private void sendCertificateVerify(byte[] bArr) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        TlsUtils.writeUint8(15, byteArrayOutputStream);
        TlsUtils.writeUint24(bArr.length + 2, byteArrayOutputStream);
        TlsUtils.writeOpaque16(bArr, byteArrayOutputStream);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        this.rs.writeMessage(22, byteArray, 0, byteArray.length);
    }

    private void sendClientCertificate(Certificate certificate) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        TlsUtils.writeUint8(11, byteArrayOutputStream);
        certificate.encode(byteArrayOutputStream);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        this.rs.writeMessage(22, byteArray, 0, byteArray.length);
    }

    private void sendClientKeyExchange() throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        TlsUtils.writeUint8(16, byteArrayOutputStream);
        this.keyExchange.generateClientKeyExchange(byteArrayOutputStream);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        this.rs.writeMessage(22, byteArray, 0, byteArray.length);
    }

    private static void writeExtension(OutputStream outputStream, Integer num, byte[] bArr) throws IOException {
        TlsUtils.writeUint16(num.intValue(), outputStream);
        TlsUtils.writeOpaque16(bArr, outputStream);
    }

    /* access modifiers changed from: protected */
    public void assertEmpty(ByteArrayInputStream byteArrayInputStream) throws IOException {
        if (byteArrayInputStream.available() > 0) {
            throw new TlsFatalAlert(50);
        }
    }

    public void close() throws IOException {
        if (!this.closed) {
            failWithError(1, 0);
        }
    }

    public void connect(CertificateVerifyer certificateVerifyer) throws IOException {
        connect(new LegacyTlsClient(certificateVerifyer));
    }

    public void connect(TlsClient tlsClient2) throws IOException {
        if (tlsClient2 == null) {
            throw new IllegalArgumentException("'tlsClient' cannot be null");
        } else if (this.tlsClient == null) {
            SecurityParameters securityParameters2 = new SecurityParameters();
            this.securityParameters = securityParameters2;
            securityParameters2.clientRandom = new byte[32];
            this.random.nextBytes(this.securityParameters.clientRandom);
            TlsUtils.writeGMTUnixTime(this.securityParameters.clientRandom, 0);
            TlsClientContextImpl tlsClientContextImpl = new TlsClientContextImpl(this.random, this.securityParameters);
            this.tlsClientContext = tlsClientContextImpl;
            this.tlsClient = tlsClient2;
            tlsClient2.init(tlsClientContextImpl);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            TlsUtils.writeVersion(byteArrayOutputStream);
            byteArrayOutputStream.write(this.securityParameters.clientRandom);
            TlsUtils.writeUint8(0, byteArrayOutputStream);
            this.offeredCipherSuites = this.tlsClient.getCipherSuites();
            Hashtable clientExtensions2 = this.tlsClient.getClientExtensions();
            this.clientExtensions = clientExtensions2;
            boolean z = clientExtensions2 == null || clientExtensions2.get(EXT_RenegotiationInfo) == null;
            int length = this.offeredCipherSuites.length;
            if (z) {
                length++;
            }
            TlsUtils.writeUint16(length * 2, byteArrayOutputStream);
            TlsUtils.writeUint16Array(this.offeredCipherSuites, byteArrayOutputStream);
            if (z) {
                TlsUtils.writeUint16(255, byteArrayOutputStream);
            }
            short[] compressionMethods = this.tlsClient.getCompressionMethods();
            this.offeredCompressionMethods = compressionMethods;
            TlsUtils.writeUint8((short) compressionMethods.length, byteArrayOutputStream);
            TlsUtils.writeUint8Array(this.offeredCompressionMethods, byteArrayOutputStream);
            if (this.clientExtensions != null) {
                ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                Enumeration keys = this.clientExtensions.keys();
                while (keys.hasMoreElements()) {
                    Integer num = (Integer) keys.nextElement();
                    writeExtension(byteArrayOutputStream2, num, (byte[]) this.clientExtensions.get(num));
                }
                TlsUtils.writeOpaque16(byteArrayOutputStream2.toByteArray(), byteArrayOutputStream);
            }
            ByteArrayOutputStream byteArrayOutputStream3 = new ByteArrayOutputStream();
            TlsUtils.writeUint8(1, byteArrayOutputStream3);
            TlsUtils.writeUint24(byteArrayOutputStream.size(), byteArrayOutputStream3);
            byteArrayOutputStream3.write(byteArrayOutputStream.toByteArray());
            byte[] byteArray = byteArrayOutputStream3.toByteArray();
            safeWriteMessage(22, byteArray, 0, byteArray.length);
            this.connection_state = 1;
            while (this.connection_state != 12) {
                safeReadData();
            }
            this.tlsInputStream = new TlsInputStream(this);
            this.tlsOutputStream = new TlsOutputStream(this);
        } else {
            throw new IllegalStateException("connect can only be called once");
        }
    }

    /* access modifiers changed from: protected */
    public void flush() throws IOException {
        this.rs.flush();
    }

    public InputStream getInputStream() {
        return this.tlsInputStream;
    }

    public OutputStream getOutputStream() {
        return this.tlsOutputStream;
    }

    /* access modifiers changed from: protected */
    public void processData(short s, byte[] bArr, int i, int i2) throws IOException {
        switch (s) {
            case 20:
                this.changeCipherSpecQueue.addData(bArr, i, i2);
                processChangeCipherSpec();
                return;
            case 21:
                this.alertQueue.addData(bArr, i, i2);
                processAlert();
                return;
            case 22:
                this.handshakeQueue.addData(bArr, i, i2);
                processHandshake();
                return;
            case 23:
                if (!this.appDataReady) {
                    failWithError(2, 10);
                }
                this.applicationDataQueue.addData(bArr, i, i2);
                processApplicationData();
                return;
            default:
                return;
        }
    }

    /* access modifiers changed from: protected */
    public int readApplicationData(byte[] bArr, int i, int i2) throws IOException {
        while (this.applicationDataQueue.size() == 0) {
            if (!this.closed) {
                safeReadData();
            } else if (!this.failedWithError) {
                return -1;
            } else {
                throw new IOException(TLS_ERROR_MESSAGE);
            }
        }
        int min = Math.min(i2, this.applicationDataQueue.size());
        this.applicationDataQueue.read(bArr, i, min, 0);
        this.applicationDataQueue.removeData(min);
        return min;
    }

    /* access modifiers changed from: protected */
    public void writeData(byte[] bArr, int i, int i2) throws IOException {
        if (!this.closed) {
            safeWriteMessage(23, emptybuf, 0, 0);
            do {
                int min = Math.min(i2, 16384);
                safeWriteMessage(23, bArr, i, min);
                i += min;
                i2 -= min;
            } while (i2 > 0);
        } else if (this.failedWithError) {
            throw new IOException(TLS_ERROR_MESSAGE);
        } else {
            throw new IOException("Sorry, connection has been closed, you cannot write more data");
        }
    }
}
