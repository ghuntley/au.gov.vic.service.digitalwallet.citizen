package net.minidev.asm;

import java.lang.reflect.Method;
import java.util.HashMap;
import kotlin.text.Typography;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;

public class BeansAccessBuilder {
    private static String METHOD_ACCESS_NAME = Type.getInternalName(BeansAccess.class);
    final String accessClassName;
    final String accessClassNameInternal;
    final Accessor[] accs;
    final String className;
    final String classNameInternal;
    final HashMap<Class<?>, Method> convMtds = new HashMap<>();
    Class<? extends Exception> exeptionClass = NoSuchFieldException.class;
    final DynamicClassLoader loader;
    final Class<?> type;

    private void dumpDebug(byte[] bArr, String str) {
    }

    public BeansAccessBuilder(Class<?> cls, Accessor[] accessorArr, DynamicClassLoader dynamicClassLoader) {
        this.type = cls;
        this.accs = accessorArr;
        this.loader = dynamicClassLoader;
        String name = cls.getName();
        this.className = name;
        if (name.startsWith("java.")) {
            this.accessClassName = "net.minidev.asm." + name + "AccAccess";
        } else {
            this.accessClassName = name.concat("AccAccess");
        }
        this.accessClassNameInternal = this.accessClassName.replace('.', '/');
        this.classNameInternal = name.replace('.', '/');
    }

    public void addConversion(Iterable<Class<?>> iterable) {
        if (iterable != null) {
            for (Class<?> cls : iterable) {
                addConversion(cls);
            }
        }
    }

