package org.bouncycastle.asn1.cms;

import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1Set;
import org.bouncycastle.asn1.BERSequence;
import org.bouncycastle.asn1.BERTaggedObject;
import org.bouncycastle.asn1.DERInteger;
import org.bouncycastle.asn1.DERObject;

public class EncryptedData extends ASN1Encodable {
    private EncryptedContentInfo encryptedContentInfo;
    private ASN1Set unprotectedAttrs;
    private DERInteger version;

    private EncryptedData(ASN1Sequence aSN1Sequence) {
        this.version = DERInteger.getInstance(aSN1Sequence.getObjectAt(0));
        this.encryptedContentInfo = EncryptedContentInfo.getInstance(aSN1Sequence.getObjectAt(1));
        if (aSN1Sequence.size() == 3) {
            this.unprotectedAttrs = ASN1Set.getInstance(aSN1Sequence.getObjectAt(2));
        }
    }

    public EncryptedData(EncryptedContentInfo encryptedContentInfo2) {
        this(encryptedContentInfo2, null);
    }

    public EncryptedData(EncryptedContentInfo encryptedContentInfo2, ASN1Set aSN1Set) {
        this.version = new DERInteger(aSN1Set == null ? 0 : 2);
        this.encryptedContentInfo = encryptedContentInfo2;
        this.unprotectedAttrs = aSN1Set;
    }

    public static EncryptedData getInstance(Object obj) {
        if (obj instanceof EncryptedData) {
            return (EncryptedData) obj;
        }
        if (obj instanceof ASN1Sequence) {
            return new EncryptedData((ASN1Sequence) obj);
        }
        throw new IllegalArgumentException("Invalid EncryptedData: " + obj.getClass().getName());
    }

    public EncryptedContentInfo getEncryptedContentInfo() {
        return this.encryptedContentInfo;
    }

    public ASN1Set getUnprotectedAttrs() {
        return this.unprotectedAttrs;
    }

    public DERInteger getVersion() {
        return this.version;
    }

    @Override // org.bouncycastle.asn1.ASN1Encodable
    public DERObject toASN1Object() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(this.version);
        aSN1EncodableVector.add(this.encryptedContentInfo);
        if (this.unprotectedAttrs != null) {
            aSN1EncodableVector.add(new BERTaggedObject(false, 1, this.unprotectedAttrs));
        }
        return new BERSequence(aSN1EncodableVector);
    }
}
