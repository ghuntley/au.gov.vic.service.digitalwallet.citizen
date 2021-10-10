package org.bouncycastle.asn1.x500.style;

import java.io.IOException;
import java.util.Hashtable;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.DERIA5String;
import org.bouncycastle.asn1.DERPrintableString;
import org.bouncycastle.asn1.DERUTF8String;
import org.bouncycastle.asn1.x500.AttributeTypeAndValue;
import org.bouncycastle.asn1.x500.RDN;
import org.bouncycastle.asn1.x500.X500Name;
import org.bouncycastle.asn1.x500.X500NameStyle;
import org.bouncycastle.i18n.MessageBundle;
import org.objectweb.asm.signature.SignatureVisitor;

public class RFC4519Style implements X500NameStyle {
    private static final Hashtable DefaultLookUp;
    private static final Hashtable DefaultSymbols;
    public static final X500NameStyle INSTANCE = new RFC4519Style();
    public static final ASN1ObjectIdentifier businessCategory;
    public static final ASN1ObjectIdentifier c;
    public static final ASN1ObjectIdentifier cn;
    public static final ASN1ObjectIdentifier dc;
    public static final ASN1ObjectIdentifier description;
    public static final ASN1ObjectIdentifier destinationIndicator;
    public static final ASN1ObjectIdentifier distinguishedName;
    public static final ASN1ObjectIdentifier dnQualifier;
    public static final ASN1ObjectIdentifier enhancedSearchGuide;
    public static final ASN1ObjectIdentifier facsimileTelephoneNumber;
    public static final ASN1ObjectIdentifier generationQualifier;
    public static final ASN1ObjectIdentifier givenName;
    public static final ASN1ObjectIdentifier houseIdentifier;
    public static final ASN1ObjectIdentifier initials;
    public static final ASN1ObjectIdentifier internationalISDNNumber;
    public static final ASN1ObjectIdentifier l;
    public static final ASN1ObjectIdentifier member;
    public static final ASN1ObjectIdentifier name;
    public static final ASN1ObjectIdentifier o;
    public static final ASN1ObjectIdentifier ou;
    public static final ASN1ObjectIdentifier owner;
    public static final ASN1ObjectIdentifier physicalDeliveryOfficeName;
    public static final ASN1ObjectIdentifier postOfficeBox;
    public static final ASN1ObjectIdentifier postalAddress;
    public static final ASN1ObjectIdentifier postalCode;
    public static final ASN1ObjectIdentifier preferredDeliveryMethod;
    public static final ASN1ObjectIdentifier registeredAddress;
    public static final ASN1ObjectIdentifier roleOccupant;
    public static final ASN1ObjectIdentifier searchGuide;
    public static final ASN1ObjectIdentifier seeAlso;
    public static final ASN1ObjectIdentifier serialNumber;
    public static final ASN1ObjectIdentifier sn;
    public static final ASN1ObjectIdentifier st;
    public static final ASN1ObjectIdentifier street;
    public static final ASN1ObjectIdentifier telephoneNumber;
    public static final ASN1ObjectIdentifier teletexTerminalIdentifier;
    public static final ASN1ObjectIdentifier telexNumber;
    public static final ASN1ObjectIdentifier title;
    public static final ASN1ObjectIdentifier uid;
    public static final ASN1ObjectIdentifier uniqueMember;
    public static final ASN1ObjectIdentifier userPassword;
    public static final ASN1ObjectIdentifier x121Address;
    public static final ASN1ObjectIdentifier x500UniqueIdentifier;

