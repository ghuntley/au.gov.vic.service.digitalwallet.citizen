package com.google.android.gms.common.api.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.signin.SignInOptions;
import com.google.android.gms.signin.zad;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import org.checkerframework.checker.initialization.qual.NotOnlyInitialized;

/* compiled from: com.google.android.gms:play-services-base@@17.4.0 */
public final class zaax implements zabn, zar {
    final Map<Api.AnyClientKey<?>, Api.Client> zaa;
    final Map<Api.AnyClientKey<?>, ConnectionResult> zab = new HashMap();
    int zac;
    final zaap zad;
    final zabm zae;
    private final Lock zaf;
    private final Condition zag;
    private final Context zah;
    private final GoogleApiAvailabilityLight zai;
    private final zaaz zaj;
    private final ClientSettings zak;
    private final Map<Api<?>, Boolean> zal;
    private final Api.AbstractClientBuilder<? extends zad, SignInOptions> zam;
    @NotOnlyInitialized
    private volatile zaay zan;
    private ConnectionResult zao = null;

    public zaax(Context context, zaap zaap, Lock lock, Looper looper, GoogleApiAvailabilityLight googleApiAvailabilityLight, Map<Api.AnyClientKey<?>, Api.Client> map, ClientSettings clientSettings, Map<Api<?>, Boolean> map2, Api.AbstractClientBuilder<? extends zad, SignInOptions> abstractClientBuilder, ArrayList<zap> arrayList, zabm zabm) {
        this.zah = context;
        this.zaf = lock;
        this.zai = googleApiAvailabilityLight;
        this.zaa = map;
        this.zak = clientSettings;
        this.zal = map2;
        this.zam = abstractClientBuilder;
        this.zad = zaap;
        this.zae = zabm;
        ArrayList<zap> arrayList2 = arrayList;
        int size = arrayList2.size();
        int i = 0;
        while (i < size) {
            zap zap = arrayList2.get(i);
            i++;
            zap.zaa(this);
        }
        this.zaj = new zaaz(this, looper);
        this.zag = lock.newCondition();
        this.zan = new zaaq(this);
    }

    @Override // com.google.android.gms.common.api.internal.zabn
    public final boolean zaa(SignInConnectionListener signInConnectionListener) {
        return false;
    }

    @Override // com.google.android.gms.common.api.internal.zabn
    public final void zag() {
    }

    @Override // com.google.android.gms.common.api.internal.zabn
    public final <A extends Api.AnyClient, R extends Result, T extends BaseImplementation.ApiMethodImpl<R, A>> T zaa(T t) {
        t.zab();
        return (T) this.zan.zaa(t);
    }

    @Override // com.google.android.gms.common.api.internal.zabn
    public final <A extends Api.AnyClient, T extends BaseImplementation.ApiMethodImpl<? extends Result, A>> T zab(T t) {
        t.zab();
        return (T) this.zan.zab(t);
    }

    @Override // com.google.android.gms.common.api.internal.zabn
    public final void zaa() {
        this.zan.zac();
    }

    @Override // com.google.android.gms.common.api.internal.zabn
    public final ConnectionResult zab() {
        zaa();
        while (zae()) {
            try {
                this.zag.await();
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
                return new ConnectionResult(15, null);
            }
        }
        if (zad()) {
            return ConnectionResult.RESULT_SUCCESS;
        }
        ConnectionResult connectionResult = this.zao;
        if (connectionResult != null) {
            return connectionResult;
        }
        return new ConnectionResult(13, null);
    }

