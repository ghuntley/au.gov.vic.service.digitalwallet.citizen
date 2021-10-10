package com.google.android.gms.vision.clearcut;

import android.content.Context;
import com.google.android.gms.clearcut.ClearcutLogger;
import com.google.android.gms.internal.vision.zzfe;
import com.google.android.gms.internal.vision.zzfi;
import com.google.android.gms.internal.vision.zzio;
import com.google.android.gms.vision.L;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
public class VisionClearcutLogger {
    private final ClearcutLogger zza;
    private boolean zzb = true;

    public VisionClearcutLogger(Context context) {
        this.zza = new ClearcutLogger(context, "VISION", null);
    }

    public final void zza(int i, zzfi.zzo zzo) {
        byte[] zzh = zzo.zzh();
        if (i < 0 || i > 3) {
            L.i("Illegal event code: %d", Integer.valueOf(i));
            return;
        }
        try {
            if (this.zzb) {
                this.zza.newEvent(zzh).setEventCode(i).log();
                return;
            }
            zzfi.zzo.zza zza2 = zzfi.zzo.zza();
            try {
                zza2.zza(zzh, 0, zzh.length, zzio.zzc());
                L.e("Would have logged:\n%s", zza2.toString());
            } catch (Exception e) {
                L.e(e, "Parsing error", new Object[0]);
            }
        } catch (Exception e2) {
            zzfe.zza(e2);
            L.e(e2, "Failed to log", new Object[0]);
        }
    }
}
