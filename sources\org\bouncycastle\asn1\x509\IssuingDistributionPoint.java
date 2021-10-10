package org.bouncycastle.asn1.x509;

import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERBoolean;
import org.bouncycastle.asn1.DERObject;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERTaggedObject;

public class IssuingDistributionPoint extends ASN1Encodable {
    private DistributionPointName distributionPoint;
    private boolean indirectCRL;
    private boolean onlyContainsAttributeCerts;
    private boolean onlyContainsCACerts;
    private boolean onlyContainsUserCerts;
    private ReasonFlags onlySomeReasons;
    private ASN1Sequence seq;

    public IssuingDistributionPoint(ASN1Sequence aSN1Sequence) {
        this.seq = aSN1Sequence;
        for (int i = 0; i != aSN1Sequence.size(); i++) {
            ASN1TaggedObject instance = ASN1TaggedObject.getInstance(aSN1Sequence.getObjectAt(i));
            int tagNo = instance.getTagNo();
            if (tagNo == 0) {
                this.distributionPoint = DistributionPointName.getInstance(instance, true);
            } else if (tagNo == 1) {
                this.onlyContainsUserCerts = DERBoolean.getInstance(instance, false).isTrue();
            } else if (tagNo == 2) {
                this.onlyContainsCACerts = DERBoolean.getInstance(instance, false).isTrue();
            } else if (tagNo == 3) {
                this.onlySomeReasons = new ReasonFlags(ReasonFlags.getInstance(instance, false));
            } else if (tagNo == 4) {
                this.indirectCRL = DERBoolean.getInstance(instance, false).isTrue();
            } else if (tagNo == 5) {
                this.onlyContainsAttributeCerts = DERBoolean.getInstance(instance, false).isTrue();
            } else {
                throw new IllegalArgumentException("unknown tag in IssuingDistributionPoint");
            }
        }
    }

    public IssuingDistributionPoint(DistributionPointName distributionPointName, boolean z, boolean z2, ReasonFlags reasonFlags, boolean z3, boolean z4) {
        this.distributionPoint = distributionPointName;
        this.indirectCRL = z3;
        this.onlyContainsAttributeCerts = z4;
        this.onlyContainsCACerts = z2;
        this.onlyContainsUserCerts = z;
        this.onlySomeReasons = reasonFlags;
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        if (distributionPointName != null) {
            aSN1EncodableVector.add(new DERTaggedObject(true, 0, distributionPointName));
        }
        if (z) {
            aSN1EncodableVector.add(new DERTaggedObject(false, 1, new DERBoolean(true)));
        }
        if (z2) {
            aSN1EncodableVector.add(new DERTaggedObject(false, 2, new DERBoolean(true)));
        }
        if (reasonFlags != null) {
            aSN1EncodableVector.add(new DERTaggedObject(false, 3, reasonFlags));
        }
        if (z3) {
            aSN1EncodableVector.add(new DERTaggedObject(false, 4, new DERBoolean(true)));
        }
        if (z4) {
            aSN1EncodableVector.add(new DERTaggedObject(false, 5, new DERBoolean(true)));
        }
        this.seq = new DERSequence(aSN1EncodableVector);
    }

    private void appendObject(StringBuffer stringBuffer, String str, String str2, String str3) {
        stringBuffer.append("    ");
        stringBuffer.append(str2);
        stringBuffer.append(":");
        stringBuffer.append(str);
        stringBuffer.append("    ");
        stringBuffer.append("    ");
        stringBuffer.append(str3);
        stringBuffer.append(str);
    }

    private String booleanToString(boolean z) {
        return z ? "true" : "false";
    }

    public static IssuingDistributionPoint getInstance(Object obj) {
        if (obj == null || (obj instanceof IssuingDistributionPoint)) {
            return (IssuingDistributionPoint) obj;
        }
        if (obj instanceof ASN1Sequence) {
            return new IssuingDistributionPoint((ASN1Sequence) obj);
        }
        throw new IllegalArgumentException("unknown object in factory: " + obj.getClass().getName());
    }

    public static IssuingDistributionPoint getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return getInstance(ASN1Sequence.getInstance(aSN1TaggedObject, z));
    }

    public DistributionPointName getDistributionPoint() {
        return this.distributionPoint;
    }

    public ReasonFlags getOnlySomeReasons() {
        return this.onlySomeReasons;
    }

    public boolean isIndirectCRL() {
        return this.indirectCRL;
    }

    public boolean onlyContainsAttributeCerts() {
        return this.onlyContainsAttributeCerts;
    }

    public boolean onlyContainsCACerts() {
        return this.onlyContainsCACerts;
    }

    public boolean onlyContainsUserCerts() {
        return this.onlyContainsUserCerts;
    }

    @Override // org.bouncycastle.asn1.ASN1Encodable
    public DERObject toASN1Object() {
        return this.seq;
    }

    public String toString() {
        String property = System.getProperty("line.separator");
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("IssuingDistributionPoint: [");
        stringBuffer.append(property);
        DistributionPointName distributionPointName = this.distributionPoint;
        if (distributionPointName != null) {
            appendObject(stringBuffer, property, "distributionPoint", distributionPointName.toString());
        }
        boolean z = this.onlyContainsUserCerts;
        if (z) {
            appendObject(stringBuffer, property, "onlyContainsUserCerts", booleanToString(z));
        }
        boolean z2 = this.onlyContainsCACerts;
        if (z2) {
            appendObject(stringBuffer, property, "onlyContainsCACerts", booleanToString(z2));
        }
        ReasonFlags reasonFlags = this.onlySomeReasons;
        if (reasonFlags != null) {
            appendObject(stringBuffer, property, "onlySomeReasons", reasonFlags.toString());
        }
        boolean z3 = this.onlyContainsAttributeCerts;
        if (z3) {
            appendObject(stringBuffer, property, "onlyContainsAttributeCerts", booleanToString(z3));
        }
        boolean z4 = this.indirectCRL;
        if (z4) {
            appendObject(stringBuffer, property, "indirectCRL", booleanToString(z4));
        }
        stringBuffer.append("]");
        stringBuffer.append(property);
        return stringBuffer.toString();
    }
}
