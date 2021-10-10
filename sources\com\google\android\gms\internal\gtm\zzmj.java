package com.google.android.gms.internal.gtm;

import android.content.Context;
import com.google.android.gms.analytics.HitBuilders;
import com.google.android.gms.analytics.Tracker;
import com.google.android.gms.analytics.ecommerce.Product;
import com.google.android.gms.analytics.ecommerce.ProductAction;
import com.google.android.gms.analytics.ecommerce.Promotion;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.CollectionUtils;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class zzmj extends zzhb {
    private static final String ID = zza.UNIVERSAL_ANALYTICS.toString();
    private static final List<String> zzamg = Arrays.asList(ProductAction.ACTION_DETAIL, ProductAction.ACTION_CHECKOUT, "checkout_option", "click", ProductAction.ACTION_ADD, ProductAction.ACTION_REMOVE, "purchase", "refund");
    private static final Pattern zzamh = Pattern.compile("dimension(\\d+)");
    private static final Pattern zzami = Pattern.compile("metric(\\d+)");
    private static final Set<String> zzasb = CollectionUtils.setOf("", "0", "false");
    private static final Map<String, String> zzasc = CollectionUtils.mapOf("transactionId", "&ti", "transactionAffiliation", "&ta", "transactionTax", "&tt", "transactionShipping", "&ts", "transactionTotal", "&tr", "transactionCurrency", "&cu");
    private static final Map<String, String> zzasd = CollectionUtils.mapOf("name", "&in", "sku", "&ic", "category", "&iv", FirebaseAnalytics.Param.PRICE, "&ip", FirebaseAnalytics.Param.QUANTITY, "&iq", FirebaseAnalytics.Param.CURRENCY, "&cu");
    private final zzfj zzapc;
    private final zzgu zzase;
    private Map<String, Object> zzasf;

    public zzmj(Context context, zzfj zzfj) {
        this(new zzgu(context), zzfj);
    }

    private zzmj(zzgu zzgu, zzfj zzfj) {
        this.zzapc = zzfj;
        this.zzase = zzgu;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:126:0x0221  */
    /* JADX WARNING: Removed duplicated region for block: B:184:0x0353  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00a9 A[Catch:{ all -> 0x048b }] */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00b8 A[Catch:{ all -> 0x048b }] */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x00da  */
    @Override // com.google.android.gms.internal.gtm.zzhb
    public final zzoa<?> zza(zzfl zzfl, zzoa<?>... zzoaArr) {
        boolean z;
        boolean z2;
        boolean z3;
        Map<String, String> map;
        List<Object> list;
        Map<String, String> map2;
        Object obj;
        List<Map> list2;
        boolean z4;
        ProductAction productAction;
        Preconditions.checkArgument(true);
        Preconditions.checkArgument(zzoaArr.length > 0);
        try {
            this.zzasf = zzoo.zza(this.zzapc.zzkt().zzkg());
            zzoa<?> zzoa = zzoaArr[0];
            zzoa<?> zzod = zzoaArr.length > 1 ? zzoaArr[1] : new zzod(true);
            zzoa<?> zzod2 = zzoaArr.length > 2 ? zzoaArr[2] : new zzod(false);
            zzog zzog = zzoaArr.length > 3 ? zzoaArr[3] : zzog.zzaum;
            zzog zzog2 = zzoaArr.length > 4 ? zzoaArr[4] : zzog.zzaum;
            zzoa<?> zzod3 = zzoaArr.length > 5 ? zzoaArr[5] : new zzod(false);
            zzoa<?> zzod4 = zzoaArr.length > 6 ? zzoaArr[6] : new zzod(false);
            zzog zzog3 = zzoaArr.length > 7 ? zzoaArr[7] : zzog.zzaum;
            zzoa<?> zzod5 = zzoaArr.length > 8 ? zzoaArr[8] : new zzod(false);
            Preconditions.checkArgument(zzoa instanceof zzok);
            if (zzog != zzog.zzaum) {
                if (!(zzog instanceof zzok)) {
                    z = false;
                    Preconditions.checkArgument(z);
                    if (zzog2 != zzog.zzaum) {
                        if (!(zzog2 instanceof zzok)) {
                            z2 = false;
                            Preconditions.checkArgument(z2);
                            if (zzog3 != zzog.zzaum) {
                                if (!(zzog3 instanceof zzok)) {
                                    z3 = false;
                                    Preconditions.checkArgument(z3);
                                    Tracker zzbm = this.zzase.zzbm("_GTM_DEFAULT_TRACKER_");
                                    zzbm.enableAdvertisingIdCollection(zzha.zza(zzod5));
                                    if (!zzha.zza(zzod3)) {
                                        HitBuilders.ScreenViewBuilder screenViewBuilder = new HitBuilders.ScreenViewBuilder();
                                        Map<String, String> zzi = zzi(zzoa);
                                        screenViewBuilder.setAll(zzi);
                                        if (zzha.zza(zzod4)) {
                                            obj = this.zzasf.get("ecommerce");
                                        } else {
                                            obj = zzoo.zzj(zzoo.zzk(zzog3));
                                        }
                                        if (obj instanceof Map) {
                                            Map map3 = (Map) obj;
                                            String str = zzi.get("&cu");
                                            if (str == null) {
                                                str = (String) map3.get("currencyCode");
                                            }
                                            if (str != null) {
                                                screenViewBuilder.set("&cu", str);
                                            }
                                            Object obj2 = map3.get("impressions");
                                            if (obj2 instanceof List) {
                                                for (Map map4 : (List) obj2) {
                                                    try {
                                                        screenViewBuilder.addImpression(zzj(map4), (String) map4.get("list"));
                                                    } catch (RuntimeException e) {
                                                        String valueOf = String.valueOf(e.getMessage());
                                                        zzev.zzav(valueOf.length() != 0 ? "Failed to extract a product from event data. ".concat(valueOf) : new String("Failed to extract a product from event data. "));
                                                    }
                                                }
                                            }
                                            if (map3.containsKey("promoClick")) {
                                                list2 = (List) ((Map) map3.get("promoClick")).get("promotions");
                                            } else {
                                                list2 = map3.containsKey("promoView") ? (List) ((Map) map3.get("promoView")).get("promotions") : null;
                                            }
                                            if (list2 != null) {
                                                for (Map map5 : list2) {
                                                    try {
                                                        Promotion promotion = new Promotion();
                                                        String str2 = (String) map5.get("id");
                                                        if (str2 != null) {
                                                            promotion.setId(String.valueOf(str2));
                                                        }
                                                        String str3 = (String) map5.get("name");
                                                        if (str3 != null) {
                                                            promotion.setName(String.valueOf(str3));
                                                        }
                                                        String str4 = (String) map5.get("creative");
                                                        if (str4 != null) {
                                                            promotion.setCreative(String.valueOf(str4));
                                                        }
                                                        String str5 = (String) map5.get("position");
                                                        if (str5 != null) {
                                                            promotion.setPosition(String.valueOf(str5));
                                                        }
                                                        screenViewBuilder.addPromotion(promotion);
                                                    } catch (RuntimeException e2) {
                                                        String valueOf2 = String.valueOf(e2.getMessage());
                                                        zzev.zzav(valueOf2.length() != 0 ? "Failed to extract a promotion from event data. ".concat(valueOf2) : new String("Failed to extract a promotion from event data. "));
                                                    }
                                                }
                                                if (map3.containsKey("promoClick")) {
                                                    screenViewBuilder.set("&promoa", "click");
                                                    z4 = false;
                                                    if (z4) {
                                                        Iterator<String> it = zzamg.iterator();
                                                        while (true) {
                                                            if (!it.hasNext()) {
                                                                break;
                                                            }
                                                            String next = it.next();
                                                            if (map3.containsKey(next)) {
                                                                Map map6 = (Map) map3.get(next);
                                                                List<Map> list3 = (List) map6.get("products");
                                                                if (list3 != null) {
                                                                    for (Map map7 : list3) {
                                                                        try {
                                                                            screenViewBuilder.addProduct(zzj(map7));
                                                                        } catch (RuntimeException e3) {
                                                                            String valueOf3 = String.valueOf(e3.getMessage());
                                                                            zzev.zzav(valueOf3.length() != 0 ? "Failed to extract a product from event data. ".concat(valueOf3) : new String("Failed to extract a product from event data. "));
                                                                        }
                                                                    }
                                                                }
                                                                try {
                                                                    if (map6.containsKey("actionField")) {
                                                                        Map map8 = (Map) map6.get("actionField");
                                                                        productAction = new ProductAction(next);
                                                                        Object obj3 = map8.get("id");
                                                                        if (obj3 != null) {
                                                                            productAction.setTransactionId(String.valueOf(obj3));
                                                                        }
                                                                        Object obj4 = map8.get(FirebaseAnalytics.Param.AFFILIATION);
                                                                        if (obj4 != null) {
                                                                            productAction.setTransactionAffiliation(String.valueOf(obj4));
                                                                        }
                                                                        Object obj5 = map8.get(FirebaseAnalytics.Param.COUPON);
                                                                        if (obj5 != null) {
                                                                            productAction.setTransactionCouponCode(String.valueOf(obj5));
                                                                        }
                                                                        Object obj6 = map8.get("list");
                                                                        if (obj6 != null) {
                                                                            productAction.setProductActionList(String.valueOf(obj6));
                                                                        }
                                                                        Object obj7 = map8.get("option");
                                                                        if (obj7 != null) {
                                                                            productAction.setCheckoutOptions(String.valueOf(obj7));
                                                                        }
                                                                        Object obj8 = map8.get("revenue");
                                                                        if (obj8 != null) {
                                                                            productAction.setTransactionRevenue(zzm(obj8).doubleValue());
                                                                        }
                                                                        Object obj9 = map8.get(FirebaseAnalytics.Param.TAX);
                                                                        if (obj9 != null) {
                                                                            productAction.setTransactionTax(zzm(obj9).doubleValue());
                                                                        }
                                                                        Object obj10 = map8.get(FirebaseAnalytics.Param.SHIPPING);
                                                                        if (obj10 != null) {
                                                                            productAction.setTransactionShipping(zzm(obj10).doubleValue());
                                                                        }
                                                                        Object obj11 = map8.get("step");
                                                                        if (obj11 != null) {
                                                                            productAction.setCheckoutStep(zzn(obj11).intValue());
                                                                        }
                                                                    } else {
                                                                        productAction = new ProductAction(next);
                                                                    }
                                                                    screenViewBuilder.setProductAction(productAction);
                                                                } catch (RuntimeException e4) {
                                                                    String valueOf4 = String.valueOf(e4.getMessage());
                                                                    zzev.zzav(valueOf4.length() != 0 ? "Failed to extract a product action from event data. ".concat(valueOf4) : new String("Failed to extract a product action from event data. "));
                                                                }
                                                            }
                                                        }
                                                    }
                                                } else {
                                                    screenViewBuilder.set("&promoa", Promotion.ACTION_VIEW);
                                                }
                                            }
                                            z4 = true;
                                            if (z4) {
                                            }
                                        }
                                        zzbm.send(screenViewBuilder.build());
                                    } else if (zzha.zza(zzod)) {
                                        zzbm.send(zzi(zzoa));
                                    } else if (zzha.zza(zzod2)) {
                                        String str6 = (String) this.zzasf.get("transactionId");
                                        if (str6 == null) {
                                            zzev.zzav("Cannot find transactionId in data layer.");
                                        } else {
                                            ArrayList arrayList = new ArrayList();
                                            try {
                                                Map<String, String> zzi2 = zzi(zzoa);
                                                zzi2.put("&t", "transaction");
                                                if (zzog == zzog.zzaum) {
                                                    map = zzasc;
                                                } else {
                                                    map = zzh(zzog);
                                                }
                                                for (Map.Entry<String, String> entry : map.entrySet()) {
                                                    String str7 = (String) this.zzasf.get(entry.getKey());
                                                    if (str7 != null) {
                                                        zzi2.put(entry.getValue(), str7);
                                                    }
                                                }
                                                arrayList.add(zzi2);
                                                Object obj12 = this.zzasf.get("transactionProducts");
                                                if (obj12 == null) {
                                                    list = null;
                                                } else if (obj12 instanceof List) {
                                                    list = (List) obj12;
                                                    for (Object obj13 : list) {
                                                        if (!(obj13 instanceof Map)) {
                                                            throw new IllegalArgumentException("Each element of transactionProducts should be of type Map.");
                                                        }
                                                    }
                                                } else {
                                                    throw new IllegalArgumentException("transactionProducts should be of type List.");
                                                }
                                                if (list != null) {
                                                    Iterator it2 = list.iterator();
                                                    while (true) {
                                                        if (!it2.hasNext()) {
                                                            break;
                                                        }
                                                        Map map9 = (Map) it2.next();
                                                        if (map9.get("name") == null) {
                                                            zzev.zzav("Unable to send transaction item hit due to missing 'name' field.");
                                                            break;
                                                        }
                                                        Map<String, String> zzi3 = zzi(zzoa);
                                                        zzi3.put("&t", "item");
                                                        zzi3.put("&ti", str6);
                                                        if (zzog2 == zzog.zzaum) {
                                                            map2 = zzasd;
                                                        } else {
                                                            map2 = zzh(zzog2);
                                                        }
                                                        for (Map.Entry<String, String> entry2 : map2.entrySet()) {
                                                            Object obj14 = map9.get(entry2.getKey());
                                                            if (obj14 != null) {
                                                                zzi3.put(entry2.getValue(), obj14.toString());
                                                            }
                                                        }
                                                        arrayList.add(zzi3);
                                                    }
                                                }
                                                ArrayList arrayList2 = arrayList;
                                                int size = arrayList2.size();
                                                int i = 0;
                                                while (i < size) {
                                                    Object obj15 = arrayList2.get(i);
                                                    i++;
                                                    zzbm.send((Map) obj15);
                                                }
                                            } catch (IllegalArgumentException e5) {
                                                zzev.zza("Unable to send transaction", e5);
                                            }
                                        }
                                    } else {
                                        zzev.zzac("Ignoring unknown tag.");
                                    }
                                    this.zzasf = null;
                                    return zzog.zzaum;
                                }
                            }
                            z3 = true;
                            Preconditions.checkArgument(z3);
                            Tracker zzbm2 = this.zzase.zzbm("_GTM_DEFAULT_TRACKER_");
                            zzbm2.enableAdvertisingIdCollection(zzha.zza(zzod5));
                            if (!zzha.zza(zzod3)) {
                            }
                            this.zzasf = null;
                            return zzog.zzaum;
                        }
                    }
                    z2 = true;
                    Preconditions.checkArgument(z2);
                    if (zzog3 != zzog.zzaum) {
                    }
                    z3 = true;
                    Preconditions.checkArgument(z3);
                    Tracker zzbm22 = this.zzase.zzbm("_GTM_DEFAULT_TRACKER_");
                    zzbm22.enableAdvertisingIdCollection(zzha.zza(zzod5));
                    if (!zzha.zza(zzod3)) {
                    }
                    this.zzasf = null;
                    return zzog.zzaum;
                }
            }
            z = true;
            Preconditions.checkArgument(z);
            if (zzog2 != zzog.zzaum) {
            }
            z2 = true;
            Preconditions.checkArgument(z2);
            if (zzog3 != zzog.zzaum) {
            }
            z3 = true;
            Preconditions.checkArgument(z3);
            Tracker zzbm222 = this.zzase.zzbm("_GTM_DEFAULT_TRACKER_");
            zzbm222.enableAdvertisingIdCollection(zzha.zza(zzod5));
            if (!zzha.zza(zzod3)) {
            }
            this.zzasf = null;
            return zzog.zzaum;
        } catch (Throwable th) {
            this.zzasf = null;
            throw th;
        }
    }

    private static Product zzj(Map<String, Object> map) {
        Product product = new Product();
        Object obj = map.get("id");
        if (obj != null) {
            product.setId(String.valueOf(obj));
        }
        Object obj2 = map.get("name");
        if (obj2 != null) {
            product.setName(String.valueOf(obj2));
        }
        Object obj3 = map.get("brand");
        if (obj3 != null) {
            product.setBrand(String.valueOf(obj3));
        }
        Object obj4 = map.get("category");
        if (obj4 != null) {
            product.setCategory(String.valueOf(obj4));
        }
        Object obj5 = map.get("variant");
        if (obj5 != null) {
            product.setVariant(String.valueOf(obj5));
        }
        Object obj6 = map.get(FirebaseAnalytics.Param.COUPON);
        if (obj6 != null) {
            product.setCouponCode(String.valueOf(obj6));
        }
        Object obj7 = map.get("position");
        if (obj7 != null) {
            product.setPosition(zzn(obj7).intValue());
        }
        Object obj8 = map.get(FirebaseAnalytics.Param.PRICE);
        if (obj8 != null) {
            product.setPrice(zzm(obj8).doubleValue());
        }
        Object obj9 = map.get(FirebaseAnalytics.Param.QUANTITY);
        if (obj9 != null) {
            product.setQuantity(zzn(obj9).intValue());
        }
        for (String str : map.keySet()) {
            Matcher matcher = zzamh.matcher(str);
            if (matcher.matches()) {
                try {
                    product.setCustomDimension(Integer.parseInt(matcher.group(1)), String.valueOf(map.get(str)));
                } catch (NumberFormatException unused) {
                    String valueOf = String.valueOf(str);
                    zzev.zzac(valueOf.length() != 0 ? "illegal number in custom dimension value: ".concat(valueOf) : new String("illegal number in custom dimension value: "));
                }
            } else {
                Matcher matcher2 = zzami.matcher(str);
                if (matcher2.matches()) {
                    try {
                        product.setCustomMetric(Integer.parseInt(matcher2.group(1)), zzn(map.get(str)).intValue());
                    } catch (NumberFormatException unused2) {
                        String valueOf2 = String.valueOf(str);
                        zzev.zzac(valueOf2.length() != 0 ? "illegal number in custom metric value: ".concat(valueOf2) : new String("illegal number in custom metric value: "));
                    }
                }
            }
        }
        return product;
    }

    private static Map<String, String> zzh(zzoa<?> zzoa) {
        Preconditions.checkNotNull(zzoa);
        Preconditions.checkArgument(zzoa instanceof zzok);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Object zzj = zzoo.zzj(zzoo.zzk(zzoa));
        Preconditions.checkState(zzj instanceof Map);
        for (Map.Entry entry : ((Map) zzj).entrySet()) {
            linkedHashMap.put(entry.getKey().toString(), entry.getValue().toString());
        }
        return linkedHashMap;
    }

    private static Map<String, String> zzi(zzoa<?> zzoa) {
        Map<String, String> zzh = zzh(zzoa);
        String str = zzh.get("&aip");
        if (str != null && zzasb.contains(str.toLowerCase())) {
            zzh.remove("&aip");
        }
        return zzh;
    }

    private static Double zzm(Object obj) {
        if (obj instanceof String) {
            try {
                return Double.valueOf((String) obj);
            } catch (NumberFormatException e) {
                String valueOf = String.valueOf(e.getMessage());
                throw new RuntimeException(valueOf.length() != 0 ? "Cannot convert the object to Double: ".concat(valueOf) : new String("Cannot convert the object to Double: "));
            }
        } else if (obj instanceof Integer) {
            return Double.valueOf(((Integer) obj).doubleValue());
        } else {
            if (obj instanceof Double) {
                return (Double) obj;
            }
            String valueOf2 = String.valueOf(obj.toString());
            throw new RuntimeException(valueOf2.length() != 0 ? "Cannot convert the object to Double: ".concat(valueOf2) : new String("Cannot convert the object to Double: "));
        }
    }

    private static Integer zzn(Object obj) {
        if (obj instanceof String) {
            try {
                return Integer.valueOf((String) obj);
            } catch (NumberFormatException e) {
                String valueOf = String.valueOf(e.getMessage());
                throw new RuntimeException(valueOf.length() != 0 ? "Cannot convert the object to Integer: ".concat(valueOf) : new String("Cannot convert the object to Integer: "));
            }
        } else if (obj instanceof Double) {
            return Integer.valueOf(((Double) obj).intValue());
        } else {
            if (obj instanceof Integer) {
                return (Integer) obj;
            }
            String valueOf2 = String.valueOf(obj.toString());
            throw new RuntimeException(valueOf2.length() != 0 ? "Cannot convert the object to Integer: ".concat(valueOf2) : new String("Cannot convert the object to Integer: "));
        }
    }
}
