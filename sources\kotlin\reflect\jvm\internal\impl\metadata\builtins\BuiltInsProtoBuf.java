package kotlin.reflect.jvm.internal.impl.metadata.builtins;

import java.util.List;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.WireFormat;
import org.objectweb.asm.Opcodes;

public final class BuiltInsProtoBuf {
    public static final GeneratedMessageLite.GeneratedExtension<ProtoBuf.Class, List<ProtoBuf.Annotation>> classAnnotation = GeneratedMessageLite.newRepeatedGeneratedExtension(ProtoBuf.Class.getDefaultInstance(), ProtoBuf.Annotation.getDefaultInstance(), null, Opcodes.FCMPG, WireFormat.FieldType.MESSAGE, false, ProtoBuf.Annotation.class);
    public static final GeneratedMessageLite.GeneratedExtension<ProtoBuf.Property, ProtoBuf.Annotation.Argument.Value> compileTimeValue = GeneratedMessageLite.newSingularGeneratedExtension(ProtoBuf.Property.getDefaultInstance(), ProtoBuf.Annotation.Argument.Value.getDefaultInstance(), ProtoBuf.Annotation.Argument.Value.getDefaultInstance(), null, Opcodes.DCMPL, WireFormat.FieldType.MESSAGE, ProtoBuf.Annotation.Argument.Value.class);
    public static final GeneratedMessageLite.GeneratedExtension<ProtoBuf.Constructor, List<ProtoBuf.Annotation>> constructorAnnotation = GeneratedMessageLite.newRepeatedGeneratedExtension(ProtoBuf.Constructor.getDefaultInstance(), ProtoBuf.Annotation.getDefaultInstance(), null, Opcodes.FCMPG, WireFormat.FieldType.MESSAGE, false, ProtoBuf.Annotation.class);
    public static final GeneratedMessageLite.GeneratedExtension<ProtoBuf.EnumEntry, List<ProtoBuf.Annotation>> enumEntryAnnotation = GeneratedMessageLite.newRepeatedGeneratedExtension(ProtoBuf.EnumEntry.getDefaultInstance(), ProtoBuf.Annotation.getDefaultInstance(), null, Opcodes.FCMPG, WireFormat.FieldType.MESSAGE, false, ProtoBuf.Annotation.class);
    public static final GeneratedMessageLite.GeneratedExtension<ProtoBuf.Function, List<ProtoBuf.Annotation>> functionAnnotation = GeneratedMessageLite.newRepeatedGeneratedExtension(ProtoBuf.Function.getDefaultInstance(), ProtoBuf.Annotation.getDefaultInstance(), null, Opcodes.FCMPG, WireFormat.FieldType.MESSAGE, false, ProtoBuf.Annotation.class);
    public static final GeneratedMessageLite.GeneratedExtension<ProtoBuf.Package, Integer> packageFqName = GeneratedMessageLite.newSingularGeneratedExtension(ProtoBuf.Package.getDefaultInstance(), 0, null, null, Opcodes.DCMPL, WireFormat.FieldType.INT32, Integer.class);
    public static final GeneratedMessageLite.GeneratedExtension<ProtoBuf.ValueParameter, List<ProtoBuf.Annotation>> parameterAnnotation = GeneratedMessageLite.newRepeatedGeneratedExtension(ProtoBuf.ValueParameter.getDefaultInstance(), ProtoBuf.Annotation.getDefaultInstance(), null, Opcodes.FCMPG, WireFormat.FieldType.MESSAGE, false, ProtoBuf.Annotation.class);
    public static final GeneratedMessageLite.GeneratedExtension<ProtoBuf.Property, List<ProtoBuf.Annotation>> propertyAnnotation = GeneratedMessageLite.newRepeatedGeneratedExtension(ProtoBuf.Property.getDefaultInstance(), ProtoBuf.Annotation.getDefaultInstance(), null, Opcodes.FCMPG, WireFormat.FieldType.MESSAGE, false, ProtoBuf.Annotation.class);
    public static final GeneratedMessageLite.GeneratedExtension<ProtoBuf.Property, List<ProtoBuf.Annotation>> propertyGetterAnnotation = GeneratedMessageLite.newRepeatedGeneratedExtension(ProtoBuf.Property.getDefaultInstance(), ProtoBuf.Annotation.getDefaultInstance(), null, Opcodes.DCMPG, WireFormat.FieldType.MESSAGE, false, ProtoBuf.Annotation.class);
    public static final GeneratedMessageLite.GeneratedExtension<ProtoBuf.Property, List<ProtoBuf.Annotation>> propertySetterAnnotation = GeneratedMessageLite.newRepeatedGeneratedExtension(ProtoBuf.Property.getDefaultInstance(), ProtoBuf.Annotation.getDefaultInstance(), null, Opcodes.IFEQ, WireFormat.FieldType.MESSAGE, false, ProtoBuf.Annotation.class);
    public static final GeneratedMessageLite.GeneratedExtension<ProtoBuf.Type, List<ProtoBuf.Annotation>> typeAnnotation = GeneratedMessageLite.newRepeatedGeneratedExtension(ProtoBuf.Type.getDefaultInstance(), ProtoBuf.Annotation.getDefaultInstance(), null, Opcodes.FCMPG, WireFormat.FieldType.MESSAGE, false, ProtoBuf.Annotation.class);
    public static final GeneratedMessageLite.GeneratedExtension<ProtoBuf.TypeParameter, List<ProtoBuf.Annotation>> typeParameterAnnotation = GeneratedMessageLite.newRepeatedGeneratedExtension(ProtoBuf.TypeParameter.getDefaultInstance(), ProtoBuf.Annotation.getDefaultInstance(), null, Opcodes.FCMPG, WireFormat.FieldType.MESSAGE, false, ProtoBuf.Annotation.class);

    public static void registerAllExtensions(ExtensionRegistryLite extensionRegistryLite) {
        extensionRegistryLite.add(packageFqName);
        extensionRegistryLite.add(classAnnotation);
        extensionRegistryLite.add(constructorAnnotation);
        extensionRegistryLite.add(functionAnnotation);
        extensionRegistryLite.add(propertyAnnotation);
        extensionRegistryLite.add(propertyGetterAnnotation);
        extensionRegistryLite.add(propertySetterAnnotation);
        extensionRegistryLite.add(compileTimeValue);
        extensionRegistryLite.add(enumEntryAnnotation);
        extensionRegistryLite.add(parameterAnnotation);
        extensionRegistryLite.add(typeAnnotation);
        extensionRegistryLite.add(typeParameterAnnotation);
    }
}
