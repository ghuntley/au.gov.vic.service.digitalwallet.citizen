package org.bouncycastle.asn1.x509;

import java.util.Enumeration;
import java.util.Vector;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERObject;
import org.bouncycastle.asn1.DERObjectIdentifier;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERTaggedObject;
import org.bouncycastle.asn1.DERUTF8String;

public class IetfAttrSyntax extends ASN1Encodable {
    public static final int VALUE_OCTETS = 1;
    public static final int VALUE_OID = 2;
    public static final int VALUE_UTF8 = 3;
    GeneralNames policyAuthority = null;
    int valueChoice = -1;
    Vector values = new Vector();

    /* JADX WARNING: Removed duplicated region for block: B:32:0x0088  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0040  */
    public IetfAttrSyntax(ASN1Sequence aSN1Sequence) {
        int i;
        GeneralNames instance;
        int i2 = 0;
        if (aSN1Sequence.getObjectAt(0) instanceof ASN1TaggedObject) {
            GeneralNames.getInstance((ASN1TaggedObject) aSN1Sequence.getObjectAt(0), false);
        } else {
            instance = aSN1Sequence.size() == 2 ? GeneralNames.getInstance(aSN1Sequence.getObjectAt(0)) : instance;
            if (!(aSN1Sequence.getObjectAt(i2) instanceof ASN1Sequence)) {
                Enumeration objects = ((ASN1Sequence) aSN1Sequence.getObjectAt(i2)).getObjects();
                while (objects.hasMoreElements()) {
                    DERObject dERObject = (DERObject) objects.nextElement();
                    if (dERObject instanceof DERObjectIdentifier) {
                        i = 2;
                    } else if (dERObject instanceof DERUTF8String) {
                        i = 3;
                    } else if (dERObject instanceof DEROctetString) {
                        i = 1;
                    } else {
                        throw new IllegalArgumentException("Bad value type encoding IetfAttrSyntax");
                    }
                    if (this.valueChoice < 0) {
                        this.valueChoice = i;
                    }
                    if (i == this.valueChoice) {
                        this.values.addElement(dERObject);
                    } else {
                        throw new IllegalArgumentException("Mix of value types in IetfAttrSyntax");
                    }
                }
                return;
            }
            throw new IllegalArgumentException("Non-IetfAttrSyntax encoding");
        }
        this.policyAuthority = instance;
        i2 = 1;
        if (!(aSN1Sequence.getObjectAt(i2) instanceof ASN1Sequence)) {
        }
    }

    public GeneralNames getPolicyAuthority() {
        return this.policyAuthority;
    }

    public int getValueType() {
        return this.valueChoice;
    }

    public Object[] getValues() {
        int i = 0;
        if (getValueType() == 1) {
            int size = this.values.size();
            ASN1OctetString[] aSN1OctetStringArr = new ASN1OctetString[size];
            while (i != size) {
                aSN1OctetStringArr[i] = (ASN1OctetString) this.values.elementAt(i);
                i++;
            }
            return aSN1OctetStringArr;
        } else if (getValueType() == 2) {
            int size2 = this.values.size();
            DERObjectIdentifier[] dERObjectIdentifierArr = new DERObjectIdentifier[size2];
            while (i != size2) {
                dERObjectIdentifierArr[i] = (DERObjectIdentifier) this.values.elementAt(i);
                i++;
            }
            return dERObjectIdentifierArr;
        } else {
            int size3 = this.values.size();
            DERUTF8String[] dERUTF8StringArr = new DERUTF8String[size3];
            while (i != size3) {
                dERUTF8StringArr[i] = (DERUTF8String) this.values.elementAt(i);
                i++;
            }
            return dERUTF8StringArr;
        }
    }

    @Override // org.bouncycastle.asn1.ASN1Encodable
    public DERObject toASN1Object() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        if (this.policyAuthority != null) {
            aSN1EncodableVector.add(new DERTaggedObject(0, this.policyAuthority));
        }
        ASN1EncodableVector aSN1EncodableVector2 = new ASN1EncodableVector();
        Enumeration elements = this.values.elements();
        while (elements.hasMoreElements()) {
            aSN1EncodableVector2.add((ASN1Encodable) elements.nextElement());
        }
        aSN1EncodableVector.add(new DERSequence(aSN1EncodableVector2));
        return new DERSequence(aSN1EncodableVector);
    }
}
