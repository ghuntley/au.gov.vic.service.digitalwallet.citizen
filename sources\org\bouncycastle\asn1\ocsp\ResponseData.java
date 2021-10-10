package org.bouncycastle.asn1.ocsp;

import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERGeneralizedTime;
import org.bouncycastle.asn1.DERInteger;
import org.bouncycastle.asn1.DERObject;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERTaggedObject;
import org.bouncycastle.asn1.x509.X509Extensions;

public class ResponseData extends ASN1Encodable {
    private static final DERInteger V1 = new DERInteger(0);
    private DERGeneralizedTime producedAt;
    private ResponderID responderID;
    private X509Extensions responseExtensions;
    private ASN1Sequence responses;
    private DERInteger version;
    private boolean versionPresent;

    public ResponseData(ASN1Sequence aSN1Sequence) {
        int i = 0;
        if (!(aSN1Sequence.getObjectAt(0) instanceof ASN1TaggedObject) || ((ASN1TaggedObject) aSN1Sequence.getObjectAt(0)).getTagNo() != 0) {
            this.version = V1;
        } else {
            this.versionPresent = true;
            this.version = DERInteger.getInstance((ASN1TaggedObject) aSN1Sequence.getObjectAt(0), true);
            i = 1;
        }
        int i2 = i + 1;
        this.responderID = ResponderID.getInstance(aSN1Sequence.getObjectAt(i));
        int i3 = i2 + 1;
        this.producedAt = (DERGeneralizedTime) aSN1Sequence.getObjectAt(i2);
        int i4 = i3 + 1;
        this.responses = (ASN1Sequence) aSN1Sequence.getObjectAt(i3);
        if (aSN1Sequence.size() > i4) {
            this.responseExtensions = X509Extensions.getInstance((ASN1TaggedObject) aSN1Sequence.getObjectAt(i4), true);
        }
    }

    public ResponseData(DERInteger dERInteger, ResponderID responderID2, DERGeneralizedTime dERGeneralizedTime, ASN1Sequence aSN1Sequence, X509Extensions x509Extensions) {
        this.version = dERInteger;
        this.responderID = responderID2;
        this.producedAt = dERGeneralizedTime;
        this.responses = aSN1Sequence;
        this.responseExtensions = x509Extensions;
    }

    public ResponseData(ResponderID responderID2, DERGeneralizedTime dERGeneralizedTime, ASN1Sequence aSN1Sequence, X509Extensions x509Extensions) {
        this(V1, responderID2, dERGeneralizedTime, aSN1Sequence, x509Extensions);
    }

    public static ResponseData getInstance(Object obj) {
        if (obj == null || (obj instanceof ResponseData)) {
            return (ResponseData) obj;
        }
        if (obj instanceof ASN1Sequence) {
            return new ResponseData((ASN1Sequence) obj);
        }
        throw new IllegalArgumentException("unknown object in factory: " + obj.getClass().getName());
    }

    public static ResponseData getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return getInstance(ASN1Sequence.getInstance(aSN1TaggedObject, z));
    }

    public DERGeneralizedTime getProducedAt() {
        return this.producedAt;
    }

    public ResponderID getResponderID() {
        return this.responderID;
    }

    public X509Extensions getResponseExtensions() {
        return this.responseExtensions;
    }

    public ASN1Sequence getResponses() {
        return this.responses;
    }

    public DERInteger getVersion() {
        return this.version;
    }

    @Override // org.bouncycastle.asn1.ASN1Encodable
    public DERObject toASN1Object() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        if (this.versionPresent || !this.version.equals(V1)) {
            aSN1EncodableVector.add(new DERTaggedObject(true, 0, this.version));
        }
        aSN1EncodableVector.add(this.responderID);
        aSN1EncodableVector.add(this.producedAt);
        aSN1EncodableVector.add(this.responses);
        if (this.responseExtensions != null) {
            aSN1EncodableVector.add(new DERTaggedObject(true, 1, this.responseExtensions));
        }
        return new DERSequence(aSN1EncodableVector);
    }
}
