package com.digitalwallet.app.viewmodel.main;

import com.digitalwallet.app.model.AttributeDetailItem;
import java.util.List;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0016\u0010\u0004\u001a\u00020\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H&¨\u0006\b"}, d2 = {"Lcom/digitalwallet/app/viewmodel/main/AccountDetailsView;", "", "edit", "", "updateList", "detailList", "", "Lcom/digitalwallet/app/model/AttributeDetailItem;", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: AccountDetailsFragmentViewModel.kt */
public interface AccountDetailsView {
    void edit();

    void updateList(List<AttributeDetailItem> list);
}
