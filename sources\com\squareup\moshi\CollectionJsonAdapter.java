package com.squareup.moshi;

import com.squareup.moshi.JsonAdapter;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.Nullable;

abstract class CollectionJsonAdapter<C extends Collection<T>, T> extends JsonAdapter<C> {
    public static final JsonAdapter.Factory FACTORY = new JsonAdapter.Factory() {
        /* class com.squareup.moshi.CollectionJsonAdapter.AnonymousClass1 */

        @Override // com.squareup.moshi.JsonAdapter.Factory
        @Nullable
        public JsonAdapter<?> create(Type type, Set<? extends Annotation> set, Moshi moshi) {
            Class<?> rawType = Types.getRawType(type);
            if (!set.isEmpty()) {
                return null;
            }
            if (rawType == List.class || rawType == Collection.class) {
                return CollectionJsonAdapter.newArrayListAdapter(type, moshi).nullSafe();
            }
            if (rawType == Set.class) {
                return CollectionJsonAdapter.newLinkedHashSetAdapter(type, moshi).nullSafe();
            }
            return null;
        }
    };
    private final JsonAdapter<T> elementAdapter;

    /* access modifiers changed from: package-private */
    public abstract C newCollection();

    private CollectionJsonAdapter(JsonAdapter<T> jsonAdapter) {
        this.elementAdapter = jsonAdapter;
    }

    static <T> JsonAdapter<Collection<T>> newArrayListAdapter(Type type, Moshi moshi) {
        return new CollectionJsonAdapter<Collection<T>, T>(moshi.adapter(Types.collectionElementType(type, Collection.class))) {
            /* class com.squareup.moshi.CollectionJsonAdapter.AnonymousClass2 */

            @Override // com.squareup.moshi.JsonAdapter, com.squareup.moshi.CollectionJsonAdapter, com.squareup.moshi.CollectionJsonAdapter
            public /* bridge */ /* synthetic */ Object fromJson(JsonReader jsonReader) throws IOException {
                return CollectionJsonAdapter.super.fromJson(jsonReader);
            }

            /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.squareup.moshi.CollectionJsonAdapter$2 */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.squareup.moshi.JsonAdapter, com.squareup.moshi.CollectionJsonAdapter
            public /* bridge */ /* synthetic */ void toJson(JsonWriter jsonWriter, Object obj) throws IOException {
                CollectionJsonAdapter.super.toJson(jsonWriter, (Collection) obj);
            }

            /* access modifiers changed from: package-private */
            @Override // com.squareup.moshi.CollectionJsonAdapter
            public Collection<T> newCollection() {
                return new ArrayList();
            }
        };
    }

    static <T> JsonAdapter<Set<T>> newLinkedHashSetAdapter(Type type, Moshi moshi) {
        return new CollectionJsonAdapter<Set<T>, T>(moshi.adapter(Types.collectionElementType(type, Collection.class))) {
            /* class com.squareup.moshi.CollectionJsonAdapter.AnonymousClass3 */

            @Override // com.squareup.moshi.JsonAdapter, com.squareup.moshi.CollectionJsonAdapter, com.squareup.moshi.CollectionJsonAdapter
            public /* bridge */ /* synthetic */ Object fromJson(JsonReader jsonReader) throws IOException {
                return CollectionJsonAdapter.super.fromJson(jsonReader);
            }

            /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.squareup.moshi.CollectionJsonAdapter$3 */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.squareup.moshi.JsonAdapter, com.squareup.moshi.CollectionJsonAdapter
            public /* bridge */ /* synthetic */ void toJson(JsonWriter jsonWriter, Object obj) throws IOException {
                CollectionJsonAdapter.super.toJson(jsonWriter, (Collection) obj);
            }

            /* access modifiers changed from: package-private */
            @Override // com.squareup.moshi.CollectionJsonAdapter
            public Set<T> newCollection() {
                return new LinkedHashSet();
            }
        };
    }

    @Override // com.squareup.moshi.JsonAdapter
    public C fromJson(JsonReader jsonReader) throws IOException {
        C newCollection = newCollection();
        jsonReader.beginArray();
        while (jsonReader.hasNext()) {
            newCollection.add(this.elementAdapter.fromJson(jsonReader));
        }
        jsonReader.endArray();
        return newCollection;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.squareup.moshi.JsonAdapter<T> */
    /* JADX WARN: Multi-variable type inference failed */
    public void toJson(JsonWriter jsonWriter, C c) throws IOException {
        jsonWriter.beginArray();
        for (Object obj : c) {
            this.elementAdapter.toJson(jsonWriter, obj);
        }
        jsonWriter.endArray();
    }

    public String toString() {
        return this.elementAdapter + ".collection()";
    }
}
