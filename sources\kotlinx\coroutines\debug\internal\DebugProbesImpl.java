package kotlinx.coroutines.debug.internal;

import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlin.KotlinVersion;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobSupport;
import kotlinx.coroutines.internal.ScopeCoroutine;
import kotlinx.coroutines.internal.StackTraceRecoveryKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000º\u0001\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0003\n\u0002\b\n\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010#\n\u0000\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0010\u0000\bÀ\u0002\u0018\u00002\u00020|:\u0001zB\t\b\u0002¢\u0006\u0004\b\u0001\u0010\u0002J3\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\u0004\b\u0000\u0010\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\r\u0010\u000eJ\u0013\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0013\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0013\u0010\u000eJ\u0013\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u000f¢\u0006\u0004\b\u0015\u0010\u0012J+\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00170\u000f2\u0006\u0010\u0016\u001a\u00020\u00102\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u000fH\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ?\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020 0\u001f2\u0006\u0010\u001c\u001a\u00020\u001b2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00170\u001d2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u000fH\u0002¢\u0006\u0004\b!\u0010\"J3\u0010$\u001a\u00020\u001b2\u0006\u0010#\u001a\u00020\u001b2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00170\u001d2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u000fH\u0002¢\u0006\u0004\b$\u0010%J\u001d\u0010'\u001a\u0010\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\f\u0018\u00010&H\u0002¢\u0006\u0004\b'\u0010(J\u0015\u0010,\u001a\u00020+2\u0006\u0010*\u001a\u00020)¢\u0006\u0004\b,\u0010-J\r\u0010.\u001a\u00020\f¢\u0006\u0004\b.\u0010\u0002J%\u00100\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\n2\f\u0010/\u001a\b\u0012\u0004\u0012\u00020\u00170\u000fH\u0002¢\u0006\u0004\b0\u00101J\u001b\u00104\u001a\u00020\f2\n\u00103\u001a\u0006\u0012\u0002\b\u000302H\u0002¢\u0006\u0004\b4\u00105J)\u00108\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\u0004\b\u0000\u0010\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0000¢\u0006\u0004\b6\u00107J\u001b\u0010;\u001a\u00020\f2\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\u0004H\u0000¢\u0006\u0004\b9\u0010:J\u001b\u0010=\u001a\u00020\f2\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\u0004H\u0000¢\u0006\u0004\b<\u0010:J'\u0010@\u001a\b\u0012\u0004\u0012\u00020\u00170\u000f\"\b\b\u0000\u0010\u0003*\u00020>2\u0006\u0010?\u001a\u00028\u0000H\u0002¢\u0006\u0004\b@\u0010AJ\r\u0010B\u001a\u00020\f¢\u0006\u0004\bB\u0010\u0002J\u001f\u0010D\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010C\u001a\u00020+H\u0002¢\u0006\u0004\bD\u0010EJ#\u0010F\u001a\u00020\f2\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\u00042\u0006\u0010C\u001a\u00020+H\u0002¢\u0006\u0004\bF\u0010GJ/\u0010F\u001a\u00020\f2\n\u00103\u001a\u0006\u0012\u0002\b\u0003022\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\u00042\u0006\u0010C\u001a\u00020+H\u0002¢\u0006\u0004\bF\u0010HJ;\u0010O\u001a\u00020\f*\u00020)2\u0012\u0010J\u001a\u000e\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020\u00100I2\n\u0010M\u001a\u00060Kj\u0002`L2\u0006\u0010N\u001a\u00020+H\u0002¢\u0006\u0004\bO\u0010PJ\u001d\u00103\u001a\b\u0012\u0002\b\u0003\u0018\u000102*\u0006\u0012\u0002\b\u00030\u0004H\u0002¢\u0006\u0004\b3\u0010QJ\u001a\u00103\u001a\b\u0012\u0002\b\u0003\u0018\u000102*\u00020\u0006H\u0010¢\u0006\u0004\b3\u0010RJ\u0016\u0010S\u001a\u0004\u0018\u00010\u0006*\u00020\u0006H\u0010¢\u0006\u0004\bS\u0010TR\u0016\u0010U\u001a\u00020+8\u0002@\u0002XT¢\u0006\u0006\n\u0004\bU\u0010VR\"\u0010X\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00100W8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bX\u0010YRJ\u0010]\u001a6\u0012\u0014\u0012\u0012\u0012\u0002\b\u0003 [*\b\u0012\u0002\b\u0003\u0018\u00010202 [*\u001a\u0012\u0014\u0012\u0012\u0012\u0002\b\u0003 [*\b\u0012\u0002\b\u0003\u0018\u00010202\u0018\u00010\\0Z8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b]\u0010^R\u0016\u0010`\u001a\u00020_8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b`\u0010aR\u0016\u0010c\u001a\u00020b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bc\u0010dR$\u0010e\u001a\u0010\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\f\u0018\u00010&8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\be\u0010fR\"\u0010g\u001a\u00020 8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\bg\u0010h\u001a\u0004\bi\u0010j\"\u0004\bk\u0010lR\u0016\u0010m\u001a\u00020\u001b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bm\u0010nR\u0016\u0010p\u001a\u00020 8@@\u0000X\u0004¢\u0006\u0006\u001a\u0004\bo\u0010jR\"\u0010q\u001a\u00020 8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\bq\u0010h\u001a\u0004\br\u0010j\"\u0004\bs\u0010lR \u0010w\u001a\u00020+*\u00020)8B@\u0002X\u0004¢\u0006\f\u0012\u0004\bu\u0010v\u001a\u0004\bt\u0010-R\u001a\u0010x\u001a\u00020 *\u00020\u00178B@\u0002X\u0004¢\u0006\u0006\u001a\u0004\bx\u0010y¨\u0006{"}, d2 = {"Lkotlinx/coroutines/debug/internal/DebugProbesImpl;", "<init>", "()V", "T", "Lkotlin/coroutines/Continuation;", "completion", "Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "frame", "createOwner", "(Lkotlin/coroutines/Continuation;Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;)Lkotlin/coroutines/Continuation;", "Ljava/io/PrintStream;", "out", "", "dumpCoroutines", "(Ljava/io/PrintStream;)V", "", "Lkotlinx/coroutines/debug/internal/DebugCoroutineInfo;", "dumpCoroutinesInfo", "()Ljava/util/List;", "dumpCoroutinesSynchronized", "Lkotlinx/coroutines/debug/internal/DebuggerInfo;", "dumpDebuggerInfo", "info", "Ljava/lang/StackTraceElement;", "coroutineTrace", "enhanceStackTraceWithThreadDump", "(Lkotlinx/coroutines/debug/internal/DebugCoroutineInfo;Ljava/util/List;)Ljava/util/List;", "", "indexOfResumeWith", "", "actualTrace", "Lkotlin/Pair;", "", "findContinuationStartIndex", "(I[Ljava/lang/StackTraceElement;Ljava/util/List;)Lkotlin/Pair;", "frameIndex", "findIndexOfFrame", "(I[Ljava/lang/StackTraceElement;Ljava/util/List;)I", "Lkotlin/Function1;", "getDynamicAttach", "()Lkotlin/jvm/functions/Function1;", "Lkotlinx/coroutines/Job;", "job", "", "hierarchyToString", "(Lkotlinx/coroutines/Job;)Ljava/lang/String;", "install", "frames", "printStackTrace", "(Ljava/io/PrintStream;Ljava/util/List;)V", "Lkotlinx/coroutines/debug/internal/DebugProbesImpl$CoroutineOwner;", "owner", "probeCoroutineCompleted", "(Lkotlinx/coroutines/debug/internal/DebugProbesImpl$CoroutineOwner;)V", "probeCoroutineCreated$kotlinx_coroutines_core", "(Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;", "probeCoroutineCreated", "probeCoroutineResumed$kotlinx_coroutines_core", "(Lkotlin/coroutines/Continuation;)V", "probeCoroutineResumed", "probeCoroutineSuspended$kotlinx_coroutines_core", "probeCoroutineSuspended", "", "throwable", "sanitizeStackTrace", "(Ljava/lang/Throwable;)Ljava/util/List;", "uninstall", "state", "updateRunningState", "(Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;Ljava/lang/String;)V", "updateState", "(Lkotlin/coroutines/Continuation;Ljava/lang/String;)V", "(Lkotlinx/coroutines/debug/internal/DebugProbesImpl$CoroutineOwner;Lkotlin/coroutines/Continuation;Ljava/lang/String;)V", "", "map", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "builder", "indent", "build", "(Lkotlinx/coroutines/Job;Ljava/util/Map;Ljava/lang/StringBuilder;Ljava/lang/String;)V", "(Lkotlin/coroutines/Continuation;)Lkotlinx/coroutines/debug/internal/DebugProbesImpl$CoroutineOwner;", "(Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;)Lkotlinx/coroutines/debug/internal/DebugProbesImpl$CoroutineOwner;", "realCaller", "(Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;)Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "ARTIFICIAL_FRAME_MESSAGE", "Ljava/lang/String;", "Ljava/util/concurrent/ConcurrentHashMap;", "callerInfoCache", "Ljava/util/concurrent/ConcurrentHashMap;", "", "kotlin.jvm.PlatformType", "", "capturedCoroutines", "Ljava/util/Set;", "Ljava/util/concurrent/locks/ReentrantReadWriteLock;", "coroutineStateLock", "Ljava/util/concurrent/locks/ReentrantReadWriteLock;", "Ljava/text/SimpleDateFormat;", "dateFormat", "Ljava/text/SimpleDateFormat;", "dynamicAttach", "Lkotlin/jvm/functions/Function1;", "enableCreationStackTraces", "Z", "getEnableCreationStackTraces", "()Z", "setEnableCreationStackTraces", "(Z)V", "installations", "I", "isInstalled$kotlinx_coroutines_core", "isInstalled", "sanitizeStackTraces", "getSanitizeStackTraces", "setSanitizeStackTraces", "getDebugString", "debugString$annotations", "(Lkotlinx/coroutines/Job;)V", "debugString", "isInternalMethod", "(Ljava/lang/StackTraceElement;)Z", "CoroutineOwner", "kotlinx-coroutines-core", ""}, k = 1, mv = {1, 1, 16})
/* compiled from: DebugProbesImpl.kt */
public final class DebugProbesImpl {
    private static final String ARTIFICIAL_FRAME_MESSAGE = "Coroutine creation stacktrace";
    public static final DebugProbesImpl INSTANCE;
    private static final ConcurrentHashMap<CoroutineStackFrame, DebugCoroutineInfo> callerInfoCache = new ConcurrentHashMap<>();
    private static final Set<CoroutineOwner<?>> capturedCoroutines = Collections.newSetFromMap(new ConcurrentHashMap());
    private static final ReentrantReadWriteLock coroutineStateLock = new ReentrantReadWriteLock();
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    static final /* synthetic */ DebugProbesImplSequenceNumberRefVolatile debugProbesImplSequenceNumberRefVolatile = new DebugProbesImplSequenceNumberRefVolatile(0);
    private static final Function1<Boolean, Unit> dynamicAttach;
    private static boolean enableCreationStackTraces = true;
    private static volatile int installations;
    private static boolean sanitizeStackTraces = true;
    static final /* synthetic */ AtomicLongFieldUpdater sequenceNumber$FU = AtomicLongFieldUpdater.newUpdater(DebugProbesImplSequenceNumberRefVolatile.class, "sequenceNumber");

