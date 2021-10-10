package com.google.android.gms.common.api.internal;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import androidx.fragment.app.FragmentActivity;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.service.Common;
import com.google.android.gms.common.internal.zah;
import com.google.android.gms.common.internal.zak;
import com.google.android.gms.common.util.ClientLibraryUtils;
import com.google.android.gms.signin.SignInOptions;
import com.google.android.gms.signin.zad;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Lock;

/* compiled from: com.google.android.gms:play-services-base@@17.4.0 */
public final class zaap extends GoogleApiClient implements zabm {
    final Queue<BaseImplementation.ApiMethodImpl<?, ?>> zaa = new LinkedList();
    final Map<Api.AnyClientKey<?>, Api.Client> zab;
    Set<Scope> zac;
    Set<zack> zad;
    final zacl zae;
    private final Lock zaf;
    private final zah zag;
    private zabn zah = null;
    private final int zai;
    private final Context zaj;
    private final Looper zak;
    private volatile boolean zal;
    private long zam;
    private long zan;
    private final zaaw zao;
    private final GoogleApiAvailability zap;
    private zabj zaq;
    private final ClientSettings zar;
    private final Map<Api<?>, Boolean> zas;
    private final Api.AbstractClientBuilder<? extends zad, SignInOptions> zat;
    private final ListenerHolders zau;
    private final ArrayList<zap> zav;
    private Integer zaw;
    private final zak zax;

    public zaap(Context context, Lock lock, Looper looper, ClientSettings clientSettings, GoogleApiAvailability googleApiAvailability, Api.AbstractClientBuilder<? extends zad, SignInOptions> abstractClientBuilder, Map<Api<?>, Boolean> map, List<GoogleApiClient.ConnectionCallbacks> list, List<GoogleApiClient.OnConnectionFailedListener> list2, Map<Api.AnyClientKey<?>, Api.Client> map2, int i, int i2, ArrayList<zap> arrayList) {
        this.zam = ClientLibraryUtils.isPackageSide() ? 10000 : 120000;
        this.zan = 5000;
        this.zac = new HashSet();
        this.zau = new ListenerHolders();
        this.zaw = null;
        this.zad = null;
        zaas zaas = new zaas(this);
        this.zax = zaas;
        this.zaj = context;
        this.zaf = lock;
        this.zag = new zah(looper, zaas);
        this.zak = looper;
        this.zao = new zaaw(this, looper);
        this.zap = googleApiAvailability;
        this.zai = i;
        if (i >= 0) {
            this.zaw = Integer.valueOf(i2);
        }
        this.zas = map;
        this.zab = map2;
        this.zav = arrayList;
        this.zae = new zacl();
        for (GoogleApiClient.ConnectionCallbacks connectionCallbacks : list) {
            this.zag.zaa(connectionCallbacks);
        }
        for (GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener : list2) {
            this.zag.zaa(onConnectionFailedListener);
        }
        this.zar = clientSettings;
        this.zat = abstractClientBuilder;
    }

