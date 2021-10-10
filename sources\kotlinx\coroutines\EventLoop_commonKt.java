package kotlinx.coroutines;

import kotlin.jvm.internal.LongCompanionObject;
import kotlinx.coroutines.internal.Symbol;

public final class EventLoop_commonKt {
    private static final Symbol CLOSED_EMPTY = new Symbol("CLOSED_EMPTY");
    private static final Symbol DISPOSED_TASK = new Symbol("REMOVED_TASK");
    private static final long MAX_DELAY_NS;
    private static final long MAX_MS;
    private static final long MS_TO_NS;
    private static final int SCHEDULE_COMPLETED;
    private static final int SCHEDULE_DISPOSED;
    private static final int SCHEDULE_OK;

    private static /* synthetic */ void CLOSED_EMPTY$annotations() {
    }

    private static /* synthetic */ void DISPOSED_TASK$annotations() {
    }

    public static final long delayToNanos(long j) {
        if (j <= 0) {
            return 0;
        }
        return j >= MAX_MS ? LongCompanionObject.MAX_VALUE : MS_TO_NS * j;
    }

    public static final long delayNanosToMillis(long j) {
        return j / MS_TO_NS;
    }
}
