package androidx.preference;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\r\n\u0002\b\u0004\n\u0002\u0010)\n\u0002\b\u0003\u001a\u0015\u0010\n\u001a\u00020\u000b*\u00020\u00032\u0006\u0010\f\u001a\u00020\u0002H\u0002\u001a0\u0010\r\u001a\u00020\u000e*\u00020\u00032!\u0010\u000f\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\u000e0\u0010H\b\u001aE\u0010\u0013\u001a\u00020\u000e*\u00020\u000326\u0010\u000f\u001a2\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0015\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\u000e0\u0014H\b\u001a&\u0010\u0016\u001a\u0004\u0018\u0001H\u0017\"\b\b\u0000\u0010\u0017*\u00020\u0002*\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u0019H\n¢\u0006\u0002\u0010\u001a\u001a\u0015\u0010\u0016\u001a\u00020\u0002*\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0007H\u0002\u001a\r\u0010\u001b\u001a\u00020\u000b*\u00020\u0003H\b\u001a\r\u0010\u001c\u001a\u00020\u000b*\u00020\u0003H\b\u001a\u0013\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00020\u001e*\u00020\u0003H\u0002\u001a\u0015\u0010\u001f\u001a\u00020\u000e*\u00020\u00032\u0006\u0010\f\u001a\u00020\u0002H\n\u001a\u0015\u0010 \u001a\u00020\u000e*\u00020\u00032\u0006\u0010\f\u001a\u00020\u0002H\n\"\u001b\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005\"\u0016\u0010\u0006\u001a\u00020\u0007*\u00020\u00038Æ\u0002¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006!"}, d2 = {"children", "Lkotlin/sequences/Sequence;", "Landroidx/preference/Preference;", "Landroidx/preference/PreferenceGroup;", "getChildren", "(Landroidx/preference/PreferenceGroup;)Lkotlin/sequences/Sequence;", "size", "", "getSize", "(Landroidx/preference/PreferenceGroup;)I", "contains", "", "preference", "forEach", "", "action", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "forEachIndexed", "Lkotlin/Function2;", FirebaseAnalytics.Param.INDEX, "get", "T", "key", "", "(Landroidx/preference/PreferenceGroup;Ljava/lang/CharSequence;)Landroidx/preference/Preference;", "isEmpty", "isNotEmpty", "iterator", "", "minusAssign", "plusAssign", "preference-ktx_release"}, k = 2, mv = {1, 1, 15})
/* compiled from: PreferenceGroup.kt */
public final class PreferenceGroupKt {
    public static final <T extends Preference> T get(PreferenceGroup preferenceGroup, CharSequence charSequence) {
        Intrinsics.checkParameterIsNotNull(preferenceGroup, "$this$get");
        Intrinsics.checkParameterIsNotNull(charSequence, "key");
        return (T) preferenceGroup.findPreference(charSequence);
    }

    public static final Preference get(PreferenceGroup preferenceGroup, int i) {
        Intrinsics.checkParameterIsNotNull(preferenceGroup, "$this$get");
        Preference preference = preferenceGroup.getPreference(i);
        if (preference != null) {
            return preference;
        }
        throw new IndexOutOfBoundsException("Index: " + i + ", Size: " + preferenceGroup.getPreferenceCount());
    }

    public static final boolean contains(PreferenceGroup preferenceGroup, Preference preference) {
        Intrinsics.checkParameterIsNotNull(preferenceGroup, "$this$contains");
        Intrinsics.checkParameterIsNotNull(preference, "preference");
        int preferenceCount = preferenceGroup.getPreferenceCount();
        for (int i = 0; i < preferenceCount; i++) {
            if (Intrinsics.areEqual(preferenceGroup.getPreference(i), preference)) {
                return true;
            }
        }
        return false;
    }

    public static final void plusAssign(PreferenceGroup preferenceGroup, Preference preference) {
        Intrinsics.checkParameterIsNotNull(preferenceGroup, "$this$plusAssign");
        Intrinsics.checkParameterIsNotNull(preference, "preference");
        preferenceGroup.addPreference(preference);
    }

    public static final void minusAssign(PreferenceGroup preferenceGroup, Preference preference) {
        Intrinsics.checkParameterIsNotNull(preferenceGroup, "$this$minusAssign");
        Intrinsics.checkParameterIsNotNull(preference, "preference");
        preferenceGroup.removePreference(preference);
    }

    public static final int getSize(PreferenceGroup preferenceGroup) {
        Intrinsics.checkParameterIsNotNull(preferenceGroup, "$this$size");
        return preferenceGroup.getPreferenceCount();
    }

    public static final void forEach(PreferenceGroup preferenceGroup, Function1<? super Preference, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(preferenceGroup, "$this$forEach");
        Intrinsics.checkParameterIsNotNull(function1, "action");
        int preferenceCount = preferenceGroup.getPreferenceCount();
        for (int i = 0; i < preferenceCount; i++) {
            function1.invoke(get(preferenceGroup, i));
        }
    }

    public static final void forEachIndexed(PreferenceGroup preferenceGroup, Function2<? super Integer, ? super Preference, Unit> function2) {
        Intrinsics.checkParameterIsNotNull(preferenceGroup, "$this$forEachIndexed");
        Intrinsics.checkParameterIsNotNull(function2, "action");
        int preferenceCount = preferenceGroup.getPreferenceCount();
        for (int i = 0; i < preferenceCount; i++) {
            function2.invoke(Integer.valueOf(i), get(preferenceGroup, i));
        }
    }

    public static final Iterator<Preference> iterator(PreferenceGroup preferenceGroup) {
        Intrinsics.checkParameterIsNotNull(preferenceGroup, "$this$iterator");
        return new PreferenceGroupKt$iterator$1(preferenceGroup);
    }

    public static final Sequence<Preference> getChildren(PreferenceGroup preferenceGroup) {
        Intrinsics.checkParameterIsNotNull(preferenceGroup, "$this$children");
        return new PreferenceGroupKt$children$1(preferenceGroup);
    }

    public static final boolean isEmpty(PreferenceGroup preferenceGroup) {
        Intrinsics.checkParameterIsNotNull(preferenceGroup, "$this$isEmpty");
        return preferenceGroup.getPreferenceCount() == 0;
    }

    public static final boolean isNotEmpty(PreferenceGroup preferenceGroup) {
        Intrinsics.checkParameterIsNotNull(preferenceGroup, "$this$isNotEmpty");
        return preferenceGroup.getPreferenceCount() != 0;
    }
}
