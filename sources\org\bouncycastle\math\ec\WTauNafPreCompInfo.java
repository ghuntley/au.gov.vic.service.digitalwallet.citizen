package org.bouncycastle.math.ec;

import org.bouncycastle.math.ec.ECPoint;

/* access modifiers changed from: package-private */
public class WTauNafPreCompInfo implements PreCompInfo {
    private ECPoint.F2m[] preComp = null;

    WTauNafPreCompInfo(ECPoint.F2m[] f2mArr) {
        this.preComp = f2mArr;
    }

    /* access modifiers changed from: protected */
    public ECPoint.F2m[] getPreComp() {
        return this.preComp;
    }
}
