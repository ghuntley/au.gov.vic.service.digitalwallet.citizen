package com.nimbusds.jose;

import com.nimbusds.jose.util.Base64URL;
import com.nimbusds.jose.util.StandardCharset;
import java.text.ParseException;
import net.jcip.annotations.ThreadSafe;

@ThreadSafe
public class JWSObject extends JOSEObject {
    private static final long serialVersionUID = 1;
    private final JWSHeader header;
    private Base64URL signature;
    private final String signingInputString;
    private State state;

    public enum State {
        UNSIGNED,
        SIGNED,
        VERIFIED
    }

    public JWSObject(JWSHeader jWSHeader, Payload payload) {
        if (jWSHeader != null) {
            this.header = jWSHeader;
            if (payload != null) {
                setPayload(payload);
                if (jWSHeader.getCustomParam("b64") == null || ((Boolean) jWSHeader.getCustomParam("b64")).booleanValue()) {
                    this.signingInputString = composeSigningInput(jWSHeader.toBase64URL(), payload.toBase64URL());
                } else {
                    this.signingInputString = jWSHeader.toBase64URL().toString() + '.' + payload.toString();
                }
                this.signature = null;
                this.state = State.UNSIGNED;
                return;
            }
            throw new IllegalArgumentException("The payload must not be null");
        }
        throw new IllegalArgumentException("The JWS header must not be null");
    }

    public JWSObject(Base64URL base64URL, Base64URL base64URL2, Base64URL base64URL3) throws ParseException {
        if (base64URL != null) {
            try {
                this.header = JWSHeader.parse(base64URL);
                if (base64URL2 != null) {
                    setPayload(new Payload(base64URL2));
                    this.signingInputString = composeSigningInput(base64URL, base64URL2);
                    if (base64URL3 != null) {
                        this.signature = base64URL3;
                        this.state = State.SIGNED;
                        setParsedParts(base64URL, base64URL2, base64URL3);
                        return;
                    }
                    throw new IllegalArgumentException("The third part must not be null");
                }
                throw new IllegalArgumentException("The second part must not be null");
            } catch (ParseException e) {
                throw new ParseException("Invalid JWS header: " + e.getMessage(), 0);
            }
        } else {
            throw new IllegalArgumentException("The first part must not be null");
        }
    }

    @Override // com.nimbusds.jose.JOSEObject
    public JWSHeader getHeader() {
        return this.header;
    }

    private static String composeSigningInput(Base64URL base64URL, Base64URL base64URL2) {
        return base64URL.toString() + '.' + base64URL2.toString();
    }

    public byte[] getSigningInput() {
        return this.signingInputString.getBytes(StandardCharset.UTF_8);
    }

    public Base64URL getSignature() {
        return this.signature;
    }

    public State getState() {
        return this.state;
    }

    private void ensureUnsignedState() {
        if (this.state != State.UNSIGNED) {
            throw new IllegalStateException("The JWS object must be in an unsigned state");
        }
    }

    private void ensureSignedOrVerifiedState() {
        if (this.state != State.SIGNED && this.state != State.VERIFIED) {
            throw new IllegalStateException("The JWS object must be in a signed or verified state");
        }
    }

    private void ensureJWSSignerSupport(JWSSigner jWSSigner) throws JOSEException {
        if (!jWSSigner.supportedJWSAlgorithms().contains(getHeader().getAlgorithm())) {
            throw new JOSEException("The \"" + getHeader().getAlgorithm() + "\" algorithm is not allowed or supported by the JWS signer: Supported algorithms: " + jWSSigner.supportedJWSAlgorithms());
        }
    }

    public synchronized void sign(JWSSigner jWSSigner) throws JOSEException {
        ensureUnsignedState();
        ensureJWSSignerSupport(jWSSigner);
        try {
            this.signature = jWSSigner.sign(getHeader(), getSigningInput());
            this.state = State.SIGNED;
        } catch (JOSEException e) {
            throw e;
        } catch (Exception e2) {
            throw new JOSEException(e2.getMessage(), e2);
        }
    }

    public synchronized boolean verify(JWSVerifier jWSVerifier) throws JOSEException {
        boolean verify;
        ensureSignedOrVerifiedState();
        try {
            verify = jWSVerifier.verify(getHeader(), getSigningInput(), getSignature());
            if (verify) {
                this.state = State.VERIFIED;
            }
        } catch (JOSEException e) {
            throw e;
        } catch (Exception e2) {
            throw new JOSEException(e2.getMessage(), e2);
        }
        return verify;
    }

    @Override // com.nimbusds.jose.JOSEObject
    public String serialize() {
        return serialize(false);
    }

    public String serialize(boolean z) {
        ensureSignedOrVerifiedState();
        if (z) {
            return this.header.toBase64URL().toString() + '.' + '.' + this.signature.toString();
        }
        return this.signingInputString + '.' + this.signature.toString();
    }

    public static JWSObject parse(String str) throws ParseException {
        Base64URL[] split = JOSEObject.split(str);
        if (split.length == 3) {
            return new JWSObject(split[0], split[1], split[2]);
        }
        throw new ParseException("Unexpected number of Base64URL parts, must be three", 0);
    }
}
