package org.bouncycastle.x509;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

public class X509CollectionStoreParameters implements X509StoreParameters {
    private Collection collection;

    public X509CollectionStoreParameters(Collection collection2) {
        Objects.requireNonNull(collection2, "collection cannot be null");
        this.collection = collection2;
    }

    public Object clone() {
        return new X509CollectionStoreParameters(this.collection);
    }

    public Collection getCollection() {
        return new ArrayList(this.collection);
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("X509CollectionStoreParameters: [\n");
        stringBuffer.append("  collection: " + this.collection + "\n");
        stringBuffer.append("]");
        return stringBuffer.toString();
    }
}
