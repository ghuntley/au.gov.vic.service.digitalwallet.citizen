package org.bouncycastle.asn1;

import java.io.IOException;
import org.objectweb.asm.Opcodes;

public class DERTaggedObject extends ASN1TaggedObject {
    private static final byte[] ZERO_BYTES = new byte[0];

    public DERTaggedObject(int i) {
        super(false, i, new DERSequence());
    }

    public DERTaggedObject(int i, DEREncodable dEREncodable) {
        super(i, dEREncodable);
    }

    public DERTaggedObject(boolean z, int i, DEREncodable dEREncodable) {
        super(z, i, dEREncodable);
    }

    /* access modifiers changed from: package-private */
    @Override // org.bouncycastle.asn1.ASN1TaggedObject, org.bouncycastle.asn1.DERObject, org.bouncycastle.asn1.ASN1Object
    public void encode(DEROutputStream dEROutputStream) throws IOException {
        boolean z = this.empty;
        int i = Opcodes.IF_ICMPNE;
        if (!z) {
            byte[] encoded = this.obj.getDERObject().getEncoded(ASN1Encodable.DER);
            if (this.explicit) {
                dEROutputStream.writeEncoded(Opcodes.IF_ICMPNE, this.tagNo, encoded);
                return;
            }
            if ((encoded[0] & 32) == 0) {
                i = 128;
            }
            dEROutputStream.writeTag(i, this.tagNo);
            dEROutputStream.write(encoded, 1, encoded.length - 1);
            return;
        }
        dEROutputStream.writeEncoded(Opcodes.IF_ICMPNE, this.tagNo, ZERO_BYTES);
    }
}
