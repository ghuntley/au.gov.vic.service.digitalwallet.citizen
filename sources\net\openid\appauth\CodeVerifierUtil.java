package net.openid.appauth;

import android.util.Base64;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.regex.Pattern;
import net.openid.appauth.internal.Logger;

public final class CodeVerifierUtil {
    public static final int DEFAULT_CODE_VERIFIER_ENTROPY = 64;
    public static final int MAX_CODE_VERIFIER_ENTROPY = 96;
    public static final int MAX_CODE_VERIFIER_LENGTH = 128;
    public static final int MIN_CODE_VERIFIER_ENTROPY = 32;
    public static final int MIN_CODE_VERIFIER_LENGTH = 43;
    private static final int PKCE_BASE64_ENCODE_SETTINGS = 11;
    private static final Pattern REGEX_CODE_VERIFIER = Pattern.compile("^[0-9a-zA-Z\\-\\.\\_\\~]{43,128}$");

    private CodeVerifierUtil() {
        throw new IllegalStateException("This type is not intended to be instantiated");
    }

    public static void checkCodeVerifier(String str) {
        boolean z = true;
        Preconditions.checkArgument(43 <= str.length(), "codeVerifier length is shorter than allowed by the PKCE specification");
        if (str.length() > 128) {
            z = false;
        }
        Preconditions.checkArgument(z, "codeVerifier length is longer than allowed by the PKCE specification");
        Preconditions.checkArgument(REGEX_CODE_VERIFIER.matcher(str).matches(), "codeVerifier string contains illegal characters");
    }

    public static String generateRandomCodeVerifier() {
        return generateRandomCodeVerifier(new SecureRandom(), 64);
    }

    public static String generateRandomCodeVerifier(SecureRandom secureRandom, int i) {
        Preconditions.checkNotNull(secureRandom, "entropySource cannot be null");
        boolean z = true;
        Preconditions.checkArgument(32 <= i, "entropyBytes is less than the minimum permitted");
        if (i > 96) {
            z = false;
        }
        Preconditions.checkArgument(z, "entropyBytes is greater than the maximum permitted");
        byte[] bArr = new byte[i];
        secureRandom.nextBytes(bArr);
        return Base64.encodeToString(bArr, 11);
    }

    public static String deriveCodeVerifierChallenge(String str) {
        try {
            MessageDigest instance = MessageDigest.getInstance("SHA-256");
            instance.update(str.getBytes("ISO_8859_1"));
            return Base64.encodeToString(instance.digest(), 11);
        } catch (NoSuchAlgorithmException e) {
            Logger.warn("SHA-256 is not supported on this device! Using plain challenge", e);
            return str;
        } catch (UnsupportedEncodingException e2) {
            Logger.error("ISO-8859-1 encoding not supported on this device!", e2);
            throw new IllegalStateException("ISO-8859-1 encoding not supported", e2);
        }
    }

    public static String getCodeVerifierChallengeMethod() {
        try {
            MessageDigest.getInstance("SHA-256");
            return AuthorizationRequest.CODE_CHALLENGE_METHOD_S256;
        } catch (NoSuchAlgorithmException unused) {
            return AuthorizationRequest.CODE_CHALLENGE_METHOD_PLAIN;
        }
    }
}
