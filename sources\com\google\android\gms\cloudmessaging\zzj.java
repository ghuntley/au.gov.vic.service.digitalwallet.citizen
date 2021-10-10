package com.google.android.gms.cloudmessaging;

import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-cloud-messaging@@16.0.0 */
final /* synthetic */ class zzj implements Runnable {
    private final zzf zza;

    zzj(zzf zzf) {
        this.zza = zzf;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0040, code lost:
        if (android.util.Log.isLoggable("MessengerIpcClient", 3) == false) goto L_0x0066;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0042, code lost:
        r4 = java.lang.String.valueOf(r1);
        r6 = new java.lang.StringBuilder(java.lang.String.valueOf(r4).length() + 8);
        r6.append("Sending ");
        r6.append(r4);
        android.util.Log.d("MessengerIpcClient", r6.toString());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0066, code lost:
        r3 = r0.zzf.zzb;
        r4 = r0.zzb;
        r5 = android.os.Message.obtain();
        r5.what = r1.zzc;
        r5.arg1 = r1.zza;
        r5.replyTo = r4;
        r4 = new android.os.Bundle();
        r4.putBoolean("oneWay", r1.zza());
        r4.putString("pkg", r3.getPackageName());
        r4.putBundle(com.google.firebase.messaging.Constants.ScionAnalytics.MessageType.DATA_MESSAGE, r1.zzd);
        r5.setData(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
        r0.zzc.zza(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x00a4, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x00a5, code lost:
        r0.zza(2, r1.getMessage());
     */
    public final void run() {
        zzf zzf = this.zza;
        while (true) {
            synchronized (zzf) {
                if (zzf.zza == 2) {
                    if (zzf.zzd.isEmpty()) {
                        zzf.zzb();
                        return;
                    }
                    zzq<?> poll = zzf.zzd.poll();
                    zzf.zze.put(poll.zza, poll);
                    zzf.zzf.zzc.schedule(new zzl(zzf, poll), 30, TimeUnit.SECONDS);
                } else {
                    return;
                }
            }
        }
    }
}
