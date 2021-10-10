package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.ChainedMemberScope;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;

/* compiled from: LazyPackageViewDescriptorImpl.kt */
final class LazyPackageViewDescriptorImpl$memberScope$1 extends Lambda implements Function0<MemberScope> {
    final /* synthetic */ LazyPackageViewDescriptorImpl this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LazyPackageViewDescriptorImpl$memberScope$1(LazyPackageViewDescriptorImpl lazyPackageViewDescriptorImpl) {
        super(0);
        this.this$0 = lazyPackageViewDescriptorImpl;
    }

    @Override // kotlin.jvm.functions.Function0
    public final MemberScope invoke() {
        if (this.this$0.getFragments().isEmpty()) {
            return MemberScope.Empty.INSTANCE;
        }
        List<PackageFragmentDescriptor> fragments = this.this$0.getFragments();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(fragments, 10));
        Iterator<T> it = fragments.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().getMemberScope());
        }
        List plus = CollectionsKt.plus((Collection) arrayList, (Object) new SubpackagesScope(this.this$0.getModule(), this.this$0.getFqName()));
        ChainedMemberScope.Companion companion = ChainedMemberScope.Companion;
        return companion.create("package view scope for " + this.this$0.getFqName() + " in " + this.this$0.getModule().getName(), plus);
    }
}
