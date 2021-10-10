package com.google.android.gms.tagmanager;

import java.util.Map;

/* access modifiers changed from: package-private */
public final class zzbj extends zzce {
    zzbj() {
    }

    @Override // com.google.android.gms.tagmanager.zzcd
    public final void zzb(String str, Map map) {
        CustomTagProvider customTagProvider;
        if (!zzbf.zzagn.containsKey(str)) {
            customTagProvider = (CustomTagProvider) zzbf.zza(str, CustomTagProvider.class);
            zzbf.zzagn.put(str, customTagProvider);
        } else {
            customTagProvider = (CustomTagProvider) zzbf.zzagn.get(str);
        }
        if (customTagProvider != null) {
            customTagProvider.execute(map);
        }
    }

    @Override // com.google.android.gms.tagmanager.zzcd
    public final String zzc(String str, Map map) {
        CustomVariableProvider customVariableProvider;
        if (!zzbf.zzago.containsKey(str)) {
            customVariableProvider = (CustomVariableProvider) zzbf.zza(str, CustomVariableProvider.class);
            zzbf.zzago.put(str, customVariableProvider);
        } else {
            customVariableProvider = (CustomVariableProvider) zzbf.zzago.get(str);
        }
        if (customVariableProvider != null) {
            return customVariableProvider.getValue(map);
        }
        return null;
    }
}
