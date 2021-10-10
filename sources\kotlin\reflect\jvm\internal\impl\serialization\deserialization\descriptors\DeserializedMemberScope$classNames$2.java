package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.name.Name;

/* access modifiers changed from: package-private */
/* compiled from: DeserializedMemberScope.kt */
public final class DeserializedMemberScope$classNames$2 extends Lambda implements Function0<Set<? extends Name>> {
    final /* synthetic */ Function0 $classNames;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DeserializedMemberScope$classNames$2(Function0 function0) {
        super(0);
        this.$classNames = function0;
    }

    /* Return type fixed from 'java.util.Set<kotlin.reflect.jvm.internal.impl.name.Name>' to match base method */
    @Override // kotlin.jvm.functions.Function0
    public final Set<? extends Name> invoke() {
        return CollectionsKt.toSet((Iterable) this.$classNames.invoke());
    }
}
