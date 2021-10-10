package kotlin.reflect.jvm.internal;

import com.google.firebase.messaging.Constants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorVisitorEmptyBodies;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0010\u0018\u00002\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J!\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\u00022\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0003H\u0016¢\u0006\u0002\u0010\u000bJ!\u0010\f\u001a\u0006\u0012\u0002\b\u00030\u00022\u0006\u0010\b\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u0003H\u0016¢\u0006\u0002\u0010\u000eR\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lkotlin/reflect/jvm/internal/CreateKCallableVisitor;", "Lkotlin/reflect/jvm/internal/impl/descriptors/impl/DeclarationDescriptorVisitorEmptyBodies;", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "", "container", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;)V", "visitFunctionDescriptor", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/FunctionDescriptor;", Constants.ScionAnalytics.MessageType.DATA_MESSAGE, "(Lorg/jetbrains/kotlin/descriptors/FunctionDescriptor;Lkotlin/Unit;)Lkotlin/reflect/jvm/internal/KCallableImpl;", "visitPropertyDescriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyDescriptor;", "(Lorg/jetbrains/kotlin/descriptors/PropertyDescriptor;Lkotlin/Unit;)Lkotlin/reflect/jvm/internal/KCallableImpl;", "kotlin-reflection"}, k = 1, mv = {1, 4, 0})
/* compiled from: util.kt */
public class CreateKCallableVisitor extends DeclarationDescriptorVisitorEmptyBodies<KCallableImpl<?>, Unit> {
    private final KDeclarationContainerImpl container;

    public CreateKCallableVisitor(KDeclarationContainerImpl kDeclarationContainerImpl) {
        Intrinsics.checkNotNullParameter(kDeclarationContainerImpl, "container");
        this.container = kDeclarationContainerImpl;
    }

    public KCallableImpl<?> visitPropertyDescriptor(PropertyDescriptor propertyDescriptor, Unit unit) {
        Intrinsics.checkNotNullParameter(propertyDescriptor, "descriptor");
        Intrinsics.checkNotNullParameter(unit, Constants.ScionAnalytics.MessageType.DATA_MESSAGE);
        int i = 0;
        int i2 = propertyDescriptor.getDispatchReceiverParameter() != null ? 1 : 0;
        if (propertyDescriptor.getExtensionReceiverParameter() != null) {
            i = 1;
        }
        int i3 = i2 + i;
        if (propertyDescriptor.isVar()) {
            if (i3 == 0) {
                return new KMutableProperty0Impl(this.container, propertyDescriptor);
            }
            if (i3 == 1) {
                return new KMutableProperty1Impl(this.container, propertyDescriptor);
            }
            if (i3 == 2) {
                return new KMutableProperty2Impl(this.container, propertyDescriptor);
            }
        } else if (i3 == 0) {
            return new KProperty0Impl(this.container, propertyDescriptor);
        } else {
            if (i3 == 1) {
                return new KProperty1Impl(this.container, propertyDescriptor);
            }
            if (i3 == 2) {
                return new KProperty2Impl(this.container, propertyDescriptor);
            }
        }
        throw new KotlinReflectionInternalError("Unsupported property: " + propertyDescriptor);
    }

    public KCallableImpl<?> visitFunctionDescriptor(FunctionDescriptor functionDescriptor, Unit unit) {
        Intrinsics.checkNotNullParameter(functionDescriptor, "descriptor");
        Intrinsics.checkNotNullParameter(unit, Constants.ScionAnalytics.MessageType.DATA_MESSAGE);
        return new KFunctionImpl(this.container, functionDescriptor);
    }
}
