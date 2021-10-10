package com.digitalwallet.app.view.hologram;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\bH\u0016J\u0010\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u0006\u0010\u001a\u001a\u00020\u0014J\u0019\u0010\u001b\u001a\u00020\f2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\f0\u0011¢\u0006\u0002\u0010\u001dJ\u0006\u0010\u001e\u001a\u00020\u0014R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\f@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\f0\u0011X\u0004¢\u0006\u0004\n\u0002\u0010\u0012¨\u0006 "}, d2 = {"Lcom/digitalwallet/app/view/hologram/Accelerometer;", "Landroid/hardware/SensorEventListener;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "accelerometer", "Landroid/hardware/Sensor;", FirebaseAnalytics.Param.INDEX, "", "sensorManager", "Landroid/hardware/SensorManager;", "<set-?>", "", "vector", "getVector", "()[F", "vectorHistory", "", "[[F", "onAccuracyChanged", "", "sensor", "accuracy", "onSensorChanged", "event", "Landroid/hardware/SensorEvent;", "register", "sumV3", "vectors", "([[F)[F", "unregister", "Companion", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: Accelerometer.kt */
public final class Accelerometer implements SensorEventListener {
    public static final Companion Companion = new Companion(null);
    private static final float[] NULL_VECTOR = {0.0f, 0.0f, 0.0f};
    private static final int SMOOTHNESS = 20;
    private final Sensor accelerometer;
    private int index;
    private final SensorManager sensorManager;
    private float[] vector;
    private final float[][] vectorHistory;

    public void onAccuracyChanged(Sensor sensor, int i) {
        Intrinsics.checkNotNullParameter(sensor, "sensor");
    }

    public Accelerometer(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Object systemService = context.getSystemService("sensor");
        Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.hardware.SensorManager");
        this.sensorManager = (SensorManager) systemService;
        float[][] fArr = new float[20][];
        for (int i = 0; i < 20; i++) {
            fArr[i] = NULL_VECTOR;
        }
        this.vectorHistory = fArr;
        this.vector = NULL_VECTOR;
        Sensor defaultSensor = this.sensorManager.getDefaultSensor(1);
        Intrinsics.checkNotNullExpressionValue(defaultSensor, "sensorManager.getDefault…ensor.TYPE_ACCELEROMETER)");
        this.accelerometer = defaultSensor;
        register();
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/digitalwallet/app/view/hologram/Accelerometer$Companion;", "", "()V", "NULL_VECTOR", "", "SMOOTHNESS", "", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
    /* compiled from: Accelerometer.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public final float[] getVector() {
        return this.vector;
    }

    public final void register() {
        this.sensorManager.registerListener(this, this.accelerometer, 0);
    }

    public final void unregister() {
        this.sensorManager.unregisterListener(this);
    }

    public final float[] sumV3(float[][] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "vectors");
        float f = 0.0f;
        float f2 = 0.0f;
        float f3 = 0.0f;
        for (float[] fArr2 : fArr) {
            f += fArr2[0];
            f2 += fArr2[1];
            f3 += fArr2[2];
        }
        return new float[]{f, f2, f3};
    }

    public void onSensorChanged(SensorEvent sensorEvent) {
        Intrinsics.checkNotNullParameter(sensorEvent, "event");
        Sensor sensor = sensorEvent.sensor;
        Intrinsics.checkNotNullExpressionValue(sensor, "event.sensor");
        if (sensor.getType() == 1) {
            int i = this.index % 20;
            this.index = i;
            float[][] fArr = this.vectorHistory;
            this.index = i + 1;
            fArr[i] = new float[]{sensorEvent.values[0], sensorEvent.values[1], sensorEvent.values[2]};
            this.vector = sumV3(this.vectorHistory);
        }
    }
}
