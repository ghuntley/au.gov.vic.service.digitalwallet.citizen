package net.minidev.asm;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import net.minidev.asm.ex.NoSuchFieldException;

public abstract class BeansAccess<T> {
    private static ConcurrentHashMap<Class<?>, BeansAccess<?>> cache = new ConcurrentHashMap<>();
    private Accessor[] accs;
    private HashMap<String, Accessor> map;

    public abstract Object get(T t, int i);

    public abstract T newInstance();

    public abstract void set(T t, int i, Object obj);

    /* access modifiers changed from: protected */
    public void setAccessor(Accessor[] accessorArr) {
        this.accs = accessorArr;
        this.map = new HashMap<>();
        int length = accessorArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            Accessor accessor = accessorArr[i];
            accessor.index = i2;
            this.map.put(accessor.getName(), accessor);
            i++;
            i2++;
        }
    }

    public HashMap<String, Accessor> getMap() {
        return this.map;
    }

    public Accessor[] getAccessors() {
        return this.accs;
    }

    public static <P> BeansAccess<P> get(Class<P> cls) {
        return get(cls, (FieldFilter) null);
    }

    public static <P> BeansAccess<P> get(Class<P> cls, FieldFilter fieldFilter) {
        String str;
        BeansAccess<P> beansAccess = (BeansAccess<P>) cache.get(cls);
        if (beansAccess != null) {
            return beansAccess;
        }
        Accessor[] accessors = ASMUtil.getAccessors(cls, fieldFilter);
        String name = cls.getName();
        if (name.startsWith("java.util.")) {
            str = "net.minidev.asm." + name + "AccAccess";
        } else {
            str = name.concat("AccAccess");
        }
        DynamicClassLoader dynamicClassLoader = new DynamicClassLoader(cls.getClassLoader());
        Class<?> cls2 = null;
        try {
            cls2 = dynamicClassLoader.loadClass(str);
        } catch (ClassNotFoundException unused) {
        }
        LinkedList<Class<?>> parents = getParents(cls);
        if (cls2 == null) {
            BeansAccessBuilder beansAccessBuilder = new BeansAccessBuilder(cls, accessors, dynamicClassLoader);
            Iterator<Class<?>> it = parents.iterator();
            while (it.hasNext()) {
                beansAccessBuilder.addConversion(BeansAccessConfig.classMapper.get(it.next()));
            }
            cls2 = beansAccessBuilder.bulid();
        }
        try {
            BeansAccess<P> beansAccess2 = (BeansAccess) cls2.newInstance();
            beansAccess2.setAccessor(accessors);
            cache.putIfAbsent(cls, beansAccess2);
            Iterator<Class<?>> it2 = parents.iterator();
            while (it2.hasNext()) {
                addAlias(beansAccess2, BeansAccessConfig.classFiledNameMapper.get(it2.next()));
            }
            return beansAccess2;
        } catch (Exception e) {
            throw new RuntimeException("Error constructing accessor class: " + str, e);
        }
    }

    private static LinkedList<Class<?>> getParents(Class<?> cls) {
        LinkedList<Class<?>> linkedList = new LinkedList<>();
        while (cls != null && !cls.equals(Object.class)) {
            linkedList.addLast(cls);
            for (Class<?> cls2 : cls.getInterfaces()) {
                linkedList.addLast(cls2);
            }
            cls = cls.getSuperclass();
        }
        linkedList.addLast(Object.class);
        return linkedList;
    }

    private static void addAlias(BeansAccess<?> beansAccess, HashMap<String, String> hashMap) {
        if (hashMap != null) {
            HashMap hashMap2 = new HashMap();
            for (Map.Entry<String, String> entry : hashMap.entrySet()) {
                Accessor accessor = ((BeansAccess) beansAccess).map.get(entry.getValue());
                if (accessor != null) {
                    hashMap2.put(entry.getValue(), accessor);
                }
            }
            ((BeansAccess) beansAccess).map.putAll(hashMap2);
        }
    }

    public void set(T t, String str, Object obj) {
        int index = getIndex(str);
        if (index != -1) {
            set(t, index, obj);
            return;
        }
        throw new NoSuchFieldException(String.valueOf(str) + " in " + t.getClass() + " to put value : " + obj);
    }

    public Object get(T t, String str) {
        return get(t, getIndex(str));
    }

    public int getIndex(String str) {
        Accessor accessor = this.map.get(str);
        if (accessor == null) {
            return -1;
        }
        return accessor.index;
    }
}
