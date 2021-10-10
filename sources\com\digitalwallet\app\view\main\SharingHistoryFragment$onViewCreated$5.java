package com.digitalwallet.app.view.main;

import android.content.Context;
import com.digitalwallet.utilities.AnalyticsHelper;
import io.reactivex.functions.Consumer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "accept", "(Ljava/lang/Boolean;)V"}, k = 3, mv = {1, 4, 0})
/* compiled from: SharingHistoryFragment.kt */
final class SharingHistoryFragment$onViewCreated$5<T> implements Consumer<Boolean> {
    final /* synthetic */ SharingHistoryFragment this$0;

    SharingHistoryFragment$onViewCreated$5(SharingHistoryFragment sharingHistoryFragment) {
        this.this$0 = sharingHistoryFragment;
    }

    public final void accept(Boolean bool) {
        Context context = this.this$0.getContext();
        Intrinsics.checkNotNull(context);
        Intrinsics.checkNotNullExpressionValue(context, "context!!");
        new AnalyticsHelper(context).selectContent("Sharing activity", "Hide");
        this.this$0.getParentFragmentManager().popBackStack(Reflection.getOrCreateKotlinClass(this.this$0.getClass()).getSimpleName(), 1);
    }
}
