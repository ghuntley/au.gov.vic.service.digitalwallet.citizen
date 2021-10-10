package org.bouncycastle.openpgp;

import java.util.ArrayList;
import java.util.Date;
import org.bouncycastle.bcpg.SignatureSubpacket;
import org.bouncycastle.bcpg.sig.IssuerKeyID;
import org.bouncycastle.bcpg.sig.KeyExpirationTime;
import org.bouncycastle.bcpg.sig.KeyFlags;
import org.bouncycastle.bcpg.sig.NotationData;
import org.bouncycastle.bcpg.sig.PreferredAlgorithms;
import org.bouncycastle.bcpg.sig.PrimaryUserID;
import org.bouncycastle.bcpg.sig.SignatureCreationTime;
import org.bouncycastle.bcpg.sig.SignatureExpirationTime;
import org.bouncycastle.bcpg.sig.SignerUserID;

public class PGPSignatureSubpacketVector {
    SignatureSubpacket[] packets;

    PGPSignatureSubpacketVector(SignatureSubpacket[] signatureSubpacketArr) {
        this.packets = signatureSubpacketArr;
    }

    public int[] getCriticalTags() {
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (true) {
            SignatureSubpacket[] signatureSubpacketArr = this.packets;
            if (i2 == signatureSubpacketArr.length) {
                break;
            }
            if (signatureSubpacketArr[i2].isCritical()) {
                i3++;
            }
            i2++;
        }
        int[] iArr = new int[i3];
        int i4 = 0;
        while (true) {
            SignatureSubpacket[] signatureSubpacketArr2 = this.packets;
            if (i == signatureSubpacketArr2.length) {
                return iArr;
            }
            if (signatureSubpacketArr2[i].isCritical()) {
                iArr[i4] = this.packets[i].getType();
                i4++;
            }
            i++;
        }
    }

    public long getIssuerKeyID() {
        SignatureSubpacket subpacket = getSubpacket(16);
        if (subpacket == null) {
            return 0;
        }
        return ((IssuerKeyID) subpacket).getKeyID();
    }

    public long getKeyExpirationTime() {
        SignatureSubpacket subpacket = getSubpacket(9);
        if (subpacket == null) {
            return 0;
        }
        return ((KeyExpirationTime) subpacket).getTime();
    }

    public int getKeyFlags() {
        SignatureSubpacket subpacket = getSubpacket(27);
        if (subpacket == null) {
            return 0;
        }
        return ((KeyFlags) subpacket).getFlags();
    }

    public NotationData[] getNotationDataOccurences() {
        SignatureSubpacket[] subpackets = getSubpackets(20);
        NotationData[] notationDataArr = new NotationData[subpackets.length];
        for (int i = 0; i < subpackets.length; i++) {
            notationDataArr[i] = (NotationData) subpackets[i];
        }
        return notationDataArr;
    }

    public int[] getPreferredCompressionAlgorithms() {
        SignatureSubpacket subpacket = getSubpacket(22);
        if (subpacket == null) {
            return null;
        }
        return ((PreferredAlgorithms) subpacket).getPreferences();
    }

    public int[] getPreferredHashAlgorithms() {
        SignatureSubpacket subpacket = getSubpacket(21);
        if (subpacket == null) {
            return null;
        }
        return ((PreferredAlgorithms) subpacket).getPreferences();
    }

    public int[] getPreferredSymmetricAlgorithms() {
        SignatureSubpacket subpacket = getSubpacket(11);
        if (subpacket == null) {
            return null;
        }
        return ((PreferredAlgorithms) subpacket).getPreferences();
    }

    public Date getSignatureCreationTime() {
        SignatureSubpacket subpacket = getSubpacket(2);
        if (subpacket == null) {
            return null;
        }
        return ((SignatureCreationTime) subpacket).getTime();
    }

    public long getSignatureExpirationTime() {
        SignatureSubpacket subpacket = getSubpacket(3);
        if (subpacket == null) {
            return 0;
        }
        return ((SignatureExpirationTime) subpacket).getTime();
    }

    public String getSignerUserID() {
        SignatureSubpacket subpacket = getSubpacket(28);
        if (subpacket == null) {
            return null;
        }
        return ((SignerUserID) subpacket).getID();
    }

    public SignatureSubpacket getSubpacket(int i) {
        int i2 = 0;
        while (true) {
            SignatureSubpacket[] signatureSubpacketArr = this.packets;
            if (i2 == signatureSubpacketArr.length) {
                return null;
            }
            if (signatureSubpacketArr[i2].getType() == i) {
                return this.packets[i2];
            }
            i2++;
        }
    }

    public SignatureSubpacket[] getSubpackets(int i) {
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        while (true) {
            SignatureSubpacket[] signatureSubpacketArr = this.packets;
            if (i2 == signatureSubpacketArr.length) {
                return (SignatureSubpacket[]) arrayList.toArray(new SignatureSubpacket[0]);
            }
            if (signatureSubpacketArr[i2].getType() == i) {
                arrayList.add(this.packets[i2]);
            }
            i2++;
        }
    }

    public boolean hasSubpacket(int i) {
        return getSubpacket(i) != null;
    }

    public boolean isPrimaryUserID() {
        PrimaryUserID primaryUserID = (PrimaryUserID) getSubpacket(25);
        if (primaryUserID != null) {
            return primaryUserID.isPrimaryUserID();
        }
        return false;
    }

    public int size() {
        return this.packets.length;
    }

    /* access modifiers changed from: package-private */
    public SignatureSubpacket[] toSubpacketArray() {
        return this.packets;
    }
}
