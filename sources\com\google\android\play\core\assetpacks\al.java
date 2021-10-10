package com.google.android.play.core.assetpacks;

import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import com.google.android.play.core.tasks.i;

final class al extends ak<ParcelFileDescriptor> {
    al(ar arVar, i<ParcelFileDescriptor> iVar) {
        super(arVar, iVar);
    }

    @Override // com.google.android.play.core.assetpacks.ak, com.google.android.play.core.internal.v
    public final void e(Bundle bundle, Bundle bundle2) throws RemoteException {
        super.e(bundle, bundle2);
        this.a.e((ParcelFileDescriptor) bundle.getParcelable("chunk_file_descriptor"));
    }
}
