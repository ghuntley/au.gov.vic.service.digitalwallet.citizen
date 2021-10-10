package com.digitalwallet.viewmodel.checkIn.checkInInput;

import android.text.Editable;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableField;
import androidx.lifecycle.MutableLiveData;
import au.gov.vic.service.digitalwallet.citizen.R;
import com.digitalwallet.model.CheckIn;
import com.digitalwallet.utilities.ActionEvent;
import com.digitalwallet.utilities.ActionEventKt;
import com.digitalwallet.utilities.ValidationHelperKt;
import com.digitalwallet.viewmodel.base.BaseViewModel;
import com.digitalwallet.viewmodel.checkIn.CheckInUtils;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u0000 ,2\u00020\u0001:\u0002,-B\u0005¢\u0006\u0002\u0010\u0002J\u0014\u0010#\u001a\u0010\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020\t\u0018\u00010$J\u000e\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\u000eJ\u000e\u0010)\u001a\u00020\u00132\u0006\u0010*\u001a\u00020+R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001f\u0010\u0007\u001a\u0010\u0012\f\u0012\n \n*\u0004\u0018\u00010\t0\t0\b¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001f\u0010\r\u001a\u0010\u0012\f\u0012\n \n*\u0004\u0018\u00010\u000e0\u000e0\b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR'\u0010\u0010\u001a\u0018\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u00120\u0011j\b\u0012\u0004\u0012\u00020\u0013`\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u001f\u0010\u0017\u001a\u0010\u0012\f\u0012\n \n*\u0004\u0018\u00010\u000e0\u000e0\b¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\fR'\u0010\u0019\u001a\u0018\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u00120\u0011j\b\u0012\u0004\u0012\u00020\u0013`\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0016R\u001f\u0010\u001b\u001a\u0010\u0012\f\u0012\n \n*\u0004\u0018\u00010\u000e0\u000e0\b¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\fR\u000e\u0010\u001d\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u001e\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0006R'\u0010 \u001a\u0018\u0012\n\u0012\b\u0012\u0004\u0012\u00020!0\u00120\u0011j\b\u0012\u0004\u0012\u00020!`\u0014¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0016¨\u0006."}, d2 = {"Lcom/digitalwallet/viewmodel/checkIn/checkInInput/CheckInInputBaseViewModel;", "Lcom/digitalwallet/viewmodel/base/BaseViewModel;", "()V", "allRequiredFieldsInputted", "Landroidx/databinding/ObservableBoolean;", "getAllRequiredFieldsInputted", "()Landroidx/databinding/ObservableBoolean;", "checkInCode", "Landroidx/databinding/ObservableField;", "Lcom/digitalwallet/viewmodel/checkIn/CheckInUtils$CheckInCode;", "kotlin.jvm.PlatformType", "getCheckInCode", "()Landroidx/databinding/ObservableField;", "firstName", "", "getFirstName", "hideKeyboard", "Landroidx/lifecycle/MutableLiveData;", "Lcom/digitalwallet/utilities/ActionEvent;", "", "Lcom/digitalwallet/utilities/MutableLiveEvent;", "getHideKeyboard", "()Landroidx/lifecycle/MutableLiveData;", "lastName", "getLastName", "movePhoneCursorToEnd", "getMovePhoneCursorToEnd", "phoneNumber", "getPhoneNumber", "placeholderCode", "requirePhoneNumber", "getRequirePhoneNumber", "showValidationError", "Lcom/digitalwallet/viewmodel/checkIn/checkInInput/CheckInInputBaseViewModel$ValidationError;", "getShowValidationError", "getCheckInInfo", "Lkotlin/Pair;", "Lcom/digitalwallet/model/CheckIn;", "isPhoneNumberValid", "", "number", "validateInputs", "e", "Landroid/text/Editable;", "Companion", "ValidationError", "base_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: CheckInInputBaseViewModel.kt */
public class CheckInInputBaseViewModel extends BaseViewModel {
    public static final Companion Companion = new Companion(null);
    public static final int MAX_NUMBER_LENGTH = 15;
    public static final int MINIMUM_NUMBER_LENGTH = 7;
    public static final int NATIONAL_NUMBER_LENGTH = 10;
    private final ObservableBoolean allRequiredFieldsInputted = new ObservableBoolean(false);
    private final ObservableField<CheckInUtils.CheckInCode> checkInCode;
    private final ObservableField<String> firstName = new ObservableField<>("");
    private final MutableLiveData<ActionEvent<Unit>> hideKeyboard = new MutableLiveData<>();
    private final ObservableField<String> lastName = new ObservableField<>("");
    private final MutableLiveData<ActionEvent<Unit>> movePhoneCursorToEnd = new MutableLiveData<>();
    private final ObservableField<String> phoneNumber = new ObservableField<>("");
    private final CheckInUtils.CheckInCode placeholderCode;
    private final ObservableBoolean requirePhoneNumber = new ObservableBoolean(true);
    private final MutableLiveData<ActionEvent<ValidationError>> showValidationError = new MutableLiveData<>();

