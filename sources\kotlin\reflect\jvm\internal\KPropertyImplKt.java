package kotlin.reflect.jvm.internal;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.JvmFunctionSignature;
import kotlin.reflect.jvm.internal.JvmPropertySignature;
import kotlin.reflect.jvm.internal.KPropertyImpl;
import kotlin.reflect.jvm.internal.calls.Caller;
import kotlin.reflect.jvm.internal.calls.CallerImpl;
import kotlin.reflect.jvm.internal.calls.InlineClassAwareCallerKt;
import kotlin.reflect.jvm.internal.calls.InternalUnderlyingValOfInlineClass;
import kotlin.reflect.jvm.internal.calls.ThrowingCaller;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibilities;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmProtoBufUtil;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.resolve.InlineClassesUtilsKt;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedPropertyDescriptor;

public final class KPropertyImplKt {
    public static final Object getBoundReceiver(KPropertyImpl.Accessor<?, ?> accessor) {
        Intrinsics.checkNotNullParameter(accessor, "$this$boundReceiver");
        return accessor.getProperty().getBoundReceiver();
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x005e  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0083  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0086  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x013b  */
    public static final Caller<?> computeCallerForAccessor(KPropertyImpl.Accessor<?, ?> accessor, boolean z) {
        Caller caller;
        JvmFunctionSignature.KotlinFunction kotlinFunction;
        CallerImpl.Method.Instance instance;
        Method method;
        CallerImpl.Method.Instance instance2;
        JvmProtoBuf.JvmMethodSignature jvmMethodSignature;
        Method findMethodBySignature;
        CallerImpl.Method.Static r0;
        CallerImpl.Method.JvmStaticInObject jvmStaticInObject;
        CallerImpl.Method.Instance instance3;
        Method unboxMethod;
        InternalUnderlyingValOfInlineClass.Unbound unbound;
        if (KDeclarationContainerImpl.Companion.getLOCAL_PROPERTY_SIGNATURE$kotlin_reflection().matches(accessor.getProperty().getSignature())) {
            return ThrowingCaller.INSTANCE;
        }
        KPropertyImplKt$computeCallerForAccessor$1 kPropertyImplKt$computeCallerForAccessor$1 = new KPropertyImplKt$computeCallerForAccessor$1(accessor);
        KPropertyImplKt$computeCallerForAccessor$3 kPropertyImplKt$computeCallerForAccessor$3 = new KPropertyImplKt$computeCallerForAccessor$3(accessor, z, new KPropertyImplKt$computeCallerForAccessor$2(accessor), kPropertyImplKt$computeCallerForAccessor$1);
        JvmPropertySignature mapPropertySignature = RuntimeTypeMapper.INSTANCE.mapPropertySignature(accessor.getProperty().getDescriptor());
        if (mapPropertySignature instanceof JvmPropertySignature.KotlinProperty) {
            JvmPropertySignature.KotlinProperty kotlinProperty = (JvmPropertySignature.KotlinProperty) mapPropertySignature;
            JvmProtoBuf.JvmPropertySignature signature = kotlinProperty.getSignature();
            if (z) {
                if (signature.hasGetter()) {
                    jvmMethodSignature = signature.getGetter();
                    findMethodBySignature = jvmMethodSignature != null ? accessor.getProperty().getContainer().findMethodBySignature(kotlinProperty.getNameResolver().getString(jvmMethodSignature.getName()), kotlinProperty.getNameResolver().getString(jvmMethodSignature.getDesc())) : null;
                    if (findMethodBySignature == null) {
                        if (!InlineClassesUtilsKt.isUnderlyingPropertyOfInlineClass(accessor.getProperty().getDescriptor()) || !Intrinsics.areEqual(accessor.getProperty().getDescriptor().getVisibility(), Visibilities.INTERNAL)) {
                            Field javaField = accessor.getProperty().getJavaField();
                            if (javaField != null) {
                                caller = kPropertyImplKt$computeCallerForAccessor$3.invoke(javaField);
                            } else {
                                throw new KotlinReflectionInternalError("No accessors or field is found for property " + accessor.getProperty());
                            }
                        } else {
                            Class<?> inlineClass = InlineClassAwareCallerKt.toInlineClass(accessor.getProperty().getDescriptor().getContainingDeclaration());
                            if (inlineClass == null || (unboxMethod = InlineClassAwareCallerKt.getUnboxMethod(inlineClass, accessor.getProperty().getDescriptor())) == null) {
                                throw new KotlinReflectionInternalError("Underlying property of inline class " + accessor.getProperty() + " should have a field");
                            }
                            if (accessor.isBound()) {
                                unbound = new InternalUnderlyingValOfInlineClass.Bound(unboxMethod, getBoundReceiver(accessor));
                            } else {
                                unbound = new InternalUnderlyingValOfInlineClass.Unbound(unboxMethod);
                            }
                            caller = unbound;
                        }
                    } else if (!Modifier.isStatic(findMethodBySignature.getModifiers())) {
                        if (accessor.isBound()) {
                            instance3 = new CallerImpl.Method.BoundInstance(findMethodBySignature, getBoundReceiver(accessor));
                        } else {
                            instance3 = new CallerImpl.Method.Instance(findMethodBySignature);
                        }
                        caller = instance3;
                    } else if (kPropertyImplKt$computeCallerForAccessor$1.invoke()) {
                        if (accessor.isBound()) {
                            jvmStaticInObject = new CallerImpl.Method.BoundJvmStaticInObject(findMethodBySignature);
                        } else {
                            jvmStaticInObject = new CallerImpl.Method.JvmStaticInObject(findMethodBySignature);
                        }
                        caller = jvmStaticInObject;
                    } else {
                        if (accessor.isBound()) {
                            r0 = new CallerImpl.Method.BoundStatic(findMethodBySignature, getBoundReceiver(accessor));
                        } else {
                            r0 = new CallerImpl.Method.Static(findMethodBySignature);
                        }
                        caller = r0;
                    }
                }
            } else if (signature.hasSetter()) {
                jvmMethodSignature = signature.getSetter();
                if (jvmMethodSignature != null) {
                }
                if (findMethodBySignature == null) {
                }
            }
            jvmMethodSignature = null;
            if (jvmMethodSignature != null) {
            }
            if (findMethodBySignature == null) {
            }
        } else if (mapPropertySignature instanceof JvmPropertySignature.JavaField) {
            caller = kPropertyImplKt$computeCallerForAccessor$3.invoke(((JvmPropertySignature.JavaField) mapPropertySignature).getField());
        } else if (mapPropertySignature instanceof JvmPropertySignature.JavaMethodProperty) {
            if (z) {
                method = ((JvmPropertySignature.JavaMethodProperty) mapPropertySignature).getGetterMethod();
            } else {
                JvmPropertySignature.JavaMethodProperty javaMethodProperty = (JvmPropertySignature.JavaMethodProperty) mapPropertySignature;
                method = javaMethodProperty.getSetterMethod();
                if (method == null) {
                    throw new KotlinReflectionInternalError("No source found for setter of Java method property: " + javaMethodProperty.getGetterMethod());
                }
            }
            if (accessor.isBound()) {
                instance2 = new CallerImpl.Method.BoundInstance(method, getBoundReceiver(accessor));
            } else {
                instance2 = new CallerImpl.Method.Instance(method);
            }
            caller = instance2;
        } else if (mapPropertySignature instanceof JvmPropertySignature.MappedKotlinProperty) {
            if (z) {
                kotlinFunction = ((JvmPropertySignature.MappedKotlinProperty) mapPropertySignature).getGetterSignature();
            } else {
                kotlinFunction = ((JvmPropertySignature.MappedKotlinProperty) mapPropertySignature).getSetterSignature();
                if (kotlinFunction == null) {
                    throw new KotlinReflectionInternalError("No setter found for property " + accessor.getProperty());
                }
            }
            Method findMethodBySignature2 = accessor.getProperty().getContainer().findMethodBySignature(kotlinFunction.getMethodName(), kotlinFunction.getMethodDesc());
            if (findMethodBySignature2 != null) {
                Modifier.isStatic(findMethodBySignature2.getModifiers());
                if (accessor.isBound()) {
                    instance = new CallerImpl.Method.BoundInstance(findMethodBySignature2, getBoundReceiver(accessor));
                } else {
                    instance = new CallerImpl.Method.Instance(findMethodBySignature2);
                }
                return instance;
            }
            throw new KotlinReflectionInternalError("No accessor found for property " + accessor.getProperty());
        } else {
            throw new NoWhenBranchMatchedException();
        }
        return InlineClassAwareCallerKt.createInlineClassAwareCallerIfNeeded$default(caller, accessor.getDescriptor(), false, 2, null);
    }

    public static final boolean isJvmFieldPropertyInCompanionObject(PropertyDescriptor propertyDescriptor) {
        DeclarationDescriptor containingDeclaration = propertyDescriptor.getContainingDeclaration();
        Intrinsics.checkNotNullExpressionValue(containingDeclaration, "containingDeclaration");
        if (!DescriptorUtils.isCompanionObject(containingDeclaration)) {
            return false;
        }
        DeclarationDescriptor containingDeclaration2 = containingDeclaration.getContainingDeclaration();
        if ((DescriptorUtils.isInterface(containingDeclaration2) || DescriptorUtils.isAnnotationClass(containingDeclaration2)) && (!(propertyDescriptor instanceof DeserializedPropertyDescriptor) || !JvmProtoBufUtil.isMovedFromInterfaceCompanion(((DeserializedPropertyDescriptor) propertyDescriptor).getProto()))) {
            return false;
        }
        return true;
    }
}
