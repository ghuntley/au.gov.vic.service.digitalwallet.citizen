package org.bouncycastle.openpgp;

public class PGPOnePassSignatureList {
    PGPOnePassSignature[] sigs;

    public PGPOnePassSignatureList(PGPOnePassSignature pGPOnePassSignature) {
        PGPOnePassSignature[] pGPOnePassSignatureArr = new PGPOnePassSignature[1];
        this.sigs = pGPOnePassSignatureArr;
        pGPOnePassSignatureArr[0] = pGPOnePassSignature;
    }

    public PGPOnePassSignatureList(PGPOnePassSignature[] pGPOnePassSignatureArr) {
        PGPOnePassSignature[] pGPOnePassSignatureArr2 = new PGPOnePassSignature[pGPOnePassSignatureArr.length];
        this.sigs = pGPOnePassSignatureArr2;
        System.arraycopy(pGPOnePassSignatureArr, 0, pGPOnePassSignatureArr2, 0, pGPOnePassSignatureArr.length);
    }

    public PGPOnePassSignature get(int i) {
        return this.sigs[i];
    }

    public boolean isEmpty() {
        return this.sigs.length == 0;
    }

    public int size() {
        return this.sigs.length;
    }
}
