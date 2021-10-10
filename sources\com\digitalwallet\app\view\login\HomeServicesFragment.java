package com.digitalwallet.app.view.login;

import android.app.Application;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.browser.customtabs.CustomTabsIntent;
import androidx.core.content.ContextCompat;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import au.gov.vic.service.digitalwallet.citizen.R;
import com.digitalwallet.DigitalWalletApplication;
import com.digitalwallet.app.databinding.FragmentHomeServicesBinding;
import com.digitalwallet.app.databinding.ItemSvServiceTitleActionBinding;
import com.digitalwallet.app.model.login.SVService;
import com.digitalwallet.app.model.login.SVServices;
import com.digitalwallet.app.view.base.BaseAppFragment;
import com.digitalwallet.app.view.login.adapter.TopCarouselPagerAdapter;
import com.digitalwallet.app.view.svservices.ServiceGroupCategoriesFragment;
import com.digitalwallet.app.view.util.CustomTabProvider;
import com.digitalwallet.app.viewmodel.login.HomeServicesViewModel;
import com.digitalwallet.app.viewmodel.svservices.SVItemViewModel;
import com.digitalwallet.services.RemoteConfigService;
import com.digitalwallet.utilities.ActivityHelperKt;
import com.digitalwallet.utilities.EventObserver;
import com.digitalwallet.utilities.SpecialURLs;
import com.digitalwallet.view.base.BaseFragment;
import com.digitalwallet.view.checkIn.CheckInScannerFragment;
import com.digitalwallet.view.checkIn.CheckInUtilsKt;
import com.digitalwallet.view.checkIn.checkInShortcut.CheckInShortcutFragment;
import com.digitalwallet.view.checkIn.checkInShortcut.FavouriteCarouselAdapter;
import com.digitalwallet.view.util.ViewUtilsKt;
import com.digitalwallet.viewmodel.checkIn.CheckInUtils;
import com.digitalwallet.viewmodel.checkIn.checkInShortcut.FavouriteCellViewModel;
import com.google.android.gms.analytics.ecommerce.Promotion;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

public final class HomeServicesFragment extends BaseAppFragment<FragmentHomeServicesBinding> {
    public static final Companion Companion = new Companion(null);
    private static final String SHOW_LOGIN_KEY;
    private HashMap _$_findViewCache;
    private CompositeDisposable disposables = new CompositeDisposable();
    private final int layoutId = R.layout.fragment_home_services;
    public RemoteConfigService remoteConfigService;
    public HomeServicesViewModel viewModel;

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
    public HomeServicesViewModel getViewModel() {
        HomeServicesViewModel homeServicesViewModel = this.viewModel;
        if (homeServicesViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        return homeServicesViewModel;
    }

    public void setViewModel(HomeServicesViewModel homeServicesViewModel) {
        Intrinsics.checkNotNullParameter(homeServicesViewModel, "<set-?>");
        this.viewModel = homeServicesViewModel;
    }

    public final RemoteConfigService getRemoteConfigService() {
        RemoteConfigService remoteConfigService2 = this.remoteConfigService;
        if (remoteConfigService2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("remoteConfigService");
        }
        return remoteConfigService2;
    }

    public final void setRemoteConfigService(RemoteConfigService remoteConfigService2) {
        Intrinsics.checkNotNullParameter(remoteConfigService2, "<set-?>");
        this.remoteConfigService = remoteConfigService2;
    }

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ HomeServicesFragment newInstance$default(Companion companion, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                z = false;
            }
            return companion.newInstance(z);
        }

