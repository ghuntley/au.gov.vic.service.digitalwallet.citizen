package net.minidev.json.writer;

import java.lang.reflect.Type;
import java.util.Date;
import java.util.HashMap;
import net.minidev.asm.Accessor;
import net.minidev.asm.BeansAccess;
import net.minidev.asm.ConvertDate;
import net.minidev.json.JSONUtil;

public abstract class BeansMapper<T> extends JsonReaderI<T> {
    public static JsonReaderI<Date> MAPPER_DATE = new ArraysMapper<Date>(null) {
        /* class net.minidev.json.writer.BeansMapper.AnonymousClass1 */

        @Override // net.minidev.json.writer.ArraysMapper, net.minidev.json.writer.JsonReaderI
        public Date convert(Object obj) {
            return ConvertDate.convertToDate(obj);
        }
    };

    @Override // net.minidev.json.writer.JsonReaderI
    public abstract Object getValue(Object obj, String str);

    public BeansMapper(JsonReader jsonReader) {
        super(jsonReader);
    }

    public static class Bean<T> extends JsonReaderI<T> {
        final BeansAccess<T> ba;
        final Class<T> clz;
        final HashMap<String, Accessor> index;

        public Bean(JsonReader jsonReader, Class<T> cls) {
            super(jsonReader);
            this.clz = cls;
            BeansAccess<T> beansAccess = BeansAccess.get(cls, JSONUtil.JSON_SMART_FIELD_FILTER);
            this.ba = beansAccess;
            this.index = beansAccess.getMap();
        }

        @Override // net.minidev.json.writer.JsonReaderI
        public void setValue(Object obj, String str, Object obj2) {
            this.ba.set(obj, str, obj2);
        }

        @Override // net.minidev.json.writer.JsonReaderI
        public Object getValue(Object obj, String str) {
            return this.ba.get(obj, str);
        }

        @Override // net.minidev.json.writer.JsonReaderI
        public Type getType(String str) {
            return this.index.get(str).getGenericType();
        }

        @Override // net.minidev.json.writer.JsonReaderI
        public JsonReaderI<?> startArray(String str) {
            Accessor accessor = this.index.get(str);
            if (accessor != null) {
                return this.base.getMapper(accessor.getGenericType());
            }
            throw new RuntimeException("Can not find Array '" + str + "' field in " + this.clz);
        }

        @Override // net.minidev.json.writer.JsonReaderI
        public JsonReaderI<?> startObject(String str) {
            Accessor accessor = this.index.get(str);
            if (accessor != null) {
                return this.base.getMapper(accessor.getGenericType());
            }
            throw new RuntimeException("Can not find Object '" + str + "' field in " + this.clz);
        }

        @Override // net.minidev.json.writer.JsonReaderI
        public Object createObject() {
            return this.ba.newInstance();
        }
    }

    public static class BeanNoConv<T> extends JsonReaderI<T> {
        final BeansAccess<T> ba;
        final Class<T> clz;
        final HashMap<String, Accessor> index;

        public BeanNoConv(JsonReader jsonReader, Class<T> cls) {
            super(jsonReader);
            this.clz = cls;
            BeansAccess<T> beansAccess = BeansAccess.get(cls, JSONUtil.JSON_SMART_FIELD_FILTER);
            this.ba = beansAccess;
            this.index = beansAccess.getMap();
        }

        @Override // net.minidev.json.writer.JsonReaderI
        public void setValue(Object obj, String str, Object obj2) {
            this.ba.set(obj, str, obj2);
        }

        @Override // net.minidev.json.writer.JsonReaderI
        public Object getValue(Object obj, String str) {
            return this.ba.get(obj, str);
        }

        @Override // net.minidev.json.writer.JsonReaderI
        public Type getType(String str) {
            return this.index.get(str).getGenericType();
        }

        @Override // net.minidev.json.writer.JsonReaderI
        public JsonReaderI<?> startArray(String str) {
            Accessor accessor = this.index.get(str);
            if (accessor != null) {
                return this.base.getMapper(accessor.getGenericType());
            }
            throw new RuntimeException("Can not set " + str + " field in " + this.clz);
        }

        @Override // net.minidev.json.writer.JsonReaderI
        public JsonReaderI<?> startObject(String str) {
            Accessor accessor = this.index.get(str);
            if (accessor != null) {
                return this.base.getMapper(accessor.getGenericType());
            }
            throw new RuntimeException("Can not set " + str + " field in " + this.clz);
        }

        @Override // net.minidev.json.writer.JsonReaderI
        public Object createObject() {
            return this.ba.newInstance();
        }
    }
}
