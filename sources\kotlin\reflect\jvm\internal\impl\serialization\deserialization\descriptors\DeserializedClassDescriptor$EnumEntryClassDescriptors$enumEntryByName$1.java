package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.EnumEntrySyntheticClassDescriptor;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor;

/* access modifiers changed from: package-private */
/* compiled from: DeserializedClassDescriptor.kt */
public final class DeserializedClassDescriptor$EnumEntryClassDescriptors$enumEntryByName$1 extends Lambda implements Function1<Name, ClassDescriptor> {
    final /* synthetic */ DeserializedClassDescriptor.EnumEntryClassDescriptors this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DeserializedClassDescriptor$EnumEntryClassDescriptors$enumEntryByName$1(DeserializedClassDescriptor.EnumEntryClassDescriptors enumEntryClassDescriptors) {
        super(1);
        this.this$0 = enumEntryClassDescriptors;
    }

    public final ClassDescriptor invoke(Name name) {
        Intrinsics.checkNotNullParameter(name, "name");
        ProtoBuf.EnumEntry enumEntry = (ProtoBuf.EnumEntry) this.this$0.enumEntryProtos.get(name);
        return enumEntry != null ? EnumEntrySyntheticClassDescriptor.create(DeserializedClassDescriptor.this.getC().getStorageManager(), DeserializedClassDescriptor.this, name, this.this$0.enumMemberNames, new DeserializedAnnotations(DeserializedClassDescriptor.this.getC().getStorageManager(), new DeserializedClassDescriptor$EnumEntryClassDescriptors$enumEntryByName$1$$special$$inlined$let$lambda$1(enumEntry, this, name)), SourceElement.NO_SOURCE) : null;
    }
}
