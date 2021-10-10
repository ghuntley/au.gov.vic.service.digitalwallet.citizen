package com.digitalwallet.app.viewmodel.login;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 4, 0})
/* compiled from: CreateAccountViewModel.kt */
public final class CreateAccountViewModel$doInDelay$1 implements Runnable {
    final /* synthetic */ Function0 $action;

    CreateAccountViewModel$doInDelay$1(Function0 function0) {
        this.$action = function0;
    }

    public final void run() {
        this.$action.invoke();
    }
}
