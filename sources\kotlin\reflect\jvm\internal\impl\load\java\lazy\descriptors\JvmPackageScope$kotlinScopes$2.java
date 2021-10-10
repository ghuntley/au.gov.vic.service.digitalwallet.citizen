package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.util.collectionUtils.ScopeUtilsKt;

/* compiled from: JvmPackageScope.kt */
final class JvmPackageScope$kotlinScopes$2 extends Lambda implements Function0<MemberScope[]> {
    final /* synthetic */ JvmPackageScope this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    JvmPackageScope$kotlinScopes$2(JvmPackageScope jvmPackageScope) {
        super(0);
        this.this$0 = jvmPackageScope;
    }

    @Override // kotlin.jvm.functions.Function0
    public final MemberScope[] invoke() {
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = JvmPackageScope.access$getPackageFragment$p(this.this$0).getBinaryClasses$descriptors_jvm().values().iterator();
        while (it.hasNext()) {
            MemberScope createKotlinPackagePartScope = JvmPackageScope.access$getC$p(this.this$0).getComponents().getDeserializedDescriptorResolver().createKotlinPackagePartScope(JvmPackageScope.access$getPackageFragment$p(this.this$0), it.next());
            if (createKotlinPackagePartScope != null) {
                arrayList.add(createKotlinPackagePartScope);
            }
        }
        Object[] array = ScopeUtilsKt.listOfNonEmptyScopes(arrayList).toArray(new MemberScope[0]);
        Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
        return (MemberScope[]) array;
    }
}
