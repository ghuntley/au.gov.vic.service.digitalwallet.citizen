package com.digitalwallet.app.view.onboarding;

import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H&¨\u0006\u0007"}, d2 = {"Lcom/digitalwallet/app/view/onboarding/OnboardingViewModel;", "", "done", "", "isSkip", "", "next", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: OnboardingActivity.kt */
public interface OnboardingViewModel {
    void done(boolean z);

    void next();

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 0})
    /* compiled from: OnboardingActivity.kt */
    public static final class DefaultImpls {
        public static /* synthetic */ void done$default(OnboardingViewModel onboardingViewModel, boolean z, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    z = false;
                }
                onboardingViewModel.done(z);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: done");
        }
    }
}
