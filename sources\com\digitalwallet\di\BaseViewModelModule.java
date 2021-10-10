package com.digitalwallet.di;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.digitalwallet.viewmodel.checkIn.CheckInOverviewViewModel;
import com.digitalwallet.viewmodel.checkIn.CheckInScannerViewModel;
import com.digitalwallet.viewmodel.checkIn.checkInInput.CheckInAddDependantInputViewModel;
import com.digitalwallet.viewmodel.checkIn.checkInInput.CheckInEditPersonInputViewModel;
import com.digitalwallet.viewmodel.checkIn.checkInInput.CheckInPrimaryInputViewModel;
import com.digitalwallet.viewmodel.checkIn.checkInInput.CheckInSubmittingViewModel;
import com.digitalwallet.viewmodel.checkIn.checkInInput.CheckInSummaryViewModel;
import com.digitalwallet.viewmodel.checkIn.checkInShortcut.CheckInShortcutViewModel;
import com.digitalwallet.viewmodel.checkIn.checkedIn.CheckInFeedbackSuccessViewModel;
import com.digitalwallet.viewmodel.checkIn.checkedIn.CheckInFeedbackViewModel;
import com.digitalwallet.viewmodel.checkIn.checkedIn.CheckInHistoryDetailViewModel;
import com.digitalwallet.viewmodel.checkIn.checkedIn.CheckInSuccessViewModel;
import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b'\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0015\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H!¢\u0006\u0002\b\u0007J\u0015\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH!¢\u0006\u0002\b\fJ\u0015\u0010\r\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000eH!¢\u0006\u0002\b\u000fJ\u0015\u0010\u0010\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0011H!¢\u0006\u0002\b\u0012J\u0015\u0010\u0013\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0014H!¢\u0006\u0002\b\u0015J\u0015\u0010\u0016\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0017H!¢\u0006\u0002\b\u0018J\u0015\u0010\u0019\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u001aH!¢\u0006\u0002\b\u001bJ\u0015\u0010\u001c\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u001dH!¢\u0006\u0002\b\u001eJ\u0015\u0010\u001f\u001a\u00020\t2\u0006\u0010\n\u001a\u00020 H!¢\u0006\u0002\b!J\u0015\u0010\"\u001a\u00020\t2\u0006\u0010\n\u001a\u00020#H!¢\u0006\u0002\b$J\u0015\u0010%\u001a\u00020\t2\u0006\u0010\n\u001a\u00020&H!¢\u0006\u0002\b'J\u0015\u0010(\u001a\u00020\t2\u0006\u0010\n\u001a\u00020)H!¢\u0006\u0002\b*J\u0015\u0010+\u001a\u00020\t2\u0006\u0010\n\u001a\u00020,H!¢\u0006\u0002\b-¨\u0006."}, d2 = {"Lcom/digitalwallet/di/BaseViewModelModule;", "", "()V", "bindViewModelFactory", "Landroidx/lifecycle/ViewModelProvider$Factory;", "factory", "Lcom/digitalwallet/di/ViewModelFactory;", "bindViewModelFactory$base_citizenProdRelease", "checkInAddDependantInputViewModel", "Landroidx/lifecycle/ViewModel;", "viewModel", "Lcom/digitalwallet/viewmodel/checkIn/checkInInput/CheckInAddDependantInputViewModel;", "checkInAddDependantInputViewModel$base_citizenProdRelease", "checkInEditPersonInputViewModel", "Lcom/digitalwallet/viewmodel/checkIn/checkInInput/CheckInEditPersonInputViewModel;", "checkInEditPersonInputViewModel$base_citizenProdRelease", "checkInFeedbackSuccessViewModel", "Lcom/digitalwallet/viewmodel/checkIn/checkedIn/CheckInFeedbackSuccessViewModel;", "checkInFeedbackSuccessViewModel$base_citizenProdRelease", "checkInFeedbackViewModel", "Lcom/digitalwallet/viewmodel/checkIn/checkedIn/CheckInFeedbackViewModel;", "checkInFeedbackViewModel$base_citizenProdRelease", "checkInHistoryDetailViewModel", "Lcom/digitalwallet/viewmodel/checkIn/checkedIn/CheckInHistoryDetailViewModel;", "checkInHistoryDetailViewModel$base_citizenProdRelease", "checkInOverviewViewModel", "Lcom/digitalwallet/viewmodel/checkIn/CheckInOverviewViewModel;", "checkInOverviewViewModel$base_citizenProdRelease", "checkInPrimaryInputViewModel", "Lcom/digitalwallet/viewmodel/checkIn/checkInInput/CheckInPrimaryInputViewModel;", "checkInPrimaryInputViewModel$base_citizenProdRelease", "checkInScannerViewModel", "Lcom/digitalwallet/viewmodel/checkIn/CheckInScannerViewModel;", "checkInScannerViewModel$base_citizenProdRelease", "checkInShortcutViewModel", "Lcom/digitalwallet/viewmodel/checkIn/checkInShortcut/CheckInShortcutViewModel;", "checkInShortcutViewModel$base_citizenProdRelease", "checkInSubmittingViewModel", "Lcom/digitalwallet/viewmodel/checkIn/checkInInput/CheckInSubmittingViewModel;", "checkInSubmittingViewModel$base_citizenProdRelease", "checkInSuccessViewModel", "Lcom/digitalwallet/viewmodel/checkIn/checkedIn/CheckInSuccessViewModel;", "checkInSuccessViewModel$base_citizenProdRelease", "checkInSummaryViewModel", "Lcom/digitalwallet/viewmodel/checkIn/checkInInput/CheckInSummaryViewModel;", "checkInSummaryViewModel$base_citizenProdRelease", "base_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
@Module
/* compiled from: BaseViewModelModule.kt */
public abstract class BaseViewModelModule {
    @Binds
    public abstract ViewModelProvider.Factory bindViewModelFactory$base_citizenProdRelease(ViewModelFactory viewModelFactory);

