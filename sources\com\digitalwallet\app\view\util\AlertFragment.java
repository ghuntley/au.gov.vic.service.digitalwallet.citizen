package com.digitalwallet.app.view.util;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import au.gov.vic.service.digitalwallet.citizen.R;
import com.digitalwallet.app.databinding.AlertBinding;
import com.digitalwallet.view.main.BackHandler;
import com.google.android.gms.analytics.ecommerce.Promotion;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.bouncycastle.i18n.MessageBundle;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 %2\u00020\u00012\u00020\u0002:\u0001%B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0016\u001a\u00020\tH\u0002J\b\u0010\u0017\u001a\u00020\u000bH\u0016J\u000e\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\u0010J&\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J\u0006\u0010\"\u001a\u00020\tJ\u001a\u0010#\u001a\u00020\t2\u0006\u0010$\u001a\u00020\u001b2\b\u0010 \u001a\u0004\u0018\u00010!H\u0016R\u0016\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0007\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u000f\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u000e¢\u0006\u0004\n\u0002\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/digitalwallet/app/view/util/AlertFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/digitalwallet/view/main/BackHandler;", "()V", "actionTitles", "", "", "actions", "Lkotlin/Function0;", "", "canDismiss", "", "detailedMessage", "dismiss", "dismissTitle", "icon", "", "Ljava/lang/Integer;", "inclusive", "message", "popTo", MessageBundle.TITLE_ENTRY, "done", "handleBack", "onAction", "idx", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDismiss", "onViewCreated", Promotion.ACTION_VIEW, "Companion", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: AlertFragment.kt */
public final class AlertFragment extends Fragment implements BackHandler {
    public static final Companion Companion = new Companion(null);
    private HashMap _$_findViewCache;
    private List<String> actionTitles;
    private List<? extends Function0<Unit>> actions;
    private boolean canDismiss = true;
    private String detailedMessage;
    private Function0<Unit> dismiss;
    private String dismissTitle;
    private Integer icon = Integer.valueOf((int) R.drawable.ic_icon_success);
    private boolean inclusive;
    private String message;
    private String popTo;
    private String title;

    public void _$_clearFindViewByIdCache() {
        HashMap hashMap = this._$_findViewCache;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public View _$_findCachedViewById(int i) {
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i);
        this._$_findViewCache.put(Integer.valueOf(i), findViewById);
        return findViewById;
    }

