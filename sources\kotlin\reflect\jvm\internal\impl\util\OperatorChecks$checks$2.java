package kotlin.reflect.jvm.internal.impl.util;

import java.util.Collection;
import java.util.Iterator;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;

/* compiled from: modifierChecks.kt */
final class OperatorChecks$checks$2 extends Lambda implements Function1<FunctionDescriptor, String> {
    public static final OperatorChecks$checks$2 INSTANCE = new OperatorChecks$checks$2();

    OperatorChecks$checks$2() {
        super(1);
    }

    public final String invoke(FunctionDescriptor functionDescriptor) {
        boolean z;
        Intrinsics.checkNotNullParameter(functionDescriptor, "$receiver");
        AnonymousClass1 r0 = AnonymousClass1.INSTANCE;
        OperatorChecks operatorChecks = OperatorChecks.INSTANCE;
        DeclarationDescriptor containingDeclaration = functionDescriptor.getContainingDeclaration();
        Intrinsics.checkNotNullExpressionValue(containingDeclaration, "containingDeclaration");
        boolean invoke = r0.invoke(containingDeclaration);
        boolean z2 = true;
        if (!invoke) {
            Collection<? extends FunctionDescriptor> overriddenDescriptors = functionDescriptor.getOverriddenDescriptors();
            Intrinsics.checkNotNullExpressionValue(overriddenDescriptors, "overriddenDescriptors");
            Collection<? extends FunctionDescriptor> collection = overriddenDescriptors;
            if (!(collection instanceof Collection) || !collection.isEmpty()) {
                Iterator<T> it = collection.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    T next = it.next();
                    AnonymousClass1 r3 = AnonymousClass1.INSTANCE;
                    Intrinsics.checkNotNullExpressionValue(next, "it");
                    DeclarationDescriptor containingDeclaration2 = next.getContainingDeclaration();
                    Intrinsics.checkNotNullExpressionValue(containingDeclaration2, "it.containingDeclaration");
                    if (r3.invoke(containingDeclaration2)) {
                        z = true;
                        break;
                    }
                }
            }
            z = false;
            if (!z) {
                z2 = false;
            }
        }
        if (!z2) {
            return "must override ''equals()'' in Any";
        }
        return null;
    }
}
