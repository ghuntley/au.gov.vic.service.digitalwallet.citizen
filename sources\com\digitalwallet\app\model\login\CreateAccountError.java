package com.digitalwallet.app.model.login;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.ResponseBody;
import retrofit2.HttpException;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\b\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0013"}, d2 = {"Lcom/digitalwallet/app/model/login/CreateAccountError;", "", "errorCode", "", "status", "(Ljava/lang/String;Ljava/lang/String;)V", "getErrorCode", "()Ljava/lang/String;", "getStatus", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "Companion", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: CreateAccountError.kt */
public final class CreateAccountError {
    public static final String CODE_LOGIN_AUTH_FAILED = "SVMAER-3010";
    public static final String CODE_LOGIN_BAD_REQUEST = "SVMAER-3100";
    public static final String CODE_LOGIN_DOWNSTREAM = "SVMAER-3000";
    public static final String CODE_OTP_DEVICE_PRINT_DOWN_CDE = "SVMAER-2200";
    public static final String CODE_OTP_HACKY_MISMATCH = "SVMAER-2140";
    public static final String CODE_OTP_INCORRECT = "SVMAER-2110";
    public static final String CODE_OTP_MAX_RETRIES_HIT = "SVMAER-2130";
    public static final String CODE_OTP_REGISTER_DOWN_B = "SVMAER-2030";
    public static final String CODE_OTP_TIMEOUT = "SVMAER-2120";
    public static final String CODE_REG_DOWNSTREAM_B = "SVMAER-1010";
    public static final String CODE_REG_DOWNSTREAM_C = "SVMAER-1020";
    public static final String CODE_REG_USER_EXISTS = "SVMAER-1000";
    public static final String CODE_RESEND_DOWNSTREAM = "SVMAER-4020";
    public static final String CODE_RESEND_MAX_RETRIES_HIT = "SVMAER-4130";
    private static final String CODE_UNKNOWN = "UNKNOWN";
    public static final Companion Companion = new Companion(null);
    private static final CreateAccountError UNKNOWN = new CreateAccountError(CODE_UNKNOWN, CODE_UNKNOWN);
    private final String errorCode;
    private final String status;

    public static /* synthetic */ CreateAccountError copy$default(CreateAccountError createAccountError, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = createAccountError.errorCode;
        }
        if ((i & 2) != 0) {
            str2 = createAccountError.status;
        }
        return createAccountError.copy(str, str2);
    }

    public final String component1() {
        return this.errorCode;
    }

    public final String component2() {
        return this.status;
    }

    public final CreateAccountError copy(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "errorCode");
        Intrinsics.checkNotNullParameter(str2, "status");
        return new CreateAccountError(str, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CreateAccountError)) {
            return false;
        }
        CreateAccountError createAccountError = (CreateAccountError) obj;
        return Intrinsics.areEqual(this.errorCode, createAccountError.errorCode) && Intrinsics.areEqual(this.status, createAccountError.status);
    }

    public int hashCode() {
        String str = this.errorCode;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.status;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return "CreateAccountError(errorCode=" + this.errorCode + ", status=" + this.status + ")";
    }

    public CreateAccountError(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "errorCode");
        Intrinsics.checkNotNullParameter(str2, "status");
        this.errorCode = str;
        this.status = str2;
    }

    public final String getErrorCode() {
        return this.errorCode;
    }

    public final String getStatus() {
        return this.status;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/digitalwallet/app/model/login/CreateAccountError$Companion;", "", "()V", "CODE_LOGIN_AUTH_FAILED", "", "CODE_LOGIN_BAD_REQUEST", "CODE_LOGIN_DOWNSTREAM", "CODE_OTP_DEVICE_PRINT_DOWN_CDE", "CODE_OTP_HACKY_MISMATCH", "CODE_OTP_INCORRECT", "CODE_OTP_MAX_RETRIES_HIT", "CODE_OTP_REGISTER_DOWN_B", "CODE_OTP_TIMEOUT", "CODE_REG_DOWNSTREAM_B", "CODE_REG_DOWNSTREAM_C", "CODE_REG_USER_EXISTS", "CODE_RESEND_DOWNSTREAM", "CODE_RESEND_MAX_RETRIES_HIT", "CODE_UNKNOWN", CreateAccountError.CODE_UNKNOWN, "Lcom/digitalwallet/app/model/login/CreateAccountError;", "fromThrowable", "throwable", "", "moshi", "Lcom/squareup/moshi/Moshi;", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
    /* compiled from: CreateAccountError.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final CreateAccountError fromThrowable(Throwable th, Moshi moshi) {
            CreateAccountError createAccountError;
            String string;
            Intrinsics.checkNotNullParameter(th, "throwable");
            Intrinsics.checkNotNullParameter(moshi, "moshi");
            if (!(th instanceof HttpException)) {
                th = null;
            }
            HttpException httpException = (HttpException) th;
            if (httpException != null) {
                ResponseBody errorBody = httpException.response().errorBody();
                if (errorBody == null || (string = errorBody.string()) == null) {
                    createAccountError = CreateAccountError.UNKNOWN;
                } else {
                    try {
                        JsonAdapter adapter = moshi.adapter(CreateAccountError.class);
                        Intrinsics.checkNotNullExpressionValue(adapter, "this.adapter(T::class.java)");
                        createAccountError = (CreateAccountError) adapter.fromJson(string);
                    } catch (Exception unused) {
                        createAccountError = CreateAccountError.UNKNOWN;
                    }
                }
                if (createAccountError != null) {
                    return createAccountError;
                }
            }
            return CreateAccountError.UNKNOWN;
        }
    }
}
