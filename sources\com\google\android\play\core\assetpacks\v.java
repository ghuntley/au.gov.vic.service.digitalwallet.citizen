package com.google.android.play.core.assetpacks;

import com.google.android.play.core.internal.br;
import com.google.android.play.core.internal.co;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public final class v implements co<Executor> {
    public static Executor b() {
        ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor(m.a);
        br.j(newSingleThreadExecutor);
        return newSingleThreadExecutor;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.google.android.play.core.internal.co
    public final /* bridge */ /* synthetic */ Executor a() {
        return b();
    }
}
