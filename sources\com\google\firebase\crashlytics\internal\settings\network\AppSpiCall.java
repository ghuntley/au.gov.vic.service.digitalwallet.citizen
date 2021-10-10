package com.google.firebase.crashlytics.internal.settings.network;

import com.google.firebase.crashlytics.internal.settings.model.AppRequestData;

interface AppSpiCall {
    boolean invoke(AppRequestData appRequestData, boolean z);
}
