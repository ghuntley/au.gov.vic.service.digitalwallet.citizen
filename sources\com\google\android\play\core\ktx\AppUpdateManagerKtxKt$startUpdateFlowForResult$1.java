package com.google.android.play.core.ktx;

import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function7;
import kotlin.jvm.internal.FunctionReference;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012,\u0010\u0002\u001a( \u0007*\u0013\u0018\u00010\u0003¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00060\u0003¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00062\u0015\u0010\b\u001a\u00110\t¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00022\u0017\u0010\n\u001a\u0013\u0018\u00010\u000b¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\b2\u0015\u0010\f\u001a\u00110\t¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\n2\u0015\u0010\r\u001a\u00110\t¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\f2\u0015\u0010\u000e\u001a\u00110\t¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\r2\u0017\u0010\u000f\u001a\u0013\u0018\u00010\u0010¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u000e¢\u0006\u0002\b\u0011"}, d2 = {"<anonymous>", "", "p1", "Landroid/content/IntentSender;", "Lkotlin/ParameterName;", "name", "p0", "kotlin.jvm.PlatformType", "p2", "", "p3", "Landroid/content/Intent;", "p4", "p5", "p6", "p7", "Landroid/os/Bundle;", "invoke"}, k = 3, mv = {1, 1, 16})
/* compiled from: AppUpdateManagerKtx.kt */
public final /* synthetic */ class AppUpdateManagerKtxKt$startUpdateFlowForResult$1 extends FunctionReference implements Function7<IntentSender, Integer, Intent, Integer, Integer, Integer, Bundle, Unit> {
    AppUpdateManagerKtxKt$startUpdateFlowForResult$1(Fragment fragment) {
        super(7, fragment);
    }

    @Override // kotlin.jvm.internal.CallableReference, kotlin.reflect.KCallable
    public final String getName() {
        return "startIntentSenderForResult";
    }

    @Override // kotlin.jvm.internal.CallableReference
    public final KDeclarationContainer getOwner() {
        return Reflection.getOrCreateKotlinClass(Fragment.class);
    }

    @Override // kotlin.jvm.internal.CallableReference
    public final String getSignature() {
        return "startIntentSenderForResult(Landroid/content/IntentSender;ILandroid/content/Intent;IIILandroid/os/Bundle;)V";
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object, java.lang.Object, java.lang.Object, java.lang.Object, java.lang.Object, java.lang.Object] */
    @Override // kotlin.jvm.functions.Function7
    public /* bridge */ /* synthetic */ Unit invoke(IntentSender intentSender, Integer num, Intent intent, Integer num2, Integer num3, Integer num4, Bundle bundle) {
        invoke(intentSender, num.intValue(), intent, num2.intValue(), num3.intValue(), num4.intValue(), bundle);
        return Unit.INSTANCE;
    }

    public final void invoke(IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4, Bundle bundle) {
        ((Fragment) this.receiver).startIntentSenderForResult(intentSender, i, intent, i2, i3, i4, bundle);
    }
}
