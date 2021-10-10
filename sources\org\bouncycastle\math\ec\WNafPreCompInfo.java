package org.bouncycastle.math.ec;

class WNafPreCompInfo implements PreCompInfo {
    private ECPoint[] preComp = null;
    private ECPoint twiceP = null;

    WNafPreCompInfo() {
    }

    /* access modifiers changed from: protected */
    public ECPoint[] getPreComp() {
        return this.preComp;
    }

    /* access modifiers changed from: protected */
    public ECPoint getTwiceP() {
        return this.twiceP;
    }

    /* access modifiers changed from: protected */
    public void setPreComp(ECPoint[] eCPointArr) {
        this.preComp = eCPointArr;
    }

    /* access modifiers changed from: protected */
    public void setTwiceP(ECPoint eCPoint) {
        this.twiceP = eCPoint;
    }
}
