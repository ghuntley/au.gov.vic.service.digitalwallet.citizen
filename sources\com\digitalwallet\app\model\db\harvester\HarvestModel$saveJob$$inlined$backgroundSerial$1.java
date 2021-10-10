package com.digitalwallet.app.model.db.harvester;

import android.os.AsyncTask;
import android.os.Looper;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J'\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0016\u0010\u0004\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00020\u0005\"\u0004\u0018\u00010\u0002H\u0014¢\u0006\u0002\u0010\u0006¨\u0006\u0007¸\u0006\u0000"}, d2 = {"com/digitalwallet/utilities/AsyncHelper$Companion$backgroundSerial$1", "Landroid/os/AsyncTask;", "Ljava/lang/Void;", "doInBackground", "params", "", "([Ljava/lang/Void;)Ljava/lang/Void;", "base_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: StandardHelper.kt */
public final class HarvestModel$saveJob$$inlined$backgroundSerial$1 extends AsyncTask<Void, Void, Void> {
    final /* synthetic */ String $address$inlined;
    final /* synthetic */ String $agencyIdentifier$inlined;
    final /* synthetic */ Date $consentDateTime$inlined;
    final /* synthetic */ String $landholderContactNumber$inlined;
    final /* synthetic */ String $landholderName$inlined;
    final /* synthetic */ String $quotaId$inlined;
    final /* synthetic */ HarvestModel this$0;

    public HarvestModel$saveJob$$inlined$backgroundSerial$1(HarvestModel harvestModel, String str, Date date, String str2, String str3, String str4, String str5) {
        this.this$0 = harvestModel;
        this.$agencyIdentifier$inlined = str;
        this.$consentDateTime$inlined = date;
        this.$quotaId$inlined = str2;
        this.$address$inlined = str3;
        this.$landholderName$inlined = str4;
        this.$landholderContactNumber$inlined = str5;
    }

    /* access modifiers changed from: protected */
    public Void doInBackground(Void... voidArr) {
        Intrinsics.checkNotNullParameter(voidArr, "params");
        Looper mainLooper = Looper.getMainLooper();
        Intrinsics.checkNotNullExpressionValue(mainLooper, "Looper.getMainLooper()");
        boolean z = true;
        if (!mainLooper.isCurrentThread()) {
            SavedHarvestJob savedHarvestJob = new SavedHarvestJob(this.$agencyIdentifier$inlined, this.$consentDateTime$inlined, this.$quotaId$inlined, this.$address$inlined, this.$landholderName$inlined, this.$landholderContactNumber$inlined, null, 64, null);
            savedHarvestJob.setId(Long.valueOf(this.this$0.database.harvestJobDao().insert(savedHarvestJob)));
            Long id = savedHarvestJob.getId();
            Intrinsics.checkNotNull(id);
            if (id.longValue() <= 0) {
                z = false;
            }
            if (z) {
                return null;
            }
            throw new IllegalStateException("Check failed.".toString());
        }
        throw new IllegalStateException("Check failed.".toString());
    }
}
