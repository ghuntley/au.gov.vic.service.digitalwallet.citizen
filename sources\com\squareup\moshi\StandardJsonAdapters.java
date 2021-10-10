package com.squareup.moshi;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.internal.Util;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import kotlin.text.Typography;

/* access modifiers changed from: package-private */
public final class StandardJsonAdapters {
    static final JsonAdapter<Boolean> BOOLEAN_JSON_ADAPTER = new JsonAdapter<Boolean>() {
        /* class com.squareup.moshi.StandardJsonAdapters.AnonymousClass2 */

        public String toString() {
            return "JsonAdapter(Boolean)";
        }

        @Override // com.squareup.moshi.JsonAdapter
        public Boolean fromJson(JsonReader jsonReader) throws IOException {
            return Boolean.valueOf(jsonReader.nextBoolean());
        }

        public void toJson(JsonWriter jsonWriter, Boolean bool) throws IOException {
            jsonWriter.value(bool.booleanValue());
        }
    };
    static final JsonAdapter<Byte> BYTE_JSON_ADAPTER = new JsonAdapter<Byte>() {
        /* class com.squareup.moshi.StandardJsonAdapters.AnonymousClass3 */

        public String toString() {
            return "JsonAdapter(Byte)";
        }

        @Override // com.squareup.moshi.JsonAdapter
        public Byte fromJson(JsonReader jsonReader) throws IOException {
            return Byte.valueOf((byte) StandardJsonAdapters.rangeCheckNextInt(jsonReader, "a byte", -128, 255));
        }

        public void toJson(JsonWriter jsonWriter, Byte b) throws IOException {
            jsonWriter.value((long) (b.intValue() & 255));
        }
    };
    static final JsonAdapter<Character> CHARACTER_JSON_ADAPTER = new JsonAdapter<Character>() {
        /* class com.squareup.moshi.StandardJsonAdapters.AnonymousClass4 */

        public String toString() {
            return "JsonAdapter(Character)";
        }

        @Override // com.squareup.moshi.JsonAdapter
        public Character fromJson(JsonReader jsonReader) throws IOException {
            String nextString = jsonReader.nextString();
            if (nextString.length() <= 1) {
                return Character.valueOf(nextString.charAt(0));
            }
            throw new JsonDataException(String.format(StandardJsonAdapters.ERROR_FORMAT, "a char", Typography.quote + nextString + Typography.quote, jsonReader.getPath()));
        }

        public void toJson(JsonWriter jsonWriter, Character ch) throws IOException {
            jsonWriter.value(ch.toString());
        }
    };
    static final JsonAdapter<Double> DOUBLE_JSON_ADAPTER = new JsonAdapter<Double>() {
        /* class com.squareup.moshi.StandardJsonAdapters.AnonymousClass5 */

        public String toString() {
            return "JsonAdapter(Double)";
        }

        @Override // com.squareup.moshi.JsonAdapter
        public Double fromJson(JsonReader jsonReader) throws IOException {
            return Double.valueOf(jsonReader.nextDouble());
        }

        public void toJson(JsonWriter jsonWriter, Double d) throws IOException {
            jsonWriter.value(d.doubleValue());
        }
    };
    private static final String ERROR_FORMAT = "Expected %s but was %s at path %s";
    public static final JsonAdapter.Factory FACTORY = new JsonAdapter.Factory() {
        /* class com.squareup.moshi.StandardJsonAdapters.AnonymousClass1 */

        @Override // com.squareup.moshi.JsonAdapter.Factory
        public JsonAdapter<?> create(Type type, Set<? extends Annotation> set, Moshi moshi) {
            if (!set.isEmpty()) {
                return null;
            }
            if (type == Boolean.TYPE) {
                return StandardJsonAdapters.BOOLEAN_JSON_ADAPTER;
            }
            if (type == Byte.TYPE) {
                return StandardJsonAdapters.BYTE_JSON_ADAPTER;
            }
            if (type == Character.TYPE) {
                return StandardJsonAdapters.CHARACTER_JSON_ADAPTER;
            }
            if (type == Double.TYPE) {
                return StandardJsonAdapters.DOUBLE_JSON_ADAPTER;
            }
            if (type == Float.TYPE) {
                return StandardJsonAdapters.FLOAT_JSON_ADAPTER;
            }
            if (type == Integer.TYPE) {
                return StandardJsonAdapters.INTEGER_JSON_ADAPTER;
            }
            if (type == Long.TYPE) {
                return StandardJsonAdapters.LONG_JSON_ADAPTER;
            }
            if (type == Short.TYPE) {
                return StandardJsonAdapters.SHORT_JSON_ADAPTER;
            }
            if (type == Boolean.class) {
                return StandardJsonAdapters.BOOLEAN_JSON_ADAPTER.nullSafe();
            }
            if (type == Byte.class) {
                return StandardJsonAdapters.BYTE_JSON_ADAPTER.nullSafe();
            }
            if (type == Character.class) {
                return StandardJsonAdapters.CHARACTER_JSON_ADAPTER.nullSafe();
            }
            if (type == Double.class) {
                return StandardJsonAdapters.DOUBLE_JSON_ADAPTER.nullSafe();
            }
            if (type == Float.class) {
                return StandardJsonAdapters.FLOAT_JSON_ADAPTER.nullSafe();
            }
            if (type == Integer.class) {
                return StandardJsonAdapters.INTEGER_JSON_ADAPTER.nullSafe();
            }
            if (type == Long.class) {
                return StandardJsonAdapters.LONG_JSON_ADAPTER.nullSafe();
            }
            if (type == Short.class) {
                return StandardJsonAdapters.SHORT_JSON_ADAPTER.nullSafe();
            }
            if (type == String.class) {
                return StandardJsonAdapters.STRING_JSON_ADAPTER.nullSafe();
            }
            if (type == Object.class) {
                return new ObjectJsonAdapter(moshi).nullSafe();
            }
            Class<?> rawType = Types.getRawType(type);
            JsonAdapter<?> generatedAdapter = Util.generatedAdapter(moshi, type, rawType);
            if (generatedAdapter != null) {
                return generatedAdapter;
            }
            if (rawType.isEnum()) {
                return new EnumJsonAdapter(rawType).nullSafe();
            }
            return null;
        }
    };
    static final JsonAdapter<Float> FLOAT_JSON_ADAPTER = new JsonAdapter<Float>() {
        /* class com.squareup.moshi.StandardJsonAdapters.AnonymousClass6 */

        public String toString() {
            return "JsonAdapter(Float)";
        }

        @Override // com.squareup.moshi.JsonAdapter
        public Float fromJson(JsonReader jsonReader) throws IOException {
            float nextDouble = (float) jsonReader.nextDouble();
            if (jsonReader.isLenient() || !Float.isInfinite(nextDouble)) {
                return Float.valueOf(nextDouble);
            }
            throw new JsonDataException("JSON forbids NaN and infinities: " + nextDouble + " at path " + jsonReader.getPath());
        }

        public void toJson(JsonWriter jsonWriter, Float f) throws IOException {
            Objects.requireNonNull(f);
            jsonWriter.value(f);
        }
    };
    static final JsonAdapter<Integer> INTEGER_JSON_ADAPTER = new JsonAdapter<Integer>() {
        /* class com.squareup.moshi.StandardJsonAdapters.AnonymousClass7 */

        public String toString() {
            return "JsonAdapter(Integer)";
        }

        @Override // com.squareup.moshi.JsonAdapter
        public Integer fromJson(JsonReader jsonReader) throws IOException {
            return Integer.valueOf(jsonReader.nextInt());
        }

        public void toJson(JsonWriter jsonWriter, Integer num) throws IOException {
            jsonWriter.value((long) num.intValue());
        }
    };
    static final JsonAdapter<Long> LONG_JSON_ADAPTER = new JsonAdapter<Long>() {
        /* class com.squareup.moshi.StandardJsonAdapters.AnonymousClass8 */

        public String toString() {
            return "JsonAdapter(Long)";
        }

        @Override // com.squareup.moshi.JsonAdapter
        public Long fromJson(JsonReader jsonReader) throws IOException {
            return Long.valueOf(jsonReader.nextLong());
        }

        public void toJson(JsonWriter jsonWriter, Long l) throws IOException {
            jsonWriter.value(l.longValue());
        }
    };
    static final JsonAdapter<Short> SHORT_JSON_ADAPTER = new JsonAdapter<Short>() {
        /* class com.squareup.moshi.StandardJsonAdapters.AnonymousClass9 */

        public String toString() {
            return "JsonAdapter(Short)";
        }

        @Override // com.squareup.moshi.JsonAdapter
        public Short fromJson(JsonReader jsonReader) throws IOException {
            return Short.valueOf((short) StandardJsonAdapters.rangeCheckNextInt(jsonReader, "a short", -32768, 32767));
        }

        public void toJson(JsonWriter jsonWriter, Short sh) throws IOException {
            jsonWriter.value((long) sh.intValue());
        }
    };
    static final JsonAdapter<String> STRING_JSON_ADAPTER = new JsonAdapter<String>() {
        /* class com.squareup.moshi.StandardJsonAdapters.AnonymousClass10 */

        public String toString() {
            return "JsonAdapter(String)";
        }

        @Override // com.squareup.moshi.JsonAdapter
        public String fromJson(JsonReader jsonReader) throws IOException {
            return jsonReader.nextString();
        }

        public void toJson(JsonWriter jsonWriter, String str) throws IOException {
            jsonWriter.value(str);
        }
    };

