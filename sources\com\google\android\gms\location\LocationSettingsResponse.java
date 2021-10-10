package com.google.android.gms.location;

import com.google.android.gms.common.api.Response;

/* compiled from: com.google.android.gms:play-services-location@@17.1.0 */
public class LocationSettingsResponse extends Response<LocationSettingsResult> {
    public LocationSettingsResponse() {
    }

    public LocationSettingsResponse(LocationSettingsResult locationSettingsResult) {
        super(locationSettingsResult);
    }

    public LocationSettingsStates getLocationSettingsStates() {
        return ((LocationSettingsResult) getResult()).getLocationSettingsStates();
    }
}
