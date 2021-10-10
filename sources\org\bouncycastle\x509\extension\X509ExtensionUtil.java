package org.bouncycastle.x509.extension;

import java.io.IOException;
import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Enumeration;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1String;
import org.bouncycastle.asn1.DERObjectIdentifier;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.x509.GeneralName;
import org.bouncycastle.asn1.x509.X509Extensions;
import org.bouncycastle.asn1.x509.X509Name;

public class X509ExtensionUtil {
    public static ASN1Object fromExtensionValue(byte[] bArr) throws IOException {
        return ASN1Object.fromByteArray(((ASN1OctetString) ASN1Object.fromByteArray(bArr)).getOctets());
    }

    private static Collection getAlternativeNames(byte[] bArr) throws CertificateParsingException {
        Object dERObject;
        if (bArr == null) {
            return Collections.EMPTY_LIST;
        }
        try {
            ArrayList arrayList = new ArrayList();
            Enumeration objects = DERSequence.getInstance(fromExtensionValue(bArr)).getObjects();
            while (objects.hasMoreElements()) {
                GeneralName instance = GeneralName.getInstance(objects.nextElement());
                ArrayList arrayList2 = new ArrayList();
                arrayList2.add(new Integer(instance.getTagNo()));
                switch (instance.getTagNo()) {
                    case 0:
                    case 3:
                    case 5:
                        dERObject = instance.getName().getDERObject();
                        break;
                    case 1:
                    case 2:
                    case 6:
                        dERObject = ((ASN1String) instance.getName()).getString();
                        break;
                    case 4:
                        dERObject = X509Name.getInstance(instance.getName()).toString();
                        break;
                    case 7:
                        arrayList2.add(DEROctetString.getInstance(instance.getName()).getOctets());
                        continue;
                        arrayList.add(arrayList2);
                    case 8:
                        dERObject = DERObjectIdentifier.getInstance(instance.getName()).getId();
                        break;
                    default:
                        throw new IOException("Bad tag number: " + instance.getTagNo());
                }
                arrayList2.add(dERObject);
                arrayList.add(arrayList2);
            }
            return Collections.unmodifiableCollection(arrayList);
        } catch (Exception e) {
            throw new CertificateParsingException(e.getMessage());
        }
    }

    public static Collection getIssuerAlternativeNames(X509Certificate x509Certificate) throws CertificateParsingException {
        return getAlternativeNames(x509Certificate.getExtensionValue(X509Extensions.IssuerAlternativeName.getId()));
    }

    public static Collection getSubjectAlternativeNames(X509Certificate x509Certificate) throws CertificateParsingException {
        return getAlternativeNames(x509Certificate.getExtensionValue(X509Extensions.SubjectAlternativeName.getId()));
    }
}
