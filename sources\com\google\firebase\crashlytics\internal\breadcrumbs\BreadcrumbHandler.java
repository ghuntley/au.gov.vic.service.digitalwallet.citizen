package com.google.firebase.crashlytics.internal.breadcrumbs;

public interface BreadcrumbHandler {
    void handleBreadcrumb(String str);
}
