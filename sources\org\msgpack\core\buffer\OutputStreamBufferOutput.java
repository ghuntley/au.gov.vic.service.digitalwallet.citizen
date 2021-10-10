package org.msgpack.core.buffer;

import java.io.IOException;
import java.io.OutputStream;
import org.msgpack.core.Preconditions;

public class OutputStreamBufferOutput implements MessageBufferOutput {
    private MessageBuffer buffer;
    private OutputStream out;

    public OutputStreamBufferOutput(OutputStream outputStream) {
        this(outputStream, 8192);
    }

    public OutputStreamBufferOutput(OutputStream outputStream, int i) {
        this.out = (OutputStream) Preconditions.checkNotNull(outputStream, "output is null");
        this.buffer = MessageBuffer.allocate(i);
    }

    public OutputStream reset(OutputStream outputStream) throws IOException {
        OutputStream outputStream2 = this.out;
        this.out = outputStream;
        return outputStream2;
    }

    @Override // org.msgpack.core.buffer.MessageBufferOutput
    public MessageBuffer next(int i) throws IOException {
        if (this.buffer.size() < i) {
            this.buffer = MessageBuffer.allocate(i);
        }
        return this.buffer;
    }

    @Override // org.msgpack.core.buffer.MessageBufferOutput
    public void writeBuffer(int i) throws IOException {
        write(this.buffer.array(), this.buffer.arrayOffset(), i);
    }

    @Override // org.msgpack.core.buffer.MessageBufferOutput
    public void write(byte[] bArr, int i, int i2) throws IOException {
        this.out.write(bArr, i, i2);
    }

    @Override // org.msgpack.core.buffer.MessageBufferOutput
    public void add(byte[] bArr, int i, int i2) throws IOException {
        write(bArr, i, i2);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.out.close();
    }

    @Override // java.io.Flushable
    public void flush() throws IOException {
        this.out.flush();
    }
}
