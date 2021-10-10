package com.digitalwallet.app.services.remotenotification;

import android.content.Context;
import com.digitalwallet.app.BuildConfig;
import com.digitalwallet.app.api.DeviceRegisterApi;
import com.digitalwallet.app.model.DeviceInfo;
import com.digitalwallet.app.model.RegisterDevicePayload;
import com.digitalwallet.app.oidc.AuthenticationUtility;
import com.digitalwallet.utilities.AppType;
import com.digitalwallet.utilities.DeviceInfoKt;
import com.digitalwallet.utilities.ServerTypeKt;
import com.digitalwallet.utilities.VersionNameCodeKt;
import com.google.android.gms.stats.CodePackage;
import io.reactivex.Single;
import io.reactivex.disposables.CompositeDisposable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u001f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u0012J\u0006\u0010\u0013\u001a\u00020\u0014R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/digitalwallet/app/services/remotenotification/RemoteSubscriptionService;", "", "context", "Landroid/content/Context;", "deviceRegisterApi", "Lcom/digitalwallet/app/api/DeviceRegisterApi;", "authenticationUtility", "Lcom/digitalwallet/app/oidc/AuthenticationUtility;", "(Landroid/content/Context;Lcom/digitalwallet/app/api/DeviceRegisterApi;Lcom/digitalwallet/app/oidc/AuthenticationUtility;)V", "disposables", "Lio/reactivex/disposables/CompositeDisposable;", "isCitizen", "", "getDeviceRegistrationPayload", "Lcom/digitalwallet/app/model/RegisterDevicePayload;", "deviceToken", "", "getDeviceToken", "Lio/reactivex/Single;", "registerRemoteNotification", "", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: RemoteSubscriptionService.kt */
public final class RemoteSubscriptionService {
    private final AuthenticationUtility authenticationUtility;
    private final Context context;
    private final DeviceRegisterApi deviceRegisterApi;
    private final CompositeDisposable disposables;
    private final boolean isCitizen;

    public final void registerRemoteNotification() {
    }

    @Inject
    public RemoteSubscriptionService(Context context2, DeviceRegisterApi deviceRegisterApi2, AuthenticationUtility authenticationUtility2) {
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(deviceRegisterApi2, "deviceRegisterApi");
        Intrinsics.checkNotNullParameter(authenticationUtility2, "authenticationUtility");
        this.context = context2;
        this.deviceRegisterApi = deviceRegisterApi2;
        this.authenticationUtility = authenticationUtility2;
        this.isCitizen = ServerTypeKt.getAppType() == AppType.CITIZEN;
        this.disposables = new CompositeDisposable();
    }

    public final Single<String> getDeviceToken() {
        Single<String> create = Single.create(RemoteSubscriptionService$getDeviceToken$1.INSTANCE);
        Intrinsics.checkNotNullExpressionValue(create, "Single.create { emitter …        }\n        }\n    }");
        return create;
    }

    /* access modifiers changed from: private */
    public final RegisterDevicePayload getDeviceRegistrationPayload(String str) {
        return new RegisterDevicePayload(str, BuildConfig.DEVICE_REG_API_APPID, str, new DeviceInfo(VersionNameCodeKt.versionName(this.context), DeviceInfoKt.getDeviceLocaleName(), DeviceInfoKt.getDeviceManufacturer(), DeviceInfoKt.getDeviceModel(), "", "Android", DeviceInfoKt.getAndroidVersion(), DeviceInfoKt.getDeviceTimezoneId()), CodePackage.GCM);
    }
}
