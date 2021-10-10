package com.digitalwallet.app.view.harvester;

import android.app.ProgressDialog;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001:\u0001\u001aJ\b\u0010\b\u001a\u00020\tH&J\b\u0010\n\u001a\u00020\tH&J\b\u0010\u000b\u001a\u00020\tH&J\b\u0010\f\u001a\u00020\tH&J\b\u0010\r\u001a\u00020\u000eH&J\u0010\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u0011H&J\b\u0010\u0012\u001a\u00020\tH&J\b\u0010\u0013\u001a\u00020\tH&J\b\u0010\u0014\u001a\u00020\tH&J\u0010\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u0017H&J\u0012\u0010\u0018\u001a\u00020\t2\b\b\u0001\u0010\u0019\u001a\u00020\u0017H&R\u0014\u0010\u0002\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005¨\u0006\u001b"}, d2 = {"Lcom/digitalwallet/app/view/harvester/HarvestTagView;", "", "gpsLatitude", "", "getGpsLatitude", "()Ljava/lang/Double;", "gpsLongitude", "getGpsLongitude", "goBack", "", "goBackDirect", "manualTagEntry", "showCloseScanner", "showProgressIndicator", "Landroid/app/ProgressDialog;", "showScanner", "jobId", "", "showSummary", "showSummaryBackgroundRetry", "showSummarySuccess", "showTagSuccess", "numTags", "", "toast", "message", "Screen", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: HarvestTagView.kt */
public interface HarvestTagView {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/digitalwallet/app/view/harvester/HarvestTagView$Screen;", "", "(Ljava/lang/String;I)V", "Scanner", "ManualEntry", "HarvestSummary", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
    /* compiled from: HarvestTagView.kt */
    public enum Screen {
        Scanner,
        ManualEntry,
        HarvestSummary
    }

    Double getGpsLatitude();

    Double getGpsLongitude();

    void goBack();

    void goBackDirect();

    void manualTagEntry();

    void showCloseScanner();

    ProgressDialog showProgressIndicator();

    void showScanner(long j);

    void showSummary();

    void showSummaryBackgroundRetry();

    void showSummarySuccess();

    void showTagSuccess(int i);

    void toast(int i);
}
