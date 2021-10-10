package com.digitalwallet.app.holdings;

import com.digitalwallet.app.model.SecureHolding;
import com.digitalwallet.app.model.db.secure.SecuredData;
import com.digitalwallet.app.model.db.secure.SecuredStoreKt;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.Charsets;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0016\u0012\u0004\u0012\u00020\u0002 \u0003*\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00010\u00012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00050\u0001H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "Lcom/digitalwallet/app/model/SecureHolding;", "kotlin.jvm.PlatformType", "results", "Lcom/digitalwallet/app/model/db/secure/SecuredData;", "apply"}, k = 3, mv = {1, 4, 0})
/* compiled from: HoldingsDbService.kt */
public final class HoldingsDbService$getSecureHoldings$1<T, R> implements Function<List<? extends SecuredData>, List<? extends SecureHolding>> {
    public static final HoldingsDbService$getSecureHoldings$1 INSTANCE = new HoldingsDbService$getSecureHoldings$1();

    HoldingsDbService$getSecureHoldings$1() {
    }

    public final List<SecureHolding> apply(List<? extends SecuredData> list) {
        Intrinsics.checkNotNullParameter(list, "results");
        List<? extends SecuredData> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        for (T t : list2) {
            Moshi build = new Moshi.Builder().build();
            Intrinsics.checkNotNullExpressionValue(build, "Moshi.Builder().build()");
            JsonAdapter<T> adapter = build.adapter((Class) SecureHolding.class);
            Intrinsics.checkNotNullExpressionValue(adapter, "this.adapter(T::class.java)");
            T fromJson = adapter.fromJson(new String(SecuredStoreKt.decrypt(t.getEncryptedData(), t.getIv()), Charsets.UTF_8));
            if (fromJson != null) {
                arrayList.add(fromJson);
            } else {
                throw new IllegalStateException("cannot deserialize " + ((Object) t) + " to " + Reflection.getOrCreateKotlinClass(SecureHolding.class).getSimpleName());
            }
        }
        return arrayList;
    }
}
