package com.digitalwallet.di;

import com.digitalwallet.view.checkIn.CheckInOverviewFragment;
import com.digitalwallet.view.checkIn.CheckInScannerFragment;
import com.digitalwallet.view.checkIn.checkInInput.CheckInAddDependantInputFragment;
import com.digitalwallet.view.checkIn.checkInInput.CheckInEditPersonInputFragment;
import com.digitalwallet.view.checkIn.checkInInput.CheckInPrimaryInputFragment;
import com.digitalwallet.view.checkIn.checkInInput.CheckInSubmittingFragment;
import com.digitalwallet.view.checkIn.checkInInput.CheckInSummaryFragment;
import com.digitalwallet.view.checkIn.checkInShortcut.CheckInShortcutFragment;
import com.digitalwallet.view.checkIn.checkedIn.CheckInFeedbackFragment;
import com.digitalwallet.view.checkIn.checkedIn.CheckInFeedbackSuccessFragment;
import com.digitalwallet.view.checkIn.checkedIn.CheckInHistoryDetailFragment;
import com.digitalwallet.view.checkIn.checkedIn.CheckInSuccessFragment;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b'\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H'J\b\u0010\u0005\u001a\u00020\u0006H'J\b\u0010\u0007\u001a\u00020\bH'J\b\u0010\t\u001a\u00020\nH'J\b\u0010\u000b\u001a\u00020\fH'J\b\u0010\r\u001a\u00020\u000eH'J\b\u0010\u000f\u001a\u00020\u0010H'J\b\u0010\u0011\u001a\u00020\u0012H'J\b\u0010\u0013\u001a\u00020\u0014H'J\b\u0010\u0015\u001a\u00020\u0016H'J\b\u0010\u0017\u001a\u00020\u0018H'J\b\u0010\u0019\u001a\u00020\u001aH'¨\u0006\u001b"}, d2 = {"Lcom/digitalwallet/di/BaseSupportFragmentModule;", "", "()V", "contributeCheckInAddDependantInputFragment", "Lcom/digitalwallet/view/checkIn/checkInInput/CheckInAddDependantInputFragment;", "contributeCheckInEditPersonInputFragment", "Lcom/digitalwallet/view/checkIn/checkInInput/CheckInEditPersonInputFragment;", "contributeCheckInFeedbackFragment", "Lcom/digitalwallet/view/checkIn/checkedIn/CheckInFeedbackFragment;", "contributeCheckInFeedbackSuccessFragment", "Lcom/digitalwallet/view/checkIn/checkedIn/CheckInFeedbackSuccessFragment;", "contributeCheckInHistoryDetailFragment", "Lcom/digitalwallet/view/checkIn/checkedIn/CheckInHistoryDetailFragment;", "contributeCheckInOverviewFragment", "Lcom/digitalwallet/view/checkIn/CheckInOverviewFragment;", "contributeCheckInPrimaryInputFragment", "Lcom/digitalwallet/view/checkIn/checkInInput/CheckInPrimaryInputFragment;", "contributeCheckInScannerFragment", "Lcom/digitalwallet/view/checkIn/CheckInScannerFragment;", "contributeCheckInShortcutFragment", "Lcom/digitalwallet/view/checkIn/checkInShortcut/CheckInShortcutFragment;", "contributeCheckInSubmittingFragment", "Lcom/digitalwallet/view/checkIn/checkInInput/CheckInSubmittingFragment;", "contributeCheckInSuccessFragment", "Lcom/digitalwallet/view/checkIn/checkedIn/CheckInSuccessFragment;", "contributeCheckInSummaryFragment", "Lcom/digitalwallet/view/checkIn/checkInInput/CheckInSummaryFragment;", "base_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
@Module
/* compiled from: BaseSupportFragmentModule.kt */
public abstract class BaseSupportFragmentModule {
    @ContributesAndroidInjector
    public abstract CheckInAddDependantInputFragment contributeCheckInAddDependantInputFragment();

    @ContributesAndroidInjector
    public abstract CheckInEditPersonInputFragment contributeCheckInEditPersonInputFragment();

    @ContributesAndroidInjector
    public abstract CheckInFeedbackFragment contributeCheckInFeedbackFragment();

    @ContributesAndroidInjector
    public abstract CheckInFeedbackSuccessFragment contributeCheckInFeedbackSuccessFragment();

    @ContributesAndroidInjector
    public abstract CheckInHistoryDetailFragment contributeCheckInHistoryDetailFragment();

    @ContributesAndroidInjector
    public abstract CheckInOverviewFragment contributeCheckInOverviewFragment();

    @ContributesAndroidInjector
    public abstract CheckInPrimaryInputFragment contributeCheckInPrimaryInputFragment();

    @ContributesAndroidInjector
    public abstract CheckInScannerFragment contributeCheckInScannerFragment();

    @ContributesAndroidInjector
    public abstract CheckInShortcutFragment contributeCheckInShortcutFragment();

    @ContributesAndroidInjector
    public abstract CheckInSubmittingFragment contributeCheckInSubmittingFragment();

    @ContributesAndroidInjector
    public abstract CheckInSuccessFragment contributeCheckInSuccessFragment();

    @ContributesAndroidInjector
    public abstract CheckInSummaryFragment contributeCheckInSummaryFragment();
}
