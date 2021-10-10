package org.bouncycastle.tsp;

import java.text.DecimalFormat;
import org.bouncycastle.asn1.DERInteger;
import org.bouncycastle.asn1.tsp.Accuracy;

public class GenTimeAccuracy {
    private Accuracy accuracy;

    public GenTimeAccuracy(Accuracy accuracy2) {
        this.accuracy = accuracy2;
    }

    private int getTimeComponent(DERInteger dERInteger) {
        if (dERInteger != null) {
            return dERInteger.getValue().intValue();
        }
        return 0;
    }

    public int getMicros() {
        return getTimeComponent(this.accuracy.getMicros());
    }

    public int getMillis() {
        return getTimeComponent(this.accuracy.getMillis());
    }

    public int getSeconds() {
        return getTimeComponent(this.accuracy.getSeconds());
    }

    public String toString() {
        DecimalFormat decimalFormat = new DecimalFormat("000");
        return getSeconds() + "." + decimalFormat.format((long) getMillis()) + decimalFormat.format((long) getMicros());
    }
}
