package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaTypeParameter;

/* access modifiers changed from: package-private */
/* compiled from: LazyJavaClassDescriptor.kt */
public final class LazyJavaClassDescriptor$declaredParameters$1 extends Lambda implements Function0<List<? extends TypeParameterDescriptor>> {
    final /* synthetic */ LazyJavaClassDescriptor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LazyJavaClassDescriptor$declaredParameters$1(LazyJavaClassDescriptor lazyJavaClassDescriptor) {
        super(0);
        this.this$0 = lazyJavaClassDescriptor;
    }

    /* Return type fixed from 'java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor>' to match base method */
    @Override // kotlin.jvm.functions.Function0
    public final List<? extends TypeParameterDescriptor> invoke() {
        List<JavaTypeParameter> typeParameters = this.this$0.getJClass().getTypeParameters();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(typeParameters, 10));
        for (T t : typeParameters) {
            TypeParameterDescriptor resolveTypeParameter = this.this$0.c.getTypeParameterResolver().resolveTypeParameter(t);
            if (resolveTypeParameter != null) {
                arrayList.add(resolveTypeParameter);
            } else {
                throw new AssertionError("Parameter " + ((Object) t) + " surely belongs to class " + this.this$0.getJClass() + ", so it must be resolved");
            }
        }
        return arrayList;
    }
}
