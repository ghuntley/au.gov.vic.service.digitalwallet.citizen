package kotlin.reflect.jvm.internal;

import com.google.firebase.messaging.Constants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J!\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¢\u0006\u0002\u0010\b¨\u0006\t"}, d2 = {"kotlin/reflect/jvm/internal/KDeclarationContainerImpl$getMembers$visitor$1", "Lkotlin/reflect/jvm/internal/CreateKCallableVisitor;", "visitConstructorDescriptor", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/ConstructorDescriptor;", Constants.ScionAnalytics.MessageType.DATA_MESSAGE, "", "(Lorg/jetbrains/kotlin/descriptors/ConstructorDescriptor;Lkotlin/Unit;)Lkotlin/reflect/jvm/internal/KCallableImpl;", "kotlin-reflection"}, k = 1, mv = {1, 4, 0})
/* compiled from: KDeclarationContainerImpl.kt */
public final class KDeclarationContainerImpl$getMembers$visitor$1 extends CreateKCallableVisitor {
    final /* synthetic */ KDeclarationContainerImpl this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    KDeclarationContainerImpl$getMembers$visitor$1(KDeclarationContainerImpl kDeclarationContainerImpl, KDeclarationContainerImpl kDeclarationContainerImpl2) {
        super(kDeclarationContainerImpl2);
        this.this$0 = kDeclarationContainerImpl;
    }

    public KCallableImpl<?> visitConstructorDescriptor(ConstructorDescriptor constructorDescriptor, Unit unit) {
        Intrinsics.checkNotNullParameter(constructorDescriptor, "descriptor");
        Intrinsics.checkNotNullParameter(unit, Constants.ScionAnalytics.MessageType.DATA_MESSAGE);
        throw new IllegalStateException("No constructors should appear here: " + constructorDescriptor);
    }
}
