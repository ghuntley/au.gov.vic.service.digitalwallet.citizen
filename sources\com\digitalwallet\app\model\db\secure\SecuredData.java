package com.digitalwallet.app.model.db.secure;

import com.digitalwallet.app.model.InitHandshakeData;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.Charsets;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JU\u0010\t\u001a\u0002H\n\"\n\b\u0000\u0010\n\u0018\u0001*\u00020\u000b26\u0010\f\u001a2\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\u00040\rH\bø\u0001\u0000¢\u0006\u0002\u0010\u0011R\u0012\u0010\u0003\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0012\u0010\u0007\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\u0006\u0001\u0001\u0012\u0002\u0007\n\u0005\b20\u0001¨\u0006\u0013"}, d2 = {"Lcom/digitalwallet/app/model/db/secure/SecuredData;", "", "()V", "encryptedData", "", "getEncryptedData", "()[B", InitHandshakeData.ivKey, "getIv", "decryptModelType", "T", "Lcom/digitalwallet/app/model/db/secure/Securable;", "with", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "bytesToDecrypt", "(Lkotlin/jvm/functions/Function2;)Lcom/digitalwallet/app/model/db/secure/Securable;", "Lcom/digitalwallet/app/model/db/secure/EncryptedSecureHoldings;", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: SecuredStore.kt */
public abstract class SecuredData {
    public abstract byte[] getEncryptedData();

    public abstract byte[] getIv();

    private SecuredData() {
    }

    public /* synthetic */ SecuredData(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* JADX DEBUG: Type inference failed for r3v2. Raw type applied. Possible types: ? super byte[] */
    /* JADX DEBUG: Type inference failed for r4v0. Raw type applied. Possible types: ? super byte[] */
    public final /* synthetic */ <T extends Securable> T decryptModelType(Function2<? super byte[], ? super byte[], byte[]> function2) {
        Intrinsics.checkNotNullParameter(function2, "with");
        Moshi build = new Moshi.Builder().build();
        Intrinsics.checkNotNullExpressionValue(build, "Moshi.Builder().build()");
        Intrinsics.reifiedOperationMarker(4, "T");
        JsonAdapter adapter = build.adapter(Object.class);
        Intrinsics.checkNotNullExpressionValue(adapter, "this.adapter(T::class.java)");
        T t = (T) ((Securable) adapter.fromJson(new String(function2.invoke(getEncryptedData(), getIv()), Charsets.UTF_8)));
        if (t != null) {
            return t;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("cannot deserialize ");
        sb.append(this);
        sb.append(" to ");
        Intrinsics.reifiedOperationMarker(4, "T");
        sb.append(Reflection.getOrCreateKotlinClass(Securable.class).getSimpleName());
        throw new IllegalStateException(sb.toString());
    }
}
