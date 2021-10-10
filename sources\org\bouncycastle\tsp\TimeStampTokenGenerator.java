package org.bouncycastle.tsp;

import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.cert.CRL;
import java.security.cert.CRLException;
import java.security.cert.CertStore;
import java.security.cert.CertStoreException;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.security.cert.X509CRL;
import java.security.cert.X509Certificate;
import java.security.interfaces.DSAPrivateKey;
import java.security.interfaces.RSAPrivateKey;
import java.util.ArrayList;
import java.util.Date;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.DERBoolean;
import org.bouncycastle.asn1.DERGeneralizedTime;
import org.bouncycastle.asn1.DERInteger;
import org.bouncycastle.asn1.DERNull;
import org.bouncycastle.asn1.DERSet;
import org.bouncycastle.asn1.cms.Attribute;
import org.bouncycastle.asn1.cms.AttributeTable;
import org.bouncycastle.asn1.ess.ESSCertID;
import org.bouncycastle.asn1.ess.SigningCertificate;
import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.asn1.tsp.Accuracy;
import org.bouncycastle.asn1.tsp.MessageImprint;
import org.bouncycastle.asn1.tsp.TSTInfo;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.asn1.x509.GeneralName;
import org.bouncycastle.cert.jcajce.JcaX509CRLHolder;
import org.bouncycastle.cert.jcajce.JcaX509CertificateHolder;
import org.bouncycastle.cms.CMSAttributeTableGenerationException;
import org.bouncycastle.cms.CMSAttributeTableGenerator;
import org.bouncycastle.cms.CMSException;
import org.bouncycastle.cms.CMSProcessableByteArray;
import org.bouncycastle.cms.CMSSignedDataGenerator;
import org.bouncycastle.cms.CMSSignedGenerator;
import org.bouncycastle.cms.CMSTypedData;
import org.bouncycastle.cms.DefaultSignedAttributeTableGenerator;
import org.bouncycastle.cms.SignerInfoGenerator;
import org.bouncycastle.cms.SimpleAttributeTableGenerator;
import org.bouncycastle.cms.jcajce.JcaSignerInfoGeneratorBuilder;
import org.bouncycastle.jce.interfaces.GOST3410PrivateKey;
import org.bouncycastle.operator.OperatorCreationException;
import org.bouncycastle.operator.jcajce.JcaContentSignerBuilder;
import org.bouncycastle.operator.jcajce.JcaDigestCalculatorProviderBuilder;
import org.bouncycastle.util.CollectionStore;
import org.bouncycastle.util.Store;

public class TimeStampTokenGenerator {
    int accuracyMicros;
    int accuracyMillis;
    int accuracySeconds;
    private List attrCerts;
    X509Certificate cert;
    private List certs;
    CertStore certsAndCrls;
    private List crls;
    String digestOID;
    PrivateKey key;
    boolean ordering;
    AttributeTable signedAttr;
    private SignerInfoGenerator signerInfoGen;
    GeneralName tsa;
    private String tsaPolicyOID;
    AttributeTable unsignedAttr;

    public TimeStampTokenGenerator(PrivateKey privateKey, X509Certificate x509Certificate, String str, String str2) throws IllegalArgumentException, TSPException {
        this(privateKey, x509Certificate, str, str2, null, null);
    }

    public TimeStampTokenGenerator(PrivateKey privateKey, X509Certificate x509Certificate, String str, String str2, AttributeTable attributeTable, AttributeTable attributeTable2) throws IllegalArgumentException, TSPException {
        this.accuracySeconds = -1;
        this.accuracyMillis = -1;
        this.accuracyMicros = -1;
        this.ordering = false;
        this.tsa = null;
        this.certs = new ArrayList();
        this.crls = new ArrayList();
        this.attrCerts = new ArrayList();
        this.key = privateKey;
        this.cert = x509Certificate;
        this.digestOID = str;
        this.tsaPolicyOID = str2;
        this.unsignedAttr = attributeTable2;
        Hashtable hashtable = attributeTable != null ? attributeTable.toHashtable() : new Hashtable();
        TSPUtil.validateCertificate(x509Certificate);
        try {
            hashtable.put(PKCSObjectIdentifiers.id_aa_signingCertificate, new Attribute(PKCSObjectIdentifiers.id_aa_signingCertificate, new DERSet(new SigningCertificate(new ESSCertID(MessageDigest.getInstance("SHA-1").digest(x509Certificate.getEncoded()))))));
            this.signedAttr = new AttributeTable(hashtable);
        } catch (NoSuchAlgorithmException e) {
            throw new TSPException("Can't find a SHA-1 implementation.", e);
        } catch (CertificateEncodingException e2) {
            throw new TSPException("Exception processing certificate.", e2);
        }
    }

