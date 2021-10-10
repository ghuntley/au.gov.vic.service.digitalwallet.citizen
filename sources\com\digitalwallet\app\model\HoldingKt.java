package com.digitalwallet.app.model;

import android.content.Context;
import com.digitalwallet.app.view.main.HoldingElementsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\"\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007\u001a*\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u001a\u0018\u0010\b\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0006\u001a\u00020\u0007*\n\u0010\u000e\"\u00020\u00012\u00020\u0001¨\u0006\u000f"}, d2 = {"getHoldingDetailTitle", "", "context", "Landroid/content/Context;", "dynamicDisplay", "Lcom/digitalwallet/app/model/DynamicHoldingDisplay;", "attributes", "Lcom/digitalwallet/app/model/HoldingRecordAttributes;", "holdingType", "Lcom/digitalwallet/app/model/HoldingType;", "subType", "Lcom/digitalwallet/app/model/SubType;", "cardTemplate", "Lcom/digitalwallet/app/model/DynamicHoldingCardTemplate;", "SharingCode", "app_citizenProdRelease"}, k = 2, mv = {1, 4, 0})
/* compiled from: Holding.kt */
public final class HoldingKt {
    public static final HoldingType holdingType(DynamicHoldingCardTemplate dynamicHoldingCardTemplate, HoldingRecordAttributes holdingRecordAttributes) {
        Intrinsics.checkNotNullParameter(holdingRecordAttributes, "attributes");
        if (dynamicHoldingCardTemplate != null) {
            return HoldingType.TEMPLATE;
        }
        return holdingRecordAttributes.embeddedHoldingType();
    }

    public static final String getHoldingDetailTitle(Context context, DynamicHoldingDisplay dynamicHoldingDisplay, HoldingRecordAttributes holdingRecordAttributes) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(holdingRecordAttributes, "attributes");
        return getHoldingDetailTitle(context, holdingType(dynamicHoldingDisplay != null ? dynamicHoldingDisplay.getCardTemplate() : null, holdingRecordAttributes), holdingRecordAttributes.getSubTypeEnum(), dynamicHoldingDisplay);
    }

    public static final String getHoldingDetailTitle(Context context, HoldingType holdingType, SubType subType, DynamicHoldingDisplay dynamicHoldingDisplay) {
        String holdingName;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(holdingType, "holdingType");
        Intrinsics.checkNotNullParameter(subType, "subType");
        if (dynamicHoldingDisplay != null && (holdingName = dynamicHoldingDisplay.getHoldingName()) != null) {
            return holdingName;
        }
        if (SubType.Companion.getWorksafeTypes().contains(subType)) {
            return subType.getDisplayName();
        }
        Integer detailTitle = HoldingElementsKt.holdingElements(holdingType, dynamicHoldingDisplay != null ? dynamicHoldingDisplay.getCardTemplate() : null).getDetailTitle();
        if (detailTitle != null) {
            return context.getString(detailTitle.intValue());
        }
        return null;
    }
}