    static {
        ASN1ObjectIdentifier aSN1ObjectIdentifier = new ASN1ObjectIdentifier("2.5.4.15");
        businessCategory = aSN1ObjectIdentifier;
        ASN1ObjectIdentifier aSN1ObjectIdentifier2 = new ASN1ObjectIdentifier("2.5.4.6");
        c = aSN1ObjectIdentifier2;
        ASN1ObjectIdentifier aSN1ObjectIdentifier3 = new ASN1ObjectIdentifier("2.5.4.3");
        cn = aSN1ObjectIdentifier3;
        ASN1ObjectIdentifier aSN1ObjectIdentifier4 = new ASN1ObjectIdentifier("0.9.2342.19200300.100.1.25");
        dc = aSN1ObjectIdentifier4;
        ASN1ObjectIdentifier aSN1ObjectIdentifier5 = new ASN1ObjectIdentifier("2.5.4.13");
        description = aSN1ObjectIdentifier5;
        ASN1ObjectIdentifier aSN1ObjectIdentifier6 = new ASN1ObjectIdentifier("2.5.4.27");
        destinationIndicator = aSN1ObjectIdentifier6;
        ASN1ObjectIdentifier aSN1ObjectIdentifier7 = new ASN1ObjectIdentifier("2.5.4.49");
        distinguishedName = aSN1ObjectIdentifier7;
        ASN1ObjectIdentifier aSN1ObjectIdentifier8 = new ASN1ObjectIdentifier("2.5.4.46");
        dnQualifier = aSN1ObjectIdentifier8;
        ASN1ObjectIdentifier aSN1ObjectIdentifier9 = new ASN1ObjectIdentifier("2.5.4.47");
        enhancedSearchGuide = aSN1ObjectIdentifier9;
        ASN1ObjectIdentifier aSN1ObjectIdentifier10 = new ASN1ObjectIdentifier("2.5.4.23");
        facsimileTelephoneNumber = aSN1ObjectIdentifier10;
        ASN1ObjectIdentifier aSN1ObjectIdentifier11 = new ASN1ObjectIdentifier("2.5.4.44");
        generationQualifier = aSN1ObjectIdentifier11;
        ASN1ObjectIdentifier aSN1ObjectIdentifier12 = new ASN1ObjectIdentifier("2.5.4.42");
        givenName = aSN1ObjectIdentifier12;
        ASN1ObjectIdentifier aSN1ObjectIdentifier13 = new ASN1ObjectIdentifier("2.5.4.51");
        houseIdentifier = aSN1ObjectIdentifier13;
        ASN1ObjectIdentifier aSN1ObjectIdentifier14 = new ASN1ObjectIdentifier("2.5.4.43");
        initials = aSN1ObjectIdentifier14;
        ASN1ObjectIdentifier aSN1ObjectIdentifier15 = new ASN1ObjectIdentifier("2.5.4.25");
        internationalISDNNumber = aSN1ObjectIdentifier15;
        ASN1ObjectIdentifier aSN1ObjectIdentifier16 = new ASN1ObjectIdentifier("2.5.4.7");
        l = aSN1ObjectIdentifier16;
        ASN1ObjectIdentifier aSN1ObjectIdentifier17 = new ASN1ObjectIdentifier("2.5.4.31");
        member = aSN1ObjectIdentifier17;
        ASN1ObjectIdentifier aSN1ObjectIdentifier18 = new ASN1ObjectIdentifier("2.5.4.41");
        name = aSN1ObjectIdentifier18;
        ASN1ObjectIdentifier aSN1ObjectIdentifier19 = new ASN1ObjectIdentifier("2.5.4.10");
        o = aSN1ObjectIdentifier19;
        ASN1ObjectIdentifier aSN1ObjectIdentifier20 = new ASN1ObjectIdentifier("2.5.4.11");
        ou = aSN1ObjectIdentifier20;
        ASN1ObjectIdentifier aSN1ObjectIdentifier21 = new ASN1ObjectIdentifier("2.5.4.32");
        owner = aSN1ObjectIdentifier21;
        ASN1ObjectIdentifier aSN1ObjectIdentifier22 = new ASN1ObjectIdentifier("2.5.4.19");
        physicalDeliveryOfficeName = aSN1ObjectIdentifier22;
        ASN1ObjectIdentifier aSN1ObjectIdentifier23 = new ASN1ObjectIdentifier("2.5.4.16");
        postalAddress = aSN1ObjectIdentifier23;
        ASN1ObjectIdentifier aSN1ObjectIdentifier24 = new ASN1ObjectIdentifier("2.5.4.17");
        postalCode = aSN1ObjectIdentifier24;
        ASN1ObjectIdentifier aSN1ObjectIdentifier25 = new ASN1ObjectIdentifier("2.5.4.18");
        postOfficeBox = aSN1ObjectIdentifier25;
        ASN1ObjectIdentifier aSN1ObjectIdentifier26 = new ASN1ObjectIdentifier("2.5.4.28");
        preferredDeliveryMethod = aSN1ObjectIdentifier26;
        ASN1ObjectIdentifier aSN1ObjectIdentifier27 = new ASN1ObjectIdentifier("2.5.4.26");
        registeredAddress = aSN1ObjectIdentifier27;
        ASN1ObjectIdentifier aSN1ObjectIdentifier28 = new ASN1ObjectIdentifier("2.5.4.33");
        roleOccupant = aSN1ObjectIdentifier28;
        ASN1ObjectIdentifier aSN1ObjectIdentifier29 = new ASN1ObjectIdentifier("2.5.4.14");
        searchGuide = aSN1ObjectIdentifier29;
        ASN1ObjectIdentifier aSN1ObjectIdentifier30 = new ASN1ObjectIdentifier("2.5.4.34");
        seeAlso = aSN1ObjectIdentifier30;
        ASN1ObjectIdentifier aSN1ObjectIdentifier31 = new ASN1ObjectIdentifier("2.5.4.5");
        serialNumber = aSN1ObjectIdentifier31;
        ASN1ObjectIdentifier aSN1ObjectIdentifier32 = new ASN1ObjectIdentifier("2.5.4.4");
        sn = aSN1ObjectIdentifier32;
        ASN1ObjectIdentifier aSN1ObjectIdentifier33 = new ASN1ObjectIdentifier("2.5.4.8");
        st = aSN1ObjectIdentifier33;
        ASN1ObjectIdentifier aSN1ObjectIdentifier34 = new ASN1ObjectIdentifier("2.5.4.9");
        street = aSN1ObjectIdentifier34;
        ASN1ObjectIdentifier aSN1ObjectIdentifier35 = new ASN1ObjectIdentifier("2.5.4.20");
        telephoneNumber = aSN1ObjectIdentifier35;
        ASN1ObjectIdentifier aSN1ObjectIdentifier36 = new ASN1ObjectIdentifier("2.5.4.22");
        teletexTerminalIdentifier = aSN1ObjectIdentifier36;
        ASN1ObjectIdentifier aSN1ObjectIdentifier37 = new ASN1ObjectIdentifier("2.5.4.21");
        telexNumber = aSN1ObjectIdentifier37;
        ASN1ObjectIdentifier aSN1ObjectIdentifier38 = new ASN1ObjectIdentifier("2.5.4.12");
        title = aSN1ObjectIdentifier38;
        ASN1ObjectIdentifier aSN1ObjectIdentifier39 = new ASN1ObjectIdentifier("0.9.2342.19200300.100.1.1");
        uid = aSN1ObjectIdentifier39;
        ASN1ObjectIdentifier aSN1ObjectIdentifier40 = new ASN1ObjectIdentifier("2.5.4.50");
        uniqueMember = aSN1ObjectIdentifier40;
        ASN1ObjectIdentifier aSN1ObjectIdentifier41 = new ASN1ObjectIdentifier("2.5.4.35");
        userPassword = aSN1ObjectIdentifier41;
        ASN1ObjectIdentifier aSN1ObjectIdentifier42 = new ASN1ObjectIdentifier("2.5.4.24");
        x121Address = aSN1ObjectIdentifier42;
        ASN1ObjectIdentifier aSN1ObjectIdentifier43 = new ASN1ObjectIdentifier("2.5.4.45");
        x500UniqueIdentifier = aSN1ObjectIdentifier43;
        Hashtable hashtable = new Hashtable();
        DefaultSymbols = hashtable;
        Hashtable hashtable2 = new Hashtable();
        DefaultLookUp = hashtable2;
        hashtable.put(aSN1ObjectIdentifier, "businessCategory");
        hashtable.put(aSN1ObjectIdentifier2, "c");
        hashtable.put(aSN1ObjectIdentifier3, "cn");
        hashtable.put(aSN1ObjectIdentifier4, "dc");
        hashtable.put(aSN1ObjectIdentifier5, "description");
        hashtable.put(aSN1ObjectIdentifier6, "destinationIndicator");
        hashtable.put(aSN1ObjectIdentifier7, "distinguishedName");
        hashtable.put(aSN1ObjectIdentifier8, "dnQualifier");
        hashtable.put(aSN1ObjectIdentifier9, "enhancedSearchGuide");
        hashtable.put(aSN1ObjectIdentifier10, "facsimileTelephoneNumber");
        hashtable.put(aSN1ObjectIdentifier11, "generationQualifier");
        hashtable.put(aSN1ObjectIdentifier12, "givenName");
        hashtable.put(aSN1ObjectIdentifier13, "houseIdentifier");
        hashtable.put(aSN1ObjectIdentifier14, "initials");
        hashtable.put(aSN1ObjectIdentifier15, "internationalISDNNumber");
        hashtable.put(aSN1ObjectIdentifier16, "l");
        hashtable.put(aSN1ObjectIdentifier17, "member");
        hashtable.put(aSN1ObjectIdentifier18, "name");
        hashtable.put(aSN1ObjectIdentifier19, "o");
        hashtable.put(aSN1ObjectIdentifier20, "ou");
        hashtable.put(aSN1ObjectIdentifier21, "owner");
        hashtable.put(aSN1ObjectIdentifier22, "physicalDeliveryOfficeName");
        hashtable.put(aSN1ObjectIdentifier23, "postalAddress");
        hashtable.put(aSN1ObjectIdentifier24, "postalCode");
        hashtable.put(aSN1ObjectIdentifier25, "postOfficeBox");
        hashtable.put(aSN1ObjectIdentifier26, "preferredDeliveryMethod");
        hashtable.put(aSN1ObjectIdentifier27, "registeredAddress");
        hashtable.put(aSN1ObjectIdentifier28, "roleOccupant");
        hashtable.put(aSN1ObjectIdentifier29, "searchGuide");
        hashtable.put(aSN1ObjectIdentifier30, "seeAlso");
        hashtable.put(aSN1ObjectIdentifier31, "serialNumber");
        hashtable.put(aSN1ObjectIdentifier32, "sn");
        hashtable.put(aSN1ObjectIdentifier33, "st");
        hashtable.put(aSN1ObjectIdentifier34, "street");
        hashtable.put(aSN1ObjectIdentifier35, "telephoneNumber");
        hashtable.put(aSN1ObjectIdentifier36, "teletexTerminalIdentifier");
        hashtable.put(aSN1ObjectIdentifier37, "telexNumber");
        hashtable.put(aSN1ObjectIdentifier38, MessageBundle.TITLE_ENTRY);
        hashtable.put(aSN1ObjectIdentifier39, "uid");
        hashtable.put(aSN1ObjectIdentifier40, "uniqueMember");
        hashtable.put(aSN1ObjectIdentifier41, "userPassword");
        hashtable.put(aSN1ObjectIdentifier42, "x121Address");
        hashtable.put(aSN1ObjectIdentifier43, "x500UniqueIdentifier");
        hashtable2.put("businesscategory", aSN1ObjectIdentifier);
        hashtable2.put("c", aSN1ObjectIdentifier2);
        hashtable2.put("cn", aSN1ObjectIdentifier3);
        hashtable2.put("dc", aSN1ObjectIdentifier4);
        hashtable2.put("description", aSN1ObjectIdentifier5);
        hashtable2.put("destinationindicator", aSN1ObjectIdentifier6);
        hashtable2.put("distinguishedname", aSN1ObjectIdentifier7);
        hashtable2.put("dnqualifier", aSN1ObjectIdentifier8);
        hashtable2.put("enhancedsearchguide", aSN1ObjectIdentifier9);
        hashtable2.put("facsimiletelephonenumber", aSN1ObjectIdentifier10);
        hashtable2.put("generationqualifier", aSN1ObjectIdentifier11);
        hashtable2.put("givenname", aSN1ObjectIdentifier12);
        hashtable2.put("houseidentifier", aSN1ObjectIdentifier13);
        hashtable2.put("initials", aSN1ObjectIdentifier14);
        hashtable2.put("internationalisdnnumber", aSN1ObjectIdentifier15);
        hashtable2.put("l", aSN1ObjectIdentifier16);
        hashtable2.put("member", aSN1ObjectIdentifier17);
        hashtable2.put("name", aSN1ObjectIdentifier18);
        hashtable2.put("o", aSN1ObjectIdentifier19);
        hashtable2.put("ou", aSN1ObjectIdentifier20);
        hashtable2.put("owner", aSN1ObjectIdentifier21);
        hashtable2.put("physicaldeliveryofficename", aSN1ObjectIdentifier22);
        hashtable2.put("postaladdress", aSN1ObjectIdentifier23);
        hashtable2.put("postalcode", aSN1ObjectIdentifier24);
        hashtable2.put("postofficebox", aSN1ObjectIdentifier25);
        hashtable2.put("preferreddeliverymethod", aSN1ObjectIdentifier26);
        hashtable2.put("registeredaddress", aSN1ObjectIdentifier27);
        hashtable2.put("roleoccupant", aSN1ObjectIdentifier28);
        hashtable2.put("searchguide", aSN1ObjectIdentifier29);
        hashtable2.put("seealso", aSN1ObjectIdentifier30);
        hashtable2.put("serialnumber", aSN1ObjectIdentifier31);
        hashtable2.put("sn", aSN1ObjectIdentifier32);
        hashtable2.put("st", aSN1ObjectIdentifier33);
        hashtable2.put("street", aSN1ObjectIdentifier34);
        hashtable2.put("telephonenumber", aSN1ObjectIdentifier35);
        hashtable2.put("teletexterminalidentifier", aSN1ObjectIdentifier36);
        hashtable2.put("telexnumber", aSN1ObjectIdentifier37);
        hashtable2.put(MessageBundle.TITLE_ENTRY, aSN1ObjectIdentifier38);
        hashtable2.put("uid", aSN1ObjectIdentifier39);
        hashtable2.put("uniquemember", aSN1ObjectIdentifier40);
        hashtable2.put("userpassword", aSN1ObjectIdentifier41);
        hashtable2.put("x121address", aSN1ObjectIdentifier42);
        hashtable2.put("x500uniqueidentifier", aSN1ObjectIdentifier43);
    }

