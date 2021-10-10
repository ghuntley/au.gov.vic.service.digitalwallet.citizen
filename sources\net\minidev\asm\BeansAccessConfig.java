package net.minidev.asm;

import java.util.HashMap;
import java.util.LinkedHashSet;

public class BeansAccessConfig {
    protected static HashMap<Class<?>, HashMap<String, String>> classFiledNameMapper = new HashMap<>();
    protected static HashMap<Class<?>, LinkedHashSet<Class<?>>> classMapper = new HashMap<>();

    static {
        addTypeMapper(Object.class, DefaultConverter.class);
        addTypeMapper(Object.class, ConvertDate.class);
    }

    public static void addTypeMapper(Class<?> cls, Class<?> cls2) {
        synchronized (classMapper) {
            LinkedHashSet<Class<?>> linkedHashSet = classMapper.get(cls);
            if (linkedHashSet == null) {
                linkedHashSet = new LinkedHashSet<>();
                classMapper.put(cls, linkedHashSet);
            }
            linkedHashSet.add(cls2);
        }
    }
}
