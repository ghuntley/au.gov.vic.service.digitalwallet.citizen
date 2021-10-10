package com.digitalwallet.app.services;

import android.os.AsyncTask;
import android.util.Base64;
import com.digitalwallet.app.model.Asset;
import com.digitalwallet.app.services.AssetService;
import com.digitalwallet.app.services.AssetService$getBinaryFromNetwork$1;
import java.security.MessageDigest;
import java.util.Arrays;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.ResponseBody;
import org.bouncycastle.cms.CMSAttributeTableGenerator;
import retrofit2.Call;
import retrofit2.Response;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001J'\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0016\u0010\u0004\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00020\u0005\"\u0004\u0018\u00010\u0002H\u0014¢\u0006\u0002\u0010\u0006¨\u0006\u0007¸\u0006\u0000"}, d2 = {"com/digitalwallet/utilities/StandardHelperKt$async$1", "Landroid/os/AsyncTask;", "Ljava/lang/Void;", "doInBackground", "params", "", "([Ljava/lang/Void;)Ljava/lang/Void;", "base_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: StandardHelper.kt */
public final class AssetService$getBinaryFromNetwork$1$1$onResponse$$inlined$async$1 extends AsyncTask<Void, Void, Void> {
    final /* synthetic */ Call $call$inlined;
    final /* synthetic */ Response $response$inlined;
    final /* synthetic */ AssetService$getBinaryFromNetwork$1.AnonymousClass1 this$0;

    public AssetService$getBinaryFromNetwork$1$1$onResponse$$inlined$async$1(AssetService$getBinaryFromNetwork$1.AnonymousClass1 r1, Response response, Call call) {
        this.this$0 = r1;
        this.$response$inlined = response;
        this.$call$inlined = call;
    }

    /* access modifiers changed from: protected */
    public Void doInBackground(Void... voidArr) {
        byte[] bArr;
        Intrinsics.checkNotNullParameter(voidArr, "params");
        try {
            if (this.$response$inlined.isSuccessful()) {
                Object body = this.$response$inlined.body();
                Intrinsics.checkNotNull(body);
                Intrinsics.checkNotNullExpressionValue(body, "response.body()!!");
                ResponseBody responseBody = (ResponseBody) body;
                AssetService assetService = this.this$0.this$0.this$0;
                Asset asset = this.this$0.this$0.$asset;
                MessageDigest digest = this.this$0.getDigest();
                Intrinsics.checkNotNullExpressionValue(digest, CMSAttributeTableGenerator.DIGEST);
                if (((long) assetService.writeToDisk(responseBody, asset, digest)) == responseBody.contentLength()) {
                    byte[] digest2 = this.this$0.getDigest().digest();
                    try {
                        bArr = Base64.decode(this.this$0.this$0.$asset.getHash(), 11);
                    } catch (Exception unused) {
                        bArr = Base64.decode(this.this$0.this$0.$asset.getHash(), 2);
                    }
                    if (bArr == null || !Arrays.equals(digest2, bArr)) {
                        boolean unused2 = this.this$0.this$0.this$0.delete(this.this$0.this$0.$asset);
                        throw new IllegalStateException(new AssetService.InvalidHashError().toString());
                    }
                    r3.onSuccess(this.this$0.this$0.$asset);
                    return null;
                }
                throw new IllegalStateException("Check failed.".toString());
            }
            AssetService$getBinaryFromNetwork$1.AnonymousClass1 r5 = this.this$0;
            Void unused3 = r5.error("HTTP response of " + this.$response$inlined.code());
            throw new KotlinNothingValueException();
        } catch (Exception e) {
            r3.onError(e);
            this.$call$inlined.cancel();
            return null;
        }
    }
}