    protected RFC4519Style() {
    }

    private boolean atvAreEqual(AttributeTypeAndValue attributeTypeAndValue, AttributeTypeAndValue attributeTypeAndValue2) {
        if (attributeTypeAndValue == attributeTypeAndValue2) {
            return true;
        }
        return attributeTypeAndValue != null && attributeTypeAndValue2 != null && attributeTypeAndValue.getType().equals(attributeTypeAndValue2.getType()) && IETFUtils.canonicalize(IETFUtils.valueToString(attributeTypeAndValue.getValue())).equals(IETFUtils.canonicalize(IETFUtils.valueToString(attributeTypeAndValue2.getValue())));
    }

    private int calcHashCode(ASN1Encodable aSN1Encodable) {
        return IETFUtils.canonicalize(IETFUtils.valueToString(aSN1Encodable)).hashCode();
    }

    private boolean foundMatch(boolean z, RDN rdn, RDN[] rdnArr) {
        if (z) {
            for (int length = rdnArr.length - 1; length >= 0; length--) {
                if (rdnArr[length] != null && rdnAreEqual(rdn, rdnArr[length])) {
                    rdnArr[length] = null;
                    return true;
                }
            }
        } else {
            for (int i = 0; i != rdnArr.length; i++) {
                if (rdnArr[i] != null && rdnAreEqual(rdn, rdnArr[i])) {
                    rdnArr[i] = null;
                    return true;
                }
            }
        }
        return false;
    }

