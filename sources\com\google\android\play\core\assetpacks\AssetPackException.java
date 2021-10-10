package com.google.android.play.core.assetpacks;

import com.google.android.play.core.assetpacks.model.a;
import com.google.android.play.core.tasks.j;

public class AssetPackException extends j {
    private final int a;

    AssetPackException(int i) {
        super(String.format("Asset Pack Download Error(%d): %s", Integer.valueOf(i), a.a(i)));
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
