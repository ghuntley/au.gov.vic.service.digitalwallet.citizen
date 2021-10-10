package com.digitalwallet.app.view.login;

import androidx.databinding.Observable;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"com/digitalwallet/app/view/login/HomeServicesFragment$onViewCreated$4", "Landroidx/databinding/Observable$OnPropertyChangedCallback;", "onPropertyChanged", "", "sender", "Landroidx/databinding/Observable;", "propertyId", "", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: HomeServicesFragment.kt */
public final class HomeServicesFragment$onViewCreated$4 extends Observable.OnPropertyChangedCallback {
    final /* synthetic */ HomeServicesFragment this$0;

    /* JADX WARN: Incorrect args count in method signature: ()V */
    HomeServicesFragment$onViewCreated$4(HomeServicesFragment homeServicesFragment) {
        this.this$0 = homeServicesFragment;
    }

    @Override // androidx.databinding.Observable.OnPropertyChangedCallback
    public void onPropertyChanged(Observable observable, int i) {
        this.this$0.populateFavouriteCarousel(false);
    }
}
