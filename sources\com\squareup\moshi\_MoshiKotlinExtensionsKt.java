package com.squareup.moshi;

import com.squareup.moshi.Moshi;
import com.squareup.moshi.internal.NonNullJsonAdapter;
import com.squareup.moshi.internal.NullSafeJsonAdapter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KType;
import kotlin.reflect.TypesJVMKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u001b\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003H\b\u001a \u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0007\u001a#\u0010\u0006\u001a\u00020\u0007\"\u0006\b\u0000\u0010\u0002\u0018\u0001*\u00020\u00072\f\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001H\b¨\u0006\b"}, d2 = {"adapter", "Lcom/squareup/moshi/JsonAdapter;", "T", "Lcom/squareup/moshi/Moshi;", "ktype", "Lkotlin/reflect/KType;", "addAdapter", "Lcom/squareup/moshi/Moshi$Builder;", "moshi"}, k = 2, mv = {1, 4, 0})
/* compiled from: -MoshiKotlinExtensions.kt */
public final class _MoshiKotlinExtensionsKt {
    public static final /* synthetic */ <T> JsonAdapter<T> adapter(Moshi moshi) {
        Intrinsics.checkNotNullParameter(moshi, "$this$adapter");
        Intrinsics.reifiedOperationMarker(6, "T");
        return adapter(moshi, null);
    }

    public static final /* synthetic */ <T> Moshi.Builder addAdapter(Moshi.Builder builder, JsonAdapter<T> jsonAdapter) {
        Intrinsics.checkNotNullParameter(builder, "$this$addAdapter");
        Intrinsics.checkNotNullParameter(jsonAdapter, "adapter");
        Intrinsics.reifiedOperationMarker(6, "T");
        Moshi.Builder add = builder.add(TypesJVMKt.getJavaType((KType) null), jsonAdapter);
        Intrinsics.checkNotNullExpressionValue(add, "add(typeOf<T>().javaType, adapter)");
        return add;
    }

    public static final <T> JsonAdapter<T> adapter(Moshi moshi, KType kType) {
        Intrinsics.checkNotNullParameter(moshi, "$this$adapter");
        Intrinsics.checkNotNullParameter(kType, "ktype");
        JsonAdapter<T> adapter = moshi.adapter(TypesJVMKt.getJavaType(kType));
        if (!(adapter instanceof NullSafeJsonAdapter) && !(adapter instanceof NonNullJsonAdapter)) {
            if (kType.isMarkedNullable()) {
                adapter = adapter.nullSafe();
            } else {
                adapter = adapter.nonNull();
            }
            Intrinsics.checkNotNullExpressionValue(adapter, "if (ktype.isMarkedNullab…    adapter.nonNull()\n  }");
        }
        return adapter;
    }
}
