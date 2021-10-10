package org.bouncycastle.asn1.x509;

import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERObject;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERTaggedObject;

public class Holder extends ASN1Encodable {
    IssuerSerial baseCertificateID;
    GeneralNames entityName;
    ObjectDigestInfo objectDigestInfo;
    private int version = 1;

    public Holder(ASN1Sequence aSN1Sequence) {
        if (aSN1Sequence.size() <= 3) {
            for (int i = 0; i != aSN1Sequence.size(); i++) {
                ASN1TaggedObject instance = ASN1TaggedObject.getInstance(aSN1Sequence.getObjectAt(i));
                int tagNo = instance.getTagNo();
                if (tagNo == 0) {
                    this.baseCertificateID = IssuerSerial.getInstance(instance, false);
                } else if (tagNo == 1) {
                    this.entityName = GeneralNames.getInstance(instance, false);
                } else if (tagNo == 2) {
                    this.objectDigestInfo = ObjectDigestInfo.getInstance(instance, false);
                } else {
                    throw new IllegalArgumentException("unknown tag in Holder");
                }
            }
            this.version = 1;
            return;
        }
        throw new IllegalArgumentException("Bad sequence size: " + aSN1Sequence.size());
    }

    public Holder(ASN1TaggedObject aSN1TaggedObject) {
        int tagNo = aSN1TaggedObject.getTagNo();
        if (tagNo == 0) {
            this.baseCertificateID = IssuerSerial.getInstance(aSN1TaggedObject, false);
        } else if (tagNo == 1) {
            this.entityName = GeneralNames.getInstance(aSN1TaggedObject, false);
        } else {
            throw new IllegalArgumentException("unknown tag in Holder");
        }
        this.version = 0;
    }

    public Holder(GeneralNames generalNames) {
        this.entityName = generalNames;
    }

    public Holder(GeneralNames generalNames, int i) {
        this.entityName = generalNames;
        this.version = i;
    }

    public Holder(IssuerSerial issuerSerial) {
        this.baseCertificateID = issuerSerial;
    }

    public Holder(IssuerSerial issuerSerial, int i) {
        this.baseCertificateID = issuerSerial;
        this.version = i;
    }

    public Holder(ObjectDigestInfo objectDigestInfo2) {
        this.objectDigestInfo = objectDigestInfo2;
    }

    public static Holder getInstance(Object obj) {
        if (obj instanceof Holder) {
            return (Holder) obj;
        }
        if (obj instanceof ASN1Sequence) {
            return new Holder((ASN1Sequence) obj);
        }
        if (obj instanceof ASN1TaggedObject) {
            return new Holder((ASN1TaggedObject) obj);
        }
        throw new IllegalArgumentException("unknown object in factory: " + obj.getClass().getName());
    }

    public IssuerSerial getBaseCertificateID() {
        return this.baseCertificateID;
    }

    public GeneralNames getEntityName() {
        return this.entityName;
    }

    public ObjectDigestInfo getObjectDigestInfo() {
        return this.objectDigestInfo;
    }

    public int getVersion() {
        return this.version;
    }

    @Override // org.bouncycastle.asn1.ASN1Encodable
    public DERObject toASN1Object() {
        if (this.version != 1) {
            return this.entityName != null ? new DERTaggedObject(false, 1, this.entityName) : new DERTaggedObject(false, 0, this.baseCertificateID);
        }
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        if (this.baseCertificateID != null) {
            aSN1EncodableVector.add(new DERTaggedObject(false, 0, this.baseCertificateID));
        }
        if (this.entityName != null) {
            aSN1EncodableVector.add(new DERTaggedObject(false, 1, this.entityName));
        }
        if (this.objectDigestInfo != null) {
            aSN1EncodableVector.add(new DERTaggedObject(false, 2, this.objectDigestInfo));
        }
        return new DERSequence(aSN1EncodableVector);
    }
}
