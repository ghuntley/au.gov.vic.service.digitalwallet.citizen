package com.google.android.gms.vision.text;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.graphics.YuvImage;
import android.util.SparseArray;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.vision.zzah;
import com.google.android.gms.internal.vision.zzaj;
import com.google.android.gms.internal.vision.zzam;
import com.google.android.gms.internal.vision.zzan;
import com.google.android.gms.internal.vision.zzs;
import com.google.android.gms.internal.vision.zzw;
import com.google.android.gms.vision.Detector;
import com.google.android.gms.vision.Frame;
import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;

/* compiled from: com.google.android.gms:play-services-vision@@20.1.3 */
public final class TextRecognizer extends Detector<TextBlock> {
    private final zzan zza;

    private TextRecognizer() {
        throw new IllegalStateException("Default constructor called");
    }

    private TextRecognizer(zzan zzan) {
        this.zza = zzan;
    }

    /* compiled from: com.google.android.gms:play-services-vision@@20.1.3 */
    public static class Builder {
        private Context zza;
        private zzam zzb = new zzam();

        public Builder(Context context) {
            this.zza = context;
        }

        public TextRecognizer build() {
            return new TextRecognizer(new zzan(this.zza, this.zzb));
        }
    }

    @Override // com.google.android.gms.vision.Detector
    public final SparseArray<TextBlock> detect(Frame frame) {
        Bitmap bitmap;
        byte[] bArr;
        zzaj zzaj = new zzaj(new Rect());
        if (frame != null) {
            zzs zza2 = zzs.zza(frame);
            if (frame.getBitmap() != null) {
                bitmap = frame.getBitmap();
            } else {
                Frame.Metadata metadata = frame.getMetadata();
                ByteBuffer byteBuffer = (ByteBuffer) Preconditions.checkNotNull(frame.getGrayscaleImageData());
                int format = metadata.getFormat();
                int i = zza2.zza;
                int i2 = zza2.zzb;
                if (!byteBuffer.hasArray() || byteBuffer.arrayOffset() != 0) {
                    byte[] bArr2 = new byte[byteBuffer.capacity()];
                    byteBuffer.get(bArr2);
                    bArr = bArr2;
                } else {
                    bArr = byteBuffer.array();
                }
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                new YuvImage(bArr, format, i, i2, null).compressToJpeg(new Rect(0, 0, i, i2), 100, byteArrayOutputStream);
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                bitmap = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
            }
            Bitmap zza3 = zzw.zza((Bitmap) Preconditions.checkNotNull(bitmap), zza2);
            if (!zzaj.zza.isEmpty()) {
                Rect rect = zzaj.zza;
                int width = frame.getMetadata().getWidth();
                int height = frame.getMetadata().getHeight();
                int i3 = zza2.zze;
                if (i3 == 1) {
                    rect = new Rect(height - rect.bottom, rect.left, height - rect.top, rect.right);
                } else if (i3 == 2) {
                    rect = new Rect(width - rect.right, height - rect.bottom, width - rect.left, height - rect.top);
                } else if (i3 == 3) {
                    rect = new Rect(rect.top, width - rect.right, rect.bottom, width - rect.left);
                }
                zzaj.zza.set(rect);
            }
            zza2.zze = 0;
            zzah[] zza4 = this.zza.zza(zza3, zza2, zzaj);
            SparseArray sparseArray = new SparseArray();
            for (zzah zzah : zza4) {
                SparseArray sparseArray2 = (SparseArray) sparseArray.get(zzah.zzf);
                if (sparseArray2 == null) {
                    sparseArray2 = new SparseArray();
                    sparseArray.append(zzah.zzf, sparseArray2);
                }
                sparseArray2.append(zzah.zzg, zzah);
            }
            SparseArray<TextBlock> sparseArray3 = new SparseArray<>(sparseArray.size());
            for (int i4 = 0; i4 < sparseArray.size(); i4++) {
                sparseArray3.append(sparseArray.keyAt(i4), new TextBlock((SparseArray) sparseArray.valueAt(i4)));
            }
            return sparseArray3;
        }
        throw new IllegalArgumentException("No frame supplied.");
    }

    @Override // com.google.android.gms.vision.Detector
    public final boolean isOperational() {
        return this.zza.zzb();
    }

    @Override // com.google.android.gms.vision.Detector
    public final void release() {
        super.release();
        this.zza.zzc();
    }
}
