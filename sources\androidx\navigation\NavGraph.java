package androidx.navigation;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.collection.SparseArrayCompat;
import androidx.navigation.NavDestination;
import androidx.navigation.common.R;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class NavGraph extends NavDestination implements Iterable<NavDestination> {
    final SparseArrayCompat<NavDestination> mNodes = new SparseArrayCompat<>();
    private int mStartDestId;
    private String mStartDestIdName;

    public NavGraph(Navigator<? extends NavGraph> navigator) {
        super(navigator);
    }

    @Override // androidx.navigation.NavDestination
    public void onInflate(Context context, AttributeSet attributeSet) {
        super.onInflate(context, attributeSet);
        TypedArray obtainAttributes = context.getResources().obtainAttributes(attributeSet, R.styleable.NavGraphNavigator);
        setStartDestination(obtainAttributes.getResourceId(R.styleable.NavGraphNavigator_startDestination, 0));
        this.mStartDestIdName = getDisplayName(context, this.mStartDestId);
        obtainAttributes.recycle();
    }

    /* access modifiers changed from: package-private */
    @Override // androidx.navigation.NavDestination
    public NavDestination.DeepLinkMatch matchDeepLink(NavDeepLinkRequest navDeepLinkRequest) {
        NavDestination.DeepLinkMatch matchDeepLink = super.matchDeepLink(navDeepLinkRequest);
        Iterator<NavDestination> it = iterator();
        while (it.hasNext()) {
            NavDestination.DeepLinkMatch matchDeepLink2 = it.next().matchDeepLink(navDeepLinkRequest);
            if (matchDeepLink2 != null && (matchDeepLink == null || matchDeepLink2.compareTo(matchDeepLink) > 0)) {
                matchDeepLink = matchDeepLink2;
            }
        }
        return matchDeepLink;
    }

    public final void addDestination(NavDestination navDestination) {
        if (navDestination.getId() != 0) {
            NavDestination navDestination2 = this.mNodes.get(navDestination.getId());
            if (navDestination2 != navDestination) {
                if (navDestination.getParent() == null) {
                    if (navDestination2 != null) {
                        navDestination2.setParent(null);
                    }
                    navDestination.setParent(this);
                    this.mNodes.put(navDestination.getId(), navDestination);
                    return;
                }
                throw new IllegalStateException("Destination already has a parent set. Call NavGraph.remove() to remove the previous parent.");
            }
            return;
        }
        throw new IllegalArgumentException("Destinations must have an id. Call setId() or include an android:id in your navigation XML.");
    }

    public final void addDestinations(Collection<NavDestination> collection) {
        for (NavDestination navDestination : collection) {
            if (navDestination != null) {
                addDestination(navDestination);
            }
        }
    }

    public final void addDestinations(NavDestination... navDestinationArr) {
        for (NavDestination navDestination : navDestinationArr) {
            if (navDestination != null) {
                addDestination(navDestination);
            }
        }
    }

    public final NavDestination findNode(int i) {
        return findNode(i, true);
    }

    /* access modifiers changed from: package-private */
    public final NavDestination findNode(int i, boolean z) {
        NavDestination navDestination = this.mNodes.get(i);
        if (navDestination != null) {
            return navDestination;
        }
        if (!z || getParent() == null) {
            return null;
        }
        return getParent().findNode(i);
    }

    @Override // java.lang.Iterable
    public final Iterator<NavDestination> iterator() {
        return new Iterator<NavDestination>() {
            /* class androidx.navigation.NavGraph.AnonymousClass1 */
            private int mIndex = -1;
            private boolean mWentToNext = false;

            public boolean hasNext() {
                return this.mIndex + 1 < NavGraph.this.mNodes.size();
            }

            @Override // java.util.Iterator
            public NavDestination next() {
                if (hasNext()) {
                    this.mWentToNext = true;
                    SparseArrayCompat<NavDestination> sparseArrayCompat = NavGraph.this.mNodes;
                    int i = this.mIndex + 1;
                    this.mIndex = i;
                    return sparseArrayCompat.valueAt(i);
                }
                throw new NoSuchElementException();
            }

            public void remove() {
                if (this.mWentToNext) {
                    NavGraph.this.mNodes.valueAt(this.mIndex).setParent(null);
                    NavGraph.this.mNodes.removeAt(this.mIndex);
                    this.mIndex--;
                    this.mWentToNext = false;
                    return;
                }
                throw new IllegalStateException("You must call next() before you can remove an element");
            }
        };
    }

    public final void addAll(NavGraph navGraph) {
        Iterator<NavDestination> it = navGraph.iterator();
        while (it.hasNext()) {
            it.remove();
            addDestination(it.next());
        }
    }

    public final void remove(NavDestination navDestination) {
        int indexOfKey = this.mNodes.indexOfKey(navDestination.getId());
        if (indexOfKey >= 0) {
            this.mNodes.valueAt(indexOfKey).setParent(null);
            this.mNodes.removeAt(indexOfKey);
        }
    }

    public final void clear() {
        Iterator<NavDestination> it = iterator();
        while (it.hasNext()) {
            it.next();
            it.remove();
        }
    }

    @Override // androidx.navigation.NavDestination
    public String getDisplayName() {
        return getId() != 0 ? super.getDisplayName() : "the root navigation";
    }

    public final int getStartDestination() {
        return this.mStartDestId;
    }

    public final void setStartDestination(int i) {
        this.mStartDestId = i;
        this.mStartDestIdName = null;
    }

    /* access modifiers changed from: package-private */
    public String getStartDestDisplayName() {
        if (this.mStartDestIdName == null) {
            this.mStartDestIdName = Integer.toString(this.mStartDestId);
        }
        return this.mStartDestIdName;
    }

    @Override // androidx.navigation.NavDestination
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append(" startDestination=");
        NavDestination findNode = findNode(getStartDestination());
        if (findNode == null) {
            String str = this.mStartDestIdName;
            if (str == null) {
                sb.append("0x");
                sb.append(Integer.toHexString(this.mStartDestId));
            } else {
                sb.append(str);
            }
        } else {
            sb.append("{");
            sb.append(findNode.toString());
            sb.append("}");
        }
        return sb.toString();
    }
}
