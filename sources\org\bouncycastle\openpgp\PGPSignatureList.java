package org.bouncycastle.openpgp;

public class PGPSignatureList {
    PGPSignature[] sigs;

    public PGPSignatureList(PGPSignature pGPSignature) {
        PGPSignature[] pGPSignatureArr = new PGPSignature[1];
        this.sigs = pGPSignatureArr;
        pGPSignatureArr[0] = pGPSignature;
    }

    public PGPSignatureList(PGPSignature[] pGPSignatureArr) {
        PGPSignature[] pGPSignatureArr2 = new PGPSignature[pGPSignatureArr.length];
        this.sigs = pGPSignatureArr2;
        System.arraycopy(pGPSignatureArr, 0, pGPSignatureArr2, 0, pGPSignatureArr.length);
    }

    public PGPSignature get(int i) {
        return this.sigs[i];
    }

    public boolean isEmpty() {
        return this.sigs.length == 0;
    }

    public int size() {
        return this.sigs.length;
    }
}
