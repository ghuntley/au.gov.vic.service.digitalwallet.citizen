package com.google.android.datatransport.runtime.scheduling.persistence;

import android.database.Cursor;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore;

/* access modifiers changed from: package-private */
/* compiled from: SQLiteEventStore */
public final /* synthetic */ class SQLiteEventStore$$Lambda$16 implements SQLiteEventStore.Function {
    private static final SQLiteEventStore$$Lambda$16 instance = new SQLiteEventStore$$Lambda$16();

    private SQLiteEventStore$$Lambda$16() {
    }

    public static SQLiteEventStore.Function lambdaFactory$() {
        return instance;
    }

    @Override // com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore.Function
    public Object apply(Object obj) {
        return SQLiteEventStore.lambda$readPayload$13((Cursor) obj);
    }
}
