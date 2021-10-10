package com.github.ajalt.reprint.core;

import androidx.core.os.CancellationSignal;
import com.github.ajalt.reprint.core.Reprint;

public interface ReprintModule {
    void authenticate(CancellationSignal cancellationSignal, AuthenticationListener authenticationListener, Reprint.RestartPredicate restartPredicate);

    boolean hasFingerprintRegistered();

    boolean isHardwarePresent();

    int tag();
}
