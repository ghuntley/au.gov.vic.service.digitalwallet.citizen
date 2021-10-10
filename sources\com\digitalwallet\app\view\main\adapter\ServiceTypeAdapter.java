package com.digitalwallet.app.view.main.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;
import au.gov.vic.service.digitalwallet.citizen.R;
import com.digitalwallet.app.databinding.ServiceTypeCardBinding;
import com.digitalwallet.app.view.main.ServiceType;
import com.digitalwallet.app.viewmodel.main.ServiceTypeItem;
import io.reactivex.subjects.BehaviorSubject;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001\u001aB\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\r\u001a\u00020\u000eH\u0016J\u001c\u0010\u000f\u001a\u00020\u00102\n\u0010\u0011\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u000eH\u0016J\u001c\u0010\u0013\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u000eH\u0016J\u0014\u0010\u0017\u001a\u00020\u00102\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00060\u0019R \u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\fX\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/digitalwallet/app/view/main/adapter/ServiceTypeAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/digitalwallet/app/view/main/adapter/ServiceTypeAdapter$ServiceTypeViewHolder;", "()V", "selectedTypeItemViewModel", "Lio/reactivex/subjects/BehaviorSubject;", "Lcom/digitalwallet/app/view/main/ServiceType;", "getSelectedTypeItemViewModel", "()Lio/reactivex/subjects/BehaviorSubject;", "setSelectedTypeItemViewModel", "(Lio/reactivex/subjects/BehaviorSubject;)V", "serviceTypes", "", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "updateList", "updates", "", "ServiceTypeViewHolder", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: ServiceTypeAdapter.kt */
public final class ServiceTypeAdapter extends RecyclerView.Adapter<ServiceTypeViewHolder> {
    private BehaviorSubject<ServiceType> selectedTypeItemViewModel;
    private final List<ServiceType> serviceTypes = new ArrayList();

    public ServiceTypeAdapter() {
        BehaviorSubject<ServiceType> create = BehaviorSubject.create();
        Intrinsics.checkNotNullExpressionValue(create, "BehaviorSubject.create()");
        this.selectedTypeItemViewModel = create;
    }

    public final BehaviorSubject<ServiceType> getSelectedTypeItemViewModel() {
        return this.selectedTypeItemViewModel;
    }

    public final void setSelectedTypeItemViewModel(BehaviorSubject<ServiceType> behaviorSubject) {
        Intrinsics.checkNotNullParameter(behaviorSubject, "<set-?>");
        this.selectedTypeItemViewModel = behaviorSubject;
    }

    public final void updateList(List<? extends ServiceType> list) {
        Intrinsics.checkNotNullParameter(list, "updates");
        this.serviceTypes.clear();
        this.serviceTypes.addAll(list);
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ServiceTypeViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        ServiceTypeCardBinding serviceTypeCardBinding = (ServiceTypeCardBinding) DataBindingUtil.inflate(LayoutInflater.from(viewGroup.getContext()), R.layout.service_type_card, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(serviceTypeCardBinding, "binding");
        return new ServiceTypeViewHolder(this, serviceTypeCardBinding);
    }

    public void onBindViewHolder(ServiceTypeViewHolder serviceTypeViewHolder, int i) {
        Intrinsics.checkNotNullParameter(serviceTypeViewHolder, "holder");
        serviceTypeViewHolder.bind(this.serviceTypes.get(i));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.serviceTypes.size();
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000b"}, d2 = {"Lcom/digitalwallet/app/view/main/adapter/ServiceTypeAdapter$ServiceTypeViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/digitalwallet/app/databinding/ServiceTypeCardBinding;", "(Lcom/digitalwallet/app/view/main/adapter/ServiceTypeAdapter;Lcom/digitalwallet/app/databinding/ServiceTypeCardBinding;)V", "getBinding", "()Lcom/digitalwallet/app/databinding/ServiceTypeCardBinding;", "bind", "", "type", "Lcom/digitalwallet/app/view/main/ServiceType;", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
    /* compiled from: ServiceTypeAdapter.kt */
    public final class ServiceTypeViewHolder extends RecyclerView.ViewHolder {
        private final ServiceTypeCardBinding binding;
        final /* synthetic */ ServiceTypeAdapter this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ServiceTypeViewHolder(ServiceTypeAdapter serviceTypeAdapter, ServiceTypeCardBinding serviceTypeCardBinding) {
            super(serviceTypeCardBinding.getRoot());
            Intrinsics.checkNotNullParameter(serviceTypeCardBinding, "binding");
            this.this$0 = serviceTypeAdapter;
            this.binding = serviceTypeCardBinding;
        }

        public final ServiceTypeCardBinding getBinding() {
            return this.binding;
        }

        public final void bind(ServiceType serviceType) {
            Intrinsics.checkNotNullParameter(serviceType, "type");
            this.binding.setVm(ServiceTypeItem.Companion.from(serviceType));
            this.binding.getRoot().setOnClickListener(new ServiceTypeAdapter$ServiceTypeViewHolder$bind$1(this, serviceType));
            this.binding.executePendingBindings();
        }
    }
}