    @Override // androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0001\u0010\u0003\u001a\u00020\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00062\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00062\u0010\b\u0002\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r2\n\b\u0003\u0010\u0011\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u0014\u001a\u00020\t¢\u0006\u0002\u0010\u0015J£\u0001\u0010\u0016\u001a\u00020\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00062\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r2\u0010\b\u0002\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00182\u0016\b\u0002\u0010\u0019\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r\u0018\u00010\u00182\n\b\u0003\u0010\u0011\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u0014\u001a\u00020\t¢\u0006\u0002\u0010\u001a¨\u0006\u001b"}, d2 = {"Lcom/digitalwallet/app/view/util/AlertFragment$Companion;", "", "()V", "create", "Lcom/digitalwallet/app/view/util/AlertFragment;", MessageBundle.TITLE_ENTRY, "", "popTo", "inclusive", "", "message", "dismissTitle", "dismiss", "Lkotlin/Function0;", "", "actionTitle", "action", "icon", "", "detailedMessage", "canDismiss", "(Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function0;Ljava/lang/String;Lkotlin/jvm/functions/Function0;Ljava/lang/Integer;Ljava/lang/String;Z)Lcom/digitalwallet/app/view/util/AlertFragment;", "createMultiAction", "actionTitles", "", "actions", "(Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function0;Ljava/util/List;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/String;Z)Lcom/digitalwallet/app/view/util/AlertFragment;", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
    /* compiled from: AlertFragment.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ AlertFragment create$default(Companion companion, String str, String str2, boolean z, String str3, String str4, Function0 function0, String str5, Function0 function02, Integer num, String str6, boolean z2, int i, Object obj) {
            String str7 = (i & 1) != 0 ? null : str;
            String str8 = (i & 2) != 0 ? null : str2;
            boolean z3 = true;
            boolean z4 = (i & 4) != 0 ? true : z;
            String str9 = (i & 8) != 0 ? null : str3;
            String str10 = (i & 16) != 0 ? null : str4;
            Function0 function03 = (i & 32) != 0 ? null : function0;
            String str11 = (i & 64) != 0 ? null : str5;
            Function0 function04 = (i & 128) != 0 ? null : function02;
            Integer valueOf = (i & 256) != 0 ? Integer.valueOf((int) R.drawable.ic_icon_success) : num;
            String str12 = (i & 512) != 0 ? null : str6;
            if ((i & 1024) == 0) {
                z3 = z2;
            }
            return companion.create(str7, str8, z4, str9, str10, function03, str11, function04, valueOf, str12, z3);
        }

        public final AlertFragment create(String str, String str2, boolean z, String str3, String str4, Function0<Unit> function0, String str5, Function0<Unit> function02, Integer num, String str6, boolean z2) {
            Companion companion = this;
            List<? extends Function0<Unit>> list = null;
            List<String> listOf = str5 != null ? CollectionsKt.listOf(str5) : null;
            if (function02 != null) {
                list = CollectionsKt.listOf(function02);
            }
            return companion.createMultiAction(str, str2, z, str3, str4, function0, listOf, list, num, str6, z2);
        }

        public static /* synthetic */ AlertFragment createMultiAction$default(Companion companion, String str, String str2, boolean z, String str3, String str4, Function0 function0, List list, List list2, Integer num, String str5, boolean z2, int i, Object obj) {
            String str6 = (i & 1) != 0 ? null : str;
            String str7 = (i & 2) != 0 ? null : str2;
            boolean z3 = true;
            boolean z4 = (i & 4) != 0 ? true : z;
            String str8 = (i & 8) != 0 ? null : str3;
            String str9 = (i & 16) != 0 ? null : str4;
            Function0 function02 = (i & 32) != 0 ? null : function0;
            List list3 = (i & 64) != 0 ? null : list;
            List list4 = (i & 128) != 0 ? null : list2;
            Integer valueOf = (i & 256) != 0 ? Integer.valueOf((int) R.drawable.ic_icon_success) : num;
            String str10 = (i & 512) != 0 ? null : str5;
            if ((i & 1024) == 0) {
                z3 = z2;
            }
            return companion.createMultiAction(str6, str7, z4, str8, str9, function02, list3, list4, valueOf, str10, z3);
        }

