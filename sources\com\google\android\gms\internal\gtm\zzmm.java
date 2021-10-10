package com.google.android.gms.internal.gtm;

import com.digitalwallet.app.model.P2PHeader;
import com.google.android.gms.analytics.ecommerce.ProductAction;
import com.google.android.gms.common.internal.Preconditions;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class zzmm {
    static zznm zzcd(String str) throws JSONException, zzml {
        Object obj = new JSONObject(str).get("resource");
        if (obj instanceof JSONObject) {
            JSONObject jSONObject = (JSONObject) obj;
            zznn zznn = new zznn();
            zznn.zzcl(jSONObject.optString(P2PHeader.versionKey));
            JSONArray jSONArray = jSONObject.getJSONArray("macros");
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < jSONArray.length(); i++) {
                arrayList.add(jSONArray.getJSONObject(i).getString("instance_name"));
            }
            List<zzno> zza = zza(jSONObject.getJSONArray("tags"), (List<String>) arrayList);
            List<zzno> zza2 = zza(jSONObject.getJSONArray("predicates"), (List<String>) arrayList);
            for (zzno zzno : zza(jSONObject.getJSONArray("macros"), (List<String>) arrayList)) {
                zznn.zzb(zzno);
            }
            JSONArray jSONArray2 = jSONObject.getJSONArray("rules");
            for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                JSONArray jSONArray3 = jSONArray2.getJSONArray(i2);
                zznt zznt = new zznt();
                for (int i3 = 0; i3 < jSONArray3.length(); i3++) {
                    JSONArray jSONArray4 = jSONArray3.getJSONArray(i3);
                    int i4 = 1;
                    if (jSONArray4.getString(0).equals("if")) {
                        while (i4 < jSONArray4.length()) {
                            zznt.zzc(zza2.get(jSONArray4.getInt(i4)));
                            i4++;
                        }
                    } else if (jSONArray4.getString(0).equals("unless")) {
                        while (i4 < jSONArray4.length()) {
                            zznt.zzd(zza2.get(jSONArray4.getInt(i4)));
                            i4++;
                        }
                    } else if (jSONArray4.getString(0).equals(ProductAction.ACTION_ADD)) {
                        while (i4 < jSONArray4.length()) {
                            zznt.zze(zza.get(jSONArray4.getInt(i4)));
                            i4++;
                        }
                    } else if (jSONArray4.getString(0).equals("block")) {
                        while (i4 < jSONArray4.length()) {
                            zznt.zzf(zza.get(jSONArray4.getInt(i4)));
                            i4++;
                        }
                    } else {
                        String valueOf = String.valueOf(jSONArray4.getString(0));
                        zzcf(valueOf.length() != 0 ? "Unknown Rule property: ".concat(valueOf) : new String("Unknown Rule property: "));
                    }
                }
                zznn.zza(zznt.zzma());
            }
            return zznn.zzlt();
        }
        throw new zzml("Resource map not found");
    }

    private static List<zzno> zza(JSONArray jSONArray, List<String> list) throws JSONException, zzml {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObject = jSONArray.getJSONObject(i);
            zznq zznq = new zznq();
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                zznx zzme = zza(jSONObject.get(next), list).zzme();
                if ("push_after_evaluate".equals(next)) {
                    zznq.zzb(zzme);
                } else {
                    zznq.zza(next, zzme);
                }
            }
            arrayList.add(zznq.zzlv());
        }
        return arrayList;
    }

    private static zznz zza(Object obj, List<String> list) throws zzml, JSONException {
        zznz zznz;
        if (obj instanceof JSONArray) {
            JSONArray jSONArray = (JSONArray) obj;
            String string = jSONArray.getString(0);
            if (string.equals("escape")) {
                zznz zza = zza(jSONArray.get(1), list);
                for (int i = 2; i < jSONArray.length(); i++) {
                    zza.zzab(jSONArray.getInt(i));
                }
                return zza;
            } else if (string.equals("list")) {
                ArrayList arrayList = new ArrayList();
                for (int i2 = 1; i2 < jSONArray.length(); i2++) {
                    arrayList.add(zza(jSONArray.get(i2), list).zzme());
                }
                zznz = new zznz(2, arrayList);
                zznz.zzh(true);
            } else if (string.equals("map")) {
                HashMap hashMap = new HashMap();
                for (int i3 = 1; i3 < jSONArray.length(); i3 += 2) {
                    hashMap.put(zza(jSONArray.get(i3), list).zzme(), zza(jSONArray.get(i3 + 1), list).zzme());
                }
                zznz = new zznz(3, hashMap);
                zznz.zzh(true);
            } else if (string.equals("macro")) {
                zznz zznz2 = new zznz(4, list.get(jSONArray.getInt(1)));
                zznz2.zzh(true);
                return zznz2;
            } else if (string.equals("template")) {
                ArrayList arrayList2 = new ArrayList();
                for (int i4 = 1; i4 < jSONArray.length(); i4++) {
                    arrayList2.add(zza(jSONArray.get(i4), list).zzme());
                }
                zznz = new zznz(7, arrayList2);
                zznz.zzh(true);
            } else {
                String valueOf = String.valueOf(obj);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 20);
                sb.append("Invalid value type: ");
                sb.append(valueOf);
                zzcf(sb.toString());
                return null;
            }
        } else if (obj instanceof Boolean) {
            zznz = new zznz(8, obj);
        } else if (obj instanceof Integer) {
            zznz = new zznz(6, obj);
        } else if (obj instanceof String) {
            zznz = new zznz(1, obj);
        } else {
            String valueOf2 = String.valueOf(obj);
            StringBuilder sb2 = new StringBuilder(String.valueOf(valueOf2).length() + 20);
            sb2.append("Invalid value type: ");
            sb2.append(valueOf2);
            zzcf(sb2.toString());
            return null;
        }
        return zznz;
    }

    static zznu zzce(String str) throws JSONException, zzml {
        JSONObject jSONObject = new JSONObject(str);
        JSONArray optJSONArray = jSONObject.optJSONArray("runtime");
        if (optJSONArray == null) {
            return null;
        }
        zznw zznw = new zznw();
        Object obj = jSONObject.get("resource");
        if (obj instanceof JSONObject) {
            zznw.zzcm(((JSONObject) obj).optString(P2PHeader.versionKey));
            for (int i = 0; i < optJSONArray.length(); i++) {
                Object obj2 = optJSONArray.get(i);
                if (!(obj2 instanceof JSONArray) || ((JSONArray) obj2).length() != 0) {
                    zznw.zza(zzo(obj2));
                }
            }
            return zznw.zzmc();
        }
        throw new zzml("Resource map not found");
    }

    public static zzgy zzo(Object obj) throws JSONException {
        JSONArray jSONArray;
        JSONArray jSONArray2;
        String str;
        if (obj instanceof JSONObject) {
            JSONObject jSONObject = (JSONObject) obj;
            str = jSONObject.getString("name");
            jSONArray2 = jSONObject.getJSONArray("params");
            jSONArray = jSONObject.getJSONArray("instructions");
        } else if (obj instanceof JSONArray) {
            JSONArray jSONArray3 = (JSONArray) obj;
            Preconditions.checkArgument(jSONArray3.length() >= 3);
            str = jSONArray3.getString(1);
            JSONArray jSONArray4 = jSONArray3.getJSONArray(2);
            JSONArray jSONArray5 = new JSONArray();
            for (int i = 1; i < jSONArray4.length(); i++) {
                Preconditions.checkArgument(jSONArray4.get(i) instanceof String);
                jSONArray5.put(jSONArray4.get(i));
            }
            JSONArray jSONArray6 = new JSONArray();
            for (int i2 = 3; i2 < jSONArray3.length(); i2++) {
                jSONArray6.put(jSONArray3.get(i2));
            }
            jSONArray = jSONArray6;
            jSONArray2 = jSONArray5;
        } else {
            throw new IllegalArgumentException("invalid JSON in runtime section");
        }
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < jSONArray2.length(); i3++) {
            arrayList.add(jSONArray2.getString(i3));
        }
        ArrayList arrayList2 = new ArrayList();
        for (int i4 = 0; i4 < jSONArray.length(); i4++) {
            JSONArray jSONArray7 = jSONArray.getJSONArray(i4);
            if (jSONArray7.length() != 0) {
                arrayList2.add(zza(jSONArray7));
            }
        }
        return new zzgy(null, str, arrayList, arrayList2);
    }

    private static zzol zza(JSONArray jSONArray) throws JSONException {
        Preconditions.checkArgument(jSONArray.length() > 0);
        String string = jSONArray.getString(0);
        ArrayList arrayList = new ArrayList();
        for (int i = 1; i < jSONArray.length(); i++) {
            Object obj = jSONArray.get(i);
            if (obj instanceof JSONArray) {
                JSONArray jSONArray2 = (JSONArray) obj;
                if (jSONArray2.length() != 0) {
                    arrayList.add(zza(jSONArray2));
                }
            } else if (obj == JSONObject.NULL) {
                arrayList.add(zzog.zzaul);
            } else {
                arrayList.add(zzoo.zzq(obj));
            }
        }
        return new zzol(string, arrayList);
    }

    private static void zzcf(String str) throws zzml {
        zzev.zzav(str);
        throw new zzml(str);
    }
}
