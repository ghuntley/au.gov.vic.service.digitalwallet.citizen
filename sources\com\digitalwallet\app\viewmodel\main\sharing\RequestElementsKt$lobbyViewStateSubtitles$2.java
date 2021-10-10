package com.digitalwallet.app.viewmodel.main.sharing;

import au.gov.vic.service.digitalwallet.citizen.R;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/digitalwallet/app/viewmodel/main/sharing/LobbyViewState;", "invoke"}, k = 3, mv = {1, 4, 0})
/* compiled from: RequestElements.kt */
final class RequestElementsKt$lobbyViewStateSubtitles$2 extends Lambda implements Function1<LobbyViewState, Integer> {
    public static final RequestElementsKt$lobbyViewStateSubtitles$2 INSTANCE = new RequestElementsKt$lobbyViewStateSubtitles$2();

    RequestElementsKt$lobbyViewStateSubtitles$2() {
        super(1);
    }

    public final int invoke(LobbyViewState lobbyViewState) {
        Intrinsics.checkNotNullParameter(lobbyViewState, "it");
        return R.string.empty_string_RES_2114650224;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Integer invoke(LobbyViewState lobbyViewState) {
        return Integer.valueOf(invoke(lobbyViewState));
    }
}
