package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.zzjb;
import com.google.android.gms.internal.vision.zzjb.zzb;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
public abstract class zzjb<MessageType extends zzjb<MessageType, BuilderType>, BuilderType extends zzb<MessageType, BuilderType>> extends zzhf<MessageType, BuilderType> {
    private static Map<Object, zzjb<?, ?>> zzd = new ConcurrentHashMap();
    protected zzlx zzb = zzlx.zza();
    private int zzc = -1;

    /* compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
    protected static class zza<T extends zzjb<T, ?>> extends zzhg<T> {
        private final T zza;

        public zza(T t) {
            this.zza = t;
        }
    }

    /* JADX INFO: Failed to restore enum class, 'enum' modifier removed */
    /* compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
    public static final class zzg {
        public static final int zza = 1;
        public static final int zzb = 2;
        public static final int zzc = 3;
        public static final int zzd = 4;
        public static final int zze = 5;
        public static final int zzf = 6;
        public static final int zzg = 7;
        private static final /* synthetic */ int[] zzh = {1, 2, 3, 4, 5, 6, 7};

        public static int[] zza() {
            return (int[]) zzh.clone();
        }
    }

    /* access modifiers changed from: protected */
    public abstract Object zza(int i, Object obj, Object obj2);

    /* compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
    public static abstract class zzc<MessageType extends zzc<MessageType, BuilderType>, BuilderType extends zzd<MessageType, BuilderType>> extends zzjb<MessageType, BuilderType> implements zzkm {
        protected zziu<zzf> zzc = zziu.zza();

        /* access modifiers changed from: package-private */
        public final zziu<zzf> zza() {
            if (this.zzc.zzc()) {
                this.zzc = (zziu) this.zzc.clone();
            }
            return this.zzc;
        }

        public final <Type> Type zzb(zzim<MessageType, Type> zzim) {
            zze zzb = zzjb.zzb(zzim);
            if (zzb.zza == ((zzjb) zzr())) {
                Type<Object> type = (Type) this.zzc.zza(zzb.zzd);
                if (type == null) {
                    return zzb.zzb;
                }
                if (!zzb.zzd.zzd) {
                    return (Type) zzb.zza(type);
                }
                if (zzb.zzd.zzc.zza() != zzmo.ENUM) {
                    return type;
                }
                Type type2 = (Type) new ArrayList();
                for (Object obj : type) {
                    type2.add(zzb.zza(obj));
                }
                return type2;
            }
            throw new IllegalArgumentException("This extension is for a different message type.  Please make sure that you are not suppressing any generics type warnings.");
        }
    }

    /* compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
    public static abstract class zzd<MessageType extends zzc<MessageType, BuilderType>, BuilderType extends zzd<MessageType, BuilderType>> extends zzb<MessageType, BuilderType> implements zzkm {
        protected zzd(MessageType messagetype) {
            super(messagetype);
        }

        /* access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.vision.zzjb.zzb
        public void zzb() {
            super.zzb();
            ((zzc) this.zza).zzc = (zziu) ((zzc) this.zza).zzc.clone();
        }

        @Override // com.google.android.gms.internal.vision.zzjb.zzb
        public /* synthetic */ zzjb zzc() {
            return (zzc) zze();
        }

        @Override // com.google.android.gms.internal.vision.zzjb.zzb, com.google.android.gms.internal.vision.zzkn
        public /* synthetic */ zzkk zze() {
            if (this.zzb) {
                return (zzc) this.zza;
            }
            ((zzc) this.zza).zzc.zzb();
            return (zzc) super.zze();
        }
    }

    public String toString() {
        return zzkp.zza(this, super.toString());
    }

    public int hashCode() {
        if (this.zza != 0) {
            return this.zza;
        }
        this.zza = zzky.zza().zza(this).zza(this);
        return this.zza;
    }

    /* compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
    public static abstract class zzb<MessageType extends zzjb<MessageType, BuilderType>, BuilderType extends zzb<MessageType, BuilderType>> extends zzhe<MessageType, BuilderType> {
        protected MessageType zza;
        protected boolean zzb = false;
        private final MessageType zzc;

        protected zzb(MessageType messagetype) {
            this.zzc = messagetype;
            this.zza = (MessageType) ((zzjb) messagetype.zza(zzg.zzd, null, null));
        }

        /* access modifiers changed from: protected */
        public void zzb() {
            MessageType messagetype = (MessageType) ((zzjb) this.zza.zza(zzg.zzd, null, null));
            zza(messagetype, this.zza);
            this.zza = messagetype;
        }

        @Override // com.google.android.gms.internal.vision.zzkm
        public final boolean zzk() {
            return zzjb.zza((zzjb) this.zza, false);
        }

        /* renamed from: zzc */
        public MessageType zze() {
            if (this.zzb) {
                return this.zza;
            }
            MessageType messagetype = this.zza;
            zzky.zza().zza(messagetype).zzc(messagetype);
            this.zzb = true;
            return this.zza;
        }

        /* renamed from: zzd */
        public final MessageType zzf() {
            MessageType messagetype = (MessageType) ((zzjb) zze());
            if (messagetype.zzk()) {
                return messagetype;
            }
            throw new zzlv(messagetype);
        }

        public final BuilderType zza(MessageType messagetype) {
            if (this.zzb) {
                zzb();
                this.zzb = false;
            }
            zza(this.zza, messagetype);
            return this;
        }

        private static void zza(MessageType messagetype, MessageType messagetype2) {
            zzky.zza().zza(messagetype).zzb(messagetype, messagetype2);
        }

        private final BuilderType zzb(byte[] bArr, int i, int i2, zzio zzio) throws zzjk {
            if (this.zzb) {
                zzb();
                this.zzb = false;
            }
            try {
                zzky.zza().zza(this.zza).zza(this.zza, bArr, 0, i2, new zzhn(zzio));
                return this;
            } catch (zzjk e) {
                throw e;
            } catch (IndexOutOfBoundsException unused) {
                throw zzjk.zza();
            } catch (IOException e2) {
                throw new RuntimeException("Reading from byte array should not throw IOException.", e2);
            }
        }

        /* access modifiers changed from: private */
        /* renamed from: zzb */
        public final BuilderType zza(zzif zzif, zzio zzio) throws IOException {
            if (this.zzb) {
                zzb();
                this.zzb = false;
            }
            try {
                zzky.zza().zza(this.zza).zza(this.zza, zzig.zza(zzif), zzio);
                return this;
            } catch (RuntimeException e) {
                if (e.getCause() instanceof IOException) {
                    throw ((IOException) e.getCause());
                }
                throw e;
            }
        }

        @Override // com.google.android.gms.internal.vision.zzhe
        public final /* synthetic */ zzhe zza(byte[] bArr, int i, int i2, zzio zzio) throws zzjk {
            return zzb(bArr, 0, i2, zzio);
        }

        @Override // com.google.android.gms.internal.vision.zzhe
        public final /* synthetic */ zzhe zza() {
            return (zzb) clone();
        }

        @Override // com.google.android.gms.internal.vision.zzkm
        public final /* synthetic */ zzkk zzr() {
            return this.zzc;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v3, resolved type: com.google.android.gms.internal.vision.zzjb$zzb */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.android.gms.internal.vision.zzhe, java.lang.Object
        public /* synthetic */ Object clone() throws CloneNotSupportedException {
            zzb zzb2 = (zzb) this.zzc.zza(zzg.zze, null, null);
            zzb2.zza((zzjb) zze());
            return zzb2;
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
    public static final class zzf implements zziw<zzf> {
        final zzjh<?> zza = null;
        final int zzb = 202056002;
        final zzml zzc;
        final boolean zzd;
        final boolean zze;

        zzf(zzjh<?> zzjh, int i, zzml zzml, boolean z, boolean z2) {
            this.zzc = zzml;
            this.zzd = true;
            this.zze = false;
        }

        @Override // com.google.android.gms.internal.vision.zziw
        public final boolean zze() {
            return false;
        }

        @Override // com.google.android.gms.internal.vision.zziw
        public final int zza() {
            return this.zzb;
        }

        @Override // com.google.android.gms.internal.vision.zziw
        public final zzml zzb() {
            return this.zzc;
        }

        @Override // com.google.android.gms.internal.vision.zziw
        public final zzmo zzc() {
            return this.zzc.zza();
        }

        @Override // com.google.android.gms.internal.vision.zziw
        public final boolean zzd() {
            return this.zzd;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.google.android.gms.internal.vision.zzjb$zzb */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.android.gms.internal.vision.zziw
        public final zzkn zza(zzkn zzkn, zzkk zzkk) {
            return ((zzb) zzkn).zza((zzjb) zzkk);
        }

        @Override // com.google.android.gms.internal.vision.zziw
        public final zzkt zza(zzkt zzkt, zzkt zzkt2) {
            throw new UnsupportedOperationException();
        }

        @Override // java.lang.Comparable
        public final /* synthetic */ int compareTo(Object obj) {
            return this.zzb - ((zzf) obj).zzb;
        }
    }

    /* compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
    public static class zze<ContainingType extends zzkk, Type> extends zzim<ContainingType, Type> {
        final ContainingType zza;
        final Type zzb;
        final zzkk zzc;
        final zzf zzd;

        zze(ContainingType containingtype, Type type, zzkk zzkk, zzf zzf, Class cls) {
            if (containingtype == null) {
                throw new IllegalArgumentException("Null containingTypeDefaultInstance");
            } else if (zzf.zzc == zzml.MESSAGE && zzkk == null) {
                throw new IllegalArgumentException("Null messageDefaultInstance");
            } else {
                this.zza = containingtype;
                this.zzb = type;
                this.zzc = zzkk;
                this.zzd = zzf;
            }
        }

        /* access modifiers changed from: package-private */
        public final Object zza(Object obj) {
            if (this.zzd.zzc.zza() != zzmo.ENUM) {
                return obj;
            }
            zzjh zzjh = null;
            return zzjh.zza(((Integer) obj).intValue());
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            return zzky.zza().zza(this).zza(this, (zzjb) obj);
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public final <MessageType extends zzjb<MessageType, BuilderType>, BuilderType extends zzb<MessageType, BuilderType>> BuilderType zzj() {
        return (BuilderType) ((zzb) zza(zzg.zze, (Object) null, (Object) null));
    }

    @Override // com.google.android.gms.internal.vision.zzkm
    public final boolean zzk() {
        Boolean bool = Boolean.TRUE;
        return zza((zzjb) this, true);
    }

    public final BuilderType zzl() {
        BuilderType buildertype = (BuilderType) ((zzb) zza(zzg.zze, (Object) null, (Object) null));
        buildertype.zza(this);
        return buildertype;
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.vision.zzhf
    public final int zzi() {
        return this.zzc;
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.vision.zzhf
    public final void zzb(int i) {
        this.zzc = i;
    }

    @Override // com.google.android.gms.internal.vision.zzkk
    public final void zza(zzii zzii) throws IOException {
        zzky.zza().zza(this).zza((Object) this, (zzmr) zzil.zza(zzii));
    }

    @Override // com.google.android.gms.internal.vision.zzkk
    public final int zzm() {
        if (this.zzc == -1) {
            this.zzc = zzky.zza().zza(this).zzb(this);
        }
        return this.zzc;
    }

    static <T extends zzjb<?, ?>> T zza(Class<T> cls) {
        zzjb<?, ?> zzjb = zzd.get(cls);
        if (zzjb == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                zzjb = (T) zzd.get(cls);
            } catch (ClassNotFoundException e) {
                throw new IllegalStateException("Class initialization cannot fail.", e);
            }
        }
        if (zzjb == null) {
            zzjb = (T) ((zzjb) ((zzjb) zzma.zza(cls)).zza(zzg.zzf, (Object) null, (Object) null));
            if (zzjb != null) {
                zzd.put(cls, zzjb);
            } else {
                throw new IllegalStateException();
            }
        }
        return (T) zzjb;
    }

    protected static <T extends zzjb<?, ?>> void zza(Class<T> cls, T t) {
        zzd.put(cls, t);
    }

    protected static Object zza(zzkk zzkk, String str, Object[] objArr) {
        return new zzla(zzkk, str, objArr);
    }

    public static <ContainingType extends zzkk, Type> zze<ContainingType, Type> zza(ContainingType containingtype, zzkk zzkk, zzjh<?> zzjh, int i, zzml zzml, boolean z, Class cls) {
        return new zze<>(containingtype, Collections.emptyList(), zzkk, new zzf(null, 202056002, zzml, true, false), cls);
    }

    static Object zza(Method method, Object obj, Object... objArr) {
        try {
            return method.invoke(obj, objArr);
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", e);
        } catch (InvocationTargetException e2) {
            Throwable cause = e2.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            } else if (cause instanceof Error) {
                throw ((Error) cause);
            } else {
                throw new RuntimeException("Unexpected exception thrown by generated accessor method.", cause);
            }
        }
    }

    /* access modifiers changed from: private */
    public static <MessageType extends zzc<MessageType, BuilderType>, BuilderType extends zzd<MessageType, BuilderType>, T> zze<MessageType, T> zzb(zzim<MessageType, T> zzim) {
        return (zze) zzim;
    }

    protected static final <T extends zzjb<T, ?>> boolean zza(T t, boolean z) {
        byte byteValue = ((Byte) t.zza(zzg.zza, null, null)).byteValue();
        if (byteValue == 1) {
            return true;
        }
        if (byteValue == 0) {
            return false;
        }
        boolean zzd2 = zzky.zza().zza(t).zzd(t);
        if (z) {
            t.zza(zzg.zzb, zzd2 ? t : null, null);
        }
        return zzd2;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.google.android.gms.internal.vision.zzjj, com.google.android.gms.internal.vision.zzjd] */
    /* JADX WARNING: Unknown variable types count: 1 */
    protected static zzjj zzn() {
        return zzjd.zzd();
    }

    protected static <E> zzjl<E> zzo() {
        return zzlb.zzd();
    }

    protected static <E> zzjl<E> zza(zzjl<E> zzjl) {
        int size = zzjl.size();
        return zzjl.zza(size == 0 ? 10 : size << 1);
    }

    private static <T extends zzjb<T, ?>> T zza(T t, byte[] bArr, int i, int i2, zzio zzio) throws zzjk {
        T t2 = (T) ((zzjb) t.zza(zzg.zzd, null, null));
        try {
            zzlc zza2 = zzky.zza().zza(t2);
            zza2.zza(t2, bArr, 0, i2, new zzhn(zzio));
            zza2.zzc(t2);
            if (((zzjb) t2).zza == 0) {
                return t2;
            }
            throw new RuntimeException();
        } catch (IOException e) {
            if (e.getCause() instanceof zzjk) {
                throw ((zzjk) e.getCause());
            }
            throw new zzjk(e.getMessage()).zza(t2);
        } catch (IndexOutOfBoundsException unused) {
            throw zzjk.zza().zza(t2);
        }
    }

    private static <T extends zzjb<T, ?>> T zza(T t) throws zzjk {
        if (t == null || t.zzk()) {
            return t;
        }
        throw new zzjk(new zzlv(t).getMessage()).zza(t);
    }

    protected static <T extends zzjb<T, ?>> T zza(T t, byte[] bArr) throws zzjk {
        return (T) zza(zza(t, bArr, 0, bArr.length, zzio.zzb()));
    }

    protected static <T extends zzjb<T, ?>> T zza(T t, byte[] bArr, zzio zzio) throws zzjk {
        return (T) zza(zza(t, bArr, 0, bArr.length, zzio));
    }

    @Override // com.google.android.gms.internal.vision.zzkk
    public final /* synthetic */ zzkn zzp() {
        zzb zzb2 = (zzb) zza(zzg.zze, (Object) null, (Object) null);
        zzb2.zza((zzjb) this);
        return zzb2;
    }

    @Override // com.google.android.gms.internal.vision.zzkk
    public final /* synthetic */ zzkn zzq() {
        return (zzb) zza(zzg.zze, (Object) null, (Object) null);
    }

    @Override // com.google.android.gms.internal.vision.zzkm
    public final /* synthetic */ zzkk zzr() {
        return (zzjb) zza(zzg.zzf, (Object) null, (Object) null);
    }
}
