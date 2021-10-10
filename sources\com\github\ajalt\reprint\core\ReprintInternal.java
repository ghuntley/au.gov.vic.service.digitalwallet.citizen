package com.github.ajalt.reprint.core;

import android.content.Context;
import android.os.Build;
import androidx.core.os.CancellationSignal;
import com.github.ajalt.library.R;
import com.github.ajalt.reprint.core.Reprint;
import com.github.ajalt.reprint.module.marshmallow.MarshmallowReprintModule;
import java.util.concurrent.atomic.AtomicReference;

/* access modifiers changed from: package-private */
public enum ReprintInternal {
    INSTANCE;
    
    public static final Reprint.Logger NULL_LOGGER = new Reprint.Logger() {
        /* class com.github.ajalt.reprint.core.ReprintInternal.AnonymousClass1 */

        @Override // com.github.ajalt.reprint.core.Reprint.Logger
        public void log(String str) {
        }

        @Override // com.github.ajalt.reprint.core.Reprint.Logger
        public void logException(Throwable th, String str) {
        }
    };
    private static final String REPRINT_SPASS_MODULE = "com.github.ajalt.reprint.module.spass.SpassReprintModule";
    private AtomicReference<CancellationSignal> cancellationSignal = new AtomicReference<>();
    private Context context;
    private ReprintModule module;

    private ReprintInternal() {
    }

    public void initialize(Context context2, Reprint.Logger logger) {
        this.context = context2.getApplicationContext();
        if (this.module == null && Build.VERSION.SDK_INT >= 17) {
            if (logger == null) {
                logger = NULL_LOGGER;
            }
            try {
                registerModule((ReprintModule) Class.forName(REPRINT_SPASS_MODULE).getConstructor(Context.class, Reprint.Logger.class).newInstance(context2, logger));
            } catch (Exception unused) {
            }
            if (Build.VERSION.SDK_INT >= 23) {
                registerModule(new MarshmallowReprintModule(context2, logger));
            }
        }
    }

    public void registerModule(ReprintModule reprintModule) {
        if (reprintModule == null) {
            return;
        }
        if ((this.module == null || reprintModule.tag() != this.module.tag()) && reprintModule.isHardwarePresent()) {
            this.module = reprintModule;
        }
    }

    public boolean isHardwarePresent() {
        ReprintModule reprintModule = this.module;
        return reprintModule != null && reprintModule.isHardwarePresent();
    }

    public boolean hasFingerprintRegistered() {
        ReprintModule reprintModule = this.module;
        return reprintModule != null && reprintModule.hasFingerprintRegistered();
    }

    public void authenticate(AuthenticationListener authenticationListener, Reprint.RestartPredicate restartPredicate) {
        ReprintModule reprintModule = this.module;
        if (reprintModule == null || !reprintModule.isHardwarePresent()) {
            authenticationListener.onFailure(AuthenticationFailureReason.NO_HARDWARE, true, getString(R.string.fingerprint_error_hw_not_available), 0, 0);
        } else if (!this.module.hasFingerprintRegistered()) {
            authenticationListener.onFailure(AuthenticationFailureReason.NO_FINGERPRINTS_REGISTERED, true, getString(R.string.fingerprint_not_recognized), 0, 0);
        } else {
            this.cancellationSignal.set(new CancellationSignal());
            this.module.authenticate(this.cancellationSignal.get(), authenticationListener, restartPredicate);
        }
    }

    public void cancelAuthentication() {
        CancellationSignal andSet = this.cancellationSignal.getAndSet(null);
        if (andSet != null) {
            try {
                andSet.cancel();
            } catch (NullPointerException unused) {
            }
        }
    }

    private String getString(int i) {
        Context context2 = this.context;
        if (context2 == null) {
            return null;
        }
        return context2.getString(i);
    }
}
