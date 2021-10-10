package com.google.android.play.core.install;

final class NativeInstallStateUpdateListener implements InstallStateUpdatedListener {
    NativeInstallStateUpdateListener() {
    }

    public native void onStateUpdate(InstallState installState);
}
