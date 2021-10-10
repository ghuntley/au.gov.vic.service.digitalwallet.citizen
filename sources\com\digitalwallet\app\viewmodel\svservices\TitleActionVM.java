package com.digitalwallet.app.viewmodel.svservices;

import au.gov.vic.service.digitalwallet.citizen.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.bouncycastle.i18n.MessageBundle;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0002\u0010\tJ\u0006\u0010\u0010\u001a\u00020\bR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0011"}, d2 = {"Lcom/digitalwallet/app/viewmodel/svservices/TitleActionVM;", "", MessageBundle.TITLE_ENTRY, "", "isExternalAction", "", "clickAction", "Lkotlin/Function0;", "", "(Ljava/lang/String;ZLkotlin/jvm/functions/Function0;)V", "actionIconResId", "", "getActionIconResId", "()I", "getTitle", "()Ljava/lang/String;", "onClicked", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: ServiceActionViewModels.kt */
public final class TitleActionVM {
    private final int actionIconResId;
    private final Function0<Unit> clickAction;
    private final String title;

    public TitleActionVM(String str, boolean z, Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(str, MessageBundle.TITLE_ENTRY);
        Intrinsics.checkNotNullParameter(function0, "clickAction");
        this.title = str;
        this.clickAction = function0;
        this.actionIconResId = z ? R.drawable.ic_link_out : R.drawable.ic_control_next_slate;
    }

    public final String getTitle() {
        return this.title;
    }

    public final int getActionIconResId() {
        return this.actionIconResId;
    }

    public final void onClicked() {
        this.clickAction.invoke();
    }
}
