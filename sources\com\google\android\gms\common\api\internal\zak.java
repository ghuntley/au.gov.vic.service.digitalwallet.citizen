package com.google.android.gms.common.api.internal;

import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.internal.base.zap;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-base@@17.4.0 */
public abstract class zak extends LifecycleCallback implements DialogInterface.OnCancelListener {
    protected volatile boolean zaa;
    protected final AtomicReference<zam> zab;
    protected final GoogleApiAvailability zac;
    private final Handler zad;

    protected zak(LifecycleFragment lifecycleFragment) {
        this(lifecycleFragment, GoogleApiAvailability.getInstance());
    }

    /* access modifiers changed from: protected */
    public abstract void zaa();

    /* access modifiers changed from: protected */
    public abstract void zaa(ConnectionResult connectionResult, int i);

    zak(LifecycleFragment lifecycleFragment, GoogleApiAvailability googleApiAvailability) {
        super(lifecycleFragment);
        this.zab = new AtomicReference<>(null);
        this.zad = new zap(Looper.getMainLooper());
        this.zac = googleApiAvailability;
    }

    public void onCancel(DialogInterface dialogInterface) {
        zaa(new ConnectionResult(13, null), zaa(this.zab.get()));
        zab();
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleCallback
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            this.zab.set(bundle.getBoolean("resolving_error", false) ? new zam(new ConnectionResult(bundle.getInt("failed_status"), (PendingIntent) bundle.getParcelable("failed_resolution")), bundle.getInt("failed_client_id", -1)) : null);
        }
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleCallback
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        zam zam = this.zab.get();
        if (zam != null) {
            bundle.putBoolean("resolving_error", true);
            bundle.putInt("failed_client_id", zam.zaa());
            bundle.putInt("failed_status", zam.zab().getErrorCode());
            bundle.putParcelable("failed_resolution", zam.zab().getResolution());
        }
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleCallback
    public void onStart() {
        super.onStart();
        this.zaa = true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0063  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0067  */
    @Override // com.google.android.gms.common.api.internal.LifecycleCallback
    public void onActivityResult(int i, int i2, Intent intent) {
        zam zam = this.zab.get();
        boolean z = true;
        if (i == 1) {
            if (i2 != -1) {
                if (i2 == 0) {
                    if (zam != null) {
                        int i3 = 13;
                        if (intent != null) {
                            i3 = intent.getIntExtra("<<ResolutionFailureErrorDetail>>", 13);
                        }
                        zam zam2 = new zam(new ConnectionResult(i3, null, zam.zab().toString()), zaa(zam));
                        this.zab.set(zam2);
                        zam = zam2;
                    } else {
                        return;
                    }
                }
            }
            if (z) {
            }
        } else if (i == 2) {
            int isGooglePlayServicesAvailable = this.zac.isGooglePlayServicesAvailable(getActivity());
            if (isGooglePlayServicesAvailable != 0) {
                z = false;
            }
            if (zam != null) {
                if (zam.zab().getErrorCode() == 18 && isGooglePlayServicesAvailable == 18) {
                    return;
                }
                if (z) {
                    zab();
                    return;
                } else if (zam != null) {
                    zaa(zam.zab(), zam.zaa());
                    return;
                } else {
                    return;
                }
            } else {
                return;
            }
        }
        z = false;
        if (z) {
        }
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleCallback
    public void onStop() {
        super.onStop();
        this.zaa = false;
    }

    /* access modifiers changed from: protected */
    public final void zab() {
        this.zab.set(null);
        zaa();
    }

    public final void zab(ConnectionResult connectionResult, int i) {
        zam zam = new zam(connectionResult, i);
        if (this.zab.compareAndSet(null, zam)) {
            this.zad.post(new zal(this, zam));
        }
    }

    private static int zaa(zam zam) {
        if (zam == null) {
            return -1;
        }
        return zam.zaa();
    }
}
