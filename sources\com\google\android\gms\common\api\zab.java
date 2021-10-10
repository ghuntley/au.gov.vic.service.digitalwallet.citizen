package com.google.android.gms.common.api;

import com.google.android.gms.common.api.PendingResult;

/* compiled from: com.google.android.gms:play-services-base@@17.4.0 */
final class zab implements PendingResult.StatusListener {
    private final /* synthetic */ Batch zaa;

    zab(Batch batch) {
        this.zaa = batch;
    }

    @Override // com.google.android.gms.common.api.PendingResult.StatusListener
    public final void onComplete(Status status) {
        Status status2;
        synchronized (Batch.zaa(this.zaa)) {
            if (!this.zaa.isCanceled()) {
                if (status.isCanceled()) {
                    Batch.zaa(this.zaa, true);
                } else if (!status.isSuccess()) {
                    Batch.zab(this.zaa, true);
                }
                Batch.zab(this.zaa);
                if (Batch.zac(this.zaa) == 0) {
                    if (Batch.zad(this.zaa)) {
                        Batch.zae(this.zaa);
                    } else {
                        if (Batch.zaf(this.zaa)) {
                            status2 = new Status(13);
                        } else {
                            status2 = Status.RESULT_SUCCESS;
                        }
                        Batch batch = this.zaa;
                        batch.setResult(new BatchResult(status2, Batch.zag(batch)));
                    }
                }
            }
        }
    }
}
