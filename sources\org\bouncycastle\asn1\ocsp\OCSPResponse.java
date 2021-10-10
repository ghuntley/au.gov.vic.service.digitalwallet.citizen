package org.bouncycastle.asn1.ocsp;

import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DEREnumerated;
import org.bouncycastle.asn1.DERObject;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERTaggedObject;

public class OCSPResponse extends ASN1Encodable {
    ResponseBytes responseBytes;
    OCSPResponseStatus responseStatus;

    public OCSPResponse(ASN1Sequence aSN1Sequence) {
        this.responseStatus = new OCSPResponseStatus(DEREnumerated.getInstance(aSN1Sequence.getObjectAt(0)));
        if (aSN1Sequence.size() == 2) {
            this.responseBytes = ResponseBytes.getInstance((ASN1TaggedObject) aSN1Sequence.getObjectAt(1), true);
        }
    }

    public OCSPResponse(OCSPResponseStatus oCSPResponseStatus, ResponseBytes responseBytes2) {
        this.responseStatus = oCSPResponseStatus;
        this.responseBytes = responseBytes2;
    }

    public static OCSPResponse getInstance(Object obj) {
        if (obj == null || (obj instanceof OCSPResponse)) {
            return (OCSPResponse) obj;
        }
        if (obj instanceof ASN1Sequence) {
            return new OCSPResponse((ASN1Sequence) obj);
        }
        throw new IllegalArgumentException("unknown object in factory: " + obj.getClass().getName());
    }

    public static OCSPResponse getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return getInstance(ASN1Sequence.getInstance(aSN1TaggedObject, z));
    }

    public ResponseBytes getResponseBytes() {
        return this.responseBytes;
    }

    public OCSPResponseStatus getResponseStatus() {
        return this.responseStatus;
    }

    @Override // org.bouncycastle.asn1.ASN1Encodable
    public DERObject toASN1Object() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(this.responseStatus);
        if (this.responseBytes != null) {
            aSN1EncodableVector.add(new DERTaggedObject(true, 0, this.responseBytes));
        }
        return new DERSequence(aSN1EncodableVector);
    }
}
