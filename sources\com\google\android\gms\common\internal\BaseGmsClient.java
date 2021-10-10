package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.api.CommonStatusCodes;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.GmsClientSupervisor;
import com.google.android.gms.common.internal.IGmsCallbacks;
import com.google.android.gms.common.internal.IGmsServiceBroker;
import com.google.android.gms.internal.common.zzi;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: com.google.android.gms:play-services-basement@@17.4.0 */
public abstract class BaseGmsClient<T extends IInterface> {
    public static final int CONNECT_STATE_CONNECTED = 4;
    public static final int CONNECT_STATE_DISCONNECTED = 1;
    public static final int CONNECT_STATE_DISCONNECTING = 5;
    public static final String DEFAULT_ACCOUNT = "<<default account>>";
    public static final String[] GOOGLE_PLUS_REQUIRED_FEATURES = {"service_esmobile", "service_googleme"};
    public static final String KEY_PENDING_INTENT = "pendingIntent";
    private static final Feature[] zzd = new Feature[0];
    final Handler zza;
    private ConnectionResult zzaa;
    private boolean zzab;
    private volatile zzc zzac;
    protected ConnectionProgressReportCallbacks zzb;
    protected AtomicInteger zzc;
    private int zze;
    private long zzf;
    private long zzg;
    private int zzh;
    private long zzi;
    private volatile String zzj;
    private zzl zzk;
    private final Context zzl;
    private final Looper zzm;
    private final GmsClientSupervisor zzn;
    private final GoogleApiAvailabilityLight zzo;
    private final Object zzp;
    private final Object zzq;
    private IGmsServiceBroker zzr;
    private T zzs;
    private final ArrayList<zzc<?>> zzt;
    private zzd zzu;
    private int zzv;
    private final BaseConnectionCallbacks zzw;
    private final BaseOnConnectionFailedListener zzx;
    private final int zzy;
    private final String zzz;

    /* compiled from: com.google.android.gms:play-services-basement@@17.4.0 */
    public interface BaseConnectionCallbacks {
        public static final int CAUSE_DEAD_OBJECT_EXCEPTION = 3;
        public static final int CAUSE_SERVICE_DISCONNECTED = 1;

        void onConnected(Bundle bundle);

        void onConnectionSuspended(int i);
    }

    /* compiled from: com.google.android.gms:play-services-basement@@17.4.0 */
    public interface BaseOnConnectionFailedListener {
        void onConnectionFailed(ConnectionResult connectionResult);
    }

    /* compiled from: com.google.android.gms:play-services-basement@@17.4.0 */
    public interface ConnectionProgressReportCallbacks {
        void onReportServiceBinding(ConnectionResult connectionResult);
    }

    /* compiled from: com.google.android.gms:play-services-basement@@17.4.0 */
    protected class LegacyClientCallbackAdapter implements ConnectionProgressReportCallbacks {
        public LegacyClientCallbackAdapter() {
        }

        @Override // com.google.android.gms.common.internal.BaseGmsClient.ConnectionProgressReportCallbacks
        public void onReportServiceBinding(ConnectionResult connectionResult) {
            if (connectionResult.isSuccess()) {
                BaseGmsClient baseGmsClient = BaseGmsClient.this;
                baseGmsClient.getRemoteService(null, baseGmsClient.getScopes());
            } else if (BaseGmsClient.this.zzx != null) {
                BaseGmsClient.this.zzx.onConnectionFailed(connectionResult);
            }
        }
    }

    /* compiled from: com.google.android.gms:play-services-basement@@17.4.0 */
    public interface SignOutCallbacks {
        void onSignOutComplete();
    }

    /* access modifiers changed from: protected */
    public abstract T createServiceInterface(IBinder iBinder);

    /* access modifiers changed from: protected */
    public boolean enableLocalFallback() {
        return false;
    }

    public Account getAccount() {
        return null;
    }

    public Bundle getConnectionHint() {
        return null;
    }

    /* access modifiers changed from: protected */
    public String getLocalStartServiceAction() {
        return null;
    }

    /* access modifiers changed from: protected */
    public abstract String getServiceDescriptor();

    /* access modifiers changed from: protected */
    public abstract String getStartServiceAction();

    /* access modifiers changed from: protected */
    public String getStartServicePackage() {
        return "com.google.android.gms";
    }

    /* access modifiers changed from: protected */
    public boolean getUseDynamicLookup() {
        return false;
    }

    public boolean providesSignIn() {
        return false;
    }

