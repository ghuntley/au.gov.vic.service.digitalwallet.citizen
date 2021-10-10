package org.bouncycastle.asn1.isismtt.x509;

import java.util.Enumeration;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DEREncodable;
import org.bouncycastle.asn1.DERObject;
import org.bouncycastle.asn1.DERObjectIdentifier;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.DERPrintableString;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERTaggedObject;
import org.bouncycastle.asn1.x500.DirectoryString;

public class ProfessionInfo extends ASN1Encodable {
    public static final DERObjectIdentifier Notar = new DERObjectIdentifier(NamingAuthority.id_isismtt_at_namingAuthorities_RechtWirtschaftSteuern + ".9");
    public static final DERObjectIdentifier Notariatsverwalter = new DERObjectIdentifier(NamingAuthority.id_isismtt_at_namingAuthorities_RechtWirtschaftSteuern + ".13");
    public static final DERObjectIdentifier Notariatsverwalterin = new DERObjectIdentifier(NamingAuthority.id_isismtt_at_namingAuthorities_RechtWirtschaftSteuern + ".12");
    public static final DERObjectIdentifier Notarin = new DERObjectIdentifier(NamingAuthority.id_isismtt_at_namingAuthorities_RechtWirtschaftSteuern + ".8");
    public static final DERObjectIdentifier Notarvertreter = new DERObjectIdentifier(NamingAuthority.id_isismtt_at_namingAuthorities_RechtWirtschaftSteuern + ".11");
    public static final DERObjectIdentifier Notarvertreterin = new DERObjectIdentifier(NamingAuthority.id_isismtt_at_namingAuthorities_RechtWirtschaftSteuern + ".10");
    public static final DERObjectIdentifier Patentanwalt = new DERObjectIdentifier(NamingAuthority.id_isismtt_at_namingAuthorities_RechtWirtschaftSteuern + ".19");
    public static final DERObjectIdentifier Patentanwltin = new DERObjectIdentifier(NamingAuthority.id_isismtt_at_namingAuthorities_RechtWirtschaftSteuern + ".18");
    public static final DERObjectIdentifier Rechtsanwalt = new DERObjectIdentifier(NamingAuthority.id_isismtt_at_namingAuthorities_RechtWirtschaftSteuern + ".2");
    public static final DERObjectIdentifier Rechtsanwltin = new DERObjectIdentifier(NamingAuthority.id_isismtt_at_namingAuthorities_RechtWirtschaftSteuern + ".1");
    public static final DERObjectIdentifier Rechtsbeistand = new DERObjectIdentifier(NamingAuthority.id_isismtt_at_namingAuthorities_RechtWirtschaftSteuern + ".3");
    public static final DERObjectIdentifier Steuerberater = new DERObjectIdentifier(NamingAuthority.id_isismtt_at_namingAuthorities_RechtWirtschaftSteuern + ".5");
    public static final DERObjectIdentifier Steuerberaterin = new DERObjectIdentifier(NamingAuthority.id_isismtt_at_namingAuthorities_RechtWirtschaftSteuern + ".4");
    public static final DERObjectIdentifier Steuerbevollmchtigte = new DERObjectIdentifier(NamingAuthority.id_isismtt_at_namingAuthorities_RechtWirtschaftSteuern + ".6");
    public static final DERObjectIdentifier Steuerbevollmchtigter = new DERObjectIdentifier(NamingAuthority.id_isismtt_at_namingAuthorities_RechtWirtschaftSteuern + ".7");
    public static final DERObjectIdentifier VereidigteBuchprferin = new DERObjectIdentifier(NamingAuthority.id_isismtt_at_namingAuthorities_RechtWirtschaftSteuern + ".16");
    public static final DERObjectIdentifier VereidigterBuchprfer = new DERObjectIdentifier(NamingAuthority.id_isismtt_at_namingAuthorities_RechtWirtschaftSteuern + ".17");
    public static final DERObjectIdentifier Wirtschaftsprfer = new DERObjectIdentifier(NamingAuthority.id_isismtt_at_namingAuthorities_RechtWirtschaftSteuern + ".15");
    public static final DERObjectIdentifier Wirtschaftsprferin = new DERObjectIdentifier(NamingAuthority.id_isismtt_at_namingAuthorities_RechtWirtschaftSteuern + ".14");
    private ASN1OctetString addProfessionInfo;
    private NamingAuthority namingAuthority;
    private ASN1Sequence professionItems;
    private ASN1Sequence professionOIDs;
    private String registrationNumber;

