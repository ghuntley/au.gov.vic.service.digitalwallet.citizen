package com.digitalwallet.app.view.util;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.databinding.BindingAdapter;
import androidx.lifecycle.MutableLiveData;
import au.gov.vic.service.digitalwallet.citizen.R;
import com.digitalwallet.app.viewmodel.main.addsync.CardSyncViewState;
import com.digitalwallet.app.viewmodel.pin.FingerprintState;
import com.digitalwallet.utilities.DateFormattingHelper;
import com.google.android.gms.analytics.ecommerce.Promotion;
import java.util.Date;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000X\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001a\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0007\u001a\u0018\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H\u0007\u001a\u0018\u0010\b\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH\u0007\u001a\u0018\u0010\u000b\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0007\u001a\u0018\u0010\u0010\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000fH\u0007\u001a\u0018\u0010\u0011\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000fH\u0007\u001a\u0018\u0010\u0012\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\u00132\u0006\u0010\u000e\u001a\u00020\u000fH\u0007\u001a\u001e\u0010\u0014\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\u00032\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016H\u0007\u001a\u0018\u0010\u0018\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\u00132\u0006\u0010\u000e\u001a\u00020\u000fH\u0007\u001a\u0018\u0010\u0019\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\u0007H\u0007\u001a\u001e\u0010\u001b\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u001c0\u0016H\u0007\u001a\u0018\u0010\u001d\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\u001e2\u0006\u0010\u000e\u001a\u00020\u001fH\u0007\u001a\u0018\u0010 \u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u001fH\u0007¨\u0006!"}, d2 = {"bindServerDate", "", "textView", "Landroid/widget/TextView;", "date", "Ljava/util/Date;", "goneWhenEmpty", "", "setDrawableTop", "resource", "", "setEligibilityCompleteButtonText", Promotion.ACTION_VIEW, "Landroid/widget/Button;", "viewState", "Lcom/digitalwallet/app/view/util/ScannerViewState;", "setEligibilityCompleteSubtitle", "setEligibilityCompleteTitleResources", "setEligibilityCompleteVisibility", "Landroid/view/View;", "setEligibilityCustomError", "customText", "Landroidx/lifecycle/MutableLiveData;", "", "setScannerPendingVisibility", "setVisibleOrGone", "condition", "updateCardSyncPrimaryBtn", "Lcom/digitalwallet/app/viewmodel/main/addsync/CardSyncViewState;", "updateFingerprintIcon", "Landroid/widget/ImageView;", "Lcom/digitalwallet/app/viewmodel/pin/FingerprintState;", "updateFingerprintText", "app_citizenProdRelease"}, k = 2, mv = {1, 4, 0})
/* compiled from: BindingAdapters.kt */
public final class BindingAdaptersKt {

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 0})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;
        public static final /* synthetic */ int[] $EnumSwitchMapping$2;
        public static final /* synthetic */ int[] $EnumSwitchMapping$3;

        static {
            int[] iArr = new int[ScannerViewState.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[ScannerViewState.SUCCESS.ordinal()] = 1;
            iArr[ScannerViewState.ERROR.ordinal()] = 2;
            iArr[ScannerViewState.INVALID.ordinal()] = 3;
            int[] iArr2 = new int[ScannerViewState.values().length];
            $EnumSwitchMapping$1 = iArr2;
            iArr2[ScannerViewState.SUCCESS.ordinal()] = 1;
            iArr2[ScannerViewState.ERROR.ordinal()] = 2;
            int[] iArr3 = new int[ScannerViewState.values().length];
            $EnumSwitchMapping$2 = iArr3;
            iArr3[ScannerViewState.SUCCESS.ordinal()] = 1;
            iArr3[ScannerViewState.ERROR.ordinal()] = 2;
            iArr3[ScannerViewState.INVALID.ordinal()] = 3;
            int[] iArr4 = new int[CardSyncViewState.values().length];
            $EnumSwitchMapping$3 = iArr4;
            iArr4[CardSyncViewState.HOLDINGS.ordinal()] = 1;
        }
    }

    @BindingAdapter({"date_ddMMyyyy"})
    public static final void bindServerDate(TextView textView, Date date) {
        Intrinsics.checkNotNullParameter(textView, "textView");
        textView.setText(date != null ? DateFormattingHelper.INSTANCE.toStringMonthAsWord(date) : null);
    }

    @BindingAdapter({"visibleOrGone"})
    public static final void setVisibleOrGone(View view, boolean z) {
        Intrinsics.checkNotNullParameter(view, Promotion.ACTION_VIEW);
        view.setVisibility(z ? 0 : 8);
    }

    @BindingAdapter({"goneWhenEmpty"})
    public static final void goneWhenEmpty(TextView textView, boolean z) {
        Intrinsics.checkNotNullParameter(textView, "textView");
        CharSequence text = textView.getText();
        int i = 0;
        if ((text == null || text.length() == 0) && z) {
            i = 8;
        }
        textView.setVisibility(i);
    }

    @BindingAdapter({"android:drawableTop"})
    public static final void setDrawableTop(TextView textView, int i) {
        Intrinsics.checkNotNullParameter(textView, "textView");
        textView.setCompoundDrawablesRelativeWithIntrinsicBounds(0, i, 0, 0);
    }

    @BindingAdapter({"eligibilityPendingVisibility"})
    public static final void setScannerPendingVisibility(View view, ScannerViewState scannerViewState) {
        Intrinsics.checkNotNullParameter(view, Promotion.ACTION_VIEW);
        Intrinsics.checkNotNullParameter(scannerViewState, "viewState");
        com.digitalwallet.view.util.BindingAdaptersKt.setVisibleOrGone(view, CollectionsKt.listOf((Object[]) new ScannerViewState[]{ScannerViewState.VERIFYING, ScannerViewState.SCANNING}).contains(scannerViewState));
    }

    @BindingAdapter({"eligibilityCompleteVisibility"})
    public static final void setEligibilityCompleteVisibility(View view, ScannerViewState scannerViewState) {
        Intrinsics.checkNotNullParameter(view, Promotion.ACTION_VIEW);
        Intrinsics.checkNotNullParameter(scannerViewState, "viewState");
        com.digitalwallet.view.util.BindingAdaptersKt.setVisibleOrGone(view, CollectionsKt.listOf((Object[]) new ScannerViewState[]{ScannerViewState.SUCCESS, ScannerViewState.ERROR, ScannerViewState.INVALID}).contains(scannerViewState));
    }

    @BindingAdapter({"eligibilityCompleteTitle"})
    public static final void setEligibilityCompleteTitleResources(TextView textView, ScannerViewState scannerViewState) {
        Pair pair;
        Intrinsics.checkNotNullParameter(textView, Promotion.ACTION_VIEW);
        Intrinsics.checkNotNullParameter(scannerViewState, "viewState");
        int i = WhenMappings.$EnumSwitchMapping$0[scannerViewState.ordinal()];
        if (i == 1) {
            pair = new Pair(Integer.valueOf((int) R.string.scanner_success_title), Integer.valueOf((int) R.drawable.ic_icon_success));
        } else if (i == 2) {
            pair = new Pair(Integer.valueOf((int) R.string.scanner_error_title), Integer.valueOf((int) R.drawable.ic_icon_notice));
        } else if (i != 3) {
            pair = new Pair(Integer.valueOf((int) R.string.empty_string_RES_2114650224), Integer.valueOf((int) R.drawable.ic_icon_notice));
        } else {
            pair = new Pair(Integer.valueOf((int) R.string.scanner_invalid_title), Integer.valueOf((int) R.drawable.ic_red_cross));
        }
        int intValue = ((Number) pair.component1()).intValue();
        int intValue2 = ((Number) pair.component2()).intValue();
        textView.setText(intValue);
        setDrawableTop(textView, intValue2);
    }

    @BindingAdapter({"eligibilityCompleteSubtitle"})
    public static final void setEligibilityCompleteSubtitle(TextView textView, ScannerViewState scannerViewState) {
        Intrinsics.checkNotNullParameter(textView, Promotion.ACTION_VIEW);
        Intrinsics.checkNotNullParameter(scannerViewState, "viewState");
        com.digitalwallet.view.util.BindingAdaptersKt.setVisibleOrGone(textView, scannerViewState != ScannerViewState.INVALID);
        int i = WhenMappings.$EnumSwitchMapping$1[scannerViewState.ordinal()];
        textView.setText(i != 1 ? i != 2 ? R.string.empty_string_RES_2114650224 : R.string.scanner_error_text : R.string.scanner_success_text);
    }

    @BindingAdapter({"eligibilityCustomError"})
    public static final void setEligibilityCustomError(TextView textView, MutableLiveData<String> mutableLiveData) {
        Intrinsics.checkNotNullParameter(textView, Promotion.ACTION_VIEW);
        Intrinsics.checkNotNullParameter(mutableLiveData, "customText");
        TextView textView2 = textView;
        String value = mutableLiveData.getValue();
        com.digitalwallet.view.util.BindingAdaptersKt.setVisibleOrGone(textView2, !(value == null || value.length() == 0));
        textView.setText(mutableLiveData.getValue());
    }

    @BindingAdapter({"eligibilityCompleteButtonText"})
    public static final void setEligibilityCompleteButtonText(Button button, ScannerViewState scannerViewState) {
        Intrinsics.checkNotNullParameter(button, Promotion.ACTION_VIEW);
        Intrinsics.checkNotNullParameter(scannerViewState, "viewState");
        int i = WhenMappings.$EnumSwitchMapping$2[scannerViewState.ordinal()];
        button.setText(i != 1 ? (i == 2 || i == 3) ? R.string.scanner_close : R.string.empty_string_RES_2114650224 : R.string.scanner_done);
    }

    @BindingAdapter({"cardSyncPrimaryBtn"})
    public static final void updateCardSyncPrimaryBtn(Button button, MutableLiveData<CardSyncViewState> mutableLiveData) {
        Intrinsics.checkNotNullParameter(button, Promotion.ACTION_VIEW);
        Intrinsics.checkNotNullParameter(mutableLiveData, "viewState");
        CardSyncViewState value = mutableLiveData.getValue();
        button.setVisibility((value != null && WhenMappings.$EnumSwitchMapping$3[value.ordinal()] == 1) ? 0 : 8);
    }

    @BindingAdapter({"fingerprintText"})
    public static final void updateFingerprintText(TextView textView, FingerprintState fingerprintState) {
        Intrinsics.checkNotNullParameter(textView, Promotion.ACTION_VIEW);
        Intrinsics.checkNotNullParameter(fingerprintState, "viewState");
        if (Intrinsics.areEqual(fingerprintState, FingerprintState.Default.INSTANCE)) {
            FingerprintState.Default r0 = (FingerprintState.Default) fingerprintState;
            textView.setText(R.string.fingerprint_hint);
        } else if (fingerprintState instanceof FingerprintState.Error) {
            textView.setText(((FingerprintState.Error) fingerprintState).getMessage());
        }
        textView.setTextColor(ContextCompat.getColor(textView.getContext(), fingerprintState.getColorId()));
    }

    @BindingAdapter({"fingerprintIcon"})
    public static final void updateFingerprintIcon(ImageView imageView, FingerprintState fingerprintState) {
        Intrinsics.checkNotNullParameter(imageView, Promotion.ACTION_VIEW);
        Intrinsics.checkNotNullParameter(fingerprintState, "viewState");
        imageView.setImageResource(fingerprintState.getIconId());
    }
}