    public CheckInInputBaseViewModel() {
        CheckInUtils.CheckInCode checkInCode2 = new CheckInUtils.CheckInCode("", "", "", null);
        this.placeholderCode = checkInCode2;
        this.checkInCode = new ObservableField<>(checkInCode2);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/digitalwallet/viewmodel/checkIn/checkInInput/CheckInInputBaseViewModel$Companion;", "", "()V", "MAX_NUMBER_LENGTH", "", "MINIMUM_NUMBER_LENGTH", "NATIONAL_NUMBER_LENGTH", "base_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
    /* compiled from: CheckInInputBaseViewModel.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public final ObservableField<CheckInUtils.CheckInCode> getCheckInCode() {
        return this.checkInCode;
    }

    public final ObservableField<String> getFirstName() {
        return this.firstName;
    }

    public final ObservableField<String> getLastName() {
        return this.lastName;
    }

    public final ObservableField<String> getPhoneNumber() {
        return this.phoneNumber;
    }

    public final ObservableBoolean getRequirePhoneNumber() {
        return this.requirePhoneNumber;
    }

    public final ObservableBoolean getAllRequiredFieldsInputted() {
        return this.allRequiredFieldsInputted;
    }

    public final MutableLiveData<ActionEvent<ValidationError>> getShowValidationError() {
        return this.showValidationError;
    }

    public final MutableLiveData<ActionEvent<Unit>> getMovePhoneCursorToEnd() {
        return this.movePhoneCursorToEnd;
    }

    public final MutableLiveData<ActionEvent<Unit>> getHideKeyboard() {
        return this.hideKeyboard;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00ba, code lost:
        if ((r11 == null || kotlin.text.StringsKt.isBlank(r11)) != false) goto L_0x00c3;
     */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0067  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0088  */
    public final void validateInputs(Editable editable) {
        String str;
        String str2;
        Intrinsics.checkNotNullParameter(editable, "e");
        String str3 = this.phoneNumber.get();
        if (str3 != null) {
            Objects.requireNonNull(str3, "null cannot be cast to non-null type kotlin.CharSequence");
            str = StringsKt.trim((CharSequence) str3).toString();
            if (str != null) {
                if (StringsKt.startsWith$default(str, "+61", false, 2, (Object) null)) {
                    str = StringsKt.replaceFirst$default(str, "+61", "0", false, 4, (Object) null);
                } else if (StringsKt.startsWith$default(str, "61", false, 2, (Object) null)) {
                    str = StringsKt.replaceFirst$default(str, "61", "0", false, 4, (Object) null);
                } else if (StringsKt.startsWith$default(str, "0061", false, 2, (Object) null)) {
                    str = StringsKt.replaceFirst$default(str, "0061", "0", false, 4, (Object) null);
                }
                if (!StringsKt.equals$default(str, str3, false, 2, null)) {
                    this.phoneNumber.set(str);
                    ActionEventKt.post(this.movePhoneCursorToEnd);
                }
                str2 = this.firstName.get();
                if (!(str2 != null || StringsKt.isBlank(str2))) {
                    String str4 = this.lastName.get();
                    if (!(str4 == null || StringsKt.isBlank(str4))) {
                        if (this.requirePhoneNumber.get()) {
                            String str5 = this.phoneNumber.get();
                        }
                        this.allRequiredFieldsInputted.set(true);
                        return;
                    }
                }
                this.allRequiredFieldsInputted.set(false);
            }
        }
        str = null;
        if (!StringsKt.equals$default(str, str3, false, 2, null)) {
        }
        str2 = this.firstName.get();
        if (!(str2 != null || StringsKt.isBlank(str2))) {
        }
        this.allRequiredFieldsInputted.set(false);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0055, code lost:
        if (r0 != null) goto L_0x0059;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0081, code lost:
        if ((r0.length() > 0) != false) goto L_0x0083;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0087, code lost:
        if (isPhoneNumberValid(r0) == false) goto L_0x008b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x008a, code lost:
        r4 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x008b, code lost:
        if (r1 != false) goto L_0x00de;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x008d, code lost:
        if (r3 != false) goto L_0x00de;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x008f, code lost:
        if (r4 == false) goto L_0x0092;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0092, code lost:
        r1 = r14.checkInCode.get();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x009a, code lost:
        if (r1 == null) goto L_0x009d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x009d, code lost:
        r1 = r14.placeholderCode;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x009f, code lost:
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, "checkInCode.get() ?: placeholderCode");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00ab, code lost:
        if (kotlin.text.StringsKt.isBlank(r0) == false) goto L_0x00af;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00ad, code lost:
        r7 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00af, code lost:
        r7 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00b0, code lost:
        r0 = java.util.Calendar.getInstance();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, "Calendar.getInstance()");
        r8 = r0.getTime();
        r9 = java.util.UUID.randomUUID().toString();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r9, "UUID.randomUUID().toString()");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00dd, code lost:
        return kotlin.TuplesKt.to(new com.digitalwallet.model.CheckIn(r1.getPayload(), r5, r6, r7, r8, r9, null, null, org.objectweb.asm.Opcodes.CHECKCAST, null), r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00de, code lost:
        com.digitalwallet.utilities.ActionEventKt.postEvent(r14.showValidationError, new com.digitalwallet.viewmodel.checkIn.checkInInput.CheckInInputBaseViewModel.ValidationError(r1, r3, r4));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00e8, code lost:
        return null;
     */
    public final Pair<CheckIn, CheckInUtils.CheckInCode> getCheckInInfo() {
        String str;
        String str2;
        String str3;
        ActionEventKt.post(this.hideKeyboard);
        String str4 = this.firstName.get();
        if (str4 != null) {
            Objects.requireNonNull(str4, "null cannot be cast to non-null type kotlin.CharSequence");
            str = StringsKt.trim((CharSequence) str4).toString();
        } else {
            str = null;
        }
        String str5 = this.lastName.get();
        if (str5 != null) {
            Objects.requireNonNull(str5, "null cannot be cast to non-null type kotlin.CharSequence");
            str2 = StringsKt.trim((CharSequence) str5).toString();
        } else {
            str2 = null;
        }
        String str6 = this.phoneNumber.get();
        String str7 = "";
        if (str6 != null) {
            Objects.requireNonNull(str6, "null cannot be cast to non-null type kotlin.CharSequence");
            str3 = StringsKt.trim((CharSequence) str6).toString();
        }
        str3 = str7;
        boolean z = true;
        boolean z2 = !ValidationHelperKt.isNameValid(str != null ? str : str7);
        if (str2 != null) {
            str7 = str2;
        }
        boolean z3 = !ValidationHelperKt.isNameValid(str7);
        if (!this.requirePhoneNumber.get()) {
        }
    }

    public final boolean isPhoneNumberValid(String str) {
        Intrinsics.checkNotNullParameter(str, "number");
        if (str.length() < 7) {
            return false;
        }
        String obj = StringsKt.trim((CharSequence) str).toString();
        if (StringsKt.startsWith$default(obj, "+", false, 2, (Object) null)) {
            obj = StringsKt.drop(obj, 1);
        }
        String str2 = obj;
        StringBuilder sb = new StringBuilder();
        int length = str2.length();
        for (int i = 0; i < length; i++) {
            char charAt = str2.charAt(i);
            if (Character.isDigit(charAt)) {
                sb.append(charAt);
            }
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "filterTo(StringBuilder(), predicate).toString()");
        if (StringsKt.startsWith$default(sb2, "000", false, 2, (Object) null)) {
            return false;
        }
        boolean z = StringsKt.startsWith$default(sb2, "0", false, 2, null) && StringsKt.contains$default("23478", sb2.charAt(1), false, 2, null);
        int length2 = sb2.length();
        if (z) {
            if (length2 != 10) {
                return false;
            }
        } else if (7 > length2 || 15 < length2) {
            return false;
        }
        return true;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\r\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u0011\u001a\u00020\u0003HÂ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÂ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÂ\u0003J'\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00032\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\fHÖ\u0001J\t\u0010\u0018\u001a\u00020\bHÖ\u0001R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u0005\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u000f\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u000e\u0010\u0004\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/digitalwallet/viewmodel/checkIn/checkInInput/CheckInInputBaseViewModel$ValidationError;", "", "firstNameInvalid", "", "lastNameInvalid", "contactNumberInvalid", "(ZZZ)V", "analyticsContentType", "", "getAnalyticsContentType", "()Ljava/lang/String;", "dialogMessageId", "", "getDialogMessageId", "()I", "focusFieldIndex", "getFocusFieldIndex", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "toString", "base_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
    /* compiled from: CheckInInputBaseViewModel.kt */
    public static final class ValidationError {
        private final String analyticsContentType;
        private final boolean contactNumberInvalid;
        private final int dialogMessageId;
        private final boolean firstNameInvalid;
        private final int focusFieldIndex;
        private final boolean lastNameInvalid;

        private final boolean component1() {
            return this.firstNameInvalid;
        }

        private final boolean component2() {
            return this.lastNameInvalid;
        }

        private final boolean component3() {
            return this.contactNumberInvalid;
        }

        public static /* synthetic */ ValidationError copy$default(ValidationError validationError, boolean z, boolean z2, boolean z3, int i, Object obj) {
            if ((i & 1) != 0) {
                z = validationError.firstNameInvalid;
            }
            if ((i & 2) != 0) {
                z2 = validationError.lastNameInvalid;
            }
            if ((i & 4) != 0) {
                z3 = validationError.contactNumberInvalid;
            }
            return validationError.copy(z, z2, z3);
        }

        public final ValidationError copy(boolean z, boolean z2, boolean z3) {
            return new ValidationError(z, z2, z3);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ValidationError)) {
                return false;
            }
            ValidationError validationError = (ValidationError) obj;
            return this.firstNameInvalid == validationError.firstNameInvalid && this.lastNameInvalid == validationError.lastNameInvalid && this.contactNumberInvalid == validationError.contactNumberInvalid;
        }

        public int hashCode() {
            boolean z = this.firstNameInvalid;
            int i = 1;
            if (z) {
                z = true;
            }
            int i2 = z ? 1 : 0;
            int i3 = z ? 1 : 0;
            int i4 = z ? 1 : 0;
            int i5 = i2 * 31;
            boolean z2 = this.lastNameInvalid;
            if (z2) {
                z2 = true;
            }
            int i6 = z2 ? 1 : 0;
            int i7 = z2 ? 1 : 0;
            int i8 = z2 ? 1 : 0;
            int i9 = (i5 + i6) * 31;
            boolean z3 = this.contactNumberInvalid;
            if (!z3) {
                i = z3 ? 1 : 0;
            }
            return i9 + i;
        }

        public String toString() {
            return "ValidationError(firstNameInvalid=" + this.firstNameInvalid + ", lastNameInvalid=" + this.lastNameInvalid + ", contactNumberInvalid=" + this.contactNumberInvalid + ")";
        }

        public ValidationError(boolean z, boolean z2, boolean z3) {
            this.firstNameInvalid = z;
            this.lastNameInvalid = z2;
            this.contactNumberInvalid = z3;
            int i = R.string.check_in_validation_dialog_message_names_number;
            if (!z || !z2 || !z3) {
                if (z && z3) {
                    i = R.string.check_in_validation_dialog_message_firstname_number;
                } else if (z2 && z3) {
                    i = R.string.check_in_validation_dialog_message_lastname_number;
                } else if (z && z2) {
                    i = R.string.check_in_validation_dialog_message_names;
                } else if (z) {
                    i = R.string.check_in_validation_dialog_message_firstname;
                } else if (z2) {
                    i = R.string.check_in_validation_dialog_message_lastname;
                } else if (z3) {
                    i = R.string.check_in_validation_dialog_message_number;
                }
            }
            this.dialogMessageId = i;
            this.focusFieldIndex = z ? 0 : z2 ? 1 : 2;
            this.analyticsContentType = (z || z2 || !z3) ? null : "Check in - Invalid Phone Number";
        }

        public final int getDialogMessageId() {
            return this.dialogMessageId;
        }

        public final int getFocusFieldIndex() {
            return this.focusFieldIndex;
        }

        public final String getAnalyticsContentType() {
            return this.analyticsContentType;
        }
    }
}
