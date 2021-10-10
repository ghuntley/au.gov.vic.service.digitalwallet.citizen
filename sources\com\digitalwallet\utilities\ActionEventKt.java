package com.digitalwallet.utilities;

import androidx.lifecycle.MutableLiveData;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a \u0010\u0000\u001a\u00020\u0001*\u0018\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0001`\u0004\u001a3\u0010\u0005\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0006*\u0018\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00060\u00030\u0002j\b\u0012\u0004\u0012\u0002H\u0006`\u00042\u0006\u0010\u0007\u001a\u0002H\u0006¢\u0006\u0002\u0010\b*(\u0010\t\u001a\u0004\b\u0000\u0010\u0006\"\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00060\u00030\n2\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00060\u00030\n*(\u0010\u000b\u001a\u0004\b\u0000\u0010\u0006\"\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00060\u00030\u00022\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00060\u00030\u0002¨\u0006\f"}, d2 = {"post", "", "Landroidx/lifecycle/MutableLiveData;", "Lcom/digitalwallet/utilities/ActionEvent;", "Lcom/digitalwallet/utilities/MutableLiveEvent;", "postEvent", "T", "item", "(Landroidx/lifecycle/MutableLiveData;Ljava/lang/Object;)V", "LiveEvent", "Landroidx/lifecycle/LiveData;", "MutableLiveEvent", "base_citizenProdRelease"}, k = 2, mv = {1, 4, 0})
/* compiled from: ActionEvent.kt */
public final class ActionEventKt {
    public static final <T> void postEvent(MutableLiveData<ActionEvent<T>> mutableLiveData, T t) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "$this$postEvent");
        mutableLiveData.postValue(new ActionEvent<>(t));
    }

    public static final void post(MutableLiveData<ActionEvent<Unit>> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "$this$post");
        mutableLiveData.postValue(new ActionEvent<>(Unit.INSTANCE));
    }
}
