package com.digitalwallet.app.viewmodel.main;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 4, 0})
/* compiled from: AccountDetailsFragmentViewModel.kt */
public final /* synthetic */ class AccountDetailsFragmentViewModel$transHistoryErrorDescription$1 extends FunctionReferenceImpl implements Function0<Unit> {
    AccountDetailsFragmentViewModel$transHistoryErrorDescription$1(AccountDetailsFragmentViewModel accountDetailsFragmentViewModel) {
        super(0, accountDetailsFragmentViewModel, AccountDetailsFragmentViewModel.class, "requestTransactionHistory", "requestTransactionHistory()V", 0);
    }

    @Override // kotlin.jvm.functions.Function0
    public final void invoke() {
        ((AccountDetailsFragmentViewModel) this.receiver).requestTransactionHistory();
    }
}
