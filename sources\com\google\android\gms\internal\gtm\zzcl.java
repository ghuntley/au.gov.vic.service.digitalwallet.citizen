package com.google.android.gms.internal.gtm;

import com.google.android.gms.common.internal.Preconditions;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/* access modifiers changed from: package-private */
public final class zzcl {
    private int zzabs;
    private ByteArrayOutputStream zzabt = new ByteArrayOutputStream();
    private final /* synthetic */ zzck zzabu;

    public zzcl(zzck zzck) {
        this.zzabu = zzck;
    }

    public final boolean zze(zzcd zzcd) {
        Preconditions.checkNotNull(zzcd);
        if (this.zzabs + 1 > zzbq.zzes()) {
            return false;
        }
        String zza = this.zzabu.zza(zzcd, false);
        if (zza == null) {
            this.zzabu.zzco().zza(zzcd, "Error formatting hit");
            return true;
        }
        byte[] bytes = zza.getBytes();
        int length = bytes.length;
        if (length > zzbq.zzeo()) {
            this.zzabu.zzco().zza(zzcd, "Hit size exceeds the maximum size limit");
            return true;
        }
        if (this.zzabt.size() > 0) {
            length++;
        }
        if (this.zzabt.size() + length > zzby.zzzz.get().intValue()) {
            return false;
        }
        try {
            if (this.zzabt.size() > 0) {
                this.zzabt.write(zzck.zzabr);
            }
            this.zzabt.write(bytes);
            this.zzabs++;
            return true;
        } catch (IOException e) {
            this.zzabu.zze("Failed to write payload when batching hits", e);
            return true;
        }
    }

    public final int zzfu() {
        return this.zzabs;
    }

    public final byte[] getPayload() {
        return this.zzabt.toByteArray();
    }
}
