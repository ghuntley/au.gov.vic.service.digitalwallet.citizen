package com.digitalwallet.app.model.db.secure;

import com.digitalwallet.app.holdings.HoldingExpiryPublisher;
import java.util.List;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H'J\b\u0010\u0006\u001a\u00020\u0003H'J\u0010\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\tH'J\u000e\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u000bH'J!\u0010\f\u001a\u00020\u00032\u0012\u0010\r\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u000e\"\u00020\u0005H'¢\u0006\u0002\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/digitalwallet/app/model/db/secure/SecureHoldingDao;", "", "delete", "", HoldingExpiryPublisher.HOLDING_KEY, "Lcom/digitalwallet/app/model/db/secure/EncryptedSecureHoldings;", "deleteAll", "findById", "id", "", "getAll", "", "insertAll", "holdings", "", "([Lcom/digitalwallet/app/model/db/secure/EncryptedSecureHoldings;)V", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: SecuredStore.kt */
public interface SecureHoldingDao {
    void delete(EncryptedSecureHoldings encryptedSecureHoldings);

    void deleteAll();

    EncryptedSecureHoldings findById(int i);

    List<EncryptedSecureHoldings> getAll();

    void insertAll(EncryptedSecureHoldings... encryptedSecureHoldingsArr);
}
