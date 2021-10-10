package com.digitalwallet.app.viewmodel.main.sharing;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import timber.log.Timber;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "p1", "", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 4, 0})
/* compiled from: LobbyFragmentViewModel.kt */
public final /* synthetic */ class LobbyFragmentViewModel$storeShareRecord$1 extends FunctionReferenceImpl implements Function1<Throwable, Unit> {
    public static final LobbyFragmentViewModel$storeShareRecord$1 INSTANCE = new LobbyFragmentViewModel$storeShareRecord$1();

    LobbyFragmentViewModel$storeShareRecord$1() {
        super(1, Timber.class, "e", "e(Ljava/lang/Throwable;)V", 0);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
        invoke(th);
        return Unit.INSTANCE;
    }

    public final void invoke(Throwable th) {
        Timber.e(th);
    }
}
