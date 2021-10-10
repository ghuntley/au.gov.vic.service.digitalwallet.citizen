package org.bouncycastle.cms;

import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.cms.SignerIdentifier;
import org.bouncycastle.cert.X509CertificateHolder;
import org.bouncycastle.operator.ContentSigner;
import org.bouncycastle.operator.DigestCalculatorProvider;
import org.bouncycastle.operator.OperatorCreationException;

public class SignerInfoGeneratorBuilder {
    private DigestCalculatorProvider digestProvider;
    private boolean directSignature;
    private CMSAttributeTableGenerator signedGen;
    private CMSAttributeTableGenerator unsignedGen;

    public SignerInfoGeneratorBuilder(DigestCalculatorProvider digestCalculatorProvider) {
        this.digestProvider = digestCalculatorProvider;
    }

    private SignerInfoGenerator createGenerator(ContentSigner contentSigner, SignerIdentifier signerIdentifier) throws OperatorCreationException {
        if (this.directSignature) {
            return new SignerInfoGenerator(signerIdentifier, contentSigner, this.digestProvider, true);
        }
        CMSAttributeTableGenerator cMSAttributeTableGenerator = this.signedGen;
        if (cMSAttributeTableGenerator == null && this.unsignedGen == null) {
            return new SignerInfoGenerator(signerIdentifier, contentSigner, this.digestProvider);
        }
        if (cMSAttributeTableGenerator == null) {
            this.signedGen = new DefaultSignedAttributeTableGenerator();
        }
        return new SignerInfoGenerator(signerIdentifier, contentSigner, this.digestProvider, this.signedGen, this.unsignedGen);
    }

    public SignerInfoGenerator build(ContentSigner contentSigner, X509CertificateHolder x509CertificateHolder) throws OperatorCreationException {
        SignerInfoGenerator createGenerator = createGenerator(contentSigner, new SignerIdentifier(x509CertificateHolder.getIssuerAndSerialNumber()));
        createGenerator.setAssociatedCertificate(x509CertificateHolder);
        return createGenerator;
    }

    public SignerInfoGenerator build(ContentSigner contentSigner, byte[] bArr) throws OperatorCreationException {
        return createGenerator(contentSigner, new SignerIdentifier((ASN1OctetString) new DEROctetString(bArr)));
    }

    public SignerInfoGeneratorBuilder setDirectSignature(boolean z) {
        this.directSignature = z;
        return this;
    }

    public SignerInfoGeneratorBuilder setSignedAttributeGenerator(CMSAttributeTableGenerator cMSAttributeTableGenerator) {
        this.signedGen = cMSAttributeTableGenerator;
        return this;
    }

    public SignerInfoGeneratorBuilder setUnsignedAttributeGenerator(CMSAttributeTableGenerator cMSAttributeTableGenerator) {
        this.unsignedGen = cMSAttributeTableGenerator;
        return this;
    }
}
