package androidx.navigation.ui;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.customview.widget.Openable;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.NavGraph;
import androidx.navigation.NavOptions;
import androidx.navigation.ui.AppBarConfiguration;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.navigation.NavigationView;
import java.lang.ref.WeakReference;
import java.util.Set;

public final class NavigationUI {
    private NavigationUI() {
    }

    public static boolean onNavDestinationSelected(MenuItem menuItem, NavController navController) {
        NavOptions.Builder popExitAnim = new NavOptions.Builder().setLaunchSingleTop(true).setEnterAnim(R.animator.nav_default_enter_anim).setExitAnim(R.animator.nav_default_exit_anim).setPopEnterAnim(R.animator.nav_default_pop_enter_anim).setPopExitAnim(R.animator.nav_default_pop_exit_anim);
        if ((menuItem.getOrder() & 196608) == 0) {
            popExitAnim.setPopUpTo(findStartDestination(navController.getGraph()).getId(), false);
        }
        try {
            navController.navigate(menuItem.getItemId(), (Bundle) null, popExitAnim.build());
            return true;
        } catch (IllegalArgumentException unused) {
            return false;
        }
    }

    public static boolean navigateUp(NavController navController, Openable openable) {
        return navigateUp(navController, new AppBarConfiguration.Builder(navController.getGraph()).setOpenableLayout(openable).build());
    }

    public static boolean navigateUp(NavController navController, AppBarConfiguration appBarConfiguration) {
        Openable openableLayout = appBarConfiguration.getOpenableLayout();
        NavDestination currentDestination = navController.getCurrentDestination();
        Set<Integer> topLevelDestinations = appBarConfiguration.getTopLevelDestinations();
        if (openableLayout != null && currentDestination != null && matchDestinations(currentDestination, topLevelDestinations)) {
            openableLayout.open();
            return true;
        } else if (navController.navigateUp()) {
            return true;
        } else {
            if (appBarConfiguration.getFallbackOnNavigateUpListener() != null) {
                return appBarConfiguration.getFallbackOnNavigateUpListener().onNavigateUp();
            }
            return false;
        }
    }

    public static void setupActionBarWithNavController(AppCompatActivity appCompatActivity, NavController navController) {
        setupActionBarWithNavController(appCompatActivity, navController, new AppBarConfiguration.Builder(navController.getGraph()).build());
    }

    public static void setupActionBarWithNavController(AppCompatActivity appCompatActivity, NavController navController, Openable openable) {
        setupActionBarWithNavController(appCompatActivity, navController, new AppBarConfiguration.Builder(navController.getGraph()).setOpenableLayout(openable).build());
    }

    public static void setupActionBarWithNavController(AppCompatActivity appCompatActivity, NavController navController, AppBarConfiguration appBarConfiguration) {
        navController.addOnDestinationChangedListener(new ActionBarOnDestinationChangedListener(appCompatActivity, appBarConfiguration));
    }

    public static void setupWithNavController(Toolbar toolbar, NavController navController) {
        setupWithNavController(toolbar, navController, new AppBarConfiguration.Builder(navController.getGraph()).build());
    }

    public static void setupWithNavController(Toolbar toolbar, NavController navController, Openable openable) {
        setupWithNavController(toolbar, navController, new AppBarConfiguration.Builder(navController.getGraph()).setOpenableLayout(openable).build());
    }