    public boolean requiresAccount() {
        return false;
    }

    public boolean requiresGooglePlayServices() {
        return true;
    }

    public boolean requiresSignIn() {
        return false;
    }

    public boolean usesClientTelemetry() {
        return false;
    }

    protected BaseGmsClient(Context context, Looper looper, int i, BaseConnectionCallbacks baseConnectionCallbacks, BaseOnConnectionFailedListener baseOnConnectionFailedListener, String str) {
        this(context, looper, GmsClientSupervisor.getInstance(context), GoogleApiAvailabilityLight.getInstance(), i, (BaseConnectionCallbacks) Preconditions.checkNotNull(baseConnectionCallbacks), (BaseOnConnectionFailedListener) Preconditions.checkNotNull(baseOnConnectionFailedListener), str);
    }

    /* compiled from: com.google.android.gms:play-services-basement@@17.4.0 */
    final class zzb extends zzi {
        public zzb(Looper looper) {
            super(looper);
        }

        public final void handleMessage(Message message) {
            ConnectionResult connectionResult;
            ConnectionResult connectionResult2;
            if (BaseGmsClient.this.zzc.get() != message.arg1) {
                if (zzb(message)) {
                    zza(message);
                }
            } else if ((message.what == 1 || message.what == 7 || ((message.what == 4 && !BaseGmsClient.this.enableLocalFallback()) || message.what == 5)) && !BaseGmsClient.this.isConnecting()) {
                zza(message);
            } else {
                PendingIntent pendingIntent = null;
                if (message.what == 4) {
                    BaseGmsClient.this.zzaa = new ConnectionResult(message.arg2);
                    if (!BaseGmsClient.this.zzc() || BaseGmsClient.this.zzab) {
                        if (BaseGmsClient.this.zzaa != null) {
                            connectionResult2 = BaseGmsClient.this.zzaa;
                        } else {
                            connectionResult2 = new ConnectionResult(8);
                        }
                        BaseGmsClient.this.zzb.onReportServiceBinding(connectionResult2);
                        BaseGmsClient.this.onConnectionFailed(connectionResult2);
                        return;
                    }
                    BaseGmsClient.this.zza((BaseGmsClient) 3, (int) null);
                } else if (message.what == 5) {
                    if (BaseGmsClient.this.zzaa != null) {
                        connectionResult = BaseGmsClient.this.zzaa;
                    } else {
                        connectionResult = new ConnectionResult(8);
                    }
                    BaseGmsClient.this.zzb.onReportServiceBinding(connectionResult);
                    BaseGmsClient.this.onConnectionFailed(connectionResult);
                } else if (message.what == 3) {
                    if (message.obj instanceof PendingIntent) {
                        pendingIntent = (PendingIntent) message.obj;
                    }
                    ConnectionResult connectionResult3 = new ConnectionResult(message.arg2, pendingIntent);
                    BaseGmsClient.this.zzb.onReportServiceBinding(connectionResult3);
                    BaseGmsClient.this.onConnectionFailed(connectionResult3);
                } else if (message.what == 6) {
                    BaseGmsClient.this.zza((BaseGmsClient) 5, (int) null);
                    if (BaseGmsClient.this.zzw != null) {
                        BaseGmsClient.this.zzw.onConnectionSuspended(message.arg2);
                    }
                    BaseGmsClient.this.onConnectionSuspended(message.arg2);
                    BaseGmsClient.this.zza((BaseGmsClient) 5, 1, (int) null);
                } else if (message.what == 2 && !BaseGmsClient.this.isConnected()) {
                    zza(message);
                } else if (zzb(message)) {
                    ((zzc) message.obj).zzc();
                } else {
                    int i = message.what;
                    StringBuilder sb = new StringBuilder(45);
                    sb.append("Don't know how to handle message: ");
                    sb.append(i);
                    Log.wtf("GmsClient", sb.toString(), new Exception());
                }
            }
        }

        private static void zza(Message message) {
            zzc zzc = (zzc) message.obj;
            zzc.zzb();
            zzc.zzd();
        }

        private static boolean zzb(Message message) {
            return message.what == 2 || message.what == 1 || message.what == 7;
        }
    }

    /* access modifiers changed from: protected */
    /* compiled from: com.google.android.gms:play-services-basement@@17.4.0 */
    public final class zzg extends zza {
        public zzg(int i, Bundle bundle) {
            super(i, null);
        }

