package com.digitalwallet.app.model.db.unsecure;

import com.digitalwallet.app.model.DynamicHoldingDisplay;
import com.google.firebase.messaging.Constants;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0007J\u0012\u0010\u0007\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u0004H\u0007¨\u0006\t"}, d2 = {"Lcom/digitalwallet/app/model/db/unsecure/DynamicHoldingDisplayConverter;", "", "()V", "toDisplay", "Lcom/digitalwallet/app/model/DynamicHoldingDisplay;", "json", "", "toJson", Constants.ScionAnalytics.MessageType.DISPLAY_NOTIFICATION, "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: UnsecuredHolding.kt */
public final class DynamicHoldingDisplayConverter {
    public final String toJson(DynamicHoldingDisplay dynamicHoldingDisplay) {
        if (dynamicHoldingDisplay != null) {
            Moshi build = new Moshi.Builder().build();
            Intrinsics.checkNotNullExpressionValue(build, "Moshi.Builder().build()");
            JsonAdapter adapter = build.adapter(DynamicHoldingDisplay.class);
            Intrinsics.checkNotNullExpressionValue(adapter, "this.adapter(T::class.java)");
            String json = adapter.toJson(dynamicHoldingDisplay);
            if (json != null) {
                return json;
            }
        }
        return "";
    }

    public final DynamicHoldingDisplay toDisplay(String str) {
        try {
            Moshi build = new Moshi.Builder().build();
            Intrinsics.checkNotNullExpressionValue(build, "Moshi.Builder().build()");
            JsonAdapter adapter = build.adapter(DynamicHoldingDisplay.class);
            Intrinsics.checkNotNullExpressionValue(adapter, "this.adapter(T::class.java)");
            if (str == null) {
                str = "";
            }
            return (DynamicHoldingDisplay) adapter.fromJson(str);
        } catch (Exception unused) {
            return null;
        }
    }
}
