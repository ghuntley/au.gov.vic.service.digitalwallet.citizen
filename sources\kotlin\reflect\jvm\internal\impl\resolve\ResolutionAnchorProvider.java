package kotlin.reflect.jvm.internal.impl.resolve;

import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;

/* compiled from: ResolutionAnchorProvider.kt */
public interface ResolutionAnchorProvider {
    public static final Companion Companion = Companion.$$INSTANCE;

    ModuleDescriptor getResolutionAnchor(ModuleDescriptor moduleDescriptor);

    /* compiled from: ResolutionAnchorProvider.kt */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        private static final ResolutionAnchorProvider Default = new ResolutionAnchorProvider$Companion$Default$1();

        private Companion() {
        }
    }
}
