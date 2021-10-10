package com.digitalwallet.app.view.main.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;
import au.gov.vic.service.digitalwallet.citizen.R;
import com.digitalwallet.app.databinding.ServiceDetailRowBinding;
import com.digitalwallet.app.view.main.ServiceDetailType;
import com.digitalwallet.app.viewmodel.main.ServiceDetailItem;
import io.reactivex.subjects.BehaviorSubject;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001\u0018B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u000b\u001a\u00020\fH\u0016J\u001c\u0010\r\u001a\u00020\u000e2\n\u0010\u000f\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0010\u001a\u00020\fH\u0016J\u001c\u0010\u0011\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\fH\u0016J\u0014\u0010\u0015\u001a\u00020\u000e2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00060\u0017R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\nX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/digitalwallet/app/view/main/adapter/ServiceDetailAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/digitalwallet/app/view/main/adapter/ServiceDetailAdapter$ServiceDetailViewHolder;", "()V", "selectedDetailItemViewModel", "Lio/reactivex/subjects/BehaviorSubject;", "Lcom/digitalwallet/app/view/main/ServiceDetailType;", "getSelectedDetailItemViewModel", "()Lio/reactivex/subjects/BehaviorSubject;", "serviceDetails", "", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "updateList", "updates", "", "ServiceDetailViewHolder", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: ServiceDetailAdapter.kt */
public final class ServiceDetailAdapter extends RecyclerView.Adapter<ServiceDetailViewHolder> {
    private final BehaviorSubject<ServiceDetailType> selectedDetailItemViewModel;
    private final List<ServiceDetailType> serviceDetails = new ArrayList();

    public ServiceDetailAdapter() {
        BehaviorSubject<ServiceDetailType> create = BehaviorSubject.create();
        Intrinsics.checkNotNullExpressionValue(create, "BehaviorSubject.create()");
        this.selectedDetailItemViewModel = create;
    }

    public final BehaviorSubject<ServiceDetailType> getSelectedDetailItemViewModel() {
        return this.selectedDetailItemViewModel;
    }

    public final void updateList(List<? extends ServiceDetailType> list) {
        Intrinsics.checkNotNullParameter(list, "updates");
        this.serviceDetails.clear();
        this.serviceDetails.addAll(list);
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ServiceDetailViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        ServiceDetailRowBinding serviceDetailRowBinding = (ServiceDetailRowBinding) DataBindingUtil.inflate(LayoutInflater.from(viewGroup.getContext()), R.layout.service_detail_row, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(serviceDetailRowBinding, "binding");
        return new ServiceDetailViewHolder(this, serviceDetailRowBinding);
    }

    public void onBindViewHolder(ServiceDetailViewHolder serviceDetailViewHolder, int i) {
        Intrinsics.checkNotNullParameter(serviceDetailViewHolder, "holder");
        serviceDetailViewHolder.bind(this.serviceDetails.get(i));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.serviceDetails.size();
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000b"}, d2 = {"Lcom/digitalwallet/app/view/main/adapter/ServiceDetailAdapter$ServiceDetailViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/digitalwallet/app/databinding/ServiceDetailRowBinding;", "(Lcom/digitalwallet/app/view/main/adapter/ServiceDetailAdapter;Lcom/digitalwallet/app/databinding/ServiceDetailRowBinding;)V", "getBinding", "()Lcom/digitalwallet/app/databinding/ServiceDetailRowBinding;", "bind", "", "type", "Lcom/digitalwallet/app/view/main/ServiceDetailType;", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
    /* compiled from: ServiceDetailAdapter.kt */
    public final class ServiceDetailViewHolder extends RecyclerView.ViewHolder {
        private final ServiceDetailRowBinding binding;
        final /* synthetic */ ServiceDetailAdapter this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ServiceDetailViewHolder(ServiceDetailAdapter serviceDetailAdapter, ServiceDetailRowBinding serviceDetailRowBinding) {
            super(serviceDetailRowBinding.getRoot());
            Intrinsics.checkNotNullParameter(serviceDetailRowBinding, "binding");
            this.this$0 = serviceDetailAdapter;
            this.binding = serviceDetailRowBinding;
        }

        public final ServiceDetailRowBinding getBinding() {
            return this.binding;
        }

        public final void bind(ServiceDetailType serviceDetailType) {
            Intrinsics.checkNotNullParameter(serviceDetailType, "type");
            this.binding.setVm(ServiceDetailItem.Companion.from(serviceDetailType));
            this.binding.getRoot().setOnClickListener(new ServiceDetailAdapter$ServiceDetailViewHolder$bind$1(this, serviceDetailType));
            this.binding.executePendingBindings();
        }
    }
}
