package com.digitalwallet.app.viewmodel.main.sharing;

import android.content.Context;
import com.digitalwallet.app.model.SecureHolding;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&J\b\u0010\b\u001a\u00020\u0003H&J\b\u0010\t\u001a\u00020\u0003H&J\b\u0010\n\u001a\u00020\u0003H&J\b\u0010\u000b\u001a\u00020\u0003H&¨\u0006\f"}, d2 = {"Lcom/digitalwallet/app/viewmodel/main/sharing/LobbyFragmentView;", "", "finish", "", "secureHolding", "Lcom/digitalwallet/app/model/SecureHolding;", "getContext", "Landroid/content/Context;", "requestCancelled", "retryRequested", "retryScan", "vibrate", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: LobbyFragmentViewModel.kt */
public interface LobbyFragmentView {
    void finish(SecureHolding secureHolding);

    Context getContext();

    void requestCancelled();

    void retryRequested();

    void retryScan();

    void vibrate();
}
