package com.nimbusds.jose.util;

import com.bumptech.glide.load.Key;
import java.nio.charset.Charset;

public final class StandardCharset {
    public static final Charset UTF_8 = Charset.forName(Key.STRING_CHARSET_NAME);

    private StandardCharset() {
    }
}
