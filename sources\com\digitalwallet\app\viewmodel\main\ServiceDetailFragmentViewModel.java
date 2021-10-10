package com.digitalwallet.app.viewmodel.main;

import androidx.databinding.ObservableField;
import com.digitalwallet.viewmodel.base.BaseViewModel;
import io.reactivex.subjects.BehaviorSubject;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.bouncycastle.i18n.MessageBundle;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007\b\u0007¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0011R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001f\u0010\b\u001a\u0010\u0012\f\u0012\n \u000b*\u0004\u0018\u00010\n0\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001f\u0010\u000e\u001a\u0010\u0012\f\u0012\n \u000b*\u0004\u0018\u00010\u000f0\u000f0\t¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\r¨\u0006\u0012"}, d2 = {"Lcom/digitalwallet/app/viewmodel/main/ServiceDetailFragmentViewModel;", "Lcom/digitalwallet/viewmodel/base/BaseViewModel;", "()V", "backToMainActivity", "Lio/reactivex/subjects/BehaviorSubject;", "", "getBackToMainActivity", "()Lio/reactivex/subjects/BehaviorSubject;", "image", "Landroidx/databinding/ObservableField;", "", "kotlin.jvm.PlatformType", "getImage", "()Landroidx/databinding/ObservableField;", MessageBundle.TITLE_ENTRY, "", "getTitle", "", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: ServiceDetailFragmentViewModel.kt */
public final class ServiceDetailFragmentViewModel extends BaseViewModel {
    private final BehaviorSubject<Boolean> backToMainActivity;
    private final ObservableField<Integer> image = new ObservableField<>((Integer) 0);
    private final ObservableField<String> title = new ObservableField<>("");

    @Inject
    public ServiceDetailFragmentViewModel() {
        BehaviorSubject<Boolean> createDefault = BehaviorSubject.createDefault(false);
        Intrinsics.checkNotNullExpressionValue(createDefault, "BehaviorSubject.createDefault(false)");
        this.backToMainActivity = createDefault;
    }

    public final ObservableField<String> getTitle() {
        return this.title;
    }

    public final ObservableField<Integer> getImage() {
        return this.image;
    }

    public final BehaviorSubject<Boolean> getBackToMainActivity() {
        return this.backToMainActivity;
    }

    public final void backToMainActivity() {
        this.backToMainActivity.onNext(true);
    }
}
