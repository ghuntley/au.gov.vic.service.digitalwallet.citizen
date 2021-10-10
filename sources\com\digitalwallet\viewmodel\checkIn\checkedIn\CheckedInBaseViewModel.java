package com.digitalwallet.viewmodel.checkIn.checkedIn;

import android.content.Context;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableField;
import androidx.databinding.ObservableInt;
import au.gov.vic.service.digitalwallet.citizen.R;
import com.digitalwallet.model.CheckIn;
import com.digitalwallet.model.CheckInGuest;
import com.digitalwallet.utilities.DateFormattingHelper;
import com.digitalwallet.viewmodel.base.BaseViewModel;
import com.digitalwallet.viewmodel.checkIn.checkInRepository.CheckInRepository;
import java.util.Date;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0016\u0010 \u001a\u00020!2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020$0#H\u0002J\u0010\u0010%\u001a\u00020!2\u0006\u0010\r\u001a\u00020\u000eH\u0016R\u001f\u0010\u0007\u001a\u0010\u0012\f\u0012\n \n*\u0004\u0018\u00010\t0\t0\b¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u000eX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u001f\u0010\u0013\u001a\u0010\u0012\f\u0012\n \n*\u0004\u0018\u00010\t0\t0\b¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\fR\u0011\u0010\u0015\u001a\u00020\u0016¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0019\u001a\u00020\u001a¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001bR\u001f\u0010\u001c\u001a\u0010\u0012\f\u0012\n \n*\u0004\u0018\u00010\t0\t0\b¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\fR\u001f\u0010\u001e\u001a\u0010\u0012\f\u0012\n \n*\u0004\u0018\u00010\t0\t0\b¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\f¨\u0006&"}, d2 = {"Lcom/digitalwallet/viewmodel/checkIn/checkedIn/CheckedInBaseViewModel;", "Lcom/digitalwallet/viewmodel/base/BaseViewModel;", "context", "Landroid/content/Context;", "checkInRepository", "Lcom/digitalwallet/viewmodel/checkIn/checkInRepository/CheckInRepository;", "(Landroid/content/Context;Lcom/digitalwallet/viewmodel/checkIn/checkInRepository/CheckInRepository;)V", "briefCheckedInText", "Landroidx/databinding/ObservableField;", "", "kotlin.jvm.PlatformType", "getBriefCheckedInText", "()Landroidx/databinding/ObservableField;", "checkInItem", "Lcom/digitalwallet/model/CheckIn;", "getCheckInItem", "()Lcom/digitalwallet/model/CheckIn;", "setCheckInItem", "(Lcom/digitalwallet/model/CheckIn;)V", "detailedCheckedInText", "getDetailedCheckedInText", "guestCount", "Landroidx/databinding/ObservableInt;", "getGuestCount", "()Landroidx/databinding/ObservableInt;", "isActiveCheckIn", "Landroidx/databinding/ObservableBoolean;", "()Landroidx/databinding/ObservableBoolean;", "locationName", "getLocationName", "time", "getTime", "setCheckedInText", "", "guests", "", "Lcom/digitalwallet/model/CheckInGuest;", "setup", "base_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: CheckedInBaseViewModels.kt */
public class CheckedInBaseViewModel extends BaseViewModel {
    private final ObservableField<String> briefCheckedInText = new ObservableField<>("");
    public CheckIn checkInItem;
    private final CheckInRepository checkInRepository;
    private final Context context;
    private final ObservableField<String> detailedCheckedInText = new ObservableField<>("");
    private final ObservableInt guestCount = new ObservableInt(0);
    private final ObservableBoolean isActiveCheckIn = new ObservableBoolean(false);
    private final ObservableField<String> locationName = new ObservableField<>("");
    private final ObservableField<String> time = new ObservableField<>("");

    public CheckedInBaseViewModel(Context context2, CheckInRepository checkInRepository2) {
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(checkInRepository2, "checkInRepository");
        this.context = context2;
        this.checkInRepository = checkInRepository2;
    }

