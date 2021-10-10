package kotlin.reflect.jvm.internal.impl.util;

import com.google.firebase.messaging.Constants;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;

/* compiled from: ModuleVisibilityHelper.kt */
public interface ModuleVisibilityHelper {
    boolean isInFriendModule(DeclarationDescriptor declarationDescriptor, DeclarationDescriptor declarationDescriptor2);

    /* compiled from: ModuleVisibilityHelper.kt */
    public static final class EMPTY implements ModuleVisibilityHelper {
        public static final EMPTY INSTANCE = new EMPTY();

        @Override // kotlin.reflect.jvm.internal.impl.util.ModuleVisibilityHelper
        public boolean isInFriendModule(DeclarationDescriptor declarationDescriptor, DeclarationDescriptor declarationDescriptor2) {
            Intrinsics.checkNotNullParameter(declarationDescriptor, "what");
            Intrinsics.checkNotNullParameter(declarationDescriptor2, Constants.MessagePayloadKeys.FROM);
            return true;
        }

        private EMPTY() {
        }
    }
}
