package kotlin.reflect.jvm.internal.impl.descriptors;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;

/* access modifiers changed from: package-private */
/* compiled from: ScopesHolderForClass.kt */
public final class ScopesHolderForClass$getScope$1 extends Lambda implements Function0<T> {
    final /* synthetic */ KotlinTypeRefiner $kotlinTypeRefiner;
    final /* synthetic */ ScopesHolderForClass this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ScopesHolderForClass$getScope$1(ScopesHolderForClass scopesHolderForClass, KotlinTypeRefiner kotlinTypeRefiner) {
        super(0);
        this.this$0 = scopesHolderForClass;
        this.$kotlinTypeRefiner = kotlinTypeRefiner;
    }

    @Override // kotlin.jvm.functions.Function0
    public final T invoke() {
        return (T) ((MemberScope) ScopesHolderForClass.access$getScopeFactory$p(this.this$0).invoke(this.$kotlinTypeRefiner));
    }
}
