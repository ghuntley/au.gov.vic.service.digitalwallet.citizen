package com.google.android.gms.internal.measurement;

import java.io.PrintStream;
import org.objectweb.asm.Opcodes;

/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
public final class zzgb {
    private static final zzga zza;
    private static final int zzb;

    /* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
    static final class zza extends zzga {
        zza() {
        }

        @Override // com.google.android.gms.internal.measurement.zzga
        public final void zza(Throwable th, Throwable th2) {
        }
    }

    public static void zza(Throwable th, Throwable th2) {
        zza.zza(th, th2);
    }

    private static Integer zza() {
        try {
            return (Integer) Class.forName("android.os.Build$VERSION").getField("SDK_INT").get(null);
        } catch (Exception e) {
            System.err.println("Failed to retrieve value from android.os.Build$VERSION.SDK_INT due to the following exception.");
            e.printStackTrace(System.err);
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0068  */
    static {
        zzga zzga;
        Integer num;
        Throwable th;
        int i = 1;
        try {
            num = zza();
            if (num != null) {
                try {
                    if (num.intValue() >= 19) {
                        zzga = new zzgf();
                        zza = zzga;
                        if (num != null) {
                            i = num.intValue();
                        }
                        zzb = i;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    PrintStream printStream = System.err;
                    String name = zza.class.getName();
                    StringBuilder sb = new StringBuilder(String.valueOf(name).length() + Opcodes.I2L);
                    sb.append("An error has occurred when initializing the try-with-resources desuguring strategy. The default strategy ");
                    sb.append(name);
                    sb.append("will be used. The error is: ");
                    printStream.println(sb.toString());
                    th.printStackTrace(System.err);
                    zzga = new zza();
                    zza = zzga;
                    if (num != null) {
                    }
                    zzb = i;
                }
            }
            if (!Boolean.getBoolean("com.google.devtools.build.android.desugar.runtime.twr_disable_mimic")) {
                zzga = new zzge();
            } else {
                zzga = new zza();
            }
        } catch (Throwable th3) {
            th = th3;
            num = null;
            PrintStream printStream2 = System.err;
            String name2 = zza.class.getName();
            StringBuilder sb2 = new StringBuilder(String.valueOf(name2).length() + Opcodes.I2L);
            sb2.append("An error has occurred when initializing the try-with-resources desuguring strategy. The default strategy ");
            sb2.append(name2);
            sb2.append("will be used. The error is: ");
            printStream2.println(sb2.toString());
            th.printStackTrace(System.err);
            zzga = new zza();
            zza = zzga;
            if (num != null) {
            }
            zzb = i;
        }
        zza = zzga;
        if (num != null) {
        }
        zzb = i;
    }
}
