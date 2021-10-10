package com.digitalwallet.app.view.login;

import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import au.gov.vic.service.digitalwallet.citizen.R;
import com.digitalwallet.app.databinding.FragmentVerifyEmailBinding;
import com.digitalwallet.app.model.login.VerifyOTPRequestPayload;
import com.digitalwallet.app.view.base.BaseAppFragment;
import com.digitalwallet.app.viewmodel.login.VerifyEmailViewModel;
import com.digitalwallet.utilities.ActivityAnalyticsHelper;
import com.digitalwallet.utilities.EventObserver;
import com.digitalwallet.view.main.BackHandler;
import com.google.android.gms.analytics.ecommerce.Promotion;
import java.util.HashMap;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u001a2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001\u001aB\u0005¢\u0006\u0002\u0010\u0004J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0002J\b\u0010\u0013\u001a\u00020\u0012H\u0002J\u001a\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u0012H\u0002R\u0014\u0010\u0005\u001a\u00020\u0006XD¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\n8\u0016@\u0016X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u001b"}, d2 = {"Lcom/digitalwallet/app/view/login/VerifyEmailFragment;", "Lcom/digitalwallet/app/view/base/BaseAppFragment;", "Lcom/digitalwallet/app/databinding/FragmentVerifyEmailBinding;", "Lcom/digitalwallet/view/main/BackHandler;", "()V", "layoutId", "", "getLayoutId", "()I", "viewModel", "Lcom/digitalwallet/app/viewmodel/login/VerifyEmailViewModel;", "getViewModel", "()Lcom/digitalwallet/app/viewmodel/login/VerifyEmailViewModel;", "setViewModel", "(Lcom/digitalwallet/app/viewmodel/login/VerifyEmailViewModel;)V", "handleBack", "", "manualLogin", "", "observeEvents", "onViewCreated", Promotion.ACTION_VIEW, "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "setupViews", "Companion", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: VerifyEmailFragment.kt */
public final class VerifyEmailFragment extends BaseAppFragment<FragmentVerifyEmailBinding> implements BackHandler {
    public static final Companion Companion = new Companion(null);
    private static final String USER_API_X_TRANS_ID_KEY = "USER_API_X_TRANS_ID_KEY";
    private static final String VERIFY_OTP_REQUEST_PAYLOAD_KEY = "VERIFY_OTP_REQUEST_PAYLOAD_KEY";
    private HashMap _$_findViewCache;
    private final int layoutId = R.layout.fragment_verify_email;
    @Inject
    public VerifyEmailViewModel viewModel;

