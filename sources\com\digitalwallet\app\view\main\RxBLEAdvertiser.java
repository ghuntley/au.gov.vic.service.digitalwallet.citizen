package com.digitalwallet.app.view.main;

import android.bluetooth.le.AdvertiseData;
import android.bluetooth.le.AdvertiseSettings;
import android.bluetooth.le.BluetoothLeAdvertiser;
import com.google.firebase.messaging.Constants;
import io.reactivex.Observable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001c\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/digitalwallet/app/view/main/RxBLEAdvertiser;", "", "advertiser", "Landroid/bluetooth/le/BluetoothLeAdvertiser;", "(Landroid/bluetooth/le/BluetoothLeAdvertiser;)V", "startAdvertising", "Lio/reactivex/Observable;", "Lcom/digitalwallet/app/view/main/RxAdvertisingEvent;", "settings", "Landroid/bluetooth/le/AdvertiseSettings;", Constants.ScionAnalytics.MessageType.DATA_MESSAGE, "Landroid/bluetooth/le/AdvertiseData;", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: RxBLEScanner.kt */
public final class RxBLEAdvertiser {
    private final BluetoothLeAdvertiser advertiser;

    public RxBLEAdvertiser(BluetoothLeAdvertiser bluetoothLeAdvertiser) {
        Intrinsics.checkNotNullParameter(bluetoothLeAdvertiser, "advertiser");
        this.advertiser = bluetoothLeAdvertiser;
    }

    public static final /* synthetic */ BluetoothLeAdvertiser access$getAdvertiser$p(RxBLEAdvertiser rxBLEAdvertiser) {
        return rxBLEAdvertiser.advertiser;
    }

    public final Observable<RxAdvertisingEvent> startAdvertising(AdvertiseSettings advertiseSettings, AdvertiseData advertiseData) {
        Intrinsics.checkNotNullParameter(advertiseSettings, "settings");
        Intrinsics.checkNotNullParameter(advertiseData, Constants.ScionAnalytics.MessageType.DATA_MESSAGE);
        RxBLEAdvertiser$startAdvertising$1 rxBLEAdvertiser$startAdvertising$1 = RxBLEAdvertiser$startAdvertising$1.INSTANCE;
        Observable<RxAdvertisingEvent> create = Observable.create(new RxBLEAdvertiser$startAdvertising$2(this, advertiseSettings, advertiseData));
        Intrinsics.checkNotNullExpressionValue(create, "Observable.create { adve…gs, data, callback(it)) }");
        return create;
    }
}
