package com.digitalwallet.utilities;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.widget.Toast;
import au.gov.vic.service.digitalwallet.citizen.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u0016\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"viewAppInStore", "", "context", "Landroid/content/Context;", "viewURI", "uri", "Landroid/net/Uri;", "base_citizenProdRelease"}, k = 2, mv = {1, 4, 0})
/* compiled from: ActivityHelper.kt */
public final class ActivityHelperKt {
    public static final void viewAppInStore(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        AnalyticsHelper.selectContent$default(new AnalyticsHelper(context), "View app in store", null, 2, null);
        Uri parse = Uri.parse("https://play.google.com/store/apps/details?id=au.gov.vic.service.digitalwallet.citizen");
        Intrinsics.checkNotNullExpressionValue(parse, "uri");
        viewURI(context, parse);
    }

    public static final void viewURI(Context context, Uri uri) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(uri, "uri");
        try {
            context.startActivity(new Intent("android.intent.action.VIEW", uri));
        } catch (Exception e) {
            Timber.e(e);
            Toast.makeText(context, (int) R.string.error_no_browser, 1).show();
        }
    }
}
