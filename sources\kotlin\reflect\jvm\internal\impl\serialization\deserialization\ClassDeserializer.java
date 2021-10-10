package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import java.util.Iterator;
import java.util.Set;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProvider;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.ClassDescriptorFactory;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.BinaryVersion;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.TypeTable;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.VersionRequirementTable;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor;

public final class ClassDeserializer {
    private static final Set<ClassId> BLACK_LIST = SetsKt.setOf(ClassId.topLevel(KotlinBuiltIns.FQ_NAMES.cloneable.toSafe()));
    public static final Companion Companion = new Companion(null);
    private final Function1<ClassKey, ClassDescriptor> classes;
    private final DeserializationComponents components;

    public ClassDeserializer(DeserializationComponents deserializationComponents) {
        Intrinsics.checkNotNullParameter(deserializationComponents, "components");
        this.components = deserializationComponents;
        this.classes = deserializationComponents.getStorageManager().createMemoizedFunctionWithNullableValues(new ClassDeserializer$classes$1(this));
    }

    public static /* synthetic */ ClassDescriptor deserializeClass$default(ClassDeserializer classDeserializer, ClassId classId, ClassData classData, int i, Object obj) {
        if ((i & 2) != 0) {
            classData = null;
        }
        return classDeserializer.deserializeClass(classId, classData);
    }

    public final ClassDescriptor deserializeClass(ClassId classId, ClassData classData) {
        Intrinsics.checkNotNullParameter(classId, "classId");
        return this.classes.invoke(new ClassKey(classId, classData));
    }

    /* access modifiers changed from: public */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00bb A[EDGE_INSN: B:45:0x00bb->B:37:0x00bb ?: BREAK  , SYNTHETIC] */
    private final ClassDescriptor createClass(ClassKey classKey) {
        T t;
        DeserializationContext createContext;
        boolean z;
        ClassId classId = classKey.getClassId();
        for (ClassDescriptorFactory classDescriptorFactory : this.components.getFictitiousClassDescriptorFactories()) {
            ClassDescriptor createClass = classDescriptorFactory.createClass(classId);
            if (createClass != null) {
                return createClass;
            }
        }
        if (BLACK_LIST.contains(classId)) {
            return null;
        }
        ClassData classData = classKey.getClassData();
        if (classData == null) {
            classData = this.components.getClassDataFinder().findClassData(classId);
        }
        if (classData != null) {
            NameResolver component1 = classData.component1();
            ProtoBuf.Class component2 = classData.component2();
            BinaryVersion component3 = classData.component3();
            SourceElement component4 = classData.component4();
            ClassId outerClassId = classId.getOuterClassId();
            if (outerClassId != null) {
                ClassDescriptor deserializeClass$default = deserializeClass$default(this, outerClassId, null, 2, null);
                if (!(deserializeClass$default instanceof DeserializedClassDescriptor)) {
                    deserializeClass$default = null;
                }
                DeserializedClassDescriptor deserializedClassDescriptor = (DeserializedClassDescriptor) deserializeClass$default;
                if (deserializedClassDescriptor == null) {
                    return null;
                }
                Name shortClassName = classId.getShortClassName();
                Intrinsics.checkNotNullExpressionValue(shortClassName, "classId.shortClassName");
                if (!deserializedClassDescriptor.hasNestedClass$deserialization(shortClassName)) {
                    return null;
                }
                createContext = deserializedClassDescriptor.getC();
            } else {
                PackageFragmentProvider packageFragmentProvider = this.components.getPackageFragmentProvider();
                FqName packageFqName = classId.getPackageFqName();
                Intrinsics.checkNotNullExpressionValue(packageFqName, "classId.packageFqName");
                Iterator<T> it = packageFragmentProvider.getPackageFragments(packageFqName).iterator();
                while (true) {
                    if (!it.hasNext()) {
                        t = null;
                        break;
                    }
                    t = it.next();
                    T t2 = t;
                    if (t2 instanceof DeserializedPackageFragment) {
                        Name shortClassName2 = classId.getShortClassName();
                        Intrinsics.checkNotNullExpressionValue(shortClassName2, "classId.shortClassName");
                        if (!t2.hasTopLevelClass(shortClassName2)) {
                            z = false;
                            continue;
                            if (z) {
                                break;
                            }
                        }
                    }
                    z = true;
                    continue;
                    if (z) {
                    }
                }
                T t3 = t;
                if (t3 != null) {
                    DeserializationComponents deserializationComponents = this.components;
                    ProtoBuf.TypeTable typeTable = component2.getTypeTable();
                    Intrinsics.checkNotNullExpressionValue(typeTable, "classProto.typeTable");
                    TypeTable typeTable2 = new TypeTable(typeTable);
                    VersionRequirementTable.Companion companion = VersionRequirementTable.Companion;
                    ProtoBuf.VersionRequirementTable versionRequirementTable = component2.getVersionRequirementTable();
                    Intrinsics.checkNotNullExpressionValue(versionRequirementTable, "classProto.versionRequirementTable");
                    createContext = deserializationComponents.createContext(t3, component1, typeTable2, companion.create(versionRequirementTable), component3, null);
                }
            }
            return new DeserializedClassDescriptor(createContext, component2, component1, component3, component4);
        }
        return null;
    }

    public static final class ClassKey {
        private final ClassData classData;
        private final ClassId classId;

        public ClassKey(ClassId classId2, ClassData classData2) {
            Intrinsics.checkNotNullParameter(classId2, "classId");
            this.classId = classId2;
            this.classData = classData2;
        }

        public final ClassData getClassData() {
            return this.classData;
        }

        public final ClassId getClassId() {
            return this.classId;
        }

        public boolean equals(Object obj) {
            return (obj instanceof ClassKey) && Intrinsics.areEqual(this.classId, ((ClassKey) obj).classId);
        }

        public int hashCode() {
            return this.classId.hashCode();
        }
    }

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Set<ClassId> getBLACK_LIST() {
            return ClassDeserializer.BLACK_LIST;
        }
    }
}
