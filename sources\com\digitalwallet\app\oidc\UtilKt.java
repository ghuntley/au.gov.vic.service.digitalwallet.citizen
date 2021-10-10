package com.digitalwallet.app.oidc;

import com.squareup.moshi.Moshi;
import com.squareup.moshi.Types;
import java.nio.charset.Charset;
import java.util.Map;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0012\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u001e\u0010\u0000\u001a\u00020\u0001*\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00022\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"toByteArray", "", "", "", "", "moshi", "Lcom/squareup/moshi/Moshi;", "app_citizenProdRelease"}, k = 2, mv = {1, 4, 0})
/* compiled from: Util.kt */
public final class UtilKt {
    public static final byte[] toByteArray(Map<String, ? extends Object> map, Moshi moshi) {
        Intrinsics.checkNotNullParameter(map, "$this$toByteArray");
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        String json = moshi.adapter(Types.newParameterizedType(Map.class, String.class, Object.class)).toJson(map);
        Intrinsics.checkNotNullExpressionValue(json, "moshi.adapter<Map<String…            .toJson(this)");
        Charset charset = Charsets.UTF_8;
        Objects.requireNonNull(json, "null cannot be cast to non-null type java.lang.String");
        byte[] bytes = json.getBytes(charset);
        Intrinsics.checkNotNullExpressionValue(bytes, "(this as java.lang.String).getBytes(charset)");
        return bytes;
    }
}
