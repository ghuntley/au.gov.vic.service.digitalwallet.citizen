package com.digitalwallet.app.view.main.adapter;

import com.digitalwallet.app.holdings.HoldingExpiryPublisher;
import com.digitalwallet.app.model.HoldingAssets;
import com.digitalwallet.app.model.SecureHolding;
import com.digitalwallet.app.model.ShareHolding;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/digitalwallet/app/view/main/adapter/CardListItem;", "", HoldingExpiryPublisher.HOLDING_KEY, "Lcom/digitalwallet/app/model/SecureHolding;", ShareHolding.assetDataKey, "Lcom/digitalwallet/app/model/HoldingAssets;", "(Lcom/digitalwallet/app/model/SecureHolding;Lcom/digitalwallet/app/model/HoldingAssets;)V", "getAssets", "()Lcom/digitalwallet/app/model/HoldingAssets;", "getHolding", "()Lcom/digitalwallet/app/model/SecureHolding;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: HoldingListAdapter.kt */
public final class CardListItem {
    private final HoldingAssets assets;
    private final SecureHolding holding;

    public static /* synthetic */ CardListItem copy$default(CardListItem cardListItem, SecureHolding secureHolding, HoldingAssets holdingAssets, int i, Object obj) {
        if ((i & 1) != 0) {
            secureHolding = cardListItem.holding;
        }
        if ((i & 2) != 0) {
            holdingAssets = cardListItem.assets;
        }
        return cardListItem.copy(secureHolding, holdingAssets);
    }

    public final SecureHolding component1() {
        return this.holding;
    }

    public final HoldingAssets component2() {
        return this.assets;
    }

    public final CardListItem copy(SecureHolding secureHolding, HoldingAssets holdingAssets) {
        Intrinsics.checkNotNullParameter(secureHolding, HoldingExpiryPublisher.HOLDING_KEY);
        return new CardListItem(secureHolding, holdingAssets);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CardListItem)) {
            return false;
        }
        CardListItem cardListItem = (CardListItem) obj;
        return Intrinsics.areEqual(this.holding, cardListItem.holding) && Intrinsics.areEqual(this.assets, cardListItem.assets);
    }

    public int hashCode() {
        SecureHolding secureHolding = this.holding;
        int i = 0;
        int hashCode = (secureHolding != null ? secureHolding.hashCode() : 0) * 31;
        HoldingAssets holdingAssets = this.assets;
        if (holdingAssets != null) {
            i = holdingAssets.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return "CardListItem(holding=" + this.holding + ", assets=" + this.assets + ")";
    }

    public CardListItem(SecureHolding secureHolding, HoldingAssets holdingAssets) {
        Intrinsics.checkNotNullParameter(secureHolding, HoldingExpiryPublisher.HOLDING_KEY);
        this.holding = secureHolding;
        this.assets = holdingAssets;
    }

    public final HoldingAssets getAssets() {
        return this.assets;
    }

    public final SecureHolding getHolding() {
        return this.holding;
    }
}
