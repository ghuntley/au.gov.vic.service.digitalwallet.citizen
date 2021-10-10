package com.digitalwallet.app.view.hologram;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.opengl.GLUtils;
import android.opengl.Matrix;
import android.util.AttributeSet;
import com.digitalwallet.app.R;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.ArrayList;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0015\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u0000 92\u00020\u0001:\u00019B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0006\u0010\u001f\u001a\u00020 J\u0018\u0010!\u001a\u00020\"2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010#\u001a\u00020\"H\u0002J\b\u0010$\u001a\u00020 H\u0002J\b\u0010%\u001a\u00020 H\u0002J\b\u0010&\u001a\u00020 H\u0002J\b\u0010'\u001a\u00020 H\u0002J\u0010\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\"H\u0002J\u0010\u0010+\u001a\u00020 2\u0006\u0010,\u001a\u00020-H\u0016J \u0010.\u001a\u00020 2\u0006\u0010,\u001a\u00020-2\u0006\u0010/\u001a\u00020\"2\u0006\u00100\u001a\u00020\"H\u0016J\u0018\u00101\u001a\u00020 2\u0006\u0010,\u001a\u00020-2\u0006\u00102\u001a\u000203H\u0016J\u000e\u00104\u001a\u00020 2\u0006\u00105\u001a\u00020\nJ\u000e\u00106\u001a\u00020 2\u0006\u0010\u0016\u001a\u00020\nJ\u0016\u00107\u001a\u00020 2\u0006\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\nJ\b\u00108\u001a\u00020 H\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX.¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0012X.¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000¨\u0006:"}, d2 = {"Lcom/digitalwallet/app/view/hologram/HoloRenderer;", "Landroid/opengl/GLSurfaceView$Renderer;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "accelerometer", "Lcom/digitalwallet/app/view/hologram/Accelerometer;", "(Landroid/content/Context;Landroid/util/AttributeSet;Lcom/digitalwallet/app/view/hologram/Accelerometer;)V", "alpha", "", "attributes", "Landroid/content/res/TypedArray;", "created", "", "mvpMatrix", "", "posBuffer", "Ljava/nio/FloatBuffer;", "program", "Lcom/digitalwallet/app/view/hologram/ShaderProgram;", "projectionMatrix", "rotationY", "scaleX", "scaleY", "scratchMatrix", "textures", "", "transformMatrix", "uvBuffer", "viewMatrix", "destroy", "", "generateTexture", "", "resourceId", "initBuffers", "initGLSettings", "initShaders", "initTextures", "loadResource", "", "id", "onDrawFrame", "gl", "Ljavax/microedition/khronos/opengles/GL10;", "onSurfaceChanged", "width", "height", "onSurfaceCreated", "config", "Ljavax/microedition/khronos/egl/EGLConfig;", "updateFade", "factor", "updateRotation", "updateScale", "updateTransform", "Companion", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: HoloRenderer.kt */
public final class HoloRenderer implements GLSurfaceView.Renderer {
    public static final int BYTES_PER_FLOAT = 4;
    public static final Companion Companion = new Companion(null);
    private final Accelerometer accelerometer;
    private float alpha;
    private final TypedArray attributes;
    private final Context context;
    private boolean created;
    private final float[] mvpMatrix;
    private FloatBuffer posBuffer;
    private ShaderProgram program;
    private final float[] projectionMatrix;
    private float rotationY;
    private float scaleX;
    private float scaleY;
    private final float[] scratchMatrix;
    private int[] textures;
    private final float[] transformMatrix;
    private FloatBuffer uvBuffer;
    private final float[] viewMatrix;

    public HoloRenderer(Context context2, AttributeSet attributeSet, Accelerometer accelerometer2) {
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(accelerometer2, "accelerometer");
        this.context = context2;
        this.accelerometer = accelerometer2;
        TypedArray obtainStyledAttributes = context2.getTheme().obtainStyledAttributes(attributeSet, R.styleable.HologramView, 0, 0);
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "context.theme.obtainStyl…eable.HologramView, 0, 0)");
        this.attributes = obtainStyledAttributes;
        this.scaleX = 1.0f;
        this.scaleY = 1.0f;
        this.alpha = 1.0f;
        this.mvpMatrix = new float[16];
        this.scratchMatrix = new float[16];
        this.transformMatrix = new float[16];
        this.projectionMatrix = new float[16];
        this.viewMatrix = new float[16];
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ HoloRenderer(Context context2, AttributeSet attributeSet, Accelerometer accelerometer2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context2, (i & 2) != 0 ? null : attributeSet, accelerometer2);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/digitalwallet/app/view/hologram/HoloRenderer$Companion;", "", "()V", "BYTES_PER_FLOAT", "", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
    /* compiled from: HoloRenderer.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
        Intrinsics.checkNotNullParameter(gl10, "gl");
        Intrinsics.checkNotNullParameter(eGLConfig, "config");
        initBuffers();
        initGLSettings();
        initShaders();
        initTextures();
        this.created = true;
    }

    private final void initBuffers() {
        FloatBuffer put = ByteBuffer.allocateDirect(72).order(ByteOrder.nativeOrder()).asFloatBuffer().put(new float[]{-1.0f, -1.0f, 0.0f, 1.0f, -1.0f, 0.0f, -1.0f, 1.0f, 0.0f, -1.0f, 1.0f, 0.0f, 1.0f, -1.0f, 0.0f, 1.0f, 1.0f, 0.0f});
        Intrinsics.checkNotNullExpressionValue(put, "ByteBuffer.allocateDirec…)\n            .put(verts)");
        this.posBuffer = put;
        FloatBuffer put2 = ByteBuffer.allocateDirect(48).order(ByteOrder.nativeOrder()).asFloatBuffer().put(new float[]{0.0f, 1.0f, 1.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f, 0.0f});
        Intrinsics.checkNotNullExpressionValue(put2, "ByteBuffer.allocateDirec…r()\n            .put(uvs)");
        this.uvBuffer = put2;
    }

    private final void initGLSettings() {
        GLES20.glEnable(3042);
        GLES20.glBlendFunc(770, 771);
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
    }

    private final void initShaders() {
        this.program = new ShaderProgram(loadResource(au.gov.vic.service.digitalwallet.citizen.R.raw.hologram_vertex), loadResource(au.gov.vic.service.digitalwallet.citizen.R.raw.hologram_fragment));
    }

    private final void initTextures() {
        int i = 0;
        int[] iArr = {this.attributes.getResourceId(0, au.gov.vic.service.digitalwallet.citizen.R.drawable.holo_background), this.attributes.getResourceId(2, au.gov.vic.service.digitalwallet.citizen.R.drawable.holo_rainbow), this.attributes.getResourceId(1, au.gov.vic.service.digitalwallet.citizen.R.drawable.logo_vic_holo)};
        this.textures = iArr;
        if (iArr == null) {
            Intrinsics.throwUninitializedPropertyAccessException("textures");
        }
        ArrayList arrayList = new ArrayList(iArr.length);
        for (int i2 : iArr) {
            arrayList.add(Integer.valueOf(generateTexture(this.context, i2)));
        }
        ArrayList arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList2, 10));
        for (Object obj : arrayList2) {
            int i3 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            int intValue = ((Number) obj).intValue();
            String name = Texture.values()[i].name();
            ShaderProgram shaderProgram = this.program;
            if (shaderProgram == null) {
                Intrinsics.throwUninitializedPropertyAccessException("program");
            }
            shaderProgram.bindTexture(intValue, i, name);
            arrayList3.add(Unit.INSTANCE);
            i = i3;
        }
    }

    public final void destroy() {
        if (this.created) {
            ShaderProgram shaderProgram = this.program;
            if (shaderProgram == null) {
                Intrinsics.throwUninitializedPropertyAccessException("program");
            }
            shaderProgram.delete();
            int[] iArr = this.textures;
            if (iArr == null) {
                Intrinsics.throwUninitializedPropertyAccessException("textures");
            }
            int length = iArr.length;
            int[] iArr2 = this.textures;
            if (iArr2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("textures");
            }
            GLES20.glDeleteTextures(length, iArr2, 0);
        }
    }

    public final void updateFade(float f) {
        this.alpha = f;
    }

    public final void updateScale(float f, float f2) {
        this.scaleX = f;
        this.scaleY = f2;
        updateTransform();
    }

    public final void updateRotation(float f) {
        this.rotationY = f;
        updateTransform();
    }

    private final void updateTransform() {
        Matrix.setRotateM(this.transformMatrix, 0, this.rotationY, 0.0f, 1.0f, 0.0f);
        Matrix.scaleM(this.transformMatrix, 0, this.scaleX, this.scaleY, 0.0f);
        Matrix.multiplyMM(this.mvpMatrix, 0, this.scratchMatrix, 0, this.transformMatrix, 0);
    }

    public void onSurfaceChanged(GL10 gl10, int i, int i2) {
        Intrinsics.checkNotNullParameter(gl10, "gl");
        GLES20.glViewport(0, 0, i, i2);
        Matrix.frustumM(this.projectionMatrix, 0, -0.5f, 0.5f, -0.5f, 0.5f, 1.0f, 7.0f);
        Matrix.setLookAtM(this.viewMatrix, 0, 0.0f, 0.0f, 2.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f);
        Matrix.multiplyMM(this.scratchMatrix, 0, this.projectionMatrix, 0, this.viewMatrix, 0);
        updateRotation(0.0f);
    }

    public void onDrawFrame(GL10 gl10) {
        Intrinsics.checkNotNullParameter(gl10, "gl");
        ShaderProgram shaderProgram = this.program;
        if (shaderProgram == null) {
            Intrinsics.throwUninitializedPropertyAccessException("program");
        }
        GLES20.glClear(16640);
        GLES20.glUniform3fv(shaderProgram.u_Location(Parameter.u_AccelerometerCoordinates.name()), 1, this.accelerometer.getVector(), 0);
        GLES20.glUniform1f(shaderProgram.u_Location(Parameter.u_Alpha.name()), this.alpha);
        shaderProgram.pushMatrix(Parameter.u_MVPMatrix.name(), this.mvpMatrix);
        String name = Parameter.a_VertexPosition.name();
        FloatBuffer floatBuffer = this.posBuffer;
        if (floatBuffer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("posBuffer");
        }
        int pushVertexAttribArray = shaderProgram.pushVertexAttribArray(name, floatBuffer, 3);
        String name2 = Parameter.a_TextureCoordinates.name();
        FloatBuffer floatBuffer2 = this.uvBuffer;
        if (floatBuffer2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("uvBuffer");
        }
        int pushVertexAttribArray2 = shaderProgram.pushVertexAttribArray(name2, floatBuffer2, 2);
        FloatBuffer floatBuffer3 = this.posBuffer;
        if (floatBuffer3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("posBuffer");
        }
        GLES20.glDrawArrays(4, 0, floatBuffer3.remaining() / 3);
        GLES20.glDisableVertexAttribArray(pushVertexAttribArray);
        GLES20.glDisableVertexAttribArray(pushVertexAttribArray2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x002b, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x002c, code lost:
        kotlin.io.CloseableKt.closeFinally(r5, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x002f, code lost:
        throw r1;
     */
    private final String loadResource(int i) {
        try {
            InputStream openRawResource = this.context.getResources().openRawResource(i);
            Throwable th = null;
            InputStream inputStream = openRawResource;
            byte[] bArr = new byte[inputStream.available()];
            inputStream.read(bArr);
            inputStream.close();
            String str = new String(bArr, Charsets.UTF_8);
            CloseableKt.closeFinally(openRawResource, th);
            return str;
        } catch (IOException e) {
            throw new IllegalStateException(("Error loading raw resource: " + e.getLocalizedMessage()).toString());
        }
    }

    private final int generateTexture(Context context2, int i) {
        boolean z = true;
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        int i2 = iArr[0];
        if (i2 == 0) {
            z = false;
        }
        if (z) {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inScaled = false;
            Bitmap decodeResource = BitmapFactory.decodeResource(context2.getResources(), i, options);
            GLES20.glBindTexture(3553, i2);
            GLES20.glTexParameteri(3553, 10241, 9987);
            GLES20.glTexParameteri(3553, 10240, 9729);
            GLES20.glTexParameteri(3553, 10242, 10497);
            GLES20.glTexParameteri(3553, 10243, 10497);
            GLUtils.texImage2D(3553, 0, 6408, decodeResource, 0);
            GLES20.glGenerateMipmap(3553);
            decodeResource.recycle();
            return i2;
        }
        throw new IllegalStateException("Could not create a texture".toString());
    }
}
