package com.squareup.moshi;

import java.io.IOException;
import javax.annotation.Nullable;

public final class JsonEncodingException extends IOException {
    public JsonEncodingException(@Nullable String str) {
        super(str);
    }
}