    public TimeStampTokenGenerator(final SignerInfoGenerator signerInfoGenerator, ASN1ObjectIdentifier aSN1ObjectIdentifier) throws IllegalArgumentException, TSPException {
        this.accuracySeconds = -1;
        this.accuracyMillis = -1;
        this.accuracyMicros = -1;
        this.ordering = false;
        this.tsa = null;
        this.certs = new ArrayList();
        this.crls = new ArrayList();
        this.attrCerts = new ArrayList();
        this.signerInfoGen = signerInfoGenerator;
        this.tsaPolicyOID = aSN1ObjectIdentifier.getId();
        if (signerInfoGenerator.hasAssociatedCertificate()) {
            TSPUtil.validateCertificate(signerInfoGenerator.getAssociatedCertificate());
            try {
                final ESSCertID eSSCertID = new ESSCertID(MessageDigest.getInstance("SHA-1").digest(signerInfoGenerator.getAssociatedCertificate().getEncoded()));
                this.signerInfoGen = new SignerInfoGenerator(signerInfoGenerator, new CMSAttributeTableGenerator() {
                    /* class org.bouncycastle.tsp.TimeStampTokenGenerator.AnonymousClass1 */

                    @Override // org.bouncycastle.cms.CMSAttributeTableGenerator
                    public AttributeTable getAttributes(Map map) throws CMSAttributeTableGenerationException {
                        return signerInfoGenerator.getSignedAttributeTableGenerator().getAttributes(map).add(PKCSObjectIdentifiers.id_aa_signingCertificate, new SigningCertificate(eSSCertID));
                    }
                }, signerInfoGenerator.getUnsignedAttributeTableGenerator());
            } catch (NoSuchAlgorithmException e) {
                throw new TSPException("Can't find a SHA-1 implementation.", e);
            } catch (IOException e2) {
                throw new TSPException("Exception processing certificate.", e2);
            }
        } else {
            throw new IllegalArgumentException("SignerInfoGenerator must have an associated certificate");
        }
    }

    private String getSigAlgorithm(PrivateKey privateKey, String str) {
        String str2 = "GOST3410";
        if ((privateKey instanceof RSAPrivateKey) || "RSA".equalsIgnoreCase(privateKey.getAlgorithm())) {
            str2 = "RSA";
        } else if ((privateKey instanceof DSAPrivateKey) || "DSA".equalsIgnoreCase(privateKey.getAlgorithm())) {
            str2 = "DSA";
        } else if ("ECDSA".equalsIgnoreCase(privateKey.getAlgorithm()) || "EC".equalsIgnoreCase(privateKey.getAlgorithm())) {
            str2 = "ECDSA";
        } else if (!(privateKey instanceof GOST3410PrivateKey) && !str2.equalsIgnoreCase(privateKey.getAlgorithm())) {
            str2 = "ECGOST3410".equalsIgnoreCase(privateKey.getAlgorithm()) ? CMSSignedGenerator.ENCRYPTION_ECGOST3410 : null;
        }
        return TSPUtil.getDigestAlgName(str) + "with" + str2;
    }

    public void addAttributeCertificates(Store store) {
        this.attrCerts.addAll(store.getMatches(null));
    }

    public void addCRLs(Store store) {
        this.crls.addAll(store.getMatches(null));
    }

    public void addCertificates(Store store) {
        this.certs.addAll(store.getMatches(null));
    }

