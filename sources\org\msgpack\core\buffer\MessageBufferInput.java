package org.msgpack.core.buffer;

import java.io.Closeable;
import java.io.IOException;

public interface MessageBufferInput extends Closeable {
    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close() throws IOException;

    MessageBuffer next() throws IOException;
}
