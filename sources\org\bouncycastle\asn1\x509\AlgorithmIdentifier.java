package org.bouncycastle.asn1.x509;

import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DEREncodable;
import org.bouncycastle.asn1.DERNull;
import org.bouncycastle.asn1.DERObject;
import org.bouncycastle.asn1.DERObjectIdentifier;
import org.bouncycastle.asn1.DERSequence;

public class AlgorithmIdentifier extends ASN1Encodable {
    private DERObjectIdentifier objectId;
    private DEREncodable parameters;
    private boolean parametersDefined;

    public AlgorithmIdentifier(String str) {
        this.parametersDefined = false;
        this.objectId = new DERObjectIdentifier(str);
    }

    public AlgorithmIdentifier(ASN1Sequence aSN1Sequence) {
        DEREncodable dEREncodable;
        this.parametersDefined = false;
        if (aSN1Sequence.size() < 1 || aSN1Sequence.size() > 2) {
            throw new IllegalArgumentException("Bad sequence size: " + aSN1Sequence.size());
        }
        this.objectId = DERObjectIdentifier.getInstance(aSN1Sequence.getObjectAt(0));
        if (aSN1Sequence.size() == 2) {
            this.parametersDefined = true;
            dEREncodable = aSN1Sequence.getObjectAt(1);
        } else {
            dEREncodable = null;
        }
        this.parameters = dEREncodable;
    }

    public AlgorithmIdentifier(DERObjectIdentifier dERObjectIdentifier) {
        this.parametersDefined = false;
        this.objectId = dERObjectIdentifier;
    }

    public AlgorithmIdentifier(DERObjectIdentifier dERObjectIdentifier, DEREncodable dEREncodable) {
        this.parametersDefined = false;
        this.parametersDefined = true;
        this.objectId = dERObjectIdentifier;
        this.parameters = dEREncodable;
    }

    public static AlgorithmIdentifier getInstance(Object obj) {
        if (obj == null || (obj instanceof AlgorithmIdentifier)) {
            return (AlgorithmIdentifier) obj;
        }
        if (obj instanceof DERObjectIdentifier) {
            return new AlgorithmIdentifier((DERObjectIdentifier) obj);
        }
        if (obj instanceof String) {
            return new AlgorithmIdentifier((String) obj);
        }
        if (obj instanceof ASN1Sequence) {
            return new AlgorithmIdentifier((ASN1Sequence) obj);
        }
        throw new IllegalArgumentException("unknown object in factory: " + obj.getClass().getName());
    }

    public static AlgorithmIdentifier getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return getInstance(ASN1Sequence.getInstance(aSN1TaggedObject, z));
    }

    public ASN1ObjectIdentifier getAlgorithm() {
        return new ASN1ObjectIdentifier(this.objectId.getId());
    }

    public DERObjectIdentifier getObjectId() {
        return this.objectId;
    }

    public DEREncodable getParameters() {
        return this.parameters;
    }

    @Override // org.bouncycastle.asn1.ASN1Encodable
    public DERObject toASN1Object() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(this.objectId);
        if (this.parametersDefined) {
            DEREncodable dEREncodable = this.parameters;
            if (dEREncodable == null) {
                dEREncodable = DERNull.INSTANCE;
            }
            aSN1EncodableVector.add(dEREncodable);
        }
        return new DERSequence(aSN1EncodableVector);
    }
}
