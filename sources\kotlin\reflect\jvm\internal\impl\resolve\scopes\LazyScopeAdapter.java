package kotlin.reflect.jvm.internal.impl.resolve.scopes;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;

/* compiled from: LazyScopeAdapter.kt */
public final class LazyScopeAdapter extends AbstractScopeAdapter {
    private final NotNullLazyValue<MemberScope> lazyScope;

    public LazyScopeAdapter(Function0<? extends MemberScope> function0) {
        this(null, function0, 1, null);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    public /* synthetic */ LazyScopeAdapter(StorageManager storageManager, Function0 function0, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(storageManager, function0);
        if ((i & 1) != 0) {
            storageManager = LockBasedStorageManager.NO_LOCKS;
            Intrinsics.checkNotNullExpressionValue(storageManager, "LockBasedStorageManager.NO_LOCKS");
        }
    }

    public LazyScopeAdapter(StorageManager storageManager, Function0<? extends MemberScope> function0) {
        Intrinsics.checkNotNullParameter(storageManager, "storageManager");
        Intrinsics.checkNotNullParameter(function0, "getScope");
        this.lazyScope = storageManager.createLazyValue(new LazyScopeAdapter$lazyScope$1(function0));
    }

    /* access modifiers changed from: protected */
    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.AbstractScopeAdapter
    public MemberScope getWorkerScope() {
        return (MemberScope) this.lazyScope.invoke();
    }
}
