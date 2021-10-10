package com.google.android.gms.internal.gtm;

import com.google.android.gms.analytics.ecommerce.Product;
import com.google.android.gms.analytics.ecommerce.ProductAction;
import com.google.android.gms.analytics.ecommerce.Promotion;
import com.google.android.gms.analytics.zzi;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class zzw extends zzi<zzw> {
    private ProductAction zzrx;
    private final Map<String, List<Product>> zzry = new HashMap();
    private final List<Promotion> zzrz = new ArrayList();
    private final List<Product> zzsa = new ArrayList();

    public final ProductAction zzbn() {
        return this.zzrx;
    }

    public final String toString() {
        HashMap hashMap = new HashMap();
        if (!this.zzsa.isEmpty()) {
            hashMap.put("products", this.zzsa);
        }
        if (!this.zzrz.isEmpty()) {
            hashMap.put("promotions", this.zzrz);
        }
        if (!this.zzry.isEmpty()) {
            hashMap.put("impressions", this.zzry);
        }
        hashMap.put("productAction", this.zzrx);
        return zza((Object) hashMap);
    }

    public final List<Product> zzbo() {
        return Collections.unmodifiableList(this.zzsa);
    }

    public final Map<String, List<Product>> zzbp() {
        return this.zzry;
    }

    public final List<Promotion> zzbq() {
        return Collections.unmodifiableList(this.zzrz);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.google.android.gms.analytics.zzi] */
    @Override // com.google.android.gms.analytics.zzi
    public final /* synthetic */ void zzb(zzw zzw) {
        zzw zzw2 = zzw;
        zzw2.zzsa.addAll(this.zzsa);
        zzw2.zzrz.addAll(this.zzrz);
        for (Map.Entry<String, List<Product>> entry : this.zzry.entrySet()) {
            String key = entry.getKey();
            for (Product product : entry.getValue()) {
                if (product != null) {
                    String str = key == null ? "" : key;
                    if (!zzw2.zzry.containsKey(str)) {
                        zzw2.zzry.put(str, new ArrayList());
                    }
                    zzw2.zzry.get(str).add(product);
                }
            }
        }
        ProductAction productAction = this.zzrx;
        if (productAction != null) {
            zzw2.zzrx = productAction;
        }
    }
}
