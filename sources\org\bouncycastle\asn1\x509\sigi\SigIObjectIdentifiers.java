package org.bouncycastle.asn1.x509.sigi;

import org.bouncycastle.asn1.ASN1ObjectIdentifier;

public interface SigIObjectIdentifiers {
    public static final ASN1ObjectIdentifier id_sigi;
    public static final ASN1ObjectIdentifier id_sigi_cp;
    public static final ASN1ObjectIdentifier id_sigi_cp_sigconform;
    public static final ASN1ObjectIdentifier id_sigi_kp;
    public static final ASN1ObjectIdentifier id_sigi_kp_directoryService;
    public static final ASN1ObjectIdentifier id_sigi_on;
    public static final ASN1ObjectIdentifier id_sigi_on_personalData;

    static {
        ASN1ObjectIdentifier aSN1ObjectIdentifier = new ASN1ObjectIdentifier("1.3.36.8");
        id_sigi = aSN1ObjectIdentifier;
        ASN1ObjectIdentifier aSN1ObjectIdentifier2 = new ASN1ObjectIdentifier(aSN1ObjectIdentifier + ".2");
        id_sigi_kp = aSN1ObjectIdentifier2;
        ASN1ObjectIdentifier aSN1ObjectIdentifier3 = new ASN1ObjectIdentifier(aSN1ObjectIdentifier + ".1");
        id_sigi_cp = aSN1ObjectIdentifier3;
        ASN1ObjectIdentifier aSN1ObjectIdentifier4 = new ASN1ObjectIdentifier(aSN1ObjectIdentifier + ".4");
        id_sigi_on = aSN1ObjectIdentifier4;
        id_sigi_kp_directoryService = new ASN1ObjectIdentifier(aSN1ObjectIdentifier2 + ".1");
        id_sigi_on_personalData = new ASN1ObjectIdentifier(aSN1ObjectIdentifier4 + ".1");
        id_sigi_cp_sigconform = new ASN1ObjectIdentifier(aSN1ObjectIdentifier3 + ".1");
    }
}
