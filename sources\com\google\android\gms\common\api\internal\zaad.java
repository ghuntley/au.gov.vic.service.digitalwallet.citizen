package com.google.android.gms.common.api.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.IAccountAccessor;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.zas;
import com.google.android.gms.signin.SignInOptions;
import com.google.android.gms.signin.internal.zam;
import com.google.android.gms.signin.zad;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Future;
import java.util.concurrent.locks.Lock;

/* compiled from: com.google.android.gms:play-services-base@@17.4.0 */
public final class zaad implements zaay {
    private final zaax zaa;
    private final Lock zab;
    private final Context zac;
    private final GoogleApiAvailabilityLight zad;
    private ConnectionResult zae;
    private int zaf;
    private int zag = 0;
    private int zah;
    private final Bundle zai = new Bundle();
    private final Set<Api.AnyClientKey> zaj = new HashSet();
    private zad zak;
    private boolean zal;
    private boolean zam;
    private boolean zan;
    private IAccountAccessor zao;
    private boolean zap;
    private boolean zaq;
    private final ClientSettings zar;
    private final Map<Api<?>, Boolean> zas;
    private final Api.AbstractClientBuilder<? extends zad, SignInOptions> zat;
    private ArrayList<Future<?>> zau = new ArrayList<>();

    public zaad(zaax zaax, ClientSettings clientSettings, Map<Api<?>, Boolean> map, GoogleApiAvailabilityLight googleApiAvailabilityLight, Api.AbstractClientBuilder<? extends zad, SignInOptions> abstractClientBuilder, Lock lock, Context context) {
        this.zaa = zaax;
        this.zar = clientSettings;
        this.zas = map;
        this.zad = googleApiAvailabilityLight;
        this.zat = abstractClientBuilder;
        this.zab = lock;
        this.zac = context;
    }

    private static String zac(int i) {
        return i != 0 ? i != 1 ? "UNKNOWN" : "STEP_GETTING_REMOTE_SERVICE" : "STEP_SERVICE_BINDINGS_AND_SIGN_IN";
    }

    @Override // com.google.android.gms.common.api.internal.zaay
    public final void zac() {
    }

    @Override // com.google.android.gms.common.api.internal.zaay
    public final void zaa() {
        this.zaa.zab.clear();
        this.zam = false;
        this.zae = null;
        this.zag = 0;
        this.zal = true;
        this.zan = false;
        this.zap = false;
        HashMap hashMap = new HashMap();
        boolean z = false;
        for (Api<?> api : this.zas.keySet()) {
            Api.Client client = (Api.Client) Preconditions.checkNotNull(this.zaa.zaa.get(api.zac()));
            z |= api.zaa().getPriority() == 1;
            boolean booleanValue = this.zas.get(api).booleanValue();
            if (client.requiresSignIn()) {
                this.zam = true;
                if (booleanValue) {
                    this.zaj.add(api.zac());
                } else {
                    this.zal = false;
                }
            }
            hashMap.put(client, new zaaf(this, api, booleanValue));
        }
        if (z) {
            this.zam = false;
        }
        if (this.zam) {
            Preconditions.checkNotNull(this.zar);
            Preconditions.checkNotNull(this.zat);
            this.zar.zaa(Integer.valueOf(System.identityHashCode(this.zaa.zad)));
            zaao zaao = new zaao(this, null);
            Api.AbstractClientBuilder<? extends zad, SignInOptions> abstractClientBuilder = this.zat;
            Context context = this.zac;
            Looper looper = this.zaa.zad.getLooper();
            ClientSettings clientSettings = this.zar;
            this.zak = (zad) abstractClientBuilder.buildClient(context, looper, clientSettings, clientSettings.zac(), (GoogleApiClient.ConnectionCallbacks) zaao, (GoogleApiClient.OnConnectionFailedListener) zaao);
        }
        this.zah = this.zaa.zaa.size();
        this.zau.add(zabb.zaa().submit(new zaai(this, hashMap)));
    }

