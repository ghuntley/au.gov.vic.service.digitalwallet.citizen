package net.minidev.json.writer;

import java.io.IOException;
import kotlin.text.Typography;
import net.minidev.json.JSONStyle;
import net.minidev.json.JSONValue;

public class CompessorMapper extends JsonReaderI<CompessorMapper> {
    private Boolean _isObj;
    private JSONStyle compression;
    private boolean isClosed;
    private boolean isOpen;
    private boolean needSep;
    private Appendable out;

    private boolean isArray() {
        return this._isObj == Boolean.FALSE;
    }

    private boolean isObject() {
        return this._isObj == Boolean.TRUE;
    }

    private boolean isCompressor(Object obj) {
        return obj instanceof CompessorMapper;
    }

    public CompessorMapper(JsonReader jsonReader, Appendable appendable, JSONStyle jSONStyle) {
        this(jsonReader, appendable, jSONStyle, null);
    }

    public CompessorMapper(JsonReader jsonReader, Appendable appendable, JSONStyle jSONStyle, Boolean bool) {
        super(jsonReader);
        this.needSep = false;
        this.isOpen = false;
        this.isClosed = false;
        this.out = appendable;
        this.compression = jSONStyle;
        this._isObj = bool;
    }

    @Override // net.minidev.json.writer.JsonReaderI
    public JsonReaderI<?> startObject(String str) throws IOException {
        open(this);
        startKey(str);
        CompessorMapper compessorMapper = new CompessorMapper(this.base, this.out, this.compression, true);
        open(compessorMapper);
        return compessorMapper;
    }

    @Override // net.minidev.json.writer.JsonReaderI
    public JsonReaderI<?> startArray(String str) throws IOException {
        open(this);
        startKey(str);
        CompessorMapper compessorMapper = new CompessorMapper(this.base, this.out, this.compression, false);
        open(compessorMapper);
        return compessorMapper;
    }

    private void startKey(String str) throws IOException {
        addComma();
        if (!isArray()) {
            if (!this.compression.mustProtectKey(str)) {
                this.out.append(str);
            } else {
                this.out.append(Typography.quote);
                JSONValue.escape(str, this.out, this.compression);
                this.out.append(Typography.quote);
            }
            this.out.append(':');
        }
    }

    @Override // net.minidev.json.writer.JsonReaderI
    public void setValue(Object obj, String str, Object obj2) throws IOException {
        if (isCompressor(obj2)) {
            addComma();
            return;
        }
        startKey(str);
        writeValue(obj2);
    }

    @Override // net.minidev.json.writer.JsonReaderI
    public void addValue(Object obj, Object obj2) throws IOException {
        addComma();
        writeValue(obj2);
    }

    private void addComma() throws IOException {
        if (this.needSep) {
            this.out.append(',');
        } else {
            this.needSep = true;
        }
    }

    private void writeValue(Object obj) throws IOException {
        if (obj instanceof String) {
            this.compression.writeString(this.out, (String) obj);
        } else if (isCompressor(obj)) {
            close(obj);
        } else {
            JSONValue.writeJSONString(obj, this.out, this.compression);
        }
    }

    @Override // net.minidev.json.writer.JsonReaderI
    public Object createObject() {
        this._isObj = true;
        try {
            open(this);
        } catch (Exception unused) {
        }
        return this;
    }

    @Override // net.minidev.json.writer.JsonReaderI
    public Object createArray() {
        this._isObj = false;
        try {
            open(this);
        } catch (Exception unused) {
        }
        return this;
    }

    @Override // net.minidev.json.writer.JsonReaderI
    public CompessorMapper convert(Object obj) {
        try {
            close(obj);
        } catch (Exception unused) {
        }
        return this;
    }

    private void close(Object obj) throws IOException {
        if (isCompressor(obj)) {
            CompessorMapper compessorMapper = (CompessorMapper) obj;
            if (!compessorMapper.isClosed) {
                compessorMapper.isClosed = true;
                if (compessorMapper.isObject()) {
                    this.out.append('}');
                    this.needSep = true;
                } else if (compessorMapper.isArray()) {
                    this.out.append(']');
                    this.needSep = true;
                }
            }
        }
    }

    private void open(Object obj) throws IOException {
        if (isCompressor(obj)) {
            CompessorMapper compessorMapper = (CompessorMapper) obj;
            if (!compessorMapper.isOpen) {
                compessorMapper.isOpen = true;
                if (compessorMapper.isObject()) {
                    this.out.append('{');
                    this.needSep = false;
                } else if (compessorMapper.isArray()) {
                    this.out.append('[');
                    this.needSep = false;
                }
            }
        }
    }
}
