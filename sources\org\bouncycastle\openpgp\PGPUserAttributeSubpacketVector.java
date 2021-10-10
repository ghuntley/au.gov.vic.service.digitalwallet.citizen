package org.bouncycastle.openpgp;

import org.bouncycastle.bcpg.UserAttributeSubpacket;
import org.bouncycastle.bcpg.attr.ImageAttribute;

public class PGPUserAttributeSubpacketVector {
    UserAttributeSubpacket[] packets;

    PGPUserAttributeSubpacketVector(UserAttributeSubpacket[] userAttributeSubpacketArr) {
        this.packets = userAttributeSubpacketArr;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof PGPUserAttributeSubpacketVector)) {
            return false;
        }
        PGPUserAttributeSubpacketVector pGPUserAttributeSubpacketVector = (PGPUserAttributeSubpacketVector) obj;
        if (pGPUserAttributeSubpacketVector.packets.length != this.packets.length) {
            return false;
        }
        int i = 0;
        while (true) {
            UserAttributeSubpacket[] userAttributeSubpacketArr = this.packets;
            if (i == userAttributeSubpacketArr.length) {
                return true;
            }
            if (!pGPUserAttributeSubpacketVector.packets[i].equals(userAttributeSubpacketArr[i])) {
                return false;
            }
            i++;
        }
    }

    public ImageAttribute getImageAttribute() {
        UserAttributeSubpacket subpacket = getSubpacket(1);
        if (subpacket == null) {
            return null;
        }
        return (ImageAttribute) subpacket;
    }

    public UserAttributeSubpacket getSubpacket(int i) {
        int i2 = 0;
        while (true) {
            UserAttributeSubpacket[] userAttributeSubpacketArr = this.packets;
            if (i2 == userAttributeSubpacketArr.length) {
                return null;
            }
            if (userAttributeSubpacketArr[i2].getType() == i) {
                return this.packets[i2];
            }
            i2++;
        }
    }

    public int hashCode() {
        int i = 0;
        int i2 = 0;
        while (true) {
            UserAttributeSubpacket[] userAttributeSubpacketArr = this.packets;
            if (i == userAttributeSubpacketArr.length) {
                return i2;
            }
            i2 ^= userAttributeSubpacketArr[i].hashCode();
            i++;
        }
    }

    /* access modifiers changed from: package-private */
    public UserAttributeSubpacket[] toSubpacketArray() {
        return this.packets;
    }
}
