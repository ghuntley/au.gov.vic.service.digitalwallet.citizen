package com.digitalwallet.app.viewmodel.main;

import androidx.core.app.NotificationCompat;
import java.util.concurrent.Callable;
import kotlin.Metadata;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", NotificationCompat.CATEGORY_CALL}, k = 3, mv = {1, 4, 0})
/* compiled from: MainPagerFragmentViewModel.kt */
public final class MainPagerFragmentViewModel$logout$4<V> implements Callable<Object> {
    final /* synthetic */ MainPagerFragmentViewModel this$0;

    MainPagerFragmentViewModel$logout$4(MainPagerFragmentViewModel mainPagerFragmentViewModel) {
        this.this$0 = mainPagerFragmentViewModel;
    }

    @Override // java.util.concurrent.Callable
    public final void call() {
        this.this$0.handshakeService.reset();
    }
}
