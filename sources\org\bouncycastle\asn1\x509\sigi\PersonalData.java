package org.bouncycastle.asn1.x509.sigi;

import java.math.BigInteger;
import java.util.Enumeration;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERGeneralizedTime;
import org.bouncycastle.asn1.DERInteger;
import org.bouncycastle.asn1.DERObject;
import org.bouncycastle.asn1.DERPrintableString;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERTaggedObject;
import org.bouncycastle.asn1.x500.DirectoryString;

public class PersonalData extends ASN1Encodable {
    private DERGeneralizedTime dateOfBirth;
    private String gender;
    private BigInteger nameDistinguisher;
    private NameOrPseudonym nameOrPseudonym;
    private DirectoryString placeOfBirth;
    private DirectoryString postalAddress;

    private PersonalData(ASN1Sequence aSN1Sequence) {
        if (aSN1Sequence.size() >= 1) {
            Enumeration objects = aSN1Sequence.getObjects();
            this.nameOrPseudonym = NameOrPseudonym.getInstance(objects.nextElement());
            while (objects.hasMoreElements()) {
                ASN1TaggedObject instance = ASN1TaggedObject.getInstance(objects.nextElement());
                int tagNo = instance.getTagNo();
                if (tagNo == 0) {
                    this.nameDistinguisher = DERInteger.getInstance(instance, false).getValue();
                } else if (tagNo == 1) {
                    this.dateOfBirth = DERGeneralizedTime.getInstance(instance, false);
                } else if (tagNo == 2) {
                    this.placeOfBirth = DirectoryString.getInstance(instance, true);
                } else if (tagNo == 3) {
                    this.gender = DERPrintableString.getInstance(instance, false).getString();
                } else if (tagNo == 4) {
                    this.postalAddress = DirectoryString.getInstance(instance, true);
                } else {
                    throw new IllegalArgumentException("Bad tag number: " + instance.getTagNo());
                }
            }
            return;
        }
        throw new IllegalArgumentException("Bad sequence size: " + aSN1Sequence.size());
    }

    public PersonalData(NameOrPseudonym nameOrPseudonym2, BigInteger bigInteger, DERGeneralizedTime dERGeneralizedTime, DirectoryString directoryString, String str, DirectoryString directoryString2) {
        this.nameOrPseudonym = nameOrPseudonym2;
        this.dateOfBirth = dERGeneralizedTime;
        this.gender = str;
        this.nameDistinguisher = bigInteger;
        this.postalAddress = directoryString2;
        this.placeOfBirth = directoryString;
    }

    public static PersonalData getInstance(Object obj) {
        if (obj == null || (obj instanceof PersonalData)) {
            return (PersonalData) obj;
        }
        if (obj instanceof ASN1Sequence) {
            return new PersonalData((ASN1Sequence) obj);
        }
        throw new IllegalArgumentException("illegal object in getInstance: " + obj.getClass().getName());
    }

    public DERGeneralizedTime getDateOfBirth() {
        return this.dateOfBirth;
    }

    public String getGender() {
        return this.gender;
    }

    public BigInteger getNameDistinguisher() {
        return this.nameDistinguisher;
    }

    public NameOrPseudonym getNameOrPseudonym() {
        return this.nameOrPseudonym;
    }

    public DirectoryString getPlaceOfBirth() {
        return this.placeOfBirth;
    }

    public DirectoryString getPostalAddress() {
        return this.postalAddress;
    }

    @Override // org.bouncycastle.asn1.ASN1Encodable
    public DERObject toASN1Object() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(this.nameOrPseudonym);
        if (this.nameDistinguisher != null) {
            aSN1EncodableVector.add(new DERTaggedObject(false, 0, new DERInteger(this.nameDistinguisher)));
        }
        if (this.dateOfBirth != null) {
            aSN1EncodableVector.add(new DERTaggedObject(false, 1, this.dateOfBirth));
        }
        if (this.placeOfBirth != null) {
            aSN1EncodableVector.add(new DERTaggedObject(true, 2, this.placeOfBirth));
        }
        if (this.gender != null) {
            aSN1EncodableVector.add(new DERTaggedObject(false, 3, new DERPrintableString(this.gender, true)));
        }
        if (this.postalAddress != null) {
            aSN1EncodableVector.add(new DERTaggedObject(true, 4, this.postalAddress));
        }
        return new DERSequence(aSN1EncodableVector);
    }
}
