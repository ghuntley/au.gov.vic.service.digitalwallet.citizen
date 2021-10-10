package com.digitalwallet.app.view.main;

import com.digitalwallet.app.model.SecureHolding;
import kotlin.Metadata;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.reflect.KProperty1;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 0})
/* compiled from: HoldingListFragment.kt */
public final /* synthetic */ class HoldingListFragment$checkForExpiringHolding$1$expiringHoldingIndex$1 extends PropertyReference1Impl {
    public static final KProperty1 INSTANCE = new HoldingListFragment$checkForExpiringHolding$1$expiringHoldingIndex$1();

    HoldingListFragment$checkForExpiringHolding$1$expiringHoldingIndex$1() {
        super(SecureHolding.class, "link", "getLink()Ljava/lang/String;", 0);
    }

    @Override // kotlin.reflect.KProperty1, kotlin.jvm.internal.PropertyReference1Impl
    public Object get(Object obj) {
        return ((SecureHolding) obj).getLink();
    }
}
