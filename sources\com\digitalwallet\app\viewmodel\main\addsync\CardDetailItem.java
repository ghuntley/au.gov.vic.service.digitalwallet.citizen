package com.digitalwallet.app.viewmodel.main.addsync;

import android.content.Context;
import android.graphics.drawable.Drawable;
import androidx.databinding.ObservableBoolean;
import com.digitalwallet.app.holdings.HoldingExpiryPublisher;
import com.digitalwallet.app.model.AssetType;
import com.digitalwallet.app.model.DrawableAsset;
import com.digitalwallet.app.model.HoldingAssets;
import com.digitalwallet.app.model.ShareHolding;
import com.digitalwallet.app.model.db.unsecure.UnsecuredHolding;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.bouncycastle.i18n.MessageBundle;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0002\u0010\u000bJ\u0006\u0010#\u001a\u00020\nR\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0014\u001a\u00020\u0015¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u001a\u001a\u00020\u001b¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001cR\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u001d\u001a\u00020\u001e¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0011\u0010!\u001a\u00020\u0015¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0017¨\u0006$"}, d2 = {"Lcom/digitalwallet/app/viewmodel/main/addsync/CardDetailItem;", "", HoldingExpiryPublisher.HOLDING_KEY, "Lcom/digitalwallet/app/model/db/unsecure/UnsecuredHolding;", "context", "Landroid/content/Context;", ShareHolding.assetDataKey, "Lcom/digitalwallet/app/model/HoldingAssets;", "onToggleChanged", "Lkotlin/Function0;", "", "(Lcom/digitalwallet/app/model/db/unsecure/UnsecuredHolding;Landroid/content/Context;Lcom/digitalwallet/app/model/HoldingAssets;Lkotlin/jvm/functions/Function0;)V", "dynamicAsset", "Lcom/digitalwallet/app/model/DrawableAsset;", "getDynamicAsset", "()Lcom/digitalwallet/app/model/DrawableAsset;", "embeddedIcon", "Landroid/graphics/drawable/Drawable;", "getEmbeddedIcon", "()Landroid/graphics/drawable/Drawable;", "expiry", "", "getExpiry", "()Ljava/lang/String;", "getHolding", "()Lcom/digitalwallet/app/model/db/unsecure/UnsecuredHolding;", "isHoldingExpired", "", "()Z", "shouldUpdate", "Landroidx/databinding/ObservableBoolean;", "getShouldUpdate", "()Landroidx/databinding/ObservableBoolean;", MessageBundle.TITLE_ENTRY, "getTitle", "toggleSelected", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: CardDetailItem.kt */
public final class CardDetailItem {
    private final DrawableAsset dynamicAsset;
    private final Drawable embeddedIcon;
    private final String expiry;
    private final UnsecuredHolding holding;
    private final boolean isHoldingExpired;
    private final Function0<Unit> onToggleChanged;
    private final ObservableBoolean shouldUpdate;
    private final String title;

    public CardDetailItem(UnsecuredHolding unsecuredHolding, Context context, HoldingAssets holdingAssets, Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(unsecuredHolding, HoldingExpiryPublisher.HOLDING_KEY);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(holdingAssets, ShareHolding.assetDataKey);
        Intrinsics.checkNotNullParameter(function0, "onToggleChanged");
        this.holding = unsecuredHolding;
        this.onToggleChanged = function0;
        this.dynamicAsset = holdingAssets.getMap().get(AssetType.CardFront.getJsonName());
        Integer detailIcon = unsecuredHolding.getHoldingElements().getDetailIcon();
        if (detailIcon != null) {
            this.embeddedIcon = context.getDrawable(detailIcon.intValue());
            String detailTitle = unsecuredHolding.getDetailTitle(context);
            if (detailTitle != null) {
                this.title = detailTitle;
                this.isHoldingExpired = unsecuredHolding.getAttributes().isHoldingExpired();
                this.expiry = (String) new CardDetailItem$expiry$1(this, context).invoke();
                this.shouldUpdate = new ObservableBoolean(unsecuredHolding.getShouldUpdate());
                return;
            }
            throw new Exception("Unsupported Holding Type " + unsecuredHolding.getHoldingType());
        }
        throw new Exception("Unsupported Holding Type " + unsecuredHolding.getHoldingType());
    }

    public final UnsecuredHolding getHolding() {
        return this.holding;
    }

    public final DrawableAsset getDynamicAsset() {
        return this.dynamicAsset;
    }

    public final Drawable getEmbeddedIcon() {
        return this.embeddedIcon;
    }

    public final String getTitle() {
        return this.title;
    }

    public final boolean isHoldingExpired() {
        return this.isHoldingExpired;
    }

    public final String getExpiry() {
        return this.expiry;
    }

    public final ObservableBoolean getShouldUpdate() {
        return this.shouldUpdate;
    }

    public final void toggleSelected() {
        UnsecuredHolding unsecuredHolding = this.holding;
        boolean z = !unsecuredHolding.getShouldUpdate();
        this.shouldUpdate.set(z);
        Unit unit = Unit.INSTANCE;
        unsecuredHolding.setShouldUpdate(z);
        this.onToggleChanged.invoke();
    }
}
