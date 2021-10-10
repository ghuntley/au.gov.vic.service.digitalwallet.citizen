package com.digitalwallet.viewmodel.checkIn.checkInRepository;

import android.content.Context;
import androidx.lifecycle.MutableLiveData;
import com.digitalwallet.BuildConfig;
import com.digitalwallet.api.CheckInApi;
import com.digitalwallet.model.AttestationJwt;
import com.digitalwallet.model.CheckIn;
import com.digitalwallet.model.CheckInAuth;
import com.digitalwallet.model.CheckInAuthToken;
import com.digitalwallet.model.CheckInCookie;
import com.digitalwallet.model.CheckInHistoryCombo;
import com.digitalwallet.model.CheckInShortcuts;
import com.digitalwallet.model.CheckInSubmissionPayload;
import com.digitalwallet.model.DependantCheckIn;
import com.digitalwallet.model.PrimaryPersonCheckIn;
import com.digitalwallet.utilities.AnalyticsHelper;
import com.digitalwallet.viewmodel.checkIn.CheckInUtils;
import com.google.android.gms.instantapps.InstantApps;
import com.google.android.gms.instantapps.PackageManagerCompat;
import com.google.firebase.crashlytics.internal.common.AbstractSpiCall;
import com.google.firebase.messaging.Constants;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;
import io.reactivex.Completable;
import io.reactivex.Scheduler;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import org.bouncycastle.i18n.ErrorBundle;
import org.objectweb.asm.Opcodes;
import timber.log.Timber;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000¶\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\r\b\u0007\u0018\u0000 Z2\u00020\u0001:\u0001ZB/\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\u001f\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 ¢\u0006\u0002\u0010!J\u0016\u0010\"\u001a\u00020\u001c2\u0006\u0010#\u001a\u00020\u000f2\u0006\u0010$\u001a\u00020\u001eJ\u0014\u0010%\u001a\b\u0012\u0004\u0012\u00020\u000f0&2\u0006\u0010'\u001a\u00020\u000fJ\b\u0010(\u001a\u00020\u001cH\u0002J\u0006\u0010)\u001a\u00020\u001cJ\u0010\u0010*\u001a\u00020\u001c2\b\b\u0002\u0010+\u001a\u00020,J\b\u0010-\u001a\u00020\u001cH\u0002J\u000e\u0010.\u001a\u00020\u001c2\u0006\u0010/\u001a\u000200J\u001c\u00101\u001a\u00020\u001c2\u0012\u00102\u001a\u000e\u0012\u0004\u0012\u000204\u0012\u0004\u0012\u00020\u001c03H\u0002J\n\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0002J\u000e\u00105\u001a\b\u0012\u0004\u0012\u00020706H\u0002J\u0006\u00108\u001a\u000209J\b\u0010:\u001a\u000204H\u0002J\u0006\u0010;\u001a\u000204J\n\u0010<\u001a\u0004\u0018\u00010=H\u0002J\u0010\u0010>\u001a\u0004\u0018\u00010?2\u0006\u0010$\u001a\u00020\u001eJ\u0012\u0010@\u001a\u0004\u0018\u00010=2\u0006\u0010A\u001a\u00020BH\u0002J\f\u0010C\u001a\b\u0012\u0004\u0012\u0002000&J\n\u0010D\u001a\u0004\u0018\u000107H\u0002J\b\u0010E\u001a\u0004\u0018\u00010BJ\b\u0010F\u001a\u0004\u0018\u00010BJ\b\u0010G\u001a\u0004\u0018\u00010BJ\u0014\u0010H\u001a\u00020\u001c2\f\u0010I\u001a\b\u0012\u0004\u0012\u00020\u000f0&J\u000e\u0010J\u001a\u00020,2\u0006\u0010K\u001a\u00020\u000fJ\u000e\u0010L\u001a\u00020,2\u0006\u0010K\u001a\u00020\u000fJ\u0010\u0010M\u001a\u00020N2\u0006\u0010O\u001a\u00020BH\u0002J\u0006\u0010P\u001a\u00020\u001cJ\u0006\u0010Q\u001a\u00020,J\u0014\u0010R\u001a\u00020\u001c2\f\u0010S\u001a\b\u0012\u0004\u0012\u00020\u001e0&J\u0010\u0010T\u001a\u00020\u001c2\u0006\u0010U\u001a\u000204H\u0002J\u0010\u0010V\u001a\u00020\u001c2\u0006\u0010#\u001a\u000207H\u0002J\u000e\u0010W\u001a\u00020\u001c2\u0006\u0010K\u001a\u00020\u000fJ\u000e\u0010X\u001a\u00020\u001c2\u0006\u0010/\u001a\u000200J\u0006\u0010Y\u001a\u00020NR\u0019\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0012\u001a\n \u0014*\u0004\u0018\u00010\u00130\u0013X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0017\u001a\n \u0014*\u0004\u0018\u00010\u00180\u0018X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000¨\u0006["}, d2 = {"Lcom/digitalwallet/viewmodel/checkIn/checkInRepository/CheckInRepository;", "", "context", "Landroid/content/Context;", "moshi", "Lcom/squareup/moshi/Moshi;", "checkInApi", "Lcom/digitalwallet/api/CheckInApi;", "sharedPreferences", "Lcom/digitalwallet/viewmodel/checkIn/checkInRepository/CheckInSharedPreferences;", "analytics", "Lcom/digitalwallet/utilities/AnalyticsHelper;", "(Landroid/content/Context;Lcom/squareup/moshi/Moshi;Lcom/digitalwallet/api/CheckInApi;Lcom/digitalwallet/viewmodel/checkIn/checkInRepository/CheckInSharedPreferences;Lcom/digitalwallet/utilities/AnalyticsHelper;)V", "activeCheckIn", "Landroidx/lifecycle/MutableLiveData;", "Lcom/digitalwallet/model/CheckIn;", "getActiveCheckIn", "()Landroidx/lifecycle/MutableLiveData;", "packageManager", "Lcom/google/android/gms/instantapps/PackageManagerCompat;", "kotlin.jvm.PlatformType", "secureRandom", "Ljava/security/SecureRandom;", "sequentialExecutor", "Ljava/util/concurrent/ExecutorService;", "sequentialScheduler", "Lio/reactivex/Scheduler;", "addACheckInFavouriteIfNotExists", "", "favourite", "Lcom/digitalwallet/viewmodel/checkIn/CheckInUtils$CheckInCode;", "atIndex", "", "(Lcom/digitalwallet/viewmodel/checkIn/CheckInUtils$CheckInCode;Ljava/lang/Integer;)V", "addACheckInHistoryIfNotExists", "item", "checkInCode", "addPendingCheckIn", "", ErrorBundle.DETAIL_ENTRY, "clearAttestationJwt", "clearCheckInUserDetail", "clearCookie", "onlyClearInstantAppCookie", "", "clearPendingCheckIns", "deleteACheckInDependantIfExists", "dependantCheckIn", "Lcom/digitalwallet/model/DependantCheckIn;", "editCookie", "editFn", "Lkotlin/Function1;", "Lcom/digitalwallet/model/CheckInCookie;", "getAttestation", "Lio/reactivex/Single;", "Lcom/digitalwallet/model/AttestationJwt;", "getCheckInShortcuts", "Lcom/digitalwallet/model/CheckInShortcuts;", "getCookie", "getFallbackCheckInCookie", "getNonce", "", "getPrimaryPersonCheckIn", "Lcom/digitalwallet/model/PrimaryPersonCheckIn;", "getRequestNonce", Constants.ScionAnalytics.MessageType.DATA_MESSAGE, "", "getSavedDependants", "getStoredAttestationJwt", "getStoredFirstName", "getStoredLastName", "getStoredPhoneNumber", "hideSomeCheckInHistory", "someHistory", "isActiveCheckIn", "checkInItem", "isCheckInPending", "postCheckIns", "Lio/reactivex/Completable;", "jwt", "refreshActiveCheckIn", "rememberHasCheckedIn", "removeSomeCheckInFavourites", "someFavourites", "setCookie", "cookie", "storeAttestationJwt", "storeCheckInUserDetail", "storeOrUpdateACheckInDependant", "uploadCheckIns", "Companion", "base_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
@Singleton
/* compiled from: CheckInRepository.kt */
public final class CheckInRepository {
    private static final int ATTESTATION_JWT_VALID_DURATION_MINUTES = 5;
    public static final Companion Companion = new Companion(null);
    private final MutableLiveData<CheckIn> activeCheckIn;
    private final AnalyticsHelper analytics;
    private final CheckInApi checkInApi;
    private final Context context;
    private final Moshi moshi;
    private final PackageManagerCompat packageManager;
    private final SecureRandom secureRandom = new SecureRandom();
    private final ExecutorService sequentialExecutor;
    private final Scheduler sequentialScheduler;
    private final CheckInSharedPreferences sharedPreferences;

    @Inject
    public CheckInRepository(Context context2, Moshi moshi2, CheckInApi checkInApi2, CheckInSharedPreferences checkInSharedPreferences, AnalyticsHelper analyticsHelper) {
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(moshi2, "moshi");
        Intrinsics.checkNotNullParameter(checkInApi2, "checkInApi");
        Intrinsics.checkNotNullParameter(checkInSharedPreferences, "sharedPreferences");
        Intrinsics.checkNotNullParameter(analyticsHelper, "analytics");
        this.context = context2;
        this.moshi = moshi2;
        this.checkInApi = checkInApi2;
        this.sharedPreferences = checkInSharedPreferences;
        this.analytics = analyticsHelper;
        this.packageManager = InstantApps.getPackageManagerCompat(context2);
        ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor();
        this.sequentialExecutor = newSingleThreadExecutor;
        Scheduler from = Schedulers.from(newSingleThreadExecutor);
        Intrinsics.checkNotNullExpressionValue(from, "Schedulers.from(sequentialExecutor)");
        this.sequentialScheduler = from;
        MutableLiveData<CheckIn> mutableLiveData = new MutableLiveData<>();
        this.activeCheckIn = mutableLiveData;
        mutableLiveData.setValue(getActiveCheckIn());
    }

    /* renamed from: getActiveCheckIn  reason: collision with other method in class */
    public final MutableLiveData<CheckIn> m7getActiveCheckIn() {
        return this.activeCheckIn;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x005b, code lost:
        if (java.util.concurrent.TimeUnit.MILLISECONDS.toMinutes(r1 - r8.getTime()) < ((long) 40320)) goto L_0x005f;
     */
    public final CheckInShortcuts getCheckInShortcuts() {
        CheckInShortcuts checkInShortcuts = this.sharedPreferences.getCheckInShortcuts();
        Calendar instance = Calendar.getInstance();
        Intrinsics.checkNotNullExpressionValue(instance, "Calendar.getInstance()");
        Date time = instance.getTime();
        Intrinsics.checkNotNullExpressionValue(time, "Calendar.getInstance().time");
        long time2 = time.getTime();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        Iterator<T> it = checkInShortcuts.getHistoryItems().iterator();
        while (true) {
            boolean z = true;
            if (!it.hasNext()) {
                break;
            }
            T next = it.next();
            Date date = next.component1().getDate();
            if (date != null) {
            }
            z = false;
            if (z) {
                arrayList.add(next);
            } else {
                arrayList2.add(next);
            }
        }
        Pair pair = new Pair(arrayList, arrayList2);
        checkInShortcuts.setHistoryItems(CollectionsKt.sortedWith((List) pair.component1(), new CheckInRepository$$special$$inlined$sortedByDescending$1()));
        if (!((List) pair.component2()).isEmpty()) {
            checkInShortcuts.cleanupUnusedLocations();
            this.sharedPreferences.setCheckInShortcuts(checkInShortcuts);
        }
        return checkInShortcuts;
    }

    public static /* synthetic */ void addACheckInFavouriteIfNotExists$default(CheckInRepository checkInRepository, CheckInUtils.CheckInCode checkInCode, Integer num, int i, Object obj) {
        if ((i & 2) != 0) {
            num = null;
        }
        checkInRepository.addACheckInFavouriteIfNotExists(checkInCode, num);
    }

    public final void addACheckInFavouriteIfNotExists(CheckInUtils.CheckInCode checkInCode, Integer num) {
        Intrinsics.checkNotNullParameter(checkInCode, "favourite");
        CheckInShortcuts checkInShortcuts = getCheckInShortcuts();
        List<CheckInUtils.CheckInCode> mutableList = CollectionsKt.toMutableList((Collection) checkInShortcuts.getFavourites());
        if (!mutableList.contains(checkInCode)) {
            if (num != null) {
                mutableList.add(num.intValue(), checkInCode);
            } else {
                mutableList.add(checkInCode);
            }
        }
        checkInShortcuts.setFavourites(mutableList);
        this.sharedPreferences.setCheckInShortcuts(checkInShortcuts);
    }

    public final void removeSomeCheckInFavourites(List<CheckInUtils.CheckInCode> list) {
        Intrinsics.checkNotNullParameter(list, "someFavourites");
        CheckInShortcuts checkInShortcuts = getCheckInShortcuts();
        List<CheckInUtils.CheckInCode> mutableList = CollectionsKt.toMutableList((Collection) checkInShortcuts.getFavourites());
        mutableList.removeAll(list);
        checkInShortcuts.setFavourites(mutableList);
        checkInShortcuts.cleanupUnusedLocations();
        this.sharedPreferences.setCheckInShortcuts(checkInShortcuts);
    }

    public final void addACheckInHistoryIfNotExists(CheckIn checkIn, CheckInUtils.CheckInCode checkInCode) {
        T t;
        Intrinsics.checkNotNullParameter(checkIn, "item");
        Intrinsics.checkNotNullParameter(checkInCode, "checkInCode");
        CheckInShortcuts checkInShortcuts = getCheckInShortcuts();
        List<CheckInHistoryCombo> mutableList = CollectionsKt.toMutableList((Collection) checkInShortcuts.getHistoryItems());
        Iterator<T> it = mutableList.iterator();
        while (true) {
            if (!it.hasNext()) {
                t = null;
                break;
            }
            t = it.next();
            if (Intrinsics.areEqual(t.getCheckInItem(), checkIn)) {
                break;
            }
        }
        if (t == null) {
            mutableList.add(0, new CheckInHistoryCombo(checkIn, checkInCode, false, 4, null));
        }
        checkInShortcuts.setHistoryItems(mutableList);
        this.sharedPreferences.setCheckInShortcuts(checkInShortcuts);
        refreshActiveCheckIn();
    }

    public final void hideSomeCheckInHistory(List<CheckIn> list) {
        Intrinsics.checkNotNullParameter(list, "someHistory");
        CheckInShortcuts checkInShortcuts = getCheckInShortcuts();
        List<CheckInHistoryCombo> historyItems = checkInShortcuts.getHistoryItems();
        ArrayList<CheckInHistoryCombo> arrayList = new ArrayList();
        for (T t : historyItems) {
            if (list.contains(t.component1())) {
                arrayList.add(t);
            }
        }
        for (CheckInHistoryCombo checkInHistoryCombo : arrayList) {
            checkInHistoryCombo.setHidden(true);
        }
        checkInShortcuts.setHistoryItems(historyItems);
        checkInShortcuts.cleanupUnusedLocations();
        this.sharedPreferences.setCheckInShortcuts(checkInShortcuts);
        refreshActiveCheckIn();
    }

    public final CheckInCookie getFallbackCheckInCookie() {
        return this.sharedPreferences.getCheckInCookie();
    }

    private final CheckInCookie getCookie() {
        CheckInCookie fallbackCheckInCookie = getFallbackCheckInCookie();
        if (!Intrinsics.areEqual(fallbackCheckInCookie, new CheckInCookie(null, null, false, null, null, null, null, 127, null))) {
            return fallbackCheckInCookie;
        }
        PackageManagerCompat packageManagerCompat = this.packageManager;
        Intrinsics.checkNotNullExpressionValue(packageManagerCompat, "packageManager");
        byte[] instantAppCookie = packageManagerCompat.getInstantAppCookie();
        if (instantAppCookie != null) {
            if (instantAppCookie.length == 0) {
                this.analytics.diagnosisLog("Get instantAppCookie alert", "Empty instantAppCookie");
                return fallbackCheckInCookie;
            }
            try {
                String str = new String(instantAppCookie, Charsets.UTF_8);
                JsonAdapter adapter = this.moshi.adapter(CheckInCookie.class);
                Intrinsics.checkNotNullExpressionValue(adapter, "this.adapter(T::class.java)");
                Object fromJson = adapter.fromJson(str);
                Intrinsics.checkNotNull(fromJson);
                Intrinsics.checkNotNullExpressionValue(fromJson, "moshi.adapter<CheckInCookie>().fromJson(string)!!");
                CheckInCookie checkInCookie = (CheckInCookie) fromJson;
                if (Intrinsics.areEqual(checkInCookie, new CheckInCookie(null, null, false, null, null, null, null, 127, null))) {
                    this.analytics.diagnosisLog("Get instantAppCookie alert", "Blank content");
                }
                return checkInCookie;
            } catch (Exception e) {
                Timber.e(e);
                this.analytics.diagnosisLog("Get instantAppCookie alert", "Malformed data");
                clearCookie$default(this, false, 1, null);
                return fallbackCheckInCookie;
            }
        } else {
            this.analytics.diagnosisLog("Get instantAppCookie alert", "Null returned");
            return fallbackCheckInCookie;
        }
    }

    private final void setCookie(CheckInCookie checkInCookie) {
        JsonAdapter adapter = this.moshi.adapter(CheckInCookie.class);
        Intrinsics.checkNotNullExpressionValue(adapter, "this.adapter(T::class.java)");
        String json = adapter.toJson(checkInCookie);
        Intrinsics.checkNotNullExpressionValue(json, "string");
        Charset charset = Charsets.UTF_8;
        Objects.requireNonNull(json, "null cannot be cast to non-null type java.lang.String");
        byte[] bytes = json.getBytes(charset);
        Intrinsics.checkNotNullExpressionValue(bytes, "(this as java.lang.String).getBytes(charset)");
        PackageManagerCompat packageManagerCompat = this.packageManager;
        Intrinsics.checkNotNullExpressionValue(packageManagerCompat, "packageManager");
        packageManagerCompat.setInstantAppCookie(bytes);
        this.sharedPreferences.setCheckInCookie(checkInCookie);
    }

    private final void editCookie(Function1<? super CheckInCookie, Unit> function1) {
        PackageManagerCompat packageManagerCompat = this.packageManager;
        Intrinsics.checkNotNullExpressionValue(packageManagerCompat, "packageManager");
        synchronized (packageManagerCompat) {
            CheckInCookie cookie = getCookie();
            function1.invoke(cookie);
            setCookie(cookie);
            Unit unit = Unit.INSTANCE;
        }
    }

    public static /* synthetic */ void clearCookie$default(CheckInRepository checkInRepository, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        checkInRepository.clearCookie(z);
    }

    public final void clearCookie(boolean z) {
        PackageManagerCompat packageManagerCompat = this.packageManager;
        Intrinsics.checkNotNullExpressionValue(packageManagerCompat, "packageManager");
        synchronized (packageManagerCompat) {
            PackageManagerCompat packageManagerCompat2 = this.packageManager;
            Intrinsics.checkNotNullExpressionValue(packageManagerCompat2, "packageManager");
            packageManagerCompat2.setInstantAppCookie(new byte[0]);
            if (!z) {
                this.sharedPreferences.clearCheckInCookie();
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    public final List<CheckIn> addPendingCheckIn(CheckIn checkIn) {
        Intrinsics.checkNotNullParameter(checkIn, ErrorBundle.DETAIL_ENTRY);
        editCookie(new CheckInRepository$addPendingCheckIn$1(checkIn));
        return getCookie().getPendingCheckIns();
    }

    public final boolean rememberHasCheckedIn() {
        boolean checkInAtLeastOnce = getCookie().getCheckInAtLeastOnce();
        editCookie(CheckInRepository$rememberHasCheckedIn$1.INSTANCE);
        return checkInAtLeastOnce;
    }

    public final boolean isCheckInPending(CheckIn checkIn) {
        T t;
        Intrinsics.checkNotNullParameter(checkIn, "checkInItem");
        Iterator<T> it = getCookie().getPendingCheckIns().iterator();
        while (true) {
            if (!it.hasNext()) {
                t = null;
                break;
            }
            t = it.next();
            if (Intrinsics.areEqual(t.getEventID(), checkIn.getEventID())) {
                break;
            }
        }
        return t != null;
    }

    /* access modifiers changed from: private */
    public final void clearPendingCheckIns() {
        editCookie(CheckInRepository$clearPendingCheckIns$1.INSTANCE);
    }

    public final void storeCheckInUserDetail(CheckIn checkIn) {
        Intrinsics.checkNotNullParameter(checkIn, "checkInItem");
        editCookie(new CheckInRepository$storeCheckInUserDetail$1(checkIn));
    }

    public final void clearCheckInUserDetail() {
        editCookie(CheckInRepository$clearCheckInUserDetail$1.INSTANCE);
    }

    public final void storeOrUpdateACheckInDependant(DependantCheckIn dependantCheckIn) {
        Intrinsics.checkNotNullParameter(dependantCheckIn, "dependantCheckIn");
        editCookie(new CheckInRepository$storeOrUpdateACheckInDependant$1(dependantCheckIn));
    }

    public final void deleteACheckInDependantIfExists(DependantCheckIn dependantCheckIn) {
        Intrinsics.checkNotNullParameter(dependantCheckIn, "dependantCheckIn");
        editCookie(new CheckInRepository$deleteACheckInDependantIfExists$1(dependantCheckIn));
    }

    public final String getStoredFirstName() {
        return getCookie().getCheckInFirstName();
    }

    public final String getStoredLastName() {
        return getCookie().getCheckInLastName();
    }

    public final String getStoredPhoneNumber() {
        return getCookie().getCheckInPhoneNumber();
    }

    public final PrimaryPersonCheckIn getPrimaryPersonCheckIn(CheckInUtils.CheckInCode checkInCode) {
        String storedLastName;
        String storedPhoneNumber;
        Intrinsics.checkNotNullParameter(checkInCode, "checkInCode");
        String storedFirstName = getStoredFirstName();
        if (storedFirstName == null || (storedLastName = getStoredLastName()) == null || (storedPhoneNumber = getStoredPhoneNumber()) == null || StringsKt.isBlank(storedFirstName) || StringsKt.isBlank(storedLastName) || StringsKt.isBlank(storedPhoneNumber)) {
            return null;
        }
        Calendar instance = Calendar.getInstance();
        Intrinsics.checkNotNullExpressionValue(instance, "Calendar.getInstance()");
        Date time = instance.getTime();
        String uuid = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(uuid, "UUID.randomUUID().toString()");
        return new PrimaryPersonCheckIn(new CheckIn(checkInCode.getPayload(), storedFirstName, storedLastName, storedPhoneNumber, time, uuid, null, null, Opcodes.CHECKCAST, null), checkInCode, true);
    }

    public final List<DependantCheckIn> getSavedDependants() {
        return getCookie().getCheckInDependants();
    }

    public final void refreshActiveCheckIn() {
        this.activeCheckIn.setValue(getActiveCheckIn());
    }

    public final boolean isActiveCheckIn(CheckIn checkIn) {
        Intrinsics.checkNotNullParameter(checkIn, "checkInItem");
        refreshActiveCheckIn();
        String eventID = checkIn.getEventID();
        if (eventID != null) {
            CheckIn value = this.activeCheckIn.getValue();
            if (Intrinsics.areEqual(eventID, value != null ? value.getEventID() : null)) {
                return true;
            }
        }
        return false;
    }

    private final Single<AttestationJwt> getAttestation() {
        Single<AttestationJwt> just;
        AttestationJwt storedAttestationJwt = getStoredAttestationJwt();
        if (storedAttestationJwt != null && (just = Single.just(storedAttestationJwt)) != null) {
            return just;
        }
        CheckInRepository checkInRepository = this;
        byte[] nonce = checkInRepository.getNonce();
        if (nonce != null) {
            Single<AttestationJwt> create = Single.create(new CheckInRepository$getAttestation$2$1(checkInRepository, nonce));
            Intrinsics.checkNotNullExpressionValue(create, "run {\n                va…          }\n            }");
            return create;
        }
        Single<AttestationJwt> error = Single.error(new Error("Fail to get nonce."));
        Intrinsics.checkNotNullExpressionValue(error, "Single.error(Error(\"Fail to get nonce.\"))");
        return error;
    }

    public final Completable uploadCheckIns() {
        Completable observeOn = getAttestation().subscribeOn(this.sequentialScheduler).onErrorResumeNext(CheckInRepository$uploadCheckIns$1.INSTANCE).flatMapCompletable(new CheckInRepository$uploadCheckIns$2(this)).observeOn(AndroidSchedulers.mainThread());
        Intrinsics.checkNotNullExpressionValue(observeOn, "getAttestation()\n       …dSchedulers.mainThread())");
        return observeOn;
    }

    /* access modifiers changed from: private */
    public final Completable postCheckIns(String str) {
        CheckInSubmissionPayload checkInSubmissionPayload = new CheckInSubmissionPayload(getCookie().getPendingCheckIns(), new CheckInAuth(AbstractSpiCall.ANDROID_CLIENT_TYPE, new CheckInAuthToken(str)));
        if (checkInSubmissionPayload.getCheckIns().isEmpty()) {
            Completable complete = Completable.complete();
            Intrinsics.checkNotNullExpressionValue(complete, "Completable.complete()");
            return complete;
        }
        Completable doOnError = this.checkInApi.postCheckIn(BuildConfig.CHECK_IN_API_KEY, checkInSubmissionPayload).timeout(30, TimeUnit.SECONDS).observeOn(AndroidSchedulers.mainThread()).doOnComplete(new CheckInRepository$postCheckIns$1(this)).doOnError(CheckInRepository$postCheckIns$2.INSTANCE);
        Intrinsics.checkNotNullExpressionValue(doOnError, "checkInApi\n            .…imber.e(it)\n            }");
        return doOnError;
    }

    private final CheckIn getActiveCheckIn() {
        T t;
        try {
            Iterator<T> it = getCheckInShortcuts().getHistoryItems().iterator();
            while (true) {
                if (!it.hasNext()) {
                    t = null;
                    break;
                }
                t = it.next();
                if (!t.isHidden()) {
                    break;
                }
            }
            T t2 = t;
            if (t2 == null) {
                return null;
            }
            CheckIn component1 = t2.component1();
            Date date = component1.getDate();
            Intrinsics.checkNotNull(date);
            long time = date.getTime();
            Calendar instance = Calendar.getInstance();
            Intrinsics.checkNotNullExpressionValue(instance, "Calendar.getInstance()");
            Date time2 = instance.getTime();
            Intrinsics.checkNotNullExpressionValue(time2, "Calendar.getInstance().time");
            if (TimeUnit.MILLISECONDS.toHours(time2.getTime() - time) >= ((long) 2)) {
                return null;
            }
            return component1;
        } catch (Exception e) {
            Timber.e(e);
            return null;
        }
    }

    private final byte[] getNonce() {
        return getRequestNonce(UUID.randomUUID().toString() + System.currentTimeMillis());
    }

    private final byte[] getRequestNonce(String str) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[24];
        this.secureRandom.nextBytes(bArr);
        try {
            byteArrayOutputStream.write(bArr);
            Charset charset = Charsets.UTF_8;
            if (str != null) {
                byte[] bytes = str.getBytes(charset);
                Intrinsics.checkNotNullExpressionValue(bytes, "(this as java.lang.String).getBytes(charset)");
                byteArrayOutputStream.write(bytes);
                return byteArrayOutputStream.toByteArray();
            }
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        } catch (IOException unused) {
            return null;
        }
    }

    /* access modifiers changed from: private */
    public final void storeAttestationJwt(AttestationJwt attestationJwt) {
        try {
            editCookie(new CheckInRepository$storeAttestationJwt$1(attestationJwt));
        } catch (Exception e) {
            Timber.e(e);
        }
    }

    private final AttestationJwt getStoredAttestationJwt() {
        try {
            AttestationJwt attestation = getCookie().getAttestation();
            if (attestation == null) {
                return null;
            }
            long time = attestation.getCreationDate().getTime();
            Calendar instance = Calendar.getInstance();
            Intrinsics.checkNotNullExpressionValue(instance, "Calendar.getInstance()");
            Date time2 = instance.getTime();
            Intrinsics.checkNotNullExpressionValue(time2, "Calendar.getInstance().time");
            boolean z = TimeUnit.MILLISECONDS.toMinutes(time2.getTime() - time) >= ((long) 5);
            if (z) {
                clearAttestationJwt();
            }
            if (z) {
                return null;
            }
            return attestation;
        } catch (Exception e) {
            Timber.e(e);
            return null;
        }
    }

    private final void clearAttestationJwt() {
        editCookie(CheckInRepository$clearAttestationJwt$1.INSTANCE);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/digitalwallet/viewmodel/checkIn/checkInRepository/CheckInRepository$Companion;", "", "()V", "ATTESTATION_JWT_VALID_DURATION_MINUTES", "", "base_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
    /* compiled from: CheckInRepository.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}