        /* access modifiers changed from: protected */
        @Override // com.google.android.gms.common.internal.BaseGmsClient.zza
        public final void zza(ConnectionResult connectionResult) {
            if (!BaseGmsClient.this.enableLocalFallback() || !BaseGmsClient.this.zzc()) {
                BaseGmsClient.this.zzb.onReportServiceBinding(connectionResult);
                BaseGmsClient.this.onConnectionFailed(connectionResult);
                return;
            }
            BaseGmsClient.this.zza((BaseGmsClient) 16);
        }

        /* access modifiers changed from: protected */
        @Override // com.google.android.gms.common.internal.BaseGmsClient.zza
        public final boolean zza() {
            BaseGmsClient.this.zzb.onReportServiceBinding(ConnectionResult.RESULT_SUCCESS);
            return true;
        }
    }

    /* access modifiers changed from: protected */
    /* compiled from: com.google.android.gms:play-services-basement@@17.4.0 */
    public abstract class zzc<TListener> {
        private TListener zza;
        private boolean zzb = false;

        public zzc(TListener tlistener) {
            this.zza = tlistener;
        }

        /* access modifiers changed from: protected */
        public abstract void zza(TListener tlistener);

        /* access modifiers changed from: protected */
        public abstract void zzb();

        public final void zzc() {
            TListener tlistener;
            synchronized (this) {
                tlistener = this.zza;
                if (this.zzb) {
                    String valueOf = String.valueOf(this);
                    StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 47);
                    sb.append("Callback proxy ");
                    sb.append(valueOf);
                    sb.append(" being reused. This is not safe.");
                    Log.w("GmsClient", sb.toString());
                }
            }
            if (tlistener != null) {
                try {
                    zza(tlistener);
                } catch (RuntimeException e) {
                    zzb();
                    throw e;
                }
            } else {
                zzb();
            }
            synchronized (this) {
                this.zzb = true;
            }
            zzd();
        }

        public final void zzd() {
            zze();
            synchronized (BaseGmsClient.this.zzt) {
                BaseGmsClient.this.zzt.remove(this);
            }
        }

