package com.google.android.datatransport.cct.internal;

import com.google.android.datatransport.cct.internal.ClientInfo;

final class AutoValue_ClientInfo extends ClientInfo {
    private final AndroidClientInfo androidClientInfo;
    private final ClientInfo.ClientType clientType;

    private AutoValue_ClientInfo(ClientInfo.ClientType clientType2, AndroidClientInfo androidClientInfo2) {
        this.clientType = clientType2;
        this.androidClientInfo = androidClientInfo2;
    }

    @Override // com.google.android.datatransport.cct.internal.ClientInfo
    public ClientInfo.ClientType getClientType() {
        return this.clientType;
    }

    @Override // com.google.android.datatransport.cct.internal.ClientInfo
    public AndroidClientInfo getAndroidClientInfo() {
        return this.androidClientInfo;
    }

    public String toString() {
        return "ClientInfo{clientType=" + this.clientType + ", androidClientInfo=" + this.androidClientInfo + "}";
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ClientInfo)) {
            return false;
        }
        ClientInfo clientInfo = (ClientInfo) obj;
        ClientInfo.ClientType clientType2 = this.clientType;
        if (clientType2 != null ? clientType2.equals(clientInfo.getClientType()) : clientInfo.getClientType() == null) {
            AndroidClientInfo androidClientInfo2 = this.androidClientInfo;
            if (androidClientInfo2 == null) {
                if (clientInfo.getAndroidClientInfo() == null) {
                    return true;
                }
            } else if (androidClientInfo2.equals(clientInfo.getAndroidClientInfo())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        ClientInfo.ClientType clientType2 = this.clientType;
        int i = 0;
        int hashCode = ((clientType2 == null ? 0 : clientType2.hashCode()) ^ 1000003) * 1000003;
        AndroidClientInfo androidClientInfo2 = this.androidClientInfo;
        if (androidClientInfo2 != null) {
            i = androidClientInfo2.hashCode();
        }
        return hashCode ^ i;
    }

    /* access modifiers changed from: package-private */
    public static final class Builder extends ClientInfo.Builder {
        private AndroidClientInfo androidClientInfo;
        private ClientInfo.ClientType clientType;

        Builder() {
        }

        @Override // com.google.android.datatransport.cct.internal.ClientInfo.Builder
        public ClientInfo.Builder setClientType(ClientInfo.ClientType clientType2) {
            this.clientType = clientType2;
            return this;
        }

        @Override // com.google.android.datatransport.cct.internal.ClientInfo.Builder
        public ClientInfo.Builder setAndroidClientInfo(AndroidClientInfo androidClientInfo2) {
            this.androidClientInfo = androidClientInfo2;
            return this;
        }

        @Override // com.google.android.datatransport.cct.internal.ClientInfo.Builder
        public ClientInfo build() {
            return new AutoValue_ClientInfo(this.clientType, this.androidClientInfo);
        }
    }
}
