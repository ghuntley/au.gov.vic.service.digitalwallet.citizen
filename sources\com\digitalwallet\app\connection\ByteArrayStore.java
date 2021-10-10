package com.digitalwallet.app.connection;

import android.bluetooth.BluetoothGattCharacteristic;
import android.util.Base64;
import android.util.LruCache;
import com.digitalwallet.app.model.P2PMessage;
import com.digitalwallet.app.model.util.MPUtilsKt;
import com.digitalwallet.app.services.HandshakeService;
import io.reactivex.Maybe;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import timber.log.Timber;

public final class ByteArrayStore {
    private final byte[] eodBytes;
    private final Timber.Tree log;
    private final LruCache<Pair<UUID, Integer>, Map<Integer, byte[]>> store = new LruCache<>(2000);

    public ByteArrayStore() {
        Timber.Tree tag = Timber.tag("ByteArrayStore");
        Intrinsics.checkNotNullExpressionValue(tag, "Timber.tag(\"ByteArrayStore\")");
        this.log = tag;
        byte[] bytes = "EOD".getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "(this as java.lang.String).getBytes(charset)");
        this.eodBytes = bytes;
    }

    public static /* synthetic */ Maybe accumulateAndTryBuild$default(ByteArrayStore byteArrayStore, BluetoothGattCharacteristic bluetoothGattCharacteristic, HandshakeService handshakeService, byte[] bArr, int i, UUID uuid, int i2, Object obj) {
        if ((i2 & 8) != 0) {
            i = -1;
        }
        if ((i2 & 16) != 0) {
            uuid = null;
        }
        return byteArrayStore.accumulateAndTryBuild(bluetoothGattCharacteristic, handshakeService, bArr, i, uuid);
    }

    public final Maybe<P2PMessage<?>> accumulateAndTryBuild(BluetoothGattCharacteristic bluetoothGattCharacteristic, HandshakeService handshakeService, byte[] bArr, int i, UUID uuid) {
        Intrinsics.checkNotNullParameter(bluetoothGattCharacteristic, "characteristic");
        Intrinsics.checkNotNullParameter(handshakeService, "handshakeService");
        Intrinsics.checkNotNullParameter(bArr, "byteArray");
        UUID uuid2 = bluetoothGattCharacteristic.getUuid();
        Intrinsics.checkNotNullExpressionValue(uuid2, "characteristic.uuid");
        Pair<UUID, Integer> pair = new Pair<>(uuid2, Integer.valueOf(bluetoothGattCharacteristic.getInstanceId()));
        LinkedHashMap linkedHashMap = this.store.get(pair);
        if (linkedHashMap == null) {
            linkedHashMap = new LinkedHashMap();
        }
        if (Arrays.equals(bArr, this.eodBytes)) {
            this.store.remove(pair);
            try {
                Timber.Tree tree = this.log;
                tree.d("Characteristic parsed: " + bluetoothGattCharacteristic.getUuid(), new Object[0]);
                return build(linkedHashMap, handshakeService, uuid);
            } catch (Exception e) {
                Timber.Tree tree2 = this.log;
                tree2.d("Characteristic parsing error for " + bluetoothGattCharacteristic.getUuid() + ": " + e.getLocalizedMessage(), new Object[0]);
                StackTraceElement[] stackTrace = e.getStackTrace();
                Intrinsics.checkNotNullExpressionValue(stackTrace, "e.stackTrace");
                ArrayList arrayList = new ArrayList(stackTrace.length);
                int length = stackTrace.length;
                for (int i2 = 0; i2 < length; i2++) {
                    this.log.d(stackTrace[i2].toString(), new Object[0]);
                    arrayList.add(Unit.INSTANCE);
                }
                return Maybe.error(e);
            }
        } else {
            Integer num = (Integer) CollectionsKt.maxOrNull((Iterable) linkedHashMap.keySet());
            int intValue = num != null ? num.intValue() + 1 : 0;
            if (i != -1) {
                intValue = i;
            }
            Timber.Tree tree3 = this.log;
            tree3.d("Characteristic accumulated: " + bluetoothGattCharacteristic.getUuid() + " uuid: " + pair + " instance: " + bluetoothGattCharacteristic.getInstanceId() + " buffer: " + i + " -> " + intValue, new Object[0]);
            linkedHashMap.put(Integer.valueOf(intValue), bArr);
            this.store.put(pair, linkedHashMap);
            return null;
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:20:0x0023 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v5, types: [java.lang.Integer] */
    /* JADX WARNING: Unknown variable types count: 1 */
    private final Maybe<P2PMessage<?>> build(Map<Integer, byte[]> map, HandshakeService handshakeService, UUID uuid) {
        Set keySet = MapsKt.toSortedMap(map).keySet();
        Intrinsics.checkNotNullExpressionValue(keySet, "buffer.toSortedMap().keys");
        Iterator it = CollectionsKt.toList(keySet).iterator();
        if (it.hasNext()) {
            ?? next = it.next();
            while (it.hasNext()) {
                Integer num = (Integer) it.next();
                next = (Integer) next;
                int intValue = next.intValue() + 1;
                if (num != null) {
                    num.intValue();
                }
            }
            Collection values = MapsKt.toSortedMap(map).values();
            Intrinsics.checkNotNullExpressionValue(values, "buffer\n            .toSortedMap().values");
            byte[] bArr = new byte[0];
            for (byte[] bArr2 : CollectionsKt.toList(values)) {
                Intrinsics.checkNotNullExpressionValue(bArr2, "right");
                bArr = ArraysKt.plus(bArr, bArr2);
            }
            Set keySet2 = MapsKt.toSortedMap(map).keySet();
            Intrinsics.checkNotNullExpressionValue(keySet2, "buffer.toSortedMap().keys");
            Iterator it2 = CollectionsKt.toList(keySet2).iterator();
            String str = "";
            while (it2.hasNext()) {
                str = str + ' ' + ((Integer) it2.next());
            }
            String encodeToString = Base64.encodeToString(bArr, 2);
            this.log.d("Accumulated bytes ids: " + str, new Object[0]);
            this.log.d("Accumulated bytes data: " + encodeToString + " size: " + bArr.length, new Object[0]);
            return MPUtilsKt.deserializeToMessage(bArr, handshakeService, uuid);
        }
        throw new UnsupportedOperationException("Empty collection can't be reduced.");
    }

    public final void reset(BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        Intrinsics.checkNotNullParameter(bluetoothGattCharacteristic, "characteristic");
        Timber.Tree tree = this.log;
        tree.d("Reset bytes: " + bluetoothGattCharacteristic.getUuid() + ' ' + bluetoothGattCharacteristic.getInstanceId(), new Object[0]);
        UUID uuid = bluetoothGattCharacteristic.getUuid();
        Intrinsics.checkNotNullExpressionValue(uuid, "characteristic.uuid");
        this.store.remove(new Pair<>(uuid, Integer.valueOf(bluetoothGattCharacteristic.getInstanceId())));
    }

    public final void purge() {
        this.store.evictAll();
    }
}
