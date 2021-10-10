package com.digitalwallet.app.holdings;

import android.app.AlarmManager;
import android.content.Context;
import androidx.core.app.NotificationCompat;
import com.digitalwallet.app.holdings.HoldingExpiryPublisher;
import com.digitalwallet.app.model.db.unsecure.UnsecuredHolding;
import com.digitalwallet.utilities.DateFormattingHelper;
import java.util.concurrent.Callable;
import kotlin.Metadata;
import timber.log.Timber;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", NotificationCompat.CATEGORY_CALL}, k = 3, mv = {1, 4, 0})
/* compiled from: HoldingExpiryPublisher.kt */
public final class HoldingExpiryPublisher$Companion$scheduleNotification$1<V> implements Callable<Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ UnsecuredHolding $holding;

    HoldingExpiryPublisher$Companion$scheduleNotification$1(Context context, UnsecuredHolding unsecuredHolding) {
        this.$context = context;
        this.$holding = unsecuredHolding;
    }

    @Override // java.util.concurrent.Callable
    public final void call() {
        AlarmManager alarmManager = (AlarmManager) this.$context.getSystemService(AlarmManager.class);
        long access$getDelayForNotification = HoldingExpiryPublisher.Companion.access$getDelayForNotification(HoldingExpiryPublisher.Companion, this.$holding);
        if (access$getDelayForNotification >= 0) {
            alarmManager.setExact(0, System.currentTimeMillis() + access$getDelayForNotification, HoldingExpiryPublisher.Companion.access$generateNotificationIntent(HoldingExpiryPublisher.Companion, this.$context, this.$holding));
            return;
        }
        Timber.w("Could not schedule notification for " + DateFormattingHelper.INSTANCE.tryParseToShowDateTime(this.$holding.getAttributes().getExpiry()) + " expiry.", new Object[0]);
    }
}
