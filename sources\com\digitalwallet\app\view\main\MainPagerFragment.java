package com.digitalwallet.app.view.main;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;
import au.gov.vic.service.digitalwallet.citizen.R;
import com.digitalwallet.app.databinding.FragmentMainPagerBinding;
import com.digitalwallet.app.view.base.BaseAppFragment;
import com.digitalwallet.app.view.main.adapter.AccountPagerAdapter;
import com.digitalwallet.app.view.main.adapter.ServicePagerAdapter;
import com.digitalwallet.app.viewmodel.main.MainPagerFragmentViewModel;
import com.google.android.gms.analytics.ecommerce.Promotion;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Objects;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00172\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0017B\u0005¢\u0006\u0002\u0010\u0003J\u001a\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\u0010\u0010\u0014\u001a\n \u0016*\u0004\u0018\u00010\u00150\u0015H\u0002R\u0014\u0010\u0004\u001a\u00020\u0005XD¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001e\u0010\b\u001a\u00020\t8\u0016@\u0016X.¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u0018"}, d2 = {"Lcom/digitalwallet/app/view/main/MainPagerFragment;", "Lcom/digitalwallet/app/view/base/BaseAppFragment;", "Lcom/digitalwallet/app/databinding/FragmentMainPagerBinding;", "()V", "layoutId", "", "getLayoutId", "()I", "viewModel", "Lcom/digitalwallet/app/viewmodel/main/MainPagerFragmentViewModel;", "getViewModel", "()Lcom/digitalwallet/app/viewmodel/main/MainPagerFragmentViewModel;", "setViewModel", "(Lcom/digitalwallet/app/viewmodel/main/MainPagerFragmentViewModel;)V", "onViewCreated", "", Promotion.ACTION_VIEW, "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "showLogoutDialog", "Landroidx/appcompat/app/AlertDialog;", "kotlin.jvm.PlatformType", "Companion", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: MainPagerFragment.kt */
public final class MainPagerFragment extends BaseAppFragment<FragmentMainPagerBinding> {
    public static final Companion Companion = new Companion(null);
    public static final String typeKey = "type";
    private HashMap _$_findViewCache;
    private final int layoutId = R.layout.fragment_main_pager;
    @Inject
    public MainPagerFragmentViewModel viewModel;

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 0})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[MainFragmentType.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[MainFragmentType.Account.ordinal()] = 1;
            iArr[MainFragmentType.Service.ordinal()] = 2;
        }
    }

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
    public MainPagerFragmentViewModel getViewModel() {
        MainPagerFragmentViewModel mainPagerFragmentViewModel = this.viewModel;
        if (mainPagerFragmentViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        return mainPagerFragmentViewModel;
    }

    public void setViewModel(MainPagerFragmentViewModel mainPagerFragmentViewModel) {
        Intrinsics.checkNotNullParameter(mainPagerFragmentViewModel, "<set-?>");
        this.viewModel = mainPagerFragmentViewModel;
    }

    @Override // com.digitalwallet.view.base.BaseFragment, com.digitalwallet.view.base.BasicFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, Promotion.ACTION_VIEW);
        super.onViewCreated(view, bundle);
        Bundle arguments = getArguments();
        Serializable serializable = arguments != null ? arguments.getSerializable("type") : null;
        Objects.requireNonNull(serializable, "null cannot be cast to non-null type com.digitalwallet.app.view.main.MainFragmentType");
        int i = WhenMappings.$EnumSwitchMapping$0[((MainFragmentType) serializable).ordinal()];
        if (i == 1) {
            getViewModel().getTitle().set(getResources().getString(R.string.title_my_account));
            TextView textView = ((FragmentMainPagerBinding) getBinding()).logoutBtn;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.logoutBtn");
            textView.setVisibility(0);
            ViewPager viewPager = ((FragmentMainPagerBinding) getBinding()).viewPager;
            Intrinsics.checkNotNullExpressionValue(viewPager, "binding.viewPager");
            FragmentManager childFragmentManager = getChildFragmentManager();
            Intrinsics.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
            viewPager.setAdapter(new AccountPagerAdapter(childFragmentManager));
            ((FragmentMainPagerBinding) getBinding()).logoutBtn.setOnClickListener(new MainPagerFragment$onViewCreated$1(this));
        } else if (i == 2) {
            getViewModel().getTitle().set(getResources().getString(R.string.title_my_services));
            TextView textView2 = ((FragmentMainPagerBinding) getBinding()).logoutBtn;
            Intrinsics.checkNotNullExpressionValue(textView2, "binding.logoutBtn");
            textView2.setVisibility(8);
            ViewPager viewPager2 = ((FragmentMainPagerBinding) getBinding()).viewPager;
            Intrinsics.checkNotNullExpressionValue(viewPager2, "binding.viewPager");
            FragmentManager childFragmentManager2 = getChildFragmentManager();
            Intrinsics.checkNotNullExpressionValue(childFragmentManager2, "childFragmentManager");
            viewPager2.setAdapter(new ServicePagerAdapter(childFragmentManager2));
        }
        ((FragmentMainPagerBinding) getBinding()).tabLayout.setupWithViewPager(((FragmentMainPagerBinding) getBinding()).viewPager);
    }

    /* access modifiers changed from: private */
    public final AlertDialog showLogoutDialog() {
        Context context = getContext();
        Objects.requireNonNull(context, "null cannot be cast to non-null type android.content.Context");
        return new AlertDialog.Builder(context, R.style.AlertDialogTheme_RES_2114715648).setTitle(R.string.logout_dialog_title).setMessage(R.string.logout_dialog_message).setPositiveButton(R.string.setting_logout, new MainPagerFragment$showLogoutDialog$1(this)).setNegativeButton(17039369, (DialogInterface.OnClickListener) null).show();
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/digitalwallet/app/view/main/MainPagerFragment$Companion;", "", "()V", "typeKey", "", "newInstance", "Lcom/digitalwallet/app/view/main/MainPagerFragment;", "type", "Lcom/digitalwallet/app/view/main/MainFragmentType;", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
    /* compiled from: MainPagerFragment.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final MainPagerFragment newInstance(MainFragmentType mainFragmentType) {
            Intrinsics.checkNotNullParameter(mainFragmentType, "type");
            MainPagerFragment mainPagerFragment = new MainPagerFragment();
            Bundle bundle = new Bundle();
            bundle.putSerializable("type", mainFragmentType);
            Unit unit = Unit.INSTANCE;
            mainPagerFragment.setArguments(bundle);
            return mainPagerFragment;
        }
    }
}
