package org.bouncycastle.asn1.misc;

import org.bouncycastle.asn1.ASN1ObjectIdentifier;

public interface MiscObjectIdentifiers {
    public static final ASN1ObjectIdentifier entrust;
    public static final ASN1ObjectIdentifier entrustVersionExtension;
    public static final ASN1ObjectIdentifier netscape;
    public static final ASN1ObjectIdentifier netscapeBaseURL;
    public static final ASN1ObjectIdentifier netscapeCARevocationURL;
    public static final ASN1ObjectIdentifier netscapeCApolicyURL;
    public static final ASN1ObjectIdentifier netscapeCertComment;
    public static final ASN1ObjectIdentifier netscapeCertType;
    public static final ASN1ObjectIdentifier netscapeRenewalURL;
    public static final ASN1ObjectIdentifier netscapeRevocationURL;
    public static final ASN1ObjectIdentifier netscapeSSLServerName;
    public static final ASN1ObjectIdentifier novell;
    public static final ASN1ObjectIdentifier novellSecurityAttribs;
    public static final ASN1ObjectIdentifier verisign;
    public static final ASN1ObjectIdentifier verisignCzagExtension;
    public static final ASN1ObjectIdentifier verisignDnbDunsNumber;

    static {
        ASN1ObjectIdentifier aSN1ObjectIdentifier = new ASN1ObjectIdentifier("2.16.840.1.113730.1");
        netscape = aSN1ObjectIdentifier;
        netscapeCertType = aSN1ObjectIdentifier.branch("1");
        netscapeBaseURL = aSN1ObjectIdentifier.branch("2");
        netscapeRevocationURL = aSN1ObjectIdentifier.branch("3");
        netscapeCARevocationURL = aSN1ObjectIdentifier.branch("4");
        netscapeRenewalURL = aSN1ObjectIdentifier.branch("7");
        netscapeCApolicyURL = aSN1ObjectIdentifier.branch("8");
        netscapeSSLServerName = aSN1ObjectIdentifier.branch("12");
        netscapeCertComment = aSN1ObjectIdentifier.branch("13");
        ASN1ObjectIdentifier aSN1ObjectIdentifier2 = new ASN1ObjectIdentifier("2.16.840.1.113733.1");
        verisign = aSN1ObjectIdentifier2;
        verisignCzagExtension = aSN1ObjectIdentifier2.branch("6.3");
        verisignDnbDunsNumber = aSN1ObjectIdentifier2.branch("6.15");
        ASN1ObjectIdentifier aSN1ObjectIdentifier3 = new ASN1ObjectIdentifier("2.16.840.1.113719");
        novell = aSN1ObjectIdentifier3;
        novellSecurityAttribs = aSN1ObjectIdentifier3.branch("1.9.4.1");
        ASN1ObjectIdentifier aSN1ObjectIdentifier4 = new ASN1ObjectIdentifier("1.2.840.113533.7");
        entrust = aSN1ObjectIdentifier4;
        entrustVersionExtension = aSN1ObjectIdentifier4.branch("65.0");
    }
}
