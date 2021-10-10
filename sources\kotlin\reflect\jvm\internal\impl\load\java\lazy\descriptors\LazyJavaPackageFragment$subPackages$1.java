package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaPackage;
import kotlin.reflect.jvm.internal.impl.name.FqName;

/* access modifiers changed from: package-private */
/* compiled from: LazyJavaPackageFragment.kt */
public final class LazyJavaPackageFragment$subPackages$1 extends Lambda implements Function0<List<? extends FqName>> {
    final /* synthetic */ LazyJavaPackageFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LazyJavaPackageFragment$subPackages$1(LazyJavaPackageFragment lazyJavaPackageFragment) {
        super(0);
        this.this$0 = lazyJavaPackageFragment;
    }

    /* Return type fixed from 'java.util.List<kotlin.reflect.jvm.internal.impl.name.FqName>' to match base method */
    @Override // kotlin.jvm.functions.Function0
    public final List<? extends FqName> invoke() {
        Collection<JavaPackage> subPackages = this.this$0.jPackage.getSubPackages();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(subPackages, 10));
        Iterator<T> it = subPackages.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().getFqName());
        }
        return arrayList;
    }
}
