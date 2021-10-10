package org.bouncycastle.asn1.smime;

import java.util.Enumeration;
import java.util.Vector;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERObject;
import org.bouncycastle.asn1.DERObjectIdentifier;
import org.bouncycastle.asn1.cms.Attribute;
import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;

public class SMIMECapabilities extends ASN1Encodable {
    public static final DERObjectIdentifier canNotDecryptAny = PKCSObjectIdentifiers.canNotDecryptAny;
    public static final DERObjectIdentifier dES_CBC = new DERObjectIdentifier("1.3.14.3.2.7");
    public static final DERObjectIdentifier dES_EDE3_CBC = PKCSObjectIdentifiers.des_EDE3_CBC;
    public static final DERObjectIdentifier preferSignedData = PKCSObjectIdentifiers.preferSignedData;
    public static final DERObjectIdentifier rC2_CBC = PKCSObjectIdentifiers.RC2_CBC;
    public static final DERObjectIdentifier sMIMECapabilitesVersions = PKCSObjectIdentifiers.sMIMECapabilitiesVersions;
    private ASN1Sequence capabilities;

    public SMIMECapabilities(ASN1Sequence aSN1Sequence) {
        this.capabilities = aSN1Sequence;
    }

    public static SMIMECapabilities getInstance(Object obj) {
        if (obj == null || (obj instanceof SMIMECapabilities)) {
            return (SMIMECapabilities) obj;
        }
        if (obj instanceof ASN1Sequence) {
            return new SMIMECapabilities((ASN1Sequence) obj);
        }
        if (obj instanceof Attribute) {
            return new SMIMECapabilities((ASN1Sequence) ((Attribute) obj).getAttrValues().getObjectAt(0));
        }
        throw new IllegalArgumentException("unknown object in factory: " + obj.getClass().getName());
    }

    public Vector getCapabilities(DERObjectIdentifier dERObjectIdentifier) {
        Enumeration objects = this.capabilities.getObjects();
        Vector vector = new Vector();
        if (dERObjectIdentifier == null) {
            while (objects.hasMoreElements()) {
                vector.addElement(SMIMECapability.getInstance(objects.nextElement()));
            }
        } else {
            while (objects.hasMoreElements()) {
                SMIMECapability instance = SMIMECapability.getInstance(objects.nextElement());
                if (dERObjectIdentifier.equals(instance.getCapabilityID())) {
                    vector.addElement(instance);
                }
            }
        }
        return vector;
    }

    @Override // org.bouncycastle.asn1.ASN1Encodable
    public DERObject toASN1Object() {
        return this.capabilities;
    }
}
