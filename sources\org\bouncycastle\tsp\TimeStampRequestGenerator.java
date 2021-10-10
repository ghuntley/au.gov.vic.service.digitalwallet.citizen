package org.bouncycastle.tsp;

import java.io.IOException;
import java.math.BigInteger;
import java.util.Hashtable;
import java.util.Vector;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.DERBoolean;
import org.bouncycastle.asn1.DERInteger;
import org.bouncycastle.asn1.DERNull;
import org.bouncycastle.asn1.DERObjectIdentifier;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.tsp.MessageImprint;
import org.bouncycastle.asn1.tsp.TimeStampReq;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.asn1.x509.X509Extension;
import org.bouncycastle.asn1.x509.X509Extensions;

public class TimeStampRequestGenerator {
    private DERBoolean certReq;
    private Vector extOrdering = new Vector();
    private Hashtable extensions = new Hashtable();
    private DERObjectIdentifier reqPolicy;

    public void addExtension(String str, boolean z, ASN1Encodable aSN1Encodable) throws IOException {
        addExtension(str, z, aSN1Encodable.getEncoded());
    }

    public void addExtension(String str, boolean z, byte[] bArr) {
        DERObjectIdentifier dERObjectIdentifier = new DERObjectIdentifier(str);
        this.extensions.put(dERObjectIdentifier, new X509Extension(z, new DEROctetString(bArr)));
        this.extOrdering.addElement(dERObjectIdentifier);
    }

    public void addExtension(ASN1ObjectIdentifier aSN1ObjectIdentifier, boolean z, ASN1Encodable aSN1Encodable) throws IOException {
        addExtension(aSN1ObjectIdentifier, z, aSN1Encodable.getEncoded());
    }

    public void addExtension(ASN1ObjectIdentifier aSN1ObjectIdentifier, boolean z, byte[] bArr) {
        this.extensions.put(aSN1ObjectIdentifier, new X509Extension(z, new DEROctetString(bArr)));
        this.extOrdering.addElement(aSN1ObjectIdentifier);
    }

    public TimeStampRequest generate(String str, byte[] bArr) {
        return generate(str, bArr, (BigInteger) null);
    }

    public TimeStampRequest generate(String str, byte[] bArr, BigInteger bigInteger) {
        TimeStampRequest timeStampRequest;
        if (str != null) {
            MessageImprint messageImprint = new MessageImprint(new AlgorithmIdentifier(new DERObjectIdentifier(str), new DERNull()), bArr);
            X509Extensions x509Extensions = null;
            if (this.extOrdering.size() != 0) {
                x509Extensions = new X509Extensions(this.extOrdering, this.extensions);
            }
            DERObjectIdentifier dERObjectIdentifier = this.reqPolicy;
            if (bigInteger != null) {
                new DERInteger(bigInteger);
                DERBoolean dERBoolean = this.certReq;
                return timeStampRequest;
            }
            timeStampRequest = new TimeStampRequest(new TimeStampReq(messageImprint, dERObjectIdentifier, null, this.certReq, x509Extensions));
            return timeStampRequest;
        }
        throw new IllegalArgumentException("No digest algorithm specified");
    }

    public TimeStampRequest generate(ASN1ObjectIdentifier aSN1ObjectIdentifier, byte[] bArr, BigInteger bigInteger) {
        return generate(aSN1ObjectIdentifier.getId(), bArr, bigInteger);
    }

    public void setCertReq(boolean z) {
        this.certReq = new DERBoolean(z);
    }

    public void setReqPolicy(String str) {
        this.reqPolicy = new DERObjectIdentifier(str);
    }
}