    @Override // org.bouncycastle.asn1.x500.X500NameStyle
    public boolean areEqual(X500Name x500Name, X500Name x500Name2) {
        RDN[] rDNs = x500Name.getRDNs();
        RDN[] rDNs2 = x500Name2.getRDNs();
        if (rDNs.length != rDNs2.length) {
            return false;
        }
        boolean z = (rDNs[0].getFirst() == null || rDNs2[0].getFirst() == null) ? false : !rDNs[0].getFirst().getType().equals(rDNs2[0].getFirst().getType());
        for (int i = 0; i != rDNs.length; i++) {
            if (!foundMatch(z, rDNs[i], rDNs2)) {
                return false;
            }
        }
        return true;
    }

    @Override // org.bouncycastle.asn1.x500.X500NameStyle
    public ASN1ObjectIdentifier attrNameToOID(String str) {
        return IETFUtils.decodeAttrName(str, DefaultLookUp);
    }

    @Override // org.bouncycastle.asn1.x500.X500NameStyle
    public int calculateHashCode(X500Name x500Name) {
        RDN[] rDNs = x500Name.getRDNs();
        int i = 0;
        for (int i2 = 0; i2 != rDNs.length; i2++) {
            if (rDNs[i2].isMultiValued()) {
                AttributeTypeAndValue[] typesAndValues = rDNs[i2].getTypesAndValues();
                for (int i3 = 0; i3 != typesAndValues.length; i3++) {
                    i = (i ^ typesAndValues[i3].getType().hashCode()) ^ calcHashCode(typesAndValues[i3].getValue());
                }
            } else {
                i = (i ^ rDNs[i2].getFirst().getType().hashCode()) ^ calcHashCode(rDNs[i2].getFirst().getValue());
            }
        }
        return i;
    }

