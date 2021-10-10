package kotlin.reflect.jvm.internal.impl.descriptors;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.NotFoundClasses;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNotNull;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;

/* access modifiers changed from: package-private */
/* compiled from: NotFoundClasses.kt */
public final class NotFoundClasses$classes$1 extends Lambda implements Function1<NotFoundClasses.ClassRequest, ClassDescriptor> {
    final /* synthetic */ NotFoundClasses this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    NotFoundClasses$classes$1(NotFoundClasses notFoundClasses) {
        super(1);
        this.this$0 = notFoundClasses;
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0066  */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x006b  */
    public final ClassDescriptor invoke(NotFoundClasses.ClassRequest classRequest) {
        ClassDescriptor classDescriptor;
        Intrinsics.checkNotNullParameter(classRequest, "<name for destructuring parameter 0>");
        ClassId component1 = classRequest.component1();
        List<Integer> component2 = classRequest.component2();
        if (!component1.isLocal()) {
            ClassId outerClassId = component1.getOuterClassId();
            if (outerClassId != null) {
                NotFoundClasses notFoundClasses = this.this$0;
                Intrinsics.checkNotNullExpressionValue(outerClassId, "outerClassId");
                ClassDescriptor classDescriptor2 = notFoundClasses.getClass(outerClassId, CollectionsKt.drop(component2, 1));
                if (classDescriptor2 != null) {
                    classDescriptor = classDescriptor2;
                    boolean isNestedClass = component1.isNestedClass();
                    StorageManager storageManager = this.this$0.storageManager;
                    ClassOrPackageFragmentDescriptor classOrPackageFragmentDescriptor = classDescriptor;
                    Name shortClassName = component1.getShortClassName();
                    Intrinsics.checkNotNullExpressionValue(shortClassName, "classId.shortClassName");
                    Integer num = (Integer) CollectionsKt.firstOrNull((List) component2);
                    return new NotFoundClasses.MockClassDescriptor(storageManager, classOrPackageFragmentDescriptor, shortClassName, isNestedClass, num == null ? num.intValue() : 0);
                }
            }
            MemoizedFunctionToNotNull memoizedFunctionToNotNull = this.this$0.packageFragments;
            FqName packageFqName = component1.getPackageFqName();
            Intrinsics.checkNotNullExpressionValue(packageFqName, "classId.packageFqName");
            classDescriptor = (ClassOrPackageFragmentDescriptor) memoizedFunctionToNotNull.invoke(packageFqName);
            boolean isNestedClass2 = component1.isNestedClass();
            StorageManager storageManager2 = this.this$0.storageManager;
            ClassOrPackageFragmentDescriptor classOrPackageFragmentDescriptor2 = classDescriptor;
            Name shortClassName2 = component1.getShortClassName();
            Intrinsics.checkNotNullExpressionValue(shortClassName2, "classId.shortClassName");
            Integer num2 = (Integer) CollectionsKt.firstOrNull((List) component2);
            return new NotFoundClasses.MockClassDescriptor(storageManager2, classOrPackageFragmentDescriptor2, shortClassName2, isNestedClass2, num2 == null ? num2.intValue() : 0);
        }
        throw new UnsupportedOperationException("Unresolved local class: " + component1);
    }
}
