package kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization;

import kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags;

/* compiled from: JvmFlags.kt */
public final class JvmFlags {
    private static final Flags.BooleanFlagField ARE_INTERFACE_METHOD_BODIES_INSIDE;
    public static final JvmFlags INSTANCE = new JvmFlags();
    private static final Flags.BooleanFlagField IS_ALL_COMPATIBILITY_MODE;
    private static final Flags.BooleanFlagField IS_MOVED_FROM_INTERFACE_COMPANION = Flags.FlagField.booleanFirst();

    static {
        Flags.BooleanFlagField booleanFirst = Flags.FlagField.booleanFirst();
        ARE_INTERFACE_METHOD_BODIES_INSIDE = booleanFirst;
        IS_ALL_COMPATIBILITY_MODE = Flags.FlagField.booleanAfter(booleanFirst);
    }

    private JvmFlags() {
    }

    public final Flags.BooleanFlagField getIS_MOVED_FROM_INTERFACE_COMPANION() {
        return IS_MOVED_FROM_INTERFACE_COMPANION;
    }
}
