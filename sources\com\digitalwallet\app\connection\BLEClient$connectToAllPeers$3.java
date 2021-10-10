package com.digitalwallet.app.connection;

import com.digitalwallet.app.utilities.WrapNull;
import io.reactivex.functions.BiConsumer;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import timber.log.Timber;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u001a\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004 \u0005*\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00030\u00032\u001a\u0010\u0006\u001a\u0016\u0012\u0004\u0012\u00020\u0004 \u0005*\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00070\u0007H\n¢\u0006\u0002\b\b"}, d2 = {"<anonymous>", "", "list", "", "Lcom/digitalwallet/app/connection/NamedDevice;", "kotlin.jvm.PlatformType", "item", "Lcom/digitalwallet/app/utilities/WrapNull;", "accept"}, k = 3, mv = {1, 4, 0})
/* compiled from: BLEClient.kt */
public final class BLEClient$connectToAllPeers$3<T1, T2> implements BiConsumer<List<? extends NamedDevice>, WrapNull<NamedDevice>> {
    final /* synthetic */ BLEClient this$0;

    BLEClient$connectToAllPeers$3(BLEClient bLEClient) {
        this.this$0 = bLEClient;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // io.reactivex.functions.BiConsumer
    public /* bridge */ /* synthetic */ void accept(List<? extends NamedDevice> list, WrapNull<NamedDevice> wrapNull) {
        accept((List<NamedDevice>) list, wrapNull);
    }

    public final void accept(final List<NamedDevice> list, WrapNull<NamedDevice> wrapNull) {
        wrapNull.use(new Function1<NamedDevice, Boolean>(this) {
            /* class com.digitalwallet.app.connection.BLEClient$connectToAllPeers$3.AnonymousClass1 */
            final /* synthetic */ BLEClient$connectToAllPeers$3 this$0;

            {
                this.this$0 = r1;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Boolean invoke(NamedDevice namedDevice) {
                return Boolean.valueOf(invoke(namedDevice));
            }

            public final boolean invoke(NamedDevice namedDevice) {
                Intrinsics.checkNotNullParameter(namedDevice, "it");
                Timber.Tree access$getLog$p = BLEClient.access$getLog$p(this.this$0.this$0);
                access$getLog$p.d("Device named: " + namedDevice.getDevice().getAddress() + ' ' + namedDevice.getDetails().getName(), new Object[0]);
                List list = list;
                Objects.requireNonNull(list, "null cannot be cast to non-null type kotlin.collections.MutableList<com.digitalwallet.app.connection.NamedDevice>");
                return TypeIntrinsics.asMutableList(list).add(namedDevice);
            }
        });
    }
}
