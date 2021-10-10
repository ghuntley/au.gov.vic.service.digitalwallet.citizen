package org.bouncycastle.asn1.x509;

import java.util.Enumeration;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERGeneralizedTime;
import org.bouncycastle.asn1.DERInteger;
import org.bouncycastle.asn1.DERObject;
import org.bouncycastle.asn1.DERTaggedObject;
import org.bouncycastle.asn1.DERUTCTime;

public class TBSCertList extends ASN1Encodable {
    X509Extensions crlExtensions;
    X509Name issuer;
    Time nextUpdate;
    ASN1Sequence revokedCertificates;
    ASN1Sequence seq;
    AlgorithmIdentifier signature;
    Time thisUpdate;
    DERInteger version;

    public static class CRLEntry extends ASN1Encodable {
        X509Extensions crlEntryExtensions;
        Time revocationDate;
        ASN1Sequence seq;
        DERInteger userCertificate;

        public CRLEntry(ASN1Sequence aSN1Sequence) {
            if (aSN1Sequence.size() < 2 || aSN1Sequence.size() > 3) {
                throw new IllegalArgumentException("Bad sequence size: " + aSN1Sequence.size());
            }
            this.seq = aSN1Sequence;
            this.userCertificate = DERInteger.getInstance(aSN1Sequence.getObjectAt(0));
            this.revocationDate = Time.getInstance(aSN1Sequence.getObjectAt(1));
        }

        public X509Extensions getExtensions() {
            if (this.crlEntryExtensions == null && this.seq.size() == 3) {
                this.crlEntryExtensions = X509Extensions.getInstance(this.seq.getObjectAt(2));
            }
            return this.crlEntryExtensions;
        }

        public Time getRevocationDate() {
            return this.revocationDate;
        }

        public DERInteger getUserCertificate() {
            return this.userCertificate;
        }

        @Override // org.bouncycastle.asn1.ASN1Encodable
        public DERObject toASN1Object() {
            return this.seq;
        }
    }

    /* access modifiers changed from: private */
    public class EmptyEnumeration implements Enumeration {
        private EmptyEnumeration() {
        }

        public boolean hasMoreElements() {
            return false;
        }

        @Override // java.util.Enumeration
        public Object nextElement() {
            return null;
        }
    }

    /* access modifiers changed from: private */
    public class RevokedCertificatesEnumeration implements Enumeration {
        private final Enumeration en;

        RevokedCertificatesEnumeration(Enumeration enumeration) {
            this.en = enumeration;
        }

        public boolean hasMoreElements() {
            return this.en.hasMoreElements();
        }

        @Override // java.util.Enumeration
        public Object nextElement() {
            return new CRLEntry(ASN1Sequence.getInstance(this.en.nextElement()));
        }
    }

    public TBSCertList(ASN1Sequence aSN1Sequence) {
        if (aSN1Sequence.size() < 3 || aSN1Sequence.size() > 7) {
            throw new IllegalArgumentException("Bad sequence size: " + aSN1Sequence.size());
        }
        this.seq = aSN1Sequence;
        int i = 0;
        if (aSN1Sequence.getObjectAt(0) instanceof DERInteger) {
            this.version = DERInteger.getInstance(aSN1Sequence.getObjectAt(0));
            i = 1;
        } else {
            this.version = new DERInteger(0);
        }
        int i2 = i + 1;
        this.signature = AlgorithmIdentifier.getInstance(aSN1Sequence.getObjectAt(i));
        int i3 = i2 + 1;
        this.issuer = X509Name.getInstance(aSN1Sequence.getObjectAt(i2));
        int i4 = i3 + 1;
        this.thisUpdate = Time.getInstance(aSN1Sequence.getObjectAt(i3));
        if (i4 < aSN1Sequence.size() && ((aSN1Sequence.getObjectAt(i4) instanceof DERUTCTime) || (aSN1Sequence.getObjectAt(i4) instanceof DERGeneralizedTime) || (aSN1Sequence.getObjectAt(i4) instanceof Time))) {
            this.nextUpdate = Time.getInstance(aSN1Sequence.getObjectAt(i4));
            i4++;
        }
        if (i4 < aSN1Sequence.size() && !(aSN1Sequence.getObjectAt(i4) instanceof DERTaggedObject)) {
            this.revokedCertificates = ASN1Sequence.getInstance(aSN1Sequence.getObjectAt(i4));
            i4++;
        }
        if (i4 < aSN1Sequence.size() && (aSN1Sequence.getObjectAt(i4) instanceof DERTaggedObject)) {
            this.crlExtensions = X509Extensions.getInstance(aSN1Sequence.getObjectAt(i4));
        }
    }

    public static TBSCertList getInstance(Object obj) {
        if (obj instanceof TBSCertList) {
            return (TBSCertList) obj;
        }
        if (obj instanceof ASN1Sequence) {
            return new TBSCertList((ASN1Sequence) obj);
        }
        throw new IllegalArgumentException("unknown object in factory: " + obj.getClass().getName());
    }

    public static TBSCertList getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return getInstance(ASN1Sequence.getInstance(aSN1TaggedObject, z));
    }

    public X509Extensions getExtensions() {
        return this.crlExtensions;
    }

    public X509Name getIssuer() {
        return this.issuer;
    }

    public Time getNextUpdate() {
        return this.nextUpdate;
    }

    public Enumeration getRevokedCertificateEnumeration() {
        ASN1Sequence aSN1Sequence = this.revokedCertificates;
        return aSN1Sequence == null ? new EmptyEnumeration() : new RevokedCertificatesEnumeration(aSN1Sequence.getObjects());
    }

    public CRLEntry[] getRevokedCertificates() {
        ASN1Sequence aSN1Sequence = this.revokedCertificates;
        if (aSN1Sequence == null) {
            return new CRLEntry[0];
        }
        int size = aSN1Sequence.size();
        CRLEntry[] cRLEntryArr = new CRLEntry[size];
        for (int i = 0; i < size; i++) {
            cRLEntryArr[i] = new CRLEntry(ASN1Sequence.getInstance(this.revokedCertificates.getObjectAt(i)));
        }
        return cRLEntryArr;
    }

    public AlgorithmIdentifier getSignature() {
        return this.signature;
    }

    public Time getThisUpdate() {
        return this.thisUpdate;
    }

    public int getVersion() {
        return this.version.getValue().intValue() + 1;
    }

    public DERInteger getVersionNumber() {
        return this.version;
    }

    @Override // org.bouncycastle.asn1.ASN1Encodable
    public DERObject toASN1Object() {
        return this.seq;
    }
}
