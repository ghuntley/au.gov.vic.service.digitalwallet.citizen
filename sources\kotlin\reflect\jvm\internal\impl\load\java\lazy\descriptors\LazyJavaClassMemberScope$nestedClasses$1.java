package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.Map;
import java.util.Set;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ClassDescriptorBase;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.EnumEntrySyntheticClassDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.JavaClassFinder;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaClassDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaAnnotationsKt;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaField;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;

/* access modifiers changed from: package-private */
/* compiled from: LazyJavaClassMemberScope.kt */
public final class LazyJavaClassMemberScope$nestedClasses$1 extends Lambda implements Function1<Name, ClassDescriptorBase> {
    final /* synthetic */ LazyJavaResolverContext $c;
    final /* synthetic */ LazyJavaClassMemberScope this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LazyJavaClassMemberScope$nestedClasses$1(LazyJavaClassMemberScope lazyJavaClassMemberScope, LazyJavaResolverContext lazyJavaResolverContext) {
        super(1);
        this.this$0 = lazyJavaClassMemberScope;
        this.$c = lazyJavaResolverContext;
    }

    public final ClassDescriptorBase invoke(Name name) {
        Intrinsics.checkNotNullParameter(name, "name");
        ClassDescriptorBase classDescriptorBase = null;
        if (!((Set) this.this$0.nestedClassIndex.invoke()).contains(name)) {
            JavaField javaField = (JavaField) ((Map) this.this$0.enumEntryIndex.invoke()).get(name);
            if (javaField != null) {
                classDescriptorBase = EnumEntrySyntheticClassDescriptor.create(this.$c.getStorageManager(), this.this$0.getOwnerDescriptor(), name, this.$c.getStorageManager().createLazyValue(new LazyJavaClassMemberScope$nestedClasses$1$enumMemberNames$1(this)), LazyJavaAnnotationsKt.resolveAnnotations(this.$c, javaField), this.$c.getComponents().getSourceElementFactory().source(javaField));
            }
            return classDescriptorBase;
        }
        JavaClassFinder finder = this.$c.getComponents().getFinder();
        ClassId classId = DescriptorUtilsKt.getClassId(this.this$0.getOwnerDescriptor());
        Intrinsics.checkNotNull(classId);
        ClassId createNestedClassId = classId.createNestedClassId(name);
        Intrinsics.checkNotNullExpressionValue(createNestedClassId, "ownerDescriptor.classId!…createNestedClassId(name)");
        JavaClass findClass = finder.findClass(new JavaClassFinder.Request(createNestedClassId, null, this.this$0.jClass, 2, null));
        if (findClass != null) {
            classDescriptorBase = new LazyJavaClassDescriptor(this.$c, this.this$0.getOwnerDescriptor(), findClass, null, 8, null);
            this.$c.getComponents().getJavaClassesTracker().reportClass((JavaClassDescriptor) classDescriptorBase);
        }
        return classDescriptorBase;
    }
}
