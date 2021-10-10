package com.digitalwallet.app.holdings;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.service.notification.StatusBarNotification;
import androidx.core.app.NotificationCompat;
import au.gov.vic.service.digitalwallet.citizen.R;
import com.digitalwallet.app.model.DynamicHoldingDisplay;
import com.digitalwallet.app.model.DynamicHoldingRenewal;
import com.digitalwallet.app.model.db.unsecure.UnsecuredHolding;
import com.digitalwallet.app.view.pin.PinActivity;
import com.digitalwallet.utilities.DateFormattingHelper;
import io.reactivex.Completable;
import java.util.ArrayList;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

public final class HoldingExpiryPublisher extends BroadcastReceiver {
    public static final Companion Companion = new Companion(null);
    private static final String DW_CHANNEL;
    public static final String HOLDING_KEY;
    public static final String NOTIFICATION_ID_KEY;
    public static final String NOTIFICATION_KEY;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Completable deleteNotificationChannel$app_citizenProdRelease(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            Completable fromCallable = Completable.fromCallable(new HoldingExpiryPublisher$Companion$deleteNotificationChannel$1(context));
            Intrinsics.checkNotNullExpressionValue(fromCallable, "Completable.fromCallable…nel(DW_CHANNEL)\n        }");
            return fromCallable;
        }

        public final Completable scheduleNotification$app_citizenProdRelease(Context context, UnsecuredHolding unsecuredHolding) {
            Completable completable;
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(unsecuredHolding, HoldingExpiryPublisher.HOLDING_KEY);
            Object systemService = context.getSystemService(NotificationManager.class);
            Intrinsics.checkNotNullExpressionValue(systemService, "context.getSystemService…ationManager::class.java)");
            StatusBarNotification[] activeNotifications = ((NotificationManager) systemService).getActiveNotifications();
            Intrinsics.checkNotNullExpressionValue(activeNotifications, "context.getSystemService…java).activeNotifications");
            ArrayList arrayList = new ArrayList(activeNotifications.length);
            for (StatusBarNotification statusBarNotification : activeNotifications) {
                Intrinsics.checkNotNullExpressionValue(statusBarNotification, "it");
                arrayList.add(Integer.valueOf(statusBarNotification.getId()));
            }
            ArrayList arrayList2 = arrayList;
            if (Build.VERSION.SDK_INT >= 26) {
                completable = createNotificationChannel(context);
            } else {
                completable = Completable.complete();
                Intrinsics.checkNotNullExpressionValue(completable, "Completable.complete()");
            }
            if (!arrayList2.contains(Integer.valueOf(unsecuredHolding.getIdForNotification()))) {
                Completable andThen = completable.andThen(Completable.fromCallable(new HoldingExpiryPublisher$Companion$scheduleNotification$1(context, unsecuredHolding)));
                Intrinsics.checkNotNullExpressionValue(andThen, "channelCompletable.andTh…iry.\")\n                })");
                return andThen;
            }
            Completable complete = Completable.complete();
            Intrinsics.checkNotNullExpressionValue(complete, "Completable.complete()");
            return complete;
        }

        /* access modifiers changed from: public */
        private final PendingIntent generateNotificationIntent(Context context, UnsecuredHolding unsecuredHolding) {
            int idForNotification = unsecuredHolding.getIdForNotification();
            Intent intent = new Intent(context, PinActivity.class);
            intent.putExtra(HoldingExpiryPublisher.HOLDING_KEY, unsecuredHolding.getLink());
            Unit unit = Unit.INSTANCE;
            PendingIntent activity = PendingIntent.getActivity(context, idForNotification, intent, 268435456);
            Companion companion = this;
            String generateExpiryMessage = companion.generateExpiryMessage(context, unsecuredHolding);
            Notification build = new NotificationCompat.Builder(context, HoldingExpiryPublisher.DW_CHANNEL).setContentTitle(companion.generateExpiryTitle(context, unsecuredHolding)).setContentText(generateExpiryMessage).setSmallIcon(R.drawable.ic_logo_servicevic_small).setContentIntent(activity).setAutoCancel(true).setStyle(new NotificationCompat.BigTextStyle().bigText(generateExpiryMessage)).build();
            int idForNotification2 = unsecuredHolding.getIdForNotification();
            Intent intent2 = new Intent(context, HoldingExpiryPublisher.class);
            intent2.putExtra(HoldingExpiryPublisher.NOTIFICATION_KEY, build);
            intent2.putExtra(HoldingExpiryPublisher.NOTIFICATION_ID_KEY, unsecuredHolding.getIdForNotification());
            Unit unit2 = Unit.INSTANCE;
            PendingIntent broadcast = PendingIntent.getBroadcast(context, idForNotification2, intent2, 268435456);
            Intrinsics.checkNotNullExpressionValue(broadcast, "PendingIntent.getBroadca…CEL_CURRENT\n            )");
            return broadcast;
        }

