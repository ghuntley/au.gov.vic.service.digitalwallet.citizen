package org.bouncycastle.asn1.crmf;

import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERInteger;
import org.bouncycastle.asn1.DERObject;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.x509.GeneralName;

public class SinglePubInfo extends ASN1Encodable {
    private GeneralName pubLocation;
    private DERInteger pubMethod;

    private SinglePubInfo(ASN1Sequence aSN1Sequence) {
        this.pubMethod = DERInteger.getInstance(aSN1Sequence.getObjectAt(0));
        if (aSN1Sequence.size() == 2) {
            this.pubLocation = GeneralName.getInstance(aSN1Sequence.getObjectAt(1));
        }
    }

    public static SinglePubInfo getInstance(Object obj) {
        if (obj instanceof SinglePubInfo) {
            return (SinglePubInfo) obj;
        }
        if (obj instanceof ASN1Sequence) {
            return new SinglePubInfo((ASN1Sequence) obj);
        }
        throw new IllegalArgumentException("Invalid object: " + obj.getClass().getName());
    }

    public GeneralName getPubLocation() {
        return this.pubLocation;
    }

    @Override // org.bouncycastle.asn1.ASN1Encodable
    public DERObject toASN1Object() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(this.pubMethod);
        GeneralName generalName = this.pubLocation;
        if (generalName != null) {
            aSN1EncodableVector.add(generalName);
        }
        return new DERSequence(aSN1EncodableVector);
    }
}
