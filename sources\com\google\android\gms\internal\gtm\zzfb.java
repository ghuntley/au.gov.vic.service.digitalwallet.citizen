package com.google.android.gms.internal.gtm;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.tagmanager.impl.R;

public final class zzfb {
    private final Intent intent;
    private final zzfy zzalj;
    private final Context zzaon;
    private final Context zzaoo;

    public zzfb(Intent intent2, Context context, Context context2, zzfy zzfy) {
        this.zzaon = context;
        this.zzaoo = context2;
        this.intent = intent2;
        this.zzalj = zzfy;
    }

    public final void zzkq() {
        try {
            this.zzalj.zzb(this.intent.getData());
            String string = this.zzaoo.getResources().getString(R.string.tagmanager_preview_dialog_title);
            String string2 = this.zzaoo.getResources().getString(R.string.tagmanager_preview_dialog_message);
            String string3 = this.zzaoo.getResources().getString(R.string.tagmanager_preview_dialog_button);
            AlertDialog create = new AlertDialog.Builder(this.zzaon).create();
            create.setTitle(string);
            create.setMessage(string2);
            create.setButton(-1, string3, new zzfc(this));
            create.show();
        } catch (Exception e) {
            String valueOf = String.valueOf(e.getMessage());
            zzev.zzav(valueOf.length() != 0 ? "Calling preview threw an exception: ".concat(valueOf) : new String("Calling preview threw an exception: "));
        }
    }
}
