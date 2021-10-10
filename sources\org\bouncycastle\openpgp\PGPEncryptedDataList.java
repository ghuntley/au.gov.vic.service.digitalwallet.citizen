package org.bouncycastle.openpgp;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.bouncycastle.bcpg.BCPGInputStream;
import org.bouncycastle.bcpg.InputStreamPacket;
import org.bouncycastle.bcpg.PublicKeyEncSessionPacket;
import org.bouncycastle.bcpg.SymmetricKeyEncSessionPacket;

public class PGPEncryptedDataList {
    InputStreamPacket data;
    List list = new ArrayList();

    public PGPEncryptedDataList(BCPGInputStream bCPGInputStream) throws IOException {
        Object obj;
        List list2;
        while (true) {
            if (!(bCPGInputStream.nextPacketTag() == 1 || bCPGInputStream.nextPacketTag() == 3)) {
                break;
            }
            this.list.add(bCPGInputStream.readPacket());
        }
        this.data = (InputStreamPacket) bCPGInputStream.readPacket();
        for (int i = 0; i != this.list.size(); i++) {
            if (this.list.get(i) instanceof SymmetricKeyEncSessionPacket) {
                list2 = this.list;
                obj = new PGPPBEEncryptedData((SymmetricKeyEncSessionPacket) list2.get(i), this.data);
            } else {
                list2 = this.list;
                obj = new PGPPublicKeyEncryptedData((PublicKeyEncSessionPacket) list2.get(i), this.data);
            }
            list2.set(i, obj);
        }
    }

    public Object get(int i) {
        return this.list.get(i);
    }

    public Iterator getEncryptedDataObjects() {
        return this.list.iterator();
    }

    public Iterator getEncyptedDataObjects() {
        return this.list.iterator();
    }

    public boolean isEmpty() {
        return this.list.isEmpty();
    }

    public int size() {
        return this.list.size();
    }
}
