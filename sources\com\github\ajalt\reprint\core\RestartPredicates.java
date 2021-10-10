package com.github.ajalt.reprint.core;

import com.github.ajalt.reprint.core.Reprint;

public class RestartPredicates {
    public static Reprint.RestartPredicate restartTimeouts(final int i) {
        return new Reprint.RestartPredicate() {
            /* class com.github.ajalt.reprint.core.RestartPredicates.AnonymousClass1 */
            private int timeoutRestarts = 0;

            @Override // com.github.ajalt.reprint.core.Reprint.RestartPredicate
            public boolean invoke(AuthenticationFailureReason authenticationFailureReason, int i) {
                if (authenticationFailureReason == AuthenticationFailureReason.TIMEOUT) {
                    int i2 = this.timeoutRestarts;
                    this.timeoutRestarts = i2 + 1;
                    return i2 < i;
                }
            }
        };
    }

    public static Reprint.RestartPredicate defaultPredicate() {
        return restartTimeouts(5);
    }

    public static Reprint.RestartPredicate neverRestart() {
        return new Reprint.RestartPredicate() {
            /* class com.github.ajalt.reprint.core.RestartPredicates.AnonymousClass2 */

            @Override // com.github.ajalt.reprint.core.Reprint.RestartPredicate
            public boolean invoke(AuthenticationFailureReason authenticationFailureReason, int i) {
                return false;
            }
        };
    }
}
