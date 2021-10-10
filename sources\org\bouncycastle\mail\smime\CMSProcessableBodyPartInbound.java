package org.bouncycastle.mail.smime;

import java.io.IOException;
import java.io.OutputStream;
import javax.mail.BodyPart;
import javax.mail.MessagingException;
import org.bouncycastle.cms.CMSException;
import org.bouncycastle.cms.CMSProcessable;

public class CMSProcessableBodyPartInbound implements CMSProcessable {
    private final BodyPart bodyPart;
    private final String defaultContentTransferEncoding;

    public CMSProcessableBodyPartInbound(BodyPart bodyPart2) {
        this(bodyPart2, "7bit");
    }

    public CMSProcessableBodyPartInbound(BodyPart bodyPart2, String str) {
        this.bodyPart = bodyPart2;
        this.defaultContentTransferEncoding = str;
    }

    @Override // org.bouncycastle.cms.CMSProcessable
    public Object getContent() {
        return this.bodyPart;
    }

    @Override // org.bouncycastle.cms.CMSProcessable
    public void write(OutputStream outputStream) throws IOException, CMSException {
        try {
            SMIMEUtil.outputBodyPart(outputStream, this.bodyPart, this.defaultContentTransferEncoding);
        } catch (MessagingException e) {
            throw new CMSException("can't write BodyPart to stream: " + e, e);
        }
    }
}
