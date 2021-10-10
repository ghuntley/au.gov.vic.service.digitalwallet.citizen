package kotlin.reflect.jvm.internal.impl.load.kotlin;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PackagePartProvider.kt */
public interface PackagePartProvider {
    List<String> findPackageParts(String str);

    /* compiled from: PackagePartProvider.kt */
    public static final class Empty implements PackagePartProvider {
        public static final Empty INSTANCE = new Empty();

        private Empty() {
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.PackagePartProvider
        public List<String> findPackageParts(String str) {
            Intrinsics.checkNotNullParameter(str, "packageFqName");
            return CollectionsKt.emptyList();
        }
    }
}
