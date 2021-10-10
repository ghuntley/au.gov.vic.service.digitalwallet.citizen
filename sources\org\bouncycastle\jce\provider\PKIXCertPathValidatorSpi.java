package org.bouncycastle.jce.provider;

import java.security.InvalidAlgorithmParameterException;
import java.security.PublicKey;
import java.security.cert.CertPath;
import java.security.cert.CertPathParameters;
import java.security.cert.CertPathValidatorException;
import java.security.cert.CertPathValidatorResult;
import java.security.cert.CertPathValidatorSpi;
import java.security.cert.Certificate;
import java.security.cert.PKIXCertPathChecker;
import java.security.cert.PKIXCertPathValidatorResult;
import java.security.cert.PKIXParameters;
import java.security.cert.TrustAnchor;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.security.auth.x500.X500Principal;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.jce.exception.ExtCertPathValidatorException;
import org.bouncycastle.x509.ExtendedPKIXParameters;

public class PKIXCertPathValidatorSpi extends CertPathValidatorSpi {
    @Override // java.security.cert.CertPathValidatorSpi
    public CertPathValidatorResult engineValidate(CertPath certPath, CertPathParameters certPathParameters) throws CertPathValidatorException, InvalidAlgorithmParameterException {
        PublicKey publicKey;
        X500Principal x500Principal;
        HashSet hashSet;
        List<PKIXCertPathChecker> list;
        ArrayList[] arrayListArr;
        HashSet hashSet2;
        if (certPathParameters instanceof PKIXParameters) {
            ExtendedPKIXParameters instance = certPathParameters instanceof ExtendedPKIXParameters ? (ExtendedPKIXParameters) certPathParameters : ExtendedPKIXParameters.getInstance((PKIXParameters) certPathParameters);
            if (instance.getTrustAnchors() != null) {
                List<? extends Certificate> certificates = certPath.getCertificates();
                int size = certificates.size();
                if (!certificates.isEmpty()) {
                    Set<String> initialPolicies = instance.getInitialPolicies();
                    try {
                        TrustAnchor findTrustAnchor = CertPathValidatorUtilities.findTrustAnchor((X509Certificate) certificates.get(certificates.size() - 1), instance.getTrustAnchors(), instance.getSigProvider());
                        if (findTrustAnchor != null) {
                            int i = size + 1;
                            ArrayList[] arrayListArr2 = new ArrayList[i];
                            for (int i2 = 0; i2 < i; i2++) {
                                arrayListArr2[i2] = new ArrayList();
                            }
                            HashSet hashSet3 = new HashSet();
                            hashSet3.add("2.5.29.32.0");
                            PKIXPolicyNode pKIXPolicyNode = new PKIXPolicyNode(new ArrayList(), 0, hashSet3, null, new HashSet(), "2.5.29.32.0", false);
                            arrayListArr2[0].add(pKIXPolicyNode);
                            PKIXNameConstraintValidator pKIXNameConstraintValidator = new PKIXNameConstraintValidator();
                            HashSet hashSet4 = new HashSet();
                            int i3 = instance.isExplicitPolicyRequired() ? 0 : i;
                            int i4 = instance.isAnyPolicyInhibited() ? 0 : i;
                            if (instance.isPolicyMappingInhibited()) {
                                i = 0;
                            }
                            X509Certificate trustedCert = findTrustAnchor.getTrustedCert();
                            if (trustedCert != null) {
                                try {
                                    X500Principal subjectPrincipal = CertPathValidatorUtilities.getSubjectPrincipal(trustedCert);
                                    publicKey = trustedCert.getPublicKey();
                                    x500Principal = subjectPrincipal;
                                } catch (IllegalArgumentException e) {
                                    throw new ExtCertPathValidatorException("Subject of trust anchor could not be (re)encoded.", e, certPath, -1);
                                }
                            } else {
                                x500Principal = new X500Principal(findTrustAnchor.getCAName());
                                publicKey = findTrustAnchor.getCAPublicKey();
                            }
                            try {
                                AlgorithmIdentifier algorithmIdentifier = CertPathValidatorUtilities.getAlgorithmIdentifier(publicKey);
                                algorithmIdentifier.getObjectId();
                                algorithmIdentifier.getParameters();
                                if (instance.getTargetConstraints() == null || instance.getTargetConstraints().match((X509Certificate) certificates.get(0))) {
                                    List<PKIXCertPathChecker> certPathCheckers = instance.getCertPathCheckers();
                                    for (PKIXCertPathChecker pKIXCertPathChecker : certPathCheckers) {
                                        pKIXCertPathChecker.init(false);
                                        x500Principal = x500Principal;
                                    }
                                    X500Principal x500Principal2 = x500Principal;
                                    int i5 = size;
                                    PublicKey publicKey2 = publicKey;
                                    X509Certificate x509Certificate = trustedCert;
                                    PKIXPolicyNode pKIXPolicyNode2 = pKIXPolicyNode;
                                    int i6 = i;
                                    int i7 = i4;
                                    int size2 = certificates.size() - 1;
                                    X509Certificate x509Certificate2 = null;
                                    while (size2 >= 0) {
                                        int i8 = size - size2;
                                        X509Certificate x509Certificate3 = (X509Certificate) certificates.get(size2);
                                        RFC3280CertPathUtilities.processCertA(certPath, instance, size2, publicKey2, size2 == certificates.size() + -1, x500Principal2, x509Certificate);
                                        RFC3280CertPathUtilities.processCertBC(certPath, size2, pKIXNameConstraintValidator);
                                        PKIXPolicyNode processCertE = RFC3280CertPathUtilities.processCertE(certPath, size2, RFC3280CertPathUtilities.processCertD(certPath, size2, hashSet4, pKIXPolicyNode2, arrayListArr2, i7));
                                        RFC3280CertPathUtilities.processCertF(certPath, size2, processCertE, i3);
                                        if (i8 == size) {
                                            list = certPathCheckers;
                                            arrayListArr = arrayListArr2;
                                            pKIXPolicyNode2 = processCertE;
                                            i7 = i7;
                                            i6 = i6;
                                            i3 = i3;
                                        } else if (x509Certificate3 == null || x509Certificate3.getVersion() != 1) {
                                            RFC3280CertPathUtilities.prepareNextCertA(certPath, size2);
                                            arrayListArr = arrayListArr2;
                                            PKIXPolicyNode prepareCertB = RFC3280CertPathUtilities.prepareCertB(certPath, size2, arrayListArr, processCertE, i6);
                                            RFC3280CertPathUtilities.prepareNextCertG(certPath, size2, pKIXNameConstraintValidator);
                                            int prepareNextCertH1 = RFC3280CertPathUtilities.prepareNextCertH1(certPath, size2, i3);
                                            int prepareNextCertH2 = RFC3280CertPathUtilities.prepareNextCertH2(certPath, size2, i6);
                                            int prepareNextCertH3 = RFC3280CertPathUtilities.prepareNextCertH3(certPath, size2, i7);
                                            int prepareNextCertI1 = RFC3280CertPathUtilities.prepareNextCertI1(certPath, size2, prepareNextCertH1);
                                            int prepareNextCertI2 = RFC3280CertPathUtilities.prepareNextCertI2(certPath, size2, prepareNextCertH2);
                                            int prepareNextCertJ = RFC3280CertPathUtilities.prepareNextCertJ(certPath, size2, prepareNextCertH3);
                                            RFC3280CertPathUtilities.prepareNextCertK(certPath, size2);
                                            i5 = RFC3280CertPathUtilities.prepareNextCertM(certPath, size2, RFC3280CertPathUtilities.prepareNextCertL(certPath, size2, i5));
                                            RFC3280CertPathUtilities.prepareNextCertN(certPath, size2);
                                            if (x509Certificate3.getCriticalExtensionOIDs() != null) {
                                                hashSet2.remove(RFC3280CertPathUtilities.KEY_USAGE);
                                                hashSet2.remove(RFC3280CertPathUtilities.CERTIFICATE_POLICIES);
                                                hashSet2.remove(RFC3280CertPathUtilities.POLICY_MAPPINGS);
                                                hashSet2.remove(RFC3280CertPathUtilities.INHIBIT_ANY_POLICY);
                                                hashSet2.remove(RFC3280CertPathUtilities.ISSUING_DISTRIBUTION_POINT);
                                                hashSet2.remove(RFC3280CertPathUtilities.DELTA_CRL_INDICATOR);
                                                hashSet2.remove(RFC3280CertPathUtilities.POLICY_CONSTRAINTS);
                                                hashSet2.remove(RFC3280CertPathUtilities.BASIC_CONSTRAINTS);
                                                hashSet2.remove(RFC3280CertPathUtilities.SUBJECT_ALTERNATIVE_NAME);
                                                hashSet2.remove(RFC3280CertPathUtilities.NAME_CONSTRAINTS);
                                            } else {
                                                hashSet2 = new HashSet();
                                            }
                                            list = certPathCheckers;
                                            RFC3280CertPathUtilities.prepareNextCertO(certPath, size2, hashSet2, list);
                                            X500Principal subjectPrincipal2 = CertPathValidatorUtilities.getSubjectPrincipal(x509Certificate3);
                                            try {
                                                PublicKey nextWorkingKey = CertPathValidatorUtilities.getNextWorkingKey(certPath.getCertificates(), size2);
                                                AlgorithmIdentifier algorithmIdentifier2 = CertPathValidatorUtilities.getAlgorithmIdentifier(nextWorkingKey);
                                                algorithmIdentifier2.getObjectId();
                                                algorithmIdentifier2.getParameters();
                                                pKIXPolicyNode2 = prepareCertB;
                                                x500Principal2 = subjectPrincipal2;
                                                publicKey2 = nextWorkingKey;
                                                x509Certificate = x509Certificate3;
                                                i3 = prepareNextCertI1;
                                                i7 = prepareNextCertJ;
                                                i6 = prepareNextCertI2;
                                            } catch (CertPathValidatorException e2) {
                                                throw new CertPathValidatorException("Next working key could not be retrieved.", e2, certPath, size2);
                                            }
                                        } else {
                                            throw new CertPathValidatorException("Version 1 certificates can't be used as CA ones.", null, certPath, size2);
                                        }
                                        arrayListArr2 = arrayListArr;
                                        certPathCheckers = list;
                                        pKIXNameConstraintValidator = pKIXNameConstraintValidator;
                                        certificates = certificates;
                                        findTrustAnchor = findTrustAnchor;
                                        initialPolicies = initialPolicies;
                                        size2--;
                                        x509Certificate2 = x509Certificate3;
                                    }
                                    int i9 = size2 + 1;
                                    int wrapupCertB = RFC3280CertPathUtilities.wrapupCertB(certPath, i9, RFC3280CertPathUtilities.wrapupCertA(i3, x509Certificate2));
                                    if (x509Certificate2.getCriticalExtensionOIDs() != null) {
                                        hashSet.remove(RFC3280CertPathUtilities.KEY_USAGE);
                                        hashSet.remove(RFC3280CertPathUtilities.CERTIFICATE_POLICIES);
                                        hashSet.remove(RFC3280CertPathUtilities.POLICY_MAPPINGS);
                                        hashSet.remove(RFC3280CertPathUtilities.INHIBIT_ANY_POLICY);
                                        hashSet.remove(RFC3280CertPathUtilities.ISSUING_DISTRIBUTION_POINT);
                                        hashSet.remove(RFC3280CertPathUtilities.DELTA_CRL_INDICATOR);
                                        hashSet.remove(RFC3280CertPathUtilities.POLICY_CONSTRAINTS);
                                        hashSet.remove(RFC3280CertPathUtilities.BASIC_CONSTRAINTS);
                                        hashSet.remove(RFC3280CertPathUtilities.SUBJECT_ALTERNATIVE_NAME);
                                        hashSet.remove(RFC3280CertPathUtilities.NAME_CONSTRAINTS);
                                        hashSet.remove(RFC3280CertPathUtilities.CRL_DISTRIBUTION_POINTS);
                                    } else {
                                        hashSet = new HashSet();
                                    }
                                    RFC3280CertPathUtilities.wrapupCertF(certPath, i9, certPathCheckers, hashSet);
                                    PKIXPolicyNode wrapupCertG = RFC3280CertPathUtilities.wrapupCertG(certPath, instance, initialPolicies, i9, arrayListArr2, pKIXPolicyNode2, hashSet4);
                                    if (wrapupCertB > 0 || wrapupCertG != null) {
                                        return new PKIXCertPathValidatorResult(findTrustAnchor, wrapupCertG, x509Certificate2.getPublicKey());
                                    }
                                    throw new CertPathValidatorException("Path processing failed on policy.", null, certPath, size2);
                                }
                                throw new ExtCertPathValidatorException("Target certificate in certification path does not match targetConstraints.", null, certPath, 0);
                            } catch (CertPathValidatorException e3) {
                                throw new ExtCertPathValidatorException("Algorithm identifier of public key of trust anchor could not be read.", e3, certPath, -1);
                            }
                        } else {
                            throw new CertPathValidatorException("Trust anchor for certification path not found.", null, certPath, -1);
                        }
                    } catch (AnnotatedException e4) {
                        throw new CertPathValidatorException(e4.getMessage(), e4, certPath, certificates.size() - 1);
                    }
                } else {
                    throw new CertPathValidatorException("Certification path is empty.", null, certPath, 0);
                }
            } else {
                throw new InvalidAlgorithmParameterException("trustAnchors is null, this is not allowed for certification path validation.");
            }
        } else {
            throw new InvalidAlgorithmParameterException("Parameters must be a " + PKIXParameters.class.getName() + " instance.");
        }
    }
}