        public final AlertFragment createMultiAction(String str, String str2, boolean z, String str3, String str4, Function0<Unit> function0, List<String> list, List<? extends Function0<Unit>> list2, Integer num, String str5, boolean z2) {
            AlertFragment alertFragment = new AlertFragment();
            alertFragment.title = str;
            alertFragment.inclusive = z;
            alertFragment.popTo = str2;
            alertFragment.message = str3;
            alertFragment.dismiss = function0;
            alertFragment.dismissTitle = str4;
            alertFragment.actions = list2;
            alertFragment.actionTitles = list;
            alertFragment.detailedMessage = str5;
            alertFragment.icon = num;
            alertFragment.canDismiss = z2;
            return alertFragment;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        CharSequence charSequence;
        CharSequence charSequence2;
        CharSequence charSequence3;
        CharSequence charSequence4;
        String str;
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        requireActivity.getOnBackPressedDispatcher().addCallback(getViewLifecycleOwner(), new AlertFragment$onCreateView$1(this, true));
        int i = 0;
        AlertBinding inflate = AlertBinding.inflate(layoutInflater, viewGroup, false);
        Integer num = this.icon;
        inflate.image.setImageDrawable(num != null ? getResources().getDrawable(num.intValue(), null) : null);
        TextView textView = inflate.title;
        Intrinsics.checkNotNullExpressionValue(textView, "it.title");
        String str2 = this.title;
        if (str2 != null) {
            charSequence = str2;
        } else {
            TextView textView2 = inflate.title;
            Intrinsics.checkNotNullExpressionValue(textView2, "it.title");
            textView2.setVisibility(8);
            charSequence = null;
        }
        textView.setText(charSequence);
        TextView textView3 = inflate.message;
        Intrinsics.checkNotNullExpressionValue(textView3, "it.message");
        String str3 = this.message;
        if (str3 != null) {
            charSequence2 = str3;
        } else {
            TextView textView4 = inflate.message;
            Intrinsics.checkNotNullExpressionValue(textView4, "it.message");
            textView4.setVisibility(8);
            charSequence2 = null;
        }
        textView3.setText(charSequence2);
        TextView textView5 = inflate.detailedMessage;
        Intrinsics.checkNotNullExpressionValue(textView5, "it.detailedMessage");
        String str4 = this.detailedMessage;
        if (str4 != null) {
            charSequence3 = str4;
        } else {
            TextView textView6 = inflate.detailedMessage;
            Intrinsics.checkNotNullExpressionValue(textView6, "it.detailedMessage");
            textView6.setVisibility(8);
            charSequence3 = null;
        }
        textView5.setText(charSequence3);
        Button button = inflate.dismiss;
        Intrinsics.checkNotNullExpressionValue(button, "it.dismiss");
        String str5 = this.dismissTitle;
        if (str5 != null) {
            charSequence4 = str5;
        } else {
            Button button2 = inflate.dismiss;
            Intrinsics.checkNotNullExpressionValue(button2, "it.dismiss");
            button2.setVisibility(8);
            charSequence4 = null;
        }
        button.setText(charSequence4);
        for (Object obj : CollectionsKt.listOf((Object[]) new Button[]{inflate.action1, inflate.action2})) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            Button button3 = (Button) obj;
            Intrinsics.checkNotNullExpressionValue(button3, "button");
            List<String> list = this.actionTitles;
            if (list == null || (str = (String) CollectionsKt.getOrNull(list, i)) == null) {
                button3.setVisibility(8);
                str = null;
            }
            button3.setText(str);
            i = i2;
        }
        Intrinsics.checkNotNullExpressionValue(inflate, "it");
        inflate.setVm(this);
        return inflate.getRoot();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, Promotion.ACTION_VIEW);
        if (this.dismissTitle == null && this.actionTitles == null) {
            new Handler(Looper.getMainLooper()).postDelayed(new AlertFragment$sam$java_lang_Runnable$0(new AlertFragment$onViewCreated$1(this)), 2000);
        }
    }

    @Override // com.digitalwallet.view.main.BackHandler
    public boolean handleBack() {
        if (!this.canDismiss) {
            FragmentActivity activity = getActivity();
            if (activity != null) {
                activity.finish();
            }
            return true;
        }
        done();
        Function0<Unit> function0 = this.dismiss;
        if (function0 != null) {
            function0.invoke();
        }
        return true;
    }

    public final void onDismiss() {
        List<? extends Function0<Unit>> list;
        Function0 function0;
        done();
        Function0<Unit> function02 = this.dismiss;
        if (function02 == null || function02.invoke() == null) {
            AlertFragment alertFragment = this;
            if (!(alertFragment.dismissTitle != null || (list = alertFragment.actions) == null || (function0 = (Function0) CollectionsKt.getOrNull(list, 0)) == null)) {
                Unit unit = (Unit) function0.invoke();
            }
            Unit unit2 = Unit.INSTANCE;
        }
    }

    public final void onAction(int i) {
        Function0 function0;
        done();
        List<? extends Function0<Unit>> list = this.actions;
        if (list != null && (function0 = (Function0) CollectionsKt.getOrNull(list, i)) != null) {
            Unit unit = (Unit) function0.invoke();
        }
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [int, boolean] */
    /* access modifiers changed from: private */
    /* JADX WARNING: Unknown variable types count: 1 */
    public final void done() {
        ?? r0 = this.inclusive;
        if (this.popTo != null) {
            getParentFragmentManager().popBackStack(this.popTo, (int) r0);
        } else if (r0 != 0) {
            getParentFragmentManager().popBackStack((String) null, r0 == true ? 1 : 0);
        } else {
            getParentFragmentManager().popBackStack();
        }
    }
}
