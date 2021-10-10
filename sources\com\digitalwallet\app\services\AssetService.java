package com.digitalwallet.app.services;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.util.Base64;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.digitalwallet.app.api.AssetApi;
import com.digitalwallet.app.model.Asset;
import com.digitalwallet.app.model.P2PMessage;
import com.google.firebase.messaging.Constants;
import io.reactivex.Single;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.io.FilesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.ResponseBody;
import org.bouncycastle.cms.CMSAttributeTableGenerator;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 )2\u00020\u0001:\u0002)*B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0014\u0010\u000f\u001a\u00020\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0012J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u000eH\u0002J\u001c\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u00172\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u000eJ\u000e\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0015\u001a\u00020\u000eJ\u0016\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u0015\u001a\u00020\u000eH\u0002J\u001c\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u001d\u001a\u00020\u001eJ\u0010\u0010\u001f\u001a\u00020\b2\u0006\u0010 \u001a\u00020\fH\u0002J\u000e\u0010!\u001a\u00020\u00102\u0006\u0010\"\u001a\u00020\u001aJ \u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\u0006\u0010\u0015\u001a\u00020\u000e2\u0006\u0010'\u001a\u00020(H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\n \t*\u0004\u0018\u00010\b0\bX\u0004¢\u0006\u0002\n\u0000R \u0010\n\u001a\u0014\u0012\u0004\u0012\u00020\f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\u000bX\u0004¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"Lcom/digitalwallet/app/services/AssetService;", "", "context", "Landroid/content/Context;", "assetApi", "Lcom/digitalwallet/app/api/AssetApi;", "(Landroid/content/Context;Lcom/digitalwallet/app/api/AssetApi;)V", "directory", "Ljava/io/File;", "kotlin.jvm.PlatformType", "retrieval", "", "", "Lio/reactivex/Single;", "Lcom/digitalwallet/app/model/Asset;", "cleanUp", "", "excluding", "", "delete", "", "asset", "getAsset", "Lcom/bumptech/glide/RequestBuilder;", "Landroid/graphics/drawable/Drawable;", "getAssetData", "", "getBinaryFromNetwork", "getBinaryFromNetworkCached", "timeoutSecs", "", "getFile", "name", "storeAssetData", Constants.ScionAnalytics.MessageType.DATA_MESSAGE, "writeToDisk", "", P2PMessage.contentsKey, "Lokhttp3/ResponseBody;", CMSAttributeTableGenerator.DIGEST, "Ljava/security/MessageDigest;", "Companion", "InvalidHashError", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: AssetService.kt */
public final class AssetService {
    public static final Companion Companion = new Companion(null);
    private static final int compatibleDecodeFlags = 2;
    private static final String hashAlgorithm = "SHA-1";
    private static final int safeDecodeFlags = 11;
    private final AssetApi assetApi;
    private final File directory;
    private final Map<String, Single<Asset>> retrieval = new LinkedHashMap();

