package com.digitalwallet.app.view.main;

import com.digitalwallet.app.model.P2PMessage;
import com.digitalwallet.app.model.RequestHolding;
import io.reactivex.Completable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "ready", "Lio/reactivex/Completable;", "kotlin.jvm.PlatformType", "accept"}, k = 3, mv = {1, 4, 0})
/* compiled from: MainActivityServer.kt */
public final class MainActivityServer$onResume$4<T> implements Consumer<Completable> {
    final /* synthetic */ MainActivityServer this$0;

    MainActivityServer$onResume$4(MainActivityServer mainActivityServer) {
        this.this$0 = mainActivityServer;
    }

    public final void accept(Completable completable) {
        this.this$0.getDisposables().add(completable.subscribe(new Action(this) {
            /* class com.digitalwallet.app.view.main.MainActivityServer$onResume$4.AnonymousClass1 */
            final /* synthetic */ MainActivityServer$onResume$4 this$0;

            {
                this.this$0 = r1;
            }

            @Override // io.reactivex.functions.Action
            public final void run() {
                this.this$0.this$0.setShareSubscriber(this.this$0.this$0.getBleServer().getBodySubject().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer<P2PMessage<RequestHolding>>(this) {
                    /* class com.digitalwallet.app.view.main.MainActivityServer$onResume$4.AnonymousClass1.AnonymousClass1 */
                    final /* synthetic */ AnonymousClass1 this$0;

                    {
                        this.this$0 = r1;
                    }

                    public final void accept(P2PMessage<RequestHolding> p2PMessage) {
                        MainActivityServer mainActivityServer = this.this$0.this$0.this$0;
                        Intrinsics.checkNotNullExpressionValue(p2PMessage, "it");
                        mainActivityServer.launchCitizenSharingFragment(p2PMessage);
                    }
                }));
                this.this$0.this$0.advertisement = this.this$0.this$0.getBleServer().startAdvertising();
            }
        }));
    }
}
