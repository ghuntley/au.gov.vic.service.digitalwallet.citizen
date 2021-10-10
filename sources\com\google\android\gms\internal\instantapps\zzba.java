package com.google.android.gms.internal.instantapps;

import com.google.android.gms.internal.instantapps.zzbc;
import com.google.android.gms.internal.instantapps.zzcx;
import java.util.Objects;

public final class zzba {

    public static final class zza extends zzcx<zza, C0008zza> implements zzeh {
        private static final zza zzcv;
        private static volatile zzeo<zza> zzcw;
        private zzdc<zzb> zzcu = zzca();

        private zza() {
        }

        /* renamed from: com.google.android.gms.internal.instantapps.zzba$zza$zza  reason: collision with other inner class name */
        public static final class C0008zza extends zzcx.zza<zza, C0008zza> implements zzeh {
            private C0008zza() {
                super(zza.zzcv);
            }

            public final int zzd() {
                return ((zza) this.zzapa).zzd();
            }

            public final C0008zza zza(zzb zzb) {
                zzbs();
                ((zza) this.zzapa).zzb((zza) zzb);
                return this;
            }

            public final C0008zza zza(int i, zzb zzb) {
                zzbs();
                ((zza) this.zzapa).zzb(i, zzb);
                return this;
            }

            /* synthetic */ C0008zza(zzaz zzaz) {
                this();
            }
        }

        public final int zzd() {
            return this.zzcu.size();
        }

        private final void zze() {
            if (!this.zzcu.zzr()) {
                zzdc<zzb> zzdc = this.zzcu;
                int size = zzdc.size();
                this.zzcu = zzdc.zzi(size == 0 ? 10 : size << 1);
            }
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final void zzb(zzb zzb) {
            Objects.requireNonNull(zzb);
            zze();
            this.zzcu.add(zzb);
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final void zzb(int i, zzb zzb) {
            Objects.requireNonNull(zzb);
            zze();
            this.zzcu.add(i, zzb);
        }

        public static C0008zza zzf() {
            return (C0008zza) zzcv.zzby();
        }

        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.instantapps.zzcx$zzc, com.google.android.gms.internal.instantapps.zzeo<com.google.android.gms.internal.instantapps.zzba$zza>] */
        /* access modifiers changed from: protected */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.instantapps.zzcx
        public final Object zza(int i, Object obj, Object obj2) {
            zzeo<zza> zzeo;
            switch (zzaz.zzct[i - 1]) {
                case 1:
                    return new zza();
                case 2:
                    return new C0008zza(null);
                case 3:
                    return zza(zzcv, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"zzcu", zzb.class});
                case 4:
                    return zzcv;
                case 5:
                    zzeo<zza> zzeo2 = zzcw;
                    zzeo<zza> zzeo3 = zzeo2;
                    if (zzeo2 == null) {
                        synchronized (zza.class) {
                            zzeo<zza> zzeo4 = zzcw;
                            zzeo = zzeo4;
                            if (zzeo4 == null) {
                                ?? zzc = new zzcx.zzc(zzcv);
                                zzcw = zzc;
                                zzeo = zzc;
                            }
                        }
                        zzeo3 = zzeo;
                    }
                    return zzeo3;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            zza zza = new zza();
            zzcv = zza;
            zzcx.zza(zza.class, zza);
        }
    }

    public static final class zzb extends zzcx<zzb, zza> implements zzeh {
        private static volatile zzeo<zzb> zzcw;
        private static final zzb zzda;
        private int zzcx;
        private int zzcy;
        private long zzcz;

        private zzb() {
        }

        public static final class zza extends zzcx.zza<zzb, zza> implements zzeh {
            private zza() {
                super(zzb.zzda);
            }

            public final zza zzb(zzbc.zza.zzb zzb) {
                zzbs();
                ((zzb) this.zzapa).zzc((zzb) zzb);
                return this;
            }

            public final zza zza(long j) {
                zzbs();
                ((zzb) this.zzapa).zzb((zzb) j);
                return this;
            }

            /* synthetic */ zza(zzaz zzaz) {
                this();
            }
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final void zzc(zzbc.zza.zzb zzb) {
            Objects.requireNonNull(zzb);
            this.zzcx |= 1;
            this.zzcy = zzb.zzk();
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final void zzb(long j) {
            this.zzcx |= 2;
            this.zzcz = j;
        }

        public static zza zzh() {
            return (zza) zzda.zzby();
        }

        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.instantapps.zzcx$zzc, com.google.android.gms.internal.instantapps.zzeo<com.google.android.gms.internal.instantapps.zzba$zzb>] */
        /* access modifiers changed from: protected */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.instantapps.zzcx
        public final Object zza(int i, Object obj, Object obj2) {
            zzeo<zzb> zzeo;
            switch (zzaz.zzct[i - 1]) {
                case 1:
                    return new zzb();
                case 2:
                    return new zza(null);
                case 3:
                    return zza(zzda, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\f\u0000\u0002\u0002\u0001", new Object[]{"zzcx", "zzcy", zzbc.zza.zzb.zzl(), "zzcz"});
                case 4:
                    return zzda;
                case 5:
                    zzeo<zzb> zzeo2 = zzcw;
                    zzeo<zzb> zzeo3 = zzeo2;
                    if (zzeo2 == null) {
                        synchronized (zzb.class) {
                            zzeo<zzb> zzeo4 = zzcw;
                            zzeo = zzeo4;
                            if (zzeo4 == null) {
                                ?? zzc = new zzcx.zzc(zzda);
                                zzcw = zzc;
                                zzeo = zzc;
                            }
                        }
                        zzeo3 = zzeo;
                    }
                    return zzeo3;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            zzb zzb = new zzb();
            zzda = zzb;
            zzcx.zza(zzb.class, zzb);
        }
    }
}
