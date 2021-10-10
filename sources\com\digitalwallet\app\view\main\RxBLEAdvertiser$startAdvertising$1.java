package com.digitalwallet.app.view.main;

import android.bluetooth.le.AdvertiseCallback;
import android.bluetooth.le.AdvertiseSettings;
import io.reactivex.ObservableEmitter;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0015\n\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0001\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"callback", "com/digitalwallet/app/view/main/RxBLEAdvertiser$startAdvertising$1$1", "emitter", "Lio/reactivex/ObservableEmitter;", "Lcom/digitalwallet/app/view/main/RxAdvertisingEvent;", "invoke", "(Lio/reactivex/ObservableEmitter;)Lcom/digitalwallet/app/view/main/RxBLEAdvertiser$startAdvertising$1$1;"}, k = 3, mv = {1, 4, 0})
/* compiled from: RxBLEScanner.kt */
final class RxBLEAdvertiser$startAdvertising$1 extends Lambda implements Function1<ObservableEmitter<RxAdvertisingEvent>, AnonymousClass1> {
    public static final RxBLEAdvertiser$startAdvertising$1 INSTANCE = new RxBLEAdvertiser$startAdvertising$1();

    RxBLEAdvertiser$startAdvertising$1() {
        super(1);
    }

    public final AnonymousClass1 invoke(final ObservableEmitter<RxAdvertisingEvent> observableEmitter) {
        Intrinsics.checkNotNullParameter(observableEmitter, "emitter");
        return new AdvertiseCallback() {
            /* class com.digitalwallet.app.view.main.RxBLEAdvertiser$startAdvertising$1.AnonymousClass1 */

            public void onStartSuccess(AdvertiseSettings advertiseSettings) {
                Intrinsics.checkNotNullParameter(advertiseSettings, "settingsInEffect");
                super.onStartSuccess(advertiseSettings);
                observableEmitter.onNext(new AdvertisingStartSuccess(advertiseSettings));
            }

            public void onStartFailure(int i) {
                super.onStartFailure(i);
                observableEmitter.onNext(new AdvertisingStartFailure(i));
            }
        };
    }
}
