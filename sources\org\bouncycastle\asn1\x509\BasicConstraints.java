package org.bouncycastle.asn1.x509;

import java.math.BigInteger;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERBoolean;
import org.bouncycastle.asn1.DERInteger;
import org.bouncycastle.asn1.DERObject;
import org.bouncycastle.asn1.DERSequence;

public class BasicConstraints extends ASN1Encodable {
    DERBoolean cA;
    DERInteger pathLenConstraint;

    public BasicConstraints(int i) {
        this.cA = new DERBoolean(false);
        this.pathLenConstraint = null;
        this.cA = new DERBoolean(true);
        this.pathLenConstraint = new DERInteger(i);
    }

    public BasicConstraints(ASN1Sequence aSN1Sequence) {
        this.cA = new DERBoolean(false);
        this.pathLenConstraint = null;
        if (aSN1Sequence.size() == 0) {
            this.cA = null;
            this.pathLenConstraint = null;
            return;
        }
        if (aSN1Sequence.getObjectAt(0) instanceof DERBoolean) {
            this.cA = DERBoolean.getInstance(aSN1Sequence.getObjectAt(0));
        } else {
            this.cA = null;
            this.pathLenConstraint = DERInteger.getInstance(aSN1Sequence.getObjectAt(0));
        }
        if (aSN1Sequence.size() <= 1) {
            return;
        }
        if (this.cA != null) {
            this.pathLenConstraint = DERInteger.getInstance(aSN1Sequence.getObjectAt(1));
            return;
        }
        throw new IllegalArgumentException("wrong sequence in constructor");
    }

    public BasicConstraints(boolean z) {
        this.cA = new DERBoolean(false);
        this.pathLenConstraint = null;
        if (z) {
            this.cA = new DERBoolean(true);
        } else {
            this.cA = null;
        }
        this.pathLenConstraint = null;
    }

    public BasicConstraints(boolean z, int i) {
        this.cA = new DERBoolean(false);
        this.pathLenConstraint = null;
        if (z) {
            this.cA = new DERBoolean(z);
            this.pathLenConstraint = new DERInteger(i);
            return;
        }
        this.cA = null;
        this.pathLenConstraint = null;
    }

    public static BasicConstraints getInstance(Object obj) {
        if (obj == null || (obj instanceof BasicConstraints)) {
            return (BasicConstraints) obj;
        }
        if (obj instanceof ASN1Sequence) {
            return new BasicConstraints((ASN1Sequence) obj);
        }
        if (obj instanceof X509Extension) {
            return getInstance(X509Extension.convertValueToObject((X509Extension) obj));
        }
        throw new IllegalArgumentException("unknown object in factory: " + obj.getClass().getName());
    }

    public static BasicConstraints getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return getInstance(ASN1Sequence.getInstance(aSN1TaggedObject, z));
    }

    public BigInteger getPathLenConstraint() {
        DERInteger dERInteger = this.pathLenConstraint;
        if (dERInteger != null) {
            return dERInteger.getValue();
        }
        return null;
    }

    public boolean isCA() {
        DERBoolean dERBoolean = this.cA;
        return dERBoolean != null && dERBoolean.isTrue();
    }

    @Override // org.bouncycastle.asn1.ASN1Encodable
    public DERObject toASN1Object() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        DERBoolean dERBoolean = this.cA;
        if (dERBoolean != null) {
            aSN1EncodableVector.add(dERBoolean);
        }
        DERInteger dERInteger = this.pathLenConstraint;
        if (dERInteger != null) {
            aSN1EncodableVector.add(dERInteger);
        }
        return new DERSequence(aSN1EncodableVector);
    }

    public String toString() {
        StringBuilder sb;
        if (this.pathLenConstraint != null) {
            sb = new StringBuilder();
            sb.append("BasicConstraints: isCa(");
            sb.append(isCA());
            sb.append("), pathLenConstraint = ");
            sb.append(this.pathLenConstraint.getValue());
        } else if (this.cA == null) {
            return "BasicConstraints: isCa(false)";
        } else {
            sb = new StringBuilder();
            sb.append("BasicConstraints: isCa(");
            sb.append(isCA());
            sb.append(")");
        }
        return sb.toString();
    }
}