    public void addConversion(Class<?> cls) {
        if (cls != null) {
            Method[] methods = cls.getMethods();
            for (Method method : methods) {
                if ((method.getModifiers() & 8) != 0) {
                    Class<?>[] parameterTypes = method.getParameterTypes();
                    if (parameterTypes.length == 1 && parameterTypes[0].equals(Object.class)) {
                        Class<?> returnType = method.getReturnType();
                        if (!returnType.equals(Void.TYPE)) {
                            this.convMtds.put(returnType, method);
                        }
                    }
                }
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:45:0x01ea  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x01f1  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x0209  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x027f  */
    public Class<?> bulid() {
        Class<? extends Exception> cls;
        char c;
        int i;
        int i2;
        char c2;
        int i3 = 1;
        ClassWriter classWriter = new ClassWriter(1);
        boolean z = this.accs.length > 10;
        classWriter.visit(50, 33, this.accessClassNameInternal, "Lnet/minidev/asm/BeansAccess<L" + this.classNameInternal + ";>;", METHOD_ACCESS_NAME, null);
        MethodVisitor visitMethod = classWriter.visitMethod(1, "<init>", "()V", null, null);
        visitMethod.visitCode();
        visitMethod.visitVarInsn(25, 0);
        visitMethod.visitMethodInsn(Opcodes.INVOKESPECIAL, METHOD_ACCESS_NAME, "<init>", "()V");
        visitMethod.visitInsn(Opcodes.RETURN);
        visitMethod.visitMaxs(1, 1);
        visitMethod.visitEnd();
        MethodVisitor visitMethod2 = classWriter.visitMethod(1, "set", "(Ljava/lang/Object;ILjava/lang/Object;)V", null, null);
        visitMethod2.visitCode();
        Accessor[] accessorArr = this.accs;
        if (accessorArr.length != 0) {
            if (accessorArr.length > 14) {
                visitMethod2.visitVarInsn(21, 2);
                Label[] newLabels = ASMUtil.newLabels(this.accs.length);
                Label label = new Label();
                visitMethod2.visitTableSwitchInsn(0, newLabels.length - 1, label, newLabels);
                Accessor[] accessorArr2 = this.accs;
                int length = accessorArr2.length;
                int i4 = 0;
                int i5 = 0;
                while (i4 < length) {
                    Accessor accessor = accessorArr2[i4];
                    int i6 = i5 + 1;
                    visitMethod2.visitLabel(newLabels[i5]);
                    if (!accessor.isWritable()) {
                        visitMethod2.visitInsn(Opcodes.RETURN);
                    } else {
                        internalSetFiled(visitMethod2, accessor);
                    }
                    i4++;
                    i5 = i6;
                }
                visitMethod2.visitLabel(label);
            } else {
                Label[] newLabels2 = ASMUtil.newLabels(accessorArr.length);
                Accessor[] accessorArr3 = this.accs;
                int i7 = 0;
                for (Accessor accessor2 : accessorArr3) {
                    ifNotEqJmp(visitMethod2, 2, i7, newLabels2[i7]);
                    internalSetFiled(visitMethod2, accessor2);
                    visitMethod2.visitLabel(newLabels2[i7]);
                    visitMethod2.visitFrame(3, 0, null, 0, null);
                    i7++;
                }
            }
        }
        Class<? extends Exception> cls2 = this.exeptionClass;
        if (cls2 != null) {
            throwExIntParam(visitMethod2, cls2);
        } else {
            visitMethod2.visitInsn(Opcodes.RETURN);
        }
        visitMethod2.visitMaxs(0, 0);
        visitMethod2.visitEnd();
        MethodVisitor visitMethod3 = classWriter.visitMethod(1, "get", "(Ljava/lang/Object;I)Ljava/lang/Object;", null, null);
        visitMethod3.visitCode();
        Accessor[] accessorArr4 = this.accs;
        int length2 = accessorArr4.length;
        int i8 = Opcodes.CHECKCAST;
        int i9 = Opcodes.ARETURN;
        if (length2 == 0) {
            visitMethod3.visitFrame(3, 0, null, 0, null);
        } else if (accessorArr4.length > 14) {
            visitMethod3.visitVarInsn(21, 2);
            Label[] newLabels3 = ASMUtil.newLabels(this.accs.length);
            Label label2 = new Label();
            visitMethod3.visitTableSwitchInsn(0, newLabels3.length - 1, label2, newLabels3);
            Accessor[] accessorArr5 = this.accs;
            int length3 = accessorArr5.length;
            int i10 = 0;
            int i11 = 0;
            while (i10 < length3) {
                Accessor accessor3 = accessorArr5[i10];
                int i12 = i11 + 1;
                visitMethod3.visitLabel(newLabels3[i11]);
                visitMethod3.visitFrame(3, 0, null, 0, null);
                if (!accessor3.isReadable()) {
                    visitMethod3.visitInsn(i3);
                    visitMethod3.visitInsn(i9);
                } else {
                    visitMethod3.visitVarInsn(25, i3);
                    visitMethod3.visitTypeInsn(i8, this.classNameInternal);
                    Type type2 = Type.getType(accessor3.getType());
                    if (accessor3.isPublic()) {
                        visitMethod3.visitFieldInsn(180, this.classNameInternal, accessor3.getName(), type2.getDescriptor());
                    } else {
                        visitMethod3.visitMethodInsn(Opcodes.INVOKEVIRTUAL, this.classNameInternal, accessor3.getter.getName(), Type.getMethodDescriptor(accessor3.getter));
                    }
                    ASMUtil.autoBoxing(visitMethod3, type2);
                    visitMethod3.visitInsn(Opcodes.ARETURN);
                }
                i10++;
                i11 = i12;
                i9 = Opcodes.ARETURN;
                i8 = Opcodes.CHECKCAST;
                i3 = 1;
            }
            visitMethod3.visitLabel(label2);
            visitMethod3.visitFrame(3, 0, null, 0, null);
        } else {
            Label[] newLabels4 = ASMUtil.newLabels(accessorArr4.length);
            Accessor[] accessorArr6 = this.accs;
            int i13 = 0;
            for (Accessor accessor4 : accessorArr6) {
                ifNotEqJmp(visitMethod3, 2, i13, newLabels4[i13]);
                visitMethod3.visitVarInsn(25, 1);
                visitMethod3.visitTypeInsn(Opcodes.CHECKCAST, this.classNameInternal);
                Type type3 = Type.getType(accessor4.getType());
                if (accessor4.isPublic()) {
                    visitMethod3.visitFieldInsn(180, this.classNameInternal, accessor4.getName(), type3.getDescriptor());
                    c2 = Typography.paragraph;
                } else if (accessor4.getter != null) {
                    String methodDescriptor = Type.getMethodDescriptor(accessor4.getter);
                    String str = this.classNameInternal;
                    String name = accessor4.getter.getName();
                    c2 = Typography.paragraph;
                    visitMethod3.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str, name, methodDescriptor);
                } else {
                    throw new RuntimeException("no Getter for field " + accessor4.getName() + " in class " + this.className);
                }
                ASMUtil.autoBoxing(visitMethod3, type3);
                visitMethod3.visitInsn(Opcodes.ARETURN);
                visitMethod3.visitLabel(newLabels4[i13]);
                visitMethod3.visitFrame(3, 0, null, 0, null);
                i13++;
            }
            cls = this.exeptionClass;
            if (cls == null) {
                throwExIntParam(visitMethod3, cls);
                i = 0;
                c = Typography.degree;
            } else {
                visitMethod3.visitInsn(1);
                c = Typography.degree;
                visitMethod3.visitInsn(Opcodes.ARETURN);
                i = 0;
            }
            visitMethod3.visitMaxs(i, i);
            visitMethod3.visitEnd();
            if (!z) {
                MethodVisitor visitMethod4 = classWriter.visitMethod(1, "set", "(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/Object;)V", null, null);
                visitMethod4.visitCode();
                Label[] newLabels5 = ASMUtil.newLabels(this.accs.length);
                Accessor[] accessorArr7 = this.accs;
                int length4 = accessorArr7.length;
                int i14 = 0;
                int i15 = 0;
                while (i14 < length4) {
                    Accessor accessor5 = accessorArr7[i14];
                    visitMethod4.visitVarInsn(25, 2);
                    visitMethod4.visitLdcInsn(accessor5.fieldName);
                    visitMethod4.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/lang/String", "equals", "(Ljava/lang/Object;)Z");
                    visitMethod4.visitJumpInsn(Opcodes.IFEQ, newLabels5[i15]);
                    internalSetFiled(visitMethod4, accessor5);
                    visitMethod4.visitLabel(newLabels5[i15]);
                    visitMethod4.visitFrame(3, 0, null, 0, null);
                    i15++;
                    i14++;
                    accessorArr7 = accessorArr7;
                }
                Class<? extends Exception> cls3 = this.exeptionClass;
                if (cls3 != null) {
                    throwExStrParam(visitMethod4, cls3);
                } else {
                    visitMethod4.visitInsn(Opcodes.RETURN);
                }
                visitMethod4.visitMaxs(0, 0);
                visitMethod4.visitEnd();
            }
            if (!z) {
                MethodVisitor visitMethod5 = classWriter.visitMethod(1, "get", "(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;", null, null);
                visitMethod5.visitCode();
                Label[] newLabels6 = ASMUtil.newLabels(this.accs.length);
                Accessor[] accessorArr8 = this.accs;
                int length5 = accessorArr8.length;
                int i16 = 0;
                int i17 = 0;
                while (i16 < length5) {
                    Accessor accessor6 = accessorArr8[i16];
                    visitMethod5.visitVarInsn(25, 2);
                    visitMethod5.visitLdcInsn(accessor6.fieldName);
                    visitMethod5.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/lang/String", "equals", "(Ljava/lang/Object;)Z");
                    visitMethod5.visitJumpInsn(Opcodes.IFEQ, newLabels6[i17]);
                    visitMethod5.visitVarInsn(25, 1);
                    visitMethod5.visitTypeInsn(Opcodes.CHECKCAST, this.classNameInternal);
                    Type type4 = Type.getType(accessor6.getType());
                    if (accessor6.isPublic()) {
                        i2 = length5;
                        visitMethod5.visitFieldInsn(180, this.classNameInternal, accessor6.getName(), type4.getDescriptor());
                    } else {
                        i2 = length5;
                        visitMethod5.visitMethodInsn(Opcodes.INVOKEVIRTUAL, this.classNameInternal, accessor6.getter.getName(), Type.getMethodDescriptor(accessor6.getter));
                    }
                    ASMUtil.autoBoxing(visitMethod5, type4);
                    visitMethod5.visitInsn(Opcodes.ARETURN);
                    visitMethod5.visitLabel(newLabels6[i17]);
                    visitMethod5.visitFrame(3, 0, null, 0, null);
                    i17++;
                    i16++;
                    accessorArr8 = accessorArr8;
                    length5 = i2;
                }
                Class<? extends Exception> cls4 = this.exeptionClass;
                if (cls4 != null) {
                    throwExStrParam(visitMethod5, cls4);
                } else {
                    visitMethod5.visitInsn(1);
                    visitMethod5.visitInsn(Opcodes.ARETURN);
                }
                visitMethod5.visitMaxs(0, 0);
                visitMethod5.visitEnd();
            }
            MethodVisitor visitMethod6 = classWriter.visitMethod(1, "newInstance", "()Ljava/lang/Object;", null, null);
            visitMethod6.visitCode();
            visitMethod6.visitTypeInsn(Opcodes.NEW, this.classNameInternal);
            visitMethod6.visitInsn(89);
            visitMethod6.visitMethodInsn(Opcodes.INVOKESPECIAL, this.classNameInternal, "<init>", "()V");
            visitMethod6.visitInsn(Opcodes.ARETURN);
            visitMethod6.visitMaxs(2, 1);
            visitMethod6.visitEnd();
            classWriter.visitEnd();
            return this.loader.defineClass(this.accessClassName, classWriter.toByteArray());
        }
        cls = this.exeptionClass;
        if (cls == null) {
        }
        visitMethod3.visitMaxs(i, i);
        visitMethod3.visitEnd();
        if (!z) {
        }
        if (!z) {
        }
        MethodVisitor visitMethod62 = classWriter.visitMethod(1, "newInstance", "()Ljava/lang/Object;", null, null);
        visitMethod62.visitCode();
        visitMethod62.visitTypeInsn(Opcodes.NEW, this.classNameInternal);
        visitMethod62.visitInsn(89);
        visitMethod62.visitMethodInsn(Opcodes.INVOKESPECIAL, this.classNameInternal, "<init>", "()V");
        visitMethod62.visitInsn(Opcodes.ARETURN);
        visitMethod62.visitMaxs(2, 1);
        visitMethod62.visitEnd();
        classWriter.visitEnd();
        return this.loader.defineClass(this.accessClassName, classWriter.toByteArray());
    }

    private void internalSetFiled(MethodVisitor methodVisitor, Accessor accessor) {
        methodVisitor.visitVarInsn(25, 1);
        methodVisitor.visitTypeInsn(Opcodes.CHECKCAST, this.classNameInternal);
        methodVisitor.visitVarInsn(25, 3);
        Type type2 = Type.getType(accessor.getType());
        Class<?> type3 = accessor.getType();
        String internalName = Type.getInternalName(type3);
        Method method = this.convMtds.get(type3);
        if (method != null) {
            methodVisitor.visitMethodInsn(Opcodes.INVOKESTATIC, Type.getInternalName(method.getDeclaringClass()), method.getName(), Type.getMethodDescriptor(method));
        } else if (accessor.isEnum()) {
            Label label = new Label();
            methodVisitor.visitJumpInsn(Opcodes.IFNULL, label);
            methodVisitor.visitVarInsn(25, 3);
            methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/lang/Object", "toString", "()Ljava/lang/String;");
            methodVisitor.visitMethodInsn(Opcodes.INVOKESTATIC, internalName, "valueOf", "(Ljava/lang/String;)L" + internalName + ";");
            methodVisitor.visitVarInsn(58, 3);
            methodVisitor.visitLabel(label);
            methodVisitor.visitFrame(3, 0, null, 0, null);
            methodVisitor.visitVarInsn(25, 1);
            methodVisitor.visitTypeInsn(Opcodes.CHECKCAST, this.classNameInternal);
            methodVisitor.visitVarInsn(25, 3);
            methodVisitor.visitTypeInsn(Opcodes.CHECKCAST, internalName);
        } else if (type3.equals(String.class)) {
            Label label2 = new Label();
            methodVisitor.visitJumpInsn(Opcodes.IFNULL, label2);
            methodVisitor.visitVarInsn(25, 3);
            methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/lang/Object", "toString", "()Ljava/lang/String;");
            methodVisitor.visitVarInsn(58, 3);
            methodVisitor.visitLabel(label2);
            methodVisitor.visitFrame(3, 0, null, 0, null);
            methodVisitor.visitVarInsn(25, 1);
            methodVisitor.visitTypeInsn(Opcodes.CHECKCAST, this.classNameInternal);
            methodVisitor.visitVarInsn(25, 3);
            methodVisitor.visitTypeInsn(Opcodes.CHECKCAST, internalName);
        } else {
            methodVisitor.visitTypeInsn(Opcodes.CHECKCAST, internalName);
        }
        if (accessor.isPublic()) {
            methodVisitor.visitFieldInsn(Opcodes.PUTFIELD, this.classNameInternal, accessor.getName(), type2.getDescriptor());
        } else {
            methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, this.classNameInternal, accessor.setter.getName(), Type.getMethodDescriptor(accessor.setter));
        }
        methodVisitor.visitInsn(Opcodes.RETURN);
    }

    private void throwExIntParam(MethodVisitor methodVisitor, Class<?> cls) {
        String internalName = Type.getInternalName(cls);
        methodVisitor.visitTypeInsn(Opcodes.NEW, internalName);
        methodVisitor.visitInsn(89);
        methodVisitor.visitLdcInsn("mapping " + this.className + " failed to map field:");
        methodVisitor.visitVarInsn(21, 2);
        methodVisitor.visitMethodInsn(Opcodes.INVOKESTATIC, "java/lang/Integer", "toString", "(I)Ljava/lang/String;");
        methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/lang/String", "concat", "(Ljava/lang/String;)Ljava/lang/String;");
        methodVisitor.visitMethodInsn(Opcodes.INVOKESPECIAL, internalName, "<init>", "(Ljava/lang/String;)V");
        methodVisitor.visitInsn(Opcodes.ATHROW);
    }

    private void throwExStrParam(MethodVisitor methodVisitor, Class<?> cls) {
        String internalName = Type.getInternalName(cls);
        methodVisitor.visitTypeInsn(Opcodes.NEW, internalName);
        methodVisitor.visitInsn(89);
        methodVisitor.visitLdcInsn("mapping " + this.className + " failed to map field:");
        methodVisitor.visitVarInsn(25, 2);
        methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/lang/String", "concat", "(Ljava/lang/String;)Ljava/lang/String;");
        methodVisitor.visitMethodInsn(Opcodes.INVOKESPECIAL, internalName, "<init>", "(Ljava/lang/String;)V");
        methodVisitor.visitInsn(Opcodes.ATHROW);
    }

    private void ifNotEqJmp(MethodVisitor methodVisitor, int i, int i2, Label label) {
        methodVisitor.visitVarInsn(21, i);
        if (i2 == 0) {
            methodVisitor.visitJumpInsn(Opcodes.IFNE, label);
        } else if (i2 == 1) {
            methodVisitor.visitInsn(4);
            methodVisitor.visitJumpInsn(Opcodes.IF_ICMPNE, label);
        } else if (i2 == 2) {
            methodVisitor.visitInsn(5);
            methodVisitor.visitJumpInsn(Opcodes.IF_ICMPNE, label);
        } else if (i2 == 3) {
            methodVisitor.visitInsn(6);
            methodVisitor.visitJumpInsn(Opcodes.IF_ICMPNE, label);
        } else if (i2 == 4) {
            methodVisitor.visitInsn(7);
            methodVisitor.visitJumpInsn(Opcodes.IF_ICMPNE, label);
        } else if (i2 == 5) {
            methodVisitor.visitInsn(8);
            methodVisitor.visitJumpInsn(Opcodes.IF_ICMPNE, label);
        } else if (i2 >= 6) {
            methodVisitor.visitIntInsn(16, i2);
            methodVisitor.visitJumpInsn(Opcodes.IF_ICMPNE, label);
        } else {
            throw new RuntimeException("non supported negative values");
        }
    }
}