    public final CheckIn getCheckInItem() {
        CheckIn checkIn = this.checkInItem;
        if (checkIn == null) {
            Intrinsics.throwUninitializedPropertyAccessException("checkInItem");
        }
        return checkIn;
    }

    public final void setCheckInItem(CheckIn checkIn) {
        Intrinsics.checkNotNullParameter(checkIn, "<set-?>");
        this.checkInItem = checkIn;
    }

    public final ObservableBoolean isActiveCheckIn() {
        return this.isActiveCheckIn;
    }

    public final ObservableField<String> getLocationName() {
        return this.locationName;
    }

    public final ObservableField<String> getTime() {
        return this.time;
    }

    public final ObservableInt getGuestCount() {
        return this.guestCount;
    }

    public final ObservableField<String> getBriefCheckedInText() {
        return this.briefCheckedInText;
    }

    public final ObservableField<String> getDetailedCheckedInText() {
        return this.detailedCheckedInText;
    }

    public void setup(CheckIn checkIn) {
        Intrinsics.checkNotNullParameter(checkIn, "checkInItem");
        this.checkInItem = checkIn;
        this.isActiveCheckIn.set(this.checkInRepository.isActiveCheckIn(checkIn));
        this.locationName.set(checkIn.getLocationName());
        ObservableField<String> observableField = this.time;
        Date date = checkIn.getDate();
        observableField.set(date != null ? DateFormattingHelper.INSTANCE.toCheckInDateTimeString(date) : null);
        List<CheckInGuest> guests = checkIn.getGuests();
        if (guests == null) {
            guests = CollectionsKt.emptyList();
        }
        setCheckedInText(guests);
    }

    private final void setCheckedInText(List<CheckInGuest> list) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        boolean z = this.isActiveCheckIn.get();
        int size = list.size();
        this.guestCount.set(size);
        ObservableField<String> observableField = this.briefCheckedInText;
        if (size == 0) {
            str = this.context.getString(R.string.checked_in);
        } else if (size != 1) {
            str = this.context.getString(R.string.checked_in_with_n_dependants, Integer.valueOf(size));
        } else {
            str = this.context.getString(R.string.checked_in_with_1_dependant);
        }
        observableField.set(str);
        if (size == 0) {
            if (z) {
                str3 = this.context.getString(R.string.checked_in);
                Intrinsics.checkNotNullExpressionValue(str3, "context.getString(R.string.checked_in)");
            } else {
                str3 = this.context.getString(R.string.you_were_checked_in);
                Intrinsics.checkNotNullExpressionValue(str3, "context.getString(R.string.you_were_checked_in)");
            }
            str2 = "";
        } else {
            if (z) {
                str4 = this.context.getString(R.string.checked_in_with);
                Intrinsics.checkNotNullExpressionValue(str4, "context.getString(R.string.checked_in_with)");
            } else {
                str4 = this.context.getString(R.string.you_were_checked_in_with);
                Intrinsics.checkNotNullExpressionValue(str4, "context.getString(R.stri…you_were_checked_in_with)");
            }
            StringBuilder sb = new StringBuilder();
            sb.append("\n");
            if (size == 1) {
                str5 = list.get(0).getAbbreviatedFullName();
            } else {
                StringBuilder sb2 = new StringBuilder();
                int i = size - 1;
                sb2.append(CollectionsKt.joinToString$default(CollectionsKt.take(list, i), null, null, null, 0, null, CheckedInBaseViewModel$setCheckedInText$1.INSTANCE, 31, null));
                sb2.append(" & ");
                sb2.append(list.get(i).getAbbreviatedFullName());
                str5 = sb2.toString();
            }
            sb.append(str5);
            str2 = sb.toString();
            str3 = str4;
        }
        ObservableField<String> observableField2 = this.detailedCheckedInText;
        observableField2.set(str3 + str2);
    }
}
