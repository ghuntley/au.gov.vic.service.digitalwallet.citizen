package com.google.android.gms.internal.instantapps;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.util.Log;
import com.google.android.gms.common.GoogleSignatureVerifier;

/* access modifiers changed from: package-private */
public final class zzav {
    static boolean zzg(Context context) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo("com.google.android.gms", 64);
            if (GoogleSignatureVerifier.getInstance(context).isGooglePublicSignedPackage(packageInfo)) {
                return true;
            }
            String valueOf = String.valueOf(packageInfo.packageName);
            Log.e("InstantAppsApi", valueOf.length() != 0 ? "Incorrect signature for package ".concat(valueOf) : new String("Incorrect signature for package "));
            return false;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }
}
