package org.bouncycastle.asn1.crmf;

import org.bouncycastle.asn1.ASN1Choice;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERBitString;
import org.bouncycastle.asn1.DERInteger;
import org.bouncycastle.asn1.DERObject;
import org.bouncycastle.asn1.DERTaggedObject;
import org.bouncycastle.asn1.cms.EnvelopedData;

public class POPOPrivKey extends ASN1Encodable implements ASN1Choice {
    public static final int agreeMAC = 3;
    public static final int dhMAC = 2;
    public static final int encryptedKey = 4;
    public static final int subsequentMessage = 1;
    public static final int thisMessage = 0;
    private ASN1Encodable obj;
    private int tagNo;

    private POPOPrivKey(ASN1TaggedObject aSN1TaggedObject) {
        ASN1Encodable aSN1Encodable;
        int tagNo2 = aSN1TaggedObject.getTagNo();
        this.tagNo = tagNo2;
        if (tagNo2 != 0) {
            if (tagNo2 == 1) {
                aSN1Encodable = SubsequentMessage.valueOf(DERInteger.getInstance(aSN1TaggedObject, false).getValue().intValue());
            } else if (tagNo2 != 2) {
                if (tagNo2 == 3) {
                    aSN1Encodable = PKMACValue.getInstance(aSN1TaggedObject, false);
                } else if (tagNo2 == 4) {
                    aSN1Encodable = EnvelopedData.getInstance(aSN1TaggedObject, false);
                } else {
                    throw new IllegalArgumentException("unknown tag in POPOPrivKey");
                }
            }
            this.obj = aSN1Encodable;
        }
        aSN1Encodable = DERBitString.getInstance(aSN1TaggedObject, false);
        this.obj = aSN1Encodable;
    }

    public POPOPrivKey(SubsequentMessage subsequentMessage2) {
        this.tagNo = 1;
        this.obj = subsequentMessage2;
    }

    public static POPOPrivKey getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return new POPOPrivKey(ASN1TaggedObject.getInstance(aSN1TaggedObject.getObject()));
    }

    public int getType() {
        return this.tagNo;
    }

    public ASN1Encodable getValue() {
        return this.obj;
    }

    @Override // org.bouncycastle.asn1.ASN1Encodable
    public DERObject toASN1Object() {
        return new DERTaggedObject(false, this.tagNo, this.obj);
    }
}
