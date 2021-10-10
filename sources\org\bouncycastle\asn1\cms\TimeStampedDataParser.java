package org.bouncycastle.asn1.cms;

import java.io.IOException;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1OctetStringParser;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1SequenceParser;
import org.bouncycastle.asn1.BERSequence;
import org.bouncycastle.asn1.DEREncodable;
import org.bouncycastle.asn1.DERIA5String;
import org.bouncycastle.asn1.DERInteger;
import org.bouncycastle.asn1.DERObject;

public class TimeStampedDataParser {
    private ASN1OctetStringParser content;
    private DERIA5String dataUri;
    private MetaData metaData;
    private ASN1SequenceParser parser;
    private Evidence temporalEvidence;
    private DERInteger version;

    private TimeStampedDataParser(ASN1SequenceParser aSN1SequenceParser) throws IOException {
        this.parser = aSN1SequenceParser;
        this.version = DERInteger.getInstance(aSN1SequenceParser.readObject());
        DEREncodable readObject = aSN1SequenceParser.readObject();
        if (readObject instanceof DERIA5String) {
            this.dataUri = DERIA5String.getInstance(readObject);
            readObject = aSN1SequenceParser.readObject();
        }
        if ((readObject instanceof MetaData) || (readObject instanceof ASN1SequenceParser)) {
            this.metaData = MetaData.getInstance(readObject.getDERObject());
            readObject = aSN1SequenceParser.readObject();
        }
        if (readObject instanceof ASN1OctetStringParser) {
            this.content = (ASN1OctetStringParser) readObject;
        }
    }

    public static TimeStampedDataParser getInstance(Object obj) throws IOException {
        if (obj instanceof ASN1Sequence) {
            return new TimeStampedDataParser(((ASN1Sequence) obj).parser());
        }
        if (obj instanceof ASN1SequenceParser) {
            return new TimeStampedDataParser((ASN1SequenceParser) obj);
        }
        return null;
    }

    public ASN1OctetStringParser getContent() {
        return this.content;
    }

    public DERIA5String getDataUri() {
        return this.dataUri;
    }

    public MetaData getMetaData() {
        return this.metaData;
    }

    public Evidence getTemporalEvidence() throws IOException {
        if (this.temporalEvidence == null) {
            this.temporalEvidence = Evidence.getInstance(this.parser.readObject().getDERObject());
        }
        return this.temporalEvidence;
    }

    public DERObject toASN1Object() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(this.version);
        DERIA5String dERIA5String = this.dataUri;
        if (dERIA5String != null) {
            aSN1EncodableVector.add(dERIA5String);
        }
        MetaData metaData2 = this.metaData;
        if (metaData2 != null) {
            aSN1EncodableVector.add(metaData2);
        }
        ASN1OctetStringParser aSN1OctetStringParser = this.content;
        if (aSN1OctetStringParser != null) {
            aSN1EncodableVector.add(aSN1OctetStringParser);
        }
        aSN1EncodableVector.add(this.temporalEvidence);
        return new BERSequence(aSN1EncodableVector);
    }
}
