package com.digitalwallet.app.view.main;

import io.reactivex.functions.Consumer;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "accept"}, k = 3, mv = {1, 4, 0})
/* compiled from: AccountDetailsFragment.kt */
final class AccountDetailsFragment$onViewCreated$1<T> implements Consumer<Object> {
    final /* synthetic */ AccountDetailsFragment this$0;

    AccountDetailsFragment$onViewCreated$1(AccountDetailsFragment accountDetailsFragment) {
        this.this$0 = accountDetailsFragment;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object obj) {
        this.this$0.getViewModel().reload();
    }
}
