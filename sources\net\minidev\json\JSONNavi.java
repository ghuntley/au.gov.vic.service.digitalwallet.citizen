package net.minidev.json;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import net.minidev.json.writer.JsonReaderI;

public class JSONNavi<T> {
    private static final JSONStyle ERROR_COMPRESS = new JSONStyle(2);
    private Object current;
    private boolean failure = false;
    private String failureMessage;
    private JsonReaderI<? super T> mapper;
    private Object missingKey = null;
    private Stack<Object> path = new Stack<>();
    private boolean readonly = false;
    private T root;
    private Stack<Object> stack = new Stack<>();

    public static JSONNavi<JSONAwareEx> newInstance() {
        return new JSONNavi<>(JSONValue.defaultReader.DEFAULT_ORDERED);
    }

    public static JSONNavi<JSONObject> newInstanceObject() {
        JSONNavi<JSONObject> jSONNavi = new JSONNavi<>(JSONValue.defaultReader.getMapper((Class) JSONObject.class));
        jSONNavi.object();
        return jSONNavi;
    }

    public static JSONNavi<JSONArray> newInstanceArray() {
        JSONNavi<JSONArray> jSONNavi = new JSONNavi<>(JSONValue.defaultReader.getMapper((Class) JSONArray.class));
        jSONNavi.array();
        return jSONNavi;
    }

    public JSONNavi(JsonReaderI<? super T> jsonReaderI) {
        this.mapper = jsonReaderI;
    }

    public JSONNavi(String str) {
        T t = (T) JSONValue.parse(str);
        this.root = t;
        this.current = t;
        this.readonly = true;
    }

    public JSONNavi(String str, JsonReaderI<T> jsonReaderI) {
        T t = (T) JSONValue.parse(str, (JsonReaderI) jsonReaderI);
        this.root = t;
        this.mapper = jsonReaderI;
        this.current = t;
        this.readonly = true;
    }

    public JSONNavi(String str, Class<T> cls) {
        this.root = (T) JSONValue.parse(str, (Class) cls);
        this.mapper = JSONValue.defaultReader.getMapper((Class) cls);
        this.current = this.root;
        this.readonly = true;
    }

    public JSONNavi<T> root() {
        this.current = this.root;
        this.stack.clear();
        this.path.clear();
        this.failure = false;
        this.missingKey = null;
        this.failureMessage = null;
        return this;
    }

    public boolean hasFailure() {
        return this.failure;
    }

    public Object getCurrentObject() {
        return this.current;
    }

    public Collection<String> getKeys() {
        Object obj = this.current;
        if (obj instanceof Map) {
            return ((Map) obj).keySet();
        }
        return null;
    }

    public int getSize() {
        if (this.current == null) {
            return 0;
        }
        if (isArray()) {
            return ((List) this.current).size();
        }
        if (isObject()) {
            return ((Map) this.current).size();
        }
        return 1;
    }

    public String getString(String str) {
        if (!hasKey(str)) {
            return null;
        }
        at(str);
        String asString = asString();
        up();
        return asString;
    }

    public int getInt(String str) {
        if (!hasKey(str)) {
            return 0;
        }
        at(str);
        int asInt = asInt();
        up();
        return asInt;
    }

    public Integer getInteger(String str) {
        if (!hasKey(str)) {
            return null;
        }
        at(str);
        Integer asIntegerObj = asIntegerObj();
        up();
        return asIntegerObj;
    }

    public double getDouble(String str) {
        if (!hasKey(str)) {
            return 0.0d;
        }
        at(str);
        double asDouble = asDouble();
        up();
        return asDouble;
    }

