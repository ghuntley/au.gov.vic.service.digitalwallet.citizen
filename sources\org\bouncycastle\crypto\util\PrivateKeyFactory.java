package org.bouncycastle.crypto.util;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import org.bouncycastle.asn1.ASN1InputStream;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DEREncodable;
import org.bouncycastle.asn1.DERInteger;
import org.bouncycastle.asn1.DERObject;
import org.bouncycastle.asn1.DERObjectIdentifier;
import org.bouncycastle.asn1.nist.NISTNamedCurves;
import org.bouncycastle.asn1.oiw.ElGamalParameter;
import org.bouncycastle.asn1.oiw.OIWObjectIdentifiers;
import org.bouncycastle.asn1.pkcs.DHParameter;
import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.asn1.pkcs.PrivateKeyInfo;
import org.bouncycastle.asn1.pkcs.RSAPrivateKeyStructure;
import org.bouncycastle.asn1.sec.ECPrivateKeyStructure;
import org.bouncycastle.asn1.sec.SECNamedCurves;
import org.bouncycastle.asn1.teletrust.TeleTrusTNamedCurves;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.asn1.x509.DSAParameter;
import org.bouncycastle.asn1.x9.X962NamedCurves;
import org.bouncycastle.asn1.x9.X962Parameters;
import org.bouncycastle.asn1.x9.X9ECParameters;
import org.bouncycastle.asn1.x9.X9ObjectIdentifiers;
import org.bouncycastle.crypto.params.AsymmetricKeyParameter;
import org.bouncycastle.crypto.params.DHParameters;
import org.bouncycastle.crypto.params.DHPrivateKeyParameters;
import org.bouncycastle.crypto.params.DSAParameters;
import org.bouncycastle.crypto.params.DSAPrivateKeyParameters;
import org.bouncycastle.crypto.params.ECDomainParameters;
import org.bouncycastle.crypto.params.ECPrivateKeyParameters;
import org.bouncycastle.crypto.params.ElGamalParameters;
import org.bouncycastle.crypto.params.ElGamalPrivateKeyParameters;
import org.bouncycastle.crypto.params.RSAPrivateCrtKeyParameters;

public class PrivateKeyFactory {
    public static AsymmetricKeyParameter createKey(InputStream inputStream) throws IOException {
        return createKey(PrivateKeyInfo.getInstance(new ASN1InputStream(inputStream).readObject()));
    }

    public static AsymmetricKeyParameter createKey(PrivateKeyInfo privateKeyInfo) throws IOException {
        ECDomainParameters eCDomainParameters;
        AlgorithmIdentifier algorithmId = privateKeyInfo.getAlgorithmId();
        if (algorithmId.getAlgorithm().equals(PKCSObjectIdentifiers.rsaEncryption)) {
            RSAPrivateKeyStructure rSAPrivateKeyStructure = new RSAPrivateKeyStructure((ASN1Sequence) privateKeyInfo.getPrivateKey());
            return new RSAPrivateCrtKeyParameters(rSAPrivateKeyStructure.getModulus(), rSAPrivateKeyStructure.getPublicExponent(), rSAPrivateKeyStructure.getPrivateExponent(), rSAPrivateKeyStructure.getPrime1(), rSAPrivateKeyStructure.getPrime2(), rSAPrivateKeyStructure.getExponent1(), rSAPrivateKeyStructure.getExponent2(), rSAPrivateKeyStructure.getCoefficient());
        }
        DSAParameters dSAParameters = null;
        if (algorithmId.getObjectId().equals(PKCSObjectIdentifiers.dhKeyAgreement)) {
            DHParameter dHParameter = new DHParameter((ASN1Sequence) privateKeyInfo.getAlgorithmId().getParameters());
            DERInteger dERInteger = (DERInteger) privateKeyInfo.getPrivateKey();
            BigInteger l = dHParameter.getL();
            return new DHPrivateKeyParameters(dERInteger.getValue(), new DHParameters(dHParameter.getP(), dHParameter.getG(), null, l == null ? 0 : l.intValue()));
        } else if (algorithmId.getObjectId().equals(OIWObjectIdentifiers.elGamalAlgorithm)) {
            ElGamalParameter elGamalParameter = new ElGamalParameter((ASN1Sequence) privateKeyInfo.getAlgorithmId().getParameters());
            return new ElGamalPrivateKeyParameters(((DERInteger) privateKeyInfo.getPrivateKey()).getValue(), new ElGamalParameters(elGamalParameter.getP(), elGamalParameter.getG()));
        } else if (algorithmId.getObjectId().equals(X9ObjectIdentifiers.id_dsa)) {
            DERInteger dERInteger2 = (DERInteger) privateKeyInfo.getPrivateKey();
            DEREncodable parameters = privateKeyInfo.getAlgorithmId().getParameters();
            if (parameters != null) {
                DSAParameter instance = DSAParameter.getInstance(parameters.getDERObject());
                dSAParameters = new DSAParameters(instance.getP(), instance.getQ(), instance.getG());
            }
            return new DSAPrivateKeyParameters(dERInteger2.getValue(), dSAParameters);
        } else if (algorithmId.getObjectId().equals(X9ObjectIdentifiers.id_ecPublicKey)) {
            X962Parameters x962Parameters = new X962Parameters((DERObject) privateKeyInfo.getAlgorithmId().getParameters());
            if (x962Parameters.isNamedCurve()) {
                DERObjectIdentifier dERObjectIdentifier = (DERObjectIdentifier) x962Parameters.getParameters();
                X9ECParameters byOID = X962NamedCurves.getByOID(dERObjectIdentifier);
                if (byOID == null && (byOID = SECNamedCurves.getByOID(dERObjectIdentifier)) == null && (byOID = NISTNamedCurves.getByOID(dERObjectIdentifier)) == null) {
                    byOID = TeleTrusTNamedCurves.getByOID(dERObjectIdentifier);
                }
                eCDomainParameters = new ECDomainParameters(byOID.getCurve(), byOID.getG(), byOID.getN(), byOID.getH(), byOID.getSeed());
            } else {
                X9ECParameters x9ECParameters = new X9ECParameters((ASN1Sequence) x962Parameters.getParameters());
                eCDomainParameters = new ECDomainParameters(x9ECParameters.getCurve(), x9ECParameters.getG(), x9ECParameters.getN(), x9ECParameters.getH(), x9ECParameters.getSeed());
            }
            return new ECPrivateKeyParameters(new ECPrivateKeyStructure((ASN1Sequence) privateKeyInfo.getPrivateKey()).getKey(), eCDomainParameters);
        } else {
            throw new RuntimeException("algorithm identifier in key not recognised");
        }
    }

    public static AsymmetricKeyParameter createKey(byte[] bArr) throws IOException {
        return createKey(PrivateKeyInfo.getInstance(ASN1Object.fromByteArray(bArr)));
    }
}
