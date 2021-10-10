package org.bouncycastle.asn1.cmp;

import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERObject;

public class POPODecKeyChallContent extends ASN1Encodable {
    private ASN1Sequence content;

    private POPODecKeyChallContent(ASN1Sequence aSN1Sequence) {
        this.content = aSN1Sequence;
    }

    public static POPODecKeyChallContent getInstance(Object obj) {
        if (obj instanceof POPODecKeyChallContent) {
            return (POPODecKeyChallContent) obj;
        }
        if (obj instanceof ASN1Sequence) {
            return new POPODecKeyChallContent((ASN1Sequence) obj);
        }
        throw new IllegalArgumentException("Invalid object: " + obj.getClass().getName());
    }

    @Override // org.bouncycastle.asn1.ASN1Encodable
    public DERObject toASN1Object() {
        return this.content;
    }

    public Challenge[] toChallengeArray() {
        int size = this.content.size();
        Challenge[] challengeArr = new Challenge[size];
        for (int i = 0; i != size; i++) {
            challengeArr[i] = Challenge.getInstance(this.content.getObjectAt(i));
        }
        return challengeArr;
    }
}
