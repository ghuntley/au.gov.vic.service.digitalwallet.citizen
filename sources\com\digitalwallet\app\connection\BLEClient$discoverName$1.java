package com.digitalwallet.app.connection;

import com.digitalwallet.app.utilities.WrapNull;
import io.reactivex.functions.Function;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u0016\u0012\u0004\u0012\u00020\u0002 \u0003*\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00010\u00012\u0006\u0010\u0004\u001a\u00020\u0002H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "Lcom/digitalwallet/app/utilities/WrapNull;", "Lcom/digitalwallet/app/connection/NamedDevice;", "kotlin.jvm.PlatformType", "event", "apply"}, k = 3, mv = {1, 4, 0})
/* compiled from: BLEClient.kt */
final class BLEClient$discoverName$1<T, R> implements Function<NamedDevice, WrapNull<NamedDevice>> {
    public static final BLEClient$discoverName$1 INSTANCE = new BLEClient$discoverName$1();

    BLEClient$discoverName$1() {
    }

    public final WrapNull<NamedDevice> apply(NamedDevice namedDevice) {
        Intrinsics.checkNotNullParameter(namedDevice, "event");
        return new WrapNull<>(namedDevice);
    }
}
