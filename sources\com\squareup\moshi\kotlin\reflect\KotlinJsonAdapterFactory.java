package com.squareup.moshi.kotlin.reflect;

import com.squareup.moshi.Json;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.Moshi;
import com.squareup.moshi._MoshiKotlinTypesExtensionsKt;
import com.squareup.moshi.internal.Util;
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapter;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.ranges.RangesKt;
import kotlin.reflect.KClass;
import kotlin.reflect.KFunction;
import kotlin.reflect.KMutableProperty1;
import kotlin.reflect.KParameter;
import kotlin.reflect.KProperty1;
import kotlin.reflect.full.KClasses;
import kotlin.reflect.jvm.KCallablesJvm;
import kotlin.reflect.jvm.ReflectJvmMapping;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0002\u0010\u001b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J.\u0010\u0003\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u000e\u0010\u0007\u001a\n\u0012\u0006\b\u0001\u0012\u00020\t0\b2\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\f"}, d2 = {"Lcom/squareup/moshi/kotlin/reflect/KotlinJsonAdapterFactory;", "Lcom/squareup/moshi/JsonAdapter$Factory;", "()V", "create", "Lcom/squareup/moshi/JsonAdapter;", "type", "Ljava/lang/reflect/Type;", "annotations", "", "", "moshi", "Lcom/squareup/moshi/Moshi;", "reflect"}, k = 1, mv = {1, 4, 0})
/* compiled from: KotlinJsonAdapter.kt */
public final class KotlinJsonAdapterFactory implements JsonAdapter.Factory {
    /* JADX DEBUG: Multi-variable search result rejected for r3v3, resolved type: boolean */
    /* JADX DEBUG: Multi-variable search result rejected for r3v4, resolved type: boolean */
    /* JADX DEBUG: Multi-variable search result rejected for r3v18, resolved type: boolean */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.squareup.moshi.JsonAdapter.Factory
    public JsonAdapter<?> create(Type type, Set<? extends Annotation> set, Moshi moshi) {
        int i;
        T t;
        String str;
        String str2;
        int i2;
        T t2;
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(set, "annotations");
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        boolean z = 1;
        T t3 = null;
        if (!set.isEmpty()) {
            return null;
        }
        Class<?> rawType = _MoshiKotlinTypesExtensionsKt.getRawType(type);
        if (rawType.isInterface() || rawType.isEnum() || !rawType.isAnnotationPresent(KotlinJsonAdapterKt.access$getKOTLIN_METADATA$p()) || Util.isPlatformType(rawType)) {
            return null;
        }
        try {
            JsonAdapter<?> generatedAdapter = Util.generatedAdapter(moshi, type, rawType);
            if (generatedAdapter != null) {
                return generatedAdapter;
            }
        } catch (RuntimeException e) {
            if (!(e.getCause() instanceof ClassNotFoundException)) {
                throw e;
            }
        }
        if (!rawType.isLocalClass()) {
            KClass kotlinClass = JvmClassMappingKt.getKotlinClass(rawType);
            if (!(!kotlinClass.isAbstract())) {
                throw new IllegalArgumentException(("Cannot serialize abstract class " + rawType.getName()).toString());
            } else if (!kotlinClass.isInner()) {
                int i3 = 0;
                if ((kotlinClass.getObjectInstance() == null ? 1 : null) == null) {
                    throw new IllegalArgumentException(("Cannot serialize object declaration " + rawType.getName()).toString());
                } else if (!kotlinClass.isSealed()) {
                    KFunction primaryConstructor = KClasses.getPrimaryConstructor(kotlinClass);
                    if (primaryConstructor == null) {
                        return null;
                    }
                    List<KParameter> parameters = primaryConstructor.getParameters();
                    LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(parameters, 10)), 16));
                    for (T t4 : parameters) {
                        linkedHashMap.put(t4.getName(), t4);
                    }
                    KCallablesJvm.setAccessible(primaryConstructor, true);
                    LinkedHashMap linkedHashMap2 = new LinkedHashMap();
                    for (KProperty1 kProperty1 : KClasses.getMemberProperties(kotlinClass)) {
                        KParameter kParameter = (KParameter) linkedHashMap.get(kProperty1.getName());
                        Field javaField = ReflectJvmMapping.getJavaField(kProperty1);
                        if (Modifier.isTransient(javaField != null ? javaField.getModifiers() : i3)) {
                            if (((kParameter == null || kParameter.isOptional()) ? z : i3) == 0) {
                                throw new IllegalArgumentException(("No default value for transient constructor " + kParameter).toString());
                            }
                        } else {
                            if (kParameter == null || Intrinsics.areEqual(kParameter.getType(), kProperty1.getReturnType())) {
                                int i4 = z ? 1 : 0;
                                Object[] objArr = z ? 1 : 0;
                                Object[] objArr2 = z ? 1 : 0;
                                i = i4;
                            } else {
                                i = i3;
                            }
                            if (i == 0) {
                                StringBuilder sb = new StringBuilder();
                                sb.append('\'');
                                sb.append(kProperty1.getName());
                                sb.append("' has a constructor parameter of type ");
                                Intrinsics.checkNotNull(kParameter);
                                sb.append(kParameter.getType());
                                sb.append(" but a property of type ");
                                sb.append(kProperty1.getReturnType());
                                sb.append('.');
                                throw new IllegalArgumentException(sb.toString().toString());
                            } else if ((kProperty1 instanceof KMutableProperty1) || kParameter != null) {
                                KCallablesJvm.setAccessible(kProperty1, z);
                                List mutableList = CollectionsKt.toMutableList((Collection) kProperty1.getAnnotations());
                                Iterator<T> it = kProperty1.getAnnotations().iterator();
                                while (true) {
                                    if (!it.hasNext()) {
                                        t = t3;
                                        break;
                                    }
                                    t = it.next();
                                    if (t instanceof Json) {
                                        break;
                                    }
                                }
                                T t5 = t;
                                if (kParameter != null) {
                                    CollectionsKt.addAll(mutableList, kParameter.getAnnotations());
                                    if (t5 == null) {
                                        Iterator<T> it2 = kParameter.getAnnotations().iterator();
                                        while (true) {
                                            if (!it2.hasNext()) {
                                                t2 = null;
                                                break;
                                            }
                                            t2 = it2.next();
                                            if (t2 instanceof Json) {
                                                break;
                                            }
                                        }
                                        t5 = t2;
                                    }
                                }
                                if (t5 == null || (str = t5.name()) == null) {
                                    str = kProperty1.getName();
                                }
                                Type resolve = Util.resolve(type, rawType, ReflectJvmMapping.getJavaType(kProperty1.getReturnType()));
                                Object[] array = mutableList.toArray(new Annotation[i3]);
                                Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
                                JsonAdapter adapter = moshi.adapter(resolve, Util.jsonAnnotations((Annotation[]) array), kProperty1.getName());
                                LinkedHashMap linkedHashMap3 = linkedHashMap2;
                                String name = kProperty1.getName();
                                if (t5 == null || (str2 = t5.name()) == null) {
                                    str2 = str;
                                }
                                Intrinsics.checkNotNullExpressionValue(adapter, "adapter");
                                Objects.requireNonNull(kProperty1, "null cannot be cast to non-null type kotlin.reflect.KProperty1<kotlin.Any, kotlin.Any?>");
                                if (kParameter != null) {
                                    i2 = kParameter.getIndex();
                                } else {
                                    i2 = -1;
                                }
                                linkedHashMap3.put(name, new KotlinJsonAdapter.Binding(str, str2, adapter, kProperty1, kParameter, i2));
                            }
                        }
                        z = 1;
                        t3 = null;
                        i3 = 0;
                    }
                    ArrayList arrayList = new ArrayList();
                    for (KParameter kParameter2 : primaryConstructor.getParameters()) {
                        KotlinJsonAdapter.Binding binding = (KotlinJsonAdapter.Binding) TypeIntrinsics.asMutableMap(linkedHashMap2).remove(kParameter2.getName());
                        if (binding != null || kParameter2.isOptional()) {
                            arrayList.add(binding);
                        } else {
                            throw new IllegalArgumentException(("No property for required constructor " + kParameter2).toString());
                        }
                    }
                    int size = arrayList.size();
                    for (Map.Entry entry : linkedHashMap2.entrySet()) {
                        size++;
                        arrayList.add(KotlinJsonAdapter.Binding.copy$default((KotlinJsonAdapter.Binding) entry.getValue(), null, null, null, null, null, size, 31, null));
                    }
                    List filterNotNull = CollectionsKt.filterNotNull(arrayList);
                    List<KotlinJsonAdapter.Binding> list = filterNotNull;
                    ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
                    for (KotlinJsonAdapter.Binding binding2 : list) {
                        arrayList2.add(binding2.getName());
                    }
                    Object[] array2 = arrayList2.toArray(new String[0]);
                    Objects.requireNonNull(array2, "null cannot be cast to non-null type kotlin.Array<T>");
                    String[] strArr = (String[]) array2;
                    JsonReader.Options of = JsonReader.Options.of((String[]) Arrays.copyOf(strArr, strArr.length));
                    Intrinsics.checkNotNullExpressionValue(of, "options");
                    return new KotlinJsonAdapter(primaryConstructor, arrayList, filterNotNull, of).nullSafe();
                } else {
                    throw new IllegalArgumentException(("Cannot reflectively serialize sealed class " + rawType.getName() + ". Please register an adapter.").toString());
                }
            } else {
                throw new IllegalArgumentException(("Cannot serialize inner class " + rawType.getName()).toString());
            }
        } else {
            throw new IllegalArgumentException(("Cannot serialize local class or object expression " + rawType.getName()).toString());
        }
    }
}
