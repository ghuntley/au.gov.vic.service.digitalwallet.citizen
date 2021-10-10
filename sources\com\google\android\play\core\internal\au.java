package com.google.android.play.core.internal;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.util.Log;
import com.google.android.play.core.splitcompat.c;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class au {
    private final c a;
    private final Context b;
    private final aw c;

    public au(Context context, c cVar, aw awVar, byte[] bArr) {
        this.a = cVar;
        this.c = awVar;
        this.b = context;
    }

    private static X509Certificate c(Signature signature) {
        try {
            return (X509Certificate) CertificateFactory.getInstance("X509").generateCertificate(new ByteArrayInputStream(signature.toByteArray()));
        } catch (CertificateException e) {
            Log.e("SplitCompat", "Cannot decode certificate.", e);
            return null;
        }
    }

    public final boolean a() {
        Signature[] signatureArr;
        String sb;
        try {
            File g = this.a.g();
            ArrayList<X509Certificate> arrayList = null;
            try {
                signatureArr = this.b.getPackageManager().getPackageInfo(this.b.getPackageName(), 64).signatures;
            } catch (PackageManager.NameNotFoundException unused) {
                signatureArr = null;
            }
            if (signatureArr != null) {
                arrayList = new ArrayList();
                for (Signature signature : signatureArr) {
                    X509Certificate c2 = c(signature);
                    if (c2 != null) {
                        arrayList.add(c2);
                    }
                }
            }
            if (arrayList == null || arrayList.isEmpty()) {
                Log.e("SplitCompat", "No app certificates found.");
                return false;
            }
            File[] listFiles = g.listFiles();
            Arrays.sort(listFiles);
            int length = listFiles.length;
            loop1:
            while (true) {
                length--;
                if (length < 0) {
                    return true;
                }
                File file = listFiles[length];
                try {
                    String absolutePath = file.getAbsolutePath();
                    try {
                        X509Certificate[][] g2 = i.g(absolutePath);
                        if (g2 == null || g2.length == 0 || g2[0].length == 0) {
                            StringBuilder sb2 = new StringBuilder(String.valueOf(absolutePath).length() + 32);
                            sb2.append("Downloaded split ");
                            sb2.append(absolutePath);
                            sb2.append(" is not signed.");
                            sb = sb2.toString();
                        } else if (arrayList.isEmpty()) {
                            sb = "No certificates found for app.";
                            break;
                        } else {
                            for (X509Certificate x509Certificate : arrayList) {
                                int length2 = g2.length;
                                int i = 0;
                                while (true) {
                                    if (i >= length2) {
                                        Log.i("SplitCompat", "There's an app certificate that doesn't sign the split.");
                                        break loop1;
                                    } else if (!g2[i][0].equals(x509Certificate)) {
                                        i++;
                                    }
                                }
                            }
                            try {
                                file.renameTo(this.a.d(file));
                            } catch (IOException e) {
                                Log.e("SplitCompat", "Cannot write verified split.", e);
                                return false;
                            }
                        }
                    } catch (Exception e2) {
                        StringBuilder sb3 = new StringBuilder(String.valueOf(absolutePath).length() + 32);
                        sb3.append("Downloaded split ");
                        sb3.append(absolutePath);
                        sb3.append(" is not signed.");
                        Log.e("SplitCompat", sb3.toString(), e2);
                    }
                } catch (Exception e3) {
                    Log.e("SplitCompat", "Split verification error.", e3);
                    return false;
                }
            }
            Log.e("SplitCompat", sb);
            Log.e("SplitCompat", "Split verification failure.");
            return false;
        } catch (IOException e4) {
            Log.e("SplitCompat", "Cannot access directory for unverified splits.", e4);
            return false;
        }
    }

    public final boolean b(List<Intent> list) throws IOException {
        for (Intent intent : list) {
            if (!this.a.c(intent.getStringExtra("split_id")).exists()) {
                return false;
            }
        }
        return true;
    }
}
