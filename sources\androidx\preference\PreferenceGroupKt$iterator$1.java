package androidx.preference;

import com.google.android.gms.analytics.ecommerce.ProductAction;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.markers.KMutableIterator;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000#\n\u0000\n\u0002\u0010)\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\t\u0010\u0005\u001a\u00020\u0006H\u0002J\t\u0010\u0007\u001a\u00020\u0002H\u0002J\b\u0010\b\u001a\u00020\tH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"androidx/preference/PreferenceGroupKt$iterator$1", "", "Landroidx/preference/Preference;", FirebaseAnalytics.Param.INDEX, "", "hasNext", "", "next", ProductAction.ACTION_REMOVE, "", "preference-ktx_release"}, k = 1, mv = {1, 1, 15})
/* compiled from: PreferenceGroup.kt */
public final class PreferenceGroupKt$iterator$1 implements Iterator<Preference>, KMutableIterator {
    final /* synthetic */ PreferenceGroup $this_iterator;
    private int index;

    PreferenceGroupKt$iterator$1(PreferenceGroup preferenceGroup) {
        this.$this_iterator = preferenceGroup;
    }

    public boolean hasNext() {
        return this.index < this.$this_iterator.getPreferenceCount();
    }

    @Override // java.util.Iterator
    public Preference next() {
        PreferenceGroup preferenceGroup = this.$this_iterator;
        int i = this.index;
        this.index = i + 1;
        Preference preference = preferenceGroup.getPreference(i);
        if (preference != null) {
            return preference;
        }
        throw new IndexOutOfBoundsException();
    }

    public void remove() {
        PreferenceGroup preferenceGroup = this.$this_iterator;
        int i = this.index - 1;
        this.index = i;
        preferenceGroup.removePreference(preferenceGroup.getPreference(i));
    }
}
