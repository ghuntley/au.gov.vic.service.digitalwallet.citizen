package net.minidev.json;

import java.io.IOException;
import kotlin.text.Typography;
import net.minidev.json.JStylerObj;

public class JSONStyle {
    public static final int FLAG_AGRESSIVE = 8;
    public static final int FLAG_IGNORE_NULL = 16;
    public static final int FLAG_PROTECT_4WEB = 2;
    public static final int FLAG_PROTECT_KEYS = 1;
    public static final int FLAG_PROTECT_VALUES = 4;
    public static final JSONStyle LT_COMPRESS = new JSONStyle(2);
    public static final JSONStyle MAX_COMPRESS = new JSONStyle(-1);
    public static final JSONStyle NO_COMPRESS = new JSONStyle(0);
    private boolean _ignore_null;
    private boolean _protect4Web;
    private boolean _protectKeys;
    private boolean _protectValues;
    private JStylerObj.StringProtector esc;
    private JStylerObj.MustProtect mpKey;
    private JStylerObj.MustProtect mpValue;

    public void arrayObjectEnd(Appendable appendable) throws IOException {
    }

    public void arrayfirstObject(Appendable appendable) throws IOException {
    }

    public boolean indent() {
        return false;
    }

    public void objectElmStop(Appendable appendable) throws IOException {
    }

    public void objectFirstStart(Appendable appendable) throws IOException {
    }

    public JSONStyle(int i) {
        JStylerObj.MustProtect mustProtect;
        boolean z = false;
        this._protectKeys = (i & 1) == 0;
        this._protectValues = (i & 4) == 0;
        this._protect4Web = (i & 2) == 0;
        this._ignore_null = (i & 16) > 0 ? true : z;
        if ((i & 8) > 0) {
            mustProtect = JStylerObj.MP_AGGRESIVE;
        } else {
            mustProtect = JStylerObj.MP_SIMPLE;
        }
        if (this._protectValues) {
            this.mpValue = JStylerObj.MP_TRUE;
        } else {
            this.mpValue = mustProtect;
        }
        if (this._protectKeys) {
            this.mpKey = JStylerObj.MP_TRUE;
        } else {
            this.mpKey = mustProtect;
        }
        if (this._protect4Web) {
            this.esc = JStylerObj.ESCAPE4Web;
        } else {
            this.esc = JStylerObj.ESCAPE_LT;
        }
    }

    public JSONStyle() {
        this(0);
    }

    public boolean protectKeys() {
        return this._protectKeys;
    }

    public boolean protectValues() {
        return this._protectValues;
    }

    public boolean protect4Web() {
        return this._protect4Web;
    }

    public boolean ignoreNull() {
        return this._ignore_null;
    }

    public boolean mustProtectKey(String str) {
        return this.mpKey.mustBeProtect(str);
    }

    public boolean mustProtectValue(String str) {
        return this.mpValue.mustBeProtect(str);
    }

    public void writeString(Appendable appendable, String str) throws IOException {
        if (!mustProtectValue(str)) {
            appendable.append(str);
            return;
        }
        appendable.append(Typography.quote);
        JSONValue.escape(str, appendable, this);
        appendable.append(Typography.quote);
    }

    public void escape(String str, Appendable appendable) {
        this.esc.escape(str, appendable);
    }

    public void objectStart(Appendable appendable) throws IOException {
        appendable.append('{');
    }

    public void objectStop(Appendable appendable) throws IOException {
        appendable.append('}');
    }

    public void objectNext(Appendable appendable) throws IOException {
        appendable.append(',');
    }

    public void objectEndOfKey(Appendable appendable) throws IOException {
        appendable.append(':');
    }

    public void arrayStart(Appendable appendable) throws IOException {
        appendable.append('[');
    }

    public void arrayStop(Appendable appendable) throws IOException {
        appendable.append(']');
    }

    public void arrayNextElm(Appendable appendable) throws IOException {
        appendable.append(',');
    }
}
