package com.google.android.play.core.splitinstall;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class SplitInstallRequest {
    private final List<String> a;
    private final List<Locale> b;

    public static class Builder {
        private final List<String> a = new ArrayList();
        private final List<Locale> b = new ArrayList();

        private Builder() {
        }

        /* synthetic */ Builder(byte[] bArr) {
        }

        public Builder addLanguage(Locale locale) {
            this.b.add(locale);
            return this;
        }

        public Builder addModule(String str) {
            this.a.add(str);
            return this;
        }

        public SplitInstallRequest build() {
            return new SplitInstallRequest(this);
        }
    }

    /* synthetic */ SplitInstallRequest(Builder builder) {
        this.a = new ArrayList(builder.a);
        this.b = new ArrayList(builder.b);
    }

    public static Builder newBuilder() {
        return new Builder(null);
    }

    public List<Locale> getLanguages() {
        return this.b;
    }

    public List<String> getModuleNames() {
        return this.a;
    }

    public String toString() {
        return String.format("SplitInstallRequest{modulesNames=%s,languages=%s}", this.a, this.b);
    }
}
