package com.google.firebase.crashlytics.internal.breadcrumbs;

public interface BreadcrumbSource {
    void registerBreadcrumbHandler(BreadcrumbHandler breadcrumbHandler);
}
