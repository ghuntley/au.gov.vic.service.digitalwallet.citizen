package com.digitalwallet.viewmodel.checkIn.checkInRepository;

import com.digitalwallet.BuildConfig;
import com.digitalwallet.model.AttestationJwt;
import com.google.android.gms.safetynet.SafetyNet;
import com.google.android.gms.safetynet.SafetyNetApi;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;
import java.util.Calendar;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0014\u0010\u0002\u001a\u0010\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u00040\u0003H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "emitter", "Lio/reactivex/SingleEmitter;", "Lcom/digitalwallet/model/AttestationJwt;", "kotlin.jvm.PlatformType", "subscribe"}, k = 3, mv = {1, 4, 0})
/* compiled from: CheckInRepository.kt */
public final class CheckInRepository$getAttestation$2$1<T> implements SingleOnSubscribe<AttestationJwt> {
    final /* synthetic */ byte[] $nonce;
    final /* synthetic */ CheckInRepository $this_run;

    CheckInRepository$getAttestation$2$1(CheckInRepository checkInRepository, byte[] bArr) {
        this.$this_run = checkInRepository;
        this.$nonce = bArr;
    }

    @Override // io.reactivex.SingleOnSubscribe
    public final void subscribe(final SingleEmitter<AttestationJwt> singleEmitter) {
        Intrinsics.checkNotNullParameter(singleEmitter, "emitter");
        SafetyNet.getClient(this.$this_run.context).attest(this.$nonce, BuildConfig.ATTESTATION_API_KEY).addOnSuccessListener(new OnSuccessListener<SafetyNetApi.AttestationResponse>(this) {
            /* class com.digitalwallet.viewmodel.checkIn.checkInRepository.CheckInRepository$getAttestation$2$1.AnonymousClass1 */
            final /* synthetic */ CheckInRepository$getAttestation$2$1 this$0;

            {
                this.this$0 = r1;
            }

            /* JADX DEBUG: Multi-variable search result rejected for r4v4, resolved type: io.reactivex.SingleEmitter */
            /* JADX WARN: Multi-variable type inference failed */
            public final void onSuccess(SafetyNetApi.AttestationResponse attestationResponse) {
                Intrinsics.checkNotNullExpressionValue(attestationResponse, "it");
                String jwsResult = attestationResponse.getJwsResult();
                Intrinsics.checkNotNullExpressionValue(jwsResult, "it.jwsResult");
                Calendar instance = Calendar.getInstance();
                Intrinsics.checkNotNullExpressionValue(instance, "Calendar.getInstance()");
                Date time = instance.getTime();
                Intrinsics.checkNotNullExpressionValue(time, "Calendar.getInstance().time");
                AttestationJwt attestationJwt = new AttestationJwt(jwsResult, time);
                this.this$0.$this_run.storeAttestationJwt(attestationJwt);
                singleEmitter.onSuccess(attestationJwt);
            }
        }).addOnFailureListener(new OnFailureListener() {
            /* class com.digitalwallet.viewmodel.checkIn.checkInRepository.CheckInRepository$getAttestation$2$1.AnonymousClass2 */

            @Override // com.google.android.gms.tasks.OnFailureListener
            public final void onFailure(Exception exc) {
                Intrinsics.checkNotNullParameter(exc, "it");
                Timber.e(exc);
                singleEmitter.onError(new Error("Fail to get attestationJwtToken."));
            }
        });
    }
}
