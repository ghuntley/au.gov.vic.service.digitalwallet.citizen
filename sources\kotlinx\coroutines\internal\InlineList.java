package kotlinx.coroutines.internal;

import java.util.ArrayList;
import java.util.List;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.DebugKt;

public final class InlineList<E> {
    private final Object holder;

    /* renamed from: box-impl */
    public static final /* synthetic */ InlineList m1360boximpl(Object obj) {
        return new InlineList(obj);
    }

    /* renamed from: constructor-impl */
    public static Object m1361constructorimpl(Object obj) {
        return obj;
    }

    /* renamed from: equals-impl */
    public static boolean m1363equalsimpl(Object obj, Object obj2) {
        return (obj2 instanceof InlineList) && Intrinsics.areEqual(obj, ((InlineList) obj2).m1369unboximpl());
    }

    /* renamed from: equals-impl0 */
    public static final boolean m1364equalsimpl0(Object obj, Object obj2) {
        return Intrinsics.areEqual(obj, obj2);
    }

    /* renamed from: hashCode-impl */
    public static int m1366hashCodeimpl(Object obj) {
        if (obj != null) {
            return obj.hashCode();
        }
        return 0;
    }

    /* renamed from: toString-impl */
    public static String m1368toStringimpl(Object obj) {
        return "InlineList(holder=" + obj + ")";
    }

    public boolean equals(Object obj) {
        return m1363equalsimpl(this.holder, obj);
    }

    public int hashCode() {
        return m1366hashCodeimpl(this.holder);
    }

    public String toString() {
        return m1368toStringimpl(this.holder);
    }

    /* renamed from: unbox-impl */
    public final /* synthetic */ Object m1369unboximpl() {
        return this.holder;
    }

    private /* synthetic */ InlineList(Object obj) {
        this.holder = obj;
    }

    /* renamed from: constructor-impl$default */
    public static /* synthetic */ Object m1362constructorimpl$default(Object obj, int i, DefaultConstructorMarker defaultConstructorMarker) {
        if ((i & 1) != 0) {
            obj = null;
        }
        return m1361constructorimpl(obj);
    }

    /* renamed from: plus-impl */
    public static final Object m1367plusimpl(Object obj, E e) {
        if (DebugKt.getASSERTIONS_ENABLED() && !(!(e instanceof List))) {
            throw new AssertionError();
        } else if (obj == null) {
            return m1361constructorimpl(e);
        } else {
            if (!(obj instanceof ArrayList)) {
                ArrayList arrayList = new ArrayList(4);
                arrayList.add(obj);
                arrayList.add(e);
                return m1361constructorimpl(arrayList);
            } else if (obj != null) {
                ((ArrayList) obj).add(e);
                return m1361constructorimpl(obj);
            } else {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.ArrayList<E> /* = java.util.ArrayList<E> */");
            }
        }
    }

    /* renamed from: forEachReversed-impl */
    public static final void m1365forEachReversedimpl(Object obj, Function1<? super E, Unit> function1) {
        if (obj != null) {
            if (!(obj instanceof ArrayList)) {
                function1.invoke(obj);
            } else if (obj != null) {
                ArrayList arrayList = (ArrayList) obj;
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    function1.invoke((Object) arrayList.get(size));
                }
            } else {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.ArrayList<E> /* = java.util.ArrayList<E> */");
            }
        }
    }
}
