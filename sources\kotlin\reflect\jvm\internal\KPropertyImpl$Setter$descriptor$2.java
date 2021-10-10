package kotlin.reflect.jvm.internal;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.KPropertyImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertySetterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorFactory;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001\"\u0004\b\u0000\u0010\u0003\"\u0006\b\u0001\u0010\u0003 \u0001H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertySetterDescriptor;", "kotlin.jvm.PlatformType", "V", "invoke"}, k = 3, mv = {1, 4, 0})
/* compiled from: KPropertyImpl.kt */
public final class KPropertyImpl$Setter$descriptor$2 extends Lambda implements Function0<PropertySetterDescriptor> {
    final /* synthetic */ KPropertyImpl.Setter this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    KPropertyImpl$Setter$descriptor$2(KPropertyImpl.Setter setter) {
        super(0);
        this.this$0 = setter;
    }

    @Override // kotlin.jvm.functions.Function0
    public final PropertySetterDescriptor invoke() {
        PropertySetterDescriptor setter = this.this$0.getProperty().getDescriptor().getSetter();
        return setter != null ? setter : DescriptorFactory.createDefaultSetter(this.this$0.getProperty().getDescriptor(), Annotations.Companion.getEMPTY(), Annotations.Companion.getEMPTY());
    }
}
