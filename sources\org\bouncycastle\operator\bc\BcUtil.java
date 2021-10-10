package org.bouncycastle.operator.bc;

import org.bouncycastle.asn1.nist.NISTObjectIdentifiers;
import org.bouncycastle.asn1.oiw.OIWObjectIdentifiers;
import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.digests.MD4Digest;
import org.bouncycastle.crypto.digests.MD5Digest;
import org.bouncycastle.crypto.digests.SHA1Digest;
import org.bouncycastle.crypto.digests.SHA224Digest;
import org.bouncycastle.crypto.digests.SHA256Digest;
import org.bouncycastle.crypto.digests.SHA384Digest;
import org.bouncycastle.operator.OperatorCreationException;

class BcUtil {
    BcUtil() {
    }

    static Digest createDigest(AlgorithmIdentifier algorithmIdentifier) throws OperatorCreationException {
        if (algorithmIdentifier.getAlgorithm().equals(OIWObjectIdentifiers.idSHA1)) {
            return new SHA1Digest();
        }
        if (algorithmIdentifier.getAlgorithm().equals(NISTObjectIdentifiers.id_sha224)) {
            return new SHA224Digest();
        }
        if (algorithmIdentifier.getAlgorithm().equals(NISTObjectIdentifiers.id_sha256)) {
            return new SHA256Digest();
        }
        if (algorithmIdentifier.getAlgorithm().equals(NISTObjectIdentifiers.id_sha384)) {
            return new SHA384Digest();
        }
        if (algorithmIdentifier.getAlgorithm().equals(NISTObjectIdentifiers.id_sha512)) {
            return new SHA384Digest();
        }
        if (algorithmIdentifier.getAlgorithm().equals(PKCSObjectIdentifiers.md5)) {
            return new MD5Digest();
        }
        if (algorithmIdentifier.getAlgorithm().equals(PKCSObjectIdentifiers.md4)) {
            return new MD4Digest();
        }
        throw new OperatorCreationException("cannot recognise digest");
    }
}
