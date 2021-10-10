package com.digitalwallet.app.viewmodel.main.sharing;

import au.gov.vic.service.digitalwallet.citizen.R;
import com.digitalwallet.app.connection.HoldingRequestState;
import com.digitalwallet.app.viewmodel.main.sharing.LobbyViewState;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\"'\u0010\u0000\u001a\u001b\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002\u0012\t\u0012\u00070\u0004¢\u0006\u0002\b\u00050\u0001X\u0004¢\u0006\u0002\n\u0000\"\"\u0010\u0006\u001a\u0016\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00070\u0002\u0012\u0004\u0012\u00020\b0\u0001X\u0004¢\u0006\u0002\n\u0000\"\u0015\u0010\t\u001a\u00020\b*\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b\"\u001a\u0010\f\u001a\u00070\u0004¢\u0006\u0002\b\u0005*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"holdingRequestStateSubtitles", "", "Ljava/lang/Class;", "Lcom/digitalwallet/app/connection/HoldingRequestState;", "", "Landroidx/annotation/IdRes;", "lobbyViewStateSubtitles", "Lcom/digitalwallet/app/viewmodel/main/sharing/LobbyViewState;", "Lcom/digitalwallet/app/viewmodel/main/sharing/StateElements;", "elements", "getElements", "(Lcom/digitalwallet/app/viewmodel/main/sharing/LobbyViewState;)Lcom/digitalwallet/app/viewmodel/main/sharing/StateElements;", "subtitle", "getSubtitle", "(Lcom/digitalwallet/app/connection/HoldingRequestState;)I", "app_citizenProdRelease"}, k = 2, mv = {1, 4, 0})
/* compiled from: RequestElements.kt */
public final class RequestElementsKt {
    private static final Map<Class<? extends HoldingRequestState>, Integer> holdingRequestStateSubtitles = MapsKt.mapOf(TuplesKt.to(HoldingRequestState.Handshaking.class, Integer.valueOf((int) R.string.request_state_handshaking)), TuplesKt.to(HoldingRequestState.Requesting.class, Integer.valueOf((int) R.string.request_state_requesting)), TuplesKt.to(HoldingRequestState.WaitingForResponse.class, Integer.valueOf((int) R.string.request_state_waiting_for_response)), TuplesKt.to(HoldingRequestState.Receiving.class, Integer.valueOf((int) R.string.request_state_receiving)), TuplesKt.to(HoldingRequestState.Received.class, 0), TuplesKt.to(HoldingRequestState.Terminated.class, 0), TuplesKt.to(HoldingRequestState.Disconnected.class, 0));
    private static final Map<Class<? extends LobbyViewState>, StateElements> lobbyViewStateSubtitles = MapsKt.mapOf(TuplesKt.to(LobbyViewState.Searching.class, new StateElements(R.string.request_searching, RequestElementsKt$lobbyViewStateSubtitles$1.INSTANCE, 0, R.string.request_cancel, true)), TuplesKt.to(LobbyViewState.FoundUser.class, new StateElements(R.string.empty_string_RES_2114650224, RequestElementsKt$lobbyViewStateSubtitles$2.INSTANCE, 0, R.string.request_cancel, false, 16, null)), TuplesKt.to(LobbyViewState.RequestingHolding.class, new StateElements(R.string.request_loading, RequestElementsKt$lobbyViewStateSubtitles$3.INSTANCE, 0, R.string.request_cancel, true)), TuplesKt.to(LobbyViewState.ReceivedHolding.class, new StateElements(R.string.request_accepted, RequestElementsKt$lobbyViewStateSubtitles$4.INSTANCE, R.drawable.ic_icon_success, 0, false, 16, null)), TuplesKt.to(LobbyViewState.RequestDenied.class, new StateElements(R.string.request_denied, RequestElementsKt$lobbyViewStateSubtitles$5.INSTANCE, R.drawable.ic_red_cross, 0, false, 16, null)), TuplesKt.to(LobbyViewState.NoneFound.class, new StateElements(R.string.request_none_found, RequestElementsKt$lobbyViewStateSubtitles$6.INSTANCE, R.drawable.ic_red_cross, R.string.try_again_RES_2114650510, false, 16, null)), TuplesKt.to(LobbyViewState.ScanError.class, new StateElements(R.string.error_occurred_bluetooth, RequestElementsKt$lobbyViewStateSubtitles$7.INSTANCE, R.drawable.ic_red_cross, R.string.request_cancel, false, 16, null)), TuplesKt.to(LobbyViewState.Error.class, new StateElements(R.string.error_occurred, RequestElementsKt$lobbyViewStateSubtitles$8.INSTANCE, R.drawable.ic_red_cross, R.string.request_cancel, false, 16, null)), TuplesKt.to(LobbyViewState.DisconnectError.class, new StateElements(R.string.request_disconnected, RequestElementsKt$lobbyViewStateSubtitles$9.INSTANCE, R.drawable.ic_red_cross, R.string.request_cancel, false, 16, null)), TuplesKt.to(LobbyViewState.RequestError.class, new StateElements(R.string.error_occurred, RequestElementsKt$lobbyViewStateSubtitles$10.INSTANCE, R.drawable.ic_red_cross, R.string.request_cancel, false, 16, null)));

    public static final int getSubtitle(HoldingRequestState holdingRequestState) {
        Intrinsics.checkNotNullParameter(holdingRequestState, "$this$subtitle");
        Integer num = holdingRequestStateSubtitles.get(holdingRequestState.getClass());
        if (num != null) {
            return num.intValue();
        }
        throw new Error("Request state (" + holdingRequestState.getClass().getCanonicalName() + ") not found");
    }

    public static final StateElements getElements(LobbyViewState lobbyViewState) {
        Intrinsics.checkNotNullParameter(lobbyViewState, "$this$elements");
        StateElements stateElements = lobbyViewStateSubtitles.get(lobbyViewState.getClass());
        if (stateElements != null) {
            return stateElements;
        }
        throw new Error("Lobby view state (" + lobbyViewState.getClass().getCanonicalName() + ") not found");
    }
}
