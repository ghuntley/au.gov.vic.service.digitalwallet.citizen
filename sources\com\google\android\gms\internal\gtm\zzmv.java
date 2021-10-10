package com.google.android.gms.internal.gtm;

import com.google.android.gms.common.api.Status;
import org.json.JSONException;

final class zzmv implements zzms {
    zzmv() {
    }

    @Override // com.google.android.gms.internal.gtm.zzms
    public final zzmx zze(byte[] bArr) throws zzml {
        if (bArr == null) {
            throw new zzml("Cannot parse a null byte[]");
        } else if (bArr.length != 0) {
            try {
                zznu zzce = zzmm.zzce(new String(bArr));
                if (zzce != null) {
                    zzev.zzab("The runtime configuration was successfully parsed from the resource");
                }
                return new zzmx(Status.RESULT_SUCCESS, 0, null, zzce);
            } catch (JSONException unused) {
                throw new zzml("The resource data is corrupted. The runtime configuration cannot be extracted from the JSON data");
            } catch (zzml unused2) {
                throw new zzml("The resource data is invalid. The runtime  configuration cannot be extracted from the JSON data");
            }
        } else {
            throw new zzml("Cannot parse a 0 length byte[]");
        }
    }
}
