package net.minidev.asm.ex;

public class NoSuchFieldException extends RuntimeException {
    private static final long serialVersionUID = 1;

    public NoSuchFieldException() {
    }

    public NoSuchFieldException(String str) {
        super(str);
    }
}
