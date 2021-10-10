package dagger.android;

import android.app.Activity;
import android.app.Application;
import android.app.Fragment;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ContentProvider;
import android.content.Context;
import android.util.Log;
import androidx.core.app.NotificationCompat;
import dagger.internal.Preconditions;
import net.openid.appauth.AuthorizationRequest;

public final class AndroidInjection {
    private static final String TAG = "dagger.android";

    public static void inject(Activity activity) {
        AndroidInjector<Object> androidInjector;
        Preconditions.checkNotNull(activity, "activity");
        Application application = activity.getApplication();
        if (application instanceof HasAndroidInjector) {
            androidInjector = ((HasAndroidInjector) application).androidInjector();
            Preconditions.checkNotNull(androidInjector, "%s.androidInjector() returned null", application.getClass());
        } else if (application instanceof HasActivityInjector) {
            androidInjector = ((HasActivityInjector) application).activityInjector();
            Preconditions.checkNotNull(androidInjector, "%s.activityInjector() returned null", application.getClass());
        } else {
            throw new RuntimeException(String.format("%s does not implement %s or %s", application.getClass().getCanonicalName(), HasAndroidInjector.class.getCanonicalName(), HasActivityInjector.class.getCanonicalName()));
        }
        androidInjector.inject(activity);
    }

    public static void inject(Fragment fragment) {
        AndroidInjector<Object> androidInjector;
        Preconditions.checkNotNull(fragment, AuthorizationRequest.ResponseMode.FRAGMENT);
        Object findHasFragmentInjector = findHasFragmentInjector(fragment);
        if (findHasFragmentInjector instanceof HasAndroidInjector) {
            androidInjector = ((HasAndroidInjector) findHasFragmentInjector).androidInjector();
            Preconditions.checkNotNull(androidInjector, "%s.androidInjector() returned null", findHasFragmentInjector.getClass());
        } else if (findHasFragmentInjector instanceof HasFragmentInjector) {
            androidInjector = ((HasFragmentInjector) findHasFragmentInjector).fragmentInjector();
            Preconditions.checkNotNull(androidInjector, "%s.fragmentInjector() returned null", findHasFragmentInjector.getClass());
        } else {
            throw new RuntimeException(String.format("%s does not implement %s or %s", findHasFragmentInjector.getClass().getCanonicalName(), HasAndroidInjector.class.getCanonicalName(), HasFragmentInjector.class.getCanonicalName()));
        }
        if (Log.isLoggable(TAG, 3)) {
            Log.d(TAG, String.format("An injector for %s was found in %s", fragment.getClass().getCanonicalName(), findHasFragmentInjector.getClass().getCanonicalName()));
        }
        androidInjector.inject(fragment);
    }

    private static Object findHasFragmentInjector(Fragment fragment) {
        Fragment fragment2 = fragment;
        do {
            fragment2 = fragment2.getParentFragment();
            if (fragment2 != null) {
                if (fragment2 instanceof HasAndroidInjector) {
                    break;
                }
            } else {
                Activity activity = fragment.getActivity();
                boolean z = activity instanceof HasAndroidInjector;
                Application application = activity;
                if (!z) {
                    boolean z2 = activity instanceof HasFragmentInjector;
                    application = activity;
                    if (!z2) {
                        Application application2 = activity.getApplication();
                        boolean z3 = application2 instanceof HasAndroidInjector;
                        application = application2;
                        if (!z3) {
                            boolean z4 = application2 instanceof HasFragmentInjector;
                            application = application2;
                            if (!z4) {
                                throw new IllegalArgumentException(String.format("No injector was found for %s", fragment.getClass().getCanonicalName()));
                            }
                        }
                    }
                }
                return application;
            }
        } while (!(fragment2 instanceof HasFragmentInjector));
        return fragment2;
    }

    public static void inject(Service service) {
        AndroidInjector<Object> androidInjector;
        Preconditions.checkNotNull(service, NotificationCompat.CATEGORY_SERVICE);
        Application application = service.getApplication();
        if (application instanceof HasAndroidInjector) {
            androidInjector = ((HasAndroidInjector) application).androidInjector();
            Preconditions.checkNotNull(androidInjector, "%s.androidInjector() returned null", application.getClass());
        } else if (application instanceof HasServiceInjector) {
            androidInjector = ((HasServiceInjector) application).serviceInjector();
            Preconditions.checkNotNull(androidInjector, "%s.serviceInjector() returned null", application.getClass());
        } else {
            throw new RuntimeException(String.format("%s does not implement %s or %s", application.getClass().getCanonicalName(), HasAndroidInjector.class.getCanonicalName(), HasServiceInjector.class.getCanonicalName()));
        }
        androidInjector.inject(service);
    }

    public static void inject(BroadcastReceiver broadcastReceiver, Context context) {
        AndroidInjector<Object> androidInjector;
        Preconditions.checkNotNull(broadcastReceiver, "broadcastReceiver");
        Preconditions.checkNotNull(context, "context");
        Application application = (Application) context.getApplicationContext();
        if (application instanceof HasAndroidInjector) {
            androidInjector = ((HasAndroidInjector) application).androidInjector();
            Preconditions.checkNotNull(androidInjector, "%s.androidInjector() returned null", application.getClass());
        } else if (application instanceof HasBroadcastReceiverInjector) {
            androidInjector = ((HasBroadcastReceiverInjector) application).broadcastReceiverInjector();
            Preconditions.checkNotNull(androidInjector, "%s.broadcastReceiverInjector() returned null", application.getClass());
        } else {
            throw new RuntimeException(String.format("%s does not implement %s or %s", application.getClass().getCanonicalName(), HasAndroidInjector.class.getCanonicalName(), HasBroadcastReceiverInjector.class.getCanonicalName()));
        }
        androidInjector.inject(broadcastReceiver);
    }

    public static void inject(ContentProvider contentProvider) {
        AndroidInjector<Object> androidInjector;
        Preconditions.checkNotNull(contentProvider, "contentProvider");
        Application application = (Application) contentProvider.getContext().getApplicationContext();
        if (application instanceof HasAndroidInjector) {
            androidInjector = ((HasAndroidInjector) application).androidInjector();
            Preconditions.checkNotNull(androidInjector, "%s.androidInjector() returned null", application.getClass());
        } else if (application instanceof HasContentProviderInjector) {
            androidInjector = ((HasContentProviderInjector) application).contentProviderInjector();
            Preconditions.checkNotNull(androidInjector, "%s.contentProviderInjector() returned null", application.getClass());
        } else {
            throw new RuntimeException(String.format("%s does not implement %s or %s", application.getClass().getCanonicalName(), HasAndroidInjector.class.getCanonicalName(), HasBroadcastReceiverInjector.class.getCanonicalName()));
        }
        androidInjector.inject(contentProvider);
    }

    private AndroidInjection() {
    }
}
