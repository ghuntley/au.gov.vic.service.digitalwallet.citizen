package com.digitalwallet.app.holdings;

import com.digitalwallet.app.model.HoldingRecord;
import com.digitalwallet.app.model.HoldingSet;
import com.nimbusds.jose.jwk.JWKSet;
import com.nimbusds.jwt.SignedJWT;
import io.reactivex.functions.BiFunction;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0010\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\n¢\u0006\u0002\b\b"}, d2 = {"<anonymous>", "", "Lcom/nimbusds/jwt/SignedJWT;", "kotlin.jvm.PlatformType", "decodedHoldings", "Lcom/digitalwallet/app/model/HoldingSet;", "keys", "Lcom/nimbusds/jose/jwk/JWKSet;", "apply"}, k = 3, mv = {1, 4, 0})
/* compiled from: HoldingsApiService.kt */
public final class HoldingsApiService$fetchSecureHoldings$5<T1, T2, R> implements BiFunction<HoldingSet, JWKSet, List<? extends SignedJWT>> {
    final /* synthetic */ HoldingsApiService this$0;

    HoldingsApiService$fetchSecureHoldings$5(HoldingsApiService holdingsApiService) {
        this.this$0 = holdingsApiService;
    }

    public final List<SignedJWT> apply(HoldingSet holdingSet, JWKSet jWKSet) {
        Intrinsics.checkNotNullParameter(holdingSet, "decodedHoldings");
        Intrinsics.checkNotNullParameter(jWKSet, "keys");
        this.this$0.appStartUp.updateIssuerKeys(jWKSet);
        List<HoldingRecord> records = holdingSet.getRecords();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(records, 10));
        Iterator<T> it = records.iterator();
        while (it.hasNext()) {
            arrayList.add(SignedJWT.parse(it.next().getToken()));
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : arrayList) {
            SignedJWT signedJWT = (SignedJWT) obj;
            HoldingParser holdingParser = this.this$0.holdingParser;
            Intrinsics.checkNotNullExpressionValue(signedJWT, "it");
            if (holdingParser.validate(signedJWT, jWKSet)) {
                arrayList2.add(obj);
            }
        }
        return arrayList2;
    }
}
