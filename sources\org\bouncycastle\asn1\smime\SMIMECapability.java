package org.bouncycastle.asn1.smime;

import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DEREncodable;
import org.bouncycastle.asn1.DERObject;
import org.bouncycastle.asn1.DERObjectIdentifier;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.nist.NISTObjectIdentifiers;
import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;

public class SMIMECapability extends ASN1Encodable {
    public static final DERObjectIdentifier aES128_CBC = NISTObjectIdentifiers.id_aes128_CBC;
    public static final DERObjectIdentifier aES192_CBC = NISTObjectIdentifiers.id_aes192_CBC;
    public static final DERObjectIdentifier aES256_CBC = NISTObjectIdentifiers.id_aes256_CBC;
    public static final DERObjectIdentifier canNotDecryptAny = PKCSObjectIdentifiers.canNotDecryptAny;
    public static final DERObjectIdentifier dES_CBC = new DERObjectIdentifier("1.3.14.3.2.7");
    public static final DERObjectIdentifier dES_EDE3_CBC = PKCSObjectIdentifiers.des_EDE3_CBC;
    public static final DERObjectIdentifier preferSignedData = PKCSObjectIdentifiers.preferSignedData;
    public static final DERObjectIdentifier rC2_CBC = PKCSObjectIdentifiers.RC2_CBC;
    public static final DERObjectIdentifier sMIMECapabilitiesVersions = PKCSObjectIdentifiers.sMIMECapabilitiesVersions;
    private DERObjectIdentifier capabilityID;
    private DEREncodable parameters;

    public SMIMECapability(ASN1Sequence aSN1Sequence) {
        this.capabilityID = (DERObjectIdentifier) aSN1Sequence.getObjectAt(0);
        if (aSN1Sequence.size() > 1) {
            this.parameters = (DERObject) aSN1Sequence.getObjectAt(1);
        }
    }

    public SMIMECapability(DERObjectIdentifier dERObjectIdentifier, DEREncodable dEREncodable) {
        this.capabilityID = dERObjectIdentifier;
        this.parameters = dEREncodable;
    }

    public static SMIMECapability getInstance(Object obj) {
        if (obj == null || (obj instanceof SMIMECapability)) {
            return (SMIMECapability) obj;
        }
        if (obj instanceof ASN1Sequence) {
            return new SMIMECapability((ASN1Sequence) obj);
        }
        throw new IllegalArgumentException("Invalid SMIMECapability");
    }

    public DERObjectIdentifier getCapabilityID() {
        return this.capabilityID;
    }

    public DEREncodable getParameters() {
        return this.parameters;
    }

    @Override // org.bouncycastle.asn1.ASN1Encodable
    public DERObject toASN1Object() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(this.capabilityID);
        DEREncodable dEREncodable = this.parameters;
        if (dEREncodable != null) {
            aSN1EncodableVector.add(dEREncodable);
        }
        return new DERSequence(aSN1EncodableVector);
    }
}