        public final HomeServicesFragment newInstance(boolean z) {
            HomeServicesFragment homeServicesFragment = new HomeServicesFragment();
            Bundle bundle = new Bundle();
            bundle.putBoolean(HomeServicesFragment.SHOW_LOGIN_KEY, z);
            Unit unit = Unit.INSTANCE;
            homeServicesFragment.setArguments(bundle);
            return homeServicesFragment;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [com.digitalwallet.app.view.login.HomeServicesFragment$sam$io_reactivex_functions_Consumer$0] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @Override // com.digitalwallet.view.base.BaseFragment, com.digitalwallet.view.base.BasicFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, Promotion.ACTION_VIEW);
        super.onViewCreated(view, bundle);
        setupAccountButton();
        setupSVServices(getViewModel().getFallbackSVServices());
        Single<SVServices> observeOn = getViewModel().getFetchLatestSVServices().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        HomeServicesFragment$onViewCreated$1 homeServicesFragment$onViewCreated$1 = new HomeServicesFragment$onViewCreated$1(this);
        HomeServicesFragment$onViewCreated$2 homeServicesFragment$onViewCreated$2 = HomeServicesFragment$onViewCreated$2.INSTANCE;
        if (homeServicesFragment$onViewCreated$2 != null) {
            homeServicesFragment$onViewCreated$2 = new HomeServicesFragment$sam$io_reactivex_functions_Consumer$0(homeServicesFragment$onViewCreated$2);
        }
        this.disposables.add(observeOn.subscribe(homeServicesFragment$onViewCreated$1, (Consumer) homeServicesFragment$onViewCreated$2));
        SpecialURLs.Companion companion = SpecialURLs.Companion;
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        TextView textView = (TextView) _$_findCachedViewById(com.digitalwallet.app.R.id.v_login_privacy);
        Intrinsics.checkNotNullExpressionValue(textView, "v_login_privacy");
        SpecialURLs.Companion.setPrivacySecurityText$default(companion, requireContext, R.string.login_privacy, textView, ContextCompat.getColor(requireContext(), R.color.dw_battleship_grey_RES_2114060291), null, 16, null);
        populateFavouriteCarousel(true);
        getViewModel().getFavouriteCellVMs().addOnPropertyChangedCallback(new HomeServicesFragment$onViewCreated$4(this));
        observeEvents();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        getViewModel().refreshCheckInFavourites();
    }

    private final void observeEvents() {
        getViewModel().getNavigateToCheckInScanner().observe(getViewLifecycleOwner(), new EventObserver(new HomeServicesFragment$observeEvents$1(this)));
        getViewModel().getNavigateToCheckInFavourites().observe(getViewLifecycleOwner(), new EventObserver(new HomeServicesFragment$observeEvents$2(this)));
        getViewModel().getNavigateToCheckInHistory().observe(getViewLifecycleOwner(), new EventObserver(new HomeServicesFragment$observeEvents$3(this)));
        getViewModel().getToCheckInToAFavourite().observe(getViewLifecycleOwner(), new EventObserver(new HomeServicesFragment$observeEvents$4(this)));
    }

    /* access modifiers changed from: public */
    private final void populateFavouriteCarousel(boolean z) {
        ArrayList arrayList;
        List<FavouriteCellViewModel> list = getViewModel().getFavouriteCellVMs().get();
        if (list == null || (arrayList = CollectionsKt.toMutableList((Collection) list)) == null) {
            arrayList = new ArrayList();
        }
        if (z) {
            RecyclerView recyclerView = ((FragmentHomeServicesBinding) getBinding()).favouriteCarousel;
            Intrinsics.checkNotNullExpressionValue(recyclerView, "binding.favouriteCarousel");
            recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
            RecyclerView recyclerView2 = ((FragmentHomeServicesBinding) getBinding()).favouriteCarousel;
            Intrinsics.checkNotNullExpressionValue(recyclerView2, "binding.favouriteCarousel");
            recyclerView2.setAdapter(new FavouriteCarouselAdapter(arrayList));
            return;
        }
        RecyclerView recyclerView3 = ((FragmentHomeServicesBinding) getBinding()).favouriteCarousel;
        Intrinsics.checkNotNullExpressionValue(recyclerView3, "binding.favouriteCarousel");
        RecyclerView.Adapter adapter = recyclerView3.getAdapter();
        if (!(adapter instanceof FavouriteCarouselAdapter)) {
            adapter = null;
        }
        FavouriteCarouselAdapter favouriteCarouselAdapter = (FavouriteCarouselAdapter) adapter;
        if (favouriteCarouselAdapter != null) {
            favouriteCarouselAdapter.updateFavouriteCarousel(arrayList);
        }
    }

    private final void setupAccountButton() {
        Bundle arguments = getArguments();
        boolean z = arguments != null ? arguments.getBoolean(SHOW_LOGIN_KEY) : false;
        getViewModel().getShowLogin().set(Boolean.valueOf(z));
        if (z) {
            ((FragmentHomeServicesBinding) getBinding()).vAccount.setOnClickListener(new HomeServicesFragment$setupAccountButton$1(this));
        }
    }