    @Override // com.digitalwallet.view.base.BaseFragment, com.digitalwallet.app.view.base.BaseAppFragment, com.digitalwallet.view.base.BasicFragment
    public void _$_clearFindViewByIdCache() {
        HashMap hashMap = this._$_findViewCache;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    @Override // com.digitalwallet.view.base.BaseFragment, com.digitalwallet.app.view.base.BaseAppFragment, com.digitalwallet.view.base.BasicFragment
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

    @Override // com.digitalwallet.view.main.BackHandler
    public boolean handleBack() {
        return true;
    }

    @Override // com.digitalwallet.view.base.BaseFragment, com.digitalwallet.app.view.base.BaseAppFragment, com.digitalwallet.view.base.BasicFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    @Override // com.digitalwallet.view.base.BaseFragment
    public int getLayoutId() {
        return this.layoutId;
    }

    @Override // com.digitalwallet.view.base.BaseFragment
    public VerifyEmailViewModel getViewModel() {
        VerifyEmailViewModel verifyEmailViewModel = this.viewModel;
        if (verifyEmailViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        return verifyEmailViewModel;
    }

    public void setViewModel(VerifyEmailViewModel verifyEmailViewModel) {
        Intrinsics.checkNotNullParameter(verifyEmailViewModel, "<set-?>");
        this.viewModel = verifyEmailViewModel;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/digitalwallet/app/view/login/VerifyEmailFragment$Companion;", "", "()V", VerifyEmailFragment.USER_API_X_TRANS_ID_KEY, "", VerifyEmailFragment.VERIFY_OTP_REQUEST_PAYLOAD_KEY, "newInstance", "Lcom/digitalwallet/app/view/login/VerifyEmailFragment;", "verifyOTPRequestPayload", "Lcom/digitalwallet/app/model/login/VerifyOTPRequestPayload;", "userApiXTransId", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
    /* compiled from: VerifyEmailFragment.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final VerifyEmailFragment newInstance(VerifyOTPRequestPayload verifyOTPRequestPayload, String str) {
            Intrinsics.checkNotNullParameter(verifyOTPRequestPayload, "verifyOTPRequestPayload");
            Intrinsics.checkNotNullParameter(str, "userApiXTransId");
            VerifyEmailFragment verifyEmailFragment = new VerifyEmailFragment();
            Bundle bundle = new Bundle();
            bundle.putParcelable(VerifyEmailFragment.VERIFY_OTP_REQUEST_PAYLOAD_KEY, verifyOTPRequestPayload);
            bundle.putString(VerifyEmailFragment.USER_API_X_TRANS_ID_KEY, str);
            Unit unit = Unit.INSTANCE;
            verifyEmailFragment.setArguments(bundle);
            return verifyEmailFragment;
        }
    }

    @Override // com.digitalwallet.view.base.BaseFragment, com.digitalwallet.view.base.BasicFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, Promotion.ACTION_VIEW);
        super.onViewCreated(view, bundle);
        ActivityAnalyticsHelper.setScreenName$default(getAnalytics(), ActivityAnalyticsHelper.Screen.CheckEmail, null, null, 6, null);
        Bundle arguments = getArguments();
        String str = null;
        VerifyOTPRequestPayload verifyOTPRequestPayload = arguments != null ? (VerifyOTPRequestPayload) arguments.getParcelable(VERIFY_OTP_REQUEST_PAYLOAD_KEY) : null;
        if (!(verifyOTPRequestPayload instanceof VerifyOTPRequestPayload)) {
            verifyOTPRequestPayload = null;
        }
        Bundle arguments2 = getArguments();
        if (arguments2 != null) {
            str = arguments2.getString(USER_API_X_TRANS_ID_KEY);
        }
        boolean z = true;
        if (verifyOTPRequestPayload != null) {
            if (str == null) {
                z = false;
            }
            if (z) {
                getViewModel().setup(verifyOTPRequestPayload, str);
                setupViews();
                observeEvents();
                return;
            }
            throw new IllegalStateException("Check failed.".toString());
        }
        throw new IllegalStateException("Check failed.".toString());
    }

    private final void setupViews() {
        TextView textView = ((FragmentVerifyEmailBinding) getBinding()).checkEmailDescription;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.checkEmailDescription");
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        ((FragmentVerifyEmailBinding) getBinding()).otpView.setOtpCompletionListener(new VerifyEmailFragment$setupViews$1(this));
    }

    private final void observeEvents() {
        getViewModel().getEmailResentEvent().observe(getViewLifecycleOwner(), new EventObserver(new VerifyEmailFragment$observeEvents$1(this)));
        getViewModel().getEmailResendFailedEvent().observe(getViewLifecycleOwner(), new EventObserver(new VerifyEmailFragment$observeEvents$2(this)));
        getViewModel().getVerificationPassedEvent().observe(getViewLifecycleOwner(), new EventObserver(new VerifyEmailFragment$observeEvents$3(this)));
        getViewModel().getVerificationFailedEvent().observe(getViewLifecycleOwner(), new EventObserver(new VerifyEmailFragment$observeEvents$4(this)));
    }

    /* access modifiers changed from: private */
    public final void manualLogin() {
        getViewModel().clearOtpInput();
        FragmentActivity activity = getActivity();
        if (!(activity instanceof LoginActivity)) {
            activity = null;
        }
        LoginActivity loginActivity = (LoginActivity) activity;
        if (loginActivity != null) {
            loginActivity.login();
        }
    }
}
