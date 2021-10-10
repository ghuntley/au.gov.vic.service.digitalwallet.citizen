package com.digitalwallet.app.view.main;

import android.content.res.Resources;
import androidx.fragment.app.FragmentActivity;
import com.digitalwallet.app.viewmodel.main.ServiceDetailItem;
import io.reactivex.functions.Consumer;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Lcom/digitalwallet/app/view/main/ServiceDetailType;", "kotlin.jvm.PlatformType", "accept"}, k = 3, mv = {1, 4, 0})
/* compiled from: ServiceDetailFragment.kt */
public final class ServiceDetailFragment$setupRX$1<T> implements Consumer<ServiceDetailType> {
    final /* synthetic */ ServiceDetailFragment this$0;

    ServiceDetailFragment$setupRX$1(ServiceDetailFragment serviceDetailFragment) {
        this.this$0 = serviceDetailFragment;
    }

    public final void accept(ServiceDetailType serviceDetailType) {
        FragmentActivity activity = this.this$0.getActivity();
        Objects.requireNonNull(activity, "null cannot be cast to non-null type com.digitalwallet.app.view.main.MainActivity");
        Resources resources = this.this$0.getResources();
        ServiceDetailItem.Companion companion = ServiceDetailItem.Companion;
        Intrinsics.checkNotNullExpressionValue(serviceDetailType, "it");
        String string = resources.getString(companion.from(serviceDetailType).getUrl());
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(Serv…eDetailItem.from(it).url)");
        ((MainActivity) activity).startChromeCustomTabs(string, true);
    }
}
