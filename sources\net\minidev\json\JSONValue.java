package net.minidev.json;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import net.minidev.json.parser.JSONParser;
import net.minidev.json.parser.ParseException;
import net.minidev.json.reader.JsonWriter;
import net.minidev.json.reader.JsonWriterI;
import net.minidev.json.writer.CompessorMapper;
import net.minidev.json.writer.FakeMapper;
import net.minidev.json.writer.JsonReader;
import net.minidev.json.writer.JsonReaderI;
import net.minidev.json.writer.UpdaterMapper;

public class JSONValue {
    public static JSONStyle COMPRESSION = JSONStyle.NO_COMPRESS;
    public static final JsonReader defaultReader = new JsonReader();
    public static final JsonWriter defaultWriter = new JsonWriter();

    public static Object parse(InputStream inputStream) {
        try {
            return new JSONParser(JSONParser.DEFAULT_PERMISSIVE_MODE).parse(inputStream);
        } catch (Exception unused) {
            return null;
        }
    }

    public static Object parse(byte[] bArr) {
        try {
            return new JSONParser(JSONParser.DEFAULT_PERMISSIVE_MODE).parse(bArr);
        } catch (Exception unused) {
            return null;
        }
    }

    public static <T> T parse(InputStream inputStream, Class<T> cls) {
        try {
            return (T) new JSONParser(JSONParser.DEFAULT_PERMISSIVE_MODE).parse(inputStream, defaultReader.getMapper((Class) cls));
        } catch (Exception unused) {
            return null;
        }
    }

    public static Object parse(Reader reader) {
        try {
            return new JSONParser(JSONParser.DEFAULT_PERMISSIVE_MODE).parse(reader);
        } catch (Exception unused) {
            return null;
        }
    }

    public static <T> T parse(byte[] bArr, Class<T> cls) {
        try {
            return (T) new JSONParser(JSONParser.DEFAULT_PERMISSIVE_MODE).parse(bArr, defaultReader.getMapper((Class) cls));
        } catch (Exception unused) {
            return null;
        }
    }

    public static <T> T parse(Reader reader, Class<T> cls) {
        try {
            return (T) new JSONParser(JSONParser.DEFAULT_PERMISSIVE_MODE).parse(reader, defaultReader.getMapper((Class) cls));
        } catch (Exception unused) {
            return null;
        }
    }

    public static <T> T parse(Reader reader, T t) {
        try {
            return (T) new JSONParser(JSONParser.DEFAULT_PERMISSIVE_MODE).parse(reader, new UpdaterMapper(defaultReader, t));
        } catch (Exception unused) {
            return null;
        }
    }

    protected static <T> T parse(Reader reader, JsonReaderI<T> jsonReaderI) {
        try {
            return (T) new JSONParser(JSONParser.DEFAULT_PERMISSIVE_MODE).parse(reader, jsonReaderI);
        } catch (Exception unused) {
            return null;
        }
    }

    public static <T> T parse(String str, Class<T> cls) {
        try {
            return (T) new JSONParser(JSONParser.DEFAULT_PERMISSIVE_MODE).parse(str, defaultReader.getMapper((Class) cls));
        } catch (Exception unused) {
            return null;
        }
    }

    public static <T> T parse(InputStream inputStream, T t) {
        try {
            return (T) new JSONParser(JSONParser.DEFAULT_PERMISSIVE_MODE).parse(inputStream, new UpdaterMapper(defaultReader, t));
        } catch (Exception unused) {
            return null;
        }
    }

    public static <T> T parse(String str, T t) {
        try {
            return (T) new JSONParser(JSONParser.DEFAULT_PERMISSIVE_MODE).parse(str, new UpdaterMapper(defaultReader, t));
        } catch (Exception unused) {
            return null;
        }
    }

    protected static <T> T parse(byte[] bArr, JsonReaderI<T> jsonReaderI) {
        try {
            return (T) new JSONParser(JSONParser.DEFAULT_PERMISSIVE_MODE).parse(bArr, jsonReaderI);
        } catch (Exception unused) {
            return null;
        }
    }

    protected static <T> T parse(String str, JsonReaderI<T> jsonReaderI) {
        try {
            return (T) new JSONParser(JSONParser.DEFAULT_PERMISSIVE_MODE).parse(str, jsonReaderI);
        } catch (Exception unused) {
            return null;
        }
    }

    public static Object parse(String str) {
        try {
            return new JSONParser(JSONParser.DEFAULT_PERMISSIVE_MODE).parse(str);
        } catch (Exception unused) {
            return null;
        }
    }

    public static Object parseKeepingOrder(Reader reader) {
        try {
            return new JSONParser(JSONParser.DEFAULT_PERMISSIVE_MODE).parse(reader, defaultReader.DEFAULT_ORDERED);
        } catch (Exception unused) {
            return null;
        }
    }

    public static Object parseKeepingOrder(String str) {
        try {
            return new JSONParser(JSONParser.DEFAULT_PERMISSIVE_MODE).parse(str, defaultReader.DEFAULT_ORDERED);
        } catch (Exception unused) {
            return null;
        }
    }

