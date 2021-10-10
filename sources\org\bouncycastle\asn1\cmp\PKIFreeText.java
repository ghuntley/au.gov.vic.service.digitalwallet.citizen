package org.bouncycastle.asn1.cmp;

import java.util.Enumeration;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERObject;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERUTF8String;

public class PKIFreeText extends ASN1Encodable {
    ASN1Sequence strings;

    public PKIFreeText(ASN1Sequence aSN1Sequence) {
        Enumeration objects = aSN1Sequence.getObjects();
        while (objects.hasMoreElements()) {
            if (!(objects.nextElement() instanceof DERUTF8String)) {
                throw new IllegalArgumentException("attempt to insert non UTF8 STRING into PKIFreeText");
            }
        }
        this.strings = aSN1Sequence;
    }

    public PKIFreeText(DERUTF8String dERUTF8String) {
        this.strings = new DERSequence(dERUTF8String);
    }

    public PKIFreeText(String[] strArr) {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        for (String str : strArr) {
            aSN1EncodableVector.add(new DERUTF8String(str));
        }
        this.strings = new DERSequence(aSN1EncodableVector);
    }

    public PKIFreeText(DERUTF8String[] dERUTF8StringArr) {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        for (DERUTF8String dERUTF8String : dERUTF8StringArr) {
            aSN1EncodableVector.add(dERUTF8String);
        }
        this.strings = new DERSequence(aSN1EncodableVector);
    }

    public static PKIFreeText getInstance(Object obj) {
        if (obj instanceof PKIFreeText) {
            return (PKIFreeText) obj;
        }
        if (obj instanceof ASN1Sequence) {
            return new PKIFreeText((ASN1Sequence) obj);
        }
        throw new IllegalArgumentException("Unknown object in factory: " + obj.getClass().getName());
    }

    public static PKIFreeText getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return getInstance(ASN1Sequence.getInstance(aSN1TaggedObject, z));
    }

    public DERUTF8String getStringAt(int i) {
        return (DERUTF8String) this.strings.getObjectAt(i);
    }

    public int size() {
        return this.strings.size();
    }

    @Override // org.bouncycastle.asn1.ASN1Encodable
    public DERObject toASN1Object() {
        return this.strings;
    }
}
