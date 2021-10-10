package androidx.navigation;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import androidx.lifecycle.AbstractSavedStateViewModelFactory;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.SavedStateViewModelFactory;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.SavedStateRegistryController;
import androidx.savedstate.SavedStateRegistryOwner;
import java.util.UUID;

public final class NavBackStackEntry implements LifecycleOwner, ViewModelStoreOwner, HasDefaultViewModelProviderFactory, SavedStateRegistryOwner {
    private Bundle mArgs;
    private final Context mContext;
    private ViewModelProvider.Factory mDefaultFactory;
    private final NavDestination mDestination;
    private Lifecycle.State mHostLifecycle;
    final UUID mId;
    private final LifecycleRegistry mLifecycle;
    private Lifecycle.State mMaxLifecycle;
    private NavControllerViewModel mNavControllerViewModel;
    private SavedStateHandle mSavedStateHandle;
    private final SavedStateRegistryController mSavedStateRegistryController;

    NavBackStackEntry(Context context, NavDestination navDestination, Bundle bundle, LifecycleOwner lifecycleOwner, NavControllerViewModel navControllerViewModel) {
        this(context, navDestination, bundle, lifecycleOwner, navControllerViewModel, UUID.randomUUID(), null);
    }

    NavBackStackEntry(Context context, NavDestination navDestination, Bundle bundle, LifecycleOwner lifecycleOwner, NavControllerViewModel navControllerViewModel, UUID uuid, Bundle bundle2) {
        this.mLifecycle = new LifecycleRegistry(this);
        SavedStateRegistryController create = SavedStateRegistryController.create(this);
        this.mSavedStateRegistryController = create;
        this.mHostLifecycle = Lifecycle.State.CREATED;
        this.mMaxLifecycle = Lifecycle.State.RESUMED;
        this.mContext = context;
        this.mId = uuid;
        this.mDestination = navDestination;
        this.mArgs = bundle;
        this.mNavControllerViewModel = navControllerViewModel;
        create.performRestore(bundle2);
        if (lifecycleOwner != null) {
            this.mHostLifecycle = lifecycleOwner.getLifecycle().getCurrentState();
        }
    }

    public NavDestination getDestination() {
        return this.mDestination;
    }

    public Bundle getArguments() {
        return this.mArgs;
    }

    /* access modifiers changed from: package-private */
    public void replaceArguments(Bundle bundle) {
        this.mArgs = bundle;
    }

    @Override // androidx.lifecycle.LifecycleOwner
    public Lifecycle getLifecycle() {
        return this.mLifecycle;
    }

    /* access modifiers changed from: package-private */
    public void setMaxLifecycle(Lifecycle.State state) {
        this.mMaxLifecycle = state;
        updateState();
    }

    /* access modifiers changed from: package-private */
    public Lifecycle.State getMaxLifecycle() {
        return this.mMaxLifecycle;
    }

    /* access modifiers changed from: package-private */
    public void handleLifecycleEvent(Lifecycle.Event event) {
        this.mHostLifecycle = getStateAfter(event);
        updateState();
    }

    /* access modifiers changed from: package-private */
    public void updateState() {
        if (this.mHostLifecycle.ordinal() < this.mMaxLifecycle.ordinal()) {
            this.mLifecycle.setCurrentState(this.mHostLifecycle);
        } else {
            this.mLifecycle.setCurrentState(this.mMaxLifecycle);
        }
    }

    @Override // androidx.lifecycle.ViewModelStoreOwner
    public ViewModelStore getViewModelStore() {
        NavControllerViewModel navControllerViewModel = this.mNavControllerViewModel;
        if (navControllerViewModel != null) {
            return navControllerViewModel.getViewModelStore(this.mId);
        }
        throw new IllegalStateException("You must call setViewModelStore() on your NavHostController before accessing the ViewModelStore of a navigation graph.");
    }

    @Override // androidx.lifecycle.HasDefaultViewModelProviderFactory
    public ViewModelProvider.Factory getDefaultViewModelProviderFactory() {
        if (this.mDefaultFactory == null) {
            this.mDefaultFactory = new SavedStateViewModelFactory((Application) this.mContext.getApplicationContext(), this, this.mArgs);
        }
        return this.mDefaultFactory;
    }

    @Override // androidx.savedstate.SavedStateRegistryOwner
    public SavedStateRegistry getSavedStateRegistry() {
        return this.mSavedStateRegistryController.getSavedStateRegistry();
    }

    /* access modifiers changed from: package-private */
    public void saveState(Bundle bundle) {
        this.mSavedStateRegistryController.performSave(bundle);
    }

    public SavedStateHandle getSavedStateHandle() {
        if (this.mSavedStateHandle == null) {
            this.mSavedStateHandle = ((SavedStateViewModel) new ViewModelProvider(this, new NavResultSavedStateFactory(this, null)).get(SavedStateViewModel.class)).getHandle();
        }
        return this.mSavedStateHandle;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: androidx.navigation.NavBackStackEntry$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$androidx$lifecycle$Lifecycle$Event;

        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|1|2|3|4|5|6|7|8|9|10|11|12|(3:13|14|16)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(16:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|16) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            int[] iArr = new int[Lifecycle.Event.values().length];
            $SwitchMap$androidx$lifecycle$Lifecycle$Event = iArr;
            iArr[Lifecycle.Event.ON_CREATE.ordinal()] = 1;
            $SwitchMap$androidx$lifecycle$Lifecycle$Event[Lifecycle.Event.ON_STOP.ordinal()] = 2;
            $SwitchMap$androidx$lifecycle$Lifecycle$Event[Lifecycle.Event.ON_START.ordinal()] = 3;
            $SwitchMap$androidx$lifecycle$Lifecycle$Event[Lifecycle.Event.ON_PAUSE.ordinal()] = 4;
            $SwitchMap$androidx$lifecycle$Lifecycle$Event[Lifecycle.Event.ON_RESUME.ordinal()] = 5;
            $SwitchMap$androidx$lifecycle$Lifecycle$Event[Lifecycle.Event.ON_DESTROY.ordinal()] = 6;
            try {
                $SwitchMap$androidx$lifecycle$Lifecycle$Event[Lifecycle.Event.ON_ANY.ordinal()] = 7;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    private static Lifecycle.State getStateAfter(Lifecycle.Event event) {
        switch (AnonymousClass1.$SwitchMap$androidx$lifecycle$Lifecycle$Event[event.ordinal()]) {
            case 1:
            case 2:
                return Lifecycle.State.CREATED;
            case 3:
            case 4:
                return Lifecycle.State.STARTED;
            case 5:
                return Lifecycle.State.RESUMED;
            case 6:
                return Lifecycle.State.DESTROYED;
            default:
                throw new IllegalArgumentException("Unexpected event value " + event);
        }
    }

    private static class NavResultSavedStateFactory extends AbstractSavedStateViewModelFactory {
        NavResultSavedStateFactory(SavedStateRegistryOwner savedStateRegistryOwner, Bundle bundle) {
            super(savedStateRegistryOwner, bundle);
        }

        /* access modifiers changed from: protected */
        @Override // androidx.lifecycle.AbstractSavedStateViewModelFactory
        public <T extends ViewModel> T create(String str, Class<T> cls, SavedStateHandle savedStateHandle) {
            return new SavedStateViewModel(savedStateHandle);
        }
    }

    private static class SavedStateViewModel extends ViewModel {
        private SavedStateHandle mHandle;

        SavedStateViewModel(SavedStateHandle savedStateHandle) {
            this.mHandle = savedStateHandle;
        }

        public SavedStateHandle getHandle() {
            return this.mHandle;
        }
    }
}
