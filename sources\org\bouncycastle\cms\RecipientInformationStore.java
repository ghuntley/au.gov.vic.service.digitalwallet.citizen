package org.bouncycastle.cms;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class RecipientInformationStore {
    private final List all;
    private final Map table = new HashMap();

    public RecipientInformationStore(Collection collection) {
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            RecipientInformation recipientInformation = (RecipientInformation) it.next();
            RecipientId rid = recipientInformation.getRID();
            ArrayList arrayList = (ArrayList) this.table.get(rid);
            if (arrayList == null) {
                arrayList = new ArrayList(1);
                this.table.put(rid, arrayList);
            }
            arrayList.add(recipientInformation);
        }
        this.all = new ArrayList(collection);
    }

    public RecipientInformation get(RecipientId recipientId) {
        ArrayList arrayList = (ArrayList) this.table.get(recipientId);
        if (arrayList == null) {
            return null;
        }
        return (RecipientInformation) arrayList.get(0);
    }

    public Collection getRecipients() {
        return new ArrayList(this.all);
    }

    public Collection getRecipients(RecipientId recipientId) {
        ArrayList arrayList = (ArrayList) this.table.get(recipientId);
        return arrayList == null ? new ArrayList() : new ArrayList(arrayList);
    }

    public int size() {
        return this.all.size();
    }
}
