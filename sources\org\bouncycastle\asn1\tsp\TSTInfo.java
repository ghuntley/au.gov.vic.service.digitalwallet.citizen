package org.bouncycastle.asn1.tsp;

import java.io.IOException;
import java.util.Enumeration;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1InputStream;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERBoolean;
import org.bouncycastle.asn1.DERGeneralizedTime;
import org.bouncycastle.asn1.DERInteger;
import org.bouncycastle.asn1.DERObject;
import org.bouncycastle.asn1.DERObjectIdentifier;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERTaggedObject;
import org.bouncycastle.asn1.x509.GeneralName;
import org.bouncycastle.asn1.x509.X509Extensions;

public class TSTInfo extends ASN1Encodable {
    Accuracy accuracy;
    X509Extensions extensions;
    DERGeneralizedTime genTime;
    MessageImprint messageImprint;
    DERInteger nonce;
    DERBoolean ordering;
    DERInteger serialNumber;
    GeneralName tsa;
    DERObjectIdentifier tsaPolicyId;
    DERInteger version;

    public TSTInfo(ASN1Sequence aSN1Sequence) {
        Enumeration objects = aSN1Sequence.getObjects();
        this.version = DERInteger.getInstance(objects.nextElement());
        this.tsaPolicyId = DERObjectIdentifier.getInstance(objects.nextElement());
        this.messageImprint = MessageImprint.getInstance(objects.nextElement());
        this.serialNumber = DERInteger.getInstance(objects.nextElement());
        this.genTime = DERGeneralizedTime.getInstance(objects.nextElement());
        DERBoolean dERBoolean = new DERBoolean(false);
        while (true) {
            this.ordering = dERBoolean;
            while (objects.hasMoreElements()) {
                DERObject dERObject = (DERObject) objects.nextElement();
                if (dERObject instanceof ASN1TaggedObject) {
                    DERTaggedObject dERTaggedObject = (DERTaggedObject) dERObject;
                    int tagNo = dERTaggedObject.getTagNo();
                    if (tagNo == 0) {
                        this.tsa = GeneralName.getInstance(dERTaggedObject, true);
                    } else if (tagNo == 1) {
                        this.extensions = X509Extensions.getInstance(dERTaggedObject, false);
                    } else {
                        throw new IllegalArgumentException("Unknown tag value " + dERTaggedObject.getTagNo());
                    }
                } else if (dERObject instanceof DERSequence) {
                    this.accuracy = Accuracy.getInstance(dERObject);
                } else if (dERObject instanceof DERBoolean) {
                    dERBoolean = DERBoolean.getInstance(dERObject);
                } else if (dERObject instanceof DERInteger) {
                    this.nonce = DERInteger.getInstance(dERObject);
                }
            }
            return;
        }
    }

    public TSTInfo(DERObjectIdentifier dERObjectIdentifier, MessageImprint messageImprint2, DERInteger dERInteger, DERGeneralizedTime dERGeneralizedTime, Accuracy accuracy2, DERBoolean dERBoolean, DERInteger dERInteger2, GeneralName generalName, X509Extensions x509Extensions) {
        this.version = new DERInteger(1);
        this.tsaPolicyId = dERObjectIdentifier;
        this.messageImprint = messageImprint2;
        this.serialNumber = dERInteger;
        this.genTime = dERGeneralizedTime;
        this.accuracy = accuracy2;
        this.ordering = dERBoolean;
        this.nonce = dERInteger2;
        this.tsa = generalName;
        this.extensions = x509Extensions;
    }

    public static TSTInfo getInstance(Object obj) {
        if (obj == null || (obj instanceof TSTInfo)) {
            return (TSTInfo) obj;
        }
        if (obj instanceof ASN1Sequence) {
            return new TSTInfo((ASN1Sequence) obj);
        }
        if (obj instanceof ASN1OctetString) {
            try {
                return getInstance(new ASN1InputStream(((ASN1OctetString) obj).getOctets()).readObject());
            } catch (IOException unused) {
                throw new IllegalArgumentException("Bad object format in 'TSTInfo' factory.");
            }
        } else {
            throw new IllegalArgumentException("Unknown object in 'TSTInfo' factory : " + obj.getClass().getName() + ".");
        }
    }

    public Accuracy getAccuracy() {
        return this.accuracy;
    }

    public X509Extensions getExtensions() {
        return this.extensions;
    }

    public DERGeneralizedTime getGenTime() {
        return this.genTime;
    }

    public MessageImprint getMessageImprint() {
        return this.messageImprint;
    }

    public DERInteger getNonce() {
        return this.nonce;
    }

    public DERBoolean getOrdering() {
        return this.ordering;
    }

    public DERObjectIdentifier getPolicy() {
        return this.tsaPolicyId;
    }

    public DERInteger getSerialNumber() {
        return this.serialNumber;
    }

    public GeneralName getTsa() {
        return this.tsa;
    }

    @Override // org.bouncycastle.asn1.ASN1Encodable
    public DERObject toASN1Object() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(this.version);
        aSN1EncodableVector.add(this.tsaPolicyId);
        aSN1EncodableVector.add(this.messageImprint);
        aSN1EncodableVector.add(this.serialNumber);
        aSN1EncodableVector.add(this.genTime);
        Accuracy accuracy2 = this.accuracy;
        if (accuracy2 != null) {
            aSN1EncodableVector.add(accuracy2);
        }
        DERBoolean dERBoolean = this.ordering;
        if (dERBoolean != null && dERBoolean.isTrue()) {
            aSN1EncodableVector.add(this.ordering);
        }
        DERInteger dERInteger = this.nonce;
        if (dERInteger != null) {
            aSN1EncodableVector.add(dERInteger);
        }
        if (this.tsa != null) {
            aSN1EncodableVector.add(new DERTaggedObject(true, 0, this.tsa));
        }
        if (this.extensions != null) {
            aSN1EncodableVector.add(new DERTaggedObject(false, 1, this.extensions));
        }
        return new DERSequence(aSN1EncodableVector);
    }
}
