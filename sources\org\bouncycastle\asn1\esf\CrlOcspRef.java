package org.bouncycastle.asn1.esf;

import java.util.Enumeration;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERObject;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERTaggedObject;

public class CrlOcspRef extends ASN1Encodable {
    private CrlListID crlids;
    private OcspListID ocspids;
    private OtherRevRefs otherRev;

    private CrlOcspRef(ASN1Sequence aSN1Sequence) {
        Enumeration objects = aSN1Sequence.getObjects();
        while (objects.hasMoreElements()) {
            DERTaggedObject dERTaggedObject = (DERTaggedObject) objects.nextElement();
            int tagNo = dERTaggedObject.getTagNo();
            if (tagNo == 0) {
                this.crlids = CrlListID.getInstance(dERTaggedObject.getObject());
            } else if (tagNo == 1) {
                this.ocspids = OcspListID.getInstance(dERTaggedObject.getObject());
            } else if (tagNo == 2) {
                this.otherRev = OtherRevRefs.getInstance(dERTaggedObject.getObject());
            } else {
                throw new IllegalArgumentException("illegal tag");
            }
        }
    }

    public CrlOcspRef(CrlListID crlListID, OcspListID ocspListID, OtherRevRefs otherRevRefs) {
        this.crlids = crlListID;
        this.ocspids = ocspListID;
        this.otherRev = otherRevRefs;
    }

    public static CrlOcspRef getInstance(Object obj) {
        if (obj instanceof CrlOcspRef) {
            return (CrlOcspRef) obj;
        }
        if (obj != null) {
            return new CrlOcspRef(ASN1Sequence.getInstance(obj));
        }
        throw new IllegalArgumentException("null value in getInstance");
    }

    public CrlListID getCrlids() {
        return this.crlids;
    }

    public OcspListID getOcspids() {
        return this.ocspids;
    }

    public OtherRevRefs getOtherRev() {
        return this.otherRev;
    }

    @Override // org.bouncycastle.asn1.ASN1Encodable
    public DERObject toASN1Object() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        if (this.crlids != null) {
            aSN1EncodableVector.add(new DERTaggedObject(true, 0, this.crlids.toASN1Object()));
        }
        if (this.ocspids != null) {
            aSN1EncodableVector.add(new DERTaggedObject(true, 1, this.ocspids.toASN1Object()));
        }
        if (this.otherRev != null) {
            aSN1EncodableVector.add(new DERTaggedObject(true, 2, this.otherRev.toASN1Object()));
        }
        return new DERSequence(aSN1EncodableVector);
    }
}
