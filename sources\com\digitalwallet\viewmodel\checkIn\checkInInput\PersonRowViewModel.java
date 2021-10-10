package com.digitalwallet.viewmodel.checkIn.checkInInput;

import android.content.Context;
import androidx.databinding.ObservableBoolean;
import au.gov.vic.service.digitalwallet.citizen.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001BO\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0006\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\u0002\u0010\rJ\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÂ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u000b0\nHÂ\u0003J\u000f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u000b0\nHÂ\u0003Ja\u0010%\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00062\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nHÆ\u0001J\u0006\u0010&\u001a\u00020\u000bJ\u0013\u0010'\u001a\u00020\u00032\b\u0010(\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010)\u001a\u00020*HÖ\u0001J\u000e\u0010+\u001a\u00020\u00062\u0006\u0010,\u001a\u00020-J\t\u0010.\u001a\u00020\u0006HÖ\u0001R\u0016\u0010\u000e\u001a\u00020\u000bX\u0004¢\u0006\n\n\u0002\u0010\u0011\u0012\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0012\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0018\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0017R\u000e\u0010\u0004\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0017R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0017R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001d¨\u0006/"}, d2 = {"Lcom/digitalwallet/viewmodel/checkIn/checkInInput/PersonRowViewModel;", "", "showCheckBox", "", "initiallyChecked", "firstName", "", "lastName", "phoneNumber", "onCheckChanged", "Lkotlin/Function0;", "", "onEditClicked", "(ZZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "_checkChanged", "get_checkChanged$annotations", "()V", "Lkotlin/Unit;", "checked", "Landroidx/databinding/ObservableBoolean;", "getChecked", "()Landroidx/databinding/ObservableBoolean;", "getFirstName", "()Ljava/lang/String;", "fullName", "getFullName", "getLastName", "getPhoneNumber", "getShowCheckBox", "()Z", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "doOnEdit", "equals", "other", "hashCode", "", "phoneNumberDisplay", "context", "Landroid/content/Context;", "toString", "base_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: CheckInSummaryViewModel.kt */
public final class PersonRowViewModel {
    private final Unit _checkChanged = Unit.INSTANCE;
    private final ObservableBoolean checked;
    private final String firstName;
    private final String fullName;
    private final boolean initiallyChecked;
    private final String lastName;
    private final Function0<Unit> onCheckChanged;
    private final Function0<Unit> onEditClicked;
    private final String phoneNumber;
    private final boolean showCheckBox;

    private final boolean component2() {
        return this.initiallyChecked;
    }

    private final Function0<Unit> component6() {
        return this.onCheckChanged;
    }

