package androidx.navigation;

import android.os.Bundle;
import androidx.core.app.NotificationCompat;
import androidx.navigation.Navigator;

@Navigator.Name(NotificationCompat.CATEGORY_NAVIGATION)
public class NavGraphNavigator extends Navigator<NavGraph> {
    private final NavigatorProvider mNavigatorProvider;

    @Override // androidx.navigation.Navigator
    public boolean popBackStack() {
        return true;
    }

    public NavGraphNavigator(NavigatorProvider navigatorProvider) {
        this.mNavigatorProvider = navigatorProvider;
    }

    @Override // androidx.navigation.Navigator
    public NavGraph createDestination() {
        return new NavGraph(this);
    }

    public NavDestination navigate(NavGraph navGraph, Bundle bundle, NavOptions navOptions, Navigator.Extras extras) {
        int startDestination = navGraph.getStartDestination();
        if (startDestination != 0) {
            NavDestination findNode = navGraph.findNode(startDestination, false);
            if (findNode != null) {
                return this.mNavigatorProvider.getNavigator(findNode.getNavigatorName()).navigate(findNode, findNode.addInDefaultArgs(bundle), navOptions, extras);
            }
            String startDestDisplayName = navGraph.getStartDestDisplayName();
            throw new IllegalArgumentException("navigation destination " + startDestDisplayName + " is not a direct child of this NavGraph");
        }
        throw new IllegalStateException("no start destination defined via app:startDestination for " + navGraph.getDisplayName());
    }
}
