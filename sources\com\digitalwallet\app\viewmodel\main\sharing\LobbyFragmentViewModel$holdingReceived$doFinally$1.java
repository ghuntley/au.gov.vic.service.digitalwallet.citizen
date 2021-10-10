package com.digitalwallet.app.viewmodel.main.sharing;

import com.digitalwallet.app.model.HoldingResponseStatus;
import com.digitalwallet.app.model.P2PMessage;
import com.digitalwallet.app.model.SecureHolding;
import com.digitalwallet.app.model.db.shares.ShareRecord;
import com.digitalwallet.app.viewmodel.main.sharing.LobbyFragmentViewModel;
import com.digitalwallet.app.viewmodel.main.sharing.LobbyViewState;
import com.digitalwallet.utilities.StandardHelperKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "status", "Lcom/digitalwallet/app/model/HoldingResponseStatus;", "secureHolding", "Lcom/digitalwallet/app/model/SecureHolding;", "invoke"}, k = 3, mv = {1, 4, 0})
/* compiled from: LobbyFragmentViewModel.kt */
public final class LobbyFragmentViewModel$holdingReceived$doFinally$1 extends Lambda implements Function2<HoldingResponseStatus, SecureHolding, Unit> {
    final /* synthetic */ P2PMessage $share;
    final /* synthetic */ LobbyFragmentViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LobbyFragmentViewModel$holdingReceived$doFinally$1(LobbyFragmentViewModel lobbyFragmentViewModel, P2PMessage p2PMessage) {
        super(2);
        this.this$0 = lobbyFragmentViewModel;
        this.$share = p2PMessage;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(HoldingResponseStatus holdingResponseStatus, SecureHolding secureHolding) {
        invoke(holdingResponseStatus, secureHolding);
        return Unit.INSTANCE;
    }

    public final void invoke(HoldingResponseStatus holdingResponseStatus, final SecureHolding secureHolding) {
        String str;
        LobbyViewState.RequestDenied requestDenied;
        Intrinsics.checkNotNullParameter(holdingResponseStatus, "status");
        LobbyFragmentViewModel lobbyFragmentViewModel = this.this$0;
        if (secureHolding == null || (str = secureHolding.holdingTypeName(lobbyFragmentViewModel.getView().getContext())) == null) {
            str = "";
        }
        lobbyFragmentViewModel.postTransaction(holdingResponseStatus, str);
        ShareRecord shareRecord = this.this$0.getRecord(holdingResponseStatus, secureHolding);
        if (shareRecord != null) {
            this.this$0.storeShareRecord(shareRecord);
        }
        int i = LobbyFragmentViewModel.WhenMappings.$EnumSwitchMapping$0[holdingResponseStatus.ordinal()];
        if (i == 1) {
            requestDenied = new LobbyViewState.RequestDenied();
        } else if (i == 2) {
            requestDenied = secureHolding != null ? new LobbyViewState.ReceivedHolding(this.$share) : new LobbyViewState.Error(new Exception("Invalid holding."));
        } else {
            throw new NoWhenBranchMatchedException();
        }
        this.this$0.getView().vibrate();
        this.this$0.changeState(requestDenied);
        StandardHelperKt.postAfter(2000, new Function0<Unit>(this) {
            /* class com.digitalwallet.app.viewmodel.main.sharing.LobbyFragmentViewModel$holdingReceived$doFinally$1.AnonymousClass2 */
            final /* synthetic */ LobbyFragmentViewModel$holdingReceived$doFinally$1 this$0;

            {
                this.this$0 = r1;
            }

            @Override // kotlin.jvm.functions.Function0
            public final void invoke() {
                this.this$0.this$0.getView().finish(secureHolding);
            }
        });
    }
}
