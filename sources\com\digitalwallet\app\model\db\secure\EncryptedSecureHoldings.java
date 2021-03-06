package com.digitalwallet.app.model.db.secure;

import com.digitalwallet.app.model.InitHandshakeData;
import java.util.Arrays;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0012\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0002J\b\u0010\u0015\u001a\u00020\u0003H\u0016J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u0014\u0010\u0006\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0018"}, d2 = {"Lcom/digitalwallet/app/model/db/secure/EncryptedSecureHoldings;", "Lcom/digitalwallet/app/model/db/secure/SecuredData;", "id", "", InitHandshakeData.ivKey, "", "encryptedData", "(I[B[B)V", "getEncryptedData", "()[B", "getId", "()I", "getIv", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "toString", "", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: SecuredStore.kt */
public final class EncryptedSecureHoldings extends SecuredData {
    private final byte[] encryptedData;
    private final int id;
    private final byte[] iv;

    public static /* synthetic */ EncryptedSecureHoldings copy$default(EncryptedSecureHoldings encryptedSecureHoldings, int i, byte[] bArr, byte[] bArr2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = encryptedSecureHoldings.id;
        }
        if ((i2 & 2) != 0) {
            bArr = encryptedSecureHoldings.getIv();
        }
        if ((i2 & 4) != 0) {
            bArr2 = encryptedSecureHoldings.getEncryptedData();
        }
        return encryptedSecureHoldings.copy(i, bArr, bArr2);
    }

    public final int component1() {
        return this.id;
    }

    public final byte[] component2() {
        return getIv();
    }

    public final byte[] component3() {
        return getEncryptedData();
    }

    public final EncryptedSecureHoldings copy(int i, byte[] bArr, byte[] bArr2) {
        Intrinsics.checkNotNullParameter(bArr, InitHandshakeData.ivKey);
        Intrinsics.checkNotNullParameter(bArr2, "encryptedData");
        return new EncryptedSecureHoldings(i, bArr, bArr2);
    }

    public String toString() {
        return "EncryptedSecureHoldings(id=" + this.id + ", iv=" + Arrays.toString(getIv()) + ", encryptedData=" + Arrays.toString(getEncryptedData()) + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ EncryptedSecureHoldings(int i, byte[] bArr, byte[] bArr2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 0 : i, bArr, bArr2);
    }

    public final int getId() {
        return this.id;
    }

    @Override // com.digitalwallet.app.model.db.secure.SecuredData
    public byte[] getIv() {
        return this.iv;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public EncryptedSecureHoldings(int i, byte[] bArr, byte[] bArr2) {
        super(null);
        Intrinsics.checkNotNullParameter(bArr, InitHandshakeData.ivKey);
        Intrinsics.checkNotNullParameter(bArr2, "encryptedData");
        this.id = i;
        this.iv = bArr;
        this.encryptedData = bArr2;
    }

    @Override // com.digitalwallet.app.model.db.secure.SecuredData
    public byte[] getEncryptedData() {
        return this.encryptedData;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!Intrinsics.areEqual(getClass(), obj != null ? obj.getClass() : null)) {
            return false;
        }
        Objects.requireNonNull(obj, "null cannot be cast to non-null type com.digitalwallet.app.model.db.secure.EncryptedSecureHoldings");
        EncryptedSecureHoldings encryptedSecureHoldings = (EncryptedSecureHoldings) obj;
        if (this.id == encryptedSecureHoldings.id && Arrays.equals(getEncryptedData(), encryptedSecureHoldings.getEncryptedData())) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (this.id * 31) + Arrays.hashCode(getEncryptedData());
    }
}
