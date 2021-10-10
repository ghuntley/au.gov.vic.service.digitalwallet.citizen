package com.digitalwallet.utilities;

import android.content.res.Resources;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import android.util.Base64;
import com.digitalwallet.utilities.AsyncHelper;
import io.reactivex.Single;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\\\n\u0000\n\u0002\u0010\u0007\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u001c\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0006\u001a\u001c\u0010\b\u001a\u00020\t2\u000e\b\u0004\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u000bH\bø\u0001\u0000\u001a\u001c\u0010\f\u001a\u00020\t2\u000e\b\u0004\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u000bH\bø\u0001\u0000\u001a(\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\u000f0\u000e\"\u0004\b\u0000\u0010\u000f2\u000e\b\u0004\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u000f0\u000bH\bø\u0001\u0000\u001a\u001c\u0010\u0010\u001a\u00020\t2\u000e\b\u0004\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u000bH\bø\u0001\u0000\u001a\u001c\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u00132\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\t0\u000b\u001a0\u0010\u0015\u001a\u0002H\u000f\"\u0010\b\u0000\u0010\u000f\u0018\u0001*\b\u0012\u0004\u0012\u0002H\u000f0\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u0002H\u000fH\b¢\u0006\u0002\u0010\u001a\u001a7\u0010\u001b\u001a\u0002H\u000f\"\u0004\b\u0000\u0010\u000f*\u0002H\u000f2\u0006\u0010\u001c\u001a\u00020\u001d2\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u0002H\u000f\u0012\u0004\u0012\u0002H\u000f0\u001eH\bø\u0001\u0000¢\u0006\u0002\u0010\u001f\u001a?\u0010 \u001a\u0002H\u000f\"\u0004\b\u0000\u0010!\"\u000e\b\u0001\u0010\u000f*\b\u0012\u0004\u0012\u0002H!0\"*\u0002H\u000f2\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u0002H!\u0012\u0004\u0012\u00020\t0\u001eH\bø\u0001\u0000¢\u0006\u0002\u0010#\u001a)\u0010$\u001a\u00020\u001d*\u00020\u001d2\u0017\u0010\u0014\u001a\u0013\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\t0\u001e¢\u0006\u0002\b%H\bø\u0001\u0000\u001a\n\u0010&\u001a\u00020'*\u00020\u0018\u001a7\u0010(\u001a\u0002H\u000f\"\u0004\b\u0000\u0010\u000f*\u0002H\u000f2\u0006\u0010\u001c\u001a\u00020\u001d2\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u0002H\u000f\u0012\u0004\u0012\u0002H\u000f0\u001eH\bø\u0001\u0000¢\u0006\u0002\u0010\u001f\u001a?\u0010)\u001a\u0004\u0018\u0001H*\"\u0004\b\u0000\u0010\u000f\"\u0004\b\u0001\u0010**\b\u0012\u0004\u0012\u0002H\u000f0\"2\u0014\u0010+\u001a\u0010\u0012\u0004\u0012\u0002H\u000f\u0012\u0006\u0012\u0004\u0018\u0001H*0\u001eH\bø\u0001\u0000¢\u0006\u0002\u0010,\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\u0015\u0010\u0005\u001a\u00020\u0002*\u00020\u00018F¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007\u0002\u0007\n\u0005\b20\u0001¨\u0006-"}, d2 = {"devicePixels", "", "", "getDevicePixels", "(I)F", "pixels", "getPixels", "(F)I", "async", "", "execute", "Lkotlin/Function0;", "backgroundSerial", "databaseOp", "Lio/reactivex/Single;", "T", "main", "postAfter", "millis", "", "block", "toEnumValue", "", "name", "", "default", "(Ljava/lang/String;Ljava/lang/Enum;)Ljava/lang/Enum;", "alsoIf", "condition", "", "Lkotlin/Function1;", "(Ljava/lang/Object;ZLkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "applyForEach", "I", "", "(Ljava/lang/Iterable;Lkotlin/jvm/functions/Function1;)Ljava/lang/Iterable;", "applyTrue", "Lkotlin/ExtensionFunctionType;", "base64ToByteArray", "", "letIf", "reduceFirst", "R", "action", "(Ljava/lang/Iterable;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "base_citizenProdRelease"}, k = 2, mv = {1, 4, 0})
/* compiled from: StandardHelper.kt */
public final class StandardHelperKt {
    public static final boolean applyTrue(boolean z, Function1<? super Boolean, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "block");
        if (z) {
            function1.invoke(Boolean.valueOf(z));
        }
        return z;
    }

    public static final <T> T alsoIf(T t, boolean z, Function1<? super T, ? extends T> function1) {
        Intrinsics.checkNotNullParameter(function1, "block");
        if (z) {
            function1.invoke(t);
        }
        return t;
    }

    public static final <T> T letIf(T t, boolean z, Function1<? super T, ? extends T> function1) {
        Intrinsics.checkNotNullParameter(function1, "block");
        return z ? (T) function1.invoke(t) : t;
    }

    public static final <T, R> R reduceFirst(Iterable<? extends T> iterable, Function1<? super T, ? extends R> function1) {
        Intrinsics.checkNotNullParameter(iterable, "$this$reduceFirst");
        Intrinsics.checkNotNullParameter(function1, "action");
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            R r = (R) function1.invoke((Object) it.next());
            if (r != null) {
                return r;
            }
        }
        return null;
    }

    public static final void postAfter(long j, Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "block");
        new Handler(Looper.getMainLooper()).postDelayed(new StandardHelperKt$sam$java_lang_Runnable$0(function0), j);
    }

    public static final void async(Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "execute");
        new Handler();
        new StandardHelperKt$async$1(function0).execute(new Void[0]);
    }

    public static final void backgroundSerial(Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "execute");
        AsyncHelper.Companion companion = AsyncHelper.Companion;
        new AsyncHelper$Companion$backgroundSerial$1(function0).executeOnExecutor(AsyncTask.SERIAL_EXECUTOR, new Void[0]);
    }

    public static final <T> Single<T> databaseOp(Function0<? extends T> function0) {
        Intrinsics.checkNotNullParameter(function0, "execute");
        Single<T> create = Single.create(new StandardHelperKt$databaseOp$1(function0));
        Intrinsics.checkNotNullExpressionValue(create, "Single.create {\n        …        }\n        }\n    }");
        return create;
    }

    public static final void main(Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "execute");
        new Handler(Looper.getMainLooper()).post(new StandardHelperKt$main$1(function0));
    }

    public static final /* synthetic */ <T extends Enum<T>> T toEnumValue(String str, T t) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(t, "default");
        try {
            Intrinsics.reifiedOperationMarker(5, "T");
            return (T) Enum.valueOf(null, str);
        } catch (Throwable unused) {
            return t;
        }
    }

    public static final byte[] base64ToByteArray(String str) {
        Intrinsics.checkNotNullParameter(str, "$this$base64ToByteArray");
        byte[] decode = Base64.decode(new Regex("[\n\r]").replace(StringsKt.trimIndent(str), ""), 0);
        Intrinsics.checkNotNullExpressionValue(decode, "this\n        .trimIndent… { Base64.decode(it, 0) }");
        return decode;
    }

    public static final float getDevicePixels(int i) {
        Resources system = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(system, "Resources.getSystem()");
        return ((float) i) * system.getDisplayMetrics().density;
    }

    public static final int getPixels(float f) {
        Resources system = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(system, "Resources.getSystem()");
        return (int) (f / system.getDisplayMetrics().density);
    }

    public static final <I, T extends Iterable<? extends I>> T applyForEach(T t, Function1<? super I, Unit> function1) {
        Intrinsics.checkNotNullParameter(t, "$this$applyForEach");
        Intrinsics.checkNotNullParameter(function1, "block");
        Iterator it = t.iterator();
        while (it.hasNext()) {
            function1.invoke((Object) it.next());
        }
        return t;
    }
}
