package net.minidev.asm;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class BasicFiledFilter implements FieldFilter {
    public static final BasicFiledFilter SINGLETON = new BasicFiledFilter();

    @Override // net.minidev.asm.FieldFilter
    public boolean canRead(Field field) {
        return true;
    }

    @Override // net.minidev.asm.FieldFilter
    public boolean canUse(Field field) {
        return true;
    }

    @Override // net.minidev.asm.FieldFilter
    public boolean canUse(Field field, Method method) {
        return true;
    }

    @Override // net.minidev.asm.FieldFilter
    public boolean canWrite(Field field) {
        return true;
    }
}
