package com.google.android.gms.internal.instantapps;

import com.google.android.gms.internal.instantapps.zzbe;
import com.google.android.gms.internal.instantapps.zzbh;
import java.io.IOException;

public abstract class zzbh<MessageType extends zzbe<MessageType, BuilderType>, BuilderType extends zzbh<MessageType, BuilderType>> implements zzee {
    /* access modifiers changed from: protected */
    public abstract BuilderType zza(MessageType messagetype);

    public abstract BuilderType zza(zzcb zzcb, zzck zzck) throws IOException;

    /* renamed from: zzo */
    public abstract BuilderType clone();

    public BuilderType zza(byte[] bArr, int i, int i2, zzck zzck) throws zzdf {
        try {
            zzcb zza = zzcb.zza(bArr, 0, i2, false);
            zza(zza, zzck);
            zza.zzm(0);
            return this;
        } catch (zzdf e) {
            throw e;
        } catch (IOException e2) {
            String name = getClass().getName();
            StringBuilder sb = new StringBuilder(String.valueOf(name).length() + 60 + "byte array".length());
            sb.append("Reading ");
            sb.append(name);
            sb.append(" from a ");
            sb.append("byte array");
            sb.append(" threw an IOException (should never happen).");
            throw new RuntimeException(sb.toString(), e2);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.google.android.gms.internal.instantapps.zzbh<MessageType extends com.google.android.gms.internal.instantapps.zzbe<MessageType, BuilderType>, BuilderType extends com.google.android.gms.internal.instantapps.zzbh<MessageType, BuilderType>> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.instantapps.zzee
    public final /* synthetic */ zzee zza(zzef zzef) {
        if (zzbx().getClass().isInstance(zzef)) {
            return zza((zzbe) zzef);
        }
        throw new IllegalArgumentException("mergeFrom(MessageLite) can only merge messages of the same type.");
    }
}