    @Override // com.google.android.gms.common.api.internal.zabn
    public final ConnectionResult zaa(long j, TimeUnit timeUnit) {
        zaa();
        long nanos = timeUnit.toNanos(j);
        while (zae()) {
            if (nanos <= 0) {
                try {
                    zac();
                    return new ConnectionResult(14, null);
                } catch (InterruptedException unused) {
                    Thread.currentThread().interrupt();
                    return new ConnectionResult(15, null);
                }
            } else {
                nanos = this.zag.awaitNanos(nanos);
            }
        }
        if (zad()) {
            return ConnectionResult.RESULT_SUCCESS;
        }
        ConnectionResult connectionResult = this.zao;
        if (connectionResult != null) {
            return connectionResult;
        }
        return new ConnectionResult(13, null);
    }

    @Override // com.google.android.gms.common.api.internal.zabn
    public final void zac() {
        if (this.zan.zab()) {
            this.zab.clear();
        }
    }

    @Override // com.google.android.gms.common.api.internal.zabn
    public final ConnectionResult zaa(Api<?> api) {
        Api.AnyClientKey<?> zac2 = api.zac();
        if (!this.zaa.containsKey(zac2)) {
            return null;
        }
        if (this.zaa.get(zac2).isConnected()) {
            return ConnectionResult.RESULT_SUCCESS;
        }
        if (this.zab.containsKey(zac2)) {
            return this.zab.get(zac2);
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public final void zah() {
        this.zaf.lock();
        try {
            this.zan = new zaad(this, this.zak, this.zal, this.zai, this.zam, this.zaf, this.zah);
            this.zan.zaa();
            this.zag.signalAll();
        } finally {
            this.zaf.unlock();
        }
    }

    /* access modifiers changed from: package-private */
    public final void zai() {
        this.zaf.lock();
        try {
            this.zad.zab();
            this.zan = new zaac(this);
            this.zan.zaa();
            this.zag.signalAll();
        } finally {
            this.zaf.unlock();
        }
    }

    /* access modifiers changed from: package-private */
    public final void zaa(ConnectionResult connectionResult) {
        this.zaf.lock();
        try {
            this.zao = connectionResult;
            this.zan = new zaaq(this);
            this.zan.zaa();
            this.zag.signalAll();
        } finally {
            this.zaf.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.internal.zabn
    public final boolean zad() {
        return this.zan instanceof zaac;
    }

    @Override // com.google.android.gms.common.api.internal.zabn
    public final boolean zae() {
        return this.zan instanceof zaad;
    }

    @Override // com.google.android.gms.common.api.internal.zabn
    public final void zaf() {
        if (zad()) {
            ((zaac) this.zan).zad();
        }
    }

    @Override // com.google.android.gms.common.api.internal.zar
    public final void zaa(ConnectionResult connectionResult, Api<?> api, boolean z) {
        this.zaf.lock();
        try {
            this.zan.zaa(connectionResult, api, z);
        } finally {
            this.zaf.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.internal.ConnectionCallbacks
    public final void onConnected(Bundle bundle) {
        this.zaf.lock();
        try {
            this.zan.zaa(bundle);
        } finally {
            this.zaf.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.internal.ConnectionCallbacks
    public final void onConnectionSuspended(int i) {
        this.zaf.lock();
        try {
            this.zan.zaa(i);
        } finally {
            this.zaf.unlock();
        }
    }

    /* access modifiers changed from: package-private */
    public final void zaa(zaba zaba) {
        this.zaj.sendMessage(this.zaj.obtainMessage(1, zaba));
    }

    /* access modifiers changed from: package-private */
    public final void zaa(RuntimeException runtimeException) {
        this.zaj.sendMessage(this.zaj.obtainMessage(2, runtimeException));
    }

    @Override // com.google.android.gms.common.api.internal.zabn
    public final void zaa(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        String concat = String.valueOf(str).concat("  ");
        printWriter.append((CharSequence) str).append("mState=").println(this.zan);
        for (Api<?> api : this.zal.keySet()) {
            printWriter.append((CharSequence) str).append((CharSequence) api.zad()).println(":");
            ((Api.Client) Preconditions.checkNotNull(this.zaa.get(api.zac()))).dump(concat, fileDescriptor, printWriter, strArr);
        }
    }
}
