package com.squareup.moshi;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.internal.Util;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.annotation.Nullable;

/* access modifiers changed from: package-private */
public final class AdapterMethodsFactory implements JsonAdapter.Factory {
    private final List<AdapterMethod> fromAdapters;
    private final List<AdapterMethod> toAdapters;

    AdapterMethodsFactory(List<AdapterMethod> list, List<AdapterMethod> list2) {
        this.toAdapters = list;
        this.fromAdapters = list2;
    }

    @Override // com.squareup.moshi.JsonAdapter.Factory
    @Nullable
    public JsonAdapter<?> create(final Type type, final Set<? extends Annotation> set, final Moshi moshi) {
        final AdapterMethod adapterMethod = get(this.toAdapters, type, set);
        final AdapterMethod adapterMethod2 = get(this.fromAdapters, type, set);
        final JsonAdapter jsonAdapter = null;
        if (adapterMethod == null && adapterMethod2 == null) {
            return null;
        }
        if (adapterMethod == null || adapterMethod2 == null) {
            try {
                jsonAdapter = moshi.nextAdapter(this, type, set);
            } catch (IllegalArgumentException e) {
                String str = adapterMethod == null ? "@ToJson" : "@FromJson";
                throw new IllegalArgumentException("No " + str + " adapter for " + Util.typeAnnotatedWithAnnotations(type, set), e);
            }
        }
        if (adapterMethod != null) {
            adapterMethod.bind(moshi, this);
        }
        if (adapterMethod2 != null) {
            adapterMethod2.bind(moshi, this);
        }
        return new JsonAdapter<Object>() {
            /* class com.squareup.moshi.AdapterMethodsFactory.AnonymousClass1 */

            @Override // com.squareup.moshi.JsonAdapter
            public void toJson(JsonWriter jsonWriter, @Nullable Object obj) throws IOException {
                AdapterMethod adapterMethod = adapterMethod;
                if (adapterMethod == null) {
                    jsonAdapter.toJson(jsonWriter, obj);
                } else if (adapterMethod.nullable || obj != null) {
                    try {
                        adapterMethod.toJson(moshi, jsonWriter, obj);
                    } catch (InvocationTargetException e) {
                        Throwable cause = e.getCause();
                        if (cause instanceof IOException) {
                            throw ((IOException) cause);
                        }
                        throw new JsonDataException(cause + " at " + jsonWriter.getPath(), cause);
                    }
                } else {
                    jsonWriter.nullValue();
                }
            }

            @Override // com.squareup.moshi.JsonAdapter
            @Nullable
            public Object fromJson(JsonReader jsonReader) throws IOException {
                AdapterMethod adapterMethod = adapterMethod2;
                if (adapterMethod == null) {
                    return jsonAdapter.fromJson(jsonReader);
                }
                if (adapterMethod.nullable || jsonReader.peek() != JsonReader.Token.NULL) {
                    try {
                        return adapterMethod2.fromJson(moshi, jsonReader);
                    } catch (InvocationTargetException e) {
                        Throwable cause = e.getCause();
                        if (cause instanceof IOException) {
                            throw ((IOException) cause);
                        }
                        throw new JsonDataException(cause + " at " + jsonReader.getPath(), cause);
                    }
                } else {
                    jsonReader.nextNull();
                    return null;
                }
            }

            public String toString() {
                return "JsonAdapter" + set + "(" + type + ")";
            }
        };
    }

