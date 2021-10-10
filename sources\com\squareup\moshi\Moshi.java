package com.squareup.moshi;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.internal.Util;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nullable;

public final class Moshi {
    static final List<JsonAdapter.Factory> BUILT_IN_FACTORIES;
    private final Map<Object, JsonAdapter<?>> adapterCache = new LinkedHashMap();
    private final List<JsonAdapter.Factory> factories;
    private final int lastOffset;
    private final ThreadLocal<LookupChain> lookupChainThreadLocal = new ThreadLocal<>();

    static {
        ArrayList arrayList = new ArrayList(5);
        BUILT_IN_FACTORIES = arrayList;
        arrayList.add(StandardJsonAdapters.FACTORY);
        arrayList.add(CollectionJsonAdapter.FACTORY);
        arrayList.add(MapJsonAdapter.FACTORY);
        arrayList.add(ArrayJsonAdapter.FACTORY);
        arrayList.add(ClassJsonAdapter.FACTORY);
    }

    Moshi(Builder builder) {
        int size = builder.factories.size();
        List<JsonAdapter.Factory> list = BUILT_IN_FACTORIES;
        ArrayList arrayList = new ArrayList(size + list.size());
        arrayList.addAll(builder.factories);
        arrayList.addAll(list);
        this.factories = Collections.unmodifiableList(arrayList);
        this.lastOffset = builder.lastOffset;
    }

    @CheckReturnValue
    public <T> JsonAdapter<T> adapter(Type type) {
        return adapter(type, Util.NO_ANNOTATIONS);
    }

    @CheckReturnValue
    public <T> JsonAdapter<T> adapter(Class<T> cls) {
        return adapter(cls, Util.NO_ANNOTATIONS);
    }

    @CheckReturnValue
    public <T> JsonAdapter<T> adapter(Type type, Class<? extends Annotation> cls) {
        Objects.requireNonNull(cls, "annotationType == null");
        return adapter(type, Collections.singleton(Types.createJsonQualifierImplementation(cls)));
    }

