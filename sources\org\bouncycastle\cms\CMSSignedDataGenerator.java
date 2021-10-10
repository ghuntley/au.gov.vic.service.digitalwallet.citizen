package org.bouncycastle.cms;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.Provider;
import java.security.SecureRandom;
import java.security.Signature;
import java.security.SignatureException;
import java.security.cert.CertificateEncodingException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Set;
import org.bouncycastle.asn1.BERConstructedOctetString;
import org.bouncycastle.asn1.DERNull;
import org.bouncycastle.asn1.DERObjectIdentifier;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.DEROutputStream;
import org.bouncycastle.asn1.DERSet;
import org.bouncycastle.asn1.cms.AttributeTable;
import org.bouncycastle.asn1.cms.CMSAttributes;
import org.bouncycastle.asn1.cms.CMSObjectIdentifiers;
import org.bouncycastle.asn1.cms.ContentInfo;
import org.bouncycastle.asn1.cms.SignedData;
import org.bouncycastle.asn1.cms.SignerIdentifier;
import org.bouncycastle.asn1.cms.SignerInfo;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;

public class CMSSignedDataGenerator extends CMSSignedGenerator {
    private List signerInfs = new ArrayList();

    /* access modifiers changed from: private */
    public class SignerInf {
        final AttributeTable baseSignedTable;
        final String digestOID;
        final String encOID;
        final PrivateKey key;
        final CMSAttributeTableGenerator sAttr;
        final SignerIdentifier signerIdentifier;
        final CMSAttributeTableGenerator unsAttr;

        SignerInf(PrivateKey privateKey, SignerIdentifier signerIdentifier2, String str, String str2, CMSAttributeTableGenerator cMSAttributeTableGenerator, CMSAttributeTableGenerator cMSAttributeTableGenerator2, AttributeTable attributeTable) {
            this.key = privateKey;
            this.signerIdentifier = signerIdentifier2;
            this.digestOID = str;
            this.encOID = str2;
            this.sAttr = cMSAttributeTableGenerator;
            this.unsAttr = cMSAttributeTableGenerator2;
            this.baseSignedTable = attributeTable;
        }

        /* access modifiers changed from: package-private */
        public AlgorithmIdentifier getDigestAlgorithmID() {
            return new AlgorithmIdentifier(new DERObjectIdentifier(this.digestOID), new DERNull());
        }

