package com.nimbusds.jwt;

import com.nimbusds.jose.JOSEObject;
import com.nimbusds.jose.Payload;
import com.nimbusds.jose.PlainHeader;
import com.nimbusds.jose.PlainObject;
import com.nimbusds.jose.util.Base64URL;
import java.text.ParseException;
import net.jcip.annotations.ThreadSafe;
import net.minidev.json.JSONObject;

@ThreadSafe
public class PlainJWT extends PlainObject implements JWT {
    private static final long serialVersionUID = 1;

    public PlainJWT(JWTClaimsSet jWTClaimsSet) {
        super(new Payload(jWTClaimsSet.toJSONObject()));
    }

    public PlainJWT(PlainHeader plainHeader, JWTClaimsSet jWTClaimsSet) {
        super(plainHeader, new Payload(jWTClaimsSet.toJSONObject()));
    }

    public PlainJWT(Base64URL base64URL, Base64URL base64URL2) throws ParseException {
        super(base64URL, base64URL2);
    }

    @Override // com.nimbusds.jwt.JWT
    public JWTClaimsSet getJWTClaimsSet() throws ParseException {
        JSONObject jSONObject = getPayload().toJSONObject();
        if (jSONObject != null) {
            return JWTClaimsSet.parse(jSONObject);
        }
        throw new ParseException("Payload of unsecured JOSE object is not a valid JSON object", 0);
    }

    public static PlainJWT parse(String str) throws ParseException {
        Base64URL[] split = JOSEObject.split(str);
        if (split[2].toString().isEmpty()) {
            return new PlainJWT(split[0], split[1]);
        }
        throw new ParseException("Unexpected third Base64URL part in the unsecured JWT object", 0);
    }
}
