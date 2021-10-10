package com.google.android.gms.internal.gtm;

import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import java.util.ArrayList;
import java.util.List;

public final class zzha {
    public static boolean zza(zzoa<?> zzoa) {
        Preconditions.checkArgument(zzoa != null);
        if (zzoa == zzog.zzaum || zzoa == zzog.zzaul) {
            return false;
        }
        if (zzoa instanceof zzod) {
            return ((Boolean) ((zzod) zzoa).value()).booleanValue();
        }
        if (zzoa instanceof zzoe) {
            zzoe zzoe = (zzoe) zzoa;
            if (((Double) zzoe.value()).doubleValue() == 0.0d || ((Double) zzoe.value()).doubleValue() == -0.0d || Double.isNaN(((Double) zzoe.value()).doubleValue())) {
                return false;
            }
        } else if (zzoa instanceof zzom) {
            if (((String) ((zzom) zzoa).value()).isEmpty()) {
                return false;
            }
        } else if (zzf(zzoa)) {
            String zzoa2 = zzoa.toString();
            StringBuilder sb = new StringBuilder(String.valueOf(zzoa2).length() + 33);
            sb.append("Illegal type given to isTruthy: ");
            sb.append(zzoa2);
            sb.append(".");
            throw new IllegalArgumentException(sb.toString());
        }
        return true;
    }

    public static double zzb(zzoa<?> zzoa) {
        while (true) {
            Preconditions.checkArgument(zzoa != null);
            if (zzoa == zzog.zzaum) {
                return Double.NaN;
            }
            if (zzoa == zzog.zzaul) {
                return 0.0d;
            }
            if (zzoa instanceof zzod) {
                if (((Boolean) ((zzod) zzoa).value()).booleanValue()) {
                    return 1.0d;
                }
                return 0.0d;
            } else if (zzoa instanceof zzoe) {
                return ((Double) ((zzoe) zzoa).value()).doubleValue();
            } else {
                if (zzoa instanceof zzoh) {
                    zzoh zzoh = (zzoh) zzoa;
                    if (!((List) zzoh.value()).isEmpty()) {
                        if (((List) zzoh.value()).size() != 1) {
                            break;
                        }
                        zzoa = new zzom(zzd(zzoh.zzac(0)));
                    } else {
                        return 0.0d;
                    }
                } else if (zzoa instanceof zzom) {
                    zzom zzom = (zzom) zzoa;
                    if (((String) zzom.value()).isEmpty()) {
                        return 0.0d;
                    }
                    try {
                        return Double.parseDouble((String) zzom.value());
                    } catch (NumberFormatException unused) {
                        return Double.NaN;
                    }
                }
            }
        }
        if (!zzf(zzoa)) {
            return Double.NaN;
        }
        String zzoa2 = zzoa.toString();
        StringBuilder sb = new StringBuilder(String.valueOf(zzoa2).length() + 41);
        sb.append("Illegal type given to numberEquivalent: ");
        sb.append(zzoa2);
        sb.append(".");
        throw new IllegalArgumentException(sb.toString());
    }

    public static double zzc(zzoa<?> zzoa) {
        double zzb = zzb(zzoa);
        if (Double.isNaN(zzb)) {
            return 0.0d;
        }
        return (zzb == 0.0d || zzb == -0.0d || Double.isInfinite(zzb)) ? zzb : Math.signum(zzb) * Math.floor(Math.abs(zzb));
    }

