package com.google.android.gms.internal.instantapps;

/* access modifiers changed from: package-private */
public final class zzfi {
    static String zzd(zzbp zzbp) {
        zzfl zzfl = new zzfl(zzbp);
        StringBuilder sb = new StringBuilder(zzfl.size());
        for (int i = 0; i < zzfl.size(); i++) {
            byte zzj = zzfl.zzj(i);
            if (zzj == 34) {
                sb.append("\\\"");
            } else if (zzj == 39) {
                sb.append("\\'");
            } else if (zzj != 92) {
                switch (zzj) {
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
                        if (zzj < 32 || zzj > 126) {
                            sb.append('\\');
                            sb.append((char) (((zzj >>> 6) & 3) + 48));
                            sb.append((char) (((zzj >>> 3) & 7) + 48));
                            sb.append((char) ((zzj & 7) + 48));
                            break;
                        } else {
                            sb.append((char) zzj);
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
