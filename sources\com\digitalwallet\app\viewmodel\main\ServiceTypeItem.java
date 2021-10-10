package com.digitalwallet.app.viewmodel.main;

import au.gov.vic.service.digitalwallet.citizen.R;
import com.digitalwallet.app.view.main.ServiceDetailType;
import com.digitalwallet.app.view.main.ServiceType;
import com.google.firebase.messaging.Constants;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB%\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u000f"}, d2 = {"Lcom/digitalwallet/app/viewmodel/main/ServiceTypeItem;", "", "name", "", "image", "serviceDetails", "", "Lcom/digitalwallet/app/view/main/ServiceDetailType;", "(IILjava/util/List;)V", "getImage", "()I", "getName", "getServiceDetails", "()Ljava/util/List;", "Companion", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: ServiceTypeItem.kt */
public final class ServiceTypeItem {
    public static final Companion Companion = new Companion(null);
    private final int image;
    private final int name;
    private final List<ServiceDetailType> serviceDetails;

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: java.util.List<? extends com.digitalwallet.app.view.main.ServiceDetailType> */
    /* JADX WARN: Multi-variable type inference failed */
    private ServiceTypeItem(int i, int i2, List<? extends ServiceDetailType> list) {
        this.name = i;
        this.image = i2;
        this.serviceDetails = list;
    }

    public /* synthetic */ ServiceTypeItem(int i, int i2, List list, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, i2, list);
    }

    public final int getName() {
        return this.name;
    }

    public final int getImage() {
        return this.image;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/digitalwallet/app/viewmodel/main/ServiceTypeItem$Companion;", "", "()V", Constants.MessagePayloadKeys.FROM, "Lcom/digitalwallet/app/viewmodel/main/ServiceTypeItem;", "type", "Lcom/digitalwallet/app/view/main/ServiceType;", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
    /* compiled from: ServiceTypeItem.kt */
    public static final class Companion {

        @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 0})
        public final /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[ServiceType.values().length];
                $EnumSwitchMapping$0 = iArr;
                iArr[ServiceType.Home.ordinal()] = 1;
                iArr[ServiceType.Vehicles.ordinal()] = 2;
                iArr[ServiceType.Hobbies.ordinal()] = 3;
                iArr[ServiceType.Work.ordinal()] = 4;
            }
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ServiceTypeItem from(ServiceType serviceType) {
            Intrinsics.checkNotNullParameter(serviceType, "type");
            int i = WhenMappings.$EnumSwitchMapping$0[serviceType.ordinal()];
            if (i == 1) {
                return new ServiceTypeItem(R.string.my_home_title, com.digitalwallet.app.R.drawable.my_home, CollectionsKt.listOf((Object[]) new ServiceDetailType[]{ServiceDetailType.PartySafe, ServiceDetailType.Absence}), null);
            } else if (i == 2) {
                return new ServiceTypeItem(R.string.my_vehicles_title, com.digitalwallet.app.R.drawable.my_vehicles, CollectionsKt.listOf((Object[]) new ServiceDetailType[]{ServiceDetailType.CheckRego, ServiceDetailType.RenewRego}), null);
            } else if (i == 3) {
                return new ServiceTypeItem(R.string.my_hobbies_title, com.digitalwallet.app.R.drawable.my_hobbies, CollectionsKt.listOf(ServiceDetailType.FishingLicence), null);
            } else {
                if (i == 4) {
                    return new ServiceTypeItem(R.string.my_work_title, com.digitalwallet.app.R.drawable.my_work, CollectionsKt.listOf(ServiceDetailType.WorkWithChildrenCheck), null);
                }
                throw new NoWhenBranchMatchedException();
            }
        }
    }

    public final List<ServiceDetailType> getServiceDetails() {
        return this.serviceDetails;
    }
}
