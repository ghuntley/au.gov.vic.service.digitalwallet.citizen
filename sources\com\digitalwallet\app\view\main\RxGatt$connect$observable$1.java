package com.digitalwallet.app.view.main;

import android.content.Context;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0014\u0010\u0002\u001a\u0010\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u00040\u0003H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "it", "Lio/reactivex/ObservableEmitter;", "Lcom/digitalwallet/app/view/main/RxGattClientEvent;", "kotlin.jvm.PlatformType", "subscribe"}, k = 3, mv = {1, 4, 0})
/* compiled from: RxBLEScanner.kt */
final class RxGatt$connect$observable$1<T> implements ObservableOnSubscribe<RxGattClientEvent> {
    final /* synthetic */ boolean $autoConnect;
    final /* synthetic */ Context $context;
    final /* synthetic */ RxGatt this$0;

    RxGatt$connect$observable$1(RxGatt rxGatt, Context context, boolean z) {
        this.this$0 = rxGatt;
        this.$context = context;
        this.$autoConnect = z;
    }

    @Override // io.reactivex.ObservableOnSubscribe
    public final void subscribe(ObservableEmitter<RxGattClientEvent> observableEmitter) {
        Intrinsics.checkNotNullParameter(observableEmitter, "it");
        RxGatt rxGatt = this.this$0;
        RxGatt.access$setGatt$p(rxGatt, RxGatt.access$getDevice$p(rxGatt).connectGatt(this.$context, this.$autoConnect, RxGatt$connect$1.INSTANCE.invoke(observableEmitter)));
    }
}
