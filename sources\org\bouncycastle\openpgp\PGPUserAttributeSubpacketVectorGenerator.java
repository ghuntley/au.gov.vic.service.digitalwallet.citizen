package org.bouncycastle.openpgp;

import java.util.ArrayList;
import java.util.List;
import org.bouncycastle.bcpg.UserAttributeSubpacket;
import org.bouncycastle.bcpg.attr.ImageAttribute;

public class PGPUserAttributeSubpacketVectorGenerator {
    private List list = new ArrayList();

    public PGPUserAttributeSubpacketVector generate() {
        List list2 = this.list;
        return new PGPUserAttributeSubpacketVector((UserAttributeSubpacket[]) list2.toArray(new UserAttributeSubpacket[list2.size()]));
    }

    public void setImageAttribute(int i, byte[] bArr) {
        if (bArr != null) {
            this.list.add(new ImageAttribute(i, bArr));
            return;
        }
        throw new IllegalArgumentException("attempt to set null image");
    }
}
