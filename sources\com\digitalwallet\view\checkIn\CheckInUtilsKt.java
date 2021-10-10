package com.digitalwallet.view.checkIn;

import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.digitalwallet.model.PrimaryPersonCheckIn;
import com.digitalwallet.view.base.BaseFragment;
import com.digitalwallet.view.checkIn.checkInInput.CheckInPrimaryInputFragment;
import com.digitalwallet.view.checkIn.checkInInput.CheckInSummaryFragment;
import com.digitalwallet.viewmodel.checkIn.CheckInUtils;
import com.digitalwallet.viewmodel.checkIn.checkInRepository.CheckInRepository;
import com.google.android.gms.instantapps.InstantApps;
import com.google.android.gms.instantapps.PackageManagerCompat;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import net.openid.appauth.AuthorizationRequest;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003\u001a&\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f\u001a\u000e\u0010\r\u001a\u00020\f2\u0006\u0010\u0002\u001a\u00020\u0003¨\u0006\u000e"}, d2 = {"backToMainActivity", "", AuthorizationRequest.ResponseMode.FRAGMENT, "Landroidx/fragment/app/Fragment;", "getCheckInInputEntryFragment", "Lcom/digitalwallet/view/base/BaseFragment;", "Landroidx/databinding/ViewDataBinding;", "checkInRepository", "Lcom/digitalwallet/viewmodel/checkIn/checkInRepository/CheckInRepository;", "checkInCode", "Lcom/digitalwallet/viewmodel/checkIn/CheckInUtils$CheckInCode;", "showBack", "", "isInstantApp", "base_citizenProdRelease"}, k = 2, mv = {1, 4, 0})
/* compiled from: CheckInUtils.kt */
public final class CheckInUtilsKt {
    public static final void backToMainActivity(Fragment fragment) {
        Intrinsics.checkNotNullParameter(fragment, AuthorizationRequest.ResponseMode.FRAGMENT);
        if (!fragment.getParentFragmentManager().popBackStackImmediate(Reflection.getOrCreateKotlinClass(CheckInScannerFragment.class).getSimpleName(), 1)) {
            fragment.getParentFragmentManager().popBackStackImmediate((String) null, 1);
            FragmentManager parentFragmentManager = fragment.getParentFragmentManager();
            Intrinsics.checkNotNullExpressionValue(parentFragmentManager, "fragment.parentFragmentManager");
            List<Fragment> fragments = parentFragmentManager.getFragments();
            Intrinsics.checkNotNullExpressionValue(fragments, "fragment.parentFragmentManager.fragments");
            Fragment fragment2 = (Fragment) CollectionsKt.firstOrNull((List) fragments);
            if ((fragment2 instanceof CheckInOverviewFragment) || (fragment2 instanceof CheckInPrimaryInputFragment) || (fragment2 instanceof CheckInSummaryFragment)) {
                fragment.requireActivity().finishAndRemoveTask();
            }
        }
    }

    public static final boolean isInstantApp(Fragment fragment) {
        Intrinsics.checkNotNullParameter(fragment, AuthorizationRequest.ResponseMode.FRAGMENT);
        PackageManagerCompat packageManagerCompat = InstantApps.getPackageManagerCompat(fragment.requireContext());
        Intrinsics.checkNotNullExpressionValue(packageManagerCompat, "InstantApps.getPackageMa…ragment.requireContext())");
        return packageManagerCompat.isInstantApp();
    }

    public static final BaseFragment<? extends ViewDataBinding> getCheckInInputEntryFragment(CheckInRepository checkInRepository, CheckInUtils.CheckInCode checkInCode, boolean z) {
        CheckInSummaryFragment createFragment;
        Intrinsics.checkNotNullParameter(checkInRepository, "checkInRepository");
        Intrinsics.checkNotNullParameter(checkInCode, "checkInCode");
        PrimaryPersonCheckIn primaryPersonCheckIn = checkInRepository.getPrimaryPersonCheckIn(checkInCode);
        if (primaryPersonCheckIn == null || (createFragment = CheckInSummaryFragment.Companion.createFragment(primaryPersonCheckIn, null, z)) == null) {
            return CheckInPrimaryInputFragment.Companion.createFragment(checkInCode, z);
        }
        return createFragment;
    }
}