    @Override // org.bouncycastle.asn1.x500.X500NameStyle
    public RDN[] fromString(String str) {
        RDN[] rDNsFromString = IETFUtils.rDNsFromString(str, this);
        int length = rDNsFromString.length;
        RDN[] rdnArr = new RDN[length];
        for (int i = 0; i != rDNsFromString.length; i++) {
            rdnArr[(length - i) - 1] = rDNsFromString[i];
        }
        return rdnArr;
    }

    /* access modifiers changed from: protected */
    public boolean rdnAreEqual(RDN rdn, RDN rdn2) {
        if (rdn.isMultiValued()) {
            if (!rdn2.isMultiValued()) {
                return false;
            }
            AttributeTypeAndValue[] typesAndValues = rdn.getTypesAndValues();
            AttributeTypeAndValue[] typesAndValues2 = rdn2.getTypesAndValues();
            if (typesAndValues.length != typesAndValues2.length) {
                return false;
            }
            for (int i = 0; i != typesAndValues.length; i++) {
                if (!atvAreEqual(typesAndValues[i], typesAndValues2[i])) {
                    return false;
                }
            }
            return true;
        } else if (!rdn2.isMultiValued()) {
            return atvAreEqual(rdn.getFirst(), rdn2.getFirst());
        } else {
            return false;
        }
    }

