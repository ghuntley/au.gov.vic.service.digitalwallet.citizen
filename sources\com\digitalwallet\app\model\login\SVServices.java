package com.digitalwallet.app.model.login;

import com.squareup.moshi.JsonClass;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@JsonClass(generateAdapter = true)
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u000f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\u0013\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0007HÖ\u0001R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\tR\u0019\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\tR\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\t¨\u0006\u001a"}, d2 = {"Lcom/digitalwallet/app/model/login/SVServices;", "", "services", "", "Lcom/digitalwallet/app/model/login/SVService;", "(Ljava/util/List;)V", "allImageUrlCacheNames", "", "getAllImageUrlCacheNames", "()Ljava/util/List;", "getServices", "sortedAllServices", "getSortedAllServices", "sortedCarouselItems", "Lcom/digitalwallet/app/model/login/SVItem;", "getSortedCarouselItems", "sortedServiceGroups", "getSortedServiceGroups", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: SVServices.kt */
public final class SVServices {
    private final List<String> allImageUrlCacheNames;
    private final List<SVService> services;
    private final List<SVService> sortedAllServices;
    private final List<SVItem> sortedCarouselItems;
    private final List<SVService> sortedServiceGroups;

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.digitalwallet.app.model.login.SVServices */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SVServices copy$default(SVServices sVServices, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = sVServices.services;
        }
        return sVServices.copy(list);
    }

    public final List<SVService> component1() {
        return this.services;
    }

    public final SVServices copy(List<SVService> list) {
        Intrinsics.checkNotNullParameter(list, "services");
        return new SVServices(list);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof SVServices) && Intrinsics.areEqual(this.services, ((SVServices) obj).services);
        }
        return true;
    }

    public int hashCode() {
        List<SVService> list = this.services;
        if (list != null) {
            return list.hashCode();
        }
        return 0;
    }

    public String toString() {
        return "SVServices(services=" + this.services + ")";
    }

    public SVServices(List<SVService> list) {
        List<SVItem> list2;
        T t;
        ArrayList arrayList;
        Intrinsics.checkNotNullParameter(list, "services");
        this.services = list;
        List<SVService> sortedWith = CollectionsKt.sortedWith(list, new SVServices$$special$$inlined$sortedBy$1());
        this.sortedAllServices = sortedWith;
        Iterator<T> it = sortedWith.iterator();
        while (true) {
            list2 = null;
            if (!it.hasNext()) {
                t = null;
                break;
            }
            t = it.next();
            if (Intrinsics.areEqual(t.getType(), SVService.TYPE_CAROUSEL)) {
                break;
            }
        }
        T t2 = t;
        this.sortedCarouselItems = t2 != null ? t2.getSortedItems() : list2;
        ArrayList arrayList2 = new ArrayList();
        for (T t3 : this.sortedAllServices) {
            if (Intrinsics.areEqual(t3.getType(), SVService.TYPE_GROUP)) {
                arrayList2.add(t3);
            }
        }
        this.sortedServiceGroups = arrayList2;
        List<SVItem> list3 = this.sortedCarouselItems;
        if (list3 != null) {
            ArrayList arrayList3 = new ArrayList();
            Iterator<T> it2 = list3.iterator();
            while (it2.hasNext()) {
                String cacheNameForImageUrl = it2.next().getCacheNameForImageUrl();
                if (cacheNameForImageUrl != null) {
                    arrayList3.add(cacheNameForImageUrl);
                }
            }
            arrayList = arrayList3;
        } else {
            arrayList = CollectionsKt.emptyList();
        }
        this.allImageUrlCacheNames = arrayList;
    }

    public final List<SVService> getServices() {
        return this.services;
    }

    public final List<SVService> getSortedAllServices() {
        return this.sortedAllServices;
    }

    public final List<SVItem> getSortedCarouselItems() {
        return this.sortedCarouselItems;
    }

    public final List<SVService> getSortedServiceGroups() {
        return this.sortedServiceGroups;
    }

    public final List<String> getAllImageUrlCacheNames() {
        return this.allImageUrlCacheNames;
    }
}
