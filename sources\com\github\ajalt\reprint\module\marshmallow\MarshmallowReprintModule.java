package com.github.ajalt.reprint.module.marshmallow;

import android.content.Context;
import android.hardware.fingerprint.FingerprintManager;
import androidx.core.os.CancellationSignal;
import com.github.ajalt.library.R;
import com.github.ajalt.reprint.core.AuthenticationFailureReason;
import com.github.ajalt.reprint.core.AuthenticationListener;
import com.github.ajalt.reprint.core.Reprint;
import com.github.ajalt.reprint.core.ReprintModule;

public class MarshmallowReprintModule implements ReprintModule {
    public static final int FINGERPRINT_ACQUIRED_GOOD = 0;
    public static final int FINGERPRINT_ACQUIRED_IMAGER_DIRTY = 3;
    public static final int FINGERPRINT_ACQUIRED_INSUFFICIENT = 2;
    public static final int FINGERPRINT_ACQUIRED_PARTIAL = 1;
    public static final int FINGERPRINT_ACQUIRED_TOO_FAST = 5;
    public static final int FINGERPRINT_ACQUIRED_TOO_SLOW = 4;
    public static final int FINGERPRINT_AUTHENTICATION_FAILED = 1001;
    public static final int FINGERPRINT_ERROR_CANCELED = 5;
    public static final int FINGERPRINT_ERROR_HW_UNAVAILABLE = 1;
    public static final int FINGERPRINT_ERROR_LOCKOUT = 7;
    public static final int FINGERPRINT_ERROR_NO_SPACE = 4;
    public static final int FINGERPRINT_ERROR_TIMEOUT = 3;
    public static final int FINGERPRINT_ERROR_UNABLE_TO_PROCESS = 2;
    public static final int TAG = 1;
    private final Context context;
    private final Reprint.Logger logger;

    @Override // com.github.ajalt.reprint.core.ReprintModule
    public int tag() {
        return 1;
    }

    public MarshmallowReprintModule(Context context2, Reprint.Logger logger2) {
        this.context = context2.getApplicationContext();
        this.logger = logger2;
    }

    private FingerprintManager fingerprintManager() {
        try {
            return (FingerprintManager) this.context.getSystemService(FingerprintManager.class);
        } catch (Exception e) {
            this.logger.logException(e, "Could not get fingerprint system service on API that should support it.");
            return null;
        } catch (NoClassDefFoundError unused) {
            this.logger.log("FingerprintManager not available on this device");
            return null;
        }
    }

    @Override // com.github.ajalt.reprint.core.ReprintModule
    public boolean isHardwarePresent() {
        FingerprintManager fingerprintManager = fingerprintManager();
        if (fingerprintManager == null) {
            return false;
        }
        try {
            return fingerprintManager.isHardwareDetected();
        } catch (NullPointerException | SecurityException e) {
            this.logger.logException(e, "MarshmallowReprintModule: isHardwareDetected failed unexpectedly");
            return false;
        }
    }

    @Override // com.github.ajalt.reprint.core.ReprintModule
    public boolean hasFingerprintRegistered() throws SecurityException {
        FingerprintManager fingerprintManager = fingerprintManager();
        if (fingerprintManager == null) {
            return false;
        }
        try {
            return fingerprintManager.hasEnrolledFingerprints();
        } catch (IllegalStateException e) {
            this.logger.logException(e, "MarshmallowReprintModule: hasEnrolledFingerprints failed unexpectedly");
            return false;
        }
    }

    @Override // com.github.ajalt.reprint.core.ReprintModule
    public void authenticate(CancellationSignal cancellationSignal, AuthenticationListener authenticationListener, Reprint.RestartPredicate restartPredicate) {
        authenticate(cancellationSignal, authenticationListener, restartPredicate, 0);
    }