    public static void setupWithNavController(Toolbar toolbar, final NavController navController, final AppBarConfiguration appBarConfiguration) {
        navController.addOnDestinationChangedListener(new ToolbarOnDestinationChangedListener(toolbar, appBarConfiguration));
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            /* class androidx.navigation.ui.NavigationUI.AnonymousClass1 */

            public void onClick(View view) {
                NavigationUI.navigateUp(NavController.this, appBarConfiguration);
            }
        });
    }

    public static void setupWithNavController(CollapsingToolbarLayout collapsingToolbarLayout, Toolbar toolbar, NavController navController) {
        setupWithNavController(collapsingToolbarLayout, toolbar, navController, new AppBarConfiguration.Builder(navController.getGraph()).build());
    }

    public static void setupWithNavController(CollapsingToolbarLayout collapsingToolbarLayout, Toolbar toolbar, NavController navController, Openable openable) {
        setupWithNavController(collapsingToolbarLayout, toolbar, navController, new AppBarConfiguration.Builder(navController.getGraph()).setOpenableLayout(openable).build());
    }

    public static void setupWithNavController(CollapsingToolbarLayout collapsingToolbarLayout, Toolbar toolbar, final NavController navController, final AppBarConfiguration appBarConfiguration) {
        navController.addOnDestinationChangedListener(new CollapsingToolbarOnDestinationChangedListener(collapsingToolbarLayout, toolbar, appBarConfiguration));
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            /* class androidx.navigation.ui.NavigationUI.AnonymousClass2 */

            public void onClick(View view) {
                NavigationUI.navigateUp(NavController.this, appBarConfiguration);
            }
        });
    }

    public static void setupWithNavController(final NavigationView navigationView, final NavController navController) {
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            /* class androidx.navigation.ui.NavigationUI.AnonymousClass3 */

            @Override // com.google.android.material.navigation.NavigationView.OnNavigationItemSelectedListener
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                boolean onNavDestinationSelected = NavigationUI.onNavDestinationSelected(menuItem, NavController.this);
                if (onNavDestinationSelected) {
                    ViewParent parent = navigationView.getParent();
                    if (parent instanceof Openable) {
                        ((Openable) parent).close();
                    } else {
                        BottomSheetBehavior findBottomSheetBehavior = NavigationUI.findBottomSheetBehavior(navigationView);
                        if (findBottomSheetBehavior != null) {
                            findBottomSheetBehavior.setState(5);
                        }
                    }
                }
                return onNavDestinationSelected;
            }
        });
        final WeakReference weakReference = new WeakReference(navigationView);
        navController.addOnDestinationChangedListener(new NavController.OnDestinationChangedListener() {
            /* class androidx.navigation.ui.NavigationUI.AnonymousClass4 */

            @Override // androidx.navigation.NavController.OnDestinationChangedListener
            public void onDestinationChanged(NavController navController, NavDestination navDestination, Bundle bundle) {
                NavigationView navigationView = (NavigationView) weakReference.get();
                if (navigationView == null) {
                    navController.removeOnDestinationChangedListener(this);
                    return;
                }
                Menu menu = navigationView.getMenu();
                int size = menu.size();
                for (int i = 0; i < size; i++) {
                    MenuItem item = menu.getItem(i);
                    item.setChecked(NavigationUI.matchDestination(navDestination, item.getItemId()));
                }
            }
        });
    }

    static BottomSheetBehavior findBottomSheetBehavior(View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof CoordinatorLayout.LayoutParams)) {
            ViewParent parent = view.getParent();
            if (parent instanceof View) {
                return findBottomSheetBehavior((View) parent);
            }
            return null;
        }
        CoordinatorLayout.Behavior behavior = ((CoordinatorLayout.LayoutParams) layoutParams).getBehavior();
        if (!(behavior instanceof BottomSheetBehavior)) {
            return null;
        }
        return (BottomSheetBehavior) behavior;
    }

    public static void setupWithNavController(BottomNavigationView bottomNavigationView, final NavController navController) {
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            /* class androidx.navigation.ui.NavigationUI.AnonymousClass5 */

            @Override // com.google.android.material.bottomnavigation.BottomNavigationView.OnNavigationItemSelectedListener
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                return NavigationUI.onNavDestinationSelected(menuItem, NavController.this);
            }
        });
        final WeakReference weakReference = new WeakReference(bottomNavigationView);
        navController.addOnDestinationChangedListener(new NavController.OnDestinationChangedListener() {
            /* class androidx.navigation.ui.NavigationUI.AnonymousClass6 */

            @Override // androidx.navigation.NavController.OnDestinationChangedListener
            public void onDestinationChanged(NavController navController, NavDestination navDestination, Bundle bundle) {
                BottomNavigationView bottomNavigationView = (BottomNavigationView) weakReference.get();
                if (bottomNavigationView == null) {
                    navController.removeOnDestinationChangedListener(this);
                    return;
                }
                Menu menu = bottomNavigationView.getMenu();
                int size = menu.size();
                for (int i = 0; i < size; i++) {
                    MenuItem item = menu.getItem(i);
                    if (NavigationUI.matchDestination(navDestination, item.getItemId())) {
                        item.setChecked(true);
                    }
                }
            }
        });
    }

    static boolean matchDestination(NavDestination navDestination, int i) {
        while (navDestination.getId() != i && navDestination.getParent() != null) {
            navDestination = navDestination.getParent();
        }
        return navDestination.getId() == i;
    }

    static boolean matchDestinations(NavDestination navDestination, Set<Integer> set) {
        while (!set.contains(Integer.valueOf(navDestination.getId()))) {
            navDestination = navDestination.getParent();
            if (navDestination == null) {
                return false;
            }
        }
        return true;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:5:? */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [androidx.navigation.NavGraph] */
    /* JADX WARN: Type inference failed for: r1v1, types: [androidx.navigation.NavDestination] */
    static NavDestination findStartDestination(NavGraph navGraph) {
        while (navGraph instanceof NavGraph) {
            NavGraph navGraph2 = (NavGraph) navGraph;
            navGraph = navGraph2.findNode(navGraph2.getStartDestination());
        }
        return navGraph;
    }
}
