package org.bouncycastle.asn1.pkcs;

import java.util.Enumeration;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1Set;
import org.bouncycastle.asn1.BERSequence;
import org.bouncycastle.asn1.DERInteger;
import org.bouncycastle.asn1.DERObject;
import org.bouncycastle.asn1.DERTaggedObject;

public class SignedData extends ASN1Encodable implements PKCSObjectIdentifiers {
    private ASN1Set certificates;
    private ContentInfo contentInfo;
    private ASN1Set crls;
    private ASN1Set digestAlgorithms;
    private ASN1Set signerInfos;
    private DERInteger version;

    public SignedData(ASN1Sequence aSN1Sequence) {
        Enumeration objects = aSN1Sequence.getObjects();
        this.version = (DERInteger) objects.nextElement();
        this.digestAlgorithms = (ASN1Set) objects.nextElement();
        this.contentInfo = ContentInfo.getInstance(objects.nextElement());
        while (objects.hasMoreElements()) {
            DERObject dERObject = (DERObject) objects.nextElement();
            if (dERObject instanceof DERTaggedObject) {
                DERTaggedObject dERTaggedObject = (DERTaggedObject) dERObject;
                int tagNo = dERTaggedObject.getTagNo();
                if (tagNo == 0) {
                    this.certificates = ASN1Set.getInstance(dERTaggedObject, false);
                } else if (tagNo == 1) {
                    this.crls = ASN1Set.getInstance(dERTaggedObject, false);
                } else {
                    throw new IllegalArgumentException("unknown tag value " + dERTaggedObject.getTagNo());
                }
            } else {
                this.signerInfos = (ASN1Set) dERObject;
            }
        }
    }

    public SignedData(DERInteger dERInteger, ASN1Set aSN1Set, ContentInfo contentInfo2, ASN1Set aSN1Set2, ASN1Set aSN1Set3, ASN1Set aSN1Set4) {
        this.version = dERInteger;
        this.digestAlgorithms = aSN1Set;
        this.contentInfo = contentInfo2;
        this.certificates = aSN1Set2;
        this.crls = aSN1Set3;
        this.signerInfos = aSN1Set4;
    }

    public static SignedData getInstance(Object obj) {
        if (obj instanceof SignedData) {
            return (SignedData) obj;
        }
        if (obj instanceof ASN1Sequence) {
            return new SignedData((ASN1Sequence) obj);
        }
        throw new IllegalArgumentException("unknown object in factory: " + obj);
    }

    public ASN1Set getCRLs() {
        return this.crls;
    }

    public ASN1Set getCertificates() {
        return this.certificates;
    }

    public ContentInfo getContentInfo() {
        return this.contentInfo;
    }

    public ASN1Set getDigestAlgorithms() {
        return this.digestAlgorithms;
    }

    public ASN1Set getSignerInfos() {
        return this.signerInfos;
    }

    public DERInteger getVersion() {
        return this.version;
    }

    @Override // org.bouncycastle.asn1.ASN1Encodable
    public DERObject toASN1Object() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(this.version);
        aSN1EncodableVector.add(this.digestAlgorithms);
        aSN1EncodableVector.add(this.contentInfo);
        if (this.certificates != null) {
            aSN1EncodableVector.add(new DERTaggedObject(false, 0, this.certificates));
        }
        if (this.crls != null) {
            aSN1EncodableVector.add(new DERTaggedObject(false, 1, this.crls));
        }
        aSN1EncodableVector.add(this.signerInfos);
        return new BERSequence(aSN1EncodableVector);
    }
}
