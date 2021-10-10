package com.digitalwallet.app.model;

import au.gov.vic.service.digitalwallet.citizen.R;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/digitalwallet/app/model/DynamicHoldingTemplateType;", "", "(Ljava/lang/String;I)V", "cardFrontLayoutID", "", "getCardFrontLayoutID", "()I", "TYPE1", "TYPE2", "TYPE3", "TYPE4", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: Holding.kt */
public enum DynamicHoldingTemplateType {
    TYPE1,
    TYPE2,
    TYPE3,
    TYPE4;

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 0})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[DynamicHoldingTemplateType.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[DynamicHoldingTemplateType.TYPE1.ordinal()] = 1;
            iArr[DynamicHoldingTemplateType.TYPE2.ordinal()] = 2;
            iArr[DynamicHoldingTemplateType.TYPE3.ordinal()] = 3;
            iArr[DynamicHoldingTemplateType.TYPE4.ordinal()] = 4;
        }
    }

    public final int getCardFrontLayoutID() {
        int i = WhenMappings.$EnumSwitchMapping$0[ordinal()];
        if (i == 1) {
            return R.layout.card_template_1_front;
        }
        if (i == 2) {
            return R.layout.card_template_2_front;
        }
        if (i == 3) {
            return R.layout.card_template_3_front;
        }
        if (i == 4) {
            return R.layout.card_template_4_front;
        }
        throw new NoWhenBranchMatchedException();
    }
}
