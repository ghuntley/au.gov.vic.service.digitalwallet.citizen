package com.google.android.gms.location;

import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.internal.location.zzbg;

/* compiled from: com.google.android.gms:play-services-location@@17.1.0 */
public interface Geofence {
    public static final int GEOFENCE_TRANSITION_DWELL = 4;
    public static final int GEOFENCE_TRANSITION_ENTER = 1;
    public static final int GEOFENCE_TRANSITION_EXIT = 2;
    public static final long NEVER_EXPIRE = -1;

    String getRequestId();

    /* compiled from: com.google.android.gms:play-services-location@@17.1.0 */
    public static final class Builder {
        private String zza = null;
        private int zzb = 0;
        private long zzc = Long.MIN_VALUE;
        private short zzd = -1;
        private double zze;
        private double zzf;
        private float zzg;
        private int zzh = 0;
        private int zzi = -1;

        public final Builder setRequestId(String str) {
            this.zza = str;
            return this;
        }

        public final Builder setTransitionTypes(int i) {
            this.zzb = i;
            return this;
        }

        public final Builder setExpirationDuration(long j) {
            if (j < 0) {
                this.zzc = -1;
            } else {
                this.zzc = DefaultClock.getInstance().elapsedRealtime() + j;
            }
            return this;
        }

        public final Builder setCircularRegion(double d, double d2, float f) {
            this.zzd = 1;
            this.zze = d;
            this.zzf = d2;
            this.zzg = f;
            return this;
        }

        public final Builder setNotificationResponsiveness(int i) {
            this.zzh = i;
            return this;
        }

        public final Builder setLoiteringDelay(int i) {
            this.zzi = i;
            return this;
        }

        public final Geofence build() {
            if (this.zza != null) {
                int i = this.zzb;
                if (i == 0) {
                    throw new IllegalArgumentException("Transitions types not set.");
                } else if ((i & 4) != 0 && this.zzi < 0) {
                    throw new IllegalArgumentException("Non-negative loitering delay needs to be set when transition types include GEOFENCE_TRANSITION_DWELLING.");
                } else if (this.zzc == Long.MIN_VALUE) {
                    throw new IllegalArgumentException("Expiration not set.");
                } else if (this.zzd == -1) {
                    throw new IllegalArgumentException("Geofence region not set.");
                } else if (this.zzh >= 0) {
                    return new zzbg(this.zza, this.zzb, 1, this.zze, this.zzf, this.zzg, this.zzc, this.zzh, this.zzi);
                } else {
                    throw new IllegalArgumentException("Notification responsiveness should be nonnegative.");
                }
            } else {
                throw new IllegalArgumentException("Request ID not set.");
            }
        }
    }
}
