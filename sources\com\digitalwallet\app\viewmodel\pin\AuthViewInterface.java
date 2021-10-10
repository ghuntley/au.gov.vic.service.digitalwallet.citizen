package com.digitalwallet.app.viewmodel.pin;

public interface AuthViewInterface {
    void startLoginActivity(boolean z);

    void startMainActivity();

    void toggleFingerprintDialog(boolean z);

    public static final class DefaultImpls {
        public static /* synthetic */ void toggleFingerprintDialog$default(AuthViewInterface authViewInterface, boolean z, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    z = true;
                }
                authViewInterface.toggleFingerprintDialog(z);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: toggleFingerprintDialog");
        }

        public static /* synthetic */ void startLoginActivity$default(AuthViewInterface authViewInterface, boolean z, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    z = true;
                }
                authViewInterface.startLoginActivity(z);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: startLoginActivity");
        }
    }
}
