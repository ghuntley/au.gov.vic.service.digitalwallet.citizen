package org.bouncycastle.asn1;

import java.io.InputStream;

public interface ASN1OctetStringParser extends DEREncodable, InMemoryRepresentable {
    InputStream getOctetStream();
}
