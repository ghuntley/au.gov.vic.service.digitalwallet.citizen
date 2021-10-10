package kotlin.reflect.jvm.internal.impl.resolve.scopes;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorFactory;

/* compiled from: StaticScopeForKotlinEnum.kt */
final class StaticScopeForKotlinEnum$functions$2 extends Lambda implements Function0<List<? extends SimpleFunctionDescriptor>> {
    final /* synthetic */ StaticScopeForKotlinEnum this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    StaticScopeForKotlinEnum$functions$2(StaticScopeForKotlinEnum staticScopeForKotlinEnum) {
        super(0);
        this.this$0 = staticScopeForKotlinEnum;
    }

    /* Return type fixed from 'java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor>' to match base method */
    @Override // kotlin.jvm.functions.Function0
    public final List<? extends SimpleFunctionDescriptor> invoke() {
        return CollectionsKt.listOf((Object[]) new SimpleFunctionDescriptor[]{DescriptorFactory.createEnumValueOfMethod(StaticScopeForKotlinEnum.access$getContainingClass$p(this.this$0)), DescriptorFactory.createEnumValuesMethod(StaticScopeForKotlinEnum.access$getContainingClass$p(this.this$0))});
    }
}
