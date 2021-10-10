package org.bouncycastle.asn1.cmp;

import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERGeneralizedTime;
import org.bouncycastle.asn1.DERInteger;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERTaggedObject;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.asn1.x509.GeneralName;

public class PKIHeaderBuilder {
    private PKIFreeText freeText;
    private ASN1Sequence generalInfo;
    private DERGeneralizedTime messageTime;
    private AlgorithmIdentifier protectionAlg;
    private DERInteger pvno;
    private ASN1OctetString recipKID;
    private ASN1OctetString recipNonce;
    private GeneralName recipient;
    private GeneralName sender;
    private ASN1OctetString senderKID;
    private ASN1OctetString senderNonce;
    private ASN1OctetString transactionID;

    public PKIHeaderBuilder(int i, GeneralName generalName, GeneralName generalName2) {
        this(new DERInteger(i), generalName, generalName2);
    }

    private PKIHeaderBuilder(DERInteger dERInteger, GeneralName generalName, GeneralName generalName2) {
        this.pvno = dERInteger;
        this.sender = generalName;
        this.recipient = generalName2;
    }

    private void addOptional(ASN1EncodableVector aSN1EncodableVector, int i, ASN1Encodable aSN1Encodable) {
        if (aSN1Encodable != null) {
            aSN1EncodableVector.add(new DERTaggedObject(true, i, aSN1Encodable));
        }
    }

    private static ASN1Sequence makeGeneralInfoSeq(InfoTypeAndValue infoTypeAndValue) {
        return new DERSequence(infoTypeAndValue);
    }

    private static ASN1Sequence makeGeneralInfoSeq(InfoTypeAndValue[] infoTypeAndValueArr) {
        if (infoTypeAndValueArr == null) {
            return null;
        }
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        for (InfoTypeAndValue infoTypeAndValue : infoTypeAndValueArr) {
            aSN1EncodableVector.add(infoTypeAndValue);
        }
        return new DERSequence(aSN1EncodableVector);
    }

    public PKIHeader build() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(this.pvno);
        aSN1EncodableVector.add(this.sender);
        aSN1EncodableVector.add(this.recipient);
        addOptional(aSN1EncodableVector, 0, this.messageTime);
        addOptional(aSN1EncodableVector, 1, this.protectionAlg);
        addOptional(aSN1EncodableVector, 2, this.senderKID);
        addOptional(aSN1EncodableVector, 3, this.recipKID);
        addOptional(aSN1EncodableVector, 4, this.transactionID);
        addOptional(aSN1EncodableVector, 5, this.senderNonce);
        addOptional(aSN1EncodableVector, 6, this.recipNonce);
        addOptional(aSN1EncodableVector, 7, this.freeText);
        addOptional(aSN1EncodableVector, 8, this.generalInfo);
        this.messageTime = null;
        this.protectionAlg = null;
        this.senderKID = null;
        this.recipKID = null;
        this.transactionID = null;
        this.senderNonce = null;
        this.recipNonce = null;
        this.freeText = null;
        this.generalInfo = null;
        return PKIHeader.getInstance(new DERSequence(aSN1EncodableVector));
    }

    public PKIHeaderBuilder setFreeText(PKIFreeText pKIFreeText) {
        this.freeText = pKIFreeText;
        return this;
    }

    public PKIHeaderBuilder setGeneralInfo(ASN1Sequence aSN1Sequence) {
        this.generalInfo = aSN1Sequence;
        return this;
    }

    public PKIHeaderBuilder setGeneralInfo(InfoTypeAndValue infoTypeAndValue) {
        return setGeneralInfo(makeGeneralInfoSeq(infoTypeAndValue));
    }

    public PKIHeaderBuilder setGeneralInfo(InfoTypeAndValue[] infoTypeAndValueArr) {
        return setGeneralInfo(makeGeneralInfoSeq(infoTypeAndValueArr));
    }

    public PKIHeaderBuilder setMessageTime(DERGeneralizedTime dERGeneralizedTime) {
        this.messageTime = dERGeneralizedTime;
        return this;
    }

    public PKIHeaderBuilder setProtectionAlg(AlgorithmIdentifier algorithmIdentifier) {
        this.protectionAlg = algorithmIdentifier;
        return this;
    }

    public PKIHeaderBuilder setRecipKID(DEROctetString dEROctetString) {
        this.recipKID = dEROctetString;
        return this;
    }

    public PKIHeaderBuilder setRecipKID(byte[] bArr) {
        return setRecipKID(new DEROctetString(bArr));
    }

    public PKIHeaderBuilder setRecipNonce(ASN1OctetString aSN1OctetString) {
        this.recipNonce = aSN1OctetString;
        return this;
    }

    public PKIHeaderBuilder setRecipNonce(byte[] bArr) {
        return setRecipNonce(new DEROctetString(bArr));
    }

    public PKIHeaderBuilder setSenderKID(ASN1OctetString aSN1OctetString) {
        this.senderKID = aSN1OctetString;
        return this;
    }

    public PKIHeaderBuilder setSenderKID(byte[] bArr) {
        return setSenderKID(new DEROctetString(bArr));
    }

    public PKIHeaderBuilder setSenderNonce(ASN1OctetString aSN1OctetString) {
        this.senderNonce = aSN1OctetString;
        return this;
    }

    public PKIHeaderBuilder setSenderNonce(byte[] bArr) {
        return setSenderNonce(new DEROctetString(bArr));
    }

    public PKIHeaderBuilder setTransactionID(ASN1OctetString aSN1OctetString) {
        this.transactionID = aSN1OctetString;
        return this;
    }

    public PKIHeaderBuilder setTransactionID(byte[] bArr) {
        return setTransactionID(new DEROctetString(bArr));
    }
}