    /* access modifiers changed from: public */
    private final void setupSVServices(SVServices sVServices) {
        List<SVItemViewModel> list = getViewModel().topCarouselVMs(sVServices);
        ViewPager viewPager = ((FragmentHomeServicesBinding) getBinding()).loginTopCarousel;
        Intrinsics.checkNotNullExpressionValue(viewPager, "binding.loginTopCarousel");
        viewPager.setAdapter(new TopCarouselPagerAdapter(list));
        getViewModel().getStartChromeEvent().observe(getViewLifecycleOwner(), new EventObserver(new HomeServicesFragment$setupSVServices$1(this)));
        getViewModel().getOpenURLEvent().observe(getViewLifecycleOwner(), new EventObserver(new HomeServicesFragment$setupSVServices$2(this)));
        ArrayList arrayList = new ArrayList();
        ((FragmentHomeServicesBinding) getBinding()).carouselPagingDots.removeAllViews();
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(24, 24);
        int i = 0;
        layoutParams.setMargins(25, 0, 25, 0);
        int size = list.size();
        while (i < size) {
            ImageView imageView = new ImageView(getContext());
            imageView.setImageDrawable(getResources().getDrawable(i == 0 ? R.drawable.pill_slate : R.drawable.pill_light, null));
            ((FragmentHomeServicesBinding) getBinding()).carouselPagingDots.addView(imageView, layoutParams);
            arrayList.add(imageView);
            i++;
        }
        ((FragmentHomeServicesBinding) getBinding()).loginTopCarousel.addOnPageChangeListener(new HomeServicesFragment$setupSVServices$3(this, arrayList));
        ((FragmentHomeServicesBinding) getBinding()).svServiceGroups.removeAllViews();
        Iterator<T> it = getViewModel().serviceGroupVMs(sVServices).iterator();
        while (it.hasNext()) {
            ItemSvServiceTitleActionBinding inflate = ItemSvServiceTitleActionBinding.inflate(LayoutInflater.from(getContext()), ((FragmentHomeServicesBinding) getBinding()).svServiceGroups, true);
            Intrinsics.checkNotNullExpressionValue(inflate, "ItemSvServiceTitleAction…ng.svServiceGroups, true)");
            inflate.setVm(it.next());
        }
        getViewModel().getNavigateToGroupCategoriesEvent().observe(getViewLifecycleOwner(), new EventObserver(new HomeServicesFragment$setupSVServices$5(this)));
    }

