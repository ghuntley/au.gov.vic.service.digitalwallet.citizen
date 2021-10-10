package com.digitalwallet.app.view.hologram;

import android.opengl.GLES20;
import java.nio.Buffer;
import java.nio.FloatBuffer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\u001e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0003J\u0018\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u0006\u0010\u0017\u001a\u00020\u000fJ\u0016\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u001bJ\u001e\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0007J\u000e\u0010 \u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u0003R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\f\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\t¨\u0006!"}, d2 = {"Lcom/digitalwallet/app/view/hologram/ShaderProgram;", "", "vertexShaderSource", "", "fragmentShaderSource", "(Ljava/lang/String;Ljava/lang/String;)V", "fragmentShader", "", "getFragmentShader", "()I", "handle", "getHandle", "vertexShader", "getVertexShader", "bindTexture", "", "texture", "textureSlot", "property", "createShader", "source", "isFragment", "", "delete", "pushMatrix", "parameter", "matrix", "", "pushVertexAttribArray", "buffer", "Ljava/nio/FloatBuffer;", "vectorSize", "u_Location", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: ShaderProgram.kt */
public final class ShaderProgram {
    private final int fragmentShader;
    private final int handle;
    private final int vertexShader;

    public ShaderProgram(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "vertexShaderSource");
        Intrinsics.checkNotNullParameter(str2, "fragmentShaderSource");
        int glCreateProgram = GLES20.glCreateProgram();
        this.handle = glCreateProgram;
        int createShader = createShader(str, false);
        this.vertexShader = createShader;
        int createShader2 = createShader(str2, true);
        this.fragmentShader = createShader2;
        if (glCreateProgram != 0) {
            GLES20.glAttachShader(glCreateProgram, createShader);
            GLES20.glAttachShader(glCreateProgram, createShader2);
            GLES20.glLinkProgram(glCreateProgram);
            int[] iArr = new int[1];
            GLES20.glGetProgramiv(glCreateProgram, 35714, iArr, 0);
            if (iArr[0] == 0) {
                String glGetProgramInfoLog = GLES20.glGetProgramInfoLog(glCreateProgram);
                GLES20.glDeleteProgram(glCreateProgram);
                throw new IllegalStateException(("Could not link a shader program: " + glGetProgramInfoLog).toString());
            }
        }
        GLES20.glUseProgram(glCreateProgram);
    }

    public final int getHandle() {
        return this.handle;
    }

    public final int getVertexShader() {
        return this.vertexShader;
    }

    public final int getFragmentShader() {
        return this.fragmentShader;
    }

    public final void delete() {
        GLES20.glDeleteProgram(this.handle);
        GLES20.glDeleteShader(this.vertexShader);
        GLES20.glDeleteShader(this.fragmentShader);
    }

    public final int u_Location(String str) {
        Intrinsics.checkNotNullParameter(str, "parameter");
        return GLES20.glGetUniformLocation(this.handle, str);
    }

    public final void pushMatrix(String str, float[] fArr) {
        Intrinsics.checkNotNullParameter(str, "parameter");
        Intrinsics.checkNotNullParameter(fArr, "matrix");
        GLES20.glUniformMatrix4fv(GLES20.glGetUniformLocation(this.handle, str), 1, false, fArr, 0);
    }

    public final int pushVertexAttribArray(String str, FloatBuffer floatBuffer, int i) {
        Intrinsics.checkNotNullParameter(str, "parameter");
        Intrinsics.checkNotNullParameter(floatBuffer, "buffer");
        int glGetAttribLocation = GLES20.glGetAttribLocation(this.handle, str);
        floatBuffer.position(0);
        GLES20.glEnableVertexAttribArray(glGetAttribLocation);
        GLES20.glVertexAttribPointer(glGetAttribLocation, i, 5126, false, i * 4, (Buffer) floatBuffer);
        return glGetAttribLocation;
    }

    public final void bindTexture(int i, int i2, String str) {
        Intrinsics.checkNotNullParameter(str, "property");
        GLES20.glActiveTexture(33984 + i2);
        GLES20.glBindTexture(3553, i);
        GLES20.glUniform1i(GLES20.glGetUniformLocation(this.handle, str), i2);
    }

    private final int createShader(String str, boolean z) {
        int glCreateShader = GLES20.glCreateShader(z ? 35632 : 35633);
        boolean z2 = true;
        if (glCreateShader != 0) {
            int[] iArr = new int[1];
            GLES20.glShaderSource(glCreateShader, str);
            GLES20.glCompileShader(glCreateShader);
            GLES20.glGetShaderiv(glCreateShader, 35713, iArr, 0);
            if (iArr[0] == 0) {
                z2 = false;
            }
            if (z2) {
                return glCreateShader;
            }
            String glGetShaderInfoLog = GLES20.glGetShaderInfoLog(glCreateShader);
            GLES20.glDeleteShader(glCreateShader);
            throw new IllegalStateException(("Could not compile a shader: " + glGetShaderInfoLog).toString());
        }
        throw new IllegalStateException(("Could not create a shader: " + str).toString());
    }
}
