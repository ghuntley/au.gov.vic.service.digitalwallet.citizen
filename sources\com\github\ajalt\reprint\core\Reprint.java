package com.github.ajalt.reprint.core;

import android.content.Context;

public class Reprint {

    public interface Logger {
        void log(String str);

        void logException(Throwable th, String str);
    }

    public interface RestartPredicate {
        boolean invoke(AuthenticationFailureReason authenticationFailureReason, int i);
    }

    public static void initialize(Context context) {
        ReprintInternal.INSTANCE.initialize(context, null);
    }

    public static void initialize(Context context, Logger logger) {
        ReprintInternal.INSTANCE.initialize(context, logger);
    }

    public static void registerModule(ReprintModule reprintModule) {
        ReprintInternal.INSTANCE.registerModule(reprintModule);
    }

    public static boolean isHardwarePresent() {
        return ReprintInternal.INSTANCE.isHardwarePresent();
    }

    public static boolean hasFingerprintRegistered() {
        return ReprintInternal.INSTANCE.hasFingerprintRegistered();
    }

    public static void authenticate(AuthenticationListener authenticationListener) {
        authenticate(authenticationListener, RestartPredicates.defaultPredicate());
    }

    public static void authenticate(AuthenticationListener authenticationListener, RestartPredicate restartPredicate) {
        ReprintInternal.INSTANCE.authenticate(authenticationListener, restartPredicate);
    }

    public static void authenticateWithoutRestart(AuthenticationListener authenticationListener) {
        ReprintInternal.INSTANCE.authenticate(authenticationListener, RestartPredicates.neverRestart());
    }

    public static void cancelAuthentication() {
        ReprintInternal.INSTANCE.cancelAuthentication();
    }
}
