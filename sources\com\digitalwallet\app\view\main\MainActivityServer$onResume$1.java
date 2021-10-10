package com.digitalwallet.app.view.main;

import android.app.AlertDialog;
import io.reactivex.functions.Consumer;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "accept"}, k = 3, mv = {1, 4, 0})
/* compiled from: MainActivityServer.kt */
final class MainActivityServer$onResume$1<T> implements Consumer<Throwable> {
    final /* synthetic */ MainActivityServer this$0;

    MainActivityServer$onResume$1(MainActivityServer mainActivityServer) {
        this.this$0 = mainActivityServer;
    }

    public final void accept(Throwable th) {
        new AlertDialog.Builder(this.this$0).setTitle("Bluetooth not enabled").setMessage("Bluetooth is required for this app to work properly.\n\nPlease enable Bluetooth in your phone's settings.").setPositiveButton("OK", AnonymousClass1.INSTANCE).show();
    }
}
