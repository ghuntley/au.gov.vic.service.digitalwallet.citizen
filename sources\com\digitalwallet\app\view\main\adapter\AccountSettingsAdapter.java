package com.digitalwallet.app.view.main.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;
import au.gov.vic.service.digitalwallet.citizen.R;
import com.digitalwallet.app.databinding.ItemSettingOptionBinding;
import com.digitalwallet.app.viewmodel.main.SettingOption;
import com.digitalwallet.app.viewmodel.main.SettingOptionItem;
import io.reactivex.subjects.BehaviorSubject;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0002\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001 B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\u001c\u0010\u0013\u001a\u00020\u00142\n\u0010\u0015\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u0012H\u0016J\u001c\u0010\u0017\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0012H\u0016J\u000e\u0010\u001b\u001a\u00020\u00142\u0006\u0010\u001c\u001a\u00020\u0005J\u001c\u0010\u001d\u001a\u00020\u00142\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\n0\u001f2\u0006\u0010\u0006\u001a\u00020\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X.¢\u0006\u0002\n\u0000R \u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\n0\u0010X\u0004¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/digitalwallet/app/view/main/adapter/AccountSettingsAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/digitalwallet/app/view/main/adapter/AccountSettingsAdapter$SettingOptionViewHolder;", "()V", "autoSyncEnabled", "", "context", "Landroid/content/Context;", "selectedOptionItemViewModel", "Lio/reactivex/subjects/BehaviorSubject;", "Lcom/digitalwallet/app/viewmodel/main/SettingOption;", "getSelectedOptionItemViewModel", "()Lio/reactivex/subjects/BehaviorSubject;", "setSelectedOptionItemViewModel", "(Lio/reactivex/subjects/BehaviorSubject;)V", "settingOption", "", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "updateAutoSyncStatus", "newStatus", "updateList", "updates", "", "SettingOptionViewHolder", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: AccountSettingsAdapter.kt */
public final class AccountSettingsAdapter extends RecyclerView.Adapter<SettingOptionViewHolder> {
    private boolean autoSyncEnabled;
    private Context context;
    private BehaviorSubject<SettingOption> selectedOptionItemViewModel;
    private final List<SettingOption> settingOption = new ArrayList();

    public AccountSettingsAdapter() {
        BehaviorSubject<SettingOption> create = BehaviorSubject.create();
        Intrinsics.checkNotNullExpressionValue(create, "BehaviorSubject.create()");
        this.selectedOptionItemViewModel = create;
    }

    public static final /* synthetic */ Context access$getContext$p(AccountSettingsAdapter accountSettingsAdapter) {
        Context context2 = accountSettingsAdapter.context;
        if (context2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("context");
        }
        return context2;
    }

    public final BehaviorSubject<SettingOption> getSelectedOptionItemViewModel() {
        return this.selectedOptionItemViewModel;
    }

    public final void setSelectedOptionItemViewModel(BehaviorSubject<SettingOption> behaviorSubject) {
        Intrinsics.checkNotNullParameter(behaviorSubject, "<set-?>");
        this.selectedOptionItemViewModel = behaviorSubject;
    }

    public final void updateList(List<? extends SettingOption> list, Context context2) {
        Intrinsics.checkNotNullParameter(list, "updates");
        Intrinsics.checkNotNullParameter(context2, "context");
        this.settingOption.clear();
        this.settingOption.addAll(list);
        this.context = context2;
        notifyDataSetChanged();
    }

    public final void updateAutoSyncStatus(boolean z) {
        this.autoSyncEnabled = z;
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public SettingOptionViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        ItemSettingOptionBinding itemSettingOptionBinding = (ItemSettingOptionBinding) DataBindingUtil.inflate(LayoutInflater.from(viewGroup.getContext()), R.layout.item_setting_option, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(itemSettingOptionBinding, "binding");
        return new SettingOptionViewHolder(this, itemSettingOptionBinding);
    }

    public void onBindViewHolder(SettingOptionViewHolder settingOptionViewHolder, int i) {
        Intrinsics.checkNotNullParameter(settingOptionViewHolder, "holder");
        settingOptionViewHolder.bind(this.settingOption.get(i));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.settingOption.size();
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000b"}, d2 = {"Lcom/digitalwallet/app/view/main/adapter/AccountSettingsAdapter$SettingOptionViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/digitalwallet/app/databinding/ItemSettingOptionBinding;", "(Lcom/digitalwallet/app/view/main/adapter/AccountSettingsAdapter;Lcom/digitalwallet/app/databinding/ItemSettingOptionBinding;)V", "getBinding", "()Lcom/digitalwallet/app/databinding/ItemSettingOptionBinding;", "bind", "", "option", "Lcom/digitalwallet/app/viewmodel/main/SettingOption;", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
    /* compiled from: AccountSettingsAdapter.kt */
    public final class SettingOptionViewHolder extends RecyclerView.ViewHolder {
        private final ItemSettingOptionBinding binding;
        final /* synthetic */ AccountSettingsAdapter this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public SettingOptionViewHolder(AccountSettingsAdapter accountSettingsAdapter, ItemSettingOptionBinding itemSettingOptionBinding) {
            super(itemSettingOptionBinding.getRoot());
            Intrinsics.checkNotNullParameter(itemSettingOptionBinding, "binding");
            this.this$0 = accountSettingsAdapter;
            this.binding = itemSettingOptionBinding;
        }

        public final ItemSettingOptionBinding getBinding() {
            return this.binding;
        }

        public final void bind(SettingOption settingOption) {
            Intrinsics.checkNotNullParameter(settingOption, "option");
            this.binding.setVm(new SettingOptionItem(settingOption, this.this$0.autoSyncEnabled, AccountSettingsAdapter.access$getContext$p(this.this$0), new AccountSettingsAdapter$SettingOptionViewHolder$bind$1(this, settingOption)));
            this.binding.executePendingBindings();
        }
    }
}
