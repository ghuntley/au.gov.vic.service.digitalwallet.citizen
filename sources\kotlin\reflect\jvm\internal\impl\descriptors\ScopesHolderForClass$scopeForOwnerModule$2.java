package kotlin.reflect.jvm.internal.impl.descriptors;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;

/* compiled from: ScopesHolderForClass.kt */
final class ScopesHolderForClass$scopeForOwnerModule$2 extends Lambda implements Function0<T> {
    final /* synthetic */ ScopesHolderForClass this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ScopesHolderForClass$scopeForOwnerModule$2(ScopesHolderForClass scopesHolderForClass) {
        super(0);
        this.this$0 = scopesHolderForClass;
    }

    @Override // kotlin.jvm.functions.Function0
    public final T invoke() {
        return (T) ((MemberScope) ScopesHolderForClass.access$getScopeFactory$p(this.this$0).invoke(ScopesHolderForClass.access$getKotlinTypeRefinerForOwnerModule$p(this.this$0)));
    }
}
