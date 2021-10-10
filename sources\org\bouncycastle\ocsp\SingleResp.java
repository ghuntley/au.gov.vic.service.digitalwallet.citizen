package org.bouncycastle.ocsp;

import java.security.cert.X509Extension;
import java.text.ParseException;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Set;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.DERObjectIdentifier;
import org.bouncycastle.asn1.ocsp.CertStatus;
import org.bouncycastle.asn1.ocsp.RevokedInfo;
import org.bouncycastle.asn1.ocsp.SingleResponse;
import org.bouncycastle.asn1.x509.X509Extensions;

public class SingleResp implements X509Extension {
    SingleResponse resp;

    public SingleResp(SingleResponse singleResponse) {
        this.resp = singleResponse;
    }

    private Set getExtensionOIDs(boolean z) {
        HashSet hashSet = new HashSet();
        X509Extensions singleExtensions = getSingleExtensions();
        if (singleExtensions != null) {
            Enumeration oids = singleExtensions.oids();
            while (oids.hasMoreElements()) {
                DERObjectIdentifier dERObjectIdentifier = (DERObjectIdentifier) oids.nextElement();
                if (z == singleExtensions.getExtension(dERObjectIdentifier).isCritical()) {
                    hashSet.add(dERObjectIdentifier.getId());
                }
            }
        }
        return hashSet;
    }

    public CertificateID getCertID() {
        return new CertificateID(this.resp.getCertID());
    }

    public Object getCertStatus() {
        CertStatus certStatus = this.resp.getCertStatus();
        if (certStatus.getTagNo() == 0) {
            return null;
        }
        return certStatus.getTagNo() == 1 ? new RevokedStatus(RevokedInfo.getInstance(certStatus.getStatus())) : new UnknownStatus();
    }

    @Override // java.security.cert.X509Extension
    public Set getCriticalExtensionOIDs() {
        return getExtensionOIDs(true);
    }

    public byte[] getExtensionValue(String str) {
        org.bouncycastle.asn1.x509.X509Extension extension;
        X509Extensions singleExtensions = getSingleExtensions();
        if (singleExtensions == null || (extension = singleExtensions.getExtension(new DERObjectIdentifier(str))) == null) {
            return null;
        }
        try {
            return extension.getValue().getEncoded(ASN1Encodable.DER);
        } catch (Exception e) {
            throw new RuntimeException("error encoding " + e.toString());
        }
    }

    public Date getNextUpdate() {
        if (this.resp.getNextUpdate() == null) {
            return null;
        }
        try {
            return this.resp.getNextUpdate().getDate();
        } catch (ParseException e) {
            throw new IllegalStateException("ParseException: " + e.getMessage());
        }
    }

    @Override // java.security.cert.X509Extension
    public Set getNonCriticalExtensionOIDs() {
        return getExtensionOIDs(false);
    }

    public X509Extensions getSingleExtensions() {
        return this.resp.getSingleExtensions();
    }

    public Date getThisUpdate() {
        try {
            return this.resp.getThisUpdate().getDate();
        } catch (ParseException e) {
            throw new IllegalStateException("ParseException: " + e.getMessage());
        }
    }

    public boolean hasUnsupportedCriticalExtension() {
        Set criticalExtensionOIDs = getCriticalExtensionOIDs();
        return criticalExtensionOIDs != null && !criticalExtensionOIDs.isEmpty();
    }
}
