package com.google.android.gms.internal.gtm;

import java.io.PrintStream;
import org.objectweb.asm.Opcodes;

public final class zzpf {
    private static final zzpg zzavi;
    private static final int zzavj;

    static final class zza extends zzpg {
        zza() {
        }

        @Override // com.google.android.gms.internal.gtm.zzpg
        public final void zza(Throwable th, PrintStream printStream) {
            th.printStackTrace(printStream);
        }
    }

    public static void zza(Throwable th, PrintStream printStream) {
        zzavi.zza(th, printStream);
    }

    private static Integer zzmu() {
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
        zzpg zzpg;
        Integer num;
        Throwable th;
        int i = 1;
        try {
            num = zzmu();
            if (num != null) {
                try {
                    if (num.intValue() >= 19) {
                        zzpg = new zzpk();
                        zzavi = zzpg;
                        if (num != null) {
                            i = num.intValue();
                        }
                        zzavj = i;
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
                    zzpg = new zza();
                    zzavi = zzpg;
                    if (num != null) {
                    }
                    zzavj = i;
                }
            }
            if (!Boolean.getBoolean("com.google.devtools.build.android.desugar.runtime.twr_disable_mimic")) {
                zzpg = new zzpj();
            } else {
                zzpg = new zza();
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
            zzpg = new zza();
            zzavi = zzpg;
            if (num != null) {
            }
            zzavj = i;
        }
        zzavi = zzpg;
        if (num != null) {
        }
        zzavj = i;
    }
}
