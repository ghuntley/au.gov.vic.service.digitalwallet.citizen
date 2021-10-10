package kotlin.reflect.jvm.internal.impl.load.kotlin;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* access modifiers changed from: package-private */
/* compiled from: methodSignatureBuilding.kt */
public final class SignatureBuildingComponents$jvmDescriptor$1 extends Lambda implements Function1<String, CharSequence> {
    public static final SignatureBuildingComponents$jvmDescriptor$1 INSTANCE = new SignatureBuildingComponents$jvmDescriptor$1();

    SignatureBuildingComponents$jvmDescriptor$1() {
        super(1);
    }

    public final CharSequence invoke(String str) {
        Intrinsics.checkNotNullParameter(str, "it");
        return SignatureBuildingComponents.INSTANCE.escapeClassName(str);
    }
}
