package com.google.android.datatransport.runtime.scheduling.persistence;

import com.google.android.datatransport.runtime.EventInternal;
import com.google.android.datatransport.runtime.TransportContext;
import java.util.Objects;

/* access modifiers changed from: package-private */
public final class AutoValue_PersistedEvent extends PersistedEvent {
    private final EventInternal event;
    private final long id;
    private final TransportContext transportContext;

    AutoValue_PersistedEvent(long j, TransportContext transportContext2, EventInternal eventInternal) {
        this.id = j;
        Objects.requireNonNull(transportContext2, "Null transportContext");
        this.transportContext = transportContext2;
        Objects.requireNonNull(eventInternal, "Null event");
        this.event = eventInternal;
    }

    @Override // com.google.android.datatransport.runtime.scheduling.persistence.PersistedEvent
    public long getId() {
        return this.id;
    }

    @Override // com.google.android.datatransport.runtime.scheduling.persistence.PersistedEvent
    public TransportContext getTransportContext() {
        return this.transportContext;
    }

    @Override // com.google.android.datatransport.runtime.scheduling.persistence.PersistedEvent
    public EventInternal getEvent() {
        return this.event;
    }

    public String toString() {
        return "PersistedEvent{id=" + this.id + ", transportContext=" + this.transportContext + ", event=" + this.event + "}";
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof PersistedEvent)) {
            return false;
        }
        PersistedEvent persistedEvent = (PersistedEvent) obj;
        return this.id == persistedEvent.getId() && this.transportContext.equals(persistedEvent.getTransportContext()) && this.event.equals(persistedEvent.getEvent());
    }

    public int hashCode() {
        long j = this.id;
        return ((((((int) (j ^ (j >>> 32))) ^ 1000003) * 1000003) ^ this.transportContext.hashCode()) * 1000003) ^ this.event.hashCode();
    }
}
