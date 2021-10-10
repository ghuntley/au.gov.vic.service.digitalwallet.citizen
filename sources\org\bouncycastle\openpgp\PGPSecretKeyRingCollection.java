package org.bouncycastle.openpgp;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.bouncycastle.bcpg.BCPGOutputStream;
import org.bouncycastle.util.Strings;

public class PGPSecretKeyRingCollection {
    private List order;
    private Map secretRings;

    public PGPSecretKeyRingCollection(InputStream inputStream) throws IOException, PGPException {
        this.secretRings = new HashMap();
        this.order = new ArrayList();
        PGPObjectFactory pGPObjectFactory = new PGPObjectFactory(inputStream);
        while (true) {
            Object nextObject = pGPObjectFactory.nextObject();
            if (nextObject == null) {
                return;
            }
            if (nextObject instanceof PGPSecretKeyRing) {
                PGPSecretKeyRing pGPSecretKeyRing = (PGPSecretKeyRing) nextObject;
                Long l = new Long(pGPSecretKeyRing.getPublicKey().getKeyID());
                this.secretRings.put(l, pGPSecretKeyRing);
                this.order.add(l);
            } else {
                throw new PGPException(nextObject.getClass().getName() + " found where PGPSecretKeyRing expected");
            }
        }
    }

    public PGPSecretKeyRingCollection(Collection collection) throws IOException, PGPException {
        this.secretRings = new HashMap();
        this.order = new ArrayList();
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            PGPSecretKeyRing pGPSecretKeyRing = (PGPSecretKeyRing) it.next();
            Long l = new Long(pGPSecretKeyRing.getPublicKey().getKeyID());
            this.secretRings.put(l, pGPSecretKeyRing);
            this.order.add(l);
        }
    }

    private PGPSecretKeyRingCollection(Map map, List list) {
        this.secretRings = new HashMap();
        this.order = new ArrayList();
        this.secretRings = map;
        this.order = list;
    }

    public PGPSecretKeyRingCollection(byte[] bArr) throws IOException, PGPException {
        this(new ByteArrayInputStream(bArr));
    }

    public static PGPSecretKeyRingCollection addSecretKeyRing(PGPSecretKeyRingCollection pGPSecretKeyRingCollection, PGPSecretKeyRing pGPSecretKeyRing) {
        Long l = new Long(pGPSecretKeyRing.getPublicKey().getKeyID());
        if (!pGPSecretKeyRingCollection.secretRings.containsKey(l)) {
            HashMap hashMap = new HashMap(pGPSecretKeyRingCollection.secretRings);
            ArrayList arrayList = new ArrayList(pGPSecretKeyRingCollection.order);
            hashMap.put(l, pGPSecretKeyRing);
            arrayList.add(l);
            return new PGPSecretKeyRingCollection(hashMap, arrayList);
        }
        throw new IllegalArgumentException("Collection already contains a key with a keyID for the passed in ring.");
    }

    public static PGPSecretKeyRingCollection removeSecretKeyRing(PGPSecretKeyRingCollection pGPSecretKeyRingCollection, PGPSecretKeyRing pGPSecretKeyRing) {
        Long l = new Long(pGPSecretKeyRing.getPublicKey().getKeyID());
        if (pGPSecretKeyRingCollection.secretRings.containsKey(l)) {
            HashMap hashMap = new HashMap(pGPSecretKeyRingCollection.secretRings);
            ArrayList arrayList = new ArrayList(pGPSecretKeyRingCollection.order);
            hashMap.remove(l);
            int i = 0;
            while (true) {
                if (i >= arrayList.size()) {
                    break;
                } else if (((Long) arrayList.get(i)).longValue() == l.longValue()) {
                    arrayList.remove(i);
                    break;
                } else {
                    i++;
                }
            }
            return new PGPSecretKeyRingCollection(hashMap, arrayList);
        }
        throw new IllegalArgumentException("Collection does not contain a key with a keyID for the passed in ring.");
    }

    public boolean contains(long j) throws PGPException {
        return getSecretKey(j) != null;
    }

    public void encode(OutputStream outputStream) throws IOException {
        BCPGOutputStream bCPGOutputStream = outputStream instanceof BCPGOutputStream ? (BCPGOutputStream) outputStream : new BCPGOutputStream(outputStream);
        for (Object obj : this.order) {
            ((PGPSecretKeyRing) this.secretRings.get(obj)).encode(bCPGOutputStream);
        }
    }

    public byte[] getEncoded() throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        encode(byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    public Iterator getKeyRings() {
        return this.secretRings.values().iterator();
    }

    public Iterator getKeyRings(String str) throws PGPException {
        return getKeyRings(str, false, false);
    }

    public Iterator getKeyRings(String str, boolean z) throws PGPException {
        return getKeyRings(str, z, false);
    }

    public Iterator getKeyRings(String str, boolean z, boolean z2) throws PGPException {
        Iterator keyRings = getKeyRings();
        ArrayList arrayList = new ArrayList();
        if (z2) {
            str = Strings.toLowerCase(str);
        }
        while (keyRings.hasNext()) {
            PGPSecretKeyRing pGPSecretKeyRing = (PGPSecretKeyRing) keyRings.next();
            Iterator userIDs = pGPSecretKeyRing.getSecretKey().getUserIDs();
            while (userIDs.hasNext()) {
                String str2 = (String) userIDs.next();
                if (z2) {
                    str2 = Strings.toLowerCase(str2);
                }
                if (z) {
                    if (str2.indexOf(str) <= -1) {
                    }
                } else if (!str2.equals(str)) {
                }
                arrayList.add(pGPSecretKeyRing);
            }
        }
        return arrayList.iterator();
    }

    public PGPSecretKey getSecretKey(long j) throws PGPException {
        Iterator keyRings = getKeyRings();
        while (keyRings.hasNext()) {
            PGPSecretKey secretKey = ((PGPSecretKeyRing) keyRings.next()).getSecretKey(j);
            if (secretKey != null) {
                return secretKey;
            }
        }
        return null;
    }

    public PGPSecretKeyRing getSecretKeyRing(long j) throws PGPException {
        Long l = new Long(j);
        if (this.secretRings.containsKey(l)) {
            return (PGPSecretKeyRing) this.secretRings.get(l);
        }
        Iterator keyRings = getKeyRings();
        while (keyRings.hasNext()) {
            PGPSecretKeyRing pGPSecretKeyRing = (PGPSecretKeyRing) keyRings.next();
            if (pGPSecretKeyRing.getSecretKey(j) != null) {
                return pGPSecretKeyRing;
            }
        }
        return null;
    }

    public int size() {
        return this.order.size();
    }
}
