package com.squareup.moshi.internal;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonWriter;
import java.io.IOException;
import javax.annotation.Nullable;

public final class NullSafeJsonAdapter<T> extends JsonAdapter<T> {
    private final JsonAdapter<T> delegate;

    public NullSafeJsonAdapter(JsonAdapter<T> jsonAdapter) {
        this.delegate = jsonAdapter;
    }

    public JsonAdapter<T> delegate() {
        return this.delegate;
    }

    @Override // com.squareup.moshi.JsonAdapter
    @Nullable
    public T fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.peek() == JsonReader.Token.NULL ? (T) jsonReader.nextNull() : this.delegate.fromJson(jsonReader);
    }

    @Override // com.squareup.moshi.JsonAdapter
    public void toJson(JsonWriter jsonWriter, @Nullable T t) throws IOException {
        if (t == null) {
            jsonWriter.nullValue();
        } else {
            this.delegate.toJson(jsonWriter, t);
        }
    }

    public String toString() {
        return this.delegate + ".nullSafe()";
    }
}
