package net.minidev.json.parser;

import java.io.IOException;
import java.io.Reader;
import net.minidev.json.JSONValue;
import net.minidev.json.writer.JsonReaderI;

/* access modifiers changed from: package-private */
public class JSONParserReader extends JSONParserStream {
    private Reader in;

    public JSONParserReader(int i) {
        super(i);
    }

    public Object parse(Reader reader) throws ParseException {
        return parse(reader, JSONValue.defaultReader.DEFAULT);
    }

    public <T> T parse(Reader reader, JsonReaderI<T> jsonReaderI) throws ParseException {
        this.base = jsonReaderI.base;
        this.in = reader;
        return (T) super.parse(jsonReaderI);
    }

    /* access modifiers changed from: protected */
    @Override // net.minidev.json.parser.JSONParserBase
    public void read() throws IOException {
        int read = this.in.read();
        this.c = read == -1 ? 26 : (char) read;
        this.pos++;
    }

    /* access modifiers changed from: protected */
    @Override // net.minidev.json.parser.JSONParserBase
    public void readS() throws IOException {
        this.sb.append(this.c);
        int read = this.in.read();
        if (read == -1) {
            this.c = 26;
            return;
        }
        this.c = (char) read;
        this.pos++;
    }

    /* access modifiers changed from: protected */
    @Override // net.minidev.json.parser.JSONParserBase
    public void readNoEnd() throws ParseException, IOException {
        int read = this.in.read();
        if (read != -1) {
            this.c = (char) read;
            return;
        }
        throw new ParseException(this.pos - 1, 3, "EOF");
    }
}
