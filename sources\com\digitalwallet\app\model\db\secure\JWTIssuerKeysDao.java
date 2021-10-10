package com.digitalwallet.app.model.db.secure;

import java.util.List;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H'J\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H'J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0006H'¨\u0006\t"}, d2 = {"Lcom/digitalwallet/app/model/db/secure/JWTIssuerKeysDao;", "", "deleteAll", "", "getAll", "", "Lcom/digitalwallet/app/model/db/secure/JWTIssuerKeys;", "insert", "jwtIssuerKeys", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: JWTIssuerKeys.kt */
public interface JWTIssuerKeysDao {
    void deleteAll();

    List<JWTIssuerKeys> getAll();

    void insert(JWTIssuerKeys jWTIssuerKeys);
}
