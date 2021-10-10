package org.bouncycastle.asn1.ess;

import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERObject;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.nist.NISTObjectIdentifiers;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.asn1.x509.IssuerSerial;

public class ESSCertIDv2 extends ASN1Encodable {
    private static final AlgorithmIdentifier DEFAULT_ALG_ID = new AlgorithmIdentifier(NISTObjectIdentifiers.id_sha256);
    private byte[] certHash;
    private AlgorithmIdentifier hashAlgorithm;
    private IssuerSerial issuerSerial;

    public ESSCertIDv2(ASN1Sequence aSN1Sequence) {
        if (aSN1Sequence.size() <= 3) {
            int i = 0;
            if (aSN1Sequence.getObjectAt(0) instanceof ASN1OctetString) {
                this.hashAlgorithm = DEFAULT_ALG_ID;
            } else {
                this.hashAlgorithm = AlgorithmIdentifier.getInstance(aSN1Sequence.getObjectAt(0).getDERObject());
                i = 1;
            }
            int i2 = i + 1;
            this.certHash = ASN1OctetString.getInstance(aSN1Sequence.getObjectAt(i).getDERObject()).getOctets();
            if (aSN1Sequence.size() > i2) {
                this.issuerSerial = new IssuerSerial(ASN1Sequence.getInstance(aSN1Sequence.getObjectAt(i2).getDERObject()));
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Bad sequence size: " + aSN1Sequence.size());
    }

    public ESSCertIDv2(AlgorithmIdentifier algorithmIdentifier, byte[] bArr) {
        this(algorithmIdentifier, bArr, null);
    }

    public ESSCertIDv2(AlgorithmIdentifier algorithmIdentifier, byte[] bArr, IssuerSerial issuerSerial2) {
        this.hashAlgorithm = algorithmIdentifier == null ? DEFAULT_ALG_ID : algorithmIdentifier;
        this.certHash = bArr;
        this.issuerSerial = issuerSerial2;
    }

    public static ESSCertIDv2 getInstance(Object obj) {
        if (obj == null || (obj instanceof ESSCertIDv2)) {
            return (ESSCertIDv2) obj;
        }
        if (obj instanceof ASN1Sequence) {
            return new ESSCertIDv2((ASN1Sequence) obj);
        }
        throw new IllegalArgumentException("unknown object in 'ESSCertIDv2' factory : " + obj.getClass().getName() + ".");
    }

    public byte[] getCertHash() {
        return this.certHash;
    }

    public AlgorithmIdentifier getHashAlgorithm() {
        return this.hashAlgorithm;
    }

    public IssuerSerial getIssuerSerial() {
        return this.issuerSerial;
    }

    @Override // org.bouncycastle.asn1.ASN1Encodable
    public DERObject toASN1Object() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        if (!this.hashAlgorithm.equals(DEFAULT_ALG_ID)) {
            aSN1EncodableVector.add(this.hashAlgorithm);
        }
        aSN1EncodableVector.add(new DEROctetString(this.certHash).toASN1Object());
        IssuerSerial issuerSerial2 = this.issuerSerial;
        if (issuerSerial2 != null) {
            aSN1EncodableVector.add(issuerSerial2);
        }
        return new DERSequence(aSN1EncodableVector);
    }
}
