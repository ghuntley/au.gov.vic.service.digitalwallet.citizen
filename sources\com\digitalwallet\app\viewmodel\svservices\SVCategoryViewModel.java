package com.digitalwallet.app.viewmodel.svservices;

import com.digitalwallet.app.model.login.SVCategory;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.bouncycastle.i18n.MessageBundle;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\u0006\u0010\u000e\u001a\u00020\u0006R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000b¨\u0006\u000f"}, d2 = {"Lcom/digitalwallet/app/viewmodel/svservices/SVCategoryViewModel;", "", "svCategory", "Lcom/digitalwallet/app/model/login/SVCategory;", "clickAction", "Lkotlin/Function0;", "", "(Lcom/digitalwallet/app/model/login/SVCategory;Lkotlin/jvm/functions/Function0;)V", "description", "", "getDescription", "()Ljava/lang/String;", MessageBundle.TITLE_ENTRY, "getTitle", "onClicked", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: ServiceActionViewModels.kt */
public final class SVCategoryViewModel {
    private final Function0<Unit> clickAction;
    private final String description;
    private final String title;

    public SVCategoryViewModel(SVCategory sVCategory, Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(sVCategory, "svCategory");
        Intrinsics.checkNotNullParameter(function0, "clickAction");
        this.clickAction = function0;
        this.title = sVCategory.getTitle();
        this.description = sVCategory.getDescription();
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getDescription() {
        return this.description;
    }

    public final void onClicked() {
        this.clickAction.invoke();
    }
}
