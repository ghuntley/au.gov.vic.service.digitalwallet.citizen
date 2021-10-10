package com.google.android.gms.internal.gtm;

import com.google.android.gms.common.api.Status;
import org.json.JSONException;

final class zzmu implements zzms {
    zzmu() {
    }

    @Override // com.google.android.gms.internal.gtm.zzms
    public final zzmx zze(byte[] bArr) throws zzml {
        if (bArr == null) {
            throw new zzml("Cannot parse a null byte[]");
        } else if (bArr.length != 0) {
            try {
                zznm zzcd = zzmm.zzcd(new String(bArr));
                if (zzcd != null) {
                    zzev.zzab("The container was successfully parsed from the resource");
                }
                return new zzmx(Status.RESULT_SUCCESS, 0, new zzmy(zzcd), zzmt.zzasx.zze(bArr).zzlm());
            } catch (JSONException unused) {
                throw new zzml("The resource data is corrupted. The container cannot be extracted from the JSON data");
            } catch (zzml unused2) {
                throw new zzml("The resource data is invalid. The container cannot be extracted from the JSON data");
            }
        } else {
            throw new zzml("Cannot parse a 0 length byte[]");
        }
    }
}
