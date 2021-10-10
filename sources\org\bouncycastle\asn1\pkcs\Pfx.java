package org.bouncycastle.asn1.pkcs;

import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.BERSequence;
import org.bouncycastle.asn1.DERInteger;
import org.bouncycastle.asn1.DERObject;

public class Pfx extends ASN1Encodable implements PKCSObjectIdentifiers {
    private ContentInfo contentInfo;
    private MacData macData = null;

    public Pfx(ASN1Sequence aSN1Sequence) {
        if (((DERInteger) aSN1Sequence.getObjectAt(0)).getValue().intValue() == 3) {
            this.contentInfo = ContentInfo.getInstance(aSN1Sequence.getObjectAt(1));
            if (aSN1Sequence.size() == 3) {
                this.macData = MacData.getInstance(aSN1Sequence.getObjectAt(2));
                return;
            }
            return;
        }
        throw new IllegalArgumentException("wrong version for PFX PDU");
    }

    public Pfx(ContentInfo contentInfo2, MacData macData2) {
        this.contentInfo = contentInfo2;
        this.macData = macData2;
    }

    public ContentInfo getAuthSafe() {
        return this.contentInfo;
    }

    public MacData getMacData() {
        return this.macData;
    }

    @Override // org.bouncycastle.asn1.ASN1Encodable
    public DERObject toASN1Object() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(new DERInteger(3));
        aSN1EncodableVector.add(this.contentInfo);
        MacData macData2 = this.macData;
        if (macData2 != null) {
            aSN1EncodableVector.add(macData2);
        }
        return new BERSequence(aSN1EncodableVector);
    }
}
