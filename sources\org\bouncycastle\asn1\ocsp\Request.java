package org.bouncycastle.asn1.ocsp;

import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERObject;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERTaggedObject;
import org.bouncycastle.asn1.x509.X509Extensions;

public class Request extends ASN1Encodable {
    CertID reqCert;
    X509Extensions singleRequestExtensions;

    public Request(ASN1Sequence aSN1Sequence) {
        this.reqCert = CertID.getInstance(aSN1Sequence.getObjectAt(0));
        if (aSN1Sequence.size() == 2) {
            this.singleRequestExtensions = X509Extensions.getInstance((ASN1TaggedObject) aSN1Sequence.getObjectAt(1), true);
        }
    }

    public Request(CertID certID, X509Extensions x509Extensions) {
        this.reqCert = certID;
        this.singleRequestExtensions = x509Extensions;
    }

    public static Request getInstance(Object obj) {
        if (obj == null || (obj instanceof Request)) {
            return (Request) obj;
        }
        if (obj instanceof ASN1Sequence) {
            return new Request((ASN1Sequence) obj);
        }
        throw new IllegalArgumentException("unknown object in factory: " + obj.getClass().getName());
    }

    public static Request getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return getInstance(ASN1Sequence.getInstance(aSN1TaggedObject, z));
    }

    public CertID getReqCert() {
        return this.reqCert;
    }

    public X509Extensions getSingleRequestExtensions() {
        return this.singleRequestExtensions;
    }

    @Override // org.bouncycastle.asn1.ASN1Encodable
    public DERObject toASN1Object() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(this.reqCert);
        if (this.singleRequestExtensions != null) {
            aSN1EncodableVector.add(new DERTaggedObject(true, 0, this.singleRequestExtensions));
        }
        return new DERSequence(aSN1EncodableVector);
    }
}
