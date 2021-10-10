package com.nimbusds.jwt;

import com.nimbusds.jose.JOSEObject;
import com.nimbusds.jose.JWSHeader;
import com.nimbusds.jose.JWSObject;
import com.nimbusds.jose.Payload;
import com.nimbusds.jose.util.Base64URL;
import java.text.ParseException;
import net.jcip.annotations.ThreadSafe;
import net.minidev.json.JSONObject;

@ThreadSafe
public class SignedJWT extends JWSObject implements JWT {
    private static final long serialVersionUID = 1;

    public SignedJWT(JWSHeader jWSHeader, JWTClaimsSet jWTClaimsSet) {
        super(jWSHeader, new Payload(jWTClaimsSet.toJSONObject()));
    }

    public SignedJWT(Base64URL base64URL, Base64URL base64URL2, Base64URL base64URL3) throws ParseException {
        super(base64URL, base64URL2, base64URL3);
    }

    @Override // com.nimbusds.jwt.JWT
    public JWTClaimsSet getJWTClaimsSet() throws ParseException {
        JSONObject jSONObject = getPayload().toJSONObject();
        if (jSONObject != null) {
            return JWTClaimsSet.parse(jSONObject);
        }
        throw new ParseException("Payload of JWS object is not a valid JSON object", 0);
    }

    public static SignedJWT parse(String str) throws ParseException {
        Base64URL[] split = JOSEObject.split(str);
        if (split.length == 3) {
            return new SignedJWT(split[0], split[1], split[2]);
        }
        throw new ParseException("Unexpected number of Base64URL parts, must be three", 0);
    }
}
