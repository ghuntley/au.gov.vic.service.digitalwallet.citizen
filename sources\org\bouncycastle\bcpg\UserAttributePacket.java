package org.bouncycastle.bcpg;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Vector;

public class UserAttributePacket extends ContainedPacket {
    private UserAttributeSubpacket[] subpackets;

    public UserAttributePacket(BCPGInputStream bCPGInputStream) throws IOException {
        UserAttributeSubpacketInputStream userAttributeSubpacketInputStream = new UserAttributeSubpacketInputStream(bCPGInputStream);
        Vector vector = new Vector();
        while (true) {
            UserAttributeSubpacket readPacket = userAttributeSubpacketInputStream.readPacket();
            if (readPacket == null) {
                break;
            }
            vector.addElement(readPacket);
        }
        this.subpackets = new UserAttributeSubpacket[vector.size()];
        int i = 0;
        while (true) {
            UserAttributeSubpacket[] userAttributeSubpacketArr = this.subpackets;
            if (i != userAttributeSubpacketArr.length) {
                userAttributeSubpacketArr[i] = (UserAttributeSubpacket) vector.elementAt(i);
                i++;
            } else {
                return;
            }
        }
    }

    public UserAttributePacket(UserAttributeSubpacket[] userAttributeSubpacketArr) {
        this.subpackets = userAttributeSubpacketArr;
    }

    @Override // org.bouncycastle.bcpg.ContainedPacket
    public void encode(BCPGOutputStream bCPGOutputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i = 0;
        while (true) {
            UserAttributeSubpacket[] userAttributeSubpacketArr = this.subpackets;
            if (i != userAttributeSubpacketArr.length) {
                userAttributeSubpacketArr[i].encode(byteArrayOutputStream);
                i++;
            } else {
                bCPGOutputStream.writePacket(17, byteArrayOutputStream.toByteArray(), false);
                return;
            }
        }
    }

    public UserAttributeSubpacket[] getSubpackets() {
        return this.subpackets;
    }
}
