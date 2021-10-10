package com.digitalwallet.app.connection;

import android.widget.Toast;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 4, 0})
/* compiled from: BLEClient.kt */
final class BLEClient$scan$1 implements Runnable {
    final /* synthetic */ BLEClient this$0;

    BLEClient$scan$1(BLEClient bLEClient) {
        this.this$0 = bLEClient;
    }

    public final void run() {
        this.this$0.analytics.viewItem("Error", "Bluetooth error - autofix");
        Toast.makeText(this.this$0.application, "Bluetooth issues occurred.\nAttempting to fix.", 1).show();
    }
}
