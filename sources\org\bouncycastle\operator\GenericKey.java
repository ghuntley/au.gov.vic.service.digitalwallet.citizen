package org.bouncycastle.operator;

public class GenericKey {
    private Object representation;

    public GenericKey(Object obj) {
        this.representation = obj;
    }

    public Object getRepresentation() {
        return this.representation;
    }
}
