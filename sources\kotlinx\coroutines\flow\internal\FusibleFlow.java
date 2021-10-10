package kotlinx.coroutines.flow.internal;

import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlinx.coroutines.flow.Flow;

public interface FusibleFlow<T> extends Flow<T> {
    FusibleFlow<T> fuse(CoroutineContext coroutineContext, int i);

    public static final class DefaultImpls {
        public static /* synthetic */ FusibleFlow fuse$default(FusibleFlow fusibleFlow, CoroutineContext coroutineContext, int i, int i2, Object obj) {
            if (obj == null) {
                if ((i2 & 1) != 0) {
                    coroutineContext = EmptyCoroutineContext.INSTANCE;
                }
                if ((i2 & 2) != 0) {
                    i = -3;
                }
                return fusibleFlow.fuse(coroutineContext, i);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: fuse");
        }
    }
}
