package org.bouncycastle.asn1.x509.qualified;

import java.util.Enumeration;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERObject;
import org.bouncycastle.asn1.DERObjectIdentifier;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.x509.GeneralName;

public class SemanticsInformation extends ASN1Encodable {
    GeneralName[] nameRegistrationAuthorities;
    DERObjectIdentifier semanticsIdentifier;

    public SemanticsInformation(ASN1Sequence aSN1Sequence) {
        Enumeration objects = aSN1Sequence.getObjects();
        if (aSN1Sequence.size() >= 1) {
            Object nextElement = objects.nextElement();
            if (nextElement instanceof DERObjectIdentifier) {
                this.semanticsIdentifier = DERObjectIdentifier.getInstance(nextElement);
                nextElement = objects.hasMoreElements() ? objects.nextElement() : null;
            }
            if (nextElement != null) {
                ASN1Sequence instance = ASN1Sequence.getInstance(nextElement);
                this.nameRegistrationAuthorities = new GeneralName[instance.size()];
                for (int i = 0; i < instance.size(); i++) {
                    this.nameRegistrationAuthorities[i] = GeneralName.getInstance(instance.getObjectAt(i));
                }
                return;
            }
            return;
        }
        throw new IllegalArgumentException("no objects in SemanticsInformation");
    }

    public SemanticsInformation(DERObjectIdentifier dERObjectIdentifier) {
        this.semanticsIdentifier = dERObjectIdentifier;
        this.nameRegistrationAuthorities = null;
    }

    public SemanticsInformation(DERObjectIdentifier dERObjectIdentifier, GeneralName[] generalNameArr) {
        this.semanticsIdentifier = dERObjectIdentifier;
        this.nameRegistrationAuthorities = generalNameArr;
    }

    public SemanticsInformation(GeneralName[] generalNameArr) {
        this.semanticsIdentifier = null;
        this.nameRegistrationAuthorities = generalNameArr;
    }

    public static SemanticsInformation getInstance(Object obj) {
        if (obj == null || (obj instanceof SemanticsInformation)) {
            return (SemanticsInformation) obj;
        }
        if (obj instanceof ASN1Sequence) {
            return new SemanticsInformation(ASN1Sequence.getInstance(obj));
        }
        throw new IllegalArgumentException("unknown object in getInstance");
    }

    public GeneralName[] getNameRegistrationAuthorities() {
        return this.nameRegistrationAuthorities;
    }

    public DERObjectIdentifier getSemanticsIdentifier() {
        return this.semanticsIdentifier;
    }

    @Override // org.bouncycastle.asn1.ASN1Encodable
    public DERObject toASN1Object() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        DERObjectIdentifier dERObjectIdentifier = this.semanticsIdentifier;
        if (dERObjectIdentifier != null) {
            aSN1EncodableVector.add(dERObjectIdentifier);
        }
        if (this.nameRegistrationAuthorities != null) {
            ASN1EncodableVector aSN1EncodableVector2 = new ASN1EncodableVector();
            int i = 0;
            while (true) {
                GeneralName[] generalNameArr = this.nameRegistrationAuthorities;
                if (i >= generalNameArr.length) {
                    break;
                }
                aSN1EncodableVector2.add(generalNameArr[i]);
                i++;
            }
            aSN1EncodableVector.add(new DERSequence(aSN1EncodableVector2));
        }
        return new DERSequence(aSN1EncodableVector);
    }
}
