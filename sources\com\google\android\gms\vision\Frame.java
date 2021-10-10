package com.google.android.gms.vision;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.media.Image;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
public class Frame {
    public static final int ROTATION_0 = 0;
    public static final int ROTATION_180 = 2;
    public static final int ROTATION_270 = 3;
    public static final int ROTATION_90 = 1;
    private final Metadata zza;
    @Nullable
    private ByteBuffer zzb;
    @Nullable
    private zza zzc;
    @Nullable
    private Bitmap zzd;

    public Metadata getMetadata() {
        return this.zza;
    }

    /* compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
    public static class Builder {
        private final Frame zza = new Frame();

        public Builder setBitmap(Bitmap bitmap) {
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            this.zza.zzd = bitmap;
            Metadata metadata = this.zza.getMetadata();
            metadata.zza = width;
            metadata.zzb = height;
            return this;
        }

        public Builder setPlanes(Image.Plane[] planeArr, int i, int i2, int i3) {
            if (planeArr == null) {
                throw new IllegalArgumentException("Null image data supplied.");
            } else if (planeArr.length != 3) {
                throw new IllegalArgumentException("Only android.graphics.ImageFormat#YUV_420_888 is supported which should have 3 planes.");
            } else if (planeArr[0].getBuffer().capacity() >= i * i2) {
                this.zza.zzc = new zza(planeArr);
                Metadata metadata = this.zza.getMetadata();
                metadata.zza = i;
                metadata.zzb = i2;
                metadata.zzf = i3;
                return this;
            } else {
                throw new IllegalArgumentException("Invalid image data size.");
            }
        }

        public Builder setImageData(ByteBuffer byteBuffer, int i, int i2, int i3) {
            if (byteBuffer == null) {
                throw new IllegalArgumentException("Null image data supplied.");
            } else if (byteBuffer.capacity() < i * i2) {
                throw new IllegalArgumentException("Invalid image data size.");
            } else if (i3 == 16 || i3 == 17 || i3 == 842094169) {
                this.zza.zzb = byteBuffer;
                Metadata metadata = this.zza.getMetadata();
                metadata.zza = i;
                metadata.zzb = i2;
                metadata.zzf = i3;
                return this;
            } else {
                StringBuilder sb = new StringBuilder(37);
                sb.append("Unsupported image format: ");
                sb.append(i3);
                throw new IllegalArgumentException(sb.toString());
            }
        }

        public Builder setId(int i) {
            this.zza.getMetadata().zzc = i;
            return this;
        }

        public Builder setTimestampMillis(long j) {
            this.zza.getMetadata().zzd = j;
            return this;
        }

        public Builder setRotation(int i) {
            this.zza.getMetadata().zze = i;
            return this;
        }

        public Frame build() {
            if (this.zza.zzb != null || this.zza.zzd != null || this.zza.zzc != null) {
                return this.zza;
            }
            throw new IllegalStateException("Missing image data.  Call either setBitmap or setImageData to specify the image");
        }
    }

    public Image.Plane[] getPlanes() {
        zza zza2 = this.zzc;
        if (zza2 == null) {
            return null;
        }
        return zza2.zza();
    }

    /* compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
    public static class Metadata {
        private int zza;
        private int zzb;
        private int zzc;
        private long zzd;
        private int zze;
        private int zzf = -1;

        public Metadata() {
        }

        public Metadata(Metadata metadata) {
            this.zza = metadata.getWidth();
            this.zzb = metadata.getHeight();
            this.zzc = metadata.getId();
            this.zzd = metadata.getTimestampMillis();
            this.zze = metadata.getRotation();
            this.zzf = metadata.getFormat();
        }

        public int getWidth() {
            return this.zza;
        }

        public int getHeight() {
            return this.zzb;
        }

        public int getId() {
            return this.zzc;
        }

        public long getTimestampMillis() {
            return this.zzd;
        }

        public int getRotation() {
            return this.zze;
        }

        public int getFormat() {
            return this.zzf;
        }

        public final void zza() {
            if (this.zze % 2 != 0) {
                int i = this.zza;
                this.zza = this.zzb;
                this.zzb = i;
            }
            this.zze = 0;
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
    public static class zza {
        private final Image.Plane[] zza;

        zza(Image.Plane[] planeArr) {
            this.zza = planeArr;
        }

        /* access modifiers changed from: package-private */
        public final Image.Plane[] zza() {
            return this.zza;
        }
    }

    public ByteBuffer getGrayscaleImageData() {
        Bitmap bitmap = this.zzd;
        if (bitmap == null) {
            return this.zzb;
        }
        if (bitmap == null) {
            return null;
        }
        int width = bitmap.getWidth();
        int height = this.zzd.getHeight();
        int i = width * height;
        int[] iArr = new int[i];
        this.zzd.getPixels(iArr, 0, width, 0, 0, width, height);
        byte[] bArr = new byte[i];
        for (int i2 = 0; i2 < i; i2++) {
            bArr[i2] = (byte) ((int) ((((float) Color.red(iArr[i2])) * 0.299f) + (((float) Color.green(iArr[i2])) * 0.587f) + (((float) Color.blue(iArr[i2])) * 0.114f)));
        }
        return ByteBuffer.wrap(bArr);
    }

    public Bitmap getBitmap() {
        return this.zzd;
    }

    private Frame() {
        this.zza = new Metadata();
        this.zzb = null;
        this.zzc = null;
        this.zzd = null;
    }
}
