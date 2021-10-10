package com.digitalwallet.check_in.di;

import com.digitalwallet.check_in.di.CheckInComponent;
import com.digitalwallet.check_in.view.CheckInActivity;
import com.digitalwallet.check_in.view.CheckInActivity_MembersInjector;
import com.digitalwallet.di.BaseComponent;
import com.digitalwallet.utilities.AnalyticsHelper;
import com.digitalwallet.viewmodel.checkIn.checkInRepository.CheckInRepository;
import com.squareup.moshi.Moshi;
import dagger.internal.Preconditions;

public final class DaggerCheckInComponent implements CheckInComponent {
    private final BaseComponent baseComponent;

    private DaggerCheckInComponent(BaseComponent baseComponent2) {
        this.baseComponent = baseComponent2;
    }

    public static CheckInComponent.Factory factory() {
        return new Factory();
    }

    @Override // com.digitalwallet.check_in.di.CheckInComponent
    public void inject(CheckInActivity checkInActivity) {
        injectCheckInActivity(checkInActivity);
    }

    private CheckInActivity injectCheckInActivity(CheckInActivity checkInActivity) {
        CheckInActivity_MembersInjector.injectMoshi(checkInActivity, (Moshi) Preconditions.checkNotNull(this.baseComponent.moshi(), "Cannot return null from a non-@Nullable component method"));
        CheckInActivity_MembersInjector.injectAnalytics(checkInActivity, (AnalyticsHelper) Preconditions.checkNotNull(this.baseComponent.analytics(), "Cannot return null from a non-@Nullable component method"));
        CheckInActivity_MembersInjector.injectCheckInRepository(checkInActivity, (CheckInRepository) Preconditions.checkNotNull(this.baseComponent.checkInRepository(), "Cannot return null from a non-@Nullable component method"));
        return checkInActivity;
    }

    /* access modifiers changed from: private */
    public static final class Factory implements CheckInComponent.Factory {
        private Factory() {
        }

        @Override // com.digitalwallet.check_in.di.CheckInComponent.Factory
        public CheckInComponent create(BaseComponent baseComponent) {
            Preconditions.checkNotNull(baseComponent);
            return new DaggerCheckInComponent(baseComponent);
        }
    }
}
