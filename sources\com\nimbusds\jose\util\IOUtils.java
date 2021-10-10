package com.nimbusds.jose.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

public class IOUtils {
    public static String readInputStreamToString(InputStream inputStream, Charset charset) throws IOException {
        char[] cArr = new char[1024];
        StringBuilder sb = new StringBuilder();
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream, charset);
        while (true) {
            try {
                int read = inputStreamReader.read(cArr, 0, 1024);
                if (read < 0) {
                    return sb.toString();
                }
                sb.append(cArr, 0, read);
            } finally {
                inputStreamReader.close();
            }
        }
    }

    public static String readFileToString(File file, Charset charset) throws IOException {
        return readInputStreamToString(new FileInputStream(file), charset);
    }

    private IOUtils() {
    }
}