    private StandardJsonAdapters() {
    }

    static int rangeCheckNextInt(JsonReader jsonReader, String str, int i, int i2) throws IOException {
        int nextInt = jsonReader.nextInt();
        if (nextInt >= i && nextInt <= i2) {
            return nextInt;
        }
        throw new JsonDataException(String.format(ERROR_FORMAT, str, Integer.valueOf(nextInt), jsonReader.getPath()));
    }

    static final class EnumJsonAdapter<T extends Enum<T>> extends JsonAdapter<T> {
        private final T[] constants;
        private final Class<T> enumType;
        private final String[] nameStrings;
        private final JsonReader.Options options;

        EnumJsonAdapter(Class<T> cls) {
            this.enumType = cls;
            try {
                T[] enumConstants = cls.getEnumConstants();
                this.constants = enumConstants;
                this.nameStrings = new String[enumConstants.length];
                int i = 0;
                while (true) {
                    T[] tArr = this.constants;
                    if (i < tArr.length) {
                        T t = tArr[i];
                        Json json = (Json) cls.getField(t.name()).getAnnotation(Json.class);
                        this.nameStrings[i] = json != null ? json.name() : t.name();
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
        public T fromJson(JsonReader jsonReader) throws IOException {
            int selectString = jsonReader.selectString(this.options);
            if (selectString != -1) {
                return this.constants[selectString];
            }
            String path = jsonReader.getPath();
            String nextString = jsonReader.nextString();
            throw new JsonDataException("Expected one of " + Arrays.asList(this.nameStrings) + " but was " + nextString + " at path " + path);
        }

        public void toJson(JsonWriter jsonWriter, T t) throws IOException {
            jsonWriter.value(this.nameStrings[t.ordinal()]);
        }

        public String toString() {
            return "JsonAdapter(" + this.enumType.getName() + ")";
        }
    }

    static final class ObjectJsonAdapter extends JsonAdapter<Object> {
        private final JsonAdapter<Boolean> booleanAdapter;
        private final JsonAdapter<Double> doubleAdapter;
        private final JsonAdapter<List> listJsonAdapter;
        private final JsonAdapter<Map> mapAdapter;
        private final Moshi moshi;
        private final JsonAdapter<String> stringAdapter;

        public String toString() {
            return "JsonAdapter(Object)";
        }

        ObjectJsonAdapter(Moshi moshi2) {
            this.moshi = moshi2;
            this.listJsonAdapter = moshi2.adapter(List.class);
            this.mapAdapter = moshi2.adapter(Map.class);
            this.stringAdapter = moshi2.adapter(String.class);
            this.doubleAdapter = moshi2.adapter(Double.class);
            this.booleanAdapter = moshi2.adapter(Boolean.class);
        }

        @Override // com.squareup.moshi.JsonAdapter
        public Object fromJson(JsonReader jsonReader) throws IOException {
            switch (AnonymousClass11.$SwitchMap$com$squareup$moshi$JsonReader$Token[jsonReader.peek().ordinal()]) {
                case 1:
                    return this.listJsonAdapter.fromJson(jsonReader);
                case 2:
                    return this.mapAdapter.fromJson(jsonReader);
                case 3:
                    return this.stringAdapter.fromJson(jsonReader);
                case 4:
                    return this.doubleAdapter.fromJson(jsonReader);
                case 5:
                    return this.booleanAdapter.fromJson(jsonReader);
                case 6:
                    return jsonReader.nextNull();
                default:
                    throw new IllegalStateException("Expected a value but was " + jsonReader.peek() + " at path " + jsonReader.getPath());
            }
        }

        @Override // com.squareup.moshi.JsonAdapter
        public void toJson(JsonWriter jsonWriter, Object obj) throws IOException {
            Class<?> cls = obj.getClass();
            if (cls == Object.class) {
                jsonWriter.beginObject();
                jsonWriter.endObject();
                return;
            }
            this.moshi.adapter(toJsonType(cls), Util.NO_ANNOTATIONS).toJson(jsonWriter, obj);
        }

        private Class<?> toJsonType(Class<?> cls) {
            if (Map.class.isAssignableFrom(cls)) {
                return Map.class;
            }
            return Collection.class.isAssignableFrom(cls) ? Collection.class : cls;
        }
    }

    /* renamed from: com.squareup.moshi.StandardJsonAdapters$11  reason: invalid class name */
    static /* synthetic */ class AnonymousClass11 {
        static final /* synthetic */ int[] $SwitchMap$com$squareup$moshi$JsonReader$Token;

        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|1|2|3|4|5|6|7|8|9|10|11|12|14) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            int[] iArr = new int[JsonReader.Token.values().length];
            $SwitchMap$com$squareup$moshi$JsonReader$Token = iArr;
            iArr[JsonReader.Token.BEGIN_ARRAY.ordinal()] = 1;
            $SwitchMap$com$squareup$moshi$JsonReader$Token[JsonReader.Token.BEGIN_OBJECT.ordinal()] = 2;
            $SwitchMap$com$squareup$moshi$JsonReader$Token[JsonReader.Token.STRING.ordinal()] = 3;
            $SwitchMap$com$squareup$moshi$JsonReader$Token[JsonReader.Token.NUMBER.ordinal()] = 4;
            $SwitchMap$com$squareup$moshi$JsonReader$Token[JsonReader.Token.BOOLEAN.ordinal()] = 5;
            try {
                $SwitchMap$com$squareup$moshi$JsonReader$Token[JsonReader.Token.NULL.ordinal()] = 6;
            } catch (NoSuchFieldError unused) {
            }
        }
    }
}
