package org.bouncycastle.asn1.x509;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Vector;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERGeneralizedTime;
import org.bouncycastle.asn1.DERInteger;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERTaggedObject;
import org.bouncycastle.asn1.DERUTCTime;
import org.bouncycastle.asn1.x500.X500Name;

public class V2TBSCertListGenerator {
    private Vector crlentries = null;
    X509Extensions extensions = null;
    X509Name issuer;
    Time nextUpdate = null;
    AlgorithmIdentifier signature;
    Time thisUpdate;
    DERInteger version = new DERInteger(1);

    public void addCRLEntry(ASN1Sequence aSN1Sequence) {
        if (this.crlentries == null) {
            this.crlentries = new Vector();
        }
        this.crlentries.addElement(aSN1Sequence);
    }

    public void addCRLEntry(DERInteger dERInteger, DERUTCTime dERUTCTime, int i) {
        addCRLEntry(dERInteger, new Time(dERUTCTime), i);
    }

    public void addCRLEntry(DERInteger dERInteger, Time time, int i) {
        addCRLEntry(dERInteger, time, i, null);
    }

    public void addCRLEntry(DERInteger dERInteger, Time time, int i, DERGeneralizedTime dERGeneralizedTime) {
        Vector vector = new Vector();
        Vector vector2 = new Vector();
        if (i != 0) {
            CRLReason cRLReason = new CRLReason(i);
            try {
                vector.addElement(X509Extension.reasonCode);
                vector2.addElement(new X509Extension(false, (ASN1OctetString) new DEROctetString(cRLReason.getEncoded())));
            } catch (IOException e) {
                throw new IllegalArgumentException("error encoding reason: " + e);
            }
        }
        if (dERGeneralizedTime != null) {
            try {
                vector.addElement(X509Extension.invalidityDate);
                vector2.addElement(new X509Extension(false, (ASN1OctetString) new DEROctetString(dERGeneralizedTime.getEncoded())));
            } catch (IOException e2) {
                throw new IllegalArgumentException("error encoding invalidityDate: " + e2);
            }
        }
        addCRLEntry(dERInteger, time, vector.size() != 0 ? new X509Extensions(vector, vector2) : null);
    }

    public void addCRLEntry(DERInteger dERInteger, Time time, X509Extensions x509Extensions) {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(dERInteger);
        aSN1EncodableVector.add(time);
        if (x509Extensions != null) {
            aSN1EncodableVector.add(x509Extensions);
        }
        addCRLEntry(new DERSequence(aSN1EncodableVector));
    }

    public TBSCertList generateTBSCertList() {
        if (this.signature == null || this.issuer == null || this.thisUpdate == null) {
            throw new IllegalStateException("Not all mandatory fields set in V2 TBSCertList generator.");
        }
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(this.version);
        aSN1EncodableVector.add(this.signature);
        aSN1EncodableVector.add(this.issuer);
        aSN1EncodableVector.add(this.thisUpdate);
        Time time = this.nextUpdate;
        if (time != null) {
            aSN1EncodableVector.add(time);
        }
        if (this.crlentries != null) {
            ASN1EncodableVector aSN1EncodableVector2 = new ASN1EncodableVector();
            Enumeration elements = this.crlentries.elements();
            while (elements.hasMoreElements()) {
                aSN1EncodableVector2.add((ASN1Sequence) elements.nextElement());
            }
            aSN1EncodableVector.add(new DERSequence(aSN1EncodableVector2));
        }
        if (this.extensions != null) {
            aSN1EncodableVector.add(new DERTaggedObject(0, this.extensions));
        }
        return new TBSCertList(new DERSequence(aSN1EncodableVector));
    }

    public void setExtensions(X509Extensions x509Extensions) {
        this.extensions = x509Extensions;
    }

    public void setIssuer(X500Name x500Name) {
        this.issuer = X509Name.getInstance(x500Name);
    }

    public void setIssuer(X509Name x509Name) {
        this.issuer = x509Name;
    }

    public void setNextUpdate(DERUTCTime dERUTCTime) {
        this.nextUpdate = new Time(dERUTCTime);
    }

    public void setNextUpdate(Time time) {
        this.nextUpdate = time;
    }

    public void setSignature(AlgorithmIdentifier algorithmIdentifier) {
        this.signature = algorithmIdentifier;
    }

    public void setThisUpdate(DERUTCTime dERUTCTime) {
        this.thisUpdate = new Time(dERUTCTime);
    }

    public void setThisUpdate(Time time) {
        this.thisUpdate = time;
    }
}
