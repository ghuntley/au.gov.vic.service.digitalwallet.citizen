package kotlin.reflect.jvm.internal.impl.util.collectionUtils;

import java.util.Collection;
import java.util.LinkedHashSet;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.utils.SmartList;

/* compiled from: scopeUtils.kt */
public final class ScopeUtilsKt {
    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.util.Collection<? extends T> */
    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.util.Collection<? extends T> */
    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> Collection<T> concat(Collection<? extends T> collection, Collection<? extends T> collection2) {
        Intrinsics.checkNotNullParameter(collection2, "collection");
        if (collection2.isEmpty()) {
            return collection;
        }
        if (collection == 0) {
            return collection2;
        }
        if (collection instanceof LinkedHashSet) {
            ((LinkedHashSet) collection).addAll(collection2);
            return collection;
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet(collection);
        linkedHashSet.addAll(collection2);
        return linkedHashSet;
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Object] */
    /* JADX WARNING: Unknown variable types count: 1 */
    public static final SmartList<MemberScope> listOfNonEmptyScopes(Iterable<? extends MemberScope> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "scopes");
        SmartList<MemberScope> smartList = new SmartList<>();
        for (?? r1 : iterable) {
            MemberScope memberScope = (MemberScope) r1;
            if ((memberScope == null || memberScope == MemberScope.Empty.INSTANCE) ? false : true) {
                smartList.add(r1);
            }
        }
        return smartList;
    }
}
