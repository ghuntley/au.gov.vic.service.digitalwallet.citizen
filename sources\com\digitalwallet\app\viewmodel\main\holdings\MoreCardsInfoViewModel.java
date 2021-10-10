package com.digitalwallet.app.viewmodel.main.holdings;

import android.content.Context;
import android.text.SpannableStringBuilder;
import androidx.lifecycle.MutableLiveData;
import com.digitalwallet.utilities.ActionEvent;
import com.digitalwallet.utilities.ActionEventKt;
import com.digitalwallet.viewmodel.base.BaseViewModel;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0010\u001a\u00020\bR'\u0010\u0005\u001a\u0018\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006j\b\u0012\u0004\u0012\u00020\b`\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0011"}, d2 = {"Lcom/digitalwallet/app/viewmodel/main/holdings/MoreCardsInfoViewModel;", "Lcom/digitalwallet/viewmodel/base/BaseViewModel;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "backEvent", "Landroidx/lifecycle/MutableLiveData;", "Lcom/digitalwallet/utilities/ActionEvent;", "", "Lcom/digitalwallet/utilities/MutableLiveEvent;", "getBackEvent", "()Landroidx/lifecycle/MutableLiveData;", "description4", "Landroid/text/SpannableStringBuilder;", "getDescription4", "()Landroid/text/SpannableStringBuilder;", "goBack", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: MoreCardsInfoViewModel.kt */
public final class MoreCardsInfoViewModel extends BaseViewModel {
    private final MutableLiveData<ActionEvent<Unit>> backEvent = new MutableLiveData<>();
    private final SpannableStringBuilder description4;

    @Inject
    public MoreCardsInfoViewModel(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.description4 = (SpannableStringBuilder) new MoreCardsInfoViewModel$description4$1(context).invoke();
    }

    public final SpannableStringBuilder getDescription4() {
        return this.description4;
    }

    public final MutableLiveData<ActionEvent<Unit>> getBackEvent() {
        return this.backEvent;
    }

    public final void goBack() {
        ActionEventKt.post(this.backEvent);
    }
}
