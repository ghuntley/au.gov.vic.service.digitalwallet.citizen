package org.bouncycastle.asn1;

import java.io.IOException;
import java.util.Enumeration;
import org.objectweb.asm.Opcodes;

public class BERTaggedObject extends DERTaggedObject {
    public BERTaggedObject(int i) {
        super(false, i, new BERSequence());
    }

    public BERTaggedObject(int i, DEREncodable dEREncodable) {
        super(i, dEREncodable);
    }

    public BERTaggedObject(boolean z, int i, DEREncodable dEREncodable) {
        super(z, i, dEREncodable);
    }

    /* access modifiers changed from: package-private */
    @Override // org.bouncycastle.asn1.ASN1TaggedObject, org.bouncycastle.asn1.DERTaggedObject, org.bouncycastle.asn1.DERObject, org.bouncycastle.asn1.ASN1Object
    public void encode(DEROutputStream dEROutputStream) throws IOException {
        Enumeration enumeration;
        if ((dEROutputStream instanceof ASN1OutputStream) || (dEROutputStream instanceof BEROutputStream)) {
            dEROutputStream.writeTag(Opcodes.IF_ICMPNE, this.tagNo);
            dEROutputStream.write(128);
            if (!this.empty) {
                if (!this.explicit) {
                    if (this.obj instanceof ASN1OctetString) {
                        enumeration = this.obj instanceof BERConstructedOctetString ? ((BERConstructedOctetString) this.obj).getObjects() : new BERConstructedOctetString(((ASN1OctetString) this.obj).getOctets()).getObjects();
                    } else if (this.obj instanceof ASN1Sequence) {
                        enumeration = ((ASN1Sequence) this.obj).getObjects();
                    } else if (this.obj instanceof ASN1Set) {
                        enumeration = ((ASN1Set) this.obj).getObjects();
                    } else {
                        throw new RuntimeException("not implemented: " + this.obj.getClass().getName());
                    }
                    while (enumeration.hasMoreElements()) {
                        dEROutputStream.writeObject(enumeration.nextElement());
                    }
                } else {
                    dEROutputStream.writeObject(this.obj);
                }
            }
            dEROutputStream.write(0);
            dEROutputStream.write(0);
            return;
        }
        super.encode(dEROutputStream);
    }
}
