package net.minidev.json.parser;

import java.io.IOException;

/* access modifiers changed from: package-private */
public abstract class JSONParserStream extends JSONParserBase {
    public JSONParserStream(int i) {
        super(i);
    }

    /* access modifiers changed from: protected */
    @Override // net.minidev.json.parser.JSONParserBase
    public void readNQString(boolean[] zArr) throws IOException {
        this.sb.clear();
        skipNQString(zArr);
        this.xs = this.sb.toString().trim();
    }

    /* access modifiers changed from: protected */
    @Override // net.minidev.json.parser.JSONParserBase
    public Object readNumber(boolean[] zArr) throws ParseException, IOException {
        this.sb.clear();
        this.sb.append(this.c);
        read();
        skipDigits();
        if (this.c == '.' || this.c == 'E' || this.c == 'e') {
            if (this.c == '.') {
                this.sb.append(this.c);
                read();
                skipDigits();
            }
            if (this.c == 'E' || this.c == 'e') {
                this.sb.append('E');
                read();
                if (this.c == '+' || this.c == '-' || (this.c >= '0' && this.c <= '9')) {
                    this.sb.append(this.c);
                    read();
                    skipDigits();
                    skipSpace();
                    if (this.c < 0 || this.c >= '~' || zArr[this.c] || this.c == 26) {
                        this.xs = this.sb.toString().trim();
                        return extractFloat();
                    }
                    skipNQString(zArr);
                    this.xs = this.sb.toString().trim();
                    if (this.acceptNonQuote) {
                        return this.xs;
                    }
                    throw new ParseException(this.pos, 1, this.xs);
                }
                skipNQString(zArr);
                this.xs = this.sb.toString().trim();
                if (this.acceptNonQuote) {
                    if (!this.acceptLeadinZero) {
                        checkLeadinZero();
                    }
                    return this.xs;
                }
                throw new ParseException(this.pos, 1, this.xs);
            }
            skipSpace();
            if (this.c < 0 || this.c >= '~' || zArr[this.c] || this.c == 26) {
                this.xs = this.sb.toString().trim();
                return extractFloat();
            }
            skipNQString(zArr);
            this.xs = this.sb.toString().trim();
            if (this.acceptNonQuote) {
                return this.xs;
            }
            throw new ParseException(this.pos, 1, this.xs);
        }
        skipSpace();
        if (this.c < 0 || this.c >= '~' || zArr[this.c] || this.c == 26) {
            this.xs = this.sb.toString().trim();
            return parseNumber(this.xs);
        }
        skipNQString(zArr);
        this.xs = this.sb.toString().trim();
        if (this.acceptNonQuote) {
            return this.xs;
        }
        throw new ParseException(this.pos, 1, this.xs);
    }

    /* access modifiers changed from: protected */
    @Override // net.minidev.json.parser.JSONParserBase
    public void readString() throws ParseException, IOException {
        if (this.acceptSimpleQuote || this.c != '\'') {
            this.sb.clear();
            readString2();
        } else if (this.acceptNonQuote) {
            readNQString(stopAll);
        } else {
            throw new ParseException(this.pos, 0, Character.valueOf(this.c));
        }
    }
}
