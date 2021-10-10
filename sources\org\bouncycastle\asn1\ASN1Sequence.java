package org.bouncycastle.asn1;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Vector;

public abstract class ASN1Sequence extends ASN1Object {
    private Vector seq = new Vector();

    public static ASN1Sequence getInstance(Object obj) {
        if (obj == null || (obj instanceof ASN1Sequence)) {
            return (ASN1Sequence) obj;
        }
        if (obj instanceof byte[]) {
            try {
                return getInstance(ASN1Object.fromByteArray((byte[]) obj));
            } catch (IOException e) {
                throw new IllegalArgumentException("failed to construct sequence from byte[]: " + e.getMessage());
            }
        } else {
            throw new IllegalArgumentException("unknown object in getInstance: " + obj.getClass().getName());
        }
    }

    public static ASN1Sequence getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        if (z) {
            if (!aSN1TaggedObject.isExplicit()) {
                throw new IllegalArgumentException("object implicit - explicit expected.");
            }
        } else if (aSN1TaggedObject.isExplicit()) {
            return aSN1TaggedObject instanceof BERTaggedObject ? new BERSequence(aSN1TaggedObject.getObject()) : new DERSequence(aSN1TaggedObject.getObject());
        } else {
            if (!(aSN1TaggedObject.getObject() instanceof ASN1Sequence)) {
                throw new IllegalArgumentException("unknown object in getInstance: " + aSN1TaggedObject.getClass().getName());
            }
        }
        return (ASN1Sequence) aSN1TaggedObject.getObject();
    }

    private DEREncodable getNext(Enumeration enumeration) {
        DEREncodable dEREncodable = (DEREncodable) enumeration.nextElement();
        return dEREncodable == null ? DERNull.INSTANCE : dEREncodable;
    }

    /* access modifiers changed from: protected */
    public void addObject(DEREncodable dEREncodable) {
        this.seq.addElement(dEREncodable);
    }

    /* access modifiers changed from: package-private */
    @Override // org.bouncycastle.asn1.ASN1Object
    public boolean asn1Equals(DERObject dERObject) {
        if (!(dERObject instanceof ASN1Sequence)) {
            return false;
        }
        ASN1Sequence aSN1Sequence = (ASN1Sequence) dERObject;
        if (size() != aSN1Sequence.size()) {
            return false;
        }
        Enumeration objects = getObjects();
        Enumeration objects2 = aSN1Sequence.getObjects();
        while (objects.hasMoreElements()) {
            DEREncodable next = getNext(objects);
            DEREncodable next2 = getNext(objects2);
            DERObject dERObject2 = next.getDERObject();
            DERObject dERObject3 = next2.getDERObject();
            if (dERObject2 != dERObject3 && !dERObject2.equals(dERObject3)) {
                return false;
            }
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    @Override // org.bouncycastle.asn1.DERObject, org.bouncycastle.asn1.ASN1Object
    public abstract void encode(DEROutputStream dEROutputStream) throws IOException;

    public DEREncodable getObjectAt(int i) {
        return (DEREncodable) this.seq.elementAt(i);
    }

    public Enumeration getObjects() {
        return this.seq.elements();
    }

    @Override // org.bouncycastle.asn1.ASN1Encodable, org.bouncycastle.asn1.DERObject, org.bouncycastle.asn1.ASN1Object
    public int hashCode() {
        Enumeration objects = getObjects();
        int size = size();
        while (objects.hasMoreElements()) {
            size = (size * 17) ^ getNext(objects).hashCode();
        }
        return size;
    }

    public ASN1SequenceParser parser() {
        return new ASN1SequenceParser() {
            /* class org.bouncycastle.asn1.ASN1Sequence.AnonymousClass1 */
            private int index;
            private final int max;

            {
                this.max = ASN1Sequence.this.size();
            }

            @Override // org.bouncycastle.asn1.DEREncodable
            public DERObject getDERObject() {
                return this;
            }

            @Override // org.bouncycastle.asn1.InMemoryRepresentable
            public DERObject getLoadedObject() {
                return this;
            }

            @Override // org.bouncycastle.asn1.ASN1SequenceParser
            public DEREncodable readObject() throws IOException {
                int i = this.index;
                if (i == this.max) {
                    return null;
                }
                ASN1Sequence aSN1Sequence = ASN1Sequence.this;
                this.index = i + 1;
                DEREncodable objectAt = aSN1Sequence.getObjectAt(i);
                return objectAt instanceof ASN1Sequence ? ((ASN1Sequence) objectAt).parser() : objectAt instanceof ASN1Set ? ((ASN1Set) objectAt).parser() : objectAt;
            }
        };
    }

    public int size() {
        return this.seq.size();
    }

    public String toString() {
        return this.seq.toString();
    }
}
