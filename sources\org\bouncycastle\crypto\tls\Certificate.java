package org.bouncycastle.crypto.tls;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Vector;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1InputStream;
import org.bouncycastle.asn1.x509.X509CertificateStructure;

public class Certificate {
    public static final Certificate EMPTY_CHAIN = new Certificate(new X509CertificateStructure[0]);
    protected X509CertificateStructure[] certs;

    public Certificate(X509CertificateStructure[] x509CertificateStructureArr) {
        if (x509CertificateStructureArr != null) {
            this.certs = x509CertificateStructureArr;
            return;
        }
        throw new IllegalArgumentException("'certs' cannot be null");
    }

    protected static Certificate parse(InputStream inputStream) throws IOException {
        int readUint24 = TlsUtils.readUint24(inputStream);
        if (readUint24 == 0) {
            return EMPTY_CHAIN;
        }
        Vector vector = new Vector();
        while (readUint24 > 0) {
            int readUint242 = TlsUtils.readUint24(inputStream);
            readUint24 -= readUint242 + 3;
            byte[] bArr = new byte[readUint242];
            TlsUtils.readFully(bArr, inputStream);
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            vector.addElement(X509CertificateStructure.getInstance(new ASN1InputStream(byteArrayInputStream).readObject()));
            if (byteArrayInputStream.available() > 0) {
                throw new IllegalArgumentException("Sorry, there is garbage data left after the certificate");
            }
        }
        X509CertificateStructure[] x509CertificateStructureArr = new X509CertificateStructure[vector.size()];
        for (int i = 0; i < vector.size(); i++) {
            x509CertificateStructureArr[i] = (X509CertificateStructure) vector.elementAt(i);
        }
        return new Certificate(x509CertificateStructureArr);
    }

    /* access modifiers changed from: protected */
    public void encode(OutputStream outputStream) throws IOException {
        Vector vector = new Vector();
        int i = 0;
        int i2 = 0;
        while (true) {
            X509CertificateStructure[] x509CertificateStructureArr = this.certs;
            if (i >= x509CertificateStructureArr.length) {
                break;
            }
            byte[] encoded = x509CertificateStructureArr[i].getEncoded(ASN1Encodable.DER);
            vector.addElement(encoded);
            i2 += encoded.length + 3;
            i++;
        }
        TlsUtils.writeUint24(i2 + 3, outputStream);
        TlsUtils.writeUint24(i2, outputStream);
        for (int i3 = 0; i3 < vector.size(); i3++) {
            TlsUtils.writeOpaque24((byte[]) vector.elementAt(i3), outputStream);
        }
    }

    public X509CertificateStructure[] getCerts() {
        X509CertificateStructure[] x509CertificateStructureArr = this.certs;
        X509CertificateStructure[] x509CertificateStructureArr2 = new X509CertificateStructure[x509CertificateStructureArr.length];
        System.arraycopy(x509CertificateStructureArr, 0, x509CertificateStructureArr2, 0, x509CertificateStructureArr.length);
        return x509CertificateStructureArr2;
    }

    public boolean isEmpty() {
        return this.certs.length == 0;
    }
}