    private static /* synthetic */ void debugString$annotations(Job job) {
    }

    static {
        DebugProbesImpl debugProbesImpl = new DebugProbesImpl();
        INSTANCE = debugProbesImpl;
        dynamicAttach = debugProbesImpl.getDynamicAttach();
    }

    private DebugProbesImpl() {
    }

    public final boolean isInstalled$kotlinx_coroutines_core() {
        return installations > 0;
    }

    public final boolean getSanitizeStackTraces() {
        return sanitizeStackTraces;
    }

    public final void setSanitizeStackTraces(boolean z) {
        sanitizeStackTraces = z;
    }

    public final boolean getEnableCreationStackTraces() {
        return enableCreationStackTraces;
    }

    public final void setEnableCreationStackTraces(boolean z) {
        enableCreationStackTraces = z;
    }

    private final Function1<Boolean, Unit> getDynamicAttach() {
        Object obj;
        try {
            Result.Companion companion = Result.Companion;
            DebugProbesImpl debugProbesImpl = this;
            Object newInstance = Class.forName("kotlinx.coroutines.debug.internal.ByteBuddyDynamicAttach").getConstructors()[0].newInstance(new Object[0]);
            if (newInstance != null) {
                obj = Result.m12constructorimpl((Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(newInstance, 1));
                if (Result.m18isFailureimpl(obj)) {
                    obj = null;
                }
                return (Function1) obj;
            }
            throw new TypeCastException("null cannot be cast to non-null type (kotlin.Boolean) -> kotlin.Unit");
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m12constructorimpl(ResultKt.createFailure(th));
        }
    }

    /*  JADX ERROR: StackOverflowError in pass: MarkFinallyVisitor
        java.lang.StackOverflowError
        	at jadx.core.dex.nodes.InsnNode.isSame(InsnNode.java:311)
        	at jadx.core.dex.instructions.ArithNode.isSame(ArithNode.java:89)
        	at jadx.core.dex.visitors.MarkFinallyVisitor.sameInsns(MarkFinallyVisitor.java:451)
        	at jadx.core.dex.visitors.MarkFinallyVisitor.compareBlocks(MarkFinallyVisitor.java:436)
        	at jadx.core.dex.visitors.MarkFinallyVisitor.checkBlocksTree(MarkFinallyVisitor.java:408)
        	at jadx.core.dex.visitors.MarkFinallyVisitor.checkBlocksTree(MarkFinallyVisitor.java:411)
        */
    public final void install() {
        /*
        // Method dump skipped, instructions count: 118
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.debug.internal.DebugProbesImpl.install():void");
    }

    /*  JADX ERROR: StackOverflowError in pass: MarkFinallyVisitor
        java.lang.StackOverflowError
        	at jadx.core.dex.nodes.InsnNode.isSame(InsnNode.java:311)
        	at jadx.core.dex.instructions.ArithNode.isSame(ArithNode.java:89)
        	at jadx.core.dex.visitors.MarkFinallyVisitor.sameInsns(MarkFinallyVisitor.java:451)
        	at jadx.core.dex.visitors.MarkFinallyVisitor.compareBlocks(MarkFinallyVisitor.java:436)
        	at jadx.core.dex.visitors.MarkFinallyVisitor.checkBlocksTree(MarkFinallyVisitor.java:408)
        	at jadx.core.dex.visitors.MarkFinallyVisitor.checkBlocksTree(MarkFinallyVisitor.java:411)
        */
    public final void uninstall() {
        /*
        // Method dump skipped, instructions count: 150
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.debug.internal.DebugProbesImpl.uninstall():void");
    }

    /*  JADX ERROR: StackOverflowError in pass: MarkFinallyVisitor
        java.lang.StackOverflowError
        	at jadx.core.dex.nodes.InsnNode.isSame(InsnNode.java:311)
        	at jadx.core.dex.instructions.ArithNode.isSame(ArithNode.java:89)
        	at jadx.core.dex.visitors.MarkFinallyVisitor.sameInsns(MarkFinallyVisitor.java:451)
        	at jadx.core.dex.visitors.MarkFinallyVisitor.compareBlocks(MarkFinallyVisitor.java:436)
        	at jadx.core.dex.visitors.MarkFinallyVisitor.checkBlocksTree(MarkFinallyVisitor.java:408)
        	at jadx.core.dex.visitors.MarkFinallyVisitor.checkBlocksTree(MarkFinallyVisitor.java:411)
        */
    public final java.lang.String hierarchyToString(kotlinx.coroutines.Job r10) {
        /*
        // Method dump skipped, instructions count: 229
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.debug.internal.DebugProbesImpl.hierarchyToString(kotlinx.coroutines.Job):java.lang.String");
    }

    private final void build(Job job, Map<Job, DebugCoroutineInfo> map, StringBuilder sb, String str) {
        DebugCoroutineInfo debugCoroutineInfo = map.get(job);
        if (debugCoroutineInfo != null) {
            String state = debugCoroutineInfo.getState();
            sb.append(str + getDebugString(job) + ", continuation is " + state + " at line " + ((StackTraceElement) CollectionsKt.firstOrNull((List) debugCoroutineInfo.lastObservedStackTrace())) + '\n');
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str);
            sb2.append("\t");
            str = sb2.toString();
        } else if (!(job instanceof ScopeCoroutine)) {
            sb.append(str + getDebugString(job) + '\n');
            StringBuilder sb3 = new StringBuilder();
            sb3.append(str);
            sb3.append("\t");
            str = sb3.toString();
        }
        for (Job job2 : job.getChildren()) {
            build(job2, map, sb, str);
        }
    }

    private final String getDebugString(Job job) {
        return job instanceof JobSupport ? ((JobSupport) job).toDebugString() : job.toString();
    }

    /*  JADX ERROR: StackOverflowError in pass: MarkFinallyVisitor
        java.lang.StackOverflowError
        	at jadx.core.dex.nodes.InsnNode.isSame(InsnNode.java:311)
        	at jadx.core.dex.instructions.ArithNode.isSame(ArithNode.java:89)
        	at jadx.core.dex.visitors.MarkFinallyVisitor.sameInsns(MarkFinallyVisitor.java:451)
        	at jadx.core.dex.visitors.MarkFinallyVisitor.compareBlocks(MarkFinallyVisitor.java:436)
        	at jadx.core.dex.visitors.MarkFinallyVisitor.checkBlocksTree(MarkFinallyVisitor.java:408)
        	at jadx.core.dex.visitors.MarkFinallyVisitor.checkBlocksTree(MarkFinallyVisitor.java:411)
        */
    public final java.util.List<kotlinx.coroutines.debug.internal.DebugCoroutineInfo> dumpCoroutinesInfo() {
        /*
        // Method dump skipped, instructions count: 113
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.debug.internal.DebugProbesImpl.dumpCoroutinesInfo():java.util.List");
    }

    public final List<DebuggerInfo> dumpDebuggerInfo() {
        List<DebugCoroutineInfo> dumpCoroutinesInfo = dumpCoroutinesInfo();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(dumpCoroutinesInfo, 10));
        Iterator<T> it = dumpCoroutinesInfo.iterator();
        while (it.hasNext()) {
            arrayList.add(new DebuggerInfo(it.next()));
        }
        return arrayList;
    }

    public final void dumpCoroutines(PrintStream printStream) {
        synchronized (printStream) {
            INSTANCE.dumpCoroutinesSynchronized(printStream);
            Unit unit = Unit.INSTANCE;
        }
    }

    /*  JADX ERROR: StackOverflowError in pass: MarkFinallyVisitor
        java.lang.StackOverflowError
        	at jadx.core.dex.nodes.InsnNode.isSame(InsnNode.java:311)
        	at jadx.core.dex.instructions.ArithNode.isSame(ArithNode.java:89)
        	at jadx.core.dex.visitors.MarkFinallyVisitor.sameInsns(MarkFinallyVisitor.java:451)
        	at jadx.core.dex.visitors.MarkFinallyVisitor.compareBlocks(MarkFinallyVisitor.java:436)
        	at jadx.core.dex.visitors.MarkFinallyVisitor.checkBlocksTree(MarkFinallyVisitor.java:408)
        	at jadx.core.dex.visitors.MarkFinallyVisitor.checkBlocksTree(MarkFinallyVisitor.java:411)
        */
    private final void dumpCoroutinesSynchronized(java.io.PrintStream r14) {
        /*
        // Method dump skipped, instructions count: 285
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.debug.internal.DebugProbesImpl.dumpCoroutinesSynchronized(java.io.PrintStream):void");
    }

    private final void printStackTrace(PrintStream printStream, List<StackTraceElement> list) {
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            printStream.print("\n\tat " + ((Object) it.next()));
        }
    }

    /* JADX WARN: Type inference failed for: r0v6, types: [int, boolean] */
    /* JADX WARNING: Unknown variable types count: 1 */
    private final List<StackTraceElement> enhanceStackTraceWithThreadDump(DebugCoroutineInfo debugCoroutineInfo, List<StackTraceElement> list) {
        Object obj;
        Thread thread = debugCoroutineInfo.lastObservedThread;
        if (!(!Intrinsics.areEqual(debugCoroutineInfo.getState(), DebugCoroutineInfoKt.RUNNING)) && thread != null) {
            try {
                Result.Companion companion = Result.Companion;
                DebugProbesImpl debugProbesImpl = this;
                obj = Result.m12constructorimpl(thread.getStackTrace());
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                obj = Result.m12constructorimpl(ResultKt.createFailure(th));
            }
            if (Result.m18isFailureimpl(obj)) {
                obj = null;
            }
            StackTraceElement[] stackTraceElementArr = (StackTraceElement[]) obj;
            if (stackTraceElementArr != null) {
                int length = stackTraceElementArr.length;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        i = -1;
                        break;
                    }
                    StackTraceElement stackTraceElement = stackTraceElementArr[i];
                    if (((!Intrinsics.areEqual(stackTraceElement.getClassName(), "kotlin.coroutines.jvm.internal.BaseContinuationImpl") || !Intrinsics.areEqual(stackTraceElement.getMethodName(), "resumeWith") || !Intrinsics.areEqual(stackTraceElement.getFileName(), "ContinuationImpl.kt")) ? null : 1) != null) {
                        break;
                    }
                    i++;
                }
                Pair<Integer, Boolean> findContinuationStartIndex = findContinuationStartIndex(i, stackTraceElementArr, list);
                int intValue = findContinuationStartIndex.component1().intValue();
                ?? booleanValue = findContinuationStartIndex.component2().booleanValue();
                if (intValue == -1) {
                    return list;
                }
                ArrayList arrayList = new ArrayList((((list.size() + i) - intValue) - 1) - (booleanValue == true ? 1 : 0));
                int i2 = i - booleanValue;
                for (int i3 = 0; i3 < i2; i3++) {
                    arrayList.add(stackTraceElementArr[i3]);
                }
                int size = list.size();
                for (int i4 = intValue + 1; i4 < size; i4++) {
                    arrayList.add(list.get(i4));
                }
                return arrayList;
            }
        }
        return list;
    }

    private final Pair<Integer, Boolean> findContinuationStartIndex(int i, StackTraceElement[] stackTraceElementArr, List<StackTraceElement> list) {
        int findIndexOfFrame = findIndexOfFrame(i - 1, stackTraceElementArr, list);
        if (findIndexOfFrame == -1) {
            return TuplesKt.to(Integer.valueOf(findIndexOfFrame(i - 2, stackTraceElementArr, list)), true);
        }
        return TuplesKt.to(Integer.valueOf(findIndexOfFrame), false);
    }

    private final int findIndexOfFrame(int i, StackTraceElement[] stackTraceElementArr, List<StackTraceElement> list) {
        StackTraceElement stackTraceElement = (StackTraceElement) ArraysKt.getOrNull(stackTraceElementArr, i);
        if (stackTraceElement == null) {
            return -1;
        }
        int i2 = 0;
        for (StackTraceElement stackTraceElement2 : list) {
            if (Intrinsics.areEqual(stackTraceElement2.getFileName(), stackTraceElement.getFileName()) && Intrinsics.areEqual(stackTraceElement2.getClassName(), stackTraceElement.getClassName()) && Intrinsics.areEqual(stackTraceElement2.getMethodName(), stackTraceElement.getMethodName())) {
                return i2;
            }
            i2++;
        }
        return -1;
    }

    public final void probeCoroutineResumed$kotlinx_coroutines_core(Continuation<?> continuation) {
        updateState(continuation, DebugCoroutineInfoKt.RUNNING);
    }

    public final void probeCoroutineSuspended$kotlinx_coroutines_core(Continuation<?> continuation) {
        updateState(continuation, DebugCoroutineInfoKt.SUSPENDED);
    }

    private final void updateState(Continuation<?> continuation, String str) {
        if (!Intrinsics.areEqual(str, DebugCoroutineInfoKt.RUNNING) || !KotlinVersion.CURRENT.isAtLeast(1, 3, 30)) {
            CoroutineOwner<?> owner = owner(continuation);
            if (owner != null) {
                updateState(owner, continuation, str);
                return;
            }
            return;
        }
        if (!(continuation instanceof CoroutineStackFrame)) {
            continuation = null;
        }
        CoroutineStackFrame coroutineStackFrame = (CoroutineStackFrame) continuation;
        if (coroutineStackFrame != null) {
            updateRunningState(coroutineStackFrame, str);
        }
    }

    private final void updateRunningState(CoroutineStackFrame coroutineStackFrame, String str) {
        ReentrantReadWriteLock.ReadLock readLock = coroutineStateLock.readLock();
        readLock.lock();
        try {
            DebugProbesImpl debugProbesImpl = INSTANCE;
            if (debugProbesImpl.isInstalled$kotlinx_coroutines_core()) {
                ConcurrentHashMap<CoroutineStackFrame, DebugCoroutineInfo> concurrentHashMap = callerInfoCache;
                DebugCoroutineInfo remove = concurrentHashMap.remove(coroutineStackFrame);
                if (remove == null) {
                    CoroutineOwner<?> owner = debugProbesImpl.owner(coroutineStackFrame);
                    if (owner == null || (remove = owner.info) == null) {
                        readLock.unlock();
                        return;
                    }
                    CoroutineStackFrame coroutineStackFrame2 = remove.lastObservedFrame;
                    CoroutineStackFrame realCaller = coroutineStackFrame2 != null ? debugProbesImpl.realCaller(coroutineStackFrame2) : null;
                    if (realCaller != null) {
                        concurrentHashMap.remove(realCaller);
                    }
                }
                if (coroutineStackFrame != null) {
                    remove.updateState$kotlinx_coroutines_core(str, (Continuation) coroutineStackFrame);
                    CoroutineStackFrame realCaller2 = debugProbesImpl.realCaller(coroutineStackFrame);
                    if (realCaller2 != null) {
                        concurrentHashMap.put(realCaller2, remove);
                        Unit unit = Unit.INSTANCE;
                        readLock.unlock();
                        return;
                    }
                    readLock.unlock();
                    return;
                }
                throw new TypeCastException("null cannot be cast to non-null type kotlin.coroutines.Continuation<*>");
            }
        } finally {
            readLock.unlock();
        }
    }

    private final CoroutineStackFrame realCaller(CoroutineStackFrame coroutineStackFrame) {
        do {
            coroutineStackFrame = coroutineStackFrame.getCallerFrame();
            if (coroutineStackFrame == null) {
                return null;
            }
        } while (coroutineStackFrame.getStackTraceElement() == null);
        return coroutineStackFrame;
    }

    private final void updateState(CoroutineOwner<?> coroutineOwner, Continuation<?> continuation, String str) {
        ReentrantReadWriteLock.ReadLock readLock = coroutineStateLock.readLock();
        readLock.lock();
        try {
            if (INSTANCE.isInstalled$kotlinx_coroutines_core()) {
                coroutineOwner.info.updateState$kotlinx_coroutines_core(str, continuation);
                Unit unit = Unit.INSTANCE;
                readLock.unlock();
            }
        } finally {
            readLock.unlock();
        }
    }

    private final CoroutineOwner<?> owner(Continuation<?> continuation) {
        if (!(continuation instanceof CoroutineStackFrame)) {
            continuation = null;
        }
        CoroutineStackFrame coroutineStackFrame = (CoroutineStackFrame) continuation;
        if (coroutineStackFrame != null) {
            return owner(coroutineStackFrame);
        }
        return null;
    }

    private final CoroutineOwner<?> owner(CoroutineStackFrame coroutineStackFrame) {
        while (!(coroutineStackFrame instanceof CoroutineOwner)) {
            coroutineStackFrame = coroutineStackFrame.getCallerFrame();
            if (coroutineStackFrame == null) {
                return null;
            }
        }
        return (CoroutineOwner) coroutineStackFrame;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: kotlin.coroutines.Continuation<? super T> */
    /* JADX WARN: Multi-variable type inference failed */
    public final <T> Continuation<T> probeCoroutineCreated$kotlinx_coroutines_core(Continuation<? super T> continuation) {
        if (!isInstalled$kotlinx_coroutines_core() || owner(continuation) != null) {
            return continuation;
        }
        CoroutineStackFrame coroutineStackFrame = null;
        if (enableCreationStackTraces) {
            List<StackTraceElement> sanitizeStackTrace = sanitizeStackTrace(new Exception());
            if (!sanitizeStackTrace.isEmpty()) {
                ListIterator<StackTraceElement> listIterator = sanitizeStackTrace.listIterator(sanitizeStackTrace.size());
                while (listIterator.hasPrevious()) {
                    coroutineStackFrame = new DebugProbesImpl$probeCoroutineCreated$frame$1$1(listIterator.previous(), coroutineStackFrame);
                }
            }
            coroutineStackFrame = coroutineStackFrame;
        }
        return createOwner(continuation, coroutineStackFrame);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: kotlin.coroutines.Continuation<? super T> */
    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.util.concurrent.atomic.AtomicLongFieldUpdater */
    /* JADX WARN: Multi-variable type inference failed */
    private final <T> Continuation<T> createOwner(Continuation<? super T> continuation, CoroutineStackFrame coroutineStackFrame) {
        if (!isInstalled$kotlinx_coroutines_core()) {
            return continuation;
        }
        CoroutineOwner<?> coroutineOwner = new CoroutineOwner<>(continuation, new DebugCoroutineInfo(continuation.getContext(), coroutineStackFrame, sequenceNumber$FU.incrementAndGet(debugProbesImplSequenceNumberRefVolatile)), coroutineStackFrame);
        Set<CoroutineOwner<?>> set = capturedCoroutines;
        set.add(coroutineOwner);
        if (!isInstalled$kotlinx_coroutines_core()) {
            set.clear();
        }
        return coroutineOwner;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private final void probeCoroutineCompleted(CoroutineOwner<?> coroutineOwner) {
        CoroutineStackFrame realCaller;
        capturedCoroutines.remove(coroutineOwner);
        CoroutineStackFrame coroutineStackFrame = coroutineOwner.info.lastObservedFrame;
        if (coroutineStackFrame != null && (realCaller = realCaller(coroutineStackFrame)) != null) {
            callerInfoCache.remove(realCaller);
        }
    }

    /* access modifiers changed from: private */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\u00020\u0003B%\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\bJ\n\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\u001e\u0010\u0012\u001a\u00020\u00132\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0015H\u0016ø\u0001\u0000¢\u0006\u0002\u0010\u0016J\b\u0010\u0017\u001a\u00020\u0018H\u0016R\u0016\u0010\t\u001a\u0004\u0018\u00010\u00038VX\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0012\u0010\f\u001a\u00020\rX\u0005¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00028\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u00020\u00068\u0006X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0019"}, d2 = {"Lkotlinx/coroutines/debug/internal/DebugProbesImpl$CoroutineOwner;", "T", "Lkotlin/coroutines/Continuation;", "Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "delegate", "info", "Lkotlinx/coroutines/debug/internal/DebugCoroutineInfo;", "frame", "(Lkotlin/coroutines/Continuation;Lkotlinx/coroutines/debug/internal/DebugCoroutineInfo;Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;)V", "callerFrame", "getCallerFrame", "()Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "context", "Lkotlin/coroutines/CoroutineContext;", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "getStackTraceElement", "Ljava/lang/StackTraceElement;", "resumeWith", "", "result", "Lkotlin/Result;", "(Ljava/lang/Object;)V", "toString", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 16})
    /* compiled from: DebugProbesImpl.kt */
    public static final class CoroutineOwner<T> implements Continuation<T>, CoroutineStackFrame {
        public final Continuation<T> delegate;
        private final CoroutineStackFrame frame;
        public final DebugCoroutineInfo info;

        @Override // kotlin.coroutines.Continuation
        public CoroutineContext getContext() {
            return this.delegate.getContext();
        }

        /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: kotlin.coroutines.Continuation<? super T> */
        /* JADX WARN: Multi-variable type inference failed */
        public CoroutineOwner(Continuation<? super T> continuation, DebugCoroutineInfo debugCoroutineInfo, CoroutineStackFrame coroutineStackFrame) {
            this.delegate = continuation;
            this.info = debugCoroutineInfo;
            this.frame = coroutineStackFrame;
        }

        @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
        public CoroutineStackFrame getCallerFrame() {
            CoroutineStackFrame coroutineStackFrame = this.frame;
            if (coroutineStackFrame != null) {
                return coroutineStackFrame.getCallerFrame();
            }
            return null;
        }

        @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
        public StackTraceElement getStackTraceElement() {
            CoroutineStackFrame coroutineStackFrame = this.frame;
            if (coroutineStackFrame != null) {
                return coroutineStackFrame.getStackTraceElement();
            }
            return null;
        }

        @Override // kotlin.coroutines.Continuation
        public void resumeWith(Object obj) {
            DebugProbesImpl.INSTANCE.probeCoroutineCompleted(this);
            this.delegate.resumeWith(obj);
        }

        public String toString() {
            return this.delegate.toString();
        }
    }

    private final <T extends Throwable> List<StackTraceElement> sanitizeStackTrace(T t) {
        StackTraceElement[] stackTrace = t.getStackTrace();
        int length = stackTrace.length;
        int i = -1;
        int length2 = stackTrace.length - 1;
        while (true) {
            if (length2 < 0) {
                break;
            } else if (Intrinsics.areEqual(stackTrace[length2].getClassName(), "kotlin.coroutines.jvm.internal.DebugProbesKt")) {
                i = length2;
                break;
            } else {
                length2--;
            }
        }
        int i2 = 0;
        if (!sanitizeStackTraces) {
            int i3 = length - i;
            ArrayList arrayList = new ArrayList(i3);
            while (i2 < i3) {
                arrayList.add(i2 == 0 ? StackTraceRecoveryKt.artificialFrame(ARTIFICIAL_FRAME_MESSAGE) : stackTrace[i2 + i]);
                i2++;
            }
            return arrayList;
        }
        ArrayList arrayList2 = new ArrayList((length - i) + 1);
        ArrayList arrayList3 = arrayList2;
        arrayList3.add(StackTraceRecoveryKt.artificialFrame(ARTIFICIAL_FRAME_MESSAGE));
        int i4 = length - 1;
        boolean z = true;
        for (int i5 = i + 1; i5 < i4; i5++) {
            StackTraceElement stackTraceElement = stackTrace[i5];
            if (!isInternalMethod(stackTraceElement)) {
                arrayList3.add(stackTraceElement);
            } else {
                if (z) {
                    arrayList3.add(stackTraceElement);
                    z = false;
                } else if (!isInternalMethod(stackTrace[i5 + 1])) {
                    arrayList3.add(stackTraceElement);
                }
            }
            z = true;
        }
        arrayList3.add(stackTrace[i4]);
        return arrayList2;
    }

    private final boolean isInternalMethod(StackTraceElement stackTraceElement) {
        return StringsKt.startsWith$default(stackTraceElement.getClassName(), "kotlinx.coroutines", false, 2, (Object) null);
    }
}
