package org.bouncycastle.util;

import java.util.ArrayList;
import java.util.Collection;

public class CollectionStore implements Store {
    private Collection _local;

    public CollectionStore(Collection collection) {
        this._local = new ArrayList(collection);
    }

    @Override // org.bouncycastle.util.Store
    public Collection getMatches(Selector selector) {
        if (selector == null) {
            return new ArrayList(this._local);
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj : this._local) {
            if (selector.match(obj)) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }
}
