package com.digitalwallet.app.viewmodel.svservices;

import android.graphics.drawable.Drawable;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0004"}, d2 = {"<anonymous>", "", "run", "com/digitalwallet/utilities/StandardHelperKt$main$1", "com/digitalwallet/app/viewmodel/svservices/SVItemViewModel$getAsset$2$$special$$inlined$main$1"}, k = 3, mv = {1, 4, 0})
/* compiled from: StandardHelper.kt */
public final class SVItemViewModel$getAsset$2$$special$$inlined$async$1$lambda$1 implements Runnable {
    final /* synthetic */ Drawable $image$inlined;
    final /* synthetic */ SVItemViewModel$getAsset$2$$special$$inlined$async$1 this$0;

    public SVItemViewModel$getAsset$2$$special$$inlined$async$1$lambda$1(Drawable drawable, SVItemViewModel$getAsset$2$$special$$inlined$async$1 sVItemViewModel$getAsset$2$$special$$inlined$async$1) {
        this.$image$inlined = drawable;
        this.this$0 = sVItemViewModel$getAsset$2$$special$$inlined$async$1;
    }

    public final void run() {
        this.this$0.this$0.this$0.getImageDrawable().set(this.$image$inlined);
    }
}
