package org.bouncycastle.asn1.crmf;

import java.util.Enumeration;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERObject;
import org.bouncycastle.asn1.DERSequence;

public class CertReqMsg extends ASN1Encodable {
    private CertRequest certReq;
    private ProofOfPossession popo;
    private ASN1Sequence regInfo;

    private CertReqMsg(ASN1Sequence aSN1Sequence) {
        Enumeration objects = aSN1Sequence.getObjects();
        this.certReq = CertRequest.getInstance(objects.nextElement());
        while (objects.hasMoreElements()) {
            Object nextElement = objects.nextElement();
            if ((nextElement instanceof ASN1TaggedObject) || (nextElement instanceof ProofOfPossession)) {
                this.popo = ProofOfPossession.getInstance(nextElement);
            } else {
                this.regInfo = ASN1Sequence.getInstance(nextElement);
            }
        }
    }

    public CertReqMsg(CertRequest certRequest, ProofOfPossession proofOfPossession, AttributeTypeAndValue[] attributeTypeAndValueArr) {
        if (certRequest != null) {
            this.certReq = certRequest;
            this.popo = proofOfPossession;
            if (attributeTypeAndValueArr != null) {
                this.regInfo = new DERSequence(attributeTypeAndValueArr);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("'certReq' cannot be null");
    }

    private void addOptional(ASN1EncodableVector aSN1EncodableVector, ASN1Encodable aSN1Encodable) {
        if (aSN1Encodable != null) {
            aSN1EncodableVector.add(aSN1Encodable);
        }
    }

    public static CertReqMsg getInstance(Object obj) {
        if (obj instanceof CertReqMsg) {
            return (CertReqMsg) obj;
        }
        if (obj != null) {
            return new CertReqMsg(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public CertRequest getCertReq() {
        return this.certReq;
    }

    public ProofOfPossession getPop() {
        return this.popo;
    }

    public ProofOfPossession getPopo() {
        return this.popo;
    }

    public AttributeTypeAndValue[] getRegInfo() {
        ASN1Sequence aSN1Sequence = this.regInfo;
        if (aSN1Sequence == null) {
            return null;
        }
        int size = aSN1Sequence.size();
        AttributeTypeAndValue[] attributeTypeAndValueArr = new AttributeTypeAndValue[size];
        for (int i = 0; i != size; i++) {
            attributeTypeAndValueArr[i] = AttributeTypeAndValue.getInstance(this.regInfo.getObjectAt(i));
        }
        return attributeTypeAndValueArr;
    }

    @Override // org.bouncycastle.asn1.ASN1Encodable
    public DERObject toASN1Object() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(this.certReq);
        addOptional(aSN1EncodableVector, this.popo);
        addOptional(aSN1EncodableVector, this.regInfo);
        return new DERSequence(aSN1EncodableVector);
    }
}
