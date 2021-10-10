package kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntProgression;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlin.text.Typography;

/* compiled from: ClassMapperLite.kt */
public final class ClassMapperLite {
    public static final ClassMapperLite INSTANCE = new ClassMapperLite();

    /* renamed from: kotlin  reason: collision with root package name */
    private static final String f5kotlin = CollectionsKt.joinToString$default(CollectionsKt.listOf((Object[]) new Character[]{'k', 'o', 't', 'l', 'i', 'n'}), "", null, null, 0, null, null, 62, null);
    private static final Map<String, String> map;

    static {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        List listOf = CollectionsKt.listOf((Object[]) new String[]{"Boolean", "Z", "Char", "C", "Byte", "B", "Short", "S", "Int", "I", "Float", "F", "Long", "J", "Double", "D"});
        IntProgression step = RangesKt.step(CollectionsKt.getIndices(listOf), 2);
        int first = step.getFirst();
        int last = step.getLast();
        int step2 = step.getStep();
        if (step2 < 0 ? first >= last : first <= last) {
            while (true) {
                StringBuilder sb = new StringBuilder();
                String str = f5kotlin;
                sb.append(str);
                sb.append('/');
                sb.append((String) listOf.get(first));
                int i = first + 1;
                linkedHashMap.put(sb.toString(), listOf.get(i));
                linkedHashMap.put(str + '/' + ((String) listOf.get(first)) + "Array", '[' + ((String) listOf.get(i)));
                if (first == last) {
                    break;
                }
                first += step2;
            }
        }
        linkedHashMap.put(f5kotlin + "/Unit", "V");
        ClassMapperLite$map$1$1 classMapperLite$map$1$1 = new ClassMapperLite$map$1$1(linkedHashMap);
        classMapperLite$map$1$1.invoke("Any", "java/lang/Object");
        classMapperLite$map$1$1.invoke("Nothing", "java/lang/Void");
        classMapperLite$map$1$1.invoke("Annotation", "java/lang/annotation/Annotation");
        for (String str2 : CollectionsKt.listOf((Object[]) new String[]{"String", "CharSequence", "Throwable", "Cloneable", "Number", "Comparable", "Enum"})) {
            classMapperLite$map$1$1.invoke(str2, "java/lang/" + str2);
        }
        for (String str3 : CollectionsKt.listOf((Object[]) new String[]{"Iterator", "Collection", "List", "Set", "Map", "ListIterator"})) {
            classMapperLite$map$1$1.invoke("collections/" + str3, "java/util/" + str3);
            classMapperLite$map$1$1.invoke("collections/Mutable" + str3, "java/util/" + str3);
        }
        classMapperLite$map$1$1.invoke("collections/Iterable", "java/lang/Iterable");
        classMapperLite$map$1$1.invoke("collections/MutableIterable", "java/lang/Iterable");
        classMapperLite$map$1$1.invoke("collections/Map.Entry", "java/util/Map$Entry");
        classMapperLite$map$1$1.invoke("collections/MutableMap.MutableEntry", "java/util/Map$Entry");
        for (int i2 = 0; i2 <= 22; i2++) {
            StringBuilder sb2 = new StringBuilder();
            String str4 = f5kotlin;
            sb2.append(str4);
            sb2.append("/jvm/functions/Function");
            sb2.append(i2);
            classMapperLite$map$1$1.invoke("Function" + i2, sb2.toString());
            classMapperLite$map$1$1.invoke("reflect/KFunction" + i2, str4 + "/reflect/KFunction");
        }
        for (String str5 : CollectionsKt.listOf((Object[]) new String[]{"Char", "Byte", "Short", "Int", "Float", "Long", "Double", "String", "Enum"})) {
            classMapperLite$map$1$1.invoke(str5 + ".Companion", f5kotlin + "/jvm/internal/" + str5 + "CompanionObject");
        }
        map = linkedHashMap;
    }

    private ClassMapperLite() {
    }

    @JvmStatic
    public static final String mapClass(String str) {
        Intrinsics.checkNotNullParameter(str, "classId");
        String str2 = map.get(str);
        if (str2 != null) {
            return str2;
        }
        return 'L' + StringsKt.replace$default(str, '.', (char) Typography.dollar, false, 4, (Object) null) + ';';
    }
}