    public final void startChrome(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "fullUrl");
        Intrinsics.checkNotNullParameter(str2, "analyticsItemId");
        CustomTabProvider customTabProvider = CustomTabProvider.INSTANCE;
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        if (customTabProvider.getCustomTabsPackageName(requireContext) != null) {
            getAnalytics().viewItem("Web view", str2);
            FragmentActivity activity = getActivity();
            DigitalWalletApplication digitalWalletApplication = null;
            Application application = activity != null ? activity.getApplication() : null;
            if (application instanceof DigitalWalletApplication) {
                digitalWalletApplication = application;
            }
            DigitalWalletApplication digitalWalletApplication2 = digitalWalletApplication;
            if (digitalWalletApplication2 != null) {
                digitalWalletApplication2.setSpawnedAnotherActivity(true);
            }
            Uri build = Uri.parse(str).buildUpon().build();
            Intrinsics.checkNotNullExpressionValue(build, "Uri.parse(fullUrl).buildUpon().build()");
            CustomTabsIntent customTabsIntent = CustomTabProvider.INSTANCE.getCustomTabsIntent();
            if (customTabsIntent != null) {
                customTabsIntent.launchUrl(requireContext(), build);
                return;
            }
            return;
        }
        openURL(str, str2);
    }

    public final void openURL(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "fullUrl");
        Intrinsics.checkNotNullParameter(str2, "analyticsItemId");
        getAnalytics().viewItem("Browser", str2);
        Uri build = Uri.parse(str).buildUpon().build();
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        Intrinsics.checkNotNullExpressionValue(build, "uri");
        ActivityHelperKt.viewURI(requireContext, build);
    }

    /* access modifiers changed from: public */
    private final void navigateToGroupCategoriesFragment(SVService sVService) {
        if (Intrinsics.areEqual(sVService.getType(), SVService.TYPE_GROUP)) {
            getAnalytics().selectContent("Service group", sVService.getId());
            ServiceGroupCategoriesFragment serviceGroupCategoriesFragment = new ServiceGroupCategoriesFragment();
            Bundle bundle = new Bundle();
            bundle.putParcelable(ServiceGroupCategoriesFragment.SV_SERVICE_GROUP_KEY, sVService);
            Unit unit = Unit.INSTANCE;
            serviceGroupCategoriesFragment.setArguments(bundle);
            FragmentManager parentFragmentManager = getParentFragmentManager();
            Intrinsics.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
            List<Fragment> fragments = parentFragmentManager.getFragments();
            Intrinsics.checkNotNullExpressionValue(fragments, "fragments");
            for (T t : fragments) {
                Intrinsics.checkNotNullExpressionValue(t, "it");
                t.setUserVisibleHint(false);
            }
            FragmentTransaction beginTransaction = parentFragmentManager.beginTransaction();
            Intrinsics.checkNotNullExpressionValue(beginTransaction, "this.beginTransaction()");
            beginTransaction.setCustomAnimations(R.anim.slide_in_up, R.anim.slide_out_down, R.anim.slide_in_up, R.anim.slide_out_down);
            String simpleName = Reflection.getOrCreateKotlinClass(ServiceGroupCategoriesFragment.class).getSimpleName();
            beginTransaction.add(R.id.fragment_container_RES_2114322527, serviceGroupCategoriesFragment, simpleName).addToBackStack(simpleName).commit();
            return;
        }
        throw new IllegalStateException("Check failed.".toString());
    }

    /* access modifiers changed from: public */
    private final void navigateToCheckInScannerFragment() {
        CheckInScannerFragment checkInScannerFragment = new CheckInScannerFragment();
        FragmentManager parentFragmentManager = getParentFragmentManager();
        Intrinsics.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        List<Fragment> fragments = parentFragmentManager.getFragments();
        Intrinsics.checkNotNullExpressionValue(fragments, "fragments");
        for (T t : fragments) {
            Intrinsics.checkNotNullExpressionValue(t, "it");
            t.setUserVisibleHint(false);
        }
        FragmentTransaction beginTransaction = parentFragmentManager.beginTransaction();
        Intrinsics.checkNotNullExpressionValue(beginTransaction, "this.beginTransaction()");
        beginTransaction.setCustomAnimations(R.anim.slide_in_up, R.anim.slide_out_down, R.anim.slide_in_up, R.anim.slide_out_down);
        String simpleName = Reflection.getOrCreateKotlinClass(CheckInScannerFragment.class).getSimpleName();
        beginTransaction.add(R.id.fragment_container_RES_2114322527, checkInScannerFragment, simpleName).addToBackStack(simpleName).commit();
    }

    /* access modifiers changed from: public */
    private final void navigateToCheckInShortcutFragment(boolean z) {
        CheckInShortcutFragment createFragment = CheckInShortcutFragment.Companion.createFragment(z);
        FragmentManager parentFragmentManager = getParentFragmentManager();
        Intrinsics.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        int containerId = ViewUtilsKt.getContainerId(this);
        FragmentTransaction beginTransaction = parentFragmentManager.beginTransaction();
        Intrinsics.checkNotNullExpressionValue(beginTransaction, "this.beginTransaction()");
        beginTransaction.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_left, R.anim.enter_from_left, R.anim.exit_to_right);
        beginTransaction.replace(containerId, createFragment, Reflection.getOrCreateKotlinClass(CheckInShortcutFragment.class).getSimpleName()).addToBackStack(null).commit();
    }

    /* access modifiers changed from: public */
    private final void toCheckInToAFavouriteLocation(CheckInUtils.CheckInCode checkInCode) {
        BaseFragment<? extends ViewDataBinding> checkInInputEntryFragment = CheckInUtilsKt.getCheckInInputEntryFragment(getViewModel().getCheckInRepository(), checkInCode, true);
        FragmentManager parentFragmentManager = getParentFragmentManager();
        Intrinsics.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        int containerId = ViewUtilsKt.getContainerId(this);
        FragmentTransaction beginTransaction = parentFragmentManager.beginTransaction();
        Intrinsics.checkNotNullExpressionValue(beginTransaction, "this.beginTransaction()");
        beginTransaction.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_left, R.anim.enter_from_left, R.anim.exit_to_right);
        beginTransaction.replace(containerId, checkInInputEntryFragment, Reflection.getOrCreateKotlinClass(BaseFragment.class).getSimpleName()).addToBackStack(null).commit();
    }
}
