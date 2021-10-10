package com.google.android.play.core.splitinstall.testing;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Log;
import com.google.android.play.core.common.IntentSenderForResultStarter;
import com.google.android.play.core.internal.af;
import com.google.android.play.core.internal.aw;
import com.google.android.play.core.internal.by;
import com.google.android.play.core.splitinstall.SplitInstallException;
import com.google.android.play.core.splitinstall.SplitInstallManager;
import com.google.android.play.core.splitinstall.SplitInstallRequest;
import com.google.android.play.core.splitinstall.SplitInstallSessionState;
import com.google.android.play.core.splitinstall.SplitInstallStateUpdatedListener;
import com.google.android.play.core.splitinstall.e;
import com.google.android.play.core.splitinstall.h;
import com.google.android.play.core.splitinstall.l;
import com.google.android.play.core.splitinstall.p;
import com.google.android.play.core.tasks.Task;
import com.google.android.play.core.tasks.Tasks;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public class FakeSplitInstallManager implements SplitInstallManager {
    public static final /* synthetic */ int a = 0;
    private static final long c = TimeUnit.SECONDS.toMillis(1);
    private final Handler b;
    private final Context d;
    private final p e;
    private final by f;
    private final af<SplitInstallSessionState> g;
    private final Executor h;
    private final e i;
    private final File j;
    private final AtomicReference<SplitInstallSessionState> k;
    private final Set<String> l;
    private final Set<String> m;
    private final AtomicBoolean n;
    private final a o;

    @Deprecated
    public FakeSplitInstallManager(Context context, File file) {
        this(context, file, new p(context, context.getPackageName()));
    }

    FakeSplitInstallManager(Context context, File file, p pVar) {
        Executor a2 = com.google.android.play.core.splitcompat.p.a();
        by byVar = new by(context);
        a aVar = a.a;
        this.b = new Handler(Looper.getMainLooper());
        this.k = new AtomicReference<>();
        this.l = Collections.synchronizedSet(new HashSet());
        this.m = Collections.synchronizedSet(new HashSet());
        this.n = new AtomicBoolean(false);
        this.d = context;
        this.j = file;
        this.e = pVar;
        this.h = a2;
        this.f = byVar;
        this.o = aVar;
        this.g = new af<>();
        this.i = l.a;
    }

    static final /* synthetic */ SplitInstallSessionState e(int i2, SplitInstallSessionState splitInstallSessionState) {
        int status;
        if (splitInstallSessionState != null && i2 == splitInstallSessionState.sessionId() && ((status = splitInstallSessionState.status()) == 1 || status == 2 || status == 8 || status == 9 || status == 7)) {
            return SplitInstallSessionState.create(i2, 7, splitInstallSessionState.errorCode(), splitInstallSessionState.bytesDownloaded(), splitInstallSessionState.totalBytesToDownload(), splitInstallSessionState.moduleNames(), splitInstallSessionState.languages());
        }
        throw new SplitInstallException(-3);
    }

    static final /* synthetic */ SplitInstallSessionState g(Integer num, int i2, int i3, Long l2, Long l3, List list, List list2, SplitInstallSessionState splitInstallSessionState) {
        SplitInstallSessionState create = splitInstallSessionState == null ? SplitInstallSessionState.create(0, 0, 0, 0, 0, new ArrayList(), new ArrayList()) : splitInstallSessionState;
        return SplitInstallSessionState.create(num == null ? create.sessionId() : num.intValue(), i2, i3, l2 == null ? create.bytesDownloaded() : l2.longValue(), l3 == null ? create.totalBytesToDownload() : l3.longValue(), list == null ? create.moduleNames() : list, list2 == null ? create.languages() : list2);
    }

    static final /* synthetic */ void h() {
        SystemClock.sleep(c);
    }

    private final SplitInstallSessionState n() {
        return this.k.get();
    }

    private final synchronized SplitInstallSessionState o(j jVar) {
        SplitInstallSessionState n2 = n();
        SplitInstallSessionState a2 = jVar.a(n2);
        if (this.k.compareAndSet(n2, a2)) {
            return a2;
        }
        return null;
    }

    /* access modifiers changed from: private */
    public final boolean p(int i2, int i3, Long l2, Long l3, List<String> list, Integer num, List<String> list2) {
        SplitInstallSessionState o2 = o(new b(num, i2, i3, l2, l3, list, list2));
        if (o2 == null) {
            return false;
        }
        s(o2);
        return true;
    }

    private static String q(String str) {
        return str.split("\\.config\\.", 2)[0];
    }

    private final h r() {
        h c2 = this.e.c();
        if (c2 != null) {
            return c2;
        }
        throw new IllegalStateException("Language information could not be found. Make sure you are using the target application context, not the tests context, and the app is built as a bundle.");
    }

    private final void s(SplitInstallSessionState splitInstallSessionState) {
        this.b.post(new f(this, splitInstallSessionState));
    }

    /* access modifiers changed from: private */
    public final void t(List<Intent> list, List<String> list2, List<String> list3, long j2, boolean z) {
        this.i.a().a(list, new i(this, list2, list3, j2, z, list));
    }

    /* access modifiers changed from: private */
    public final boolean u(int i2) {
        return p(6, i2, null, null, null, null, null);
    }

    /* access modifiers changed from: package-private */
    public final File a() {
        return this.j;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void b(List list, List list2, List list3, long j2) {
        if (this.n.get()) {
            u(-6);
        } else {
            t(list, list2, list3, j2, false);
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void c(long j2, List list, List list2, List list3) {
        long j3 = j2 / 3;
        long j4 = 0;
        for (int i2 = 0; i2 < 3; i2++) {
            j4 = Math.min(j2, j4 + j3);
            p(2, 0, Long.valueOf(j4), Long.valueOf(j2), null, null, null);
            h();
            SplitInstallSessionState n2 = n();
            if (n2.status() == 9 || n2.status() == 7 || n2.status() == 6) {
                return;
            }
        }
        this.h.execute(new h(this, list, list2, list3, j2));
    }

    @Override // com.google.android.play.core.splitinstall.SplitInstallManager
    public final Task<Void> cancelInstall(int i2) {
        try {
            SplitInstallSessionState o2 = o(new e(i2));
            if (o2 != null) {
                s(o2);
            }
            return Tasks.a(null);
        } catch (SplitInstallException e2) {
            return Tasks.b(e2);
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void d(SplitInstallSessionState splitInstallSessionState) {
        this.g.c(splitInstallSessionState);
    }

    @Override // com.google.android.play.core.splitinstall.SplitInstallManager
    public final Task<Void> deferredInstall(List<String> list) {
        return Tasks.b(new SplitInstallException(-5));
    }

    @Override // com.google.android.play.core.splitinstall.SplitInstallManager
    public final Task<Void> deferredLanguageInstall(List<Locale> list) {
        return Tasks.b(new SplitInstallException(-5));
    }

    @Override // com.google.android.play.core.splitinstall.SplitInstallManager
    public final Task<Void> deferredLanguageUninstall(List<Locale> list) {
        return Tasks.b(new SplitInstallException(-5));
    }

    @Override // com.google.android.play.core.splitinstall.SplitInstallManager
    public final Task<Void> deferredUninstall(List<String> list) {
        return Tasks.b(new SplitInstallException(-5));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void f(List list, List list2) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            File file = (File) it.next();
            String b2 = aw.b(file);
            Uri fromFile = Uri.fromFile(file);
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setDataAndType(fromFile, this.d.getContentResolver().getType(fromFile));
            intent.addFlags(1);
            intent.putExtra("module_name", q(b2));
            intent.putExtra("split_id", b2);
            arrayList.add(intent);
            arrayList2.add(q(aw.b(file)));
        }
        SplitInstallSessionState n2 = n();
        if (n2 != null) {
            this.h.execute(new g(this, n2.totalBytesToDownload(), arrayList, arrayList2, list2));
        }
    }

    @Override // com.google.android.play.core.splitinstall.SplitInstallManager
    public final Set<String> getInstalledLanguages() {
        HashSet hashSet = new HashSet();
        if (this.e.b() != null) {
            hashSet.addAll(this.e.b());
        }
        hashSet.addAll(this.m);
        return hashSet;
    }

    @Override // com.google.android.play.core.splitinstall.SplitInstallManager
    public final Set<String> getInstalledModules() {
        HashSet hashSet = new HashSet();
        hashSet.addAll(this.e.a());
        hashSet.addAll(this.l);
        return hashSet;
    }

    @Override // com.google.android.play.core.splitinstall.SplitInstallManager
    public final Task<SplitInstallSessionState> getSessionState(int i2) {
        SplitInstallSessionState n2 = n();
        return (n2 == null || n2.sessionId() != i2) ? Tasks.b(new SplitInstallException(-4)) : Tasks.a(n2);
    }

    @Override // com.google.android.play.core.splitinstall.SplitInstallManager
    public final Task<List<SplitInstallSessionState>> getSessionStates() {
        SplitInstallSessionState n2 = n();
        return Tasks.a(n2 != null ? Collections.singletonList(n2) : Collections.emptyList());
    }

    @Override // com.google.android.play.core.splitinstall.SplitInstallManager
    public final void registerListener(SplitInstallStateUpdatedListener splitInstallStateUpdatedListener) {
        this.g.a(splitInstallStateUpdatedListener);
    }

    public void setShouldNetworkError(boolean z) {
        this.n.set(z);
    }

    @Override // com.google.android.play.core.splitinstall.SplitInstallManager
    public final boolean startConfirmationDialogForResult(SplitInstallSessionState splitInstallSessionState, Activity activity, int i2) throws IntentSender.SendIntentException {
        return false;
    }

    @Override // com.google.android.play.core.splitinstall.SplitInstallManager
    public final boolean startConfirmationDialogForResult(SplitInstallSessionState splitInstallSessionState, IntentSenderForResultStarter intentSenderForResultStarter, int i2) throws IntentSender.SendIntentException {
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0133, code lost:
        if (r0.contains(r6) == false) goto L_0x013c;
     */
    @Override // com.google.android.play.core.splitinstall.SplitInstallManager
    public final Task<Integer> startInstall(SplitInstallRequest splitInstallRequest) {
        int i2;
        int i3;
        File[] fileArr;
        int i4;
        try {
            SplitInstallSessionState o2 = o(new d(splitInstallRequest));
            if (o2 == null) {
                return Tasks.b(new SplitInstallException(-100));
            }
            int sessionId = o2.sessionId();
            ArrayList arrayList = new ArrayList();
            for (Locale locale : splitInstallRequest.getLanguages()) {
                arrayList.add(locale.getLanguage());
            }
            HashSet hashSet = new HashSet();
            ArrayList arrayList2 = new ArrayList();
            File[] listFiles = this.j.listFiles();
            if (listFiles == null) {
                Log.w("FakeSplitInstallManager", "Specified splits directory does not exist.");
                return Tasks.b(new SplitInstallException(-5));
            }
            int length = listFiles.length;
            int i5 = 0;
            long j2 = 0;
            while (i5 < length) {
                File file = listFiles[i5];
                String b2 = aw.b(file);
                if (splitInstallRequest.getModuleNames().contains(q(b2))) {
                    String q = q(b2);
                    HashSet hashSet2 = new HashSet(this.f.a());
                    fileArr = listFiles;
                    Map<String, Set<String>> a2 = r().a(Arrays.asList(q));
                    HashSet hashSet3 = new HashSet();
                    for (Set<String> set : a2.values()) {
                        hashSet3.addAll(set);
                        length = length;
                    }
                    i3 = length;
                    HashSet hashSet4 = new HashSet();
                    Iterator it = hashSet2.iterator();
                    while (it.hasNext()) {
                        String str = (String) it.next();
                        if (str.contains("_")) {
                            i4 = sessionId;
                            str = str.split("_", -1)[0];
                        } else {
                            i4 = sessionId;
                        }
                        hashSet4.add(str);
                        it = it;
                        sessionId = i4;
                    }
                    i2 = sessionId;
                    hashSet4.addAll(this.m);
                    hashSet4.addAll(arrayList);
                    HashSet hashSet5 = new HashSet();
                    for (Map.Entry<String, Set<String>> entry : a2.entrySet()) {
                        if (hashSet4.contains(entry.getKey())) {
                            hashSet5.addAll(entry.getValue());
                        }
                    }
                    if (hashSet3.contains(b2)) {
                    }
                    j2 += file.length();
                    hashSet.add(aw.b(file));
                    arrayList2.add(file);
                    i5++;
                    listFiles = fileArr;
                    length = i3;
                    sessionId = i2;
                } else {
                    i2 = sessionId;
                    fileArr = listFiles;
                    i3 = length;
                }
                List<Locale> languages = splitInstallRequest.getLanguages();
                ArrayList arrayList3 = new ArrayList(this.l);
                arrayList3.addAll(Arrays.asList("", "base"));
                Map<String, Set<String>> a3 = r().a(arrayList3);
                Iterator<Locale> it2 = languages.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    Locale next = it2.next();
                    if (a3.containsKey(next.getLanguage()) && a3.get(next.getLanguage()).contains(b2)) {
                        break;
                    }
                }
                j2 += file.length();
                hashSet.add(aw.b(file));
                arrayList2.add(file);
                i5++;
                listFiles = fileArr;
                length = i3;
                sessionId = i2;
            }
            String valueOf = String.valueOf(hashSet);
            String valueOf2 = String.valueOf(splitInstallRequest.getModuleNames());
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 21 + String.valueOf(valueOf2).length());
            sb.append("availableSplits");
            sb.append(valueOf);
            sb.append(" want ");
            sb.append(valueOf2);
            Log.i("FakeSplitInstallManager", sb.toString());
            if (!hashSet.containsAll(new HashSet(splitInstallRequest.getModuleNames()))) {
                return Tasks.b(new SplitInstallException(-2));
            }
            Long valueOf3 = Long.valueOf(j2);
            List<String> moduleNames = splitInstallRequest.getModuleNames();
            Integer valueOf4 = Integer.valueOf(sessionId);
            p(1, 0, 0L, valueOf3, moduleNames, valueOf4, arrayList);
            this.h.execute(new c(this, arrayList2, arrayList));
            return Tasks.a(valueOf4);
        } catch (SplitInstallException e2) {
            return Tasks.b(e2);
        }
    }

    @Override // com.google.android.play.core.splitinstall.SplitInstallManager
    public final void unregisterListener(SplitInstallStateUpdatedListener splitInstallStateUpdatedListener) {
        this.g.b(splitInstallStateUpdatedListener);
    }
}
