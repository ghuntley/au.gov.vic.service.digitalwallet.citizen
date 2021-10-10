package com.digitalwallet.app.view.main;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import au.gov.vic.service.digitalwallet.citizen.R;
import com.digitalwallet.app.databinding.NicknameEditBinding;
import com.digitalwallet.app.view.base.BaseAppFragment;
import com.digitalwallet.app.view.util.ClickMute;
import com.digitalwallet.app.viewmodel.main.NicknameView;
import com.digitalwallet.app.viewmodel.main.NicknameViewModel;
import com.google.android.gms.analytics.ecommerce.Promotion;
import java.util.HashMap;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u0005¢\u0006\u0002\u0010\u0004J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\u001a\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0012H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\bXD¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001e\u0010\u000b\u001a\u00020\f8\u0016@\u0016X.¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0019"}, d2 = {"Lcom/digitalwallet/app/view/main/NicknameEditFragment;", "Lcom/digitalwallet/app/view/base/BaseAppFragment;", "Lcom/digitalwallet/app/databinding/NicknameEditBinding;", "Lcom/digitalwallet/app/viewmodel/main/NicknameView;", "()V", "doneMute", "Lcom/digitalwallet/app/view/util/ClickMute;", "layoutId", "", "getLayoutId", "()I", "viewModel", "Lcom/digitalwallet/app/viewmodel/main/NicknameViewModel;", "getViewModel", "()Lcom/digitalwallet/app/viewmodel/main/NicknameViewModel;", "setViewModel", "(Lcom/digitalwallet/app/viewmodel/main/NicknameViewModel;)V", "done", "", "onViewCreated", Promotion.ACTION_VIEW, "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "showWarning", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: NicknameEditFragment.kt */
public final class NicknameEditFragment extends BaseAppFragment<NicknameEditBinding> implements NicknameView {
    private HashMap _$_findViewCache;
    private final ClickMute doneMute = new ClickMute(0, 1, null);
    private final int layoutId = R.layout.nickname_edit;
    @Inject
    public NicknameViewModel viewModel;

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
    public NicknameViewModel getViewModel() {
        NicknameViewModel nicknameViewModel = this.viewModel;
        if (nicknameViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        return nicknameViewModel;
    }

    public void setViewModel(NicknameViewModel nicknameViewModel) {
        Intrinsics.checkNotNullParameter(nicknameViewModel, "<set-?>");
        this.viewModel = nicknameViewModel;
    }

    @Override // com.digitalwallet.view.base.BaseFragment, com.digitalwallet.view.base.BasicFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, Promotion.ACTION_VIEW);
        super.onViewCreated(view, bundle);
        getViewModel().setView(this);
        ((NicknameEditBinding) getBinding()).nickname.setOnEditorActionListener(new NicknameEditFragment$onViewCreated$1(this));
    }

    @Override // com.digitalwallet.app.viewmodel.main.NicknameView
    public void showWarning() {
        Toast.makeText(getContext(), (int) R.string.nickname_blank_warning, 0).show();
    }

    @Override // com.digitalwallet.app.viewmodel.main.NicknameView
    public void done() {
        this.doneMute.tryDo(new NicknameEditFragment$done$1(this));
    }
}
