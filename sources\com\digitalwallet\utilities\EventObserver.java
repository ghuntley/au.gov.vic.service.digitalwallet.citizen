package com.digitalwallet.utilities;

import androidx.lifecycle.Observer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000*\u0004\b\u0000\u0010\u00012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u00030\u0002B\u0019\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\u0018\u0010\b\u001a\u00020\u00062\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0003H\u0016R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00060\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/digitalwallet/utilities/EventObserver;", "T", "Landroidx/lifecycle/Observer;", "Lcom/digitalwallet/utilities/ActionEvent;", "onEventUnhandledContent", "Lkotlin/Function1;", "", "(Lkotlin/jvm/functions/Function1;)V", "onChanged", "event", "base_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: ActionEvent.kt */
public final class EventObserver<T> implements Observer<ActionEvent<? extends T>> {
    private final Function1<T, Unit> onEventUnhandledContent;

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: kotlin.jvm.functions.Function1<? super T, kotlin.Unit> */
    /* JADX WARN: Multi-variable type inference failed */
    public EventObserver(Function1<? super T, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "onEventUnhandledContent");
        this.onEventUnhandledContent = function1;
    }

    @Override // androidx.lifecycle.Observer
    public /* bridge */ /* synthetic */ void onChanged(Object obj) {
        onChanged((ActionEvent) ((ActionEvent) obj));
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: kotlin.jvm.functions.Function1<T, kotlin.Unit> */
    /* JADX WARN: Multi-variable type inference failed */
    public void onChanged(ActionEvent<? extends T> actionEvent) {
        Object contentIfNotHandled;
        if (actionEvent != null && (contentIfNotHandled = actionEvent.getContentIfNotHandled()) != null) {
            this.onEventUnhandledContent.invoke(contentIfNotHandled);
        }
    }
}