    @ViewModelKey(CheckInAddDependantInputViewModel.class)
    @Binds
    @IntoMap
    public abstract ViewModel checkInAddDependantInputViewModel$base_citizenProdRelease(CheckInAddDependantInputViewModel checkInAddDependantInputViewModel);

    @ViewModelKey(CheckInEditPersonInputViewModel.class)
    @Binds
    @IntoMap
    public abstract ViewModel checkInEditPersonInputViewModel$base_citizenProdRelease(CheckInEditPersonInputViewModel checkInEditPersonInputViewModel);

    @ViewModelKey(CheckInFeedbackSuccessViewModel.class)
    @Binds
    @IntoMap
    public abstract ViewModel checkInFeedbackSuccessViewModel$base_citizenProdRelease(CheckInFeedbackSuccessViewModel checkInFeedbackSuccessViewModel);

    @ViewModelKey(CheckInFeedbackViewModel.class)
    @Binds
    @IntoMap
    public abstract ViewModel checkInFeedbackViewModel$base_citizenProdRelease(CheckInFeedbackViewModel checkInFeedbackViewModel);

    @ViewModelKey(CheckInHistoryDetailViewModel.class)
    @Binds
    @IntoMap
    public abstract ViewModel checkInHistoryDetailViewModel$base_citizenProdRelease(CheckInHistoryDetailViewModel checkInHistoryDetailViewModel);

    @ViewModelKey(CheckInOverviewViewModel.class)
    @Binds
    @IntoMap
    public abstract ViewModel checkInOverviewViewModel$base_citizenProdRelease(CheckInOverviewViewModel checkInOverviewViewModel);

    @ViewModelKey(CheckInPrimaryInputViewModel.class)
    @Binds
    @IntoMap
    public abstract ViewModel checkInPrimaryInputViewModel$base_citizenProdRelease(CheckInPrimaryInputViewModel checkInPrimaryInputViewModel);

    @ViewModelKey(CheckInScannerViewModel.class)
    @Binds
    @IntoMap
    public abstract ViewModel checkInScannerViewModel$base_citizenProdRelease(CheckInScannerViewModel checkInScannerViewModel);

    @ViewModelKey(CheckInShortcutViewModel.class)
    @Binds
    @IntoMap
    public abstract ViewModel checkInShortcutViewModel$base_citizenProdRelease(CheckInShortcutViewModel checkInShortcutViewModel);

    @ViewModelKey(CheckInSubmittingViewModel.class)
    @Binds
    @IntoMap
    public abstract ViewModel checkInSubmittingViewModel$base_citizenProdRelease(CheckInSubmittingViewModel checkInSubmittingViewModel);

    @ViewModelKey(CheckInSuccessViewModel.class)
    @Binds
    @IntoMap
    public abstract ViewModel checkInSuccessViewModel$base_citizenProdRelease(CheckInSuccessViewModel checkInSuccessViewModel);

    @ViewModelKey(CheckInSummaryViewModel.class)
    @Binds
    @IntoMap
    public abstract ViewModel checkInSummaryViewModel$base_citizenProdRelease(CheckInSummaryViewModel checkInSummaryViewModel);
}