    public TimeStampToken generate(TimeStampRequest timeStampRequest, BigInteger bigInteger, Date date) throws TSPException {
        Accuracy accuracy;
        if (this.signerInfoGen != null) {
            MessageImprint messageImprint = new MessageImprint(new AlgorithmIdentifier(new ASN1ObjectIdentifier(timeStampRequest.getMessageImprintAlgOID()), new DERNull()), timeStampRequest.getMessageImprintDigest());
            int i = this.accuracySeconds;
            if (i > 0 || this.accuracyMillis > 0 || this.accuracyMicros > 0) {
                DERInteger dERInteger = i > 0 ? new DERInteger(i) : null;
                int i2 = this.accuracyMillis;
                DERInteger dERInteger2 = i2 > 0 ? new DERInteger(i2) : null;
                int i3 = this.accuracyMicros;
                accuracy = new Accuracy(dERInteger, dERInteger2, i3 > 0 ? new DERInteger(i3) : null);
            } else {
                accuracy = null;
            }
            boolean z = this.ordering;
            DERBoolean dERBoolean = z ? new DERBoolean(z) : null;
            DERInteger dERInteger3 = timeStampRequest.getNonce() != null ? new DERInteger(timeStampRequest.getNonce()) : null;
            ASN1ObjectIdentifier aSN1ObjectIdentifier = new ASN1ObjectIdentifier(this.tsaPolicyOID);
            if (timeStampRequest.getReqPolicy() != null) {
                aSN1ObjectIdentifier = new ASN1ObjectIdentifier(timeStampRequest.getReqPolicy());
            }
            TSTInfo tSTInfo = new TSTInfo(aSN1ObjectIdentifier, messageImprint, new DERInteger(bigInteger), new DERGeneralizedTime(date), accuracy, dERBoolean, dERInteger3, this.tsa, timeStampRequest.getExtensions());
            try {
                CMSSignedDataGenerator cMSSignedDataGenerator = new CMSSignedDataGenerator();
                if (timeStampRequest.getCertReq()) {
                    cMSSignedDataGenerator.addCertificates(new CollectionStore(this.certs));
                    cMSSignedDataGenerator.addCRLs(new CollectionStore(this.crls));
                    cMSSignedDataGenerator.addAttributeCertificates(new CollectionStore(this.attrCerts));
                } else {
                    cMSSignedDataGenerator.addCRLs(new CollectionStore(this.crls));
                }
                cMSSignedDataGenerator.addSignerInfoGenerator(this.signerInfoGen);
                return new TimeStampToken(cMSSignedDataGenerator.generate((CMSTypedData) new CMSProcessableByteArray(PKCSObjectIdentifiers.id_ct_TSTInfo, tSTInfo.getEncoded(ASN1Encodable.DER)), true));
            } catch (CMSException e) {
                throw new TSPException("Error generating time-stamp token", e);
            } catch (IOException e2) {
                throw new TSPException("Exception encoding info", e2);
            }
        } else {
            throw new IllegalStateException("can only use this method with SignerInfoGenerator constructor");
        }
    }

    public TimeStampToken generate(TimeStampRequest timeStampRequest, BigInteger bigInteger, Date date, String str) throws NoSuchAlgorithmException, NoSuchProviderException, TSPException {
        if (this.signerInfoGen == null) {
            try {
                JcaSignerInfoGeneratorBuilder jcaSignerInfoGeneratorBuilder = new JcaSignerInfoGeneratorBuilder(new JcaDigestCalculatorProviderBuilder().setProvider(str).build());
                jcaSignerInfoGeneratorBuilder.setSignedAttributeGenerator(new DefaultSignedAttributeTableGenerator(this.signedAttr));
                AttributeTable attributeTable = this.unsignedAttr;
                if (attributeTable != null) {
                    jcaSignerInfoGeneratorBuilder.setUnsignedAttributeGenerator(new SimpleAttributeTableGenerator(attributeTable));
                }
                this.signerInfoGen = jcaSignerInfoGeneratorBuilder.build(new JcaContentSignerBuilder(getSigAlgorithm(this.key, this.digestOID)).setProvider(str).build(this.key), this.cert);
            } catch (OperatorCreationException e) {
                throw new TSPException("Error generating signing operator", e);
            } catch (CertificateEncodingException e2) {
                throw new TSPException("Error encoding certificate", e2);
            }
        }
        return generate(timeStampRequest, bigInteger, date);
    }

    public void setAccuracyMicros(int i) {
        this.accuracyMicros = i;
    }

    public void setAccuracyMillis(int i) {
        this.accuracyMillis = i;
    }

    public void setAccuracySeconds(int i) {
        this.accuracySeconds = i;
    }

    public void setCertificatesAndCRLs(CertStore certStore) throws CertStoreException, TSPException {
        Iterator<? extends Certificate> it = certStore.getCertificates(null).iterator();
        while (it.hasNext()) {
            try {
                this.certs.add(new JcaX509CertificateHolder((X509Certificate) it.next()));
            } catch (CertificateEncodingException e) {
                throw new TSPException("cannot encode certificate: " + e.getMessage(), e);
            }
        }
        Iterator<? extends CRL> it2 = certStore.getCRLs(null).iterator();
        while (it2.hasNext()) {
            try {
                this.crls.add(new JcaX509CRLHolder((X509CRL) it2.next()));
            } catch (CRLException e2) {
                throw new TSPException("cannot encode CRL: " + e2.getMessage(), e2);
            }
        }
    }

    public void setOrdering(boolean z) {
        this.ordering = z;
    }

    public void setTSA(GeneralName generalName) {
        this.tsa = generalName;
    }
}
