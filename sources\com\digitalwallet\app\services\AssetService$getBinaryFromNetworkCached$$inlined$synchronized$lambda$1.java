package com.digitalwallet.app.services;

import com.digitalwallet.app.model.Asset;
import io.reactivex.functions.Consumer;
import kotlin.Metadata;
import kotlin.Unit;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0004\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0007"}, d2 = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "accept", "com/digitalwallet/app/services/AssetService$getBinaryFromNetworkCached$1$1$1", "com/digitalwallet/app/services/AssetService$$special$$inlined$run$lambda$1"}, k = 3, mv = {1, 4, 0})
/* compiled from: AssetService.kt */
public final class AssetService$getBinaryFromNetworkCached$$inlined$synchronized$lambda$1<T> implements Consumer<Throwable> {
    final /* synthetic */ Asset $asset$inlined;
    final /* synthetic */ String $key$inlined;
    final /* synthetic */ AssetService $this_run;
    final /* synthetic */ long $timeoutSecs$inlined;
    final /* synthetic */ AssetService this$0;

    AssetService$getBinaryFromNetworkCached$$inlined$synchronized$lambda$1(AssetService assetService, String str, AssetService assetService2, Asset asset, long j) {
        this.$this_run = assetService;
        this.$key$inlined = str;
        this.this$0 = assetService2;
        this.$asset$inlined = asset;
        this.$timeoutSecs$inlined = j;
    }

    public final void accept(Throwable th) {
        synchronized (this.$this_run.retrieval) {
            this.$this_run.retrieval.remove(this.$key$inlined);
            Unit unit = Unit.INSTANCE;
        }
    }
}
