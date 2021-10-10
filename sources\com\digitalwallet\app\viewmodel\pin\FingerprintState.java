package com.digitalwallet.app.viewmodel.pin;

import au.gov.vic.service.digitalwallet.citizen.R;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\t\nB\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0012\u0010\u0003\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0012\u0010\u0007\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\u0006\u0001\u0002\u000b\f¨\u0006\r"}, d2 = {"Lcom/digitalwallet/app/viewmodel/pin/FingerprintState;", "", "()V", "colorId", "", "getColorId", "()I", "iconId", "getIconId", "Default", "Error", "Lcom/digitalwallet/app/viewmodel/pin/FingerprintState$Default;", "Lcom/digitalwallet/app/viewmodel/pin/FingerprintState$Error;", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: FingerprintState.kt */
public abstract class FingerprintState {
    public abstract int getColorId();

    public abstract int getIconId();

    private FingerprintState() {
    }

    public /* synthetic */ FingerprintState(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/digitalwallet/app/viewmodel/pin/FingerprintState$Default;", "Lcom/digitalwallet/app/viewmodel/pin/FingerprintState;", "()V", "colorId", "", "getColorId", "()I", "iconId", "getIconId", "textId", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
    /* compiled from: FingerprintState.kt */
    public static final class Default extends FingerprintState {
        public static final Default INSTANCE = new Default();
        private static final int colorId = R.color.hint_color_RES_2131034247;
        private static final int iconId = R.drawable.ic_fingerprint_64dp;
        public static final int textId = 2114650245;

        private Default() {
            super(null);
        }

        @Override // com.digitalwallet.app.viewmodel.pin.FingerprintState
        public int getColorId() {
            return colorId;
        }

        @Override // com.digitalwallet.app.viewmodel.pin.FingerprintState
        public int getIconId() {
            return iconId;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0006HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0014\u0010\u0005\u001a\u00020\u0006XD¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u0006XD¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0016"}, d2 = {"Lcom/digitalwallet/app/viewmodel/pin/FingerprintState$Error;", "Lcom/digitalwallet/app/viewmodel/pin/FingerprintState;", "message", "", "(Ljava/lang/CharSequence;)V", "colorId", "", "getColorId", "()I", "iconId", "getIconId", "getMessage", "()Ljava/lang/CharSequence;", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
    /* compiled from: FingerprintState.kt */
    public static final class Error extends FingerprintState {
        private final int colorId = R.color.warning_color_RES_2131034366;
        private final int iconId = R.drawable.ic_fingerprint_error_64dp;
        private final CharSequence message;

        public static /* synthetic */ Error copy$default(Error error, CharSequence charSequence, int i, Object obj) {
            if ((i & 1) != 0) {
                charSequence = error.message;
            }
            return error.copy(charSequence);
        }

        public final CharSequence component1() {
            return this.message;
        }

        public final Error copy(CharSequence charSequence) {
            Intrinsics.checkNotNullParameter(charSequence, "message");
            return new Error(charSequence);
        }

        public boolean equals(Object obj) {
            if (this != obj) {
                return (obj instanceof Error) && Intrinsics.areEqual(this.message, ((Error) obj).message);
            }
            return true;
        }

        public int hashCode() {
            CharSequence charSequence = this.message;
            if (charSequence != null) {
                return charSequence.hashCode();
            }
            return 0;
        }

        public String toString() {
            return "Error(message=" + this.message + ")";
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Error(CharSequence charSequence) {
            super(null);
            Intrinsics.checkNotNullParameter(charSequence, "message");
            this.message = charSequence;
        }

        public final CharSequence getMessage() {
            return this.message;
        }

        @Override // com.digitalwallet.app.viewmodel.pin.FingerprintState
        public int getIconId() {
            return this.iconId;
        }

        @Override // com.digitalwallet.app.viewmodel.pin.FingerprintState
        public int getColorId() {
            return this.colorId;
        }
    }
}
