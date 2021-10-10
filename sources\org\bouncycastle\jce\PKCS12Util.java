package org.bouncycastle.jce;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;
import org.bouncycastle.asn1.ASN1InputStream;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERNull;
import org.bouncycastle.asn1.DERObjectIdentifier;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.DEROutputStream;
import org.bouncycastle.asn1.pkcs.ContentInfo;
import org.bouncycastle.asn1.pkcs.MacData;
import org.bouncycastle.asn1.pkcs.Pfx;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.asn1.x509.DigestInfo;

public class PKCS12Util {
    private static byte[] calculatePbeMac(DERObjectIdentifier dERObjectIdentifier, byte[] bArr, int i, char[] cArr, byte[] bArr2, String str) throws Exception {
        SecretKeyFactory instance = SecretKeyFactory.getInstance(dERObjectIdentifier.getId(), str);
        PBEParameterSpec pBEParameterSpec = new PBEParameterSpec(bArr, i);
        SecretKey generateSecret = instance.generateSecret(new PBEKeySpec(cArr));
        Mac instance2 = Mac.getInstance(dERObjectIdentifier.getId(), str);
        instance2.init(generateSecret, pBEParameterSpec);
        instance2.update(bArr2);
        return instance2.doFinal();
    }

    public static byte[] convertToDefiniteLength(byte[] bArr) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DEROutputStream dEROutputStream = new DEROutputStream(byteArrayOutputStream);
        Pfx pfx = new Pfx(ASN1Sequence.getInstance(ASN1Object.fromByteArray(bArr)));
        byteArrayOutputStream.reset();
        dEROutputStream.writeObject(pfx);
        return byteArrayOutputStream.toByteArray();
    }

    public static byte[] convertToDefiniteLength(byte[] bArr, char[] cArr, String str) throws IOException {
        Pfx pfx = new Pfx(ASN1Sequence.getInstance(ASN1Object.fromByteArray(bArr)));
        ContentInfo authSafe = pfx.getAuthSafe();
        ASN1OctetString instance = ASN1OctetString.getInstance(authSafe.getContent());
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DEROutputStream dEROutputStream = new DEROutputStream(byteArrayOutputStream);
        dEROutputStream.writeObject(new ASN1InputStream(instance.getOctets()).readObject());
        ContentInfo contentInfo = new ContentInfo(authSafe.getContentType(), new DEROctetString(byteArrayOutputStream.toByteArray()));
        MacData macData = pfx.getMacData();
        try {
            int intValue = macData.getIterationCount().intValue();
            Pfx pfx2 = new Pfx(contentInfo, new MacData(new DigestInfo(new AlgorithmIdentifier(macData.getMac().getAlgorithmId().getObjectId(), new DERNull()), calculatePbeMac(macData.getMac().getAlgorithmId().getObjectId(), macData.getSalt(), intValue, cArr, ASN1OctetString.getInstance(contentInfo.getContent()).getOctets(), str)), macData.getSalt(), intValue));
            byteArrayOutputStream.reset();
            dEROutputStream.writeObject(pfx2);
            return byteArrayOutputStream.toByteArray();
        } catch (Exception e) {
            throw new IOException("error constructing MAC: " + e.toString());
        }
    }
}
