package kotlin.reflect.jvm.internal.impl.types;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.model.StubTypeMarker;

/* compiled from: StubType.kt */
public final class StubType extends AbstractStubType implements StubTypeMarker {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public StubType(TypeConstructor typeConstructor, boolean z, TypeConstructor typeConstructor2, MemberScope memberScope) {
        super(typeConstructor, z, typeConstructor2, memberScope);
        Intrinsics.checkNotNullParameter(typeConstructor, "originalTypeVariable");
        Intrinsics.checkNotNullParameter(typeConstructor2, "constructor");
        Intrinsics.checkNotNullParameter(memberScope, "memberScope");
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.AbstractStubType
    public AbstractStubType materialize(boolean z) {
        return new StubType(getOriginalTypeVariable(), z, getConstructor(), getMemberScope());
    }
}