    public static String zzd(zzoa<?> zzoa) {
        String str;
        Preconditions.checkArgument(zzoa != null);
        if (zzoa == zzog.zzaum) {
            return "undefined";
        }
        if (zzoa == zzog.zzaul) {
            return "null";
        }
        if (zzoa instanceof zzod) {
            return ((Boolean) ((zzod) zzoa).value()).booleanValue() ? "true" : "false";
        }
        if (zzoa instanceof zzoe) {
            String d = Double.toString(((Double) ((zzoe) zzoa).value()).doubleValue());
            int indexOf = d.indexOf("E");
            if (indexOf > 0) {
                int parseInt = Integer.parseInt(d.substring(indexOf + 1, d.length()));
                if (parseInt < 0) {
                    if (parseInt <= -7) {
                        return d.replace("E", "e");
                    }
                    String replace = d.substring(0, indexOf).replace(".", "");
                    StringBuilder sb = new StringBuilder();
                    sb.append("0.");
                    while (true) {
                        parseInt++;
                        if (parseInt < 0) {
                            sb.append("0");
                        } else {
                            sb.append(replace);
                            return sb.toString();
                        }
                    }
                } else if (parseInt >= 21) {
                    return d.replace("E", "e+");
                } else {
                    String replace2 = d.substring(0, indexOf).replace(".", "");
                    int length = (parseInt + 1) - (replace2.length() - (replace2.startsWith("-") ? 1 : 0));
                    StringBuilder sb2 = new StringBuilder();
                    if (length < 0) {
                        int length2 = replace2.length() + length;
                        sb2.append(replace2.substring(0, length2));
                        sb2.append(".");
                        sb2.append(replace2.substring(length2, replace2.length()));
                    } else {
                        sb2.append(replace2);
                        while (length > 0) {
                            sb2.append("0");
                            length--;
                        }
                    }
                    return sb2.toString();
                }
            } else if (!d.endsWith(".0")) {
                return d;
            } else {
                String substring = d.substring(0, d.length() - 2);
                if (substring.equals("-0")) {
                    return "0";
                }
                return substring;
            }
        } else {
            if (zzoa instanceof zzof) {
                zzgz zzgz = (zzgz) ((zzof) zzoa).value();
                if (zzgz instanceof zzgy) {
                    return ((zzgy) zzgz).getName();
                }
            } else if (zzoa instanceof zzoh) {
                ArrayList arrayList = new ArrayList();
                for (zzoa zzoa2 : (List) ((zzoh) zzoa).value()) {
                    if (zzoa2 == zzog.zzaul || zzoa2 == zzog.zzaum) {
                        arrayList.add("");
                    } else {
                        arrayList.add(zzd(zzoa2));
                    }
                }
                return TextUtils.join(",", arrayList);
            } else if (zzoa instanceof zzok) {
                return "[object Object]";
            } else {
                if (zzoa instanceof zzom) {
                    return (String) ((zzom) zzoa).value();
                }
            }
            if (zzf(zzoa)) {
                String zzoa3 = zzoa.toString();
                StringBuilder sb3 = new StringBuilder(String.valueOf(zzoa3).length() + 41);
                sb3.append("Illegal type given to stringEquivalent: ");
                sb3.append(zzoa3);
                sb3.append(".");
                str = sb3.toString();
            } else {
                str = "Unknown type in stringEquivalent.";
            }
            throw new IllegalArgumentException(str);
        }
    }

    public static double zza(zzoa<?> zzoa, zzoa<?> zzoa2) {
        boolean z = true;
        Preconditions.checkArgument(zzoa != null);
        if (zzoa2 == null) {
            z = false;
        }
        Preconditions.checkArgument(z);
        double zzb = zzb(zzoa);
        double zzb2 = zzb(zzoa2);
        if (Double.isNaN(zzb) || Double.isNaN(zzb2)) {
            return Double.NaN;
        }
        if ((zzb == Double.POSITIVE_INFINITY && zzb2 == Double.NEGATIVE_INFINITY) || (zzb == Double.NEGATIVE_INFINITY && zzb2 == Double.POSITIVE_INFINITY)) {
            return Double.NaN;
        }
        if (!Double.isInfinite(zzb) || Double.isInfinite(zzb2)) {
            return (Double.isInfinite(zzb) || !Double.isInfinite(zzb2)) ? zzb + zzb2 : zzb2;
        }
        return zzb;
    }

