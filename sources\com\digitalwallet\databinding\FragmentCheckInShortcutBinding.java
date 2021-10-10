package com.digitalwallet.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import au.gov.vic.service.digitalwallet.citizen.R;
import com.digitalwallet.viewmodel.checkIn.checkInShortcut.CheckInShortcutViewModel;

public abstract class FragmentCheckInShortcutBinding extends ViewDataBinding {
    public final ImageView backButton;
    public final TextView deleteButton;
    public final TextView editButton;
    public final RecyclerView favouriteList;
    public final LinearLayout featureTabs;
    public final RecyclerView historyList;
    public final LinearLayout historyListContainer;
    @Bindable
    protected CheckInShortcutViewModel mVm;
    public final ConstraintLayout titleBar;
    public final TextView titleText;

    public abstract void setVm(CheckInShortcutViewModel checkInShortcutViewModel);

    protected FragmentCheckInShortcutBinding(Object obj, View view, int i, ImageView imageView, TextView textView, TextView textView2, RecyclerView recyclerView, LinearLayout linearLayout, RecyclerView recyclerView2, LinearLayout linearLayout2, ConstraintLayout constraintLayout, TextView textView3) {
        super(obj, view, i);
        this.backButton = imageView;
        this.deleteButton = textView;
        this.editButton = textView2;
        this.favouriteList = recyclerView;
        this.featureTabs = linearLayout;
        this.historyList = recyclerView2;
        this.historyListContainer = linearLayout2;
        this.titleBar = constraintLayout;
        this.titleText = textView3;
    }

    public CheckInShortcutViewModel getVm() {
        return this.mVm;
    }

    public static FragmentCheckInShortcutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentCheckInShortcutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (FragmentCheckInShortcutBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_check_in_shortcut, viewGroup, z, obj);
    }

    public static FragmentCheckInShortcutBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentCheckInShortcutBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (FragmentCheckInShortcutBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_check_in_shortcut, null, false, obj);
    }

    public static FragmentCheckInShortcutBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentCheckInShortcutBinding bind(View view, Object obj) {
        return (FragmentCheckInShortcutBinding) bind(obj, view, R.layout.fragment_check_in_shortcut);
    }
}
