package com.google.android.gms.internal.gtm;

/* access modifiers changed from: package-private */
public final class zztn {
    static String zzd(zzps zzps) {
        zzto zzto = new zzto(zzps);
        StringBuilder sb = new StringBuilder(zzto.size());
        for (int i = 0; i < zzto.size(); i++) {
            byte zzak = zzto.zzak(i);
            if (zzak == 34) {
                sb.append("\\\"");
            } else if (zzak == 39) {
                sb.append("\\'");
            } else if (zzak != 92) {
                switch (zzak) {
                    case 7:
                        sb.append("\\a");
                        continue;
                    case 8:
                        sb.append("\\b");
                        continue;
                    case 9:
                        sb.append("\\t");
                        continue;
                    case 10:
                        sb.append("\\n");
                        continue;
                    case 11:
                        sb.append("\\v");
                        continue;
                    case 12:
                        sb.append("\\f");
                        continue;
                    case 13:
                        sb.append("\\r");
                        continue;
                    default:
                        if (zzak < 32 || zzak > 126) {
                            sb.append('\\');
                            sb.append((char) (((zzak >>> 6) & 3) + 48));
                            sb.append((char) (((zzak >>> 3) & 7) + 48));
                            sb.append((char) ((zzak & 7) + 48));
                            break;
                        } else {
                            sb.append((char) zzak);
                            continue;
                        }
                }
            } else {
                sb.append("\\\\");
            }
        }
        return sb.toString();
    }
}
