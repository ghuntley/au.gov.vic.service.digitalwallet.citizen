package org.bouncycastle.cms;

import org.bouncycastle.asn1.DERObjectIdentifier;
import org.bouncycastle.asn1.cms.SignerInfo;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;

interface SignerIntInfoGenerator {
    SignerInfo generate(DERObjectIdentifier dERObjectIdentifier, AlgorithmIdentifier algorithmIdentifier, byte[] bArr) throws CMSStreamException;
}
