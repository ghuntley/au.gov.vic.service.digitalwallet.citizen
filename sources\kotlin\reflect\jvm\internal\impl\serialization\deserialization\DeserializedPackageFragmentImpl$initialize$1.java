package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import java.util.ArrayList;
import java.util.Collection;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.Name;

/* compiled from: DeserializedPackageFragmentImpl.kt */
final class DeserializedPackageFragmentImpl$initialize$1 extends Lambda implements Function0<Collection<? extends Name>> {
    final /* synthetic */ DeserializedPackageFragmentImpl this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DeserializedPackageFragmentImpl$initialize$1(DeserializedPackageFragmentImpl deserializedPackageFragmentImpl) {
        super(0);
        this.this$0 = deserializedPackageFragmentImpl;
    }

    /* Return type fixed from 'java.util.Collection<kotlin.reflect.jvm.internal.impl.name.Name>' to match base method */
    @Override // kotlin.jvm.functions.Function0
    public final Collection<? extends Name> invoke() {
        ArrayList arrayList = new ArrayList();
        for (T t : this.this$0.getClassDataFinder().getAllClassIds()) {
            T t2 = t;
            if (!t2.isNestedClass() && !ClassDeserializer.Companion.getBLACK_LIST().contains(t2)) {
                arrayList.add(t);
            }
        }
        ArrayList<ClassId> arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList2, 10));
        for (ClassId classId : arrayList2) {
            arrayList3.add(classId.getShortClassName());
        }
        return arrayList3;
    }
}
