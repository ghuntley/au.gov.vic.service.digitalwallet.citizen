package org.bouncycastle.asn1.x509.qualified;

import java.util.Enumeration;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERObject;
import org.bouncycastle.asn1.DERObjectIdentifier;
import org.bouncycastle.asn1.DERSequence;

public class QCStatement extends ASN1Encodable implements ETSIQCObjectIdentifiers, RFC3739QCObjectIdentifiers {
    DERObjectIdentifier qcStatementId;
    ASN1Encodable qcStatementInfo;

    public QCStatement(ASN1Sequence aSN1Sequence) {
        Enumeration objects = aSN1Sequence.getObjects();
        this.qcStatementId = DERObjectIdentifier.getInstance(objects.nextElement());
        if (objects.hasMoreElements()) {
            this.qcStatementInfo = (ASN1Encodable) objects.nextElement();
        }
    }

    public QCStatement(DERObjectIdentifier dERObjectIdentifier) {
        this.qcStatementId = dERObjectIdentifier;
        this.qcStatementInfo = null;
    }

    public QCStatement(DERObjectIdentifier dERObjectIdentifier, ASN1Encodable aSN1Encodable) {
        this.qcStatementId = dERObjectIdentifier;
        this.qcStatementInfo = aSN1Encodable;
    }

    public static QCStatement getInstance(Object obj) {
        if (obj == null || (obj instanceof QCStatement)) {
            return (QCStatement) obj;
        }
        if (obj instanceof ASN1Sequence) {
            return new QCStatement(ASN1Sequence.getInstance(obj));
        }
        throw new IllegalArgumentException("unknown object in getInstance");
    }

    public DERObjectIdentifier getStatementId() {
        return this.qcStatementId;
    }

    public ASN1Encodable getStatementInfo() {
        return this.qcStatementInfo;
    }

    @Override // org.bouncycastle.asn1.ASN1Encodable
    public DERObject toASN1Object() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(this.qcStatementId);
        ASN1Encodable aSN1Encodable = this.qcStatementInfo;
        if (aSN1Encodable != null) {
            aSN1EncodableVector.add(aSN1Encodable);
        }
        return new DERSequence(aSN1EncodableVector);
    }
}
