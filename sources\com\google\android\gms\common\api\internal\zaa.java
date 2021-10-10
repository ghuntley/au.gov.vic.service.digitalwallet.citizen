package com.google.android.gms.common.api.internal;

import android.app.Activity;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-base@@17.4.0 */
public final class zaa extends ActivityLifecycleObserver {
    private final WeakReference<C0001zaa> zaa;

    public zaa(Activity activity) {
        this(C0001zaa.zab(activity));
    }

    private zaa(C0001zaa zaa2) {
        this.zaa = new WeakReference<>(zaa2);
    }

    @Override // com.google.android.gms.common.api.internal.ActivityLifecycleObserver
    public final ActivityLifecycleObserver onStopCallOnce(Runnable runnable) {
        C0001zaa zaa2 = this.zaa.get();
        if (zaa2 != null) {
            zaa2.zaa((C0001zaa) runnable);
            return this;
        }
        throw new IllegalStateException("The target activity has already been GC'd");
    }

    /* renamed from: com.google.android.gms.common.api.internal.zaa$zaa  reason: collision with other inner class name */
    /* compiled from: com.google.android.gms:play-services-base@@17.4.0 */
    static class C0001zaa extends LifecycleCallback {
        private List<Runnable> zaa = new ArrayList();

        /* access modifiers changed from: private */
        public static C0001zaa zab(Activity activity) {
            C0001zaa zaa2;
            synchronized (activity) {
                LifecycleFragment fragment = getFragment(activity);
                zaa2 = (C0001zaa) fragment.getCallbackOrNull("LifecycleObserverOnStop", C0001zaa.class);
                if (zaa2 == null) {
                    zaa2 = new C0001zaa(fragment);
                }
            }
            return zaa2;
        }

        private C0001zaa(LifecycleFragment lifecycleFragment) {
            super(lifecycleFragment);
            this.mLifecycleFragment.addCallback("LifecycleObserverOnStop", this);
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final synchronized void zaa(Runnable runnable) {
            this.zaa.add(runnable);
        }

        @Override // com.google.android.gms.common.api.internal.LifecycleCallback
        public void onStop() {
            List<Runnable> list;
            synchronized (this) {
                list = this.zaa;
                this.zaa = new ArrayList();
            }
            for (Runnable runnable : list) {
                runnable.run();
            }
        }
    }
}
