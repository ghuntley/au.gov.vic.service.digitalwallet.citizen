package com.google.android.gms.analytics;

import android.content.BroadcastReceiver;

final class zzc implements Runnable {
    private final /* synthetic */ BroadcastReceiver.PendingResult zzrj;

    zzc(CampaignTrackingReceiver campaignTrackingReceiver, BroadcastReceiver.PendingResult pendingResult) {
        this.zzrj = pendingResult;
    }

    public final void run() {
        BroadcastReceiver.PendingResult pendingResult = this.zzrj;
        if (pendingResult != null) {
            pendingResult.finish();
        }
    }
}
