package com.digitalwallet.app.view.main;

import com.digitalwallet.app.connection.BLEClient;
import com.digitalwallet.app.holdings.HoldingParser;
import com.digitalwallet.app.holdings.HoldingsService;
import com.digitalwallet.app.viewmodel.main.sharing.LobbyFragmentViewModel;
import com.digitalwallet.di.ViewModelFactory;
import com.digitalwallet.view.base.BaseFragment_MembersInjector;
import dagger.MembersInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.DaggerFragment_MembersInjector;
import javax.inject.Provider;

public final class LobbyFragment_MembersInjector implements MembersInjector<LobbyFragment> {
    private final Provider<DispatchingAndroidInjector<Object>> androidInjectorProvider;
    private final Provider<BLEClient> bleClientProvider;
    private final Provider<HoldingParser> holdingParserProvider;
    private final Provider<HoldingsService> holdingsServiceProvider;
    private final Provider<ViewModelFactory> viewModelFactoryProvider;
    private final Provider<LobbyFragmentViewModel> viewModelProvider;

    public LobbyFragment_MembersInjector(Provider<DispatchingAndroidInjector<Object>> provider, Provider<ViewModelFactory> provider2, Provider<LobbyFragmentViewModel> provider3, Provider<HoldingParser> provider4, Provider<HoldingsService> provider5, Provider<BLEClient> provider6) {
        this.androidInjectorProvider = provider;
        this.viewModelFactoryProvider = provider2;
        this.viewModelProvider = provider3;
        this.holdingParserProvider = provider4;
        this.holdingsServiceProvider = provider5;
        this.bleClientProvider = provider6;
    }

    public static MembersInjector<LobbyFragment> create(Provider<DispatchingAndroidInjector<Object>> provider, Provider<ViewModelFactory> provider2, Provider<LobbyFragmentViewModel> provider3, Provider<HoldingParser> provider4, Provider<HoldingsService> provider5, Provider<BLEClient> provider6) {
        return new LobbyFragment_MembersInjector(provider, provider2, provider3, provider4, provider5, provider6);
    }

    public void injectMembers(LobbyFragment lobbyFragment) {
        DaggerFragment_MembersInjector.injectAndroidInjector(lobbyFragment, this.androidInjectorProvider.get());
        BaseFragment_MembersInjector.injectViewModelFactory(lobbyFragment, this.viewModelFactoryProvider.get());
        injectViewModel(lobbyFragment, this.viewModelProvider.get());
        injectHoldingParser(lobbyFragment, this.holdingParserProvider.get());
        injectHoldingsService(lobbyFragment, this.holdingsServiceProvider.get());
        injectBleClient(lobbyFragment, this.bleClientProvider.get());
    }

    public static void injectViewModel(LobbyFragment lobbyFragment, LobbyFragmentViewModel lobbyFragmentViewModel) {
        lobbyFragment.viewModel = lobbyFragmentViewModel;
    }

    public static void injectHoldingParser(LobbyFragment lobbyFragment, HoldingParser holdingParser) {
        lobbyFragment.holdingParser = holdingParser;
    }

    public static void injectHoldingsService(LobbyFragment lobbyFragment, HoldingsService holdingsService) {
        lobbyFragment.holdingsService = holdingsService;
    }

    public static void injectBleClient(LobbyFragment lobbyFragment, BLEClient bLEClient) {
        lobbyFragment.bleClient = bLEClient;
    }
}
