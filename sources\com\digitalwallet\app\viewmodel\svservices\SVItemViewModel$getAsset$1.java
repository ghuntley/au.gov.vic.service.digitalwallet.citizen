package com.digitalwallet.app.viewmodel.svservices;

import io.reactivex.functions.Consumer;
import kotlin.Metadata;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "accept"}, k = 3, mv = {1, 4, 0})
/* compiled from: ServiceActionViewModels.kt */
public final class SVItemViewModel$getAsset$1<T> implements Consumer<Throwable> {
    final /* synthetic */ SVItemViewModel this$0;

    SVItemViewModel$getAsset$1(SVItemViewModel sVItemViewModel) {
        this.this$0 = sVItemViewModel;
    }

    public final void accept(Throwable th) {
        this.this$0.getImageDrawable().set(this.this$0.errorIndicator);
    }
}
