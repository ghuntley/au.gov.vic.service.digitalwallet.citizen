package org.bouncycastle.asn1.cms;

import java.io.IOException;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1SequenceParser;
import org.bouncycastle.asn1.ASN1SetParser;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.ASN1TaggedObjectParser;
import org.bouncycastle.asn1.DEREncodable;
import org.bouncycastle.asn1.DERInteger;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;

public class AuthenticatedDataParser {
    private DEREncodable nextObject;
    private boolean originatorInfoCalled;
    private ASN1SequenceParser seq;
    private DERInteger version;

    public AuthenticatedDataParser(ASN1SequenceParser aSN1SequenceParser) throws IOException {
        this.seq = aSN1SequenceParser;
        this.version = (DERInteger) aSN1SequenceParser.readObject();
    }

    public ASN1SetParser getAuthAttrs() throws IOException {
        if (this.nextObject == null) {
            this.nextObject = this.seq.readObject();
        }
        DEREncodable dEREncodable = this.nextObject;
        if (!(dEREncodable instanceof ASN1TaggedObjectParser)) {
            return null;
        }
        this.nextObject = null;
        return (ASN1SetParser) ((ASN1TaggedObjectParser) dEREncodable).getObjectParser(17, false);
    }

    public AlgorithmIdentifier getDigestAlgorithm() throws IOException {
        if (this.nextObject == null) {
            this.nextObject = this.seq.readObject();
        }
        DEREncodable dEREncodable = this.nextObject;
        if (!(dEREncodable instanceof ASN1TaggedObjectParser)) {
            return null;
        }
        AlgorithmIdentifier instance = AlgorithmIdentifier.getInstance((ASN1TaggedObject) dEREncodable.getDERObject(), false);
        this.nextObject = null;
        return instance;
    }

    public ContentInfoParser getEnapsulatedContentInfo() throws IOException {
        if (this.nextObject == null) {
            this.nextObject = this.seq.readObject();
        }
        DEREncodable dEREncodable = this.nextObject;
        if (dEREncodable == null) {
            return null;
        }
        this.nextObject = null;
        return new ContentInfoParser((ASN1SequenceParser) dEREncodable);
    }

    public ASN1OctetString getMac() throws IOException {
        if (this.nextObject == null) {
            this.nextObject = this.seq.readObject();
        }
        DEREncodable dEREncodable = this.nextObject;
        this.nextObject = null;
        return ASN1OctetString.getInstance(dEREncodable.getDERObject());
    }

    public AlgorithmIdentifier getMacAlgorithm() throws IOException {
        if (this.nextObject == null) {
            this.nextObject = this.seq.readObject();
        }
        DEREncodable dEREncodable = this.nextObject;
        if (dEREncodable == null) {
            return null;
        }
        this.nextObject = null;
        return AlgorithmIdentifier.getInstance(((ASN1SequenceParser) dEREncodable).getDERObject());
    }

    public OriginatorInfo getOriginatorInfo() throws IOException {
        this.originatorInfoCalled = true;
        if (this.nextObject == null) {
            this.nextObject = this.seq.readObject();
        }
        DEREncodable dEREncodable = this.nextObject;
        if (!(dEREncodable instanceof ASN1TaggedObjectParser) || ((ASN1TaggedObjectParser) dEREncodable).getTagNo() != 0) {
            return null;
        }
        this.nextObject = null;
        return OriginatorInfo.getInstance(((ASN1SequenceParser) ((ASN1TaggedObjectParser) this.nextObject).getObjectParser(16, false)).getDERObject());
    }

    public ASN1SetParser getRecipientInfos() throws IOException {
        if (!this.originatorInfoCalled) {
            getOriginatorInfo();
        }
        if (this.nextObject == null) {
            this.nextObject = this.seq.readObject();
        }
        ASN1SetParser aSN1SetParser = (ASN1SetParser) this.nextObject;
        this.nextObject = null;
        return aSN1SetParser;
    }

    public ASN1SetParser getUnauthAttrs() throws IOException {
        if (this.nextObject == null) {
            this.nextObject = this.seq.readObject();
        }
        DEREncodable dEREncodable = this.nextObject;
        if (dEREncodable == null) {
            return null;
        }
        this.nextObject = null;
        return (ASN1SetParser) ((ASN1TaggedObjectParser) dEREncodable).getObjectParser(17, false);
    }

    public DERInteger getVersion() {
        return this.version;
    }
}
