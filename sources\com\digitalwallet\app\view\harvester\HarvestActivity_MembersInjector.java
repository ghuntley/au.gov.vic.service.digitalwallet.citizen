package com.digitalwallet.app.view.harvester;

import com.digitalwallet.app.AppStartUp;
import com.digitalwallet.app.view.base.BaseAppActivity_MembersInjector;
import com.digitalwallet.app.viewmodel.harvester.HarvestJobWizardViewModel;
import com.digitalwallet.app.viewmodel.harvester.HarvestTagViewModel;
import com.digitalwallet.di.ViewModelFactory;
import com.digitalwallet.view.base.BaseActivity_MembersInjector;
import dagger.MembersInjector;
import dagger.android.DispatchingAndroidInjector;
import javax.inject.Provider;

public final class HarvestActivity_MembersInjector implements MembersInjector<HarvestActivity> {
    private final Provider<DispatchingAndroidInjector<Object>> androidInjectorProvider;
    private final Provider<AppStartUp> appStartUpProvider;
    private final Provider<HarvestTagViewModel> tagViewModelProvider;
    private final Provider<ViewModelFactory> viewModelFactoryProvider;
    private final Provider<HarvestJobWizardViewModel> viewModelProvider;

    public HarvestActivity_MembersInjector(Provider<DispatchingAndroidInjector<Object>> provider, Provider<ViewModelFactory> provider2, Provider<AppStartUp> provider3, Provider<HarvestJobWizardViewModel> provider4, Provider<HarvestTagViewModel> provider5) {
        this.androidInjectorProvider = provider;
        this.viewModelFactoryProvider = provider2;
        this.appStartUpProvider = provider3;
        this.viewModelProvider = provider4;
        this.tagViewModelProvider = provider5;
    }

    public static MembersInjector<HarvestActivity> create(Provider<DispatchingAndroidInjector<Object>> provider, Provider<ViewModelFactory> provider2, Provider<AppStartUp> provider3, Provider<HarvestJobWizardViewModel> provider4, Provider<HarvestTagViewModel> provider5) {
        return new HarvestActivity_MembersInjector(provider, provider2, provider3, provider4, provider5);
    }

    public void injectMembers(HarvestActivity harvestActivity) {
        BaseActivity_MembersInjector.injectAndroidInjector(harvestActivity, this.androidInjectorProvider.get());
        BaseActivity_MembersInjector.injectViewModelFactory(harvestActivity, this.viewModelFactoryProvider.get());
        BaseAppActivity_MembersInjector.injectAppStartUp(harvestActivity, this.appStartUpProvider.get());
        injectViewModel(harvestActivity, this.viewModelProvider.get());
        injectTagViewModel(harvestActivity, this.tagViewModelProvider.get());
    }

    public static void injectViewModel(HarvestActivity harvestActivity, HarvestJobWizardViewModel harvestJobWizardViewModel) {
        harvestActivity.viewModel = harvestJobWizardViewModel;
    }

    public static void injectTagViewModel(HarvestActivity harvestActivity, HarvestTagViewModel harvestTagViewModel) {
        harvestActivity.tagViewModel = harvestTagViewModel;
    }
}
