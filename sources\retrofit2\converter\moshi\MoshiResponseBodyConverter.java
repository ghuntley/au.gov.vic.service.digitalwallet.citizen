package retrofit2.converter.moshi;

import com.squareup.moshi.JsonAdapter;
import java.io.IOException;
import okhttp3.ResponseBody;
import okio.BufferedSource;
import okio.ByteString;
import retrofit2.Converter;

/* access modifiers changed from: package-private */
public final class MoshiResponseBodyConverter<T> implements Converter<ResponseBody, T> {
    private static final ByteString UTF8_BOM = ByteString.decodeHex("EFBBBF");
    private final JsonAdapter<T> adapter;

    MoshiResponseBodyConverter(JsonAdapter<T> jsonAdapter) {
        this.adapter = jsonAdapter;
    }

    public T convert(ResponseBody responseBody) throws IOException {
        BufferedSource source = responseBody.source();
        try {
            ByteString byteString = UTF8_BOM;
            if (source.rangeEquals(0, byteString)) {
                source.skip((long) byteString.size());
            }
            return this.adapter.fromJson(source);
        } finally {
            responseBody.close();
        }
    }
}