    private ProfessionInfo(ASN1Sequence aSN1Sequence) {
        if (aSN1Sequence.size() <= 5) {
            Enumeration objects = aSN1Sequence.getObjects();
            DEREncodable dEREncodable = (DEREncodable) objects.nextElement();
            if (dEREncodable instanceof ASN1TaggedObject) {
                ASN1TaggedObject aSN1TaggedObject = (ASN1TaggedObject) dEREncodable;
                if (aSN1TaggedObject.getTagNo() == 0) {
                    this.namingAuthority = NamingAuthority.getInstance(aSN1TaggedObject, true);
                    dEREncodable = (DEREncodable) objects.nextElement();
                } else {
                    throw new IllegalArgumentException("Bad tag number: " + aSN1TaggedObject.getTagNo());
                }
            }
            this.professionItems = ASN1Sequence.getInstance(dEREncodable);
            if (objects.hasMoreElements()) {
                DEREncodable dEREncodable2 = (DEREncodable) objects.nextElement();
                if (dEREncodable2 instanceof ASN1Sequence) {
                    this.professionOIDs = ASN1Sequence.getInstance(dEREncodable2);
                } else if (dEREncodable2 instanceof DERPrintableString) {
                    this.registrationNumber = DERPrintableString.getInstance(dEREncodable2).getString();
                } else if (dEREncodable2 instanceof ASN1OctetString) {
                    this.addProfessionInfo = ASN1OctetString.getInstance(dEREncodable2);
                } else {
                    throw new IllegalArgumentException("Bad object encountered: " + dEREncodable2.getClass());
                }
            }
            if (objects.hasMoreElements()) {
                DEREncodable dEREncodable3 = (DEREncodable) objects.nextElement();
                if (dEREncodable3 instanceof DERPrintableString) {
                    this.registrationNumber = DERPrintableString.getInstance(dEREncodable3).getString();
                } else if (dEREncodable3 instanceof DEROctetString) {
                    this.addProfessionInfo = (DEROctetString) dEREncodable3;
                } else {
                    throw new IllegalArgumentException("Bad object encountered: " + dEREncodable3.getClass());
                }
            }
            if (objects.hasMoreElements()) {
                DEREncodable dEREncodable4 = (DEREncodable) objects.nextElement();
                if (dEREncodable4 instanceof DEROctetString) {
                    this.addProfessionInfo = (DEROctetString) dEREncodable4;
                    return;
                }
                throw new IllegalArgumentException("Bad object encountered: " + dEREncodable4.getClass());
            }
            return;
        }
        throw new IllegalArgumentException("Bad sequence size: " + aSN1Sequence.size());
    }

    public ProfessionInfo(NamingAuthority namingAuthority2, DirectoryString[] directoryStringArr, DERObjectIdentifier[] dERObjectIdentifierArr, String str, ASN1OctetString aSN1OctetString) {
        this.namingAuthority = namingAuthority2;
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        for (int i = 0; i != directoryStringArr.length; i++) {
            aSN1EncodableVector.add(directoryStringArr[i]);
        }
        this.professionItems = new DERSequence(aSN1EncodableVector);
        if (dERObjectIdentifierArr != null) {
            ASN1EncodableVector aSN1EncodableVector2 = new ASN1EncodableVector();
            for (int i2 = 0; i2 != dERObjectIdentifierArr.length; i2++) {
                aSN1EncodableVector2.add(dERObjectIdentifierArr[i2]);
            }
            this.professionOIDs = new DERSequence(aSN1EncodableVector2);
        }
        this.registrationNumber = str;
        this.addProfessionInfo = aSN1OctetString;
    }

    public static ProfessionInfo getInstance(Object obj) {
        if (obj == null || (obj instanceof ProfessionInfo)) {
            return (ProfessionInfo) obj;
        }
        if (obj instanceof ASN1Sequence) {
            return new ProfessionInfo((ASN1Sequence) obj);
        }
        throw new IllegalArgumentException("illegal object in getInstance: " + obj.getClass().getName());
    }

    public ASN1OctetString getAddProfessionInfo() {
        return this.addProfessionInfo;
    }

    public NamingAuthority getNamingAuthority() {
        return this.namingAuthority;
    }

    public DirectoryString[] getProfessionItems() {
        DirectoryString[] directoryStringArr = new DirectoryString[this.professionItems.size()];
        Enumeration objects = this.professionItems.getObjects();
        int i = 0;
        while (objects.hasMoreElements()) {
            directoryStringArr[i] = DirectoryString.getInstance(objects.nextElement());
            i++;
        }
        return directoryStringArr;
    }

    public DERObjectIdentifier[] getProfessionOIDs() {
        ASN1Sequence aSN1Sequence = this.professionOIDs;
        int i = 0;
        if (aSN1Sequence == null) {
            return new DERObjectIdentifier[0];
        }
        DERObjectIdentifier[] dERObjectIdentifierArr = new DERObjectIdentifier[aSN1Sequence.size()];
        Enumeration objects = this.professionOIDs.getObjects();
        while (objects.hasMoreElements()) {
            dERObjectIdentifierArr[i] = DERObjectIdentifier.getInstance(objects.nextElement());
            i++;
        }
        return dERObjectIdentifierArr;
    }

    public String getRegistrationNumber() {
        return this.registrationNumber;
    }

    @Override // org.bouncycastle.asn1.ASN1Encodable
    public DERObject toASN1Object() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        if (this.namingAuthority != null) {
            aSN1EncodableVector.add(new DERTaggedObject(true, 0, this.namingAuthority));
        }
        aSN1EncodableVector.add(this.professionItems);
        ASN1Sequence aSN1Sequence = this.professionOIDs;
        if (aSN1Sequence != null) {
            aSN1EncodableVector.add(aSN1Sequence);
        }
        String str = this.registrationNumber;
        if (str != null) {
            aSN1EncodableVector.add(new DERPrintableString(str, true));
        }
        ASN1OctetString aSN1OctetString = this.addProfessionInfo;
        if (aSN1OctetString != null) {
            aSN1EncodableVector.add(aSN1OctetString);
        }
        return new DERSequence(aSN1EncodableVector);
    }
}
