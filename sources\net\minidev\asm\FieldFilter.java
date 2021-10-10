package net.minidev.asm;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public interface FieldFilter {
    boolean canRead(Field field);

    boolean canUse(Field field);

    boolean canUse(Field field, Method method);

    boolean canWrite(Field field);
}
