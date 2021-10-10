package net.minidev.json.writer;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import net.minidev.json.JSONArray;
import net.minidev.json.JSONAware;
import net.minidev.json.JSONAwareEx;
import net.minidev.json.JSONObject;
import net.minidev.json.writer.ArraysMapper;
import net.minidev.json.writer.BeansMapper;
import net.minidev.json.writer.CollectionMapper;

public class JsonReader {
    public JsonReaderI<JSONAwareEx> DEFAULT = new DefaultMapper(this);
    public JsonReaderI<JSONAwareEx> DEFAULT_ORDERED = new DefaultMapperOrdered(this);
    private final ConcurrentHashMap<Type, JsonReaderI<?>> cache;

    public JsonReader() {
        ConcurrentHashMap<Type, JsonReaderI<?>> concurrentHashMap = new ConcurrentHashMap<>(100);
        this.cache = concurrentHashMap;
        concurrentHashMap.put(Date.class, BeansMapper.MAPPER_DATE);
        concurrentHashMap.put(int[].class, ArraysMapper.MAPPER_PRIM_INT);
        concurrentHashMap.put(Integer[].class, ArraysMapper.MAPPER_INT);
        concurrentHashMap.put(short[].class, ArraysMapper.MAPPER_PRIM_INT);
        concurrentHashMap.put(Short[].class, ArraysMapper.MAPPER_INT);
        concurrentHashMap.put(long[].class, ArraysMapper.MAPPER_PRIM_LONG);
        concurrentHashMap.put(Long[].class, ArraysMapper.MAPPER_LONG);
        concurrentHashMap.put(byte[].class, ArraysMapper.MAPPER_PRIM_BYTE);
        concurrentHashMap.put(Byte[].class, ArraysMapper.MAPPER_BYTE);
        concurrentHashMap.put(char[].class, ArraysMapper.MAPPER_PRIM_CHAR);
        concurrentHashMap.put(Character[].class, ArraysMapper.MAPPER_CHAR);
        concurrentHashMap.put(float[].class, ArraysMapper.MAPPER_PRIM_FLOAT);
        concurrentHashMap.put(Float[].class, ArraysMapper.MAPPER_FLOAT);
        concurrentHashMap.put(double[].class, ArraysMapper.MAPPER_PRIM_DOUBLE);
        concurrentHashMap.put(Double[].class, ArraysMapper.MAPPER_DOUBLE);
        concurrentHashMap.put(boolean[].class, ArraysMapper.MAPPER_PRIM_BOOL);
        concurrentHashMap.put(Boolean[].class, ArraysMapper.MAPPER_BOOL);
        concurrentHashMap.put(JSONAwareEx.class, this.DEFAULT);
        concurrentHashMap.put(JSONAware.class, this.DEFAULT);
        concurrentHashMap.put(JSONArray.class, this.DEFAULT);
        concurrentHashMap.put(JSONObject.class, this.DEFAULT);
    }

    public <T> void remapField(Class<T> cls, String str, String str2) {
        JsonReaderI<T> mapper = getMapper((Class) cls);
        if (!(mapper instanceof MapperRemapped)) {
            MapperRemapped mapperRemapped = new MapperRemapped(mapper);
            registerReader(cls, mapperRemapped);
            mapper = mapperRemapped;
        }
        ((MapperRemapped) mapper).renameField(str, str2);
    }

    public <T> void registerReader(Class<T> cls, JsonReaderI<T> jsonReaderI) {
        this.cache.put(cls, jsonReaderI);
    }

    public <T> JsonReaderI<T> getMapper(Type type) {
        if (type instanceof ParameterizedType) {
            return getMapper((ParameterizedType) type);
        }
        return getMapper((Class) ((Class) type));
    }

    public <T> JsonReaderI<T> getMapper(Class<T> cls) {
        JsonReaderI<T> jsonReaderI;
        DefaultMapperCollection defaultMapperCollection = (JsonReaderI<T>) this.cache.get(cls);
        if (defaultMapperCollection != null) {
            return defaultMapperCollection;
        }
        if (cls instanceof Class) {
            if (Map.class.isAssignableFrom(cls)) {
                defaultMapperCollection = new DefaultMapperCollection(this, cls);
            } else if (List.class.isAssignableFrom(cls)) {
                defaultMapperCollection = new DefaultMapperCollection(this, cls);
            }
            if (defaultMapperCollection != null) {
                this.cache.put(cls, defaultMapperCollection);
                return defaultMapperCollection;
            }
        }
        if (cls.isArray()) {
            jsonReaderI = new ArraysMapper.GenericMapper<>(this, cls);
        } else if (List.class.isAssignableFrom(cls)) {
            jsonReaderI = new CollectionMapper.ListClass<>(this, cls);
        } else if (Map.class.isAssignableFrom(cls)) {
            jsonReaderI = new CollectionMapper.MapClass<>(this, cls);
        } else {
            jsonReaderI = new BeansMapper.Bean<>(this, cls);
        }
        this.cache.putIfAbsent(cls, jsonReaderI);
        return jsonReaderI;
    }

    public <T> JsonReaderI<T> getMapper(ParameterizedType parameterizedType) {
        CollectionMapper.MapType mapType = (JsonReaderI<T>) this.cache.get(parameterizedType);
        if (mapType != null) {
            return mapType;
        }
        Class cls = (Class) parameterizedType.getRawType();
        if (List.class.isAssignableFrom(cls)) {
            mapType = new CollectionMapper.ListType(this, parameterizedType);
        } else if (Map.class.isAssignableFrom(cls)) {
            mapType = new CollectionMapper.MapType(this, parameterizedType);
        }
        this.cache.putIfAbsent(parameterizedType, mapType);
        return mapType;
    }
}
