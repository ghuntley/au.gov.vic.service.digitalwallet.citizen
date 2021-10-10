package com.google.android.gms.location;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.location.Location;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.internal.ApiExceptionMapper;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.api.internal.ListenerHolders;
import com.google.android.gms.common.api.internal.RegistrationMethods;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.common.api.internal.StatusExceptionMapper;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.common.api.internal.TaskUtil;
import com.google.android.gms.internal.location.zzac;
import com.google.android.gms.internal.location.zzah;
import com.google.android.gms.internal.location.zzai;
import com.google.android.gms.internal.location.zzay;
import com.google.android.gms.internal.location.zzbc;
import com.google.android.gms.internal.location.zzbj;
import com.google.android.gms.tasks.CancellationToken;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-location@@17.1.0 */
public class FusedLocationProviderClient extends GoogleApi<Api.ApiOptions.NoOptions> {
    public static final String KEY_MOCK_LOCATION = "mockLocation";
    public static final String KEY_VERTICAL_ACCURACY = "verticalAccuracy";

    /* access modifiers changed from: private */
    /* compiled from: com.google.android.gms:play-services-location@@17.1.0 */
    public interface zza {
        void zza();
    }

    public FusedLocationProviderClient(Context context) {
        super(context, LocationServices.API, (Api.ApiOptions) null, new ApiExceptionMapper());
    }

    /* compiled from: com.google.android.gms:play-services-location@@17.1.0 */
    private static class zzb extends zzd {
        private final zza zza;

        public zzb(TaskCompletionSource<Void> taskCompletionSource, zza zza2) {
            super(taskCompletionSource);
            this.zza = zza2;
        }

        @Override // com.google.android.gms.location.FusedLocationProviderClient.zzd, com.google.android.gms.internal.location.zzai
        public final void a_() {
            this.zza.zza();
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: com.google.android.gms:play-services-location@@17.1.0 */
    public static abstract class zzc implements RemoteCall<zzay, TaskCompletionSource<Boolean>> {
        private boolean zza = true;

        protected zzc() {
        }

        /* access modifiers changed from: protected */
        public final boolean zza() {
            return this.zza;
        }

        /* access modifiers changed from: package-private */
        public final void zza(boolean z) {
            this.zza = false;
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: com.google.android.gms:play-services-location@@17.1.0 */
    public static class zzd extends zzah {
        private final TaskCompletionSource<Void> zza;

        public zzd(TaskCompletionSource<Void> taskCompletionSource) {
            this.zza = taskCompletionSource;
        }

        @Override // com.google.android.gms.internal.location.zzai
        public void a_() {
        }

        @Override // com.google.android.gms.internal.location.zzai
        public final void zza(zzac zzac) {
            TaskUtil.setResultOrApiException(zzac.getStatus(), this.zza);
        }
    }

    public FusedLocationProviderClient(Activity activity) {
        super(activity, (Api) LocationServices.API, (Api.ApiOptions) null, (StatusExceptionMapper) new ApiExceptionMapper());
    }

    public Task<Location> getLastLocation() {
        return doRead(TaskApiCall.builder().run(new zzq(this)).build());
    }

    public Task<Location> getCurrentLocation(int i, CancellationToken cancellationToken) {
        Task<Location> doRead = doRead(TaskApiCall.builder().run(new zzs(this, cancellationToken, zzbc.zza(null, LocationRequest.create().setPriority(i).setInterval(0).setFastestInterval(0).setExpirationDuration(30000)).zza(true).zza(10000))).setFeatures(zzp.zzb).build());
        if (cancellationToken == null) {
            return doRead;
        }
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource(cancellationToken);
        doRead.continueWithTask(new zzy(taskCompletionSource));
        return taskCompletionSource.getTask();
    }

    public Task<LocationAvailability> getLocationAvailability() {
        return doRead(TaskApiCall.builder().run(zzx.zza).build());
    }

    public Task<Void> requestLocationUpdates(LocationRequest locationRequest, LocationCallback locationCallback, Looper looper) {
        return zza(zzbc.zza(null, locationRequest), locationCallback, looper, (zza) null);
    }

    private final Task<Void> zza(zzbc zzbc, LocationCallback locationCallback, Looper looper, zza zza2) {
        ListenerHolder createListenerHolder = ListenerHolders.createListenerHolder(locationCallback, zzbj.zza(looper), LocationCallback.class.getSimpleName());
        zzag zzag = new zzag(this, createListenerHolder);
        return doRegisterEventListener(RegistrationMethods.builder().register(new zzaa(this, zzag, locationCallback, zza2, zzbc, createListenerHolder)).unregister(zzag).withHolder(createListenerHolder).build());
    }

    public Task<Void> requestLocationUpdates(LocationRequest locationRequest, PendingIntent pendingIntent) {
        return doWrite(TaskApiCall.builder().run(new zzz(this, zzbc.zza(null, locationRequest), pendingIntent)).build());
    }

    public Task<Void> removeLocationUpdates(LocationCallback locationCallback) {
        return TaskUtil.toVoidTaskThatFailsOnFalse(doUnregisterEventListener(ListenerHolders.createListenerKey(locationCallback, LocationCallback.class.getSimpleName())));
    }

    public Task<Void> removeLocationUpdates(PendingIntent pendingIntent) {
        return doWrite(TaskApiCall.builder().run(new zzac(pendingIntent)).build());
    }

    public Task<Void> setMockMode(boolean z) {
        return doWrite(TaskApiCall.builder().run(new zzab(z)).build());
    }

    public Task<Void> setMockLocation(Location location) {
        return doWrite(TaskApiCall.builder().run(new zzae(location)).build());
    }

    public Task<Void> flushLocations() {
        return doWrite(TaskApiCall.builder().run(zzr.zza).build());
    }

    /* access modifiers changed from: private */
    public final zzai zza(TaskCompletionSource<Boolean> taskCompletionSource) {
        return new zzaf(this, taskCompletionSource);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zza(zzbc zzbc, PendingIntent pendingIntent, zzay zzay, TaskCompletionSource taskCompletionSource) throws RemoteException {
        zzd zzd2 = new zzd(taskCompletionSource);
        zzbc.zza(getContextAttributionTag());
        zzay.zza(zzbc, pendingIntent, zzd2);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zza(zzc zzc2, LocationCallback locationCallback, zza zza2, zzbc zzbc, ListenerHolder listenerHolder, zzay zzay, TaskCompletionSource taskCompletionSource) throws RemoteException {
        zzb zzb2 = new zzb(taskCompletionSource, new zzu(this, zzc2, locationCallback, zza2));
        zzbc.zza(getContextAttributionTag());
        zzay.zza(zzbc, listenerHolder, zzb2);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zza(CancellationToken cancellationToken, zzbc zzbc, zzay zzay, TaskCompletionSource taskCompletionSource) throws RemoteException {
        zzad zzad = new zzad(this, taskCompletionSource);
        if (cancellationToken != null) {
            cancellationToken.onCanceledRequested(new zzt(this, zzad));
        }
        Task<Void> zza2 = zza(zzbc, zzad, Looper.getMainLooper(), new zzw(taskCompletionSource));
        zza2.continueWithTask(new zzv(taskCompletionSource, zza2));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zza(zzay zzay, TaskCompletionSource taskCompletionSource) throws RemoteException {
        taskCompletionSource.setResult(zzay.zza(getContextAttributionTag()));
    }
}
