package com.digitalwallet.app.view.hologram;

import android.app.ActivityManager;
import android.content.Context;
import android.opengl.GLSurfaceView;
import android.util.AttributeSet;
import android.view.View;
import java.util.HashMap;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u001b\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\r\u001a\u00020\u000eJ\u000e\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0011J\u0006\u0010\u0012\u001a\u00020\u000eJ\b\u0010\u0013\u001a\u00020\u000eH\u0002J\b\u0010\u0014\u001a\u00020\u000eH\u0016J\b\u0010\u0015\u001a\u00020\u000eH\u0016J\u000e\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u0011J\u0016\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\u0011J\u0006\u0010\u001b\u001a\u00020\u000eR\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/digitalwallet/app/view/hologram/HologramView;", "Landroid/opengl/GLSurfaceView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "accelerometer", "Lcom/digitalwallet/app/view/hologram/Accelerometer;", "renderer", "Lcom/digitalwallet/app/view/hologram/HoloRenderer;", "willDestroy", "", "destroy", "", "fade", "factor", "", "flagToDestroy", "initGLES", "onPause", "onResume", "rotate", "rotationY", "scale", "x", "y", "setup", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: HologramView.kt */
public final class HologramView extends GLSurfaceView {
    private HashMap _$_findViewCache;
    private Accelerometer accelerometer;
    private AttributeSet attrs;
    private HoloRenderer renderer;
    private boolean willDestroy;

    public HologramView(Context context) {
        this(context, null, 2, null);
    }

    public void _$_clearFindViewByIdCache() {
        HashMap hashMap = this._$_findViewCache;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public View _$_findCachedViewById(int i) {
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i);
        this._$_findViewCache.put(Integer.valueOf(i), findViewById);
        return findViewById;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ HologramView(Context context, AttributeSet attributeSet, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public HologramView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.attrs = attributeSet;
    }

    public final void setup() {
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        this.accelerometer = new Accelerometer(context);
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "context");
        AttributeSet attributeSet = this.attrs;
        Accelerometer accelerometer2 = this.accelerometer;
        Intrinsics.checkNotNull(accelerometer2);
        this.renderer = new HoloRenderer(context2, attributeSet, accelerometer2);
        initGLES();
    }

    private final void initGLES() {
        Object systemService = getContext().getSystemService("activity");
        Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.app.ActivityManager");
        if (((ActivityManager) systemService).getDeviceConfigurationInfo().reqGlEsVersion >= 131072) {
            setZOrderOnTop(true);
            setEGLContextClientVersion(2);
            setEGLConfigChooser(8, 8, 8, 8, 0, 0);
            getHolder().setFormat(-3);
            HoloRenderer holoRenderer = this.renderer;
            Intrinsics.checkNotNull(holoRenderer);
            setRenderer(holoRenderer);
            return;
        }
        throw new IllegalStateException("OpenGL ES 2.0 not supported.".toString());
    }

    public final void flagToDestroy() {
        this.willDestroy = true;
    }

    public void onResume() {
        super.onResume();
        Accelerometer accelerometer2 = this.accelerometer;
        if (accelerometer2 != null) {
            accelerometer2.register();
        }
    }

    public void onPause() {
        super.onPause();
        Accelerometer accelerometer2 = this.accelerometer;
        if (accelerometer2 != null) {
            accelerometer2.unregister();
        }
        if (this.willDestroy) {
            destroy();
        }
    }

    public final void destroy() {
        HoloRenderer holoRenderer = this.renderer;
        if (holoRenderer != null) {
            holoRenderer.destroy();
        }
    }

    public final void rotate(float f) {
        HoloRenderer holoRenderer = this.renderer;
        if (holoRenderer != null) {
            holoRenderer.updateRotation(f);
        }
    }

    public final void scale(float f, float f2) {
        HoloRenderer holoRenderer = this.renderer;
        if (holoRenderer != null) {
            holoRenderer.updateScale(f, f2);
        }
    }

    public final void fade(float f) {
        HoloRenderer holoRenderer = this.renderer;
        if (holoRenderer != null) {
            holoRenderer.updateFade(f);
        }
    }
}
