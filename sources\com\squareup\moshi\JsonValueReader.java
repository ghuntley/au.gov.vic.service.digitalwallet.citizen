package com.squareup.moshi;

import com.squareup.moshi.JsonReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;
import okio.Buffer;
import okio.BufferedSource;

final class JsonValueReader extends JsonReader {
    private static final Object JSON_READER_CLOSED = new Object();
    private Object[] stack;

    JsonValueReader(Object obj) {
        this.scopes[this.stackSize] = 7;
        Object[] objArr = new Object[32];
        this.stack = objArr;
        int i = this.stackSize;
        this.stackSize = i + 1;
        objArr[i] = obj;
    }

    JsonValueReader(JsonValueReader jsonValueReader) {
        super(jsonValueReader);
        this.stack = (Object[]) jsonValueReader.stack.clone();
        for (int i = 0; i < this.stackSize; i++) {
            Object[] objArr = this.stack;
            if (objArr[i] instanceof JsonIterator) {
                objArr[i] = ((JsonIterator) objArr[i]).clone();
            }
        }
    }

    @Override // com.squareup.moshi.JsonReader
    public void beginArray() throws IOException {
        List list = (List) require(List.class, JsonReader.Token.BEGIN_ARRAY);
        JsonIterator jsonIterator = new JsonIterator(JsonReader.Token.END_ARRAY, list.toArray(new Object[list.size()]), 0);
        this.stack[this.stackSize - 1] = jsonIterator;
        this.scopes[this.stackSize - 1] = 1;
        this.pathIndices[this.stackSize - 1] = 0;
        if (jsonIterator.hasNext()) {
            push(jsonIterator.next());
        }
    }

    @Override // com.squareup.moshi.JsonReader
    public void endArray() throws IOException {
        JsonIterator jsonIterator = (JsonIterator) require(JsonIterator.class, JsonReader.Token.END_ARRAY);
        if (jsonIterator.endToken != JsonReader.Token.END_ARRAY || jsonIterator.hasNext()) {
            throw typeMismatch(jsonIterator, JsonReader.Token.END_ARRAY);
        }
        remove();
    }

    @Override // com.squareup.moshi.JsonReader
    public void beginObject() throws IOException {
        Map map = (Map) require(Map.class, JsonReader.Token.BEGIN_OBJECT);
        JsonIterator jsonIterator = new JsonIterator(JsonReader.Token.END_OBJECT, map.entrySet().toArray(new Object[map.size()]), 0);
        this.stack[this.stackSize - 1] = jsonIterator;
        this.scopes[this.stackSize - 1] = 3;
        if (jsonIterator.hasNext()) {
            push(jsonIterator.next());
        }
    }

    @Override // com.squareup.moshi.JsonReader
    public void endObject() throws IOException {
        JsonIterator jsonIterator = (JsonIterator) require(JsonIterator.class, JsonReader.Token.END_OBJECT);
        if (jsonIterator.endToken != JsonReader.Token.END_OBJECT || jsonIterator.hasNext()) {
            throw typeMismatch(jsonIterator, JsonReader.Token.END_OBJECT);
        }
        this.pathNames[this.stackSize - 1] = null;
        remove();
    }

    @Override // com.squareup.moshi.JsonReader
    public boolean hasNext() throws IOException {
        if (this.stackSize == 0) {
            return false;
        }
        Object obj = this.stack[this.stackSize - 1];
        if (!(obj instanceof Iterator) || ((Iterator) obj).hasNext()) {
            return true;
        }
        return false;
    }

    @Override // com.squareup.moshi.JsonReader
    public JsonReader.Token peek() throws IOException {
        if (this.stackSize == 0) {
            return JsonReader.Token.END_DOCUMENT;
        }
        Object obj = this.stack[this.stackSize - 1];
        if (obj instanceof JsonIterator) {
            return ((JsonIterator) obj).endToken;
        }
        if (obj instanceof List) {
            return JsonReader.Token.BEGIN_ARRAY;
        }
        if (obj instanceof Map) {
            return JsonReader.Token.BEGIN_OBJECT;
        }
        if (obj instanceof Map.Entry) {
            return JsonReader.Token.NAME;
        }
        if (obj instanceof String) {
            return JsonReader.Token.STRING;
        }
        if (obj instanceof Boolean) {
            return JsonReader.Token.BOOLEAN;
        }
        if (obj instanceof Number) {
            return JsonReader.Token.NUMBER;
        }
        if (obj == null) {
            return JsonReader.Token.NULL;
        }
        if (obj == JSON_READER_CLOSED) {
            throw new IllegalStateException("JsonReader is closed");
        }
        throw typeMismatch(obj, "a JSON value");
    }

    @Override // com.squareup.moshi.JsonReader
    public String nextName() throws IOException {
        Map.Entry<?, ?> entry = (Map.Entry) require(Map.Entry.class, JsonReader.Token.NAME);
        String stringKey = stringKey(entry);
        this.stack[this.stackSize - 1] = entry.getValue();
        this.pathNames[this.stackSize - 2] = stringKey;
        return stringKey;
    }

