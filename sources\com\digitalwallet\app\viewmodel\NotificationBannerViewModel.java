package com.digitalwallet.app.viewmodel;

import au.gov.vic.service.digitalwallet.citizen.R;
import com.google.firebase.messaging.Constants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B%\b\u0002\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\tR \u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u0015"}, d2 = {"Lcom/digitalwallet/app/viewmodel/NotificationBannerViewModel;", "", "titleText", "", "buttonText", "showNoticeIcon", "", "(IIZ)V", "getButtonText", "()I", "getShowNoticeIcon", "()Z", "getTitleText", "visitUrl", "Lkotlin/Function0;", "", "getVisitUrl", "()Lkotlin/jvm/functions/Function0;", "setVisitUrl", "(Lkotlin/jvm/functions/Function0;)V", "Companion", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: NotificationBannerViewModel.kt */
public final class NotificationBannerViewModel {
    public static final Companion Companion = new Companion(null);
    private final int buttonText;
    private final boolean showNoticeIcon;
    private final int titleText;
    public Function0<Unit> visitUrl;

    private NotificationBannerViewModel(int i, int i2, boolean z) {
        this.titleText = i;
        this.buttonText = i2;
        this.showNoticeIcon = z;
    }

    public /* synthetic */ NotificationBannerViewModel(int i, int i2, boolean z, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, i2, z);
    }

    public final int getTitleText() {
        return this.titleText;
    }

    public final int getButtonText() {
        return this.buttonText;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    /* synthetic */ NotificationBannerViewModel(int i, int i2, boolean z, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 0 : i, (i3 & 2) != 0 ? 0 : i2, (i3 & 4) != 0 ? false : z);
    }

    public final boolean getShowNoticeIcon() {
        return this.showNoticeIcon;
    }

    public final Function0<Unit> getVisitUrl() {
        Function0<Unit> function0 = this.visitUrl;
        if (function0 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("visitUrl");
        }
        return function0;
    }

    public final void setVisitUrl(Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "<set-?>");
        this.visitUrl = function0;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b¨\u0006\t"}, d2 = {"Lcom/digitalwallet/app/viewmodel/NotificationBannerViewModel$Companion;", "", "()V", Constants.MessagePayloadKeys.FROM, "Lcom/digitalwallet/app/viewmodel/NotificationBannerViewModel;", "holdingState", "Lcom/digitalwallet/app/viewmodel/NotificationType;", "isHoldingExpired", "", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
    /* compiled from: NotificationBannerViewModel.kt */
    public static final class Companion {

        @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 0})
        public final /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[NotificationType.values().length];
                $EnumSwitchMapping$0 = iArr;
                iArr[NotificationType.ComingSoon.ordinal()] = 1;
            }
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ NotificationBannerViewModel from$default(Companion companion, NotificationType notificationType, boolean z, int i, Object obj) {
            if ((i & 2) != 0) {
                z = false;
            }
            return companion.from(notificationType, z);
        }

        public final NotificationBannerViewModel from(NotificationType notificationType, boolean z) {
            Intrinsics.checkNotNullParameter(notificationType, "holdingState");
            if (WhenMappings.$EnumSwitchMapping$0[notificationType.ordinal()] == 1) {
                return new NotificationBannerViewModel(0, 0, false, 7, null);
            }
            if (z) {
                return new NotificationBannerViewModel(R.string.notification_expired, R.string.list_renew, true, null);
            }
            return new NotificationBannerViewModel(R.string.notification_expiring_soon, R.string.list_renew, true, null);
        }
    }
}
