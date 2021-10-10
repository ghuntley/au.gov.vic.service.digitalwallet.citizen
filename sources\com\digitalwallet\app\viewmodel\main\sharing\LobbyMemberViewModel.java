package com.digitalwallet.app.viewmodel.main.sharing;

import androidx.lifecycle.ViewModel;
import com.digitalwallet.app.connection.NamedDevice;
import com.digitalwallet.app.model.RequestHolding;
import com.digitalwallet.utilities.AppType;
import com.digitalwallet.utilities.ServerTypeKt;
import com.google.android.gms.analytics.ecommerce.Promotion;
import io.reactivex.disposables.CompositeDisposable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B!\u0012\n\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\b\u0010\u0013\u001a\u00020\u0014H\u0014J\u0006\u0010\u0015\u001a\u00020\u0014R\u001a\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0010\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0012\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/digitalwallet/app/viewmodel/main/sharing/LobbyMemberViewModel;", "Landroidx/lifecycle/ViewModel;", RequestHolding.sharingCodeKey, "", "Lcom/digitalwallet/app/model/SharingCode;", "member", "Lcom/digitalwallet/app/connection/NamedDevice;", Promotion.ACTION_VIEW, "Lcom/digitalwallet/app/viewmodel/main/sharing/LobbyMemberView;", "(Ljava/lang/String;Lcom/digitalwallet/app/connection/NamedDevice;Lcom/digitalwallet/app/viewmodel/main/sharing/LobbyMemberView;)V", "disposables", "Lio/reactivex/disposables/CompositeDisposable;", "getDisposables", "()Lio/reactivex/disposables/CompositeDisposable;", "setDisposables", "(Lio/reactivex/disposables/CompositeDisposable;)V", "name", "getName", "()Ljava/lang/String;", "onCleared", "", "onClick", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: LobbyMemberViewModel.kt */
public final class LobbyMemberViewModel extends ViewModel {
    private CompositeDisposable disposables = new CompositeDisposable();
    private final NamedDevice member;
    private final String name;
    private final String sharingCode;
    private final LobbyMemberView view;

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 0})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[AppType.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[AppType.AUTHORITY.ordinal()] = 1;
        }
    }

    public LobbyMemberViewModel(String str, NamedDevice namedDevice, LobbyMemberView lobbyMemberView) {
        Intrinsics.checkNotNullParameter(str, RequestHolding.sharingCodeKey);
        Intrinsics.checkNotNullParameter(namedDevice, "member");
        Intrinsics.checkNotNullParameter(lobbyMemberView, Promotion.ACTION_VIEW);
        this.sharingCode = str;
        this.member = namedDevice;
        this.view = lobbyMemberView;
        this.name = namedDevice.getDetails().getName();
    }

    public final String getName() {
        return this.name;
    }

    public final void onClick() {
        if (WhenMappings.$EnumSwitchMapping$0[ServerTypeKt.getAppType().ordinal()] == 1) {
            this.view.requestHolding(this.sharingCode, this.member);
            return;
        }
        throw new IllegalStateException("Wrong app type".toString());
    }

    /* access modifiers changed from: protected */
    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        this.disposables.clear();
    }

    public final CompositeDisposable getDisposables() {
        return this.disposables;
    }

    public final void setDisposables(CompositeDisposable compositeDisposable) {
        Intrinsics.checkNotNullParameter(compositeDisposable, "<set-?>");
        this.disposables = compositeDisposable;
    }
}