    private static String zab(int i) {
        return i != 1 ? i != 2 ? i != 3 ? "UNKNOWN" : "SIGN_IN_MODE_NONE" : "SIGN_IN_MODE_OPTIONAL" : "SIGN_IN_MODE_REQUIRED";
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final <A extends Api.AnyClient, R extends Result, T extends BaseImplementation.ApiMethodImpl<R, A>> T enqueue(T t) {
        Api<?> api = t.getApi();
        boolean containsKey = this.zab.containsKey(t.getClientKey());
        String zad2 = api != null ? api.zad() : "the API";
        StringBuilder sb = new StringBuilder(String.valueOf(zad2).length() + 65);
        sb.append("GoogleApiClient is not configured to use ");
        sb.append(zad2);
        sb.append(" required for this call.");
        Preconditions.checkArgument(containsKey, sb.toString());
        this.zaf.lock();
        try {
            zabn zabn = this.zah;
            if (zabn == null) {
                this.zaa.add(t);
                return t;
            }
            T t2 = (T) zabn.zaa(t);
            this.zaf.unlock();
            return t2;
        } finally {
            this.zaf.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final <A extends Api.AnyClient, T extends BaseImplementation.ApiMethodImpl<? extends Result, A>> T execute(T t) {
        Api<?> api = t.getApi();
        boolean containsKey = this.zab.containsKey(t.getClientKey());
        String zad2 = api != null ? api.zad() : "the API";
        StringBuilder sb = new StringBuilder(String.valueOf(zad2).length() + 65);
        sb.append("GoogleApiClient is not configured to use ");
        sb.append(zad2);
        sb.append(" required for this call.");
        Preconditions.checkArgument(containsKey, sb.toString());
        this.zaf.lock();
        try {
            zabn zabn = this.zah;
            if (zabn == null) {
                throw new IllegalStateException("GoogleApiClient is not connected yet.");
            } else if (this.zal) {
                this.zaa.add(t);
                while (!this.zaa.isEmpty()) {
                    BaseImplementation.ApiMethodImpl<?, ?> remove = this.zaa.remove();
                    this.zae.zaa(remove);
                    remove.setFailedResult(Status.RESULT_INTERNAL_ERROR);
                }
                return t;
            } else {
                T t2 = (T) zabn.zab(t);
                this.zaf.unlock();
                return t2;
            }
        } finally {
            this.zaf.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final <L> ListenerHolder<L> registerListener(L l) {
        this.zaf.lock();
        try {
            return this.zau.zaa(l, this.zak, "NO_TYPE");
        } finally {
            this.zaf.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final <C extends Api.Client> C getClient(Api.AnyClientKey<C> anyClientKey) {
        C c = (C) this.zab.get(anyClientKey);
        Preconditions.checkNotNull(c, "Appropriate Api was not requested.");
        return c;
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final boolean hasApi(Api<?> api) {
        return this.zab.containsKey(api.zac());
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final boolean hasConnectedApi(Api<?> api) {
        Api.Client client;
        if (isConnected() && (client = this.zab.get(api.zac())) != null && client.isConnected()) {
            return true;
        }
        return false;
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final ConnectionResult getConnectionResult(Api<?> api) {
        this.zaf.lock();
        try {
            if (!isConnected()) {
                if (!this.zal) {
                    throw new IllegalStateException("Cannot invoke getConnectionResult unless GoogleApiClient is connected");
                }
            }
            if (this.zab.containsKey(api.zac())) {
                ConnectionResult zaa2 = ((zabn) Preconditions.checkNotNull(this.zah)).zaa(api);
                if (zaa2 != null) {
                    this.zaf.unlock();
                    return zaa2;
                } else if (this.zal) {
                    return ConnectionResult.RESULT_SUCCESS;
                } else {
                    Log.w("GoogleApiClientImpl", zac());
                    Log.wtf("GoogleApiClientImpl", String.valueOf(api.zad()).concat(" requested in getConnectionResult is not connected but is not present in the failed  connections map"), new Exception());
                    ConnectionResult connectionResult = new ConnectionResult(8, null);
                    this.zaf.unlock();
                    return connectionResult;
                }
            } else {
                throw new IllegalArgumentException(String.valueOf(api.zad()).concat(" was never registered with GoogleApiClient"));
            }
        } finally {
            this.zaf.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final void connect() {
        this.zaf.lock();
        try {
            boolean z = false;
            if (this.zai >= 0) {
                if (this.zaw != null) {
                    z = true;
                }
                Preconditions.checkState(z, "Sign-in mode should have been set explicitly by auto-manage.");
            } else {
                Integer num = this.zaw;
                if (num == null) {
                    this.zaw = Integer.valueOf(zaa((Iterable<Api.Client>) this.zab.values(), false));
                } else if (num.intValue() == 2) {
                    throw new IllegalStateException("Cannot call connect() when SignInMode is set to SIGN_IN_MODE_OPTIONAL. Call connect(SIGN_IN_MODE_OPTIONAL) instead.");
                }
            }
            connect(((Integer) Preconditions.checkNotNull(this.zaw)).intValue());
        } finally {
            this.zaf.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final void connect(int i) {
        this.zaf.lock();
        boolean z = true;
        if (!(i == 3 || i == 1 || i == 2)) {
            z = false;
        }
        try {
            StringBuilder sb = new StringBuilder(33);
            sb.append("Illegal sign-in mode: ");
            sb.append(i);
            Preconditions.checkArgument(z, sb.toString());
            zaa(i);
            zad();
        } finally {
            this.zaf.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final ConnectionResult blockingConnect() {
        boolean z = true;
        Preconditions.checkState(Looper.myLooper() != Looper.getMainLooper(), "blockingConnect must not be called on the UI thread");
        this.zaf.lock();
        try {
            if (this.zai >= 0) {
                if (this.zaw == null) {
                    z = false;
                }
                Preconditions.checkState(z, "Sign-in mode should have been set explicitly by auto-manage.");
            } else {
                Integer num = this.zaw;
                if (num == null) {
                    this.zaw = Integer.valueOf(zaa((Iterable<Api.Client>) this.zab.values(), false));
                } else if (num.intValue() == 2) {
                    throw new IllegalStateException("Cannot call blockingConnect() when sign-in mode is set to SIGN_IN_MODE_OPTIONAL. Call connect(SIGN_IN_MODE_OPTIONAL) instead.");
                }
            }
            zaa(((Integer) Preconditions.checkNotNull(this.zaw)).intValue());
            this.zag.zab();
            return ((zabn) Preconditions.checkNotNull(this.zah)).zab();
        } finally {
            this.zaf.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final ConnectionResult blockingConnect(long j, TimeUnit timeUnit) {
        Preconditions.checkState(Looper.myLooper() != Looper.getMainLooper(), "blockingConnect must not be called on the UI thread");
        Preconditions.checkNotNull(timeUnit, "TimeUnit must not be null");
        this.zaf.lock();
        try {
            Integer num = this.zaw;
            if (num == null) {
                this.zaw = Integer.valueOf(zaa((Iterable<Api.Client>) this.zab.values(), false));
            } else if (num.intValue() == 2) {
                throw new IllegalStateException("Cannot call blockingConnect() when sign-in mode is set to SIGN_IN_MODE_OPTIONAL. Call connect(SIGN_IN_MODE_OPTIONAL) instead.");
            }
            zaa(((Integer) Preconditions.checkNotNull(this.zaw)).intValue());
            this.zag.zab();
            return ((zabn) Preconditions.checkNotNull(this.zah)).zaa(j, timeUnit);
        } finally {
            this.zaf.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final void disconnect() {
        this.zaf.lock();
        try {
            this.zae.zaa();
            zabn zabn = this.zah;
            if (zabn != null) {
                zabn.zac();
            }
            this.zau.zaa();
            for (BaseImplementation.ApiMethodImpl<?, ?> apiMethodImpl : this.zaa) {
                apiMethodImpl.zaa((zacn) null);
                apiMethodImpl.cancel();
            }
            this.zaa.clear();
            if (this.zah != null) {
                zab();
                this.zag.zaa();
                this.zaf.unlock();
            }
        } finally {
            this.zaf.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final void reconnect() {
        disconnect();
        connect();
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final PendingResult<Status> clearDefaultAccountAndReconnect() {
        Preconditions.checkState(isConnected(), "GoogleApiClient is not connected yet.");
        Integer num = this.zaw;
        Preconditions.checkState(num == null || num.intValue() != 2, "Cannot use clearDefaultAccountAndReconnect with GOOGLE_SIGN_IN_API");
        StatusPendingResult statusPendingResult = new StatusPendingResult(this);
        if (this.zab.containsKey(Common.CLIENT_KEY)) {
            zaa(this, statusPendingResult, false);
        } else {
            AtomicReference atomicReference = new AtomicReference();
            GoogleApiClient build = new GoogleApiClient.Builder(this.zaj).addApi(Common.API).addConnectionCallbacks(new zaar(this, atomicReference, statusPendingResult)).addOnConnectionFailedListener(new zaau(this, statusPendingResult)).setHandler(this.zao).build();
            atomicReference.set(build);
            build.connect();
        }
        return statusPendingResult;
    }

    /* access modifiers changed from: private */
    public final void zaa(GoogleApiClient googleApiClient, StatusPendingResult statusPendingResult, boolean z) {
        Common.zaa.zaa(googleApiClient).setResultCallback(new zaat(this, statusPendingResult, z, googleApiClient));
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final void stopAutoManage(FragmentActivity fragmentActivity) {
        LifecycleActivity lifecycleActivity = new LifecycleActivity((Activity) fragmentActivity);
        if (this.zai >= 0) {
            zai.zaa(lifecycleActivity).zaa(this.zai);
            return;
        }
        throw new IllegalStateException("Called stopAutoManage but automatic lifecycle management is not enabled.");
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final boolean isConnected() {
        zabn zabn = this.zah;
        return zabn != null && zabn.zad();
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final boolean isConnecting() {
        zabn zabn = this.zah;
        return zabn != null && zabn.zae();
    }

    private final void zaa(int i) {
        Integer num = this.zaw;
        if (num == null) {
            this.zaw = Integer.valueOf(i);
        } else if (num.intValue() != i) {
            String zab2 = zab(i);
            String zab3 = zab(this.zaw.intValue());
            StringBuilder sb = new StringBuilder(String.valueOf(zab2).length() + 51 + String.valueOf(zab3).length());
            sb.append("Cannot use sign-in mode: ");
            sb.append(zab2);
            sb.append(". Mode was already set to ");
            sb.append(zab3);
            throw new IllegalStateException(sb.toString());
        }
        if (this.zah == null) {
            boolean z = false;
            boolean z2 = false;
            for (Api.Client client : this.zab.values()) {
                if (client.requiresSignIn()) {
                    z = true;
                }
                if (client.providesSignIn()) {
                    z2 = true;
                }
            }
            int intValue = this.zaw.intValue();
            if (intValue != 1) {
                if (intValue == 2 && z) {
                    this.zah = zaq.zaa(this.zaj, this, this.zaf, this.zak, this.zap, this.zab, this.zar, this.zas, this.zat, this.zav);
                    return;
                }
            } else if (!z) {
                throw new IllegalStateException("SIGN_IN_MODE_REQUIRED cannot be used on a GoogleApiClient that does not contain any authenticated APIs. Use connect() instead.");
            } else if (z2) {
                throw new IllegalStateException("Cannot use SIGN_IN_MODE_REQUIRED with GOOGLE_SIGN_IN_API. Use connect(SIGN_IN_MODE_OPTIONAL) instead.");
            }
            this.zah = new zaax(this.zaj, this, this.zaf, this.zak, this.zap, this.zab, this.zar, this.zas, this.zat, this.zav, this);
        }
    }

    private final void zad() {
        this.zag.zab();
        ((zabn) Preconditions.checkNotNull(this.zah)).zaa();
    }

    /* access modifiers changed from: private */
    public final void zae() {
        this.zaf.lock();
        try {
            if (this.zal) {
                zad();
            }
        } finally {
            this.zaf.unlock();
        }
    }

    /* access modifiers changed from: private */
    public final void zaf() {
        this.zaf.lock();
        try {
            if (zab()) {
                zad();
            }
        } finally {
            this.zaf.unlock();
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean zab() {
        if (!this.zal) {
            return false;
        }
        this.zal = false;
        this.zao.removeMessages(2);
        this.zao.removeMessages(1);
        zabj zabj = this.zaq;
        if (zabj != null) {
            zabj.zaa();
            this.zaq = null;
        }
        return true;
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final void registerConnectionCallbacks(GoogleApiClient.ConnectionCallbacks connectionCallbacks) {
        this.zag.zaa(connectionCallbacks);
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final boolean isConnectionCallbacksRegistered(GoogleApiClient.ConnectionCallbacks connectionCallbacks) {
        return this.zag.zab(connectionCallbacks);
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final void unregisterConnectionCallbacks(GoogleApiClient.ConnectionCallbacks connectionCallbacks) {
        this.zag.zac(connectionCallbacks);
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final void registerConnectionFailedListener(GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        this.zag.zaa(onConnectionFailedListener);
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final boolean isConnectionFailedListenerRegistered(GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        return this.zag.zab(onConnectionFailedListener);
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final void unregisterConnectionFailedListener(GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        this.zag.zac(onConnectionFailedListener);
    }

    @Override // com.google.android.gms.common.api.internal.zabm
    public final void zaa(Bundle bundle) {
        while (!this.zaa.isEmpty()) {
            execute(this.zaa.remove());
        }
        this.zag.zaa(bundle);
    }

    @Override // com.google.android.gms.common.api.internal.zabm
    public final void zaa(ConnectionResult connectionResult) {
        if (!this.zap.isPlayServicesPossiblyUpdating(this.zaj, connectionResult.getErrorCode())) {
            zab();
        }
        if (!this.zal) {
            this.zag.zaa(connectionResult);
            this.zag.zaa();
        }
    }

    @Override // com.google.android.gms.common.api.internal.zabm
    public final void zaa(int i, boolean z) {
        if (i == 1 && !z && !this.zal) {
            this.zal = true;
            if (this.zaq == null && !ClientLibraryUtils.isPackageSide()) {
                try {
                    this.zaq = this.zap.zaa(this.zaj.getApplicationContext(), new zaav(this));
                } catch (SecurityException unused) {
                }
            }
            zaaw zaaw = this.zao;
            zaaw.sendMessageDelayed(zaaw.obtainMessage(1), this.zam);
            zaaw zaaw2 = this.zao;
            zaaw2.sendMessageDelayed(zaaw2.obtainMessage(2), this.zan);
        }
        for (BasePendingResult basePendingResult : (BasePendingResult[]) this.zae.zab.toArray(new BasePendingResult[0])) {
            basePendingResult.forceFailureUnlessReady(zacl.zaa);
        }
        this.zag.zaa(i);
        this.zag.zaa();
        if (i == 2) {
            zad();
        }
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final Context getContext() {
        return this.zaj;
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final Looper getLooper() {
        return this.zak;
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final boolean maybeSignIn(SignInConnectionListener signInConnectionListener) {
        zabn zabn = this.zah;
        return zabn != null && zabn.zaa(signInConnectionListener);
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final void maybeSignOut() {
        zabn zabn = this.zah;
        if (zabn != null) {
            zabn.zag();
        }
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final void zaa(zack zack) {
        this.zaf.lock();
        try {
            if (this.zad == null) {
                this.zad = new HashSet();
            }
            this.zad.add(zack);
        } finally {
            this.zaf.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final void zab(zack zack) {
        zabn zabn;
        this.zaf.lock();
        try {
            Set<zack> set = this.zad;
            if (set == null) {
                Log.wtf("GoogleApiClientImpl", "Attempted to remove pending transform when no transforms are registered.", new Exception());
            } else if (!set.remove(zack)) {
                Log.wtf("GoogleApiClientImpl", "Failed to remove pending transform - this may lead to memory leaks!", new Exception());
            } else if (!zag() && (zabn = this.zah) != null) {
                zabn.zaf();
            }
        } finally {
            this.zaf.unlock();
        }
    }

    /* JADX INFO: finally extract failed */
    private final boolean zag() {
        this.zaf.lock();
        try {
            Set<zack> set = this.zad;
            if (set == null) {
                this.zaf.unlock();
                return false;
            }
            boolean z = !set.isEmpty();
            this.zaf.unlock();
            return z;
        } catch (Throwable th) {
            this.zaf.unlock();
            throw th;
        }
    }

    /* access modifiers changed from: package-private */
    public final String zac() {
        StringWriter stringWriter = new StringWriter();
        dump("", null, new PrintWriter(stringWriter), null);
        return stringWriter.toString();
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.append((CharSequence) str).append("mContext=").println(this.zaj);
        printWriter.append((CharSequence) str).append("mResuming=").print(this.zal);
        printWriter.append(" mWorkQueue.size()=").print(this.zaa.size());
        printWriter.append(" mUnconsumedApiCalls.size()=").println(this.zae.zab.size());
        zabn zabn = this.zah;
        if (zabn != null) {
            zabn.zaa(str, fileDescriptor, printWriter, strArr);
        }
    }

    public static int zaa(Iterable<Api.Client> iterable, boolean z) {
        boolean z2 = false;
        boolean z3 = false;
        for (Api.Client client : iterable) {
            if (client.requiresSignIn()) {
                z2 = true;
            }
            if (client.providesSignIn()) {
                z3 = true;
            }
        }
        if (!z2) {
            return 3;
        }
        if (!z3 || !z) {
            return 1;
        }
        return 2;
    }
}
