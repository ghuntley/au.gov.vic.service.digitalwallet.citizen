package com.google.android.datatransport.cct;

import com.google.android.datatransport.cct.CctTransportBackend;
import com.google.android.datatransport.runtime.retries.Function;

/* compiled from: CctTransportBackend */
final /* synthetic */ class CctTransportBackend$$Lambda$1 implements Function {
    private final CctTransportBackend arg$1;

    private CctTransportBackend$$Lambda$1(CctTransportBackend cctTransportBackend) {
        this.arg$1 = cctTransportBackend;
    }

    public static Function lambdaFactory$(CctTransportBackend cctTransportBackend) {
        return new CctTransportBackend$$Lambda$1(cctTransportBackend);
    }

    @Override // com.google.android.datatransport.runtime.retries.Function
    public Object apply(Object obj) {
        return this.arg$1.doSend((CctTransportBackend.HttpRequest) obj);
    }
}
