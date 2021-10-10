package net.minidev.json.parser;

import net.minidev.json.JSONValue;
import net.minidev.json.writer.JsonReaderI;

/* access modifiers changed from: package-private */
public class JSONParserByteArray extends JSONParserMemory {
    private byte[] in;

    public JSONParserByteArray(int i) {
        super(i);
    }

    public Object parse(byte[] bArr) throws ParseException {
        return parse(bArr, JSONValue.defaultReader.DEFAULT);
    }

    public <T> T parse(byte[] bArr, JsonReaderI<T> jsonReaderI) throws ParseException {
        this.base = jsonReaderI.base;
        this.in = bArr;
        this.len = bArr.length;
        return (T) parse(jsonReaderI);
    }

    /* access modifiers changed from: protected */
    @Override // net.minidev.json.parser.JSONParserMemory
    public void extractString(int i, int i2) {
        this.xs = new String(this.in, i, i2 - i);
    }

    /* access modifiers changed from: protected */
    @Override // net.minidev.json.parser.JSONParserMemory
    public void extractStringTrim(int i, int i2) {
        byte[] bArr = this.in;
        while (i < i2 && bArr[i] <= 32) {
            i++;
        }
        while (i < i2 && bArr[i2 - 1] <= 32) {
            i2--;
        }
        this.xs = new String(this.in, i, i2 - i);
    }

    /* access modifiers changed from: protected */
    @Override // net.minidev.json.parser.JSONParserMemory
    public int indexOf(char c, int i) {
        int i2 = i;
        while (i < this.len) {
            if (this.in[i2] == ((byte) c)) {
                return i2;
            }
            i2++;
        }
        return -1;
    }

    /* access modifiers changed from: protected */
    @Override // net.minidev.json.parser.JSONParserBase
    public void read() {
        int i = this.pos + 1;
        this.pos = i;
        if (i >= this.len) {
            this.c = 26;
        } else {
            this.c = (char) this.in[this.pos];
        }
    }

    /* access modifiers changed from: protected */
    @Override // net.minidev.json.parser.JSONParserBase
    public void readS() {
        int i = this.pos + 1;
        this.pos = i;
        if (i >= this.len) {
            this.c = 26;
        } else {
            this.c = (char) this.in[this.pos];
        }
    }

    /* access modifiers changed from: protected */
    @Override // net.minidev.json.parser.JSONParserBase
    public void readNoEnd() throws ParseException {
        int i = this.pos + 1;
        this.pos = i;
        if (i < this.len) {
            this.c = (char) this.in[this.pos];
        } else {
            this.c = 26;
            throw new ParseException(this.pos - 1, 3, "EOF");
        }
    }
}
