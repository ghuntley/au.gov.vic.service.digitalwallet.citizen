package kotlin.reflect.jvm.internal.impl.resolve;

import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;

/* compiled from: ResolutionAnchorProvider.kt */
public final class ResolutionAnchorProviderKt {
    private static final ModuleDescriptor.Capability<ResolutionAnchorProvider> RESOLUTION_ANCHOR_PROVIDER_CAPABILITY = new ModuleDescriptor.Capability<>("ResolutionAnchorProvider");

    public static final ModuleDescriptor.Capability<ResolutionAnchorProvider> getRESOLUTION_ANCHOR_PROVIDER_CAPABILITY() {
        return RESOLUTION_ANCHOR_PROVIDER_CAPABILITY;
    }
}
