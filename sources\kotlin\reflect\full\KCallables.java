package kotlin.reflect.full;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SpreadBuilder;
import kotlin.reflect.KCallable;
import kotlin.reflect.KFunction;
import kotlin.reflect.KParameter;
import kotlin.reflect.jvm.internal.KotlinReflectionInternalError;
import kotlin.reflect.jvm.internal.UtilKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\u001a9\u0010\u000f\u001a\u0002H\u0010\"\u0004\b\u0000\u0010\u0010*\b\u0012\u0004\u0012\u0002H\u00100\u00022\u0016\u0010\u0011\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00130\u0012\"\u0004\u0018\u00010\u0013H@ø\u0001\u0000¢\u0006\u0002\u0010\u0014\u001a7\u0010\u0015\u001a\u0002H\u0010\"\u0004\b\u0000\u0010\u0010*\b\u0012\u0004\u0012\u0002H\u00100\u00022\u0014\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u0016H@ø\u0001\u0000¢\u0006\u0002\u0010\u0017\u001a\u001a\u0010\u0018\u001a\u0004\u0018\u00010\u0001*\u0006\u0012\u0002\b\u00030\u00022\u0006\u0010\u0019\u001a\u00020\u001aH\u0007\"$\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u0006\u0012\u0002\b\u00030\u00028FX\u0004¢\u0006\f\u0012\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"$\u0010\u0007\u001a\u0004\u0018\u00010\u0001*\u0006\u0012\u0002\b\u00030\u00028FX\u0004¢\u0006\f\u0012\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006\"(\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00010\u000b*\u0006\u0012\u0002\b\u00030\u00028FX\u0004¢\u0006\f\u0012\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u000e\u0002\u0004\n\u0002\b\u0019¨\u0006\u001b"}, d2 = {"extensionReceiverParameter", "Lkotlin/reflect/KParameter;", "Lkotlin/reflect/KCallable;", "getExtensionReceiverParameter$annotations", "(Lkotlin/reflect/KCallable;)V", "getExtensionReceiverParameter", "(Lkotlin/reflect/KCallable;)Lkotlin/reflect/KParameter;", "instanceParameter", "getInstanceParameter$annotations", "getInstanceParameter", "valueParameters", "", "getValueParameters$annotations", "getValueParameters", "(Lkotlin/reflect/KCallable;)Ljava/util/List;", "callSuspend", "R", "args", "", "", "(Lkotlin/reflect/KCallable;[Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "callSuspendBy", "", "(Lkotlin/reflect/KCallable;Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "findParameterByName", "name", "", "kotlin-reflection"}, k = 2, mv = {1, 4, 0})
/* compiled from: KCallables.kt */
public final class KCallables {
    public static /* synthetic */ void getExtensionReceiverParameter$annotations(KCallable kCallable) {
    }

    public static /* synthetic */ void getInstanceParameter$annotations(KCallable kCallable) {
    }

    public static /* synthetic */ void getValueParameters$annotations(KCallable kCallable) {
    }

    public static final KParameter getInstanceParameter(KCallable<?> kCallable) {
        Intrinsics.checkNotNullParameter(kCallable, "$this$instanceParameter");
        Iterator<T> it = kCallable.getParameters().iterator();
        T t = null;
        boolean z = false;
        T t2 = null;
        while (true) {
            if (it.hasNext()) {
                T next = it.next();
                if (next.getKind() == KParameter.Kind.INSTANCE) {
                    if (z) {
                        break;
                    }
                    t2 = next;
                    z = true;
                }
            } else if (z) {
                t = t2;
            }
        }
        return t;
    }

    public static final KParameter getExtensionReceiverParameter(KCallable<?> kCallable) {
        Intrinsics.checkNotNullParameter(kCallable, "$this$extensionReceiverParameter");
        Iterator<T> it = kCallable.getParameters().iterator();
        T t = null;
        boolean z = false;
        T t2 = null;
        while (true) {
            if (it.hasNext()) {
                T next = it.next();
                if (next.getKind() == KParameter.Kind.EXTENSION_RECEIVER) {
                    if (z) {
                        break;
                    }
                    t2 = next;
                    z = true;
                }
            } else if (z) {
                t = t2;
            }
        }
        return t;
    }

    public static final List<KParameter> getValueParameters(KCallable<?> kCallable) {
        Intrinsics.checkNotNullParameter(kCallable, "$this$valueParameters");
        ArrayList arrayList = new ArrayList();
        for (T t : kCallable.getParameters()) {
            if (t.getKind() == KParameter.Kind.VALUE) {
                arrayList.add(t);
            }
        }
        return arrayList;
    }

