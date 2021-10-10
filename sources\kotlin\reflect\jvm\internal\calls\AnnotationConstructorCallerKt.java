package kotlin.reflect.jvm.internal.calls;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.text.Typography;

public final class AnnotationConstructorCallerKt {
    public static final Object transformKotlinToJvm(Object obj, Class<?> cls) {
        if (obj instanceof Class) {
            return null;
        }
        if (obj instanceof KClass) {
            obj = JvmClassMappingKt.getJavaClass((KClass) obj);
        } else if (obj instanceof Object[]) {
            Object[] objArr = (Object[]) obj;
            if (objArr instanceof Class[]) {
                return null;
            }
            if (objArr instanceof KClass[]) {
                Objects.requireNonNull(obj, "null cannot be cast to non-null type kotlin.Array<kotlin.reflect.KClass<*>>");
                KClass[] kClassArr = (KClass[]) obj;
                ArrayList arrayList = new ArrayList(kClassArr.length);
                for (KClass kClass : kClassArr) {
                    arrayList.add(JvmClassMappingKt.getJavaClass(kClass));
                }
                obj = arrayList.toArray(new Class[0]);
                Objects.requireNonNull(obj, "null cannot be cast to non-null type kotlin.Array<T>");
            } else {
                obj = objArr;
            }
        }
        if (cls.isInstance(obj)) {
            return obj;
        }
        return null;
    }

    public static final Void throwIllegalArgumentType(int i, String str, Class<?> cls) {
        KClass kClass;
        String str2;
        if (Intrinsics.areEqual(cls, Class.class)) {
            kClass = Reflection.getOrCreateKotlinClass(KClass.class);
        } else if (!cls.isArray() || !Intrinsics.areEqual(cls.getComponentType(), Class.class)) {
            kClass = JvmClassMappingKt.getKotlinClass(cls);
        } else {
            kClass = Reflection.getOrCreateKotlinClass(KClass[].class);
        }
        if (Intrinsics.areEqual(kClass.getQualifiedName(), Reflection.getOrCreateKotlinClass(Object[].class).getQualifiedName())) {
            str2 = kClass.getQualifiedName() + Typography.less + JvmClassMappingKt.getKotlinClass(JvmClassMappingKt.getJavaClass(kClass).getComponentType()).getQualifiedName() + Typography.greater;
        } else {
            str2 = kClass.getQualifiedName();
        }
        throw new IllegalArgumentException("Argument #" + i + ' ' + str + " is not of the required type " + str2);
    }

    public static /* synthetic */ Object createAnnotationInstance$default(Class cls, Map map, List list, int i, Object obj) {
        if ((i & 4) != 0) {
            Set<String> keySet = map.keySet();
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(keySet, 10));
            for (String str : keySet) {
                arrayList.add(cls.getDeclaredMethod(str, new Class[0]));
            }
            list = arrayList;
        }
        return createAnnotationInstance(cls, map, list);
    }

    public static final <T> T createAnnotationInstance(Class<T> cls, Map<String, ? extends Object> map, List<Method> list) {
        Intrinsics.checkNotNullParameter(cls, "annotationClass");
        Intrinsics.checkNotNullParameter(map, "values");
        Intrinsics.checkNotNullParameter(list, "methods");
        AnnotationConstructorCallerKt$createAnnotationInstance$2 annotationConstructorCallerKt$createAnnotationInstance$2 = new AnnotationConstructorCallerKt$createAnnotationInstance$2(cls, list, map);
        Lazy lazy = LazyKt.lazy(new AnnotationConstructorCallerKt$createAnnotationInstance$hashCode$2(map));
        Lazy lazy2 = LazyKt.lazy(new AnnotationConstructorCallerKt$createAnnotationInstance$toString$2(cls, map));
        T t = (T) Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, new AnnotationConstructorCallerKt$createAnnotationInstance$result$1(cls, lazy2, null, lazy, null, annotationConstructorCallerKt$createAnnotationInstance$2, map));
        Objects.requireNonNull(t, "null cannot be cast to non-null type T");
        return t;
    }
}
