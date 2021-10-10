package com.digitalwallet.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import au.gov.vic.service.digitalwallet.citizen.R;
import com.digitalwallet.app.viewmodel.main.sharing.LobbyFragmentViewModel;

public abstract class FragmentLobbyBinding extends ViewDataBinding {
    public final LinearLayout footer;
    public final TextView header;
    public final RecyclerView lobbyMembers;
    @Bindable
    protected LobbyFragmentViewModel mVm;

    public abstract void setVm(LobbyFragmentViewModel lobbyFragmentViewModel);

    protected FragmentLobbyBinding(Object obj, View view, int i, LinearLayout linearLayout, TextView textView, RecyclerView recyclerView) {
        super(obj, view, i);
        this.footer = linearLayout;
        this.header = textView;
        this.lobbyMembers = recyclerView;
    }

    public LobbyFragmentViewModel getVm() {
        return this.mVm;
    }

    public static FragmentLobbyBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentLobbyBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (FragmentLobbyBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_lobby, viewGroup, z, obj);
    }

    public static FragmentLobbyBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentLobbyBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (FragmentLobbyBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_lobby, null, false, obj);
    }

    public static FragmentLobbyBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentLobbyBinding bind(View view, Object obj) {
        return (FragmentLobbyBinding) bind(obj, view, R.layout.fragment_lobby);
    }
}
