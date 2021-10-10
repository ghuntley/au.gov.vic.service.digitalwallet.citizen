package com.google.firebase.heartbeatinfo;

import android.content.Context;
import android.content.SharedPreferences;
import com.digitalwallet.utilities.DateFormattingHelper;

/* access modifiers changed from: package-private */
public class HeartBeatInfoStorage {
    private static final String GLOBAL = "fire-global";
    private static HeartBeatInfoStorage instance = null;
    private static final String preferencesName = "FirebaseAppHeartBeat";
    private final SharedPreferences sharedPreferences;

    private HeartBeatInfoStorage(Context context) {
        this.sharedPreferences = context.getSharedPreferences(preferencesName, 0);
    }

    HeartBeatInfoStorage(SharedPreferences sharedPreferences2) {
        this.sharedPreferences = sharedPreferences2;
    }

    /* access modifiers changed from: package-private */
    public static synchronized HeartBeatInfoStorage getInstance(Context context) {
        HeartBeatInfoStorage heartBeatInfoStorage;
        synchronized (HeartBeatInfoStorage.class) {
            if (instance == null) {
                instance = new HeartBeatInfoStorage(context);
            }
            heartBeatInfoStorage = instance;
        }
        return heartBeatInfoStorage;
    }

    /* access modifiers changed from: package-private */
    public synchronized boolean shouldSendSdkHeartBeat(String str, long j) {
        if (!this.sharedPreferences.contains(str)) {
            this.sharedPreferences.edit().putLong(str, j).apply();
            return true;
        } else if (j - this.sharedPreferences.getLong(str, -1) < DateFormattingHelper.DAY_IN_MS) {
            return false;
        } else {
            this.sharedPreferences.edit().putLong(str, j).apply();
            return true;
        }
    }

    /* access modifiers changed from: package-private */
    public synchronized boolean shouldSendGlobalHeartBeat(long j) {
        return shouldSendSdkHeartBeat(GLOBAL, j);
    }
}
