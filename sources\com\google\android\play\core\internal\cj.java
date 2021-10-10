package com.google.android.play.core.internal;

import java.io.PrintStream;
import org.objectweb.asm.Opcodes;

public final class cj {
    static final cd a;

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0080 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0081  */
    static {
        cd cdVar;
        Integer num = null;
        try {
            num = (Integer) Class.forName("android.os.Build$VERSION").getField("SDK_INT").get(null);
        } catch (Exception e) {
            System.err.println("Failed to retrieve value from android.os.Build$VERSION.SDK_INT due to the following exception.");
            e.printStackTrace(System.err);
        } catch (Throwable th) {
            PrintStream printStream = System.err;
            String name = ch.class.getName();
            StringBuilder sb = new StringBuilder(String.valueOf(name).length() + Opcodes.I2L);
            sb.append("An error has occurred when initializing the try-with-resources desuguring strategy. The default strategy ");
            sb.append(name);
            sb.append("will be used. The error is: ");
            printStream.println(sb.toString());
            th.printStackTrace(System.err);
            cdVar = new ch();
        }
        if (num == null || num.intValue() < 19) {
            cdVar = !Boolean.getBoolean("com.google.devtools.build.android.desugar.runtime.twr_disable_mimic") ? new cg() : new ch();
            a = cdVar;
            if (num == null) {
                num.intValue();
                return;
            }
            return;
        }
        cdVar = new ci();
        a = cdVar;
        if (num == null) {
        }
    }

    public static void a(Throwable th, Throwable th2) {
        a.a(th, th2);
    }
}
