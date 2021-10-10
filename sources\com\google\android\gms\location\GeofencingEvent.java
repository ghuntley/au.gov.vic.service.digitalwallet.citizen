package com.google.android.gms.location;

import android.content.Intent;
import android.location.Location;
import com.google.android.gms.common.internal.Constants;
import com.google.android.gms.internal.location.zzbg;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-location@@17.1.0 */
public class GeofencingEvent {
    private final int zza;
    private final int zzb;
    private final List<Geofence> zzc;
    private final Location zzd;

    private GeofencingEvent(int i, int i2, List<Geofence> list, Location location) {
        this.zza = i;
        this.zzb = i2;
        this.zzc = list;
        this.zzd = location;
    }

    public static GeofencingEvent fromIntent(Intent intent) {
        ArrayList arrayList = null;
        if (intent == null) {
            return null;
        }
        int i = -1;
        int intExtra = intent.getIntExtra(Constants.KEY_GMS_ERROR_CODE, -1);
        int intExtra2 = intent.getIntExtra("com.google.android.location.intent.extra.transition", -1);
        if (intExtra2 != -1 && (intExtra2 == 1 || intExtra2 == 2 || intExtra2 == 4)) {
            i = intExtra2;
        }
        ArrayList arrayList2 = (ArrayList) intent.getSerializableExtra("com.google.android.location.intent.extra.geofence_list");
        if (arrayList2 != null) {
            arrayList = new ArrayList(arrayList2.size());
            ArrayList arrayList3 = arrayList2;
            int size = arrayList3.size();
            int i2 = 0;
            while (i2 < size) {
                Object obj = arrayList3.get(i2);
                i2++;
                arrayList.add(zzbg.zza((byte[]) obj));
            }
        }
        return new GeofencingEvent(intExtra, i, arrayList, (Location) intent.getParcelableExtra("com.google.android.location.intent.extra.triggering_location"));
    }

    public boolean hasError() {
        return this.zza != -1;
    }

    public int getErrorCode() {
        return this.zza;
    }

    public int getGeofenceTransition() {
        return this.zzb;
    }

    public List<Geofence> getTriggeringGeofences() {
        return this.zzc;
    }

    public Location getTriggeringLocation() {
        return this.zzd;
    }
}
