package org.bouncycastle.cms;

import org.bouncycastle.util.Arrays;

public class KEKRecipientId extends RecipientId {
    private byte[] keyIdentifier;

    public KEKRecipientId(byte[] bArr) {
        super(1);
        this.keyIdentifier = bArr;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof KEKRecipientId)) {
            return false;
        }
        return Arrays.areEqual(this.keyIdentifier, ((KEKRecipientId) obj).keyIdentifier);
    }

    public int hashCode() {
        return Arrays.hashCode(this.keyIdentifier);
    }

    @Override // org.bouncycastle.util.Selector
    public boolean match(Object obj) {
        if (obj instanceof byte[]) {
            return Arrays.areEqual(this.keyIdentifier, (byte[]) obj);
        }
        if (obj instanceof KEKRecipientInformation) {
            return ((KEKRecipientInformation) obj).getRID().equals(this);
        }
        return false;
    }
}
