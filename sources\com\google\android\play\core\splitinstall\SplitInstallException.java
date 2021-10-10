package com.google.android.play.core.splitinstall;

import com.google.android.play.core.splitinstall.model.a;
import com.google.android.play.core.tasks.j;

public class SplitInstallException extends j {
    private final int a;

    public SplitInstallException(int i) {
        super(String.format("Split Install Error(%d): %s", Integer.valueOf(i), a.a(i)));
        if (i != 0) {
            this.a = i;
            return;
        }
        throw new IllegalArgumentException("errorCode should not be 0.");
    }

    @Override // com.google.android.play.core.tasks.j
    public int getErrorCode() {
        return this.a;
    }
}
