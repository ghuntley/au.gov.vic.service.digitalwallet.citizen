package com.digitalwallet.app.view.main;

import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.digitalwallet.app.R;
import com.digitalwallet.app.databinding.FragmentSharingDetailsBinding;
import com.digitalwallet.app.model.AttributeDetailItem;
import com.digitalwallet.app.model.db.shares.ShareRecord;
import com.digitalwallet.app.view.util.BindingAdaptersKt;
import com.digitalwallet.app.view.util.ViewUtilsKt;
import com.digitalwallet.utilities.AppType;
import com.digitalwallet.utilities.ServerTypeKt;
import com.digitalwallet.view.base.BasicFragment;
import com.google.android.gms.analytics.ecommerce.Promotion;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0005¢\u0006\u0002\u0010\u0002J&\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\u001a\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016¨\u0006\u000f"}, d2 = {"Lcom/digitalwallet/app/view/main/SharingDetailsFragment;", "Lcom/digitalwallet/view/base/BasicFragment;", "()V", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", Promotion.ACTION_VIEW, "Companion", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: SharingDetailsFragment.kt */
public final class SharingDetailsFragment extends BasicFragment {
    public static final Companion Companion = new Companion(null);
    private static final String RECIPIENT_DETAILS_KEY = "RECIPIENT_DETAILS";
    private static final String SENDER_DETAILS_KEY = "SENDER_DETAILS";
    private static final String TRANSACTION_RESPONSE_KEY = "TRANSACTION_RESPONSE";
    private HashMap _$_findViewCache;

    @Override // com.digitalwallet.view.base.BasicFragment
    public void _$_clearFindViewByIdCache() {
        HashMap hashMap = this._$_findViewCache;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    @Override // com.digitalwallet.view.base.BasicFragment
    public View _$_findCachedViewById(int i) {
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i);
        this._$_findViewCache.put(Integer.valueOf(i), findViewById);
        return findViewById;
    }

    @Override // androidx.fragment.app.Fragment, com.digitalwallet.view.base.BasicFragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        boolean z = false;
        FragmentSharingDetailsBinding inflate = FragmentSharingDetailsBinding.inflate(layoutInflater, viewGroup, false);
        LinearLayout linearLayout = inflate.sharedWithContainer;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "sharedWithContainer");
        LinearLayout linearLayout2 = linearLayout;
        if (ServerTypeKt.getAppType() == AppType.CITIZEN) {
            z = true;
        }
        BindingAdaptersKt.setVisibleOrGone(linearLayout2, z);
        Intrinsics.checkNotNullExpressionValue(inflate, "FragmentSharingDetailsBi…pe.CITIZEN)\n            }");
        return inflate.getRoot();
    }

    @Override // androidx.fragment.app.Fragment, com.digitalwallet.view.base.BasicFragment
    public void onViewCreated(View view, Bundle bundle) {
        Parcelable[] parcelableArray;
        Parcelable[] parcelableArray2;
        Intrinsics.checkNotNullParameter(view, Promotion.ACTION_VIEW);
        super.onViewCreated(view, bundle);
        Bundle arguments = getArguments();
        if (arguments == null || (parcelableArray2 = arguments.getParcelableArray(SENDER_DETAILS_KEY)) == null) {
            getParentFragmentManager().popBackStackImmediate();
        } else {
            ArrayList arrayList = new ArrayList();
            for (Parcelable parcelable : parcelableArray2) {
                if (parcelable instanceof AttributeDetailItem) {
                    arrayList.add(parcelable);
                }
            }
            RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(R.id.sharing_details_recycler_view);
            Intrinsics.checkNotNullExpressionValue(recyclerView, "sharing_details_recycler_view");
            ViewUtilsKt.initDetails(recyclerView, arrayList);
        }
        Bundle arguments2 = getArguments();
        if (!(arguments2 == null || (parcelableArray = arguments2.getParcelableArray(RECIPIENT_DETAILS_KEY)) == null)) {
            ArrayList arrayList2 = new ArrayList();
            for (Parcelable parcelable2 : parcelableArray) {
                if (parcelable2 instanceof AttributeDetailItem) {
                    arrayList2.add(parcelable2);
                }
            }
            RecyclerView recyclerView2 = (RecyclerView) _$_findCachedViewById(R.id.recipient_details_recycler_view);
            Intrinsics.checkNotNullExpressionValue(recyclerView2, "recipient_details_recycler_view");
            ViewUtilsKt.initDetails(recyclerView2, arrayList2);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\fR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/digitalwallet/app/view/main/SharingDetailsFragment$Companion;", "", "()V", "RECIPIENT_DETAILS_KEY", "", "SENDER_DETAILS_KEY", "TRANSACTION_RESPONSE_KEY", "newInstance", "Lcom/digitalwallet/app/view/main/SharingDetailsFragment;", FirebaseAnalytics.Event.SHARE, "Lcom/digitalwallet/app/model/db/shares/ShareRecord;", "transactionResponse", "", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
    /* compiled from: SharingDetailsFragment.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ SharingDetailsFragment newInstance$default(Companion companion, ShareRecord shareRecord, boolean z, int i, Object obj) {
            if ((i & 2) != 0) {
                z = false;
            }
            return companion.newInstance(shareRecord, z);
        }

        public final SharingDetailsFragment newInstance(ShareRecord shareRecord, boolean z) {
            Intrinsics.checkNotNullParameter(shareRecord, FirebaseAnalytics.Event.SHARE);
            SharingDetailsFragment sharingDetailsFragment = new SharingDetailsFragment();
            Bundle bundle = new Bundle();
            Object[] array = shareRecord.senderDetailsAsList().toArray(new AttributeDetailItem[0]);
            Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
            bundle.putParcelableArray(SharingDetailsFragment.SENDER_DETAILS_KEY, (Parcelable[]) array);
            bundle.putBoolean(SharingDetailsFragment.TRANSACTION_RESPONSE_KEY, z);
            Object[] array2 = shareRecord.receiverDetailsAsList().toArray(new AttributeDetailItem[0]);
            Objects.requireNonNull(array2, "null cannot be cast to non-null type kotlin.Array<T>");
            bundle.putParcelableArray(SharingDetailsFragment.RECIPIENT_DETAILS_KEY, (Parcelable[]) array2);
            Unit unit = Unit.INSTANCE;
            sharingDetailsFragment.setArguments(bundle);
            return sharingDetailsFragment;
        }
    }
}
