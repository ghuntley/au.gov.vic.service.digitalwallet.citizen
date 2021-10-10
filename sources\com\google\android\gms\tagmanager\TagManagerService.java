package com.google.android.gms.tagmanager;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;

public class TagManagerService extends Service {
    public IBinder onBind(Intent intent) {
        return zzbf.zzh(this);
    }

    public static void initialize(Context context) {
        zzbf.zzi(context);
    }
}
