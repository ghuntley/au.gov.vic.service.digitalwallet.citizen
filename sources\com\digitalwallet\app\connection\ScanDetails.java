package com.digitalwallet.app.connection;

import com.digitalwallet.app.model.SecureHolding;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.msgpack.core.MessagePack;
import org.msgpack.core.MessagePacker;
import org.msgpack.core.MessageUnpacker;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\t\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u001d\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007B\u000f\b\u0016\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0006\u0010\u0017\u001a\u00020\tR\u001b\u0010\u000b\u001a\f\u0012\b\u0012\u00060\u0003j\u0002`\f0\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0013\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0019"}, d2 = {"Lcom/digitalwallet/app/connection/ScanDetails;", "", "name", "", "holdings", "", "Lcom/digitalwallet/app/model/SecureHolding;", "(Ljava/lang/String;Ljava/util/List;)V", "bytes", "", "([B)V", "holdingFlags", "Lcom/digitalwallet/app/model/SharingCode;", "getHoldingFlags", "()Ljava/util/List;", "majorRevision", "", "getMajorRevision", "()I", "minorRevision", "getMinorRevision", "getName", "()Ljava/lang/String;", "toBytes", "Companion", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: ScanDetails.kt */
public final class ScanDetails {
    public static final Companion Companion = new Companion(null);
    public static final int currentMajorRevision = 1;
    public static final int currentMinorRevision = 0;
    private final List<String> holdingFlags;
    private final int majorRevision;
    private final int minorRevision;
    private final String name;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/digitalwallet/app/connection/ScanDetails$Companion;", "", "()V", "currentMajorRevision", "", "currentMinorRevision", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
    /* compiled from: ScanDetails.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public final int getMajorRevision() {
        return this.majorRevision;
    }

    public final int getMinorRevision() {
        return this.minorRevision;
    }

    public final String getName() {
        return this.name;
    }

    public final List<String> getHoldingFlags() {
        return this.holdingFlags;
    }

    public ScanDetails(String str, List<SecureHolding> list) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(list, "holdings");
        this.majorRevision = 1;
        this.minorRevision = 0;
        this.name = str;
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            String sharingCode = it.next().getAttributes().getSharingCode();
            if (sharingCode != null) {
                arrayList.add(sharingCode);
            }
        }
        this.holdingFlags = CollectionsKt.distinct(arrayList);
    }

    public ScanDetails(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "bytes");
        MessageUnpacker newDefaultUnpacker = MessagePack.newDefaultUnpacker(new ByteArrayInputStream(bArr));
        boolean z = true;
        if (newDefaultUnpacker.unpackArrayHeader() >= 4) {
            int unpackInt = newDefaultUnpacker.unpackInt();
            if (unpackInt == 1) {
                Unit unit = Unit.INSTANCE;
                this.majorRevision = unpackInt;
                int unpackInt2 = newDefaultUnpacker.unpackInt();
                if (unpackInt2 > 0 ? false : z) {
                    Unit unit2 = Unit.INSTANCE;
                    this.minorRevision = unpackInt2;
                    String unpackString = newDefaultUnpacker.unpackString();
                    Intrinsics.checkNotNullExpressionValue(unpackString, "unpacker.unpackString()");
                    this.name = unpackString;
                    int unpackArrayHeader = newDefaultUnpacker.unpackArrayHeader();
                    ArrayList arrayList = new ArrayList();
                    for (int i = 0; i < unpackArrayHeader; i++) {
                        String unpackString2 = newDefaultUnpacker.unpackString();
                        Intrinsics.checkNotNullExpressionValue(unpackString2, "unpacker.unpackString()");
                        arrayList.add(unpackString2);
                    }
                    this.holdingFlags = arrayList;
                    return;
                }
                throw new IllegalStateException("Check failed.".toString());
            }
            throw new IllegalStateException("Check failed.".toString());
        }
        throw new IllegalStateException("Check failed.".toString());
    }

    public final byte[] toBytes() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        MessagePacker packArrayHeader = MessagePack.newDefaultPacker(byteArrayOutputStream).packArrayHeader(4).packInt(this.majorRevision).packInt(this.minorRevision).packString(this.name).packArrayHeader(this.holdingFlags.size());
        Iterator<T> it = this.holdingFlags.iterator();
        while (it.hasNext()) {
            packArrayHeader.packString(it.next());
        }
        packArrayHeader.close();
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        Intrinsics.checkNotNullExpressionValue(byteArray, "os.toByteArray()");
        return byteArray;
    }
}
