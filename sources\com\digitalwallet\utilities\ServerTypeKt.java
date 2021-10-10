package com.digitalwallet.utilities;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\u001a\u000e\u0010\u000e\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u0010\u001a\u000e\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0010\"\u001b\u0010\u0000\u001a\u00020\u00018FX\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0002\u0010\u0003\"\u001b\u0010\u0006\u001a\u00020\u00078FX\u0002¢\u0006\f\n\u0004\b\n\u0010\u0005\u001a\u0004\b\b\u0010\t\"\u0015\u0010\u000b\u001a\u00020\f*\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\r¨\u0006\u0013"}, d2 = {"appType", "Lcom/digitalwallet/utilities/AppType;", "getAppType", "()Lcom/digitalwallet/utilities/AppType;", "appType$delegate", "Lkotlin/Lazy;", "serverType", "Lcom/digitalwallet/utilities/ServerType;", "getServerType", "()Lcom/digitalwallet/utilities/ServerType;", "serverType$delegate", "isInternal", "", "(Lcom/digitalwallet/utilities/ServerType;)Z", "getAppTypeFromString", "appString", "", "getServerTypeFromString", "serverString", "base_citizenProdRelease"}, k = 2, mv = {1, 4, 0})
/* compiled from: ServerType.kt */
public final class ServerTypeKt {
    private static final Lazy appType$delegate = LazyKt.lazy(ServerTypeKt$appType$2.INSTANCE);
    private static final Lazy serverType$delegate = LazyKt.lazy(ServerTypeKt$serverType$2.INSTANCE);

    public static final AppType getAppType() {
        return (AppType) appType$delegate.getValue();
    }

    public static final ServerType getServerType() {
        return (ServerType) serverType$delegate.getValue();
    }

    public static final boolean isInternal(ServerType serverType) {
        Intrinsics.checkNotNullParameter(serverType, "$this$isInternal");
        return SetsKt.setOf((Object[]) new ServerType[]{ServerType.DEV, ServerType.QA}).contains(serverType);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0048, code lost:
        if (r2.equals("uat_tb") != false) goto L_0x004a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:?, code lost:
        return com.digitalwallet.utilities.ServerType.UAT;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x001e, code lost:
        if (r2.equals("uat") != false) goto L_0x004a;
     */
    public static final ServerType getServerTypeFromString(String str) {
        Intrinsics.checkNotNullParameter(str, "serverString");
        switch (str.hashCode()) {
            case -852224347:
                break;
            case 3600:
                if (str.equals("qa")) {
                    return ServerType.QA;
                }
                Timber.w("Unknown Server Type " + str + ". Defaulting to dev configuration.", new Object[0]);
                return ServerType.DEV;
            case 99349:
                if (str.equals("dev")) {
                    return ServerType.DEV;
                }
                Timber.w("Unknown Server Type " + str + ". Defaulting to dev configuration.", new Object[0]);
                return ServerType.DEV;
            case 113886:
                if (str.equals("sit")) {
                    return ServerType.SIT;
                }
                Timber.w("Unknown Server Type " + str + ". Defaulting to dev configuration.", new Object[0]);
                return ServerType.DEV;
            case 115560:
                break;
            case 3449687:
                if (str.equals("prod")) {
                    return ServerType.PROD;
                }
                Timber.w("Unknown Server Type " + str + ". Defaulting to dev configuration.", new Object[0]);
                return ServerType.DEV;
            default:
                Timber.w("Unknown Server Type " + str + ". Defaulting to dev configuration.", new Object[0]);
                return ServerType.DEV;
        }
    }

    public static final AppType getAppTypeFromString(String str) {
        Intrinsics.checkNotNullParameter(str, "appString");
        int hashCode = str.hashCode();
        if (hashCode != 784989032) {
            if (hashCode == 1475610435 && str.equals("authority")) {
                return AppType.AUTHORITY;
            }
        } else if (str.equals("citizen")) {
            return AppType.CITIZEN;
        }
        Timber.w("Unknown app type " + str + ". Defaulting to citizen configuration.", new Object[0]);
        return AppType.CITIZEN;
    }
}
