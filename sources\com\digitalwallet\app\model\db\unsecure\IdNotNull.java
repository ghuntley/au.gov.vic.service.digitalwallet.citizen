package com.digitalwallet.app.model.db.unsecure;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0017\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0007¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/digitalwallet/app/model/db/unsecure/IdNotNull;", "", "()V", "fromNullToValue", "", "value", "(Ljava/lang/Integer;)I", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: UnsecuredHolding.kt */
public final class IdNotNull {
    public final int fromNullToValue(Integer num) {
        Intrinsics.checkNotNull(num);
        return num.intValue();
    }
}
