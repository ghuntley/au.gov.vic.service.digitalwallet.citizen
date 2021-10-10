package com.digitalwallet.app.services;

import com.digitalwallet.app.model.db.scan.Scan;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\u0010\u0000\u001a*\u0012\u000e\b\u0001\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002 \u0003*\u0014\u0012\u000e\b\u0001\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002\u0018\u00010\u00010\u00012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "Lio/reactivex/ObservableSource;", "Lcom/digitalwallet/app/model/db/scan/Scan;", "kotlin.jvm.PlatformType", "it", "", "apply"}, k = 3, mv = {1, 4, 0})
/* compiled from: ScannerDataService.kt */
public final class ScannerDataService$retryCachedScans$2<T, R> implements Function<List<? extends Scan>, ObservableSource<? extends Scan>> {
    public static final ScannerDataService$retryCachedScans$2 INSTANCE = new ScannerDataService$retryCachedScans$2();

    ScannerDataService$retryCachedScans$2() {
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Function
    public /* bridge */ /* synthetic */ ObservableSource<? extends Scan> apply(List<? extends Scan> list) {
        return apply((List<Scan>) list);
    }

    public final ObservableSource<? extends Scan> apply(List<Scan> list) {
        Intrinsics.checkNotNullParameter(list, "it");
        Object[] array = list.toArray(new Scan[0]);
        Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
        Scan[] scanArr = (Scan[]) array;
        return Observable.fromArray((Scan[]) Arrays.copyOf(scanArr, scanArr.length));
    }
}
