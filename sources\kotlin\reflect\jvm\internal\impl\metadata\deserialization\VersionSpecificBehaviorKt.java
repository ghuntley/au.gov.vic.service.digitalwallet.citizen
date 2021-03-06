package kotlin.reflect.jvm.internal.impl.metadata.deserialization;

import com.digitalwallet.app.model.P2PHeader;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: versionSpecificBehavior.kt */
public final class VersionSpecificBehaviorKt {
    public static final boolean isVersionRequirementTableWrittenCorrectly(BinaryVersion binaryVersion) {
        Intrinsics.checkNotNullParameter(binaryVersion, P2PHeader.versionKey);
        return isKotlin1Dot4OrLater(binaryVersion);
    }

    public static final boolean isKotlin1Dot4OrLater(BinaryVersion binaryVersion) {
        Intrinsics.checkNotNullParameter(binaryVersion, P2PHeader.versionKey);
        return binaryVersion.getMajor() == 1 && binaryVersion.getMinor() >= 4;
    }
}
