package dagger.android;

import android.app.IntentService;

public abstract class DaggerIntentService extends IntentService {
    public DaggerIntentService(String str) {
        super(str);
    }

    public void onCreate() {
        AndroidInjection.inject(this);
        super.onCreate();
    }
}
