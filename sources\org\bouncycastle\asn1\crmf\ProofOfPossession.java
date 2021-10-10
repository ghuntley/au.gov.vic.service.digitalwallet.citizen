package org.bouncycastle.asn1.crmf;

import org.bouncycastle.asn1.ASN1Choice;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERNull;
import org.bouncycastle.asn1.DERObject;
import org.bouncycastle.asn1.DERTaggedObject;

public class ProofOfPossession extends ASN1Encodable implements ASN1Choice {
    public static final int TYPE_KEY_AGREEMENT = 3;
    public static final int TYPE_KEY_ENCIPHERMENT = 2;
    public static final int TYPE_RA_VERIFIED = 0;
    public static final int TYPE_SIGNING_KEY = 1;
    private ASN1Encodable obj;
    private int tagNo;

    public ProofOfPossession() {
        this.tagNo = 0;
        this.obj = DERNull.INSTANCE;
    }

    public ProofOfPossession(int i, POPOPrivKey pOPOPrivKey) {
        this.tagNo = i;
        this.obj = pOPOPrivKey;
    }

    private ProofOfPossession(ASN1TaggedObject aSN1TaggedObject) {
        ASN1Encodable aSN1Encodable;
        int tagNo2 = aSN1TaggedObject.getTagNo();
        this.tagNo = tagNo2;
        if (tagNo2 == 0) {
            aSN1Encodable = DERNull.INSTANCE;
        } else if (tagNo2 == 1) {
            aSN1Encodable = POPOSigningKey.getInstance(aSN1TaggedObject, false);
        } else if (tagNo2 == 2 || tagNo2 == 3) {
            aSN1Encodable = POPOPrivKey.getInstance(aSN1TaggedObject, false);
        } else {
            throw new IllegalArgumentException("unknown tag: " + this.tagNo);
        }
        this.obj = aSN1Encodable;
    }

    public ProofOfPossession(POPOSigningKey pOPOSigningKey) {
        this.tagNo = 1;
        this.obj = pOPOSigningKey;
    }

    public static ProofOfPossession getInstance(Object obj2) {
        if (obj2 instanceof ProofOfPossession) {
            return (ProofOfPossession) obj2;
        }
        if (obj2 instanceof ASN1TaggedObject) {
            return new ProofOfPossession((ASN1TaggedObject) obj2);
        }
        throw new IllegalArgumentException("Invalid object: " + obj2.getClass().getName());
    }

    public ASN1Encodable getObject() {
        return this.obj;
    }

    public int getType() {
        return this.tagNo;
    }

    @Override // org.bouncycastle.asn1.ASN1Encodable
    public DERObject toASN1Object() {
        return new DERTaggedObject(false, this.tagNo, this.obj);
    }
}
