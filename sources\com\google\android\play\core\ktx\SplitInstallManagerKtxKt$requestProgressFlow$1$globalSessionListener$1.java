package com.google.android.play.core.ktx;

import com.google.android.play.core.splitinstall.SplitInstallSessionState;
import com.google.android.play.core.splitinstall.SplitInstallStateUpdatedListener;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.channels.ProducerScope;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "state", "Lcom/google/android/play/core/splitinstall/SplitInstallSessionState;", "onStateUpdate"}, k = 3, mv = {1, 1, 16})
/* compiled from: SplitInstallManagerKtx.kt */
public final class SplitInstallManagerKtxKt$requestProgressFlow$1$globalSessionListener$1 implements SplitInstallStateUpdatedListener {
    final /* synthetic */ Set $sessionsAlreadyOffered;
    final /* synthetic */ ProducerScope $this_callbackFlow;

    SplitInstallManagerKtxKt$requestProgressFlow$1$globalSessionListener$1(ProducerScope producerScope, Set set) {
        this.$this_callbackFlow = producerScope;
        this.$sessionsAlreadyOffered = set;
    }

    public final void onStateUpdate(SplitInstallSessionState splitInstallSessionState) {
        Intrinsics.checkParameterIsNotNull(splitInstallSessionState, "state");
        this.$sessionsAlreadyOffered.add(Integer.valueOf(splitInstallSessionState.sessionId()));
        TaskUtilsKt.tryOffer(this.$this_callbackFlow, splitInstallSessionState);
    }
}
