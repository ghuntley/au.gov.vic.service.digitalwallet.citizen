package com.google.android.gms.common.internal;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.util.Log;
import androidx.fragment.app.Fragment;
import com.google.android.gms.common.api.internal.LifecycleFragment;

/* compiled from: com.google.android.gms:play-services-base@@17.4.0 */
public abstract class zab implements DialogInterface.OnClickListener {
    /* access modifiers changed from: protected */
    public abstract void zaa();

    public static zab zaa(Activity activity, Intent intent, int i) {
        return new zae(intent, activity, i);
    }

    public static zab zaa(Fragment fragment, Intent intent, int i) {
        return new zad(intent, fragment, i);
    }

    public static zab zaa(LifecycleFragment lifecycleFragment, Intent intent, int i) {
        return new zaf(intent, lifecycleFragment, 2);
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        try {
            zaa();
        } catch (ActivityNotFoundException e) {
            String str = "Failed to start resolution intent.";
            if (Build.FINGERPRINT.contains("generic")) {
                str = str.concat(" This may occur when resolving Google Play services connection issues on emulators with Google APIs but not Google Play Store.");
            }
            Log.e("DialogRedirect", str, e);
        } finally {
            dialogInterface.dismiss();
        }
    }
}
