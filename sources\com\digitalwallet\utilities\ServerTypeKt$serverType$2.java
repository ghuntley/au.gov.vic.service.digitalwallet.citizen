package com.digitalwallet.utilities;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/digitalwallet/utilities/ServerType;", "invoke"}, k = 3, mv = {1, 4, 0})
/* compiled from: ServerType.kt */
final class ServerTypeKt$serverType$2 extends Lambda implements Function0<ServerType> {
    public static final ServerTypeKt$serverType$2 INSTANCE = new ServerTypeKt$serverType$2();

    ServerTypeKt$serverType$2() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public final ServerType invoke() {
        return ServerTypeKt.getServerTypeFromString("prod");
    }
}
