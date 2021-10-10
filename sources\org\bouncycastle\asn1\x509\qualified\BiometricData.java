package org.bouncycastle.asn1.x509.qualified;

import java.util.Enumeration;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERIA5String;
import org.bouncycastle.asn1.DERObject;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;

public class BiometricData extends ASN1Encodable {
    ASN1OctetString biometricDataHash;
    AlgorithmIdentifier hashAlgorithm;
    DERIA5String sourceDataUri;
    TypeOfBiometricData typeOfBiometricData;

    public BiometricData(ASN1Sequence aSN1Sequence) {
        Enumeration objects = aSN1Sequence.getObjects();
        this.typeOfBiometricData = TypeOfBiometricData.getInstance(objects.nextElement());
        this.hashAlgorithm = AlgorithmIdentifier.getInstance(objects.nextElement());
        this.biometricDataHash = ASN1OctetString.getInstance(objects.nextElement());
        if (objects.hasMoreElements()) {
            this.sourceDataUri = DERIA5String.getInstance(objects.nextElement());
        }
    }

    public BiometricData(TypeOfBiometricData typeOfBiometricData2, AlgorithmIdentifier algorithmIdentifier, ASN1OctetString aSN1OctetString) {
        this.typeOfBiometricData = typeOfBiometricData2;
        this.hashAlgorithm = algorithmIdentifier;
        this.biometricDataHash = aSN1OctetString;
        this.sourceDataUri = null;
    }

    public BiometricData(TypeOfBiometricData typeOfBiometricData2, AlgorithmIdentifier algorithmIdentifier, ASN1OctetString aSN1OctetString, DERIA5String dERIA5String) {
        this.typeOfBiometricData = typeOfBiometricData2;
        this.hashAlgorithm = algorithmIdentifier;
        this.biometricDataHash = aSN1OctetString;
        this.sourceDataUri = dERIA5String;
    }

    public static BiometricData getInstance(Object obj) {
        if (obj == null || (obj instanceof BiometricData)) {
            return (BiometricData) obj;
        }
        if (obj instanceof ASN1Sequence) {
            return new BiometricData(ASN1Sequence.getInstance(obj));
        }
        throw new IllegalArgumentException("unknown object in getInstance");
    }

    public ASN1OctetString getBiometricDataHash() {
        return this.biometricDataHash;
    }

    public AlgorithmIdentifier getHashAlgorithm() {
        return this.hashAlgorithm;
    }

    public DERIA5String getSourceDataUri() {
        return this.sourceDataUri;
    }

    public TypeOfBiometricData getTypeOfBiometricData() {
        return this.typeOfBiometricData;
    }

    @Override // org.bouncycastle.asn1.ASN1Encodable
    public DERObject toASN1Object() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(this.typeOfBiometricData);
        aSN1EncodableVector.add(this.hashAlgorithm);
        aSN1EncodableVector.add(this.biometricDataHash);
        DERIA5String dERIA5String = this.sourceDataUri;
        if (dERIA5String != null) {
            aSN1EncodableVector.add(dERIA5String);
        }
        return new DERSequence(aSN1EncodableVector);
    }
}
