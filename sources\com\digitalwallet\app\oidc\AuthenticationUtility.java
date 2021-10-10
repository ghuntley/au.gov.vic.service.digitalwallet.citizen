package com.digitalwallet.app.oidc;

import android.content.Context;
import android.content.SharedPreferences;
import android.security.keystore.KeyGenParameterSpec;
import android.util.Base64;
import com.digitalwallet.app.oidc.model.Profile;
import com.digitalwallet.app.oidc.model.Tokens;
import com.squareup.moshi.Moshi;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.KeyStore;
import java.security.PublicKey;
import java.security.cert.Certificate;
import java.security.interfaces.ECPublicKey;
import java.security.spec.ECPoint;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\b\u0016\u0018\u0000 32\u00020\u0001:\u00013B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0012\u001a\u00020\bH\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0016J(\u0010\u0015\u001a\u001a\u0012\u0004\u0012\u00020\f\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00010\u00160\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\r\u0010\u0019\u001a\u00020\u0018H\u0010¢\u0006\u0002\b\u001aJ\n\u0010\u001b\u001a\u0004\u0018\u00010\u0018H\u0016J\n\u0010\u001c\u001a\u0004\u0018\u00010\fH\u0016J\u0015\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0002\u001a\u00020\u0003H\u0010¢\u0006\u0002\b\u001fJ\n\u0010 \u001a\u0004\u0018\u00010!H\u0016J\n\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\n\u0010$\u001a\u0004\u0018\u00010\fH\u0016J\r\u0010%\u001a\u00020\u0014H\u0010¢\u0006\u0002\b&J\b\u0010'\u001a\u00020\u0014H\u0016J\u0010\u0010(\u001a\u00020\u00142\u0006\u0010)\u001a\u00020\bH\u0016J\b\u0010*\u001a\u00020\u0014H\u0016J\u0015\u0010+\u001a\u00020\u00142\u0006\u0010,\u001a\u00020!H\u0010¢\u0006\u0002\b-J\u0010\u0010.\u001a\u00020\u00142\u0006\u0010/\u001a\u00020#H\u0016J\u0010\u00100\u001a\u00020\u00142\u0006\u00101\u001a\u00020\fH\u0016J\b\u00102\u001a\u00020\bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\b8VX\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R$\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\f8V@VX\u000e¢\u0006\f\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u00064"}, d2 = {"Lcom/digitalwallet/app/oidc/AuthenticationUtility;", "", "context", "Landroid/content/Context;", "moshi", "Lcom/squareup/moshi/Moshi;", "(Landroid/content/Context;Lcom/squareup/moshi/Moshi;)V", "firstTime", "", "getFirstTime", "()Z", "value", "", AuthenticationUtility.NICKNAME, "getNickname", "()Ljava/lang/String;", "setNickname", "(Ljava/lang/String;)V", "cardSyncPreferencesSet", "clearKeys", "", "generateJWK", "", "publicKey", "Ljava/security/interfaces/ECPublicKey;", "generateSecureKey", "generateSecureKey$app_citizenProdRelease", "getKey", "getLoginSession", "getPreferences", "Landroid/content/SharedPreferences;", "getPreferences$app_citizenProdRelease", "getProfile", "Lcom/digitalwallet/app/oidc/model/Profile;", "getTokens", "Lcom/digitalwallet/app/oidc/model/Tokens;", "getUserPin", "newLoginSession", "newLoginSession$app_citizenProdRelease", "revokeUser", "setAutoUpdateState", "shouldUpdate", "setFirstRun", "setProfile", "profile", "setProfile$app_citizenProdRelease", "setTokens", AuthenticationUtility.TOKENS_KEY, "setUserPin", "pin", "shouldAutoUpdate", "Companion", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: AuthenticationUtility.kt */
public class AuthenticationUtility {
    private static final String AUTH_ALIAS = "DW_HOLDINGS";
    private static final String AUTH_KEY_STORE = "AndroidKeyStore";
    private static final String AUTO_UPDATE = "auto_update";
    private static final String CARD_SYNC_PREFS_SET = "card_sync_prefs_set";
    public static final Companion Companion = new Companion(null);
    private static final String FIRST_TIME = "first_time";
    private static final String KEY_STORE = "au.gov.vic.service.digitalwallet.citizen.tokens";
    private static final String LOGIN_SESSION_UID = "login_session_uid";
    private static final String NICKNAME = "nickname";
    private static final String PIN_KEY = "user_pin";
    private static final String PROFILE_KEY = "profile";
    private static final String TOKENS_KEY = "tokens";
    private final Context context;
    private final Moshi moshi;

    public AuthenticationUtility(Context context2, Moshi moshi2) {
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(moshi2, "moshi");
        this.context = context2;
        this.moshi = moshi2;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/digitalwallet/app/oidc/AuthenticationUtility$Companion;", "", "()V", "AUTH_ALIAS", "", "AUTH_KEY_STORE", "AUTO_UPDATE", "CARD_SYNC_PREFS_SET", "FIRST_TIME", "KEY_STORE", "LOGIN_SESSION_UID", "NICKNAME", "PIN_KEY", "PROFILE_KEY", "TOKENS_KEY", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
    /* compiled from: AuthenticationUtility.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public Profile getProfile() {
        String string = getPreferences$app_citizenProdRelease(this.context).getString("profile", null);
        if (string == null) {
            return null;
        }
        Intrinsics.checkNotNullExpressionValue(string, "getPreferences(context).…le\", null) ?: return null");
        return (Profile) this.moshi.adapter(Profile.class).fromJson(string);
    }

    public void revokeUser() {
        SharedPreferences.Editor edit = getPreferences$app_citizenProdRelease(this.context).edit();
        edit.remove("profile");
        edit.remove(TOKENS_KEY);
        edit.remove(PIN_KEY);
        edit.remove(AUTO_UPDATE);
        edit.remove(CARD_SYNC_PREFS_SET);
        edit.remove(NICKNAME);
        edit.remove(LOGIN_SESSION_UID);
        edit.apply();
        clearKeys();
    }

    public Map<String, Map<String, Object>> generateJWK(ECPublicKey eCPublicKey) {
        Intrinsics.checkNotNullParameter(eCPublicKey, "publicKey");
        ECPoint w = eCPublicKey.getW();
        Intrinsics.checkNotNullExpressionValue(w, "publicKey.w");
        byte[] byteArray = w.getAffineX().toByteArray();
        ECPoint w2 = eCPublicKey.getW();
        Intrinsics.checkNotNullExpressionValue(w2, "publicKey.w");
        byte[] byteArray2 = w2.getAffineY().toByteArray();
        String encodeToString = Base64.encodeToString(byteArray, 3);
        String encodeToString2 = Base64.encodeToString(byteArray2, 3);
        if (encodeToString.length() > 44 || encodeToString2.length() > 44) {
            throw new Exception("Bytes are too large");
        }
        return MapsKt.mapOf(TuplesKt.to("jwk", MapsKt.mapOf(TuplesKt.to("kty", "EC"), TuplesKt.to("use", "enc"), TuplesKt.to("crv", "P-256"), TuplesKt.to("alg", "ES256"), TuplesKt.to("x", encodeToString), TuplesKt.to("y", encodeToString2))));
    }

    public void clearKeys() {
        KeyStore instance = KeyStore.getInstance(AUTH_KEY_STORE);
        instance.load(null, null);
        instance.deleteEntry(AUTH_ALIAS);
    }

    public ECPublicKey getKey() {
        KeyStore instance = KeyStore.getInstance(AUTH_KEY_STORE);
        instance.load(null, null);
        Certificate certificate = instance.getCertificate(AUTH_ALIAS);
        Intrinsics.checkNotNullExpressionValue(certificate, "cert");
        PublicKey publicKey = certificate.getPublicKey();
        Objects.requireNonNull(publicKey, "null cannot be cast to non-null type java.security.interfaces.ECPublicKey");
        return (ECPublicKey) publicKey;
    }

    public Tokens getTokens() {
        String string = getPreferences$app_citizenProdRelease(this.context).getString(TOKENS_KEY, null);
        if (string == null) {
            return null;
        }
        Intrinsics.checkNotNullExpressionValue(string, "getPreferences(context).…KEY, null) ?: return null");
        return (Tokens) this.moshi.adapter(Tokens.class).fromJson(string);
    }

    public void setUserPin(String str) {
        Intrinsics.checkNotNullParameter(str, "pin");
        SharedPreferences.Editor edit = getPreferences$app_citizenProdRelease(this.context).edit();
        edit.putString(PIN_KEY, str);
        edit.apply();
    }

    public String getUserPin() {
        return getPreferences$app_citizenProdRelease(this.context).getString(PIN_KEY, null);
    }

    public void setTokens(Tokens tokens) {
        Intrinsics.checkNotNullParameter(tokens, TOKENS_KEY);
        SharedPreferences.Editor edit = getPreferences$app_citizenProdRelease(this.context).edit();
        edit.putString(TOKENS_KEY, this.moshi.adapter(Tokens.class).toJson(tokens));
        edit.apply();
    }

    public void newLoginSession$app_citizenProdRelease() {
        SharedPreferences preferences$app_citizenProdRelease = getPreferences$app_citizenProdRelease(this.context);
        String uuid = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(uuid, "UUID.randomUUID().toString()");
        SharedPreferences.Editor edit = preferences$app_citizenProdRelease.edit();
        edit.putString(LOGIN_SESSION_UID, uuid);
        edit.apply();
    }

    public String getLoginSession() {
        return getPreferences$app_citizenProdRelease(this.context).getString(LOGIN_SESSION_UID, null);
    }

    public void setAutoUpdateState(boolean z) {
        SharedPreferences.Editor edit = getPreferences$app_citizenProdRelease(this.context).edit();
        edit.putBoolean(AUTO_UPDATE, z);
        edit.putBoolean(CARD_SYNC_PREFS_SET, true);
        edit.apply();
    }

    public boolean shouldAutoUpdate() {
        return getPreferences$app_citizenProdRelease(this.context).getBoolean(AUTO_UPDATE, false);
    }

    public boolean cardSyncPreferencesSet() {
        return getPreferences$app_citizenProdRelease(this.context).getBoolean(CARD_SYNC_PREFS_SET, false);
    }

    public boolean getFirstTime() {
        return getPreferences$app_citizenProdRelease(this.context).getBoolean(FIRST_TIME, true);
    }

    public void setFirstRun() {
        SharedPreferences.Editor edit = getPreferences$app_citizenProdRelease(this.context).edit();
        edit.putBoolean(FIRST_TIME, false);
        edit.apply();
    }

    public String getNickname() {
        String string = getPreferences$app_citizenProdRelease(this.context).getString(NICKNAME, "");
        Intrinsics.checkNotNull(string);
        return string;
    }

    public void setNickname(String str) {
        Intrinsics.checkNotNullParameter(str, "value");
        SharedPreferences.Editor edit = getPreferences$app_citizenProdRelease(this.context).edit();
        edit.putString(NICKNAME, str);
        edit.apply();
    }

    public ECPublicKey generateSecureKey$app_citizenProdRelease() {
        KeyPairGenerator instance = KeyPairGenerator.getInstance("EC", AUTH_KEY_STORE);
        Intrinsics.checkNotNullExpressionValue(instance, "KeyPairGenerator.getInst… AUTH_KEY_STORE\n        )");
        KeyGenParameterSpec.Builder builder = new KeyGenParameterSpec.Builder(AUTH_ALIAS, 14);
        builder.setKeySize(256);
        builder.setDigests("SHA-256", "SHA-512");
        KeyGenParameterSpec build = builder.build();
        Intrinsics.checkNotNullExpressionValue(build, "KeyGenParameterSpec.Buil…        build()\n        }");
        instance.initialize(build);
        KeyPair generateKeyPair = instance.generateKeyPair();
        Intrinsics.checkNotNullExpressionValue(generateKeyPair, "keyPair");
        PublicKey publicKey = generateKeyPair.getPublic();
        Objects.requireNonNull(publicKey, "null cannot be cast to non-null type java.security.interfaces.ECPublicKey");
        return (ECPublicKey) publicKey;
    }

    public SharedPreferences getPreferences$app_citizenProdRelease(Context context2) {
        Intrinsics.checkNotNullParameter(context2, "context");
        SharedPreferences sharedPreferences = context2.getSharedPreferences(KEY_STORE, 0);
        Intrinsics.checkNotNullExpressionValue(sharedPreferences, "context.getSharedPrefere…RE, Context.MODE_PRIVATE)");
        return sharedPreferences;
    }

    public void setProfile$app_citizenProdRelease(Profile profile) {
        Intrinsics.checkNotNullParameter(profile, "profile");
        SharedPreferences.Editor edit = getPreferences$app_citizenProdRelease(this.context).edit();
        edit.putString("profile", this.moshi.adapter(Profile.class).toJson(profile));
        edit.apply();
    }
}
