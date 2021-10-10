package org.bouncycastle.cms;

public class PasswordRecipientId extends RecipientId {
    public PasswordRecipientId() {
        super(3);
    }

    public boolean equals(Object obj) {
        return obj instanceof PasswordRecipientId;
    }

    public int hashCode() {
        return 3;
    }

    @Override // org.bouncycastle.util.Selector
    public boolean match(Object obj) {
        return obj instanceof PasswordRecipientInformation;
    }
}
