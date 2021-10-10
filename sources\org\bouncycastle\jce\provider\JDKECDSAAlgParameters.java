package org.bouncycastle.jce.provider;

import java.io.IOException;
import java.security.AlgorithmParametersSpi;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidParameterSpecException;
import org.bouncycastle.asn1.DEROctetString;

public abstract class JDKECDSAAlgParameters extends AlgorithmParametersSpi {

    public static class SigAlgParameters extends JDKAlgorithmParameters {
        /* access modifiers changed from: protected */
        @Override // java.security.AlgorithmParametersSpi
        public byte[] engineGetEncoded() throws IOException {
            return engineGetEncoded("ASN.1");
        }

        /* access modifiers changed from: protected */
        @Override // java.security.AlgorithmParametersSpi
        public byte[] engineGetEncoded(String str) throws IOException {
            if (str == null) {
                return engineGetEncoded("ASN.1");
            }
            if (str.equals("ASN.1")) {
                return new DEROctetString(engineGetEncoded("RAW")).getEncoded();
            }
            return null;
        }

        /* access modifiers changed from: protected */
        @Override // java.security.AlgorithmParametersSpi
        public void engineInit(AlgorithmParameterSpec algorithmParameterSpec) throws InvalidParameterSpecException {
            throw new InvalidParameterSpecException("unknown parameter spec passed to ECDSA parameters object.");
        }

        /* access modifiers changed from: protected */
        @Override // java.security.AlgorithmParametersSpi
        public void engineInit(byte[] bArr) throws IOException {
        }

        /* access modifiers changed from: protected */
        @Override // java.security.AlgorithmParametersSpi
        public void engineInit(byte[] bArr, String str) throws IOException {
            throw new IOException("Unknown parameters format in IV parameters object");
        }

        /* access modifiers changed from: protected */
        public String engineToString() {
            return "ECDSA Parameters";
        }

        /* access modifiers changed from: protected */
        @Override // org.bouncycastle.jce.provider.JDKAlgorithmParameters
        public AlgorithmParameterSpec localEngineGetParameterSpec(Class cls) throws InvalidParameterSpecException {
            throw new InvalidParameterSpecException("unknown parameter spec passed to ECDSA parameters object.");
        }
    }
}