    @Override // org.bouncycastle.asn1.x500.X500NameStyle
    public ASN1Encodable stringToValue(ASN1ObjectIdentifier aSN1ObjectIdentifier, String str) {
        if (str.length() == 0 || str.charAt(0) != '#') {
            if (str.length() != 0 && str.charAt(0) == '\\') {
                str = str.substring(1);
            }
            return aSN1ObjectIdentifier.equals(dc) ? new DERIA5String(str) : (aSN1ObjectIdentifier.equals(c) || aSN1ObjectIdentifier.equals(serialNumber) || aSN1ObjectIdentifier.equals(dnQualifier) || aSN1ObjectIdentifier.equals(telephoneNumber)) ? new DERPrintableString(str) : new DERUTF8String(str);
        }
        try {
            return IETFUtils.valueFromHexString(str, 1);
        } catch (IOException unused) {
            throw new RuntimeException("can't recode value for oid " + aSN1ObjectIdentifier.getId());
        }
    }

    @Override // org.bouncycastle.asn1.x500.X500NameStyle
    public String toString(X500Name x500Name) {
        StringBuffer stringBuffer = new StringBuffer();
        RDN[] rDNs = x500Name.getRDNs();
        boolean z = true;
        for (int length = rDNs.length - 1; length >= 0; length--) {
            if (z) {
                z = false;
            } else {
                stringBuffer.append(',');
            }
            if (rDNs[length].isMultiValued()) {
                AttributeTypeAndValue[] typesAndValues = rDNs[length].getTypesAndValues();
                boolean z2 = true;
                for (int i = 0; i != typesAndValues.length; i++) {
                    if (z2) {
                        z2 = false;
                    } else {
                        stringBuffer.append(SignatureVisitor.EXTENDS);
                    }
                    IETFUtils.appendTypeAndValue(stringBuffer, typesAndValues[i], DefaultSymbols);
                }
            } else {
                IETFUtils.appendTypeAndValue(stringBuffer, rDNs[length].getFirst(), DefaultSymbols);
            }
        }
        return stringBuffer.toString();
    }
}
