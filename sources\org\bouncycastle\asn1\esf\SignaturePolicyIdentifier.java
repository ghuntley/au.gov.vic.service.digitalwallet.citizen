package org.bouncycastle.asn1.esf;

import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1Null;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERNull;
import org.bouncycastle.asn1.DERObject;

public class SignaturePolicyIdentifier extends ASN1Encodable {
    private boolean isSignaturePolicyImplied = true;
    private SignaturePolicyId signaturePolicyId;

    public SignaturePolicyIdentifier() {
    }

    public SignaturePolicyIdentifier(SignaturePolicyId signaturePolicyId2) {
        this.signaturePolicyId = signaturePolicyId2;
    }

    public static SignaturePolicyIdentifier getInstance(Object obj) {
        if (obj == null || (obj instanceof SignaturePolicyIdentifier)) {
            return (SignaturePolicyIdentifier) obj;
        }
        if (obj instanceof ASN1Sequence) {
            return new SignaturePolicyIdentifier(SignaturePolicyId.getInstance(obj));
        }
        if (obj instanceof ASN1Null) {
            return new SignaturePolicyIdentifier();
        }
        throw new IllegalArgumentException("unknown object in 'SignaturePolicyIdentifier' factory: " + obj.getClass().getName() + ".");
    }

    public SignaturePolicyId getSignaturePolicyId() {
        return this.signaturePolicyId;
    }

    public boolean isSignaturePolicyImplied() {
        return this.isSignaturePolicyImplied;
    }

    @Override // org.bouncycastle.asn1.ASN1Encodable
    public DERObject toASN1Object() {
        return this.isSignaturePolicyImplied ? new DERNull() : this.signaturePolicyId.getDERObject();
    }
}
