package com.google.firebase.crashlytics.ktx;

import com.google.firebase.crashlytics.FirebaseCrashlytics;
import com.google.firebase.ktx.Firebase;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a#\u0010\u0007\u001a\u00020\b*\u00020\u00032\u0017\u0010\t\u001a\u0013\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\b0\n¢\u0006\u0002\b\f\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0003*\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\r"}, d2 = {"LIBRARY_NAME", "", "crashlytics", "Lcom/google/firebase/crashlytics/FirebaseCrashlytics;", "Lcom/google/firebase/ktx/Firebase;", "getCrashlytics", "(Lcom/google/firebase/ktx/Firebase;)Lcom/google/firebase/crashlytics/FirebaseCrashlytics;", "setCustomKeys", "", "init", "Lkotlin/Function1;", "Lcom/google/firebase/crashlytics/ktx/KeyValueBuilder;", "Lkotlin/ExtensionFunctionType;", "com.google.firebase-firebase-crashlytics-ktx"}, k = 2, mv = {1, 1, 13})
/* compiled from: FirebaseCrashlytics.kt */
public final class FirebaseCrashlyticsKt {
    public static final String LIBRARY_NAME = "fire-cls-ktx";

    public static final FirebaseCrashlytics getCrashlytics(Firebase firebase) {
        Intrinsics.checkParameterIsNotNull(firebase, "receiver$0");
        FirebaseCrashlytics instance = FirebaseCrashlytics.getInstance();
        Intrinsics.checkExpressionValueIsNotNull(instance, "FirebaseCrashlytics.getInstance()");
        return instance;
    }

    public static final void setCustomKeys(FirebaseCrashlytics firebaseCrashlytics, Function1<? super KeyValueBuilder, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(firebaseCrashlytics, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        function1.invoke(new KeyValueBuilder(firebaseCrashlytics));
    }
}
