package org.bouncycastle.util;

public interface Selector extends Cloneable {
    @Override // java.lang.Object
    Object clone();

    boolean match(Object obj);
}
