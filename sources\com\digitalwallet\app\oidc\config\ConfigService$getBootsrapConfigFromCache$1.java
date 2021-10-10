package com.digitalwallet.app.oidc.config;

import com.digitalwallet.app.oidc.model.BootstrapConfig;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0014\u0010\u0002\u001a\u0010\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u00040\u0003H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "emitter", "Lio/reactivex/SingleEmitter;", "Lcom/digitalwallet/app/oidc/model/BootstrapConfig;", "kotlin.jvm.PlatformType", "subscribe"}, k = 3, mv = {1, 4, 0})
/* compiled from: ConfigService.kt */
public final class ConfigService$getBootsrapConfigFromCache$1<T> implements SingleOnSubscribe<BootstrapConfig> {
    final /* synthetic */ ConfigService this$0;

    ConfigService$getBootsrapConfigFromCache$1(ConfigService configService) {
        this.this$0 = configService;
    }

    @Override // io.reactivex.SingleOnSubscribe
    public final void subscribe(SingleEmitter<BootstrapConfig> singleEmitter) {
        Intrinsics.checkNotNullParameter(singleEmitter, "emitter");
        if (this.this$0.cachedConfig != null) {
            ConfigService configService = this.this$0;
            BootstrapConfig bootstrapConfig = configService.cachedConfig;
            Objects.requireNonNull(bootstrapConfig, "null cannot be cast to non-null type com.digitalwallet.app.oidc.model.BootstrapConfig");
            if (!(configService.isOverADayOld(bootstrapConfig.getCreated()))) {
                BootstrapConfig bootstrapConfig2 = this.this$0.cachedConfig;
                Objects.requireNonNull(bootstrapConfig2, "null cannot be cast to non-null type com.digitalwallet.app.oidc.model.BootstrapConfig");
                singleEmitter.onSuccess(bootstrapConfig2);
                return;
            }
        }
        singleEmitter.onError(new Exception("Bootstrap is invalid"));
    }
}
