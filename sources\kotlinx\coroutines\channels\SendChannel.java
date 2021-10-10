package kotlinx.coroutines.channels;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.selects.SelectClause2;

public interface SendChannel<E> {
    boolean close(Throwable th);

    SelectClause2<E, SendChannel<E>> getOnSend();

    void invokeOnClose(Function1<? super Throwable, Unit> function1);

    boolean isClosedForSend();

    boolean isFull();

    boolean offer(E e);

    Object send(E e, Continuation<? super Unit> continuation);

    public static final class DefaultImpls {
        public static /* synthetic */ void isClosedForSend$annotations() {
        }

        public static /* synthetic */ void isFull$annotations() {
        }

        public static /* synthetic */ boolean close$default(SendChannel sendChannel, Throwable th, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    th = null;
                }
                return sendChannel.close(th);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: close");
        }
    }
}