    private final Function0<Unit> component7() {
        return this.onEditClicked;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: com.digitalwallet.viewmodel.checkIn.checkInInput.PersonRowViewModel */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PersonRowViewModel copy$default(PersonRowViewModel personRowViewModel, boolean z, boolean z2, String str, String str2, String str3, Function0 function0, Function0 function02, int i, Object obj) {
        if ((i & 1) != 0) {
            z = personRowViewModel.showCheckBox;
        }
        if ((i & 2) != 0) {
            z2 = personRowViewModel.initiallyChecked;
        }
        if ((i & 4) != 0) {
            str = personRowViewModel.firstName;
        }
        if ((i & 8) != 0) {
            str2 = personRowViewModel.lastName;
        }
        if ((i & 16) != 0) {
            str3 = personRowViewModel.phoneNumber;
        }
        if ((i & 32) != 0) {
            function0 = personRowViewModel.onCheckChanged;
        }
        if ((i & 64) != 0) {
            function02 = personRowViewModel.onEditClicked;
        }
        return personRowViewModel.copy(z, z2, str, str2, str3, function0, function02);
    }

    private static /* synthetic */ void get_checkChanged$annotations() {
    }

    public final boolean component1() {
        return this.showCheckBox;
    }

    public final String component3() {
        return this.firstName;
    }

    public final String component4() {
        return this.lastName;
    }

    public final String component5() {
        return this.phoneNumber;
    }

    public final PersonRowViewModel copy(boolean z, boolean z2, String str, String str2, String str3, Function0<Unit> function0, Function0<Unit> function02) {
        Intrinsics.checkNotNullParameter(function0, "onCheckChanged");
        Intrinsics.checkNotNullParameter(function02, "onEditClicked");
        return new PersonRowViewModel(z, z2, str, str2, str3, function0, function02);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PersonRowViewModel)) {
            return false;
        }
        PersonRowViewModel personRowViewModel = (PersonRowViewModel) obj;
        return this.showCheckBox == personRowViewModel.showCheckBox && this.initiallyChecked == personRowViewModel.initiallyChecked && Intrinsics.areEqual(this.firstName, personRowViewModel.firstName) && Intrinsics.areEqual(this.lastName, personRowViewModel.lastName) && Intrinsics.areEqual(this.phoneNumber, personRowViewModel.phoneNumber) && Intrinsics.areEqual(this.onCheckChanged, personRowViewModel.onCheckChanged) && Intrinsics.areEqual(this.onEditClicked, personRowViewModel.onEditClicked);
    }

    public int hashCode() {
        boolean z = this.showCheckBox;
        int i = 1;
        if (z) {
            z = true;
        }
        int i2 = z ? 1 : 0;
        int i3 = z ? 1 : 0;
        int i4 = z ? 1 : 0;
        int i5 = i2 * 31;
        boolean z2 = this.initiallyChecked;
        if (!z2) {
            i = z2 ? 1 : 0;
        }
        int i6 = (i5 + i) * 31;
        String str = this.firstName;
        int i7 = 0;
        int hashCode = (i6 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.lastName;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.phoneNumber;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        Function0<Unit> function0 = this.onCheckChanged;
        int hashCode4 = (hashCode3 + (function0 != null ? function0.hashCode() : 0)) * 31;
        Function0<Unit> function02 = this.onEditClicked;
        if (function02 != null) {
            i7 = function02.hashCode();
        }
        return hashCode4 + i7;
    }

    public String toString() {
        return "PersonRowViewModel(showCheckBox=" + this.showCheckBox + ", initiallyChecked=" + this.initiallyChecked + ", firstName=" + this.firstName + ", lastName=" + this.lastName + ", phoneNumber=" + this.phoneNumber + ", onCheckChanged=" + this.onCheckChanged + ", onEditClicked=" + this.onEditClicked + ")";
    }

    public PersonRowViewModel(boolean z, boolean z2, String str, String str2, String str3, Function0<Unit> function0, Function0<Unit> function02) {
        Intrinsics.checkNotNullParameter(function0, "onCheckChanged");
        Intrinsics.checkNotNullParameter(function02, "onEditClicked");
        this.showCheckBox = z;
        this.initiallyChecked = z2;
        this.firstName = str;
        this.lastName = str2;
        this.phoneNumber = str3;
        this.onCheckChanged = function0;
        this.onEditClicked = function02;
        ObservableBoolean observableBoolean = new ObservableBoolean(z2);
        this.checked = observableBoolean;
        observableBoolean.addOnPropertyChangedCallback(new PersonRowViewModel$_checkChanged$1(this));
        StringBuilder sb = new StringBuilder();
        sb.append(str == null ? "" : str);
        sb.append(" ");
        sb.append(str2 == null ? "" : str2);
        this.fullName = sb.toString();
    }

    public final boolean getShowCheckBox() {
        return this.showCheckBox;
    }

    public final String getFirstName() {
        return this.firstName;
    }

    public final String getLastName() {
        return this.lastName;
    }

    public final String getPhoneNumber() {
        return this.phoneNumber;
    }

    public final ObservableBoolean getChecked() {
        return this.checked;
    }

    public final String getFullName() {
        return this.fullName;
    }

    public final String phoneNumberDisplay(Context context) {
        String str;
        Intrinsics.checkNotNullParameter(context, "context");
        String str2 = this.phoneNumber;
        if (str2 == null || StringsKt.isBlank(str2)) {
            str = context.getString(R.string.check_in_no_phone_number);
        } else {
            str = this.phoneNumber;
        }
        Intrinsics.checkNotNullExpressionValue(str, "if (phoneNumber.isNullOr…        phoneNumber\n    }");
        return str;
    }

    public final void doOnEdit() {
        this.onEditClicked.invoke();
    }
}