    @CheckReturnValue
    public <T> JsonAdapter<T> adapter(Type type, Class<? extends Annotation>... clsArr) {
        if (clsArr.length == 1) {
            return adapter(type, clsArr[0]);
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet(clsArr.length);
        for (Class<? extends Annotation> cls : clsArr) {
            linkedHashSet.add(Types.createJsonQualifierImplementation(cls));
        }
        return adapter(type, Collections.unmodifiableSet(linkedHashSet));
    }

    @CheckReturnValue
    public <T> JsonAdapter<T> adapter(Type type, Set<? extends Annotation> set) {
        return adapter(type, set, null);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0030, code lost:
        r1 = new com.squareup.moshi.Moshi.LookupChain(r4);
        r4.lookupChainThreadLocal.set(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x003a, code lost:
        r7 = r1.push(r5, r7, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x003f, code lost:
        if (r7 == null) goto L_0x0045;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0041, code lost:
        r1.pop(false);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0044, code lost:
        return r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:?, code lost:
        r7 = r4.factories.size();
        r2 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x004c, code lost:
        if (r2 >= r7) goto L_0x0067;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x004e, code lost:
        r3 = (com.squareup.moshi.JsonAdapter<T>) r4.factories.get(r2).create(r5, r6, r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x005a, code lost:
        if (r3 != null) goto L_0x005f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x005c, code lost:
        r2 = r2 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x005f, code lost:
        r1.adapterFound(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0062, code lost:
        r1.pop(true);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0066, code lost:
        return r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0081, code lost:
        throw new java.lang.IllegalArgumentException("No JsonAdapter for " + com.squareup.moshi.internal.Util.typeAnnotatedWithAnnotations(r5, r6));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0082, code lost:
        r5 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0084, code lost:
        r5 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0089, code lost:
        throw r1.exceptionWithLookupStack(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x008a, code lost:
        r1.pop(false);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x008d, code lost:
        throw r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0026, code lost:
        r1 = r4.lookupChainThreadLocal.get();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x002e, code lost:
        if (r1 != null) goto L_0x003a;
     */
    @CheckReturnValue
    public <T> JsonAdapter<T> adapter(Type type, Set<? extends Annotation> set, @Nullable String str) {
        Objects.requireNonNull(type, "type == null");
        Objects.requireNonNull(set, "annotations == null");
        Type removeSubtypeWildcard = Util.removeSubtypeWildcard(Util.canonicalize(type));
        Object cacheKey = cacheKey(removeSubtypeWildcard, set);
        synchronized (this.adapterCache) {
            JsonAdapter<T> jsonAdapter = (JsonAdapter<T>) this.adapterCache.get(cacheKey);
            if (jsonAdapter != null) {
                return jsonAdapter;
            }
        }
    }

    @CheckReturnValue
    public <T> JsonAdapter<T> nextAdapter(JsonAdapter.Factory factory, Type type, Set<? extends Annotation> set) {
        Objects.requireNonNull(set, "annotations == null");
        Type removeSubtypeWildcard = Util.removeSubtypeWildcard(Util.canonicalize(type));
        int indexOf = this.factories.indexOf(factory);
        if (indexOf != -1) {
            int size = this.factories.size();
            for (int i = indexOf + 1; i < size; i++) {
                JsonAdapter<T> jsonAdapter = (JsonAdapter<T>) this.factories.get(i).create(removeSubtypeWildcard, set, this);
                if (jsonAdapter != null) {
                    return jsonAdapter;
                }
            }
            throw new IllegalArgumentException("No next JsonAdapter for " + Util.typeAnnotatedWithAnnotations(removeSubtypeWildcard, set));
        }
        throw new IllegalArgumentException("Unable to skip past unknown factory " + factory);
    }

    @CheckReturnValue
    public Builder newBuilder() {
        Builder builder = new Builder();
        int i = this.lastOffset;
        for (int i2 = 0; i2 < i; i2++) {
            builder.add(this.factories.get(i2));
        }
        int size = this.factories.size() - BUILT_IN_FACTORIES.size();
        for (int i3 = this.lastOffset; i3 < size; i3++) {
            builder.addLast(this.factories.get(i3));
        }
        return builder;
    }

    private Object cacheKey(Type type, Set<? extends Annotation> set) {
        if (set.isEmpty()) {
            return type;
        }
        return Arrays.asList(type, set);
    }

    public static final class Builder {
        final List<JsonAdapter.Factory> factories = new ArrayList();
        int lastOffset = 0;

        public <T> Builder add(Type type, JsonAdapter<T> jsonAdapter) {
            return add(Moshi.newAdapterFactory(type, jsonAdapter));
        }

        public <T> Builder add(Type type, Class<? extends Annotation> cls, JsonAdapter<T> jsonAdapter) {
            return add(Moshi.newAdapterFactory(type, cls, jsonAdapter));
        }

        public Builder add(JsonAdapter.Factory factory) {
            if (factory != null) {
                List<JsonAdapter.Factory> list = this.factories;
                int i = this.lastOffset;
                this.lastOffset = i + 1;
                list.add(i, factory);
                return this;
            }
            throw new IllegalArgumentException("factory == null");
        }

        public Builder add(Object obj) {
            if (obj != null) {
                return add((JsonAdapter.Factory) AdapterMethodsFactory.get(obj));
            }
            throw new IllegalArgumentException("adapter == null");
        }

        public <T> Builder addLast(Type type, JsonAdapter<T> jsonAdapter) {
            return addLast(Moshi.newAdapterFactory(type, jsonAdapter));
        }

        public <T> Builder addLast(Type type, Class<? extends Annotation> cls, JsonAdapter<T> jsonAdapter) {
            return addLast(Moshi.newAdapterFactory(type, cls, jsonAdapter));
        }

        public Builder addLast(JsonAdapter.Factory factory) {
            if (factory != null) {
                this.factories.add(factory);
                return this;
            }
            throw new IllegalArgumentException("factory == null");
        }

        public Builder addLast(Object obj) {
            if (obj != null) {
                return addLast((JsonAdapter.Factory) AdapterMethodsFactory.get(obj));
            }
            throw new IllegalArgumentException("adapter == null");
        }

        @CheckReturnValue
        public Moshi build() {
            return new Moshi(this);
        }
    }

    static <T> JsonAdapter.Factory newAdapterFactory(final Type type, final JsonAdapter<T> jsonAdapter) {
        if (type == null) {
            throw new IllegalArgumentException("type == null");
        } else if (jsonAdapter != null) {
            return new JsonAdapter.Factory() {
                /* class com.squareup.moshi.Moshi.AnonymousClass1 */

                @Override // com.squareup.moshi.JsonAdapter.Factory
                @Nullable
                public JsonAdapter<?> create(Type type, Set<? extends Annotation> set, Moshi moshi) {
                    if (!set.isEmpty() || !Util.typesMatch(type, type)) {
                        return null;
                    }
                    return jsonAdapter;
                }
            };
        } else {
            throw new IllegalArgumentException("jsonAdapter == null");
        }
    }

    static <T> JsonAdapter.Factory newAdapterFactory(final Type type, final Class<? extends Annotation> cls, final JsonAdapter<T> jsonAdapter) {
        if (type == null) {
            throw new IllegalArgumentException("type == null");
        } else if (cls == null) {
            throw new IllegalArgumentException("annotation == null");
        } else if (jsonAdapter == null) {
            throw new IllegalArgumentException("jsonAdapter == null");
        } else if (!cls.isAnnotationPresent(JsonQualifier.class)) {
            throw new IllegalArgumentException(cls + " does not have @JsonQualifier");
        } else if (cls.getDeclaredMethods().length <= 0) {
            return new JsonAdapter.Factory() {
                /* class com.squareup.moshi.Moshi.AnonymousClass2 */

                @Override // com.squareup.moshi.JsonAdapter.Factory
                @Nullable
                public JsonAdapter<?> create(Type type, Set<? extends Annotation> set, Moshi moshi) {
                    if (!Util.typesMatch(type, type) || set.size() != 1 || !Util.isAnnotationPresent(set, cls)) {
                        return null;
                    }
                    return jsonAdapter;
                }
            };
        } else {
            throw new IllegalArgumentException("Use JsonAdapter.Factory for annotations with elements");
        }
    }

    /* access modifiers changed from: package-private */
    public final class LookupChain {
        final List<Lookup<?>> callLookups = new ArrayList();
        boolean exceptionAnnotated;
        final Deque<Lookup<?>> stack = new ArrayDeque();

        LookupChain() {
        }

        /* access modifiers changed from: package-private */
        public <T> JsonAdapter<T> push(Type type, @Nullable String str, Object obj) {
            int size = this.callLookups.size();
            for (int i = 0; i < size; i++) {
                Lookup<?> lookup = this.callLookups.get(i);
                if (lookup.cacheKey.equals(obj)) {
                    this.stack.add(lookup);
                    return lookup.adapter != null ? lookup.adapter : lookup;
                }
            }
            Lookup<?> lookup2 = new Lookup<>(type, str, obj);
            this.callLookups.add(lookup2);
            this.stack.add(lookup2);
            return null;
        }

        /* access modifiers changed from: package-private */
        public <T> void adapterFound(JsonAdapter<T> jsonAdapter) {
            this.stack.getLast().adapter = jsonAdapter;
        }

        /* access modifiers changed from: package-private */
        public void pop(boolean z) {
            this.stack.removeLast();
            if (this.stack.isEmpty()) {
                Moshi.this.lookupChainThreadLocal.remove();
                if (z) {
                    synchronized (Moshi.this.adapterCache) {
                        int size = this.callLookups.size();
                        for (int i = 0; i < size; i++) {
                            Lookup<?> lookup = this.callLookups.get(i);
                            JsonAdapter<T> jsonAdapter = (JsonAdapter) Moshi.this.adapterCache.put(lookup.cacheKey, lookup.adapter);
                            if (jsonAdapter != null) {
                                lookup.adapter = jsonAdapter;
                                Moshi.this.adapterCache.put(lookup.cacheKey, jsonAdapter);
                            }
                        }
                    }
                }
            }
        }

        /* access modifiers changed from: package-private */
        public IllegalArgumentException exceptionWithLookupStack(IllegalArgumentException illegalArgumentException) {
            if (this.exceptionAnnotated) {
                return illegalArgumentException;
            }
            this.exceptionAnnotated = true;
            if (this.stack.size() == 1 && this.stack.getFirst().fieldName == null) {
                return illegalArgumentException;
            }
            StringBuilder sb = new StringBuilder(illegalArgumentException.getMessage());
            Iterator<Lookup<?>> descendingIterator = this.stack.descendingIterator();
            while (descendingIterator.hasNext()) {
                Lookup<?> next = descendingIterator.next();
                sb.append("\nfor ");
                sb.append(next.type);
                if (next.fieldName != null) {
                    sb.append(' ');
                    sb.append(next.fieldName);
                }
            }
            return new IllegalArgumentException(sb.toString(), illegalArgumentException);
        }
    }

    /* access modifiers changed from: package-private */
    public static final class Lookup<T> extends JsonAdapter<T> {
        @Nullable
        JsonAdapter<T> adapter;
        final Object cacheKey;
        @Nullable
        final String fieldName;
        final Type type;

        Lookup(Type type2, @Nullable String str, Object obj) {
            this.type = type2;
            this.fieldName = str;
            this.cacheKey = obj;
        }

        @Override // com.squareup.moshi.JsonAdapter
        public T fromJson(JsonReader jsonReader) throws IOException {
            JsonAdapter<T> jsonAdapter = this.adapter;
            if (jsonAdapter != null) {
                return jsonAdapter.fromJson(jsonReader);
            }
            throw new IllegalStateException("JsonAdapter isn't ready");
        }

        @Override // com.squareup.moshi.JsonAdapter
        public void toJson(JsonWriter jsonWriter, T t) throws IOException {
            JsonAdapter<T> jsonAdapter = this.adapter;
            if (jsonAdapter != null) {
                jsonAdapter.toJson(jsonWriter, t);
                return;
            }
            throw new IllegalStateException("JsonAdapter isn't ready");
        }

        public String toString() {
            JsonAdapter<T> jsonAdapter = this.adapter;
            return jsonAdapter != null ? jsonAdapter.toString() : super.toString();
        }
    }
}
