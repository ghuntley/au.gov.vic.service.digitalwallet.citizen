package com.digitalwallet.app.holdings;

import com.digitalwallet.app.model.SecureHolding;
import com.nimbusds.jwt.SignedJWT;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00040\u0001¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "Lcom/digitalwallet/app/model/SecureHolding;", "p1", "Lcom/nimbusds/jwt/SignedJWT;", "invoke"}, k = 3, mv = {1, 4, 0})
/* compiled from: HoldingsApiService.kt */
public final /* synthetic */ class HoldingsApiService$fetchSecureHoldings$6 extends FunctionReferenceImpl implements Function1<List<? extends SignedJWT>, List<? extends SecureHolding>> {
    HoldingsApiService$fetchSecureHoldings$6(HoldingParser holdingParser) {
        super(1, holdingParser, HoldingParser.class, "parseHoldings", "parseHoldings(Ljava/util/List;)Ljava/util/List;", 0);
    }

    public final List<SecureHolding> invoke(List<? extends SignedJWT> list) {
        Intrinsics.checkNotNullParameter(list, "p1");
        return ((HoldingParser) this.receiver).parseHoldings(list);
    }
}
