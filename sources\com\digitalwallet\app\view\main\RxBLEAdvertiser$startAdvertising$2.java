package com.digitalwallet.app.view.main;

import android.bluetooth.le.AdvertiseData;
import android.bluetooth.le.AdvertiseSettings;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0014\u0010\u0002\u001a\u0010\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u00040\u0003H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "it", "Lio/reactivex/ObservableEmitter;", "Lcom/digitalwallet/app/view/main/RxAdvertisingEvent;", "kotlin.jvm.PlatformType", "subscribe"}, k = 3, mv = {1, 4, 0})
/* compiled from: RxBLEScanner.kt */
final class RxBLEAdvertiser$startAdvertising$2<T> implements ObservableOnSubscribe<RxAdvertisingEvent> {
    final /* synthetic */ AdvertiseData $data;
    final /* synthetic */ AdvertiseSettings $settings;
    final /* synthetic */ RxBLEAdvertiser this$0;

    RxBLEAdvertiser$startAdvertising$2(RxBLEAdvertiser rxBLEAdvertiser, AdvertiseSettings advertiseSettings, AdvertiseData advertiseData) {
        this.this$0 = rxBLEAdvertiser;
        this.$settings = advertiseSettings;
        this.$data = advertiseData;
    }

    @Override // io.reactivex.ObservableOnSubscribe
    public final void subscribe(ObservableEmitter<RxAdvertisingEvent> observableEmitter) {
        Intrinsics.checkNotNullParameter(observableEmitter, "it");
        RxBLEAdvertiser.access$getAdvertiser$p(this.this$0).startAdvertising(this.$settings, this.$data, RxBLEAdvertiser$startAdvertising$1.INSTANCE.invoke(observableEmitter));
    }
}