        public final void zze() {
            synchronized (this) {
                this.zza = null;
            }
        }
    }

    /* compiled from: com.google.android.gms:play-services-basement@@17.4.0 */
    public final class zzd implements ServiceConnection {
        private final int zza;

        public zzd(int i) {
            this.zza = i;
        }

        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            IGmsServiceBroker iGmsServiceBroker;
            if (iBinder == null) {
                BaseGmsClient.this.zza((BaseGmsClient) 16);
                return;
            }
            synchronized (BaseGmsClient.this.zzq) {
                BaseGmsClient baseGmsClient = BaseGmsClient.this;
                IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                if (queryLocalInterface == null || !(queryLocalInterface instanceof IGmsServiceBroker)) {
                    iGmsServiceBroker = new IGmsServiceBroker.Stub.zza(iBinder);
                } else {
                    iGmsServiceBroker = (IGmsServiceBroker) queryLocalInterface;
                }
                baseGmsClient.zzr = iGmsServiceBroker;
            }
            BaseGmsClient.this.zza(0, (Bundle) null, this.zza);
        }

        public final void onServiceDisconnected(ComponentName componentName) {
            synchronized (BaseGmsClient.this.zzq) {
                BaseGmsClient.this.zzr = null;
            }
            BaseGmsClient.this.zza.sendMessage(BaseGmsClient.this.zza.obtainMessage(6, this.zza, 1));
        }
    }

    /* compiled from: com.google.android.gms:play-services-basement@@17.4.0 */
    public static final class zze extends IGmsCallbacks.zza {
        private BaseGmsClient zza;
        private final int zzb;

        public zze(BaseGmsClient baseGmsClient, int i) {
            this.zza = baseGmsClient;
            this.zzb = i;
        }

        @Override // com.google.android.gms.common.internal.IGmsCallbacks
        public final void zza(int i, Bundle bundle) {
            Log.wtf("GmsClient", "received deprecated onAccountValidationComplete callback, ignoring", new Exception());
        }

        @Override // com.google.android.gms.common.internal.IGmsCallbacks
        public final void onPostInitComplete(int i, IBinder iBinder, Bundle bundle) {
            Preconditions.checkNotNull(this.zza, "onPostInitComplete can be called only once per call to getRemoteService");
            this.zza.onPostInitHandler(i, iBinder, bundle, this.zzb);
            this.zza = null;
        }

        @Override // com.google.android.gms.common.internal.IGmsCallbacks
        public final void zza(int i, IBinder iBinder, zzc zzc) {
            BaseGmsClient baseGmsClient = this.zza;
            Preconditions.checkNotNull(baseGmsClient, "onPostInitCompleteWithConnectionInfo can be called only once per call togetRemoteService");
            Preconditions.checkNotNull(zzc);
            baseGmsClient.zza((BaseGmsClient) zzc);
            onPostInitComplete(i, iBinder, zzc.zza);
        }
    }

    /* access modifiers changed from: protected */
    /* compiled from: com.google.android.gms:play-services-basement@@17.4.0 */
    public final class zzf extends zza {
        private final IBinder zza;

        public zzf(int i, IBinder iBinder, Bundle bundle) {
            super(i, bundle);
            this.zza = iBinder;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.android.gms.common.internal.BaseGmsClient.zza
        public final void zza(ConnectionResult connectionResult) {
            if (BaseGmsClient.this.zzx != null) {
                BaseGmsClient.this.zzx.onConnectionFailed(connectionResult);
            }
            BaseGmsClient.this.onConnectionFailed(connectionResult);
        }

        /* access modifiers changed from: protected */
        @Override // com.google.android.gms.common.internal.BaseGmsClient.zza
        public final boolean zza() {
            try {
                String interfaceDescriptor = ((IBinder) Preconditions.checkNotNull(this.zza)).getInterfaceDescriptor();
                if (!BaseGmsClient.this.getServiceDescriptor().equals(interfaceDescriptor)) {
                    String serviceDescriptor = BaseGmsClient.this.getServiceDescriptor();
                    StringBuilder sb = new StringBuilder(String.valueOf(serviceDescriptor).length() + 34 + String.valueOf(interfaceDescriptor).length());
                    sb.append("service descriptor mismatch: ");
                    sb.append(serviceDescriptor);
                    sb.append(" vs. ");
                    sb.append(interfaceDescriptor);
                    Log.e("GmsClient", sb.toString());
                    return false;
                }
                IInterface createServiceInterface = BaseGmsClient.this.createServiceInterface(this.zza);
                if (createServiceInterface == null || (!BaseGmsClient.this.zza((BaseGmsClient) 2, 4, (int) createServiceInterface) && !BaseGmsClient.this.zza((BaseGmsClient) 3, 4, (int) createServiceInterface))) {
                    return false;
                }
                BaseGmsClient.this.zzaa = null;
                Bundle connectionHint = BaseGmsClient.this.getConnectionHint();
                if (BaseGmsClient.this.zzw == null) {
                    return true;
                }
                BaseGmsClient.this.zzw.onConnected(connectionHint);
                return true;
            } catch (RemoteException unused) {
                Log.w("GmsClient", "service probably died");
                return false;
            }
        }
    }

    /* compiled from: com.google.android.gms:play-services-basement@@17.4.0 */
    private abstract class zza extends zzc<Boolean> {
        private final int zza;
        private final Bundle zzb;

        protected zza(int i, Bundle bundle) {
            super(true);
            this.zza = i;
            this.zzb = bundle;
        }

        /* access modifiers changed from: protected */
        public abstract void zza(ConnectionResult connectionResult);

        /* access modifiers changed from: protected */
        public abstract boolean zza();

        /* access modifiers changed from: protected */
        @Override // com.google.android.gms.common.internal.BaseGmsClient.zzc
        public final void zzb() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* access modifiers changed from: protected */
        @Override // com.google.android.gms.common.internal.BaseGmsClient.zzc
        public final /* synthetic */ void zza(Boolean bool) {
            PendingIntent pendingIntent = null;
            if (bool == null) {
                BaseGmsClient.this.zza((BaseGmsClient) 1, (int) null);
            } else if (this.zza != 0) {
                BaseGmsClient.this.zza((BaseGmsClient) 1, (int) null);
                Bundle bundle = this.zzb;
                if (bundle != null) {
                    pendingIntent = (PendingIntent) bundle.getParcelable(BaseGmsClient.KEY_PENDING_INTENT);
                }
                zza(new ConnectionResult(this.zza, pendingIntent));
            } else if (!zza()) {
                BaseGmsClient.this.zza((BaseGmsClient) 1, (int) null);
                zza(new ConnectionResult(8, null));
            }
        }
    }

    protected BaseGmsClient(Context context, Looper looper, GmsClientSupervisor gmsClientSupervisor, GoogleApiAvailabilityLight googleApiAvailabilityLight, int i, BaseConnectionCallbacks baseConnectionCallbacks, BaseOnConnectionFailedListener baseOnConnectionFailedListener, String str) {
        this.zzj = null;
        this.zzp = new Object();
        this.zzq = new Object();
        this.zzt = new ArrayList<>();
        this.zzv = 1;
        this.zzaa = null;
        this.zzab = false;
        this.zzac = null;
        this.zzc = new AtomicInteger(0);
        this.zzl = (Context) Preconditions.checkNotNull(context, "Context must not be null");
        this.zzm = (Looper) Preconditions.checkNotNull(looper, "Looper must not be null");
        this.zzn = (GmsClientSupervisor) Preconditions.checkNotNull(gmsClientSupervisor, "Supervisor must not be null");
        this.zzo = (GoogleApiAvailabilityLight) Preconditions.checkNotNull(googleApiAvailabilityLight, "API availability must not be null");
        this.zza = new zzb(looper);
        this.zzy = i;
        this.zzw = baseConnectionCallbacks;
        this.zzx = baseOnConnectionFailedListener;
        this.zzz = str;
    }

    protected BaseGmsClient(Context context, Handler handler, GmsClientSupervisor gmsClientSupervisor, GoogleApiAvailabilityLight googleApiAvailabilityLight, int i, BaseConnectionCallbacks baseConnectionCallbacks, BaseOnConnectionFailedListener baseOnConnectionFailedListener) {
        this.zzj = null;
        this.zzp = new Object();
        this.zzq = new Object();
        this.zzt = new ArrayList<>();
        this.zzv = 1;
        this.zzaa = null;
        this.zzab = false;
        this.zzac = null;
        this.zzc = new AtomicInteger(0);
        this.zzl = (Context) Preconditions.checkNotNull(context, "Context must not be null");
        this.zza = (Handler) Preconditions.checkNotNull(handler, "Handler must not be null");
        this.zzm = handler.getLooper();
        this.zzn = (GmsClientSupervisor) Preconditions.checkNotNull(gmsClientSupervisor, "Supervisor must not be null");
        this.zzo = (GoogleApiAvailabilityLight) Preconditions.checkNotNull(googleApiAvailabilityLight, "API availability must not be null");
        this.zzy = i;
        this.zzw = baseConnectionCallbacks;
        this.zzx = baseOnConnectionFailedListener;
        this.zzz = null;
    }

    private final String zza() {
        String str = this.zzz;
        return str == null ? this.zzl.getClass().getName() : str;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private final void zza(zzc zzc2) {
        this.zzac = zzc2;
    }

    public final Feature[] getAvailableFeatures() {
        zzc zzc2 = this.zzac;
        if (zzc2 == null) {
            return null;
        }
        return zzc2.zzb;
    }

    public ConnectionTelemetryConfiguration getTelemetryConfiguration() {
        if (this.zzac == null) {
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public void onConnectedLocked(T t) {
        this.zzg = System.currentTimeMillis();
    }

    /* access modifiers changed from: protected */
    public void onConnectionSuspended(int i) {
        this.zze = i;
        this.zzf = System.currentTimeMillis();
    }

    /* access modifiers changed from: protected */
    public void onConnectionFailed(ConnectionResult connectionResult) {
        this.zzh = connectionResult.getErrorCode();
        this.zzi = System.currentTimeMillis();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r12v0, resolved type: com.google.android.gms.common.internal.BaseGmsClient<T extends android.os.IInterface> */
    /* JADX WARN: Multi-variable type inference failed */
    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private final void zza(int i, T t) {
        zzl zzl2;
        zzl zzl3;
        boolean z = false;
        if ((i == 4) == (t != null)) {
            z = true;
        }
        Preconditions.checkArgument(z);
        synchronized (this.zzp) {
            this.zzv = i;
            this.zzs = t;
            if (i == 1) {
                zzd zzd2 = this.zzu;
                if (zzd2 != null) {
                    this.zzn.zza((String) Preconditions.checkNotNull(this.zzk.zza()), this.zzk.zzb(), this.zzk.zzc(), zzd2, zza(), this.zzk.zzd());
                    this.zzu = null;
                }
            } else if (i == 2 || i == 3) {
                zzd zzd3 = this.zzu;
                if (!(zzd3 == null || (zzl3 = this.zzk) == null)) {
                    String zza2 = zzl3.zza();
                    String zzb2 = this.zzk.zzb();
                    StringBuilder sb = new StringBuilder(String.valueOf(zza2).length() + 70 + String.valueOf(zzb2).length());
                    sb.append("Calling connect() while still connected, missing disconnect() for ");
                    sb.append(zza2);
                    sb.append(" on ");
                    sb.append(zzb2);
                    Log.e("GmsClient", sb.toString());
                    this.zzn.zza((String) Preconditions.checkNotNull(this.zzk.zza()), this.zzk.zzb(), this.zzk.zzc(), zzd3, zza(), this.zzk.zzd());
                    this.zzc.incrementAndGet();
                }
                zzd zzd4 = new zzd(this.zzc.get());
                this.zzu = zzd4;
                if (this.zzv != 3 || getLocalStartServiceAction() == null) {
                    zzl2 = new zzl(getStartServicePackage(), getStartServiceAction(), false, GmsClientSupervisor.getDefaultBindFlags(), getUseDynamicLookup());
                } else {
                    zzl2 = new zzl(getContext().getPackageName(), getLocalStartServiceAction(), true, GmsClientSupervisor.getDefaultBindFlags(), false);
                }
                this.zzk = zzl2;
                if (!zzl2.zzd() || getMinApkVersion() >= 17895000) {
                    if (!this.zzn.zza(new GmsClientSupervisor.zza((String) Preconditions.checkNotNull(this.zzk.zza()), this.zzk.zzb(), this.zzk.zzc(), this.zzk.zzd()), zzd4, zza())) {
                        String zza3 = this.zzk.zza();
                        String zzb3 = this.zzk.zzb();
                        StringBuilder sb2 = new StringBuilder(String.valueOf(zza3).length() + 34 + String.valueOf(zzb3).length());
                        sb2.append("unable to connect to service: ");
                        sb2.append(zza3);
                        sb2.append(" on ");
                        sb2.append(zzb3);
                        Log.e("GmsClient", sb2.toString());
                        zza(16, (Bundle) null, this.zzc.get());
                    }
                } else {
                    String valueOf = String.valueOf(this.zzk.zza());
                    throw new IllegalStateException(valueOf.length() != 0 ? "Internal Error, the minimum apk version of this BaseGmsClient is too low to support dynamic lookup. Start service action: ".concat(valueOf) : new String("Internal Error, the minimum apk version of this BaseGmsClient is too low to support dynamic lookup. Start service action: "));
                }
            } else if (i == 4) {
                onConnectedLocked((IInterface) Preconditions.checkNotNull(t));
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private final boolean zza(int i, int i2, T t) {
        synchronized (this.zzp) {
            if (this.zzv != i) {
                return false;
            }
            zza(i2, t);
            return true;
        }
    }

    public void checkAvailabilityAndConnect() {
        int isGooglePlayServicesAvailable = this.zzo.isGooglePlayServicesAvailable(this.zzl, getMinApkVersion());
        if (isGooglePlayServicesAvailable != 0) {
            zza(1, (IInterface) null);
            triggerNotAvailable(new LegacyClientCallbackAdapter(), isGooglePlayServicesAvailable, null);
            return;
        }
        connect(new LegacyClientCallbackAdapter());
    }

    public void connect(ConnectionProgressReportCallbacks connectionProgressReportCallbacks) {
        this.zzb = (ConnectionProgressReportCallbacks) Preconditions.checkNotNull(connectionProgressReportCallbacks, "Connection progress callbacks cannot be null.");
        zza(2, (IInterface) null);
    }

    public boolean isConnected() {
        boolean z;
        synchronized (this.zzp) {
            z = this.zzv == 4;
        }
        return z;
    }

    public boolean isConnecting() {
        boolean z;
        synchronized (this.zzp) {
            int i = this.zzv;
            if (i != 2) {
                if (i != 3) {
                    z = false;
                }
            }
            z = true;
        }
        return z;
    }

    private final boolean zzb() {
        boolean z;
        synchronized (this.zzp) {
            z = this.zzv == 3;
        }
        return z;
    }

    public void disconnect(String str) {
        this.zzj = str;
        disconnect();
    }

    public void disconnect() {
        this.zzc.incrementAndGet();
        synchronized (this.zzt) {
            int size = this.zzt.size();
            for (int i = 0; i < size; i++) {
                this.zzt.get(i).zze();
            }
            this.zzt.clear();
        }
        synchronized (this.zzq) {
            this.zzr = null;
        }
        zza(1, (IInterface) null);
    }

    public String getLastDisconnectMessage() {
        return this.zzj;
    }

    public void triggerConnectionSuspended(int i) {
        Handler handler = this.zza;
        handler.sendMessage(handler.obtainMessage(6, this.zzc.get(), i));
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private final void zza(int i) {
        int i2;
        if (zzb()) {
            i2 = 5;
            this.zzab = true;
        } else {
            i2 = 4;
        }
        Handler handler = this.zza;
        handler.sendMessage(handler.obtainMessage(i2, this.zzc.get(), 16));
    }

    /* access modifiers changed from: protected */
    public void triggerNotAvailable(ConnectionProgressReportCallbacks connectionProgressReportCallbacks, int i, PendingIntent pendingIntent) {
        this.zzb = (ConnectionProgressReportCallbacks) Preconditions.checkNotNull(connectionProgressReportCallbacks, "Connection progress callbacks cannot be null.");
        Handler handler = this.zza;
        handler.sendMessage(handler.obtainMessage(3, this.zzc.get(), i, pendingIntent));
    }

    public final Context getContext() {
        return this.zzl;
    }

    public final Looper getLooper() {
        return this.zzm;
    }

    public Feature[] getApiFeatures() {
        return zzd;
    }

    /* access modifiers changed from: protected */
    public Bundle getGetServiceRequestExtraArgs() {
        return new Bundle();
    }

    /* access modifiers changed from: protected */
    public void onPostInitHandler(int i, IBinder iBinder, Bundle bundle, int i2) {
        Handler handler = this.zza;
        handler.sendMessage(handler.obtainMessage(1, i2, -1, new zzf(i, iBinder, bundle)));
    }

    /* access modifiers changed from: protected */
    public final void zza(int i, Bundle bundle, int i2) {
        Handler handler = this.zza;
        handler.sendMessage(handler.obtainMessage(7, i2, -1, new zzg(i, null)));
    }

    /* access modifiers changed from: protected */
    public final void checkConnected() {
        if (!isConnected()) {
            throw new IllegalStateException("Not connected. Call connect() and wait for onConnected() to be called.");
        }
    }

    public final T getService() throws DeadObjectException {
        T t;
        synchronized (this.zzp) {
            if (this.zzv != 5) {
                checkConnected();
                t = (T) ((IInterface) Preconditions.checkNotNull(this.zzs, "Client is connected but service is null"));
            } else {
                throw new DeadObjectException();
            }
        }
        return t;
    }

    public void getRemoteService(IAccountAccessor iAccountAccessor, Set<Scope> set) {
        Bundle getServiceRequestExtraArgs = getGetServiceRequestExtraArgs();
        GetServiceRequest getServiceRequest = new GetServiceRequest(this.zzy);
        getServiceRequest.zza = this.zzl.getPackageName();
        getServiceRequest.zzd = getServiceRequestExtraArgs;
        if (set != null) {
            getServiceRequest.zzc = (Scope[]) set.toArray(new Scope[set.size()]);
        }
        if (requiresSignIn()) {
            Account account = getAccount();
            if (account == null) {
                account = new Account("<<default account>>", AccountType.GOOGLE);
            }
            getServiceRequest.zze = account;
            if (iAccountAccessor != null) {
                getServiceRequest.zzb = iAccountAccessor.asBinder();
            }
        } else if (requiresAccount()) {
            getServiceRequest.zze = getAccount();
        }
        getServiceRequest.zzf = zzd;
        getServiceRequest.zzg = getApiFeatures();
        if (usesClientTelemetry()) {
            getServiceRequest.zzh = true;
        }
        try {
            synchronized (this.zzq) {
                IGmsServiceBroker iGmsServiceBroker = this.zzr;
                if (iGmsServiceBroker != null) {
                    iGmsServiceBroker.getService(new zze(this, this.zzc.get()), getServiceRequest);
                } else {
                    Log.w("GmsClient", "mServiceBroker is null, client disconnected");
                }
            }
        } catch (DeadObjectException e) {
            Log.w("GmsClient", "IGmsServiceBroker.getService failed", e);
            triggerConnectionSuspended(3);
        } catch (SecurityException e2) {
            throw e2;
        } catch (RemoteException | RuntimeException e3) {
            Log.w("GmsClient", "IGmsServiceBroker.getService failed", e3);
            onPostInitHandler(8, null, null, this.zzc.get());
        }
    }

    public void onUserSignOut(SignOutCallbacks signOutCallbacks) {
        signOutCallbacks.onSignOutComplete();
    }

    public Intent getSignInIntent() {
        throw new UnsupportedOperationException("Not a sign in API");
    }

    /* access modifiers changed from: protected */
    public Set<Scope> getScopes() {
        return Collections.emptySet();
    }

    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        int i;
        T t;
        IGmsServiceBroker iGmsServiceBroker;
        synchronized (this.zzp) {
            i = this.zzv;
            t = this.zzs;
        }
        synchronized (this.zzq) {
            iGmsServiceBroker = this.zzr;
        }
        printWriter.append((CharSequence) str).append("mConnectState=");
        if (i == 1) {
            printWriter.print("DISCONNECTED");
        } else if (i == 2) {
            printWriter.print("REMOTE_CONNECTING");
        } else if (i == 3) {
            printWriter.print("LOCAL_CONNECTING");
        } else if (i == 4) {
            printWriter.print("CONNECTED");
        } else if (i != 5) {
            printWriter.print("UNKNOWN");
        } else {
            printWriter.print("DISCONNECTING");
        }
        printWriter.append(" mService=");
        if (t == null) {
            printWriter.append("null");
        } else {
            printWriter.append((CharSequence) getServiceDescriptor()).append("@").append((CharSequence) Integer.toHexString(System.identityHashCode(t.asBinder())));
        }
        printWriter.append(" mServiceBroker=");
        if (iGmsServiceBroker == null) {
            printWriter.println("null");
        } else {
            printWriter.append("IGmsServiceBroker@").println(Integer.toHexString(System.identityHashCode(iGmsServiceBroker.asBinder())));
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.US);
        if (this.zzg > 0) {
            PrintWriter append = printWriter.append((CharSequence) str).append("lastConnectedTime=");
            long j = this.zzg;
            String format = simpleDateFormat.format(new Date(this.zzg));
            StringBuilder sb = new StringBuilder(String.valueOf(format).length() + 21);
            sb.append(j);
            sb.append(" ");
            sb.append(format);
            append.println(sb.toString());
        }
        if (this.zzf > 0) {
            printWriter.append((CharSequence) str).append("lastSuspendedCause=");
            int i2 = this.zze;
            if (i2 == 1) {
                printWriter.append("CAUSE_SERVICE_DISCONNECTED");
            } else if (i2 == 2) {
                printWriter.append("CAUSE_NETWORK_LOST");
            } else if (i2 != 3) {
                printWriter.append((CharSequence) String.valueOf(i2));
            } else {
                printWriter.append("CAUSE_DEAD_OBJECT_EXCEPTION");
            }
            PrintWriter append2 = printWriter.append(" lastSuspendedTime=");
            long j2 = this.zzf;
            String format2 = simpleDateFormat.format(new Date(this.zzf));
            StringBuilder sb2 = new StringBuilder(String.valueOf(format2).length() + 21);
            sb2.append(j2);
            sb2.append(" ");
            sb2.append(format2);
            append2.println(sb2.toString());
        }
        if (this.zzi > 0) {
            printWriter.append((CharSequence) str).append("lastFailedStatus=").append((CharSequence) CommonStatusCodes.getStatusCodeString(this.zzh));
            PrintWriter append3 = printWriter.append(" lastFailedTime=");
            long j3 = this.zzi;
            String format3 = simpleDateFormat.format(new Date(this.zzi));
            StringBuilder sb3 = new StringBuilder(String.valueOf(format3).length() + 21);
            sb3.append(j3);
            sb3.append(" ");
            sb3.append(format3);
            append3.println(sb3.toString());
        }
    }

    public IBinder getServiceBrokerBinder() {
        synchronized (this.zzq) {
            IGmsServiceBroker iGmsServiceBroker = this.zzr;
            if (iGmsServiceBroker == null) {
                return null;
            }
            return iGmsServiceBroker.asBinder();
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private final boolean zzc() {
        if (this.zzab || TextUtils.isEmpty(getServiceDescriptor()) || TextUtils.isEmpty(getLocalStartServiceAction())) {
            return false;
        }
        try {
            Class.forName(getServiceDescriptor());
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    public String getEndpointPackageName() {
        zzl zzl2;
        if (isConnected() && (zzl2 = this.zzk) != null) {
            return zzl2.zzb();
        }
        throw new RuntimeException("Failed to connect when checking package");
    }

    public int getMinApkVersion() {
        return GoogleApiAvailabilityLight.GOOGLE_PLAY_SERVICES_VERSION_CODE;
    }
}
