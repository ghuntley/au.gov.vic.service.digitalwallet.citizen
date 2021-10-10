package kotlinx.coroutines.debug.internal;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.debug.internal.DebugProbesImpl;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0016\u0010\u0002\u001a\u0012\u0012\u0002\b\u0003 \u0004*\b\u0012\u0002\b\u0003\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "Lkotlinx/coroutines/debug/internal/DebugCoroutineInfo;", "it", "Lkotlinx/coroutines/debug/internal/DebugProbesImpl$CoroutineOwner;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 1, 16})
/* compiled from: DebugProbesImpl.kt */
public final class DebugProbesImpl$dumpCoroutinesInfo$1$2 extends Lambda implements Function1<DebugProbesImpl.CoroutineOwner<?>, DebugCoroutineInfo> {
    public static final DebugProbesImpl$dumpCoroutinesInfo$1$2 INSTANCE = new DebugProbesImpl$dumpCoroutinesInfo$1$2();

    DebugProbesImpl$dumpCoroutinesInfo$1$2() {
        super(1);
    }

    public final DebugCoroutineInfo invoke(DebugProbesImpl.CoroutineOwner<?> coroutineOwner) {
        return coroutineOwner.info.copy();
    }
}
