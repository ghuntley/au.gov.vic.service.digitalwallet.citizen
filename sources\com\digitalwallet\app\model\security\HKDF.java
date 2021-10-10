package com.digitalwallet.app.model.security;

import com.digitalwallet.app.model.InitHandshakeData;
import com.digitalwallet.app.model.security.HkdfMacFactory;
import com.google.firebase.messaging.Constants;
import java.nio.ByteBuffer;
import javax.crypto.Mac;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000b\u0018\u0000 \u00122\u00020\u0001:\u0003\u0012\u0013\u0014B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\nJ\u0016\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u0006J(\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u00062\b\u0010\u0010\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0011\u001a\u00020\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/digitalwallet/app/model/security/HKDF;", "", "macFactory", "Lcom/digitalwallet/app/model/security/HkdfMacFactory;", "(Lcom/digitalwallet/app/model/security/HkdfMacFactory;)V", "expand", "", "pseudoRandomKey", "info", "outLengthBytes", "", "extract", InitHandshakeData.saltKey, "inputKeyingMaterial", "extractAndExpand", "saltExtract", "infoExpand", "outLengthByte", "Companion", "Expander", "Extractor", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: HKDF.kt */
public final class HKDF {
    public static final Companion Companion = new Companion(null);
    private static HKDF hkdfHmacSha256;
    private static HKDF hkdfHmacSha512;
    private final HkdfMacFactory macFactory;

    private HKDF(HkdfMacFactory hkdfMacFactory) {
        this.macFactory = hkdfMacFactory;
    }

    public /* synthetic */ HKDF(HkdfMacFactory hkdfMacFactory, DefaultConstructorMarker defaultConstructorMarker) {
        this(hkdfMacFactory);
    }

    public final byte[] extract(byte[] bArr, byte[] bArr2) {
        Intrinsics.checkNotNullParameter(bArr, InitHandshakeData.saltKey);
        Intrinsics.checkNotNullParameter(bArr2, "inputKeyingMaterial");
        return new Extractor(this.macFactory).execute(bArr, bArr2);
    }

    public final byte[] expand(byte[] bArr, byte[] bArr2, int i) {
        Intrinsics.checkNotNullParameter(bArr, "pseudoRandomKey");
        Intrinsics.checkNotNullParameter(bArr2, "info");
        return new Expander(this.macFactory).execute(bArr, bArr2, i);
    }

    public final byte[] extractAndExpand(byte[] bArr, byte[] bArr2, byte[] bArr3, int i) {
        Intrinsics.checkNotNullParameter(bArr, "saltExtract");
        Intrinsics.checkNotNullParameter(bArr2, "inputKeyingMaterial");
        return new Expander(this.macFactory).execute(new Extractor(this.macFactory).execute(bArr, bArr2), bArr3, i);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001a\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u0006R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/digitalwallet/app/model/security/HKDF$Extractor;", "", "macFactory", "Lcom/digitalwallet/app/model/security/HkdfMacFactory;", "(Lcom/digitalwallet/app/model/security/HkdfMacFactory;)V", "execute", "", InitHandshakeData.saltKey, "inputKeyingMaterial", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
    /* compiled from: HKDF.kt */
    public static final class Extractor {
        private final HkdfMacFactory macFactory;

        public Extractor(HkdfMacFactory hkdfMacFactory) {
            Intrinsics.checkNotNullParameter(hkdfMacFactory, "macFactory");
            this.macFactory = hkdfMacFactory;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:11:0x0020, code lost:
            if (r1 != false) goto L_0x0022;
         */
        public final byte[] execute(byte[] bArr, byte[] bArr2) {
            if (bArr2 != null) {
                boolean z = false;
                if (!(bArr2.length == 0)) {
                    byte[] bArr3 = new byte[this.macFactory.createInstance(new byte[1]).getMacLength()];
                    if (bArr != null) {
                        if (bArr.length == 0) {
                            z = true;
                        }
                    }
                    bArr = bArr3;
                    byte[] doFinal = this.macFactory.createInstance(bArr).doFinal(bArr2);
                    Intrinsics.checkNotNullExpressionValue(doFinal, "saltToUse\n              …inal(inputKeyingMaterial)");
                    return doFinal;
                }
            }
            throw new IllegalArgumentException("provided inputKeyingMaterial must be at least of size 1 and not null");
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\"\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/digitalwallet/app/model/security/HKDF$Expander;", "", "macFactory", "Lcom/digitalwallet/app/model/security/HkdfMacFactory;", "(Lcom/digitalwallet/app/model/security/HkdfMacFactory;)V", "execute", "", "pseudoRandomKey", "info", "outLengthBytes", "", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
    /* compiled from: HKDF.kt */
    public static final class Expander {
        private final HkdfMacFactory macFactory;

        public Expander(HkdfMacFactory hkdfMacFactory) {
            Intrinsics.checkNotNullParameter(hkdfMacFactory, "macFactory");
            this.macFactory = hkdfMacFactory;
        }

        public final byte[] execute(byte[] bArr, byte[] bArr2, int i) {
            if (i > 0) {
                if (bArr != null) {
                    if (!(bArr.length == 0)) {
                        Mac createInstance = this.macFactory.createInstance(bArr);
                        byte[] bArr3 = new byte[0];
                        int ceil = (int) Math.ceil(((double) i) / ((double) createInstance.getMacLength()));
                        if (ceil <= 255) {
                            ByteBuffer allocate = ByteBuffer.allocate(i);
                            if (bArr2 == null) {
                                bArr2 = new byte[0];
                            }
                            int i2 = 0;
                            while (i2 < ceil) {
                                createInstance.update(bArr3);
                                createInstance.update(bArr2);
                                i2++;
                                createInstance.update((byte) i2);
                                bArr3 = createInstance.doFinal();
                                Intrinsics.checkNotNullExpressionValue(bArr3, "hmacHasher.doFinal()");
                                int min = Math.min(i, bArr3.length);
                                allocate.put(bArr3, 0, min);
                                i -= min;
                            }
                            byte[] array = allocate.array();
                            Intrinsics.checkNotNullExpressionValue(array, "buffer.array()");
                            return array;
                        }
                        throw new IllegalArgumentException("out length must be maximal 255 * hash-length; requested: " + i + " bytes");
                    }
                }
                throw new IllegalArgumentException("provided pseudoRandomKey must be at least of size 1 and not null");
            }
            throw new IllegalArgumentException("out length bytes must be at least 1");
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bJ\b\u0010\t\u001a\u0004\u0018\u00010\u0004J\b\u0010\n\u001a\u0004\u0018\u00010\u0004R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/digitalwallet/app/model/security/HKDF$Companion;", "", "()V", "hkdfHmacSha256", "Lcom/digitalwallet/app/model/security/HKDF;", "hkdfHmacSha512", Constants.MessagePayloadKeys.FROM, "macFactory", "Lcom/digitalwallet/app/model/security/HkdfMacFactory;", "fromHmacSha256", "fromHmacSha512", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
    /* compiled from: HKDF.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final HKDF fromHmacSha256() {
            if (HKDF.hkdfHmacSha256 == null) {
                HKDF.hkdfHmacSha256 = from(HkdfMacFactory.Default.Companion.hmacSha256());
            }
            return HKDF.hkdfHmacSha256;
        }

        public final HKDF fromHmacSha512() {
            if (HKDF.hkdfHmacSha512 == null) {
                HKDF.hkdfHmacSha512 = from(HkdfMacFactory.Default.Companion.hmacSha512());
            }
            return HKDF.hkdfHmacSha512;
        }

        public final HKDF from(HkdfMacFactory hkdfMacFactory) {
            Intrinsics.checkNotNullParameter(hkdfMacFactory, "macFactory");
            return new HKDF(hkdfMacFactory, null);
        }
    }
}
