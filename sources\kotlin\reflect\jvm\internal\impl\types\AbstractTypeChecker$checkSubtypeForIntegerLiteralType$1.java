package kotlin.reflect.jvm.internal.impl.types;

import java.util.Collection;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker;

/* access modifiers changed from: package-private */
/* compiled from: AbstractTypeChecker.kt */
public final class AbstractTypeChecker$checkSubtypeForIntegerLiteralType$1 extends Lambda implements Function3<SimpleTypeMarker, SimpleTypeMarker, Boolean, Boolean> {
    final /* synthetic */ AbstractTypeCheckerContext $this_checkSubtypeForIntegerLiteralType;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AbstractTypeChecker$checkSubtypeForIntegerLiteralType$1(AbstractTypeCheckerContext abstractTypeCheckerContext) {
        super(3);
        this.$this_checkSubtypeForIntegerLiteralType = abstractTypeCheckerContext;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object, java.lang.Object] */
    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Boolean invoke(SimpleTypeMarker simpleTypeMarker, SimpleTypeMarker simpleTypeMarker2, Boolean bool) {
        return Boolean.valueOf(invoke(simpleTypeMarker, simpleTypeMarker2, bool.booleanValue()));
    }

    public final boolean invoke(SimpleTypeMarker simpleTypeMarker, SimpleTypeMarker simpleTypeMarker2, boolean z) {
        boolean z2;
        Intrinsics.checkNotNullParameter(simpleTypeMarker, "integerLiteralType");
        Intrinsics.checkNotNullParameter(simpleTypeMarker2, "type");
        Collection<KotlinTypeMarker> possibleIntegerTypes = this.$this_checkSubtypeForIntegerLiteralType.possibleIntegerTypes(simpleTypeMarker);
        if (!(possibleIntegerTypes instanceof Collection) || !possibleIntegerTypes.isEmpty()) {
            for (T t : possibleIntegerTypes) {
                if (Intrinsics.areEqual(this.$this_checkSubtypeForIntegerLiteralType.typeConstructor((KotlinTypeMarker) t), this.$this_checkSubtypeForIntegerLiteralType.typeConstructor(simpleTypeMarker2)) || (z && AbstractTypeChecker.isSubtypeOf$default(AbstractTypeChecker.INSTANCE, this.$this_checkSubtypeForIntegerLiteralType, simpleTypeMarker2, t, false, 8, null))) {
                    z2 = true;
                    continue;
                } else {
                    z2 = false;
                    continue;
                }
                if (z2) {
                    return true;
                }
            }
        }
        return false;
    }
}
