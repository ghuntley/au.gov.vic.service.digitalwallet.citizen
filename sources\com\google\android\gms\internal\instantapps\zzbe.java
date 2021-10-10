package com.google.android.gms.internal.instantapps;

import com.google.android.gms.internal.instantapps.zzbe;
import com.google.android.gms.internal.instantapps.zzbh;
import java.io.IOException;

public abstract class zzbe<MessageType extends zzbe<MessageType, BuilderType>, BuilderType extends zzbh<MessageType, BuilderType>> implements zzef {
    private static boolean zzaki = false;
    protected int zzakh = 0;

    @Override // com.google.android.gms.internal.instantapps.zzef
    public final zzbp zzm() {
        try {
            zzbx zzl = zzbp.zzl(zzbz());
            zzb(zzl.zzz());
            return zzl.zzy();
        } catch (IOException e) {
            String name = getClass().getName();
            StringBuilder sb = new StringBuilder(String.valueOf(name).length() + 62 + "ByteString".length());
            sb.append("Serializing ");
            sb.append(name);
            sb.append(" to a ");
            sb.append("ByteString");
            sb.append(" threw an IOException (should never happen).");
            throw new RuntimeException(sb.toString(), e);
        }
    }

    public final byte[] toByteArray() {
        try {
            byte[] bArr = new byte[zzbz()];
            zzce zzb = zzce.zzb(bArr);
            zzb(zzb);
            zzb.zzbb();
            return bArr;
        } catch (IOException e) {
            String name = getClass().getName();
            StringBuilder sb = new StringBuilder(String.valueOf(name).length() + 62 + "byte array".length());
            sb.append("Serializing ");
            sb.append(name);
            sb.append(" to a ");
            sb.append("byte array");
            sb.append(" threw an IOException (should never happen).");
            throw new RuntimeException(sb.toString(), e);
        }
    }

    /* access modifiers changed from: package-private */
    public int zzn() {
        throw new UnsupportedOperationException();
    }

    /* access modifiers changed from: package-private */
    public void zze(int i) {
        throw new UnsupportedOperationException();
    }
}