        private final Completable createNotificationChannel(Context context) {
            NotificationChannel notificationChannel = new NotificationChannel(HoldingExpiryPublisher.DW_CHANNEL, context.getString(R.string.dw_channel_name), 3);
            notificationChannel.setDescription(context.getString(R.string.dw_channel_description));
            Completable fromCallable = Completable.fromCallable(new HoldingExpiryPublisher$Companion$createNotificationChannel$1(context, notificationChannel));
            Intrinsics.checkNotNullExpressionValue(fromCallable, "Completable.fromCallable…el(channel)\n            }");
            return fromCallable;
        }

        private final int notificationDays(UnsecuredHolding unsecuredHolding) {
            DynamicHoldingRenewal renewal = unsecuredHolding.getRenewal();
            if (renewal != null) {
                return renewal.getPeriod();
            }
            return 3;
        }

        /* access modifiers changed from: public */
        private final long getDelayForNotification(UnsecuredHolding unsecuredHolding) {
            long notificationDays = ((long) notificationDays(unsecuredHolding)) * DateFormattingHelper.DAY_IN_MS;
            Long timeDifference$default = DateFormattingHelper.getTimeDifference$default(DateFormattingHelper.INSTANCE, null, unsecuredHolding.getAttributes().getExpiry(), false, 1, null);
            if (timeDifference$default != null) {
                return timeDifference$default.longValue() - notificationDays;
            }
            return -1;
        }

        private final String generateExpiryTitle(Context context, UnsecuredHolding unsecuredHolding) {
            String str;
            DynamicHoldingDisplay display = unsecuredHolding.getDisplay();
            if (display == null || (str = display.getHoldingName()) == null) {
                str = context.getResources().getString(unsecuredHolding.getHoldingElements().getTitle());
                Intrinsics.checkNotNullExpressionValue(str, "context.resources.getStr…ng.holdingElements.title)");
            }
            return str + " Expires Soon";
        }

        private final String generateExpiryMessage(Context context, UnsecuredHolding unsecuredHolding) {
            String str;
            StringBuilder sb;
            String str2;
            DynamicHoldingDisplay display = unsecuredHolding.getDisplay();
            if (display == null || (str = display.getHoldingName()) == null) {
                str = context.getResources().getString(unsecuredHolding.getHoldingElements().getLowercaseTitle());
                Intrinsics.checkNotNullExpressionValue(str, "context.resources.getStr…gElements.lowercaseTitle)");
            }
            int notificationDays = notificationDays(unsecuredHolding);
            if (notificationDays == 1) {
                sb = new StringBuilder();
                sb.append(notificationDays);
                str2 = " day";
            } else {
                sb = new StringBuilder();
                sb.append(notificationDays);
                str2 = " days";
            }
            sb.append(str2);
            String sb2 = sb.toString();
            return "It looks like your " + str + " is expiring in " + sb2 + ". Time to renew it!";
        }
    }

    public void onReceive(Context context, Intent intent) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(intent, "intent");
        ((NotificationManager) context.getSystemService(NotificationManager.class)).notify(intent.getIntExtra(NOTIFICATION_ID_KEY, 0), (Notification) intent.getParcelableExtra(NOTIFICATION_KEY));
    }
}
