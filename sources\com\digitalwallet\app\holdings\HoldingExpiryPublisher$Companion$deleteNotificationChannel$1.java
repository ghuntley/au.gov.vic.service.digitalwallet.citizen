package com.digitalwallet.app.holdings;

import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;
import androidx.core.app.NotificationCompat;
import java.util.concurrent.Callable;
import kotlin.Metadata;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", NotificationCompat.CATEGORY_CALL}, k = 3, mv = {1, 4, 0})
/* compiled from: HoldingExpiryPublisher.kt */
public final class HoldingExpiryPublisher$Companion$deleteNotificationChannel$1<V> implements Callable<Object> {
    final /* synthetic */ Context $context;

    HoldingExpiryPublisher$Companion$deleteNotificationChannel$1(Context context) {
        this.$context = context;
    }

    @Override // java.util.concurrent.Callable
    public final void call() {
        NotificationManager notificationManager = (NotificationManager) this.$context.getSystemService(NotificationManager.class);
        notificationManager.cancelAll();
        if (Build.VERSION.SDK_INT >= 26) {
            notificationManager.deleteNotificationChannel("service_vic_channel");
        }
    }
}
