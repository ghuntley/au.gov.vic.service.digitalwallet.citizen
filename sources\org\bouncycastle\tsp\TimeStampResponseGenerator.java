package org.bouncycastle.tsp;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.util.Date;
import java.util.Set;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1InputStream;
import org.bouncycastle.asn1.DERBitString;
import org.bouncycastle.asn1.DERInteger;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERUTF8String;
import org.bouncycastle.asn1.cmp.PKIFreeText;
import org.bouncycastle.asn1.cmp.PKIStatusInfo;
import org.bouncycastle.asn1.cms.ContentInfo;
import org.bouncycastle.asn1.tsp.TimeStampResp;

public class TimeStampResponseGenerator {
    private Set acceptedAlgorithms;
    private Set acceptedExtensions;
    private Set acceptedPolicies;
    int failInfo;
    int status;
    ASN1EncodableVector statusStrings;
    private TimeStampTokenGenerator tokenGenerator;

    /* access modifiers changed from: package-private */
    public class FailInfo extends DERBitString {
        FailInfo(int i) {
            super(getBytes(i), getPadBits(i));
        }
    }

    public TimeStampResponseGenerator(TimeStampTokenGenerator timeStampTokenGenerator, Set set) {
        this(timeStampTokenGenerator, set, null, null);
    }

    public TimeStampResponseGenerator(TimeStampTokenGenerator timeStampTokenGenerator, Set set, Set set2) {
        this(timeStampTokenGenerator, set, set2, null);
    }

    public TimeStampResponseGenerator(TimeStampTokenGenerator timeStampTokenGenerator, Set set, Set set2, Set set3) {
        this.tokenGenerator = timeStampTokenGenerator;
        this.acceptedAlgorithms = set;
        this.acceptedPolicies = set2;
        this.acceptedExtensions = set3;
        this.statusStrings = new ASN1EncodableVector();
    }

    private void addStatusString(String str) {
        this.statusStrings.add(new DERUTF8String(str));
    }

    private PKIStatusInfo getPKIStatusInfo() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(new DERInteger(this.status));
        if (this.statusStrings.size() > 0) {
            aSN1EncodableVector.add(new PKIFreeText(new DERSequence(this.statusStrings)));
        }
        int i = this.failInfo;
        if (i != 0) {
            aSN1EncodableVector.add(new FailInfo(i));
        }
        return new PKIStatusInfo(new DERSequence(aSN1EncodableVector));
    }

    private void setFailInfoField(int i) {
        this.failInfo = i | this.failInfo;
    }

    public TimeStampResponse generate(TimeStampRequest timeStampRequest, BigInteger bigInteger, Date date) throws TSPException {
        TimeStampResp timeStampResp;
        if (date != null) {
            try {
                timeStampRequest.validate(this.acceptedAlgorithms, this.acceptedPolicies, this.acceptedExtensions);
                this.status = 0;
                addStatusString("Operation Okay");
                try {
                    timeStampResp = new TimeStampResp(getPKIStatusInfo(), ContentInfo.getInstance(new ASN1InputStream(new ByteArrayInputStream(this.tokenGenerator.generate(timeStampRequest, bigInteger, date).toCMSSignedData().getEncoded())).readObject()));
                } catch (IOException e) {
                    throw new TSPException("Timestamp token received cannot be converted to ContentInfo", e);
                }
            } catch (TSPValidationException e2) {
                this.status = 2;
                setFailInfoField(e2.getFailureCode());
                addStatusString(e2.getMessage());
                timeStampResp = new TimeStampResp(getPKIStatusInfo(), null);
            }
            try {
                return new TimeStampResponse(timeStampResp);
            } catch (IOException unused) {
                throw new TSPException("created badly formatted response!");
            }
        } else {
            throw new TSPValidationException("The time source is not available.", 512);
        }
    }

    public TimeStampResponse generate(TimeStampRequest timeStampRequest, BigInteger bigInteger, Date date, String str) throws NoSuchAlgorithmException, NoSuchProviderException, TSPException {
        TimeStampResp timeStampResp;
        if (date != null) {
            try {
                timeStampRequest.validate(this.acceptedAlgorithms, this.acceptedPolicies, this.acceptedExtensions, str);
                this.status = 0;
                addStatusString("Operation Okay");
                try {
                    timeStampResp = new TimeStampResp(getPKIStatusInfo(), ContentInfo.getInstance(new ASN1InputStream(new ByteArrayInputStream(this.tokenGenerator.generate(timeStampRequest, bigInteger, date, str).toCMSSignedData().getEncoded())).readObject()));
                } catch (IOException e) {
                    throw new TSPException("Timestamp token received cannot be converted to ContentInfo", e);
                }
            } catch (TSPValidationException e2) {
                this.status = 2;
                setFailInfoField(e2.getFailureCode());
                addStatusString(e2.getMessage());
                timeStampResp = new TimeStampResp(getPKIStatusInfo(), null);
            }
            try {
                return new TimeStampResponse(timeStampResp);
            } catch (IOException unused) {
                throw new TSPException("created badly formatted response!");
            }
        } else {
            throw new TSPValidationException("The time source is not available.", 512);
        }
    }

    public TimeStampResponse generateFailResponse(int i, int i2, String str) throws TSPException {
        this.status = i;
        setFailInfoField(i2);
        if (str != null) {
            addStatusString(str);
        }
        try {
            return new TimeStampResponse(new TimeStampResp(getPKIStatusInfo(), null));
        } catch (IOException unused) {
            throw new TSPException("created badly formatted response!");
        }
    }
}
