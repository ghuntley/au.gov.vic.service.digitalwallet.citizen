package net.openid.appauth.browser;

import android.content.ComponentName;
import android.content.Context;
import android.net.Uri;
import androidx.browser.customtabs.CustomTabsCallback;
import androidx.browser.customtabs.CustomTabsClient;
import androidx.browser.customtabs.CustomTabsIntent;
import androidx.browser.customtabs.CustomTabsServiceConnection;
import androidx.browser.customtabs.CustomTabsSession;
import java.lang.ref.WeakReference;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import net.openid.appauth.internal.Logger;
import net.openid.appauth.internal.UriUtil;

public class CustomTabManager {
    private static final long CLIENT_WAIT_TIME = 1;
    private final AtomicReference<CustomTabsClient> mClient = new AtomicReference<>();
    private final CountDownLatch mClientLatch = new CountDownLatch(1);
    private CustomTabsServiceConnection mConnection;
    private final WeakReference<Context> mContextRef;

    public CustomTabManager(Context context) {
        this.mContextRef = new WeakReference<>(context);
    }

    public synchronized void bind(String str) {
        if (this.mConnection == null) {
            this.mConnection = new CustomTabsServiceConnection() {
                /* class net.openid.appauth.browser.CustomTabManager.AnonymousClass1 */

                public void onServiceDisconnected(ComponentName componentName) {
                    Logger.debug("CustomTabsService is disconnected", new Object[0]);
                    setClient(null);
                }

                @Override // androidx.browser.customtabs.CustomTabsServiceConnection
                public void onCustomTabsServiceConnected(ComponentName componentName, CustomTabsClient customTabsClient) {
                    Logger.debug("CustomTabsService is connected", new Object[0]);
                    customTabsClient.warmup(0);
                    setClient(customTabsClient);
                }

                private void setClient(CustomTabsClient customTabsClient) {
                    CustomTabManager.this.mClient.set(customTabsClient);
                    CustomTabManager.this.mClientLatch.countDown();
                }
            };
            Context context = this.mContextRef.get();
            if (context == null || !CustomTabsClient.bindCustomTabsService(context, str, this.mConnection)) {
                Logger.info("Unable to bind custom tabs service", new Object[0]);
                this.mClientLatch.countDown();
            }
        }
    }

    public CustomTabsIntent.Builder createTabBuilder(Uri... uriArr) {
        return new CustomTabsIntent.Builder(createSession(null, uriArr));
    }

    public synchronized void dispose() {
        if (this.mConnection != null) {
            Context context = this.mContextRef.get();
            if (context != null) {
                context.unbindService(this.mConnection);
            }
            this.mClient.set(null);
            Logger.debug("CustomTabsService is disconnected", new Object[0]);
        }
    }

    public CustomTabsSession createSession(CustomTabsCallback customTabsCallback, Uri... uriArr) {
        CustomTabsClient client = getClient();
        if (client == null) {
            return null;
        }
        CustomTabsSession newSession = client.newSession(customTabsCallback);
        if (newSession == null) {
            Logger.warn("Failed to create custom tabs session through custom tabs client", new Object[0]);
            return null;
        }
        if (uriArr != null && uriArr.length > 0) {
            newSession.mayLaunchUrl(uriArr[0], null, UriUtil.toCustomTabUriBundle(uriArr, 1));
        }
        return newSession;
    }

    public CustomTabsClient getClient() {
        try {
            this.mClientLatch.await(1, TimeUnit.SECONDS);
        } catch (InterruptedException unused) {
            Logger.info("Interrupted while waiting for browser connection", new Object[0]);
            this.mClientLatch.countDown();
        }
        return this.mClient.get();
    }
}
