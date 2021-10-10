package com.digitalwallet.app.view.main;

import com.digitalwallet.app.holdings.HoldingExpiryPublisher;
import com.digitalwallet.app.model.Asset;
import com.digitalwallet.app.model.AssetType;
import com.digitalwallet.app.model.HoldingResponseStatus;
import com.digitalwallet.app.model.SecureHolding;
import com.digitalwallet.app.model.ShareHolding;
import com.digitalwallet.app.view.main.IncomingRequestFragment;
import com.nimbusds.jwt.SignedJWT;
import io.reactivex.Maybe;
import io.reactivex.MaybeSource;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001aZ\u0012&\b\u0001\u0012\"\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004 \u0005*\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00020\u0002 \u0005*,\u0012&\b\u0001\u0012\"\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004 \u0005*\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00020\u0002\u0018\u00010\u00010\u00012\u0006\u0010\u0006\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "Lio/reactivex/MaybeSource;", "Lkotlin/Pair;", "Lcom/digitalwallet/app/model/HoldingResponseStatus;", "Lcom/digitalwallet/app/model/ShareHolding;", "kotlin.jvm.PlatformType", "response", "apply"}, k = 3, mv = {1, 4, 0})
/* compiled from: IncomingRequestFragment.kt */
public final class IncomingRequestFragment$onViewCreated$8<T, R> implements Function<HoldingResponseStatus, MaybeSource<? extends Pair<? extends HoldingResponseStatus, ? extends ShareHolding>>> {
    final /* synthetic */ IncomingRequestFragment this$0;

    IncomingRequestFragment$onViewCreated$8(IncomingRequestFragment incomingRequestFragment) {
        this.this$0 = incomingRequestFragment;
    }

    public final MaybeSource<? extends Pair<HoldingResponseStatus, ShareHolding>> apply(final HoldingResponseStatus holdingResponseStatus) {
        Maybe<R> maybe;
        Intrinsics.checkNotNullParameter(holdingResponseStatus, "response");
        int i = IncomingRequestFragment.WhenMappings.$EnumSwitchMapping$0[holdingResponseStatus.ordinal()];
        if (i == 1) {
            this.this$0.getAnalytics().selectContent("Citizen - Share", this.this$0.holdingName);
            maybe = this.this$0.getViewModel().fetchRequestedHolding(IncomingRequestFragment.access$getSharingCode$p(this.this$0)).subscribeOn(Schedulers.io()).map(new Function<SecureHolding, Pair<? extends HoldingResponseStatus, ? extends ShareHolding>>(this) {
                /* class com.digitalwallet.app.view.main.IncomingRequestFragment$onViewCreated$8.AnonymousClass1 */
                final /* synthetic */ IncomingRequestFragment$onViewCreated$8 this$0;

                {
                    this.this$0 = r1;
                }

                public final Pair<HoldingResponseStatus, ShareHolding> apply(SecureHolding secureHolding) {
                    ArrayList arrayList;
                    Intrinsics.checkNotNullParameter(secureHolding, HoldingExpiryPublisher.HOLDING_KEY);
                    HoldingResponseStatus holdingResponseStatus = holdingResponseStatus;
                    Intrinsics.checkNotNullExpressionValue(holdingResponseStatus, "response");
                    SignedJWT parse = SignedJWT.parse(secureHolding.getJws());
                    List<Asset> assets = secureHolding.getAssets();
                    if (assets != null) {
                        ArrayList arrayList2 = new ArrayList();
                        for (T t : assets) {
                            if (t.getInterpretedType() == AssetType.Photo) {
                                arrayList2.add(t);
                            }
                        }
                        ArrayList<T> arrayList3 = arrayList2;
                        ArrayList arrayList4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList3, 10));
                        for (T t2 : arrayList3) {
                            arrayList4.add(this.this$0.this$0.getAssetService().getAssetData(t2));
                        }
                        arrayList = arrayList4;
                    } else {
                        arrayList = null;
                    }
                    return TuplesKt.to(holdingResponseStatus, new ShareHolding(holdingResponseStatus, parse, arrayList));
                }
            });
        } else if (i == 2) {
            this.this$0.getAnalytics().selectContent("Citizen - Decline", this.this$0.holdingName);
            maybe = Maybe.just(TuplesKt.to(holdingResponseStatus, new ShareHolding(holdingResponseStatus, null, null)));
        } else {
            throw new NoWhenBranchMatchedException();
        }
        return maybe;
    }
}
