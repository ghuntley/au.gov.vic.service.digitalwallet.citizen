package kotlinx.coroutines.internal;

import kotlin.jvm.functions.Function2;

public final class ConcurrentLinkedListKt {
    private static final Symbol CLOSED = new Symbol("CLOSED");
    private static final int POINTERS_SHIFT;

    private static /* synthetic */ void CLOSED$annotations() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v12 */
    public static final <S extends Segment<S>> Object findSegmentInternal(S s, long j, Function2<? super Long, ? super S, ? extends S> function2) {
        while (true) {
            if (s.getId() >= j && !s.getRemoved()) {
                return SegmentOrClosed.m1371constructorimpl(s);
            }
            Object nextOrClosed = s.getNextOrClosed();
            if (nextOrClosed == CLOSED) {
                return SegmentOrClosed.m1371constructorimpl(CLOSED);
            }
            ConcurrentLinkedListNode concurrentLinkedListNode = (Segment) ((ConcurrentLinkedListNode) nextOrClosed);
            if (concurrentLinkedListNode == null) {
                concurrentLinkedListNode = (Segment) function2.invoke(Long.valueOf(s.getId() + 1), s);
                if (s.trySetNext(concurrentLinkedListNode)) {
                    if (s.getRemoved()) {
                        s.remove();
                    }
                }
            }
            s = concurrentLinkedListNode;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [kotlinx.coroutines.internal.ConcurrentLinkedListNode] */
    /* JADX WARNING: Unknown variable types count: 1 */
    public static final <N extends ConcurrentLinkedListNode<N>> N close(N n) {
        while (true) {
            Object nextOrClosed = n.getNextOrClosed();
            if (nextOrClosed == CLOSED) {
                return n;
            }
            ?? r0 = (ConcurrentLinkedListNode) nextOrClosed;
            if (r0 != 0) {
                n = r0;
            } else if (n.markAsClosed()) {
                return n;
            }
        }
    }
}
