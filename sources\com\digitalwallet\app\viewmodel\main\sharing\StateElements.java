package com.digitalwallet.app.viewmodel.main.sharing;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.bouncycastle.i18n.MessageBundle;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B;\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00030\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\u0015\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\nHÆ\u0003JG\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0014\b\u0002\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00030\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\u0013\u0010\u0019\u001a\u00020\n2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u000eR\u001d\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\r¨\u0006\u001e"}, d2 = {"Lcom/digitalwallet/app/viewmodel/main/sharing/StateElements;", "", MessageBundle.TITLE_ENTRY, "", "subtitle", "Lkotlin/Function1;", "Lcom/digitalwallet/app/viewmodel/main/sharing/LobbyViewState;", "titleImg", "btnText", "isLoading", "", "(ILkotlin/jvm/functions/Function1;IIZ)V", "getBtnText", "()I", "()Z", "getSubtitle", "()Lkotlin/jvm/functions/Function1;", "getTitle", "getTitleImg", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "toString", "", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: RequestElements.kt */
public final class StateElements {
    private final int btnText;
    private final boolean isLoading;
    private final Function1<LobbyViewState, Integer> subtitle;
    private final int title;
    private final int titleImg;

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: com.digitalwallet.app.viewmodel.main.sharing.StateElements */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ StateElements copy$default(StateElements stateElements, int i, Function1 function1, int i2, int i3, boolean z, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i = stateElements.title;
        }
        if ((i4 & 2) != 0) {
            function1 = stateElements.subtitle;
        }
        if ((i4 & 4) != 0) {
            i2 = stateElements.titleImg;
        }
        if ((i4 & 8) != 0) {
            i3 = stateElements.btnText;
        }
        if ((i4 & 16) != 0) {
            z = stateElements.isLoading;
        }
        return stateElements.copy(i, function1, i2, i3, z);
    }

    public final int component1() {
        return this.title;
    }

    public final Function1<LobbyViewState, Integer> component2() {
        return this.subtitle;
    }

    public final int component3() {
        return this.titleImg;
    }

    public final int component4() {
        return this.btnText;
    }

    public final boolean component5() {
        return this.isLoading;
    }

    public final StateElements copy(int i, Function1<? super LobbyViewState, Integer> function1, int i2, int i3, boolean z) {
        Intrinsics.checkNotNullParameter(function1, "subtitle");
        return new StateElements(i, function1, i2, i3, z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof StateElements)) {
            return false;
        }
        StateElements stateElements = (StateElements) obj;
        return this.title == stateElements.title && Intrinsics.areEqual(this.subtitle, stateElements.subtitle) && this.titleImg == stateElements.titleImg && this.btnText == stateElements.btnText && this.isLoading == stateElements.isLoading;
    }

    public int hashCode() {
        int i = this.title * 31;
        Function1<LobbyViewState, Integer> function1 = this.subtitle;
        int hashCode = (((((i + (function1 != null ? function1.hashCode() : 0)) * 31) + this.titleImg) * 31) + this.btnText) * 31;
        boolean z = this.isLoading;
        if (z) {
            z = true;
        }
        int i2 = z ? 1 : 0;
        int i3 = z ? 1 : 0;
        int i4 = z ? 1 : 0;
        return hashCode + i2;
    }

    public String toString() {
        return "StateElements(title=" + this.title + ", subtitle=" + this.subtitle + ", titleImg=" + this.titleImg + ", btnText=" + this.btnText + ", isLoading=" + this.isLoading + ")";
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: kotlin.jvm.functions.Function1<? super com.digitalwallet.app.viewmodel.main.sharing.LobbyViewState, java.lang.Integer> */
    /* JADX WARN: Multi-variable type inference failed */
    public StateElements(int i, Function1<? super LobbyViewState, Integer> function1, int i2, int i3, boolean z) {
        Intrinsics.checkNotNullParameter(function1, "subtitle");
        this.title = i;
        this.subtitle = function1;
        this.titleImg = i2;
        this.btnText = i3;
        this.isLoading = z;
    }

    public final int getTitle() {
        return this.title;
    }

    public final Function1<LobbyViewState, Integer> getSubtitle() {
        return this.subtitle;
    }

    public final int getTitleImg() {
        return this.titleImg;
    }

    public final int getBtnText() {
        return this.btnText;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ StateElements(int i, Function1 function1, int i2, int i3, boolean z, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, function1, i2, i3, (i4 & 16) != 0 ? false : z);
    }

    public final boolean isLoading() {
        return this.isLoading;
    }
}
