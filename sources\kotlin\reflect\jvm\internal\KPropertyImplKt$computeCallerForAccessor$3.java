package kotlin.reflect.jvm.internal;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.KPropertyImpl;
import kotlin.reflect.jvm.internal.calls.CallerImpl;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0002\b\u0004"}, d2 = {"computeFieldCaller", "Lkotlin/reflect/jvm/internal/calls/CallerImpl;", "Ljava/lang/reflect/Field;", "field", "invoke"}, k = 3, mv = {1, 4, 0})
/* compiled from: KPropertyImpl.kt */
public final class KPropertyImplKt$computeCallerForAccessor$3 extends Lambda implements Function1<Field, CallerImpl<? extends Field>> {
    final /* synthetic */ boolean $isGetter;
    final /* synthetic */ KPropertyImplKt$computeCallerForAccessor$1 $isJvmStaticProperty$1;
    final /* synthetic */ KPropertyImplKt$computeCallerForAccessor$2 $isNotNullProperty$2;
    final /* synthetic */ KPropertyImpl.Accessor $this_computeCallerForAccessor;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    KPropertyImplKt$computeCallerForAccessor$3(KPropertyImpl.Accessor accessor, boolean z, KPropertyImplKt$computeCallerForAccessor$2 kPropertyImplKt$computeCallerForAccessor$2, KPropertyImplKt$computeCallerForAccessor$1 kPropertyImplKt$computeCallerForAccessor$1) {
        super(1);
        this.$this_computeCallerForAccessor = accessor;
        this.$isGetter = z;
        this.$isNotNullProperty$2 = kPropertyImplKt$computeCallerForAccessor$2;
        this.$isJvmStaticProperty$1 = kPropertyImplKt$computeCallerForAccessor$1;
    }

    public final CallerImpl<Field> invoke(Field field) {
        CallerImpl.FieldSetter.Instance instance;
        CallerImpl.FieldGetter.Instance instance2;
        CallerImpl.FieldSetter.JvmStaticInObject jvmStaticInObject;
        CallerImpl.FieldGetter.JvmStaticInObject jvmStaticInObject2;
        Intrinsics.checkNotNullParameter(field, "field");
        if ((KPropertyImplKt.isJvmFieldPropertyInCompanionObject(this.$this_computeCallerForAccessor.getProperty().getDescriptor())) || !Modifier.isStatic(field.getModifiers())) {
            if (this.$isGetter) {
                if (this.$this_computeCallerForAccessor.isBound()) {
                    instance2 = new CallerImpl.FieldGetter.BoundInstance(field, KPropertyImplKt.getBoundReceiver(this.$this_computeCallerForAccessor));
                } else {
                    instance2 = new CallerImpl.FieldGetter.Instance(field);
                }
                return instance2;
            }
            if (this.$this_computeCallerForAccessor.isBound()) {
                instance = new CallerImpl.FieldSetter.BoundInstance(field, this.$isNotNullProperty$2.invoke(), KPropertyImplKt.getBoundReceiver(this.$this_computeCallerForAccessor));
            } else {
                instance = new CallerImpl.FieldSetter.Instance(field, this.$isNotNullProperty$2.invoke());
            }
            return instance;
        } else if (this.$isJvmStaticProperty$1.invoke()) {
            if (this.$isGetter) {
                if (this.$this_computeCallerForAccessor.isBound()) {
                    jvmStaticInObject2 = new CallerImpl.FieldGetter.BoundJvmStaticInObject(field);
                } else {
                    jvmStaticInObject2 = new CallerImpl.FieldGetter.JvmStaticInObject(field);
                }
                return jvmStaticInObject2;
            }
            if (this.$this_computeCallerForAccessor.isBound()) {
                jvmStaticInObject = new CallerImpl.FieldSetter.BoundJvmStaticInObject(field, this.$isNotNullProperty$2.invoke());
            } else {
                jvmStaticInObject = new CallerImpl.FieldSetter.JvmStaticInObject(field, this.$isNotNullProperty$2.invoke());
            }
            return jvmStaticInObject;
        } else if (this.$isGetter) {
            return new CallerImpl.FieldGetter.Static(field);
        } else {
            return new CallerImpl.FieldSetter.Static(field, this.$isNotNullProperty$2.invoke());
        }
    }
}