    @Inject
    public AssetService(Context context, AssetApi assetApi2) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(assetApi2, "assetApi");
        this.assetApi = assetApi2;
        this.directory = context.getFilesDir();
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0005¢\u0006\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/digitalwallet/app/services/AssetService$InvalidHashError;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "()V", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
    /* compiled from: AssetService.kt */
    public static final class InvalidHashError extends Exception {
        public InvalidHashError() {
            super("Invalid hash");
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/digitalwallet/app/services/AssetService$Companion;", "", "()V", "compatibleDecodeFlags", "", "hashAlgorithm", "", "safeDecodeFlags", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
    /* compiled from: AssetService.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public final RequestBuilder<Drawable> getAsset(Context context, Asset asset) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(asset, "asset");
        RequestBuilder<Drawable> load = Glide.with(context).load(getFile(asset.toString()));
        Intrinsics.checkNotNullExpressionValue(load, "Glide.with(context).load…etFile(asset.toString()))");
        return load;
    }

    public final byte[] getAssetData(Asset asset) {
        Intrinsics.checkNotNullParameter(asset, "asset");
        return FilesKt.readBytes(getFile(asset.toString()));
    }

    public final void storeAssetData(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, Constants.ScionAnalytics.MessageType.DATA_MESSAGE);
        MessageDigest instance = MessageDigest.getInstance(hashAlgorithm);
        instance.update(bArr);
        String encodeToString = Base64.encodeToString(instance.digest(), 11);
        Intrinsics.checkNotNullExpressionValue(encodeToString, "assetHash");
        FilesKt.writeBytes(getFile(encodeToString), bArr);
    }

    public final Single<Asset> getBinaryFromNetworkCached(Asset asset, long j) {
        Single<Asset> single;
        Intrinsics.checkNotNullParameter(asset, "asset");
        synchronized (this.retrieval) {
            String asset2 = asset.toString();
            single = this.retrieval.get(asset2);
            if (single == null) {
                AssetService assetService = this;
                single = assetService.getBinaryFromNetwork(asset).timeout(j, TimeUnit.SECONDS).doOnError(new AssetService$getBinaryFromNetworkCached$$inlined$synchronized$lambda$1(assetService, asset2, this, asset, j));
                Map<String, Single<Asset>> map = assetService.retrieval;
                Intrinsics.checkNotNullExpressionValue(single, "it");
                map.put(asset2, single);
                Intrinsics.checkNotNullExpressionValue(single, "run {\n                  … = it }\n                }");
            }
        }
        return single;
    }

    public final void cleanUp(List<Asset> list) {
        Intrinsics.checkNotNullParameter(list, "excluding");
        Looper mainLooper = Looper.getMainLooper();
        Intrinsics.checkNotNullExpressionValue(mainLooper, "Looper.getMainLooper()");
        if (!mainLooper.isCurrentThread()) {
            List<Asset> list2 = list;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
            Iterator<T> it = list2.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().toString());
            }
            File[] listFiles = this.directory.listFiles(new AssetService$cleanUp$excluded$1(arrayList));
            if (listFiles != null) {
                for (File file : listFiles) {
                    file.delete();
                }
                return;
            }
            return;
        }
        throw new IllegalStateException("Check failed.".toString());
    }

    private final Single<Asset> getBinaryFromNetwork(Asset asset) {
        delete(asset);
        Single<Asset> create = Single.create(new AssetService$getBinaryFromNetwork$1(this, asset));
        Intrinsics.checkNotNullExpressionValue(create, "Single.create { emitter …             })\n        }");
        return create;
    }

    /* access modifiers changed from: private */
    public final boolean delete(Asset asset) {
        Looper mainLooper = Looper.getMainLooper();
        Intrinsics.checkNotNullExpressionValue(mainLooper, "Looper.getMainLooper()");
        if (!mainLooper.isCurrentThread()) {
            return getFile(asset.toString()).delete();
        }
        throw new IllegalStateException("Check failed.".toString());
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0057, code lost:
        r12 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0058, code lost:
        kotlin.io.CloseableKt.closeFinally(r4, r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x005b, code lost:
        throw r12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x005e, code lost:
        r12 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x005f, code lost:
        kotlin.io.CloseableKt.closeFinally(r10, r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0062, code lost:
        throw r12;
     */
    public final int writeToDisk(ResponseBody responseBody, Asset asset, MessageDigest messageDigest) {
        Looper mainLooper = Looper.getMainLooper();
        Intrinsics.checkNotNullExpressionValue(mainLooper, "Looper.getMainLooper()");
        if (!mainLooper.isCurrentThread()) {
            File file = getFile(asset.toString());
            InputStream byteStream = responseBody.byteStream();
            Throwable th = null;
            InputStream inputStream = byteStream;
            byte[] bArr = new byte[4096];
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            Throwable th2 = null;
            FileOutputStream fileOutputStream2 = fileOutputStream;
            int i = 0;
            while (true) {
                int read = inputStream.read(bArr);
                if (read == -1) {
                    fileOutputStream2.flush();
                    Unit unit = Unit.INSTANCE;
                    CloseableKt.closeFinally(fileOutputStream, th2);
                    Unit unit2 = Unit.INSTANCE;
                    CloseableKt.closeFinally(byteStream, th);
                    return i;
                }
                i += read;
                messageDigest.update(bArr, 0, read);
                fileOutputStream2.write(bArr, 0, read);
            }
        } else {
            throw new IllegalStateException("Check failed.".toString());
        }
    }

    private final File getFile(String str) {
        List listOf = CollectionsKt.listOf(this.directory, str);
        String str2 = File.separator;
        Intrinsics.checkNotNullExpressionValue(str2, "File.separator");
        return new File(CollectionsKt.joinToString$default(listOf, str2, null, null, 0, null, null, 62, null));
    }
}
