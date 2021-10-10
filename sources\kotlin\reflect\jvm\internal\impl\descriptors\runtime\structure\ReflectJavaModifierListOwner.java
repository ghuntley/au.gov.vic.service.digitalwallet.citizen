package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import java.lang.reflect.Modifier;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibilities;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibility;
import kotlin.reflect.jvm.internal.impl.load.java.JavaVisibilities;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaModifierListOwner;

/* compiled from: ReflectJavaModifierListOwner.kt */
public interface ReflectJavaModifierListOwner extends JavaModifierListOwner {
    int getModifiers();

    /* compiled from: ReflectJavaModifierListOwner.kt */
    public static final class DefaultImpls {
        public static boolean isAbstract(ReflectJavaModifierListOwner reflectJavaModifierListOwner) {
            return Modifier.isAbstract(reflectJavaModifierListOwner.getModifiers());
        }

        public static boolean isStatic(ReflectJavaModifierListOwner reflectJavaModifierListOwner) {
            return Modifier.isStatic(reflectJavaModifierListOwner.getModifiers());
        }

        public static boolean isFinal(ReflectJavaModifierListOwner reflectJavaModifierListOwner) {
            return Modifier.isFinal(reflectJavaModifierListOwner.getModifiers());
        }

        public static Visibility getVisibility(ReflectJavaModifierListOwner reflectJavaModifierListOwner) {
            Visibility visibility;
            int modifiers = reflectJavaModifierListOwner.getModifiers();
            if (Modifier.isPublic(modifiers)) {
                visibility = Visibilities.PUBLIC;
            } else if (Modifier.isPrivate(modifiers)) {
                visibility = Visibilities.PRIVATE;
            } else if (!Modifier.isProtected(modifiers)) {
                visibility = JavaVisibilities.PACKAGE_VISIBILITY;
            } else if (Modifier.isStatic(modifiers)) {
                visibility = JavaVisibilities.PROTECTED_STATIC_VISIBILITY;
            } else {
                visibility = JavaVisibilities.PROTECTED_AND_PACKAGE;
            }
            Intrinsics.checkNotNullExpressionValue(visibility, "modifiers.let { modifier…Y\n            }\n        }");
            return visibility;
        }
    }
}
