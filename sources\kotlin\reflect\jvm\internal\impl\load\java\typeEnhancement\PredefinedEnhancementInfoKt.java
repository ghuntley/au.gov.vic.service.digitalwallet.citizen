package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import java.util.Map;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancementBuilder;
import kotlin.reflect.jvm.internal.impl.load.kotlin.SignatureBuildingComponents;

public final class PredefinedEnhancementInfoKt {
    private static final JavaTypeQualifiers NOT_NULLABLE = new JavaTypeQualifiers(NullabilityQualifier.NOT_NULL, null, true, false, 8, null);
    private static final JavaTypeQualifiers NOT_PLATFORM = new JavaTypeQualifiers(NullabilityQualifier.NOT_NULL, null, false, false, 8, null);
    private static final JavaTypeQualifiers NULLABLE = new JavaTypeQualifiers(NullabilityQualifier.NULLABLE, null, false, false, 8, null);
    private static final Map<String, PredefinedFunctionEnhancementInfo> PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE;

    static {
        SignatureBuildingComponents signatureBuildingComponents = SignatureBuildingComponents.INSTANCE;
        String javaLang = signatureBuildingComponents.javaLang("Object");
        String javaFunction = signatureBuildingComponents.javaFunction("Predicate");
        String javaFunction2 = signatureBuildingComponents.javaFunction("Function");
        String javaFunction3 = signatureBuildingComponents.javaFunction("Consumer");
        String javaFunction4 = signatureBuildingComponents.javaFunction("BiFunction");
        String javaFunction5 = signatureBuildingComponents.javaFunction("BiConsumer");
        String javaFunction6 = signatureBuildingComponents.javaFunction("UnaryOperator");
        String javaUtil = signatureBuildingComponents.javaUtil("stream/Stream");
        String javaUtil2 = signatureBuildingComponents.javaUtil("Optional");
        SignatureEnhancementBuilder signatureEnhancementBuilder = new SignatureEnhancementBuilder();
        new SignatureEnhancementBuilder.ClassEnhancementBuilder(signatureEnhancementBuilder, signatureBuildingComponents.javaUtil("Iterator")).function("forEachRemaining", new PredefinedEnhancementInfoKt$$special$$inlined$enhancement$lambda$1(signatureBuildingComponents, javaFunction3, javaFunction, javaUtil, javaFunction6, javaFunction5, javaLang, javaFunction4, javaFunction2, javaUtil2));
        new SignatureEnhancementBuilder.ClassEnhancementBuilder(signatureEnhancementBuilder, signatureBuildingComponents.javaLang("Iterable")).function("spliterator", new PredefinedEnhancementInfoKt$$special$$inlined$enhancement$lambda$2(signatureBuildingComponents, javaFunction3, javaFunction, javaUtil, javaFunction6, javaFunction5, javaLang, javaFunction4, javaFunction2, javaUtil2));
        SignatureEnhancementBuilder.ClassEnhancementBuilder classEnhancementBuilder = new SignatureEnhancementBuilder.ClassEnhancementBuilder(signatureEnhancementBuilder, signatureBuildingComponents.javaUtil("Collection"));
        classEnhancementBuilder.function("removeIf", new PredefinedEnhancementInfoKt$$special$$inlined$enhancement$lambda$3(signatureBuildingComponents, javaFunction3, javaFunction, javaUtil, javaFunction6, javaFunction5, javaLang, javaFunction4, javaFunction2, javaUtil2));
        classEnhancementBuilder.function("stream", new PredefinedEnhancementInfoKt$$special$$inlined$enhancement$lambda$4(signatureBuildingComponents, javaFunction3, javaFunction, javaUtil, javaFunction6, javaFunction5, javaLang, javaFunction4, javaFunction2, javaUtil2));
        classEnhancementBuilder.function("parallelStream", new PredefinedEnhancementInfoKt$$special$$inlined$enhancement$lambda$5(signatureBuildingComponents, javaFunction3, javaFunction, javaUtil, javaFunction6, javaFunction5, javaLang, javaFunction4, javaFunction2, javaUtil2));
        new SignatureEnhancementBuilder.ClassEnhancementBuilder(signatureEnhancementBuilder, signatureBuildingComponents.javaUtil("List")).function("replaceAll", new PredefinedEnhancementInfoKt$$special$$inlined$enhancement$lambda$6(signatureBuildingComponents, javaFunction3, javaFunction, javaUtil, javaFunction6, javaFunction5, javaLang, javaFunction4, javaFunction2, javaUtil2));
        SignatureEnhancementBuilder.ClassEnhancementBuilder classEnhancementBuilder2 = new SignatureEnhancementBuilder.ClassEnhancementBuilder(signatureEnhancementBuilder, signatureBuildingComponents.javaUtil("Map"));
        classEnhancementBuilder2.function("forEach", new PredefinedEnhancementInfoKt$$special$$inlined$enhancement$lambda$7(signatureBuildingComponents, javaFunction3, javaFunction, javaUtil, javaFunction6, javaFunction5, javaLang, javaFunction4, javaFunction2, javaUtil2));
        classEnhancementBuilder2.function("putIfAbsent", new PredefinedEnhancementInfoKt$$special$$inlined$enhancement$lambda$8(signatureBuildingComponents, javaFunction3, javaFunction, javaUtil, javaFunction6, javaFunction5, javaLang, javaFunction4, javaFunction2, javaUtil2));
        classEnhancementBuilder2.function("replace", new PredefinedEnhancementInfoKt$$special$$inlined$enhancement$lambda$9(signatureBuildingComponents, javaFunction3, javaFunction, javaUtil, javaFunction6, javaFunction5, javaLang, javaFunction4, javaFunction2, javaUtil2));
        classEnhancementBuilder2.function("replace", new PredefinedEnhancementInfoKt$$special$$inlined$enhancement$lambda$10(signatureBuildingComponents, javaFunction3, javaFunction, javaUtil, javaFunction6, javaFunction5, javaLang, javaFunction4, javaFunction2, javaUtil2));
        classEnhancementBuilder2.function("replaceAll", new PredefinedEnhancementInfoKt$$special$$inlined$enhancement$lambda$11(signatureBuildingComponents, javaFunction3, javaFunction, javaUtil, javaFunction6, javaFunction5, javaLang, javaFunction4, javaFunction2, javaUtil2));
        classEnhancementBuilder2.function("compute", new PredefinedEnhancementInfoKt$$special$$inlined$enhancement$lambda$12(signatureBuildingComponents, javaFunction3, javaFunction, javaUtil, javaFunction6, javaFunction5, javaLang, javaFunction4, javaFunction2, javaUtil2));
        classEnhancementBuilder2.function("computeIfAbsent", new PredefinedEnhancementInfoKt$$special$$inlined$enhancement$lambda$13(signatureBuildingComponents, javaFunction3, javaFunction, javaUtil, javaFunction6, javaFunction5, javaLang, javaFunction4, javaFunction2, javaUtil2));
        classEnhancementBuilder2.function("computeIfPresent", new PredefinedEnhancementInfoKt$$special$$inlined$enhancement$lambda$14(signatureBuildingComponents, javaFunction3, javaFunction, javaUtil, javaFunction6, javaFunction5, javaLang, javaFunction4, javaFunction2, javaUtil2));
        classEnhancementBuilder2.function("merge", new PredefinedEnhancementInfoKt$$special$$inlined$enhancement$lambda$15(signatureBuildingComponents, javaFunction3, javaFunction, javaUtil, javaFunction6, javaFunction5, javaLang, javaFunction4, javaFunction2, javaUtil2));
        SignatureEnhancementBuilder.ClassEnhancementBuilder classEnhancementBuilder3 = new SignatureEnhancementBuilder.ClassEnhancementBuilder(signatureEnhancementBuilder, javaUtil2);
        classEnhancementBuilder3.function("empty", new PredefinedEnhancementInfoKt$$special$$inlined$enhancement$lambda$16(signatureBuildingComponents, javaFunction3, javaFunction, javaUtil, javaFunction6, javaFunction5, javaLang, javaFunction4, javaFunction2, javaUtil2));
        classEnhancementBuilder3.function("of", new PredefinedEnhancementInfoKt$$special$$inlined$enhancement$lambda$17(signatureBuildingComponents, javaFunction3, javaFunction, javaUtil, javaFunction6, javaFunction5, javaLang, javaFunction4, javaFunction2, javaUtil2));
        classEnhancementBuilder3.function("ofNullable", new PredefinedEnhancementInfoKt$$special$$inlined$enhancement$lambda$18(signatureBuildingComponents, javaFunction3, javaFunction, javaUtil, javaFunction6, javaFunction5, javaLang, javaFunction4, javaFunction2, javaUtil2));
        classEnhancementBuilder3.function("get", new PredefinedEnhancementInfoKt$$special$$inlined$enhancement$lambda$19(signatureBuildingComponents, javaFunction3, javaFunction, javaUtil, javaFunction6, javaFunction5, javaLang, javaFunction4, javaFunction2, javaUtil2));
        classEnhancementBuilder3.function("ifPresent", new PredefinedEnhancementInfoKt$$special$$inlined$enhancement$lambda$20(signatureBuildingComponents, javaFunction3, javaFunction, javaUtil, javaFunction6, javaFunction5, javaLang, javaFunction4, javaFunction2, javaUtil2));
        new SignatureEnhancementBuilder.ClassEnhancementBuilder(signatureEnhancementBuilder, signatureBuildingComponents.javaLang("ref/Reference")).function("get", new PredefinedEnhancementInfoKt$$special$$inlined$enhancement$lambda$21(signatureBuildingComponents, javaFunction3, javaFunction, javaUtil, javaFunction6, javaFunction5, javaLang, javaFunction4, javaFunction2, javaUtil2));
        new SignatureEnhancementBuilder.ClassEnhancementBuilder(signatureEnhancementBuilder, javaFunction).function("test", new PredefinedEnhancementInfoKt$$special$$inlined$enhancement$lambda$22(signatureBuildingComponents, javaFunction3, javaFunction, javaUtil, javaFunction6, javaFunction5, javaLang, javaFunction4, javaFunction2, javaUtil2));
        new SignatureEnhancementBuilder.ClassEnhancementBuilder(signatureEnhancementBuilder, signatureBuildingComponents.javaFunction("BiPredicate")).function("test", new PredefinedEnhancementInfoKt$$special$$inlined$enhancement$lambda$23(signatureBuildingComponents, javaFunction3, javaFunction, javaUtil, javaFunction6, javaFunction5, javaLang, javaFunction4, javaFunction2, javaUtil2));
        new SignatureEnhancementBuilder.ClassEnhancementBuilder(signatureEnhancementBuilder, javaFunction3).function("accept", new PredefinedEnhancementInfoKt$$special$$inlined$enhancement$lambda$24(signatureBuildingComponents, javaFunction3, javaFunction, javaUtil, javaFunction6, javaFunction5, javaLang, javaFunction4, javaFunction2, javaUtil2));
        new SignatureEnhancementBuilder.ClassEnhancementBuilder(signatureEnhancementBuilder, javaFunction5).function("accept", new PredefinedEnhancementInfoKt$$special$$inlined$enhancement$lambda$25(signatureBuildingComponents, javaFunction3, javaFunction, javaUtil, javaFunction6, javaFunction5, javaLang, javaFunction4, javaFunction2, javaUtil2));
        new SignatureEnhancementBuilder.ClassEnhancementBuilder(signatureEnhancementBuilder, javaFunction2).function("apply", new PredefinedEnhancementInfoKt$$special$$inlined$enhancement$lambda$26(signatureBuildingComponents, javaFunction3, javaFunction, javaUtil, javaFunction6, javaFunction5, javaLang, javaFunction4, javaFunction2, javaUtil2));
        new SignatureEnhancementBuilder.ClassEnhancementBuilder(signatureEnhancementBuilder, javaFunction4).function("apply", new PredefinedEnhancementInfoKt$$special$$inlined$enhancement$lambda$27(signatureBuildingComponents, javaFunction3, javaFunction, javaUtil, javaFunction6, javaFunction5, javaLang, javaFunction4, javaFunction2, javaUtil2));
        new SignatureEnhancementBuilder.ClassEnhancementBuilder(signatureEnhancementBuilder, signatureBuildingComponents.javaFunction("Supplier")).function("get", new PredefinedEnhancementInfoKt$$special$$inlined$enhancement$lambda$28(signatureBuildingComponents, javaFunction3, javaFunction, javaUtil, javaFunction6, javaFunction5, javaLang, javaFunction4, javaFunction2, javaUtil2));
        PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE = signatureEnhancementBuilder.build();
    }

    public static final Map<String, PredefinedFunctionEnhancementInfo> getPREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE() {
        return PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE;
    }
}
