package com.digitalwallet.app.viewmodel.main.sharing;

import com.digitalwallet.app.connection.NamedDevice;
import com.digitalwallet.app.model.RequestHolding;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\n\u0010\u0004\u001a\u00060\u0005j\u0002`\u00062\u0006\u0010\u0007\u001a\u00020\bH&¨\u0006\t"}, d2 = {"Lcom/digitalwallet/app/viewmodel/main/sharing/LobbyMemberView;", "", "requestHolding", "", RequestHolding.sharingCodeKey, "", "Lcom/digitalwallet/app/model/SharingCode;", "member", "Lcom/digitalwallet/app/connection/NamedDevice;", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: LobbyMemberViewModel.kt */
public interface LobbyMemberView {
    void requestHolding(String str, NamedDevice namedDevice);
}
