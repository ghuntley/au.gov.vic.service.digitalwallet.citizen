package com.digitalwallet.app.viewmodel.main;

import au.gov.vic.service.digitalwallet.citizen.R;
import com.digitalwallet.app.view.main.ServiceDetailType;
import com.google.android.gms.common.internal.ImagesContract;
import com.google.firebase.messaging.Constants;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\u0018\u0000 \r2\u00020\u0001:\u0001\rB'\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u000e"}, d2 = {"Lcom/digitalwallet/app/viewmodel/main/ServiceDetailItem;", "", "name", "", "description", "icon", ImagesContract.URL, "(IIII)V", "getDescription", "()I", "getIcon", "getName", "getUrl", "Companion", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: ServiceDetailItem.kt */
public final class ServiceDetailItem {
    public static final Companion Companion = new Companion(null);
    private final int description;
    private final int icon;
    private final int name;
    private final int url;

    private ServiceDetailItem(int i, int i2, int i3, int i4) {
        this.name = i;
        this.description = i2;
        this.icon = i3;
        this.url = i4;
    }

    public /* synthetic */ ServiceDetailItem(int i, int i2, int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, i2, i3, i4);
    }

    public final int getName() {
        return this.name;
    }

    public final int getDescription() {
        return this.description;
    }

    public final int getIcon() {
        return this.icon;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/digitalwallet/app/viewmodel/main/ServiceDetailItem$Companion;", "", "()V", Constants.MessagePayloadKeys.FROM, "Lcom/digitalwallet/app/viewmodel/main/ServiceDetailItem;", "type", "Lcom/digitalwallet/app/view/main/ServiceDetailType;", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
    /* compiled from: ServiceDetailItem.kt */
    public static final class Companion {

        @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 0})
        public final /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[ServiceDetailType.values().length];
                $EnumSwitchMapping$0 = iArr;
                iArr[ServiceDetailType.PartySafe.ordinal()] = 1;
                iArr[ServiceDetailType.Absence.ordinal()] = 2;
                iArr[ServiceDetailType.CheckRego.ordinal()] = 3;
                iArr[ServiceDetailType.RenewRego.ordinal()] = 4;
                iArr[ServiceDetailType.FishingLicence.ordinal()] = 5;
                iArr[ServiceDetailType.WorkWithChildrenCheck.ordinal()] = 6;
            }
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ServiceDetailItem from(ServiceDetailType serviceDetailType) {
            Intrinsics.checkNotNullParameter(serviceDetailType, "type");
            switch (WhenMappings.$EnumSwitchMapping$0[serviceDetailType.ordinal()]) {
                case 1:
                    return new ServiceDetailItem(R.string.my_home_detail_name1, R.string.my_home_detail_desc1, R.drawable.ic_icon_nav_party, R.string.my_home_detail_url1, null);
                case 2:
                    return new ServiceDetailItem(R.string.my_home_detail_name2, R.string.my_home_detail_desc2, R.drawable.ic_icon_nav_absence, R.string.my_home_detail_url2, null);
                case 3:
                    return new ServiceDetailItem(R.string.my_vehicles_detail_name1, R.string.my_vehicles_detail_desc1, R.drawable.ic_icon_nav_registration, R.string.my_vehicles_detail_url1, null);
                case 4:
                    return new ServiceDetailItem(R.string.my_vehicles_detail_name2, R.string.my_vehicles_detail_desc2, R.drawable.ic_icon_nav_registration, R.string.my_vehicles_detail_url2, null);
                case 5:
                    return new ServiceDetailItem(R.string.my_hobbies_detail_name1, R.string.my_hobbies_detail_desc1, R.drawable.ic_icon_nav_fishing, R.string.fishing_licence_url, null);
                case 6:
                    return new ServiceDetailItem(R.string.my_work_detail_name1, R.string.my_work_detail_desc1, R.drawable.ic_icon_nav_wwcc, R.string.my_work_detail_url1, null);
                default:
                    throw new NoWhenBranchMatchedException();
            }
        }
    }

    public final int getUrl() {
        return this.url;
    }
}
