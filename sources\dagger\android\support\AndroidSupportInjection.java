package dagger.android.support;

import android.app.Application;
import android.util.Log;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import dagger.android.AndroidInjector;
import dagger.android.HasAndroidInjector;
import dagger.internal.Preconditions;
import net.openid.appauth.AuthorizationRequest;

public final class AndroidSupportInjection {
    private static final String TAG = "dagger.android.support";

    public static void inject(Fragment fragment) {
        AndroidInjector<Object> androidInjector;
        Preconditions.checkNotNull(fragment, AuthorizationRequest.ResponseMode.FRAGMENT);
        Object findHasSupportFragmentInjector = findHasSupportFragmentInjector(fragment);
        if (findHasSupportFragmentInjector instanceof HasAndroidInjector) {
            androidInjector = ((HasAndroidInjector) findHasSupportFragmentInjector).androidInjector();
            Preconditions.checkNotNull(androidInjector, "%s.androidInjector() returned null", findHasSupportFragmentInjector.getClass());
        } else if (findHasSupportFragmentInjector instanceof HasSupportFragmentInjector) {
            androidInjector = ((HasSupportFragmentInjector) findHasSupportFragmentInjector).supportFragmentInjector();
            Preconditions.checkNotNull(androidInjector, "%s.supportFragmentInjector() returned null", findHasSupportFragmentInjector.getClass());
        } else {
            throw new RuntimeException(String.format("%s does not implement %s or %s", findHasSupportFragmentInjector.getClass().getCanonicalName(), HasAndroidInjector.class.getCanonicalName(), HasSupportFragmentInjector.class.getCanonicalName()));
        }
        if (Log.isLoggable(TAG, 3)) {
            Log.d(TAG, String.format("An injector for %s was found in %s", fragment.getClass().getCanonicalName(), findHasSupportFragmentInjector.getClass().getCanonicalName()));
        }
        androidInjector.inject(fragment);
    }

    private static Object findHasSupportFragmentInjector(Fragment fragment) {
        Fragment fragment2 = fragment;
        do {
            fragment2 = fragment2.getParentFragment();
            if (fragment2 != null) {
                if (fragment2 instanceof HasAndroidInjector) {
                    break;
                }
            } else {
                FragmentActivity activity = fragment.getActivity();
                boolean z = activity instanceof HasAndroidInjector;
                Application application = activity;
                if (!z) {
                    boolean z2 = activity instanceof HasSupportFragmentInjector;
                    application = activity;
                    if (!z2) {
                        Application application2 = activity.getApplication();
                        boolean z3 = application2 instanceof HasAndroidInjector;
                        application = application2;
                        if (!z3) {
                            boolean z4 = application2 instanceof HasSupportFragmentInjector;
                            application = application2;
                            if (!z4) {
                                throw new IllegalArgumentException(String.format("No injector was found for %s", fragment.getClass().getCanonicalName()));
                            }
                        }
                    }
                }
                return application;
            }
        } while (!(fragment2 instanceof HasSupportFragmentInjector));
        return fragment2;
    }

    private AndroidSupportInjection() {
    }
}
