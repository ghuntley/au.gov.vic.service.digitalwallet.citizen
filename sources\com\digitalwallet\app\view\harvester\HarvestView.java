package com.digitalwallet.app.view.harvester;

import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001:\u0001\fJ\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&J\b\u0010\t\u001a\u00020\u0003H&J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u000b\u001a\u00020\u0003H&¨\u0006\r"}, d2 = {"Lcom/digitalwallet/app/view/harvester/HarvestView;", "", "closeJob", "", "jobId", "", "go", "screen", "Lcom/digitalwallet/app/view/harvester/HarvestView$Screen;", "goBack", "scanTags", "showAddJobSuccess", "Screen", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: HarvestView.kt */
public interface HarvestView {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/digitalwallet/app/view/harvester/HarvestView$Screen;", "", "(Ljava/lang/String;I)V", "List", "Consent", "Address", "Zone", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
    /* compiled from: HarvestView.kt */
    public enum Screen {
        List,
        Consent,
        Address,
        Zone
    }

    void closeJob(long j);

    void go(Screen screen);

    void goBack();

    void scanTags(long j);

    void showAddJobSuccess();
}
