package org.bouncycastle.tsp;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.security.NoSuchProviderException;
import java.security.cert.X509Extension;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.bouncycastle.asn1.ASN1InputStream;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.DERObjectIdentifier;
import org.bouncycastle.asn1.tsp.TimeStampReq;
import org.bouncycastle.asn1.x509.X509Extensions;

public class TimeStampRequest implements X509Extension {
    private X509Extensions extensions;
    private TimeStampReq req;

    public TimeStampRequest(InputStream inputStream) throws IOException {
        try {
            this.req = TimeStampReq.getInstance(new ASN1InputStream(inputStream).readObject());
        } catch (ClassCastException e) {
            throw new IOException("malformed request: " + e);
        } catch (IllegalArgumentException e2) {
            throw new IOException("malformed request: " + e2);
        }
    }

    public TimeStampRequest(TimeStampReq timeStampReq) {
        this.req = timeStampReq;
        this.extensions = timeStampReq.getExtensions();
    }

    public TimeStampRequest(byte[] bArr) throws IOException {
        this(new ByteArrayInputStream(bArr));
    }

    private Set getExtensionOIDS(boolean z) {
        HashSet hashSet = new HashSet();
        X509Extensions extensions2 = this.req.getExtensions();
        if (extensions2 == null) {
            return null;
        }
        Enumeration oids = extensions2.oids();
        while (oids.hasMoreElements()) {
            DERObjectIdentifier dERObjectIdentifier = (DERObjectIdentifier) oids.nextElement();
            if (extensions2.getExtension(dERObjectIdentifier).isCritical() == z) {
                hashSet.add(dERObjectIdentifier.getId());
            }
        }
        return hashSet;
    }

    public boolean getCertReq() {
        if (this.req.getCertReq() != null) {
            return this.req.getCertReq().isTrue();
        }
        return false;
    }

    @Override // java.security.cert.X509Extension
    public Set getCriticalExtensionOIDs() {
        return getExtensionOIDS(true);
    }

    public byte[] getEncoded() throws IOException {
        return this.req.getEncoded();
    }

    public org.bouncycastle.asn1.x509.X509Extension getExtension(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        X509Extensions x509Extensions = this.extensions;
        if (x509Extensions != null) {
            return x509Extensions.getExtension(aSN1ObjectIdentifier);
        }
        return null;
    }

    public List getExtensionOIDs() {
        return TSPUtil.getExtensionOIDs(this.extensions);
    }

    public byte[] getExtensionValue(String str) {
        org.bouncycastle.asn1.x509.X509Extension extension;
        X509Extensions extensions2 = this.req.getExtensions();
        if (extensions2 == null || (extension = extensions2.getExtension(new DERObjectIdentifier(str))) == null) {
            return null;
        }
        try {
            return extension.getValue().getEncoded();
        } catch (Exception e) {
            throw new RuntimeException("error encoding " + e.toString());
        }
    }

    /* access modifiers changed from: package-private */
    public X509Extensions getExtensions() {
        return this.extensions;
    }

    public String getMessageImprintAlgOID() {
        return this.req.getMessageImprint().getHashAlgorithm().getObjectId().getId();
    }

    public byte[] getMessageImprintDigest() {
        return this.req.getMessageImprint().getHashedMessage();
    }

    @Override // java.security.cert.X509Extension
    public Set getNonCriticalExtensionOIDs() {
        return getExtensionOIDS(false);
    }

    public BigInteger getNonce() {
        if (this.req.getNonce() != null) {
            return this.req.getNonce().getValue();
        }
        return null;
    }

    public String getReqPolicy() {
        if (this.req.getReqPolicy() != null) {
            return this.req.getReqPolicy().getId();
        }
        return null;
    }

    public int getVersion() {
        return this.req.getVersion().getValue().intValue();
    }

    public boolean hasExtensions() {
        return this.extensions != null;
    }

    public boolean hasUnsupportedCriticalExtension() {
        return false;
    }

    public void validate(Set set, Set set2, Set set3) throws TSPException {
        if (!set.contains(getMessageImprintAlgOID())) {
            throw new TSPValidationException("request contains unknown algorithm.", 128);
        } else if (set2 == null || getReqPolicy() == null || set2.contains(getReqPolicy())) {
            if (!(getExtensions() == null || set3 == null)) {
                Enumeration oids = getExtensions().oids();
                while (oids.hasMoreElements()) {
                    if (!set3.contains(((DERObjectIdentifier) oids.nextElement()).getId())) {
                        throw new TSPValidationException("request contains unknown extension.", 8388608);
                    }
                }
            }
            if (TSPUtil.getDigestLength(getMessageImprintAlgOID()) != getMessageImprintDigest().length) {
                throw new TSPValidationException("imprint digest the wrong length.", 4);
            }
        } else {
            throw new TSPValidationException("request contains unknown policy.", 256);
        }
    }

    public void validate(Set set, Set set2, Set set3, String str) throws TSPException, NoSuchProviderException {
        if (!set.contains(getMessageImprintAlgOID())) {
            throw new TSPValidationException("request contains unknown algorithm.", 128);
        } else if (set2 == null || getReqPolicy() == null || set2.contains(getReqPolicy())) {
            if (!(getExtensions() == null || set3 == null)) {
                Enumeration oids = getExtensions().oids();
                while (oids.hasMoreElements()) {
                    if (!set3.contains(((DERObjectIdentifier) oids.nextElement()).getId())) {
                        throw new TSPValidationException("request contains unknown extension.", 8388608);
                    }
                }
            }
            if (TSPUtil.getDigestLength(getMessageImprintAlgOID()) != getMessageImprintDigest().length) {
                throw new TSPValidationException("imprint digest the wrong length.", 4);
            }
        } else {
            throw new TSPValidationException("request contains unknown policy.", 256);
        }
    }
}
