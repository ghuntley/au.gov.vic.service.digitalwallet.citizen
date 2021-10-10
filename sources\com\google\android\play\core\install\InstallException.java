package com.google.android.play.core.install;

import com.google.android.play.core.install.model.a;
import com.google.android.play.core.tasks.j;

public class InstallException extends j {
    private final int a;

    public InstallException(int i) {
        super(String.format("Install Error(%d): %s", Integer.valueOf(i), a.a(i)));
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
