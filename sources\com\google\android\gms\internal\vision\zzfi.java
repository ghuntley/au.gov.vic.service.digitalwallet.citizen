package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.zzjb;
import kotlin.text.Typography;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
public final class zzfi {

    /* compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
    public static final class zzb extends zzjb<zzb, zza> implements zzkm {
        private static final zzji<Integer, zzgz> zzd = new zzfl();
        private static final zzb zze;
        private static volatile zzkx<zzb> zzf;
        private zzjj zzc = zzn();

        private zzb() {
        }

        /* compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
        public static final class zza extends zzjb.zzb<zzb, zza> implements zzkm {
            private zza() {
                super(zzb.zze);
            }

            /* synthetic */ zza(zzfk zzfk) {
                this();
            }
        }

        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.vision.zzkx<com.google.android.gms.internal.vision.zzfi$zzb>, com.google.android.gms.internal.vision.zzjb$zza] */
        /* access modifiers changed from: protected */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.vision.zzjb
        public final Object zza(int i, Object obj, Object obj2) {
            zzkx<zzb> zzkx;
            switch (zzfk.zza[i - 1]) {
                case 1:
                    return new zzb();
                case 2:
                    return new zza(null);
                case 3:
                    return zza(zze, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001e", new Object[]{"zzc", zzgz.zzb()});
                case 4:
                    return zze;
                case 5:
                    zzkx<zzb> zzkx2 = zzf;
                    zzkx<zzb> zzkx3 = zzkx2;
                    if (zzkx2 == null) {
                        synchronized (zzb.class) {
                            zzkx<zzb> zzkx4 = zzf;
                            zzkx = zzkx4;
                            if (zzkx4 == null) {
                                ?? zza2 = new zzjb.zza(zze);
                                zzf = zza2;
                                zzkx = zza2;
                            }
                        }
                        zzkx3 = zzkx;
                    }
                    return zzkx3;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [com.google.android.gms.internal.vision.zzji<java.lang.Integer, com.google.android.gms.internal.vision.zzgz>, com.google.android.gms.internal.vision.zzfl] */
        static {
            zzb zzb = new zzb();
            zze = zzb;
            zzjb.zza(zzb.class, zzb);
        }
    }

    /* compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
    public static final class zzc extends zzjb<zzc, zza> implements zzkm {
        private static final zzc zzg;
        private static volatile zzkx<zzc> zzh;
        private int zzc;
        private int zzd;
        private int zze;
        private String zzf = "";

        private zzc() {
        }

        /* compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
        public static final class zza extends zzjb.zzb<zzc, zza> implements zzkm {
            private zza() {
                super(zzc.zzg);
            }

            /* synthetic */ zza(zzfk zzfk) {
                this();
            }
        }

        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.vision.zzkx<com.google.android.gms.internal.vision.zzfi$zzc>, com.google.android.gms.internal.vision.zzjb$zza] */
        /* access modifiers changed from: protected */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.vision.zzjb
        public final Object zza(int i, Object obj, Object obj2) {
            zzkx<zzc> zzkx;
            switch (zzfk.zza[i - 1]) {
                case 1:
                    return new zzc();
                case 2:
                    return new zza(null);
                case 3:
                    return zza(zzg, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဌ\u0001\u0003ဈ\u0002", new Object[]{"zzc", "zzd", zzgz.zzb(), "zze", zzha.zzb(), "zzf"});
                case 4:
                    return zzg;
                case 5:
                    zzkx<zzc> zzkx2 = zzh;
                    zzkx<zzc> zzkx3 = zzkx2;
                    if (zzkx2 == null) {
                        synchronized (zzc.class) {
                            zzkx<zzc> zzkx4 = zzh;
                            zzkx = zzkx4;
                            if (zzkx4 == null) {
                                ?? zza2 = new zzjb.zza(zzg);
                                zzh = zza2;
                                zzkx = zza2;
                            }
                        }
                        zzkx3 = zzkx;
                    }
                    return zzkx3;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            zzc zzc2 = new zzc();
            zzg = zzc2;
            zzjb.zza(zzc.class, zzc2);
        }
    }

    /* compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
    public static final class zze extends zzjb<zze, zza> implements zzkm {
        private static final zze zzl;
        private static volatile zzkx<zze> zzm;
        private int zzc;
        private String zzd = "";
        private boolean zze;
        private int zzf;
        private long zzg;
        private long zzh;
        private long zzi;
        private String zzj = "";
        private boolean zzk;

        /* compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
        public enum zzb implements zzje {
            REASON_UNKNOWN(0),
            REASON_MISSING(1),
            REASON_UPGRADE(2),
            REASON_INVALID(3);
            
            private static final zzjh<zzb> zze = new zzfm();
            private final int zzf;

            @Override // com.google.android.gms.internal.vision.zzje
            public final int zza() {
                return this.zzf;
            }

            public static zzb zza(int i) {
                if (i == 0) {
                    return REASON_UNKNOWN;
                }
                if (i == 1) {
                    return REASON_MISSING;
                }
                if (i == 2) {
                    return REASON_UPGRADE;
                }
                if (i != 3) {
                    return null;
                }
                return REASON_INVALID;
            }

            public static zzjg zzb() {
                return zzfn.zza;
            }

            public final String toString() {
                return "<" + getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzf + " name=" + name() + Typography.greater;
            }

            private zzb(int i) {
                this.zzf = i;
            }
        }

        private zze() {
        }

        /* compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
        public static final class zza extends zzjb.zzb<zze, zza> implements zzkm {
            private zza() {
                super(zze.zzl);
            }

            /* synthetic */ zza(zzfk zzfk) {
                this();
            }
        }

        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.vision.zzkx<com.google.android.gms.internal.vision.zzfi$zze>, com.google.android.gms.internal.vision.zzjb$zza] */
        /* access modifiers changed from: protected */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.vision.zzjb
        public final Object zza(int i, Object obj, Object obj2) {
            zzkx<zze> zzkx;
            switch (zzfk.zza[i - 1]) {
                case 1:
                    return new zze();
                case 2:
                    return new zza(null);
                case 3:
                    return zza(zzl, "\u0001\b\u0000\u0001\u0001\b\b\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဇ\u0001\u0003ဌ\u0002\u0004ဂ\u0003\u0005ဂ\u0004\u0006ဂ\u0005\u0007ဈ\u0006\bဇ\u0007", new Object[]{"zzc", "zzd", "zze", "zzf", zzb.zzb(), "zzg", "zzh", "zzi", "zzj", "zzk"});
                case 4:
                    return zzl;
                case 5:
                    zzkx<zze> zzkx2 = zzm;
                    zzkx<zze> zzkx3 = zzkx2;
                    if (zzkx2 == null) {
                        synchronized (zze.class) {
                            zzkx<zze> zzkx4 = zzm;
                            zzkx = zzkx4;
                            if (zzkx4 == null) {
                                ?? zza2 = new zzjb.zza(zzl);
                                zzm = zza2;
                                zzkx = zza2;
                            }
                        }
                        zzkx3 = zzkx;
                    }
                    return zzkx3;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            zze zze2 = new zze();
            zzl = zze2;
            zzjb.zza(zze.class, zze2);
        }
    }

    /* compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
    public static final class zzl extends zzjb<zzl, zza> implements zzkm {
        private static final zzl zzf;
        private static volatile zzkx<zzl> zzg;
        private int zzc;
        private long zzd;
        private long zze;

        private zzl() {
        }

        /* compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
        public static final class zza extends zzjb.zzb<zzl, zza> implements zzkm {
            private zza() {
                super(zzl.zzf);
            }

            /* synthetic */ zza(zzfk zzfk) {
                this();
            }
        }

        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.vision.zzjb$zza, com.google.android.gms.internal.vision.zzkx<com.google.android.gms.internal.vision.zzfi$zzl>] */
        /* access modifiers changed from: protected */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.vision.zzjb
        public final Object zza(int i, Object obj, Object obj2) {
            zzkx<zzl> zzkx;
            switch (zzfk.zza[i - 1]) {
                case 1:
                    return new zzl();
                case 2:
                    return new zza(null);
                case 3:
                    return zza(zzf, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဂ\u0000\u0002ဂ\u0001", new Object[]{"zzc", "zzd", "zze"});
                case 4:
                    return zzf;
                case 5:
                    zzkx<zzl> zzkx2 = zzg;
                    zzkx<zzl> zzkx3 = zzkx2;
                    if (zzkx2 == null) {
                        synchronized (zzl.class) {
                            zzkx<zzl> zzkx4 = zzg;
                            zzkx = zzkx4;
                            if (zzkx4 == null) {
                                ?? zza2 = new zzjb.zza(zzf);
                                zzg = zza2;
                                zzkx = zza2;
                            }
                        }
                        zzkx3 = zzkx;
                    }
                    return zzkx3;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            zzl zzl = new zzl();
            zzf = zzl;
            zzjb.zza(zzl.class, zzl);
        }
    }

    /* compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
    public static final class zza extends zzjb<zza, C0014zza> implements zzkm {
        private static final zza zzf;
        private static volatile zzkx<zza> zzg;
        private int zzc;
        private String zzd = "";
        private String zze = "";

        private zza() {
        }

        /* renamed from: com.google.android.gms.internal.vision.zzfi$zza$zza  reason: collision with other inner class name */
        /* compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
        public static final class C0014zza extends zzjb.zzb<zza, C0014zza> implements zzkm {
            private C0014zza() {
                super(zza.zzf);
            }

            public final C0014zza zza(String str) {
                if (this.zzb) {
                    zzb();
                    this.zzb = false;
                }
                ((zza) this.zza).zza((zza) str);
                return this;
            }

            public final C0014zza zzb(String str) {
                if (this.zzb) {
                    zzb();
                    this.zzb = false;
                }
                ((zza) this.zza).zzb((zza) str);
                return this;
            }

            /* synthetic */ C0014zza(zzfk zzfk) {
                this();
            }
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final void zza(String str) {
            str.getClass();
            this.zzc |= 1;
            this.zzd = str;
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final void zzb(String str) {
            str.getClass();
            this.zzc |= 2;
            this.zze = str;
        }

        public static C0014zza zza() {
            return (C0014zza) zzf.zzj();
        }

        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.vision.zzkx<com.google.android.gms.internal.vision.zzfi$zza>, com.google.android.gms.internal.vision.zzjb$zza] */
        /* access modifiers changed from: protected */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.vision.zzjb
        public final Object zza(int i, Object obj, Object obj2) {
            zzkx<zza> zzkx;
            switch (zzfk.zza[i - 1]) {
                case 1:
                    return new zza();
                case 2:
                    return new C0014zza(null);
                case 3:
                    return zza(zzf, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001", new Object[]{"zzc", "zzd", "zze"});
                case 4:
                    return zzf;
                case 5:
                    zzkx<zza> zzkx2 = zzg;
                    zzkx<zza> zzkx3 = zzkx2;
                    if (zzkx2 == null) {
                        synchronized (zza.class) {
                            zzkx<zza> zzkx4 = zzg;
                            zzkx = zzkx4;
                            if (zzkx4 == null) {
                                ?? zza = new zzjb.zza(zzf);
                                zzg = zza;
                                zzkx = zza;
                            }
                        }
                        zzkx3 = zzkx;
                    }
                    return zzkx3;
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
            zzf = zza;
            zzjb.zza(zza.class, zza);
        }
    }

    /* compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
    public static final class zzd extends zzjb<zzd, zza> implements zzkm {
        private static final zzd zzd;
        private static volatile zzkx<zzd> zze;
        private zzjl<zzm> zzc = zzo();

        private zzd() {
        }

        /* compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
        public static final class zza extends zzjb.zzb<zzd, zza> implements zzkm {
            private zza() {
                super(zzd.zzd);
            }

            public final zza zza(zzm zzm) {
                if (this.zzb) {
                    zzb();
                    this.zzb = false;
                }
                ((zzd) this.zza).zza((zzd) zzm);
                return this;
            }

            public final zza zza(zzm.zza zza) {
                if (this.zzb) {
                    zzb();
                    this.zzb = false;
                }
                ((zzd) this.zza).zza((zzd) ((zzm) ((zzjb) zza.zzf())));
                return this;
            }

            /* synthetic */ zza(zzfk zzfk) {
                this();
            }
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final void zza(zzm zzm) {
            zzm.getClass();
            zzjl<zzm> zzjl = this.zzc;
            if (!zzjl.zza()) {
                this.zzc = zzjb.zza(zzjl);
            }
            this.zzc.add(zzm);
        }

        public static zza zza() {
            return (zza) zzd.zzj();
        }

        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.vision.zzkx<com.google.android.gms.internal.vision.zzfi$zzd>, com.google.android.gms.internal.vision.zzjb$zza] */
        /* access modifiers changed from: protected */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.vision.zzjb
        public final Object zza(int i, Object obj, Object obj2) {
            zzkx<zzd> zzkx;
            switch (zzfk.zza[i - 1]) {
                case 1:
                    return new zzd();
                case 2:
                    return new zza(null);
                case 3:
                    return zza(zzd, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"zzc", zzm.class});
                case 4:
                    return zzd;
                case 5:
                    zzkx<zzd> zzkx2 = zze;
                    zzkx<zzd> zzkx3 = zzkx2;
                    if (zzkx2 == null) {
                        synchronized (zzd.class) {
                            zzkx<zzd> zzkx4 = zze;
                            zzkx = zzkx4;
                            if (zzkx4 == null) {
                                ?? zza2 = new zzjb.zza(zzd);
                                zze = zza2;
                                zzkx = zza2;
                            }
                        }
                        zzkx3 = zzkx;
                    }
                    return zzkx3;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            zzd zzd2 = new zzd();
            zzd = zzd2;
            zzjb.zza(zzd.class, zzd2);
        }
    }

    /* compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
    public static final class zzf extends zzjb<zzf, zzb> implements zzkm {
        private static final zzf zzl;
        private static volatile zzkx<zzf> zzm;
        private int zzc;
        private String zzd = "";
        private String zze = "";
        private zzjl<String> zzf = zzjb.zzo();
        private int zzg;
        private String zzh = "";
        private long zzi;
        private long zzj;
        private zzjl<zzn> zzk = zzo();

        /* compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
        public enum zza implements zzje {
            RESULT_UNKNOWN(0),
            RESULT_SUCCESS(1),
            RESULT_FAIL(2),
            RESULT_SKIPPED(3);
            
            private static final zzjh<zza> zze = new zzfp();
            private final int zzf;

            @Override // com.google.android.gms.internal.vision.zzje
            public final int zza() {
                return this.zzf;
            }

            public static zza zza(int i) {
                if (i == 0) {
                    return RESULT_UNKNOWN;
                }
                if (i == 1) {
                    return RESULT_SUCCESS;
                }
                if (i == 2) {
                    return RESULT_FAIL;
                }
                if (i != 3) {
                    return null;
                }
                return RESULT_SKIPPED;
            }

            public static zzjg zzb() {
                return zzfo.zza;
            }

            public final String toString() {
                return "<" + getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzf + " name=" + name() + Typography.greater;
            }

            private zza(int i) {
                this.zzf = i;
            }
        }

        private zzf() {
        }

        /* compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
        public static final class zzb extends zzjb.zzb<zzf, zzb> implements zzkm {
            private zzb() {
                super(zzf.zzl);
            }

            public final zzb zza(String str) {
                if (this.zzb) {
                    zzb();
                    this.zzb = false;
                }
                ((zzf) this.zza).zza((zzf) str);
                return this;
            }

            public final zzb zza(long j) {
                if (this.zzb) {
                    zzb();
                    this.zzb = false;
                }
                ((zzf) this.zza).zza((zzf) j);
                return this;
            }

            public final zzb zzb(long j) {
                if (this.zzb) {
                    zzb();
                    this.zzb = false;
                }
                ((zzf) this.zza).zzb((zzf) j);
                return this;
            }

            public final zzb zza(Iterable<? extends zzn> iterable) {
                if (this.zzb) {
                    zzb();
                    this.zzb = false;
                }
                ((zzf) this.zza).zza((zzf) iterable);
                return this;
            }

            /* synthetic */ zzb(zzfk zzfk) {
                this();
            }
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final void zza(String str) {
            str.getClass();
            this.zzc |= 1;
            this.zzd = str;
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final void zza(long j) {
            this.zzc |= 16;
            this.zzi = j;
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final void zzb(long j) {
            this.zzc |= 32;
            this.zzj = j;
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final void zza(Iterable<? extends zzn> iterable) {
            zzjl<zzn> zzjl = this.zzk;
            if (!zzjl.zza()) {
                this.zzk = zzjb.zza(zzjl);
            }
            zzhf.zza(iterable, this.zzk);
        }

        public static zzb zza() {
            return (zzb) zzl.zzj();
        }

        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.vision.zzkx<com.google.android.gms.internal.vision.zzfi$zzf>, com.google.android.gms.internal.vision.zzjb$zza] */
        /* access modifiers changed from: protected */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.vision.zzjb
        public final Object zza(int i, Object obj, Object obj2) {
            zzkx<zzf> zzkx;
            switch (zzfk.zza[i - 1]) {
                case 1:
                    return new zzf();
                case 2:
                    return new zzb(null);
                case 3:
                    return zza(zzl, "\u0001\b\u0000\u0001\u0001\b\b\u0000\u0002\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003\u001a\u0004ဌ\u0002\u0005ဈ\u0003\u0006ဂ\u0004\u0007ဂ\u0005\b\u001b", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg", zza.zzb(), "zzh", "zzi", "zzj", "zzk", zzn.class});
                case 4:
                    return zzl;
                case 5:
                    zzkx<zzf> zzkx2 = zzm;
                    zzkx<zzf> zzkx3 = zzkx2;
                    if (zzkx2 == null) {
                        synchronized (zzf.class) {
                            zzkx<zzf> zzkx4 = zzm;
                            zzkx = zzkx4;
                            if (zzkx4 == null) {
                                ?? zza2 = new zzjb.zza(zzl);
                                zzm = zza2;
                                zzkx = zza2;
                            }
                        }
                        zzkx3 = zzkx;
                    }
                    return zzkx3;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            zzf zzf2 = new zzf();
            zzl = zzf2;
            zzjb.zza(zzf.class, zzf2);
        }
    }

    /* compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
    public static final class zzg extends zzjb<zzg, zza> implements zzkm {
        private static final zzg zzj;
        private static volatile zzkx<zzg> zzk;
        private int zzc;
        private int zzd;
        private int zze;
        private int zzf;
        private boolean zzg;
        private boolean zzh;
        private float zzi;

        /* compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
        public enum zzb implements zzje {
            CLASSIFICATION_UNKNOWN(0),
            CLASSIFICATION_NONE(1),
            CLASSIFICATION_ALL(2);
            
            private static final zzjh<zzb> zzd = new zzfq();
            private final int zze;

            @Override // com.google.android.gms.internal.vision.zzje
            public final int zza() {
                return this.zze;
            }

            public static zzb zza(int i) {
                if (i == 0) {
                    return CLASSIFICATION_UNKNOWN;
                }
                if (i == 1) {
                    return CLASSIFICATION_NONE;
                }
                if (i != 2) {
                    return null;
                }
                return CLASSIFICATION_ALL;
            }

            public static zzjg zzb() {
                return zzfr.zza;
            }

            public final String toString() {
                return "<" + getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zze + " name=" + name() + Typography.greater;
            }

            private zzb(int i) {
                this.zze = i;
            }
        }

        /* compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
        public enum zzc implements zzje {
            LANDMARK_UNKNOWN(0),
            LANDMARK_NONE(1),
            LANDMARK_ALL(2),
            LANDMARK_CONTOUR(3);
            
            private static final zzjh<zzc> zze = new zzft();
            private final int zzf;

            @Override // com.google.android.gms.internal.vision.zzje
            public final int zza() {
                return this.zzf;
            }

            public static zzc zza(int i) {
                if (i == 0) {
                    return LANDMARK_UNKNOWN;
                }
                if (i == 1) {
                    return LANDMARK_NONE;
                }
                if (i == 2) {
                    return LANDMARK_ALL;
                }
                if (i != 3) {
                    return null;
                }
                return LANDMARK_CONTOUR;
            }

            public static zzjg zzb() {
                return zzfs.zza;
            }

            public final String toString() {
                return "<" + getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzf + " name=" + name() + Typography.greater;
            }

            private zzc(int i) {
                this.zzf = i;
            }
        }

        /* compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
        public enum zzd implements zzje {
            MODE_UNKNOWN(0),
            MODE_ACCURATE(1),
            MODE_FAST(2),
            MODE_SELFIE(3);
            
            private static final zzjh<zzd> zze = new zzfu();
            private final int zzf;

            @Override // com.google.android.gms.internal.vision.zzje
            public final int zza() {
                return this.zzf;
            }

            public static zzd zza(int i) {
                if (i == 0) {
                    return MODE_UNKNOWN;
                }
                if (i == 1) {
                    return MODE_ACCURATE;
                }
                if (i == 2) {
                    return MODE_FAST;
                }
                if (i != 3) {
                    return null;
                }
                return MODE_SELFIE;
            }

            public static zzjg zzb() {
                return zzfv.zza;
            }

            public final String toString() {
                return "<" + getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzf + " name=" + name() + Typography.greater;
            }

            private zzd(int i) {
                this.zzf = i;
            }
        }

        private zzg() {
        }

        /* compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
        public static final class zza extends zzjb.zzb<zzg, zza> implements zzkm {
            private zza() {
                super(zzg.zzj);
            }

            public final zza zza(zzd zzd) {
                if (this.zzb) {
                    zzb();
                    this.zzb = false;
                }
                ((zzg) this.zza).zza((zzg) zzd);
                return this;
            }

            public final zza zza(zzc zzc) {
                if (this.zzb) {
                    zzb();
                    this.zzb = false;
                }
                ((zzg) this.zza).zza((zzg) zzc);
                return this;
            }

            public final zza zza(zzb zzb) {
                if (this.zzb) {
                    zzb();
                    this.zzb = false;
                }
                ((zzg) this.zza).zza((zzg) zzb);
                return this;
            }

            public final zza zza(boolean z) {
                if (this.zzb) {
                    zzb();
                    this.zzb = false;
                }
                ((zzg) this.zza).zza((zzg) z);
                return this;
            }

            public final zza zzb(boolean z) {
                if (this.zzb) {
                    zzb();
                    this.zzb = false;
                }
                ((zzg) this.zza).zzb((zzg) z);
                return this;
            }

            public final zza zza(float f) {
                if (this.zzb) {
                    zzb();
                    this.zzb = false;
                }
                ((zzg) this.zza).zza((zzg) f);
                return this;
            }

            /* synthetic */ zza(zzfk zzfk) {
                this();
            }
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final void zza(zzd zzd2) {
            this.zzd = zzd2.zza();
            this.zzc |= 1;
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final void zza(zzc zzc2) {
            this.zze = zzc2.zza();
            this.zzc |= 2;
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final void zza(zzb zzb2) {
            this.zzf = zzb2.zza();
            this.zzc |= 4;
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final void zza(boolean z) {
            this.zzc |= 8;
            this.zzg = z;
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final void zzb(boolean z) {
            this.zzc |= 16;
            this.zzh = z;
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final void zza(float f) {
            this.zzc |= 32;
            this.zzi = f;
        }

        public static zza zza() {
            return (zza) zzj.zzj();
        }

        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.vision.zzkx<com.google.android.gms.internal.vision.zzfi$zzg>, com.google.android.gms.internal.vision.zzjb$zza] */
        /* access modifiers changed from: protected */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.vision.zzjb
        public final Object zza(int i, Object obj, Object obj2) {
            zzkx<zzg> zzkx;
            switch (zzfk.zza[i - 1]) {
                case 1:
                    return new zzg();
                case 2:
                    return new zza(null);
                case 3:
                    return zza(zzj, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဌ\u0001\u0003ဌ\u0002\u0004ဇ\u0003\u0005ဇ\u0004\u0006ခ\u0005", new Object[]{"zzc", "zzd", zzd.zzb(), "zze", zzc.zzb(), "zzf", zzb.zzb(), "zzg", "zzh", "zzi"});
                case 4:
                    return zzj;
                case 5:
                    zzkx<zzg> zzkx2 = zzk;
                    zzkx<zzg> zzkx3 = zzkx2;
                    if (zzkx2 == null) {
                        synchronized (zzg.class) {
                            zzkx<zzg> zzkx4 = zzk;
                            zzkx = zzkx4;
                            if (zzkx4 == null) {
                                ?? zza2 = new zzjb.zza(zzj);
                                zzk = zza2;
                                zzkx = zza2;
                            }
                        }
                        zzkx3 = zzkx;
                    }
                    return zzkx3;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            zzg zzg2 = new zzg();
            zzj = zzg2;
            zzjb.zza(zzg.class, zzg2);
        }
    }

    /* compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
    public static final class zzh extends zzjb<zzh, zza> implements zzkm {
        private static final zzh zzj;
        private static volatile zzkx<zzh> zzk;
        private int zzc;
        private float zzd;
        private float zze;
        private float zzf;
        private float zzg;
        private float zzh;
        private float zzi;

        private zzh() {
        }

        /* compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
        public static final class zza extends zzjb.zzb<zzh, zza> implements zzkm {
            private zza() {
                super(zzh.zzj);
            }

            public final zza zza(float f) {
                if (this.zzb) {
                    zzb();
                    this.zzb = false;
                }
                ((zzh) this.zza).zza((zzh) f);
                return this;
            }

            public final zza zzb(float f) {
                if (this.zzb) {
                    zzb();
                    this.zzb = false;
                }
                ((zzh) this.zza).zzb((zzh) f);
                return this;
            }

            public final zza zzc(float f) {
                if (this.zzb) {
                    zzb();
                    this.zzb = false;
                }
                ((zzh) this.zza).zzc(f);
                return this;
            }

            public final zza zzd(float f) {
                if (this.zzb) {
                    zzb();
                    this.zzb = false;
                }
                ((zzh) this.zza).zzd(f);
                return this;
            }

            public final zza zze(float f) {
                if (this.zzb) {
                    zzb();
                    this.zzb = false;
                }
                ((zzh) this.zza).zze(f);
                return this;
            }

            public final zza zzf(float f) {
                if (this.zzb) {
                    zzb();
                    this.zzb = false;
                }
                ((zzh) this.zza).zzf(f);
                return this;
            }

            /* synthetic */ zza(zzfk zzfk) {
                this();
            }
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final void zza(float f) {
            this.zzc |= 1;
            this.zzd = f;
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final void zzb(float f) {
            this.zzc |= 2;
            this.zze = f;
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final void zzc(float f) {
            this.zzc |= 4;
            this.zzf = f;
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final void zzd(float f) {
            this.zzc |= 8;
            this.zzg = f;
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final void zze(float f) {
            this.zzc |= 16;
            this.zzh = f;
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final void zzf(float f) {
            this.zzc |= 32;
            this.zzi = f;
        }

        public static zza zza() {
            return (zza) zzj.zzj();
        }

        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.vision.zzkx<com.google.android.gms.internal.vision.zzfi$zzh>, com.google.android.gms.internal.vision.zzjb$zza] */
        /* access modifiers changed from: protected */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.vision.zzjb
        public final Object zza(int i, Object obj, Object obj2) {
            zzkx<zzh> zzkx;
            switch (zzfk.zza[i - 1]) {
                case 1:
                    return new zzh();
                case 2:
                    return new zza(null);
                case 3:
                    return zza(zzj, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001ခ\u0000\u0002ခ\u0001\u0003ခ\u0002\u0004ခ\u0003\u0005ခ\u0004\u0006ခ\u0005", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg", "zzh", "zzi"});
                case 4:
                    return zzj;
                case 5:
                    zzkx<zzh> zzkx2 = zzk;
                    zzkx<zzh> zzkx3 = zzkx2;
                    if (zzkx2 == null) {
                        synchronized (zzh.class) {
                            zzkx<zzh> zzkx4 = zzk;
                            zzkx = zzkx4;
                            if (zzkx4 == null) {
                                ?? zza2 = new zzjb.zza(zzj);
                                zzk = zza2;
                                zzkx = zza2;
                            }
                        }
                        zzkx3 = zzkx;
                    }
                    return zzkx3;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            zzh zzh2 = new zzh();
            zzj = zzh2;
            zzjb.zza(zzh.class, zzh2);
        }
    }

    /* compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
    public static final class zzi extends zzjb<zzi, zza> implements zzkm {
        private static final zzi zzg;
        private static volatile zzkx<zzi> zzh;
        private int zzc;
        private zzj zzd;
        private zzl zze;
        private zzjl<zzf> zzf = zzo();

        private zzi() {
        }

        /* compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
        public static final class zza extends zzjb.zzb<zzi, zza> implements zzkm {
            private zza() {
                super(zzi.zzg);
            }

            public final zza zza(zzj zzj) {
                if (this.zzb) {
                    zzb();
                    this.zzb = false;
                }
                ((zzi) this.zza).zza((zzi) zzj);
                return this;
            }

            public final zza zza(zzf.zzb zzb) {
                if (this.zzb) {
                    zzb();
                    this.zzb = false;
                }
                ((zzi) this.zza).zza((zzi) ((zzf) ((zzjb) zzb.zzf())));
                return this;
            }

            public final zza zza(Iterable<? extends zzf> iterable) {
                if (this.zzb) {
                    zzb();
                    this.zzb = false;
                }
                ((zzi) this.zza).zza((zzi) iterable);
                return this;
            }

            /* synthetic */ zza(zzfk zzfk) {
                this();
            }
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final void zza(zzj zzj) {
            zzj.getClass();
            this.zzd = zzj;
            this.zzc |= 1;
        }

        private final void zzc() {
            zzjl<zzf> zzjl = this.zzf;
            if (!zzjl.zza()) {
                this.zzf = zzjb.zza(zzjl);
            }
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final void zza(zzf zzf2) {
            zzf2.getClass();
            zzc();
            this.zzf.add(zzf2);
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final void zza(Iterable<? extends zzf> iterable) {
            zzc();
            zzhf.zza(iterable, this.zzf);
        }

        public static zza zza() {
            return (zza) zzg.zzj();
        }

        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.vision.zzkx<com.google.android.gms.internal.vision.zzfi$zzi>, com.google.android.gms.internal.vision.zzjb$zza] */
        /* access modifiers changed from: protected */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.vision.zzjb
        public final Object zza(int i, Object obj, Object obj2) {
            zzkx<zzi> zzkx;
            switch (zzfk.zza[i - 1]) {
                case 1:
                    return new zzi();
                case 2:
                    return new zza(null);
                case 3:
                    return zza(zzg, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0001\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003\u001b", new Object[]{"zzc", "zzd", "zze", "zzf", zzf.class});
                case 4:
                    return zzg;
                case 5:
                    zzkx<zzi> zzkx2 = zzh;
                    zzkx<zzi> zzkx3 = zzkx2;
                    if (zzkx2 == null) {
                        synchronized (zzi.class) {
                            zzkx<zzi> zzkx4 = zzh;
                            zzkx = zzkx4;
                            if (zzkx4 == null) {
                                ?? zza2 = new zzjb.zza(zzg);
                                zzh = zza2;
                                zzkx = zza2;
                            }
                        }
                        zzkx3 = zzkx;
                    }
                    return zzkx3;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            zzi zzi = new zzi();
            zzg = zzi;
            zzjb.zza(zzi.class, zzi);
        }
    }

    /* compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
    public static final class zzj extends zzjb<zzj, zzb> implements zzkm {
        private static final zzj zzi;
        private static volatile zzkx<zzj> zzj;
        private int zzc;
        private int zzd;
        private long zze;
        private long zzf;
        private long zzg;
        private long zzh;

        /* compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
        public enum zza implements zzje {
            FORMAT_UNKNOWN(0),
            FORMAT_LUMINANCE(1),
            FORMAT_RGB8(2),
            FORMAT_MONOCHROME(3);
            
            private static final zzjh<zza> zze = new zzfx();
            private final int zzf;

            @Override // com.google.android.gms.internal.vision.zzje
            public final int zza() {
                return this.zzf;
            }

            public static zza zza(int i) {
                if (i == 0) {
                    return FORMAT_UNKNOWN;
                }
                if (i == 1) {
                    return FORMAT_LUMINANCE;
                }
                if (i == 2) {
                    return FORMAT_RGB8;
                }
                if (i != 3) {
                    return null;
                }
                return FORMAT_MONOCHROME;
            }

            public static zzjg zzb() {
                return zzfw.zza;
            }

            public final String toString() {
                return "<" + getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzf + " name=" + name() + Typography.greater;
            }

            private zza(int i) {
                this.zzf = i;
            }
        }

        private zzj() {
        }

        /* compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
        public static final class zzb extends zzjb.zzb<zzj, zzb> implements zzkm {
            private zzb() {
                super(zzj.zzi);
            }

            public final zzb zza(long j) {
                if (this.zzb) {
                    zzb();
                    this.zzb = false;
                }
                ((zzj) this.zza).zza((zzj) j);
                return this;
            }

            public final zzb zzb(long j) {
                if (this.zzb) {
                    zzb();
                    this.zzb = false;
                }
                ((zzj) this.zza).zzb((zzj) j);
                return this;
            }

            public final zzb zzc(long j) {
                if (this.zzb) {
                    zzb();
                    this.zzb = false;
                }
                ((zzj) this.zza).zzc(j);
                return this;
            }

            public final zzb zzd(long j) {
                if (this.zzb) {
                    zzb();
                    this.zzb = false;
                }
                ((zzj) this.zza).zzd(j);
                return this;
            }

            /* synthetic */ zzb(zzfk zzfk) {
                this();
            }
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final void zza(long j) {
            this.zzc |= 2;
            this.zze = j;
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final void zzb(long j) {
            this.zzc |= 4;
            this.zzf = j;
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final void zzc(long j) {
            this.zzc |= 8;
            this.zzg = j;
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final void zzd(long j) {
            this.zzc |= 16;
            this.zzh = j;
        }

        public static zzb zza() {
            return (zzb) zzi.zzj();
        }

        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.vision.zzjb$zza, com.google.android.gms.internal.vision.zzkx<com.google.android.gms.internal.vision.zzfi$zzj>] */
        /* access modifiers changed from: protected */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.vision.zzjb
        public final Object zza(int i, Object obj, Object obj2) {
            zzkx<zzj> zzkx;
            switch (zzfk.zza[i - 1]) {
                case 1:
                    return new zzj();
                case 2:
                    return new zzb(null);
                case 3:
                    return zza(zzi, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဂ\u0001\u0003ဂ\u0002\u0004ဂ\u0004\u0005ဂ\u0003", new Object[]{"zzc", "zzd", zza.zzb(), "zze", "zzf", "zzh", "zzg"});
                case 4:
                    return zzi;
                case 5:
                    zzkx<zzj> zzkx2 = zzj;
                    zzkx<zzj> zzkx3 = zzkx2;
                    if (zzkx2 == null) {
                        synchronized (zzj.class) {
                            zzkx<zzj> zzkx4 = zzj;
                            zzkx = zzkx4;
                            if (zzkx4 == null) {
                                ?? zza2 = new zzjb.zza(zzi);
                                zzj = zza2;
                                zzkx = zza2;
                            }
                        }
                        zzkx3 = zzkx;
                    }
                    return zzkx3;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            zzj zzj2 = new zzj();
            zzi = zzj2;
            zzjb.zza(zzj.class, zzj2);
        }
    }

    /* compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
    public static final class zzk extends zzjb<zzk, zza> implements zzkm {
        private static final zzk zzj;
        private static volatile zzkx<zzk> zzk;
        private int zzc;
        private String zzd = "";
        private long zze;
        private zza zzf;
        private String zzg = "";
        private zzg zzh;
        private zzb zzi;

        private zzk() {
        }

        /* compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
        public static final class zza extends zzjb.zzb<zzk, zza> implements zzkm {
            private zza() {
                super(zzk.zzj);
            }

            public final zza zza(String str) {
                if (this.zzb) {
                    zzb();
                    this.zzb = false;
                }
                ((zzk) this.zza).zza((zzk) str);
                return this;
            }

            public final zza zza(long j) {
                if (this.zzb) {
                    zzb();
                    this.zzb = false;
                }
                ((zzk) this.zza).zza((zzk) j);
                return this;
            }

            public final zza zza(zza zza) {
                if (this.zzb) {
                    zzb();
                    this.zzb = false;
                }
                ((zzk) this.zza).zza((zzk) zza);
                return this;
            }

            public final zza zzb(String str) {
                if (this.zzb) {
                    zzb();
                    this.zzb = false;
                }
                ((zzk) this.zza).zzb((zzk) str);
                return this;
            }

            public final zza zza(zzg.zza zza) {
                if (this.zzb) {
                    zzb();
                    this.zzb = false;
                }
                ((zzk) this.zza).zza((zzk) ((zzg) ((zzjb) zza.zzf())));
                return this;
            }

            /* synthetic */ zza(zzfk zzfk) {
                this();
            }
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final void zza(String str) {
            str.getClass();
            this.zzc |= 1;
            this.zzd = str;
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final void zza(long j) {
            this.zzc |= 2;
            this.zze = j;
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final void zza(zza zza2) {
            zza2.getClass();
            this.zzf = zza2;
            this.zzc |= 4;
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final void zzb(String str) {
            str.getClass();
            this.zzc |= 8;
            this.zzg = str;
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final void zza(zzg zzg2) {
            zzg2.getClass();
            this.zzh = zzg2;
            this.zzc |= 16;
        }

        public static zza zza() {
            return (zza) zzj.zzj();
        }

        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.vision.zzkx<com.google.android.gms.internal.vision.zzfi$zzk>, com.google.android.gms.internal.vision.zzjb$zza] */
        /* access modifiers changed from: protected */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.vision.zzjb
        public final Object zza(int i, Object obj, Object obj2) {
            zzkx<zzk> zzkx;
            switch (zzfk.zza[i - 1]) {
                case 1:
                    return new zzk();
                case 2:
                    return new zza(null);
                case 3:
                    return zza(zzj, "\u0001\u0006\u0000\u0001\u0001\u0011\u0006\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဂ\u0001\u0003ဉ\u0002\u0006ဈ\u0003\u0010ဉ\u0004\u0011ဉ\u0005", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg", "zzh", "zzi"});
                case 4:
                    return zzj;
                case 5:
                    zzkx<zzk> zzkx2 = zzk;
                    zzkx<zzk> zzkx3 = zzkx2;
                    if (zzkx2 == null) {
                        synchronized (zzk.class) {
                            zzkx<zzk> zzkx4 = zzk;
                            zzkx = zzkx4;
                            if (zzkx4 == null) {
                                ?? zza2 = new zzjb.zza(zzj);
                                zzk = zza2;
                                zzkx = zza2;
                            }
                        }
                        zzkx3 = zzkx;
                    }
                    return zzkx3;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            zzk zzk2 = new zzk();
            zzj = zzk2;
            zzjb.zza(zzk.class, zzk2);
        }
    }

    /* compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
    public static final class zzm extends zzjb<zzm, zza> implements zzkm {
        private static final zzm zzf;
        private static volatile zzkx<zzm> zzg;
        private int zzc;
        private int zzd;
        private int zze;

        private zzm() {
        }

        /* compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
        public static final class zza extends zzjb.zzb<zzm, zza> implements zzkm {
            private zza() {
                super(zzm.zzf);
            }

            public final zza zza(int i) {
                if (this.zzb) {
                    zzb();
                    this.zzb = false;
                }
                ((zzm) this.zza).zza((zzm) i);
                return this;
            }

            public final zza zzb(int i) {
                if (this.zzb) {
                    zzb();
                    this.zzb = false;
                }
                ((zzm) this.zza).zzc(i);
                return this;
            }

            /* synthetic */ zza(zzfk zzfk) {
                this();
            }
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final void zza(int i) {
            this.zzc |= 1;
            this.zzd = i;
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final void zzc(int i) {
            this.zzc |= 2;
            this.zze = i;
        }

        public static zza zza() {
            return (zza) zzf.zzj();
        }

        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.vision.zzjb$zza, com.google.android.gms.internal.vision.zzkx<com.google.android.gms.internal.vision.zzfi$zzm>] */
        /* access modifiers changed from: protected */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.vision.zzjb
        public final Object zza(int i, Object obj, Object obj2) {
            zzkx<zzm> zzkx;
            switch (zzfk.zza[i - 1]) {
                case 1:
                    return new zzm();
                case 2:
                    return new zza(null);
                case 3:
                    return zza(zzf, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001င\u0000\u0002င\u0001", new Object[]{"zzc", "zzd", "zze"});
                case 4:
                    return zzf;
                case 5:
                    zzkx<zzm> zzkx2 = zzg;
                    zzkx<zzm> zzkx3 = zzkx2;
                    if (zzkx2 == null) {
                        synchronized (zzm.class) {
                            zzkx<zzm> zzkx4 = zzg;
                            zzkx = zzkx4;
                            if (zzkx4 == null) {
                                ?? zza2 = new zzjb.zza(zzf);
                                zzg = zza2;
                                zzkx = zza2;
                            }
                        }
                        zzkx3 = zzkx;
                    }
                    return zzkx3;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            zzm zzm = new zzm();
            zzf = zzm;
            zzjb.zza(zzm.class, zzm);
        }
    }

    /* compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
    public static final class zzn extends zzjb<zzn, zza> implements zzkm {
        private static final zzn zzh;
        private static volatile zzkx<zzn> zzi;
        private int zzc;
        private zzd zzd;
        private int zze;
        private zzh zzf;
        private zzc zzg;

        private zzn() {
        }

        /* compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
        public static final class zza extends zzjb.zzb<zzn, zza> implements zzkm {
            private zza() {
                super(zzn.zzh);
            }

            public final zza zza(zzd zzd) {
                if (this.zzb) {
                    zzb();
                    this.zzb = false;
                }
                ((zzn) this.zza).zza((zzn) zzd);
                return this;
            }

            public final zza zza(zzd.zza zza) {
                if (this.zzb) {
                    zzb();
                    this.zzb = false;
                }
                ((zzn) this.zza).zza((zzn) ((zzd) ((zzjb) zza.zzf())));
                return this;
            }

            public final zza zza(int i) {
                if (this.zzb) {
                    zzb();
                    this.zzb = false;
                }
                ((zzn) this.zza).zza((zzn) i);
                return this;
            }

            public final zza zza(zzh zzh) {
                if (this.zzb) {
                    zzb();
                    this.zzb = false;
                }
                ((zzn) this.zza).zza((zzn) zzh);
                return this;
            }

            /* synthetic */ zza(zzfk zzfk) {
                this();
            }
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final void zza(zzd zzd2) {
            zzd2.getClass();
            this.zzd = zzd2;
            this.zzc |= 1;
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final void zza(int i) {
            this.zzc |= 2;
            this.zze = i;
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final void zza(zzh zzh2) {
            zzh2.getClass();
            this.zzf = zzh2;
            this.zzc |= 4;
        }

        public static zza zza() {
            return (zza) zzh.zzj();
        }

        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.vision.zzjb$zza, com.google.android.gms.internal.vision.zzkx<com.google.android.gms.internal.vision.zzfi$zzn>] */
        /* access modifiers changed from: protected */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.vision.zzjb
        public final Object zza(int i, Object obj, Object obj2) {
            zzkx<zzn> zzkx;
            switch (zzfk.zza[i - 1]) {
                case 1:
                    return new zzn();
                case 2:
                    return new zza(null);
                case 3:
                    return zza(zzh, "\u0001\u0004\u0000\u0001\u0001\u0011\u0004\u0000\u0000\u0000\u0001ဉ\u0000\u0002င\u0001\u0010ဉ\u0002\u0011ဉ\u0003", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg"});
                case 4:
                    return zzh;
                case 5:
                    zzkx<zzn> zzkx2 = zzi;
                    zzkx<zzn> zzkx3 = zzkx2;
                    if (zzkx2 == null) {
                        synchronized (zzn.class) {
                            zzkx<zzn> zzkx4 = zzi;
                            zzkx = zzkx4;
                            if (zzkx4 == null) {
                                ?? zza2 = new zzjb.zza(zzh);
                                zzi = zza2;
                                zzkx = zza2;
                            }
                        }
                        zzkx3 = zzkx;
                    }
                    return zzkx3;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            zzn zzn = new zzn();
            zzh = zzn;
            zzjb.zza(zzn.class, zzn);
        }
    }

    /* compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
    public static final class zzo extends zzjb<zzo, zza> implements zzkm {
        private static final zzo zzi;
        private static volatile zzkx<zzo> zzj;
        private int zzc;
        private zze zzd;
        private zzk zze;
        private zzi zzf;
        private int zzg;
        private boolean zzh;

        private zzo() {
        }

        /* compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
        public static final class zza extends zzjb.zzb<zzo, zza> implements zzkm {
            private zza() {
                super(zzo.zzi);
            }

            public final zza zza(zzk.zza zza) {
                if (this.zzb) {
                    zzb();
                    this.zzb = false;
                }
                ((zzo) this.zza).zza((zzo) ((zzk) ((zzjb) zza.zzf())));
                return this;
            }

            public final zza zza(zzi zzi) {
                if (this.zzb) {
                    zzb();
                    this.zzb = false;
                }
                ((zzo) this.zza).zza((zzo) zzi);
                return this;
            }

            public final zza zza(boolean z) {
                if (this.zzb) {
                    zzb();
                    this.zzb = false;
                }
                ((zzo) this.zza).zza((zzo) true);
                return this;
            }

            /* synthetic */ zza(zzfk zzfk) {
                this();
            }
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final void zza(zzk zzk) {
            zzk.getClass();
            this.zze = zzk;
            this.zzc |= 2;
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final void zza(zzi zzi2) {
            zzi2.getClass();
            this.zzf = zzi2;
            this.zzc |= 4;
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final void zza(boolean z) {
            this.zzc |= 16;
            this.zzh = true;
        }

        public static zza zza() {
            return (zza) zzi.zzj();
        }

        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.vision.zzjb$zza, com.google.android.gms.internal.vision.zzkx<com.google.android.gms.internal.vision.zzfi$zzo>] */
        /* access modifiers changed from: protected */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.vision.zzjb
        public final Object zza(int i, Object obj, Object obj2) {
            zzkx<zzo> zzkx;
            switch (zzfk.zza[i - 1]) {
                case 1:
                    return new zzo();
                case 2:
                    return new zza(null);
                case 3:
                    return zza(zzi, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003ဉ\u0002\u0004င\u0003\u0005ဇ\u0004", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg", "zzh"});
                case 4:
                    return zzi;
                case 5:
                    zzkx<zzo> zzkx2 = zzj;
                    zzkx<zzo> zzkx3 = zzkx2;
                    if (zzkx2 == null) {
                        synchronized (zzo.class) {
                            zzkx<zzo> zzkx4 = zzj;
                            zzkx = zzkx4;
                            if (zzkx4 == null) {
                                ?? zza2 = new zzjb.zza(zzi);
                                zzj = zza2;
                                zzkx = zza2;
                            }
                        }
                        zzkx3 = zzkx;
                    }
                    return zzkx3;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            zzo zzo = new zzo();
            zzi = zzo;
            zzjb.zza(zzo.class, zzo);
        }
    }
}
