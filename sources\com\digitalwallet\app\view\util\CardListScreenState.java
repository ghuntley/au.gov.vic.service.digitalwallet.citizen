package com.digitalwallet.app.view.util;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0002¢\u0006\u0002\u0010\u0002\u0001\u0002\u0005\u0006¨\u0006\u0007"}, d2 = {"Lcom/digitalwallet/app/view/util/CardListScreenState;", "", "()V", "Loading", "ShowCardList", "Lcom/digitalwallet/app/view/util/CardListScreenState$Loading;", "Lcom/digitalwallet/app/view/util/CardListScreenState$ShowCardList;", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: ScreenState.kt */
public abstract class CardListScreenState {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/digitalwallet/app/view/util/CardListScreenState$Loading;", "Lcom/digitalwallet/app/view/util/CardListScreenState;", "()V", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
    /* compiled from: ScreenState.kt */
    public static final class Loading extends CardListScreenState {
        public static final Loading INSTANCE = new Loading();

        private Loading() {
            super(null);
        }
    }

    private CardListScreenState() {
    }

    public /* synthetic */ CardListScreenState(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/digitalwallet/app/view/util/CardListScreenState$ShowCardList;", "Lcom/digitalwallet/app/view/util/CardListScreenState;", "()V", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
    /* compiled from: ScreenState.kt */
    public static final class ShowCardList extends CardListScreenState {
        public static final ShowCardList INSTANCE = new ShowCardList();

        private ShowCardList() {
            super(null);
        }
    }
}