    @Override // com.squareup.moshi.JsonReader
    public int selectName(JsonReader.Options options) throws IOException {
        Map.Entry<?, ?> entry = (Map.Entry) require(Map.Entry.class, JsonReader.Token.NAME);
        String stringKey = stringKey(entry);
        int length = options.strings.length;
        for (int i = 0; i < length; i++) {
            if (options.strings[i].equals(stringKey)) {
                this.stack[this.stackSize - 1] = entry.getValue();
                this.pathNames[this.stackSize - 2] = stringKey;
                return i;
            }
        }
        return -1;
    }

    @Override // com.squareup.moshi.JsonReader
    public void skipName() throws IOException {
        if (!this.failOnUnknown) {
            this.stack[this.stackSize - 1] = ((Map.Entry) require(Map.Entry.class, JsonReader.Token.NAME)).getValue();
            this.pathNames[this.stackSize - 2] = "null";
            return;
        }
        JsonReader.Token peek = peek();
        nextName();
        throw new JsonDataException("Cannot skip unexpected " + peek + " at " + getPath());
    }

    @Override // com.squareup.moshi.JsonReader
    public String nextString() throws IOException {
        String str = this.stackSize != 0 ? this.stack[this.stackSize - 1] : null;
        if (str instanceof String) {
            remove();
            return str;
        } else if (str instanceof Number) {
            remove();
            return str.toString();
        } else if (str == JSON_READER_CLOSED) {
            throw new IllegalStateException("JsonReader is closed");
        } else {
            throw typeMismatch(str, JsonReader.Token.STRING);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v5, types: [java.lang.Object[]] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARNING: Unknown variable types count: 2 */
    @Override // com.squareup.moshi.JsonReader
    public int selectString(JsonReader.Options options) throws IOException {
        String str = this.stackSize != 0 ? this.stack[this.stackSize - 1] : null;
        if (str instanceof String) {
            String str2 = str;
            int length = options.strings.length;
            for (int i = 0; i < length; i++) {
                if (options.strings[i].equals(str2)) {
                    remove();
                    return i;
                }
            }
            return -1;
        } else if (str != JSON_READER_CLOSED) {
            return -1;
        } else {
            throw new IllegalStateException("JsonReader is closed");
        }
    }

    @Override // com.squareup.moshi.JsonReader
    public boolean nextBoolean() throws IOException {
        remove();
        return ((Boolean) require(Boolean.class, JsonReader.Token.BOOLEAN)).booleanValue();
    }

    @Override // com.squareup.moshi.JsonReader
    @Nullable
    public <T> T nextNull() throws IOException {
        require(Void.class, JsonReader.Token.NULL);
        remove();
        return null;
    }

    @Override // com.squareup.moshi.JsonReader
    public double nextDouble() throws IOException {
        double d;
        Object require = require(Object.class, JsonReader.Token.NUMBER);
        if (require instanceof Number) {
            d = ((Number) require).doubleValue();
        } else if (require instanceof String) {
            try {
                d = Double.parseDouble((String) require);
            } catch (NumberFormatException unused) {
                throw typeMismatch(require, JsonReader.Token.NUMBER);
            }
        } else {
            throw typeMismatch(require, JsonReader.Token.NUMBER);
        }
        if (this.lenient || (!Double.isNaN(d) && !Double.isInfinite(d))) {
            remove();
            return d;
        }
        throw new JsonEncodingException("JSON forbids NaN and infinities: " + d + " at path " + getPath());
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:6:0x0018 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0, types: [com.squareup.moshi.JsonValueReader] */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v4, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v8, types: [long] */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:8:0x001f */
    /* JADX WARNING: Unknown variable types count: 1 */
    @Override // com.squareup.moshi.JsonReader
    public long nextLong() throws IOException {
        long j;
        ?? require = require(Object.class, JsonReader.Token.NUMBER);
        if (require instanceof Number) {
            j = ((Number) require).longValue();
        } else if (require instanceof String) {
            require = Long.parseLong((String) require);
            j = require;
            try {
                j = new BigDecimal((String) require).longValueExact();
            } catch (NumberFormatException unused) {
                throw typeMismatch(require, JsonReader.Token.NUMBER);
            }
        } else {
            throw typeMismatch(require, JsonReader.Token.NUMBER);
        }
        remove();
        return j == 1 ? 1 : 0;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:6:0x0018 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0, types: [com.squareup.moshi.JsonValueReader] */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v4, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v8, types: [int] */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:8:0x001f */
    /* JADX WARNING: Unknown variable types count: 1 */
    @Override // com.squareup.moshi.JsonReader
    public int nextInt() throws IOException {
        int i;
        ?? require = require(Object.class, JsonReader.Token.NUMBER);
        if (require instanceof Number) {
            i = ((Number) require).intValue();
        } else if (require instanceof String) {
            require = Integer.parseInt((String) require);
            i = require;
            try {
                i = new BigDecimal((String) require).intValueExact();
            } catch (NumberFormatException unused) {
                throw typeMismatch(require, JsonReader.Token.NUMBER);
            }
        } else {
            throw typeMismatch(require, JsonReader.Token.NUMBER);
        }
        remove();
        return i == 1 ? 1 : 0;
    }

    @Override // com.squareup.moshi.JsonReader
    public void skipValue() throws IOException {
        if (!this.failOnUnknown) {
            if (this.stackSize > 1) {
                this.pathNames[this.stackSize - 2] = "null";
            }
            Object obj = this.stackSize != 0 ? this.stack[this.stackSize - 1] : null;
            if (obj instanceof JsonIterator) {
                throw new JsonDataException("Expected a value but was " + peek() + " at path " + getPath());
            } else if (obj instanceof Map.Entry) {
                this.stack[this.stackSize - 1] = ((Map.Entry) this.stack[this.stackSize - 1]).getValue();
            } else if (this.stackSize > 0) {
                remove();
            } else {
                throw new JsonDataException("Expected a value but was " + peek() + " at path " + getPath());
            }
        } else {
            throw new JsonDataException("Cannot skip unexpected " + peek() + " at " + getPath());
        }
    }

    @Override // com.squareup.moshi.JsonReader
    public BufferedSource nextSource() throws IOException {
        Object readJsonValue = readJsonValue();
        Buffer buffer = new Buffer();
        JsonWriter of = JsonWriter.of(buffer);
        try {
            of.jsonValue(readJsonValue);
            if (of != null) {
                of.close();
            }
            return buffer;
        } catch (Throwable th) {
            th.addSuppressed(th);
        }
        throw th;
    }

    @Override // com.squareup.moshi.JsonReader
    public JsonReader peekJson() {
        return new JsonValueReader(this);
    }

    @Override // com.squareup.moshi.JsonReader
    public void promoteNameToValue() throws IOException {
        if (hasNext()) {
            push(nextName());
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        Arrays.fill(this.stack, 0, this.stackSize, (Object) null);
        this.stack[0] = JSON_READER_CLOSED;
        this.scopes[0] = 8;
        this.stackSize = 1;
    }

    private void push(Object obj) {
        if (this.stackSize == this.stack.length) {
            if (this.stackSize != 256) {
                this.scopes = Arrays.copyOf(this.scopes, this.scopes.length * 2);
                this.pathNames = (String[]) Arrays.copyOf(this.pathNames, this.pathNames.length * 2);
                this.pathIndices = Arrays.copyOf(this.pathIndices, this.pathIndices.length * 2);
                Object[] objArr = this.stack;
                this.stack = Arrays.copyOf(objArr, objArr.length * 2);
            } else {
                throw new JsonDataException("Nesting too deep at " + getPath());
            }
        }
        Object[] objArr2 = this.stack;
        int i = this.stackSize;
        this.stackSize = i + 1;
        objArr2[i] = obj;
    }

    @Nullable
    private <T> T require(Class<T> cls, JsonReader.Token token) throws IOException {
        Object obj = this.stackSize != 0 ? this.stack[this.stackSize - 1] : null;
        if (cls.isInstance(obj)) {
            return cls.cast(obj);
        }
        if (obj == null && token == JsonReader.Token.NULL) {
            return null;
        }
        if (obj == JSON_READER_CLOSED) {
            throw new IllegalStateException("JsonReader is closed");
        }
        throw typeMismatch(obj, token);
    }

    private String stringKey(Map.Entry<?, ?> entry) {
        Object key = entry.getKey();
        if (key instanceof String) {
            return (String) key;
        }
        throw typeMismatch(key, JsonReader.Token.NAME);
    }

    private void remove() {
        this.stackSize--;
        this.stack[this.stackSize] = null;
        this.scopes[this.stackSize] = 0;
        if (this.stackSize > 0) {
            int[] iArr = this.pathIndices;
            int i = this.stackSize - 1;
            iArr[i] = iArr[i] + 1;
            Object obj = this.stack[this.stackSize - 1];
            if (obj instanceof Iterator) {
                Iterator it = (Iterator) obj;
                if (it.hasNext()) {
                    push(it.next());
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public static final class JsonIterator implements Iterator<Object>, Cloneable {
        final Object[] array;
        final JsonReader.Token endToken;
        int next;

        JsonIterator(JsonReader.Token token, Object[] objArr, int i) {
            this.endToken = token;
            this.array = objArr;
            this.next = i;
        }

        public boolean hasNext() {
            return this.next < this.array.length;
        }

        @Override // java.util.Iterator
        public Object next() {
            Object[] objArr = this.array;
            int i = this.next;
            this.next = i + 1;
            return objArr[i];
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        /* access modifiers changed from: protected */
        @Override // java.lang.Object
        public JsonIterator clone() {
            return new JsonIterator(this.endToken, this.array, this.next);
        }
    }
}
