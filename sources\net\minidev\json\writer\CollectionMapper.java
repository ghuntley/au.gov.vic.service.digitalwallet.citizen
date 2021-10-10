package net.minidev.json.writer;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;
import net.minidev.asm.BeansAccess;
import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;
import net.minidev.json.JSONUtil;

public class CollectionMapper {

    public static class MapType<T> extends JsonReaderI<T> {
        final BeansAccess<?> ba;
        final Class<?> instance;
        final Class<?> keyClass;
        final Type keyType;
        final Class<?> rawClass;
        JsonReaderI<?> subMapper;
        final ParameterizedType type;
        final Class<?> valueClass;
        final Type valueType;

        public MapType(JsonReader jsonReader, ParameterizedType parameterizedType) {
            super(jsonReader);
            this.type = parameterizedType;
            Class<?> cls = (Class) parameterizedType.getRawType();
            this.rawClass = cls;
            if (cls.isInterface()) {
                this.instance = JSONObject.class;
            } else {
                this.instance = cls;
            }
            this.ba = BeansAccess.get(this.instance, JSONUtil.JSON_SMART_FIELD_FILTER);
            Type type2 = parameterizedType.getActualTypeArguments()[0];
            this.keyType = type2;
            Type type3 = parameterizedType.getActualTypeArguments()[1];
            this.valueType = type3;
            if (type2 instanceof Class) {
                this.keyClass = (Class) type2;
            } else {
                this.keyClass = (Class) ((ParameterizedType) type2).getRawType();
            }
            if (type3 instanceof Class) {
                this.valueClass = (Class) type3;
            } else {
                this.valueClass = (Class) ((ParameterizedType) type3).getRawType();
            }
        }

        @Override // net.minidev.json.writer.JsonReaderI
        public Object createObject() {
            try {
                return this.instance.newInstance();
            } catch (InstantiationException e) {
                e.printStackTrace();
                return null;
            } catch (IllegalAccessException e2) {
                e2.printStackTrace();
                return null;
            }
        }

        @Override // net.minidev.json.writer.JsonReaderI
        public JsonReaderI<?> startArray(String str) {
            if (this.subMapper == null) {
                this.subMapper = this.base.getMapper(this.valueType);
            }
            return this.subMapper;
        }

        @Override // net.minidev.json.writer.JsonReaderI
        public JsonReaderI<?> startObject(String str) {
            if (this.subMapper == null) {
                this.subMapper = this.base.getMapper(this.valueType);
            }
            return this.subMapper;
        }

        @Override // net.minidev.json.writer.JsonReaderI
        public void setValue(Object obj, String str, Object obj2) {
            ((Map) obj).put(JSONUtil.convertToX(str, this.keyClass), JSONUtil.convertToX(obj2, this.valueClass));
        }

        @Override // net.minidev.json.writer.JsonReaderI
        public Object getValue(Object obj, String str) {
            return ((Map) obj).get(JSONUtil.convertToX(str, this.keyClass));
        }

        @Override // net.minidev.json.writer.JsonReaderI
        public Type getType(String str) {
            return this.type;
        }
    }

    public static class MapClass<T> extends JsonReaderI<T> {
        final BeansAccess<?> ba;
        final Class<?> instance;
        JsonReaderI<?> subMapper;
        final Class<?> type;

        public MapClass(JsonReader jsonReader, Class<?> cls) {
            super(jsonReader);
            this.type = cls;
            if (cls.isInterface()) {
                this.instance = JSONObject.class;
            } else {
                this.instance = cls;
            }
            this.ba = BeansAccess.get(this.instance, JSONUtil.JSON_SMART_FIELD_FILTER);
        }

        @Override // net.minidev.json.writer.JsonReaderI
        public Object createObject() {
            return this.ba.newInstance();
        }

        @Override // net.minidev.json.writer.JsonReaderI
        public JsonReaderI<?> startArray(String str) {
            return this.base.DEFAULT;
        }

        @Override // net.minidev.json.writer.JsonReaderI
        public JsonReaderI<?> startObject(String str) {
            return this.base.DEFAULT;
        }

        @Override // net.minidev.json.writer.JsonReaderI
        public void setValue(Object obj, String str, Object obj2) {
            ((Map) obj).put(str, obj2);
        }

        @Override // net.minidev.json.writer.JsonReaderI
        public Object getValue(Object obj, String str) {
            return ((Map) obj).get(str);
        }

        @Override // net.minidev.json.writer.JsonReaderI
        public Type getType(String str) {
            return this.type;
        }
    }

    public static class ListType<T> extends JsonReaderI<T> {
        final BeansAccess<?> ba;
        final Class<?> instance;
        final Class<?> rawClass;
        JsonReaderI<?> subMapper;
        final ParameterizedType type;
        final Class<?> valueClass;
        final Type valueType;

        public ListType(JsonReader jsonReader, ParameterizedType parameterizedType) {
            super(jsonReader);
            this.type = parameterizedType;
            Class<?> cls = (Class) parameterizedType.getRawType();
            this.rawClass = cls;
            if (cls.isInterface()) {
                this.instance = JSONArray.class;
            } else {
                this.instance = cls;
            }
            this.ba = BeansAccess.get(this.instance, JSONUtil.JSON_SMART_FIELD_FILTER);
            Type type2 = parameterizedType.getActualTypeArguments()[0];
            this.valueType = type2;
            if (type2 instanceof Class) {
                this.valueClass = (Class) type2;
            } else {
                this.valueClass = (Class) ((ParameterizedType) type2).getRawType();
            }
        }

        @Override // net.minidev.json.writer.JsonReaderI
        public Object createArray() {
            return this.ba.newInstance();
        }

        @Override // net.minidev.json.writer.JsonReaderI
        public JsonReaderI<?> startArray(String str) {
            if (this.subMapper == null) {
                this.subMapper = this.base.getMapper(this.type.getActualTypeArguments()[0]);
            }
            return this.subMapper;
        }

        @Override // net.minidev.json.writer.JsonReaderI
        public JsonReaderI<?> startObject(String str) {
            if (this.subMapper == null) {
                this.subMapper = this.base.getMapper(this.type.getActualTypeArguments()[0]);
            }
            return this.subMapper;
        }

        @Override // net.minidev.json.writer.JsonReaderI
        public void addValue(Object obj, Object obj2) {
            ((List) obj).add(JSONUtil.convertToX(obj2, this.valueClass));
        }
    }

    public static class ListClass<T> extends JsonReaderI<T> {
        final BeansAccess<?> ba;
        final Class<?> instance;
        JsonReaderI<?> subMapper;
        final Class<?> type;

        public ListClass(JsonReader jsonReader, Class<?> cls) {
            super(jsonReader);
            this.type = cls;
            if (cls.isInterface()) {
                this.instance = JSONArray.class;
            } else {
                this.instance = cls;
            }
            this.ba = BeansAccess.get(this.instance, JSONUtil.JSON_SMART_FIELD_FILTER);
        }

        @Override // net.minidev.json.writer.JsonReaderI
        public Object createArray() {
            return this.ba.newInstance();
        }

        @Override // net.minidev.json.writer.JsonReaderI
        public JsonReaderI<?> startArray(String str) {
            return this.base.DEFAULT;
        }

        @Override // net.minidev.json.writer.JsonReaderI
        public JsonReaderI<?> startObject(String str) {
            return this.base.DEFAULT;
        }

        @Override // net.minidev.json.writer.JsonReaderI
        public void addValue(Object obj, Object obj2) {
            ((List) obj).add(obj2);
        }
    }
}
