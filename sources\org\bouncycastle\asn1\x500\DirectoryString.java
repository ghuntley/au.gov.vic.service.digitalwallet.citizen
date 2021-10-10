package org.bouncycastle.asn1.x500;

import org.bouncycastle.asn1.ASN1Choice;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1String;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERBMPString;
import org.bouncycastle.asn1.DEREncodable;
import org.bouncycastle.asn1.DERObject;
import org.bouncycastle.asn1.DERPrintableString;
import org.bouncycastle.asn1.DERT61String;
import org.bouncycastle.asn1.DERUTF8String;
import org.bouncycastle.asn1.DERUniversalString;

public class DirectoryString extends ASN1Encodable implements ASN1Choice, ASN1String {
    private ASN1String string;

    public DirectoryString(String str) {
        this.string = new DERUTF8String(str);
    }

    private DirectoryString(DERBMPString dERBMPString) {
        this.string = dERBMPString;
    }

    private DirectoryString(DERPrintableString dERPrintableString) {
        this.string = dERPrintableString;
    }

    private DirectoryString(DERT61String dERT61String) {
        this.string = dERT61String;
    }

    private DirectoryString(DERUTF8String dERUTF8String) {
        this.string = dERUTF8String;
    }

    private DirectoryString(DERUniversalString dERUniversalString) {
        this.string = dERUniversalString;
    }

    public static DirectoryString getInstance(Object obj) {
        if (obj instanceof DirectoryString) {
            return (DirectoryString) obj;
        }
        if (obj instanceof DERT61String) {
            return new DirectoryString((DERT61String) obj);
        }
        if (obj instanceof DERPrintableString) {
            return new DirectoryString((DERPrintableString) obj);
        }
        if (obj instanceof DERUniversalString) {
            return new DirectoryString((DERUniversalString) obj);
        }
        if (obj instanceof DERUTF8String) {
            return new DirectoryString((DERUTF8String) obj);
        }
        if (obj instanceof DERBMPString) {
            return new DirectoryString((DERBMPString) obj);
        }
        throw new IllegalArgumentException("illegal object in getInstance: " + obj.getClass().getName());
    }

    public static DirectoryString getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        if (z) {
            return getInstance(aSN1TaggedObject.getObject());
        }
        throw new IllegalArgumentException("choice item must be explicitly tagged");
    }

    @Override // org.bouncycastle.asn1.ASN1String
    public String getString() {
        return this.string.getString();
    }

    @Override // org.bouncycastle.asn1.ASN1Encodable
    public DERObject toASN1Object() {
        return ((DEREncodable) this.string).getDERObject();
    }

    public String toString() {
        return this.string.getString();
    }
}
