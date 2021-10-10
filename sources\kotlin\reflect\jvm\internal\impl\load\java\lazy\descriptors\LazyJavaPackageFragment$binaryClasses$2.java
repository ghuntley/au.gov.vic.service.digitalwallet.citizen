package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.ArrayList;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinClassFinderKt;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass;
import kotlin.reflect.jvm.internal.impl.load.kotlin.PackagePartProvider;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmClassName;

/* access modifiers changed from: package-private */
/* compiled from: LazyJavaPackageFragment.kt */
public final class LazyJavaPackageFragment$binaryClasses$2 extends Lambda implements Function0<Map<String, ? extends KotlinJvmBinaryClass>> {
    final /* synthetic */ LazyJavaPackageFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LazyJavaPackageFragment$binaryClasses$2(LazyJavaPackageFragment lazyJavaPackageFragment) {
        super(0);
        this.this$0 = lazyJavaPackageFragment;
    }

    /* Return type fixed from 'java.util.Map<java.lang.String, kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass>' to match base method */
    @Override // kotlin.jvm.functions.Function0
    public final Map<String, ? extends KotlinJvmBinaryClass> invoke() {
        PackagePartProvider packagePartProvider = this.this$0.c.getComponents().getPackagePartProvider();
        String asString = this.this$0.getFqName().asString();
        Intrinsics.checkNotNullExpressionValue(asString, "fqName.asString()");
        ArrayList arrayList = new ArrayList();
        for (T t : packagePartProvider.findPackageParts(asString)) {
            JvmClassName byInternalName = JvmClassName.byInternalName(t);
            Intrinsics.checkNotNullExpressionValue(byInternalName, "JvmClassName.byInternalName(partName)");
            ClassId classId = ClassId.topLevel(byInternalName.getFqNameForTopLevelClassMaybeWithDollars());
            Intrinsics.checkNotNullExpressionValue(classId, "ClassId.topLevel(JvmClas…velClassMaybeWithDollars)");
            KotlinJvmBinaryClass findKotlinClass = KotlinClassFinderKt.findKotlinClass(this.this$0.c.getComponents().getKotlinClassFinder(), classId);
            Pair pair = findKotlinClass != null ? TuplesKt.to(t, findKotlinClass) : null;
            if (pair != null) {
                arrayList.add(pair);
            }
        }
        return MapsKt.toMap(arrayList);
    }
}
