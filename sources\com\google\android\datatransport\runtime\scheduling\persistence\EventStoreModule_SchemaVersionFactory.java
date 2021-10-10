package com.google.android.datatransport.runtime.scheduling.persistence;

import com.google.android.datatransport.runtime.dagger.internal.Factory;

public final class EventStoreModule_SchemaVersionFactory implements Factory<Integer> {
    @Override // javax.inject.Provider
    public Integer get() {
        return Integer.valueOf(schemaVersion());
    }

    public static EventStoreModule_SchemaVersionFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static int schemaVersion() {
        return EventStoreModule.schemaVersion();
    }

    private static final class InstanceHolder {
        private static final EventStoreModule_SchemaVersionFactory INSTANCE = new EventStoreModule_SchemaVersionFactory();

        private InstanceHolder() {
        }
    }
}
