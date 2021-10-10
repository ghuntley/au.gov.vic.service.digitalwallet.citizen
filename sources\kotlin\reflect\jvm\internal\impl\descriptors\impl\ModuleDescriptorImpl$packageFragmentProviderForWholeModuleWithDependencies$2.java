package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProvider;

/* access modifiers changed from: package-private */
/* compiled from: ModuleDescriptorImpl.kt */
public final class ModuleDescriptorImpl$packageFragmentProviderForWholeModuleWithDependencies$2 extends Lambda implements Function0<CompositePackageFragmentProvider> {
    final /* synthetic */ ModuleDescriptorImpl this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ModuleDescriptorImpl$packageFragmentProviderForWholeModuleWithDependencies$2(ModuleDescriptorImpl moduleDescriptorImpl) {
        super(0);
        this.this$0 = moduleDescriptorImpl;
    }

    @Override // kotlin.jvm.functions.Function0
    public final CompositePackageFragmentProvider invoke() {
        ModuleDependencies moduleDependencies = this.this$0.dependencies;
        if (moduleDependencies != null) {
            List<ModuleDescriptorImpl> allDependencies = moduleDependencies.getAllDependencies();
            allDependencies.contains(this.this$0);
            List<ModuleDescriptorImpl> list = allDependencies;
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                boolean unused = it.next().isInitialized();
            }
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            Iterator<T> it2 = list.iterator();
            while (it2.hasNext()) {
                PackageFragmentProvider packageFragmentProvider = it2.next().packageFragmentProviderForModuleContent;
                Intrinsics.checkNotNull(packageFragmentProvider);
                arrayList.add(packageFragmentProvider);
            }
            return new CompositePackageFragmentProvider(arrayList);
        }
        throw new AssertionError("Dependencies of module " + this.this$0.getId() + " were not set before querying module content");
    }
}
