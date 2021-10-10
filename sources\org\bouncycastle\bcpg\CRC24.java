package org.bouncycastle.bcpg;

public class CRC24 {
    private static final int CRC24_INIT = 11994318;
    private static final int CRC24_POLY = 25578747;
    private int crc = CRC24_INIT;

    public int getValue() {
        return this.crc;
    }

    public void reset() {
        this.crc = CRC24_INIT;
    }

    public void update(int i) {
        this.crc = (i << 16) ^ this.crc;
        for (int i2 = 0; i2 < 8; i2++) {
            int i3 = this.crc << 1;
            this.crc = i3;
            if ((16777216 & i3) != 0) {
                this.crc = i3 ^ CRC24_POLY;
            }
        }
    }
}
