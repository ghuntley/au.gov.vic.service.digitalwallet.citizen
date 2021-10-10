package com.digitalwallet.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import au.gov.vic.service.digitalwallet.citizen.R;
import com.digitalwallet.app.viewmodel.main.sharing.LobbyMemberViewModel;

public abstract class ItemLobbyMemberBinding extends ViewDataBinding {
    @Bindable
    protected LobbyMemberViewModel mVm;

    public abstract void setVm(LobbyMemberViewModel lobbyMemberViewModel);

    protected ItemLobbyMemberBinding(Object obj, View view, int i) {
        super(obj, view, i);
    }

    public LobbyMemberViewModel getVm() {
        return this.mVm;
    }

    public static ItemLobbyMemberBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemLobbyMemberBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemLobbyMemberBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_lobby_member, viewGroup, z, obj);
    }

    public static ItemLobbyMemberBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemLobbyMemberBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemLobbyMemberBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_lobby_member, null, false, obj);
    }

    public static ItemLobbyMemberBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemLobbyMemberBinding bind(View view, Object obj) {
        return (ItemLobbyMemberBinding) bind(obj, view, R.layout.item_lobby_member);
    }
}