        /* access modifiers changed from: package-private */
        public SignerInfo toSignerInfo(DERObjectIdentifier dERObjectIdentifier, CMSProcessable cMSProcessable, SecureRandom secureRandom, Provider provider, boolean z) throws IOException, SignatureException, InvalidKeyException, NoSuchAlgorithmException, CertificateEncodingException, CMSException {
            AttributeTable attributeTable;
            ASN1Set aSN1Set;
            ASN1Set aSN1Set2;
            AlgorithmIdentifier digestAlgorithmID = getDigestAlgorithmID();
            String digestAlgName = CMSSignedHelper.INSTANCE.getDigestAlgName(this.digestOID);
            Signature signatureInstance = CMSSignedHelper.INSTANCE.getSignatureInstance(digestAlgName + "with" + CMSSignedHelper.INSTANCE.getEncryptionAlgName(this.encOID), provider);
            MessageDigest digestInstance = CMSSignedHelper.INSTANCE.getDigestInstance(digestAlgName, provider);
            AlgorithmIdentifier encAlgorithmIdentifier = CMSSignedDataGenerator.this.getEncAlgorithmIdentifier(this.encOID, signatureInstance);
            if (cMSProcessable != null) {
                cMSProcessable.write(new DigOutputStream(digestInstance));
            }
            byte[] digest = digestInstance.digest();
            CMSSignedDataGenerator.this.digests.put(this.digestOID, digest.clone());
            if (z) {
                Map baseParameters = CMSSignedDataGenerator.this.getBaseParameters(dERObjectIdentifier, digestAlgorithmID, digest);
                CMSAttributeTableGenerator cMSAttributeTableGenerator = this.sAttr;
                attributeTable = cMSAttributeTableGenerator != null ? cMSAttributeTableGenerator.getAttributes(Collections.unmodifiableMap(baseParameters)) : null;
            } else {
                attributeTable = this.baseSignedTable;
            }
            signatureInstance.initSign(this.key, secureRandom);
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new SigOutputStream(signatureInstance));
            if (attributeTable != null) {
                if (dERObjectIdentifier == null && attributeTable.get(CMSAttributes.contentType) != null) {
                    Hashtable hashtable = attributeTable.toHashtable();
                    hashtable.remove(CMSAttributes.contentType);
                    attributeTable = new AttributeTable(hashtable);
                }
                ASN1Set attributeSet = CMSSignedDataGenerator.this.getAttributeSet(attributeTable);
                new DEROutputStream(bufferedOutputStream).writeObject(attributeSet);
                aSN1Set = attributeSet;
            } else {
                if (cMSProcessable != null) {
                    cMSProcessable.write(bufferedOutputStream);
                }
                aSN1Set = null;
            }
            bufferedOutputStream.close();
            byte[] sign = signatureInstance.sign();
            if (this.unsAttr != null) {
                Map baseParameters2 = CMSSignedDataGenerator.this.getBaseParameters(dERObjectIdentifier, digestAlgorithmID, digest);
                baseParameters2.put(CMSAttributeTableGenerator.SIGNATURE, sign.clone());
                aSN1Set2 = CMSSignedDataGenerator.this.getAttributeSet(this.unsAttr.getAttributes(Collections.unmodifiableMap(baseParameters2)));
            } else {
                aSN1Set2 = null;
            }
            return new SignerInfo(this.signerIdentifier, digestAlgorithmID, aSN1Set, encAlgorithmIdentifier, new DEROctetString(sign), aSN1Set2);
        }
    }

    public CMSSignedDataGenerator() {
    }

    public CMSSignedDataGenerator(SecureRandom secureRandom) {
        super(secureRandom);
    }

    private void doAddSigner(PrivateKey privateKey, SignerIdentifier signerIdentifier, String str, String str2, CMSAttributeTableGenerator cMSAttributeTableGenerator, CMSAttributeTableGenerator cMSAttributeTableGenerator2, AttributeTable attributeTable) throws IllegalArgumentException {
        this.signerInfs.add(new SignerInf(privateKey, signerIdentifier, str2, str, cMSAttributeTableGenerator, cMSAttributeTableGenerator2, attributeTable));
    }

    public void addSigner(PrivateKey privateKey, X509Certificate x509Certificate, String str) throws IllegalArgumentException {
        addSigner(privateKey, x509Certificate, getEncOID(privateKey, str), str);
    }

    public void addSigner(PrivateKey privateKey, X509Certificate x509Certificate, String str, String str2) throws IllegalArgumentException {
        doAddSigner(privateKey, getSignerIdentifier(x509Certificate), str, str2, new DefaultSignedAttributeTableGenerator(), null, null);
    }

    public void addSigner(PrivateKey privateKey, X509Certificate x509Certificate, String str, String str2, AttributeTable attributeTable, AttributeTable attributeTable2) throws IllegalArgumentException {
        doAddSigner(privateKey, getSignerIdentifier(x509Certificate), str, str2, new DefaultSignedAttributeTableGenerator(attributeTable), new SimpleAttributeTableGenerator(attributeTable2), attributeTable);
    }

    public void addSigner(PrivateKey privateKey, X509Certificate x509Certificate, String str, String str2, CMSAttributeTableGenerator cMSAttributeTableGenerator, CMSAttributeTableGenerator cMSAttributeTableGenerator2) throws IllegalArgumentException {
        doAddSigner(privateKey, getSignerIdentifier(x509Certificate), str, str2, cMSAttributeTableGenerator, cMSAttributeTableGenerator2, null);
    }

    public void addSigner(PrivateKey privateKey, X509Certificate x509Certificate, String str, AttributeTable attributeTable, AttributeTable attributeTable2) throws IllegalArgumentException {
        addSigner(privateKey, x509Certificate, getEncOID(privateKey, str), str, attributeTable, attributeTable2);
    }

    public void addSigner(PrivateKey privateKey, X509Certificate x509Certificate, String str, CMSAttributeTableGenerator cMSAttributeTableGenerator, CMSAttributeTableGenerator cMSAttributeTableGenerator2) throws IllegalArgumentException {
        addSigner(privateKey, x509Certificate, getEncOID(privateKey, str), str, cMSAttributeTableGenerator, cMSAttributeTableGenerator2);
    }

    public void addSigner(PrivateKey privateKey, byte[] bArr, String str) throws IllegalArgumentException {
        addSigner(privateKey, bArr, getEncOID(privateKey, str), str);
    }

    public void addSigner(PrivateKey privateKey, byte[] bArr, String str, String str2) throws IllegalArgumentException {
        doAddSigner(privateKey, getSignerIdentifier(bArr), str, str2, new DefaultSignedAttributeTableGenerator(), null, null);
    }

    public void addSigner(PrivateKey privateKey, byte[] bArr, String str, String str2, AttributeTable attributeTable, AttributeTable attributeTable2) throws IllegalArgumentException {
        doAddSigner(privateKey, getSignerIdentifier(bArr), str, str2, new DefaultSignedAttributeTableGenerator(attributeTable), new SimpleAttributeTableGenerator(attributeTable2), attributeTable);
    }

    public void addSigner(PrivateKey privateKey, byte[] bArr, String str, String str2, CMSAttributeTableGenerator cMSAttributeTableGenerator, CMSAttributeTableGenerator cMSAttributeTableGenerator2) throws IllegalArgumentException {
        doAddSigner(privateKey, getSignerIdentifier(bArr), str, str2, cMSAttributeTableGenerator, cMSAttributeTableGenerator2, null);
    }

    public void addSigner(PrivateKey privateKey, byte[] bArr, String str, AttributeTable attributeTable, AttributeTable attributeTable2) throws IllegalArgumentException {
        addSigner(privateKey, bArr, getEncOID(privateKey, str), str, attributeTable, attributeTable2);
    }

    public void addSigner(PrivateKey privateKey, byte[] bArr, String str, CMSAttributeTableGenerator cMSAttributeTableGenerator, CMSAttributeTableGenerator cMSAttributeTableGenerator2) throws IllegalArgumentException {
        addSigner(privateKey, bArr, getEncOID(privateKey, str), str, cMSAttributeTableGenerator, cMSAttributeTableGenerator2);
    }

    public CMSSignedData generate(String str, CMSProcessable cMSProcessable, boolean z, String str2) throws NoSuchAlgorithmException, NoSuchProviderException, CMSException {
        return generate(str, cMSProcessable, z, CMSUtils.getProvider(str2), true);
    }

    public CMSSignedData generate(String str, CMSProcessable cMSProcessable, boolean z, String str2, boolean z2) throws NoSuchAlgorithmException, NoSuchProviderException, CMSException {
        return generate(str, cMSProcessable, z, CMSUtils.getProvider(str2), z2);
    }

    public CMSSignedData generate(String str, CMSProcessable cMSProcessable, boolean z, Provider provider) throws NoSuchAlgorithmException, CMSException {
        return generate(str, cMSProcessable, z, provider, true);
    }

    public CMSSignedData generate(String str, CMSProcessable cMSProcessable, boolean z, Provider provider, boolean z2) throws NoSuchAlgorithmException, CMSException {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        ASN1EncodableVector aSN1EncodableVector2 = new ASN1EncodableVector();
        this.digests.clear();
        for (SignerInformation signerInformation : this._signers) {
            aSN1EncodableVector.add(CMSSignedHelper.INSTANCE.fixAlgID(signerInformation.getDigestAlgorithmID()));
            aSN1EncodableVector2.add(signerInformation.toSignerInfo());
        }
        BERConstructedOctetString bERConstructedOctetString = null;
        ASN1ObjectIdentifier aSN1ObjectIdentifier = str == null ? null : new ASN1ObjectIdentifier(str);
        for (SignerInfoGenerator signerInfoGenerator : this.signerGens) {
            if (cMSProcessable != null) {
                OutputStream calculatingOutputStream = signerInfoGenerator.getCalculatingOutputStream();
                try {
                    cMSProcessable.write(calculatingOutputStream);
                    calculatingOutputStream.close();
                } catch (IOException e) {
                    throw new CMSException("data processing exception: " + e.getMessage(), e);
                }
            }
            SignerInfo generate = signerInfoGenerator.generate(aSN1ObjectIdentifier);
            aSN1EncodableVector.add(generate.getDigestAlgorithm());
            aSN1EncodableVector2.add(generate);
        }
        for (SignerInf signerInf : this.signerInfs) {
            try {
                aSN1EncodableVector.add(signerInf.getDigestAlgorithmID());
                aSN1EncodableVector2.add(signerInf.toSignerInfo(aSN1ObjectIdentifier, cMSProcessable, this.rand, provider, z2));
            } catch (IOException e2) {
                throw new CMSException("encoding error.", e2);
            } catch (InvalidKeyException e3) {
                throw new CMSException("key inappropriate for signature.", e3);
            } catch (SignatureException e4) {
                throw new CMSException("error creating signature.", e4);
            } catch (CertificateEncodingException e5) {
                throw new CMSException("error creating sid.", e5);
            }
        }
        ASN1Set createBerSetFromList = this.certs.size() != 0 ? CMSUtils.createBerSetFromList(this.certs) : null;
        ASN1Set createBerSetFromList2 = this.crls.size() != 0 ? CMSUtils.createBerSetFromList(this.crls) : null;
        if (z) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            if (cMSProcessable != null) {
                try {
                    cMSProcessable.write(byteArrayOutputStream);
                } catch (IOException e6) {
                    throw new CMSException("encapsulation error.", e6);
                }
            }
            bERConstructedOctetString = new BERConstructedOctetString(byteArrayOutputStream.toByteArray());
        }
        return new CMSSignedData(cMSProcessable, new ContentInfo(CMSObjectIdentifiers.signedData, new SignedData(new DERSet(aSN1EncodableVector), new ContentInfo(aSN1ObjectIdentifier, bERConstructedOctetString), createBerSetFromList, createBerSetFromList2, new DERSet(aSN1EncodableVector2))));
    }

    public CMSSignedData generate(CMSProcessable cMSProcessable, String str) throws NoSuchAlgorithmException, NoSuchProviderException, CMSException {
        return generate(cMSProcessable, CMSUtils.getProvider(str));
    }

    public CMSSignedData generate(CMSProcessable cMSProcessable, Provider provider) throws NoSuchAlgorithmException, CMSException {
        return generate(cMSProcessable, false, provider);
    }

    public CMSSignedData generate(CMSProcessable cMSProcessable, boolean z, String str) throws NoSuchAlgorithmException, NoSuchProviderException, CMSException {
        return generate(cMSProcessable instanceof CMSTypedData ? ((CMSTypedData) cMSProcessable).getContentType().getId() : DATA, cMSProcessable, z, str);
    }

    public CMSSignedData generate(CMSProcessable cMSProcessable, boolean z, Provider provider) throws NoSuchAlgorithmException, CMSException {
        return generate(cMSProcessable instanceof CMSTypedData ? ((CMSTypedData) cMSProcessable).getContentType().getId() : DATA, cMSProcessable, z, provider);
    }

    public CMSSignedData generate(CMSTypedData cMSTypedData) throws CMSException {
        return generate(cMSTypedData, false);
    }

    public CMSSignedData generate(CMSTypedData cMSTypedData, boolean z) throws CMSException {
        BERConstructedOctetString bERConstructedOctetString;
        if (this.signerInfs.isEmpty()) {
            ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
            ASN1EncodableVector aSN1EncodableVector2 = new ASN1EncodableVector();
            this.digests.clear();
            for (SignerInformation signerInformation : this._signers) {
                aSN1EncodableVector.add(CMSSignedHelper.INSTANCE.fixAlgID(signerInformation.getDigestAlgorithmID()));
                aSN1EncodableVector2.add(signerInformation.toSignerInfo());
            }
            ASN1ObjectIdentifier contentType = cMSTypedData.getContentType();
            ASN1Set aSN1Set = null;
            if (z) {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                if (cMSTypedData != null) {
                    try {
                        cMSTypedData.write(byteArrayOutputStream);
                    } catch (IOException e) {
                        throw new CMSException("encapsulation error.", e);
                    }
                }
                bERConstructedOctetString = new BERConstructedOctetString(byteArrayOutputStream.toByteArray());
            } else {
                bERConstructedOctetString = null;
            }
            if (cMSTypedData != null) {
                ByteArrayOutputStream byteArrayOutputStream2 = z ? new ByteArrayOutputStream() : null;
                OutputStream safeOutputStream = CMSUtils.getSafeOutputStream(CMSUtils.attachSignersToOutputStream(this.signerGens, byteArrayOutputStream2));
                try {
                    cMSTypedData.write(safeOutputStream);
                    safeOutputStream.close();
                    if (z) {
                        bERConstructedOctetString = new BERConstructedOctetString(byteArrayOutputStream2.toByteArray());
                    }
                } catch (IOException e2) {
                    throw new CMSException("data processing exception: " + e2.getMessage(), e2);
                }
            }
            for (SignerInfoGenerator signerInfoGenerator : this.signerGens) {
                SignerInfo generate = signerInfoGenerator.generate(contentType);
                aSN1EncodableVector.add(generate.getDigestAlgorithm());
                aSN1EncodableVector2.add(generate);
                byte[] calculatedDigest = signerInfoGenerator.getCalculatedDigest();
                if (calculatedDigest != null) {
                    this.digests.put(generate.getDigestAlgorithm().getAlgorithm().getId(), calculatedDigest);
                }
            }
            ASN1Set createBerSetFromList = this.certs.size() != 0 ? CMSUtils.createBerSetFromList(this.certs) : null;
            if (this.crls.size() != 0) {
                aSN1Set = CMSUtils.createBerSetFromList(this.crls);
            }
            return new CMSSignedData(cMSTypedData, new ContentInfo(CMSObjectIdentifiers.signedData, new SignedData(new DERSet(aSN1EncodableVector), new ContentInfo(contentType, bERConstructedOctetString), createBerSetFromList, aSN1Set, new DERSet(aSN1EncodableVector2))));
        }
        throw new IllegalStateException("this method can only be used with SignerInfoGenerator");
    }

    public SignerInformationStore generateCounterSigners(SignerInformation signerInformation) throws NoSuchAlgorithmException, NoSuchProviderException, CMSException {
        return generate((CMSTypedData) new CMSProcessableByteArray(null, signerInformation.getSignature()), false).getSignerInfos();
    }

    public SignerInformationStore generateCounterSigners(SignerInformation signerInformation, String str) throws NoSuchAlgorithmException, NoSuchProviderException, CMSException {
        return generate((String) null, (CMSProcessable) new CMSProcessableByteArray(signerInformation.getSignature()), false, CMSUtils.getProvider(str)).getSignerInfos();
    }

    public SignerInformationStore generateCounterSigners(SignerInformation signerInformation, Provider provider) throws NoSuchAlgorithmException, CMSException {
        return generate((String) null, (CMSProcessable) new CMSProcessableByteArray(signerInformation.getSignature()), false, provider).getSignerInfos();
    }
}
