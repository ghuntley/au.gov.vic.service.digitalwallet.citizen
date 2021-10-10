package com.digitalwallet.app.viewmodel.main.addsync;

import android.content.Context;
import au.gov.vic.service.digitalwallet.citizen.R;
import com.digitalwallet.app.model.HoldingType;
import com.digitalwallet.app.model.SecureHolding;
import com.digitalwallet.app.viewmodel.main.addsync.CardAddEvent;
import com.digitalwallet.utilities.AnalyticsHelper;
import com.digitalwallet.viewmodel.base.BaseViewModel;
import io.reactivex.subjects.PublishSubject;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\r\u001a\u00020\u000bJ\u0006\u0010\u000e\u001a\u00020\u000bJ\u0006\u0010\u000f\u001a\u00020\u000bJ\u0016\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014R\u000e\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0015"}, d2 = {"Lcom/digitalwallet/app/viewmodel/main/addsync/CardAddViewModel;", "Lcom/digitalwallet/viewmodel/base/BaseViewModel;", "analytics", "Lcom/digitalwallet/utilities/AnalyticsHelper;", "(Lcom/digitalwallet/utilities/AnalyticsHelper;)V", "cardRequestPublisher", "Lio/reactivex/subjects/PublishSubject;", "Lcom/digitalwallet/app/viewmodel/main/addsync/CardAddEvent;", "getCardRequestPublisher", "()Lio/reactivex/subjects/PublishSubject;", "goBackEventPublisher", "", "getGoBackEventPublisher", "cancel", "openCardSyncView", "openFishingLicenceUrl", "openHoldingView", "secureHolding", "Lcom/digitalwallet/app/model/SecureHolding;", "context", "Landroid/content/Context;", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: CardAddViewModel.kt */
public final class CardAddViewModel extends BaseViewModel {
    private AnalyticsHelper analytics;
    private final PublishSubject<CardAddEvent> cardRequestPublisher;
    private final PublishSubject<Unit> goBackEventPublisher;

    @Inject
    public CardAddViewModel(AnalyticsHelper analyticsHelper) {
        Intrinsics.checkNotNullParameter(analyticsHelper, "analytics");
        this.analytics = analyticsHelper;
        PublishSubject<CardAddEvent> create = PublishSubject.create();
        Intrinsics.checkNotNullExpressionValue(create, "PublishSubject.create()");
        this.cardRequestPublisher = create;
        PublishSubject<Unit> create2 = PublishSubject.create();
        Intrinsics.checkNotNullExpressionValue(create2, "PublishSubject.create()");
        this.goBackEventPublisher = create2;
    }

    public final PublishSubject<CardAddEvent> getCardRequestPublisher() {
        return this.cardRequestPublisher;
    }

    public final PublishSubject<Unit> getGoBackEventPublisher() {
        return this.goBackEventPublisher;
    }

    public final void openFishingLicenceUrl() {
        this.analytics.selectContent("Add card - Select", HoldingType.FISHING_LICENCE.name());
        this.cardRequestPublisher.onNext(new CardAddEvent.WebRequest(R.string.fishing_licence_url));
    }

    public final void openHoldingView(SecureHolding secureHolding, Context context) {
        Intrinsics.checkNotNullParameter(secureHolding, "secureHolding");
        Intrinsics.checkNotNullParameter(context, "context");
        this.analytics.selectContent("Add card - Select", secureHolding.holdingTypeName(context));
        this.cardRequestPublisher.onNext(new CardAddEvent.ComingSoonHolding(secureHolding.getHoldingType()));
    }

    public final void openCardSyncView() {
        AnalyticsHelper.selectContent$default(this.analytics, "Download cards", null, 2, null);
        this.cardRequestPublisher.onNext(CardAddEvent.CardSync.INSTANCE);
    }

    public final void cancel() {
        this.goBackEventPublisher.onNext(Unit.INSTANCE);
    }
}
