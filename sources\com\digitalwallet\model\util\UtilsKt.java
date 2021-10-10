package com.digitalwallet.model.util;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001b\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0006\b\u0000\u0010\u0005\u0018\u0001*\u00020\u0006H\b\u001a\n\u0010\u0007\u001a\u00020\b*\u00020\t\u001a\n\u0010\n\u001a\u00020\b*\u00020\u0001\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"BLE_MAX_PACKET_SIZE", "", "UUID_BYTE_WIDTH", "adapter", "Lcom/squareup/moshi/JsonAdapter;", "T", "Lcom/squareup/moshi/Moshi;", "getBytes", "", "Ljava/util/UUID;", "toByteArray", "base_citizenProdRelease"}, k = 2, mv = {1, 4, 0})
/* compiled from: Utils.kt */
public final class UtilsKt {
    public static final int BLE_MAX_PACKET_SIZE = 20;
    public static final int UUID_BYTE_WIDTH = 16;

    public static final byte[] getBytes(UUID uuid) {
        Intrinsics.checkNotNullParameter(uuid, "$this$getBytes");
        byte[] array = ByteBuffer.wrap(new byte[16]).putLong(uuid.getMostSignificantBits()).putLong(uuid.getLeastSignificantBits()).array();
        Intrinsics.checkNotNullExpressionValue(array, "ByteBuffer.wrap(ByteArra…\n                .array()");
        return array;
    }

    public static final byte[] toByteArray(int i) {
        byte[] array = ByteBuffer.allocate(4).order(ByteOrder.LITTLE_ENDIAN).putInt(i).array();
        Intrinsics.checkNotNullExpressionValue(array, "ByteBuffer.allocate(4).o…IAN).putInt(this).array()");
        return array;
    }

    public static final /* synthetic */ <T> JsonAdapter<T> adapter(Moshi moshi) {
        Intrinsics.checkNotNullParameter(moshi, "$this$adapter");
        Intrinsics.reifiedOperationMarker(4, "T");
        JsonAdapter<T> adapter = moshi.adapter((Class) Object.class);
        Intrinsics.checkNotNullExpressionValue(adapter, "this.adapter(T::class.java)");
        return adapter;
    }
}
