package org.bouncycastle.asn1.tsp;

import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERBoolean;
import org.bouncycastle.asn1.DERInteger;
import org.bouncycastle.asn1.DERObject;
import org.bouncycastle.asn1.DERObjectIdentifier;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERTaggedObject;
import org.bouncycastle.asn1.x509.X509Extensions;

public class TimeStampReq extends ASN1Encodable {
    DERBoolean certReq;
    X509Extensions extensions;
    MessageImprint messageImprint;
    DERInteger nonce;
    DERObjectIdentifier tsaPolicy;
    DERInteger version;

    public TimeStampReq(ASN1Sequence aSN1Sequence) {
        int size = aSN1Sequence.size();
        this.version = DERInteger.getInstance(aSN1Sequence.getObjectAt(0));
        this.messageImprint = MessageImprint.getInstance(aSN1Sequence.getObjectAt(1));
        for (int i = 2; i < size; i++) {
            if (aSN1Sequence.getObjectAt(i) instanceof DERObjectIdentifier) {
                this.tsaPolicy = DERObjectIdentifier.getInstance(aSN1Sequence.getObjectAt(i));
            } else if (aSN1Sequence.getObjectAt(i) instanceof DERInteger) {
                this.nonce = DERInteger.getInstance(aSN1Sequence.getObjectAt(i));
            } else if (aSN1Sequence.getObjectAt(i) instanceof DERBoolean) {
                this.certReq = DERBoolean.getInstance(aSN1Sequence.getObjectAt(i));
            } else if (aSN1Sequence.getObjectAt(i) instanceof ASN1TaggedObject) {
                ASN1TaggedObject aSN1TaggedObject = (ASN1TaggedObject) aSN1Sequence.getObjectAt(i);
                if (aSN1TaggedObject.getTagNo() == 0) {
                    this.extensions = X509Extensions.getInstance(aSN1TaggedObject, false);
                }
            }
        }
    }

    public TimeStampReq(MessageImprint messageImprint2, DERObjectIdentifier dERObjectIdentifier, DERInteger dERInteger, DERBoolean dERBoolean, X509Extensions x509Extensions) {
        this.version = new DERInteger(1);
        this.messageImprint = messageImprint2;
        this.tsaPolicy = dERObjectIdentifier;
        this.nonce = dERInteger;
        this.certReq = dERBoolean;
        this.extensions = x509Extensions;
    }

    public static TimeStampReq getInstance(Object obj) {
        if (obj == null || (obj instanceof TimeStampReq)) {
            return (TimeStampReq) obj;
        }
        if (obj instanceof ASN1Sequence) {
            return new TimeStampReq((ASN1Sequence) obj);
        }
        throw new IllegalArgumentException("Unknown object in 'TimeStampReq' factory : " + obj.getClass().getName() + ".");
    }

    public DERBoolean getCertReq() {
        return this.certReq;
    }

    public X509Extensions getExtensions() {
        return this.extensions;
    }

    public MessageImprint getMessageImprint() {
        return this.messageImprint;
    }

    public DERInteger getNonce() {
        return this.nonce;
    }

    public DERObjectIdentifier getReqPolicy() {
        return this.tsaPolicy;
    }

    public DERInteger getVersion() {
        return this.version;
    }

    @Override // org.bouncycastle.asn1.ASN1Encodable
    public DERObject toASN1Object() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(this.version);
        aSN1EncodableVector.add(this.messageImprint);
        DERObjectIdentifier dERObjectIdentifier = this.tsaPolicy;
        if (dERObjectIdentifier != null) {
            aSN1EncodableVector.add(dERObjectIdentifier);
        }
        DERInteger dERInteger = this.nonce;
        if (dERInteger != null) {
            aSN1EncodableVector.add(dERInteger);
        }
        DERBoolean dERBoolean = this.certReq;
        if (dERBoolean != null && dERBoolean.isTrue()) {
            aSN1EncodableVector.add(this.certReq);
        }
        if (this.extensions != null) {
            aSN1EncodableVector.add(new DERTaggedObject(false, 0, this.extensions));
        }
        return new DERSequence(aSN1EncodableVector);
    }
}
