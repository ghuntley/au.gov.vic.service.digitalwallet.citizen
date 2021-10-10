package com.digitalwallet.utilities;

import android.os.Environment;
import android.util.Log;
import com.google.firebase.messaging.Constants;
import java.io.File;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0002\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0014J,\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\f\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0015¨\u0006\u0010"}, d2 = {"Lcom/digitalwallet/utilities/FileLoggingTree;", "Ltimber/log/Timber$DebugTree;", "()V", "createStackElementTag", "", "element", "Ljava/lang/StackTraceElement;", "log", "", Constants.FirelogAnalytics.PARAM_PRIORITY, "", "tag", "message", "t", "", "Companion", "base_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: FileLoggingTree.kt */
public final class FileLoggingTree extends Timber.DebugTree {
    public static final Companion Companion = new Companion(null);
    private static final String LOG_TAG;

    /* access modifiers changed from: protected */
    @Override // timber.log.Timber.DebugTree, timber.log.Timber.Tree
    public void log(int i, String str, String str2, Throwable th) {
        Intrinsics.checkNotNullParameter(str2, "message");
        try {
            String format = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault()).format(new Date());
            String format2 = new SimpleDateFormat("E MMM dd yyyy 'at' hh:mm:ss:SSS aaa", Locale.getDefault()).format(new Date());
            File generateFile = Companion.generateFile("Log", format + ".html");
            if (generateFile != null) {
                FileWriter fileWriter = new FileWriter(generateFile, true);
                fileWriter.append((CharSequence) ("\n                        <p style=\"background:lightgray;\"><strong style=\"background:lightblue;\">&nbsp&nbsp " + format2 + " :&nbsp&nbsp</strong><strong>&nbsp&nbsp" + str + "</strong> - " + str2 + "</p>\n                        "));
                fileWriter.flush();
                fileWriter.close();
            }
        } catch (Exception e) {
            String str3 = LOG_TAG;
            Log.e(str3, "Error while logging into file : " + e);
        }
    }

    /* access modifiers changed from: protected */
    @Override // timber.log.Timber.DebugTree
    public String createStackElementTag(StackTraceElement stackTraceElement) {
        Intrinsics.checkNotNullParameter(stackTraceElement, "element");
        return super.createStackElementTag(stackTraceElement) + " - " + stackTraceElement.getLineNumber();
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0004H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u00068BX\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0007¨\u0006\f"}, d2 = {"Lcom/digitalwallet/utilities/FileLoggingTree$Companion;", "", "()V", "LOG_TAG", "", "isExternalStorageAvailable", "", "()Z", "generateFile", "Ljava/io/File;", "path", "fileName", "base_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
    /* compiled from: FileLoggingTree.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final File generateFile(String str, String str2) {
            File file = null;
            if (!isExternalStorageAvailable()) {
                return file;
            }
            File externalStorageDirectory = Environment.getExternalStorageDirectory();
            Intrinsics.checkNotNullExpressionValue(externalStorageDirectory, "Environment.getExternalStorageDirectory()");
            File file2 = new File(externalStorageDirectory.getAbsolutePath(), "au.gov.vic.service.digitalwallet.citizen" + File.separator + str);
            boolean z = true;
            if (!file2.exists()) {
                z = file2.mkdirs();
            }
            return z ? new File(file2, str2) : file;
        }

        private final boolean isExternalStorageAvailable() {
            return Intrinsics.areEqual("mounted", Environment.getExternalStorageState());
        }
    }

    static {
        String simpleName = FileLoggingTree.class.getSimpleName();
        Intrinsics.checkNotNullExpressionValue(simpleName, "FileLoggingTree::class.java.simpleName");
        LOG_TAG = simpleName;
    }
}
