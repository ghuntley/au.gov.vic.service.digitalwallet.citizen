package net.minidev.json.parser;

import java.io.InputStream;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import net.minidev.json.JSONValue;
import net.minidev.json.writer.JsonReaderI;

public class JSONParser {
    public static final int ACCEPT_LEADING_ZERO = 32;
    public static final int ACCEPT_NAN = 4;
    public static final int ACCEPT_NON_QUOTE = 2;
    public static final int ACCEPT_SIMPLE_QUOTE = 1;
    public static final int ACCEPT_TAILLING_DATA = 256;
    public static final int ACCEPT_TAILLING_SPACE = 512;
    public static final int ACCEPT_USELESS_COMMA = 64;
    public static int DEFAULT_PERMISSIVE_MODE = (System.getProperty("JSON_SMART_SIMPLE") != null ? MODE_JSON_SIMPLE : -1);
    public static final int IGNORE_CONTROL_CHAR = 8;
    public static final int MODE_JSON_SIMPLE = 1984;
    public static final int MODE_PERMISSIVE = -1;
    public static final int MODE_RFC4627 = 656;
    public static final int MODE_STRICTEST = 1168;
    public static final int REJECT_127_CHAR = 1024;
    public static final int USE_HI_PRECISION_FLOAT = 128;
    public static final int USE_INTEGER_STORAGE = 16;
    private int mode;
    private JSONParserInputStream pBinStream;
    private JSONParserByteArray pBytes;
    private JSONParserReader pStream;
    private JSONParserString pString;

    private JSONParserReader getPStream() {
        if (this.pStream == null) {
            this.pStream = new JSONParserReader(this.mode);
        }
        return this.pStream;
    }

    private JSONParserInputStream getPBinStream() {
        if (this.pBinStream == null) {
            this.pBinStream = new JSONParserInputStream(this.mode);
        }
        return this.pBinStream;
    }

    private JSONParserString getPString() {
        if (this.pString == null) {
            this.pString = new JSONParserString(this.mode);
        }
        return this.pString;
    }

    private JSONParserByteArray getPBytes() {
        if (this.pBytes == null) {
            this.pBytes = new JSONParserByteArray(this.mode);
        }
        return this.pBytes;
    }

    public JSONParser() {
        this.mode = DEFAULT_PERMISSIVE_MODE;
    }

    public JSONParser(int i) {
        this.mode = i;
    }

    public Object parse(byte[] bArr) throws ParseException {
        return getPBytes().parse(bArr);
    }

    public <T> T parse(byte[] bArr, JsonReaderI<T> jsonReaderI) throws ParseException {
        return (T) getPBytes().parse(bArr, jsonReaderI);
    }

    public <T> T parse(byte[] bArr, Class<T> cls) throws ParseException {
        return (T) getPBytes().parse(bArr, JSONValue.defaultReader.getMapper((Class) cls));
    }

    public Object parse(InputStream inputStream) throws ParseException, UnsupportedEncodingException {
        return getPBinStream().parse(inputStream);
    }

    public <T> T parse(InputStream inputStream, JsonReaderI<T> jsonReaderI) throws ParseException, UnsupportedEncodingException {
        return (T) getPBinStream().parse(inputStream, jsonReaderI);
    }

    public <T> T parse(InputStream inputStream, Class<T> cls) throws ParseException, UnsupportedEncodingException {
        return (T) getPBinStream().parse(inputStream, JSONValue.defaultReader.getMapper((Class) cls));
    }

    public Object parse(Reader reader) throws ParseException {
        return getPStream().parse(reader);
    }

    public <T> T parse(Reader reader, JsonReaderI<T> jsonReaderI) throws ParseException {
        return (T) getPStream().parse(reader, jsonReaderI);
    }

    public <T> T parse(Reader reader, Class<T> cls) throws ParseException {
        return (T) getPStream().parse(reader, JSONValue.defaultReader.getMapper((Class) cls));
    }

    public Object parse(String str) throws ParseException {
        return getPString().parse(str);
    }

    public <T> T parse(String str, JsonReaderI<T> jsonReaderI) throws ParseException {
        return (T) getPString().parse(str, jsonReaderI);
    }

    public <T> T parse(String str, Class<T> cls) throws ParseException {
        return (T) getPString().parse(str, JSONValue.defaultReader.getMapper((Class) cls));
    }
}
