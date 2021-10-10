package com.squareup.moshi;

import android.support.v4.media.session.PlaybackStateCompat;
import java.io.IOException;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;
import okio.Source;
import okio.Timeout;

/* access modifiers changed from: package-private */
public final class JsonValueSource implements Source {
    static final ByteString STATE_C_STYLE_COMMENT = ByteString.encodeUtf8("*");
    static final ByteString STATE_DOUBLE_QUOTED = ByteString.encodeUtf8("\"\\");
    static final ByteString STATE_END_OF_JSON = ByteString.EMPTY;
    static final ByteString STATE_END_OF_LINE_COMMENT = ByteString.encodeUtf8("\r\n");
    static final ByteString STATE_JSON = ByteString.encodeUtf8("[]{}\"'/#");
    static final ByteString STATE_SINGLE_QUOTED = ByteString.encodeUtf8("'\\");
    private final Buffer buffer;
    private boolean closed;
    private long limit;
    private final Buffer prefix;
    private final BufferedSource source;
    private int stackSize;
    private ByteString state;

    JsonValueSource(BufferedSource bufferedSource) {
        this(bufferedSource, new Buffer(), STATE_JSON, 0);
    }

    JsonValueSource(BufferedSource bufferedSource, Buffer buffer2, ByteString byteString, int i) {
        this.limit = 0;
        this.closed = false;
        this.source = bufferedSource;
        this.buffer = bufferedSource.getBuffer();
        this.prefix = buffer2;
        this.state = byteString;
        this.stackSize = i;
    }

    private void advanceLimit(long j) throws IOException {
        ByteString byteString;
        while (true) {
            long j2 = this.limit;
            if (j2 < j && this.state != (byteString = STATE_END_OF_JSON)) {
                if (j2 == this.buffer.size()) {
                    if (this.limit <= 0) {
                        this.source.require(1);
                    } else {
                        return;
                    }
                }
                long indexOfElement = this.buffer.indexOfElement(this.state, this.limit);
                if (indexOfElement == -1) {
                    this.limit = this.buffer.size();
                } else {
                    byte b = this.buffer.getByte(indexOfElement);
                    ByteString byteString2 = this.state;
                    ByteString byteString3 = STATE_JSON;
                    if (byteString2 == byteString3) {
                        if (b == 34) {
                            this.state = STATE_DOUBLE_QUOTED;
                            this.limit = indexOfElement + 1;
                        } else if (b == 35) {
                            this.state = STATE_END_OF_LINE_COMMENT;
                            this.limit = indexOfElement + 1;
                        } else if (b == 39) {
                            this.state = STATE_SINGLE_QUOTED;
                            this.limit = indexOfElement + 1;
                        } else if (b != 47) {
                            if (b != 91) {
                                if (b != 93) {
                                    if (b != 123) {
                                        if (b != 125) {
                                        }
                                    }
                                }
                                int i = this.stackSize - 1;
                                this.stackSize = i;
                                if (i == 0) {
                                    this.state = byteString;
                                }
                                this.limit = indexOfElement + 1;
                            }
                            this.stackSize++;
                            this.limit = indexOfElement + 1;
                        } else {
                            long j3 = 2 + indexOfElement;
                            this.source.require(j3);
                            long j4 = indexOfElement + 1;
                            byte b2 = this.buffer.getByte(j4);
                            if (b2 == 47) {
                                this.state = STATE_END_OF_LINE_COMMENT;
                                this.limit = j3;
                            } else if (b2 == 42) {
                                this.state = STATE_C_STYLE_COMMENT;
                                this.limit = j3;
                            } else {
                                this.limit = j4;
                            }
                        }
                    } else if (byteString2 == STATE_SINGLE_QUOTED || byteString2 == STATE_DOUBLE_QUOTED) {
                        if (b == 92) {
                            long j5 = indexOfElement + 2;
                            this.source.require(j5);
                            this.limit = j5;
                        } else {
                            if (this.stackSize > 0) {
                                byteString = byteString3;
                            }
                            this.state = byteString;
                            this.limit = indexOfElement + 1;
                        }
                    } else if (byteString2 == STATE_C_STYLE_COMMENT) {
                        long j6 = 2 + indexOfElement;
                        this.source.require(j6);
                        long j7 = indexOfElement + 1;
                        if (this.buffer.getByte(j7) == 47) {
                            this.limit = j6;
                            this.state = byteString3;
                        } else {
                            this.limit = j7;
                        }
                    } else if (byteString2 == STATE_END_OF_LINE_COMMENT) {
                        this.limit = indexOfElement + 1;
                        this.state = byteString3;
                    } else {
                        throw new AssertionError();
                    }
                }
            } else {
                return;
            }
        }
    }

    public void discard() throws IOException {
        this.closed = true;
        while (this.state != STATE_END_OF_JSON) {
            advanceLimit(PlaybackStateCompat.ACTION_PLAY_FROM_URI);
            this.source.skip(this.limit);
        }
    }

    @Override // okio.Source
    public long read(Buffer buffer2, long j) throws IOException {
        if (this.closed) {
            throw new IllegalStateException("closed");
        } else if (j == 0) {
            return 0;
        } else {
            if (!this.prefix.exhausted()) {
                long read = this.prefix.read(buffer2, j);
                long j2 = j - read;
                if (this.buffer.exhausted()) {
                    return read;
                }
                long read2 = read(buffer2, j2);
                return read2 != -1 ? read + read2 : read;
            }
            advanceLimit(j);
            long j3 = this.limit;
            if (j3 != 0) {
                long min = Math.min(j, j3);
                buffer2.write(this.buffer, min);
                this.limit -= min;
                return min;
            } else if (this.state == STATE_END_OF_JSON) {
                return -1;
            } else {
                throw new AssertionError();
            }
        }
    }

    @Override // okio.Source
    public Timeout timeout() {
        return this.source.timeout();
    }

    @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.closed = true;
    }
}
