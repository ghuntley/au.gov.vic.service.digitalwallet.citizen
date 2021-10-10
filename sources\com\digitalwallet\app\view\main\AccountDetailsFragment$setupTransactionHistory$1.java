package com.digitalwallet.app.view.main;

import android.view.LayoutInflater;
import androidx.databinding.Observable;
import com.digitalwallet.app.databinding.FragmentAccountDetailsBinding;
import com.digitalwallet.app.databinding.ItemTransactionHistoryBinding;
import com.digitalwallet.app.model.transaction.TransactionHistoryItem;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"com/digitalwallet/app/view/main/AccountDetailsFragment$setupTransactionHistory$1", "Landroidx/databinding/Observable$OnPropertyChangedCallback;", "onPropertyChanged", "", "sender", "Landroidx/databinding/Observable;", "propertyId", "", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: AccountDetailsFragment.kt */
public final class AccountDetailsFragment$setupTransactionHistory$1 extends Observable.OnPropertyChangedCallback {
    final /* synthetic */ AccountDetailsFragment this$0;

    /* JADX WARN: Incorrect args count in method signature: ()V */
    AccountDetailsFragment$setupTransactionHistory$1(AccountDetailsFragment accountDetailsFragment) {
        this.this$0 = accountDetailsFragment;
    }

    @Override // androidx.databinding.Observable.OnPropertyChangedCallback
    public void onPropertyChanged(Observable observable, int i) {
        ((FragmentAccountDetailsBinding) this.this$0.getBinding()).historyItems.removeAllViews();
        List<TransactionHistoryItem> list = this.this$0.getViewModel().getTransHistoryItems().get();
        if (list != null) {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                ItemTransactionHistoryBinding inflate = ItemTransactionHistoryBinding.inflate(LayoutInflater.from(this.this$0.getContext()), ((FragmentAccountDetailsBinding) this.this$0.getBinding()).historyItems, true);
                Intrinsics.checkNotNullExpressionValue(inflate, "ItemTransactionHistoryBi…nding.historyItems, true)");
                inflate.setVm(it.next());
            }
        }
    }
}
