package com.google.android.gms.internal.gtm;

import com.google.android.gms.internal.gtm.zzrc;
import com.google.android.gms.internal.gtm.zzrc.zza;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class zzrc<MessageType extends zzrc<MessageType, BuilderType>, BuilderType extends zza<MessageType, BuilderType>> extends zzpl<MessageType, BuilderType> {
    private static Map<Object, zzrc<?, ?>> zzbam = new ConcurrentHashMap();
    protected zzts zzbak = zzts.zzrj();
    private int zzbal = -1;

    public static abstract class zzc<MessageType extends zzc<MessageType, BuilderType>, BuilderType> extends zzrc<MessageType, BuilderType> implements zzsm {
        protected zzqt<Object> zzbaq = zzqt.zzov();
    }

    public static class zzd<ContainingType extends zzsk, Type> extends zzqn<ContainingType, Type> {
    }

    /* JADX INFO: Failed to restore enum class, 'enum' modifier removed */
    public static final class zze {
        public static final int zzbar = 1;
        public static final int zzbas = 2;
        public static final int zzbat = 3;
        public static final int zzbau = 4;
        public static final int zzbav = 5;
        public static final int zzbaw = 6;
        public static final int zzbax = 7;
        private static final /* synthetic */ int[] zzbay = {1, 2, 3, 4, 5, 6, 7};
        public static final int zzbaz = 1;
        public static final int zzbba = 2;
        private static final /* synthetic */ int[] zzbbb = {1, 2};
        public static final int zzbbc = 1;
        public static final int zzbbd = 2;
        private static final /* synthetic */ int[] zzbbe = {1, 2};

        public static int[] zzpn() {
            return (int[]) zzbay.clone();
        }
    }

    /* access modifiers changed from: protected */
    public abstract Object zza(int i, Object obj, Object obj2);

    public static class zzb<T extends zzrc<T, ?>> extends zzpn<T> {
        private final T zzban;

        public zzb(T t) {
            this.zzban = t;
        }

        @Override // com.google.android.gms.internal.gtm.zzsu
        public final /* synthetic */ Object zza(zzqe zzqe, zzqp zzqp) throws zzrk {
            return zzrc.zza(this.zzban, zzqe, zzqp);
        }
    }

    public String toString() {
        return zzsn.zza(this, super.toString());
    }

    public int hashCode() {
        if (this.zzavp != 0) {
            return this.zzavp;
        }
        this.zzavp = zzsw.zzqs().zzaf(this).hashCode(this);
        return this.zzavp;
    }

    public static abstract class zza<MessageType extends zzrc<MessageType, BuilderType>, BuilderType extends zza<MessageType, BuilderType>> extends zzpm<MessageType, BuilderType> {
        private final MessageType zzban;
        private MessageType zzbao;
        private boolean zzbap = false;

        protected zza(MessageType messagetype) {
            this.zzban = messagetype;
            this.zzbao = (MessageType) ((zzrc) messagetype.zza(zze.zzbau, null, null));
        }

        @Override // com.google.android.gms.internal.gtm.zzsm
        public final boolean isInitialized() {
            return zzrc.zza((zzrc) this.zzbao, false);
        }

        /* renamed from: zzpj */
        public MessageType zzpl() {
            if (this.zzbap) {
                return this.zzbao;
            }
            this.zzbao.zzmi();
            this.zzbap = true;
            return this.zzbao;
        }

        /* renamed from: zzpk */
        public final MessageType zzpm() {
            MessageType messagetype = (MessageType) ((zzrc) zzpl());
            if (messagetype.isInitialized()) {
                return messagetype;
            }
            throw new zztq(messagetype);
        }

        public final BuilderType zza(MessageType messagetype) {
            if (this.zzbap) {
                MessageType messagetype2 = (MessageType) ((zzrc) this.zzbao.zza(zze.zzbau, null, null));
                zza(messagetype2, this.zzbao);
                this.zzbao = messagetype2;
                this.zzbap = false;
            }
            zza(this.zzbao, messagetype);
            return this;
        }

        private static void zza(MessageType messagetype, MessageType messagetype2) {
            zzsw.zzqs().zzaf(messagetype).zzd(messagetype, messagetype2);
        }

        @Override // com.google.android.gms.internal.gtm.zzpm
        public final /* synthetic */ zzpm zzmx() {
            return (zza) clone();
        }

        @Override // com.google.android.gms.internal.gtm.zzsm
        public final /* synthetic */ zzsk zzpi() {
            return this.zzban;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v3, resolved type: com.google.android.gms.internal.gtm.zzrc$zza */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.android.gms.internal.gtm.zzpm, java.lang.Object
        public /* synthetic */ Object clone() throws CloneNotSupportedException {
            zza zza = (zza) this.zzban.zza(zze.zzbav, null, null);
            zza.zza((zzrc) zzpl());
            return zza;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!((zzrc) zza(zze.zzbaw, (Object) null, (Object) null)).getClass().isInstance(obj)) {
            return false;
        }
        return zzsw.zzqs().zzaf(this).equals(this, (zzrc) obj);
    }

    /* access modifiers changed from: protected */
    public final void zzmi() {
        zzsw.zzqs().zzaf(this).zzt(this);
    }

    @Override // com.google.android.gms.internal.gtm.zzsm
    public final boolean isInitialized() {
        Boolean bool = Boolean.TRUE;
        return zza((zzrc) this, true);
    }

    public final BuilderType zzpd() {
        BuilderType buildertype = (BuilderType) ((zza) zza(zze.zzbav, (Object) null, (Object) null));
        buildertype.zza(this);
        return buildertype;
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.gtm.zzpl
    public final int zzmw() {
        return this.zzbal;
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.gtm.zzpl
    public final void zzag(int i) {
        this.zzbal = i;
    }

    @Override // com.google.android.gms.internal.gtm.zzsk
    public final void zzb(zzqj zzqj) throws IOException {
        zzsw.zzqs().zzi(getClass()).zza(this, zzql.zza(zzqj));
    }

    @Override // com.google.android.gms.internal.gtm.zzsk
    public final int zzpe() {
        if (this.zzbal == -1) {
            this.zzbal = zzsw.zzqs().zzaf(this).zzad(this);
        }
        return this.zzbal;
    }

    static <T extends zzrc<?, ?>> T zzg(Class<T> cls) {
        zzrc<?, ?> zzrc = zzbam.get(cls);
        if (zzrc == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                zzrc = (T) zzbam.get(cls);
            } catch (ClassNotFoundException e) {
                throw new IllegalStateException("Class initialization cannot fail.", e);
            }
        }
        if (zzrc == null) {
            zzrc = (T) ((zzrc) ((zzrc) zztx.zzk(cls)).zza(zze.zzbaw, (Object) null, (Object) null));
            if (zzrc != null) {
                zzbam.put(cls, zzrc);
            } else {
                throw new IllegalStateException();
            }
        }
        return (T) zzrc;
    }

    protected static <T extends zzrc<?, ?>> void zza(Class<T> cls, T t) {
        zzbam.put(cls, t);
    }

    protected static Object zza(zzsk zzsk, String str, Object[] objArr) {
        return new zzsx(zzsk, str, objArr);
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

    protected static final <T extends zzrc<T, ?>> boolean zza(T t, boolean z) {
        byte byteValue = ((Byte) t.zza(zze.zzbar, null, null)).byteValue();
        if (byteValue == 1) {
            return true;
        }
        if (byteValue == 0) {
            return false;
        }
        boolean zzae = zzsw.zzqs().zzaf(t).zzae(t);
        if (z) {
            t.zza(zze.zzbas, zzae ? t : null, null);
        }
        return zzae;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.google.android.gms.internal.gtm.zzrd, com.google.android.gms.internal.gtm.zzri] */
    /* JADX WARNING: Unknown variable types count: 1 */
    protected static zzri zzpf() {
        return zzrd.zzpo();
    }

    static <T extends zzrc<T, ?>> T zza(T t, zzqe zzqe, zzqp zzqp) throws zzrk {
        T t2 = (T) ((zzrc) t.zza(zze.zzbau, null, null));
        try {
            zzsw.zzqs().zzaf(t2).zza(t2, zzqh.zza(zzqe), zzqp);
            t2.zzmi();
            return t2;
        } catch (IOException e) {
            if (e.getCause() instanceof zzrk) {
                throw ((zzrk) e.getCause());
            }
            throw new zzrk(e.getMessage()).zzg(t2);
        } catch (RuntimeException e2) {
            if (e2.getCause() instanceof zzrk) {
                throw ((zzrk) e2.getCause());
            }
            throw e2;
        }
    }

    @Override // com.google.android.gms.internal.gtm.zzsk
    public final /* synthetic */ zzsl zzpg() {
        zza zza2 = (zza) zza(zze.zzbav, (Object) null, (Object) null);
        zza2.zza((zzrc) this);
        return zza2;
    }

    @Override // com.google.android.gms.internal.gtm.zzsk
    public final /* synthetic */ zzsl zzph() {
        return (zza) zza(zze.zzbav, (Object) null, (Object) null);
    }

    @Override // com.google.android.gms.internal.gtm.zzsm
    public final /* synthetic */ zzsk zzpi() {
        return (zzrc) zza(zze.zzbaw, (Object) null, (Object) null);
    }
}