    public static final KParameter findParameterByName(KCallable<?> kCallable, String str) {
        Intrinsics.checkNotNullParameter(kCallable, "$this$findParameterByName");
        Intrinsics.checkNotNullParameter(str, "name");
        Iterator<T> it = kCallable.getParameters().iterator();
        T t = null;
        boolean z = false;
        T t2 = null;
        while (true) {
            if (it.hasNext()) {
                T next = it.next();
                if (Intrinsics.areEqual(next.getName(), str)) {
                    if (z) {
                        break;
                    }
                    z = true;
                    t2 = next;
                }
            } else if (z) {
                t = t2;
            }
        }
        return t;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x003a  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    public static final <R> Object callSuspend(KCallable<? extends R> kCallable, Object[] objArr, Continuation<? super R> continuation) {
        KCallables$callSuspend$1 kCallables$callSuspend$1;
        int i;
        if (continuation instanceof KCallables$callSuspend$1) {
            kCallables$callSuspend$1 = (KCallables$callSuspend$1) continuation;
            if ((kCallables$callSuspend$1.label & Integer.MIN_VALUE) != 0) {
                kCallables$callSuspend$1.label -= Integer.MIN_VALUE;
                Object obj = kCallables$callSuspend$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = kCallables$callSuspend$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    if (!kCallable.isSuspend()) {
                        return kCallable.call(Arrays.copyOf(objArr, objArr.length));
                    }
                    if (kCallable instanceof KFunction) {
                        kCallables$callSuspend$1.L$0 = kCallable;
                        kCallables$callSuspend$1.L$1 = objArr;
                        kCallables$callSuspend$1.label = 1;
                        KCallables$callSuspend$1 kCallables$callSuspend$12 = kCallables$callSuspend$1;
                        SpreadBuilder spreadBuilder = new SpreadBuilder(2);
                        spreadBuilder.addSpread(objArr);
                        spreadBuilder.add(kCallables$callSuspend$12);
                        obj = kCallable.call(spreadBuilder.toArray(new Object[spreadBuilder.size()]));
                        if (obj == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                            DebugProbesKt.probeCoroutineSuspended(kCallables$callSuspend$12);
                        }
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        throw new IllegalArgumentException("Cannot callSuspend on a property " + kCallable + ": suspend properties are not supported yet");
                    }
                } else if (i == 1) {
                    Object[] objArr2 = (Object[]) kCallables$callSuspend$1.L$1;
                    kCallable = (KCallable) kCallables$callSuspend$1.L$0;
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                return (Intrinsics.areEqual(kCallable.getReturnType().getClassifier(), Reflection.getOrCreateKotlinClass(Unit.class)) || kCallable.getReturnType().isMarkedNullable()) ? obj : Unit.INSTANCE;
            }
        }
        kCallables$callSuspend$1 = new KCallables$callSuspend$1(continuation);
        Object obj2 = kCallables$callSuspend$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = kCallables$callSuspend$1.label;
        if (i != 0) {
        }
        if (Intrinsics.areEqual(kCallable.getReturnType().getClassifier(), Reflection.getOrCreateKotlinClass(Unit.class))) {
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x003e  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    public static final <R> Object callSuspendBy(KCallable<? extends R> kCallable, Map<KParameter, ? extends Object> map, Continuation<? super R> continuation) {
        KCallables$callSuspendBy$1 kCallables$callSuspendBy$1;
        int i;
        if (continuation instanceof KCallables$callSuspendBy$1) {
            kCallables$callSuspendBy$1 = (KCallables$callSuspendBy$1) continuation;
            if ((kCallables$callSuspendBy$1.label & Integer.MIN_VALUE) != 0) {
                kCallables$callSuspendBy$1.label -= Integer.MIN_VALUE;
                Object obj = kCallables$callSuspendBy$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = kCallables$callSuspendBy$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    if (!kCallable.isSuspend()) {
                        return kCallable.callBy(map);
                    }
                    if (kCallable instanceof KFunction) {
                        Ref.ObjectRef objectRef = new Ref.ObjectRef();
                        T t = (T) UtilKt.asKCallableImpl(kCallable);
                        if (t != null) {
                            objectRef.element = t;
                            kCallables$callSuspendBy$1.L$0 = kCallable;
                            kCallables$callSuspendBy$1.L$1 = map;
                            kCallables$callSuspendBy$1.L$2 = objectRef;
                            kCallables$callSuspendBy$1.label = 1;
                            KCallables$callSuspendBy$1 kCallables$callSuspendBy$12 = kCallables$callSuspendBy$1;
                            obj = objectRef.element.callDefaultMethod$kotlin_reflection(map, kCallables$callSuspendBy$12);
                            if (obj == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                                DebugProbesKt.probeCoroutineSuspended(kCallables$callSuspendBy$12);
                            }
                            if (obj == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        } else {
                            throw new KotlinReflectionInternalError("This callable does not support a default call: " + kCallable);
                        }
                    } else {
                        throw new IllegalArgumentException("Cannot callSuspendBy on a property " + kCallable + ": suspend properties are not supported yet");
                    }
                } else if (i == 1) {
                    Ref.ObjectRef objectRef2 = (Ref.ObjectRef) kCallables$callSuspendBy$1.L$2;
                    Map map2 = (Map) kCallables$callSuspendBy$1.L$1;
                    kCallable = (KCallable) kCallables$callSuspendBy$1.L$0;
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                return (Intrinsics.areEqual(kCallable.getReturnType().getClassifier(), Reflection.getOrCreateKotlinClass(Unit.class)) || kCallable.getReturnType().isMarkedNullable()) ? obj : Unit.INSTANCE;
            }
        }
        kCallables$callSuspendBy$1 = new KCallables$callSuspendBy$1(continuation);
        Object obj2 = kCallables$callSuspendBy$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = kCallables$callSuspendBy$1.label;
        if (i != 0) {
        }
        if (Intrinsics.areEqual(kCallable.getReturnType().getClassifier(), Reflection.getOrCreateKotlinClass(Unit.class))) {
        }
    }
}
