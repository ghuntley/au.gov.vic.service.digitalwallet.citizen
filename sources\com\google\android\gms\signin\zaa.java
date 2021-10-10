package com.google.android.gms.signin;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.signin.internal.SignInClientImpl;

/* compiled from: com.google.android.gms:play-services-base@@17.4.0 */
public final class zaa {
    public static final Api.AbstractClientBuilder<SignInClientImpl, SignInOptions> zaa;
    public static final Api<SignInOptions> zab;
    private static final Api.ClientKey<SignInClientImpl> zac;
    private static final Api.ClientKey<SignInClientImpl> zad;
    private static final Api.AbstractClientBuilder<SignInClientImpl, zae> zae;
    private static final Scope zaf = new Scope("profile");
    private static final Scope zag = new Scope("email");
    private static final Api<zae> zah;

    static {
        Api.ClientKey<SignInClientImpl> clientKey = new Api.ClientKey<>();
        zac = clientKey;
        Api.ClientKey<SignInClientImpl> clientKey2 = new Api.ClientKey<>();
        zad = clientKey2;
        zac zac2 = new zac();
        zaa = zac2;
        zab zab2 = new zab();
        zae = zab2;
        zab = new Api<>("SignIn.API", zac2, clientKey);
        zah = new Api<>("SignIn.INTERNAL_API", zab2, clientKey2);
    }
}
