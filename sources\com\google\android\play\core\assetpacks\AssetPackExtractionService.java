package com.google.android.play.core.assetpacks;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import com.digitalwallet.app.holdings.HoldingExpiryPublisher;
import com.google.android.play.core.internal.ag;

public class AssetPackExtractionService extends Service {
    Context a;
    j b;
    bb c;
    private final ag d = new ag("AssetPackExtractionService");
    private b e;
    private NotificationManager f;

    private final synchronized void c(Bundle bundle) {
        String string = bundle.getString("notification_title");
        String string2 = bundle.getString("notification_subtext");
        long j = bundle.getLong("notification_timeout");
        PendingIntent pendingIntent = (PendingIntent) bundle.getParcelable("notification_on_click_intent");
        Notification.Builder timeoutAfter = Build.VERSION.SDK_INT >= 26 ? new Notification.Builder(this.a, "playcore-assetpacks-service-notification-channel").setTimeoutAfter(j) : new Notification.Builder(this.a).setPriority(-2);
        if (pendingIntent != null) {
            timeoutAfter.setContentIntent(pendingIntent);
        }
        timeoutAfter.setSmallIcon(17301633).setOngoing(false).setContentTitle(string).setSubText(string2);
        if (Build.VERSION.SDK_INT >= 21) {
            timeoutAfter.setColor(bundle.getInt("notification_color")).setVisibility(-1);
        }
        Notification build = timeoutAfter.build();
        this.d.d("Starting foreground service.", new Object[0]);
        this.b.a(true);
        if (Build.VERSION.SDK_INT >= 26) {
            this.f.createNotificationChannel(new NotificationChannel("playcore-assetpacks-service-notification-channel", bundle.getString("notification_channel_name"), 2));
        }
        startForeground(-1883842196, build);
    }

    public final synchronized Bundle a(Bundle bundle) {
        int i = bundle.getInt("action_type");
        ag agVar = this.d;
        Integer valueOf = Integer.valueOf(i);
        agVar.a("updateServiceState: %d", valueOf);
        if (i == 1) {
            c(bundle);
        } else if (i == 2) {
            b();
        } else {
            this.d.b("Unknown action type received: %d", valueOf);
        }
        return new Bundle();
    }

    /* access modifiers changed from: package-private */
    public final synchronized void b() {
        this.d.d("Stopping service.", new Object[0]);
        this.b.a(false);
        stopForeground(true);
        stopSelf();
    }

    public final IBinder onBind(Intent intent) {
        return this.e;
    }

    public final void onCreate() {
        super.onCreate();
        this.d.a("onCreate", new Object[0]);
        db.j(getApplicationContext()).b(this);
        this.e = new b(this.a, this, this.c);
        this.f = (NotificationManager) this.a.getSystemService(HoldingExpiryPublisher.NOTIFICATION_KEY);
    }
}
