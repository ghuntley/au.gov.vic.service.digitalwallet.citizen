package com.digitalwallet.app.view.harvester;

import android.location.Location;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationResult;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/digitalwallet/app/view/harvester/HarvestActivity$locationCallback$1", "Lcom/google/android/gms/location/LocationCallback;", "onLocationResult", "", "result", "Lcom/google/android/gms/location/LocationResult;", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: HarvestActivity.kt */
public final class HarvestActivity$locationCallback$1 extends LocationCallback {
    final /* synthetic */ HarvestActivity this$0;

    /* JADX WARN: Incorrect args count in method signature: ()V */
    HarvestActivity$locationCallback$1(HarvestActivity harvestActivity) {
        this.this$0 = harvestActivity;
    }

    @Override // com.google.android.gms.location.LocationCallback
    public void onLocationResult(LocationResult locationResult) {
        Location lastLocation;
        Location lastLocation2;
        Double d = null;
        this.this$0.setGpsLatitude((locationResult == null || (lastLocation2 = locationResult.getLastLocation()) == null) ? null : Double.valueOf(lastLocation2.getLatitude()));
        HarvestActivity harvestActivity = this.this$0;
        if (!(locationResult == null || (lastLocation = locationResult.getLastLocation()) == null)) {
            d = Double.valueOf(lastLocation.getLongitude());
        }
        harvestActivity.setGpsLongitude(d);
    }
}