    /* access modifiers changed from: package-private */
    public void authenticate(CancellationSignal cancellationSignal, AuthenticationListener authenticationListener, Reprint.RestartPredicate restartPredicate, int i) throws SecurityException {
        android.os.CancellationSignal cancellationSignal2;
        FingerprintManager fingerprintManager = fingerprintManager();
        if (fingerprintManager == null) {
            authenticationListener.onFailure(AuthenticationFailureReason.UNKNOWN, true, this.context.getString(R.string.fingerprint_error_unable_to_process), 1, 5);
            return;
        }
        AuthCallback authCallback = new AuthCallback(i, restartPredicate, cancellationSignal, authenticationListener);
        if (cancellationSignal == null) {
            cancellationSignal2 = null;
        } else {
            cancellationSignal2 = (android.os.CancellationSignal) cancellationSignal.getCancellationSignalObject();
        }
        try {
            fingerprintManager.authenticate(null, cancellationSignal2, 0, authCallback, null);
        } catch (NullPointerException e) {
            this.logger.logException(e, "MarshmallowReprintModule: authenticate failed unexpectedly");
            authenticationListener.onFailure(AuthenticationFailureReason.UNKNOWN, true, this.context.getString(R.string.fingerprint_error_unable_to_process), 1, 5);
        }
    }

    /* access modifiers changed from: package-private */
    public class AuthCallback extends FingerprintManager.AuthenticationCallback {
        private final CancellationSignal cancellationSignal;
        private final AuthenticationListener listener;
        private int restartCount;
        private final Reprint.RestartPredicate restartPredicate;

        private AuthCallback(int i, Reprint.RestartPredicate restartPredicate2, CancellationSignal cancellationSignal2, AuthenticationListener authenticationListener) {
            this.restartCount = i;
            this.restartPredicate = restartPredicate2;
            this.cancellationSignal = cancellationSignal2;
            this.listener = authenticationListener;
        }

        public void onAuthenticationError(int i, CharSequence charSequence) {
            AuthenticationFailureReason authenticationFailureReason = AuthenticationFailureReason.UNKNOWN;
            if (i != 1) {
                if (i != 2) {
                    if (i == 3) {
                        authenticationFailureReason = AuthenticationFailureReason.TIMEOUT;
                    } else if (i != 4) {
                        if (i == 5) {
                            return;
                        }
                        if (i == 7) {
                            authenticationFailureReason = AuthenticationFailureReason.LOCKED_OUT;
                        }
                    }
                }
                authenticationFailureReason = AuthenticationFailureReason.SENSOR_FAILED;
            } else {
                authenticationFailureReason = AuthenticationFailureReason.HARDWARE_UNAVAILABLE;
            }
            if (i != 3 || !this.restartPredicate.invoke(authenticationFailureReason, this.restartCount)) {
                this.listener.onFailure(authenticationFailureReason, true, charSequence, 1, i);
            } else {
                MarshmallowReprintModule.this.authenticate(this.cancellationSignal, this.listener, this.restartPredicate, this.restartCount);
            }
        }

        public void onAuthenticationHelp(int i, CharSequence charSequence) {
            Reprint.RestartPredicate restartPredicate2 = this.restartPredicate;
            AuthenticationFailureReason authenticationFailureReason = AuthenticationFailureReason.SENSOR_FAILED;
            int i2 = this.restartCount;
            this.restartCount = i2 + 1;
            if (!restartPredicate2.invoke(authenticationFailureReason, i2)) {
                this.cancellationSignal.cancel();
            }
            this.listener.onFailure(AuthenticationFailureReason.SENSOR_FAILED, false, charSequence, 1, i);
        }

        public void onAuthenticationSucceeded(FingerprintManager.AuthenticationResult authenticationResult) {
            this.listener.onSuccess(1);
        }

        public void onAuthenticationFailed() {
            this.listener.onFailure(AuthenticationFailureReason.AUTHENTICATION_FAILED, false, MarshmallowReprintModule.this.context.getString(R.string.fingerprint_not_recognized), 1, 1001);
        }
    }
}
