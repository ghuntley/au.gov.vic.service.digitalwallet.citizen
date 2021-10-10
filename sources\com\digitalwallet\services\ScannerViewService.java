package com.digitalwallet.services;

import android.content.Context;
import android.graphics.Rect;
import android.hardware.Camera;
import android.util.SparseArray;
import android.view.SurfaceHolder;
import com.google.android.gms.vision.CameraSource;
import com.google.android.gms.vision.Detector;
import com.google.android.gms.vision.Frame;
import com.google.android.gms.vision.barcode.Barcode;
import com.google.android.gms.vision.barcode.BarcodeDetector;
import com.google.firebase.messaging.Constants;
import java.lang.reflect.Field;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.DebugKt;
import timber.log.Timber;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\b\u0007\u0018\u0000 92\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u00019B\u000f\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0018\u001a\u00020\u0019H\u0002J \u0010\u001a\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\r2\u0006\u0010\u001c\u001a\u00020\r2\u0006\u0010\u001d\u001a\u00020\rH\u0002J\u0010\u0010\u001e\u001a\n \u001f*\u0004\u0018\u00010\u00110\u0011H\u0002J\u0018\u0010 \u001a\u00020\u000f2\u0006\u0010!\u001a\u00020\u00112\u0006\u0010\"\u001a\u00020\rH\u0002J\u0012\u0010#\u001a\u0004\u0018\u00010$2\u0006\u0010%\u001a\u00020\u000fH\u0002J\u0006\u0010&\u001a\u00020\u0019J\u0016\u0010'\u001a\u00020\u00192\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00030)H\u0016J\b\u0010*\u001a\u00020\u0019H\u0016J\u000e\u0010+\u001a\u00020\u000b2\u0006\u0010,\u001a\u00020\u000bJ$\u0010-\u001a\u00020\u00192\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u000b0\n2\b\b\u0002\u0010\u0007\u001a\u00020\bJ\u0010\u0010.\u001a\u00020\u00192\u0006\u0010/\u001a\u000200H\u0002J\u0006\u00101\u001a\u00020\u0019J(\u00102\u001a\u00020\u00192\u0006\u0010/\u001a\u0002002\u0006\u00103\u001a\u00020\b2\u0006\u00104\u001a\u00020\b2\u0006\u00105\u001a\u00020\bH\u0016J\u0010\u00106\u001a\u00020\u00192\u0006\u0010/\u001a\u000200H\u0016J\u0010\u00107\u001a\u00020\u00192\u0006\u0010/\u001a\u000200H\u0016J\u0006\u00108\u001a\u00020\u0019R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u000b0\nX.¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006:"}, d2 = {"Lcom/digitalwallet/services/ScannerViewService;", "Landroid/view/SurfaceHolder$Callback;", "Lcom/google/android/gms/vision/Detector$Processor;", "Lcom/google/android/gms/vision/barcode/Barcode;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "barcodeFormats", "", "barcodeReceived", "Lkotlin/Function1;", "", "cameraSurfaceFrame", "Landroid/graphics/Rect;", "currentCamera", "Lcom/google/android/gms/vision/CameraSource;", "currentDetector", "Lcom/google/android/gms/vision/barcode/BarcodeDetector;", "safeToTakePicture", "scannerArea", "getScannerArea", "()Landroid/graphics/Rect;", "setScannerArea", "(Landroid/graphics/Rect;)V", "cleanup", "", "convert", "rect", Constants.MessagePayloadKeys.FROM, "to", "generateNewBarcodeDetector", "kotlin.jvm.PlatformType", "generateNewCamera", "barcodeDetector", "frame", "getHackCamera", "Landroid/hardware/Camera;", "cameraSource", "pause", "receiveDetections", "detections", "Lcom/google/android/gms/vision/Detector$Detections;", "release", "setTorch", DebugKt.DEBUG_PROPERTY_VALUE_ON, "setup", "start", "holder", "Landroid/view/SurfaceHolder;", "stop", "surfaceChanged", "format", "width", "height", "surfaceCreated", "surfaceDestroyed", "unpause", "Companion", "base_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
@Singleton
/* compiled from: ScannerViewService.kt */
public final class ScannerViewService implements SurfaceHolder.Callback, Detector.Processor<Barcode> {
    public static final float CAMERA_FPS = 24.0f;
    public static final Companion Companion = new Companion(null);
    private int barcodeFormats = 256;
    private Function1<? super Barcode, Boolean> barcodeReceived;
    private Rect cameraSurfaceFrame = new Rect();
    private final Context context;
    private CameraSource currentCamera;
    private BarcodeDetector currentDetector;
    private boolean safeToTakePicture;
    private Rect scannerArea;

    @Override // com.google.android.gms.vision.Detector.Processor
    public void release() {
    }

    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        Intrinsics.checkNotNullParameter(surfaceHolder, "holder");
    }

    @Inject
    public ScannerViewService(Context context2) {
        Intrinsics.checkNotNullParameter(context2, "context");
        this.context = context2;
    }

    public final Rect getScannerArea() {
        return this.scannerArea;
    }

    public final void setScannerArea(Rect rect) {
        this.scannerArea = rect;
    }

    public static /* synthetic */ void setup$default(ScannerViewService scannerViewService, Function1 function1, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 256;
        }
        scannerViewService.setup(function1, i);
    }

    public final void setup(Function1<? super Barcode, Boolean> function1, int i) {
        Intrinsics.checkNotNullParameter(function1, "barcodeReceived");
        this.barcodeFormats = i;
        this.barcodeReceived = function1;
    }

    public final void stop() {
        cleanup();
    }

    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        Intrinsics.checkNotNullParameter(surfaceHolder, "holder");
        cleanup();
    }

    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        Intrinsics.checkNotNullParameter(surfaceHolder, "holder");
        start(surfaceHolder);
    }

    private final void start(SurfaceHolder surfaceHolder) {
        boolean z;
        try {
            Rect surfaceFrame = surfaceHolder.getSurfaceFrame();
            Intrinsics.checkNotNullExpressionValue(surfaceFrame, "holder.surfaceFrame");
            this.cameraSurfaceFrame = surfaceFrame;
            BarcodeDetector generateNewBarcodeDetector = generateNewBarcodeDetector();
            generateNewBarcodeDetector.setProcessor(this);
            Unit unit = Unit.INSTANCE;
            this.currentDetector = generateNewBarcodeDetector;
            if (generateNewBarcodeDetector != null) {
                Rect surfaceFrame2 = surfaceHolder.getSurfaceFrame();
                Intrinsics.checkNotNullExpressionValue(surfaceFrame2, "holder.surfaceFrame");
                CameraSource generateNewCamera = generateNewCamera(generateNewBarcodeDetector, surfaceFrame2);
                try {
                    generateNewCamera.start(surfaceHolder);
                    z = true;
                } catch (Exception e) {
                    Timber.e(e);
                    z = false;
                }
                this.safeToTakePicture = z;
                Unit unit2 = Unit.INSTANCE;
                this.currentCamera = generateNewCamera;
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type com.google.android.gms.vision.barcode.BarcodeDetector");
        } catch (SecurityException e2) {
            Timber.e("CAMERA SOURCE SECURITY EXCEPTION: " + e2, new Object[0]);
        }
    }

    public final void unpause() {
        this.safeToTakePicture = true;
    }

    public final void pause() {
        this.safeToTakePicture = false;
    }

    public final boolean setTorch(boolean z) {
        String str = z ? "torch" : DebugKt.DEBUG_PROPERTY_VALUE_OFF;
        try {
            CameraSource cameraSource = this.currentCamera;
            Intrinsics.checkNotNull(cameraSource);
            Camera hackCamera = getHackCamera(cameraSource);
            Intrinsics.checkNotNull(hackCamera);
            Camera.Parameters parameters = hackCamera.getParameters();
            parameters.setFlashMode(str);
            hackCamera.setParameters(parameters);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private final Camera getHackCamera(CameraSource cameraSource) {
        Field[] declaredFields = CameraSource.class.getDeclaredFields();
        Intrinsics.checkNotNullExpressionValue(declaredFields, "CameraSource::class.java.declaredFields");
        for (Field field : declaredFields) {
            Intrinsics.checkNotNullExpressionValue(field, "field");
            if (field.getType() == Camera.class) {
                field.setAccessible(true);
                try {
                    Object obj = field.get(cameraSource);
                    if (obj != null) {
                        return (Camera) obj;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type android.hardware.Camera");
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                    return null;
                }
            }
        }
        return null;
    }

    @Override // com.google.android.gms.vision.Detector.Processor
    public void receiveDetections(Detector.Detections<Barcode> detections) {
        Intrinsics.checkNotNullParameter(detections, "detections");
        SparseArray<Barcode> detectedItems = detections.getDetectedItems();
        Frame.Metadata frameMetadata = detections.getFrameMetadata();
        Intrinsics.checkNotNullExpressionValue(frameMetadata, "frameMeta");
        Rect rect = new Rect(0, 0, frameMetadata.getWidth(), frameMetadata.getHeight());
        int size = detectedItems.size();
        for (int i = 0; i < size; i++) {
            Barcode barcode = detectedItems.get(detectedItems.keyAt(i));
            Intrinsics.checkNotNullExpressionValue(barcode, "barcode");
            Rect boundingBox = barcode.getBoundingBox();
            Intrinsics.checkNotNullExpressionValue(boundingBox, "barcode.boundingBox");
            Rect convert = convert(boundingBox, rect, this.cameraSurfaceFrame);
            Rect rect2 = this.scannerArea;
            if ((rect2 != null ? rect2.contains(convert) : true) && this.safeToTakePicture) {
                Function1<? super Barcode, Boolean> function1 = this.barcodeReceived;
                if (function1 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("barcodeReceived");
                }
                boolean booleanValue = function1.invoke(barcode).booleanValue();
                CameraSource cameraSource = this.currentCamera;
                if (cameraSource != null) {
                    cameraSource.takePicture(null, new ScannerViewService$receiveDetections$1(this, booleanValue));
                }
                this.safeToTakePicture = false;
            }
        }
    }

    private final Rect convert(Rect rect, Rect rect2, Rect rect3) {
        float width = ((float) rect3.width()) / ((float) rect2.width());
        float height = ((float) rect3.height()) / ((float) rect2.height());
        return new Rect((int) (((float) rect.left) * width), (int) (((float) rect.top) * height), (int) (((float) rect.right) * width), (int) (((float) rect.bottom) * height));
    }

    private final BarcodeDetector generateNewBarcodeDetector() {
        return new BarcodeDetector.Builder(this.context).setBarcodeFormats(this.barcodeFormats).build();
    }

    private final CameraSource generateNewCamera(BarcodeDetector barcodeDetector, Rect rect) {
        CameraSource build = new CameraSource.Builder(this.context, barcodeDetector).setFacing(0).setRequestedPreviewSize(rect.height(), rect.width()).setAutoFocusEnabled(true).setRequestedFps(24.0f).build();
        Intrinsics.checkNotNullExpressionValue(build, "CameraSource.Builder(con…FPS)\n            .build()");
        return build;
    }

    private final void cleanup() {
        CameraSource cameraSource = this.currentCamera;
        if (cameraSource != null) {
            cameraSource.release();
        }
        BarcodeDetector barcodeDetector = this.currentDetector;
        if (barcodeDetector != null) {
            barcodeDetector.release();
        }
        this.currentCamera = null;
        this.currentDetector = null;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/digitalwallet/services/ScannerViewService$Companion;", "", "()V", "CAMERA_FPS", "", "base_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
    /* compiled from: ScannerViewService.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}
