package com.digitalwallet.app.model;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", "invoke"}, k = 3, mv = {1, 4, 0})
/* compiled from: Holding.kt */
public final class HoldingAddress$elementsToString$1 extends Lambda implements Function1<String, Boolean> {
    public static final HoldingAddress$elementsToString$1 INSTANCE = new HoldingAddress$elementsToString$1();

    HoldingAddress$elementsToString$1() {
        super(1);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(String str) {
        return Boolean.valueOf(invoke(str));
    }

    public final boolean invoke(String str) {
        String str2 = str;
        return !(str2 == null || str2.length() == 0);
    }
}
