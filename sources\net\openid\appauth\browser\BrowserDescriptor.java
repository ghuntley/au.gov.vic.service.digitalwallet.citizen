package net.openid.appauth.browser;

import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import android.util.Base64;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashSet;
import java.util.Set;

public class BrowserDescriptor {
    private static final String DIGEST_SHA_512 = "SHA-512";
    private static final int PRIME_HASH_FACTOR = 92821;
    public final String packageName;
    public final Set<String> signatureHashes;
    public final Boolean useCustomTab;
    public final String version;

    public BrowserDescriptor(PackageInfo packageInfo, boolean z) {
        this(packageInfo.packageName, generateSignatureHashes(packageInfo.signatures), packageInfo.versionName, z);
    }

    public BrowserDescriptor(String str, Set<String> set, String str2, boolean z) {
        this.packageName = str;
        this.signatureHashes = set;
        this.version = str2;
        this.useCustomTab = Boolean.valueOf(z);
    }

    public BrowserDescriptor changeUseCustomTab(boolean z) {
        return new BrowserDescriptor(this.packageName, this.signatureHashes, this.version, z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof BrowserDescriptor)) {
            return false;
        }
        BrowserDescriptor browserDescriptor = (BrowserDescriptor) obj;
        return this.packageName.equals(browserDescriptor.packageName) && this.version.equals(browserDescriptor.version) && this.useCustomTab == browserDescriptor.useCustomTab && this.signatureHashes.equals(browserDescriptor.signatureHashes);
    }

    public int hashCode() {
        int hashCode = (((this.packageName.hashCode() * PRIME_HASH_FACTOR) + this.version.hashCode()) * PRIME_HASH_FACTOR) + (this.useCustomTab.booleanValue() ? 1 : 0);
        for (String str : this.signatureHashes) {
            hashCode = (hashCode * PRIME_HASH_FACTOR) + str.hashCode();
        }
        return hashCode;
    }

    public static String generateSignatureHash(Signature signature) {
        try {
            return Base64.encodeToString(MessageDigest.getInstance(DIGEST_SHA_512).digest(signature.toByteArray()), 10);
        } catch (NoSuchAlgorithmException unused) {
            throw new IllegalStateException("Platform does not supportSHA-512 hashing");
        }
    }

    public static Set<String> generateSignatureHashes(Signature[] signatureArr) {
        HashSet hashSet = new HashSet();
        for (Signature signature : signatureArr) {
            hashSet.add(generateSignatureHash(signature));
        }
        return hashSet;
    }
}