    public static boolean zzb(zzoa<?> zzoa, zzoa<?> zzoa2) {
        Preconditions.checkArgument(zzoa != null);
        Preconditions.checkArgument(zzoa2 != null);
        if (zzf(zzoa)) {
            String zzoa3 = zzoa.toString();
            StringBuilder sb = new StringBuilder(String.valueOf(zzoa3).length() + 50);
            sb.append("Illegal type given to abstractRelationalCompare: ");
            sb.append(zzoa3);
            sb.append(".");
            throw new IllegalArgumentException(sb.toString());
        } else if (!zzf(zzoa2)) {
            if ((zzoa instanceof zzok) || (zzoa instanceof zzoh) || (zzoa instanceof zzof)) {
                zzoa = new zzom(zzd(zzoa));
            }
            if ((zzoa2 instanceof zzok) || (zzoa2 instanceof zzoh) || (zzoa2 instanceof zzof)) {
                zzoa2 = new zzom(zzd(zzoa2));
            }
            if ((zzoa instanceof zzom) && (zzoa2 instanceof zzom)) {
                return ((String) ((zzom) zzoa).value()).compareTo((String) ((zzom) zzoa2).value()) < 0;
            }
            double zzb = zzb(zzoa);
            double zzb2 = zzb(zzoa2);
            if (Double.isNaN(zzb) || Double.isNaN(zzb2) || ((zzb == 0.0d && zzb2 == -0.0d) || ((zzb == -0.0d && zzb2 == 0.0d) || zzb == Double.POSITIVE_INFINITY))) {
                return false;
            }
            if (zzb2 == Double.POSITIVE_INFINITY) {
                return true;
            }
            if (zzb2 == Double.NEGATIVE_INFINITY) {
                return false;
            }
            return zzb == Double.NEGATIVE_INFINITY || Double.compare(zzb, zzb2) < 0;
        } else {
            String zzoa4 = zzoa2.toString();
            StringBuilder sb2 = new StringBuilder(String.valueOf(zzoa4).length() + 50);
            sb2.append("Illegal type given to abstractRelationalCompare: ");
            sb2.append(zzoa4);
            sb2.append(".");
            throw new IllegalArgumentException(sb2.toString());
        }
    }

    private static String zze(zzoa<?> zzoa) {
        if (zzoa == zzog.zzaum) {
            return "Undefined";
        }
        if (zzoa == zzog.zzaul) {
            return "Null";
        }
        if (zzoa instanceof zzod) {
            return "Boolean";
        }
        if (zzoa instanceof zzoe) {
            return "Number";
        }
        return zzoa instanceof zzom ? "String" : "Object";
    }

    public static boolean zzc(zzoa<?> zzoa, zzoa<?> zzoa2) {
        zzoa<?> zzoa3;
        zzoa<?> zzom;
        while (true) {
            Preconditions.checkArgument(zzoa != null);
            Preconditions.checkArgument(zzoa2 != null);
            if (zzf(zzoa)) {
                String zzoa4 = zzoa.toString();
                StringBuilder sb = new StringBuilder(String.valueOf(zzoa4).length() + 48);
                sb.append("Illegal type given to abstractEqualityCompare: ");
                sb.append(zzoa4);
                sb.append(".");
                throw new IllegalArgumentException(sb.toString());
            } else if (!zzf(zzoa2)) {
                String zze = zze(zzoa);
                String zze2 = zze(zzoa2);
                if (zze.equals(zze2)) {
                    zze.hashCode();
                    char c = 65535;
                    switch (zze.hashCode()) {
                        case -1950496919:
                            if (zze.equals("Number")) {
                                c = 0;
                                break;
                            }
                            break;
                        case -1939501217:
                            if (zze.equals("Object")) {
                                c = 1;
                                break;
                            }
                            break;
                        case -1808118735:
                            if (zze.equals("String")) {
                                c = 2;
                                break;
                            }
                            break;
                        case 2439591:
                            if (zze.equals("Null")) {
                                c = 3;
                                break;
                            }
                            break;
                        case 965837104:
                            if (zze.equals("Undefined")) {
                                c = 4;
                                break;
                            }
                            break;
                        case 1729365000:
                            if (zze.equals("Boolean")) {
                                c = 5;
                                break;
                            }
                            break;
                    }
                    switch (c) {
                        case 0:
                            double doubleValue = ((Double) ((zzoe) zzoa).value()).doubleValue();
                            double doubleValue2 = ((Double) ((zzoe) zzoa2).value()).doubleValue();
                            return !Double.isNaN(doubleValue) && !Double.isNaN(doubleValue2) && doubleValue == doubleValue2;
                        case 1:
                            return zzoa == zzoa2;
                        case 2:
                            return ((String) ((zzom) zzoa).value()).equals((String) ((zzom) zzoa2).value());
                        case 3:
                        case 4:
                            return true;
                        case 5:
                            return ((Boolean) ((zzod) zzoa).value()) == ((Boolean) ((zzod) zzoa2).value());
                        default:
                            return false;
                    }
                } else if ((zzoa == zzog.zzaum || zzoa == zzog.zzaul) && (zzoa2 == zzog.zzaum || zzoa2 == zzog.zzaul)) {
                    return true;
                } else {
                    if (!zze.equals("Number") || !zze2.equals("String")) {
                        if (zze.equals("String") && zze2.equals("Number")) {
                            zzoa3 = new zzoe(Double.valueOf(zzb(zzoa)));
                        } else if (zze.equals("Boolean")) {
                            zzoa3 = new zzoe(Double.valueOf(zzb(zzoa)));
                        } else if (zze2.equals("Boolean")) {
                            zzom = new zzoe(Double.valueOf(zzb(zzoa2)));
                        } else if ((zze.equals("String") || zze.equals("Number")) && zze2.equals("Object")) {
                            zzom = new zzom(zzd(zzoa2));
                        } else if (!zze.equals("Object") || (!zze2.equals("String") && !zze2.equals("Number"))) {
                            return false;
                        } else {
                            zzoa3 = new zzom(zzd(zzoa));
                        }
                        zzoa = zzoa3;
                    } else {
                        zzom = new zzoe(Double.valueOf(zzb(zzoa2)));
                    }
                    zzoa2 = zzom;
                }
            } else {
                String zzoa5 = zzoa2.toString();
                StringBuilder sb2 = new StringBuilder(String.valueOf(zzoa5).length() + 48);
                sb2.append("Illegal type given to abstractEqualityCompare: ");
                sb2.append(zzoa5);
                sb2.append(".");
                throw new IllegalArgumentException(sb2.toString());
            }
        }
        return false;
    }

