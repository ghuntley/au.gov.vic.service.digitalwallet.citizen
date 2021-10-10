package com.digitalwallet.app.view.main;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import timber.log.Timber;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 4, 0})
/* compiled from: MainActivityServer.kt */
public final class MainActivityServer$launchCitizenSharingFragment$onInvalidIdentity$1 extends Lambda implements Function0<Unit> {
    public static final MainActivityServer$launchCitizenSharingFragment$onInvalidIdentity$1 INSTANCE = new MainActivityServer$launchCitizenSharingFragment$onInvalidIdentity$1();

    MainActivityServer$launchCitizenSharingFragment$onInvalidIdentity$1() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public final void invoke() {
        Timber.e("Holding Request is invalid.", new Object[0]);
    }
}
