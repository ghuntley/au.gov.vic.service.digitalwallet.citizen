package com.digitalwallet.app.view.main;

import com.digitalwallet.app.connection.NamedDevice;
import com.digitalwallet.app.viewmodel.main.sharing.LobbyViewState;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ObservableProperty;
import kotlin.reflect.KProperty;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J)\u0010\u0002\u001a\u00020\u00032\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u00052\u0006\u0010\u0006\u001a\u00028\u00002\u0006\u0010\u0007\u001a\u00028\u0000H\u0014¢\u0006\u0002\u0010\b¨\u0006\t¸\u0006\u0000"}, d2 = {"kotlin/properties/Delegates$observable$1", "Lkotlin/properties/ObservableProperty;", "afterChange", "", "property", "Lkotlin/reflect/KProperty;", "oldValue", "newValue", "(Lkotlin/reflect/KProperty;Ljava/lang/Object;Ljava/lang/Object;)V", "kotlin-stdlib"}, k = 1, mv = {1, 4, 0})
/* compiled from: Delegates.kt */
public final class LobbyFragment$$special$$inlined$observable$1 extends ObservableProperty<Pair<? extends String, ? extends List<? extends NamedDevice>>> {
    final /* synthetic */ Object $initialValue;
    final /* synthetic */ LobbyFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LobbyFragment$$special$$inlined$observable$1(Object obj, Object obj2, LobbyFragment lobbyFragment) {
        super(obj2);
        this.$initialValue = obj;
        this.this$0 = lobbyFragment;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v5, resolved type: com.digitalwallet.app.view.main.adapter.LobbyAdapter */
    /* JADX WARN: Multi-variable type inference failed */
    /* access modifiers changed from: protected */
    @Override // kotlin.properties.ObservableProperty
    public void afterChange(KProperty<?> kProperty, Pair<? extends String, ? extends List<? extends NamedDevice>> pair, Pair<? extends String, ? extends List<? extends NamedDevice>> pair2) {
        Intrinsics.checkNotNullParameter(kProperty, "property");
        Pair<? extends String, ? extends List<? extends NamedDevice>> pair3 = pair2;
        if (((List) pair3.getSecond()).size() > ((List) pair.getSecond()).size()) {
            this.this$0.getViewModel().changeState(new LobbyViewState.FoundUser());
        } else if (((List) pair3.getSecond()).isEmpty()) {
            this.this$0.getViewModel().changeState(new LobbyViewState.NoneFound());
        }
        LobbyFragment.access$getAdapter$p(this.this$0).update(pair3);
    }
}
