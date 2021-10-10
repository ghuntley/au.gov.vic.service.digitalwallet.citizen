package com.squareup.moshi;

import com.squareup.moshi.JsonReader;
import com.squareup.moshi.internal.NonNullJsonAdapter;
import com.squareup.moshi.internal.NullSafeJsonAdapter;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.Objects;
import java.util.Set;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nullable;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;

public abstract class JsonAdapter<T> {

    public interface Factory {
        @CheckReturnValue
        @Nullable
        JsonAdapter<?> create(Type type, Set<? extends Annotation> set, Moshi moshi);
    }

    @CheckReturnValue
    @Nullable
    public abstract T fromJson(JsonReader jsonReader) throws IOException;

    /* access modifiers changed from: package-private */
    public boolean isLenient() {
        return false;
    }

    public abstract void toJson(JsonWriter jsonWriter, @Nullable T t) throws IOException;

    @CheckReturnValue
    @Nullable
    public final T fromJson(BufferedSource bufferedSource) throws IOException {
        return fromJson(JsonReader.of(bufferedSource));
    }

    @CheckReturnValue
    @Nullable
    public final T fromJson(String str) throws IOException {
        JsonReader of = JsonReader.of(new Buffer().writeUtf8(str));
        T fromJson = fromJson(of);
        if (isLenient() || of.peek() == JsonReader.Token.END_DOCUMENT) {
            return fromJson;
        }
        throw new JsonDataException("JSON document was not fully consumed.");
    }

    public final void toJson(BufferedSink bufferedSink, @Nullable T t) throws IOException {
        toJson(JsonWriter.of(bufferedSink), t);
    }

    @CheckReturnValue
    public final String toJson(@Nullable T t) {
        Buffer buffer = new Buffer();
        try {
            toJson(buffer, t);
            return buffer.readUtf8();
        } catch (IOException e) {
            throw new AssertionError(e);
        }
    }

    @CheckReturnValue
    @Nullable
    public final Object toJsonValue(@Nullable T t) {
        JsonValueWriter jsonValueWriter = new JsonValueWriter();
        try {
            toJson(jsonValueWriter, t);
            return jsonValueWriter.root();
        } catch (IOException e) {
            throw new AssertionError(e);
        }
    }

    @CheckReturnValue
    @Nullable
    public final T fromJsonValue(@Nullable Object obj) {
        try {
            return fromJson(new JsonValueReader(obj));
        } catch (IOException e) {
            throw new AssertionError(e);
        }
    }

    @CheckReturnValue
    public final JsonAdapter<T> serializeNulls() {
        return new JsonAdapter<T>() {
            /* class com.squareup.moshi.JsonAdapter.AnonymousClass1 */

            @Override // com.squareup.moshi.JsonAdapter
            @Nullable
            public T fromJson(JsonReader jsonReader) throws IOException {
                return (T) this.fromJson(jsonReader);
            }

            @Override // com.squareup.moshi.JsonAdapter
            public void toJson(JsonWriter jsonWriter, @Nullable T t) throws IOException {
                boolean serializeNulls = jsonWriter.getSerializeNulls();
                jsonWriter.setSerializeNulls(true);
                try {
                    this.toJson(jsonWriter, t);
                } finally {
                    jsonWriter.setSerializeNulls(serializeNulls);
                }
            }

            /* access modifiers changed from: package-private */
            @Override // com.squareup.moshi.JsonAdapter
            public boolean isLenient() {
                return this.isLenient();
            }

            public String toString() {
                return this + ".serializeNulls()";
            }
        };
    }

    @CheckReturnValue
    public final JsonAdapter<T> nullSafe() {
        if (this instanceof NullSafeJsonAdapter) {
            return this;
        }
        return new NullSafeJsonAdapter(this);
    }

    @CheckReturnValue
    public final JsonAdapter<T> nonNull() {
        if (this instanceof NonNullJsonAdapter) {
            return this;
        }
        return new NonNullJsonAdapter(this);
    }

    @CheckReturnValue
    public final JsonAdapter<T> lenient() {
        return new JsonAdapter<T>() {
            /* class com.squareup.moshi.JsonAdapter.AnonymousClass2 */

            /* access modifiers changed from: package-private */
            @Override // com.squareup.moshi.JsonAdapter
            public boolean isLenient() {
                return true;
            }

            @Override // com.squareup.moshi.JsonAdapter
            @Nullable
            public T fromJson(JsonReader jsonReader) throws IOException {
                boolean isLenient = jsonReader.isLenient();
                jsonReader.setLenient(true);
                try {
                    return (T) this.fromJson(jsonReader);
                } finally {
                    jsonReader.setLenient(isLenient);
                }
            }

            @Override // com.squareup.moshi.JsonAdapter
            public void toJson(JsonWriter jsonWriter, @Nullable T t) throws IOException {
                boolean isLenient = jsonWriter.isLenient();
                jsonWriter.setLenient(true);
                try {
                    this.toJson(jsonWriter, t);
                } finally {
                    jsonWriter.setLenient(isLenient);
                }
            }

            public String toString() {
                return this + ".lenient()";
            }
        };
    }

    @CheckReturnValue
    public final JsonAdapter<T> failOnUnknown() {
        return new JsonAdapter<T>() {
            /* class com.squareup.moshi.JsonAdapter.AnonymousClass3 */

            @Override // com.squareup.moshi.JsonAdapter
            @Nullable
            public T fromJson(JsonReader jsonReader) throws IOException {
                boolean failOnUnknown = jsonReader.failOnUnknown();
                jsonReader.setFailOnUnknown(true);
                try {
                    return (T) this.fromJson(jsonReader);
                } finally {
                    jsonReader.setFailOnUnknown(failOnUnknown);
                }
            }

            @Override // com.squareup.moshi.JsonAdapter
            public void toJson(JsonWriter jsonWriter, @Nullable T t) throws IOException {
                this.toJson(jsonWriter, t);
            }

            /* access modifiers changed from: package-private */
            @Override // com.squareup.moshi.JsonAdapter
            public boolean isLenient() {
                return this.isLenient();
            }

            public String toString() {
                return this + ".failOnUnknown()";
            }
        };
    }

    @CheckReturnValue
    public JsonAdapter<T> indent(final String str) {
        Objects.requireNonNull(str, "indent == null");
        return new JsonAdapter<T>() {
            /* class com.squareup.moshi.JsonAdapter.AnonymousClass4 */

            @Override // com.squareup.moshi.JsonAdapter
            @Nullable
            public T fromJson(JsonReader jsonReader) throws IOException {
                return (T) this.fromJson(jsonReader);
            }

            @Override // com.squareup.moshi.JsonAdapter
            public void toJson(JsonWriter jsonWriter, @Nullable T t) throws IOException {
                String indent = jsonWriter.getIndent();
                jsonWriter.setIndent(str);
                try {
                    this.toJson(jsonWriter, t);
                } finally {
                    jsonWriter.setIndent(indent);
                }
            }

            /* access modifiers changed from: package-private */
            @Override // com.squareup.moshi.JsonAdapter
            public boolean isLenient() {
                return this.isLenient();
            }

            public String toString() {
                return this + ".indent(\"" + str + "\")";
            }
        };
    }
}
