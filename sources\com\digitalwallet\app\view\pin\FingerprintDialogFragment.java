package com.digitalwallet.app.view.pin;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import com.digitalwallet.app.databinding.LoginFingerprintDialogBinding;
import com.digitalwallet.app.viewmodel.pin.AuthViewInterface;
import com.digitalwallet.app.viewmodel.pin.FingerprintDialogFragmentViewModel;
import dagger.android.support.AndroidSupportInjection;
import java.util.HashMap;
import java.util.Objects;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u0000 \u001e2\u00020\u00012\u00020\u0002:\u0001\u001eB\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0012\u0010\u000e\u001a\u00020\u000b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J&\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\b\u0010\u0017\u001a\u00020\u000bH\u0016J\u0010\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\b\u0010\u001b\u001a\u00020\u000bH\u0016J\u0010\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\u001aH\u0016R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u001f"}, d2 = {"Lcom/digitalwallet/app/view/pin/FingerprintDialogFragment;", "Landroidx/fragment/app/DialogFragment;", "Lcom/digitalwallet/app/viewmodel/pin/AuthViewInterface;", "()V", "viewModel", "Lcom/digitalwallet/app/viewmodel/pin/FingerprintDialogFragmentViewModel;", "getViewModel", "()Lcom/digitalwallet/app/viewmodel/pin/FingerprintDialogFragmentViewModel;", "setViewModel", "(Lcom/digitalwallet/app/viewmodel/pin/FingerprintDialogFragmentViewModel;)V", "onAttach", "", "context", "Landroid/content/Context;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onStart", "startLoginActivity", "presentLogin", "", "startMainActivity", "toggleFingerprintDialog", "showDialog", "Companion", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: FingerprintDialogFragment.kt */
public final class FingerprintDialogFragment extends DialogFragment implements AuthViewInterface {
    public static final Companion Companion;
    private static final String TAG;
    private HashMap _$_findViewCache;
    @Inject
    public FingerprintDialogFragmentViewModel viewModel;

    public void _$_clearFindViewByIdCache() {
        HashMap hashMap = this._$_findViewCache;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public View _$_findCachedViewById(int i) {
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i);
        this._$_findViewCache.put(Integer.valueOf(i), findViewById);
        return findViewById;
    }

    @Override // androidx.fragment.app.Fragment, androidx.fragment.app.DialogFragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    public final FingerprintDialogFragmentViewModel getViewModel() {
        FingerprintDialogFragmentViewModel fingerprintDialogFragmentViewModel = this.viewModel;
        if (fingerprintDialogFragmentViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        return fingerprintDialogFragmentViewModel;
    }

    public final void setViewModel(FingerprintDialogFragmentViewModel fingerprintDialogFragmentViewModel) {
        Intrinsics.checkNotNullParameter(fingerprintDialogFragmentViewModel, "<set-?>");
        this.viewModel = fingerprintDialogFragmentViewModel;
    }

    @Override // androidx.fragment.app.Fragment, androidx.fragment.app.DialogFragment
    public void onAttach(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        AndroidSupportInjection.inject(this);
        super.onAttach(context);
    }

    @Override // androidx.fragment.app.Fragment, androidx.fragment.app.DialogFragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        FingerprintDialogFragmentViewModel fingerprintDialogFragmentViewModel = this.viewModel;
        if (fingerprintDialogFragmentViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        fingerprintDialogFragmentViewModel.inject(this);
        FingerprintDialogFragmentViewModel fingerprintDialogFragmentViewModel2 = this.viewModel;
        if (fingerprintDialogFragmentViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        Context context = getContext();
        Objects.requireNonNull(context, "null cannot be cast to non-null type android.content.Context");
        fingerprintDialogFragmentViewModel2.listenForFingerprint(context);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        Dialog dialog = getDialog();
        Intrinsics.checkNotNull(dialog);
        dialog.setCanceledOnTouchOutside(false);
        LoginFingerprintDialogBinding inflate = LoginFingerprintDialogBinding.inflate(layoutInflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "LoginFingerprintDialogBi…flater, container, false)");
        FingerprintDialogFragmentViewModel fingerprintDialogFragmentViewModel = this.viewModel;
        if (fingerprintDialogFragmentViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        inflate.setVm(fingerprintDialogFragmentViewModel);
        return inflate.getRoot();
    }

    @Override // androidx.fragment.app.Fragment, androidx.fragment.app.DialogFragment
    public void onStart() {
        super.onStart();
        Dialog dialog = getDialog();
        Intrinsics.checkNotNull(dialog);
        Intrinsics.checkNotNullExpressionValue(dialog, "dialog!!");
        Window window = dialog.getWindow();
        Intrinsics.checkNotNull(window);
        window.setLayout(-1, -2);
    }

    @Override // com.digitalwallet.app.viewmodel.pin.AuthViewInterface
    public void startMainActivity() {
        FragmentActivity activity = getActivity();
        if (!(activity instanceof AuthViewInterface)) {
            activity = null;
        }
        AuthViewInterface authViewInterface = (AuthViewInterface) activity;
        if (authViewInterface != null) {
            authViewInterface.startMainActivity();
        }
    }

    @Override // com.digitalwallet.app.viewmodel.pin.AuthViewInterface
    public void startLoginActivity(boolean z) {
        FragmentActivity activity = getActivity();
        if (!(activity instanceof AuthViewInterface)) {
            activity = null;
        }
        AuthViewInterface authViewInterface = (AuthViewInterface) activity;
        if (authViewInterface != null) {
            authViewInterface.startLoginActivity(z);
        }
    }

    @Override // com.digitalwallet.app.viewmodel.pin.AuthViewInterface
    public void toggleFingerprintDialog(boolean z) {
        if (!z) {
            dismiss();
            FragmentActivity activity = getActivity();
            if (!(activity instanceof AuthViewInterface)) {
                activity = null;
            }
            AuthViewInterface authViewInterface = (AuthViewInterface) activity;
            if (authViewInterface != null) {
                authViewInterface.toggleFingerprintDialog(z);
            }
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0007\u001a\u00020\bR\u0013\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/digitalwallet/app/view/pin/FingerprintDialogFragment$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "newInstance", "Lcom/digitalwallet/app/view/pin/FingerprintDialogFragment;", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
    /* compiled from: FingerprintDialogFragment.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final String getTAG() {
            return FingerprintDialogFragment.TAG;
        }

        public final FingerprintDialogFragment newInstance() {
            return new FingerprintDialogFragment();
        }
    }

    static {
        Companion companion = new Companion(null);
        Companion = companion;
        TAG = Reflection.getOrCreateKotlinClass(companion.getClass()).getSimpleName();
    }
}
