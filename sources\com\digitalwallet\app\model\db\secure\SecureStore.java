package com.digitalwallet.app.model.db.secure;

import com.google.firebase.messaging.Constants;
import io.reactivex.Completable;
import io.reactivex.Single;
import java.util.List;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0000\bf\u0018\u00002\u00020\u0001J)\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u0005\"\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH&¢\u0006\u0002\u0010\tJ\u0018\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\bH&J\u001e\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00060\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\bH&J\u001c\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00110\r2\u0006\u0010\u000b\u001a\u00020\bH&¨\u0006\u0012"}, d2 = {"Lcom/digitalwallet/app/model/db/secure/SecureStore;", "", "addAll", "Lio/reactivex/Completable;", "item", "", "Lcom/digitalwallet/app/model/db/secure/SecuredData;", "to", "Lcom/digitalwallet/app/model/db/secure/SecuredDWTable;", "([Lcom/digitalwallet/app/model/db/secure/SecuredData;Lcom/digitalwallet/app/model/db/secure/SecuredDWTable;)Lio/reactivex/Completable;", "delete", Constants.MessagePayloadKeys.FROM, "get", "Lio/reactivex/Single;", "id", "", "getAll", "", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: SecuredStore.kt */
public interface SecureStore {
    Completable addAll(SecuredData[] securedDataArr, SecuredDWTable securedDWTable);

    Completable delete(SecuredData securedData, SecuredDWTable securedDWTable);

    Single<SecuredData> get(int i, SecuredDWTable securedDWTable);

    Single<List<SecuredData>> getAll(SecuredDWTable securedDWTable);
}