    public boolean hasKey(String str) {
        if (!isObject()) {
            return false;
        }
        return o(this.current).containsKey(str);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: net.minidev.json.JSONNavi<T> */
    /* JADX WARN: Multi-variable type inference failed */
    public JSONNavi<?> at(String str) {
        if (this.failure) {
            return this;
        }
        if (!isObject()) {
            object();
        }
        Object obj = this.current;
        if (!(obj instanceof Map)) {
            return failure("current node is not an Object", str);
        }
        if (o(obj).containsKey(str)) {
            Object obj2 = o(this.current).get(str);
            this.stack.add(this.current);
            this.path.add(str);
            this.current = obj2;
            return this;
        } else if (this.readonly) {
            return failure("current Object have no key named " + str, str);
        } else {
            this.stack.add(this.current);
            this.path.add(str);
            this.current = null;
            this.missingKey = str;
            return this;
        }
    }

    public Object get(String str) {
        if (this.failure) {
            return this;
        }
        if (!isObject()) {
            object();
        }
        Object obj = this.current;
        if (!(obj instanceof Map)) {
            return failure("current node is not an Object", str);
        }
        return o(obj).get(str);
    }

    public Object get(int i) {
        if (this.failure) {
            return this;
        }
        if (!isArray()) {
            array();
        }
        Object obj = this.current;
        if (!(obj instanceof List)) {
            return failure("current node is not an List", Integer.valueOf(i));
        }
        return a(obj).get(i);
    }

    public JSONNavi<T> set(String str, String str2) {
        object();
        if (this.failure) {
            return this;
        }
        o(this.current).put(str, str2);
        return this;
    }

    public JSONNavi<T> set(String str, Number number) {
        object();
        if (this.failure) {
            return this;
        }
        o(this.current).put(str, number);
        return this;
    }

    public JSONNavi<T> set(String str, long j) {
        return set(str, Long.valueOf(j));
    }

    public JSONNavi<T> set(String str, int i) {
        return set(str, Integer.valueOf(i));
    }

    public JSONNavi<T> set(String str, double d) {
        return set(str, Double.valueOf(d));
    }

    public JSONNavi<T> set(String str, float f) {
        return set(str, Float.valueOf(f));
    }

    public JSONNavi<T> add(Object... objArr) {
        array();
        if (this.failure) {
            return this;
        }
        List<Object> a = a(this.current);
        for (Object obj : objArr) {
            a.add(obj);
        }
        return this;
    }

    public String asString() {
        Object obj = this.current;
        if (obj == null) {
            return null;
        }
        if (obj instanceof String) {
            return (String) obj;
        }
        return obj.toString();
    }

    public double asDouble() {
        Object obj = this.current;
        if (obj instanceof Number) {
            return ((Number) obj).doubleValue();
        }
        return Double.NaN;
    }

    public Double asDoubleObj() {
        Object obj = this.current;
        if (obj == null) {
            return null;
        }
        if (!(obj instanceof Number)) {
            return Double.valueOf(Double.NaN);
        }
        if (obj instanceof Double) {
            return (Double) obj;
        }
        return Double.valueOf(((Number) obj).doubleValue());
    }

    public double asFloat() {
        Object obj = this.current;
        if (obj instanceof Number) {
            return (double) ((Number) obj).floatValue();
        }
        return Double.NaN;
    }

    public Float asFloatObj() {
        Object obj = this.current;
        if (obj == null) {
            return null;
        }
        if (!(obj instanceof Number)) {
            return Float.valueOf(Float.NaN);
        }
        if (obj instanceof Float) {
            return (Float) obj;
        }
        return Float.valueOf(((Number) obj).floatValue());
    }

    public int asInt() {
        Object obj = this.current;
        if (obj instanceof Number) {
            return ((Number) obj).intValue();
        }
        return 0;
    }

    public Integer asIntegerObj() {
        Object obj = this.current;
        if (obj != null && (obj instanceof Number)) {
            if (obj instanceof Integer) {
                return (Integer) obj;
            }
            if (obj instanceof Long) {
                Long l = (Long) obj;
                if (l.longValue() == ((long) l.intValue())) {
                    return Integer.valueOf(l.intValue());
                }
            }
        }
        return null;
    }

    public long asLong() {
        Object obj = this.current;
        if (obj instanceof Number) {
            return ((Number) obj).longValue();
        }
        return 0;
    }

    public Long asLongObj() {
        Object obj = this.current;
        if (obj != null && (obj instanceof Number)) {
            if (obj instanceof Long) {
                return (Long) obj;
            }
            if (obj instanceof Integer) {
                return Long.valueOf(((Number) obj).longValue());
            }
        }
        return null;
    }

    public boolean asBoolean() {
        Object obj = this.current;
        if (obj instanceof Boolean) {
            return ((Boolean) obj).booleanValue();
        }
        return false;
    }

    public Boolean asBooleanObj() {
        Object obj = this.current;
        if (obj != null && (obj instanceof Boolean)) {
            return (Boolean) obj;
        }
        return null;
    }

    public JSONNavi<T> object() {
        if (this.failure) {
            return this;
        }
        if (this.current == null && this.readonly) {
            failure("Can not create Object child in readonly", null);
        }
        if (this.current == null) {
            this.current = this.mapper.createObject();
        } else if (isObject()) {
            return this;
        } else {
            if (isArray()) {
                failure("can not use Object feature on Array.", null);
            }
            failure("Can not use current possition as Object", null);
        }
        if (this.root == null) {
            this.root = (T) this.current;
        } else {
            store();
        }
        return this;
    }

    public JSONNavi<T> array() {
        if (this.failure) {
            return this;
        }
        if (this.current == null && this.readonly) {
            failure("Can not create Array child in readonly", null);
        }
        if (this.current == null) {
            this.current = this.mapper.createArray();
        } else if (isArray()) {
            return this;
        } else {
            if (isObject()) {
                failure("can not use Object feature on Array.", null);
            }
            failure("Can not use current possition as Object", null);
        }
        if (this.root == null) {
            this.root = (T) this.current;
        } else {
            store();
        }
        return this;
    }

    public JSONNavi<T> set(Number number) {
        if (this.failure) {
            return this;
        }
        this.current = number;
        store();
        return this;
    }

    public JSONNavi<T> set(Boolean bool) {
        if (this.failure) {
            return this;
        }
        this.current = bool;
        store();
        return this;
    }

    public JSONNavi<T> set(String str) {
        if (this.failure) {
            return this;
        }
        this.current = str;
        store();
        return this;
    }

    public T getRoot() {
        return this.root;
    }

    private void store() {
        Object peek = this.stack.peek();
        if (isObject(peek)) {
            o(peek).put((String) this.missingKey, this.current);
        } else if (isArray(peek)) {
            int intValue = ((Number) this.missingKey).intValue();
            List<Object> a = a(peek);
            while (a.size() <= intValue) {
                a.add(null);
            }
            a.set(intValue, this.current);
        }
    }

    public boolean isArray() {
        return isArray(this.current);
    }

    public boolean isObject() {
        return isObject(this.current);
    }

    private boolean isArray(Object obj) {
        if (obj == null) {
            return false;
        }
        return obj instanceof List;
    }

    private boolean isObject(Object obj) {
        if (obj == null) {
            return false;
        }
        return obj instanceof Map;
    }

    private List<Object> a(Object obj) {
        return (List) obj;
    }

    private Map<String, Object> o(Object obj) {
        return (Map) obj;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: net.minidev.json.JSONNavi<T> */
    /* JADX WARN: Multi-variable type inference failed */
    public JSONNavi<?> at(int i) {
        if (this.failure) {
            return this;
        }
        Object obj = this.current;
        if (!(obj instanceof List)) {
            return failure("current node is not an Array", Integer.valueOf(i));
        }
        List list = (List) obj;
        if (i < 0 && (i = i + list.size()) < 0) {
            i = 0;
        }
        if (i < list.size()) {
            Object obj2 = list.get(i);
            this.stack.add(this.current);
            this.path.add(Integer.valueOf(i));
            this.current = obj2;
            return this;
        } else if (this.readonly) {
            return failure("Out of bound exception for index", Integer.valueOf(i));
        } else {
            this.stack.add(this.current);
            this.path.add(Integer.valueOf(i));
            this.current = null;
            this.missingKey = Integer.valueOf(i);
            return this;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: net.minidev.json.JSONNavi<T> */
    /* JADX WARN: Multi-variable type inference failed */
    public JSONNavi<?> atNext() {
        if (this.failure) {
            return this;
        }
        Object obj = this.current;
        if (!(obj instanceof List)) {
            return failure("current node is not an Array", null);
        }
        return at(((List) obj).size());
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: net.minidev.json.JSONNavi<T> */
    /* JADX WARN: Multi-variable type inference failed */
    public JSONNavi<?> up(int i) {
        while (true) {
            int i2 = i - 1;
            if (i > 0 && this.stack.size() > 0) {
                this.current = this.stack.pop();
                this.path.pop();
                i = i2;
            }
        }
        return this;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: net.minidev.json.JSONNavi<T> */
    /* JADX WARN: Multi-variable type inference failed */
    public JSONNavi<?> up() {
        if (this.stack.size() > 0) {
            this.current = this.stack.pop();
            this.path.pop();
        }
        return this;
    }

    public String toString() {
        if (this.failure) {
            return JSONValue.toJSONString(this.failureMessage, ERROR_COMPRESS);
        }
        return JSONValue.toJSONString(this.root);
    }

    public String toString(JSONStyle jSONStyle) {
        if (this.failure) {
            return JSONValue.toJSONString(this.failureMessage, jSONStyle);
        }
        return JSONValue.toJSONString(this.root, jSONStyle);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: net.minidev.json.JSONNavi<T> */
    /* JADX WARN: Multi-variable type inference failed */
    private JSONNavi<?> failure(String str, Object obj) {
        this.failure = true;
        StringBuilder sb = new StringBuilder();
        sb.append("Error: ");
        sb.append(str);
        sb.append(" at ");
        sb.append(getJPath());
        if (obj != null) {
            if (obj instanceof Integer) {
                sb.append('[');
                sb.append(obj);
                sb.append(']');
            } else {
                sb.append('/');
                sb.append(obj);
            }
        }
        this.failureMessage = sb.toString();
        return this;
    }

    public String getJPath() {
        StringBuilder sb = new StringBuilder();
        Iterator<Object> it = this.path.iterator();
        while (it.hasNext()) {
            Object next = it.next();
            if (next instanceof String) {
                sb.append('/');
                sb.append(next.toString());
            } else {
                sb.append('[');
                sb.append(next.toString());
                sb.append(']');
            }
        }
        return sb.toString();
    }
}
