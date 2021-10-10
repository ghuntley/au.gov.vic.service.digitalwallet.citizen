package net.minidev.asm;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import org.objectweb.asm.Opcodes;

public class Accessor {
    protected Field field;
    protected String fieldName;
    protected Type genericType;
    protected Method getter;
    protected int index;
    protected Method setter;
    protected Class<?> type;

    public int getIndex() {
        return this.index;
    }

    public boolean isPublic() {
        return this.setter == null;
    }

    public boolean isEnum() {
        return this.type.isEnum();
    }

    public String getName() {
        return this.fieldName;
    }

    public Class<?> getType() {
        return this.type;
    }

    public Type getGenericType() {
        return this.genericType;
    }

    public boolean isUsable() {
        return (this.field == null && this.getter == null && this.setter == null) ? false : true;
    }

    public boolean isReadable() {
        return (this.field == null && this.getter == null) ? false : true;
    }

    public boolean isWritable() {
        return (this.field == null && this.getter == null) ? false : true;
    }

    public Accessor(Class<?> cls, Field field2, FieldFilter fieldFilter) {
        String str;
        this.fieldName = field2.getName();
        int modifiers = field2.getModifiers();
        if ((modifiers & Opcodes.L2I) <= 0) {
            if ((modifiers & 1) > 0) {
                this.field = field2;
            }
            String setterName = ASMUtil.getSetterName(field2.getName());
            try {
                this.setter = cls.getDeclaredMethod(setterName, field2.getType());
            } catch (Exception unused) {
            }
            boolean equals = field2.getType().equals(Boolean.TYPE);
            if (equals) {
                str = ASMUtil.getIsName(field2.getName());
            } else {
                str = ASMUtil.getGetterName(field2.getName());
            }
            try {
                this.getter = cls.getDeclaredMethod(str, new Class[0]);
            } catch (Exception unused2) {
            }
            if (this.getter == null && equals) {
                try {
                    this.getter = cls.getDeclaredMethod(ASMUtil.getGetterName(field2.getName()), new Class[0]);
                } catch (Exception unused3) {
                }
            }
            if (this.field != null || this.getter != null || this.setter != null) {
                Method method = this.getter;
                if (method != null && !fieldFilter.canUse(field2, method)) {
                    this.getter = null;
                }
                Method method2 = this.setter;
                if (method2 != null && !fieldFilter.canUse(field2, method2)) {
                    this.setter = null;
                }
                if (this.getter != null || this.setter != null || this.field != null) {
                    this.type = field2.getType();
                    this.genericType = field2.getGenericType();
                }
            }
        }
    }
}