    public static AdapterMethodsFactory get(Object obj) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (Class<?> cls = obj.getClass(); cls != Object.class; cls = cls.getSuperclass()) {
            Method[] declaredMethods = cls.getDeclaredMethods();
            for (Method method : declaredMethods) {
                if (method.isAnnotationPresent(ToJson.class)) {
                    AdapterMethod adapter = toAdapter(obj, method);
                    AdapterMethod adapterMethod = get(arrayList, adapter.type, adapter.annotations);
                    if (adapterMethod == null) {
                        arrayList.add(adapter);
                    } else {
                        throw new IllegalArgumentException("Conflicting @ToJson methods:\n    " + adapterMethod.method + "\n    " + adapter.method);
                    }
                }
                if (method.isAnnotationPresent(FromJson.class)) {
                    AdapterMethod fromAdapter = fromAdapter(obj, method);
                    AdapterMethod adapterMethod2 = get(arrayList2, fromAdapter.type, fromAdapter.annotations);
                    if (adapterMethod2 == null) {
                        arrayList2.add(fromAdapter);
                    } else {
                        throw new IllegalArgumentException("Conflicting @FromJson methods:\n    " + adapterMethod2.method + "\n    " + fromAdapter.method);
                    }
                }
            }
        }
        if (!arrayList.isEmpty() || !arrayList2.isEmpty()) {
            return new AdapterMethodsFactory(arrayList, arrayList2);
        }
        throw new IllegalArgumentException("Expected at least one @ToJson or @FromJson method on " + obj.getClass().getName());
    }

    static AdapterMethod toAdapter(Object obj, Method method) {
        method.setAccessible(true);
        final Type genericReturnType = method.getGenericReturnType();
        final Type[] genericParameterTypes = method.getGenericParameterTypes();
        Annotation[][] parameterAnnotations = method.getParameterAnnotations();
        if (genericParameterTypes.length >= 2 && genericParameterTypes[0] == JsonWriter.class && genericReturnType == Void.TYPE && parametersAreJsonAdapters(2, genericParameterTypes)) {
            return new AdapterMethod(genericParameterTypes[1], Util.jsonAnnotations(parameterAnnotations[1]), obj, method, genericParameterTypes.length, 2, true) {
                /* class com.squareup.moshi.AdapterMethodsFactory.AnonymousClass2 */

                @Override // com.squareup.moshi.AdapterMethodsFactory.AdapterMethod
                public void toJson(Moshi moshi, JsonWriter jsonWriter, @Nullable Object obj) throws IOException, InvocationTargetException {
                    invoke(jsonWriter, obj);
                }
            };
        } else if (genericParameterTypes.length != 1 || genericReturnType == Void.TYPE) {
            throw new IllegalArgumentException("Unexpected signature for " + method + ".\n@ToJson method signatures may have one of the following structures:\n    <any access modifier> void toJson(JsonWriter writer, T value) throws <any>;\n    <any access modifier> void toJson(JsonWriter writer, T value, JsonAdapter<any> delegate, <any more delegates>) throws <any>;\n    <any access modifier> R toJson(T value) throws <any>;\n");
        } else {
            final Set<? extends Annotation> jsonAnnotations = Util.jsonAnnotations(method);
            final Set<? extends Annotation> jsonAnnotations2 = Util.jsonAnnotations(parameterAnnotations[0]);
            return new AdapterMethod(genericParameterTypes[0], obj, method, genericParameterTypes.length, 1, Util.hasNullable(parameterAnnotations[0]), jsonAnnotations2) {
                /* class com.squareup.moshi.AdapterMethodsFactory.AnonymousClass3 */
                private JsonAdapter<Object> delegate;

                @Override // com.squareup.moshi.AdapterMethodsFactory.AdapterMethod
                public void bind(Moshi moshi, JsonAdapter.Factory factory) {
                    JsonAdapter<Object> jsonAdapter;
                    super.bind(moshi, factory);
                    if (!Types.equals(genericParameterTypes[0], genericReturnType) || !jsonAnnotations2.equals(jsonAnnotations)) {
                        jsonAdapter = moshi.adapter(genericReturnType, jsonAnnotations);
                    } else {
                        jsonAdapter = moshi.nextAdapter(factory, genericReturnType, jsonAnnotations);
                    }
                    this.delegate = jsonAdapter;
                }

                @Override // com.squareup.moshi.AdapterMethodsFactory.AdapterMethod
                public void toJson(Moshi moshi, JsonWriter jsonWriter, @Nullable Object obj) throws IOException, InvocationTargetException {
                    this.delegate.toJson(jsonWriter, invoke(obj));
                }
            };
        }
    }

    private static boolean parametersAreJsonAdapters(int i, Type[] typeArr) {
        int length = typeArr.length;
        while (i < length) {
            if (!(typeArr[i] instanceof ParameterizedType) || ((ParameterizedType) typeArr[i]).getRawType() != JsonAdapter.class) {
                return false;
            }
            i++;
        }
        return true;
    }

    static AdapterMethod fromAdapter(Object obj, Method method) {
        method.setAccessible(true);
        final Type genericReturnType = method.getGenericReturnType();
        final Set<? extends Annotation> jsonAnnotations = Util.jsonAnnotations(method);
        final Type[] genericParameterTypes = method.getGenericParameterTypes();
        Annotation[][] parameterAnnotations = method.getParameterAnnotations();
        if (genericParameterTypes.length >= 1 && genericParameterTypes[0] == JsonReader.class && genericReturnType != Void.TYPE && parametersAreJsonAdapters(1, genericParameterTypes)) {
            return new AdapterMethod(genericReturnType, jsonAnnotations, obj, method, genericParameterTypes.length, 1, true) {
                /* class com.squareup.moshi.AdapterMethodsFactory.AnonymousClass4 */

                @Override // com.squareup.moshi.AdapterMethodsFactory.AdapterMethod
                public Object fromJson(Moshi moshi, JsonReader jsonReader) throws IOException, InvocationTargetException {
                    return invoke(jsonReader);
                }
            };
        }
        if (genericParameterTypes.length != 1 || genericReturnType == Void.TYPE) {
            throw new IllegalArgumentException("Unexpected signature for " + method + ".\n@FromJson method signatures may have one of the following structures:\n    <any access modifier> R fromJson(JsonReader jsonReader) throws <any>;\n    <any access modifier> R fromJson(JsonReader jsonReader, JsonAdapter<any> delegate, <any more delegates>) throws <any>;\n    <any access modifier> R fromJson(T value) throws <any>;\n");
        }
        final Set<? extends Annotation> jsonAnnotations2 = Util.jsonAnnotations(parameterAnnotations[0]);
        return new AdapterMethod(obj, method, genericParameterTypes.length, 1, Util.hasNullable(parameterAnnotations[0]), genericReturnType, jsonAnnotations) {
            /* class com.squareup.moshi.AdapterMethodsFactory.AnonymousClass5 */
            JsonAdapter<Object> delegate;

            @Override // com.squareup.moshi.AdapterMethodsFactory.AdapterMethod
            public void bind(Moshi moshi, JsonAdapter.Factory factory) {
                JsonAdapter<Object> jsonAdapter;
                super.bind(moshi, factory);
                if (!Types.equals(genericParameterTypes[0], genericReturnType) || !jsonAnnotations2.equals(jsonAnnotations)) {
                    jsonAdapter = moshi.adapter(genericParameterTypes[0], jsonAnnotations2);
                } else {
                    jsonAdapter = moshi.nextAdapter(factory, genericParameterTypes[0], jsonAnnotations2);
                }
                this.delegate = jsonAdapter;
            }

            @Override // com.squareup.moshi.AdapterMethodsFactory.AdapterMethod
            public Object fromJson(Moshi moshi, JsonReader jsonReader) throws IOException, InvocationTargetException {
                return invoke(this.delegate.fromJson(jsonReader));
            }
        };
    }

    @Nullable
    private static AdapterMethod get(List<AdapterMethod> list, Type type, Set<? extends Annotation> set) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            AdapterMethod adapterMethod = list.get(i);
            if (Types.equals(adapterMethod.type, type) && adapterMethod.annotations.equals(set)) {
                return adapterMethod;
            }
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public static abstract class AdapterMethod {
        final Object adapter;
        final int adaptersOffset;
        final Set<? extends Annotation> annotations;
        final JsonAdapter<?>[] jsonAdapters;
        final Method method;
        final boolean nullable;
        final Type type;

        AdapterMethod(Type type2, Set<? extends Annotation> set, Object obj, Method method2, int i, int i2, boolean z) {
            this.type = Util.canonicalize(type2);
            this.annotations = set;
            this.adapter = obj;
            this.method = method2;
            this.adaptersOffset = i2;
            this.jsonAdapters = new JsonAdapter[(i - i2)];
            this.nullable = z;
        }

        public void bind(Moshi moshi, JsonAdapter.Factory factory) {
            JsonAdapter<?> jsonAdapter;
            if (this.jsonAdapters.length > 0) {
                Type[] genericParameterTypes = this.method.getGenericParameterTypes();
                Annotation[][] parameterAnnotations = this.method.getParameterAnnotations();
                int length = genericParameterTypes.length;
                for (int i = this.adaptersOffset; i < length; i++) {
                    Type type2 = ((ParameterizedType) genericParameterTypes[i]).getActualTypeArguments()[0];
                    Set<? extends Annotation> jsonAnnotations = Util.jsonAnnotations(parameterAnnotations[i]);
                    JsonAdapter<?>[] jsonAdapterArr = this.jsonAdapters;
                    int i2 = i - this.adaptersOffset;
                    if (!Types.equals(this.type, type2) || !this.annotations.equals(jsonAnnotations)) {
                        jsonAdapter = moshi.adapter(type2, jsonAnnotations);
                    } else {
                        jsonAdapter = moshi.nextAdapter(factory, type2, jsonAnnotations);
                    }
                    jsonAdapterArr[i2] = jsonAdapter;
                }
            }
        }

        public void toJson(Moshi moshi, JsonWriter jsonWriter, @Nullable Object obj) throws IOException, InvocationTargetException {
            throw new AssertionError();
        }

        @Nullable
        public Object fromJson(Moshi moshi, JsonReader jsonReader) throws IOException, InvocationTargetException {
            throw new AssertionError();
        }

        /* access modifiers changed from: protected */
        @Nullable
        public Object invoke(@Nullable Object obj) throws InvocationTargetException {
            JsonAdapter<?>[] jsonAdapterArr = this.jsonAdapters;
            Object[] objArr = new Object[(jsonAdapterArr.length + 1)];
            objArr[0] = obj;
            System.arraycopy(jsonAdapterArr, 0, objArr, 1, jsonAdapterArr.length);
            try {
                return this.method.invoke(this.adapter, objArr);
            } catch (IllegalAccessException unused) {
                throw new AssertionError();
            }
        }

        /* access modifiers changed from: protected */
        public Object invoke(@Nullable Object obj, @Nullable Object obj2) throws InvocationTargetException {
            JsonAdapter<?>[] jsonAdapterArr = this.jsonAdapters;
            Object[] objArr = new Object[(jsonAdapterArr.length + 2)];
            objArr[0] = obj;
            objArr[1] = obj2;
            System.arraycopy(jsonAdapterArr, 0, objArr, 2, jsonAdapterArr.length);
            try {
                return this.method.invoke(this.adapter, objArr);
            } catch (IllegalAccessException unused) {
                throw new AssertionError();
            }
        }
    }
}