    public static String compress(String str, JSONStyle jSONStyle) {
        try {
            StringBuilder sb = new StringBuilder();
            new JSONParser(JSONParser.DEFAULT_PERMISSIVE_MODE).parse(str, new CompessorMapper(defaultReader, sb, jSONStyle));
            return sb.toString();
        } catch (Exception unused) {
            return str;
        }
    }

    public static String compress(String str) {
        return compress(str, JSONStyle.MAX_COMPRESS);
    }

    public static String uncompress(String str) {
        return compress(str, JSONStyle.NO_COMPRESS);
    }

    public static Object parseWithException(byte[] bArr) throws IOException, ParseException {
        return new JSONParser(JSONParser.DEFAULT_PERMISSIVE_MODE).parse(bArr, defaultReader.DEFAULT);
    }

    public static Object parseWithException(InputStream inputStream) throws IOException, ParseException {
        return new JSONParser(JSONParser.DEFAULT_PERMISSIVE_MODE).parse(inputStream, defaultReader.DEFAULT);
    }

    public static Object parseWithException(Reader reader) throws IOException, ParseException {
        return new JSONParser(JSONParser.DEFAULT_PERMISSIVE_MODE).parse(reader, defaultReader.DEFAULT);
    }

    public static Object parseWithException(String str) throws ParseException {
        return new JSONParser(JSONParser.DEFAULT_PERMISSIVE_MODE).parse(str, defaultReader.DEFAULT);
    }

    public static <T> T parseWithException(String str, Class<T> cls) throws ParseException {
        return (T) new JSONParser(JSONParser.DEFAULT_PERMISSIVE_MODE).parse(str, defaultReader.getMapper((Class) cls));
    }

    public static Object parseStrict(Reader reader) throws IOException, ParseException {
        return new JSONParser(JSONParser.MODE_RFC4627).parse(reader, defaultReader.DEFAULT);
    }

    public static Object parseStrict(String str) throws ParseException {
        return new JSONParser(JSONParser.MODE_RFC4627).parse(str, defaultReader.DEFAULT);
    }

    public static boolean isValidJsonStrict(Reader reader) throws IOException {
        try {
            new JSONParser(JSONParser.MODE_RFC4627).parse(reader, FakeMapper.DEFAULT);
            return true;
        } catch (ParseException unused) {
            return false;
        }
    }

    public static boolean isValidJsonStrict(String str) {
        try {
            new JSONParser(JSONParser.MODE_RFC4627).parse(str, FakeMapper.DEFAULT);
            return true;
        } catch (ParseException unused) {
            return false;
        }
    }

    public static boolean isValidJson(Reader reader) throws IOException {
        try {
            new JSONParser(JSONParser.DEFAULT_PERMISSIVE_MODE).parse(reader, FakeMapper.DEFAULT);
            return true;
        } catch (ParseException unused) {
            return false;
        }
    }

    public static boolean isValidJson(String str) {
        try {
            new JSONParser(JSONParser.DEFAULT_PERMISSIVE_MODE).parse(str, FakeMapper.DEFAULT);
            return true;
        } catch (ParseException unused) {
            return false;
        }
    }

    public static void writeJSONString(Object obj, Appendable appendable) throws IOException {
        writeJSONString(obj, appendable, COMPRESSION);
    }

    public static <T> void remapField(Class<T> cls, String str, String str2) {
        defaultReader.remapField(cls, str, str2);
        defaultWriter.remapField(cls, str2, str);
    }

    public static <T> void registerWriter(Class<?> cls, JsonWriterI<T> jsonWriterI) {
        defaultWriter.registerWriter(jsonWriterI, cls);
    }

    public static <T> void registerReader(Class<T> cls, JsonReaderI<T> jsonReaderI) {
        defaultReader.registerReader(cls, jsonReaderI);
    }

    public static void writeJSONString(Object obj, Appendable appendable, JSONStyle jSONStyle) throws IOException {
        if (obj == null) {
            appendable.append("null");
            return;
        }
        Class<?> cls = obj.getClass();
        JsonWriter jsonWriter = defaultWriter;
        JsonWriterI<Object> write = jsonWriter.getWrite(cls);
        if (write == null) {
            if (cls.isArray()) {
                write = JsonWriter.arrayWriter;
            } else {
                write = jsonWriter.getWriterByInterface(obj.getClass());
                if (write == null) {
                    write = JsonWriter.beansWriterASM;
                }
            }
            jsonWriter.registerWriter(write, cls);
        }
        write.writeJSONString(obj, appendable, jSONStyle);
    }

    public static String toJSONString(Object obj) {
        return toJSONString(obj, COMPRESSION);
    }

    public static String toJSONString(Object obj, JSONStyle jSONStyle) {
        StringBuilder sb = new StringBuilder();
        try {
            writeJSONString(obj, sb, jSONStyle);
        } catch (IOException unused) {
        }
        return sb.toString();
    }

    public static String escape(String str) {
        return escape(str, COMPRESSION);
    }

    public static String escape(String str, JSONStyle jSONStyle) {
        if (str == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        jSONStyle.escape(str, sb);
        return sb.toString();
    }

    public static void escape(String str, Appendable appendable) {
        escape(str, appendable, COMPRESSION);
    }

    public static void escape(String str, Appendable appendable, JSONStyle jSONStyle) {
        if (str != null) {
            jSONStyle.escape(str, appendable);
        }
    }
}
