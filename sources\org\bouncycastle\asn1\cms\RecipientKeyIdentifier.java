package org.bouncycastle.asn1.cms;

import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERGeneralizedTime;
import org.bouncycastle.asn1.DERObject;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.DERSequence;

public class RecipientKeyIdentifier extends ASN1Encodable {
    private DERGeneralizedTime date;
    private OtherKeyAttribute other;
    private ASN1OctetString subjectKeyIdentifier;

    public RecipientKeyIdentifier(ASN1OctetString aSN1OctetString, DERGeneralizedTime dERGeneralizedTime, OtherKeyAttribute otherKeyAttribute) {
        this.subjectKeyIdentifier = aSN1OctetString;
        this.date = dERGeneralizedTime;
        this.other = otherKeyAttribute;
    }

    public RecipientKeyIdentifier(ASN1Sequence aSN1Sequence) {
        this.subjectKeyIdentifier = ASN1OctetString.getInstance(aSN1Sequence.getObjectAt(0));
        int size = aSN1Sequence.size();
        if (size != 1) {
            if (size != 2) {
                if (size == 3) {
                    this.date = (DERGeneralizedTime) aSN1Sequence.getObjectAt(1);
                } else {
                    throw new IllegalArgumentException("Invalid RecipientKeyIdentifier");
                }
            } else if (aSN1Sequence.getObjectAt(1) instanceof DERGeneralizedTime) {
                this.date = (DERGeneralizedTime) aSN1Sequence.getObjectAt(1);
                return;
            }
            this.other = OtherKeyAttribute.getInstance(aSN1Sequence.getObjectAt(2));
        }
    }

    public RecipientKeyIdentifier(byte[] bArr) {
        this(bArr, (DERGeneralizedTime) null, (OtherKeyAttribute) null);
    }

    public RecipientKeyIdentifier(byte[] bArr, DERGeneralizedTime dERGeneralizedTime, OtherKeyAttribute otherKeyAttribute) {
        this.subjectKeyIdentifier = new DEROctetString(bArr);
        this.date = dERGeneralizedTime;
        this.other = otherKeyAttribute;
    }

    public static RecipientKeyIdentifier getInstance(Object obj) {
        if (obj == null || (obj instanceof RecipientKeyIdentifier)) {
            return (RecipientKeyIdentifier) obj;
        }
        if (obj instanceof ASN1Sequence) {
            return new RecipientKeyIdentifier((ASN1Sequence) obj);
        }
        throw new IllegalArgumentException("Invalid RecipientKeyIdentifier: " + obj.getClass().getName());
    }

    public static RecipientKeyIdentifier getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return getInstance(ASN1Sequence.getInstance(aSN1TaggedObject, z));
    }

    public DERGeneralizedTime getDate() {
        return this.date;
    }

    public OtherKeyAttribute getOtherKeyAttribute() {
        return this.other;
    }

    public ASN1OctetString getSubjectKeyIdentifier() {
        return this.subjectKeyIdentifier;
    }

    @Override // org.bouncycastle.asn1.ASN1Encodable
    public DERObject toASN1Object() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(this.subjectKeyIdentifier);
        DERGeneralizedTime dERGeneralizedTime = this.date;
        if (dERGeneralizedTime != null) {
            aSN1EncodableVector.add(dERGeneralizedTime);
        }
        OtherKeyAttribute otherKeyAttribute = this.other;
        if (otherKeyAttribute != null) {
            aSN1EncodableVector.add(otherKeyAttribute);
        }
        return new DERSequence(aSN1EncodableVector);
    }
}
