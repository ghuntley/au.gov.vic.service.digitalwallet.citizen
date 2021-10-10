package com.squareup.moshi.adapters;

import com.squareup.moshi.Json;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonDataException;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonWriter;
import java.io.IOException;
import java.lang.Enum;
import java.util.Arrays;
import java.util.Objects;
import javax.annotation.Nullable;

public final class EnumJsonAdapter<T extends Enum<T>> extends JsonAdapter<T> {
    final T[] constants;
    final Class<T> enumType;
    @Nullable
    final T fallbackValue;
    final String[] nameStrings;
    final JsonReader.Options options;
    final boolean useFallbackValue;

    public static <T extends Enum<T>> EnumJsonAdapter<T> create(Class<T> cls) {
        return new EnumJsonAdapter<>(cls, null, false);
    }

    public EnumJsonAdapter<T> withUnknownFallback(@Nullable T t) {
        return new EnumJsonAdapter<>(this.enumType, t, true);
    }

    EnumJsonAdapter(Class<T> cls, @Nullable T t, boolean z) {
        this.enumType = cls;
        this.fallbackValue = t;
        this.useFallbackValue = z;
        try {
            T[] enumConstants = cls.getEnumConstants();
            this.constants = enumConstants;
            this.nameStrings = new String[enumConstants.length];
            int i = 0;
            while (true) {
                T[] tArr = this.constants;
                if (i < tArr.length) {
                    String name = tArr[i].name();
                    Json json = (Json) cls.getField(name).getAnnotation(Json.class);
                    if (json != null) {
                        name = json.name();
                    }
                    this.nameStrings[i] = name;
                    i++;
                } else {
                    this.options = JsonReader.Options.of(this.nameStrings);
                    return;
                }
            }
        } catch (NoSuchFieldException e) {
            throw new AssertionError("Missing field in " + cls.getName(), e);
        }
    }

    @Override // com.squareup.moshi.JsonAdapter
    @Nullable
    public T fromJson(JsonReader jsonReader) throws IOException {
        int selectString = jsonReader.selectString(this.options);
        if (selectString != -1) {
            return this.constants[selectString];
        }
        String path = jsonReader.getPath();
        if (!this.useFallbackValue) {
            String nextString = jsonReader.nextString();
            throw new JsonDataException("Expected one of " + Arrays.asList(this.nameStrings) + " but was " + nextString + " at path " + path);
        } else if (jsonReader.peek() == JsonReader.Token.STRING) {
            jsonReader.skipValue();
            return this.fallbackValue;
        } else {
            throw new JsonDataException("Expected a string but was " + jsonReader.peek() + " at path " + path);
        }
    }

    public void toJson(JsonWriter jsonWriter, T t) throws IOException {
        Objects.requireNonNull(t, "value was null! Wrap in .nullSafe() to write nullable values.");
        jsonWriter.value(this.nameStrings[t.ordinal()]);
    }

    public String toString() {
        return "EnumJsonAdapter(" + this.enumType.getName() + ")";
    }
}