    /* access modifiers changed from: private */
    public final boolean zad() {
        int i = this.zah - 1;
        this.zah = i;
        if (i > 0) {
            return false;
        }
        if (i < 0) {
            Log.w("GACConnecting", this.zaa.zad.zac());
            Log.wtf("GACConnecting", "GoogleApiClient received too many callbacks for the given step. Clients may be in an unexpected state; GoogleApiClient will now disconnect.", new Exception());
            zab(new ConnectionResult(8, null));
            return false;
        } else if (this.zae == null) {
            return true;
        } else {
            this.zaa.zac = this.zaf;
            zab(this.zae);
            return false;
        }
    }

    /* access modifiers changed from: private */
    public final void zaa(zam zam2) {
        if (zab(0)) {
            ConnectionResult zaa2 = zam2.zaa();
            if (zaa2.isSuccess()) {
                zas zas2 = (zas) Preconditions.checkNotNull(zam2.zab());
                ConnectionResult zab2 = zas2.zab();
                if (!zab2.isSuccess()) {
                    String valueOf = String.valueOf(zab2);
                    StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 48);
                    sb.append("Sign-in succeeded with resolve account failure: ");
                    sb.append(valueOf);
                    Log.wtf("GACConnecting", sb.toString(), new Exception());
                    zab(zab2);
                    return;
                }
                this.zan = true;
                this.zao = (IAccountAccessor) Preconditions.checkNotNull(zas2.zaa());
                this.zap = zas2.zac();
                this.zaq = zas2.zad();
                zae();
            } else if (zaa(zaa2)) {
                zag();
                zae();
            } else {
                zab(zaa2);
            }
        }
    }

    /* access modifiers changed from: private */
    public final void zae() {
        if (this.zah == 0) {
            if (!this.zam || this.zan) {
                ArrayList arrayList = new ArrayList();
                this.zag = 1;
                this.zah = this.zaa.zaa.size();
                for (Api.AnyClientKey<?> anyClientKey : this.zaa.zaa.keySet()) {
                    if (!this.zaa.zab.containsKey(anyClientKey)) {
                        arrayList.add(this.zaa.zaa.get(anyClientKey));
                    } else if (zad()) {
                        zaf();
                    }
                }
                if (!arrayList.isEmpty()) {
                    this.zau.add(zabb.zaa().submit(new zaaj(this, arrayList)));
                }
            }
        }
    }

    @Override // com.google.android.gms.common.api.internal.zaay
    public final void zaa(Bundle bundle) {
        if (zab(1)) {
            if (bundle != null) {
                this.zai.putAll(bundle);
            }
            if (zad()) {
                zaf();
            }
        }
    }

    @Override // com.google.android.gms.common.api.internal.zaay
    public final void zaa(ConnectionResult connectionResult, Api<?> api, boolean z) {
        if (zab(1)) {
            zab(connectionResult, api, z);
            if (zad()) {
                zaf();
            }
        }
    }

    private final void zaf() {
        this.zaa.zai();
        zabb.zaa().execute(new zaag(this));
        zad zad2 = this.zak;
        if (zad2 != null) {
            if (this.zap) {
                zad2.zaa((IAccountAccessor) Preconditions.checkNotNull(this.zao), this.zaq);
            }
            zaa(false);
        }
        for (Api.AnyClientKey<?> anyClientKey : this.zaa.zab.keySet()) {
            ((Api.Client) Preconditions.checkNotNull(this.zaa.zaa.get(anyClientKey))).disconnect();
        }
        this.zaa.zae.zaa(this.zai.isEmpty() ? null : this.zai);
    }

    @Override // com.google.android.gms.common.api.internal.zaay
    public final <A extends Api.AnyClient, R extends Result, T extends BaseImplementation.ApiMethodImpl<R, A>> T zaa(T t) {
        this.zaa.zad.zaa.add(t);
        return t;
    }

    @Override // com.google.android.gms.common.api.internal.zaay
    public final <A extends Api.AnyClient, T extends BaseImplementation.ApiMethodImpl<? extends Result, A>> T zab(T t) {
        throw new IllegalStateException("GoogleApiClient is not connected yet.");
    }

    @Override // com.google.android.gms.common.api.internal.zaay
    public final boolean zab() {
        zah();
        zaa(true);
        this.zaa.zaa((ConnectionResult) null);
        return true;
    }

    @Override // com.google.android.gms.common.api.internal.zaay
    public final void zaa(int i) {
        zab(new ConnectionResult(8, null));
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0022, code lost:
        if (r7 != false) goto L_0x0024;
     */
    public final void zab(ConnectionResult connectionResult, Api<?> api, boolean z) {
        boolean z2;
        int priority = api.zaa().getPriority();
        boolean z3 = false;
        if (z) {
            if (!connectionResult.hasResolution() && this.zad.getErrorResolutionIntent(connectionResult.getErrorCode()) == null) {
                z2 = false;
            } else {
                z2 = true;
            }
        }
        if (this.zae == null || priority < this.zaf) {
            z3 = true;
        }
        if (z3) {
            this.zae = connectionResult;
            this.zaf = priority;
        }
        this.zaa.zab.put(api.zac(), connectionResult);
    }

    /* access modifiers changed from: private */
    public final void zag() {
        this.zam = false;
        this.zaa.zad.zac = Collections.emptySet();
        for (Api.AnyClientKey<?> anyClientKey : this.zaj) {
            if (!this.zaa.zab.containsKey(anyClientKey)) {
                this.zaa.zab.put(anyClientKey, new ConnectionResult(17, null));
            }
        }
    }

    /* access modifiers changed from: private */
    public final boolean zaa(ConnectionResult connectionResult) {
        return this.zal && !connectionResult.hasResolution();
    }

    /* access modifiers changed from: private */
    public final void zab(ConnectionResult connectionResult) {
        zah();
        zaa(!connectionResult.hasResolution());
        this.zaa.zaa(connectionResult);
        this.zaa.zae.zaa(connectionResult);
    }

    private final void zaa(boolean z) {
        zad zad2 = this.zak;
        if (zad2 != null) {
            if (zad2.isConnected() && z) {
                zad2.zaa();
            }
            zad2.disconnect();
            ClientSettings clientSettings = (ClientSettings) Preconditions.checkNotNull(this.zar);
            this.zao = null;
        }
    }

    private final void zah() {
        ArrayList<Future<?>> arrayList = this.zau;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Future<?> future = arrayList.get(i);
            i++;
            future.cancel(true);
        }
        this.zau.clear();
    }

    /* access modifiers changed from: private */
    public final Set<Scope> zai() {
        if (this.zar == null) {
            return Collections.emptySet();
        }
        HashSet hashSet = new HashSet(this.zar.getRequiredScopes());
        Map<Api<?>, ClientSettings.zaa> zaa2 = this.zar.zaa();
        for (Api<?> api : zaa2.keySet()) {
            if (!this.zaa.zab.containsKey(api.zac())) {
                hashSet.addAll(zaa2.get(api).zaa);
            }
        }
        return hashSet;
    }

    /* access modifiers changed from: private */
    public final boolean zab(int i) {
        if (this.zag == i) {
            return true;
        }
        Log.w("GACConnecting", this.zaa.zad.zac());
        String valueOf = String.valueOf(this);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 23);
        sb.append("Unexpected callback in ");
        sb.append(valueOf);
        Log.w("GACConnecting", sb.toString());
        int i2 = this.zah;
        StringBuilder sb2 = new StringBuilder(33);
        sb2.append("mRemainingConnections=");
        sb2.append(i2);
        Log.w("GACConnecting", sb2.toString());
        String zac2 = zac(this.zag);
        String zac3 = zac(i);
        StringBuilder sb3 = new StringBuilder(String.valueOf(zac2).length() + 70 + String.valueOf(zac3).length());
        sb3.append("GoogleApiClient connecting is in step ");
        sb3.append(zac2);
        sb3.append(" but received callback for step ");
        sb3.append(zac3);
        Log.e("GACConnecting", sb3.toString(), new Exception());
        zab(new ConnectionResult(8, null));
        return false;
    }
}
