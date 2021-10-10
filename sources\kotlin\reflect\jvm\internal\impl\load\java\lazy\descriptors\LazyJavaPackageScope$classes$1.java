package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.JavaClassFinder;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaPackageScope;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.load.java.structure.LightClassOriginKind;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinClassFinder;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinClassFinderKt;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;

/* access modifiers changed from: package-private */
/* compiled from: LazyJavaPackageScope.kt */
public final class LazyJavaPackageScope$classes$1 extends Lambda implements Function1<LazyJavaPackageScope.FindClassRequest, ClassDescriptor> {
    final /* synthetic */ LazyJavaResolverContext $c;
    final /* synthetic */ LazyJavaPackageScope this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LazyJavaPackageScope$classes$1(LazyJavaPackageScope lazyJavaPackageScope, LazyJavaResolverContext lazyJavaResolverContext) {
        super(1);
        this.this$0 = lazyJavaPackageScope;
        this.$c = lazyJavaResolverContext;
    }

    public final ClassDescriptor invoke(LazyJavaPackageScope.FindClassRequest findClassRequest) {
        KotlinClassFinder.Result result;
        byte[] bArr;
        Intrinsics.checkNotNullParameter(findClassRequest, "request");
        ClassId classId = new ClassId(this.this$0.getOwnerDescriptor().getFqName(), findClassRequest.getName());
        if (findClassRequest.getJavaClass() != null) {
            result = this.$c.getComponents().getKotlinClassFinder().findKotlinClassOrContent(findClassRequest.getJavaClass());
        } else {
            result = this.$c.getComponents().getKotlinClassFinder().findKotlinClassOrContent(classId);
        }
        LazyJavaClassDescriptor lazyJavaClassDescriptor = null;
        KotlinJvmBinaryClass kotlinJvmBinaryClass = result != null ? result.toKotlinJvmBinaryClass() : null;
        ClassId classId2 = kotlinJvmBinaryClass != null ? kotlinJvmBinaryClass.getClassId() : null;
        if (classId2 != null && (classId2.isNestedClass() || classId2.isLocal())) {
            return null;
        }
        LazyJavaPackageScope.KotlinClassLookupResult kotlinClassLookupResult = this.this$0.resolveKotlinBinaryClass(kotlinJvmBinaryClass);
        if (kotlinClassLookupResult instanceof LazyJavaPackageScope.KotlinClassLookupResult.Found) {
            return ((LazyJavaPackageScope.KotlinClassLookupResult.Found) kotlinClassLookupResult).getDescriptor();
        }
        if (kotlinClassLookupResult instanceof LazyJavaPackageScope.KotlinClassLookupResult.SyntheticClass) {
            return null;
        }
        if (kotlinClassLookupResult instanceof LazyJavaPackageScope.KotlinClassLookupResult.NotFound) {
            JavaClass javaClass = findClassRequest.getJavaClass();
            if (javaClass == null) {
                JavaClassFinder finder = this.$c.getComponents().getFinder();
                if (result != null) {
                    if (!(result instanceof KotlinClassFinder.Result.ClassFileContent)) {
                        result = null;
                    }
                    KotlinClassFinder.Result.ClassFileContent classFileContent = (KotlinClassFinder.Result.ClassFileContent) result;
                    if (classFileContent != null) {
                        bArr = classFileContent.getContent();
                        javaClass = finder.findClass(new JavaClassFinder.Request(classId, bArr, null, 4, null));
                    }
                }
                bArr = null;
                javaClass = finder.findClass(new JavaClassFinder.Request(classId, bArr, null, 4, null));
            }
            if ((javaClass != null ? javaClass.getLightClassOriginKind() : null) != LightClassOriginKind.BINARY) {
                FqName fqName = javaClass != null ? javaClass.getFqName() : null;
                if (fqName != null && !fqName.isRoot() && !(!Intrinsics.areEqual(fqName.parent(), this.this$0.getOwnerDescriptor().getFqName()))) {
                    lazyJavaClassDescriptor = new LazyJavaClassDescriptor(this.$c, this.this$0.getOwnerDescriptor(), javaClass, null, 8, null);
                    this.$c.getComponents().getJavaClassesTracker().reportClass(lazyJavaClassDescriptor);
                }
                return lazyJavaClassDescriptor;
            }
            throw new IllegalStateException("Couldn't find kotlin binary class for light class created by kotlin binary file\n" + "JavaClass: " + javaClass + '\n' + "ClassId: " + classId + '\n' + "findKotlinClass(JavaClass) = " + KotlinClassFinderKt.findKotlinClass(this.$c.getComponents().getKotlinClassFinder(), javaClass) + '\n' + "findKotlinClass(ClassId) = " + KotlinClassFinderKt.findKotlinClass(this.$c.getComponents().getKotlinClassFinder(), classId) + '\n');
        }
        throw new NoWhenBranchMatchedException();
    }
}
