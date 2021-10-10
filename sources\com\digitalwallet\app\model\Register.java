package com.digitalwallet.app.model;

import com.digitalwallet.utilities.AppType;
import java.util.Map;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\b\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0014\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0016J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\bHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001b"}, d2 = {"Lcom/digitalwallet/app/model/Register;", "Lcom/digitalwallet/app/model/MPContent;", Register.personaKey, "Lcom/digitalwallet/utilities/AppType;", "(Lcom/digitalwallet/utilities/AppType;)V", "getPersona", "()Lcom/digitalwallet/utilities/AppType;", "typeString", "", "getTypeString", "()Ljava/lang/String;", "typeToken", "Lcom/digitalwallet/app/model/MPTypeToken;", "getTypeToken", "()Lcom/digitalwallet/app/model/MPTypeToken;", "asMap", "", "", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "Companion", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: MPType.kt */
public final class Register extends MPContent {
    public static final Companion Companion = new Companion(null);
    public static final String personaKey = "persona";
    private final AppType persona;
    private final String typeString;
    private final MPTypeToken typeToken = MPTypeToken.REGISTER;

    public static /* synthetic */ Register copy$default(Register register, AppType appType, int i, Object obj) {
        if ((i & 1) != 0) {
            appType = register.persona;
        }
        return register.copy(appType);
    }

    public final AppType component1() {
        return this.persona;
    }

    public final Register copy(AppType appType) {
        Intrinsics.checkNotNullParameter(appType, personaKey);
        return new Register(appType);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof Register) && Intrinsics.areEqual(this.persona, ((Register) obj).persona);
        }
        return true;
    }

    public int hashCode() {
        AppType appType = this.persona;
        if (appType != null) {
            return appType.hashCode();
        }
        return 0;
    }

    public String toString() {
        return "Register(persona=" + this.persona + ")";
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/digitalwallet/app/model/Register$Companion;", "", "()V", "personaKey", "", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
    /* compiled from: MPType.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public Register(AppType appType) {
        super(null);
        Intrinsics.checkNotNullParameter(appType, personaKey);
        this.persona = appType;
        String name = MPTypeToken.REGISTER.name();
        Objects.requireNonNull(name, "null cannot be cast to non-null type java.lang.String");
        String lowerCase = name.toLowerCase();
        Intrinsics.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase()");
        this.typeString = lowerCase;
    }

    public final AppType getPersona() {
        return this.persona;
    }

    @Override // com.digitalwallet.app.model.MPContent
    public String getTypeString() {
        return this.typeString;
    }

    @Override // com.digitalwallet.app.model.MPType
    public MPTypeToken getTypeToken() {
        return this.typeToken;
    }

    @Override // com.digitalwallet.app.model.MPType
    public Map<String, Object> asMap() {
        String name = this.persona.name();
        Objects.requireNonNull(name, "null cannot be cast to non-null type java.lang.String");
        String lowerCase = name.toLowerCase();
        Intrinsics.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase()");
        return MapsKt.mapOf(TuplesKt.to(personaKey, lowerCase));
    }
}
