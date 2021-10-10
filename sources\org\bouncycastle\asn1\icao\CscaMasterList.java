package org.bouncycastle.asn1.icao;

import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1Set;
import org.bouncycastle.asn1.DERInteger;
import org.bouncycastle.asn1.DERObject;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERSet;
import org.bouncycastle.asn1.x509.X509CertificateStructure;

public class CscaMasterList extends ASN1Encodable {
    private X509CertificateStructure[] certList;
    private DERInteger version = new DERInteger(0);

    private CscaMasterList(ASN1Sequence aSN1Sequence) {
        int i = 0;
        if (aSN1Sequence == null || aSN1Sequence.size() == 0) {
            throw new IllegalArgumentException("null or empty sequence passed.");
        } else if (aSN1Sequence.size() == 2) {
            this.version = DERInteger.getInstance(aSN1Sequence.getObjectAt(0));
            ASN1Set instance = ASN1Set.getInstance(aSN1Sequence.getObjectAt(1));
            this.certList = new X509CertificateStructure[instance.size()];
            while (true) {
                X509CertificateStructure[] x509CertificateStructureArr = this.certList;
                if (i < x509CertificateStructureArr.length) {
                    x509CertificateStructureArr[i] = X509CertificateStructure.getInstance(instance.getObjectAt(i));
                    i++;
                } else {
                    return;
                }
            }
        } else {
            throw new IllegalArgumentException("Incorrect sequence size: " + aSN1Sequence.size());
        }
    }

    public CscaMasterList(X509CertificateStructure[] x509CertificateStructureArr) {
        this.certList = copyCertList(x509CertificateStructureArr);
    }

    private X509CertificateStructure[] copyCertList(X509CertificateStructure[] x509CertificateStructureArr) {
        int length = x509CertificateStructureArr.length;
        X509CertificateStructure[] x509CertificateStructureArr2 = new X509CertificateStructure[length];
        for (int i = 0; i != length; i++) {
            x509CertificateStructureArr2[i] = x509CertificateStructureArr[i];
        }
        return x509CertificateStructureArr2;
    }

    public static CscaMasterList getInstance(Object obj) {
        if (obj instanceof CscaMasterList) {
            return (CscaMasterList) obj;
        }
        if (obj != null) {
            return new CscaMasterList(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public X509CertificateStructure[] getCertStructs() {
        return copyCertList(this.certList);
    }

    public int getVersion() {
        return this.version.getValue().intValue();
    }

    @Override // org.bouncycastle.asn1.ASN1Encodable
    public DERObject toASN1Object() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(this.version);
        ASN1EncodableVector aSN1EncodableVector2 = new ASN1EncodableVector();
        int i = 0;
        while (true) {
            X509CertificateStructure[] x509CertificateStructureArr = this.certList;
            if (i < x509CertificateStructureArr.length) {
                aSN1EncodableVector2.add(x509CertificateStructureArr[i]);
                i++;
            } else {
                aSN1EncodableVector.add(new DERSet(aSN1EncodableVector2));
                return new DERSequence(aSN1EncodableVector);
            }
        }
    }
}
