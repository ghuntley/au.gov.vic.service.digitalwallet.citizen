package com.google.android.gms.internal.gtm;

import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public final class zzoo {
    public static zzoa<?> zzq(Object obj) {
        if (obj == null) {
            return zzog.zzaul;
        }
        if (obj instanceof zzoa) {
            return (zzoa) obj;
        }
        if (obj instanceof Boolean) {
            return new zzod((Boolean) obj);
        }
        if (obj instanceof Short) {
            return new zzoe(Double.valueOf(((Short) obj).doubleValue()));
        }
        if (obj instanceof Integer) {
            return new zzoe(Double.valueOf(((Integer) obj).doubleValue()));
        }
        if (obj instanceof Long) {
            return new zzoe(Double.valueOf(((Long) obj).doubleValue()));
        }
        if (obj instanceof Float) {
            return new zzoe(Double.valueOf(((Float) obj).doubleValue()));
        }
        if (obj instanceof Double) {
            return new zzoe((Double) obj);
        }
        if (obj instanceof Byte) {
            return new zzom(obj.toString());
        }
        if (obj instanceof Character) {
            return new zzom(obj.toString());
        }
        if (obj instanceof String) {
            return new zzom((String) obj);
        }
        if (obj instanceof List) {
            ArrayList arrayList = new ArrayList();
            for (Object obj2 : (List) obj) {
                arrayList.add(zzq(obj2));
            }
            return new zzoh(arrayList);
        } else if (obj instanceof Map) {
            HashMap hashMap = new HashMap();
            for (Map.Entry entry : ((Map) obj).entrySet()) {
                Preconditions.checkArgument(entry.getKey() instanceof String);
                hashMap.put((String) entry.getKey(), zzq(entry.getValue()));
            }
            return new zzok(hashMap);
        } else if (obj instanceof Bundle) {
            HashMap hashMap2 = new HashMap();
            Bundle bundle = (Bundle) obj;
            for (String str : bundle.keySet()) {
                hashMap2.put(str, zzq(bundle.get(str)));
            }
            return new zzok(hashMap2);
        } else {
            String valueOf = String.valueOf(obj.getClass());
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 20);
            sb.append("Type not supported: ");
            sb.append(valueOf);
            throw new UnsupportedOperationException(sb.toString());
        }
    }

    public static Object zzj(zzoa<?> zzoa) {
        if (zzoa == null || zzoa == zzog.zzaul) {
            return null;
        }
        if (zzoa instanceof zzod) {
            return (Boolean) ((zzod) zzoa).value();
        }
        if (zzoa instanceof zzoe) {
            zzoe zzoe = (zzoe) zzoa;
            double doubleValue = ((Double) zzoe.value()).doubleValue();
            if (Double.isInfinite(doubleValue) || doubleValue - Math.floor(doubleValue) >= 1.0E-5d) {
                return ((Double) zzoe.value()).toString();
            }
            return Integer.valueOf((int) doubleValue);
        } else if (zzoa instanceof zzom) {
            return (String) ((zzom) zzoa).value();
        } else {
            if (zzoa instanceof zzoh) {
                ArrayList arrayList = new ArrayList();
                for (zzoa zzoa2 : (List) ((zzoh) zzoa).value()) {
                    Object zzj = zzj(zzoa2);
                    if (zzj == null) {
                        zzev.zzav(String.format("Failure to convert a list element to object: %s (%s)", zzoa2, zzoa2.getClass().getCanonicalName()));
                        return null;
                    }
                    arrayList.add(zzj);
                }
                return arrayList;
            } else if (zzoa instanceof zzok) {
                HashMap hashMap = new HashMap();
                for (Map.Entry entry : ((Map) ((zzok) zzoa).value()).entrySet()) {
                    Object zzj2 = zzj((zzoa) entry.getValue());
                    if (zzj2 == null) {
                        zzev.zzav(String.format("Failure to convert a map's value to object: %s (%s)", entry.getValue(), ((zzoa) entry.getValue()).getClass().getCanonicalName()));
                        return null;
                    }
                    hashMap.put((String) entry.getKey(), zzj2);
                }
                return hashMap;
            } else {
                String valueOf = String.valueOf(zzoa.getClass());
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 49);
                sb.append("Converting to Object from unknown abstract type: ");
                sb.append(valueOf);
                zzev.zzav(sb.toString());
                return null;
            }
        }
    }

    public static Bundle zzk(Map<String, zzoa<?>> map) {
        if (map == null) {
            return null;
        }
        Bundle bundle = new Bundle(map.size());
        for (Map.Entry<String, zzoa<?>> entry : map.entrySet()) {
            if (entry.getValue() instanceof zzom) {
                bundle.putString(entry.getKey(), (String) ((zzom) entry.getValue()).value());
            } else if (entry.getValue() instanceof zzod) {
                bundle.putBoolean(entry.getKey(), ((Boolean) ((zzod) entry.getValue()).value()).booleanValue());
            } else if (entry.getValue() instanceof zzoe) {
                bundle.putDouble(entry.getKey(), ((Double) ((zzoe) entry.getValue()).value()).doubleValue());
            } else if (entry.getValue() instanceof zzok) {
                bundle.putBundle(entry.getKey(), zzk((Map) ((zzok) entry.getValue()).value()));
            } else {
                throw new IllegalArgumentException(String.format("Invalid param type for key '%s'. Only boolean, double and string types and maps of thereof are supported.", entry.getKey()));
            }
        }
        return bundle;
    }

    public static Map<String, Object> zza(Bundle bundle) {
        HashMap hashMap = new HashMap();
        for (String str : bundle.keySet()) {
            Object obj = bundle.get(str);
            if (obj instanceof Bundle) {
                hashMap.put(str, zza((Bundle) obj));
            } else if (obj instanceof List) {
                hashMap.put(str, zzf((List) obj));
            } else {
                hashMap.put(str, obj);
            }
        }
        return hashMap;
    }

    private static List<Object> zzf(List<Object> list) {
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (obj instanceof Bundle) {
                arrayList.add(zza((Bundle) obj));
            } else if (obj instanceof List) {
                arrayList.add(zzf((List) obj));
            } else {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    public static zzoa zzk(zzoa<?> zzoa) {
        if (!(zzoa instanceof zzok)) {
            return zzoa;
        }
        HashSet<String> hashSet = new HashSet();
        Map map = (Map) ((zzok) zzoa).value();
        for (Map.Entry entry : map.entrySet()) {
            if (entry.getValue() == zzog.zzaum) {
                hashSet.add((String) entry.getKey());
            }
        }
        for (String str : hashSet) {
            map.remove(str);
        }
        return zzoa;
    }

    public static zzoa zza(zzfl zzfl, zzoa zzoa) {
        Preconditions.checkNotNull(zzoa);
        if (!zzl(zzoa) && !(zzoa instanceof zzof) && !(zzoa instanceof zzoh) && !(zzoa instanceof zzok)) {
            if (zzoa instanceof zzol) {
                zzoa = zza(zzfl, (zzol) zzoa);
            } else {
                throw new UnsupportedOperationException("Attempting to evaluate unknown type");
            }
        }
        if (zzoa == null) {
            throw new IllegalArgumentException("AbstractType evaluated to Java null");
        } else if (!(zzoa instanceof zzol)) {
            return zzoa;
        } else {
            throw new IllegalArgumentException("AbstractType evaluated to illegal type Statement.");
        }
    }

    public static zzog zza(zzfl zzfl, List<zzoa<?>> list) {
        for (zzoa<?> zzoa : list) {
            Preconditions.checkArgument(zzoa instanceof zzol);
            zzoa zza = zza(zzfl, zzoa);
            if (zzm(zza)) {
                return (zzog) zza;
            }
        }
        return zzog.zzaum;
    }

    public static boolean zzl(zzoa zzoa) {
        if ((zzoa instanceof zzod) || (zzoa instanceof zzoe) || (zzoa instanceof zzom) || zzoa == zzog.zzaul || zzoa == zzog.zzaum) {
            return true;
        }
        return false;
    }

    public static boolean zzm(zzoa zzoa) {
        if (zzoa == zzog.zzauk || zzoa == zzog.zzauj) {
            return true;
        }
        return (zzoa instanceof zzog) && ((zzog) zzoa).zzmh();
    }

    public static zzoa zza(zzfl zzfl, zzol zzol) {
        String zzmj = zzol.zzmj();
        List<zzoa<?>> zzmk = zzol.zzmk();
        zzoa<?> zzca = zzfl.zzca(zzmj);
        if (zzca == null) {
            StringBuilder sb = new StringBuilder(String.valueOf(zzmj).length() + 28);
            sb.append("Function '");
            sb.append(zzmj);
            sb.append("' is not supported");
            throw new UnsupportedOperationException(sb.toString());
        } else if (zzca instanceof zzof) {
            return ((zzgz) ((zzof) zzca).value()).zzb(zzfl, (zzoa[]) zzmk.toArray(new zzoa[zzmk.size()]));
        } else {
            StringBuilder sb2 = new StringBuilder(String.valueOf(zzmj).length() + 29);
            sb2.append("Function '");
            sb2.append(zzmj);
            sb2.append("' is not a function");
            throw new UnsupportedOperationException(sb2.toString());
        }
    }
}
