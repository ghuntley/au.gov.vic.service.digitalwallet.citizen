package com.digitalwallet.app.viewmodel.svservices;

import android.graphics.drawable.Drawable;
import com.digitalwallet.app.model.login.SVItem;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroid/graphics/drawable/Drawable;", "invoke"}, k = 3, mv = {1, 4, 0})
/* compiled from: ServiceActionViewModels.kt */
public final class SVItemViewModel$imageDrawable$2 extends Lambda implements Function0<Drawable> {
    final /* synthetic */ SVItem $svItem;
    final /* synthetic */ SVItemViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SVItemViewModel$imageDrawable$2(SVItemViewModel sVItemViewModel, SVItem sVItem) {
        super(0);
        this.this$0 = sVItemViewModel;
        this.$svItem = sVItem;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Drawable invoke() {
        Integer num;
        String image = this.$svItem.getImage();
        if (image != null) {
            num = Integer.valueOf(this.this$0.context.getResources().getIdentifier(image, "drawable", this.this$0.context.getPackageName() + ".app"));
        } else {
            num = null;
        }
        if (num == null) {
            return null;
        }
        try {
            return this.this$0.context.getDrawable(num.intValue());
        } catch (Exception unused) {
            return null;
        }
    }
}
