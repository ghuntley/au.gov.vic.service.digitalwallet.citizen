package kotlin.reflect.jvm.internal;

import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.KProperty;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, d2 = {"<no name provided>", "Ljava/lang/reflect/Type;", "invoke", "kotlin/reflect/jvm/internal/KTypeImpl$arguments$2$1$type$1"}, k = 3, mv = {1, 4, 0})
/* compiled from: KTypeImpl.kt */
public final class KTypeImpl$arguments$2$$special$$inlined$mapIndexed$lambda$1 extends Lambda implements Function0<Type> {
    final /* synthetic */ int $i;
    final /* synthetic */ Lazy $parameterizedTypeArguments$inlined;
    final /* synthetic */ KProperty $parameterizedTypeArguments$metadata$inlined;
    final /* synthetic */ KTypeImpl$arguments$2 this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    KTypeImpl$arguments$2$$special$$inlined$mapIndexed$lambda$1(int i, KTypeImpl$arguments$2 kTypeImpl$arguments$2, Lazy lazy, KProperty kProperty) {
        super(0);
        this.$i = i;
        this.this$0 = kTypeImpl$arguments$2;
        this.$parameterizedTypeArguments$inlined = lazy;
        this.$parameterizedTypeArguments$metadata$inlined = kProperty;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Type invoke() {
        Class<?> cls;
        Class<?> cls2;
        Type javaType = this.this$0.this$0.getJavaType();
        if (javaType instanceof Class) {
            Class cls3 = (Class) javaType;
            if (cls3.isArray()) {
                cls2 = cls3.getComponentType();
                Intrinsics.checkNotNullExpressionValue(cls2, "javaType.componentType");
            } else {
                cls2 = Object.class;
            }
            cls = cls2;
        } else if (javaType instanceof GenericArrayType) {
            if (this.$i == 0) {
                cls = ((GenericArrayType) javaType).getGenericComponentType();
            } else {
                throw new KotlinReflectionInternalError("Array type has been queried for a non-0th argument: " + this.this$0.this$0);
            }
        } else if (javaType instanceof ParameterizedType) {
            cls = (Type) ((List) this.$parameterizedTypeArguments$inlined.getValue()).get(this.$i);
            if (cls instanceof WildcardType) {
                WildcardType wildcardType = (WildcardType) cls;
                Type[] lowerBounds = wildcardType.getLowerBounds();
                Intrinsics.checkNotNullExpressionValue(lowerBounds, "argument.lowerBounds");
                Type type = (Type) ArraysKt.firstOrNull(lowerBounds);
                if (type != null) {
                    cls = type;
                } else {
                    Type[] upperBounds = wildcardType.getUpperBounds();
                    Intrinsics.checkNotNullExpressionValue(upperBounds, "argument.upperBounds");
                    cls = (Type) ArraysKt.first(upperBounds);
                }
            }
        } else {
            throw new KotlinReflectionInternalError("Non-generic type has been queried for arguments: " + this.this$0.this$0);
        }
        Intrinsics.checkNotNullExpressionValue(cls, "when (val javaType = jav…s\")\n                    }");
        return cls;
    }
}