    public static boolean zzd(zzoa<?> zzoa, zzoa<?> zzoa2) {
        Preconditions.checkArgument(zzoa != null);
        Preconditions.checkArgument(zzoa2 != null);
        if (zzf(zzoa)) {
            String zzoa3 = zzoa.toString();
            StringBuilder sb = new StringBuilder(String.valueOf(zzoa3).length() + 46);
            sb.append("Illegal type given to strictEqualityCompare: ");
            sb.append(zzoa3);
            sb.append(".");
            throw new IllegalArgumentException(sb.toString());
        } else if (!zzf(zzoa2)) {
            String zze = zze(zzoa);
            if (!zze.equals(zze(zzoa2))) {
                return false;
            }
            zze.hashCode();
            char c = 65535;
            switch (zze.hashCode()) {
                case -1950496919:
                    if (zze.equals("Number")) {
                        c = 0;
                        break;
                    }
                    break;
                case -1808118735:
                    if (zze.equals("String")) {
                        c = 1;
                        break;
                    }
                    break;
                case 2439591:
                    if (zze.equals("Null")) {
                        c = 2;
                        break;
                    }
                    break;
                case 965837104:
                    if (zze.equals("Undefined")) {
                        c = 3;
                        break;
                    }
                    break;
                case 1729365000:
                    if (zze.equals("Boolean")) {
                        c = 4;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    double doubleValue = ((Double) ((zzoe) zzoa).value()).doubleValue();
                    double doubleValue2 = ((Double) ((zzoe) zzoa2).value()).doubleValue();
                    return !Double.isNaN(doubleValue) && !Double.isNaN(doubleValue2) && doubleValue == doubleValue2;
                case 1:
                    return ((String) ((zzom) zzoa).value()).equals((String) ((zzom) zzoa2).value());
                case 2:
                case 3:
                    return true;
                case 4:
                    return ((Boolean) ((zzod) zzoa).value()) == ((Boolean) ((zzod) zzoa2).value());
                default:
                    return zzoa == zzoa2;
            }
        } else {
            String zzoa4 = zzoa2.toString();
            StringBuilder sb2 = new StringBuilder(String.valueOf(zzoa4).length() + 46);
            sb2.append("Illegal type given to strictEqualityCompare: ");
            sb2.append(zzoa4);
            sb2.append(".");
            throw new IllegalArgumentException(sb2.toString());
        }
    }

    private static boolean zzf(zzoa<?> zzoa) {
        if (!(zzoa instanceof zzol)) {
            return (!(zzoa instanceof zzog) || zzoa == zzog.zzaum || zzoa == zzog.zzaul) ? false : true;
        }
        return true;
    }
}
